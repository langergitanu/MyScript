package com.revenuecat.purchases;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntentExtensions.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"asWebPurchaseRedemption", "Lcom/revenuecat/purchases/WebPurchaseRedemption;", "Landroid/content/Intent;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class IntentExtensionsKt {
    public static final /* synthetic */ WebPurchaseRedemption asWebPurchaseRedemption(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return Purchases.INSTANCE.parseAsWebPurchaseRedemption(intent);
    }
}
