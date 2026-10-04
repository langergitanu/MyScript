package aws.smithy.kotlin.runtime.http.middleware;

import androidx.compose.p004ui.spatial.RectListKt;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.p007ts.TsExtractor;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.http.HttpBody;
import aws.smithy.kotlin.runtime.http.HttpBodyKt;
import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpStatusCodeKt;
import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.operation.ReceiveMiddleware;
import aws.smithy.kotlin.runtime.http.operation.SdkHttpOperation;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.Handler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: DefaultValidateResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JJ\u0010\f\u001a\u00020\b\"\u001e\b\u0000\u0010\t*\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00042\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/middleware/DefaultValidateResponse;", "Laws/smithy/kotlin/runtime/http/operation/ReceiveMiddleware;", "<init>", "()V", "Laws/smithy/kotlin/runtime/io/Handler;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/HttpCall;", "H", "request", "next", "handle", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultValidateResponse implements ReceiveMiddleware {

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.middleware.DefaultValidateResponse$handle$1 */
    /* JADX INFO: compiled from: DefaultValidateResponse.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.middleware.DefaultValidateResponse", m1609f = "DefaultValidateResponse.kt", m1610i = {0, 0, 1, 1, 1, 1, 1, 1}, m1611l = {RectListKt.BitOffsetForGesturable, TsExtractor.TS_SYNC_BYTE}, m1612m = "handle", m1613n = {"request", "next", "request", "next", NotificationCompat.CATEGORY_CALL, "message", "$this$handle_u24lambda_u240", "$i$a$-apply-DefaultValidateResponse$handle$httpException$1"}, m1614nl = {63, 72}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$5", "I$0"}, m1616v = 2)
    static final class C37231<H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>> extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C37231(Continuation<? super C37231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultValidateResponse.this.handle((OperationRequest<HttpRequestBuilder>) null, (Handler) null, (Continuation<? super HttpCall>) this);
        }
    }

    @Override // aws.smithy.kotlin.runtime.http.operation.ReceiveMiddleware
    @InternalApi
    public /* bridge */ void install(SdkHttpOperation<?, ?> sdkHttpOperation) {
        super.install(sdkHttpOperation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.middleware.Middleware
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>> Object handle(OperationRequest<HttpRequestBuilder> operationRequest, H h, Continuation<? super HttpCall> continuation) {
        C37231 c37231;
        HttpCall httpCall;
        HttpResponseException httpResponseException;
        HttpResponseException httpResponseException2;
        HttpResponseException httpResponseException3;
        if (continuation instanceof C37231) {
            c37231 = (C37231) continuation;
            if ((c37231.label & Integer.MIN_VALUE) != 0) {
                c37231.label -= Integer.MIN_VALUE;
            } else {
                c37231 = new C37231(continuation);
            }
        }
        Object objCall = c37231.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37231.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCall);
            c37231.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
            c37231.L$1 = SpillingKt.nullOutSpilledVariable(h);
            c37231.label = 1;
            objCall = h.call(operationRequest, c37231);
            if (objCall != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c37231.I$0;
            httpResponseException = (HttpResponseException) c37231.L$6;
            httpResponseException2 = (HttpResponseException) c37231.L$5;
            httpResponseException3 = (HttpResponseException) c37231.L$4;
            httpCall = (HttpCall) c37231.L$2;
            ResultKt.throwOnFailure(objCall);
            httpResponseException.setBody((byte[]) objCall);
            httpResponseException2.setRequest(httpCall.getRequest());
            throw httpResponseException3;
        }
        h = (H) c37231.L$1;
        operationRequest = (OperationRequest) c37231.L$0;
        ResultKt.throwOnFailure(objCall);
        httpCall = (HttpCall) objCall;
        if (HttpStatusCodeKt.isSuccess(httpCall.getResponse().getStatus())) {
            return httpCall;
        }
        String str = "received unsuccessful HTTP call.response: " + httpCall.getResponse().getStatus();
        HttpResponseException httpResponseException4 = new HttpResponseException(str);
        httpResponseException4.setStatusCode(httpCall.getResponse().getStatus());
        httpResponseException4.setHeaders(httpCall.getResponse().getHeaders());
        HttpBody body = httpCall.getResponse().getBody();
        c37231.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
        c37231.L$1 = SpillingKt.nullOutSpilledVariable(h);
        c37231.L$2 = httpCall;
        c37231.L$3 = SpillingKt.nullOutSpilledVariable(str);
        c37231.L$4 = httpResponseException4;
        c37231.L$5 = httpResponseException4;
        c37231.L$6 = httpResponseException4;
        c37231.I$0 = 0;
        c37231.label = 2;
        objCall = HttpBodyKt.readAll(body, c37231);
        if (objCall != coroutine_suspended) {
            httpResponseException = httpResponseException4;
            httpResponseException2 = httpResponseException;
            httpResponseException3 = httpResponseException2;
            httpResponseException.setBody((byte[]) objCall);
            httpResponseException2.setRequest(httpCall.getRequest());
            throw httpResponseException3;
        }
        return coroutine_suspended;
    }
}
