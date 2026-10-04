package aws.smithy.kotlin.runtime.telemetry.logging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J&\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH&J&\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH&J&\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH&J&\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH&J&\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0015À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "", "trace", "", "t", "", NotificationCompat.CATEGORY_MESSAGE, "Lkotlin/Function0;", "", "Laws/smithy/kotlin/runtime/telemetry/logging/MessageSupplier;", "debug", "info", "warn", "error", "isEnabledFor", "", FirebaseAnalytics.Param.LEVEL, "Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "atLevel", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Logger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    LogRecordBuilder atLevel(LogLevel level);

    void debug(Throwable t, Function0<String> msg);

    void error(Throwable t, Function0<String> msg);

    void info(Throwable t, Function0<String> msg);

    boolean isEnabledFor(LogLevel level);

    void trace(Throwable t, Function0<String> msg);

    void warn(Throwable t, Function0<String> msg);

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/Logger$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Logger None = new AbstractLogger() { // from class: aws.smithy.kotlin.runtime.telemetry.logging.Logger$Companion$None$1
        };

        private Companion() {
        }

        public final Logger getNone() {
            return None;
        }
    }

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void trace$default(Logger logger, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trace");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        logger.trace(th, function0);
    }

    static /* synthetic */ void debug$default(Logger logger, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: debug");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        logger.debug(th, function0);
    }

    static /* synthetic */ void info$default(Logger logger, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: info");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        logger.info(th, function0);
    }

    static /* synthetic */ void warn$default(Logger logger, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: warn");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        logger.warn(th, function0);
    }

    static /* synthetic */ void error$default(Logger logger, Throwable th, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
        }
        if ((i & 1) != 0) {
            th = null;
        }
        logger.error(th, function0);
    }
}
