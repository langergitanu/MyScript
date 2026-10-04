package com.revenuecat.purchases.p036ui.revenuecatui.data;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreReplacementMode;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ProductChangeCalculator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010\rJ \u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeCalculator;", "", "purchases", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PurchasesType;)V", "calculateProductChange", "Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeInfo;", "activePlayStoreSubscription", "Lcom/revenuecat/purchases/SubscriptionInfo;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "productChangeConfig", "Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;", "(Lcom/revenuecat/purchases/SubscriptionInfo;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateProductChangeInfo", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/paywalls/components/common/ProductChangeConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ProductChangeCalculator {
    private static final int MONTHS_IN_HALF_YEAR = 6;
    private static final int MONTHS_IN_QUARTER = 3;
    private static final int MONTHS_IN_YEAR = 12;
    private static final long SANDBOX_HALF_YEAR_MINUTES = 15;
    private static final long SANDBOX_MONTHLY_MINUTES = 5;
    private static final long SANDBOX_QUARTER_MINUTES = 10;
    private static final long SANDBOX_YEARLY_MINUTES = 30;
    private final PurchasesType purchases;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator$calculateProductChange$1 */
    /* JADX INFO: compiled from: ProductChangeCalculator.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator", m1609f = "ProductChangeCalculator.kt", m1610i = {0, 0, 0, 0, 0}, m1611l = {72}, m1612m = "calculateProductChange", m1613n = {"activePlayStoreSubscription", "packageToPurchase", "productChangeConfig", "oldSubscriptionId", "newSubscriptionId"}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C81591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C81591(Continuation<? super C81591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductChangeCalculator.this.calculateProductChange(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator$calculateProductChangeInfo$1 */
    /* JADX INFO: compiled from: ProductChangeCalculator.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator", m1609f = "ProductChangeCalculator.kt", m1610i = {0, 0, 0}, m1611l = {40, 45}, m1612m = "calculateProductChangeInfo", m1613n = {"this", "packageToPurchase", "productChangeConfig"}, m1615s = {"L$0", "L$1", "L$2"})
    static final class C81601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C81601(Continuation<? super C81601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductChangeCalculator.this.calculateProductChangeInfo(null, null, this);
        }
    }

    public ProductChangeCalculator(PurchasesType purchases) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        this.purchases = purchases;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a7, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object calculateProductChangeInfo(Package r9, ProductChangeConfig productChangeConfig, Continuation<? super ProductChangeInfo> continuation) {
        C81601 c81601;
        ProductChangeCalculator productChangeCalculator;
        Object next;
        if (continuation instanceof C81601) {
            c81601 = (C81601) continuation;
            if ((c81601.label & Integer.MIN_VALUE) != 0) {
                c81601.label -= Integer.MIN_VALUE;
            } else {
                c81601 = new C81601(continuation);
            }
        }
        Object objAwaitCustomerInfo$default = c81601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c81601.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAwaitCustomerInfo$default);
                if (r9.getProduct().getType() != ProductType.SUBS) {
                    return null;
                }
                PurchasesType purchasesType = this.purchases;
                c81601.L$0 = this;
                c81601.L$1 = r9;
                c81601.L$2 = productChangeConfig;
                c81601.label = 1;
                objAwaitCustomerInfo$default = PurchasesType.awaitCustomerInfo$default(purchasesType, null, c81601, 1, null);
                if (objAwaitCustomerInfo$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                productChangeCalculator = this;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objAwaitCustomerInfo$default);
                    return (ProductChangeInfo) objAwaitCustomerInfo$default;
                }
                productChangeConfig = (ProductChangeConfig) c81601.L$2;
                r9 = (Package) c81601.L$1;
                productChangeCalculator = (ProductChangeCalculator) c81601.L$0;
                ResultKt.throwOnFailure(objAwaitCustomerInfo$default);
            }
            Iterator<T> it = ((CustomerInfo) objAwaitCustomerInfo$default).getSubscriptionsByProductIdentifier().values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                SubscriptionInfo subscriptionInfo = (SubscriptionInfo) next;
                if (subscriptionInfo.getIsActive() && subscriptionInfo.getStore() == Store.PLAY_STORE) {
                    break;
                }
            }
            SubscriptionInfo subscriptionInfo2 = (SubscriptionInfo) next;
            if (subscriptionInfo2 == null) {
                return null;
            }
            c81601.L$0 = null;
            c81601.L$1 = null;
            c81601.L$2 = null;
            c81601.label = 2;
            objAwaitCustomerInfo$default = productChangeCalculator.calculateProductChange(subscriptionInfo2, r9, productChangeConfig, c81601);
        } catch (PurchasesException e) {
            Logger.INSTANCE.m1584e("Error determining product change info: " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object calculateProductChange(SubscriptionInfo subscriptionInfo, Package r13, ProductChangeConfig productChangeConfig, Continuation<? super ProductChangeInfo> continuation) {
        C81591 c81591;
        String productIdentifier;
        String strComponent1;
        Object objAwaitGetProduct;
        StoreReplacementMode downgradeReplacementMode;
        if (continuation instanceof C81591) {
            c81591 = (C81591) continuation;
            if ((c81591.label & Integer.MIN_VALUE) != 0) {
                c81591.label -= Integer.MIN_VALUE;
            } else {
                c81591 = new C81591(continuation);
            }
        }
        Object obj = c81591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c81591.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            productIdentifier = subscriptionInfo.getProductIdentifier();
            String productPlanIdentifier = subscriptionInfo.getProductPlanIdentifier();
            strComponent1 = INSTANCE.subscriptionIdentifiers$revenuecatui_defaultsRelease(r13.getProduct()).component1();
            if (Intrinsics.areEqual(productIdentifier, strComponent1)) {
                Logger.INSTANCE.m1583d("Same product (" + strComponent1 + "), Google handles base plan change automatically");
                return null;
            }
            PurchasesType purchasesType = this.purchases;
            c81591.L$0 = subscriptionInfo;
            c81591.L$1 = r13;
            c81591.L$2 = productChangeConfig;
            c81591.L$3 = productIdentifier;
            c81591.L$4 = strComponent1;
            c81591.label = 1;
            objAwaitGetProduct = purchasesType.awaitGetProduct(productIdentifier, productPlanIdentifier, c81591);
            if (objAwaitGetProduct == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str = (String) c81591.L$4;
            String str2 = (String) c81591.L$3;
            productChangeConfig = (ProductChangeConfig) c81591.L$2;
            Package r1 = (Package) c81591.L$1;
            SubscriptionInfo subscriptionInfo2 = (SubscriptionInfo) c81591.L$0;
            ResultKt.throwOnFailure(obj);
            strComponent1 = str;
            subscriptionInfo = subscriptionInfo2;
            objAwaitGetProduct = obj;
            productIdentifier = str2;
            r13 = r1;
        }
        StoreProduct storeProduct = (StoreProduct) objAwaitGetProduct;
        boolean isSandbox = subscriptionInfo.getIsSandbox();
        Long normalizedPrice$revenuecatui_defaultsRelease = storeProduct != null ? INSTANCE.getNormalizedPrice$revenuecatui_defaultsRelease(storeProduct, isSandbox) : null;
        Long normalizedPrice$revenuecatui_defaultsRelease2 = INSTANCE.getNormalizedPrice$revenuecatui_defaultsRelease(r13.getProduct(), isSandbox);
        if (normalizedPrice$revenuecatui_defaultsRelease != null && normalizedPrice$revenuecatui_defaultsRelease2 != null && normalizedPrice$revenuecatui_defaultsRelease2.longValue() > normalizedPrice$revenuecatui_defaultsRelease.longValue()) {
            Logger.INSTANCE.m1583d("Detected upgrade: " + productIdentifier + " -> " + strComponent1 + " (old: " + normalizedPrice$revenuecatui_defaultsRelease + ", new: " + normalizedPrice$revenuecatui_defaultsRelease2 + ", sandbox: " + isSandbox + ')');
            downgradeReplacementMode = productChangeConfig.getUpgradeReplacementMode();
        } else {
            Logger.INSTANCE.m1583d("Detected downgrade: " + productIdentifier + " -> " + strComponent1 + " (old: " + normalizedPrice$revenuecatui_defaultsRelease + ", new: " + normalizedPrice$revenuecatui_defaultsRelease2 + ", sandbox: " + isSandbox + ')');
            downgradeReplacementMode = productChangeConfig.getDowngradeReplacementMode();
        }
        return new ProductChangeInfo(productIdentifier, downgradeReplacementMode);
    }

    /* JADX INFO: compiled from: ProductChangeCalculator.kt */
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000fJ#\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0014J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011*\u00020\u0016H\u0000¢\u0006\u0002\b\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/ProductChangeCalculator$Companion;", "", "()V", "MONTHS_IN_HALF_YEAR", "", "MONTHS_IN_QUARTER", "MONTHS_IN_YEAR", "SANDBOX_HALF_YEAR_MINUTES", "", "SANDBOX_MONTHLY_MINUTES", "SANDBOX_QUARTER_MINUTES", "SANDBOX_YEARLY_MINUTES", "getSandboxRenewalMinutes", "period", "Lcom/revenuecat/purchases/models/Period;", "getSandboxRenewalMinutes$revenuecatui_defaultsRelease", "parseProductIdentifier", "Lkotlin/Pair;", "", "productIdentifier", "parseProductIdentifier$revenuecatui_defaultsRelease", "getNormalizedPrice", "Lcom/revenuecat/purchases/models/StoreProduct;", "isSandbox", "", "getNormalizedPrice$revenuecatui_defaultsRelease", "(Lcom/revenuecat/purchases/models/StoreProduct;Z)Ljava/lang/Long;", "subscriptionIdentifiers", "subscriptionIdentifiers$revenuecatui_defaultsRelease", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pair<String, String> parseProductIdentifier$revenuecatui_defaultsRelease(String productIdentifier) {
            Intrinsics.checkNotNullParameter(productIdentifier, "productIdentifier");
            String strSubstringBefore$default = StringsKt.substringBefore$default(productIdentifier, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, (String) null, 2, (Object) null);
            String strSubstringAfter = StringsKt.substringAfter(productIdentifier, Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, "");
            return TuplesKt.m1606to(strSubstringBefore$default, strSubstringAfter.length() > 0 ? strSubstringAfter : null);
        }

        public final Long getNormalizedPrice$revenuecatui_defaultsRelease(StoreProduct storeProduct, boolean z) {
            Intrinsics.checkNotNullParameter(storeProduct, "<this>");
            Period period = storeProduct.getPeriod();
            if (period == null) {
                return null;
            }
            long amountMicros = storeProduct.getPrice().getAmountMicros();
            if (z) {
                return Long.valueOf(amountMicros / getSandboxRenewalMinutes$revenuecatui_defaultsRelease(period));
            }
            Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
            if (pricePricePerMonth$default != null) {
                return Long.valueOf(pricePricePerMonth$default.getAmountMicros());
            }
            return null;
        }

        public final long getSandboxRenewalMinutes$revenuecatui_defaultsRelease(Period period) {
            Intrinsics.checkNotNullParameter(period, "period");
            double valueInMonths = period.getValueInMonths();
            if (valueInMonths >= 12.0d) {
                return ProductChangeCalculator.SANDBOX_YEARLY_MINUTES;
            }
            if (valueInMonths >= 6.0d) {
                return ProductChangeCalculator.SANDBOX_HALF_YEAR_MINUTES;
            }
            if (valueInMonths >= 3.0d) {
                return 10L;
            }
            return ProductChangeCalculator.SANDBOX_MONTHLY_MINUTES;
        }

        public final Pair<String, String> subscriptionIdentifiers$revenuecatui_defaultsRelease(StoreProduct storeProduct) {
            Intrinsics.checkNotNullParameter(storeProduct, "<this>");
            if (!(storeProduct instanceof GoogleStoreProduct)) {
                return parseProductIdentifier$revenuecatui_defaultsRelease(storeProduct.getId());
            }
            GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) storeProduct;
            return TuplesKt.m1606to(googleStoreProduct.getProductId(), googleStoreProduct.getBasePlanId());
        }
    }
}
