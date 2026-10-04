package aws.smithy.kotlin.runtime.telemetry.logging.slf4j;

import aws.smithy.kotlin.runtime.telemetry.logging.LogLevel;
import aws.smithy.kotlin.runtime.telemetry.logging.LogRecordBuilder;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: Slf4j1xLoggerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, m1599d2 = {"noOpLogRecordBuilder", "Laws/smithy/kotlin/runtime/telemetry/logging/LogRecordBuilder;", "logging-slf4j2"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Slf4j1xLoggerAdapterKt {
    private static final LogRecordBuilder noOpLogRecordBuilder = LoggerProvider.INSTANCE.getNone().getOrCreateLogger("NoOpLogger").atLevel(LogLevel.Error);
}
