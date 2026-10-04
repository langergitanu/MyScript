package com.myscript.nebo.freemium;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: InAppPurchaseController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\u0003H&¨\u0006\u001bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/PurchaseController;", "", "connect", "", CloudTokenInvalidDialogFragment.ACTION_DISCONNECT, "isConnected", "", FirebaseAnalytics.Event.PURCHASE, "product", "Lcom/myscript/nebo/freemium/InAppProduct;", "activity", "Landroid/app/Activity;", "(Lcom/myscript/nebo/freemium/InAppProduct;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFormattedPrice", "", "(Lcom/myscript/nebo/freemium/InAppProduct;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/freemium/PurchaseController$StateListener;", "removeStateListener", "addPurchaseListener", "Lcom/myscript/nebo/freemium/PurchaseController$PurchaseListener;", "removePurchaseListener", "fetchPreviousPurchasesState", "Provider", "StateListener", "PurchaseListener", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface PurchaseController {

    /* JADX INFO: compiled from: InAppPurchaseController.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/PurchaseController$Provider;", "", "providePurchaseController", "Lcom/myscript/nebo/freemium/PurchaseController;", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        PurchaseController providePurchaseController();
    }

    /* JADX INFO: compiled from: InAppPurchaseController.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/PurchaseController$PurchaseListener;", "", "onProductPurchased", "", "product", "Lcom/myscript/nebo/freemium/InAppProduct;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "purchaseToken", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface PurchaseListener {
        void onProductPurchased(InAppProduct product, String packageName, String purchaseToken);
    }

    /* JADX INFO: compiled from: InAppPurchaseController.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/PurchaseController$StateListener;", "", "onPurchaseControllerStateChanged", "", "connected", "", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface StateListener {
        void onPurchaseControllerStateChanged(boolean connected);
    }

    void addPurchaseListener(PurchaseListener listener);

    void addStateListener(StateListener listener);

    void connect();

    void disconnect();

    void fetchPreviousPurchasesState();

    Object getFormattedPrice(InAppProduct inAppProduct, Continuation<? super String> continuation);

    boolean isConnected();

    Object purchase(InAppProduct inAppProduct, Activity activity, Continuation<? super Boolean> continuation);

    void removePurchaseListener(PurchaseListener listener);

    void removeStateListener(StateListener listener);
}
