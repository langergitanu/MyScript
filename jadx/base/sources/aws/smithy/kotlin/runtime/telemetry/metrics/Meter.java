package aws.smithy.kotlin.runtime.telemetry.metrics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Meter.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&JJ\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052 \u0010\n\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u00102\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J2\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\r0\u0014j\u0002`\u00152\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J2\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u00170\u0014j\u0002`\u00182\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&JJ\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052 \u0010\n\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u001a2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&JJ\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052 \u0010\n\u001a\u001c\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00170\fj\u0002`\u001c\u0012\u0004\u0012\u00020\u000f0\u000bj\u0002`\u001d2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u001fÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "", "createUpDownCounter", "Laws/smithy/kotlin/runtime/telemetry/metrics/UpDownCounter;", "name", "", "units", "description", "createAsyncUpDownCounter", "Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurementHandle;", "callback", "Lkotlin/Function1;", "Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurement;", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongAsyncMeasurement;", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongUpDownCounterCallback;", "createMonotonicCounter", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "createLongHistogram", "Laws/smithy/kotlin/runtime/telemetry/metrics/Histogram;", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongHistogram;", "createDoubleHistogram", "", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleHistogram;", "createLongGauge", "Laws/smithy/kotlin/runtime/telemetry/metrics/LongGaugeCallback;", "createDoubleGauge", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleAsyncMeasurement;", "Laws/smithy/kotlin/runtime/telemetry/metrics/DoubleGaugeCallback;", "Companion", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface Meter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    AsyncMeasurementHandle createAsyncUpDownCounter(String name, Function1<? super AsyncMeasurement<Long>, Unit> callback, String units, String description);

    AsyncMeasurementHandle createDoubleGauge(String name, Function1<? super AsyncMeasurement<Double>, Unit> callback, String units, String description);

    Histogram<Double> createDoubleHistogram(String name, String units, String description);

    AsyncMeasurementHandle createLongGauge(String name, Function1<? super AsyncMeasurement<Long>, Unit> callback, String units, String description);

    Histogram<Long> createLongHistogram(String name, String units, String description);

    MonotonicCounter createMonotonicCounter(String name, String units, String description);

    UpDownCounter createUpDownCounter(String name, String units, String description);

    /* JADX INFO: compiled from: Meter.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/telemetry/metrics/Meter$Companion;", "", "<init>", "()V", "None", "Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "getNone", "()Laws/smithy/kotlin/runtime/telemetry/metrics/Meter;", "telemetry-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Meter None = new AbstractMeter() { // from class: aws.smithy.kotlin.runtime.telemetry.metrics.Meter$Companion$None$1
        };

        private Companion() {
        }

        public final Meter getNone() {
            return None;
        }
    }

    /* JADX INFO: compiled from: Meter.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ UpDownCounter createUpDownCounter$default(Meter meter, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createUpDownCounter");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return meter.createUpDownCounter(str, str2, str3);
    }

    static /* synthetic */ AsyncMeasurementHandle createAsyncUpDownCounter$default(Meter meter, String str, Function1 function1, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createAsyncUpDownCounter");
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return meter.createAsyncUpDownCounter(str, function1, str2, str3);
    }

    static /* synthetic */ MonotonicCounter createMonotonicCounter$default(Meter meter, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createMonotonicCounter");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return meter.createMonotonicCounter(str, str2, str3);
    }

    static /* synthetic */ Histogram createLongHistogram$default(Meter meter, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLongHistogram");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return meter.createLongHistogram(str, str2, str3);
    }

    static /* synthetic */ Histogram createDoubleHistogram$default(Meter meter, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDoubleHistogram");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return meter.createDoubleHistogram(str, str2, str3);
    }

    static /* synthetic */ AsyncMeasurementHandle createLongGauge$default(Meter meter, String str, Function1 function1, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLongGauge");
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return meter.createLongGauge(str, function1, str2, str3);
    }

    static /* synthetic */ AsyncMeasurementHandle createDoubleGauge$default(Meter meter, String str, Function1 function1, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDoubleGauge");
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return meter.createDoubleGauge(str, function1, str2, str3);
    }
}
