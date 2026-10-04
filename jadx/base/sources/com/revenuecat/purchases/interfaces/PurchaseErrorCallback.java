package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;

/* JADX INFO: compiled from: PurchaseErrorCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/interfaces/PurchaseErrorCallback;", "", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "userCancelled", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PurchaseErrorCallback {
    void onError(PurchasesError error, boolean userCancelled);
}
