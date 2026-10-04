package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.LayoutModifierNode;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, m1599d2 = {"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;F)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getFraction", "()F", "setFraction", "(F)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public FillNode(Direction direction, float f) {
        this.direction = direction;
        this.fraction = f;
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM10972getMinWidthimpl;
        int iM10970getMaxWidthimpl;
        int iM10969getMaxHeightimpl;
        int iM10969getMaxHeightimpl2;
        if (!Constraints.m10966getHasBoundedWidthimpl(j) || this.direction == Direction.Vertical) {
            iM10972getMinWidthimpl = Constraints.m10972getMinWidthimpl(j);
            iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(j);
        } else {
            int iRound = Math.round(Constraints.m10970getMaxWidthimpl(j) * this.fraction);
            int iM10972getMinWidthimpl2 = Constraints.m10972getMinWidthimpl(j);
            iM10972getMinWidthimpl = Constraints.m10970getMaxWidthimpl(j);
            if (iRound < iM10972getMinWidthimpl2) {
                iRound = iM10972getMinWidthimpl2;
            }
            if (iRound <= iM10972getMinWidthimpl) {
                iM10972getMinWidthimpl = iRound;
            }
            iM10970getMaxWidthimpl = iM10972getMinWidthimpl;
        }
        if (!Constraints.m10965getHasBoundedHeightimpl(j) || this.direction == Direction.Horizontal) {
            int iM10971getMinHeightimpl = Constraints.m10971getMinHeightimpl(j);
            iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(j);
            iM10969getMaxHeightimpl2 = iM10971getMinHeightimpl;
        } else {
            int iRound2 = Math.round(Constraints.m10969getMaxHeightimpl(j) * this.fraction);
            int iM10971getMinHeightimpl2 = Constraints.m10971getMinHeightimpl(j);
            iM10969getMaxHeightimpl2 = Constraints.m10969getMaxHeightimpl(j);
            if (iRound2 < iM10971getMinHeightimpl2) {
                iRound2 = iM10971getMinHeightimpl2;
            }
            if (iRound2 <= iM10969getMaxHeightimpl2) {
                iM10969getMaxHeightimpl2 = iRound2;
            }
            iM10969getMaxHeightimpl = iM10969getMaxHeightimpl2;
        }
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(ConstraintsKt.Constraints(iM10972getMinWidthimpl, iM10970getMaxWidthimpl, iM10969getMaxHeightimpl2, iM10969getMaxHeightimpl));
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.FillNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return FillNode.measure_3p2s80s$lambda$0(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
