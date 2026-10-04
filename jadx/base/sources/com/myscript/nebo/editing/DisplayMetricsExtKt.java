package com.myscript.nebo.editing;

import android.util.DisplayMetrics;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.atk.core.ViewTransform;
import com.myscript.atk.core.p020ui.TypesetListener;
import com.myscript.snt.core.LayoutGrid;
import com.myscript.snt.core.StyleUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayMetricsExt.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, m1599d2 = {"createInkStyleProperties", "Lcom/myscript/snt/core/LayoutGrid$StyleProperties;", "Landroid/util/DisplayMetrics;", TtmlNode.ATTR_TTS_FONT_SIZE, "", "lineHeight", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DisplayMetricsExtKt {
    public static final LayoutGrid.StyleProperties createInkStyleProperties(DisplayMetrics displayMetrics, float f, float f2) {
        Intrinsics.checkNotNullParameter(displayMetrics, "<this>");
        LayoutGrid.StyleProperties styleProperties = new LayoutGrid.StyleProperties();
        styleProperties.setFontSize(f);
        styleProperties.setLineHeight(f2);
        styleProperties.setCompact(false);
        ViewTransform viewTransform = new ViewTransform(displayMetrics.xdpi, displayMetrics.ydpi);
        try {
            float fLineGapMM = StyleUtils.lineGapMM(viewTransform, new TypesetListener(displayMetrics), styleProperties);
            LayoutGrid layoutGrid = new LayoutGrid();
            layoutGrid.set(0.0f, 0.0f, 0, 0.0f, 0.0f, fLineGapMM, f, f2, false, "guide");
            styleProperties.setRem(layoutGrid.rem());
            layoutGrid.delete();
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(viewTransform, null);
            return styleProperties;
        } finally {
        }
    }
}
