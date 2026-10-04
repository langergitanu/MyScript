package com.samsung.android.sdk.pen.util.color;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenColorUtil.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007¨\u0006\u000e"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenColorUtil;", "", "<init>", "()V", "HSVToColor", "", "hsvColor", "", "alpha", "RGBToHSL", "", "color", "hslColor", "HSLToRGB", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenColorUtil {
    public static final SpenColorUtil INSTANCE = new SpenColorUtil();

    private SpenColorUtil() {
    }

    public final int HSVToColor(float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        return HSVToColor(255, hsvColor);
    }

    public final int HSVToColor(int alpha, float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        return Color.HSVToColor(alpha, hsvColor);
    }

    public final void RGBToHSL(int color, float[] hslColor) {
        Intrinsics.checkNotNullParameter(hslColor, "hslColor");
        ColorUtils.RGBToHSL(Color.red(color), Color.green(color), Color.blue(color), hslColor);
    }

    public final int HSLToRGB(float[] hslColor) {
        Intrinsics.checkNotNullParameter(hslColor, "hslColor");
        return ColorUtils.HSLToColor(hslColor);
    }
}
