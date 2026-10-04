package aws.smithy.kotlin.runtime.telemetry.logging;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractLogger.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J$\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J$\u0010\r\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J$\u0010\u000e\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J$\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J,\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0017"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/AbstractLogger;", "Laws/smithy/kotlin/runtime/telemetry/logging/Logger;", "<init>", "()V", "trace", "", "t", "", NotificationCompat.CATEGORY_MESSAGE, "Lkotlin/Function0;", "", "Laws/smithy/kotlin/runtime/telemetry/logging/MessageSupplier;", "debug", "info", "warn", "error", "log", FirebaseAnalytics.Param.LEVEL, "Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "isEnabledFor", "", "atLevel", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractLogger implements Logger {
    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public boolean isEnabledFor(LogLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        return false;
    }

    public void log(LogLevel level, Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void trace(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Trace)) {
            log(LogLevel.Trace, t, msg);
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void debug(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Debug)) {
            log(LogLevel.Debug, t, msg);
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void info(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Info)) {
            log(LogLevel.Info, t, msg);
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void warn(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Warning)) {
            log(LogLevel.Warning, t, msg);
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public void error(Throwable t, Function0<String> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (isEnabledFor(LogLevel.Error)) {
            log(LogLevel.Error, t, msg);
        }
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public LogRecordBuilder atLevel(LogLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        return LogRecordBuilder.INSTANCE.getNone();
    }
}
