package aws.smithy.kotlin.runtime.http.middleware;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: Add missing generic type declarations: [O] */
/* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "aws/smithy/kotlin/runtime/telemetry/trace/CoroutineContextTraceExtKt$withSpan$3"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware$handle$$inlined$withSpan$default$1", m1609f = "RetryMiddleware.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {WebSocketProtocol.PAYLOAD_SHORT}, m1612m = "invokeSuspend", m1613n = {"$this$withContext", "$completion", "it", "$this$handle_u24lambda_u241", "$i$a$-withSpan$default-RetryMiddleware$handle$result$1"}, m1614nl = {75}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m1616v = 2)
public final class RetryMiddleware$handle$$inlined$withSpan$default$1<O> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends O>>, Object> {
    final /* synthetic */ Ref.IntRef $attempt$inlined;
    final /* synthetic */ OperationRequest $modified$inlined;
    final /* synthetic */ Handler $next$inlined;
    final /* synthetic */ TraceSpan $span;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ RetryMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryMiddleware$handle$$inlined$withSpan$default$1(TraceSpan traceSpan, Continuation continuation, RetryMiddleware retryMiddleware, OperationRequest operationRequest, Handler handler, Ref.IntRef intRef) {
        super(2, continuation);
        this.$span = traceSpan;
        this.this$0 = retryMiddleware;
        this.$modified$inlined = operationRequest;
        this.$next$inlined = handler;
        this.$attempt$inlined = intRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RetryMiddleware$handle$$inlined$withSpan$default$1 retryMiddleware$handle$$inlined$withSpan$default$1 = new RetryMiddleware$handle$$inlined$withSpan$default$1(this.$span, continuation, this.this$0, this.$modified$inlined, this.$next$inlined, this.$attempt$inlined);
        retryMiddleware$handle$$inlined$withSpan$default$1.L$0 = obj;
        return retryMiddleware$handle$$inlined$withSpan$default$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends O>> continuation) {
        return ((RetryMiddleware$handle$$inlined$withSpan$default$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objM12216tryAttemptBWLJW6A;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TraceSpan traceSpan = this.$span;
            RetryMiddleware retryMiddleware = this.this$0;
            OperationRequest operationRequest = this.$modified$inlined;
            Handler handler = this.$next$inlined;
            int i2 = this.$attempt$inlined.element;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(this);
            this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
            this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.I$0 = 0;
            this.label = 1;
            objM12216tryAttemptBWLJW6A = retryMiddleware.m12216tryAttemptBWLJW6A(operationRequest, handler, i2, this);
            if (objM12216tryAttemptBWLJW6A == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM12216tryAttemptBWLJW6A = ((Result) obj).getValue();
        }
        return Result.m14498boximpl(objM12216tryAttemptBWLJW6A);
    }
}
