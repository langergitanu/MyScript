package com.myscript.atk.core.p020ui.utils;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.myscript.atk.core.InkStyle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class BestFontSelector {
    private static final String[] FONT_NAMES = {"STIXSizeOneSym-Bold", "STIXSizeTwoSym-Bold", "STIXSizeThreeSym-Bold"};
    private static final int FONT_SIZE_1 = 0;
    private static final int FONT_SIZE_2 = 1;
    private static final int FONT_SIZE_3 = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FontSize {
    }

    public static Typeface getBestFontFor(String str, Paint paint, RectF rectF, InkStyle inkStyle) {
        return getFontForSize(getBestFontSize(str, paint, rectF, inkStyle), inkStyle);
    }

    private static int getBestFontSize(String str, Paint paint, RectF rectF, InkStyle inkStyle) {
        Rect rect = new Rect();
        float fHeight = rectF.height() / rectF.width();
        int i = -1;
        for (int i2 = 0; i2 <= 2; i2++) {
            paint.setTypeface(getFontForSize(i2, inkStyle));
            paint.getTextBounds(str, 0, 1, rect);
            RectF rectF2 = new RectF(rect);
            if (fHeight > rectF2.height() / rectF2.width() || i == -1) {
                i = i2;
            }
        }
        return i;
    }

    private static Typeface getFontForSize(int i, InkStyle inkStyle) {
        return FontManager.getTypeface(FONT_NAMES[i]);
    }
}
