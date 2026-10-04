package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RewardVerificationException.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/RewardVerificationException;", "Lcom/revenuecat/purchases/PurchasesException;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "isServerError", "", "(Lcom/revenuecat/purchases/PurchasesError;Z)V", "()Z", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RewardVerificationException extends PurchasesException {
    private final boolean isServerError;

    /* JADX INFO: renamed from: isServerError, reason: from getter */
    public final boolean getIsServerError() {
        return this.isServerError;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardVerificationException(PurchasesError error, boolean z) {
        super(error);
        Intrinsics.checkNotNullParameter(error, "error");
        this.isServerError = z;
    }
}
