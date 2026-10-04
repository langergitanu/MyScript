package com.survicate.surveys.presentation.base;

import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyAnswerAction.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J4\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/SurveyAnswerAction;", "", "answers", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "nextQuestionId", "", "currentQuestionId", "<init>", "(Ljava/util/List;Ljava/lang/Long;J)V", "answer", "(Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;Ljava/lang/Long;J)V", "getAnswers", "()Ljava/util/List;", "getNextQuestionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCurrentQuestionId", "()J", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Long;J)Lcom/survicate/surveys/presentation/base/SurveyAnswerAction;", "equals", "", "other", "hashCode", "", "toString", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class SurveyAnswerAction {
    private final List<SurveyAnswer> answers;
    private final long currentQuestionId;
    private final Long nextQuestionId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SurveyAnswerAction copy$default(SurveyAnswerAction surveyAnswerAction, List list, Long l, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            list = surveyAnswerAction.answers;
        }
        if ((i & 2) != 0) {
            l = surveyAnswerAction.nextQuestionId;
        }
        if ((i & 4) != 0) {
            j = surveyAnswerAction.currentQuestionId;
        }
        return surveyAnswerAction.copy(list, l, j);
    }

    public final List<SurveyAnswer> component1() {
        return this.answers;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getNextQuestionId() {
        return this.nextQuestionId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getCurrentQuestionId() {
        return this.currentQuestionId;
    }

    public final SurveyAnswerAction copy(List<SurveyAnswer> answers, Long nextQuestionId, long currentQuestionId) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        return new SurveyAnswerAction(answers, nextQuestionId, currentQuestionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SurveyAnswerAction)) {
            return false;
        }
        SurveyAnswerAction surveyAnswerAction = (SurveyAnswerAction) other;
        return Intrinsics.areEqual(this.answers, surveyAnswerAction.answers) && Intrinsics.areEqual(this.nextQuestionId, surveyAnswerAction.nextQuestionId) && this.currentQuestionId == surveyAnswerAction.currentQuestionId;
    }

    public int hashCode() {
        int iHashCode = this.answers.hashCode() * 31;
        Long l = this.nextQuestionId;
        return ((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Long.hashCode(this.currentQuestionId);
    }

    public String toString() {
        return "SurveyAnswerAction(answers=" + this.answers + ", nextQuestionId=" + this.nextQuestionId + ", currentQuestionId=" + this.currentQuestionId + ')';
    }

    public SurveyAnswerAction(List<SurveyAnswer> answers, Long l, long j) {
        Intrinsics.checkNotNullParameter(answers, "answers");
        this.answers = answers;
        this.nextQuestionId = l;
        this.currentQuestionId = j;
    }

    public final List<SurveyAnswer> getAnswers() {
        return this.answers;
    }

    public final Long getNextQuestionId() {
        return this.nextQuestionId;
    }

    public final long getCurrentQuestionId() {
        return this.currentQuestionId;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SurveyAnswerAction(SurveyAnswer answer, Long l, long j) {
        this((List<SurveyAnswer>) CollectionsKt.listOf(answer), l, j);
        Intrinsics.checkNotNullParameter(answer, "answer");
    }
}
