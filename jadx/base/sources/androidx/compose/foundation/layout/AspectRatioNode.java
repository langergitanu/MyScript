package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.LayoutModifierNode;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AspectRatio.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010\u001f\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001bH\u0016J\u001c\u0010 \u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u001c\u0010\"\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0016J\u0013\u0010#\u001a\u00020$*\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010*J\u001b\u0010-\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010*J\u001b\u0010/\u001a\u00020$*\u00020\u00172\u0006\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010*R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00061"}, m1599d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "<init>", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "findSize", "Landroidx/compose/ui/unit/IntSize;", "findSize-ToXhtMw", "(J)J", "tryMaxWidth", "enforceConstraints", "tryMaxWidth-JN-0ABg", "(JZ)J", "tryMaxHeight", "tryMaxHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "foundation-layout"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long jM2548findSizeToXhtMw = m2548findSizeToXhtMw(j);
        if (!IntSize.m11186equalsimpl0(jM2548findSizeToXhtMw, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m10980fixedJhjzzOo((int) (jM2548findSizeToXhtMw >> 32), (int) (jM2548findSizeToXhtMw & 4294967295L));
        }
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.AspectRatioNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AspectRatioNode.measure_3p2s80s$lambda$0(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
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
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m2548findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long jM2550tryMaxWidthJN0ABg = m2550tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m11186equalsimpl0(jM2550tryMaxWidthJN0ABg, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2550tryMaxWidthJN0ABg;
            }
            long jM2549tryMaxHeightJN0ABg = m2549tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m11186equalsimpl0(jM2549tryMaxHeightJN0ABg, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2549tryMaxHeightJN0ABg;
            }
            long jM2552tryMinWidthJN0ABg = m2552tryMinWidthJN0ABg(j, true);
            if (!IntSize.m11186equalsimpl0(jM2552tryMinWidthJN0ABg, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2552tryMinWidthJN0ABg;
            }
            long jM2551tryMinHeightJN0ABg = m2551tryMinHeightJN0ABg(j, true);
            if (!IntSize.m11186equalsimpl0(jM2551tryMinHeightJN0ABg, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2551tryMinHeightJN0ABg;
            }
            long jM2550tryMaxWidthJN0ABg2 = m2550tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m11186equalsimpl0(jM2550tryMaxWidthJN0ABg2, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2550tryMaxWidthJN0ABg2;
            }
            long jM2549tryMaxHeightJN0ABg2 = m2549tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m11186equalsimpl0(jM2549tryMaxHeightJN0ABg2, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2549tryMaxHeightJN0ABg2;
            }
            long jM2552tryMinWidthJN0ABg2 = m2552tryMinWidthJN0ABg(j, false);
            if (!IntSize.m11186equalsimpl0(jM2552tryMinWidthJN0ABg2, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2552tryMinWidthJN0ABg2;
            }
            long jM2551tryMinHeightJN0ABg2 = m2551tryMinHeightJN0ABg(j, false);
            if (!IntSize.m11186equalsimpl0(jM2551tryMinHeightJN0ABg2, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2551tryMinHeightJN0ABg2;
            }
        } else {
            long jM2549tryMaxHeightJN0ABg3 = m2549tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m11186equalsimpl0(jM2549tryMaxHeightJN0ABg3, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2549tryMaxHeightJN0ABg3;
            }
            long jM2550tryMaxWidthJN0ABg3 = m2550tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m11186equalsimpl0(jM2550tryMaxWidthJN0ABg3, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2550tryMaxWidthJN0ABg3;
            }
            long jM2551tryMinHeightJN0ABg3 = m2551tryMinHeightJN0ABg(j, true);
            if (!IntSize.m11186equalsimpl0(jM2551tryMinHeightJN0ABg3, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2551tryMinHeightJN0ABg3;
            }
            long jM2552tryMinWidthJN0ABg3 = m2552tryMinWidthJN0ABg(j, true);
            if (!IntSize.m11186equalsimpl0(jM2552tryMinWidthJN0ABg3, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2552tryMinWidthJN0ABg3;
            }
            long jM2549tryMaxHeightJN0ABg4 = m2549tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m11186equalsimpl0(jM2549tryMaxHeightJN0ABg4, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2549tryMaxHeightJN0ABg4;
            }
            long jM2550tryMaxWidthJN0ABg4 = m2550tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m11186equalsimpl0(jM2550tryMaxWidthJN0ABg4, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2550tryMaxWidthJN0ABg4;
            }
            long jM2551tryMinHeightJN0ABg4 = m2551tryMinHeightJN0ABg(j, false);
            if (!IntSize.m11186equalsimpl0(jM2551tryMinHeightJN0ABg4, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2551tryMinHeightJN0ABg4;
            }
            long jM2552tryMinWidthJN0ABg4 = m2552tryMinWidthJN0ABg(j, false);
            if (!IntSize.m11186equalsimpl0(jM2552tryMinWidthJN0ABg4, IntSize.INSTANCE.m11193getZeroYbymL2g())) {
                return jM2552tryMinWidthJN0ABg4;
            }
        }
        return IntSize.INSTANCE.m11193getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m2550tryMaxWidthJN0ABg(long j, boolean z) {
        int iRound;
        int iM10970getMaxWidthimpl = Constraints.m10970getMaxWidthimpl(j);
        if (iM10970getMaxWidthimpl == Integer.MAX_VALUE || (iRound = Math.round(iM10970getMaxWidthimpl / this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m2546isSatisfiedByNN6EwU(j, iM10970getMaxWidthimpl, iRound))) {
            return IntSize.INSTANCE.m11193getZeroYbymL2g();
        }
        return IntSize.m11183constructorimpl((((long) iM10970getMaxWidthimpl) << 32) | (((long) iRound) & 4294967295L));
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m2549tryMaxHeightJN0ABg(long j, boolean z) {
        int iRound;
        int iM10969getMaxHeightimpl = Constraints.m10969getMaxHeightimpl(j);
        if (iM10969getMaxHeightimpl == Integer.MAX_VALUE || (iRound = Math.round(iM10969getMaxHeightimpl * this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m2546isSatisfiedByNN6EwU(j, iRound, iM10969getMaxHeightimpl))) {
            return IntSize.INSTANCE.m11193getZeroYbymL2g();
        }
        return IntSize.m11183constructorimpl((((long) iRound) << 32) | (((long) iM10969getMaxHeightimpl) & 4294967295L));
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m2552tryMinWidthJN0ABg(long j, boolean z) {
        int iM10972getMinWidthimpl = Constraints.m10972getMinWidthimpl(j);
        int iRound = Math.round(iM10972getMinWidthimpl / this.aspectRatio);
        if (iRound <= 0 || (z && !AspectRatioKt.m2546isSatisfiedByNN6EwU(j, iM10972getMinWidthimpl, iRound))) {
            return IntSize.INSTANCE.m11193getZeroYbymL2g();
        }
        return IntSize.m11183constructorimpl((((long) iM10972getMinWidthimpl) << 32) | (((long) iRound) & 4294967295L));
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m2551tryMinHeightJN0ABg(long j, boolean z) {
        int iM10971getMinHeightimpl = Constraints.m10971getMinHeightimpl(j);
        int iRound = Math.round(iM10971getMinHeightimpl * this.aspectRatio);
        if (iRound <= 0 || (z && !AspectRatioKt.m2546isSatisfiedByNN6EwU(j, iRound, iM10971getMinHeightimpl))) {
            return IntSize.INSTANCE.m11193getZeroYbymL2g();
        }
        return IntSize.m11183constructorimpl((((long) iRound) << 32) | (((long) iM10971getMinHeightimpl) & 4294967295L));
    }
}
