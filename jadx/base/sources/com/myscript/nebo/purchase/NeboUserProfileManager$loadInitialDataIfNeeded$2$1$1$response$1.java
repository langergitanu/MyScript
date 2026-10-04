package com.myscript.nebo.purchase;

import com.myscript.nebo.account.backend.entity.InAppPurchaseResponse;
import com.myscript.nebo.freemium.InAppProduct;
import com.pdftron.pdf.pdfa.PDFACompliance;
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
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/account/backend/entity/InAppPurchaseResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.purchase.NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1", m1609f = "NeboUserProfileManager.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA1_2_1}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
final class NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InAppPurchaseResponse>, Object> {
    final /* synthetic */ InAppProduct $product;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ NeboUserProfileManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1(NeboUserProfileManager neboUserProfileManager, String str, InAppProduct inAppProduct, Continuation<? super NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1> continuation) {
        super(2, continuation);
        this.this$0 = neboUserProfileManager;
        this.$token = str;
        this.$product = inAppProduct;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1(this.this$0, this.$token, this.$product, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InAppPurchaseResponse> continuation) {
        return ((NeboUserProfileManager$loadInitialDataIfNeeded$2$1$1$response$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        this.label = 1;
        Object objSendPurchase = this.this$0.neboBackend.sendPurchase(this.$token, this.this$0.packageName, this.$product.getId(), this);
        return objSendPurchase == coroutine_suspended ? coroutine_suspended : objSendPurchase;
    }
}
