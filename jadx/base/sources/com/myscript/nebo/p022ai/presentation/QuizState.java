package com.myscript.nebo.p022ai.presentation;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIQuizViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b+\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00102\u001a\u00020\nHÆ\u0003J\t\u00103\u001a\u00020\nHÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\u008d\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\nHÆ\u0001J\u0014\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00109\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010:\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001f¨\u0006;"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuizState;", "", "expectedQuestionCount", "", "questions", "", "Lcom/myscript/nebo/ai/presentation/QuizQuestion;", "currentQuestion", FirebaseAnalytics.Param.SCORE, "quizEnded", "", "quizMode", "Lcom/myscript/nebo/ai/presentation/QuizMode;", "currentQuestionResult", "Lcom/myscript/nebo/ai/presentation/QuestionResult;", "selectedAnswer", "", "shouldDisplayNewQuestionsButton", "nextQuestionLoading", "loadingNextQuestions", "showViewScoreButton", "<init>", "(ILjava/util/List;Lcom/myscript/nebo/ai/presentation/QuizQuestion;IZLcom/myscript/nebo/ai/presentation/QuizMode;Lcom/myscript/nebo/ai/presentation/QuestionResult;Ljava/lang/String;ZZZZ)V", "getExpectedQuestionCount", "()I", "getQuestions", "()Ljava/util/List;", "getCurrentQuestion", "()Lcom/myscript/nebo/ai/presentation/QuizQuestion;", "getScore", "getQuizEnded", "()Z", "getQuizMode", "()Lcom/myscript/nebo/ai/presentation/QuizMode;", "getCurrentQuestionResult", "()Lcom/myscript/nebo/ai/presentation/QuestionResult;", "getSelectedAnswer", "()Ljava/lang/String;", "getShouldDisplayNewQuestionsButton", "getNextQuestionLoading", "getLoadingNextQuestions", "getShowViewScoreButton", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizState {
    public static final int $stable = 8;
    private final QuizQuestion currentQuestion;
    private final QuestionResult currentQuestionResult;
    private final int expectedQuestionCount;
    private final boolean loadingNextQuestions;
    private final boolean nextQuestionLoading;
    private final List<QuizQuestion> questions;
    private final boolean quizEnded;
    private final QuizMode quizMode;
    private final int score;
    private final String selectedAnswer;
    private final boolean shouldDisplayNewQuestionsButton;
    private final boolean showViewScoreButton;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuizState copy$default(QuizState quizState, int i, List list, QuizQuestion quizQuestion, int i2, boolean z, QuizMode quizMode, QuestionResult questionResult, String str, boolean z2, boolean z3, boolean z4, boolean z5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = quizState.expectedQuestionCount;
        }
        if ((i3 & 2) != 0) {
            list = quizState.questions;
        }
        if ((i3 & 4) != 0) {
            quizQuestion = quizState.currentQuestion;
        }
        if ((i3 & 8) != 0) {
            i2 = quizState.score;
        }
        if ((i3 & 16) != 0) {
            z = quizState.quizEnded;
        }
        if ((i3 & 32) != 0) {
            quizMode = quizState.quizMode;
        }
        if ((i3 & 64) != 0) {
            questionResult = quizState.currentQuestionResult;
        }
        if ((i3 & 128) != 0) {
            str = quizState.selectedAnswer;
        }
        if ((i3 & 256) != 0) {
            z2 = quizState.shouldDisplayNewQuestionsButton;
        }
        if ((i3 & 512) != 0) {
            z3 = quizState.nextQuestionLoading;
        }
        if ((i3 & 1024) != 0) {
            z4 = quizState.loadingNextQuestions;
        }
        if ((i3 & 2048) != 0) {
            z5 = quizState.showViewScoreButton;
        }
        boolean z6 = z4;
        boolean z7 = z5;
        boolean z8 = z2;
        boolean z9 = z3;
        QuestionResult questionResult2 = questionResult;
        String str2 = str;
        boolean z10 = z;
        QuizMode quizMode2 = quizMode;
        return quizState.copy(i, list, quizQuestion, i2, z10, quizMode2, questionResult2, str2, z8, z9, z6, z7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getExpectedQuestionCount() {
        return this.expectedQuestionCount;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getNextQuestionLoading() {
        return this.nextQuestionLoading;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getLoadingNextQuestions() {
        return this.loadingNextQuestions;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getShowViewScoreButton() {
        return this.showViewScoreButton;
    }

    public final List<QuizQuestion> component2() {
        return this.questions;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final QuizQuestion getCurrentQuestion() {
        return this.currentQuestion;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getQuizEnded() {
        return this.quizEnded;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final QuizMode getQuizMode() {
        return this.quizMode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final QuestionResult getCurrentQuestionResult() {
        return this.currentQuestionResult;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSelectedAnswer() {
        return this.selectedAnswer;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getShouldDisplayNewQuestionsButton() {
        return this.shouldDisplayNewQuestionsButton;
    }

    public final QuizState copy(int expectedQuestionCount, List<? extends QuizQuestion> questions, QuizQuestion currentQuestion, int score, boolean quizEnded, QuizMode quizMode, QuestionResult currentQuestionResult, String selectedAnswer, boolean shouldDisplayNewQuestionsButton, boolean nextQuestionLoading, boolean loadingNextQuestions, boolean showViewScoreButton) {
        Intrinsics.checkNotNullParameter(questions, "questions");
        Intrinsics.checkNotNullParameter(quizMode, "quizMode");
        return new QuizState(expectedQuestionCount, questions, currentQuestion, score, quizEnded, quizMode, currentQuestionResult, selectedAnswer, shouldDisplayNewQuestionsButton, nextQuestionLoading, loadingNextQuestions, showViewScoreButton);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizState)) {
            return false;
        }
        QuizState quizState = (QuizState) other;
        return this.expectedQuestionCount == quizState.expectedQuestionCount && Intrinsics.areEqual(this.questions, quizState.questions) && Intrinsics.areEqual(this.currentQuestion, quizState.currentQuestion) && this.score == quizState.score && this.quizEnded == quizState.quizEnded && this.quizMode == quizState.quizMode && Intrinsics.areEqual(this.currentQuestionResult, quizState.currentQuestionResult) && Intrinsics.areEqual(this.selectedAnswer, quizState.selectedAnswer) && this.shouldDisplayNewQuestionsButton == quizState.shouldDisplayNewQuestionsButton && this.nextQuestionLoading == quizState.nextQuestionLoading && this.loadingNextQuestions == quizState.loadingNextQuestions && this.showViewScoreButton == quizState.showViewScoreButton;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.expectedQuestionCount) * 31) + this.questions.hashCode()) * 31;
        QuizQuestion quizQuestion = this.currentQuestion;
        int iHashCode2 = (((((((iHashCode + (quizQuestion == null ? 0 : quizQuestion.hashCode())) * 31) + Integer.hashCode(this.score)) * 31) + Boolean.hashCode(this.quizEnded)) * 31) + this.quizMode.hashCode()) * 31;
        QuestionResult questionResult = this.currentQuestionResult;
        int iHashCode3 = (iHashCode2 + (questionResult == null ? 0 : questionResult.hashCode())) * 31;
        String str = this.selectedAnswer;
        return ((((((((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + Boolean.hashCode(this.shouldDisplayNewQuestionsButton)) * 31) + Boolean.hashCode(this.nextQuestionLoading)) * 31) + Boolean.hashCode(this.loadingNextQuestions)) * 31) + Boolean.hashCode(this.showViewScoreButton);
    }

    public String toString() {
        return "QuizState(expectedQuestionCount=" + this.expectedQuestionCount + ", questions=" + this.questions + ", currentQuestion=" + this.currentQuestion + ", score=" + this.score + ", quizEnded=" + this.quizEnded + ", quizMode=" + this.quizMode + ", currentQuestionResult=" + this.currentQuestionResult + ", selectedAnswer=" + this.selectedAnswer + ", shouldDisplayNewQuestionsButton=" + this.shouldDisplayNewQuestionsButton + ", nextQuestionLoading=" + this.nextQuestionLoading + ", loadingNextQuestions=" + this.loadingNextQuestions + ", showViewScoreButton=" + this.showViewScoreButton + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuizState(int i, List<? extends QuizQuestion> questions, QuizQuestion quizQuestion, int i2, boolean z, QuizMode quizMode, QuestionResult questionResult, String str, boolean z2, boolean z3, boolean z4, boolean z5) {
        Intrinsics.checkNotNullParameter(questions, "questions");
        Intrinsics.checkNotNullParameter(quizMode, "quizMode");
        this.expectedQuestionCount = i;
        this.questions = questions;
        this.currentQuestion = quizQuestion;
        this.score = i2;
        this.quizEnded = z;
        this.quizMode = quizMode;
        this.currentQuestionResult = questionResult;
        this.selectedAnswer = str;
        this.shouldDisplayNewQuestionsButton = z2;
        this.nextQuestionLoading = z3;
        this.loadingNextQuestions = z4;
        this.showViewScoreButton = z5;
    }

    public /* synthetic */ QuizState(int i, List list, QuizQuestion quizQuestion, int i2, boolean z, QuizMode quizMode, QuestionResult questionResult, String str, boolean z2, boolean z3, boolean z4, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, list, (i3 & 4) != 0 ? null : quizQuestion, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? false : z, quizMode, (i3 & 64) != 0 ? null : questionResult, (i3 & 128) != 0 ? null : str, (i3 & 256) != 0 ? false : z2, (i3 & 512) != 0 ? false : z3, (i3 & 1024) != 0 ? false : z4, (i3 & 2048) != 0 ? false : z5);
    }

    public final int getExpectedQuestionCount() {
        return this.expectedQuestionCount;
    }

    public final List<QuizQuestion> getQuestions() {
        return this.questions;
    }

    public final QuizQuestion getCurrentQuestion() {
        return this.currentQuestion;
    }

    public final int getScore() {
        return this.score;
    }

    public final boolean getQuizEnded() {
        return this.quizEnded;
    }

    public final QuizMode getQuizMode() {
        return this.quizMode;
    }

    public final QuestionResult getCurrentQuestionResult() {
        return this.currentQuestionResult;
    }

    public final String getSelectedAnswer() {
        return this.selectedAnswer;
    }

    public final boolean getShouldDisplayNewQuestionsButton() {
        return this.shouldDisplayNewQuestionsButton;
    }

    public final boolean getNextQuestionLoading() {
        return this.nextQuestionLoading;
    }

    public final boolean getLoadingNextQuestions() {
        return this.loadingNextQuestions;
    }

    public final boolean getShowViewScoreButton() {
        return this.showViewScoreButton;
    }
}
