package aws.smithy.kotlin.runtime.telemetry;

import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.logging.DefaultLoggerProviderJVMKt;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider;
import aws.smithy.kotlin.runtime.telemetry.metrics.MeterProvider;
import aws.smithy.kotlin.runtime.telemetry.trace.TracerProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: DefaultTelemetryProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/DefaultTelemetryProvider;", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "<init>", "()V", "Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "loggerProvider", "Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "getLoggerProvider", "()Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "Laws/smithy/kotlin/runtime/telemetry/trace/TracerProvider;", "tracerProvider", "Laws/smithy/kotlin/runtime/telemetry/trace/TracerProvider;", "getTracerProvider", "()Laws/smithy/kotlin/runtime/telemetry/trace/TracerProvider;", "Laws/smithy/kotlin/runtime/telemetry/context/ContextManager;", "contextManager", "Laws/smithy/kotlin/runtime/telemetry/context/ContextManager;", "getContextManager", "()Laws/smithy/kotlin/runtime/telemetry/context/ContextManager;", "Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "meterProvider", "Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "getMeterProvider", "()Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "telemetry-defaults"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultTelemetryProvider implements TelemetryProvider {
    public static final DefaultTelemetryProvider INSTANCE = new DefaultTelemetryProvider();
    private static final LoggerProvider loggerProvider = DefaultLoggerProviderJVMKt.getDefaultLoggerProvider();
    private static final TracerProvider tracerProvider = TracerProvider.INSTANCE.getNone();
    private static final ContextManager contextManager = ContextManager.INSTANCE.getNone();
    private static final MeterProvider meterProvider = MeterProvider.INSTANCE.getNone();

    private DefaultTelemetryProvider() {
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryProvider
    public LoggerProvider getLoggerProvider() {
        return loggerProvider;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryProvider
    public TracerProvider getTracerProvider() {
        return tracerProvider;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryProvider
    public ContextManager getContextManager() {
        return contextManager;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryProvider
    public MeterProvider getMeterProvider() {
        return meterProvider;
    }
}
