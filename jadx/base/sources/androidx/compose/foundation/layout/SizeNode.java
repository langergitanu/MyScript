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
import androidx.compose.p004ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ#\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0016¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u0010-\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016J\u001c\u0010/\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u00100\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\u001c*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, m1599d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "F", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMaxHeight-D9Ej5fM", "setMaxHeight-0680j_4", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "foundation-layout"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? C1486Dp.INSTANCE.m11037getUnspecifiedD9Ej5fM() : f4, z, null);
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m2940setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m2939setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m2938setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMaxHeight() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m2937setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long m2932getTargetConstraintsOenEA2s(Density density) {
        int iMo2185roundToPx0680j_4;
        int iMo2185roundToPx0680j_42;
        int iMo2185roundToPx0680j_43;
        int i = 0;
        if (Float.isNaN(this.maxWidth)) {
            iMo2185roundToPx0680j_4 = Integer.MAX_VALUE;
        } else {
            iMo2185roundToPx0680j_4 = density.mo2185roundToPx0680j_4(this.maxWidth);
            if (iMo2185roundToPx0680j_4 < 0) {
                iMo2185roundToPx0680j_4 = 0;
            }
        }
        if (Float.isNaN(this.maxHeight)) {
            iMo2185roundToPx0680j_42 = Integer.MAX_VALUE;
        } else {
            iMo2185roundToPx0680j_42 = density.mo2185roundToPx0680j_4(this.maxHeight);
            if (iMo2185roundToPx0680j_42 < 0) {
                iMo2185roundToPx0680j_42 = 0;
            }
        }
        if (Float.isNaN(this.minWidth)) {
            iMo2185roundToPx0680j_43 = 0;
        } else {
            iMo2185roundToPx0680j_43 = density.mo2185roundToPx0680j_4(this.minWidth);
            if (iMo2185roundToPx0680j_43 < 0) {
                iMo2185roundToPx0680j_43 = 0;
            }
            if (iMo2185roundToPx0680j_43 > iMo2185roundToPx0680j_4) {
                iMo2185roundToPx0680j_43 = iMo2185roundToPx0680j_4;
            }
            if (iMo2185roundToPx0680j_43 == Integer.MAX_VALUE) {
            }
        }
        if (!Float.isNaN(this.minHeight)) {
            int iMo2185roundToPx0680j_44 = density.mo2185roundToPx0680j_4(this.minHeight);
            if (iMo2185roundToPx0680j_44 < 0) {
                iMo2185roundToPx0680j_44 = 0;
            }
            if (iMo2185roundToPx0680j_44 > iMo2185roundToPx0680j_42) {
                iMo2185roundToPx0680j_44 = iMo2185roundToPx0680j_42;
            }
            if (iMo2185roundToPx0680j_44 != Integer.MAX_VALUE) {
                i = iMo2185roundToPx0680j_44;
            }
        }
        return ConstraintsKt.Constraints(iMo2185roundToPx0680j_43, iMo2185roundToPx0680j_4, i, iMo2185roundToPx0680j_42);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int iM10972getMinWidthimpl;
        int iM10970getMaxWidthimpl;
        int iM10971getMinHeightimpl;
        int iM10969getMaxHeightimpl;
        long jConstraints;
        long jM2932getTargetConstraintsOenEA2s = m2932getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            jConstraints = ConstraintsKt.m10985constrainN9IONVI(j, jM2932getTargetConstraintsOenEA2s);
        } else {
            if (!Float.isNaN(this.minWidth)) {
                iM10972getMinWidthimpl = Constraints.m10972getMinWidthimpl(jM2932getTargetConstraintsOenEA2s);
            } else {
                iM10972getMinWidthimpl = Constraints.m10972getMinWidthimpl(j);
                int iM10970getMaxWidthimpl2 = Constraints.m10970getMaxWidthimpl(jM2932getTargetConstraintsOenEA2s);
                if (iM10972getMinWidthimpl > iM10970getMaxWidthimpl2) {
                    iM10972getMinWidthimpl = iM10970getMaxWidthimpl2;
                }
            }
            if (!Float.isNaN(this.maxWidth)) {
                iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(jM2932getTargetConstraintsOenEA2s);
            } else {
                iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(j);
                int iM10972getMinWidthimpl2 = Constraints.m10972getMinWidthimpl(jM2932getTargetConstraintsOenEA2s);
                if (iM10970getMaxWidthimpl < iM10972getMinWidthimpl2) {
                    iM10970getMaxWidthimpl = iM10972getMinWidthimpl2;
                }
            }
            if (!Float.isNaN(this.minHeight)) {
                iM10971getMinHeightimpl = Constraints.m10971getMinHeightimpl(jM2932getTargetConstraintsOenEA2s);
            } else {
                iM10971getMinHeightimpl = Constraints.m10971getMinHeightimpl(j);
                int iM10969getMaxHeightimpl2 = Constraints.m10969getMaxHeightimpl(jM2932getTargetConstraintsOenEA2s);
                if (iM10971getMinHeightimpl > iM10969getMaxHeightimpl2) {
                    iM10971getMinHeightimpl = iM10969getMaxHeightimpl2;
                }
            }
            if (!Float.isNaN(this.maxHeight)) {
                iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(jM2932getTargetConstraintsOenEA2s);
            } else {
                iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(j);
                int iM10971getMinHeightimpl2 = Constraints.m10971getMinHeightimpl(jM2932getTargetConstraintsOenEA2s);
                if (iM10969getMaxHeightimpl < iM10971getMinHeightimpl2) {
                    iM10969getMaxHeightimpl = iM10971getMinHeightimpl2;
                }
            }
            jConstraints = ConstraintsKt.Constraints(iM10972getMinWidthimpl, iM10970getMaxWidthimpl, iM10971getMinHeightimpl, iM10969getMaxHeightimpl);
        }
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(jConstraints);
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.SizeNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SizeNode.measure_3p2s80s$lambda$1(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM2932getTargetConstraintsOenEA2s = m2932getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m10968getHasFixedWidthimpl(jM2932getTargetConstraintsOenEA2s)) {
            return Constraints.m10970getMaxWidthimpl(jM2932getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m10986constrainHeightK40F9xA(jM2932getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m10987constrainWidthK40F9xA(jM2932getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM2932getTargetConstraintsOenEA2s = m2932getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m10967getHasFixedHeightimpl(jM2932getTargetConstraintsOenEA2s)) {
            return Constraints.m10969getMaxHeightimpl(jM2932getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m10987constrainWidthK40F9xA(jM2932getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m10986constrainHeightK40F9xA(jM2932getTargetConstraintsOenEA2s, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM2932getTargetConstraintsOenEA2s = m2932getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m10968getHasFixedWidthimpl(jM2932getTargetConstraintsOenEA2s)) {
            return Constraints.m10970getMaxWidthimpl(jM2932getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m10986constrainHeightK40F9xA(jM2932getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m10987constrainWidthK40F9xA(jM2932getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long jM2932getTargetConstraintsOenEA2s = m2932getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m10967getHasFixedHeightimpl(jM2932getTargetConstraintsOenEA2s)) {
            return Constraints.m10969getMaxHeightimpl(jM2932getTargetConstraintsOenEA2s);
        }
        if (!this.enforceIncoming) {
            i = ConstraintsKt.m10987constrainWidthK40F9xA(jM2932getTargetConstraintsOenEA2s, i);
        }
        return ConstraintsKt.m10986constrainHeightK40F9xA(jM2932getTargetConstraintsOenEA2s, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
