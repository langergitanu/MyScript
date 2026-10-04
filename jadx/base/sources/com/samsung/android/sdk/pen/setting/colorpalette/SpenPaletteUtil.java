package com.samsung.android.sdk.pen.setting.colorpalette;

import android.content.Context;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteData;
import com.samsung.android.sdk.pen.setting.color.SpenColorPaletteUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenPaletteUtil.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007¨\u0006\f"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteUtil;", "", "<init>", "()V", "getDefinedPaletteData", "", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorPaletteData;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "swatchList", "", "", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenPaletteUtil {
    public static final SpenPaletteUtil INSTANCE = new SpenPaletteUtil();

    private SpenPaletteUtil() {
    }

    @JvmStatic
    public static final List<SpenColorPaletteData> getDefinedPaletteData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 24; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        return getDefinedPaletteData(context, arrayList);
    }

    @JvmStatic
    public static final List<SpenColorPaletteData> getDefinedPaletteData(Context context, List<Integer> swatchList) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(swatchList, "swatchList");
        SpenColorPaletteUtil spenColorPaletteUtil = new SpenColorPaletteUtil(context);
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = swatchList.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            SpenColorPaletteData spenColorPaletteData = new SpenColorPaletteData();
            spenColorPaletteData.index = iIntValue;
            arrayList.add(spenColorPaletteData);
        }
        spenColorPaletteUtil.getColorTables(arrayList);
        spenColorPaletteUtil.close();
        return arrayList;
    }
}
