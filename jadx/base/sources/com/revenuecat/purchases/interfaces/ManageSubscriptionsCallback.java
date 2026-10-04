package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;

/* JADX INFO: compiled from: ManageSubscriptionsCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/interfaces/ManageSubscriptionsCallback;", "", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onSuccess", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface ManageSubscriptionsCallback {
    void onError(PurchasesError error);

    void onSuccess();
}
