package com.airbnb.lottie;

/* JADX INFO: loaded from: classes4.dex */
public class Lottie {
    private Lottie() {
    }

    public static void initialize(LottieConfig lottieConfig) {
        C3843L.setFetcher(lottieConfig.networkFetcher);
        C3843L.setCacheProvider(lottieConfig.cacheProvider);
        C3843L.setTraceEnabled(lottieConfig.enableSystraceMarkers);
        C3843L.setNetworkCacheEnabled(lottieConfig.enableNetworkCache);
        C3843L.setDisablePathInterpolatorCache(lottieConfig.disablePathInterpolatorCache);
        C3843L.setDefaultAsyncUpdates(lottieConfig.defaultAsyncUpdates);
        C3843L.setReducedMotionOption(lottieConfig.reducedMotionOption);
    }
}
