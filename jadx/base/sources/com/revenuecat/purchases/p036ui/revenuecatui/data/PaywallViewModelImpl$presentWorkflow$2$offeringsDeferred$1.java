package com.revenuecat.purchases.p036ui.revenuecatui.data;

import com.revenuecat.purchases.Offerings;
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
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "Lcom/revenuecat/purchases/Offerings;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$presentWorkflow$2$offeringsDeferred$1", m1609f = "PaywallViewModel.kt", m1610i = {}, m1611l = {964}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
final class PaywallViewModelImpl$presentWorkflow$2$offeringsDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Offerings>, Object> {
    final /* synthetic */ Offerings $preloadedOfferings;
    int label;
    final /* synthetic */ PaywallViewModelImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallViewModelImpl$presentWorkflow$2$offeringsDeferred$1(Offerings offerings, PaywallViewModelImpl paywallViewModelImpl, Continuation<? super PaywallViewModelImpl$presentWorkflow$2$offeringsDeferred$1> continuation) {
        super(2, continuation);
        this.$preloadedOfferings = offerings;
        this.this$0 = paywallViewModelImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallViewModelImpl$presentWorkflow$2$offeringsDeferred$1(this.$preloadedOfferings, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Offerings> continuation) {
        return ((PaywallViewModelImpl$presentWorkflow$2$offeringsDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Offerings offerings = this.$preloadedOfferings;
            if (offerings != null) {
                return offerings;
            }
            this.label = 1;
            obj = this.this$0.purchases.awaitOfferings(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return (Offerings) obj;
    }
}
