package aws.sdk.kotlin.runtime.http.interceptors;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.awsprotocol.ResponseUtilsKt;
import aws.smithy.kotlin.runtime.client.Interceptor;
import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ProtocolResponseInterceptorContext;
import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.client.ResponseInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.telemetry.trace.CoroutineContextTraceExtKt;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpanExtKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: AwsSpanInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J8\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bH\u0096@¢\u0006\u0004\b\f\u0010\rJ:\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bH\u0096@¢\u0006\u0004\b\u000f\u0010\rJ\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/runtime/http/interceptors/AwsSpanInterceptor;", "Laws/smithy/kotlin/runtime/client/Interceptor;", "", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "Laws/smithy/kotlin/runtime/http/response/HttpResponse;", "Laws/smithy/kotlin/runtime/http/interceptors/HttpInterceptor;", "<init>", "()V", "modifyBeforeAttemptCompletion", "Lkotlin/Result;", WebViewMessageType.CONTEXT, "Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;", "modifyBeforeAttemptCompletion-gIAlu-s", "(Laws/smithy/kotlin/runtime/client/ResponseInterceptorContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modifyBeforeCompletion", "modifyBeforeCompletion-gIAlu-s", "setAwsRequestIdAttrs", "", TtmlNode.TAG_SPAN, "Laws/smithy/kotlin/runtime/telemetry/trace/TraceSpan;", "httpResp", "aws-http"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
@InternalSdkApi
public final class AwsSpanInterceptor implements Interceptor<Object, Object, HttpRequest, HttpResponse> {
    public static final AwsSpanInterceptor INSTANCE = new AwsSpanInterceptor();

    private AwsSpanInterceptor() {
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeAttemptCompletion-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo12026modifyBeforeAttemptCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        AwsSpanInterceptor$modifyBeforeAttemptCompletion$1 awsSpanInterceptor$modifyBeforeAttemptCompletion$1;
        if (continuation instanceof AwsSpanInterceptor$modifyBeforeAttemptCompletion$1) {
            awsSpanInterceptor$modifyBeforeAttemptCompletion$1 = (AwsSpanInterceptor$modifyBeforeAttemptCompletion$1) continuation;
            if ((awsSpanInterceptor$modifyBeforeAttemptCompletion$1.label & Integer.MIN_VALUE) != 0) {
                awsSpanInterceptor$modifyBeforeAttemptCompletion$1.label -= Integer.MIN_VALUE;
            } else {
                awsSpanInterceptor$modifyBeforeAttemptCompletion$1 = new AwsSpanInterceptor$modifyBeforeAttemptCompletion$1(this, continuation);
            }
        }
        Object obj = awsSpanInterceptor$modifyBeforeAttemptCompletion$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = awsSpanInterceptor$modifyBeforeAttemptCompletion$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        HttpResponse protocolResponse = responseInterceptorContext.getProtocolResponse();
        TraceSpan traceSpan = CoroutineContextTraceExtKt.getTraceSpan(awsSpanInterceptor$modifyBeforeAttemptCompletion$1.get$context());
        setAwsRequestIdAttrs(traceSpan, protocolResponse);
        awsSpanInterceptor$modifyBeforeAttemptCompletion$1.L$0 = SpillingKt.nullOutSpilledVariable(responseInterceptorContext);
        awsSpanInterceptor$modifyBeforeAttemptCompletion$1.L$1 = SpillingKt.nullOutSpilledVariable(protocolResponse);
        awsSpanInterceptor$modifyBeforeAttemptCompletion$1.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
        awsSpanInterceptor$modifyBeforeAttemptCompletion$1.label = 1;
        Object objMo12026modifyBeforeAttemptCompletiongIAlus = super.mo12026modifyBeforeAttemptCompletiongIAlus(responseInterceptorContext, awsSpanInterceptor$modifyBeforeAttemptCompletion$1);
        return objMo12026modifyBeforeAttemptCompletiongIAlus == coroutine_suspended ? coroutine_suspended : objMo12026modifyBeforeAttemptCompletiongIAlus;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.client.Interceptor
    /* JADX INFO: renamed from: modifyBeforeCompletion-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo12027modifyBeforeCompletiongIAlus(ResponseInterceptorContext<Object, Object, HttpRequest, HttpResponse> responseInterceptorContext, Continuation<? super Result<? extends Object>> continuation) {
        AwsSpanInterceptor$modifyBeforeCompletion$1 awsSpanInterceptor$modifyBeforeCompletion$1;
        if (continuation instanceof AwsSpanInterceptor$modifyBeforeCompletion$1) {
            awsSpanInterceptor$modifyBeforeCompletion$1 = (AwsSpanInterceptor$modifyBeforeCompletion$1) continuation;
            if ((awsSpanInterceptor$modifyBeforeCompletion$1.label & Integer.MIN_VALUE) != 0) {
                awsSpanInterceptor$modifyBeforeCompletion$1.label -= Integer.MIN_VALUE;
            } else {
                awsSpanInterceptor$modifyBeforeCompletion$1 = new AwsSpanInterceptor$modifyBeforeCompletion$1(this, continuation);
            }
        }
        Object obj = awsSpanInterceptor$modifyBeforeCompletion$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = awsSpanInterceptor$modifyBeforeCompletion$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        HttpResponse protocolResponse = responseInterceptorContext.getProtocolResponse();
        TraceSpan traceSpan = CoroutineContextTraceExtKt.getTraceSpan(awsSpanInterceptor$modifyBeforeCompletion$1.get$context());
        setAwsRequestIdAttrs(traceSpan, protocolResponse);
        awsSpanInterceptor$modifyBeforeCompletion$1.L$0 = SpillingKt.nullOutSpilledVariable(responseInterceptorContext);
        awsSpanInterceptor$modifyBeforeCompletion$1.L$1 = SpillingKt.nullOutSpilledVariable(protocolResponse);
        awsSpanInterceptor$modifyBeforeCompletion$1.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
        awsSpanInterceptor$modifyBeforeCompletion$1.label = 1;
        Object objMo12027modifyBeforeCompletiongIAlus = super.mo12027modifyBeforeCompletiongIAlus(responseInterceptorContext, awsSpanInterceptor$modifyBeforeCompletion$1);
        return objMo12027modifyBeforeCompletiongIAlus == coroutine_suspended ? coroutine_suspended : objMo12027modifyBeforeCompletiongIAlus;
    }

    private final void setAwsRequestIdAttrs(TraceSpan span, HttpResponse httpResp) {
        if (span == null || httpResp == null) {
            return;
        }
        String str = httpResp.getHeaders().get(ResponseUtilsKt.X_AMZN_REQUEST_ID_HEADER);
        if (str != null) {
            TraceSpanExtKt.setAttribute(span, "aws.request_id", str);
        }
        String str2 = httpResp.getHeaders().get("x-amz-id-2");
        if (str2 != null) {
            TraceSpanExtKt.setAttribute(span, "aws.extended_request_id", str2);
        }
    }
}
