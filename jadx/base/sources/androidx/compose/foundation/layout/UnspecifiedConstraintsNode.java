package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.LayoutModifierNode;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u001c\u0010\u001d\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u001c\u0010\u001e\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u001c\u0010 \u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006!"}, m1599d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "F", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "foundation-layout"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    private UnspecifiedConstraintsNode(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM() : f2, null);
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m2947setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m2946setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM10972getMinWidthimpl;
        int iM10971getMinHeightimpl;
        if (!Float.isNaN(this.minWidth) && Constraints.m10972getMinWidthimpl(j) == 0) {
            int i = measureScope.mo2185roundToPx0680j_4(this.minWidth);
            iM10972getMinWidthimpl = Constraints.m10970getMaxWidthimpl(j);
            if (i < 0) {
                i = 0;
            }
            if (i <= iM10972getMinWidthimpl) {
                iM10972getMinWidthimpl = i;
            }
        } else {
            iM10972getMinWidthimpl = Constraints.m10972getMinWidthimpl(j);
        }
        int iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(j);
        if (!Float.isNaN(this.minHeight) && Constraints.m10971getMinHeightimpl(j) == 0) {
            int i2 = measureScope.mo2185roundToPx0680j_4(this.minHeight);
            iM10971getMinHeightimpl = Constraints.m10969getMaxHeightimpl(j);
            int i3 = i2 >= 0 ? i2 : 0;
            if (i3 <= iM10971getMinHeightimpl) {
                iM10971getMinHeightimpl = i3;
            }
        } else {
            iM10971getMinHeightimpl = Constraints.m10971getMinHeightimpl(j);
        }
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(ConstraintsKt.Constraints(iM10972getMinWidthimpl, iM10970getMaxWidthimpl, iM10971getMinHeightimpl, Constraints.m10969getMaxHeightimpl(j)));
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnspecifiedConstraintsNode.measure_3p2s80s$lambda$0(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(i);
        int i2 = !Float.isNaN(this.minWidth) ? intrinsicMeasureScope.mo2185roundToPx0680j_4(this.minWidth) : 0;
        return iMinIntrinsicWidth < i2 ? i2 : iMinIntrinsicWidth;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
        int i2 = !Float.isNaN(this.minWidth) ? intrinsicMeasureScope.mo2185roundToPx0680j_4(this.minWidth) : 0;
        return iMaxIntrinsicWidth < i2 ? i2 : iMaxIntrinsicWidth;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        int iMinIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(i);
        int i2 = !Float.isNaN(this.minHeight) ? intrinsicMeasureScope.mo2185roundToPx0680j_4(this.minHeight) : 0;
        return iMinIntrinsicHeight < i2 ? i2 : iMinIntrinsicHeight;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(i);
        int i2 = !Float.isNaN(this.minHeight) ? intrinsicMeasureScope.mo2185roundToPx0680j_4(this.minHeight) : 0;
        return iMaxIntrinsicHeight < i2 ? i2 : iMaxIntrinsicHeight;
    }
}
