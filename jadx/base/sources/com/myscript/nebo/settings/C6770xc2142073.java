package com.myscript.nebo.settings;

import androidx.fragment.app.FragmentActivity;
import com.myscript.nebo.freemium.InAppProduct;
import com.myscript.nebo.freemium.PurchaseController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.myscript.nebo.settings.AccountSettingsFragment$purchaseRequestedCallback$1$onPurchaseRequested$2 */
/* JADX INFO: compiled from: AccountSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.settings.AccountSettingsFragment$purchaseRequestedCallback$1$onPurchaseRequested$2", m1609f = "AccountSettingsFragment.kt", m1610i = {}, m1611l = {118}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {119}, m1615s = {}, m1616v = 2)
final class C6770xc2142073 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AccountSettingsFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6770xc2142073(AccountSettingsFragment accountSettingsFragment, Continuation<? super C6770xc2142073> continuation) {
        super(2, continuation);
        this.this$0 = accountSettingsFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6770xc2142073(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C6770xc2142073) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PurchaseController purchaseController = this.this$0.purchaseController;
            if (purchaseController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("purchaseController");
                purchaseController = null;
            }
            InAppProduct inAppProduct = InAppProduct.Lifetime;
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
            this.label = 1;
            if (purchaseController.purchase(inAppProduct, fragmentActivityRequireActivity, this) == coroutine_suspended) {
                return coroutine_suspended;
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
