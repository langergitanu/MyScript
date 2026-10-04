package com.revenuecat.purchases.p036ui.revenuecatui.components;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionAnimation;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowPaywallUiState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowPendingTransition;
import com.revenuecat.purchases.p036ui.revenuecatui.workflow.NavigationDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WorkflowTransitionState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a:\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0000\u001a,\u0010\u0017\u001a\u00020\n*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002\u001a\u0012\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d*\u00020\fH\u0002\u001a$\u0010\u001e\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¨\u0006 ²\u0006%\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u008a\u0084\u0002"}, m1599d2 = {"rememberWorkflowTransitionState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState;", "workflowState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;", "onTransitionComplete", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "transitionId", "", "transition", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionAnimation;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;Lkotlin/jvm/functions/Function1;Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionAnimation;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState;", "workflowSlideTranslationX", "", "stepId", "", "animatingToStepId", "animatingFromStepId", "progress", "width", "directionFactor", "applyWorkflowTransition", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "state", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "toAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "workflowTransition", "Landroidx/compose/ui/Modifier;", "revenuecatui_defaultsRelease", "latestOnTransitionComplete"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class WorkflowTransitionStateKt {
    public static final WorkflowTransitionState rememberWorkflowTransitionState(WorkflowPaywallUiState workflowState, Function1<? super Integer, Unit> onTransitionComplete, WorkflowTransitionAnimation workflowTransitionAnimation, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(workflowState, "workflowState");
        Intrinsics.checkNotNullParameter(onTransitionComplete, "onTransitionComplete");
        composer.startReplaceGroup(-681319424);
        ComposerKt.sourceInformation(composer, "C(rememberWorkflowTransitionState)P(2)95@4620L42,97@4706L263,97@4668L301:WorkflowTransitionState.kt#dnqhhd");
        if ((i2 & 4) != 0) {
            workflowTransitionAnimation = new WorkflowTransitionAnimation.SlideInOut(0, null, 3, null);
        }
        WorkflowTransitionAnimation workflowTransitionAnimation2 = workflowTransitionAnimation;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-681319424, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.rememberWorkflowTransitionState (WorkflowTransitionState.kt:82)");
        }
        String currentStepId = workflowState.getCurrentStepId();
        WorkflowPendingTransition pendingTransition = workflowState.getPendingTransition();
        composer.startMovableGroup(1696122510, pendingTransition != null ? Integer.valueOf(pendingTransition.getId()) : null);
        ComposerKt.sourceInformation(composer, "90@4334L66");
        composer.startReplaceGroup(1696123651);
        ComposerKt.sourceInformation(composer, "CC(remember):WorkflowTransitionState.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = AnimatableKt.Animatable$default(pendingTransition != null ? 0.0f : 1.0f, 0.0f, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        Animatable animatable = (Animatable) objRememberedValue;
        composer.endReplaceGroup();
        composer.endMovableGroup();
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onTransitionComplete, composer, (i >> 3) & 14);
        Integer numValueOf = pendingTransition != null ? Integer.valueOf(pendingTransition.getId()) : null;
        composer.startReplaceGroup(1696135752);
        ComposerKt.sourceInformation(composer, "CC(remember):WorkflowTransitionState.kt#9igjgp");
        boolean zChanged = composer.changed(pendingTransition) | composer.changedInstance(animatable) | ((((i & 896) ^ RendererCapabilities.DECODER_SUPPORT_MASK) > 256 && composer.changed(workflowTransitionAnimation2)) || (i & RendererCapabilities.DECODER_SUPPORT_MASK) == 256) | composer.changed(stateRememberUpdatedState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new WorkflowTransitionStateKt$rememberWorkflowTransitionState$1$1(pendingTransition, animatable, workflowTransitionAnimation2, stateRememberUpdatedState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, 0);
        if (workflowTransitionAnimation2 instanceof WorkflowTransitionAnimation.SlideInOut) {
            WorkflowTransitionState.SlideInOut slideInOut = new WorkflowTransitionState.SlideInOut(pendingTransition != null ? pendingTransition.getFromStepId() : null, currentStepId, pendingTransition != null ? pendingTransition.getDirection() : null, animatable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return slideInOut;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Modifier workflowTransition(Modifier modifier, final WorkflowTransitionState state, final String stepId, final LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(stepId, "stepId");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.WorkflowTransitionStateKt.workflowTransition.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayer) {
                Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                WorkflowTransitionState workflowTransitionState = state;
                WorkflowTransitionStateKt.applyWorkflowTransition(graphicsLayer, workflowTransitionState, stepId, layoutDirection, workflowTransitionState.getAnimatable().getValue().floatValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyWorkflowTransition(GraphicsLayerScope graphicsLayerScope, WorkflowTransitionState workflowTransitionState, String str, LayoutDirection layoutDirection, float f) {
        if (!(workflowTransitionState instanceof WorkflowTransitionState.SlideInOut)) {
            throw new NoWhenBranchMatchedException();
        }
        graphicsLayerScope.setTranslationX(workflowSlideTranslationX(str, workflowTransitionState.getAnimatingToStepId(), workflowTransitionState.getAnimatingFromStepId(), f, Size.m7972getWidthimpl(graphicsLayerScope.getSize()), (((WorkflowTransitionState.SlideInOut) workflowTransitionState).getAnimatingDirection() == NavigationDirection.FORWARD ? 1.0f : -1.0f) * (layoutDirection == LayoutDirection.Rtl ? -1.0f : 1.0f)));
    }

    public static final float workflowSlideTranslationX(String stepId, String animatingToStepId, String str, float f, float f2, float f3) {
        Intrinsics.checkNotNullParameter(stepId, "stepId");
        Intrinsics.checkNotNullParameter(animatingToStepId, "animatingToStepId");
        float fRoundToInt = MathKt.roundToInt((1.0f - f) * f3 * f2);
        if (Intrinsics.areEqual(stepId, animatingToStepId)) {
            return fRoundToInt;
        }
        if (Intrinsics.areEqual(stepId, str)) {
            return fRoundToInt - (f3 * f2);
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec<Float> toAnimationSpec(WorkflowTransitionAnimation workflowTransitionAnimation) {
        if (!(workflowTransitionAnimation instanceof WorkflowTransitionAnimation.SlideInOut)) {
            throw new NoWhenBranchMatchedException();
        }
        WorkflowTransitionAnimation.SlideInOut slideInOut = (WorkflowTransitionAnimation.SlideInOut) workflowTransitionAnimation;
        return AnimationSpecKt.tween$default(slideInOut.getDurationMs(), 0, slideInOut.getEasing(), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Integer, Unit> rememberWorkflowTransitionState$lambda$1(State<? extends Function1<? super Integer, Unit>> state) {
        return (Function1) state.getValue();
    }
}
