package com.revenuecat.purchases.p036ui.revenuecatui.data;

import androidx.core.app.NotificationCompat;
import com.revenuecat.purchases.CacheFetchPolicy;
import com.revenuecat.purchases.CoroutinesExtensionsCommonKt;
import com.revenuecat.purchases.CoroutinesExtensionsKt;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.PurchasesTransactionException;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowResolution;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleStoreProductKt;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchasesType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\"\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0002\u0010\u001dJ\u000e\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010 J\u000e\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010 J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u00101J\u000e\u00102\u001a\u000203H\u0096@¢\u0006\u0002\u0010 J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0096@¢\u0006\u0002\u00108J\u000e\u00109\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010 J\u000e\u0010:\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010 J\b\u0010;\u001a\u00020<H\u0016J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u00101J\u0010\u0010@\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\b¨\u0006C"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesImpl;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "purchases", "Lcom/revenuecat/purchases/Purchases;", "(Lcom/revenuecat/purchases/Purchases;)V", "appUserID", "", "getAppUserID", "()Ljava/lang/String;", "customerCenterListener", "Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "getCustomerCenterListener", "()Lcom/revenuecat/purchases/customercenter/CustomerCenterListener;", "preferredUILocaleOverride", "getPreferredUILocaleOverride", "purchasesAreCompletedBy", "Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "getPurchasesAreCompletedBy", "()Lcom/revenuecat/purchases/PurchasesAreCompletedBy;", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "storefrontCountryCode", "getStorefrontCountryCode", "awaitCreateSupportTicket", "Lcom/revenuecat/purchases/CreateSupportTicketResult;", "email", "description", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerCenterConfigData", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitGetProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "basePlan", "awaitGetUiConfig", "Lcom/revenuecat/purchases/UiConfig;", "awaitGetVirtualCurrencies", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "awaitGetWorkflow", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "workflowId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRestore", "awaitSyncPurchases", "invalidateVirtualCurrenciesCache", "", "resolveWorkflow", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "offeringId", "track", NotificationCompat.CATEGORY_EVENT, "Lcom/revenuecat/purchases/common/events/FeatureEvent;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PurchasesImpl implements PurchasesType {
    public static final int $stable = 8;
    private final Purchases purchases;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl$awaitGetProduct$1 */
    /* JADX INFO: compiled from: PurchasesType.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl", m1609f = "PurchasesType.kt", m1610i = {0}, m1611l = {111}, m1612m = "awaitGetProduct", m1613n = {"basePlan"}, m1615s = {"L$0"})
    static final class C81611 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C81611(Continuation<? super C81611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PurchasesImpl.this.awaitGetProduct(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PurchasesImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public PurchasesImpl(Purchases purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
    }

    public /* synthetic */ PurchasesImpl(Purchases purchases, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Purchases.INSTANCE.getSharedInstance() : purchases);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public String getAppUserID() {
        return this.purchases.getAppUserID();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitPurchase(PurchaseParams.Builder builder, Continuation<? super PurchaseResult> continuation) {
        return CoroutinesExtensionsCommonKt.awaitPurchase(this.purchases, builder.build(), continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitRestore(Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsCommonKt.awaitRestore(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitOfferings(Continuation<? super Offerings> continuation) {
        return CoroutinesExtensionsCommonKt.awaitOfferings(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerInfo(CacheFetchPolicy cacheFetchPolicy, Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsKt.awaitCustomerInfo(this.purchases, cacheFetchPolicy, continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitCustomerCenterConfigData(Continuation<? super CustomerCenterConfigData> continuation) {
        return CoroutinesExtensionsKt.awaitCustomerCenterConfigData(this.purchases, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object awaitGetProduct(String str, String str2, Continuation<? super StoreProduct> continuation) throws PurchasesTransactionException {
        C81611 c81611;
        Object obj;
        if (continuation instanceof C81611) {
            c81611 = (C81611) continuation;
            if ((c81611.label & Integer.MIN_VALUE) != 0) {
                c81611.label -= Integer.MIN_VALUE;
            } else {
                c81611 = new C81611(continuation);
            }
        }
        C81611 c816112 = c81611;
        Object objAwaitGetProducts$default = c816112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c816112.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitGetProducts$default);
            Purchases purchases = this.purchases;
            List listListOf = CollectionsKt.listOf(str);
            c816112.L$0 = str2;
            c816112.label = 1;
            objAwaitGetProducts$default = CoroutinesExtensionsCommonKt.awaitGetProducts$default(purchases, listListOf, null, c816112, 2, null);
            if (objAwaitGetProducts$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str2 = (String) c816112.L$0;
            ResultKt.throwOnFailure(objAwaitGetProducts$default);
        }
        List list = (List) objAwaitGetProducts$default;
        if (str2 == null) {
            return (StoreProduct) CollectionsKt.firstOrNull(list);
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GoogleStoreProduct googleProduct = GoogleStoreProductKt.getGoogleProduct((StoreProduct) next);
            if (Intrinsics.areEqual(googleProduct != null ? googleProduct.getBasePlanId() : null, str2)) {
                obj = next;
                break;
            }
        }
        return (StoreProduct) obj;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitGetVirtualCurrencies(Continuation<? super VirtualCurrencies> continuation) throws PurchasesException {
        return CoroutinesExtensionsKt.awaitGetVirtualCurrencies(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public void invalidateVirtualCurrenciesCache() {
        this.purchases.invalidateVirtualCurrenciesCache();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public void track(FeatureEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.purchases.track(event);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitSyncPurchases(Continuation<? super CustomerInfo> continuation) {
        return CoroutinesExtensionsKt.awaitSyncPurchases(this.purchases, continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public PurchasesAreCompletedBy getPurchasesAreCompletedBy() {
        return this.purchases.getPurchasesAreCompletedBy();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public String getStorefrontCountryCode() {
        return this.purchases.getStorefrontCountryCode();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Store getStore() {
        return this.purchases.getStore();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public CustomerCenterListener getCustomerCenterListener() {
        return this.purchases.getCustomerCenterListener();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public String getPreferredUILocaleOverride() {
        return this.purchases.getPreferredUILocaleOverride();
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitCreateSupportTicket(String str, String str2, Continuation<? super CreateSupportTicketResult> continuation) throws PurchasesException {
        return CoroutinesExtensionsKt.awaitCreateSupportTicket(this.purchases, str, str2, continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitGetWorkflow(String str, Continuation<? super PublishedWorkflow> continuation) throws PurchasesException {
        return this.purchases.awaitGetWorkflow(str, continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object awaitGetUiConfig(Continuation<? super UiConfig> continuation) throws PurchasesException {
        return this.purchases.awaitGetUiConfig(continuation);
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.data.PurchasesType
    public Object resolveWorkflow(String str, Continuation<? super WorkflowResolution> continuation) {
        return this.purchases.resolveWorkflow(str, continuation);
    }
}
