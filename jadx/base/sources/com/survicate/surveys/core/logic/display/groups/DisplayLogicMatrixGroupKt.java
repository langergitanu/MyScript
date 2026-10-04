package com.survicate.surveys.core.logic.display.groups;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: DisplayLogicMatrixGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\"\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\n"}, m1599d2 = {"evaluateCondition", "", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMatrixGroup;", "columnValue", "", "combineResults", "acc", "current", "operator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicMatrixGroupKt {

    /* JADX INFO: compiled from: DisplayLogicMatrixGroup.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DisplayLogicMatrixGroupCondition.values().length];
            try {
                iArr[DisplayLogicMatrixGroupCondition.f2261IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayLogicMatrixGroupCondition.IS_NOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayLogicMatrixGroupCondition.IS_BETWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DisplayLogicMatrixGroupCondition.HAS_ANY_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AndOrOperator.values().length];
            try {
                iArr2[AndOrOperator.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AndOrOperator.f2260OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean evaluateCondition(DisplayLogicMatrixGroup displayLogicMatrixGroup, long j) {
        int i = WhenMappings.$EnumSwitchMapping$0[displayLogicMatrixGroup.getCondition().ordinal()];
        if (i == 1) {
            List<Long> value = displayLogicMatrixGroup.getValue();
            if ((value instanceof Collection) && value.isEmpty()) {
                return false;
            }
            Iterator<T> it = value.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).longValue() == j) {
                    return true;
                }
            }
            return false;
        }
        if (i == 2) {
            List<Long> value2 = displayLogicMatrixGroup.getValue();
            if ((value2 instanceof Collection) && value2.isEmpty()) {
                return true;
            }
            Iterator<T> it2 = value2.iterator();
            while (it2.hasNext()) {
                if (((Number) it2.next()).longValue() == j) {
                    return false;
                }
            }
            return true;
        }
        if (i != 3) {
            if (i == 4) {
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (displayLogicMatrixGroup.getValue().size() == 2) {
            long jLongValue = displayLogicMatrixGroup.getValue().get(0).longValue();
            if (j <= displayLogicMatrixGroup.getValue().get(1).longValue() && jLongValue <= j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean combineResults(boolean z, boolean z2, AndOrOperator andOrOperator) {
        int i = andOrOperator == null ? -1 : WhenMappings.$EnumSwitchMapping$1[andOrOperator.ordinal()];
        if (i == 1) {
            return z && z2;
        }
        if (i != 2) {
            return false;
        }
        return z || z2;
    }
}
