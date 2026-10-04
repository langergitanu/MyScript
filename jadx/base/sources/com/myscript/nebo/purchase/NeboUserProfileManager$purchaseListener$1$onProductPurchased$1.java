package com.myscript.nebo.purchase;

import com.myscript.nebo.freemium.InAppProduct;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NeboUserProfileManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$purchaseListener$1$onProductPurchased$1", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {60, 61}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {61, 65}, m1615s = {}, m1616v = 2)
final class NeboUserProfileManager$purchaseListener$1$onProductPurchased$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $packageName;
    final /* synthetic */ InAppProduct $product;
    final /* synthetic */ String $purchaseToken;
    int label;
    final /* synthetic */ NeboUserProfileManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboUserProfileManager$purchaseListener$1$onProductPurchased$1(NeboUserProfileManager neboUserProfileManager, String str, String str2, InAppProduct inAppProduct, Continuation<? super NeboUserProfileManager$purchaseListener$1$onProductPurchased$1> continuation) {
        super(2, continuation);
        this.this$0 = neboUserProfileManager;
        this.$purchaseToken = str;
        this.$packageName = str2;
        this.$product = inAppProduct;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboUserProfileManager$purchaseListener$1$onProductPurchased$1(this.this$0, this.$purchaseToken, this.$packageName, this.$product, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NeboUserProfileManager$purchaseListener$1$onProductPurchased$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r7.this$0.ioDispatcher, new com.myscript.nebo.purchase.NeboUserProfileManager$purchaseListener$1$onProductPurchased$1.C67241(r7.this$0, r7.$product, r7.$purchaseToken, null), r7) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.neboBackend.sendPurchase(this.$purchaseToken, this.$packageName, this.$product.getId(), this) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.notifyUserStatusChanged();
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 2;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.purchase.NeboUserProfileManager$purchaseListener$1$onProductPurchased$1$1 */
    /* JADX INFO: compiled from: NeboUserProfileManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$purchaseListener$1$onProductPurchased$1$1", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ InAppProduct $product;
        final /* synthetic */ String $purchaseToken;
        int label;
        final /* synthetic */ NeboUserProfileManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67241(NeboUserProfileManager neboUserProfileManager, InAppProduct inAppProduct, String str, Continuation<? super C67241> continuation) {
            super(2, continuation);
            this.this$0 = neboUserProfileManager;
            this.$product = inAppProduct;
            this.$purchaseToken = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67241(this.this$0, this.$product, this.$purchaseToken, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.purchaseStorage.store(this.$product.getId(), this.$purchaseToken);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
