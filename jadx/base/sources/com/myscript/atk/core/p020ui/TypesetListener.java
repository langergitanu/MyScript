package com.myscript.atk.core.p020ui;

import android.content.res.ColorStateList;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.InkStyle;
import com.myscript.atk.core.Rectangle;
import com.myscript.atk.core.SWIGRectangleList;
import com.myscript.atk.core.SpanInterval;
import com.myscript.atk.core.p020ui.utils.FontManager;
import com.myscript.atk.core.p020ui.utils.InkStyleCacheData;
import com.myscript.icu.text.ArabicShaping;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class TypesetListener implements ITypesetListener {
    private static final char[] MIRRORED_DB = {'(', ')', ')', '(', Typography.less, Typography.greater, Typography.greater, Typography.less, '[', ']', ']', '[', AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ, AbstractJsonLexerKt.END_OBJ, AbstractJsonLexerKt.BEGIN_OBJ, 171, 187, 187, 171, 3898, 3899, 3899, 3898, 3900, 3901, 3901, 3900, 5787, 5788, 5788, 5787, 8249, 8250, 8250, 8249, 8261, 8262, 8262, 8261, 8317, 8318, 8318, 8317, 8333, 8334, 8334, 8333, 8712, 8715, 8713, 8716, 8714, 8717, 8715, 8712, 8716, 8713, 8717, 8714, 8725, 10741, 8764, 8765, 8765, 8764, 8771, 8909, 8786, 8787, 8787, 8786, 8788, 8789, 8789, 8788, Typography.lessOrEqual, Typography.greaterOrEqual, Typography.greaterOrEqual, Typography.lessOrEqual, 8806, 8807, 8807, 8806, 8808, 8809, 8809, 8808, 8810, 8811, 8811, 8810, 8814, 8815, 8815, 8814, 8816, 8817, 8817, 8816, 8818, 8819, 8819, 8818, 8820, 8821, 8821, 8820, 8822, 8823, 8823, 8822, 8824, 8825, 8825, 8824, 8826, 8827, 8827, 8826, 8828, 8829, 8829, 8828, 8830, 8831, 8831, 8830, 8832, 8833, 8833, 8832, 8834, 8835, 8835, 8834, 8836, 8837, 8837, 8836, 8838, 8839, 8839, 8838, 8840, 8841, 8841, 8840, 8842, 8843, 8843, 8842, 8847, 8848, 8848, 8847, 8849, 8850, 8850, 8849, 8856, 10680, 8866, 8867, 8867, 8866, 8870, 10974, 8872, 10980, 8873, 10979, 8875, 10981, 8880, 8881, 8881, 8880, 8882, 8883, 8883, 8882, 8884, 8885, 8885, 8884, 8886, 8887, 8887, 8886, 8905, 8906, 8906, 8905, 8907, 8908, 8908, 8907, 8909, 8771, 8912, 8913, 8913, 8912, 8918, 8919, 8919, 8918, 8920, 8921, 8921, 8920, 8922, 8923, 8923, 8922, 8924, 8925, 8925, 8924, 8926, 8927, 8927, 8926, 8928, 8929, 8929, 8928, 8930, 8931, 8931, 8930, 8932, 8933, 8933, 8932, 8934, 8935, 8935, 8934, 8936, 8937, 8937, 8936, 8938, 8939, 8939, 8938, 8940, 8941, 8941, 8940, 8944, 8945, 8945, 8944, 8946, 8954, 8947, 8955, 8948, 8956, 8950, 8957, 8951, 8958, 8954, 8946, 8955, 8947, 8956, 8948, 8957, 8950, 8958, 8951, 8968, 8969, 8969, 8968, 8970, 8971, 8971, 8970, 9001, 9002, 9002, 9001, 10088, 10089, 10089, 10088, 10090, 10091, 10091, 10090, 10092, 10093, 10093, 10092, 10094, 10095, 10095, 10094, 10096, 10097, 10097, 10096, 10098, 10099, 10099, 10098, 10100, 10101, 10101, 10100, 10179, 10180, 10180, 10179, 10181, 10182, 10182, 10181, 10184, 10185, 10185, 10184, 10187, 10189, 10189, 10187, 10197, 10198, 10198, 10197, 10205, 10206, 10206, 10205, 10210, 10211, 10211, 10210, 10212, 10213, 10213, 10212, 10214, 10215, 10215, 10214, 10216, 10217, 10217, 10216, 10218, 10219, 10219, 10218, 10220, 10221, 10221, 10220, 10222, 10223, 10223, 10222, 10627, 10628, 10628, 10627, 10629, 10630, 10630, 10629, 10631, 10632, 10632, 10631, 10633, 10634, 10634, 10633, 10635, 10636, 10636, 10635, 10637, 10640, 10638, 10639, 10639, 10638, 10640, 10637, 10641, 10642, 10642, 10641, 10643, 10644, 10644, 10643, 10645, 10646, 10646, 10645, 10647, 10648, 10648, 10647, 10680, 8856, 10688, 10689, 10689, 10688, 10692, 10693, 10693, 10692, 10703, 10704, 10704, 10703, 10705, 10706, 10706, 10705, 10708, 10709, 10709, 10708, 10712, 10713, 10713, 10712, 10714, 10715, 10715, 10714, 10741, 8725, 10744, 10745, 10745, 10744, 10748, 10749, 10749, 10748, 10795, 10796, 10796, 10795, 10797, 10798, 10798, 10797, 10804, 10805, 10805, 10804, 10812, 10813, 10813, 10812, 10852, 10853, 10853, 10852, 10873, 10874, 10874, 10873, 10877, 10878, 10878, 10877, 10879, 10880, 10880, 10879, 10881, 10882, 10882, 10881, 10883, 10884, 10884, 10883, 10891, 10892, 10892, 10891, 10897, 10898, 10898, 10897, 10899, 10900, 10900, 10899, 10901, 10902, 10902, 10901, 10903, 10904, 10904, 10903, 10905, 10906, 10906, 10905, 10907, 10908, 10908, 10907, 10913, 10914, 10914, 10913, 10918, 10919, 10919, 10918, 10920, 10921, 10921, 10920, 10922, 10923, 10923, 10922, 10924, 10925, 10925, 10924, 10927, 10928, 10928, 10927, 10931, 10932, 10932, 10931, 10939, 10940, 10940, 10939, 10941, 10942, 10942, 10941, 10943, 10944, 10944, 10943, 10945, 10946, 10946, 10945, 10947, 10948, 10948, 10947, 10949, 10950, 10950, 10949, 10957, 10958, 10958, 10957, 10959, 10960, 10960, 10959, 10961, 10962, 10962, 10961, 10963, 10964, 10964, 10963, 10965, 10966, 10966, 10965, 10974, 8870, 10979, 8873, 10980, 8872, 10981, 8875, 10988, 10989, 10989, 10988, 10999, 11000, 11000, 10999, 11001, 11002, 11002, 11001, 11778, 11779, 11779, 11778, 11780, 11781, 11781, 11780, 11785, 11786, 11786, 11785, 11788, 11789, 11789, 11788, 11804, 11805, 11805, 11804, 11808, 11809, 11809, 11808, 11810, 11811, 11811, 11810, 11812, 11813, 11813, 11812, 11814, 11815, 11815, 11814, 11816, 11817, 11817, 11816, 12296, 12297, 12297, 12296, 12298, 12299, 12299, 12298, 12300, 12301, 12301, 12300, 12302, 12303, 12303, 12302, 12304, 12305, 12305, 12304, 12308, 12309, 12309, 12308, 12310, 12311, 12311, 12310, 12312, 12313, 12313, 12312, 12314, 12315, 12315, 12314, 65118, 65117, 65124, 65125, 65125, 65124, 65288, 65289, 65289, 65288, 65308, 65310, 65310, 65308, 65339, 65341, 65341, 65339, 65371, 65373, 65373, 65371, 65375, 65376, 65376, 65375, 65378, 65379, 65379, 65378};
    private Rect bounds;
    private RectF boundsF;
    private Path charPath;
    private int fontSizeScaled;
    private FontMetricsProvider glyphMetricsProvider;
    private TextPaint paint;
    private float scaleX;
    private float scaleY;
    private final float scaledDensity;

    @Override // com.myscript.atk.core.ITypesetListener
    public boolean supportsGlyphMetrics() {
        return true;
    }

    public TypesetListener(DisplayMetrics displayMetrics) {
        this(displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.scaledDensity);
    }

    public TypesetListener(float f, float f2, float f3) {
        this.charPath = new Path();
        this.bounds = new Rect();
        this.boundsF = new RectF();
        this.paint = new TextPaint(193);
        this.scaleX = 25.4f / f;
        this.scaleY = 25.4f / f2;
        this.scaledDensity = f3;
        this.glyphMetricsProvider = new FontMetricsProvider(f, f2, f3);
    }

    private void configurePaint(InkStyle inkStyle) {
        InkStyleCacheData data = InkStyleCacheData.getData(inkStyle, InkStyleCacheData.FONT_PROPERTIES);
        Typeface typeface = FontManager.getTypeface(data);
        if (typeface == null) {
            typeface = Typeface.create(inkStyle.getFontFamily(), FontManager.getFontStyle(data));
        }
        this.paint.setTypeface(typeface);
        int iRound = Math.round(inkStyle.getFontSize() / this.scaleY);
        this.fontSizeScaled = iRound;
        this.paint.setTextSize(iRound);
        this.paint.setLetterSpacing(FontManager.computeLetterSpacing(data.isDefaultFont, this.fontSizeScaled / this.scaledDensity));
    }

    @Override // com.myscript.atk.core.ITypesetListener
    public List<Rectangle> getCharacterBoundingBoxes(String str, InkStyle inkStyle) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(inkStyle);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new SpanInterval(0, str.length()));
        return getCharacterBoundingBoxes(str, arrayList, arrayList2);
    }

    @Override // com.myscript.atk.core.ITypesetListener
    public List<Rectangle> getCharacterBoundingBoxes(String str, List<InkStyle> list, List<SpanInterval> list2) {
        float primaryHorizontal;
        float primaryHorizontal2;
        float f;
        float f2;
        float f3;
        float f4;
        TypesetListener typesetListener = this;
        String str2 = str;
        SWIGRectangleList sWIGRectangleList = new SWIGRectangleList();
        int iMin = Math.min(list2.size(), list.size());
        if (str2 != null && !str2.isEmpty() && iMin > 0) {
            SpannableString spannableString = new SpannableString(str2);
            ColorStateList.valueOf(-16777216);
            typesetListener.configurePaint(list.get(0));
            typesetListener.getLabelBounds(new char[]{'x'}, 0, 1, typesetListener.boundsF);
            float f5 = -typesetListener.bounds.top;
            float fComputeLetterSpacing = 0.0f;
            for (int i = 0; i < iMin; i++) {
                InkStyle inkStyle = list.get(i);
                SpanInterval spanInterval = list2.get(i);
                int beginCharPosition = spanInterval.getBeginCharPosition();
                int endCharPosition = spanInterval.getEndCharPosition();
                InkStyleCacheData data = InkStyleCacheData.getData(inkStyle, InkStyleCacheData.FONT_PROPERTIES);
                Typeface typeface = FontManager.getTypeface(data);
                int fontStyle = FontManager.getFontStyle(data);
                if (typeface == null) {
                    typeface = Typeface.create(data.getFontFamily(), fontStyle);
                }
                fComputeLetterSpacing = FontManager.computeLetterSpacing(data.isDefaultFont, typesetListener.fontSizeScaled / typesetListener.scaledDensity);
                spannableString.setSpan(new CustomTextSpan(typeface, fontStyle, typesetListener.fontSizeScaled, fComputeLetterSpacing), beginCharPosition, endCharPosition, 33);
            }
            typesetListener.paint.setLetterSpacing(fComputeLetterSpacing);
            StaticLayout staticLayout = new StaticLayout(spannableString, typesetListener.paint, ((int) Math.ceil(typesetListener.paint.measureText(str2))) * 2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            if (staticLayout.getLineCount() != 1) {
                throw new RuntimeException();
            }
            char[] cArrReshapeText = reshapeText(str2, staticLayout);
            int length = str2.length();
            float f6 = 0.0f;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                if ((staticLayout.getParagraphDirection(0) == -1) ^ staticLayout.isRtlCharAt(i3)) {
                    primaryHorizontal = staticLayout.getSecondaryHorizontal(i3);
                    primaryHorizontal2 = staticLayout.getSecondaryHorizontal(i3 + 1);
                } else {
                    primaryHorizontal = staticLayout.getPrimaryHorizontal(i3);
                    primaryHorizontal2 = staticLayout.getPrimaryHorizontal(i3 + 1);
                }
                typesetListener.getLabelBounds(cArrReshapeText, i3, 1, typesetListener.boundsF);
                float fMin = Math.min(primaryHorizontal, primaryHorizontal2);
                float fMax = Math.max(primaryHorizontal, primaryHorizontal2);
                if (typesetListener.boundsF.isEmpty() && !str2.equals(" ")) {
                    if (f6 == 0.0f) {
                        typesetListener.paint.getTextPath("X", 0, 1, 0.0f, 0.0f, typesetListener.charPath);
                        typesetListener.charPath.computeBounds(typesetListener.boundsF, true);
                        f6 = typesetListener.boundsF.top;
                    }
                    f4 = typesetListener.boundsF.left + fMin;
                    f2 = typesetListener.boundsF.bottom;
                    f = fMax - fMin;
                    f3 = f6;
                } else if (typesetListener.boundsF.isEmpty()) {
                    f3 = f6;
                    f6 = -f5;
                    f4 = fMin;
                    f = fMax;
                    f2 = 0.0f;
                } else {
                    float f7 = typesetListener.boundsF.left + fMin;
                    float f8 = typesetListener.boundsF.top;
                    f = fMin + typesetListener.boundsF.right;
                    f2 = typesetListener.boundsF.bottom;
                    f3 = f6;
                    f6 = f8;
                    f4 = f7;
                }
                float f9 = typesetListener.scaleX;
                float f10 = typesetListener.scaleY;
                sWIGRectangleList.push_back(new Rectangle(f4 * f9, f6 * f10, (f - f4) * f9, (f2 - f6) * f10));
                i3++;
                i2++;
                typesetListener = this;
                str2 = str;
                f6 = f3;
            }
        }
        return sWIGRectangleList;
    }

    @Override // com.myscript.atk.core.ITypesetListener
    public float[] getGlyphMetrics(String str, int[] iArr, List<InkStyle> list, List<SpanInterval> list2) {
        return this.glyphMetricsProvider.getGlyphMetrics(new Text(str, iArr), list, list2);
    }

    private void getLabelBounds(char[] cArr, int i, int i2, RectF rectF) {
        this.paint.getTextPath(cArr, i, i2, 0.0f, 0.0f, this.charPath);
        this.charPath.computeBounds(rectF, true);
    }

    @Override // com.myscript.atk.core.ITypesetListener
    public String getCustomFontPath(InkStyle inkStyle) {
        String fontPath = inkStyle != null ? FontManager.getFontPath(inkStyle) : null;
        return fontPath != null ? fontPath : "";
    }

    @Override // com.myscript.atk.core.ITypesetListener
    public float getCharacterDefaultHeight(InkStyle inkStyle, char c) {
        configurePaint(inkStyle);
        this.paint.getTextBounds(String.valueOf(c), 0, 1, this.bounds);
        return this.bounds.height() * this.scaleY;
    }

    @Override // com.myscript.atk.core.ITypesetListener
    public float getAscent(InkStyle inkStyle) {
        configurePaint(inkStyle);
        return Math.abs(this.paint.ascent() * this.scaleY) * this.scaledDensity;
    }

    @Override // com.myscript.atk.core.ITypesetListener
    public float getDescender(InkStyle inkStyle) {
        configurePaint(inkStyle);
        return this.paint.descent() * this.scaleY;
    }

    private static char[] reshapeText(String str, Layout layout) {
        int length = str.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
        }
        ArabicShaping.SHAPER.shape(cArr, 0, length);
        for (int i2 = 0; i2 < length; i2++) {
            int mirroredCharIndex = getMirroredCharIndex(cArr[i2]);
            if (mirroredCharIndex >= 0 && layout.isRtlCharAt(i2)) {
                cArr[i2] = mirrorChar(mirroredCharIndex);
            }
        }
        return cArr;
    }

    private static int getMirroredCharIndex(char c) {
        int i = 0;
        while (true) {
            char[] cArr = MIRRORED_DB;
            if (i >= cArr.length) {
                return -1;
            }
            if (c == cArr[i]) {
                return i;
            }
            i++;
        }
    }

    private static char mirrorChar(int i) {
        if ((i & 1) == 0) {
            return MIRRORED_DB[i + 1];
        }
        return MIRRORED_DB[i - 1];
    }
}
