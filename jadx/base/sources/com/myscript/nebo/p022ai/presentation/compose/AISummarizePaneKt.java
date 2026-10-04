package com.myscript.nebo.p022ai.presentation.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.p022ai.C6091R;
import com.myscript.nebo.p022ai.presentation.AISummarizeViewModel;
import com.myscript.nebo.p022ai.presentation.compose.components.AnimateCardKt;
import com.myscript.nebo.p022ai.presentation.compose.components.ChooseNoteCardKt;
import com.myscript.nebo.p022ai.presentation.compose.components.StreamingTextCardKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AISummarizePane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0091\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\f\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0012X\u008a\u0084\u0002"}, m1599d2 = {"AISummarizePane", "", "aiSummarizeViewModel", "Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;", "closeClick", "Lkotlin/Function0;", "shorterClick", "copyClick", "Lkotlin/Function1;", "", "summarizeCurrentPage", "summarizePages", "summarizeAllPages", "addToNoteClick", "tryAgainClick", "(Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "nebo-ai_release", "chooseNote", "", "error", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "isLoading", "aiGeneratedText", "isStreamingComplete"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AISummarizePaneKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AISummarizePane$lambda$7(AISummarizeViewModel aISummarizeViewModel, Function0 function0, Function0 function02, Function1 function1, Function0 function03, Function0 function04, Function0 function05, Function1 function12, Function0 function06, int i, Composer composer, int i2) {
        AISummarizePane(aISummarizeViewModel, function0, function02, function1, function03, function04, function05, function12, function06, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AISummarizePane(final AISummarizeViewModel aiSummarizeViewModel, final Function0<Unit> closeClick, final Function0<Unit> shorterClick, final Function1<? super String, Unit> copyClick, final Function0<Unit> summarizeCurrentPage, final Function0<Unit> summarizePages, final Function0<Unit> summarizeAllPages, final Function1<? super String, Unit> addToNoteClick, final Function0<Unit> tryAgainClick, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(aiSummarizeViewModel, "aiSummarizeViewModel");
        Intrinsics.checkNotNullParameter(closeClick, "closeClick");
        Intrinsics.checkNotNullParameter(shorterClick, "shorterClick");
        Intrinsics.checkNotNullParameter(copyClick, "copyClick");
        Intrinsics.checkNotNullParameter(summarizeCurrentPage, "summarizeCurrentPage");
        Intrinsics.checkNotNullParameter(summarizePages, "summarizePages");
        Intrinsics.checkNotNullParameter(summarizeAllPages, "summarizeAllPages");
        Intrinsics.checkNotNullParameter(addToNoteClick, "addToNoteClick");
        Intrinsics.checkNotNullParameter(tryAgainClick, "tryAgainClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(331149271);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AISummarizePane)N(aiSummarizeViewModel,closeClick,shorterClick,copyClick,summarizeCurrentPage,summarizePages,summarizeAllPages,addToNoteClick,tryAgainClick)28@1099L21,29@1165L20,30@1238L21,31@1324L18,32@1415L21,36@1492L388,34@1442L438,52@1983L524,50@1886L621:AISummarizePane.kt#ez9f2c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(aiSummarizeViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(closeClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(shorterClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(copyClick) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(summarizeCurrentPage) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(summarizePages) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(summarizeAllPages) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(addToNoteClick) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(tryAgainClick) ? 67108864 : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(331149271, i2, -1, "com.myscript.nebo.ai.presentation.compose.AISummarizePane (AISummarizePane.kt:27)");
            }
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(aiSummarizeViewModel.getChooseNoteInput(), false, composerStartRestartGroup, 48);
            final State stateObserveAsState2 = LiveDataAdapterKt.observeAsState(aiSummarizeViewModel.getError(), null, composerStartRestartGroup, 48);
            final State stateObserveAsState3 = LiveDataAdapterKt.observeAsState(aiSummarizeViewModel.isLoading(), false, composerStartRestartGroup, 48);
            final State stateObserveAsState4 = LiveDataAdapterKt.observeAsState(aiSummarizeViewModel.getAiGeneratedText(), "", composerStartRestartGroup, 48);
            final State stateObserveAsState5 = LiveDataAdapterKt.observeAsState(aiSummarizeViewModel.isStreamingComplete(), false, composerStartRestartGroup, 48);
            AnimateCardKt.m12854AnimatedCardWHejsw(AISummarizePane$lambda$0(stateObserveAsState), null, null, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(-635176083, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.AISummarizePaneKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AISummarizePaneKt.AISummarizePane$lambda$5(summarizeCurrentPage, summarizeAllPages, summarizePages, closeClick, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            composer2 = composerStartRestartGroup;
            AnimateCardKt.m12854AnimatedCardWHejsw(AISummarizePane$lambda$1(stateObserveAsState2) != null || AISummarizePane$lambda$2(stateObserveAsState3) || AISummarizePane$lambda$3(stateObserveAsState4).length() > 0, null, null, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(571142628, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.AISummarizePaneKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AISummarizePaneKt.AISummarizePane$lambda$6(closeClick, shorterClick, copyClick, addToNoteClick, tryAgainClick, stateObserveAsState2, stateObserveAsState3, stateObserveAsState4, stateObserveAsState5, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.AISummarizePaneKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AISummarizePaneKt.AISummarizePane$lambda$7(aiSummarizeViewModel, closeClick, shorterClick, copyClick, summarizeCurrentPage, summarizePages, summarizeAllPages, addToNoteClick, tryAgainClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AISummarizePane$lambda$5(final Function0 function0, final Function0 function02, final Function0 function03, Function0 function04, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C39@1617L210,37@1502L372:AISummarizePane.kt#ez9f2c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-635176083, i, -1, "com.myscript.nebo.ai.presentation.compose.AISummarizePane.<anonymous> (AISummarizePane.kt:37)");
        }
        int i2 = C6091R.string.ai_select_notes_description;
        ComposerKt.sourceInformationMarkerStart(composer, -518855521, "CC(remember):AISummarizePane.kt#9igjgp");
        boolean zChanged = composer.changed(function0) | composer.changed(function02) | composer.changed(function03);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.AISummarizePaneKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AISummarizePaneKt.AISummarizePane$lambda$5$0$0(function0, function02, function03, ((Integer) obj).intValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        ChooseNoteCardKt.ChooseNoteCard(i2, (Function1) objRememberedValue, function04, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AISummarizePane$lambda$5$0$0(Function0 function0, Function0 function02, Function0 function03, int i) {
        if (i == 0) {
            function0.invoke();
        } else if (i == 1) {
            function02.invoke();
        } else if (i == 2) {
            function03.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AISummarizePane$lambda$6(Function0 function0, Function0 function02, Function1 function1, Function1 function12, Function0 function03, State state, State state2, State state3, State state4, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C53@1993L508:AISummarizePane.kt#ez9f2c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(571142628, i, -1, "com.myscript.nebo.ai.presentation.compose.AISummarizePane.<anonymous> (AISummarizePane.kt:53)");
        }
        StreamingTextCardKt.StreamingTextCard(C6091R.string.ai_summarize_title, AISummarizePane$lambda$1(state), AISummarizePane$lambda$2(state2), AISummarizePane$lambda$3(state3), AISummarizePane$lambda$4(state4), AISummarizePane$lambda$4(state4) && AISummarizePane$lambda$1(state) == null, function0, function02, function1, function12, function03, composer, 0, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final boolean AISummarizePane$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final AIError AISummarizePane$lambda$1(State<? extends AIError> state) {
        return state.getValue();
    }

    private static final boolean AISummarizePane$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String AISummarizePane$lambda$3(State<String> state) {
        return state.getValue();
    }

    private static final boolean AISummarizePane$lambda$4(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
