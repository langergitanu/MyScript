package com.survicate.surveys.core.logic.branch.groups;

import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BranchLogicDateGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicDateGroup;", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicGroup;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Date;", "condition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicDateCondition;", "<init>", "(Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicDateCondition;)V", "getCondition", "()Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicDateCondition;", "isSatisfiedBy", "", "answer", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class BranchLogicDateGroup implements BranchLogicGroup<QuestionAnswered.Date> {
    private final BranchLogicDateCondition condition;

    /* JADX INFO: compiled from: BranchLogicDateGroup.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BranchLogicDateCondition.values().length];
            try {
                iArr[BranchLogicDateCondition.QUESTION_IS_ANSWERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BranchLogicDateCondition.QUESTION_IS_NOT_ANSWERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BranchLogicDateCondition.HAS_ANY_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ BranchLogicDateGroup copy$default(BranchLogicDateGroup branchLogicDateGroup, BranchLogicDateCondition branchLogicDateCondition, int i, Object obj) {
        if ((i & 1) != 0) {
            branchLogicDateCondition = branchLogicDateGroup.condition;
        }
        return branchLogicDateGroup.copy(branchLogicDateCondition);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BranchLogicDateCondition getCondition() {
        return this.condition;
    }

    public final BranchLogicDateGroup copy(BranchLogicDateCondition condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        return new BranchLogicDateGroup(condition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BranchLogicDateGroup) && this.condition == ((BranchLogicDateGroup) other).condition;
    }

    public int hashCode() {
        return this.condition.hashCode();
    }

    public String toString() {
        return "BranchLogicDateGroup(condition=" + this.condition + ')';
    }

    public BranchLogicDateGroup(BranchLogicDateCondition condition) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        this.condition = condition;
    }

    public final BranchLogicDateCondition getCondition() {
        return this.condition;
    }

    @Override // com.survicate.surveys.core.logic.branch.groups.BranchLogicGroup
    public boolean isSatisfiedBy(QuestionAnswered.Date answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        int i = WhenMappings.$EnumSwitchMapping$0[this.condition.ordinal()];
        if (i == 1) {
            return !StringsKt.isBlank(answer.getAnswer());
        }
        if (i == 2) {
            return StringsKt.isBlank(answer.getAnswer());
        }
        if (i == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
