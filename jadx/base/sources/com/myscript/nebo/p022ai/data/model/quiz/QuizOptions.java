package com.myscript.nebo.p022ai.data.model.quiz;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizOptions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006#"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizOptions;", "", "lang", "", "questionTypes", "", "questionCount", "", "optionCount", "explanation", "", "contentRef", "<init>", "(Ljava/lang/String;Ljava/util/List;IIZZ)V", "getLang", "()Ljava/lang/String;", "getQuestionTypes", "()Ljava/util/List;", "getQuestionCount", "()I", "getOptionCount", "getExplanation", "()Z", "getContentRef", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizOptions {
    public static final int $stable = 8;

    @SerializedName("content_ref")
    private final boolean contentRef;

    @SerializedName("explanation")
    private final boolean explanation;

    @SerializedName("lang")
    private final String lang;

    @SerializedName("option_count")
    private final int optionCount;

    @SerializedName("question_count")
    private final int questionCount;

    @SerializedName("question_types")
    private final List<String> questionTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuizOptions copy$default(QuizOptions quizOptions, String str, List list, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = quizOptions.lang;
        }
        if ((i3 & 2) != 0) {
            list = quizOptions.questionTypes;
        }
        if ((i3 & 4) != 0) {
            i = quizOptions.questionCount;
        }
        if ((i3 & 8) != 0) {
            i2 = quizOptions.optionCount;
        }
        if ((i3 & 16) != 0) {
            z = quizOptions.explanation;
        }
        if ((i3 & 32) != 0) {
            z2 = quizOptions.contentRef;
        }
        boolean z3 = z;
        boolean z4 = z2;
        return quizOptions.copy(str, list, i, i2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    public final List<String> component2() {
        return this.questionTypes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getQuestionCount() {
        return this.questionCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getOptionCount() {
        return this.optionCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getExplanation() {
        return this.explanation;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getContentRef() {
        return this.contentRef;
    }

    public final QuizOptions copy(String lang, List<String> questionTypes, int questionCount, int optionCount, boolean explanation, boolean contentRef) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(questionTypes, "questionTypes");
        return new QuizOptions(lang, questionTypes, questionCount, optionCount, explanation, contentRef);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizOptions)) {
            return false;
        }
        QuizOptions quizOptions = (QuizOptions) other;
        return Intrinsics.areEqual(this.lang, quizOptions.lang) && Intrinsics.areEqual(this.questionTypes, quizOptions.questionTypes) && this.questionCount == quizOptions.questionCount && this.optionCount == quizOptions.optionCount && this.explanation == quizOptions.explanation && this.contentRef == quizOptions.contentRef;
    }

    public int hashCode() {
        return (((((((((this.lang.hashCode() * 31) + this.questionTypes.hashCode()) * 31) + Integer.hashCode(this.questionCount)) * 31) + Integer.hashCode(this.optionCount)) * 31) + Boolean.hashCode(this.explanation)) * 31) + Boolean.hashCode(this.contentRef);
    }

    public String toString() {
        return "QuizOptions(lang=" + this.lang + ", questionTypes=" + this.questionTypes + ", questionCount=" + this.questionCount + ", optionCount=" + this.optionCount + ", explanation=" + this.explanation + ", contentRef=" + this.contentRef + ")";
    }

    public QuizOptions(String lang, List<String> questionTypes, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        Intrinsics.checkNotNullParameter(questionTypes, "questionTypes");
        this.lang = lang;
        this.questionTypes = questionTypes;
        this.questionCount = i;
        this.optionCount = i2;
        this.explanation = z;
        this.contentRef = z2;
    }

    public final String getLang() {
        return this.lang;
    }

    public final List<String> getQuestionTypes() {
        return this.questionTypes;
    }

    public final int getQuestionCount() {
        return this.questionCount;
    }

    public final int getOptionCount() {
        return this.optionCount;
    }

    public final boolean getExplanation() {
        return this.explanation;
    }

    public final boolean getContentRef() {
        return this.contentRef;
    }
}
