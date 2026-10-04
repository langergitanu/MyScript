package aws.smithy.kotlin.runtime.http.interceptors;

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
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.InterceptorExecutor", m1609f = "InterceptorExecutor.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, m1611l = {264}, m1612m = "modifyBeforeAttemptCompletion-3t6e044", m1613n = {"result", "httpRequest", "httpResponse", "input", WebViewMessageType.CONTEXT, "$this$modifyBeforeAttemptCompletion_3t6e044_u24lambda_u240", "$this$fold$iv", "initial$iv", "accumulator$iv", "element$iv", "interceptor", "ctx", "$i$a$-runCatching-InterceptorExecutor$modifyBeforeAttemptCompletion$modified$1", "$i$f$fold", "$i$a$-fold-InterceptorExecutor$modifyBeforeAttemptCompletion$modified$1$1"}, m1614nl = {265}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "I$0", "I$1", "I$2"}, m1616v = 2)
final class InterceptorExecutor$modifyBeforeAttemptCompletion$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
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
    InterceptorExecutor$modifyBeforeAttemptCompletion$1(InterceptorExecutor<I, O> interceptorExecutor, Continuation<? super InterceptorExecutor$modifyBeforeAttemptCompletion$1> continuation) {
        super(continuation);
        this.this$0 = interceptorExecutor;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12210modifyBeforeAttemptCompletion3t6e044 = this.this$0.m12210modifyBeforeAttemptCompletion3t6e044(null, null, null, this);
        return objM12210modifyBeforeAttemptCompletion3t6e044 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12210modifyBeforeAttemptCompletion3t6e044 : Result.m14498boximpl(objM12210modifyBeforeAttemptCompletion3t6e044);
    }
}
