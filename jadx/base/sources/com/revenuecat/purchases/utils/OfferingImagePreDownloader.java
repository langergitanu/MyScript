package com.revenuecat.purchases.utils;

import android.net.Uri;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.paywalls.PaywallAssetWarming;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfferingImagePreDownloader.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/utils/OfferingImagePreDownloader;", "", "assetWarming", "Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;", "(Lcom/revenuecat/purchases/paywalls/PaywallAssetWarming;)V", "downloadV1Images", "", "offering", "Lcom/revenuecat/purchases/Offering;", "downloadV2Images", "preDownloadOfferingImages", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class OfferingImagePreDownloader {
    private final PaywallAssetWarming assetWarming;

    public OfferingImagePreDownloader(PaywallAssetWarming assetWarming) {
        Intrinsics.checkNotNullParameter(assetWarming, "assetWarming");
        this.assetWarming = assetWarming;
    }

    public final void preDownloadOfferingImages(Offering offering) {
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (!this.assetWarming.isAvailable()) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.mo1544v("[Purchases] - " + logLevel.name(), "OfferingImagePreDownloader won't pre-download images");
                return;
            }
            return;
        }
        LogLevel logLevel2 = LogLevel.DEBUG;
        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
            currentLogHandler2.mo1541d("[Purchases] - " + logLevel2.name(), "OfferingImagePreDownloader: starting image download");
        }
        downloadV1Images(offering);
        downloadV2Images(offering);
    }

    private final void downloadV1Images(Offering offering) {
        PaywallData paywall = offering.getPaywall();
        if (paywall == null) {
            return;
        }
        List<String> all$purchases_defaultsRelease = paywall.getConfig().getImages().getAll$purchases_defaultsRelease();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all$purchases_defaultsRelease, 10));
        Iterator<T> it = all$purchases_defaultsRelease.iterator();
        while (it.hasNext()) {
            arrayList.add(Uri.parse(paywall.getAssetBaseURL().toString()).buildUpon().path((String) it.next()).build());
        }
        this.assetWarming.warmImages(arrayList);
    }

    private final void downloadV2Images(Offering offering) {
        PaywallComponentAssets paywallComponentAssetsCollectAssets;
        PaywallComponentsConfig paywallComponentsConfigBaseComponentsConfig = PaywallComponentAssetsKt.baseComponentsConfig(offering);
        if (paywallComponentsConfigBaseComponentsConfig == null || (paywallComponentAssetsCollectAssets = PaywallComponentAssetsKt.collectAssets(paywallComponentsConfigBaseComponentsConfig)) == null) {
            return;
        }
        this.assetWarming.warmImages(paywallComponentAssetsCollectAssets.getImageUris());
        if (paywallComponentAssetsCollectAssets.getWebViewUrls().isEmpty()) {
            return;
        }
        this.assetWarming.prebootWebView();
    }
}
