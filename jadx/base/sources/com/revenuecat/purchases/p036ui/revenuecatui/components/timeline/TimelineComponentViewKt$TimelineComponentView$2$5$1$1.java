package com.revenuecat.purchases.p036ui.revenuecatui.components.timeline;

import androidx.compose.p004ui.unit.C1486Dp;
import androidx.constraintlayout.compose.ConstrainScope;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.compose.HorizontalAnchorable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, m1599d2 = {"<anonymous>", "", "Landroidx/constraintlayout/compose/ConstrainScope;", "invoke"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
final class TimelineComponentViewKt$TimelineComponentView$2$5$1$1 extends Lambda implements Function1<ConstrainScope, Unit> {
    final /* synthetic */ TimelineComponentState $timelineState;
    final /* synthetic */ ConstrainedLayoutReference $titleRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimelineComponentViewKt$TimelineComponentView$2$5$1$1(ConstrainedLayoutReference constrainedLayoutReference, TimelineComponentState timelineComponentState) {
        super(1);
        this.$titleRef = constrainedLayoutReference;
        this.$timelineState = timelineComponentState;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConstrainScope constrainScope) {
        invoke2(constrainScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConstrainScope constrainAs) {
        Intrinsics.checkNotNullParameter(constrainAs, "$this$constrainAs");
        HorizontalAnchorable.m11395linkToVpY3zN4$default(constrainAs.getTop(), this.$titleRef.getBottom(), C1486Dp.m11017constructorimpl(this.$timelineState.getTextSpacing()), 0.0f, 4, (Object) null);
        ConstrainScope.m11295linkTo8ZKsbrE$default(constrainAs, this.$titleRef.getStart(), constrainAs.getParent().getEnd(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 60, (Object) null);
        constrainAs.setWidth(Dimension.INSTANCE.getPreferredWrapContent());
        constrainAs.setHeight(Dimension.INSTANCE.getPreferredWrapContent());
    }
}
