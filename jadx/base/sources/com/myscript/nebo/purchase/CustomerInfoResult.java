package com.myscript.nebo.purchase;

import com.revenuecat.purchases.PeriodType;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IPurchaseProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010/\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u00105\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0013HÆ\u0003J¨\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0013HÆ\u0001¢\u0006\u0002\u00107J\u0014\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020;HÖ\u0081\u0004J\n\u0010<\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\"\u0010 R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006="}, m1599d2 = {"Lcom/myscript/nebo/purchase/CustomerInfoResult;", "", "hasSubscribed", "", "isTrialPeriod", "periodType", "Lcom/revenuecat/purchases/PeriodType;", "activeSubscriptions", "", "", "willRenew", "unsubscribeDetectedAtMs", "", "expirationDateMs", "originalPurchaseDateMs", "latestPurchaseDateMs", "productIdentifier", "productPlanIdentifier", "purchaseDatesByProductMs", "", "<init>", "(ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Set;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getHasSubscribed", "()Z", "getPeriodType", "()Lcom/revenuecat/purchases/PeriodType;", "getActiveSubscriptions", "()Ljava/util/Set;", "getWillRenew", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUnsubscribeDetectedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpirationDateMs", "getOriginalPurchaseDateMs", "getLatestPurchaseDateMs", "getProductIdentifier", "()Ljava/lang/String;", "getProductPlanIdentifier", "getPurchaseDatesByProductMs", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Set;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/myscript/nebo/purchase/CustomerInfoResult;", "equals", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class CustomerInfoResult {
    public static final int $stable = 8;
    private final Set<String> activeSubscriptions;
    private final Long expirationDateMs;
    private final boolean hasSubscribed;
    private final boolean isTrialPeriod;
    private final Long latestPurchaseDateMs;
    private final Long originalPurchaseDateMs;
    private final PeriodType periodType;
    private final String productIdentifier;
    private final String productPlanIdentifier;
    private final Map<String, Long> purchaseDatesByProductMs;
    private final Long unsubscribeDetectedAtMs;
    private final Boolean willRenew;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomerInfoResult copy$default(CustomerInfoResult customerInfoResult, boolean z, boolean z2, PeriodType periodType, Set set, Boolean bool, Long l, Long l2, Long l3, Long l4, String str, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = customerInfoResult.hasSubscribed;
        }
        if ((i & 2) != 0) {
            z2 = customerInfoResult.isTrialPeriod;
        }
        if ((i & 4) != 0) {
            periodType = customerInfoResult.periodType;
        }
        if ((i & 8) != 0) {
            set = customerInfoResult.activeSubscriptions;
        }
        if ((i & 16) != 0) {
            bool = customerInfoResult.willRenew;
        }
        if ((i & 32) != 0) {
            l = customerInfoResult.unsubscribeDetectedAtMs;
        }
        if ((i & 64) != 0) {
            l2 = customerInfoResult.expirationDateMs;
        }
        if ((i & 128) != 0) {
            l3 = customerInfoResult.originalPurchaseDateMs;
        }
        if ((i & 256) != 0) {
            l4 = customerInfoResult.latestPurchaseDateMs;
        }
        if ((i & 512) != 0) {
            str = customerInfoResult.productIdentifier;
        }
        if ((i & 1024) != 0) {
            str2 = customerInfoResult.productPlanIdentifier;
        }
        if ((i & 2048) != 0) {
            map = customerInfoResult.purchaseDatesByProductMs;
        }
        String str3 = str2;
        Map map2 = map;
        Long l5 = l4;
        String str4 = str;
        Long l6 = l2;
        Long l7 = l3;
        Boolean bool2 = bool;
        Long l8 = l;
        return customerInfoResult.copy(z, z2, periodType, set, bool2, l8, l6, l7, l5, str4, str3, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasSubscribed() {
        return this.hasSubscribed;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public final Map<String, Long> component12() {
        return this.purchaseDatesByProductMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsTrialPeriod() {
        return this.isTrialPeriod;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final Set<String> component4() {
        return this.activeSubscriptions;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getWillRenew() {
        return this.willRenew;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getUnsubscribeDetectedAtMs() {
        return this.unsubscribeDetectedAtMs;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getExpirationDateMs() {
        return this.expirationDateMs;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Long getOriginalPurchaseDateMs() {
        return this.originalPurchaseDateMs;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Long getLatestPurchaseDateMs() {
        return this.latestPurchaseDateMs;
    }

    public final CustomerInfoResult copy(boolean hasSubscribed, boolean isTrialPeriod, PeriodType periodType, Set<String> activeSubscriptions, Boolean willRenew, Long unsubscribeDetectedAtMs, Long expirationDateMs, Long originalPurchaseDateMs, Long latestPurchaseDateMs, String productIdentifier, String productPlanIdentifier, Map<String, Long> purchaseDatesByProductMs) {
        Intrinsics.checkNotNullParameter(activeSubscriptions, "activeSubscriptions");
        Intrinsics.checkNotNullParameter(purchaseDatesByProductMs, "purchaseDatesByProductMs");
        return new CustomerInfoResult(hasSubscribed, isTrialPeriod, periodType, activeSubscriptions, willRenew, unsubscribeDetectedAtMs, expirationDateMs, originalPurchaseDateMs, latestPurchaseDateMs, productIdentifier, productPlanIdentifier, purchaseDatesByProductMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomerInfoResult)) {
            return false;
        }
        CustomerInfoResult customerInfoResult = (CustomerInfoResult) other;
        return this.hasSubscribed == customerInfoResult.hasSubscribed && this.isTrialPeriod == customerInfoResult.isTrialPeriod && this.periodType == customerInfoResult.periodType && Intrinsics.areEqual(this.activeSubscriptions, customerInfoResult.activeSubscriptions) && Intrinsics.areEqual(this.willRenew, customerInfoResult.willRenew) && Intrinsics.areEqual(this.unsubscribeDetectedAtMs, customerInfoResult.unsubscribeDetectedAtMs) && Intrinsics.areEqual(this.expirationDateMs, customerInfoResult.expirationDateMs) && Intrinsics.areEqual(this.originalPurchaseDateMs, customerInfoResult.originalPurchaseDateMs) && Intrinsics.areEqual(this.latestPurchaseDateMs, customerInfoResult.latestPurchaseDateMs) && Intrinsics.areEqual(this.productIdentifier, customerInfoResult.productIdentifier) && Intrinsics.areEqual(this.productPlanIdentifier, customerInfoResult.productPlanIdentifier) && Intrinsics.areEqual(this.purchaseDatesByProductMs, customerInfoResult.purchaseDatesByProductMs);
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.hasSubscribed) * 31) + Boolean.hashCode(this.isTrialPeriod)) * 31;
        PeriodType periodType = this.periodType;
        int iHashCode2 = (((iHashCode + (periodType == null ? 0 : periodType.hashCode())) * 31) + this.activeSubscriptions.hashCode()) * 31;
        Boolean bool = this.willRenew;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Long l = this.unsubscribeDetectedAtMs;
        int iHashCode4 = (iHashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.expirationDateMs;
        int iHashCode5 = (iHashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.originalPurchaseDateMs;
        int iHashCode6 = (iHashCode5 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.latestPurchaseDateMs;
        int iHashCode7 = (iHashCode6 + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str = this.productIdentifier;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.productPlanIdentifier;
        return ((iHashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.purchaseDatesByProductMs.hashCode();
    }

    public String toString() {
        return "CustomerInfoResult(hasSubscribed=" + this.hasSubscribed + ", isTrialPeriod=" + this.isTrialPeriod + ", periodType=" + this.periodType + ", activeSubscriptions=" + this.activeSubscriptions + ", willRenew=" + this.willRenew + ", unsubscribeDetectedAtMs=" + this.unsubscribeDetectedAtMs + ", expirationDateMs=" + this.expirationDateMs + ", originalPurchaseDateMs=" + this.originalPurchaseDateMs + ", latestPurchaseDateMs=" + this.latestPurchaseDateMs + ", productIdentifier=" + this.productIdentifier + ", productPlanIdentifier=" + this.productPlanIdentifier + ", purchaseDatesByProductMs=" + this.purchaseDatesByProductMs + ")";
    }

    public CustomerInfoResult(boolean z, boolean z2, PeriodType periodType, Set<String> activeSubscriptions, Boolean bool, Long l, Long l2, Long l3, Long l4, String str, String str2, Map<String, Long> purchaseDatesByProductMs) {
        Intrinsics.checkNotNullParameter(activeSubscriptions, "activeSubscriptions");
        Intrinsics.checkNotNullParameter(purchaseDatesByProductMs, "purchaseDatesByProductMs");
        this.hasSubscribed = z;
        this.isTrialPeriod = z2;
        this.periodType = periodType;
        this.activeSubscriptions = activeSubscriptions;
        this.willRenew = bool;
        this.unsubscribeDetectedAtMs = l;
        this.expirationDateMs = l2;
        this.originalPurchaseDateMs = l3;
        this.latestPurchaseDateMs = l4;
        this.productIdentifier = str;
        this.productPlanIdentifier = str2;
        this.purchaseDatesByProductMs = purchaseDatesByProductMs;
    }

    public final boolean getHasSubscribed() {
        return this.hasSubscribed;
    }

    public final boolean isTrialPeriod() {
        return this.isTrialPeriod;
    }

    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final Set<String> getActiveSubscriptions() {
        return this.activeSubscriptions;
    }

    public final Boolean getWillRenew() {
        return this.willRenew;
    }

    public final Long getUnsubscribeDetectedAtMs() {
        return this.unsubscribeDetectedAtMs;
    }

    public final Long getExpirationDateMs() {
        return this.expirationDateMs;
    }

    public final Long getOriginalPurchaseDateMs() {
        return this.originalPurchaseDateMs;
    }

    public final Long getLatestPurchaseDateMs() {
        return this.latestPurchaseDateMs;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public /* synthetic */ CustomerInfoResult(boolean z, boolean z2, PeriodType periodType, Set set, Boolean bool, Long l, Long l2, Long l3, Long l4, String str, String str2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, periodType, set, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : l2, (i & 128) != 0 ? null : l3, (i & 256) != 0 ? null : l4, (i & 512) != 0 ? null : str, (i & 1024) != 0 ? null : str2, (i & 2048) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Long> getPurchaseDatesByProductMs() {
        return this.purchaseDatesByProductMs;
    }
}
