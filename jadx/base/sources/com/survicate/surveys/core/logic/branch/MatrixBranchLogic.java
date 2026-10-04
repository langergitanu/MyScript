package com.survicate.surveys.core.logic.branch;

import com.survicate.surveys.core.logic.branch.groups.BranchLogicMatrixGroup;
import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006$"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/MatrixBranchLogic;", "Lcom/survicate/surveys/core/logic/branch/BranchLogic;", "orderNumber", "", "goTo", "", "groups", "", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicMatrixGroup;", "groupOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "<init>", "(IJLjava/util/List;Lcom/survicate/surveys/core/logic/core/AndOrOperator;)V", "getOrderNumber", "()I", "getGoTo", "()J", "getGroups", "()Ljava/util/List;", "getGroupOperator", "()Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "isSatisfiedBy", "", "answer", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class MatrixBranchLogic extends BranchLogic {
    private final long goTo;
    private final AndOrOperator groupOperator;
    private final List<BranchLogicMatrixGroup> groups;
    private final int orderNumber;

    /* JADX INFO: compiled from: BranchLogic.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AndOrOperator.values().length];
            try {
                iArr[AndOrOperator.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AndOrOperator.f2260OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MatrixBranchLogic copy$default(MatrixBranchLogic matrixBranchLogic, int i, long j, List list, AndOrOperator andOrOperator, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = matrixBranchLogic.orderNumber;
        }
        if ((i2 & 2) != 0) {
            j = matrixBranchLogic.goTo;
        }
        if ((i2 & 4) != 0) {
            list = matrixBranchLogic.groups;
        }
        if ((i2 & 8) != 0) {
            andOrOperator = matrixBranchLogic.groupOperator;
        }
        return matrixBranchLogic.copy(i, j, list, andOrOperator);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getOrderNumber() {
        return this.orderNumber;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGoTo() {
        return this.goTo;
    }

    public final List<BranchLogicMatrixGroup> component3() {
        return this.groups;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AndOrOperator getGroupOperator() {
        return this.groupOperator;
    }

    public final MatrixBranchLogic copy(int orderNumber, long goTo, List<BranchLogicMatrixGroup> groups, AndOrOperator groupOperator) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        return new MatrixBranchLogic(orderNumber, goTo, groups, groupOperator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MatrixBranchLogic)) {
            return false;
        }
        MatrixBranchLogic matrixBranchLogic = (MatrixBranchLogic) other;
        return this.orderNumber == matrixBranchLogic.orderNumber && this.goTo == matrixBranchLogic.goTo && Intrinsics.areEqual(this.groups, matrixBranchLogic.groups) && this.groupOperator == matrixBranchLogic.groupOperator;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.orderNumber) * 31) + Long.hashCode(this.goTo)) * 31) + this.groups.hashCode()) * 31;
        AndOrOperator andOrOperator = this.groupOperator;
        return iHashCode + (andOrOperator == null ? 0 : andOrOperator.hashCode());
    }

    public String toString() {
        return "MatrixBranchLogic(orderNumber=" + this.orderNumber + ", goTo=" + this.goTo + ", groups=" + this.groups + ", groupOperator=" + this.groupOperator + ')';
    }

    @Override // com.survicate.surveys.core.logic.branch.BranchLogic
    public int getOrderNumber() {
        return this.orderNumber;
    }

    @Override // com.survicate.surveys.core.logic.branch.BranchLogic
    public long getGoTo() {
        return this.goTo;
    }

    public final List<BranchLogicMatrixGroup> getGroups() {
        return this.groups;
    }

    public final AndOrOperator getGroupOperator() {
        return this.groupOperator;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MatrixBranchLogic(int i, long j, List<BranchLogicMatrixGroup> groups, AndOrOperator andOrOperator) {
        super(null);
        Intrinsics.checkNotNullParameter(groups, "groups");
        this.orderNumber = i;
        this.goTo = j;
        this.groups = groups;
        this.groupOperator = andOrOperator;
    }

    @Override // com.survicate.surveys.core.logic.branch.BranchLogic
    public boolean isSatisfiedBy(QuestionAnswered answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        if (!(answer instanceof QuestionAnswered.Matrix)) {
            return false;
        }
        AndOrOperator andOrOperator = this.groupOperator;
        int i = andOrOperator == null ? -1 : WhenMappings.$EnumSwitchMapping$0[andOrOperator.ordinal()];
        if (i == -1) {
            if (this.groups.size() == 1) {
                return ((BranchLogicMatrixGroup) CollectionsKt.first((List) this.groups)).isSatisfiedBy((QuestionAnswered.Matrix) answer);
            }
            return false;
        }
        if (i == 1) {
            List<BranchLogicMatrixGroup> list = this.groups;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!((BranchLogicMatrixGroup) it.next()).isSatisfiedBy((QuestionAnswered.Matrix) answer)) {
                    return false;
                }
            }
            return true;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        List<BranchLogicMatrixGroup> list2 = this.groups;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (((BranchLogicMatrixGroup) it2.next()).isSatisfiedBy((QuestionAnswered.Matrix) answer)) {
                return true;
            }
        }
        return false;
    }
}
