package androidx.compose.foundation.layout;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.LayoutModifierNode;
import androidx.compose.p004ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WindowInsetsPadding.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J#\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u001c\u0010\u001e\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u001c\u0010 \u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u001c\u0010!\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, m1599d2 = {"Landroidx/compose/foundation/layout/RecalculateWindowInsetsModifierNode;", "Landroidx/compose/foundation/layout/InsetsConsumingModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "<init>", "()V", "insets", "Landroidx/compose/foundation/layout/ValueInsets;", "getInsets", "()Landroidx/compose/foundation/layout/ValueInsets;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "calculateInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "ancestorConsumedInsets", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "foundation-layout"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class RecalculateWindowInsetsModifierNode extends InsetsConsumingModifierNode implements LayoutModifierNode {
    private final ValueInsets insets = new ValueInsets(new InsetsValues(0, 0, 0, 0), "reset");

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final ValueInsets getInsets() {
        return this.insets;
    }

    @Override // androidx.compose.foundation.layout.InsetsConsumingModifierNode
    public WindowInsets calculateInsets(WindowInsets ancestorConsumedInsets) {
        return this.insets.getValue$foundation_layout().getLeft() == -1 ? ancestorConsumedInsets : this.insets;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measureScope, final Measurable measurable, long j) {
        if (!Constraints.m10968getHasFixedWidthimpl(j) || !Constraints.m10967getHasFixedHeightimpl(j)) {
            if (this.insets.getValue$foundation_layout().getLeft() != -1) {
                this.insets.setValue$foundation_layout(new InsetsValues(-1, -1, -1, -1));
                insetsInvalidated();
            }
            final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.RecalculateWindowInsetsModifierNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RecalculateWindowInsetsModifierNode.measure_3p2s80s$lambda$0(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        final int iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(j);
        final int iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(j);
        return MeasureScope.layout$default(measureScope, iM10970getMaxWidthimpl, iM10969getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.layout.RecalculateWindowInsetsModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RecalculateWindowInsetsModifierNode.measure_3p2s80s$lambda$1(this.f$0, measurable, iM10970getMaxWidthimpl, iM10969getMaxHeightimpl, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(RecalculateWindowInsetsModifierNode recalculateWindowInsetsModifierNode, Measurable measurable, int i, int i2, Placeable.PlacementScope placementScope) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates != null) {
            long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
            long jMo9633getSizeYbymL2g = coordinates.mo9633getSizeYbymL2g();
            long jMo9636localToRootMKHz9U = coordinates.mo9636localToRootMKHz9U(Offset.m7895constructorimpl((((long) Float.floatToRawIntBits((int) (jMo9633getSizeYbymL2g & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (jMo9633getSizeYbymL2g >> 32)) << 32)));
            long jMo9633getSizeYbymL2g2 = LayoutCoordinatesKt.findRootCoordinates(coordinates).mo9633getSizeYbymL2g();
            int iRound = Math.round(Float.intBitsToFloat((int) (jPositionInRoot >> 32)));
            int iRound2 = Math.round(Float.intBitsToFloat((int) (jPositionInRoot & 4294967295L)));
            int iRound3 = ((int) (jMo9633getSizeYbymL2g2 >> 32)) - Math.round(Float.intBitsToFloat((int) (jMo9636localToRootMKHz9U >> 32)));
            int iRound4 = ((int) (jMo9633getSizeYbymL2g2 & 4294967295L)) - Math.round(Float.intBitsToFloat((int) (jMo9636localToRootMKHz9U & 4294967295L)));
            InsetsValues value$foundation_layout = recalculateWindowInsetsModifierNode.insets.getValue$foundation_layout();
            if (value$foundation_layout.getLeft() != iRound || value$foundation_layout.getTop() != iRound2 || value$foundation_layout.getRight() != iRound3 || value$foundation_layout.getBottom() != iRound4) {
                recalculateWindowInsetsModifierNode.insets.setValue$foundation_layout(new InsetsValues(iRound, iRound2, iRound3, iRound4));
                recalculateWindowInsetsModifierNode.insetsInvalidated();
            }
        }
        Placeable.PlacementScope.place$default(placementScope, measurable.mo9625measureBRTryo0(Constraints.INSTANCE.m10980fixedJhjzzOo(i, i2)), 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }
}
