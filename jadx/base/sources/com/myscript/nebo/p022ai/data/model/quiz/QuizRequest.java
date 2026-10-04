package com.myscript.nebo.p022ai.data.model.quiz;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuizRequest.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006 "}, m1599d2 = {"Lcom/myscript/nebo/ai/data/model/quiz/QuizRequest;", "", "user", "Lcom/myscript/nebo/ai/data/model/quiz/QuizUserInfo;", "options", "Lcom/myscript/nebo/ai/data/model/quiz/QuizOptions;", FirebaseAnalytics.Param.CONTENT, "", "Lcom/myscript/nebo/ai/data/model/quiz/QuizContent;", "questionHistory", "Lcom/myscript/nebo/ai/data/model/quiz/QuestionHistory;", "<init>", "(Lcom/myscript/nebo/ai/data/model/quiz/QuizUserInfo;Lcom/myscript/nebo/ai/data/model/quiz/QuizOptions;Ljava/util/List;Ljava/util/List;)V", "getUser", "()Lcom/myscript/nebo/ai/data/model/quiz/QuizUserInfo;", "getOptions", "()Lcom/myscript/nebo/ai/data/model/quiz/QuizOptions;", "getContent", "()Ljava/util/List;", "getQuestionHistory", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class QuizRequest {
    public static final int $stable = 8;

    @SerializedName(FirebaseAnalytics.Param.CONTENT)
    private final List<QuizContent> content;

    @SerializedName("options")
    private final QuizOptions options;

    @SerializedName("question_history")
    private final List<QuestionHistory> questionHistory;

    @SerializedName("user")
    private final QuizUserInfo user;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuizRequest copy$default(QuizRequest quizRequest, QuizUserInfo quizUserInfo, QuizOptions quizOptions, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            quizUserInfo = quizRequest.user;
        }
        if ((i & 2) != 0) {
            quizOptions = quizRequest.options;
        }
        if ((i & 4) != 0) {
            list = quizRequest.content;
        }
        if ((i & 8) != 0) {
            list2 = quizRequest.questionHistory;
        }
        return quizRequest.copy(quizUserInfo, quizOptions, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final QuizUserInfo getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final QuizOptions getOptions() {
        return this.options;
    }

    public final List<QuizContent> component3() {
        return this.content;
    }

    public final List<QuestionHistory> component4() {
        return this.questionHistory;
    }

    public final QuizRequest copy(QuizUserInfo user, QuizOptions options, List<QuizContent> content, List<QuestionHistory> questionHistory) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(content, "content");
        return new QuizRequest(user, options, content, questionHistory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuizRequest)) {
            return false;
        }
        QuizRequest quizRequest = (QuizRequest) other;
        return Intrinsics.areEqual(this.user, quizRequest.user) && Intrinsics.areEqual(this.options, quizRequest.options) && Intrinsics.areEqual(this.content, quizRequest.content) && Intrinsics.areEqual(this.questionHistory, quizRequest.questionHistory);
    }

    public int hashCode() {
        int iHashCode = ((((this.user.hashCode() * 31) + this.options.hashCode()) * 31) + this.content.hashCode()) * 31;
        List<QuestionHistory> list = this.questionHistory;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "QuizRequest(user=" + this.user + ", options=" + this.options + ", content=" + this.content + ", questionHistory=" + this.questionHistory + ")";
    }

    public QuizRequest(QuizUserInfo user, QuizOptions options, List<QuizContent> content, List<QuestionHistory> list) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(content, "content");
        this.user = user;
        this.options = options;
        this.content = content;
        this.questionHistory = list;
    }

    public /* synthetic */ QuizRequest(QuizUserInfo quizUserInfo, QuizOptions quizOptions, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(quizUserInfo, quizOptions, list, (i & 8) != 0 ? null : list2);
    }

    public final QuizUserInfo getUser() {
        return this.user;
    }

    public final QuizOptions getOptions() {
        return this.options;
    }

    public final List<QuizContent> getContent() {
        return this.content;
    }

    public final List<QuestionHistory> getQuestionHistory() {
        return this.questionHistory;
    }
}
