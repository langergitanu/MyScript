package aws.smithy.kotlin.runtime.telemetry;

import aws.smithy.kotlin.runtime.ExperimentalApi;
import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider;
import aws.smithy.kotlin.runtime.telemetry.metrics.MeterProvider;
import aws.smithy.kotlin.runtime.telemetry.trace.TracerProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: AbstractTelemetryProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\n8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u000f8\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\u00148\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/AbstractTelemetryProvider;", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "<init>", "()V", "meterProvider", "Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "getMeterProvider$annotations", "getMeterProvider", "()Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "tracerProvider", "Laws/smithy/kotlin/runtime/telemetry/trace/TracerProvider;", "getTracerProvider$annotations", "getTracerProvider", "()Laws/smithy/kotlin/runtime/telemetry/trace/TracerProvider;", "loggerProvider", "Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "getLoggerProvider$annotations", "getLoggerProvider", "()Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "contextManager", "Laws/smithy/kotlin/runtime/telemetry/context/ContextManager;", "getContextManager$annotations", "getContextManager", "()Laws/smithy/kotlin/runtime/telemetry/context/ContextManager;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractTelemetryProvider implements TelemetryProvider {
    private final MeterProvider meterProvider = MeterProvider.INSTANCE.getNone();
    private final TracerProvider tracerProvider = TracerProvider.INSTANCE.getNone();
    private final LoggerProvider loggerProvider = LoggerProvider.INSTANCE.getNone();
    private final ContextManager contextManager = ContextManager.INSTANCE.getNone();

    @ExperimentalApi
    public static /* synthetic */ void getContextManager$annotations() {
    }

    @ExperimentalApi
    public static /* synthetic */ void getLoggerProvider$annotations() {
    }

    @ExperimentalApi
    public static /* synthetic */ void getMeterProvider$annotations() {
    }

    @ExperimentalApi
    public static /* synthetic */ void getTracerProvider$annotations() {
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryProvider
    public MeterProvider getMeterProvider() {
        return this.meterProvider;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryProvider
    public TracerProvider getTracerProvider() {
        return this.tracerProvider;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryProvider
    public LoggerProvider getLoggerProvider() {
        return this.loggerProvider;
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.TelemetryProvider
    public ContextManager getContextManager() {
        return this.contextManager;
    }
}
