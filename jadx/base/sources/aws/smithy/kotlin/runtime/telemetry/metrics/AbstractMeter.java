package aws.smithy.kotlin.runtime.telemetry.metrics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractMeter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016JF\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072 \u0010\f\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\rj\u0002`\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u000f0\u0016j\u0002`\u00172\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016J.\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\u00190\u0016j\u0002`\u001a2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016JF\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072 \u0010\f\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012\u0004\u0012\u00020\u00110\rj\u0002`\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016JF\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072 \u0010\f\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00190\u000ej\u0002`\u001e\u0012\u0004\u0012\u00020\u00110\rj\u0002`\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006 "}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/AbstractMeter;", "Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "<init>", "()V", "createUpDownCounter", "Laws/smithy/kotlin/runtime/telemetry/metrics/UpDownCounter;", "name", "", "units", "description", "createAsyncUpDownCounter", "Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurementHandle;", "callback", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurement;", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongAsyncMeasurement;", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongUpDownCounterCallback;", "createMonotonicCounter", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "createLongHistogram", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongHistogram;", "createDoubleHistogram", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleHistogram;", "createLongGauge", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongGaugeCallback;", "createDoubleGauge", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleAsyncMeasurement;", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleGaugeCallback;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class AbstractMeter implements Meter {
    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.Meter
    public UpDownCounter createUpDownCounter(String name, String units, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        return UpDownCounter.INSTANCE.getNone();
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.Meter
    public AsyncMeasurementHandle createAsyncUpDownCounter(String name, Function1<? super AsyncMeasurement<Long>, Unit> callback, String units, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return AsyncMeasurementHandle.INSTANCE.getNone();
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.Meter
    public MonotonicCounter createMonotonicCounter(String name, String units, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        return MonotonicCounter.INSTANCE.getNone();
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.Meter
    public Histogram<Long> createLongHistogram(String name, String units, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        return Histogram.INSTANCE.getLongNone();
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.Meter
    public Histogram<Double> createDoubleHistogram(String name, String units, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        return Histogram.INSTANCE.getDoubleNone();
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.Meter
    public AsyncMeasurementHandle createLongGauge(String name, Function1<? super AsyncMeasurement<Long>, Unit> callback, String units, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return AsyncMeasurementHandle.INSTANCE.getNone();
    }

    @Override // aws.smithy.kotlin.runtime.telemetry.metrics.Meter
    public AsyncMeasurementHandle createDoubleGauge(String name, Function1<? super AsyncMeasurement<Double>, Unit> callback, String units, String description) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return AsyncMeasurementHandle.INSTANCE.getNone();
    }
}
