package com.survicate.surveys.infrastructure.storage.interfaces;

import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyAnswersStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/interfaces/QuestionAnswerItem;", "", "surveyPointId", "", "answerTextValue", "", "", "answer", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "<init>", "(JLjava/util/List;Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;)V", "getSurveyPointId", "()J", "getAnswerTextValue", "()Ljava/util/List;", "getAnswer", "()Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class QuestionAnswerItem {
    private final QuestionAnswered answer;
    private final List<String> answerTextValue;
    private final long surveyPointId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuestionAnswerItem copy$default(QuestionAnswerItem questionAnswerItem, long j, List list, QuestionAnswered questionAnswered, int i, Object obj) {
        if ((i & 1) != 0) {
            j = questionAnswerItem.surveyPointId;
        }
        if ((i & 2) != 0) {
            list = questionAnswerItem.answerTextValue;
        }
        if ((i & 4) != 0) {
            questionAnswered = questionAnswerItem.answer;
        }
        return questionAnswerItem.copy(j, list, questionAnswered);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSurveyPointId() {
        return this.surveyPointId;
    }

    public final List<String> component2() {
        return this.answerTextValue;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final QuestionAnswered getAnswer() {
        return this.answer;
    }

    public final QuestionAnswerItem copy(long surveyPointId, List<String> answerTextValue, QuestionAnswered answer) {
        Intrinsics.checkNotNullParameter(answerTextValue, "answerTextValue");
        return new QuestionAnswerItem(surveyPointId, answerTextValue, answer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionAnswerItem)) {
            return false;
        }
        QuestionAnswerItem questionAnswerItem = (QuestionAnswerItem) other;
        return this.surveyPointId == questionAnswerItem.surveyPointId && Intrinsics.areEqual(this.answerTextValue, questionAnswerItem.answerTextValue) && Intrinsics.areEqual(this.answer, questionAnswerItem.answer);
    }

    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.surveyPointId) * 31) + this.answerTextValue.hashCode()) * 31;
        QuestionAnswered questionAnswered = this.answer;
        return iHashCode + (questionAnswered == null ? 0 : questionAnswered.hashCode());
    }

    public String toString() {
        return "QuestionAnswerItem(surveyPointId=" + this.surveyPointId + ", answerTextValue=" + this.answerTextValue + ", answer=" + this.answer + ')';
    }

    public QuestionAnswerItem(long j, List<String> answerTextValue, QuestionAnswered questionAnswered) {
        Intrinsics.checkNotNullParameter(answerTextValue, "answerTextValue");
        this.surveyPointId = j;
        this.answerTextValue = answerTextValue;
        this.answer = questionAnswered;
    }

    public final long getSurveyPointId() {
        return this.surveyPointId;
    }

    public final List<String> getAnswerTextValue() {
        return this.answerTextValue;
    }

    public final QuestionAnswered getAnswer() {
        return this.answer;
    }
}
