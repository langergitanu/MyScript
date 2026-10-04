package com.revenuecat.purchases.p036ui.revenuecatui.data;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowResolution;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: PurchasesType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u001cH¦@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H¦@¢\u0006\u0002\u0010\"J\"\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\u001aJ\u000e\u0010'\u001a\u00020(H¦@¢\u0006\u0002\u0010\u001dJ\u000e\u0010)\u001a\u00020*H¦@¢\u0006\u0002\u0010\u001dJ\u0016\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u000200H¦@¢\u0006\u0002\u0010\u001dJ\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H¦@¢\u0006\u0002\u00105J\u000e\u00106\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010\u001dJ\u000e\u00107\u001a\u00020\u001fH¦@¢\u0006\u0002\u0010\u001dJ\b\u00108\u001a\u000209H&J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010.J\u0010\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020?H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005¨\u0006@À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "", "appUserID", "", "getAppUserID", "()Ljava/lang/String;", "customerCenterListener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "preferredUILocaleOverride", "getPreferredUILocaleOverride", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "storefrontCountryCode", "getStorefrontCountryCode", "awaitCreateSupportTicket", "Lcom/revenuecat/purchases/CreateSupportTicketResult;", "email", "description", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "basePlan", "awaitGetUiConfig", "Lcom/revenuecat/purchases/UiConfig;", "awaitGetVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitGetWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "workflowId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRestore", "awaitSyncPurchases", "invalidateVirtualCurrenciesCache", "", "resolveWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "offeringId", "track", NotificationCompat.CATEGORY_EVENT, "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PurchasesType {
    Object awaitCreateSupportTicket(String str, String str2, Continuation<? super CreateSupportTicketResult> continuation) throws PurchasesException;

    Object awaitCustomerCenterConfigData(Continuation<? super CustomerCenterConfigData> continuation);

    Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation<? super CustomerInfo> continuation);

    Object awaitGetProduct(String str, String str2, Continuation<? super StoreProduct> continuation);

    Object awaitGetUiConfig(Continuation<? super UiConfig> continuation) throws PurchasesException;

    Object awaitGetVirtualCurrencies(Continuation<? super VirtualCurrencies> continuation) throws PurchasesException;

    Object awaitGetWorkflow(String str, Continuation<? super PublishedWorkflow> continuation) throws PurchasesException;

    Object awaitOfferings(Continuation<? super Offerings> continuation);

    Object awaitPurchase(PurchaseParams.Builder builder, Continuation<? super PurchaseResult> continuation);

    Object awaitRestore(Continuation<? super CustomerInfo> continuation);

    Object awaitSyncPurchases(Continuation<? super CustomerInfo> continuation);

    String getAppUserID();

    CustomerCenterListener getCustomerCenterListener();

    String getPreferredUILocaleOverride();

    PurchasesAreCompletedBy getPurchasesAreCompletedBy();

    Store getStore();

    String getStorefrontCountryCode();

    void invalidateVirtualCurrenciesCache();

    Object resolveWorkflow(String str, Continuation<? super WorkflowResolution> continuation);

    void track(FeatureEvent event);

    /* JADX INFO: compiled from: PurchasesType.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object awaitCustomerInfo$default(PurchasesType purchasesType, CacheFetchPolicy cacheFetchPolicy, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitCustomerInfo");
        }
        if ((i & 1) != 0) {
            cacheFetchPolicy = CacheFetchPolicy.INSTANCE.m13621default();
        }
        return purchasesType.awaitCustomerInfo(cacheFetchPolicy, continuation);
    }
}
