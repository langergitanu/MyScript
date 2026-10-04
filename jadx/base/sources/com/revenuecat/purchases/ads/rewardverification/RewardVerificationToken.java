package com.revenuecat.purchases.ads.rewardverification;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RewardVerificationToken.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationToken;", "", "customData", "", "clientTransactionId", "appUserID", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserID", "()Ljava/lang/String;", "getClientTransactionId", "getCustomData", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RewardVerificationToken {
    private final String appUserID;
    private final String clientTransactionId;
    private final String customData;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardVerificationToken)) {
            return false;
        }
        RewardVerificationToken rewardVerificationToken = (RewardVerificationToken) obj;
        return Intrinsics.areEqual(this.customData, rewardVerificationToken.customData) && Intrinsics.areEqual(this.clientTransactionId, rewardVerificationToken.clientTransactionId) && Intrinsics.areEqual(this.appUserID, rewardVerificationToken.appUserID);
    }

    public int hashCode() {
        return (((this.customData.hashCode() * 31) + this.clientTransactionId.hashCode()) * 31) + this.appUserID.hashCode();
    }

    public String toString() {
        return "RewardVerificationToken(customData=" + this.customData + ", clientTransactionId=" + this.clientTransactionId + ", appUserID=" + this.appUserID + ')';
    }

    public RewardVerificationToken(String customData, String clientTransactionId, String appUserID) {
        Intrinsics.checkNotNullParameter(customData, "customData");
        Intrinsics.checkNotNullParameter(clientTransactionId, "clientTransactionId");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        this.customData = customData;
        this.clientTransactionId = clientTransactionId;
        this.appUserID = appUserID;
    }

    public final String getCustomData() {
        return this.customData;
    }

    public final String getClientTransactionId() {
        return this.clientTransactionId;
    }

    public final String getAppUserID() {
        return this.appUserID;
    }
}
