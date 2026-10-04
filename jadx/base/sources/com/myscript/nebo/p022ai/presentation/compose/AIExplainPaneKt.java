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
import com.myscript.nebo.p022ai.C6091R;
import com.myscript.nebo.p022ai.presentation.AIExplainViewModel;
import com.myscript.nebo.p022ai.presentation.compose.components.AnimateCardKt;
import com.myscript.nebo.p022ai.presentation.compose.components.StreamingTextCardKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIExplainPane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f²\u0006\f\u0010\r\u001a\u0004\u0018\u00010\u000eX\u008a\u0084\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0010X\u008a\u0084\u0002"}, m1599d2 = {"AIExplainPane", "", "aiExplainViewModel", "Lcom/myscript/nebo/ai/presentation/AIExplainViewModel;", "closeClick", "Lkotlin/Function0;", "copyClick", "Lkotlin/Function1;", "", "addToNoteClick", "tryAgainClick", "(Lcom/myscript/nebo/ai/presentation/AIExplainViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "nebo-ai_release", "error", "Lcom/myscript/nebo/ai/presentation/compose/AIError;", "isLoading", "", "aiGeneratedText", "isStreamingComplete"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIExplainPaneKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIExplainPane$lambda$5(AIExplainViewModel aIExplainViewModel, Function0 function0, Function1 function1, Function1 function12, Function0 function02, int i, Composer composer, int i2) {
        AIExplainPane(aIExplainViewModel, function0, function1, function12, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AIExplainPane(final AIExplainViewModel aiExplainViewModel, final Function0<Unit> closeClick, final Function1<? super String, Unit> copyClick, final Function1<? super String, Unit> addToNoteClick, final Function0<Unit> tryAgainClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(aiExplainViewModel, "aiExplainViewModel");
        Intrinsics.checkNotNullParameter(closeClick, "closeClick");
        Intrinsics.checkNotNullParameter(copyClick, "copyClick");
        Intrinsics.checkNotNullParameter(addToNoteClick, "addToNoteClick");
        Intrinsics.checkNotNullParameter(tryAgainClick, "tryAgainClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-88306371);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIExplainPane)N(aiExplainViewModel,closeClick,copyClick,addToNoteClick,tryAgainClick)20@728L20,21@799L21,22@883L18,23@972L21,27@1042L448,25@999L491:AIExplainPane.kt#ez9f2c");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(aiExplainViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(closeClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(copyClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(addToNoteClick) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(tryAgainClick) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-88306371, i2, -1, "com.myscript.nebo.ai.presentation.compose.AIExplainPane (AIExplainPane.kt:19)");
            }
            final State stateObserveAsState = LiveDataAdapterKt.observeAsState(aiExplainViewModel.getError(), null, composerStartRestartGroup, 48);
            final State stateObserveAsState2 = LiveDataAdapterKt.observeAsState(aiExplainViewModel.isLoading(), false, composerStartRestartGroup, 48);
            final State stateObserveAsState3 = LiveDataAdapterKt.observeAsState(aiExplainViewModel.getAiGeneratedText(), "", composerStartRestartGroup, 48);
            final State stateObserveAsState4 = LiveDataAdapterKt.observeAsState(aiExplainViewModel.isStreamingComplete(), false, composerStartRestartGroup, 48);
            AnimateCardKt.m12854AnimatedCardWHejsw(true, null, null, null, 0.0f, ComposableLambdaKt.rememberComposableLambda(906481491, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.AIExplainPaneKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIExplainPaneKt.AIExplainPane$lambda$4(closeClick, copyClick, addToNoteClick, tryAgainClick, stateObserveAsState, stateObserveAsState2, stateObserveAsState3, stateObserveAsState4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 196614, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.AIExplainPaneKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIExplainPaneKt.AIExplainPane$lambda$5(aiExplainViewModel, closeClick, copyClick, addToNoteClick, tryAgainClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIExplainPane$lambda$4(Function0 function0, Function1 function1, Function1 function12, Function0 function02, State state, State state2, State state3, State state4, AnimatedVisibilityScope AnimatedCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedCard, "$this$AnimatedCard");
        ComposerKt.sourceInformation(composer, "C35@1349L2,28@1052L432:AIExplainPane.kt#ez9f2c");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(906481491, i, -1, "com.myscript.nebo.ai.presentation.compose.AIExplainPane.<anonymous> (AIExplainPane.kt:28)");
        }
        int i2 = C6091R.string.ai_explain_title;
        AIError aIErrorAIExplainPane$lambda$0 = AIExplainPane$lambda$0(state);
        boolean zAIExplainPane$lambda$1 = AIExplainPane$lambda$1(state2);
        String strAIExplainPane$lambda$2 = AIExplainPane$lambda$2(state3);
        boolean zAIExplainPane$lambda$3 = AIExplainPane$lambda$3(state4);
        ComposerKt.sourceInformationMarkerStart(composer, -749638411, "CC(remember):AIExplainPane.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.AIExplainPaneKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        StreamingTextCardKt.StreamingTextCard(i2, aIErrorAIExplainPane$lambda$0, zAIExplainPane$lambda$1, strAIExplainPane$lambda$2, zAIExplainPane$lambda$3, false, function0, (Function0) objRememberedValue, function1, function12, function02, composer, 12582912, 0, 32);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final AIError AIExplainPane$lambda$0(State<? extends AIError> state) {
        return state.getValue();
    }

    private static final boolean AIExplainPane$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String AIExplainPane$lambda$2(State<String> state) {
        return state.getValue();
    }

    private static final boolean AIExplainPane$lambda$3(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
