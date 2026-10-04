package com.survicate.surveys.presentation.theming;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ColorHelper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\n\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/presentation/theming/ColorHelper;", "", "<init>", "()V", "contrastThreshold", "", "redBrightness", "", "greenBrightness", "blueBrightness", "getArgbValue", "fromColor", "opacity", "", "getContrastColor", "forColor", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ColorHelper {
    public static final ColorHelper INSTANCE = new ColorHelper();
    private static final int blueBrightness = 114;
    private static final double contrastThreshold = 130.0d;
    private static final int greenBrightness = 597;
    private static final int redBrightness = 299;

    private ColorHelper() {
    }

    @JvmStatic
    public static final int getArgbValue(int fromColor, float opacity) {
        return Color.argb(MathKt.roundToInt(255 * opacity), Color.red(fromColor), Color.green(fromColor), Color.blue(fromColor));
    }

    public final int getContrastColor(int forColor) {
        return ((double) (((Color.red(forColor) * 299) + (Color.green(forColor) * greenBrightness)) + (Color.blue(forColor) * blueBrightness))) / ((double) 1000) > contrastThreshold ? -16777216 : -1;
    }
}
