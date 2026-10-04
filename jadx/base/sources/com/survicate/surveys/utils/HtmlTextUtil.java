package com.survicate.surveys.utils;

import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import androidx.core.text.HtmlCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HtmlTextUtil.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0014\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/utils/HtmlTextUtil;", "", "<init>", "()V", "getStyledText", "Landroid/text/Spanned;", "htmlText", "", "fontConfig", "Lcom/survicate/surveys/utils/HtmlTextUtil$FontConfig;", "withCustomFonts", "FontConfig", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class HtmlTextUtil {
    public static final HtmlTextUtil INSTANCE = new HtmlTextUtil();

    private HtmlTextUtil() {
    }

    public final Spanned getStyledText(String htmlText, FontConfig fontConfig) {
        Intrinsics.checkNotNullParameter(htmlText, "htmlText");
        Spanned spannedFromHtml = HtmlCompat.fromHtml(htmlText, 0);
        Intrinsics.checkNotNullExpressionValue(spannedFromHtml, "fromHtml(...)");
        return (spannedFromHtml.length() == 0 || fontConfig == null) ? spannedFromHtml : withCustomFonts(spannedFromHtml, fontConfig);
    }

    private final Spanned withCustomFonts(Spanned spanned, FontConfig fontConfig) {
        Typeface italic;
        SpannableString spannableString = new SpannableString(spanned);
        boolean z = false;
        StyleSpan[] styleSpanArr = (StyleSpan[]) spannableString.getSpans(0, spannableString.length(), StyleSpan.class);
        Set setMutableSetOf = SetsKt.mutableSetOf(0, Integer.valueOf(spannableString.length()));
        Iterator it = ArrayIteratorKt.iterator(styleSpanArr);
        while (it.hasNext()) {
            StyleSpan styleSpan = (StyleSpan) it.next();
            setMutableSetOf.add(Integer.valueOf(spannableString.getSpanStart(styleSpan)));
            setMutableSetOf.add(Integer.valueOf(spannableString.getSpanEnd(styleSpan)));
        }
        List listSorted = CollectionsKt.sorted(setMutableSetOf);
        Iterator it2 = ArrayIteratorKt.iterator(styleSpanArr);
        while (it2.hasNext()) {
            spannableString.removeSpan((StyleSpan) it2.next());
        }
        int size = listSorted.size() - 1;
        int i = 0;
        while (i < size) {
            int iIntValue = ((Number) listSorted.get(i)).intValue();
            i++;
            int iIntValue2 = ((Number) listSorted.get(i)).intValue();
            Iterator it3 = ArrayIteratorKt.iterator(styleSpanArr);
            boolean z2 = z;
            boolean z3 = z2;
            while (it3.hasNext()) {
                StyleSpan styleSpan2 = (StyleSpan) it3.next();
                int spanStart = spanned.getSpanStart(styleSpan2);
                int spanEnd = spanned.getSpanEnd(styleSpan2);
                if (spanStart <= iIntValue && spanEnd >= iIntValue2) {
                    int style = styleSpan2.getStyle();
                    if (style == 1) {
                        z2 = true;
                    } else if (style == 2) {
                        z3 = true;
                    }
                }
            }
            if (z2 && z3) {
                italic = fontConfig.getBoldItalic();
            } else if (z2) {
                italic = fontConfig.getBold();
            } else if (z3) {
                italic = fontConfig.getItalic();
            } else {
                z = false;
            }
            spannableString.setSpan(new CustomTypefaceSpan(italic), iIntValue, iIntValue2, 33);
            z = false;
        }
        return spannableString;
    }

    /* JADX INFO: compiled from: HtmlTextUtil.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/utils/HtmlTextUtil$FontConfig;", "", TtmlNode.BOLD, "Landroid/graphics/Typeface;", TtmlNode.ITALIC, "boldItalic", "<init>", "(Landroid/graphics/Typeface;Landroid/graphics/Typeface;Landroid/graphics/Typeface;)V", "getBold", "()Landroid/graphics/Typeface;", "getItalic", "getBoldItalic", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final /* data */ class FontConfig {
        private final Typeface bold;
        private final Typeface boldItalic;
        private final Typeface italic;

        public static /* synthetic */ FontConfig copy$default(FontConfig fontConfig, Typeface typeface, Typeface typeface2, Typeface typeface3, int i, Object obj) {
            if ((i & 1) != 0) {
                typeface = fontConfig.bold;
            }
            if ((i & 2) != 0) {
                typeface2 = fontConfig.italic;
            }
            if ((i & 4) != 0) {
                typeface3 = fontConfig.boldItalic;
            }
            return fontConfig.copy(typeface, typeface2, typeface3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Typeface getBold() {
            return this.bold;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Typeface getItalic() {
            return this.italic;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Typeface getBoldItalic() {
            return this.boldItalic;
        }

        public final FontConfig copy(Typeface bold, Typeface italic, Typeface boldItalic) {
            Intrinsics.checkNotNullParameter(bold, "bold");
            Intrinsics.checkNotNullParameter(italic, "italic");
            Intrinsics.checkNotNullParameter(boldItalic, "boldItalic");
            return new FontConfig(bold, italic, boldItalic);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FontConfig)) {
                return false;
            }
            FontConfig fontConfig = (FontConfig) other;
            return Intrinsics.areEqual(this.bold, fontConfig.bold) && Intrinsics.areEqual(this.italic, fontConfig.italic) && Intrinsics.areEqual(this.boldItalic, fontConfig.boldItalic);
        }

        public int hashCode() {
            return (((this.bold.hashCode() * 31) + this.italic.hashCode()) * 31) + this.boldItalic.hashCode();
        }

        public String toString() {
            return "FontConfig(bold=" + this.bold + ", italic=" + this.italic + ", boldItalic=" + this.boldItalic + ')';
        }

        public FontConfig(Typeface bold, Typeface italic, Typeface boldItalic) {
            Intrinsics.checkNotNullParameter(bold, "bold");
            Intrinsics.checkNotNullParameter(italic, "italic");
            Intrinsics.checkNotNullParameter(boldItalic, "boldItalic");
            this.bold = bold;
            this.italic = italic;
            this.boldItalic = boldItalic;
        }

        public final Typeface getBold() {
            return this.bold;
        }

        public final Typeface getItalic() {
            return this.italic;
        }

        public final Typeface getBoldItalic() {
            return this.boldItalic;
        }
    }
}
