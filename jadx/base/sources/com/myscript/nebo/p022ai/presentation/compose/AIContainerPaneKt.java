package com.myscript.nebo.p022ai.presentation.compose;

import android.graphics.Rect;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p004ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.nebo.p022ai.domain.AIContainerEvent;
import com.myscript.nebo.p022ai.presentation.AIExplainViewModel;
import com.myscript.nebo.p022ai.presentation.AIQuizViewModel;
import com.myscript.nebo.p022ai.presentation.AISummarizeViewModel;
import com.myscript.nebo.p022ai.presentation.compose.components.AIDropdownOption;
import com.myscript.nebo.p022ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt;
import com.myscript.nebo.p022ai.presentation.compose.quiz.AIQuizPaneKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AIContainerPane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u001e\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010!\u001a\u00020\"X\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020$X\u008a\u0084\u0002"}, m1599d2 = {"AIContainerPane", "", "aiContainerViewModel", "Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;", "aiSummarizeViewModel", "Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;", "aiExplainViewModel", "Lcom/myscript/nebo/ai/presentation/AIExplainViewModel;", "aiQuizViewModel", "Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;", "onEvent", "Lkotlin/Function1;", "Lcom/myscript/nebo/ai/domain/AIContainerEvent;", "fabProperties", "Lcom/myscript/nebo/ai/presentation/compose/FABProperties;", "(Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;Lcom/myscript/nebo/ai/presentation/AIExplainViewModel;Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;Lkotlin/jvm/functions/Function1;Lcom/myscript/nebo/ai/presentation/compose/FABProperties;Landroidx/compose/runtime/Composer;II)V", "pulseAnimation", "", "(Landroidx/compose/runtime/Composer;I)F", "nebo-ai_release", "isAIEnabled", "", "mode", "Lcom/myscript/nebo/ai/presentation/compose/AIMode;", "showMenu", "actionsAvailability", "Lcom/myscript/nebo/ai/presentation/compose/ActionsAvailability;", "isExplainLoading", "isSummarizeLoading", "isQuizLoading", "noteHidden", "showAIQuizPrompt", "lastActiveMode", "parentHeight", "Landroidx/compose/ui/unit/Dp;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Landroidx/compose/ui/graphics/Color;"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIContainerPaneKt {

    /* JADX INFO: compiled from: AIContainerPane.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AIDropdownOption.values().length];
            try {
                iArr[AIDropdownOption.Explain.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIDropdownOption.Summarize.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AIDropdownOption.Quiz.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$19(AIContainerViewModel aIContainerViewModel, AISummarizeViewModel aISummarizeViewModel, AIExplainViewModel aIExplainViewModel, AIQuizViewModel aIQuizViewModel, Function1 function1, FABProperties fABProperties, int i, int i2, Composer composer, int i3) {
        AIContainerPane(aIContainerViewModel, aISummarizeViewModel, aIExplainViewModel, aIQuizViewModel, function1, fABProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:183:0x0786  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0275  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AIContainerPane(final AIContainerViewModel aiContainerViewModel, final AISummarizeViewModel aiSummarizeViewModel, final AIExplainViewModel aiExplainViewModel, final AIQuizViewModel aiQuizViewModel, final Function1<? super AIContainerEvent, Unit> onEvent, FABProperties fABProperties, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        FABProperties fABProperties2;
        State stateObserveAsState;
        State stateObserveAsState2;
        Object objRememberedValue;
        Object objRememberedValue2;
        Animatable animatable;
        boolean zChangedInstance;
        AIContainerPaneKt$AIContainerPane$1$1 aIContainerPaneKt$AIContainerPane$1$1RememberedValue;
        long jM8183getTransparent0d7_KjU;
        final MutableState mutableState;
        Modifier.Companion companionPointerInput;
        float f;
        Intrinsics.checkNotNullParameter(aiContainerViewModel, "aiContainerViewModel");
        Intrinsics.checkNotNullParameter(aiSummarizeViewModel, "aiSummarizeViewModel");
        Intrinsics.checkNotNullParameter(aiExplainViewModel, "aiExplainViewModel");
        Intrinsics.checkNotNullParameter(aiQuizViewModel, "aiQuizViewModel");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1203547335);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIContainerPane)N(aiContainerViewModel,aiSummarizeViewModel,aiExplainViewModel,aiQuizViewModel,onEvent,fabProperties)60@2752L21,61@2816L27,62@2894L21,63@2988L99,66@3145L21,67@3228L21,68@3305L21,69@3376L21,70@3459L21,71@3543L27,74@3624L33,75@3689L7,79@3769L27,80@3822L158,80@3801L179,87@4009L184:AIContainerPane.kt#ez9f2c");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(aiContainerViewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(aiSummarizeViewModel) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(aiExplainViewModel) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(aiQuizViewModel) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onEvent) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= ((i2 & 32) == 0 && composerStartRestartGroup.changed(fABProperties)) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 32) != 0) {
                    i4 = i3 & (-458753);
                    fABProperties2 = new FABProperties(C1486Dp.m11017constructorimpl(56), C1486Dp.m11017constructorimpl(16), null);
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1203547335, i4, -1, "com.myscript.nebo.ai.presentation.compose.AIContainerPane (AIContainerPane.kt:59)");
                }
                stateObserveAsState = LiveDataAdapterKt.observeAsState(aiContainerViewModel.isAIEnabled(), false, composerStartRestartGroup, 48);
                State stateObserveAsState3 = LiveDataAdapterKt.observeAsState(aiContainerViewModel.getMode(), AIMode.NONE, composerStartRestartGroup, 48);
                State stateObserveAsState4 = LiveDataAdapterKt.observeAsState(aiContainerViewModel.getShowMenu(), false, composerStartRestartGroup, 48);
                State stateObserveAsState5 = LiveDataAdapterKt.observeAsState(aiContainerViewModel.getActionsAvailability(), new ActionsAvailability(false, false, false), composerStartRestartGroup, 0);
                State stateObserveAsState6 = LiveDataAdapterKt.observeAsState(aiExplainViewModel.isLoading(), false, composerStartRestartGroup, 48);
                State stateObserveAsState7 = LiveDataAdapterKt.observeAsState(aiSummarizeViewModel.isLoading(), false, composerStartRestartGroup, 48);
                State stateObserveAsState8 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.isQuizLoading(), false, composerStartRestartGroup, 48);
                stateObserveAsState2 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getNoteHidden(), false, composerStartRestartGroup, 48);
                State stateObserveAsState9 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getShowAIQuizPrompt(), false, composerStartRestartGroup, 48);
                State stateObserveAsState10 = LiveDataAdapterKt.observeAsState(aiContainerViewModel.getLastActiveMode(), AIMode.NONE, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1262746726, "CC(remember):AIContainerPane.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(C1486Dp.m11015boximpl(C1486Dp.m11017constructorimpl(0)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState2 = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Density density = (Density) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1262742092, "CC(remember):AIContainerPane.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 != Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                animatable = (Animatable) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1262740265, "CC(remember):AIContainerPane.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(animatable);
                aIContainerPaneKt$AIContainerPane$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || aIContainerPaneKt$AIContainerPane$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    aIContainerPaneKt$AIContainerPane$1$1RememberedValue = new AIContainerPaneKt$AIContainerPane$1$1(animatable, null);
                    composerStartRestartGroup.updateRememberedValue(aIContainerPaneKt$AIContainerPane$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aIContainerPaneKt$AIContainerPane$1$1RememberedValue, composerStartRestartGroup, 6);
                if (!AIContainerPane$lambda$7(stateObserveAsState2)) {
                    composerStartRestartGroup.startReplaceGroup(-490001183);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4096L6");
                    jM8183getTransparent0d7_KjU = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4207getSurface0d7_KjU(), 0.98f, 0.0f, 0.0f, 0.0f, 14, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-489924768);
                    composerStartRestartGroup.endReplaceGroup();
                    jM8183getTransparent0d7_KjU = Color.INSTANCE.m8183getTransparent0d7_KjU();
                }
                fABProperties = fABProperties2;
                int i5 = i4;
                State<Color> stateM1865animateColorAsStateeuL9pac = SingleValueAnimationKt.m1865animateColorAsStateeuL9pac(jM8183getTransparent0d7_KjU, null, null, null, composerStartRestartGroup, 0, 14);
                composerStartRestartGroup = composerStartRestartGroup;
                if (!AIContainerPane$lambda$0(stateObserveAsState)) {
                    composerStartRestartGroup.startReplaceGroup(-489637708);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4332L118,96@4226L7045");
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1262723985, "CC(remember):AIContainerPane.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(density);
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        mutableState = mutableState2;
                        objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AIContainerPaneKt.AIContainerPane$lambda$16$0(density, mutableState, (LayoutCoordinates) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        mutableState = mutableState2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierFillMaxSize$default, (Function1) objRememberedValue3), AIContainerPane$lambda$15(stateM1865animateColorAsStateeuL9pac), null, 2, null);
                    if (AIContainerPane$lambda$8(stateObserveAsState9) || AIContainerPane$lambda$7(stateObserveAsState2)) {
                        composerStartRestartGroup.startReplaceGroup(-489449445);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "107@4675L98");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1262713029, "CC(remember):AIContainerPane.kt#9igjgp");
                        AIContainerPaneKt$AIContainerPane$3$1 aIContainerPaneKt$AIContainerPane$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (aIContainerPaneKt$AIContainerPane$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            aIContainerPaneKt$AIContainerPane$3$1RememberedValue = AIContainerPaneKt$AIContainerPane$3$1.INSTANCE;
                            composerStartRestartGroup.updateRememberedValue(aIContainerPaneKt$AIContainerPane$3$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        companionPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, unit2, (PointerInputEventHandler) aIContainerPaneKt$AIContainerPane$3$1RememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1262709087);
                        composerStartRestartGroup.endReplaceGroup();
                        companionPointerInput = Modifier.INSTANCE;
                    }
                    Modifier modifierThen = modifierM2016backgroundbw27NRU$default.then(companionPointerInput);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
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
                    Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1594026623, "C119@5123L3509,193@9234L10,198@9474L10,200@9524L343,184@8765L1102,216@10300L49,217@10380L78,220@10494L590,235@11189L57,208@9881L1380:AIContainerPane.kt#ez9f2c");
                    if (AIContainerPane$lambda$1(stateObserveAsState3) == AIMode.MINIMIZED) {
                        composerStartRestartGroup.startReplaceGroup(-328519830);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "114@4898L16");
                        float fPulseAnimation = pulseAnimation(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        f = fPulseAnimation;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-528805532);
                        composerStartRestartGroup.endReplaceGroup();
                        f = 1.0f;
                    }
                    boolean z = AIContainerPane$lambda$1(stateObserveAsState3) == AIMode.EXPLAIN;
                    boolean z2 = AIContainerPane$lambda$1(stateObserveAsState3) == AIMode.SUMMARIZE;
                    boolean z3 = AIContainerPane$lambda$1(stateObserveAsState3) == AIMode.QUIZ;
                    boolean z4 = z2;
                    boolean z5 = z;
                    Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(PaddingKt.m2856paddingVpY3zN4$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), 0.0f, C1486Dp.m11017constructorimpl(16), 1, null), 0.0f, 0.0f, 0.0f, C1486Dp.m11017constructorimpl(fABProperties.m12842getSizeD9Ej5fM() + fABProperties.m12841getMarginD9Ej5fM()), 7, null);
                    float f2 = WorkflowTransitionState.SLIDE_DURATION_MS;
                    Modifier modifierM2928sizeInqDBjuR0$default = SizeKt.m2928sizeInqDBjuR0$default(modifierM2858paddingqDBjuR0$default, C1486Dp.m11017constructorimpl(f2), 0.0f, C1486Dp.m11017constructorimpl(f2), C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(AIContainerPane$lambda$11(mutableState) - fABProperties.m12842getSizeD9Ej5fM()) - fABProperties.m12841getMarginD9Ej5fM()), 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2928sizeInqDBjuR0$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composerStartRestartGroup);
                    Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 631321883, "C134@5768L475,130@5602L641,147@6428L852,143@6260L1020,164@7460L1158,160@7297L1321:AIContainerPane.kt#ez9f2c");
                    AnimatedVisibilityKt.AnimatedVisibility(z5, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-523985224, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda21
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AIContainerPaneKt.AIContainerPane$lambda$18$0$0(aiExplainViewModel, onEvent, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(z4, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1434754193, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AIContainerPaneKt.AIContainerPane$lambda$18$0$1(aiSummarizeViewModel, onEvent, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    AnimatedVisibilityKt.AnimatedVisibility(z3, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-857558480, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AIContainerPaneKt.AIContainerPane$lambda$18$0$2(aiQuizViewModel, onEvent, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean zAIContainerPane$lambda$8 = AIContainerPane$lambda$8(stateObserveAsState9);
                    EnterTransition enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, null, 6, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m1795scaleInL8ZKhE$default(AnimationSpecKt.tween$default(300, 0, null, 4, null), 0.85f, 0L, 4, null));
                    TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(300, 0, null, 4, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -328381084, "CC(remember):AIContainerPane.kt#9igjgp");
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Integer.valueOf(AIContainerPaneKt.AIContainerPane$lambda$18$1$0(((Integer) obj).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EnterTransition enterTransitionPlus2 = enterTransitionPlus.plus(EnterExitTransitionKt.slideInVertically(tweenSpecTween$default, (Function1) objRememberedValue4));
                    ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(200, 0, null, 6, null), 0.0f, 2, null);
                    TweenSpec tweenSpecTween$default2 = AnimationSpecKt.tween$default(200, 0, null, 6, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -328373404, "CC(remember):AIContainerPane.kt#9igjgp");
                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda26
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Integer.valueOf(AIContainerPaneKt.AIContainerPane$lambda$18$2$0(((Integer) obj).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AnimatedVisibilityKt.AnimatedVisibility(zAIContainerPane$lambda$8, (Modifier) null, enterTransitionPlus2, exitTransitionFadeOut$default.plus(EnterExitTransitionKt.slideOutVertically(tweenSpecTween$default2, (Function1) objRememberedValue5)), (String) null, ComposableLambdaKt.rememberComposableLambda(951156018, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AIContainerPaneKt.AIContainerPane$lambda$18$3(onEvent, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 200064, 18);
                    Modifier modifierM8315graphicsLayer_6ThJ44$default = GraphicsLayerModifierKt.m8315graphicsLayer_6ThJ44$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 0, null, 524284, null);
                    boolean z6 = AIContainerPane$lambda$4(stateObserveAsState6) || AIContainerPane$lambda$5(stateObserveAsState7) || AIContainerPane$lambda$6(stateObserveAsState8);
                    AIMode aIModeAIContainerPane$lambda$1 = AIContainerPane$lambda$1(stateObserveAsState3);
                    AIMode aIModeAIContainerPane$lambda$9 = AIContainerPane$lambda$9(stateObserveAsState10);
                    boolean zAIContainerPane$lambda$2 = AIContainerPane$lambda$2(stateObserveAsState4);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -328346933, "CC(remember):AIContainerPane.kt#9igjgp");
                    boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(aiContainerViewModel);
                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AIContainerPaneKt.AIContainerPane$lambda$18$4$0(aiContainerViewModel);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function0 function0 = (Function0) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -328344344, "CC(remember):AIContainerPane.kt#9igjgp");
                    int i6 = i5 & 57344;
                    boolean z7 = i6 == 16384;
                    Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (z7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AIContainerPaneKt.AIContainerPane$lambda$18$5$0(onEvent);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Function0 function02 = (Function0) objRememberedValue7;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -328340184, "CC(remember):AIContainerPane.kt#9igjgp");
                    boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(aiContainerViewModel) | (i6 == 16384);
                    Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AIContainerPaneKt.AIContainerPane$lambda$18$6$0(aiContainerViewModel, onEvent, (AIDropdownOption) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    Function1 function1 = (Function1) objRememberedValue8;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ActionsAvailability actionsAvailabilityAIContainerPane$lambda$3 = AIContainerPane$lambda$3(stateObserveAsState5);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -328318477, "CC(remember):AIContainerPane.kt#9igjgp");
                    boolean z8 = i6 == 16384;
                    Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (z8 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue9 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AIContainerPaneKt.AIContainerPane$lambda$18$7$0(onEvent, (Rect) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AIFloatingActionButtonKt.AIFloatingActionButton(modifierM8315graphicsLayer_6ThJ44$default, z6, aIModeAIContainerPane$lambda$1, aIModeAIContainerPane$lambda$9, zAIContainerPane$lambda$2, function0, function02, function1, actionsAvailabilityAIContainerPane$lambda$3, (Function1) objRememberedValue9, composerStartRestartGroup, 0, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-482852087);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                }
            }
            i4 = i3;
            fABProperties2 = fABProperties;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            stateObserveAsState = LiveDataAdapterKt.observeAsState(aiContainerViewModel.isAIEnabled(), false, composerStartRestartGroup, 48);
            State stateObserveAsState32 = LiveDataAdapterKt.observeAsState(aiContainerViewModel.getMode(), AIMode.NONE, composerStartRestartGroup, 48);
            State stateObserveAsState42 = LiveDataAdapterKt.observeAsState(aiContainerViewModel.getShowMenu(), false, composerStartRestartGroup, 48);
            State stateObserveAsState52 = LiveDataAdapterKt.observeAsState(aiContainerViewModel.getActionsAvailability(), new ActionsAvailability(false, false, false), composerStartRestartGroup, 0);
            State stateObserveAsState62 = LiveDataAdapterKt.observeAsState(aiExplainViewModel.isLoading(), false, composerStartRestartGroup, 48);
            State stateObserveAsState72 = LiveDataAdapterKt.observeAsState(aiSummarizeViewModel.isLoading(), false, composerStartRestartGroup, 48);
            State stateObserveAsState82 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.isQuizLoading(), false, composerStartRestartGroup, 48);
            stateObserveAsState2 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getNoteHidden(), false, composerStartRestartGroup, 48);
            State stateObserveAsState92 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getShowAIQuizPrompt(), false, composerStartRestartGroup, 48);
            State stateObserveAsState102 = LiveDataAdapterKt.observeAsState(aiContainerViewModel.getLastActiveMode(), AIMode.NONE, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1262746726, "CC(remember):AIContainerPane.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            MutableState mutableState22 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density2 = (Density) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1262742092, "CC(remember):AIContainerPane.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 != Composer.INSTANCE.getEmpty()) {
            }
            animatable = (Animatable) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit3 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1262740265, "CC(remember):AIContainerPane.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(animatable);
            aIContainerPaneKt$AIContainerPane$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                aIContainerPaneKt$AIContainerPane$1$1RememberedValue = new AIContainerPaneKt$AIContainerPane$1$1(animatable, null);
                composerStartRestartGroup.updateRememberedValue(aIContainerPaneKt$AIContainerPane$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aIContainerPaneKt$AIContainerPane$1$1RememberedValue, composerStartRestartGroup, 6);
                if (!AIContainerPane$lambda$7(stateObserveAsState2)) {
                }
                fABProperties = fABProperties2;
                int i52 = i4;
                State<Color> stateM1865animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m1865animateColorAsStateeuL9pac(jM8183getTransparent0d7_KjU, null, null, null, composerStartRestartGroup, 0, 14);
                composerStartRestartGroup = composerStartRestartGroup;
                if (!AIContainerPane$lambda$0(stateObserveAsState)) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final FABProperties fABProperties3 = fABProperties;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIContainerPaneKt.AIContainerPane$lambda$19(aiContainerViewModel, aiSummarizeViewModel, aiExplainViewModel, aiQuizViewModel, onEvent, fABProperties3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float AIContainerPane$lambda$11(MutableState<C1486Dp> mutableState) {
        return mutableState.getValue().m11031unboximpl();
    }

    private static final void AIContainerPane$lambda$12(MutableState<C1486Dp> mutableState, float f) {
        mutableState.setValue(C1486Dp.m11015boximpl(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$16$0(Density density, MutableState mutableState, LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        AIContainerPane$lambda$12(mutableState, density.mo2188toDpu2uoSUM((int) (coordinates.mo9633getSizeYbymL2g() & 4294967295L)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$0(AIExplainViewModel aIExplainViewModel, final Function1 function1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C137@5907L42,138@5987L44,139@6074L43,140@6159L43,135@5790L435:AIContainerPane.kt#ez9f2c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-523985224, i, -1, "com.myscript.nebo.ai.presentation.compose.AIContainerPane.<anonymous>.<anonymous>.<anonymous> (AIContainerPane.kt:135)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1038622142, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$0$0$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1038619580, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged2 = composer.changed(function1);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$0$1$0(function1, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function1 function12 = (Function1) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1038616797, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged3 = composer.changed(function1);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$0$2$0(function1, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function1 function13 = (Function1) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1038614077, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged4 = composer.changed(function1);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$0$3$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AIExplainPaneKt.AIExplainPane(aIExplainViewModel, function0, function12, function13, (Function0) objRememberedValue4, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$0$0$0(Function1 function1) {
        function1.invoke(AIContainerEvent.ExplainClose.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$0$1$0(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new AIContainerEvent.CopyResult(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$0$2$0(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new AIContainerEvent.AddToNote(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$0$3$0(Function1 function1) {
        function1.invoke(AIContainerEvent.TryAgainClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1(AISummarizeViewModel aISummarizeViewModel, final Function1 function1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C150@6573L44,154@6911L43,151@6655L44,155@7003L50,156@7096L50,157@7192L47,152@6742L43,153@6827L43,148@6450L812:AIContainerPane.kt#ez9f2c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1434754193, i, -1, "com.myscript.nebo.ai.presentation.compose.AIContainerPane.<anonymous>.<anonymous>.<anonymous> (AIContainerPane.kt:148)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -114272773, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$1$0$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -114261958, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged2 = composer.changed(function1);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$1$1$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function02 = (Function0) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -114270149, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged3 = composer.changed(function1);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$1$2$0(function1, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function1 function12 = (Function1) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -114259007, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged4 = composer.changed(function1);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$1$3$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Function0 function03 = (Function0) objRememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -114256031, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged5 = composer.changed(function1);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda32
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$1$4$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Function0 function04 = (Function0) objRememberedValue5;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -114252962, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged6 = composer.changed(function1);
        Object objRememberedValue6 = composer.rememberedValue();
        if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue6 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$1$5$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        }
        Function0 function05 = (Function0) objRememberedValue6;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -114267366, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged7 = composer.changed(function1);
        Object objRememberedValue7 = composer.rememberedValue();
        if (zChanged7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue7 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$1$6$0(function1, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue7);
        }
        Function1 function13 = (Function1) objRememberedValue7;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -114264646, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged8 = composer.changed(function1);
        Object objRememberedValue8 = composer.rememberedValue();
        if (zChanged8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue8 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$1$7$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue8);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AISummarizePaneKt.AISummarizePane(aISummarizeViewModel, function0, function02, function12, function03, function04, function05, function13, (Function0) objRememberedValue8, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1$0$0(Function1 function1) {
        function1.invoke(AIContainerEvent.SummarizeClose.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1$2$0(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new AIContainerEvent.CopyResult(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1$6$0(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new AIContainerEvent.AddToNote(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1$7$0(Function1 function1) {
        function1.invoke(AIContainerEvent.TryAgainClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1$1$0(Function1 function1) {
        function1.invoke(AIContainerEvent.ShortenResult.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1$3$0(Function1 function1) {
        function1.invoke(AIContainerEvent.SummarizeCurrentPage.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1$4$0(Function1 function1) {
        function1.invoke(AIContainerEvent.SummarizeSelectPages.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$1$5$0(Function1 function1) {
        function1.invoke(AIContainerEvent.SummarizeAllPages.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2(AIQuizViewModel aIQuizViewModel, final Function1 function1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C167@7604L52,168@7710L53,169@7801L39,170@7884L45,171@7970L42,172@8056L45,173@8149L67,174@8262L47,175@8351L47,176@8440L43,177@8530L48,165@7482L1118:AIContainerPane.kt#ez9f2c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-857558480, i, -1, "com.myscript.nebo.ai.presentation.compose.AIContainerPane.<anonymous>.<anonymous>.<anonymous> (AIContainerPane.kt:165)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 520026212, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$0$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520029605, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged2 = composer.changed(function1);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$1$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function02 = (Function0) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520032503, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged3 = composer.changed(function1);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$2$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function0 function03 = (Function0) objRememberedValue3;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520035165, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged4 = composer.changed(function1);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$3$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Function0 function04 = (Function0) objRememberedValue4;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520037914, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged5 = composer.changed(function1);
        Object objRememberedValue5 = composer.rememberedValue();
        if (zChanged5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$4$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Function0 function05 = (Function0) objRememberedValue5;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520040669, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged6 = composer.changed(function1);
        Object objRememberedValue6 = composer.rememberedValue();
        if (zChanged6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue6 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$5$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        }
        Function0 function06 = (Function0) objRememberedValue6;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520043667, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged7 = composer.changed(function1);
        Object objRememberedValue7 = composer.rememberedValue();
        if (zChanged7 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue7 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$6$0(function1, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue7);
        }
        Function1 function12 = (Function1) objRememberedValue7;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520047263, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged8 = composer.changed(function1);
        Object objRememberedValue8 = composer.rememberedValue();
        if (zChanged8 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue8 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$7$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue8);
        }
        Function0 function07 = (Function0) objRememberedValue8;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520050111, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged9 = composer.changed(function1);
        Object objRememberedValue9 = composer.rememberedValue();
        if (zChanged9 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue9 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$8$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue9);
        }
        Function0 function08 = (Function0) objRememberedValue9;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520052955, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged10 = composer.changed(function1);
        Object objRememberedValue10 = composer.rememberedValue();
        if (zChanged10 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue10 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$9$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue10);
        }
        Function0 function09 = (Function0) objRememberedValue10;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 520055840, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged11 = composer.changed(function1);
        Object objRememberedValue11 = composer.rememberedValue();
        if (zChanged11 || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue11 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$0$2$10$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue11);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AIQuizPaneKt.AIQuizPane(aIQuizViewModel, function0, function02, function03, function04, function05, function06, function12, function07, function08, function09, (Function0) objRememberedValue11, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$0$0(Function1 function1) {
        function1.invoke(AIContainerEvent.QuizDisclaimerAccepted.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$1$0(Function1 function1) {
        function1.invoke(AIContainerEvent.QuizDisclaimerDismissed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$2$0(Function1 function1) {
        function1.invoke(AIContainerEvent.CloseQuiz.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$3$0(Function1 function1) {
        function1.invoke(AIContainerEvent.QuizCurrentPage.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$4$0(Function1 function1) {
        function1.invoke(AIContainerEvent.QuizAllPages.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$5$0(Function1 function1) {
        function1.invoke(AIContainerEvent.QuizSelectPages.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$6$0(Function1 function1, String answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        function1.invoke(new AIContainerEvent.AnswerQuestionClick(answer));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$7$0(Function1 function1) {
        function1.invoke(AIContainerEvent.NextQuestionClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$8$0(Function1 function1) {
        function1.invoke(AIContainerEvent.QuizTryAgainClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$9$0(Function1 function1) {
        function1.invoke(AIContainerEvent.HideNoteClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$0$2$10$0(Function1 function1) {
        function1.invoke(AIContainerEvent.NextQuestionsClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AIContainerPane$lambda$18$1$0(int i) {
        return i / 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AIContainerPane$lambda$18$2$0(int i) {
        return i / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$3(final Function1 function1, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C202@9614L39,203@9694L46,204@9786L49,201@9542L311:AIContainerPane.kt#ez9f2c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(951156018, i, -1, "com.myscript.nebo.ai.presentation.compose.AIContainerPane.<anonymous>.<anonymous> (AIContainerPane.kt:201)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -767097831, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged = composer.changed(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$3$0$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -767095264, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged2 = composer.changed(function1);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$3$1$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function02 = (Function0) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -767092317, "CC(remember):AIContainerPane.kt#9igjgp");
        boolean zChanged3 = composer.changed(function1);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIContainerPaneKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AIContainerPaneKt.AIContainerPane$lambda$18$3$2$0(function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AIQuizChoicePromptPaneKt.AIQuizChoicePromptPane(function0, function02, (Function0) objRememberedValue3, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$3$0$0(Function1 function1) {
        function1.invoke(AIContainerEvent.CloseQuiz.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$3$1$0(Function1 function1) {
        function1.invoke(AIContainerEvent.TrueOrFalseClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$3$2$0(Function1 function1) {
        function1.invoke(AIContainerEvent.MultipleChoiceClick.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$4$0(AIContainerViewModel aIContainerViewModel) {
        aIContainerViewModel.setMenuVisibility(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$5$0(Function1 function1) {
        function1.invoke(AIContainerEvent.FabClickHook.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$6$0(AIContainerViewModel aIContainerViewModel, Function1 function1, AIDropdownOption option) {
        Intrinsics.checkNotNullParameter(option, "option");
        aIContainerViewModel.toggleMenuVisibility();
        int i = WhenMappings.$EnumSwitchMapping$0[option.ordinal()];
        if (i == 1) {
            function1.invoke(AIContainerEvent.ExplainClick.INSTANCE);
        } else if (i == 2) {
            function1.invoke(AIContainerEvent.SummarizeClick.INSTANCE);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(AIContainerEvent.QuizClick.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIContainerPane$lambda$18$7$0(Function1 function1, Rect it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new AIContainerEvent.AIButtonPositionChanged(it));
        return Unit.INSTANCE;
    }

    private static final float pulseAnimation(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -785121714, "C(pulseAnimation)246@11435L61,247@11527L256:AIContainerPane.kt#ez9f2c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-785121714, i, -1, "com.myscript.nebo.ai.presentation.compose.pulseAnimation (AIContainerPane.kt:245)");
        }
        float fFloatValue = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("pulseInfiniteTransition", composer, 6, 0), 1.0f, 1.2f, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(800, 0, null, 6, null), RepeatMode.Reverse, 0L, 4, null), "pulseScaleAnimation", composer, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0).getValue().floatValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return fFloatValue;
    }

    private static final boolean AIContainerPane$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final AIMode AIContainerPane$lambda$1(State<? extends AIMode> state) {
        return state.getValue();
    }

    private static final boolean AIContainerPane$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final ActionsAvailability AIContainerPane$lambda$3(State<ActionsAvailability> state) {
        return state.getValue();
    }

    private static final boolean AIContainerPane$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean AIContainerPane$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean AIContainerPane$lambda$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean AIContainerPane$lambda$7(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean AIContainerPane$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final AIMode AIContainerPane$lambda$9(State<? extends AIMode> state) {
        return state.getValue();
    }

    private static final long AIContainerPane$lambda$15(State<Color> state) {
        return state.getValue().m8158unboximpl();
    }
}
