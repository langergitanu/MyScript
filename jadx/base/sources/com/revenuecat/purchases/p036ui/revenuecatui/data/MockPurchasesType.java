package com.revenuecat.purchases.p036ui.revenuecatui.data;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
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
import kotlin.NotImplementedError;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MockPurchasesType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\"\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0096@¢\u0006\u0002\u0010\u001bJ\u000e\u0010(\u001a\u00020)H\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u000201H\u0096@¢\u0006\u0002\u0010\u001eJ\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0096@¢\u0006\u0002\u00106J\u000e\u00107\u001a\u00020 H\u0096@¢\u0006\u0002\u0010\u001eJ\u000e\u00108\u001a\u00020 H\u0096@¢\u0006\u0002\u0010\u001eJ\b\u00109\u001a\u00020:H\u0016J\u0016\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010/J\u0010\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020@H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006A"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/MockPurchasesType;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "appUserID", "", "preferredUILocaleOverride", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "storefrontCountryCode", "store", "Lcom/revenuecat/purchases/Store;", "customerCenterListener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/PurchasesAreCompletedBy;Ljava/lang/String;Lcom/revenuecat/purchases/Store;Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;)V", "getAppUserID", "()Ljava/lang/String;", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "getPreferredUILocaleOverride", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getStore", "()Lcom/revenuecat/purchases/Store;", "getStorefrontCountryCode", "awaitCreateSupportTicket", "Lcom/revenuecat/purchases/CreateSupportTicketResult;", "email", "description", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "basePlan", "awaitGetUiConfig", "Lcom/revenuecat/purchases/UiConfig;", "awaitGetVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitGetWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "workflowId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRestore", "awaitSyncPurchases", "invalidateVirtualCurrenciesCache", "", "resolveWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "offeringId", "track", NotificationCompat.CATEGORY_EVENT, "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class MockPurchasesType implements PurchasesType {
    public static final int $stable = 8;
    private final String appUserID;
    private final CustomerCenterListener customerCenterListener;
    private final String preferredUILocaleOverride;
    private final PurchasesAreCompletedBy purchasesAreCompletedBy;
    private final Store store;
    private final String storefrontCountryCode;

    public MockPurchasesType() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public void invalidateVirtualCurrenciesCache() {
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
    }

    public MockPurchasesType(String appUserID, String str, PurchasesAreCompletedBy purchasesAreCompletedBy, String str2, Store store, CustomerCenterListener customerCenterListener) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(purchasesAreCompletedBy, "purchasesAreCompletedBy");
        Intrinsics.checkNotNullParameter(store, "store");
        this.appUserID = appUserID;
        this.preferredUILocaleOverride = str;
        this.purchasesAreCompletedBy = purchasesAreCompletedBy;
        this.storefrontCountryCode = str2;
        this.store = store;
        this.customerCenterListener = customerCenterListener;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ MockPurchasesType(java.lang.String r2, java.lang.String r3, com.revenuecat.purchases.PurchasesAreCompletedBy r4, java.lang.String r5, com.revenuecat.purchases.Store r6, com.revenuecat.purchases.customercenter.CustomerCenterListener r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            java.lang.String r2 = ""
        L6:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lc
            r3 = r0
        Lc:
            r9 = r8 & 4
            if (r9 == 0) goto L12
            com.revenuecat.purchases.PurchasesAreCompletedBy r4 = com.revenuecat.purchases.PurchasesAreCompletedBy.REVENUECAT
        L12:
            r9 = r8 & 8
            if (r9 == 0) goto L17
            r5 = r0
        L17:
            r9 = r8 & 16
            if (r9 == 0) goto L1d
            com.revenuecat.purchases.Store r6 = com.revenuecat.purchases.Store.PLAY_STORE
        L1d:
            r8 = r8 & 32
            if (r8 == 0) goto L29
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L30
        L29:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L30:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.p036ui.revenuecatui.data.MockPurchasesType.<init>(java.lang.String, java.lang.String, com.revenuecat.purchases.PurchasesAreCompletedBy, java.lang.String, com.revenuecat.purchases.Store, com.revenuecat.purchases.customercenter.CustomerCenterListener, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public String getAppUserID() {
        return this.appUserID;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public String getPreferredUILocaleOverride() {
        return this.preferredUILocaleOverride;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchasesAreCompletedBy;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public String getStorefrontCountryCode() {
        return this.storefrontCountryCode;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Store getStore() {
        return this.store;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public CustomerCenterListener getCustomerCenterListener() {
        return this.customerCenterListener;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitPurchase(PurchaseParams.Builder builder, Continuation<? super PurchaseResult> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitRestore(Continuation<? super CustomerInfo> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitOfferings(Continuation<? super Offerings> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation<? super CustomerInfo> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerCenterConfigData(Continuation<? super CustomerCenterConfigData> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitGetProduct(String str, String str2, Continuation<? super StoreProduct> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitGetVirtualCurrencies(Continuation<? super VirtualCurrencies> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitSyncPurchases(Continuation<? super CustomerInfo> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitCreateSupportTicket(String str, String str2, Continuation<? super CreateSupportTicketResult> continuation) {
        return new CreateSupportTicketResult(true);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitGetWorkflow(String str, Continuation<? super PublishedWorkflow> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitGetUiConfig(Continuation<? super UiConfig> continuation) {
        throw new NotImplementedError("Mock implementation for previews only");
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object resolveWorkflow(String str, Continuation<? super WorkflowResolution> continuation) {
        return WorkflowResolution.NoWorkflow.INSTANCE;
    }
}
