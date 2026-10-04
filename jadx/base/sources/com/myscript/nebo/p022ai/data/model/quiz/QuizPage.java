package com.myscript.nebo.p022ai.data.model.quiz;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizPage.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizPage;", "", "id", "", "text", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizPage {
    public static final int $stable = 0;

    @SerializedName("id")
    private final int id;

    @SerializedName("text")
    private final String text;

    public static /* synthetic */ QuizPage copy$default(QuizPage quizPage, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = quizPage.id;
        }
        if ((i2 & 2) != 0) {
            str = quizPage.text;
        }
        return quizPage.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final QuizPage copy(int id, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new QuizPage(id, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizPage)) {
            return false;
        }
        QuizPage quizPage = (QuizPage) other;
        return this.id == quizPage.id && Intrinsics.areEqual(this.text, quizPage.text);
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + this.text.hashCode();
    }

    public String toString() {
        return "QuizPage(id=" + this.id + ", text=" + this.text + ")";
    }

    public QuizPage(int i, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = i;
        this.text = text;
    }

    public final int getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }
}
