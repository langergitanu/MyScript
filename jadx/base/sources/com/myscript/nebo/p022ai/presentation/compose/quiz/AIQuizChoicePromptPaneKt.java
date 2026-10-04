package com.myscript.nebo.p022ai.presentation.compose.quiz;

import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.WavUtil;
import coil.compose.SingletonAsyncImagePainterKt;
import com.myscript.nebo.p022ai.C6091R;
import com.myscript.nebo.p022ai.presentation.compose.components.AnimateCardKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AIQuizChoicePromptPane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u001a;\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a;\u0010\u0007\u001a\u00020\u00012\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0012X\u008a\u008e\u0002"}, m1599d2 = {"AIQuizChoicePromptPane", "", "onDismissQuizChoicePrompt", "Lkotlin/Function0;", "onTrueFalseClick", "onMultipleChoiceClick", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "QuizChoiceCard", "quizChoiceIcon", "", "quizChoiceTitle", "quizChoiceDescription", "onQuizChoiceClick", "(IIILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "QuizChoiceCardTrueFalsePreview", "(Landroidx/compose/runtime/Composer;I)V", "nebo-ai_release", "trueFalseVisible", "", "multipleChoiceVisible"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIQuizChoicePromptPaneKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizChoicePromptPane$lambda$11(Function0 function0, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        AIQuizChoicePromptPane(function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuizChoiceCard$lambda$2(int i, int i2, int i3, Function0 function0, int i4, int i5, Composer composer, int i6) {
        QuizChoiceCard(i, i2, i3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuizChoiceCardTrueFalsePreview$lambda$0(int i, Composer composer, int i2) {
        QuizChoiceCardTrueFalsePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AIQuizChoicePromptPane(final Function0<Unit> onDismissQuizChoicePrompt, Function0<Unit> function0, Function0<Unit> function02, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function03;
        int i4;
        Function0<Unit> function04;
        final Function0<Unit> function05;
        final Function0<Unit> function06;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function0<Unit> function07;
        Function0<Unit> function08;
        Intrinsics.checkNotNullParameter(onDismissQuizChoicePrompt, "onDismissQuizChoicePrompt");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1765954743);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizChoicePromptPane)N(onDismissQuizChoicePrompt,onTrueFalseClick,onMultipleChoiceClick)50@2134L2,51@2178L2,53@2213L34,54@2281L34,56@2342L39,56@2321L60,60@2420L90,60@2387L123,69@2614L6,66@2516L2339:AIQuizChoicePromptPane.kt#nf75a9");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onDismissQuizChoicePrompt) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function03 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function03) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function04 = function02;
                    i3 |= composerStartRestartGroup.changedInstance(function04) ? 256 : 128;
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function05 = function03;
                    function06 = function04;
                } else {
                    if (i5 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -570422709, "CC(remember):AIQuizChoicePromptPane.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function07 = (Function0) objRememberedValue;
                    } else {
                        function07 = function03;
                    }
                    if (i4 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -570421301, "CC(remember):AIQuizChoicePromptPane.kt#9igjgp");
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        function08 = (Function0) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function08 = function04;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1765954743, i3, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPane (AIQuizChoicePromptPane.kt:52)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -570420149, "CC(remember):AIQuizChoicePromptPane.kt#9igjgp");
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    MutableState mutableState = (MutableState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -570417973, "CC(remember):AIQuizChoicePromptPane.kt#9igjgp");
                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    MutableState mutableState2 = (MutableState) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -570416016, "CC(remember):AIQuizChoicePromptPane.kt#9igjgp");
                    AIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$3$1 aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$3$1RememberedValue = new AIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$3$1(mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$3$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$3$1RememberedValue, composerStartRestartGroup, 6);
                    Boolean boolValueOf = Boolean.valueOf(AIQuizChoicePromptPane$lambda$3(mutableState));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -570413469, "CC(remember):AIQuizChoicePromptPane.kt#9igjgp");
                    AIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$4$1 aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$4$1RememberedValue = new AIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$4$1(mutableState, mutableState2, null);
                        composerStartRestartGroup.updateRememberedValue(aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$4$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) aIQuizChoicePromptPaneKt$AIQuizChoicePromptPane$4$1RememberedValue, composerStartRestartGroup, 0);
                    Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4207getSurface0d7_KjU(), 0.98f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2016backgroundbw27NRU$default);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -549749894, "C72@2711L444,88@3297L7,85@3165L1684:AIQuizChoicePromptPane.kt#nf75a9");
                    float f = 16;
                    final Function0<Unit> function09 = function08;
                    IconButtonKt.IconButton(onDismissQuizChoicePrompt, PaddingKt.m2854padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), C1486Dp.m11017constructorimpl(f)), false, null, ComposableSingletons$AIQuizChoicePromptPaneKt.INSTANCE.getLambda$514477163$nebo_ai_release(), composerStartRestartGroup, (i3 & 14) | 24576, 12);
                    Modifier modifierAlign = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter());
                    ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localConfiguration);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM2811offsetVpY3zN4$default = OffsetKt.m2811offsetVpY3zN4$default(modifierAlign, 0.0f, C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(((Configuration) objConsume).smallestScreenWidthDp) / 5), 1, null);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2811offsetVpY3zN4$default);
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
                    Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 890242124, "C97@3790L344,93@3541L593,111@4475L364,107@4217L622:AIQuizChoicePromptPane.kt#nf75a9");
                    boolean zAIQuizChoicePromptPane$lambda$3 = AIQuizChoicePromptPane$lambda$3(mutableState);
                    EnterTransition enterTransitionPlus = EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(400, 0, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m1795scaleInL8ZKhE$default(AnimationSpecKt.tween$default(400, 0, null, 4, null), 0.85f, 0L, 4, null));
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1587442523, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AIQuizChoicePromptPaneKt.AIQuizChoicePromptPane$lambda$10$0$0(function07, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    Function0<Unit> function010 = function07;
                    composerStartRestartGroup = composerStartRestartGroup;
                    AnimateCardKt.m12854AnimatedCardWHejsw(zAIQuizChoicePromptPane$lambda$3, null, enterTransitionPlus, null, 0.0f, composableLambdaRememberComposableLambda, composerStartRestartGroup, 196992, 26);
                    AnimateCardKt.m12854AnimatedCardWHejsw(AIQuizChoicePromptPane$lambda$6(mutableState2), null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(400, 200, null, 4, null), 0.0f, 2, null).plus(EnterExitTransitionKt.m1795scaleInL8ZKhE$default(AnimationSpecKt.tween$default(400, 200, null, 4, null), 0.85f, 0L, 4, null)), null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1064390254, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AIQuizChoicePromptPaneKt.AIQuizChoicePromptPane$lambda$10$0$1(function09, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 196992, 26);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function06 = function09;
                    function05 = function010;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AIQuizChoicePromptPaneKt.AIQuizChoicePromptPane$lambda$11(onDismissQuizChoicePrompt, function05, function06, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            function04 = function02;
            if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function03 = function0;
        i4 = i2 & 4;
        if (i4 != 0) {
        }
        function04 = function02;
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AIQuizChoicePromptPane$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AIQuizChoicePromptPane$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean AIQuizChoicePromptPane$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AIQuizChoicePromptPane$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizChoicePromptPane$lambda$10$0$0(Function0 function0, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C98@3808L312:AIQuizChoicePromptPane.kt#nf75a9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1587442523, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPane.<anonymous>.<anonymous>.<anonymous> (AIQuizChoicePromptPane.kt:98)");
        }
        QuizChoiceCard(C6091R.drawable.img_true_false, C6091R.string.ai_quiz_true_false_title, C6091R.string.ai_quiz_true_false_description, function0, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizChoicePromptPane$lambda$10$0$1(Function0 function0, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C112@4493L332:AIQuizChoicePromptPane.kt#nf75a9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1064390254, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPane.<anonymous>.<anonymous>.<anonymous> (AIQuizChoicePromptPane.kt:112)");
        }
        QuizChoiceCard(C6091R.drawable.img_multiple_choice, C6091R.string.ai_quiz_multiple_choice_title, C6091R.string.ai_quiz_multiple_choice_description, function0, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void QuizChoiceCard(final int i, final int i2, final int i3, Function0<Unit> function0, Composer composer, final int i4, final int i5) {
        int i6;
        Function0<Unit> function02;
        final Function0<Unit> function03;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function0<Unit> function04;
        Composer composerStartRestartGroup = composer.startRestartGroup(212807324);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(QuizChoiceCard)N(quizChoiceIcon,quizChoiceTitle,quizChoiceDescription,onQuizChoiceClick)128@5045L2,135@5199L890,130@5056L1033:AIQuizChoicePromptPane.kt#nf75a9");
        if ((i4 & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(i2) ? 32 : 16;
        }
        if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= composerStartRestartGroup.changed(i3) ? 256 : 128;
        }
        int i7 = i5 & 8;
        if (i7 == 0) {
            if ((i4 & 3072) == 0) {
                function02 = function0;
                i6 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
            }
            if (composerStartRestartGroup.shouldExecute((i6 & 1171) == 1170, i6 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function03 = function02;
            } else {
                if (i7 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1650586274, "CC(remember):AIQuizChoicePromptPane.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function04 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function04 = function02;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(212807324, i6, -1, "com.myscript.nebo.ai.presentation.compose.quiz.QuizChoiceCard (AIQuizChoicePromptPane.kt:129)");
                }
                Function0<Unit> function05 = function04;
                CardKt.m4173CardFjzlyU(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(WorkflowTransitionState.SLIDE_DURATION_MS), 1, null), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(12)), 0L, 0L, null, C1486Dp.m11017constructorimpl(8), ComposableLambdaKt.rememberComposableLambda(-446835777, true, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AIQuizChoicePromptPaneKt.QuizChoiceCard$lambda$1(function04, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 1769478, 28);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function03 = function05;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AIQuizChoicePromptPaneKt.QuizChoiceCard$lambda$2(i, i2, i3, function03, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i6 |= 3072;
        function02 = function0;
        if (composerStartRestartGroup.shouldExecute((i6 & 1171) == 1170, i6 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuizChoiceCard$lambda$1(final Function0 function0, int i, int i2, int i3, Composer composer, int i4) {
        ComposerKt.sourceInformation(composer, "C137@5256L23,136@5209L874:AIQuizChoicePromptPane.kt#nf75a9");
        if (composer.shouldExecute((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446835777, i4, -1, "com.myscript.nebo.ai.presentation.compose.quiz.QuizChoiceCard.<anonymous> (AIQuizChoicePromptPane.kt:136)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 87549750, "CC(remember):AIQuizChoicePromptPane.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizChoicePromptPaneKt.QuizChoiceCard$lambda$1$0$0(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(ClickableKt.m2062clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null), C1486Dp.m11017constructorimpl(16));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            float f = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1634559370, "C142@5476L41,141@5443L194,146@5650L423:AIQuizChoicePromptPane.kt#nf75a9");
            ImageKt.Image(SingletonAsyncImagePainterKt.m12345rememberAsyncImagePainterEHKIwbg(Integer.valueOf(i), null, null, null, 0, null, composer, 0, 62), "Quiz Choice Icon", SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(80)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, 432, 120);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_42 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_42, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -265517094, "C150@5788L31,151@5863L10,149@5755L139,154@5944L37,155@6025L10,153@5911L148:AIQuizChoicePromptPane.kt#nf75a9");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(i2, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getH6(), composer, 0, 0, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(i3, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBody2(), composer, 0, 0, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuizChoiceCard$lambda$1$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void QuizChoiceCardTrueFalsePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2015700520);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(QuizChoiceCardTrueFalsePreview)165@6157L206:AIQuizChoicePromptPane.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2015700520, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.QuizChoiceCardTrueFalsePreview (AIQuizChoicePromptPane.kt:164)");
            }
            QuizChoiceCard(C6091R.drawable.img_true_false, C6091R.string.ai_quiz_true_false_title, C6091R.string.ai_quiz_true_false_description, null, composerStartRestartGroup, 0, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizChoicePromptPaneKt.QuizChoiceCardTrueFalsePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
