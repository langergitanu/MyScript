package androidx.media3.common.util;

import android.text.TextUtils;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: loaded from: classes3.dex */
public final class Log {
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_ERROR = 3;
    public static final int LOG_LEVEL_INFO = 1;
    public static final int LOG_LEVEL_OFF = Integer.MAX_VALUE;
    public static final int LOG_LEVEL_WARNING = 2;
    private static int logLevel = 0;
    private static boolean logStackTraces = true;
    private static final Object lock = new Object();
    private static Logger logger = Logger.DEFAULT;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() { // from class: androidx.media3.common.util.Log.Logger.1
            @Override // androidx.media3.common.util.Log.Logger
            /* JADX INFO: renamed from: d */
            public void mo134d(String str, String str2, Throwable th) {
                android.util.Log.d(str, Log.appendThrowableString(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            /* JADX INFO: renamed from: i */
            public void mo136i(String str, String str2, Throwable th) {
                android.util.Log.i(str, Log.appendThrowableString(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            /* JADX INFO: renamed from: w */
            public void mo137w(String str, String str2, Throwable th) {
                android.util.Log.w(str, Log.appendThrowableString(str2, th));
            }

            @Override // androidx.media3.common.util.Log.Logger
            /* JADX INFO: renamed from: e */
            public void mo135e(String str, String str2, Throwable th) {
                android.util.Log.e(str, Log.appendThrowableString(str2, th));
            }
        };

        /* JADX INFO: renamed from: d */
        void mo134d(String str, String str2, Throwable th);

        /* JADX INFO: renamed from: e */
        void mo135e(String str, String str2, Throwable th);

        /* JADX INFO: renamed from: i */
        void mo136i(String str, String str2, Throwable th);

        /* JADX INFO: renamed from: w */
        void mo137w(String str, String str2, Throwable th);
    }

    private Log() {
    }

    @Pure
    public static int getLogLevel() {
        int i;
        synchronized (lock) {
            i = logLevel;
        }
        return i;
    }

    public static void setLogLevel(int i) {
        synchronized (lock) {
            logLevel = i;
        }
    }

    public static void setLogStackTraces(boolean z) {
        synchronized (lock) {
            logStackTraces = z;
        }
    }

    public static void setLogger(Logger logger2) {
        synchronized (lock) {
            logger = logger2;
        }
    }

    @Pure
    /* JADX INFO: renamed from: d */
    public static void m126d(String str, String str2) {
        synchronized (lock) {
            if (logLevel == 0) {
                logger.mo134d(str, str2, null);
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: d */
    public static void m127d(String str, String str2, Throwable th) {
        synchronized (lock) {
            if (logLevel == 0) {
                logger.mo134d(str, str2, th);
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: i */
    public static void m130i(String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 1) {
                logger.mo136i(str, str2, null);
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: i */
    public static void m131i(String str, String str2, Throwable th) {
        synchronized (lock) {
            if (logLevel <= 1) {
                logger.mo136i(str, str2, th);
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: w */
    public static void m132w(String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 2) {
                logger.mo137w(str, str2, null);
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: w */
    public static void m133w(String str, String str2, Throwable th) {
        synchronized (lock) {
            if (logLevel <= 2) {
                logger.mo137w(str, str2, th);
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: e */
    public static void m128e(String str, String str2) {
        synchronized (lock) {
            if (logLevel <= 3) {
                logger.mo135e(str, str2, null);
            }
        }
    }

    @Pure
    /* JADX INFO: renamed from: e */
    public static void m129e(String str, String str2, Throwable th) {
        synchronized (lock) {
            if (logLevel <= 3) {
                logger.mo135e(str, str2, th);
            }
        }
    }

    @Pure
    public static String getThrowableString(Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (lock) {
            if (isCausedByUnknownHostException(th)) {
                return "UnknownHostException (no network)";
            }
            if (!logStackTraces) {
                return th.getMessage();
            }
            return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
        }
    }

    @Pure
    public static String appendThrowableString(String str, Throwable th) {
        String throwableString = getThrowableString(th);
        return !TextUtils.isEmpty(throwableString) ? str + "\n  " + throwableString.replace("\n", "\n  ") + '\n' : str;
    }

    @Pure
    private static boolean isCausedByUnknownHostException(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }
}
