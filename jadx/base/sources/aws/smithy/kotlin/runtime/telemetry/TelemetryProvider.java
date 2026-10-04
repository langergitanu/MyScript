package aws.smithy.kotlin.runtime.telemetry;

import aws.smithy.kotlin.runtime.ExperimentalApi;
import aws.smithy.kotlin.runtime.telemetry.context.ContextManager;
import aws.smithy.kotlin.runtime.telemetry.logging.LoggerProvider;
import aws.smithy.kotlin.runtime.telemetry.metrics.MeterProvider;
import aws.smithy.kotlin.runtime.telemetry.trace.TracerProvider;
import kotlin.Metadata;

/* JADX INFO: compiled from: TelemetryProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "", "tracerProvider", "Laws/smithy/kotlin/runtime/telemetry/trace/TracerProvider;", "getTracerProvider$annotations", "()V", "getTracerProvider", "()Laws/smithy/kotlin/runtime/telemetry/trace/TracerProvider;", "meterProvider", "Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "getMeterProvider$annotations", "getMeterProvider", "()Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "loggerProvider", "Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "getLoggerProvider$annotations", "getLoggerProvider", "()Laws/smithy/kotlin/runtime/telemetry/logging/LoggerProvider;", "contextManager", "Laws/smithy/kotlin/runtime/telemetry/context/ContextManager;", "getContextManager$annotations", "getContextManager", "()Laws/smithy/kotlin/runtime/telemetry/context/ContextManager;", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface TelemetryProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: TelemetryProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
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
    }

    ContextManager getContextManager();

    LoggerProvider getLoggerProvider();

    MeterProvider getMeterProvider();

    TracerProvider getTracerProvider();

    /* JADX INFO: compiled from: TelemetryProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/TelemetryProvider;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final TelemetryProvider None = new AbstractTelemetryProvider() { // from class: aws.smithy.kotlin.runtime.telemetry.TelemetryProvider$Companion$None$1
        };

        private Companion() {
        }

        public final TelemetryProvider getNone() {
            return None;
        }
    }
}
