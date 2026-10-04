package aws.sdk.kotlin.services.p010s3.internal;

import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.http.HeadersBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.http.response.HttpResponseBuilder;
import aws.smithy.kotlin.runtime.http.response.HttpResponseKt;
import aws.smithy.kotlin.runtime.telemetry.logging.CoroutineContextLogExtKt;
import aws.smithy.kotlin.runtime.telemetry.logging.Logger;
import aws.smithy.kotlin.runtime.time.Instant;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ExpiresFieldInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\u00042\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\nH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/internal/ExpiresFieldInterceptor;", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "<init>", "()V", "modifyBeforeDeserialization", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;", "(Laws/smithy/kotlin/runtime/client/ProtocolResponseInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExpiresFieldInterceptor implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    public static final ExpiresFieldInterceptor INSTANCE = new ExpiresFieldInterceptor();

    private ExpiresFieldInterceptor() {
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
    public /* bridge */ Object modifyBeforeRetryLoop(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeRetryLoop(protocolRequestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeSerialization(RequestInterceptorContext<Object> requestInterceptorContext, Continuation<? super Object> continuation) {
        return super.modifyBeforeSerialization(requestInterceptorContext, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public /* bridge */ Object modifyBeforeSigning(ProtocolRequestInterceptorContext<Object, HttpRequest> protocolRequestInterceptorContext, Continuation<? super HttpRequest> continuation) {
        return super.modifyBeforeSigning(protocolRequestInterceptorContext, continuation);
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

    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    public Object modifyBeforeDeserialization(ProtocolResponseInterceptorContext<Object, HttpRequest, HttpResponse> protocolResponseInterceptorContext, Continuation<? super HttpResponse> continuation) {
        final HttpResponseBuilder builder = HttpResponseKt.toBuilder(protocolResponseInterceptorContext.getProtocolResponse());
        if (builder.getHeaders().contains("Expires")) {
            HeadersBuilder headers = builder.getHeaders();
            String str = builder.getHeaders().get("Expires");
            Intrinsics.checkNotNull(str);
            headers.set("ExpiresString", str);
            try {
                Instant.Companion companion = Instant.INSTANCE;
                String str2 = builder.getHeaders().get("Expires");
                Intrinsics.checkNotNull(str2);
                companion.fromRfc5322(str2);
            } catch (Exception unused) {
                CoroutineContext coroutineContext = continuation.get$context();
                String qualifiedName = Reflection.getOrCreateKotlinClass(ExpiresFieldInterceptor.class).getQualifiedName();
                if (qualifiedName != null) {
                    Logger.warn$default(CoroutineContextLogExtKt.logger(coroutineContext, qualifiedName), null, new Function0() { // from class: aws.sdk.kotlin.services.s3.internal.ExpiresFieldInterceptor$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExpiresFieldInterceptor.modifyBeforeDeserialization$lambda$0(builder);
                        }
                    }, 1, null);
                    builder.getHeaders().remove("Expires");
                } else {
                    throw new IllegalArgumentException("logger<T> cannot be used on an anonymous object".toString());
                }
            }
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String modifyBeforeDeserialization$lambda$0(HttpResponseBuilder httpResponseBuilder) {
        return "Failed to parse `expires`=\"" + httpResponseBuilder.getHeaders().get("Expires") + "\" as a timestamp, setting it to `null`. The unparsed value is available in `expiresString`.";
    }
}
