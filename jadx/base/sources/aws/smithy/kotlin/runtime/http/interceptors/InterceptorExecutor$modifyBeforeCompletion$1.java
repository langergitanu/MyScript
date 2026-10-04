package aws.smithy.kotlin.runtime.http.interceptors;

import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: InterceptorExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", m1609f = "InterceptorExecutor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {AIContainerViewModel.SUMMARIZE_MIN_LIMIT}, m1612m = "modifyBeforeCompletion-KWTtemM", m1613n = {"result", "input", WebViewMessageType.CONTEXT, "$this$modifyBeforeCompletion_KWTtemM_u24lambda_u240", "$this$fold$iv", "initial$iv", "accumulator$iv", "element$iv", "interceptor", "ctx", "$i$a$-runCatching-InterceptorExecutor$modifyBeforeCompletion$modifyResult$1", "$i$f$fold", "$i$a$-fold-InterceptorExecutor$modifyBeforeCompletion$modifyResult$1$1"}, m1614nl = {300}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2"}, m1616v = 2)
final class InterceptorExecutor$modifyBeforeCompletion$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InterceptorExecutor<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InterceptorExecutor$modifyBeforeCompletion$1(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super InterceptorExecutor$modifyBeforeCompletion$1> continuation) {
        super(continuation);
        this.this$0 = interceptorExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12211modifyBeforeCompletionKWTtemM = this.this$0.m12211modifyBeforeCompletionKWTtemM(null, this);
        return objM12211modifyBeforeCompletionKWTtemM == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12211modifyBeforeCompletionKWTtemM : Result.m14498boximpl(objM12211modifyBeforeCompletionKWTtemM);
    }
}
