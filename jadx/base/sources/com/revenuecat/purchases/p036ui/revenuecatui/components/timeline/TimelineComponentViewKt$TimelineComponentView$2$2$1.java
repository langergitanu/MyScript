package com.revenuecat.purchases.p036ui.revenuecatui.components.timeline;

import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.State;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import androidx.constraintlayout.compose.VerticalAnchorable;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m1599d2 = {"<anonymous>", "", "Landroidx/constraintlayout/compose/ConstrainScope;", "invoke"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
final class TimelineComponentViewKt$TimelineComponentView$2$2$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ State<C1486Dp> $biggestIconWidth$delegate;
    final /* synthetic */ ConstraintLayoutBaseScope.HorizontalAnchor $currentPreviousItem;
    final /* synthetic */ ConstrainedLayoutReference $descriptionRef;
    final /* synthetic */ TimelineComponentState $timelineState;
    final /* synthetic */ ConstrainedLayoutReference $titleRef;

    /* JADX INFO: compiled from: TimelineComponentView.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TimelineComponent.IconAlignment.values().length];
            try {
                iArr[TimelineComponent.IconAlignment.Title.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TimelineComponent.IconAlignment.TitleAndDescription.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$2$1(TimelineComponentState timelineComponentState, ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, ConstrainedLayoutReference constrainedLayoutReference, ConstrainedLayoutReference constrainedLayoutReference2, State<C1486Dp> state) {
        super(1);
        this.$timelineState = timelineComponentState;
        this.$currentPreviousItem = horizontalAnchor;
        this.$titleRef = constrainedLayoutReference;
        this.$descriptionRef = constrainedLayoutReference2;
        this.$biggestIconWidth$delegate = state;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(ConstrainScope constrainAs) {
        Dimension wrapContent;
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        int i = WhenMappings.$EnumSwitchMapping$0[this.$timelineState.getIconAlignment().ordinal()];
        if (i == 1) {
            HorizontalAnchorable top = constrainAs.getTop();
            ConstraintLayoutBaseScope.HorizontalAnchor top2 = this.$currentPreviousItem;
            if (top2 == null) {
                top2 = constrainAs.getParent().getTop();
            }
            HorizontalAnchorable.m11395linkToVpY3zN4$default(top, top2, 0.0f, 0.0f, 6, (Object) null);
            VerticalAnchorable.m11489linkToVpY3zN4$default(constrainAs.getStart(), constrainAs.getParent().getStart(), 0.0f, 0.0f, 6, null);
        } else if (i == 2) {
            HorizontalAnchorable.m11395linkToVpY3zN4$default(constrainAs.getTop(), this.$titleRef.getTop(), 0.0f, 0.0f, 6, (Object) null);
            HorizontalAnchorable.m11395linkToVpY3zN4$default(constrainAs.getBottom(), this.$descriptionRef.getBottom(), 0.0f, 0.0f, 6, (Object) null);
            VerticalAnchorable.m11489linkToVpY3zN4$default(constrainAs.getStart(), constrainAs.getParent().getStart(), 0.0f, 0.0f, 6, null);
        }
        C1486Dp c1486DpTimelineComponentView$lambda$13$lambda$1 = TimelineComponentViewKt.TimelineComponentView$lambda$13$lambda$1(this.$biggestIconWidth$delegate);
        if (c1486DpTimelineComponentView$lambda$13$lambda$1 != null) {
            wrapContent = Dimension.INSTANCE.m11377value0680j_4(c1486DpTimelineComponentView$lambda$13$lambda$1.m11031unboximpl());
            if (wrapContent == null) {
                wrapContent = Dimension.INSTANCE.getWrapContent();
            }
        }
        constrainAs.setWidth(wrapContent);
    }
}
