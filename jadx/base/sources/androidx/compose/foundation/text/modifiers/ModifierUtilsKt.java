package androidx.compose.foundation.text.modifiers;

import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.Constraints;
import kotlin.Metadata;

/* JADX INFO: compiled from: ModifierUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"maxWidthForTextLayout", "", "Landroidx/compose/ui/unit/Constraints;", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "maxWidthForTextLayout-R2G3SPE", "(JZI)I", "foundation"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ModifierUtilsKt {
    /* JADX INFO: renamed from: maxWidthForTextLayout-R2G3SPE, reason: not valid java name */
    public static final int m3927maxWidthForTextLayoutR2G3SPE(long j, boolean z, int i) {
        if ((z || TextOverflow.m10943equalsimpl0(i, TextOverflow.INSTANCE.m10953getEllipsisgIe3tQ8())) && Constraints.m10966getHasBoundedWidthimpl(j)) {
            return Constraints.m10970getMaxWidthimpl(j);
        }
        return Integer.MAX_VALUE;
    }
}
