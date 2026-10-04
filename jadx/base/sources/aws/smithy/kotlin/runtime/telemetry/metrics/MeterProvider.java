package aws.smithy.kotlin.runtime.telemetry.metrics;

import kotlin.Metadata;

/* JADX INFO: compiled from: MeterProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "", "getOrCreateMeter", "Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "scope", "", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MeterProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Meter getOrCreateMeter(String scope);

    /* JADX INFO: compiled from: MeterProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/metrics/MeterProvider;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final MeterProvider None = new AbstractMeterProvider() { // from class: aws.smithy.kotlin.runtime.telemetry.metrics.MeterProvider$Companion$None$1
        };

        private Companion() {
        }

        public final MeterProvider getNone() {
            return None;
        }
    }
}
