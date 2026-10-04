package com.revenuecat.purchases.p036ui.revenuecatui.components;

import android.content.res.Configuration;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.layout.LayoutModifierKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionAnimation;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowPaywallUiState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowPendingTransition;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.p036ui.revenuecatui.workflow.NavigationDirection;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: LoadedWorkflowPaywall.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ax\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001aY\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u001e\u001a]\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00182\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a0!2\u0006\u0010\u001c\u001a\u00020\u001d2\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\"\u001a\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0000\u001a.\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u00182\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020+0!2\b\u0010,\u001a\u0004\u0018\u00010-H\u0000\u001a\"\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020+H\u0002\u001a,\u00104\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u00182\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a0!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u001c\u00105\u001a\u00020\u0012*\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¨\u00066"}, m1599d2 = {"LoadedWorkflowPaywall", "", "workflowState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;", "onTransitionComplete", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "transitionId", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lkotlin/coroutines/Continuation;", "", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "modifier", "Landroidx/compose/ui/Modifier;", "transition", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionAnimation;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionAnimation;Landroidx/compose/runtime/Composer;II)V", "WorkflowStepContent", "stepId", "", "stepState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "currentStepId", "transitionState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState;Lkotlin/jvm/functions/Function2;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;I)V", "WorkflowStepsContent", "stepStates", "", "(Ljava/lang/String;Ljava/util/Map;Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowTransitionState;Lkotlin/jvm/functions/Function2;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;I)V", "headerAlpha", "", "role", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowHeaderTransitionRole;", "progress", "selectWorkflowHeaderPresentation", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowHeaderPresentation;", "stepInfoByStepId", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowHeaderStepInfo;", "pendingTransition", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPendingTransition;", "shouldUseOutgoingHeader", "", "direction", "Lcom/revenuecat/purchases/ui/revenuecatui/workflow/NavigationDirection;", "fromStepInfo", "toStepInfo", "workflowHeaderState", "workflowHeaderFade", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class LoadedWorkflowPaywallKt {

    /* JADX INFO: compiled from: LoadedWorkflowPaywall.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkflowHeaderTransitionRole.values().length];
            try {
                iArr[WorkflowHeaderTransitionRole.ENTERING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkflowHeaderTransitionRole.LEAVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkflowHeaderTransitionRole.STABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Modifier workflowHeaderFade(Modifier modifier, final WorkflowHeaderTransitionRole role, final WorkflowTransitionState transitionState) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(transitionState, "transitionState");
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt.workflowHeaderFade.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m13866invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m13866invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final float fHeaderAlpha = LoadedWorkflowPaywallKt.headerAlpha(role, transitionState.getAnimatable().getValue().floatValue());
                final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(j);
                return MeasureScope.layout$default(layout, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt.workflowHeaderFade.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        if (fHeaderAlpha > 0.0f) {
                            Placeable placeable = placeableMo9625measureBRTryo0;
                            final float f = fHeaderAlpha;
                            Placeable.PlacementScope.placeWithLayer$default(layout2, placeable, 0, 0, 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt.workflowHeaderFade.1.1.1
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
                                public final void invoke2(GraphicsLayerScope placeWithLayer) {
                                    Intrinsics.checkNotNullParameter(placeWithLayer, "$this$placeWithLayer");
                                    placeWithLayer.setAlpha(f);
                                }
                            }, 4, (Object) null);
                        }
                    }
                }, 4, null);
            }
        });
    }

    public static final float headerAlpha(WorkflowHeaderTransitionRole role, float f) {
        Intrinsics.checkNotNullParameter(role, "role");
        int i = WhenMappings.$EnumSwitchMapping$0[role.ordinal()];
        if (i == 1) {
            return f;
        }
        if (i == 2) {
            return 1.0f - f;
        }
        if (i == 3) {
            return 1.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoadedWorkflowPaywall(final WorkflowPaywallUiState workflowState, final Function1<? super Integer, Unit> onTransitionComplete, final Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> clickHandler, final PaywallComponentInteractionTracker componentInteractionTracker, Modifier modifier, WorkflowTransitionAnimation workflowTransitionAnimation, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        WorkflowTransitionAnimation workflowTransitionAnimation2;
        Modifier.Companion companion;
        int i4;
        final WorkflowTransitionAnimation slideInOut;
        PaywallState.Loaded.Components components;
        boolean z;
        final ComposableLambda composableLambdaRememberComposableLambda;
        Composer composer2;
        final Modifier modifier3;
        final WorkflowTransitionAnimation workflowTransitionAnimation3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(workflowState, "workflowState");
        Intrinsics.checkNotNullParameter(onTransitionComplete, "onTransitionComplete");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Intrinsics.checkNotNullParameter(componentInteractionTracker, "componentInteractionTracker");
        Composer composerStartRestartGroup = composer.startRestartGroup(1519628723);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedWorkflowPaywall)P(5,3)82@3522L7,85@3617L163,97@4086L102,100@4246L101,128@5552L1008,123@5359L1201:LoadedWorkflowPaywall.kt#dnqhhd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(workflowState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onTransitionComplete) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(clickHandler) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(componentInteractionTracker) : composerStartRestartGroup.changedInstance(componentInteractionTracker) ? 2048 : 1024;
        }
        int i5 = i2 & 16;
        if (i5 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    workflowTransitionAnimation2 = workflowTransitionAnimation;
                    int i6 = composerStartRestartGroup.changed(workflowTransitionAnimation2) ? 131072 : 65536;
                    i3 |= i6;
                } else {
                    workflowTransitionAnimation2 = workflowTransitionAnimation;
                }
                i3 |= i6;
            } else {
                workflowTransitionAnimation2 = workflowTransitionAnimation;
            }
            if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 32) == 0) {
                        i4 = i3 & (-458753);
                        slideInOut = new WorkflowTransitionAnimation.SlideInOut(0, null, 3, null);
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1519628723, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywall (LoadedWorkflowPaywall.kt:74)");
                    }
                    final String currentStepId = workflowState.getCurrentStepId();
                    final Map<String, PaywallState.Loaded.Components> stepStates = workflowState.getStepStates();
                    components = stepStates.get(currentStepId);
                    if (components == null) {
                        Logger.INSTANCE.m1584e("Workflow step '" + currentStepId + "' not found in stepStates — rendering nothing");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup2 != null) {
                            final Modifier modifier4 = companion;
                            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$LoadedWorkflowPaywall$currentState$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i7) {
                                    LoadedWorkflowPaywallKt.LoadedWorkflowPaywall(workflowState, onTransitionComplete, clickHandler, componentInteractionTracker, modifier4, slideInOut, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    WorkflowTransitionAnimation workflowTransitionAnimation4 = slideInOut;
                    ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localConfiguration);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    PaywallState.Loaded.Components.update$default(components, ((Configuration) objConsume).getLocales(), null, null, 6, null);
                    int i7 = i4 >> 9;
                    final WorkflowTransitionState workflowTransitionStateRememberWorkflowTransitionState = WorkflowTransitionStateKt.rememberWorkflowTransitionState(workflowState, onTransitionComplete, workflowTransitionAnimation4, composerStartRestartGroup, (i4 & WebSocketProtocol.PAYLOAD_SHORT) | (i7 & 896), 0);
                    final WorkflowHeaderPresentation workflowHeaderPresentationWorkflowHeaderState = workflowHeaderState(currentStepId, stepStates, workflowTransitionStateRememberWorkflowTransitionState);
                    PaywallState.Loaded.Components components2 = stepStates.get(workflowHeaderPresentationWorkflowHeaderState.getHeaderStepId());
                    if (components2 == null) {
                        components2 = components;
                    }
                    composerStartRestartGroup.startReplaceGroup(-486640763);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedWorkflowPaywall.kt#9igjgp");
                    int i8 = i4 & 7168;
                    boolean zChanged = composerStartRestartGroup.changed(components) | composerStartRestartGroup.changedInstance(clickHandler) | (i8 == 2048 || ((i4 & 4096) != 0 && composerStartRestartGroup.changedInstance(componentInteractionTracker)));
                    LoadedWorkflowPaywallKt$LoadedWorkflowPaywall$onClick$1$1 loadedWorkflowPaywallKt$LoadedWorkflowPaywall$onClick$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || loadedWorkflowPaywallKt$LoadedWorkflowPaywall$onClick$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        loadedWorkflowPaywallKt$LoadedWorkflowPaywall$onClick$1$1RememberedValue = new LoadedWorkflowPaywallKt$LoadedWorkflowPaywall$onClick$1$1(components, clickHandler, componentInteractionTracker, null);
                        composerStartRestartGroup.updateRememberedValue(loadedWorkflowPaywallKt$LoadedWorkflowPaywall$onClick$1$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-486635644);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedWorkflowPaywall.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(components2) | composerStartRestartGroup.changedInstance(clickHandler) | (i8 == 2048 || ((i4 & 4096) != 0 && composerStartRestartGroup.changedInstance(componentInteractionTracker)));
                    LoadedWorkflowPaywallKt$LoadedWorkflowPaywall$headerOnClick$1$1 loadedWorkflowPaywallKt$LoadedWorkflowPaywall$headerOnClick$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || loadedWorkflowPaywallKt$LoadedWorkflowPaywall$headerOnClick$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        loadedWorkflowPaywallKt$LoadedWorkflowPaywall$headerOnClick$1$1RememberedValue = new LoadedWorkflowPaywallKt$LoadedWorkflowPaywall$headerOnClick$1$1(components2, clickHandler, componentInteractionTracker, null);
                        composerStartRestartGroup.updateRememberedValue(loadedWorkflowPaywallKt$LoadedWorkflowPaywall$headerOnClick$1$1RememberedValue);
                    }
                    final Function2 function2 = (Function2) loadedWorkflowPaywallKt$LoadedWorkflowPaywall$headerOnClick$1$1RememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    boolean z2 = workflowHeaderPresentationWorkflowHeaderState.getRole() == WorkflowHeaderTransitionRole.LEAVING;
                    final ComponentStyle header = components2.getHeader();
                    composerStartRestartGroup.startReplaceGroup(-486611388);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*111@5025L322");
                    if (header == null) {
                        composableLambdaRememberComposableLambda = null;
                        z = true;
                    } else {
                        final PaywallState.Loaded.Components components3 = components2;
                        z = true;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(229644996, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$LoadedWorkflowPaywall$headerComposable$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i9) {
                                ComposerKt.sourceInformation(composer3, "C112@5039L298:LoadedWorkflowPaywall.kt#dnqhhd");
                                if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(229644996, i9, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywall.<anonymous>.<anonymous> (LoadedWorkflowPaywall.kt:112)");
                                    }
                                    ComponentViewKt.ComponentView(header, components3, function2, LoadedWorkflowPaywallKt.workflowHeaderFade(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), workflowHeaderPresentationWorkflowHeaderState.getRole(), workflowTransitionStateRememberWorkflowTransitionState), null, composer3, 0, 16);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposableLambda composableLambda = z2 ? null : composableLambdaRememberComposableLambda;
                    final boolean z3 = z2;
                    Modifier modifier5 = companion;
                    LoadedPaywallComponentsKt.PaywallComponentsScaffold(components, modifier5, null, composableLambda, null, ComposableLambdaKt.rememberComposableLambda(-423939707, z, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt.LoadedWorkflowPaywall.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i9) {
                            ComposerKt.sourceInformation(composer3, "C:LoadedWorkflowPaywall.kt#dnqhhd");
                            if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-423939707, i9, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywall.<anonymous> (LoadedWorkflowPaywall.kt:129)");
                                }
                                if (z3 && composableLambdaRememberComposableLambda != null) {
                                    composer3.startReplaceGroup(2126648697);
                                    ComposerKt.sourceInformation(composer3, "132@5807L413");
                                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    String str = currentStepId;
                                    Map<String, PaywallState.Loaded.Components> map = stepStates;
                                    WorkflowTransitionState workflowTransitionState = workflowTransitionStateRememberWorkflowTransitionState;
                                    Function2<PaywallAction.External, Continuation<? super Unit>, Object> function22 = clickHandler;
                                    PaywallComponentInteractionTracker paywallComponentInteractionTracker = componentInteractionTracker;
                                    Function2<Composer, Integer, Unit> function23 = composableLambdaRememberComposableLambda;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxSize$default);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer3);
                                    Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 977263077, "C133@5853L318,140@6188L18:LoadedWorkflowPaywall.kt#dnqhhd");
                                    LoadedWorkflowPaywallKt.WorkflowStepsContent(str, map, workflowTransitionState, function22, paywallComponentInteractionTracker, composer3, 0);
                                    function23.invoke(composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceGroup();
                                } else {
                                    composer3.startReplaceGroup(2127259366);
                                    ComposerKt.sourceInformation(composer3, "143@6250L294");
                                    LoadedWorkflowPaywallKt.WorkflowStepsContent(currentStepId, stepStates, workflowTransitionStateRememberWorkflowTransitionState, clickHandler, componentInteractionTracker, composer3, 0);
                                    composer3.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i7 & 112) | 196992, 16);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    workflowTransitionAnimation3 = workflowTransitionAnimation4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    companion = modifier2;
                }
                i4 = i3;
                slideInOut = workflowTransitionAnimation2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final String currentStepId2 = workflowState.getCurrentStepId();
                final Map<String, PaywallState.Loaded.Components> stepStates2 = workflowState.getStepStates();
                components = stepStates2.get(currentStepId2);
                if (components == null) {
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                workflowTransitionAnimation3 = workflowTransitionAnimation2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt.LoadedWorkflowPaywall.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i9) {
                        LoadedWorkflowPaywallKt.LoadedWorkflowPaywall(workflowState, onTransitionComplete, clickHandler, componentInteractionTracker, modifier3, workflowTransitionAnimation3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        modifier2 = modifier;
        if ((196608 & i) != 0) {
        }
        if ((74899 & i3) == 74898) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i5 == 0) {
                }
                if ((i2 & 32) == 0) {
                    i4 = i3;
                    slideInOut = workflowTransitionAnimation2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final String currentStepId22 = workflowState.getCurrentStepId();
                final Map<String, PaywallState.Loaded.Components> stepStates22 = workflowState.getStepStates();
                components = stepStates22.get(currentStepId22);
                if (components == null) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WorkflowStepsContent(final String str, final Map<String, PaywallState.Loaded.Components> map, final WorkflowTransitionState workflowTransitionState, final Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, final PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i) {
        String str2;
        int i2;
        WorkflowTransitionState workflowTransitionState2;
        Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function22;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
        Composer composerStartRestartGroup = composer.startRestartGroup(-132441160);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WorkflowStepsContent)P(2,3,4)196@8322L705:LoadedWorkflowPaywall.kt#dnqhhd");
        if ((i & 6) == 0) {
            str2 = str;
            i2 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(map) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            workflowTransitionState2 = workflowTransitionState;
            i2 |= composerStartRestartGroup.changed(workflowTransitionState2) ? 256 : 128;
        } else {
            workflowTransitionState2 = workflowTransitionState;
        }
        if ((i & 3072) == 0) {
            function22 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker2) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker2) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((i3 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-132441160, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.WorkflowStepsContent (LoadedWorkflowPaywall.kt:191)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1818188582, "C:LoadedWorkflowPaywall.kt#dnqhhd");
            composerStartRestartGroup.startReplaceGroup(1742467142);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            for (String str3 : CollectionsKt.listOfNotNull((Object[]) new String[]{workflowTransitionState2.getAnimatingFromStepId(), workflowTransitionState2.getAnimatingToStepId()})) {
                PaywallState.Loaded.Components components = map.get(str3);
                if (components != null) {
                    composerStartRestartGroup.startMovableGroup(738994286, str3);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@8609L380");
                    int i4 = i3 << 3;
                    WorkflowStepContent(str3, components, str2, workflowTransitionState2, function22, paywallComponentInteractionTracker2, composerStartRestartGroup, ((i3 << 6) & 896) | (i4 & 7168) | (57344 & i4) | (i4 & 458752));
                    composerStartRestartGroup.endMovableGroup();
                }
                str2 = str;
                workflowTransitionState2 = workflowTransitionState;
                function22 = function2;
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt.WorkflowStepsContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    LoadedWorkflowPaywallKt.WorkflowStepsContent(str, map, workflowTransitionState, function2, paywallComponentInteractionTracker, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WorkflowStepContent(final String str, final PaywallState.Loaded.Components components, final String str2, final WorkflowTransitionState workflowTransitionState, final Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, final PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1642511534);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WorkflowStepContent)P(3,4,2,5)232@9896L138,238@10166L45,240@10341L21,241@10410L7,243@10423L2065:LoadedWorkflowPaywall.kt#dnqhhd");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(components) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(workflowTransitionState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= (i & 262144) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker) ? 131072 : 65536;
        }
        int i3 = i2;
        if ((74899 & i3) != 74898 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1642511534, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.WorkflowStepContent (LoadedWorkflowPaywall.kt:230)");
            }
            boolean zAreEqual = Intrinsics.areEqual(str, str2);
            composerStartRestartGroup.startReplaceGroup(347672073);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedWorkflowPaywall.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(zAreEqual) | ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(function2) | ((458752 & i3) == 131072 || ((i3 & 262144) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker)));
            LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1 loadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || loadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                loadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1RememberedValue = new LoadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1(zAreEqual, components, function2, paywallComponentInteractionTracker, null);
                composerStartRestartGroup.updateRememberedValue(loadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1RememberedValue);
            }
            final Function2 function22 = (Function2) loadedWorkflowPaywallKt$WorkflowStepContent$onClick$1$1RememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            final PaywallComponentInteractionTracker paywallComponentInteractionTracker2 = zAreEqual ? paywallComponentInteractionTracker : new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$$ExternalSyntheticLambda0
                @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                    Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                }
            };
            BackgroundStyle backgroundStyleRememberBackgroundStyle = BackgroundStyleKt.rememberBackgroundStyle(components.getBackground(), composerStartRestartGroup, 0);
            final boolean zShouldWrapMainContentInVerticalScroll = LoadedPaywallComponentsKt.shouldWrapMainContentInVerticalScroll(components.getStack());
            final ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierBackground$default = BackgroundKt.background$default(WorkflowTransitionStateKt.workflowTransition(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), workflowTransitionState, str, (LayoutDirection) objConsume), backgroundStyleRememberBackgroundStyle, (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBackground$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 416172085, "C253@10766L1716,249@10610L1872:LoadedWorkflowPaywall.kt#dnqhhd");
            composer2 = composerStartRestartGroup;
            WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyleRememberBackgroundStyle, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, ComposableLambdaKt.rememberComposableLambda(2081745505, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$WorkflowStepContent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ComposerKt.sourceInformation(composer3, "C261@11253L1219,257@11078L1394:LoadedWorkflowPaywall.kt#dnqhhd");
                    if ((i4 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2081745505, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.WorkflowStepContent.<anonymous>.<anonymous> (LoadedWorkflowPaywall.kt:257)");
                        }
                        PaywallState.Loaded.Components components2 = components;
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        boolean z = components.getStickyFooter() != null;
                        final PaywallState.Loaded.Components components3 = components;
                        final boolean z2 = zShouldWrapMainContentInVerticalScroll;
                        final ScrollState scrollState = scrollStateRememberScrollState;
                        final Function2<PaywallAction, Continuation<? super Unit>, Object> function23 = function22;
                        final PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker2;
                        LoadedPaywallComponentsKt.OverlayLayout(components2, modifierFillMaxSize$default, false, z, ComposableLambdaKt.rememberComposableLambda(-1998286250, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$WorkflowStepContent$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i5) {
                                ComposerKt.sourceInformation(composer4, "C269@11623L87,272@11810L83,275@11963L86,262@11271L797,*280@12150L290:LoadedWorkflowPaywall.kt#dnqhhd");
                                if ((i5 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1998286250, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.WorkflowStepContent.<anonymous>.<anonymous>.<anonymous> (LoadedWorkflowPaywall.kt:262)");
                                    }
                                    ComponentStyle stack = components3.getStack();
                                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                    boolean z3 = z2;
                                    composer4.startReplaceGroup(-1152432973);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):LoadedWorkflowPaywall.kt#9igjgp");
                                    boolean zChanged2 = composer4.changed(scrollState);
                                    final ScrollState scrollState2 = scrollState;
                                    Object objRememberedValue = composer4.rememberedValue();
                                    if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$WorkflowStepContent$1$1$1$1$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Modifier invoke(Modifier conditional) {
                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                return ScrollKt.verticalScroll$default(conditional, scrollState2, false, null, false, 14, null);
                                            }
                                        };
                                        composer4.updateRememberedValue(objRememberedValue);
                                    }
                                    composer4.endReplaceGroup();
                                    Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierFillMaxSize$default2, z3, (Function1) objRememberedValue);
                                    boolean z4 = (components3.getHeader() == null || components3.getMainStackHasHeroImage()) ? false : true;
                                    composer4.startReplaceGroup(-1152426993);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):LoadedWorkflowPaywall.kt#9igjgp");
                                    boolean zChanged3 = composer4.changed(components3);
                                    final PaywallState.Loaded.Components components4 = components3;
                                    Object objRememberedValue2 = composer4.rememberedValue();
                                    if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$WorkflowStepContent$1$1$1$2$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Modifier invoke(Modifier conditional) {
                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                return LoadedPaywallComponentsKt.headerTopPadding(conditional, components4);
                                            }
                                        };
                                        composer4.updateRememberedValue(objRememberedValue2);
                                    }
                                    composer4.endReplaceGroup();
                                    Modifier modifierConditional2 = ModifierExtensionsKt.conditional(modifierConditional, z4, (Function1) objRememberedValue2);
                                    boolean z5 = components3.getStickyFooter() != null;
                                    composer4.startReplaceGroup(-1152422094);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):LoadedWorkflowPaywall.kt#9igjgp");
                                    boolean zChanged4 = composer4.changed(components3);
                                    final PaywallState.Loaded.Components components5 = components3;
                                    Object objRememberedValue3 = composer4.rememberedValue();
                                    if (zChanged4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt$WorkflowStepContent$1$1$1$3$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Modifier invoke(Modifier conditional) {
                                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                return LoadedPaywallComponentsKt.footerBottomPadding(conditional, components5);
                                            }
                                        };
                                        composer4.updateRememberedValue(objRememberedValue3);
                                    }
                                    composer4.endReplaceGroup();
                                    ComponentViewKt.ComponentView(stack, components3, function23, ModifierExtensionsKt.conditional(modifierConditional2, z5, (Function1) objRememberedValue3), paywallComponentInteractionTracker3, composer4, 0, 0);
                                    ComponentStyle stickyFooter = components3.getStickyFooter();
                                    if (stickyFooter != null) {
                                        ComponentViewKt.ComponentView(stickyFooter, components3, function23, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paywallComponentInteractionTracker3, composer4, 3072, 0);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }, composer3, 54), composer3, 24624, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 24960, 8);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedWorkflowPaywallKt.WorkflowStepContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    LoadedWorkflowPaywallKt.WorkflowStepContent(str, components, str2, workflowTransitionState, function2, paywallComponentInteractionTracker, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final WorkflowHeaderPresentation selectWorkflowHeaderPresentation(String currentStepId, Map<String, WorkflowHeaderStepInfo> stepInfoByStepId, WorkflowPendingTransition workflowPendingTransition) {
        String fromStepId;
        Intrinsics.checkNotNullParameter(currentStepId, "currentStepId");
        Intrinsics.checkNotNullParameter(stepInfoByStepId, "stepInfoByStepId");
        if (workflowPendingTransition == null || (fromStepId = workflowPendingTransition.getFromStepId()) == null) {
            return new WorkflowHeaderPresentation(currentStepId, WorkflowHeaderTransitionRole.STABLE);
        }
        WorkflowHeaderStepInfo workflowHeaderStepInfo = stepInfoByStepId.get(fromStepId);
        WorkflowHeaderStepInfo workflowHeaderStepInfo2 = stepInfoByStepId.get(currentStepId);
        boolean z = workflowHeaderStepInfo != null && workflowHeaderStepInfo.getHasHeader();
        boolean z2 = workflowHeaderStepInfo2 != null && workflowHeaderStepInfo2.getHasHeader();
        if (z && !z2) {
            return new WorkflowHeaderPresentation(fromStepId, WorkflowHeaderTransitionRole.LEAVING);
        }
        if (!z && z2) {
            return new WorkflowHeaderPresentation(currentStepId, WorkflowHeaderTransitionRole.ENTERING);
        }
        if (z && z2) {
            NavigationDirection direction = workflowPendingTransition.getDirection();
            Intrinsics.checkNotNull(workflowHeaderStepInfo);
            Intrinsics.checkNotNull(workflowHeaderStepInfo2);
            if (shouldUseOutgoingHeader(direction, workflowHeaderStepInfo, workflowHeaderStepInfo2)) {
                currentStepId = fromStepId;
            }
            return new WorkflowHeaderPresentation(currentStepId, WorkflowHeaderTransitionRole.STABLE);
        }
        return new WorkflowHeaderPresentation(currentStepId, WorkflowHeaderTransitionRole.STABLE);
    }

    private static final boolean shouldUseOutgoingHeader(NavigationDirection navigationDirection, WorkflowHeaderStepInfo workflowHeaderStepInfo, WorkflowHeaderStepInfo workflowHeaderStepInfo2) {
        if (workflowHeaderStepInfo2.getHasHeroImage()) {
            return false;
        }
        return navigationDirection == NavigationDirection.BACKWARD || workflowHeaderStepInfo.getHasHeroImage();
    }

    private static final WorkflowHeaderPresentation workflowHeaderState(String str, Map<String, PaywallState.Loaded.Components> map, WorkflowTransitionState workflowTransitionState) {
        NavigationDirection animatingDirection;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            PaywallState.Loaded.Components components = (PaywallState.Loaded.Components) entry.getValue();
            boolean mainStackHasHeroImage = components.getMainStackHasHeroImage();
            if (components.getHeader() != null) {
                z = true;
            }
            linkedHashMap.put(key, new WorkflowHeaderStepInfo(mainStackHasHeroImage, z));
        }
        if (!(workflowTransitionState instanceof WorkflowTransitionState.SlideInOut)) {
            throw new NoWhenBranchMatchedException();
        }
        String animatingFromStepId = workflowTransitionState.getAnimatingFromStepId();
        WorkflowPendingTransition workflowPendingTransition = null;
        if (animatingFromStepId != null && (animatingDirection = ((WorkflowTransitionState.SlideInOut) workflowTransitionState).getAnimatingDirection()) != null) {
            workflowPendingTransition = new WorkflowPendingTransition(animatingFromStepId, animatingDirection, 0);
        }
        return selectWorkflowHeaderPresentation(str, linkedHashMap, workflowPendingTransition);
    }
}
