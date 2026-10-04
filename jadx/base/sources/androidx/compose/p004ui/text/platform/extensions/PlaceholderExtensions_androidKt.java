package androidx.compose.p004ui.text.platform.extensions;

import android.text.Spannable;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.Placeholder;
import androidx.compose.p004ui.text.PlaceholderVerticalAlign;
import androidx.compose.p004ui.text.android.style.PlaceholderSpan;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitType;
import androidx.emoji2.text.EmojiSpan;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PlaceholderExtensions.android.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a,\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u001e\u0010\u000e\u001a\u00020\f*\u00020\u000f8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u001e\u0010\u0014\u001a\u00020\f*\u00020\u00158BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m1599d2 = {"setPlaceholders", "", "Landroid/text/Spannable;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "setPlaceholder", "placeholder", TtmlNode.START, "", TtmlNode.END, "spanUnit", "Landroidx/compose/ui/unit/TextUnit;", "getSpanUnit--R2X_6o$annotations", "(J)V", "getSpanUnit--R2X_6o", "(J)I", "spanVerticalAlign", "Landroidx/compose/ui/text/PlaceholderVerticalAlign;", "getSpanVerticalAlign-do9X-Gg$annotations", "(I)V", "getSpanVerticalAlign-do9X-Gg", "(I)I", "ui-text"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class PlaceholderExtensions_androidKt {
    /* JADX INFO: renamed from: getSpanUnit--R2X_6o$annotations, reason: not valid java name */
    private static /* synthetic */ void m10737getSpanUnitR2X_6o$annotations(long j) {
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg$annotations, reason: not valid java name */
    private static /* synthetic */ void m10739getSpanVerticalAligndo9XGg$annotations(int i) {
    }

    private static final void setPlaceholder(Spannable spannable, Placeholder placeholder, int i, int i2, Density density) {
        for (Object obj : spannable.getSpans(i, i2, EmojiSpan.class)) {
            spannable.removeSpan((EmojiSpan) obj);
        }
        SpannableExtensions_androidKt.setSpan(spannable, new PlaceholderSpan(TextUnit.m11211getValueimpl(placeholder.getWidth()), m10736getSpanUnitR2X_6o(placeholder.getWidth()), TextUnit.m11211getValueimpl(placeholder.getHeight()), m10736getSpanUnitR2X_6o(placeholder.getHeight()), density, m10738getSpanVerticalAligndo9XGg(placeholder.getPlaceholderVerticalAlign())), i, i2);
    }

    /* JADX INFO: renamed from: getSpanUnit--R2X_6o, reason: not valid java name */
    private static final int m10736getSpanUnitR2X_6o(long j) {
        long jM11210getTypeUIouoOA = TextUnit.m11210getTypeUIouoOA(j);
        if (TextUnitType.m11239equalsimpl0(jM11210getTypeUIouoOA, TextUnitType.INSTANCE.m11244getSpUIouoOA())) {
            return 0;
        }
        return TextUnitType.m11239equalsimpl0(jM11210getTypeUIouoOA, TextUnitType.INSTANCE.m11243getEmUIouoOA()) ? 1 : 2;
    }

    /* JADX INFO: renamed from: getSpanVerticalAlign-do9X-Gg, reason: not valid java name */
    private static final int m10738getSpanVerticalAligndo9XGg(int i) {
        if (PlaceholderVerticalAlign.m10344equalsimpl0(i, PlaceholderVerticalAlign.INSTANCE.m10348getAboveBaselineJ6kI3mc())) {
            return 0;
        }
        if (PlaceholderVerticalAlign.m10344equalsimpl0(i, PlaceholderVerticalAlign.INSTANCE.m10354getTopJ6kI3mc())) {
            return 1;
        }
        if (PlaceholderVerticalAlign.m10344equalsimpl0(i, PlaceholderVerticalAlign.INSTANCE.m10349getBottomJ6kI3mc())) {
            return 2;
        }
        if (PlaceholderVerticalAlign.m10344equalsimpl0(i, PlaceholderVerticalAlign.INSTANCE.m10350getCenterJ6kI3mc())) {
            return 3;
        }
        if (PlaceholderVerticalAlign.m10344equalsimpl0(i, PlaceholderVerticalAlign.INSTANCE.m10353getTextTopJ6kI3mc())) {
            return 4;
        }
        if (PlaceholderVerticalAlign.m10344equalsimpl0(i, PlaceholderVerticalAlign.INSTANCE.m10351getTextBottomJ6kI3mc())) {
            return 5;
        }
        if (PlaceholderVerticalAlign.m10344equalsimpl0(i, PlaceholderVerticalAlign.INSTANCE.m10352getTextCenterJ6kI3mc())) {
            return 6;
        }
        throw new IllegalStateException("Invalid PlaceholderVerticalAlign".toString());
    }

    public static final void setPlaceholders(Spannable spannable, List<AnnotatedString.Range<Placeholder>> list, Density density) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<Placeholder> range = list.get(i);
            setPlaceholder(spannable, range.component1(), range.getStart(), range.getEnd(), density);
        }
    }
}
