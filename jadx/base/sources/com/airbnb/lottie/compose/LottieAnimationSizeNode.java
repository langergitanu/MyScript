package com.airbnb.lottie.compose;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.LayoutModifierNode;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LottieAnimationSizeNode.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J&\u0010\r\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, m1599d2 = {"Lcom/airbnb/lottie/compose/LottieAnimationSizeNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "width", "", "height", "(II)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "lottie-compose_release"}, m1600k = 1, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottieAnimationSizeNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private int height;
    private int width;

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public LottieAnimationSizeNode(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo1775measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        long jConstraints;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long jM10984constrain4WqzIAM = ConstraintsKt.m10984constrain4WqzIAM(j, IntSizeKt.IntSize(this.width, this.height));
        if (Constraints.m10969getMaxHeightimpl(j) == Integer.MAX_VALUE && Constraints.m10970getMaxWidthimpl(j) != Integer.MAX_VALUE) {
            jConstraints = ConstraintsKt.Constraints(IntSize.m11188getWidthimpl(jM10984constrain4WqzIAM), IntSize.m11188getWidthimpl(jM10984constrain4WqzIAM), (IntSize.m11188getWidthimpl(jM10984constrain4WqzIAM) * this.height) / this.width, (IntSize.m11188getWidthimpl(jM10984constrain4WqzIAM) * this.height) / this.width);
        } else if (Constraints.m10970getMaxWidthimpl(j) == Integer.MAX_VALUE && Constraints.m10969getMaxHeightimpl(j) != Integer.MAX_VALUE) {
            jConstraints = ConstraintsKt.Constraints((IntSize.m11187getHeightimpl(jM10984constrain4WqzIAM) * this.width) / this.height, (IntSize.m11187getHeightimpl(jM10984constrain4WqzIAM) * this.width) / this.height, IntSize.m11187getHeightimpl(jM10984constrain4WqzIAM), IntSize.m11187getHeightimpl(jM10984constrain4WqzIAM));
        } else {
            jConstraints = ConstraintsKt.Constraints(IntSize.m11188getWidthimpl(jM10984constrain4WqzIAM), IntSize.m11188getWidthimpl(jM10984constrain4WqzIAM), IntSize.m11187getHeightimpl(jM10984constrain4WqzIAM), IntSize.m11187getHeightimpl(jM10984constrain4WqzIAM));
        }
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(jConstraints);
        return MeasureScope.layout$default(measure, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.airbnb.lottie.compose.LottieAnimationSizeNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
