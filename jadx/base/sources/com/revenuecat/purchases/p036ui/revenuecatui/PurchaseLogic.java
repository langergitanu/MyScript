package com.revenuecat.purchases.p036ui.revenuecatui;

import android.app.Activity;
import com.revenuecat.purchases.Package;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: PurchaseLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated(message = "Use PaywallPurchaseLogic instead for product change and offer support.", replaceWith = @ReplaceWith(expression = "PaywallPurchaseLogic", imports = {}))
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogic;", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogic;", "performPurchase", "Lcom/revenuecat/purchases/ui/revenuecatui/PurchaseLogicResult;", "activity", "Landroid/app/Activity;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "params", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/ui/revenuecatui/PaywallPurchaseLogicParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PurchaseLogic extends PaywallPurchaseLogic {
    Object performPurchase(Activity activity, Package r2, Continuation<? super PurchaseLogicResult> continuation);

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.PaywallPurchaseLogic
    default Object performPurchase(Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation<? super PurchaseLogicResult> continuation) {
        return performPurchase$suspendImpl(this, activity, paywallPurchaseLogicParams, continuation);
    }

    /* JADX INFO: compiled from: PurchaseLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Object performPurchase(PurchaseLogic purchaseLogic, Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation<? super PurchaseLogicResult> continuation) {
            return PurchaseLogic.super.performPurchase(activity, paywallPurchaseLogicParams, continuation);
        }
    }

    static /* synthetic */ Object performPurchase$suspendImpl(PurchaseLogic purchaseLogic, Activity activity, PaywallPurchaseLogicParams paywallPurchaseLogicParams, Continuation<? super PurchaseLogicResult> continuation) {
        return purchaseLogic.performPurchase(activity, paywallPurchaseLogicParams.getRcPackage(), continuation);
    }
}
