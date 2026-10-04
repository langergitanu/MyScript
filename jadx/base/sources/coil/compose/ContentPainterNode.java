package coil.compose;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.layout.ScaleFactor;
import androidx.compose.p004ui.layout.ScaleFactorKt;
import androidx.compose.p004ui.node.DrawModifierNode;
import androidx.compose.p004ui.node.LayoutModifierNode;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ContentPainterModifier.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u001c\u00101\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J\u001c\u00106\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J\u001c\u00107\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00108\u001a\u000202H\u0016J\u001c\u00109\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00108\u001a\u000202H\u0016J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b@\u0010>J\f\u0010A\u001a\u00020B*\u00020CH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006D"}, m1599d2 = {"Lcoil/compose/ContentPainterNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "coil-compose-base_release"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public ContentPainterNode(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(m12327modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: coil.compose.ContentPainterNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContentPainterNode.measure_3p2s80s$lambda$0(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
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
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m7980getUnspecifiedNHjbRc()) {
            int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m10969getMaxHeightimpl(m12327modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.m7972getWidthimpl(m12326calculateScaledSizeE7KxVPU(SizeKt.Size(iMinIntrinsicWidth, i)))), iMinIntrinsicWidth);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m7980getUnspecifiedNHjbRc()) {
            int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m10969getMaxHeightimpl(m12327modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.m7972getWidthimpl(m12326calculateScaledSizeE7KxVPU(SizeKt.Size(iMaxIntrinsicWidth, i)))), iMaxIntrinsicWidth);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m7980getUnspecifiedNHjbRc()) {
            int iMinIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m10970getMaxWidthimpl(m12327modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.m7969getHeightimpl(m12326calculateScaledSizeE7KxVPU(SizeKt.Size(i, iMinIntrinsicHeight)))), iMinIntrinsicHeight);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m7980getUnspecifiedNHjbRc()) {
            int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m10970getMaxWidthimpl(m12327modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.m7969getHeightimpl(m12326calculateScaledSizeE7KxVPU(SizeKt.Size(i, iMaxIntrinsicHeight)))), iMaxIntrinsicHeight);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m12326calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.m7974isEmptyimpl(dstSize)) {
            return Size.INSTANCE.m7981getZeroNHjbRc();
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == Size.INSTANCE.m7980getUnspecifiedNHjbRc()) {
            return dstSize;
        }
        float fM7972getWidthimpl = Size.m7972getWidthimpl(intrinsicSize);
        if (Float.isInfinite(fM7972getWidthimpl) || Float.isNaN(fM7972getWidthimpl)) {
            fM7972getWidthimpl = Size.m7972getWidthimpl(dstSize);
        }
        float fM7969getHeightimpl = Size.m7969getHeightimpl(intrinsicSize);
        if (Float.isInfinite(fM7969getHeightimpl) || Float.isNaN(fM7969getHeightimpl)) {
            fM7969getHeightimpl = Size.m7969getHeightimpl(dstSize);
        }
        long jSize = SizeKt.Size(fM7972getWidthimpl, fM7969getHeightimpl);
        long jMo9618computeScaleFactorH7hwNQA = this.contentScale.mo9618computeScaleFactorH7hwNQA(jSize, dstSize);
        float fM9741getScaleXimpl = ScaleFactor.m9741getScaleXimpl(jMo9618computeScaleFactorH7hwNQA);
        if (Float.isInfinite(fM9741getScaleXimpl) || Float.isNaN(fM9741getScaleXimpl)) {
            return dstSize;
        }
        float fM9742getScaleYimpl = ScaleFactor.m9742getScaleYimpl(jMo9618computeScaleFactorH7hwNQA);
        return (Float.isInfinite(fM9742getScaleYimpl) || Float.isNaN(fM9742getScaleYimpl)) ? dstSize : ScaleFactorKt.m9757timesmw2e94(jMo9618computeScaleFactorH7hwNQA, jSize);
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m12327modifyConstraintsZezNO4M(long constraints) {
        float fM10972getMinWidthimpl;
        int iM10971getMinHeightimpl;
        float fM12361constrainHeightK40F9xA;
        boolean zM10968getHasFixedWidthimpl = Constraints.m10968getHasFixedWidthimpl(constraints);
        boolean zM10967getHasFixedHeightimpl = Constraints.m10967getHasFixedHeightimpl(constraints);
        if (!zM10968getHasFixedWidthimpl || !zM10967getHasFixedHeightimpl) {
            boolean z = Constraints.m10966getHasBoundedWidthimpl(constraints) && Constraints.m10965getHasBoundedHeightimpl(constraints);
            long intrinsicSize = this.painter.getIntrinsicSize();
            if (intrinsicSize != Size.INSTANCE.m7980getUnspecifiedNHjbRc()) {
                if (z && (zM10968getHasFixedWidthimpl || zM10967getHasFixedHeightimpl)) {
                    fM10972getMinWidthimpl = Constraints.m10970getMaxWidthimpl(constraints);
                    iM10971getMinHeightimpl = Constraints.m10969getMaxHeightimpl(constraints);
                } else {
                    float fM7972getWidthimpl = Size.m7972getWidthimpl(intrinsicSize);
                    float fM7969getHeightimpl = Size.m7969getHeightimpl(intrinsicSize);
                    fM10972getMinWidthimpl = (Float.isInfinite(fM7972getWidthimpl) || Float.isNaN(fM7972getWidthimpl)) ? Constraints.m10972getMinWidthimpl(constraints) : UtilsKt.m12362constrainWidthK40F9xA(constraints, fM7972getWidthimpl);
                    if (Float.isInfinite(fM7969getHeightimpl) || Float.isNaN(fM7969getHeightimpl)) {
                        iM10971getMinHeightimpl = Constraints.m10971getMinHeightimpl(constraints);
                    } else {
                        fM12361constrainHeightK40F9xA = UtilsKt.m12361constrainHeightK40F9xA(constraints, fM7969getHeightimpl);
                        long jM12326calculateScaledSizeE7KxVPU = m12326calculateScaledSizeE7KxVPU(SizeKt.Size(fM10972getMinWidthimpl, fM12361constrainHeightK40F9xA));
                        return Constraints.m10960copyZbe2FdA$default(constraints, ConstraintsKt.m10987constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m7972getWidthimpl(jM12326calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m10986constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m7969getHeightimpl(jM12326calculateScaledSizeE7KxVPU))), 0, 10, null);
                    }
                }
                fM12361constrainHeightK40F9xA = iM10971getMinHeightimpl;
                long jM12326calculateScaledSizeE7KxVPU2 = m12326calculateScaledSizeE7KxVPU(SizeKt.Size(fM10972getMinWidthimpl, fM12361constrainHeightK40F9xA));
                return Constraints.m10960copyZbe2FdA$default(constraints, ConstraintsKt.m10987constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m7972getWidthimpl(jM12326calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m10986constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m7969getHeightimpl(jM12326calculateScaledSizeE7KxVPU2))), 0, 10, null);
            }
            if (z) {
                return Constraints.m10960copyZbe2FdA$default(constraints, Constraints.m10970getMaxWidthimpl(constraints), 0, Constraints.m10969getMaxHeightimpl(constraints), 0, 10, null);
            }
        }
        return constraints;
    }

    @Override // androidx.compose.p004ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long jM12326calculateScaledSizeE7KxVPU = m12326calculateScaledSizeE7KxVPU(contentDrawScope.mo8729getSizeNHjbRc());
        long jMo7571alignKFBX0sM = this.alignment.mo7571alignKFBX0sM(UtilsKt.m12364toIntSizeuvyYCjk(jM12326calculateScaledSizeE7KxVPU), UtilsKt.m12364toIntSizeuvyYCjk(contentDrawScope.mo8729getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float fM11137component1impl = IntOffset.m11137component1impl(jMo7571alignKFBX0sM);
        float fM11138component2impl = IntOffset.m11138component2impl(jMo7571alignKFBX0sM);
        contentDrawScope2.getDrawContext().getTransform().translate(fM11137component1impl, fM11138component2impl);
        this.painter.m8855drawx_KDEd0(contentDrawScope2, jM12326calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-fM11137component1impl, -fM11138component2impl);
        contentDrawScope.drawContent();
    }
}
