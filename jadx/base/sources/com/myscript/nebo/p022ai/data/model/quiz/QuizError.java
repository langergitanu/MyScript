package com.myscript.nebo.p022ai.data.model.quiz;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizError.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizError;", "", "message", "", "details", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getDetails", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizError {
    public static final int $stable = 0;
    private final String details;
    private final String message;

    public static /* synthetic */ QuizError copy$default(QuizError quizError, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quizError.message;
        }
        if ((i & 2) != 0) {
            str2 = quizError.details;
        }
        return quizError.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDetails() {
        return this.details;
    }

    public final QuizError copy(String message, String details) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(details, "details");
        return new QuizError(message, details);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizError)) {
            return false;
        }
        QuizError quizError = (QuizError) other;
        return Intrinsics.areEqual(this.message, quizError.message) && Intrinsics.areEqual(this.details, quizError.details);
    }

    public int hashCode() {
        return (this.message.hashCode() * 31) + this.details.hashCode();
    }

    public String toString() {
        return "QuizError(message=" + this.message + ", details=" + this.details + ")";
    }

    public QuizError(String message, String details) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(details, "details");
        this.message = message;
        this.details = details;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getDetails() {
        return this.details;
    }
}
