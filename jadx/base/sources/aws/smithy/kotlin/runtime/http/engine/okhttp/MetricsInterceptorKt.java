package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.telemetry.metrics.MonotonicCounter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: MetricsInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0007"}, m1599d2 = {"instrument", "Lokhttp3/RequestBody;", "counter", "Laws/smithy/kotlin/runtime/telemetry/metrics/MonotonicCounter;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "Lokhttp3/ResponseBody;", "http-client-engine-okhttp"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MetricsInterceptorKt {
    public static final RequestBody instrument(RequestBody requestBody, MonotonicCounter counter, Attributes attributes) {
        Intrinsics.checkNotNullParameter(requestBody, "<this>");
        Intrinsics.checkNotNullParameter(counter, "counter");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new InstrumentedRequestBody(requestBody, counter, attributes);
    }

    public static final ResponseBody instrument(ResponseBody responseBody, MonotonicCounter counter, Attributes attributes) {
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        Intrinsics.checkNotNullParameter(counter, "counter");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        return new InstrumentedResponseBody(responseBody, counter, attributes);
    }
}
