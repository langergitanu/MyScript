package aws.smithy.kotlin.runtime.http.engine.internal;

import aws.smithy.kotlin.runtime.telemetry.metrics.AsyncMeasurement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpClientMetrics.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class HttpClientMetrics$connectionUsageHandle$1 extends FunctionReferenceImpl implements Function1<AsyncMeasurement<Long>, Unit> {
    HttpClientMetrics$connectionUsageHandle$1(Object obj) {
        super(1, obj, HttpClientMetrics.class, "recordConnectionState", "recordConnectionState(Laws/smithy/kotlin/runtime/telemetry/metrics/AsyncMeasurement;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AsyncMeasurement<Long> asyncMeasurement) {
        invoke2(asyncMeasurement);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AsyncMeasurement<Long> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((HttpClientMetrics) this.receiver).recordConnectionState(p0);
    }
}
