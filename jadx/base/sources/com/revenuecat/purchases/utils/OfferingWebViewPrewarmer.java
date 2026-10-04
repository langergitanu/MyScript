package com.revenuecat.purchases.utils;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.PaywallAssetWarming;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferingWebViewPrewarmer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/OfferingWebViewPrewarmer;", "", "assetWarming", "Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;", "(Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;)V", "prewarmWebViews", "", "offerings", "", "Lcom/revenuecat/purchases/Offering;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class OfferingWebViewPrewarmer {
    private final PaywallAssetWarming assetWarming;

    public OfferingWebViewPrewarmer(PaywallAssetWarming assetWarming) {
        Intrinsics.checkNotNullParameter(assetWarming, "assetWarming");
        this.assetWarming = assetWarming;
    }

    public final void prewarmWebViews(List<Offering> offerings) {
        PaywallComponentAssets paywallComponentAssetsCollectAssets;
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        if (this.assetWarming.isAvailable()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = offerings.iterator();
            while (it.hasNext()) {
                PaywallComponentsConfig paywallComponentsConfigBaseComponentsConfig = PaywallComponentAssetsKt.baseComponentsConfig((Offering) it.next());
                Set<String> webViewUrls = (paywallComponentsConfigBaseComponentsConfig == null || (paywallComponentAssetsCollectAssets = PaywallComponentAssetsKt.collectAssets(paywallComponentsConfigBaseComponentsConfig)) == null) ? null : paywallComponentAssetsCollectAssets.getWebViewUrls();
                if (webViewUrls == null) {
                    webViewUrls = SetsKt.emptySet();
                }
                CollectionsKt.addAll(linkedHashSet, webViewUrls);
            }
            this.assetWarming.warmWebViewUrls(linkedHashSet);
        }
    }
}
