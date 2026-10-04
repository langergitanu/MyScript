package com.samsung.android.sdk.pen.setting.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.color.SpenColorSwatchUtil;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: SpenSettingUtilColor.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u00020\u0007\"\u00020\b¢\u0006\u0004\b\u0004\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R.\u0010\n\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\f`\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilColor;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "defineIDs", "", "", "(Landroid/content/Context;[I)V", "mColorMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "close", "", "getColorName", "hsvColor", "", "color", "isDefinedColor", "", "initTable", "addColors", "resources", "Landroid/content/res/Resources;", "valueResId", "nameResId", "getOpaqueColor", "initSwatchColor", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenSettingUtilColor {
    public static final int DEFINED_PALETTE = 1;
    public static final int DEFINED_PICKER = 2;
    private static final int DEFINED_TABLE_SIZE = 23;
    private static final String TAG = "SpenSettingUtilColor";
    private HashMap<Integer, String> mColorMap;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenSettingUtilColor(Context context) {
        this(context, 1);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public SpenSettingUtilColor(Context context, int... defineIDs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defineIDs, "defineIDs");
        this.mColorMap = new HashMap<>();
        for (int i : defineIDs) {
            if (i == 1) {
                initTable(context);
            } else if (i == 2) {
                initSwatchColor(context);
            }
        }
    }

    public final void close() {
        Log.i(TAG, "close()");
        this.mColorMap.clear();
    }

    public final String getColorName(float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        return getColorName(SpenSettingUtil.HSVToColor(hsvColor));
    }

    public final String getColorName(int color) {
        return this.mColorMap.get(Integer.valueOf(getOpaqueColor(color)));
    }

    public final boolean isDefinedColor(int color) {
        return this.mColorMap.containsKey(Integer.valueOf(getOpaqueColor(color)));
    }

    private final void initTable(Context context) {
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        for (int i = 1; i < 24; i++) {
            int identifier = resources.getIdentifier("spen_setting_swatch_" + i, "array", packageName);
            int identifier2 = resources.getIdentifier("spen_setting_swatch_name_" + i, "array", packageName);
            Intrinsics.checkNotNull(resources);
            addColors(resources, identifier, identifier2);
        }
    }

    private final void addColors(Resources resources, int valueResId, int nameResId) {
        if (valueResId <= 0 || nameResId <= 0) {
            return;
        }
        try {
            int[] intArray = resources.getIntArray(valueResId);
            Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
            String[] stringArray = resources.getStringArray(nameResId);
            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                if (stringArray[i] != null && !isDefinedColor(intArray[i])) {
                    this.mColorMap.put(Integer.valueOf(intArray[i]), stringArray[i]);
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String str = String.format("##[Palette] NotRegistered. %08X", Arrays.copyOf(new Object[]{Integer.valueOf(intArray[i])}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                    Log.i(TAG, str);
                }
            }
        } catch (Resources.NotFoundException unused) {
            Log.i(TAG, "NotFoundException. No such ColorId=" + valueResId + " NameId=" + nameResId);
        }
    }

    private final int getOpaqueColor(int color) {
        return Color.alpha(color) != 255 ? (color & ViewCompat.MEASURED_SIZE_MASK) | (-16777216) : color;
    }

    private final void initSwatchColor(Context context) {
        SpenColorSwatchUtil spenColorSwatchUtil = new SpenColorSwatchUtil(context);
        for (int i = 0; i < 13; i++) {
            for (int i2 = 0; i2 < 13; i2++) {
                float[] fArr = {0.0f, 0.0f, 0.0f};
                if (spenColorSwatchUtil.getColor(i, i2, fArr)) {
                    int iHSVToColor = Color.HSVToColor(fArr);
                    if (!isDefinedColor(iHSVToColor)) {
                        this.mColorMap.put(Integer.valueOf(iHSVToColor), spenColorSwatchUtil.getColorName(i, i2, true));
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String str = String.format("##[PICKER] NotRegistered. %08X", Arrays.copyOf(new Object[]{Integer.valueOf(iHSVToColor)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                        Log.i(TAG, str);
                    }
                }
            }
        }
    }
}
