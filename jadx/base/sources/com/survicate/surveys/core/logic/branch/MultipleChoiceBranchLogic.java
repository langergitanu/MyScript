package com.survicate.surveys.core.logic.branch;

import com.survicate.surveys.core.logic.branch.groups.BranchLogicMultipleChoiceGroup;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/MultipleChoiceBranchLogic;", "Lcom/survicate/surveys/core/logic/branch/BranchLogic;", "orderNumber", "", "goTo", "", "group", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicMultipleChoiceGroup;", "<init>", "(IJLcom/survicate/surveys/core/logic/branch/groups/BranchLogicMultipleChoiceGroup;)V", "getOrderNumber", "()I", "getGoTo", "()J", "getGroup", "()Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicMultipleChoiceGroup;", "isSatisfiedBy", "", "answer", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class MultipleChoiceBranchLogic extends BranchLogic {
    private final long goTo;
    private final BranchLogicMultipleChoiceGroup group;
    private final int orderNumber;

    public static /* synthetic */ MultipleChoiceBranchLogic copy$default(MultipleChoiceBranchLogic multipleChoiceBranchLogic, int i, long j, BranchLogicMultipleChoiceGroup branchLogicMultipleChoiceGroup, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = multipleChoiceBranchLogic.orderNumber;
        }
        if ((i2 & 2) != 0) {
            j = multipleChoiceBranchLogic.goTo;
        }
        if ((i2 & 4) != 0) {
            branchLogicMultipleChoiceGroup = multipleChoiceBranchLogic.group;
        }
        return multipleChoiceBranchLogic.copy(i, j, branchLogicMultipleChoiceGroup);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOrderNumber() {
        return this.orderNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGoTo() {
        return this.goTo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final BranchLogicMultipleChoiceGroup getGroup() {
        return this.group;
    }

    public final MultipleChoiceBranchLogic copy(int orderNumber, long goTo, BranchLogicMultipleChoiceGroup group) {
        Intrinsics.checkNotNullParameter(group, "group");
        return new MultipleChoiceBranchLogic(orderNumber, goTo, group);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultipleChoiceBranchLogic)) {
            return false;
        }
        MultipleChoiceBranchLogic multipleChoiceBranchLogic = (MultipleChoiceBranchLogic) other;
        return this.orderNumber == multipleChoiceBranchLogic.orderNumber && this.goTo == multipleChoiceBranchLogic.goTo && Intrinsics.areEqual(this.group, multipleChoiceBranchLogic.group);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.orderNumber) * 31) + Long.hashCode(this.goTo)) * 31) + this.group.hashCode();
    }

    public String toString() {
        return "MultipleChoiceBranchLogic(orderNumber=" + this.orderNumber + ", goTo=" + this.goTo + ", group=" + this.group + ')';
    }

    @Override // com.survicate.surveys.core.logic.branch.BranchLogic
    public int getOrderNumber() {
        return this.orderNumber;
    }

    @Override // com.survicate.surveys.core.logic.branch.BranchLogic
    public long getGoTo() {
        return this.goTo;
    }

    public final BranchLogicMultipleChoiceGroup getGroup() {
        return this.group;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultipleChoiceBranchLogic(int i, long j, BranchLogicMultipleChoiceGroup group) {
        super(null);
        Intrinsics.checkNotNullParameter(group, "group");
        this.orderNumber = i;
        this.goTo = j;
        this.group = group;
    }

    @Override // com.survicate.surveys.core.logic.branch.BranchLogic
    public boolean isSatisfiedBy(QuestionAnswered answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (answer instanceof QuestionAnswered.Multiple) {
            return this.group.isSatisfiedBy((QuestionAnswered.Multiple) answer);
        }
        return false;
    }
}
