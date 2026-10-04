package com.myscript.nebo.p022ai.presentation;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIQuizViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuizMultipleChoiceQuestion;", "Lcom/myscript/nebo/ai/presentation/QuizQuestion;", "question", "", "answer", "explanation", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "c", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQuestion", "()Ljava/lang/String;", "getAnswer", "getExplanation", "getA", "getB", "getC", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizMultipleChoiceQuestion implements QuizQuestion {
    public static final int $stable = 0;
    private final String a;
    private final String answer;
    private final String b;
    private final String c;
    private final String explanation;
    private final String question;

    public static /* synthetic */ QuizMultipleChoiceQuestion copy$default(QuizMultipleChoiceQuestion quizMultipleChoiceQuestion, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizMultipleChoiceQuestion.question;
        }
        if ((i & 2) != 0) {
            str2 = quizMultipleChoiceQuestion.answer;
        }
        if ((i & 4) != 0) {
            str3 = quizMultipleChoiceQuestion.explanation;
        }
        if ((i & 8) != 0) {
            str4 = quizMultipleChoiceQuestion.a;
        }
        if ((i & 16) != 0) {
            str5 = quizMultipleChoiceQuestion.b;
        }
        if ((i & 32) != 0) {
            str6 = quizMultipleChoiceQuestion.c;
        }
        String str7 = str5;
        String str8 = str6;
        return quizMultipleChoiceQuestion.copy(str, str2, str3, str4, str7, str8);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getA() {
        return this.a;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getB() {
        return this.b;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getC() {
        return this.c;
    }

    public final QuizMultipleChoiceQuestion copy(String question, String answer, String explanation, String a2, String b, String c) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        return new QuizMultipleChoiceQuestion(question, answer, explanation, a2, b, c);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizMultipleChoiceQuestion)) {
            return false;
        }
        QuizMultipleChoiceQuestion quizMultipleChoiceQuestion = (QuizMultipleChoiceQuestion) other;
        return Intrinsics.areEqual(this.question, quizMultipleChoiceQuestion.question) && Intrinsics.areEqual(this.answer, quizMultipleChoiceQuestion.answer) && Intrinsics.areEqual(this.explanation, quizMultipleChoiceQuestion.explanation) && Intrinsics.areEqual(this.a, quizMultipleChoiceQuestion.a) && Intrinsics.areEqual(this.b, quizMultipleChoiceQuestion.b) && Intrinsics.areEqual(this.c, quizMultipleChoiceQuestion.c);
    }

    public int hashCode() {
        int iHashCode = ((this.question.hashCode() * 31) + this.answer.hashCode()) * 31;
        String str = this.explanation;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "QuizMultipleChoiceQuestion(question=" + this.question + ", answer=" + this.answer + ", explanation=" + this.explanation + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ")";
    }

    public QuizMultipleChoiceQuestion(String question, String answer, String str, String a2, String b, String c) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        this.question = question;
        this.answer = answer;
        this.explanation = str;
        this.a = a2;
        this.b = b;
        this.c = c;
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

    public final String getA() {
        return this.a;
    }

    public final String getB() {
        return this.b;
    }

    public final String getC() {
        return this.c;
    }
}
