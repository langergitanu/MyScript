package com.myscript.nebo.p022ai.presentation.compose.quiz;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.RadioButtonColors;
import androidx.compose.material.RadioButtonDefaults;
import androidx.compose.material.RadioButtonKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
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
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.credentials.provider.CredentialEntry;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.myscript.android.utils.p019ui.compose.autosizetext.AutoSizeTextKt;
import com.myscript.nebo.p022ai.C6091R;
import com.myscript.nebo.p022ai.presentation.QuestionResult;
import com.myscript.nebo.p022ai.presentation.QuizMode;
import com.myscript.nebo.p022ai.presentation.QuizMultipleChoiceQuestion;
import com.myscript.nebo.p022ai.presentation.QuizQuestion;
import com.myscript.nebo.p022ai.presentation.QuizState;
import com.myscript.nebo.p022ai.presentation.QuizTrueFalseQuestion;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;
import okio.Utf8;

/* JADX INFO: compiled from: AIQuizCard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u001a\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000f\u001aS\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0011\u001aW\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u0018\u001aC\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\"\u001aS\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010)\u001a?\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u000bH\u0003¢\u0006\u0002\u0010.\u001a1\u0010/\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u00100\u001aK\u00101\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u00052\b\b\u0002\u00106\u001a\u00020\u0005H\u0007¢\u0006\u0002\u00107\u001a\r\u00108\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001aE\u0010:\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u000b2\b\u0010<\u001a\u0004\u0018\u00010\u000b2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010>\u001a\r\u0010?\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010@\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010A\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010B\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010C\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010D\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010E\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010F\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010G\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010H\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010I\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010J\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109\u001a\r\u0010K\u001a\u00020\u0001H\u0007¢\u0006\u0002\u00109¨\u0006L²\u0006\n\u0010\u0015\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010M\u001a\u000203X\u008a\u008e\u0002"}, m1599d2 = {"AIQuizCard", "", "aiQuizState", "Lcom/myscript/nebo/ai/presentation/QuizState;", "noteHidden", "", "closeClick", "Lkotlin/Function0;", "aiQuizQuestionNextClick", "answerQuestionClick", "Lkotlin/Function1;", "", "tryAgainClick", "hideNoteClick", "nextQuestionsClick", "(Lcom/myscript/nebo/ai/presentation/QuizState;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "AIQuizCardContent", "(Lcom/myscript/nebo/ai/presentation/QuizState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AIQuizCardMenu", "modifier", "Landroidx/compose/ui/Modifier;", "showToggleNoteMenu", "onShowNoteMenuChange", "aiQuizQuestionCloseClick", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "AIQuizQuestionResult", "currentQuestion", "Lcom/myscript/nebo/ai/presentation/QuizQuestion;", "questionResult", "Lcom/myscript/nebo/ai/presentation/QuestionResult;", "selectedAnswer", "nextQuestionLoading", "showViewScoreButton", "nextQuestionClick", "(Lcom/myscript/nebo/ai/presentation/QuizQuestion;Lcom/myscript/nebo/ai/presentation/QuestionResult;Ljava/lang/String;ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AIQuizMultipleChoice", "title", "questionTitle", "options", "", "correctAnswer", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AnswerOptionRow", "text", "isChecked", "onSelected", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "AIQuizTrueFalse", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AIQuizEnded", FirebaseAnalytics.Param.SCORE, "", "expectedQuestionCount", "shouldDisplayNewQuestionsButton", "loadingNextQuestions", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;IIZZLandroidx/compose/runtime/Composer;II)V", "NextQuestionLoadingButton", "(Landroidx/compose/runtime/Composer;I)V", "AnswerRadioButton", "optionAnswer", "userSelectedAnswer", "onAnswerSelected", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ABCRadioButtonUnselectedPreview", "ABCRadioButtonSelectedPreview", "ABCRadioButtonRightAnswerPreview", "ABCRadioButtonWrongAnswerPreview", "AIQuizTrueFalseCardPreview", "AIQuizMultipleChoicePreview", "AIQuizMultipleChoiceWrongAnswerPreview", "AIQuizMultipleChoiceRightAnswerPreview", "AIQuizTrueFalseCardResultNextQuestionDisabledPreview", "AIQuizTrueFalseCardResultPreview", "AIQuizEndedCardPreview", "AIQuizEndedLoadingNewQuestionsCardPreview", "AIQuizEndedCardNewQuestionsPreview", "nebo-ai_release", "selectedOption"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIQuizCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ABCRadioButtonRightAnswerPreview$lambda$1(int i, Composer composer, int i2) {
        ABCRadioButtonRightAnswerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ABCRadioButtonSelectedPreview$lambda$1(int i, Composer composer, int i2) {
        ABCRadioButtonSelectedPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ABCRadioButtonUnselectedPreview$lambda$1(int i, Composer composer, int i2) {
        ABCRadioButtonUnselectedPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ABCRadioButtonWrongAnswerPreview$lambda$1(int i, Composer composer, int i2) {
        ABCRadioButtonWrongAnswerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCard$lambda$10(QuizState quizState, boolean z, Function0 function0, Function0 function02, Function1 function1, Function0 function03, Function0 function04, Function0 function05, int i, int i2, Composer composer, int i3) {
        AIQuizCard(quizState, z, function0, function02, function1, function03, function04, function05, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCardContent$lambda$0(QuizState quizState, Function0 function0, Function1 function1, Function0 function02, Function0 function03, int i, Composer composer, int i2) {
        AIQuizCardContent(quizState, function0, function1, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCardMenu$lambda$1(Modifier modifier, boolean z, boolean z2, Function1 function1, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        AIQuizCardMenu(modifier, z, z2, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizEnded$lambda$1(Function0 function0, Function0 function02, int i, int i2, boolean z, boolean z2, int i3, int i4, Composer composer, int i5) {
        AIQuizEnded(function0, function02, i, i2, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizEndedCardNewQuestionsPreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizEndedCardNewQuestionsPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizEndedCardPreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizEndedCardPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizEndedLoadingNewQuestionsCardPreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizEndedLoadingNewQuestionsCardPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizMultipleChoice$lambda$4(String str, String str2, List list, String str3, String str4, Function1 function1, int i, Composer composer, int i2) {
        AIQuizMultipleChoice(str, str2, list, str3, str4, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizMultipleChoicePreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizMultipleChoicePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizMultipleChoiceRightAnswerPreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizMultipleChoiceRightAnswerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizMultipleChoiceWrongAnswerPreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizMultipleChoiceWrongAnswerPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizQuestionResult$lambda$1(QuizQuestion quizQuestion, QuestionResult questionResult, String str, boolean z, boolean z2, Function0 function0, int i, Composer composer, int i2) {
        AIQuizQuestionResult(quizQuestion, questionResult, str, z, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizTrueFalse$lambda$1(String str, String str2, Function1 function1, int i, Composer composer, int i2) {
        AIQuizTrueFalse(str, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizTrueFalseCardPreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizTrueFalseCardPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizTrueFalseCardResultNextQuestionDisabledPreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizTrueFalseCardResultNextQuestionDisabledPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizTrueFalseCardResultPreview$lambda$0(int i, Composer composer, int i2) {
        AIQuizTrueFalseCardResultPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerOptionRow$lambda$2(String str, boolean z, Function0 function0, String str2, String str3, int i, Composer composer, int i2) {
        AnswerOptionRow(str, z, function0, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerRadioButton$lambda$1(boolean z, String str, String str2, String str3, Function1 function1, int i, Composer composer, int i2) {
        AnswerRadioButton(z, str, str2, str3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NextQuestionLoadingButton$lambda$2(int i, Composer composer, int i2) {
        NextQuestionLoadingButton(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCard$lambda$2$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AIQuizCard(final QuizState aiQuizState, final boolean z, Function0<Unit> function0, Function0<Unit> function02, Function1<? super String, Unit> function1, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        Function0<Unit> function06;
        int i4;
        Function0<Unit> function07;
        int i5;
        Function1<? super String, Unit> function12;
        int i6;
        Function0<Unit> function08;
        int i7;
        int i8;
        int i9;
        Composer composer2;
        final Function0<Unit> function09;
        final Function0<Unit> function010;
        final Function0<Unit> function011;
        final Function1<? super String, Unit> function13;
        final Function0<Unit> function012;
        final Function0<Unit> function013;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function0<Unit> function014;
        final Function1<? super String, Unit> function14;
        final Function0<Unit> function015;
        Function0<Unit> function016;
        final Function0<Unit> function017;
        Intrinsics.checkNotNullParameter(aiQuizState, "aiQuizState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1249879758);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizCard)N(aiQuizState,noteHidden,closeClick,aiQuizQuestionNextClick,answerQuestionClick,tryAgainClick,hideNoteClick,nextQuestionsClick)64@2831L2,65@2877L2,66@2925L2,67@2961L2,68@2997L2,69@3038L2,71@3075L34:AIQuizCard.kt#nf75a9");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(aiQuizState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            z2 = z;
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        } else {
            z2 = z;
        }
        int i10 = i2 & 4;
        if (i10 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function06 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function06) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    function07 = function02;
                    i3 |= composerStartRestartGroup.changedInstance(function07) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function12 = function1;
                        i3 |= composerStartRestartGroup.changedInstance(function12) ? 16384 : 8192;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else {
                        if ((196608 & i) == 0) {
                            function08 = function03;
                            i3 |= composerStartRestartGroup.changedInstance(function08) ? 131072 : 65536;
                        }
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= composerStartRestartGroup.changedInstance(function04) ? 1048576 : 524288;
                        }
                        i8 = i2 & 128;
                        if (i8 == 0) {
                            if ((i & 12582912) == 0) {
                                i9 = i8;
                                i3 |= composerStartRestartGroup.changedInstance(function05) ? 8388608 : 4194304;
                            }
                            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                function09 = function04;
                                function010 = function06;
                                function011 = function07;
                                function13 = function12;
                                function012 = function08;
                                function013 = function05;
                            } else {
                                if (i10 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456398580, "CC(remember):AIQuizCard.kt#9igjgp");
                                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda50
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function010 = (Function0) objRememberedValue;
                                } else {
                                    function010 = function06;
                                }
                                if (i4 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456400052, "CC(remember):AIQuizCard.kt#9igjgp");
                                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda51
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function014 = (Function0) objRememberedValue2;
                                } else {
                                    function014 = function07;
                                }
                                if (i5 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456401588, "CC(remember):AIQuizCard.kt#9igjgp");
                                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda52
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return AIQuizCardKt.AIQuizCard$lambda$2$0((String) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function14 = (Function1) objRememberedValue3;
                                } else {
                                    function14 = function12;
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456402740, "CC(remember):AIQuizCard.kt#9igjgp");
                                    Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue4 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda53
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function015 = (Function0) objRememberedValue4;
                                } else {
                                    function015 = function08;
                                }
                                if (i7 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456403892, "CC(remember):AIQuizCard.kt#9igjgp");
                                    Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue5 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda54
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                    }
                                    function016 = (Function0) objRememberedValue5;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function016 = function04;
                                }
                                if (i9 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456405204, "CC(remember):AIQuizCard.kt#9igjgp");
                                    Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue6 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                    }
                                    function013 = (Function0) objRememberedValue6;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function013 = function05;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1249879758, i3, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCard (AIQuizCard.kt:70)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456406420, "CC(remember):AIQuizCard.kt#9igjgp");
                                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                }
                                final MutableState mutableState = (MutableState) objRememberedValue7;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (!aiQuizState.getQuestions().isEmpty()) {
                                    composerStartRestartGroup.startReplaceGroup(-2095907500);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3304L1329,74@3165L1468");
                                    function017 = function016;
                                    final boolean z3 = z2;
                                    CardKt.m4173CardFjzlyU(SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(WorkflowTransitionState.SLIDE_DURATION_MS)), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(12)), 0L, 0L, null, C1486Dp.m11017constructorimpl(8), ComposableLambdaKt.rememberComposableLambda(99156784, true, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return AIQuizCardKt.AIQuizCard$lambda$9(z3, function017, function010, aiQuizState, function014, function14, function015, function013, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 1769478, 28);
                                    composer2 = composerStartRestartGroup;
                                    composer2.endReplaceGroup();
                                } else {
                                    function017 = function016;
                                    composer2 = composerStartRestartGroup;
                                    composer2.startReplaceGroup(-2094490800);
                                    composer2.endReplaceGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function011 = function014;
                                function13 = function14;
                                function012 = function015;
                                function09 = function017;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup == null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AIQuizCardKt.AIQuizCard$lambda$10(aiQuizState, z, function010, function011, function13, function012, function09, function013, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i3 |= 12582912;
                        i9 = i8;
                        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup == null) {
                        }
                    }
                    function08 = function03;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    i8 = i2 & 128;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                    }
                }
                function12 = function1;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                function08 = function03;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function07 = function02;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function12 = function1;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function08 = function03;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function06 = function0;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function07 = function02;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function12 = function1;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function08 = function03;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        if (composerStartRestartGroup.shouldExecute((i3 & 4793491) == 4793490, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final boolean AIQuizCard$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AIQuizCard$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCard$lambda$9(boolean z, Function0 function0, Function0 function02, QuizState quizState, Function0 function03, Function1 function1, Function0 function04, Function0 function05, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C79@3318L1305:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(99156784, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCard.<anonymous> (AIQuizCard.kt:79)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1008315912, "C80@3340L866,103@4409L27,100@4224L385:AIQuizCard.kt#nf75a9");
            Modifier modifierAnimateContentSize$default = AnimationModifierKt.animateContentSize$default(PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(16)), AnimationSpecKt.spring$default(0.5f, 200.0f, null, 4, null), null, 2, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierAnimateContentSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 265897527, "C91@3836L352:AIQuizCard.kt#nf75a9");
            AIQuizCardContent(quizState, function03, function1, function04, function05, composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierAlign = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd());
            boolean zAIQuizCard$lambda$7 = AIQuizCard$lambda$7(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1279419343, "CC(remember):AIQuizCard.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AIQuizCardKt.AIQuizCard$lambda$9$0$1$0(mutableState, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AIQuizCardMenu(modifierAlign, z, zAIQuizCard$lambda$7, (Function1) objRememberedValue, function0, function02, composer, 3072, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCard$lambda$9$0$1$0(MutableState mutableState, boolean z) {
        AIQuizCard$lambda$8(mutableState, z);
        return Unit.INSTANCE;
    }

    public static final void AIQuizCardContent(final QuizState aiQuizState, final Function0<Unit> aiQuizQuestionNextClick, final Function1<? super String, Unit> answerQuestionClick, final Function0<Unit> tryAgainClick, final Function0<Unit> nextQuestionsClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(aiQuizState, "aiQuizState");
        Intrinsics.checkNotNullParameter(aiQuizQuestionNextClick, "aiQuizQuestionNextClick");
        Intrinsics.checkNotNullParameter(answerQuestionClick, "answerQuestionClick");
        Intrinsics.checkNotNullParameter(tryAgainClick, "tryAgainClick");
        Intrinsics.checkNotNullParameter(nextQuestionsClick, "nextQuestionsClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-661810685);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizCardContent)N(aiQuizState,aiQuizQuestionNextClick,answerQuestionClick,tryAgainClick,nextQuestionsClick):AIQuizCard.kt#nf75a9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(aiQuizState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(aiQuizQuestionNextClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(answerQuestionClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(tryAgainClick) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(nextQuestionsClick) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-661810685, i2, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardContent (AIQuizCard.kt:120)");
            }
            if (aiQuizState.getCurrentQuestionResult() != null) {
                composerStartRestartGroup.startReplaceGroup(-2101932794);
                ComposerKt.sourceInformation(composerStartRestartGroup, "123@4939L441");
                QuizQuestion currentQuestion = aiQuizState.getCurrentQuestion();
                Intrinsics.checkNotNull(currentQuestion);
                QuestionResult currentQuestionResult = aiQuizState.getCurrentQuestionResult();
                String selectedAnswer = aiQuizState.getSelectedAnswer();
                if (selectedAnswer == null) {
                    selectedAnswer = "";
                }
                AIQuizQuestionResult(currentQuestion, currentQuestionResult, selectedAnswer, aiQuizState.getNextQuestionLoading(), aiQuizState.getShowViewScoreButton(), aiQuizQuestionNextClick, composerStartRestartGroup, (i2 << 12) & 458752);
                composerStartRestartGroup.endReplaceGroup();
            } else if (aiQuizState.getQuizEnded()) {
                composerStartRestartGroup.startReplaceGroup(-2101451736);
                ComposerKt.sourceInformation(composerStartRestartGroup, "133@5438L415");
                AIQuizEnded(tryAgainClick, nextQuestionsClick, aiQuizState.getScore(), aiQuizState.getExpectedQuestionCount(), aiQuizState.getShouldDisplayNewQuestionsButton(), aiQuizState.getLoadingNextQuestions(), composerStartRestartGroup, (i2 >> 9) & WebSocketProtocol.PAYLOAD_SHORT, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                int i3 = i2;
                if (aiQuizState.getQuizMode() == QuizMode.TRUE_FALSE) {
                    composerStartRestartGroup.startReplaceGroup(-2100959022);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "144@6042L47,145@6215L187");
                    QuizQuestion currentQuestion2 = aiQuizState.getCurrentQuestion();
                    Intrinsics.checkNotNull(currentQuestion2, "null cannot be cast to non-null type com.myscript.nebo.ai.presentation.QuizTrueFalseQuestion");
                    String str = String.format(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_question_title, composerStartRestartGroup, 0), Arrays.copyOf(new Object[]{(aiQuizState.getQuestions().indexOf(aiQuizState.getCurrentQuestion()) + 1) + DomExceptionUtils.SEPARATOR + aiQuizState.getExpectedQuestionCount()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    AIQuizTrueFalse(str, ((QuizTrueFalseQuestion) currentQuestion2).getQuestion(), answerQuestionClick, composerStartRestartGroup, i3 & 896);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (aiQuizState.getQuizMode() == QuizMode.MULTIPLE_CHOICE) {
                    composerStartRestartGroup.startReplaceGroup(-2100401766);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "153@6602L47,154@6775L429");
                    QuizQuestion currentQuestion3 = aiQuizState.getCurrentQuestion();
                    Intrinsics.checkNotNull(currentQuestion3, "null cannot be cast to non-null type com.myscript.nebo.ai.presentation.QuizMultipleChoiceQuestion");
                    QuizMultipleChoiceQuestion quizMultipleChoiceQuestion = (QuizMultipleChoiceQuestion) currentQuestion3;
                    String str2 = String.format(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_question_title, composerStartRestartGroup, 0), Arrays.copyOf(new Object[]{(aiQuizState.getQuestions().indexOf(aiQuizState.getCurrentQuestion()) + 1) + DomExceptionUtils.SEPARATOR + aiQuizState.getExpectedQuestionCount()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    AIQuizMultipleChoice(str2, quizMultipleChoiceQuestion.getQuestion(), CollectionsKt.listOf((Object[]) new String[]{quizMultipleChoiceQuestion.getA(), quizMultipleChoiceQuestion.getB(), quizMultipleChoiceQuestion.getC()}), aiQuizState.getSelectedAnswer(), quizMultipleChoiceQuestion.getAnswer(), answerQuestionClick, composerStartRestartGroup, (i3 << 9) & 458752);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2099683713);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizCardContent$lambda$0(aiQuizState, aiQuizQuestionNextClick, answerQuestionClick, tryAgainClick, nextQuestionsClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizCardMenu(Modifier modifier, final boolean z, final boolean z2, final Function1<? super Boolean, Unit> onShowNoteMenuChange, final Function0<Unit> hideNoteClick, final Function0<Unit> aiQuizQuestionCloseClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(onShowNoteMenuChange, "onShowNoteMenuChange");
        Intrinsics.checkNotNullParameter(hideNoteClick, "hideNoteClick");
        Intrinsics.checkNotNullParameter(aiQuizQuestionCloseClick, "aiQuizQuestionCloseClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(791061060);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizCardMenu)N(modifier,noteHidden,showToggleNoteMenu,onShowNoteMenuChange,hideNoteClick,aiQuizQuestionCloseClick)175@7474L1539:AIQuizCard.kt#nf75a9");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onShowNoteMenuChange) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(hideNoteClick) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(aiQuizQuestionCloseClick) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(791061060, i3, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardMenu (AIQuizCard.kt:174)");
            }
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(companion, C1486Dp.m11017constructorimpl(16));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1592363243, "C180@7607L996,207@8612L39,208@8660L347:AIQuizCard.kt#nf75a9");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -350109663, "C182@7663L30,181@7625L381,193@8115L31,194@8161L432,191@8019L574:AIQuizCard.kt#nf75a9");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950956232, "CC(remember):AIQuizCard.kt#9igjgp");
            int i5 = i3 & 7168;
            boolean z3 = i5 == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda32
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizCardKt.AIQuizCardMenu$lambda$0$0$0$0(onShowNoteMenuChange);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float f = 18;
            int i6 = i3;
            Modifier modifier4 = companion;
            IconButtonKt.IconButton((Function0) objRememberedValue, SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), false, null, ComposableSingletons$AIQuizCardKt.INSTANCE.m12902getLambda$3060994$nebo_ai_release(), composerStartRestartGroup, 24624, 12);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1950941767, "CC(remember):AIQuizCard.kt#9igjgp");
            boolean z4 = i5 == 2048;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda34
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizCardKt.AIQuizCardMenu$lambda$0$0$1$0(onShowNoteMenuChange);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidMenu_androidKt.m4104DropdownMenu4kj_NE(z2, (Function0) objRememberedValue2, null, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(684457159, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIQuizCardKt.AIQuizCardMenu$lambda$0$0$2(onShowNoteMenuChange, hideNoteClick, z, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i6 >> 6) & 14) | 1572864, 60);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(8)), composerStartRestartGroup, 6);
            IconButtonKt.IconButton(aiQuizQuestionCloseClick, SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), false, null, ComposableSingletons$AIQuizCardKt.INSTANCE.getLambda$804366404$nebo_ai_release(), composerStartRestartGroup, ((i6 >> 15) & 14) | 24624, 12);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizCardMenu$lambda$1(modifier3, z, z2, onShowNoteMenuChange, hideNoteClick, aiQuizQuestionCloseClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCardMenu$lambda$0$0$0$0(Function1 function1) {
        function1.invoke(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCardMenu$lambda$0$0$1$0(Function1 function1) {
        function1.invoke(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCardMenu$lambda$0$0$2(final Function1 function1, final Function0 function0, final boolean z, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C195@8206L103,198@8311L268,195@8179L400:AIQuizCard.kt#nf75a9");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(684457159, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardMenu.<anonymous>.<anonymous>.<anonymous> (AIQuizCard.kt:195)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 633335054, "CC(remember):AIQuizCard.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizCardKt.AIQuizCardMenu$lambda$0$0$2$0$0(function1, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AndroidMenu_androidKt.DropdownMenuItem((Function0) objRememberedValue, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(1652398314, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AIQuizCardKt.AIQuizCardMenu$lambda$0$0$2$1(z, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCardMenu$lambda$0$0$2$0$0(Function1 function1, Function0 function0) {
        function1.invoke(false);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizCardMenu$lambda$0$0$2$1(boolean z, RowScope DropdownMenuItem, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        ComposerKt.sourceInformation(composer, "C:AIQuizCard.kt#nf75a9");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1652398314, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardMenu.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AIQuizCard.kt:199)");
            }
            if (z) {
                composer.startReplaceGroup(1978033809);
                ComposerKt.sourceInformation(composer, "200@8380L49,200@8375L55");
                TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_button_note_show, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1978141937);
                ComposerKt.sourceInformation(composer, "202@8489L49,202@8484L55");
                TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_button_note_hide, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AIQuizQuestionResult(final QuizQuestion currentQuestion, final QuestionResult questionResult, final String selectedAnswer, final boolean z, final boolean z2, final Function0<Unit> nextQuestionClick, Composer composer, final int i) {
        int i2;
        int i3;
        float f;
        boolean z3;
        String a2;
        int i4;
        boolean z4;
        Intrinsics.checkNotNullParameter(currentQuestion, "currentQuestion");
        Intrinsics.checkNotNullParameter(questionResult, "questionResult");
        Intrinsics.checkNotNullParameter(selectedAnswer, "selectedAnswer");
        Intrinsics.checkNotNullParameter(nextQuestionClick, "nextQuestionClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2059154111);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizQuestionResult)N(currentQuestion,questionResult,selectedAnswer,nextQuestionLoading,showViewScoreButton,nextQuestionClick)230@9264L2884:AIQuizCard.kt#nf75a9");
        int i5 = (i & 6) == 0 ? ((i & 8) == 0 ? composerStartRestartGroup.changed(currentQuestion) : composerStartRestartGroup.changedInstance(currentQuestion) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(questionResult) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= composerStartRestartGroup.changed(selectedAnswer) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(nextQuestionClick) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i5) != 74898, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2059154111, i5, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizQuestionResult (AIQuizCard.kt:229)");
            }
            Alignment.Horizontal start = Alignment.INSTANCE.getStart();
            float f2 = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, start, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 883741340, "C235@9417L41,236@9494L10,237@9543L6,234@9392L219:AIQuizCard.kt#nf75a9");
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(questionResult.getGoodAnswer(), composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getH6(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 0, 65498);
            if (currentQuestion instanceof QuizTrueFalseQuestion) {
                composerStartRestartGroup.startReplaceGroup(883971080);
                ComposerKt.sourceInformation(composerStartRestartGroup, "244@9817L10,245@9877L6,242@9703L209");
                String explanation = ((QuizTrueFalseQuestion) currentQuestion).getExplanation();
                if (explanation == null) {
                    explanation = "";
                }
                TextKt.m4524Text4IGK_g(explanation, (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody2(), composerStartRestartGroup, 0, 0, 65530);
                composerStartRestartGroup.endReplaceGroup();
                i2 = 54;
                i3 = i5;
                f = f2;
                z3 = true;
            } else if (currentQuestion instanceof QuizMultipleChoiceQuestion) {
                composerStartRestartGroup.startReplaceGroup(884278972);
                ComposerKt.sourceInformation(composerStartRestartGroup, "251@10122L10,252@10182L6,249@9990L227,263@10686L3,260@10488L323,270@11026L3,267@10828L323,277@11366L3,274@11168L323");
                QuizMultipleChoiceQuestion quizMultipleChoiceQuestion = (QuizMultipleChoiceQuestion) currentQuestion;
                String explanation2 = quizMultipleChoiceQuestion.getExplanation();
                if (explanation2 == null) {
                    explanation2 = quizMultipleChoiceQuestion.getQuestion();
                }
                TextKt.m4524Text4IGK_g(explanation2, (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody2(), composerStartRestartGroup, 0, 0, 65530);
                String answer = quizMultipleChoiceQuestion.getAnswer();
                switch (answer.hashCode()) {
                    case 97:
                        a2 = !answer.equals(CmcdData.OBJECT_TYPE_AUDIO_ONLY) ? null : quizMultipleChoiceQuestion.getA();
                        break;
                    case 98:
                        if (answer.equals("b")) {
                            a2 = quizMultipleChoiceQuestion.getB();
                            break;
                        }
                        break;
                    case 99:
                        if (answer.equals("c")) {
                            a2 = quizMultipleChoiceQuestion.getC();
                            break;
                        }
                        break;
                }
                i2 = 54;
                String a3 = quizMultipleChoiceQuestion.getA();
                if (Intrinsics.areEqual(selectedAnswer, quizMultipleChoiceQuestion.getA()) || Intrinsics.areEqual(quizMultipleChoiceQuestion.getAnswer(), CmcdData.OBJECT_TYPE_AUDIO_ONLY)) {
                    i4 = i5;
                    z4 = true;
                } else {
                    i4 = i5;
                    z4 = false;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2106756428, "CC(remember):AIQuizCard.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i6 = ((i4 << 3) & 7168) | RendererCapabilities.DECODER_SUPPORT_MASK;
                f = f2;
                i3 = i4;
                String str = a2;
                z3 = true;
                AnswerOptionRow(a3, z4, (Function0) objRememberedValue, selectedAnswer, str, composerStartRestartGroup, i6);
                String b = quizMultipleChoiceQuestion.getB();
                boolean z5 = Intrinsics.areEqual(selectedAnswer, quizMultipleChoiceQuestion.getB()) || Intrinsics.areEqual(quizMultipleChoiceQuestion.getAnswer(), "b");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2106767308, "CC(remember):AIQuizCard.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda17
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnswerOptionRow(b, z5, (Function0) objRememberedValue2, selectedAnswer, str, composerStartRestartGroup, i6);
                String c = quizMultipleChoiceQuestion.getC();
                boolean z6 = Intrinsics.areEqual(selectedAnswer, quizMultipleChoiceQuestion.getC()) || Intrinsics.areEqual(quizMultipleChoiceQuestion.getAnswer(), "c");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2106778188, "CC(remember):AIQuizCard.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnswerOptionRow(c, z6, (Function0) objRememberedValue3, selectedAnswer, str, composerStartRestartGroup, i6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i2 = 54;
                i3 = i5;
                f = f2;
                z3 = true;
                composerStartRestartGroup.startReplaceGroup(885762105);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(885797414);
                ComposerKt.sourceInformation(composerStartRestartGroup, "284@11563L27");
                NextQuestionLoadingButton(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(885882137);
                ComposerKt.sourceInformation(composerStartRestartGroup, "288@11713L78,292@11856L276,286@11620L512");
                ButtonKt.Button(nextQuestionClick, null, false, null, null, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f)), null, ButtonDefaults.INSTANCE.m4162buttonColorsro_MJ88(0L, Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 48, 13), null, ComposableLambdaKt.rememberComposableLambda(-1994280587, z3, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AIQuizCardKt.AIQuizQuestionResult$lambda$0$3(z2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, i2), composerStartRestartGroup, ((i3 >> 15) & 14) | 805306368, WorkflowTransitionState.SLIDE_DURATION_MS);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizQuestionResult$lambda$1(currentQuestion, questionResult, selectedAnswer, z, z2, nextQuestionClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizQuestionResult$lambda$0$3(boolean z, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C295@11976L123,293@11874L244:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994280587, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizQuestionResult.<anonymous>.<anonymous> (AIQuizCard.kt:293)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(z ? C6091R.string.ai_quiz_result_view_score : C6091R.string.ai_quiz_button_next_question, composer, 0), PaddingKt.m2856paddingVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(10), 0.0f, 2, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 48, 0, 131068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void AIQuizMultipleChoice(final String title, final String questionTitle, List<String> list, final String str, final String str2, final Function1<? super String, Unit> answerQuestionClick, Composer composer, final int i) {
        Composer composer2;
        final MutableIntState mutableIntState;
        final List<String> options = list;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(questionTitle, "questionTitle");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(answerQuestionClick, "answerQuestionClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2138358353);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizMultipleChoice)N(title,questionTitle,options,selectedAnswer,correctAnswer,answerQuestionClick)311@12392L34,313@12432L1218:AIQuizCard.kt#nf75a9");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changed(title) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(questionTitle) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(options) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(answerQuestionClick) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2138358353, i2, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizMultipleChoice (AIQuizCard.kt:310)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1968002415, "CC(remember):AIQuizCard.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(-1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Alignment.Horizontal start = Alignment.INSTANCE.getStart();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, start, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -224753298, "C319@12626L10,320@12675L6,317@12560L183,325@12826L10,326@12878L6,323@12752L153,339@13255L41,342@13336L68,344@13486L70,341@13306L338:AIQuizCard.kt#nf75a9");
            int i3 = i2;
            MutableIntState mutableIntState3 = mutableIntState2;
            String str3 = "CC(remember):AIQuizCard.kt#9igjgp";
            TextKt.m4524Text4IGK_g(title, (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getH6(), composerStartRestartGroup, (i2 & 14) | ProfileVerifier.CompilationStatus.f379xf2722a21, 0, 65498);
            TextKt.m4524Text4IGK_g(questionTitle, (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody2(), composerStartRestartGroup, (i3 >> 3) & 14, 0, 65530);
            composerStartRestartGroup.startReplaceGroup(-561428581);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*333@13099L26,330@12969L266");
            options = list;
            final int i4 = 0;
            for (Object obj : options) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str4 = (String) obj;
                boolean z = AIQuizMultipleChoice$lambda$1(mutableIntState3) == i4;
                String str5 = str3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -372191539, str5);
                boolean zChanged = composerStartRestartGroup.changed(i4);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    mutableIntState = mutableIntState3;
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AIQuizCardKt.AIQuizMultipleChoice$lambda$3$0$0$0(i4, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    mutableIntState = mutableIntState3;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AnswerOptionRow(str4, z, (Function0) objRememberedValue2, str, str2, composerStartRestartGroup, i3 & 64512);
                mutableIntState3 = mutableIntState;
                i4 = i5;
                str3 = str5;
            }
            final MutableIntState mutableIntState4 = mutableIntState3;
            composerStartRestartGroup.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(16)), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -561415619, str3);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(options) | ((i3 & 458752) == 131072);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizCardKt.AIQuizMultipleChoice$lambda$3$1$0(answerQuestionClick, options, mutableIntState4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function0 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ButtonKt.Button(function0, null, AIQuizMultipleChoice$lambda$1(mutableIntState4) != -1, null, null, null, null, ButtonDefaults.INSTANCE.m4162buttonColorsro_MJ88(0L, Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, composer2, (ButtonDefaults.$stable << 12) | 48, 13), null, ComposableSingletons$AIQuizCardKt.INSTANCE.getLambda$353261577$nebo_ai_release(), composer2, 805306368, 378);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final List<String> list2 = options;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return AIQuizCardKt.AIQuizMultipleChoice$lambda$4(title, questionTitle, list2, str, str2, answerQuestionClick, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final int AIQuizMultipleChoice$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizMultipleChoice$lambda$3$0$0$0(int i, MutableIntState mutableIntState) {
        mutableIntState.setIntValue(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizMultipleChoice$lambda$3$1$0(Function1 function1, List list, MutableIntState mutableIntState) {
        String str = (String) CollectionsKt.getOrNull(list, AIQuizMultipleChoice$lambda$1(mutableIntState));
        if (str == null) {
            str = "";
        }
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    private static final void AnswerOptionRow(final String str, final boolean z, final Function0<Unit> function0, final String str2, final String str3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-379120194);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnswerOptionRow)N(text,isChecked,onSelected,selectedAnswer,correctAnswer)363@13885L16,361@13829L473:AIQuizCard.kt#nf75a9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(str3) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-379120194, i2, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AnswerOptionRow (AIQuizCard.kt:360)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 737720494, "CC(remember):AIQuizCard.kt#9igjgp");
            int i3 = i2 & 896;
            boolean z2 = i3 == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizCardKt.AnswerOptionRow$lambda$0$0(function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM2062clickableoSLSa3U$default = ClickableKt.m2062clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2062clickableoSLSa3U$default);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -994598117, "C372@14244L16,367@14034L236,374@14279L17:AIQuizCard.kt#nf75a9");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1833192654, "CC(remember):AIQuizCard.kt#9igjgp");
            boolean z3 = i3 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AIQuizCardKt.AnswerOptionRow$lambda$1$0$0(function0, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnswerRadioButton(z, str, str3, str2, (Function1) objRememberedValue2, composerStartRestartGroup, ((i2 >> 3) & 14) | ((i2 << 3) & 112) | ((i2 >> 6) & 896) | (i2 & 7168));
            TextKt.m4524Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, i2 & 14, 0, 131070);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AnswerOptionRow$lambda$2(str, z, function0, str2, str3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerOptionRow$lambda$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerOptionRow$lambda$1$0$0(Function0 function0, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void AIQuizTrueFalse(final String title, String questionTitle, final Function1<? super String, Unit> answerQuestionClick, Composer composer, final int i) {
        int i2;
        final String str;
        final Function1<? super String, Unit> function1;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(questionTitle, "questionTitle");
        Intrinsics.checkNotNullParameter(answerQuestionClick, "answerQuestionClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1056385397);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizTrueFalse)N(title,questionTitle,answerQuestionClick)384@14435L1645:AIQuizCard.kt#nf75a9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(questionTitle) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(answerQuestionClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            str = questionTitle;
            function1 = answerQuestionClick;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1056385397, i2, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizTrueFalse (AIQuizCard.kt:383)");
            }
            Alignment.Horizontal start = Alignment.INSTANCE.getStart();
            float f = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, start, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = i2;
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1803135175, "C390@14629L10,391@14678L6,388@14563L183,396@14829L10,397@14881L6,394@14755L153,399@14917L1157:AIQuizCard.kt#nf75a9");
            TextKt.m4524Text4IGK_g(title, (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getH6(), composerStartRestartGroup, (i3 & 14) | ProfileVerifier.CompilationStatus.f379xf2722a21, 0, 65498);
            str = questionTitle;
            TextKt.m4524Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody2(), composerStartRestartGroup, (i3 >> 3) & 14, 0, 65530);
            Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(f), 0.0f, 0.0f, 13, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2858paddingqDBjuR0$default);
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
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 630870898, "C403@15149L6,402@15083L146,401@15010L31,400@14976L520,413@15509L39,415@15609L127,419@15764L32,414@15561L503:AIQuizCard.kt#nf75a9");
            ButtonColors buttonColorsM4162buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m4162buttonColorsro_MJ88(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 48, 12);
            RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1088027952, "CC(remember):AIQuizCard.kt#9igjgp");
            int i4 = i3 & 896;
            boolean z = i4 == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda39
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizCardKt.AIQuizTrueFalse$lambda$0$0$0$0(answerQuestionClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function1 = answerQuestionClick;
            ButtonKt.Button((Function0) objRememberedValue, null, false, null, null, roundedCornerShapeM3235RoundedCornerShape0680j_4, null, buttonColorsM4162buttonColorsro_MJ88, null, ComposableSingletons$AIQuizCardKt.INSTANCE.m12900getLambda$1819726079$nebo_ai_release(), composerStartRestartGroup, 805306368, WorkflowTransitionState.SLIDE_DURATION_MS);
            SpacerKt.Spacer(SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), composerStartRestartGroup, 6);
            ButtonColors buttonColorsM4162buttonColorsro_MJ882 = ButtonDefaults.INSTANCE.m4162buttonColorsro_MJ88(Color.INSTANCE.m8182getRed0d7_KjU(), Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 54, 12);
            RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_42 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1088003823, "CC(remember):AIQuizCard.kt#9igjgp");
            boolean z2 = i4 == 256;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizCardKt.AIQuizTrueFalse$lambda$0$0$1$0(function1);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.Button((Function0) objRememberedValue2, null, false, null, null, roundedCornerShapeM3235RoundedCornerShape0680j_42, null, buttonColorsM4162buttonColorsro_MJ882, null, ComposableSingletons$AIQuizCardKt.INSTANCE.getLambda$586045290$nebo_ai_release(), composerStartRestartGroup, 805306368, WorkflowTransitionState.SLIDE_DURATION_MS);
            composerStartRestartGroup = composerStartRestartGroup;
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda41
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizTrueFalse$lambda$1(title, str, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizTrueFalse$lambda$0$0$0$0(Function1 function1) {
        function1.invoke(CredentialEntry.TRUE_STRING);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizTrueFalse$lambda$0$0$1$0(Function1 function1) {
        function1.invoke(CredentialEntry.FALSE_STRING);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AIQuizEnded(final Function0<Unit> tryAgainClick, final Function0<Unit> nextQuestionsClick, final int i, final int i2, final boolean z, boolean z2, Composer composer, final int i3, final int i4) {
        int i5;
        boolean z3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        long jM4203getPrimary0d7_KjU;
        Intrinsics.checkNotNullParameter(tryAgainClick, "tryAgainClick");
        Intrinsics.checkNotNullParameter(nextQuestionsClick, "nextQuestionsClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(486630301);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizEnded)N(tryAgainClick,nextQuestionsClick,score,expectedQuestionCount,shouldDisplayNewQuestionsButton,loadingNextQuestions)450@16780L3140:AIQuizCard.kt#nf75a9");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(tryAgainClick) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(nextQuestionsClick) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        int i7 = i4 & 32;
        if (i7 == 0) {
            if ((196608 & i3) == 0) {
                z3 = z2;
                i5 |= composerStartRestartGroup.changed(z3) ? 131072 : 65536;
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i5) == 74898, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z3;
            } else {
                if (i7 != 0) {
                    z3 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(486630301, i5, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizEnded (AIQuizCard.kt:439)");
                }
                String str = i + DomExceptionUtils.SEPARATOR + i2;
                float f = i2 > 0 ? (i / i2) * 100 : 0.0f;
                if (f <= 33.0f) {
                    i6 = C6091R.string.ai_quiz_result_description_bad;
                } else if (f > 33.0f && f <= 66.0f) {
                    i6 = C6091R.string.ai_quiz_result_description_intermediate;
                } else {
                    i6 = C6091R.string.ai_quiz_result_description_good;
                }
                Alignment.Horizontal start = Alignment.INSTANCE.getStart();
                float f2 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, start, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1435683970, "C455@16933L50,456@17019L10,457@17068L6,454@16908L228,461@17170L35,461@17214L56,462@17329L10,463@17381L6,460@17145L263,465@17417L2497:AIQuizCard.kt#nf75a9");
                TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_result_title, composerStartRestartGroup, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getH6(), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 0, 65498);
                String strStringResource = StringResources_androidKt.stringResource(i6, composerStartRestartGroup, 0);
                String str2 = String.format(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_result_description, composerStartRestartGroup, 0), Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                TextKt.m4524Text4IGK_g(strStringResource + " " + str2, (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody2(), composerStartRestartGroup, 0, 0, 65530);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_42 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f2));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_42, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
                Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1468823585, "C471@17658L78,469@17569L366:AIQuizCard.kt#nf75a9");
                int i8 = i5;
                final boolean z5 = z3;
                ButtonKt.Button(tryAgainClick, null, false, null, null, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f2)), null, ButtonDefaults.INSTANCE.m4162buttonColorsro_MJ88(0L, Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 48, 13), null, ComposableSingletons$AIQuizCardKt.INSTANCE.m12901getLambda$2111959021$nebo_ai_release(), composerStartRestartGroup, (i5 & 14) | 805306368, WorkflowTransitionState.SLIDE_DURATION_MS);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(1469240224);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "484@18142L205,488@18379L151,495@18656L1234,481@18003L1887");
                    Modifier modifierAnimateContentSize$default = AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, null, null, 3, null);
                    ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(185947564);
                        composerStartRestartGroup.endReplaceGroup();
                        jM4203getPrimary0d7_KjU = Color.INSTANCE.m8180getLightGray0d7_KjU();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(185948714);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "485@18259L6");
                        jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU();
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ButtonColors buttonColorsM4162buttonColorsro_MJ88 = buttonDefaults.m4162buttonColorsro_MJ88(jM4203getPrimary0d7_KjU, Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 48, 12);
                    boolean z6 = !z5;
                    RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f2));
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 185952474, "CC(remember):AIQuizCard.kt#9igjgp");
                    boolean z7 = ((i8 & 458752) == 131072) | ((i8 & 112) == 32);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda21
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AIQuizCardKt.AIQuizEnded$lambda$0$0$0$0(z5, nextQuestionsClick);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ButtonKt.Button((Function0) objRememberedValue, modifierAnimateContentSize$default, z6, null, null, roundedCornerShapeM3235RoundedCornerShape0680j_4, null, buttonColorsM4162buttonColorsro_MJ88, null, ComposableLambdaKt.rememberComposableLambda(1997427672, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda23
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AIQuizCardKt.AIQuizEnded$lambda$0$0$1(z5, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 344);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1471067519);
                    composerStartRestartGroup.endReplaceGroup();
                }
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
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AIQuizCardKt.AIQuizEnded$lambda$1(tryAgainClick, nextQuestionsClick, i, i2, z, z4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i5 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
        z3 = z2;
        if (composerStartRestartGroup.shouldExecute((74899 & i5) == 74898, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizEnded$lambda$0$0$0$0(boolean z, Function0 function0) {
        if (!z) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AIQuizEnded$lambda$0$0$1(boolean z, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C496@18678L1194:AIQuizCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1997427672, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizEnded.<anonymous>.<anonymous>.<anonymous> (AIQuizCard.kt:496)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 797503931, "C502@19010L58,505@19211L10,506@19286L10,500@18878L461,508@19364L486:AIQuizCard.kt#nf75a9");
            AutoSizeTextKt.m12528AutoSizeTextEUA8Og(StringResources_androidKt.stringResource(C6091R.string.ai_quiz_button_new_questions, composer, 0), rowScopeInstance.weight(Modifier.INSTANCE, 1.0f, false), Color.INSTANCE.m8185getWhite0d7_KjU(), null, null, 0L, 0L, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getButton().m10484getFontSizeXSAIIZE(), null, null, null, 0L, null, null, 0, false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getButton(), 0.0f, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1572864, 0, 1507192);
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableSingletons$AIQuizCardKt.INSTANCE.getLambda$704447508$nebo_ai_release(), composer, 1600518, 18);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void NextQuestionLoadingButton(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-585709275);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NextQuestionLoadingButton)529@20037L2,530@20073L109,534@20202L3,528@19974L733:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-585709275, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.NextQuestionLoadingButton (AIQuizCard.kt:527)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -225894265, "CC(remember):AIQuizCard.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM2062clickableoSLSa3U$default = ClickableKt.m2062clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 14, null);
            ButtonColors buttonColorsM4162buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m4162buttonColorsro_MJ88(Color.INSTANCE.m8180getLightGray0d7_KjU(), Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 54, 12);
            RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -225888984, "CC(remember):AIQuizCard.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.Button((Function0) objRememberedValue2, modifierM2062clickableoSLSa3U$default, false, null, null, roundedCornerShapeM3235RoundedCornerShape0680j_4, null, buttonColorsM4162buttonColorsro_MJ88, null, ComposableSingletons$AIQuizCardKt.INSTANCE.getLambda$162885909$nebo_ai_release(), composerStartRestartGroup, 805306374, 348);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.NextQuestionLoadingButton$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AnswerRadioButton(final boolean z, final String optionAnswer, final String str, final String str2, final Function1<? super String, Unit> onAnswerSelected, Composer composer, final int i) {
        boolean z2;
        int i2;
        Composer composer2;
        long jM4202getOnSurface0d7_KjU;
        long jM8147copywmQWz5c$default;
        boolean z3;
        Intrinsics.checkNotNullParameter(optionAnswer, "optionAnswer");
        Intrinsics.checkNotNullParameter(onAnswerSelected, "onAnswerSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(903407421);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnswerRadioButton)N(isChecked,optionAnswer,correctAnswer,userSelectedAnswer,onAnswerSelected)582@21801L102,581@21711L51,578@21621L288:AIQuizCard.kt#nf75a9");
        if ((i & 6) == 0) {
            z2 = z;
            i2 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(optionAnswer) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onAnswerSelected) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(903407421, i2, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AnswerRadioButton (AIQuizCard.kt:560)");
            }
            final boolean z4 = str2 != null;
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(591149926);
                ComposerKt.sourceInformation(composerStartRestartGroup, "564@21095L6");
                jM4202getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(591148836);
                ComposerKt.sourceInformation(composerStartRestartGroup, "564@21061L6");
                jM4202getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            if (!z4) {
                composerStartRestartGroup.startReplaceGroup(591152975);
                ComposerKt.sourceInformation(composerStartRestartGroup, "566@21180L6");
                jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(optionAnswer, str)) {
                composerStartRestartGroup.startReplaceGroup(591154894);
                composerStartRestartGroup.endReplaceGroup();
                jM8147copywmQWz5c$default = ColorKt.Color(4283820697L);
            } else if (Intrinsics.areEqual(optionAnswer, str2)) {
                composerStartRestartGroup.startReplaceGroup(591156942);
                composerStartRestartGroup.endReplaceGroup();
                jM8147copywmQWz5c$default = ColorKt.Color(4294534492L);
            } else {
                composerStartRestartGroup.startReplaceGroup(591159023);
                ComposerKt.sourceInformation(composerStartRestartGroup, "569@21369L6");
                jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (z4) {
                z3 = Intrinsics.areEqual(optionAnswer, str2) || Intrinsics.areEqual(optionAnswer, str);
            } else {
                z3 = z2;
            }
            boolean z5 = !z4;
            RadioButtonColors radioButtonColorsM4379colorsRGew2ao = RadioButtonDefaults.INSTANCE.m4379colorsRGew2ao(jM4202getOnSurface0d7_KjU, 0L, jM8147copywmQWz5c$default, composerStartRestartGroup, RadioButtonDefaults.$stable << 9, 2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 591169456, "CC(remember):AIQuizCard.kt#9igjgp");
            boolean zChanged = ((57344 & i2) == 16384) | composerStartRestartGroup.changed(z4) | ((i2 & 112) == 32);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AIQuizCardKt.AnswerRadioButton$lambda$0$0(z4, onAnswerSelected, optionAnswer);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            RadioButtonKt.RadioButton(z3, (Function0) objRememberedValue, null, z5, null, radioButtonColorsM4379colorsRGew2ao, composerStartRestartGroup, 0, 20);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AnswerRadioButton$lambda$1(z, optionAnswer, str, str2, onAnswerSelected, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnswerRadioButton$lambda$0$0(boolean z, Function1 function1, String str) {
        if (!z) {
            function1.invoke(str);
        }
        return Unit.INSTANCE;
    }

    public static final void ABCRadioButtonUnselectedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1946671225);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ABCRadioButtonUnselectedPreview)597@22189L2,592@22001L196:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1946671225, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ABCRadioButtonUnselectedPreview (AIQuizCard.kt:591)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1854686405, "CC(remember):AIQuizCard.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AIQuizCardKt.ABCRadioButtonUnselectedPreview$lambda$0$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnswerRadioButton(false, CmcdData.OBJECT_TYPE_AUDIO_ONLY, null, null, (Function1) objRememberedValue, composerStartRestartGroup, 28086);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.ABCRadioButtonUnselectedPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ABCRadioButtonUnselectedPreview$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void ABCRadioButtonSelectedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1104343950);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ABCRadioButtonSelectedPreview)609@22452L2,604@22287L173:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1104343950, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ABCRadioButtonSelectedPreview (AIQuizCard.kt:603)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -417607212, "CC(remember):AIQuizCard.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AIQuizCardKt.ABCRadioButtonSelectedPreview$lambda$0$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnswerRadioButton(true, CmcdData.OBJECT_TYPE_AUDIO_ONLY, null, null, (Function1) objRememberedValue, composerStartRestartGroup, 28086);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.ABCRadioButtonSelectedPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ABCRadioButtonSelectedPreview$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void ABCRadioButtonRightAnswerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(519076037);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ABCRadioButtonRightAnswerPreview)621@22779L2,616@22553L234:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(519076037, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ABCRadioButtonRightAnswerPreview (AIQuizCard.kt:615)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 615873895, "CC(remember):AIQuizCard.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AIQuizCardKt.ABCRadioButtonRightAnswerPreview$lambda$0$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnswerRadioButton(true, "b", "b", "b", (Function1) objRememberedValue, composerStartRestartGroup, 28086);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.ABCRadioButtonRightAnswerPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ABCRadioButtonRightAnswerPreview$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void ABCRadioButtonWrongAnswerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(128993876);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ABCRadioButtonWrongAnswerPreview)633@23104L2,628@22880L232:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(128993876, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ABCRadioButtonWrongAnswerPreview (AIQuizCard.kt:627)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -590928138, "CC(remember):AIQuizCard.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AIQuizCardKt.ABCRadioButtonWrongAnswerPreview$lambda$0$0((String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnswerRadioButton(true, "b", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", (Function1) objRememberedValue, composerStartRestartGroup, 28086);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.ABCRadioButtonWrongAnswerPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ABCRadioButtonWrongAnswerPreview$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void AIQuizTrueFalseCardPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1958894572);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizTrueFalseCardPreview)645@23330L260:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1958894572, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizTrueFalseCardPreview (AIQuizCard.kt:639)");
            }
            QuizTrueFalseQuestion quizTrueFalseQuestion = new QuizTrueFalseQuestion("Is this a question?", "answer", "explanation");
            AIQuizCard(new QuizState(0, CollectionsKt.listOf(quizTrueFalseQuestion), quizTrueFalseQuestion, 0, false, QuizMode.TRUE_FALSE, null, null, false, false, false, false, 3977, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizTrueFalseCardPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizMultipleChoicePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1042351434);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizMultipleChoicePreview)666@23885L299:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1042351434, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizMultipleChoicePreview (AIQuizCard.kt:657)");
            }
            QuizMultipleChoiceQuestion quizMultipleChoiceQuestion = new QuizMultipleChoiceQuestion("Is this a question?", "answer", "explanation", "a answer", "b answer", "c answer");
            AIQuizCard(new QuizState(0, CollectionsKt.listOf(quizMultipleChoiceQuestion), quizMultipleChoiceQuestion, 0, false, QuizMode.MULTIPLE_CHOICE, null, null, false, false, false, false, 3849, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizMultipleChoicePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizMultipleChoiceWrongAnswerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1164105463);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizMultipleChoiceWrongAnswerPreview)688@24493L305:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1164105463, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizMultipleChoiceWrongAnswerPreview (AIQuizCard.kt:679)");
            }
            QuizMultipleChoiceQuestion quizMultipleChoiceQuestion = new QuizMultipleChoiceQuestion("Is this a question?", "b answer", "explanation", "a answer", "b answer", "c answer");
            AIQuizCard(new QuizState(0, CollectionsKt.listOf(quizMultipleChoiceQuestion), quizMultipleChoiceQuestion, 0, false, QuizMode.MULTIPLE_CHOICE, null, "a answer", false, false, false, false, 3849, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizMultipleChoiceWrongAnswerPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizMultipleChoiceRightAnswerPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1554187624);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizMultipleChoiceRightAnswerPreview)710@25107L305:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1554187624, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizMultipleChoiceRightAnswerPreview (AIQuizCard.kt:701)");
            }
            QuizMultipleChoiceQuestion quizMultipleChoiceQuestion = new QuizMultipleChoiceQuestion("Is this a question?", "b answer", "explanation", "a answer", "b answer", "c answer");
            AIQuizCard(new QuizState(0, CollectionsKt.listOf(quizMultipleChoiceQuestion), quizMultipleChoiceQuestion, 0, false, QuizMode.MULTIPLE_CHOICE, null, "b answer", false, false, false, false, 3849, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizMultipleChoiceRightAnswerPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizTrueFalseCardResultNextQuestionDisabledPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2085188026);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizTrueFalseCardResultNextQuestionDisabledPreview)729@25656L488:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2085188026, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizTrueFalseCardResultNextQuestionDisabledPreview (AIQuizCard.kt:723)");
            }
            QuizTrueFalseQuestion quizTrueFalseQuestion = new QuizTrueFalseQuestion("Is this a question?", "answer", "explanation");
            AIQuizCard(new QuizState(0, CollectionsKt.listOf(quizTrueFalseQuestion), quizTrueFalseQuestion, 0, false, QuizMode.TRUE_FALSE, new QuestionResult("This is a long explanation for a very complicated question on a very particular topic that no one cares about.", C6091R.string.ai_quiz_right_answer), null, false, false, false, false, 3977, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizTrueFalseCardResultNextQuestionDisabledPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizTrueFalseCardResultPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1547745295);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizTrueFalseCardResultPreview)750@26368L488:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1547745295, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizTrueFalseCardResultPreview (AIQuizCard.kt:744)");
            }
            QuizTrueFalseQuestion quizTrueFalseQuestion = new QuizTrueFalseQuestion("Is this a question?", "answer", "explanation");
            AIQuizCard(new QuizState(0, CollectionsKt.listOf(quizTrueFalseQuestion), quizTrueFalseQuestion, 0, false, QuizMode.TRUE_FALSE, new QuestionResult("This is a long explanation for a very complicated question on a very particular topic that no one cares about.", C6091R.string.ai_quiz_right_answer), null, false, false, false, false, 3977, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizTrueFalseCardResultPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizEndedCardPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(45141319);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizEndedCardPreview)771@27070L322:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(45141319, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizEndedCardPreview (AIQuizCard.kt:765)");
            }
            QuizTrueFalseQuestion quizTrueFalseQuestion = new QuizTrueFalseQuestion("Is this a question?", "answer", "explanation");
            AIQuizCard(new QuizState(10, CollectionsKt.listOf(quizTrueFalseQuestion), quizTrueFalseQuestion, 5, true, QuizMode.TRUE_FALSE, null, null, false, false, false, false, Utf8.MASK_2BYTES, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizEndedCardPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizEndedLoadingNewQuestionsCardPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1103777820);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizEndedLoadingNewQuestionsCardPreview)791@27625L415:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1103777820, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizEndedLoadingNewQuestionsCardPreview (AIQuizCard.kt:785)");
            }
            QuizTrueFalseQuestion quizTrueFalseQuestion = new QuizTrueFalseQuestion("Is this a question?", "answer", "explanation");
            AIQuizCard(new QuizState(10, CollectionsKt.listOf(quizTrueFalseQuestion), quizTrueFalseQuestion, 5, true, QuizMode.TRUE_FALSE, null, null, true, false, true, false, 2688, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizEndedLoadingNewQuestionsCardPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void AIQuizEndedCardNewQuestionsPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1542411526);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AIQuizEndedCardNewQuestionsPreview)813@28266L374:AIQuizCard.kt#nf75a9");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1542411526, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.AIQuizEndedCardNewQuestionsPreview (AIQuizCard.kt:807)");
            }
            QuizTrueFalseQuestion quizTrueFalseQuestion = new QuizTrueFalseQuestion("Is this a question?", "answer", "explanation");
            AIQuizCard(new QuizState(10, CollectionsKt.listOf(quizTrueFalseQuestion), quizTrueFalseQuestion, 5, true, QuizMode.TRUE_FALSE, null, null, true, false, false, false, 3712, null), false, null, null, null, null, null, null, composerStartRestartGroup, 48, PDFACompliance.e_PDFA2_5_2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.AIQuizCardKt$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AIQuizCardKt.AIQuizEndedCardNewQuestionsPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
