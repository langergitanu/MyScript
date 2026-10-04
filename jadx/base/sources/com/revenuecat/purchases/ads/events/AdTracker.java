package com.revenuecat.purchases.ads.events;

import com.revenuecat.purchases.ads.events.AdEvent;
import com.revenuecat.purchases.ads.events.types.AdDisplayedData;
import com.revenuecat.purchases.ads.events.types.AdFailedToLoadData;
import com.revenuecat.purchases.ads.events.types.AdLoadedData;
import com.revenuecat.purchases.ads.events.types.AdOpenedData;
import com.revenuecat.purchases.ads.events.types.AdRevenueData;
import com.revenuecat.purchases.ads.events.types.AdRewardEarnedUnverifiedData;
import com.revenuecat.purchases.ads.events.types.AdRewardFailedToVerifyData;
import com.revenuecat.purchases.ads.events.types.AdRewardGrantedData;
import com.revenuecat.purchases.ads.events.types.AdRewardVerifiedData;
import com.revenuecat.purchases.common.events.EventsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdTracker.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0010J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0007J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0012J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdTracker;", "", "eventsManager", "Lcom/revenuecat/purchases/common/events/EventsManager;", "(Lcom/revenuecat/purchases/common/events/EventsManager;)V", "trackAdDisplayed", "", "data", "Lcom/revenuecat/purchases/ads/events/types/AdDisplayedData;", "captureMethod", "Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "trackAdFailedToLoad", "Lcom/revenuecat/purchases/ads/events/types/AdFailedToLoadData;", "trackAdLoaded", "Lcom/revenuecat/purchases/ads/events/types/AdLoadedData;", "trackAdOpened", "Lcom/revenuecat/purchases/ads/events/types/AdOpenedData;", "trackAdRevenue", "Lcom/revenuecat/purchases/ads/events/types/AdRevenueData;", "trackAdRewardEarnedUnverified", "Lcom/revenuecat/purchases/ads/events/types/AdRewardEarnedUnverifiedData;", "trackAdRewardFailedToVerify", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailedToVerifyData;", "trackAdRewardGranted", "Lcom/revenuecat/purchases/ads/events/types/AdRewardGrantedData;", "trackAdRewardVerified", "Lcom/revenuecat/purchases/ads/events/types/AdRewardVerifiedData;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class AdTracker {
    private final EventsManager eventsManager;

    public AdTracker(EventsManager eventsManager) {
        Intrinsics.checkNotNullParameter(eventsManager, "eventsManager");
        this.eventsManager = eventsManager;
    }

    public final void trackAdDisplayed(AdDisplayedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        trackAdDisplayed(data, AdCaptureMethod.MANUAL);
    }

    public final void trackAdDisplayed(AdDisplayedData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.Displayed(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), captureMethod, 15, null));
    }

    public final void trackAdOpened(AdOpenedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        trackAdOpened(data, AdCaptureMethod.MANUAL);
    }

    public final void trackAdOpened(AdOpenedData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.Open(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), captureMethod, 15, null));
    }

    public final void trackAdRevenue(AdRevenueData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        trackAdRevenue(data, AdCaptureMethod.MANUAL);
    }

    public final void trackAdRevenue(AdRevenueData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.Revenue(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), captureMethod, data.getRevenueMicros(), data.getCurrency(), data.getPrecision(), 15, null));
    }

    public final void trackAdLoaded(AdLoadedData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        trackAdLoaded(data, AdCaptureMethod.MANUAL);
    }

    public final void trackAdLoaded(AdLoadedData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.Loaded(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), captureMethod, 15, null));
    }

    public final void trackAdFailedToLoad(AdFailedToLoadData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        trackAdFailedToLoad(data, AdCaptureMethod.MANUAL);
    }

    public final void trackAdFailedToLoad(AdFailedToLoadData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.FailedToLoad(null, 0, null, 0L, data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), null, captureMethod, data.getMediatorErrorCode(), 15, null));
    }

    public final void trackAdRewardEarnedUnverified(AdRewardEarnedUnverifiedData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.RewardEarnedUnverified(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), captureMethod, data.getRewardVerificationEnabled(), 15, null));
    }

    public final void trackAdRewardVerified(AdRewardVerifiedData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.RewardVerified(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), captureMethod, 15, null));
    }

    public final void trackAdRewardGranted(AdRewardGrantedData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.RewardGranted(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), captureMethod, data.getReward(), 15, null));
    }

    public final void trackAdRewardFailedToVerify(AdRewardFailedToVerifyData data, AdCaptureMethod captureMethod) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(captureMethod, "captureMethod");
        this.eventsManager.track(new AdEvent.RewardFailedToVerify(null, 0, null, 0L, data.getNetworkName(), data.getMediatorName(), data.getAdFormat(), data.getPlacement(), data.getAdUnitId(), data.getImpressionId(), captureMethod, data.getFailureReason(), 15, null));
    }
}
