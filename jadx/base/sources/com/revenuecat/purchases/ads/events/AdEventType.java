package com.revenuecat.purchases.ads.events;

import kotlin.Metadata;

/* JADX INFO: compiled from: AdEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdEventType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DISPLAYED", "OPENED", "REVENUE", "LOADED", "FAILED_TO_LOAD", "REWARD_EARNED_UNVERIFIED", "REWARD_VERIFIED", "REWARD_GRANTED", "REWARD_FAILED_TO_VERIFY", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public enum AdEventType {
    DISPLAYED("rc_ads_ad_displayed"),
    OPENED("rc_ads_ad_opened"),
    REVENUE("rc_ads_ad_revenue"),
    LOADED("rc_ads_ad_loaded"),
    FAILED_TO_LOAD("rc_ads_ad_failed_to_load"),
    REWARD_EARNED_UNVERIFIED("rc_ads_ad_reward_sdk_earned"),
    REWARD_VERIFIED("rc_ads_ad_reward_sdk_verified"),
    REWARD_GRANTED("rc_ads_ad_reward_sdk_granted"),
    REWARD_FAILED_TO_VERIFY("rc_ads_ad_reward_sdk_failed_to_verify");

    private final String value;

    AdEventType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
