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
import android.text.style.TextAppearanceSpan;
import androidx.collection.LruCache;
import androidx.core.util.Pair;
import com.myscript.atk.core.InkStyle;
import com.myscript.atk.core.SpanInterval;
import com.myscript.atk.core.p020ui.utils.FontManager;
import com.myscript.atk.core.p020ui.utils.InkStyleCacheData;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class FontMetricsProvider {
    private final float scaledDensity;
    private float xdpi;
    private float ydpi;
    private TextPaint paint = new TextPaint(193);
    private TextPaint paint_ = new TextPaint(193);
    private Path charPath = new Path();
    private RectF charBox = new RectF();
    private final LruCache<Pair<FontKey, String>, GlyphMetrics> glyphMetricsCache = new LruCache<>(1024);

    private interface IValueProvider<T> {
        T get();
    }

    private static class FontKey {
        final String family;
        final int size;
        final int style;

        public FontKey(String str, int i, int i2) {
            this.family = str;
            this.style = i;
            this.size = i2;
        }

        public int hashCode() {
            return (this.family.hashCode() ^ this.style) ^ this.size;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FontKey)) {
                return false;
            }
            FontKey fontKey = (FontKey) obj;
            return this.style == fontKey.style && this.size == fontKey.size && this.family.equals(fontKey.family);
        }
    }

    private static final class GlyphMetrics {
        private static final int PARAMETER_COUNT = 6;
        final float height;
        final float leftSideBearing;
        final float rightSideBearing;
        final float width;

        /* JADX INFO: renamed from: x */
        final float f1258x;

        /* JADX INFO: renamed from: y */
        final float f1259y;

        GlyphMetrics(float[] fArr) {
            this(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
        }

        GlyphMetrics(float f, float f2, float f3, float f4, float f5, float f6) {
            this.f1258x = f;
            this.f1259y = f2;
            this.width = f3;
            this.height = f4;
            this.leftSideBearing = f5;
            this.rightSideBearing = f6;
        }

        void toFloatArray(float[] fArr, int i) {
            fArr[i] = this.f1258x;
            fArr[i + 1] = this.f1259y;
            fArr[i + 2] = this.width;
            fArr[i + 3] = this.height;
            fArr[i + 4] = this.leftSideBearing;
            fArr[i + 5] = this.rightSideBearing;
        }

        static float[] toFloatArray(GlyphMetrics[] glyphMetricsArr) {
            float[] fArr = new float[glyphMetricsArr.length * 6];
            for (int i = 0; i < glyphMetricsArr.length; i++) {
                glyphMetricsArr[i].toFloatArray(fArr, i * 6);
            }
            return fArr;
        }
    }

    public FontMetricsProvider(float f, float f2, float f3) {
        this.xdpi = f;
        this.ydpi = f2;
        this.scaledDensity = f3;
    }

    private float x_mm2px(float f) {
        return (f / 25.4f) * this.xdpi;
    }

    private float y_mm2px(float f) {
        return (f / 25.4f) * this.ydpi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float x_px2mm(float f) {
        return (f / this.xdpi) * 25.4f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float y_px2mm(float f) {
        return (f / this.ydpi) * 25.4f;
    }

    private GlyphMetrics getGlyphMetrics(FontKey fontKey, String str, IValueProvider<GlyphMetrics> iValueProvider) {
        GlyphMetrics glyphMetrics;
        Pair<FontKey, String> pair = new Pair<>(fontKey, str);
        synchronized (this.glyphMetricsCache) {
            glyphMetrics = this.glyphMetricsCache.get(pair);
            if (glyphMetrics == null) {
                glyphMetrics = iValueProvider.get();
                this.glyphMetricsCache.put(pair, glyphMetrics);
            }
        }
        return glyphMetrics;
    }

    float[] getGlyphMetrics(Text text, List<InkStyle> list, List<SpanInterval> list2) {
        return GlyphMetrics.toFloatArray(getGlyphMetricsInternal(text, list, list2));
    }

    private GlyphMetrics[] getGlyphMetricsInternal(Text text, List<InkStyle> list, List<SpanInterval> list2) {
        int i;
        Typeface[] typefaceArr;
        float[] fArr;
        int i2;
        int i3;
        Object customTextSpan;
        FontMetricsProvider fontMetricsProvider = this;
        final String label = text.getLabel();
        SpannableString spannableString = new SpannableString(label);
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(-16777216);
        int size = list2.size();
        int[] iArr = new int[size];
        Typeface[] typefaceArr2 = new Typeface[size];
        float[] fArr2 = new float[size];
        int i4 = 0;
        while (i4 < size) {
            SpanInterval spanInterval = list2.get(i4);
            InkStyle inkStyle = list.get(i4);
            int iMax = Math.max(Math.round(fontMetricsProvider.y_mm2px(inkStyle.getFontSize())), 1);
            int glyphBeginAt = text.getGlyphBeginAt(spanInterval.getBeginCharPosition());
            int glyphEndAt = text.getGlyphEndAt(spanInterval.getEndCharPosition() - 1);
            int i5 = size;
            InkStyleCacheData data = InkStyleCacheData.getData(inkStyle, InkStyleCacheData.FONT_PROPERTIES);
            int[] iArr2 = iArr;
            Typeface typeface = FontManager.getTypeface(data);
            int fontStyle = FontManager.getFontStyle(data);
            int i6 = i4;
            float fComputeLetterSpacing = FontManager.computeLetterSpacing(data.isDefaultFont, iMax / fontMetricsProvider.scaledDensity);
            if (typeface == null) {
                String fontFamily = inkStyle.getFontFamily();
                i = iMax;
                typefaceArr = typefaceArr2;
                i3 = glyphBeginAt;
                fArr = fArr2;
                i2 = glyphEndAt;
                customTextSpan = new TextAppearanceSpan(fontFamily, fontStyle, i, colorStateListValueOf, null);
            } else {
                i = iMax;
                typefaceArr = typefaceArr2;
                fArr = fArr2;
                i2 = glyphEndAt;
                i3 = glyphBeginAt;
                customTextSpan = new CustomTextSpan(typeface, fontStyle, i, fComputeLetterSpacing);
            }
            spannableString.setSpan(customTextSpan, i3, i2, 33);
            iArr2[i6] = i;
            typefaceArr[i6] = typeface;
            fArr[i6] = fComputeLetterSpacing;
            i4 = i6 + 1;
            size = i5;
            iArr = iArr2;
            typefaceArr2 = typefaceArr;
            fArr2 = fArr;
        }
        int[] iArr3 = iArr;
        Typeface[] typefaceArr3 = typefaceArr2;
        float[] fArr3 = fArr2;
        int glyphCount = text.getGlyphCount();
        GlyphMetrics[] glyphMetricsArr = new GlyphMetrics[glyphCount];
        StaticLayout staticLayout = new StaticLayout(spannableString, fontMetricsProvider.paint_, 100000, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (staticLayout.getLineCount() != 1) {
            throw new RuntimeException();
        }
        int endCharPosition = -1;
        FontKey fontKey = null;
        int i7 = 0;
        int i8 = -1;
        while (i7 < glyphCount) {
            if (i7 >= endCharPosition) {
                i8++;
                SpanInterval spanInterval2 = list2.get(i8);
                FontKey fontKey2 = new FontKey(list.get(i8).getFontFamily(), typefaceArr3[i8].getStyle(), iArr3[i8]);
                endCharPosition = spanInterval2.getEndCharPosition();
                fontMetricsProvider.paint.setTypeface(typefaceArr3[i8]);
                fontMetricsProvider.paint.setTextSize(iArr3[i8]);
                fontMetricsProvider.paint.setLetterSpacing(fArr3[i8]);
                fontKey = fontKey2;
            }
            final int glyphBeginAt2 = text.getGlyphBeginAt(i7);
            final int glyphEndAt2 = text.getGlyphEndAt(i7);
            GlyphMetrics glyphMetrics = fontMetricsProvider.getGlyphMetrics(fontKey, label.substring(glyphBeginAt2, glyphEndAt2), new IValueProvider<GlyphMetrics>() { // from class: com.myscript.atk.core.ui.FontMetricsProvider.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.myscript.atk.core.ui.FontMetricsProvider.IValueProvider
                public GlyphMetrics get() {
                    FontMetricsProvider.this.paint.getTextPath(label, glyphBeginAt2, glyphEndAt2, 0.0f, 0.0f, FontMetricsProvider.this.charPath);
                    FontMetricsProvider.this.charPath.computeBounds(FontMetricsProvider.this.charBox, true);
                    if (FontMetricsProvider.this.charBox.isEmpty() && !" ".equals(label)) {
                        FontMetricsProvider.this.paint.getTextBounds(label, glyphBeginAt2, glyphEndAt2, new Rect());
                        FontMetricsProvider.this.charBox.left = r1.left;
                        FontMetricsProvider.this.charBox.top = r1.top;
                        FontMetricsProvider.this.charBox.right = r1.right;
                        FontMetricsProvider.this.charBox.bottom = r1.bottom;
                    }
                    FontMetricsProvider fontMetricsProvider2 = FontMetricsProvider.this;
                    float fX_px2mm = fontMetricsProvider2.x_px2mm(fontMetricsProvider2.charBox.left);
                    FontMetricsProvider fontMetricsProvider3 = FontMetricsProvider.this;
                    float fY_px2mm = fontMetricsProvider3.y_px2mm(fontMetricsProvider3.charBox.top);
                    FontMetricsProvider fontMetricsProvider4 = FontMetricsProvider.this;
                    float fX_px2mm2 = fontMetricsProvider4.x_px2mm(fontMetricsProvider4.charBox.width());
                    FontMetricsProvider fontMetricsProvider5 = FontMetricsProvider.this;
                    TextPaint textPaint = FontMetricsProvider.this.paint;
                    String str = label;
                    int i9 = glyphBeginAt2;
                    int i10 = glyphEndAt2;
                    float runAdvance = textPaint.getRunAdvance((CharSequence) str, i9, i10, i9, i10, false, i10);
                    FontMetricsProvider fontMetricsProvider6 = FontMetricsProvider.this;
                    return new GlyphMetrics(fX_px2mm, fY_px2mm, fX_px2mm2, fontMetricsProvider5.y_px2mm(fontMetricsProvider5.charBox.height()), -fX_px2mm, fontMetricsProvider6.x_px2mm(runAdvance - fontMetricsProvider6.charBox.right));
                }
            });
            glyphMetricsArr[i7] = new GlyphMetrics(fontMetricsProvider.x_px2mm(staticLayout.getPrimaryHorizontal(glyphBeginAt2)) + glyphMetrics.f1258x, glyphMetrics.f1259y, glyphMetrics.width, glyphMetrics.height, glyphMetrics.leftSideBearing, glyphMetrics.rightSideBearing);
            i7++;
            fontMetricsProvider = this;
        }
        return glyphMetricsArr;
    }
}
