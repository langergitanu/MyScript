package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C8357R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenPaletteColorHelper.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002J\u0016\u0010\u0014\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorHelper;", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mColorTables", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", "mCustomColorTables", "mDefaultString", "", "getMDefaultString", "()Ljava/lang/String;", "setMDefaultString", "(Ljava/lang/String;)V", "close", "", "clearTable", "tableList", "setCustomPaletteData", "paletteData", "", "getColorString", "hsvColor", "", "findColorString", "colorTable", "color", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenPaletteColorHelper {
    private List<SpenColorPaletteData> mColorTables;
    private List<SpenColorPaletteData> mCustomColorTables;
    private String mDefaultString;

    public SpenPaletteColorHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mColorTables = SpenPaletteUtil.getDefinedPaletteData(context);
        this.mDefaultString = context.getString(C8357R.string.pen_palette_color_custom);
    }

    public final String getMDefaultString() {
        return this.mDefaultString;
    }

    public final void setMDefaultString(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mDefaultString = str;
    }

    public final void close() {
        clearTable(this.mColorTables);
        clearTable(this.mCustomColorTables);
        this.mColorTables = null;
        this.mCustomColorTables = null;
    }

    private final void clearTable(List<SpenColorPaletteData> tableList) {
        if (tableList != null) {
            tableList.clear();
        }
    }

    public final void setCustomPaletteData(List<SpenColorPaletteData> paletteData) {
        if (paletteData == null) {
            return;
        }
        if (this.mCustomColorTables == null) {
            this.mCustomColorTables = new ArrayList();
        }
        List<SpenColorPaletteData> list = this.mCustomColorTables;
        if (list != null) {
            list.clear();
        }
        List<SpenColorPaletteData> list2 = this.mCustomColorTables;
        if (list2 != null) {
            list2.addAll(paletteData);
        }
    }

    public final String getColorString(float[] hsvColor) {
        String strFindColorString;
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        int iHSVToColor = SpenSettingUtil.HSVToColor(hsvColor);
        List<SpenColorPaletteData> list = this.mCustomColorTables;
        if (list != null && (strFindColorString = findColorString(list, iHSVToColor)) != null) {
            return strFindColorString;
        }
        String strFindColorString2 = findColorString(this.mColorTables, iHSVToColor);
        return strFindColorString2 == null ? this.mDefaultString : strFindColorString2;
    }

    private final String findColorString(List<SpenColorPaletteData> colorTable, int color) {
        if (colorTable == null) {
            return null;
        }
        for (SpenColorPaletteData spenColorPaletteData : colorTable) {
            int length = spenColorPaletteData.values.length;
            for (int i = 0; i < length; i++) {
                if (spenColorPaletteData.values[i] == color) {
                    return spenColorPaletteData.names[i];
                }
            }
        }
        return null;
    }
}
