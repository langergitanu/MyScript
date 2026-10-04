package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebPurchaseRedemption.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/WebPurchaseRedemption;", "", "redemptionToken", "", "(Ljava/lang/String;)V", "getRedemptionToken$purchases_defaultsRelease", "()Ljava/lang/String;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WebPurchaseRedemption {
    private final String redemptionToken;

    public WebPurchaseRedemption(String redemptionToken) {
        Intrinsics.checkNotNullParameter(redemptionToken, "redemptionToken");
        this.redemptionToken = redemptionToken;
    }

    /* JADX INFO: renamed from: getRedemptionToken$purchases_defaultsRelease, reason: from getter */
    public final String getRedemptionToken() {
        return this.redemptionToken;
    }
}
