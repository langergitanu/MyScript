package aws.smithy.kotlin.runtime.http.operation;

import aws.smithy.kotlin.runtime.p011io.Handler;
import aws.smithy.kotlin.runtime.telemetry.trace.TraceSpan;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: CoroutineContextTraceExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, m1599d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;", "aws/smithy/kotlin/runtime/telemetry/trace/CoroutineContextTraceExtKt$withSpan$3"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.SdkHttpOperationKt$execute$$inlined$withSpan$1", m1609f = "SdkHttpOperation.kt", m1610i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m1611l = {WebSocketProtocol.PAYLOAD_SHORT, 127}, m1612m = "invokeSuspend", m1613n = {"$this$withContext", "$completion", "it", "$this$execute_u24lambda_u240", "$i$a$-withSpan-SdkHttpOperationKt$execute$2", "$this$withContext", "$completion", "it", "$this$execute_u24lambda_u240", "output", "$i$a$-withSpan-SdkHttpOperationKt$execute$2"}, m1614nl = {127, 75}, m1615s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m1616v = 2)
public final class SdkHttpOperationKt$execute$$inlined$withSpan$1<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ Function2 $block$inlined;
    final /* synthetic */ Handler $handler$inlined;
    final /* synthetic */ OperationRequest $request$inlined;
    final /* synthetic */ TraceSpan $span;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SdkHttpOperationKt$execute$$inlined$withSpan$1(TraceSpan traceSpan, Continuation continuation, Handler handler, OperationRequest operationRequest, Function2 function2) {
        super(2, continuation);
        this.$span = traceSpan;
        this.$handler$inlined = handler;
        this.$request$inlined = operationRequest;
        this.$block$inlined = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SdkHttpOperationKt$execute$$inlined$withSpan$1 sdkHttpOperationKt$execute$$inlined$withSpan$1 = new SdkHttpOperationKt$execute$$inlined$withSpan$1(this.$span, continuation, this.$handler$inlined, this.$request$inlined, this.$block$inlined);
        sdkHttpOperationKt$execute$$inlined$withSpan$1.L$0 = obj;
        return sdkHttpOperationKt$execute$$inlined$withSpan$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return ((SdkHttpOperationKt$execute$$inlined$withSpan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TraceSpan traceSpan;
        SdkHttpOperationKt$execute$$inlined$withSpan$1<R> sdkHttpOperationKt$execute$$inlined$withSpan$1;
        CoroutineScope coroutineScope;
        int i;
        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            traceSpan = this.$span;
            sdkHttpOperationKt$execute$$inlined$withSpan$1 = this;
            Handler handler = this.$handler$inlined;
            OperationRequest operationRequest = this.$request$inlined;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
            this.L$1 = SpillingKt.nullOutSpilledVariable(sdkHttpOperationKt$execute$$inlined$withSpan$1);
            this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
            this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
            this.I$0 = 0;
            this.label = 1;
            obj = handler.call(operationRequest, this);
            if (obj != coroutine_suspended) {
                coroutineScope = coroutineScope2;
                i = 0;
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        i = this.I$0;
        coroutineScope = (CoroutineScope) this.L$3;
        traceSpan = (TraceSpan) this.L$2;
        sdkHttpOperationKt$execute$$inlined$withSpan$1 = (Continuation) this.L$1;
        ResultKt.throwOnFailure(obj);
        Function2 function2 = this.$block$inlined;
        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope2);
        this.L$1 = SpillingKt.nullOutSpilledVariable(sdkHttpOperationKt$execute$$inlined$withSpan$1);
        this.L$2 = SpillingKt.nullOutSpilledVariable(traceSpan);
        this.L$3 = SpillingKt.nullOutSpilledVariable(coroutineScope);
        this.L$4 = SpillingKt.nullOutSpilledVariable(obj);
        this.I$0 = i;
        this.label = 2;
        Object objInvoke = function2.invoke(obj, this);
        return objInvoke == coroutine_suspended ? coroutine_suspended : objInvoke;
    }
}
