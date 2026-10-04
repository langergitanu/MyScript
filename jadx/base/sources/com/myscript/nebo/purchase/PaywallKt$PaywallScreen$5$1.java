package com.myscript.nebo.purchase;

import androidx.compose.runtime.MutableState;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Paywall.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", ""}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.PaywallKt$PaywallScreen$5$1", m1609f = "Paywall.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_2_3}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {127}, m1615s = {}, m1616v = 2)
final class PaywallKt$PaywallScreen$5$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ PaywallViewModel $paywallViewModel;
    final /* synthetic */ MutableState<Boolean> $showNativeSignIn$delegate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallKt$PaywallScreen$5$1(PaywallViewModel paywallViewModel, MutableState<Boolean> mutableState, Continuation<? super PaywallKt$PaywallScreen$5$1> continuation) {
        super(1, continuation);
        this.$paywallViewModel = paywallViewModel;
        this.$showNativeSignIn$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PaywallKt$PaywallScreen$5$1(this.$paywallViewModel, this.$showNativeSignIn$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Boolean> continuation) {
        return ((PaywallKt$PaywallScreen$5$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        PaywallViewModel paywallViewModel = this.$paywallViewModel;
        final MutableState<Boolean> mutableState = this.$showNativeSignIn$delegate;
        this.label = 1;
        Object objPrePurchaseChecks = paywallViewModel.prePurchaseChecks(new Function0() { // from class: com.myscript.nebo.purchase.PaywallKt$PaywallScreen$5$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PaywallKt$PaywallScreen$5$1.invokeSuspend$lambda$0(mutableState);
            }
        }, this);
        return objPrePurchaseChecks == coroutine_suspended ? coroutine_suspended : objPrePurchaseChecks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(MutableState mutableState) {
        PaywallKt.PaywallScreen$lambda$6(mutableState, true);
        return Unit.INSTANCE;
    }
}
