package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.collections.AttributesBuilder;
import aws.smithy.kotlin.runtime.collections.MutableAttributes;
import aws.smithy.kotlin.runtime.http.engine.internal.HttpClientMetrics;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: compiled from: MetricsInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/engine/okhttp/MetricsInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "http-client-engine-okhttp"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MetricsInterceptor implements Interceptor {
    public static final MetricsInterceptor INSTANCE = new MetricsInterceptor();

    private MetricsInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        HttpClientMetrics metrics;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        SdkRequestTag sdkRequestTag = (SdkRequestTag) request.tag(SdkRequestTag.class);
        if (sdkRequestTag == null || (metrics = sdkRequestTag.getMetrics()) == null) {
            return chain.proceed(request);
        }
        AttributesBuilder attributesBuilder = new AttributesBuilder();
        attributesBuilder.m498to("server.address", request.url().host() + AbstractJsonLexerKt.COLON + request.url().port());
        MutableAttributes attributes = attributesBuilder.getAttributes();
        if (request.body() != null) {
            Request.Builder builderNewBuilder = request.newBuilder();
            String strMethod = request.method();
            RequestBody requestBodyBody = request.body();
            request = builderNewBuilder.method(strMethod, requestBodyBody != null ? MetricsInterceptorKt.instrument(requestBodyBody, metrics.getBytesSent(), attributes) : null).build();
        }
        Response responseProceed = chain.proceed(request);
        return responseProceed.body().getContentLength() == 0 ? responseProceed : responseProceed.newBuilder().body(MetricsInterceptorKt.instrument(responseProceed.body(), metrics.getBytesReceived(), attributes)).build();
    }
}
