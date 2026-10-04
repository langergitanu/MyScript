package com.myscript.nebo.purchase;

import com.myscript.nebo.analytics.firebase.LoginOrigin;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Paywall.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "token", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.PaywallKt$PaywallScreen$7$2$1", m1609f = "Paywall.kt", m1610i = {0}, m1611l = {152}, m1612m = "invokeSuspend", m1613n = {"token"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
final class PaywallKt$PaywallScreen$7$2$1 extends SuspendLambda implements Function2<String, Continuation<? super Boolean>, Object> {
    final /* synthetic */ PaywallViewModel $paywallViewModel;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallKt$PaywallScreen$7$2$1(PaywallViewModel paywallViewModel, Continuation<? super PaywallKt$PaywallScreen$7$2$1> continuation) {
        super(2, continuation);
        this.$paywallViewModel = paywallViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaywallKt$PaywallScreen$7$2$1 paywallKt$PaywallScreen$7$2$1 = new PaywallKt$PaywallScreen$7$2$1(this.$paywallViewModel, continuation);
        paywallKt$PaywallScreen$7$2$1.L$0 = obj;
        return paywallKt$PaywallScreen$7$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Boolean> continuation) {
        return ((PaywallKt$PaywallScreen$7$2$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str = (String) this.L$0;
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
        this.L$0 = SpillingKt.nullOutSpilledVariable(str);
        this.label = 1;
        Object objStartNativeLoginWithGoogle = this.$paywallViewModel.startNativeLoginWithGoogle(str, LoginOrigin.PremiumModal.getValue(), this);
        return objStartNativeLoginWithGoogle == coroutine_suspended ? coroutine_suspended : objStartNativeLoginWithGoogle;
    }
}
