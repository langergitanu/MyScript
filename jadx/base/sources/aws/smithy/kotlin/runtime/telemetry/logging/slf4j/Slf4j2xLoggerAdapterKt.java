package aws.smithy.kotlin.runtime.telemetry.logging.slf4j;

import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.slf4j.event.Level;

/* JADX INFO: compiled from: Slf4j2xLoggerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"slf4jLevel", "Lorg/slf4j/event/Level;", "Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "getSlf4jLevel", "(Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;)Lorg/slf4j/event/Level;", "logging-slf4j2"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Slf4j2xLoggerAdapterKt {

    /* JADX INFO: compiled from: Slf4j2xLoggerAdapter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.Error.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.Warning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.Debug.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogLevel.Trace.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Level getSlf4jLevel(LogLevel logLevel) {
        int i = WhenMappings.$EnumSwitchMapping$0[logLevel.ordinal()];
        if (i == 1) {
            return Level.ERROR;
        }
        if (i == 2) {
            return Level.WARN;
        }
        if (i == 3) {
            return Level.INFO;
        }
        if (i == 4) {
            return Level.DEBUG;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return Level.TRACE;
    }
}
