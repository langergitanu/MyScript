package com.survicate.surveys.core.logic.display.groups;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.models.MatrixAnswer;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicMatrixGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMatrixGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicGroup;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Matrix;", "condition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMatrixGroupCondition;", "value", "", "", "answerIds", "answerIdsOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "<init>", "(Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMatrixGroupCondition;Ljava/util/List;Ljava/util/List;Lcom/survicate/surveys/core/logic/core/AndOrOperator;)V", "getCondition", "()Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMatrixGroupCondition;", "getValue", "()Ljava/util/List;", "getAnswerIds", "getAnswerIdsOperator", "()Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "isSatisfiedBy", "", "answer", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class DisplayLogicMatrixGroup implements DisplayLogicGroup<QuestionAnswered.Matrix> {
    private final List<Long> answerIds;
    private final AndOrOperator answerIdsOperator;
    private final DisplayLogicMatrixGroupCondition condition;
    private final List<Long> value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DisplayLogicMatrixGroup copy$default(DisplayLogicMatrixGroup displayLogicMatrixGroup, DisplayLogicMatrixGroupCondition displayLogicMatrixGroupCondition, List list, List list2, AndOrOperator andOrOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            displayLogicMatrixGroupCondition = displayLogicMatrixGroup.condition;
        }
        if ((i & 2) != 0) {
            list = displayLogicMatrixGroup.value;
        }
        if ((i & 4) != 0) {
            list2 = displayLogicMatrixGroup.answerIds;
        }
        if ((i & 8) != 0) {
            andOrOperator = displayLogicMatrixGroup.answerIdsOperator;
        }
        return displayLogicMatrixGroup.copy(displayLogicMatrixGroupCondition, list, list2, andOrOperator);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DisplayLogicMatrixGroupCondition getCondition() {
        return this.condition;
    }

    public final List<Long> component2() {
        return this.value;
    }

    public final List<Long> component3() {
        return this.answerIds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AndOrOperator getAnswerIdsOperator() {
        return this.answerIdsOperator;
    }

    public final DisplayLogicMatrixGroup copy(DisplayLogicMatrixGroupCondition condition, List<Long> value, List<Long> answerIds, AndOrOperator answerIdsOperator) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(answerIds, "answerIds");
        Intrinsics.checkNotNullParameter(answerIdsOperator, "answerIdsOperator");
        return new DisplayLogicMatrixGroup(condition, value, answerIds, answerIdsOperator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayLogicMatrixGroup)) {
            return false;
        }
        DisplayLogicMatrixGroup displayLogicMatrixGroup = (DisplayLogicMatrixGroup) other;
        return this.condition == displayLogicMatrixGroup.condition && Intrinsics.areEqual(this.value, displayLogicMatrixGroup.value) && Intrinsics.areEqual(this.answerIds, displayLogicMatrixGroup.answerIds) && this.answerIdsOperator == displayLogicMatrixGroup.answerIdsOperator;
    }

    public int hashCode() {
        return (((((this.condition.hashCode() * 31) + this.value.hashCode()) * 31) + this.answerIds.hashCode()) * 31) + this.answerIdsOperator.hashCode();
    }

    public String toString() {
        return "DisplayLogicMatrixGroup(condition=" + this.condition + ", value=" + this.value + ", answerIds=" + this.answerIds + ", answerIdsOperator=" + this.answerIdsOperator + ')';
    }

    public DisplayLogicMatrixGroup(DisplayLogicMatrixGroupCondition condition, List<Long> value, List<Long> answerIds, AndOrOperator answerIdsOperator) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(answerIds, "answerIds");
        Intrinsics.checkNotNullParameter(answerIdsOperator, "answerIdsOperator");
        this.condition = condition;
        this.value = value;
        this.answerIds = answerIds;
        this.answerIdsOperator = answerIdsOperator;
    }

    public final DisplayLogicMatrixGroupCondition getCondition() {
        return this.condition;
    }

    public final List<Long> getValue() {
        return this.value;
    }

    public final List<Long> getAnswerIds() {
        return this.answerIds;
    }

    public final AndOrOperator getAnswerIdsOperator() {
        return this.answerIdsOperator;
    }

    @Override // com.survicate.surveys.core.logic.display.groups.DisplayLogicGroup
    public boolean isSatisfiedBy(QuestionAnswered.Matrix answer) {
        Object next;
        Intrinsics.checkNotNullParameter(answer, "answer");
        List<MatrixAnswer> answers = answer.getAnswers();
        if (this.condition == DisplayLogicMatrixGroupCondition.HAS_ANY_VALUE) {
            return true;
        }
        List<Long> list = this.answerIds;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            Iterator<T> it2 = answers.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (((MatrixAnswer) next).getRowId() == jLongValue) {
                    break;
                }
            }
            MatrixAnswer matrixAnswer = (MatrixAnswer) next;
            Long lValueOf = matrixAnswer != null ? Long.valueOf(matrixAnswer.getColumnId()) : null;
            Boolean boolValueOf = lValueOf != null ? Boolean.valueOf(DisplayLogicMatrixGroupKt.evaluateCondition(this, lValueOf.longValue())) : null;
            if (boolValueOf != null) {
                arrayList.add(boolValueOf);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return false;
        }
        Iterator it3 = arrayList2.iterator();
        if (!it3.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        Object next2 = it3.next();
        while (it3.hasNext()) {
            next2 = Boolean.valueOf(DisplayLogicMatrixGroupKt.combineResults(((Boolean) next2).booleanValue(), ((Boolean) it3.next()).booleanValue(), this.answerIdsOperator));
        }
        return ((Boolean) next2).booleanValue();
    }
}
