package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RewardVerificationError.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/RewardVerificationError;", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "isServerError", "", "(Lcom/revenuecat/purchases/PurchasesError;Z)V", "getError", "()Lcom/revenuecat/purchases/PurchasesError;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class RewardVerificationError {
    private final PurchasesError error;
    private final boolean isServerError;

    public static /* synthetic */ RewardVerificationError copy$default(RewardVerificationError rewardVerificationError, PurchasesError purchasesError, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            purchasesError = rewardVerificationError.error;
        }
        if ((i & 2) != 0) {
            z = rewardVerificationError.isServerError;
        }
        return rewardVerificationError.copy(purchasesError, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PurchasesError getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsServerError() {
        return this.isServerError;
    }

    public final RewardVerificationError copy(PurchasesError error, boolean isServerError) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new RewardVerificationError(error, isServerError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RewardVerificationError)) {
            return false;
        }
        RewardVerificationError rewardVerificationError = (RewardVerificationError) other;
        return Intrinsics.areEqual(this.error, rewardVerificationError.error) && this.isServerError == rewardVerificationError.isServerError;
    }

    public int hashCode() {
        return (this.error.hashCode() * 31) + Boolean.hashCode(this.isServerError);
    }

    public String toString() {
        return "RewardVerificationError(error=" + this.error + ", isServerError=" + this.isServerError + ')';
    }

    public RewardVerificationError(PurchasesError error, boolean z) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.error = error;
        this.isServerError = z;
    }

    public final PurchasesError getError() {
        return this.error;
    }

    public final boolean isServerError() {
        return this.isServerError;
    }
}
