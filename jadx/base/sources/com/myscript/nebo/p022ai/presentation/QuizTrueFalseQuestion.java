package com.myscript.nebo.p022ai.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIQuizViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuizTrueFalseQuestion;", "Lcom/myscript/nebo/ai/presentation/QuizQuestion;", "question", "", "answer", "explanation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQuestion", "()Ljava/lang/String;", "getAnswer", "getExplanation", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizTrueFalseQuestion implements QuizQuestion {
    public static final int $stable = 0;
    private final String answer;
    private final String explanation;
    private final String question;

    public static /* synthetic */ QuizTrueFalseQuestion copy$default(QuizTrueFalseQuestion quizTrueFalseQuestion, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizTrueFalseQuestion.question;
        }
        if ((i & 2) != 0) {
            str2 = quizTrueFalseQuestion.answer;
        }
        if ((i & 4) != 0) {
            str3 = quizTrueFalseQuestion.explanation;
        }
        return quizTrueFalseQuestion.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getQuestion() {
        return this.question;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAnswer() {
        return this.answer;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getExplanation() {
        return this.explanation;
    }

    public final QuizTrueFalseQuestion copy(String question, String answer, String explanation) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        return new QuizTrueFalseQuestion(question, answer, explanation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizTrueFalseQuestion)) {
            return false;
        }
        QuizTrueFalseQuestion quizTrueFalseQuestion = (QuizTrueFalseQuestion) other;
        return Intrinsics.areEqual(this.question, quizTrueFalseQuestion.question) && Intrinsics.areEqual(this.answer, quizTrueFalseQuestion.answer) && Intrinsics.areEqual(this.explanation, quizTrueFalseQuestion.explanation);
    }

    public int hashCode() {
        int iHashCode = ((this.question.hashCode() * 31) + this.answer.hashCode()) * 31;
        String str = this.explanation;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "QuizTrueFalseQuestion(question=" + this.question + ", answer=" + this.answer + ", explanation=" + this.explanation + ")";
    }

    public QuizTrueFalseQuestion(String question, String answer, String str) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        this.question = question;
        this.answer = answer;
        this.explanation = str;
    }

    @Override // com.myscript.nebo.p022ai.presentation.QuizQuestion
    public String getQuestion() {
        return this.question;
    }

    @Override // com.myscript.nebo.p022ai.presentation.QuizQuestion
    public String getAnswer() {
        return this.answer;
    }

    @Override // com.myscript.nebo.p022ai.presentation.QuizQuestion
    public String getExplanation() {
        return this.explanation;
    }
}
