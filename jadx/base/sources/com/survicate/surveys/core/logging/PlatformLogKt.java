package com.survicate.surveys.core.logging;

import android.util.Log;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: PlatformLog.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\"\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"platformLog", "", "entry", "Lcom/survicate/surveys/core/logging/LogEntry;", "sdkVersion", "", "logcatTag", "logcatBody", "EXCEPTION_PREFIX", "NO_NETWORK_HINT", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class PlatformLogKt {
    private static final String EXCEPTION_PREFIX = "Survicate SDK Exception: ";
    private static final String NO_NETWORK_HINT = " (no network connection)";

    /* JADX INFO: compiled from: PlatformLog.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SdkLogLevel.values().length];
            try {
                iArr[SdkLogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SdkLogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SdkLogLevel.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SdkLogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void platformLog(LogEntry entry, String sdkVersion) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        String strLogcatTag = logcatTag(sdkVersion);
        String strLogcatBody = logcatBody(entry);
        int i = WhenMappings.$EnumSwitchMapping$0[entry.getLevel().ordinal()];
        if (i == 1) {
            Log.d(strLogcatTag, strLogcatBody, entry.getThrowable());
            return;
        }
        if (i == 2) {
            Log.i(strLogcatTag, strLogcatBody, entry.getThrowable());
        } else if (i == 3) {
            Log.w(strLogcatTag, strLogcatBody, entry.getThrowable());
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            Log.e(strLogcatTag, strLogcatBody, entry.getThrowable());
        }
    }

    public static final String logcatTag(String sdkVersion) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        return "SurvicateSDK/" + sdkVersion;
    }

    public static final String logcatBody(LogEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        StringBuilder sb = new StringBuilder("[");
        sb.append(entry.getTag()).append("] ").append(entry.getMessage());
        if (!entry.getMetadata().isEmpty()) {
            sb.append(TokenParser.f2383SP).append(MetadataFormatKt.formatMetadata(entry.getMetadata()));
        }
        if (entry.getThrowable() instanceof UnknownHostException) {
            sb.append(NO_NETWORK_HINT);
        }
        String string = sb.toString();
        return entry.getThrowable() != null ? EXCEPTION_PREFIX + string : string;
    }
}
