package aws.smithy.kotlin.runtime.http.operation;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.p011io.Handler;
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

/* JADX INFO: Add missing generic type declarations: [Output] */
/* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.operation.OperationHandler$call$lambda$1$$inlined$scopedTimeout-hhJSO8g$1, reason: invalid class name */
/* JADX INFO: compiled from: Timeouts.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, m1599d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "aws/smithy/kotlin/runtime/http/operation/TimeoutsKt$scopedTimeout$2"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.operation.OperationHandler$call$lambda$1$$inlined$scopedTimeout-hhJSO8g$1", m1609f = "SdkOperationExecution.kt", m1610i = {0, 0}, m1611l = {73}, m1612m = "invokeSuspend", m1613n = {"$completion", "$i$a$-scopedTimeout-hhJSO8g-OperationHandler$call$result$1$1"}, m1614nl = {56}, m1615s = {"L$0", "I$0"}, m1616v = 2)
public final class OperationHandler$call$lambda$1$$inlined$scopedTimeouthhJSO8g$1<Output> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Output>, Object> {
    final /* synthetic */ OperationRequest $request$inlined;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ OperationHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationHandler$call$lambda$1$$inlined$scopedTimeouthhJSO8g$1(Continuation continuation, OperationHandler operationHandler, OperationRequest operationRequest) {
        super(2, continuation);
        this.this$0 = operationHandler;
        this.$request$inlined = operationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperationHandler$call$lambda$1$$inlined$scopedTimeouthhJSO8g$1(continuation, this.this$0, this.$request$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Output> continuation) {
        return ((OperationHandler$call$lambda$1$$inlined$scopedTimeouthhJSO8g$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        Handler handler = this.this$0.inner;
        OperationRequest operationRequest = this.$request$inlined;
        this.L$0 = SpillingKt.nullOutSpilledVariable(this);
        this.I$0 = 0;
        this.label = 1;
        Object objCall = handler.call(operationRequest, this);
        return objCall == coroutine_suspended ? coroutine_suspended : objCall;
    }
}
