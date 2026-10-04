package androidx.compose.p004ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.p004ui.text.android.SpannedExtensions_androidKt;
import androidx.compose.p004ui.text.android.TextLayout;
import androidx.compose.p004ui.text.android.style.IndentationFixSpan;
import androidx.compose.p004ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.p004ui.text.style.Hyphens;
import androidx.compose.p004ui.text.style.LineBreak;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidParagraph.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0005\u001a\u0017\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0005\u001a\u0017\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0005\u001a\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0005\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u001fH\u0002\u001a\u0013\u0010 \u001a\u00020\u0001*\u00020!H\u0002¢\u0006\u0004\b\"\u0010\u0005¨\u0006#"}, m1599d2 = {"toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-aXe7zB0", "(I)I", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency--3fSNIE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-xImikfE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-hpcqdu8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-wPN0Rpw", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "attachIndentationFixSpan", "", "toLayoutTextGranularity", "Landroidx/compose/ui/text/TextGranularity;", "toLayoutTextGranularity-duNsdkg", "ui-text"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutAlign-aXe7zB0, reason: not valid java name */
    public static final int m10252toLayoutAlignaXe7zB0(int i) {
        if (TextAlign.m10891equalsimpl0(i, TextAlign.INSTANCE.m10898getLefte0LSkKk())) {
            return 3;
        }
        if (TextAlign.m10891equalsimpl0(i, TextAlign.INSTANCE.m10899getRighte0LSkKk())) {
            return 4;
        }
        if (TextAlign.m10891equalsimpl0(i, TextAlign.INSTANCE.m10895getCentere0LSkKk())) {
            return 2;
        }
        return (!TextAlign.m10891equalsimpl0(i, TextAlign.INSTANCE.m10900getStarte0LSkKk()) && TextAlign.m10891equalsimpl0(i, TextAlign.INSTANCE.m10896getEnde0LSkKk())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutHyphenationFrequency--3fSNIE, reason: not valid java name */
    public static final int m10254toLayoutHyphenationFrequency3fSNIE(int i) {
        if (Hyphens.m10783equalsimpl0(i, Hyphens.INSTANCE.m10787getAutovmbZdU8())) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        Hyphens.m10783equalsimpl0(i, Hyphens.INSTANCE.m10788getNonevmbZdU8());
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutBreakStrategy-xImikfE, reason: not valid java name */
    public static final int m10253toLayoutBreakStrategyxImikfE(int i) {
        if (LineBreak.Strategy.m10817equalsimpl0(i, LineBreak.Strategy.INSTANCE.m10823getSimplefcGXIks())) {
            return 0;
        }
        if (LineBreak.Strategy.m10817equalsimpl0(i, LineBreak.Strategy.INSTANCE.m10822getHighQualityfcGXIks())) {
            return 1;
        }
        return LineBreak.Strategy.m10817equalsimpl0(i, LineBreak.Strategy.INSTANCE.m10821getBalancedfcGXIks()) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakStyle-hpcqdu8, reason: not valid java name */
    public static final int m10255toLayoutLineBreakStylehpcqdu8(int i) {
        if (LineBreak.Strictness.m10828equalsimpl0(i, LineBreak.Strictness.INSTANCE.m10832getDefaultusljTpc())) {
            return 0;
        }
        if (LineBreak.Strictness.m10828equalsimpl0(i, LineBreak.Strictness.INSTANCE.m10833getLooseusljTpc())) {
            return 1;
        }
        if (LineBreak.Strictness.m10828equalsimpl0(i, LineBreak.Strictness.INSTANCE.m10834getNormalusljTpc())) {
            return 2;
        }
        return LineBreak.Strictness.m10828equalsimpl0(i, LineBreak.Strictness.INSTANCE.m10835getStrictusljTpc()) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutLineBreakWordStyle-wPN0Rpw, reason: not valid java name */
    public static final int m10256toLayoutLineBreakWordStylewPN0Rpw(int i) {
        return (!LineBreak.WordBreak.m10840equalsimpl0(i, LineBreak.WordBreak.INSTANCE.m10844getDefaultjp8hJ3c()) && LineBreak.WordBreak.m10840equalsimpl0(i, LineBreak.WordBreak.INSTANCE.m10845getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        return (!z || TextUnit.m11208equalsimpl0(textStyle.m10489getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m11208equalsimpl0(textStyle.m10489getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE()) || TextAlign.m10891equalsimpl0(textStyle.m10494getTextAligne0LSkKk(), TextAlign.INSTANCE.m10901getUnspecifiede0LSkKk()) || TextAlign.m10891equalsimpl0(textStyle.m10494getTextAligne0LSkKk(), TextAlign.INSTANCE.m10900getStarte0LSkKk()) || TextAlign.m10891equalsimpl0(textStyle.m10494getTextAligne0LSkKk(), TextAlign.INSTANCE.m10897getJustifye0LSkKk())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        SpannableString spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : null;
        if (spannableString == null) {
            spannableString = new SpannableString(charSequence);
        }
        if (!SpannedExtensions_androidKt.hasSpan(spannableString, IndentationFixSpan.class)) {
            SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toLayoutTextGranularity-duNsdkg, reason: not valid java name */
    public static final int m10257toLayoutTextGranularityduNsdkg(int i) {
        return (!TextGranularity.m10410equalsimpl0(i, TextGranularity.INSTANCE.m10414getCharacterDRrd7Zo()) && TextGranularity.m10410equalsimpl0(i, TextGranularity.INSTANCE.m10415getWordDRrd7Zo())) ? 1 : 0;
    }
}
