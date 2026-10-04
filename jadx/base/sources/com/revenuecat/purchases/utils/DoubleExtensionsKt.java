package com.revenuecat.purchases.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: DoubleExtensions.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"DECIMAL_BASE", "", "roundToDecimalPlaces", "decimals", "", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class DoubleExtensionsKt {
    private static final double DECIMAL_BASE = 10.0d;

    public static final double roundToDecimalPlaces(double d, int i) {
        double dPow = Math.pow(DECIMAL_BASE, i);
        return Math.floor(d * dPow) / dPow;
    }
}
