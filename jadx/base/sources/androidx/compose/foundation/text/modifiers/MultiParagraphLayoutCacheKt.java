package androidx.compose.foundation.text.modifiers;

import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: MultiParagraphLayoutCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"times", "Landroidx/compose/ui/unit/TextUnit;", "other", "times-NB67dxo", "(JJ)J", "DefaultFontSize", "J", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MultiParagraphLayoutCacheKt {
    private static final long DefaultFontSize = TextUnitKt.getSp(14);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: times-NB67dxo, reason: not valid java name */
    public static final long m3940timesNB67dxo(long j, long j2) {
        if (TextUnit.m11213isEmimpl(j2)) {
            if (TextUnit.m11213isEmimpl(j)) {
                throw new IllegalStateException("Cannot convert Em to Px when style.fontSize is Em (" + ((Object) TextUnit.m11218toStringimpl(j2)) + "). Please declare the style.fontSize with Sp units instead.");
            }
            if (TextUnit.m11209getRawTypeimpl(j) == 0) {
                long j3 = DefaultFontSize;
                float fM11211getValueimpl = TextUnit.m11211getValueimpl(j2);
                TextUnitKt.m11224checkArithmeticR2X_6o(j3);
                return TextUnitKt.pack(TextUnit.m11209getRawTypeimpl(j3), TextUnit.m11211getValueimpl(j3) * fM11211getValueimpl);
            }
            float fM11211getValueimpl2 = TextUnit.m11211getValueimpl(j2);
            TextUnitKt.m11224checkArithmeticR2X_6o(j);
            return TextUnitKt.pack(TextUnit.m11209getRawTypeimpl(j), TextUnit.m11211getValueimpl(j) * fM11211getValueimpl2);
        }
        throw new IllegalArgumentException("The multiplier must be in em, but was " + ((Object) TextUnit.m11218toStringimpl(j2)) + '.');
    }
}
