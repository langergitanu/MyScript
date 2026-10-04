package aws.smithy.kotlin.runtime.telemetry.logging;

import aws.smithy.kotlin.runtime.telemetry.logging.slf4j.Slf4jLoggerProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultLoggerProviderJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "DefaultLoggerProvider", "Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "getDefaultLoggerProvider", "()Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "telemetry-defaults"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultLoggerProviderJVMKt {
    private static final LoggerProvider DefaultLoggerProvider = Slf4jLoggerProvider.INSTANCE;

    public static final LoggerProvider getDefaultLoggerProvider() {
        return DefaultLoggerProvider;
    }
}
