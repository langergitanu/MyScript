package com.survicate.surveys.core.logic.display.models;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.DisplayLogic;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionSuggestion.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/models/QuestionSuggestion;", "", "questionId", "", "displayLogicOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "displayLogic", "", "Lcom/survicate/surveys/core/logic/display/DisplayLogic;", "<init>", "(JLcom/survicate/surveys/core/logic/core/AndOrOperator;Ljava/util/List;)V", "getQuestionId", "()J", "getDisplayLogicOperator", "()Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "getDisplayLogic", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class QuestionSuggestion {
    private final List<DisplayLogic> displayLogic;
    private final AndOrOperator displayLogicOperator;
    private final long questionId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuestionSuggestion copy$default(QuestionSuggestion questionSuggestion, long j, AndOrOperator andOrOperator, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = questionSuggestion.questionId;
        }
        if ((i & 2) != 0) {
            andOrOperator = questionSuggestion.displayLogicOperator;
        }
        if ((i & 4) != 0) {
            list = questionSuggestion.displayLogic;
        }
        return questionSuggestion.copy(j, andOrOperator, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getQuestionId() {
        return this.questionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AndOrOperator getDisplayLogicOperator() {
        return this.displayLogicOperator;
    }

    public final List<DisplayLogic> component3() {
        return this.displayLogic;
    }

    public final QuestionSuggestion copy(long questionId, AndOrOperator displayLogicOperator, List<? extends DisplayLogic> displayLogic) {
        Intrinsics.checkNotNullParameter(displayLogicOperator, "displayLogicOperator");
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        return new QuestionSuggestion(questionId, displayLogicOperator, displayLogic);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QuestionSuggestion)) {
            return false;
        }
        QuestionSuggestion questionSuggestion = (QuestionSuggestion) other;
        return this.questionId == questionSuggestion.questionId && this.displayLogicOperator == questionSuggestion.displayLogicOperator && Intrinsics.areEqual(this.displayLogic, questionSuggestion.displayLogic);
    }

    public int hashCode() {
        return (((Long.hashCode(this.questionId) * 31) + this.displayLogicOperator.hashCode()) * 31) + this.displayLogic.hashCode();
    }

    public String toString() {
        return "QuestionSuggestion(questionId=" + this.questionId + ", displayLogicOperator=" + this.displayLogicOperator + ", displayLogic=" + this.displayLogic + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuestionSuggestion(long j, AndOrOperator displayLogicOperator, List<? extends DisplayLogic> displayLogic) {
        Intrinsics.checkNotNullParameter(displayLogicOperator, "displayLogicOperator");
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        this.questionId = j;
        this.displayLogicOperator = displayLogicOperator;
        this.displayLogic = displayLogic;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final AndOrOperator getDisplayLogicOperator() {
        return this.displayLogicOperator;
    }

    public final List<DisplayLogic> getDisplayLogic() {
        return this.displayLogic;
    }
}
