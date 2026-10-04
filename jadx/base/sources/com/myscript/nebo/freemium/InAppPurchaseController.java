package com.myscript.nebo.freemium;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.media3.common.MimeTypes;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientKotlinKt;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResult;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment;
import com.myscript.nebo.freemium.PurchaseController;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: compiled from: InAppPurchaseController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001#\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020/2\u0006\u0010+\u001a\u00020,H\u0002J\u0018\u00100\u001a\u0004\u0018\u0001012\u0006\u0010+\u001a\u00020,H\u0082@¢\u0006\u0002\u0010-J\u0010\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u0012H\u0016J\u0010\u00104\u001a\u00020&2\u0006\u00103\u001a\u00020\u0012H\u0016J\u0010\u00105\u001a\u00020&2\u0006\u00103\u001a\u00020\u0014H\u0016J\u0010\u00106\u001a\u00020&2\u0006\u00103\u001a\u00020\u0014H\u0016J\u001e\u00107\u001a\u00020\u00182\u0006\u0010+\u001a\u00020,2\u0006\u00108\u001a\u000209H\u0096@¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020<H\u0082@¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020&H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006?"}, m1599d2 = {"Lcom/myscript/nebo/freemium/InAppPurchaseController;", "Lcom/myscript/nebo/freemium/PurchaseController;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "workDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroid/app/Application;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getWorkDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "parentJob", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "purchaseControllerStateListeners", "", "Lcom/myscript/nebo/freemium/PurchaseController$StateListener;", "purchaseListeners", "Lcom/myscript/nebo/freemium/PurchaseController$PurchaseListener;", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "value", "", "isBillingClientConnected", "()Z", "isAppInForeground", "params", "Lcom/android/billingclient/api/PendingPurchasesParams;", "getParams", "()Lcom/android/billingclient/api/PendingPurchasesParams;", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "lifecycleObserver", "com/myscript/nebo/freemium/InAppPurchaseController$lifecycleObserver$1", "Lcom/myscript/nebo/freemium/InAppPurchaseController$lifecycleObserver$1;", "connect", "", CloudTokenInvalidDialogFragment.ACTION_DISCONNECT, "isConnected", "getFormattedPrice", "", "product", "Lcom/myscript/nebo/freemium/InAppProduct;", "(Lcom/myscript/nebo/freemium/InAppProduct;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryProductDetailsParams", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "queryProductDetails", "Lcom/android/billingclient/api/ProductDetails;", "addStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeStateListener", "addPurchaseListener", "removePurchaseListener", FirebaseAnalytics.Event.PURCHASE, "activity", "Landroid/app/Activity;", "(Lcom/myscript/nebo/freemium/InAppProduct;Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPreviousPurchases", "Lcom/android/billingclient/api/PurchasesResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPreviousPurchasesState", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InAppPurchaseController implements PurchaseController {
    public static final int $stable = 8;
    private final BillingClient billingClient;
    private boolean isAppInForeground;
    private boolean isBillingClientConnected;
    private final InAppPurchaseController$lifecycleObserver$1 lifecycleObserver;
    private final TechnicalLogger logger;
    private final PendingPurchasesParams params;
    private CompletableJob parentJob;
    private final Set<PurchaseController.StateListener> purchaseControllerStateListeners;
    private final Set<PurchaseController.PurchaseListener> purchaseListeners;
    private final PurchasesUpdatedListener purchasesUpdatedListener;
    private final CoroutineScope scope;
    private final CoroutineDispatcher workDispatcher;

    /* JADX INFO: renamed from: com.myscript.nebo.freemium.InAppPurchaseController$getFormattedPrice$1 */
    /* JADX INFO: compiled from: InAppPurchaseController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.freemium.InAppPurchaseController", m1609f = "InAppPurchaseController.kt", m1610i = {0}, m1611l = {211}, m1612m = "getFormattedPrice", m1613n = {"product"}, m1614nl = {212}, m1615s = {"L$0"}, m1616v = 2)
    static final class C64681 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C64681(Continuation<? super C64681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppPurchaseController.this.getFormattedPrice(null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.freemium.InAppPurchaseController$purchase$1 */
    /* JADX INFO: compiled from: InAppPurchaseController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.freemium.InAppPurchaseController", m1609f = "InAppPurchaseController.kt", m1610i = {0, 0}, m1611l = {249}, m1612m = FirebaseAnalytics.Event.PURCHASE, m1613n = {"product", "activity"}, m1614nl = {PDFACompliance.e_PDFA2_5_1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C64691 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C64691(Continuation<? super C64691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppPurchaseController.this.purchase(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.freemium.InAppPurchaseController$queryProductDetails$1 */
    /* JADX INFO: compiled from: InAppPurchaseController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.freemium.InAppPurchaseController", m1609f = "InAppPurchaseController.kt", m1610i = {0}, m1611l = {228}, m1612m = "queryProductDetails", m1613n = {"product"}, m1614nl = {229}, m1615s = {"L$0"}, m1616v = 2)
    static final class C64701 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C64701(Continuation<? super C64701> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppPurchaseController.this.queryProductDetails(null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InAppPurchaseController(Application application) {
        this(application, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.myscript.nebo.freemium.InAppPurchaseController$lifecycleObserver$1] */
    public InAppPurchaseController(Application application, CoroutineDispatcher workDispatcher) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(workDispatcher, "workDispatcher");
        this.workDispatcher = workDispatcher;
        CompletableJob completableJobJob$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.parentJob = completableJobJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(completableJobJob$default.plus(workDispatcher));
        TechnicalLoggerProvider technicalLoggerProvider = application instanceof TechnicalLoggerProvider ? (TechnicalLoggerProvider) application : null;
        this.logger = technicalLoggerProvider != null ? technicalLoggerProvider.provideTechnicalLogger() : null;
        this.purchaseControllerStateListeners = new LinkedHashSet();
        this.purchaseListeners = new LinkedHashSet();
        PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.myscript.nebo.freemium.InAppPurchaseController$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                InAppPurchaseController.purchasesUpdatedListener$lambda$0(this.f$0, billingResult, list);
            }
        };
        this.purchasesUpdatedListener = purchasesUpdatedListener;
        this.isAppInForeground = true;
        PendingPurchasesParams pendingPurchasesParamsBuild = PendingPurchasesParams.newBuilder().enableOneTimeProducts().build();
        Intrinsics.checkNotNullExpressionValue(pendingPurchasesParamsBuild, "build(...)");
        this.params = pendingPurchasesParamsBuild;
        BillingClient billingClientBuild = BillingClient.newBuilder(application).enablePendingPurchases(pendingPurchasesParamsBuild).setListener(purchasesUpdatedListener).build();
        Intrinsics.checkNotNullExpressionValue(billingClientBuild, "build(...)");
        this.billingClient = billingClientBuild;
        ?? r4 = new DefaultLifecycleObserver() { // from class: com.myscript.nebo.freemium.InAppPurchaseController$lifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ void onCreate(LifecycleOwner lifecycleOwner) {
                super.onCreate(lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ void onDestroy(LifecycleOwner lifecycleOwner) {
                super.onDestroy(lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ void onPause(LifecycleOwner lifecycleOwner) {
                super.onPause(lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
                super.onResume(lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onStart(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                super.onStart(owner);
                this.this$0.isAppInForeground = true;
                int connectionState = this.this$0.billingClient.getConnectionState();
                if (connectionState == 0 || connectionState == 3) {
                    this.this$0.connect();
                }
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onStop(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                super.onStop(owner);
                this.this$0.isAppInForeground = false;
            }
        };
        this.lifecycleObserver = r4;
        ProcessLifecycleOwner.INSTANCE.get().getLifecycleRegistry().addObserver((LifecycleObserver) r4);
    }

    public /* synthetic */ InAppPurchaseController(Application application, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final CoroutineDispatcher getWorkDispatcher() {
        return this.workDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void purchasesUpdatedListener$lambda$0(InAppPurchaseController inAppPurchaseController, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(billingResult, "<unused var>");
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                if (purchase.getPurchaseState() == 1) {
                    List<String> products = purchase.getProducts();
                    Intrinsics.checkNotNullExpressionValue(products, "getProducts(...)");
                    for (String str : products) {
                        Intrinsics.checkNotNull(str);
                        InAppProduct inAppProductProductFromProductId = InAppPurchaseControllerKt.productFromProductId(str);
                        if (inAppProductProductFromProductId != null) {
                            for (PurchaseController.PurchaseListener purchaseListener : inAppPurchaseController.purchaseListeners) {
                                String packageName = purchase.getPackageName();
                                Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                                String purchaseToken = purchase.getPurchaseToken();
                                Intrinsics.checkNotNullExpressionValue(purchaseToken, "getPurchaseToken(...)");
                                purchaseListener.onProductPurchased(inAppProductProductFromProductId, packageName, purchaseToken);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: isBillingClientConnected, reason: from getter */
    public final boolean getIsBillingClientConnected() {
        return this.isBillingClientConnected;
    }

    public final PendingPurchasesParams getParams() {
        return this.params;
    }

    @Override // com.myscript.nebo.freemium.PurchaseController
    public void connect() {
        try {
            this.billingClient.startConnection(new BillingClientStateListener() { // from class: com.myscript.nebo.freemium.InAppPurchaseController.connect.1
                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingSetupFinished(BillingResult billingResult) {
                    Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                    BuildersKt__Builders_commonKt.launch$default(InAppPurchaseController.this.scope, null, null, new InAppPurchaseController$connect$1$onBillingSetupFinished$1(InAppPurchaseController.this, billingResult, null), 3, null);
                }

                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingServiceDisconnected() {
                    InAppPurchaseController.this.isBillingClientConnected = false;
                    Iterator it = InAppPurchaseController.this.purchaseControllerStateListeners.iterator();
                    while (it.hasNext()) {
                        ((PurchaseController.StateListener) it.next()).onPurchaseControllerStateChanged(false);
                    }
                    if (InAppPurchaseController.this.isAppInForeground) {
                        InAppPurchaseController.this.connect();
                    }
                }
            });
        } catch (Exception e) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger != null) {
                technicalLogger.logError(e);
            }
        }
    }

    @Override // com.myscript.nebo.freemium.PurchaseController
    public void disconnect() {
        this.billingClient.endConnection();
    }

    @Override // com.myscript.nebo.freemium.PurchaseController
    public boolean isConnected() {
        return this.isBillingClientConnected;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.freemium.PurchaseController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getFormattedPrice(InAppProduct inAppProduct, Continuation<? super String> continuation) {
        C64681 c64681;
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
        String formattedPrice;
        if (continuation instanceof C64681) {
            c64681 = (C64681) continuation;
            if ((c64681.label & Integer.MIN_VALUE) != 0) {
                c64681.label -= Integer.MIN_VALUE;
            } else {
                c64681 = new C64681(continuation);
            }
        }
        Object objQueryProductDetails = c64681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c64681.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryProductDetails);
            c64681.L$0 = SpillingKt.nullOutSpilledVariable(inAppProduct);
            c64681.label = 1;
            objQueryProductDetails = queryProductDetails(inAppProduct, c64681);
            if (objQueryProductDetails == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryProductDetails);
        }
        ProductDetails productDetails = (ProductDetails) objQueryProductDetails;
        return (productDetails == null || (oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails()) == null || (formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice()) == null) ? "" : formattedPrice;
    }

    private final QueryProductDetailsParams queryProductDetailsParams(InAppProduct product) {
        QueryProductDetailsParams queryProductDetailsParamsBuild = QueryProductDetailsParams.newBuilder().setProductList(CollectionsKt.listOf(QueryProductDetailsParams.Product.newBuilder().setProductId(product.getId()).setProductType("inapp").build())).build();
        Intrinsics.checkNotNullExpressionValue(queryProductDetailsParamsBuild, "build(...)");
        return queryProductDetailsParamsBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object queryProductDetails(InAppProduct inAppProduct, Continuation<? super ProductDetails> continuation) {
        C64701 c64701;
        ProductDetails productDetails;
        if (continuation instanceof C64701) {
            c64701 = (C64701) continuation;
            if ((c64701.label & Integer.MIN_VALUE) != 0) {
                c64701.label -= Integer.MIN_VALUE;
            } else {
                c64701 = new C64701(continuation);
            }
        }
        Object objQueryProductDetails = c64701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c64701.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryProductDetails);
            BillingClient billingClient = this.billingClient;
            QueryProductDetailsParams queryProductDetailsParams = queryProductDetailsParams(inAppProduct);
            c64701.L$0 = SpillingKt.nullOutSpilledVariable(inAppProduct);
            c64701.label = 1;
            objQueryProductDetails = BillingClientKotlinKt.queryProductDetails(billingClient, queryProductDetailsParams, c64701);
            if (objQueryProductDetails == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objQueryProductDetails);
        }
        ProductDetailsResult productDetailsResult = (ProductDetailsResult) objQueryProductDetails;
        List<ProductDetails> productDetailsList = productDetailsResult.getProductDetailsList();
        if (productDetailsList == null || (productDetails = (ProductDetails) CollectionsKt.firstOrNull((List) productDetailsList)) == null || productDetailsResult.getBillingResult().getResponseCode() != 0) {
            return null;
        }
        return productDetails;
    }

    @Override // com.myscript.nebo.freemium.PurchaseController
    public void addStateListener(PurchaseController.StateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchaseControllerStateListeners.add(listener);
    }

    @Override // com.myscript.nebo.freemium.PurchaseController
    public void removeStateListener(PurchaseController.StateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchaseControllerStateListeners.remove(listener);
    }

    @Override // com.myscript.nebo.freemium.PurchaseController
    public void addPurchaseListener(PurchaseController.PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchaseListeners.add(listener);
    }

    @Override // com.myscript.nebo.freemium.PurchaseController
    public void removePurchaseListener(PurchaseController.PurchaseListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.purchaseListeners.remove(listener);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.myscript.nebo.freemium.PurchaseController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object purchase(InAppProduct inAppProduct, Activity activity, Continuation<? super Boolean> continuation) {
        C64691 c64691;
        BillingFlowParams.ProductDetailsParams productDetailsParamsBuild;
        if (continuation instanceof C64691) {
            c64691 = (C64691) continuation;
            if ((c64691.label & Integer.MIN_VALUE) != 0) {
                c64691.label -= Integer.MIN_VALUE;
            } else {
                c64691 = new C64691(continuation);
            }
        }
        Object objQueryProductDetails = c64691.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c64691.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objQueryProductDetails);
            c64691.L$0 = SpillingKt.nullOutSpilledVariable(inAppProduct);
            c64691.L$1 = activity;
            c64691.label = 1;
            objQueryProductDetails = queryProductDetails(inAppProduct, c64691);
            if (objQueryProductDetails == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            activity = (Activity) c64691.L$1;
            ResultKt.throwOnFailure(objQueryProductDetails);
        }
        ProductDetails productDetails = (ProductDetails) objQueryProductDetails;
        if (productDetails == null) {
            return Boxing.boxBoolean(false);
        }
        try {
            productDetailsParamsBuild = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).build();
        } catch (NullPointerException e) {
            TechnicalLogger technicalLogger = this.logger;
            if (technicalLogger != null) {
                technicalLogger.logError(e);
            }
            try {
                productDetailsParamsBuild = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails).setOfferToken("{}").build();
            } catch (Exception e2) {
                TechnicalLogger technicalLogger2 = this.logger;
                if (technicalLogger2 != null) {
                    technicalLogger2.logError(e2);
                }
                e2.getMessage();
                return Boxing.boxBoolean(false);
            }
        }
        Intrinsics.checkNotNull(productDetailsParamsBuild);
        BillingFlowParams billingFlowParamsBuild = BillingFlowParams.newBuilder().setProductDetailsParamsList(CollectionsKt.listOf(productDetailsParamsBuild)).build();
        Intrinsics.checkNotNullExpressionValue(billingFlowParamsBuild, "build(...)");
        BillingResult billingResultLaunchBillingFlow = this.billingClient.launchBillingFlow(activity, billingFlowParamsBuild);
        Intrinsics.checkNotNullExpressionValue(billingResultLaunchBillingFlow, "launchBillingFlow(...)");
        return Boxing.boxBoolean(billingResultLaunchBillingFlow.getResponseCode() == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getPreviousPurchases(Continuation<? super PurchasesResult> continuation) {
        QueryPurchasesParams queryPurchasesParamsBuild = QueryPurchasesParams.newBuilder().setProductType("inapp").build();
        Intrinsics.checkNotNullExpressionValue(queryPurchasesParamsBuild, "build(...)");
        return BillingClientKotlinKt.queryPurchasesAsync(this.billingClient, queryPurchasesParamsBuild, continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.freemium.InAppPurchaseController$fetchPreviousPurchasesState$1 */
    /* JADX INFO: compiled from: InAppPurchaseController.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.freemium.InAppPurchaseController$fetchPreviousPurchasesState$1", m1609f = "InAppPurchaseController.kt", m1610i = {}, m1611l = {293}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {294}, m1615s = {}, m1616v = 2)
    static final class C64671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C64671(Continuation<? super C64671> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InAppPurchaseController.this.new C64671(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C64671) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = InAppPurchaseController.this.getPreviousPurchases(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List<Purchase> purchasesList = ((PurchasesResult) obj).getPurchasesList();
            InAppPurchaseController inAppPurchaseController = InAppPurchaseController.this;
            for (Purchase purchase : purchasesList) {
                List<String> products = purchase.getProducts();
                Intrinsics.checkNotNullExpressionValue(products, "getProducts(...)");
                for (String str : products) {
                    Intrinsics.checkNotNull(str);
                    InAppProduct inAppProductProductFromProductId = InAppPurchaseControllerKt.productFromProductId(str);
                    if (inAppProductProductFromProductId != null && purchase.getPurchaseState() == 1) {
                        for (PurchaseController.PurchaseListener purchaseListener : inAppPurchaseController.purchaseListeners) {
                            String packageName = purchase.getPackageName();
                            Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
                            String purchaseToken = purchase.getPurchaseToken();
                            Intrinsics.checkNotNullExpressionValue(purchaseToken, "getPurchaseToken(...)");
                            purchaseListener.onProductPurchased(inAppProductProductFromProductId, packageName, purchaseToken);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.nebo.freemium.PurchaseController
    public void fetchPreviousPurchasesState() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C64671(null), 3, null);
    }
}
