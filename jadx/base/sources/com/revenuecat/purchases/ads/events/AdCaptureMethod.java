package com.revenuecat.purchases.ads.events;

import kotlin.Metadata;

/* JADX INFO: compiled from: AdCaptureMethod.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/AdCaptureMethod;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ADAPTER", "MANUAL", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public enum AdCaptureMethod {
    ADAPTER("adapter"),
    MANUAL("manual");

    private final String value;

    AdCaptureMethod(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
