package com.revenuecat.purchases.p036ui.revenuecatui.components;

import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LoadedWorkflowPaywall.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "action", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1", m1609f = "LoadedWorkflowPaywall.kt", m1610i = {}, m1611l = {235}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PaywallAction.External, Continuation<? super Unit>, Object> $clickHandler;
    final /* synthetic */ PaywallComponentInteractionTracker $componentInteractionTracker;
    final /* synthetic */ boolean $isCurrent;
    final /* synthetic */ PaywallState.Loaded.Components $stepState;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1(boolean z, PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Continuation<? super LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1> continuation) {
        super(2, continuation);
        this.$isCurrent = z;
        this.$stepState = components;
        this.$clickHandler = function2;
        this.$componentInteractionTracker = paywallComponentInteractionTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1 loadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1 = new LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1(this.$isCurrent, this.$stepState, this.$clickHandler, this.$componentInteractionTracker, continuation);
        loadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1.L$0 = obj;
        return loadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
        return ((LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PaywallAction paywallAction = (PaywallAction) this.L$0;
            if (this.$isCurrent) {
                this.label = 1;
                if (LoadedPaywallComponentsKt.handleClick(paywallAction, this.$stepState, this.$clickHandler, this.$componentInteractionTracker, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
