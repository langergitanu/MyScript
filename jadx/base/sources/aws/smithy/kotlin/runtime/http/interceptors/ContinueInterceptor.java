package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: ContinueInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\u00020\u00032\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0096@¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/interceptors/ContinueInterceptor;", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "", "thresholdLengthBytes", "<init>", "(J)V", "Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;", WebViewMessageType.CONTEXT, "modifyBeforeSigning", "(Laws/smithy/kotlin/runtime/client/ProtocolRequestInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "J", "getThresholdLengthBytes", "()J", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ContinueInterceptor implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    private final long thresholdLengthBytes;

    public ContinueInterceptor(long j) {
        this.thresholdLengthBytes = j;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    public /* bridge */ Object mo12026modifyBeforeAttemptCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12026modifyBeforeAttemptCompletiongIAlus(responseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s */
    public /* bridge */ Object mo12027modifyBeforeCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        return super.mo12027modifyBeforeCompletiongIAlus(responseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext, Continuation<? super HttpResponse> continuation) {
        return super.modifyBeforeDeserialization(protocolResponseInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeRetryLoop(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeRetryLoop(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeSerialization(RequestInterceptorContext<Object> requestInterceptorContext, Continuation<? super Object> continuation) {
        return super.modifyBeforeSerialization(requestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeTransmit(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeTransmit(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterAttempt(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterAttempt(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterDeserialization(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterDeserialization(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterExecution(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext) {
        super.readAfterExecution(responseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterSerialization(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readAfterSerialization(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readAfterSigning(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readAfterTransmit(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext) {
        super.readAfterTransmit(protocolResponseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeAttempt(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeAttempt(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext) {
        super.readBeforeDeserialization(protocolResponseInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeExecution(RequestInterceptorContext<Object> requestInterceptorContext) {
        super.readBeforeExecution(requestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeSerialization(RequestInterceptorContext<Object> requestInterceptorContext) {
        super.readBeforeSerialization(requestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeSigning(protocolRequestInterceptorContext);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ void readBeforeTransmit(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext) {
        super.readBeforeTransmit(protocolRequestInterceptorContext);
    }

    public final long getThresholdLengthBytes() {
        return this.thresholdLengthBytes;
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        HttpRequest protocolRequest = protocolRequestInterceptorContext.getProtocolRequest();
        Long contentLength = protocolRequest.getBody().getContentLength();
        if ((contentLength != null ? contentLength.longValue() : Long.MAX_VALUE) < this.thresholdLengthBytes) {
            return protocolRequest;
        }
        HttpRequestBuilder builder = HttpRequestKt.toBuilder(protocolRequest);
        HttpRequestBuilderKt.header(builder, "Expect", HTTP.EXPECT_CONTINUE);
        return builder.build();
    }
}
