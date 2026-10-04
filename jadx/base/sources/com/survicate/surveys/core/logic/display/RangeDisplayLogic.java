package com.survicate.surveys.core.logic.display;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicRangeGroup;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/RangeDisplayLogic;", "Lcom/survicate/surveys/core/logic/display/DisplayLogic;", "pointId", "", "groups", "", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicRangeGroup;", "groupOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "<init>", "(JLjava/util/List;Lcom/survicate/surveys/core/logic/core/AndOrOperator;)V", "getPointId", "()J", "getGroups", "()Ljava/util/List;", "getGroupOperator", "()Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "isSatisfied", "", "providedAnswer", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class RangeDisplayLogic extends DisplayLogic {
    private final AndOrOperator groupOperator;
    private final List<DisplayLogicRangeGroup> groups;
    private final long pointId;

    /* JADX INFO: compiled from: DisplayLogic.kt */
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
    public static /* synthetic */ RangeDisplayLogic copy$default(RangeDisplayLogic rangeDisplayLogic, long j, List list, AndOrOperator andOrOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            j = rangeDisplayLogic.pointId;
        }
        if ((i & 2) != 0) {
            list = rangeDisplayLogic.groups;
        }
        if ((i & 4) != 0) {
            andOrOperator = rangeDisplayLogic.groupOperator;
        }
        return rangeDisplayLogic.copy(j, list, andOrOperator);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getPointId() {
        return this.pointId;
    }

    public final List<DisplayLogicRangeGroup> component2() {
        return this.groups;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final AndOrOperator getGroupOperator() {
        return this.groupOperator;
    }

    public final RangeDisplayLogic copy(long pointId, List<DisplayLogicRangeGroup> groups, AndOrOperator groupOperator) {
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(groupOperator, "groupOperator");
        return new RangeDisplayLogic(pointId, groups, groupOperator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RangeDisplayLogic)) {
            return false;
        }
        RangeDisplayLogic rangeDisplayLogic = (RangeDisplayLogic) other;
        return this.pointId == rangeDisplayLogic.pointId && Intrinsics.areEqual(this.groups, rangeDisplayLogic.groups) && this.groupOperator == rangeDisplayLogic.groupOperator;
    }

    public int hashCode() {
        return (((Long.hashCode(this.pointId) * 31) + this.groups.hashCode()) * 31) + this.groupOperator.hashCode();
    }

    public String toString() {
        return "RangeDisplayLogic(pointId=" + this.pointId + ", groups=" + this.groups + ", groupOperator=" + this.groupOperator + ')';
    }

    @Override // com.survicate.surveys.core.logic.display.DisplayLogic
    public long getPointId() {
        return this.pointId;
    }

    @Override // com.survicate.surveys.core.logic.display.DisplayLogic
    public List<DisplayLogicRangeGroup> getGroups() {
        return this.groups;
    }

    @Override // com.survicate.surveys.core.logic.display.DisplayLogic
    public AndOrOperator getGroupOperator() {
        return this.groupOperator;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RangeDisplayLogic(long j, List<DisplayLogicRangeGroup> groups, AndOrOperator groupOperator) {
        super(null);
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(groupOperator, "groupOperator");
        this.pointId = j;
        this.groups = groups;
        this.groupOperator = groupOperator;
    }

    @Override // com.survicate.surveys.core.logic.display.DisplayLogic
    public boolean isSatisfied(QuestionAnswered providedAnswer) {
        if (providedAnswer instanceof QuestionAnswered.Range) {
            QuestionAnswered.Range range = (QuestionAnswered.Range) providedAnswer;
            if (range.getPointId() == getPointId()) {
                int i = WhenMappings.$EnumSwitchMapping$0[getGroupOperator().ordinal()];
                if (i == 1) {
                    List<DisplayLogicRangeGroup> groups = getGroups();
                    if ((groups instanceof Collection) && groups.isEmpty()) {
                        return true;
                    }
                    Iterator<T> it = groups.iterator();
                    while (it.hasNext()) {
                        if (!((DisplayLogicRangeGroup) it.next()).isSatisfiedBy(range)) {
                            return false;
                        }
                    }
                    return true;
                }
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                List<DisplayLogicRangeGroup> groups2 = getGroups();
                if ((groups2 instanceof Collection) && groups2.isEmpty()) {
                    return false;
                }
                Iterator<T> it2 = groups2.iterator();
                while (it2.hasNext()) {
                    if (((DisplayLogicRangeGroup) it2.next()).isSatisfiedBy(range)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
