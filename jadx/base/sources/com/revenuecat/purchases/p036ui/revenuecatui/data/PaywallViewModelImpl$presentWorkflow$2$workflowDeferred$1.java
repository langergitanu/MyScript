package com.revenuecat.purchases.p036ui.revenuecatui.data;

import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PaywallViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$presentWorkflow$2$workflowDeferred$1", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {962}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class PaywallViewModelImpl$presentWorkflow$2$workflowDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PublishedWorkflow>, Object> {
    final /* synthetic */ String $workflowId;
    int label;
    final /* synthetic */ PaywallViewModelImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallViewModelImpl$presentWorkflow$2$workflowDeferred$1(PaywallViewModelImpl paywallViewModelImpl, String str, Continuation<? super PaywallViewModelImpl$presentWorkflow$2$workflowDeferred$1> continuation) {
        super(2, continuation);
        this.this$0 = paywallViewModelImpl;
        this.$workflowId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallViewModelImpl$presentWorkflow$2$workflowDeferred$1(this.this$0, this.$workflowId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PublishedWorkflow> continuation) {
        return ((PaywallViewModelImpl$presentWorkflow$2$workflowDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws PurchasesException {
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
        this.label = 1;
        Object objAwaitGetWorkflow = this.this$0.purchases.awaitGetWorkflow(this.$workflowId, this);
        return objAwaitGetWorkflow == coroutine_suspended ? coroutine_suspended : objAwaitGetWorkflow;
    }
}
