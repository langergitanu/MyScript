package com.survicate.surveys.core.logic.display.groups;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.models.FormAnswer;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DisplayLogicFormGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0016\u0010\u0015\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0002J\u0016\u0010\u0018\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0002J\u0016\u0010\u0019\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0002J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J-\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicFormGroup;", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicGroup;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Form;", "condition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicFormCondition;", "fieldOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "fieldIds", "", "", "<init>", "(Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicFormCondition;Lcom/survicate/surveys/core/logic/core/AndOrOperator;Ljava/util/List;)V", "getCondition", "()Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicFormCondition;", "getFieldOperator", "()Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "getFieldIds", "()Ljava/util/List;", "isSatisfiedBy", "", "answer", "resolveIsFilledInFormLogic", "answers", "Lcom/survicate/surveys/core/logic/display/models/FormAnswer;", "resolveIsNotFilledInFormGroupLogic", "resolveHasAnyValueFormGroupLogic", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class DisplayLogicFormGroup implements DisplayLogicGroup<QuestionAnswered.Form> {
    public static final long ANY_FIELD_ID = -1;
    private final DisplayLogicFormCondition condition;
    private final List<Long> fieldIds;
    private final AndOrOperator fieldOperator;

    /* JADX INFO: compiled from: DisplayLogicFormGroup.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DisplayLogicFormCondition.values().length];
            try {
                iArr[DisplayLogicFormCondition.IS_FILLED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayLogicFormCondition.IS_NOT_FILLED_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayLogicFormCondition.HAS_ANY_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AndOrOperator.values().length];
            try {
                iArr2[AndOrOperator.f2260OR.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AndOrOperator.AND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DisplayLogicFormGroup copy$default(DisplayLogicFormGroup displayLogicFormGroup, DisplayLogicFormCondition displayLogicFormCondition, AndOrOperator andOrOperator, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            displayLogicFormCondition = displayLogicFormGroup.condition;
        }
        if ((i & 2) != 0) {
            andOrOperator = displayLogicFormGroup.fieldOperator;
        }
        if ((i & 4) != 0) {
            list = displayLogicFormGroup.fieldIds;
        }
        return displayLogicFormGroup.copy(displayLogicFormCondition, andOrOperator, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DisplayLogicFormCondition getCondition() {
        return this.condition;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final AndOrOperator getFieldOperator() {
        return this.fieldOperator;
    }

    public final List<Long> component3() {
        return this.fieldIds;
    }

    public final DisplayLogicFormGroup copy(DisplayLogicFormCondition condition, AndOrOperator fieldOperator, List<Long> fieldIds) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(fieldOperator, "fieldOperator");
        Intrinsics.checkNotNullParameter(fieldIds, "fieldIds");
        return new DisplayLogicFormGroup(condition, fieldOperator, fieldIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DisplayLogicFormGroup)) {
            return false;
        }
        DisplayLogicFormGroup displayLogicFormGroup = (DisplayLogicFormGroup) other;
        return this.condition == displayLogicFormGroup.condition && this.fieldOperator == displayLogicFormGroup.fieldOperator && Intrinsics.areEqual(this.fieldIds, displayLogicFormGroup.fieldIds);
    }

    public int hashCode() {
        return (((this.condition.hashCode() * 31) + this.fieldOperator.hashCode()) * 31) + this.fieldIds.hashCode();
    }

    public String toString() {
        return "DisplayLogicFormGroup(condition=" + this.condition + ", fieldOperator=" + this.fieldOperator + ", fieldIds=" + this.fieldIds + ')';
    }

    public DisplayLogicFormGroup(DisplayLogicFormCondition condition, AndOrOperator fieldOperator, List<Long> fieldIds) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(fieldOperator, "fieldOperator");
        Intrinsics.checkNotNullParameter(fieldIds, "fieldIds");
        this.condition = condition;
        this.fieldOperator = fieldOperator;
        this.fieldIds = fieldIds;
    }

    public final DisplayLogicFormCondition getCondition() {
        return this.condition;
    }

    public final AndOrOperator getFieldOperator() {
        return this.fieldOperator;
    }

    public final List<Long> getFieldIds() {
        return this.fieldIds;
    }

    @Override // com.survicate.surveys.core.logic.display.groups.DisplayLogicGroup
    public boolean isSatisfiedBy(QuestionAnswered.Form answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        int i = WhenMappings.$EnumSwitchMapping$0[this.condition.ordinal()];
        if (i == 1) {
            return resolveIsFilledInFormLogic(answer.getAnswers());
        }
        if (i == 2) {
            return resolveIsNotFilledInFormGroupLogic(answer.getAnswers());
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return resolveHasAnyValueFormGroupLogic(answer.getAnswers());
    }

    private final boolean resolveIsFilledInFormLogic(List<FormAnswer> answers) {
        Object next;
        String answer;
        Object next2;
        String answer2;
        int i = WhenMappings.$EnumSwitchMapping$1[this.fieldOperator.ordinal()];
        if (i == 1) {
            List<Long> list = this.fieldIds;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
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
                    if (((FormAnswer) next).getFieldId() == jLongValue) {
                        break;
                    }
                }
                FormAnswer formAnswer = (FormAnswer) next;
                if (formAnswer != null && (answer = formAnswer.getAnswer()) != null && (!StringsKt.isBlank(answer))) {
                    return true;
                }
            }
            return false;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (!this.fieldIds.isEmpty()) {
            List<Long> list2 = this.fieldIds;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    long jLongValue2 = ((Number) it3.next()).longValue();
                    Iterator<T> it4 = answers.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it4.next();
                        if (((FormAnswer) next2).getFieldId() == jLongValue2) {
                            break;
                        }
                    }
                    FormAnswer formAnswer2 = (FormAnswer) next2;
                    if (formAnswer2 == null || (answer2 = formAnswer2.getAnswer()) == null || !(!StringsKt.isBlank(answer2))) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private final boolean resolveIsNotFilledInFormGroupLogic(List<FormAnswer> answers) {
        Object next;
        Object next2;
        int i = WhenMappings.$EnumSwitchMapping$1[this.fieldOperator.ordinal()];
        if (i == 1) {
            List<Long> list = this.fieldIds;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
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
                    if (((FormAnswer) next).getFieldId() == jLongValue) {
                        break;
                    }
                }
                FormAnswer formAnswer = (FormAnswer) next;
                String answer = formAnswer != null ? formAnswer.getAnswer() : null;
                if (answer == null || StringsKt.isBlank(answer)) {
                    return true;
                }
            }
            return false;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (!this.fieldIds.isEmpty()) {
            List<Long> list2 = this.fieldIds;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it3 = list2.iterator();
                while (it3.hasNext()) {
                    long jLongValue2 = ((Number) it3.next()).longValue();
                    Iterator<T> it4 = answers.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it4.next();
                        if (((FormAnswer) next2).getFieldId() == jLongValue2) {
                            break;
                        }
                    }
                    FormAnswer formAnswer2 = (FormAnswer) next2;
                    String answer2 = formAnswer2 != null ? formAnswer2.getAnswer() : null;
                    if (answer2 == null || StringsKt.isBlank(answer2)) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    private final boolean resolveHasAnyValueFormGroupLogic(List<FormAnswer> answers) {
        Object next;
        Object next2;
        List<Long> list = this.fieldIds;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).longValue() == -1) {
                    return true;
                }
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$1[this.fieldOperator.ordinal()];
        if (i == 1) {
            List<Long> list2 = this.fieldIds;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                return false;
            }
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                long jLongValue = ((Number) it2.next()).longValue();
                Iterator<T> it3 = answers.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                    if (((FormAnswer) next).getFieldId() == jLongValue) {
                        break;
                    }
                }
                if (next != null) {
                    return true;
                }
            }
            return false;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (!this.fieldIds.isEmpty()) {
            List<Long> list3 = this.fieldIds;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it4 = list3.iterator();
                while (it4.hasNext()) {
                    long jLongValue2 = ((Number) it4.next()).longValue();
                    Iterator<T> it5 = answers.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it5.next();
                        if (((FormAnswer) next2).getFieldId() == jLongValue2) {
                            break;
                        }
                    }
                    if (next2 != null) {
                    }
                }
            }
            return true;
        }
        return false;
    }
}
