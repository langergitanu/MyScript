package com.survicate.surveys.core.logic.branch.groups;

import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicSingleChoiceGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicSingleChoiceGroup;", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicGroup;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Single;", "condition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicSingleChoiceCondition;", "value", "", "", "<init>", "(Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicSingleChoiceCondition;Ljava/util/List;)V", "getCondition", "()Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicSingleChoiceCondition;", "getValue", "()Ljava/util/List;", "isSatisfiedBy", "", "answer", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class BranchLogicSingleChoiceGroup implements BranchLogicGroup<QuestionAnswered.Single> {
    private final BranchLogicSingleChoiceCondition condition;
    private final List<Long> value;

    /* JADX INFO: compiled from: BranchLogicSingleChoiceGroup.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BranchLogicSingleChoiceCondition.values().length];
            try {
                iArr[BranchLogicSingleChoiceCondition.f2259IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BranchLogicSingleChoiceCondition.IS_NOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BranchLogicSingleChoiceCondition.HAS_ANY_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BranchLogicSingleChoiceGroup copy$default(BranchLogicSingleChoiceGroup branchLogicSingleChoiceGroup, BranchLogicSingleChoiceCondition branchLogicSingleChoiceCondition, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            branchLogicSingleChoiceCondition = branchLogicSingleChoiceGroup.condition;
        }
        if ((i & 2) != 0) {
            list = branchLogicSingleChoiceGroup.value;
        }
        return branchLogicSingleChoiceGroup.copy(branchLogicSingleChoiceCondition, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BranchLogicSingleChoiceCondition getCondition() {
        return this.condition;
    }

    public final List<Long> component2() {
        return this.value;
    }

    public final BranchLogicSingleChoiceGroup copy(BranchLogicSingleChoiceCondition condition, List<Long> value) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(value, "value");
        return new BranchLogicSingleChoiceGroup(condition, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BranchLogicSingleChoiceGroup)) {
            return false;
        }
        BranchLogicSingleChoiceGroup branchLogicSingleChoiceGroup = (BranchLogicSingleChoiceGroup) other;
        return this.condition == branchLogicSingleChoiceGroup.condition && Intrinsics.areEqual(this.value, branchLogicSingleChoiceGroup.value);
    }

    public int hashCode() {
        return (this.condition.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "BranchLogicSingleChoiceGroup(condition=" + this.condition + ", value=" + this.value + ')';
    }

    public BranchLogicSingleChoiceGroup(BranchLogicSingleChoiceCondition condition, List<Long> value) {
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(value, "value");
        this.condition = condition;
        this.value = value;
    }

    public final BranchLogicSingleChoiceCondition getCondition() {
        return this.condition;
    }

    public final List<Long> getValue() {
        return this.value;
    }

    @Override // com.survicate.surveys.core.logic.branch.groups.BranchLogicGroup
    public boolean isSatisfiedBy(QuestionAnswered.Single answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (answer.getAnswerId() == null) {
            return this.condition == BranchLogicSingleChoiceCondition.HAS_ANY_VALUE;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.condition.ordinal()];
        if (i == 1) {
            return this.value.contains(answer.getAnswerId());
        }
        if (i == 2) {
            return !this.value.contains(answer.getAnswerId());
        }
        if (i == 3) {
            return true;
        }
        throw new NoWhenBranchMatchedException();
    }
}
