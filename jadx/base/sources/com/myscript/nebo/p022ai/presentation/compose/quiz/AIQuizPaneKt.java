package com.myscript.nebo.p022ai.presentation.compose.quiz;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.p022ai.presentation.AIQuizViewModel;
import com.myscript.nebo.p022ai.presentation.QuizSourceAction;
import com.myscript.nebo.p022ai.presentation.QuizState;
import com.myscript.nebo.p022ai.presentation.compose.AIError;
import com.myscript.nebo.p022ai.presentation.compose.components.AnimateCardKt;
import com.myscript.nebo.p022ai.presentation.compose.components.ChooseNoteDropDownMenuKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIQuizPane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\f\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u008a\u0084\u0002"}, m1599d2 = {"AIQuizPane", "", "aiQuizViewModel", "Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;", "aiQuizDisclaimerAccepted", "Lkotlin/Function0;", "aiQuizDisclaimerDismissed", "closeQuiz", "quizCurrentPage", "quizAllPages", "quizSelectPages", "answerQuestionClick", "Lkotlin/Function1;", "", "nextQuestionClick", "tryAgainClick", "hideNoteClick", "nextQuestionsClick", "(Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "nebo-ai_release", "showAIQuizDisclaimer", "", "error", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "chooseNoteInput", "isQuizLoading", "noteHidden", "quizState", "Lcom/myscript/nebo/ai/presentation/QuizState;"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIQuizPaneKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizPane$lambda$11(AIQuizViewModel aIQuizViewModel, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Function1 function1, Function0 function07, Function0 function08, Function0 function09, Function0 function010, int i, int i2, Composer composer, int i3) {
        AIQuizPane(aIQuizViewModel, function0, function02, function03, function04, function05, function06, function1, function07, function08, function09, function010, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    public static final void AIQuizPane(final AIQuizViewModel aiQuizViewModel, final Function0<Unit> aiQuizDisclaimerAccepted, final Function0<Unit> aiQuizDisclaimerDismissed, final Function0<Unit> closeQuiz, final Function0<Unit> quizCurrentPage, final Function0<Unit> quizAllPages, final Function0<Unit> quizSelectPages, final Function1<? super String, Unit> answerQuestionClick, final Function0<Unit> nextQuestionClick, final Function0<Unit> tryAgainClick, final Function0<Unit> hideNoteClick, final Function0<Unit> nextQuestionsClick, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(aiQuizViewModel, "aiQuizViewModel");
        Intrinsics.checkNotNullParameter(aiQuizDisclaimerAccepted, "aiQuizDisclaimerAccepted");
        Intrinsics.checkNotNullParameter(aiQuizDisclaimerDismissed, "aiQuizDisclaimerDismissed");
        Intrinsics.checkNotNullParameter(closeQuiz, "closeQuiz");
        Intrinsics.checkNotNullParameter(quizCurrentPage, "quizCurrentPage");
        Intrinsics.checkNotNullParameter(quizAllPages, "quizAllPages");
        Intrinsics.checkNotNullParameter(quizSelectPages, "quizSelectPages");
        Intrinsics.checkNotNullParameter(answerQuestionClick, "answerQuestionClick");
        Intrinsics.checkNotNullParameter(nextQuestionClick, "nextQuestionClick");
        Intrinsics.checkNotNullParameter(tryAgainClick, "tryAgainClick");
        Intrinsics.checkNotNullParameter(hideNoteClick, "hideNoteClick");
        Intrinsics.checkNotNullParameter(nextQuestionsClick, "nextQuestionsClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1247182967);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizPane)N(aiQuizViewModel,aiQuizDisclaimerAccepted,aiQuizDisclaimerDismissed,closeQuiz,quizCurrentPage,quizAllPages,quizSelectPages,answerQuestionClick,nextQuestionClick,tryAgainClick,hideNoteClick,nextQuestionsClick)38@1574L21,39@1635L20,40@1715L21,41@1792L21,42@1863L21,43@1932L20,47@2017L162,45@1958L221,56@2237L152,54@2185L204,67@2449L403,65@2395L457,87@3056L102,81@2858L300,95@3220L465,93@3164L521:AIQuizPane.kt#nf75a9");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changedInstance(aiQuizViewModel) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(aiQuizDisclaimerAccepted) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(aiQuizDisclaimerDismissed) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(closeQuiz) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(quizCurrentPage) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(quizAllPages) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(quizSelectPages) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(answerQuestionClick) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(nextQuestionClick) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(tryAgainClick) ? 536870912 : 268435456;
        }
        int i5 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(hideNoteClick) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(nextQuestionsClick) ? 32 : 16;
        }
        int i6 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i6 & 19) == 18) ? false : true, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1247182967, i5, i6, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPane (AIQuizPane.kt:37)");
            }
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getShowAIQuizDisclaimer(), false, composerStartRestartGroup, 48);
            final State stateObserveAsState2 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getError(), null, composerStartRestartGroup, 48);
            State stateObserveAsState3 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getChooseNoteInput(), false, composerStartRestartGroup, 48);
            State stateObserveAsState4 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.isQuizLoading(), false, composerStartRestartGroup, 48);
            final State stateObserveAsState5 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getNoteHidden(), false, composerStartRestartGroup, 48);
            final State stateObserveAsState6 = LiveDataAdapterKt.observeAsState(aiQuizViewModel.getQuizState(), null, composerStartRestartGroup, 48);
            AnimateCardKt.m12854AnimatedCardWHejsw(AIQuizPane$lambda$0(stateObserveAsState), null, null, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-882252531, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPaneKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIQuizPaneKt.AIQuizPane$lambda$6(aiQuizDisclaimerAccepted, aiQuizDisclaimerDismissed, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            AnimateCardKt.m12854AnimatedCardWHejsw(AIQuizPane$lambda$1(stateObserveAsState2) != null, null, null, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-78382588, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPaneKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIQuizPaneKt.AIQuizPane$lambda$7(stateObserveAsState2, closeQuiz, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            AnimateCardKt.m12854AnimatedCardWHejsw(AIQuizPane$lambda$2(stateObserveAsState3), null, null, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(1187688197, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPaneKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIQuizPaneKt.AIQuizPane$lambda$8(aiQuizViewModel, quizCurrentPage, quizAllPages, quizSelectPages, closeQuiz, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            AnimateCardKt.m12854AnimatedCardWHejsw(AIQuizPane$lambda$3(stateObserveAsState4), null, EnterExitTransitionKt.m1795scaleInL8ZKhE$default(AnimationSpecKt.tween$default(400, 0, null, 6, null), 0.85f, 0L, 4, null).plus(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(400, 0, null, 6, null), 0.0f, 2, null)), null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-1841208314, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPaneKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIQuizPaneKt.AIQuizPane$lambda$9(closeQuiz, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196992, 26);
            AnimateCardKt.m12854AnimatedCardWHejsw(AIQuizPane$lambda$5(stateObserveAsState6) != null, null, null, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-575137529, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPaneKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIQuizPaneKt.AIQuizPane$lambda$10(stateObserveAsState6, closeQuiz, nextQuestionClick, answerQuestionClick, tryAgainClick, hideNoteClick, nextQuestionsClick, stateObserveAsState5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPaneKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizPaneKt.AIQuizPane$lambda$11(aiQuizViewModel, aiQuizDisclaimerAccepted, aiQuizDisclaimerDismissed, closeQuiz, quizCurrentPage, quizAllPages, quizSelectPages, answerQuestionClick, nextQuestionClick, tryAgainClick, hideNoteClick, nextQuestionsClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizPane$lambda$6(Function0 function0, Function0 function02, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C48@2027L146:AIQuizPane.kt#nf75a9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-882252531, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPane.<anonymous> (AIQuizPane.kt:48)");
        }
        AIQuizDisclaimerCardKt.AIQuizDisclaimerCard(function0, function02, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizPane$lambda$7(State state, Function0 function0, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C:AIQuizPane.kt#nf75a9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-78382588, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPane.<anonymous> (AIQuizPane.kt:57)");
        }
        AIError aIErrorAIQuizPane$lambda$1 = AIQuizPane$lambda$1(state);
        if (aIErrorAIQuizPane$lambda$1 != null) {
            composer.startReplaceGroup(1366550781);
            ComposerKt.sourceInformation(composer, "*58@2272L101");
            AIQuizErrorCardKt.AIQuizErrorCard(aIErrorAIQuizPane$lambda$1, function0, composer, 0, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1366550780);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizPane$lambda$8(AIQuizViewModel aIQuizViewModel, final Function0 function0, final Function0 function02, final Function0 function03, Function0 function04, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C70@2586L214,68@2459L387:AIQuizPane.kt#nf75a9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1187688197, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPane.<anonymous> (AIQuizPane.kt:68)");
        }
        List<QuizSourceAction> quizSourceActions = aIQuizViewModel.getQuizSourceActions();
        ComposerKt.sourceInformationMarkerStart(composer, -1092938821, "CC(remember):AIQuizPane.kt#9igjgp");
        boolean zChanged = composer.changed(function0) | composer.changed(function02) | composer.changed(function03);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPaneKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AIQuizPaneKt.AIQuizPane$lambda$8$0$0(function0, function02, function03, (QuizSourceAction) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ChooseNoteDropDownMenuKt.ChooseNoteDropDownMenu(quizSourceActions, (Function1) objRememberedValue, function04, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizPane$lambda$8$0$0(Function0 function0, Function0 function02, Function0 function03, QuizSourceAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (Intrinsics.areEqual(it, QuizSourceAction.CurrentPage.INSTANCE)) {
            function0.invoke();
        } else if (Intrinsics.areEqual(it, QuizSourceAction.AllPages.INSTANCE)) {
            function02.invoke();
        } else {
            if (!Intrinsics.areEqual(it, QuizSourceAction.ChoosePages.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            function03.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizPane$lambda$9(Function0 function0, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C88@3066L86:AIQuizPane.kt#nf75a9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1841208314, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPane.<anonymous> (AIQuizPane.kt:88)");
        }
        AIQuizQuestionsLoaderCardKt.AIQuizQuestionsLoaderCard(function0, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizPane$lambda$10(State state, Function0 function0, Function0 function02, Function1 function1, Function0 function03, Function0 function04, Function0 function05, State state2, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C:AIQuizPane.kt#nf75a9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-575137529, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizPane.<anonymous> (AIQuizPane.kt:96)");
        }
        QuizState quizStateAIQuizPane$lambda$5 = AIQuizPane$lambda$5(state);
        if (quizStateAIQuizPane$lambda$5 != null) {
            composer.startReplaceGroup(-1297548283);
            ComposerKt.sourceInformation(composer, "*97@3259L410");
            AIQuizCardKt.AIQuizCard(quizStateAIQuizPane$lambda$5, AIQuizPane$lambda$4(state2), function0, function02, function1, function03, function04, function05, composer, 0, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1297548284);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final boolean AIQuizPane$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final AIError AIQuizPane$lambda$1(State<? extends AIError> state) {
        return state.getValue();
    }

    private static final boolean AIQuizPane$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean AIQuizPane$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final boolean AIQuizPane$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final QuizState AIQuizPane$lambda$5(State<QuizState> state) {
        return state.getValue();
    }
}
