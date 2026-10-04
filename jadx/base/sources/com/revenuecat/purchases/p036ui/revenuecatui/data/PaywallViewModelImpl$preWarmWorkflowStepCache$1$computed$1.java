package com.revenuecat.purchases.p036ui.revenuecatui.data;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowStep;
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
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$preWarmWorkflowStepCache$1$computed$1", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class PaywallViewModelImpl$preWarmWorkflowStepCache$1$computed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PaywallState>, Object> {
    final /* synthetic */ Offerings $offerings;
    final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
    final /* synthetic */ PaywallStateStore $stateStore;
    final /* synthetic */ WorkflowStep $step;
    final /* synthetic */ UiConfig $uiConfig;
    final /* synthetic */ PublishedWorkflow $workflow;
    int label;
    final /* synthetic */ PaywallViewModelImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallViewModelImpl$preWarmWorkflowStepCache$1$computed$1(PaywallViewModelImpl paywallViewModelImpl, WorkflowStep workflowStep, PublishedWorkflow publishedWorkflow, UiConfig uiConfig, Offerings offerings, PresentedOfferingContext presentedOfferingContext, PaywallStateStore paywallStateStore, Continuation<? super PaywallViewModelImpl$preWarmWorkflowStepCache$1$computed$1> continuation) {
        super(2, continuation);
        this.this$0 = paywallViewModelImpl;
        this.$step = workflowStep;
        this.$workflow = publishedWorkflow;
        this.$uiConfig = uiConfig;
        this.$offerings = offerings;
        this.$presentedOfferingContext = presentedOfferingContext;
        this.$stateStore = paywallStateStore;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallViewModelImpl$preWarmWorkflowStepCache$1$computed$1(this.this$0, this.$step, this.$workflow, this.$uiConfig, this.$offerings, this.$presentedOfferingContext, this.$stateStore, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PaywallState> continuation) {
        return ((PaywallViewModelImpl$preWarmWorkflowStepCache$1$computed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.computeStateForStep(this.$step, this.$workflow, this.$uiConfig, this.$offerings, this.$presentedOfferingContext, this.$stateStore);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
