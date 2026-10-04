package androidx.compose.p004ui.node;

import androidx.compose.p004ui.internal.InlineClassHelperKt;
import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.layout.HorizontalAlignmentLine;
import androidx.compose.p004ui.unit.IntOffset;
import kotlin.Metadata;

/* JADX INFO: compiled from: LayoutModifierNodeCoordinator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, m1599d2 = {"calculateAlignmentAndPlaceChildAsNeeded", "", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ui"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class LayoutModifierNodeCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable lookaheadCapablePlaceable, AlignmentLine alignmentLine) {
        int iM11145getXimpl;
        LookaheadCapablePlaceable child = lookaheadCapablePlaceable.getChild();
        if (!(child != null)) {
            InlineClassHelperKt.throwIllegalStateException("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line");
        }
        if (lookaheadCapablePlaceable.getMeasureResult$ui().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = lookaheadCapablePlaceable.getMeasureResult$ui().getAlignmentLines().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        int i = child.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        child.setShallowPlacing$ui(true);
        lookaheadCapablePlaceable.setPlacingForAlignment$ui(true);
        lookaheadCapablePlaceable.replace$ui();
        child.setShallowPlacing$ui(false);
        lookaheadCapablePlaceable.setPlacingForAlignment$ui(false);
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            iM11145getXimpl = IntOffset.m11146getYimpl(child.getPosition());
        } else {
            iM11145getXimpl = IntOffset.m11145getXimpl(child.getPosition());
        }
        return i + iM11145getXimpl;
    }
}
