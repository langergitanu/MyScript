package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.PurchasesError;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: compiled from: GetStorefrontLocaleCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/interfaces/GetStorefrontLocaleCallback;", "", "onError", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "onReceived", "storefrontLocale", "Ljava/util/Locale;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface GetStorefrontLocaleCallback {
    void onError(PurchasesError error);

    void onReceived(Locale storefrontLocale);
}
