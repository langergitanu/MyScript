package com.samsung.android.sdk.pen.setting.util;

import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: SpenSettingUtilOpacity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0007¨\u0006\u000b"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilOpacity;", "", "<init>", "()V", "getPercentToAlpha", "", "percent", "getAlphaToPercent", "alpha", "setCurrentAlpha", "color", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenSettingUtilOpacity {
    public static final SpenSettingUtilOpacity INSTANCE = new SpenSettingUtilOpacity();

    @JvmStatic
    public static final int setCurrentAlpha(int color, int alpha) {
        return (color & ViewCompat.MEASURED_SIZE_MASK) | ((alpha << 24) & (-16777216));
    }

    private SpenSettingUtilOpacity() {
    }

    @JvmStatic
    public static final int getPercentToAlpha(int percent) {
        if (percent < 0 || percent >= 101) {
            return -1;
        }
        return Math.round((percent * 255.0f) / 100.0f);
    }

    @JvmStatic
    public static final int getAlphaToPercent(int alpha) {
        if (alpha < 0 || alpha >= 256) {
            return -1;
        }
        return Math.round((alpha / 255.0f) * 100.0f);
    }
}
