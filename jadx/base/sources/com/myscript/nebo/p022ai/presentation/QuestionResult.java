package com.myscript.nebo.p022ai.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AIQuizViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuestionResult;", "", "explanation", "", "goodAnswer", "", "<init>", "(Ljava/lang/String;I)V", "getExplanation", "()Ljava/lang/String;", "getGoodAnswer", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuestionResult {
    public static final int $stable = 0;
    private final String explanation;
    private final int goodAnswer;

    public static /* synthetic */ QuestionResult copy$default(QuestionResult questionResult, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = questionResult.explanation;
        }
        if ((i2 & 2) != 0) {
            i = questionResult.goodAnswer;
        }
        return questionResult.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getExplanation() {
        return this.explanation;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getGoodAnswer() {
        return this.goodAnswer;
    }

    public final QuestionResult copy(String explanation, int goodAnswer) {
        return new QuestionResult(explanation, goodAnswer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionResult)) {
            return false;
        }
        QuestionResult questionResult = (QuestionResult) other;
        return Intrinsics.areEqual(this.explanation, questionResult.explanation) && this.goodAnswer == questionResult.goodAnswer;
    }

    public int hashCode() {
        String str = this.explanation;
        return ((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.goodAnswer);
    }

    public String toString() {
        return "QuestionResult(explanation=" + this.explanation + ", goodAnswer=" + this.goodAnswer + ")";
    }

    public QuestionResult(String str, int i) {
        this.explanation = str;
        this.goodAnswer = i;
    }

    public /* synthetic */ QuestionResult(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, i);
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final int getGoodAnswer() {
        return this.goodAnswer;
    }
}
