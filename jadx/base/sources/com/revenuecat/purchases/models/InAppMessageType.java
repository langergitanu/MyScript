package com.revenuecat.purchases.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: InAppMessageType.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/models/InAppMessageType;", "", "inAppMessageCategoryId", "", "(Ljava/lang/String;II)V", "getInAppMessageCategoryId$purchases_defaultsRelease", "()I", "BILLING_ISSUES", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public enum InAppMessageType {
    BILLING_ISSUES(2);

    private final int inAppMessageCategoryId;

    InAppMessageType(int i) {
        this.inAppMessageCategoryId = i;
    }

    /* JADX INFO: renamed from: getInAppMessageCategoryId$purchases_defaultsRelease, reason: from getter */
    public final int getInAppMessageCategoryId() {
        return this.inAppMessageCategoryId;
    }
}
