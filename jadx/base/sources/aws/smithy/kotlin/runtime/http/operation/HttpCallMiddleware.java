package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.http.HttpCall;
import aws.smithy.kotlin.runtime.http.HttpCallKt;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.p011io.middleware.Middleware;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: SdkOperationExecution.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\b\u0002\u0018\u00002\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007JJ\u0010\f\u001a\u00020\u0005\"\u001e\b\u0000\u0010\t*\u0018\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\b2\u0010\u0010\n\u001a\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u00042\u0006\u0010\u000b\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/operation/HttpCallMiddleware;", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "Laws/smithy/kotlin/runtime/http/operation/OperationRequest;", "Laws/smithy/kotlin/runtime/http/request/HttpRequestBuilder;", "Laws/smithy/kotlin/runtime/http/operation/SdkHttpRequest;", "Laws/smithy/kotlin/runtime/http/HttpCall;", "<init>", "()V", "Laws/smithy/kotlin/runtime/io/Handler;", "H", "request", "next", "handle", "(Laws/smithy/kotlin/runtime/http/operation/OperationRequest;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callList", "Ljava/util/List;", "http-client"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class HttpCallMiddleware implements Middleware<OperationRequest<HttpRequestBuilder>, HttpCall> {
    private final List<HttpCall> callList = new ArrayList();

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware$handle$1 */
    /* JADX INFO: compiled from: SdkOperationExecution.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.HttpCallMiddleware", m1609f = "SdkOperationExecution.kt", m1610i = {0, 0, 1, 1}, m1611l = {PDFACompliance.e_PDFA3_7_1, PDFACompliance.e_PDFA3_7_3}, m1612m = "handle", m1613n = {"request", "next", "request", "next"}, m1614nl = {PDFACompliance.e_PDFA3_7_3, 374}, m1615s = {"L$0", "L$1", "L$0", "L$1"}, m1616v = 2)
    static final class C37291<H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C37291(Continuation<? super C37291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpCallMiddleware.this.handle((OperationRequest<HttpRequestBuilder>) null, (Handler) null, (Continuation<? super HttpCall>) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
    
        if (r9 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.middleware.Middleware
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <H extends Handler<? super OperationRequest<HttpRequestBuilder>, ? extends HttpCall>> Object handle(OperationRequest<HttpRequestBuilder> operationRequest, H h, Continuation<? super HttpCall> continuation) {
        C37291 c37291;
        if (continuation instanceof C37291) {
            c37291 = (C37291) continuation;
            if ((c37291.label & Integer.MIN_VALUE) != 0) {
                c37291.label -= Integer.MIN_VALUE;
            } else {
                c37291 = new C37291(continuation);
            }
        }
        Object objCall = c37291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37291.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCall);
            if (!this.callList.isEmpty()) {
                HttpCall httpCall = (HttpCall) CollectionsKt.last((List) this.callList);
                c37291.L$0 = operationRequest;
                c37291.L$1 = h;
                c37291.label = 1;
                if (HttpCallKt.complete(httpCall, c37291) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                operationRequest = (OperationRequest) c37291.L$0;
                ResultKt.throwOnFailure(objCall);
                HttpCall httpCall2 = (HttpCall) objCall;
                this.callList.add(httpCall2);
                operationRequest.getContext().set(HttpOperationContext.INSTANCE.getHttpCallList(), this.callList);
                return httpCall2;
            }
            Handler handler = (Handler) c37291.L$1;
            OperationRequest<HttpRequestBuilder> operationRequest2 = (OperationRequest) c37291.L$0;
            ResultKt.throwOnFailure(objCall);
            h = (H) handler;
            operationRequest = operationRequest2;
        }
        c37291.L$0 = operationRequest;
        c37291.L$1 = SpillingKt.nullOutSpilledVariable(h);
        c37291.label = 2;
        objCall = h.call(operationRequest, c37291);
    }
}
