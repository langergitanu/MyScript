package com.revenuecat.purchases.p036ui.revenuecatui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import com.revenuecat.purchases.p036ui.revenuecatui.workflow.NavigationDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowTransitionState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\u0082\u0001\u0001\u0011¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState;", "", "()V", "animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "animatingFromStepId", "", "getAnimatingFromStepId", "()Ljava/lang/String;", "animatingToStepId", "getAnimatingToStepId", "Companion", "SlideInOut", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState$SlideInOut;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class WorkflowTransitionState {
    public static final int $stable = 0;
    public static final int SLIDE_DURATION_MS = 350;

    public /* synthetic */ WorkflowTransitionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Animatable<Float, AnimationVector1D> getAnimatable();

    public abstract String getAnimatingFromStepId();

    public abstract String getAnimatingToStepId();

    private WorkflowTransitionState() {
    }

    /* JADX INFO: compiled from: WorkflowTransitionState.kt */
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState$SlideInOut;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState;", "animatingFromStepId", "", "animatingToStepId", "animatingDirection", "Lcom/revenuecat/purchases/ui/revenuecatui/workflow/NavigationDirection;", "animatable", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/workflow/NavigationDirection;Landroidx/compose/animation/core/Animatable;)V", "getAnimatable", "()Landroidx/compose/animation/core/Animatable;", "getAnimatingDirection", "()Lcom/revenuecat/purchases/ui/revenuecatui/workflow/NavigationDirection;", "getAnimatingFromStepId", "()Ljava/lang/String;", "getAnimatingToStepId", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class SlideInOut extends WorkflowTransitionState {
        public static final int $stable = Animatable.$stable;
        private final Animatable<Float, AnimationVector1D> animatable;
        private final NavigationDirection animatingDirection;
        private final String animatingFromStepId;
        private final String animatingToStepId;

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState
        public String getAnimatingFromStepId() {
            return this.animatingFromStepId;
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState
        public String getAnimatingToStepId() {
            return this.animatingToStepId;
        }

        public final NavigationDirection getAnimatingDirection() {
            return this.animatingDirection;
        }

        @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState
        public Animatable<Float, AnimationVector1D> getAnimatable() {
            return this.animatable;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SlideInOut(String str, String animatingToStepId, NavigationDirection navigationDirection, Animatable<Float, AnimationVector1D> animatable) {
            super(null);
            Intrinsics.checkNotNullParameter(animatingToStepId, "animatingToStepId");
            Intrinsics.checkNotNullParameter(animatable, "animatable");
            this.animatingFromStepId = str;
            this.animatingToStepId = animatingToStepId;
            this.animatingDirection = navigationDirection;
            this.animatable = animatable;
        }
    }
}
