package aws.smithy.kotlin.runtime.telemetry.logging.slf4j;

import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* JADX INFO: compiled from: Slf4j1xLoggerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/slf4j/Slf4j1xLoggerAdapter;", "Laws/smithy/kotlin/runtime/telemetry/logging/slf4j/AbstractSlf4jLoggerAdapter;", "logger", "Lorg/slf4j/Logger;", "<init>", "(Lorg/slf4j/Logger;)V", "atLevel", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", FirebaseAnalytics.Param.LEVEL, "Laws/smithy/kotlin/runtime/telemetry/logging/LogLevel;", "logging-slf4j2"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Slf4j1xLoggerAdapter extends AbstractSlf4jLoggerAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Slf4j1xLoggerAdapter(Logger logger) {
        super(logger);
        Intrinsics.checkNotNullParameter(logger, "logger");
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.logging.Logger
    public LogRecordBuilder atLevel(LogLevel level) {
        Intrinsics.checkNotNullParameter(level, "level");
        if (!isEnabledFor(level)) {
            return Slf4j1xLoggerAdapterKt.noOpLogRecordBuilder;
        }
        return new Slf4j1xLogRecordBuilderAdapter(this, level);
    }
}
