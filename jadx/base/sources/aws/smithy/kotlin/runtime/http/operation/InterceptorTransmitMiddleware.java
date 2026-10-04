package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestKt;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.p011io.middleware.Middleware;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.HttpStatus;

/* JADX INFO: compiled from: SdkOperationExecution.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0003B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\n\u0010\u000bJJ\u0010\u0010\u001a\u00020\u0007\"\u001e\b\u0002\u0010\r*\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\f2\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00062\u0006\u0010\u000f\u001a\u00028\u0002H\u0096@¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/InterceptorTransmitMiddleware;", "I", "O", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/HttpCall;", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "interceptors", "<init>", "(Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;)V", "Laws/smithy/kotlin/runtime/io/Handler;", "H", "request", "next", "handle", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/http/interceptors/InterceptorExecutor;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class InterceptorTransmitMiddleware<I, O> implements Middleware<OperationRequest<HttpRequestBuilder>, HttpCall> {
    private final InterceptorExecutor<I, O> interceptors;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.InterceptorTransmitMiddleware$handle$1 */
    /* JADX INFO: compiled from: SdkOperationExecution.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.InterceptorTransmitMiddleware", m1609f = "SdkOperationExecution.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {HttpStatus.SC_REQUEST_TOO_LONG, 416}, m1612m = "handle", m1613n = {"request", "next", "request", "next", "modified"}, m1614nl = {HttpStatus.SC_REQUEST_URI_TOO_LONG, HttpStatus.SC_EXPECTATION_FAILED}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C37301<H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InterceptorTransmitMiddleware<I, O> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37301(InterceptorTransmitMiddleware<I, O> interceptorTransmitMiddleware, Continuation<? super C37301> continuation) {
            super(continuation);
            this.this$0 = interceptorTransmitMiddleware;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handle((OperationRequest<HttpRequestBuilder>) null, (Handler) null, (Continuation<? super HttpCall>) this);
        }
    }

    public InterceptorTransmitMiddleware(InterceptorExecutor<I, O> interceptors) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.interceptors = interceptors;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009d, code lost:
    
        if (r11 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.middleware.Middleware
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>> Object handle(OperationRequest<HttpRequestBuilder> operationRequest, H h, Continuation<? super HttpCall> continuation) {
        C37301 c37301;
        if (continuation instanceof C37301) {
            c37301 = (C37301) continuation;
            if ((c37301.label & Integer.MIN_VALUE) != 0) {
                c37301.label -= Integer.MIN_VALUE;
            } else {
                c37301 = new C37301(this, continuation);
            }
        }
        Object objModifyBeforeTransmit = c37301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37301.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objModifyBeforeTransmit);
            InterceptorExecutor<I, O> interceptorExecutor = this.interceptors;
            HttpRequest httpRequestImmutableView = HttpRequestBuilderKt.immutableView(operationRequest.getSubject(), true);
            c37301.L$0 = operationRequest;
            c37301.L$1 = h;
            c37301.label = 1;
            objModifyBeforeTransmit = interceptorExecutor.modifyBeforeTransmit(httpRequestImmutableView, c37301);
            if (objModifyBeforeTransmit != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objModifyBeforeTransmit);
            HttpCall httpCall = (HttpCall) objModifyBeforeTransmit;
            this.interceptors.readAfterTransmit(httpCall);
            return httpCall;
        }
        h = (H) c37301.L$1;
        operationRequest = (OperationRequest) c37301.L$0;
        ResultKt.throwOnFailure(objModifyBeforeTransmit);
        OperationRequest operationRequestCopy$default = OperationRequest.copy$default(operationRequest, null, HttpRequestKt.toBuilder((HttpRequest) objModifyBeforeTransmit), 1, null);
        this.interceptors.readBeforeTransmit(HttpRequestBuilderKt.immutableView$default((HttpRequestBuilder) operationRequestCopy$default.getSubject(), false, 1, null));
        c37301.L$0 = SpillingKt.nullOutSpilledVariable(operationRequest);
        c37301.L$1 = SpillingKt.nullOutSpilledVariable(h);
        c37301.L$2 = SpillingKt.nullOutSpilledVariable(operationRequestCopy$default);
        c37301.label = 2;
        objModifyBeforeTransmit = h.call(operationRequestCopy$default, c37301);
    }
}
