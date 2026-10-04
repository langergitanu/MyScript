package com.survicate.surveys.components.displayLogic;

import com.survicate.surveys.core.logic.display.RangeDisplayLogic;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicRangeGroup;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicRangeGroupCondition;
import com.survicate.surveys.entities.survey.surveyLogic.display.RangeDisplayLogicGroup;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyLogicRangeCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicRangeEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicRangeGroupCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/range/SurveyLogicRangeCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicRangeGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/RangeDisplayLogicGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/display/RangeDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/RangeDisplayLogic;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicRangeExKt {

    /* JADX INFO: compiled from: DisplayLogicRangeEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicRangeCondition.values().length];
            try {
                iArr[SurveyLogicRangeCondition.f2285IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicRangeCondition.IS_NOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicRangeCondition.IS_BETWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyLogicRangeCondition.HAS_ANY_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DisplayLogicRangeGroupCondition toCoreCondition(SurveyLogicRangeCondition surveyLogicRangeCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicRangeCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicRangeCondition.ordinal()];
        if (i == 1) {
            return DisplayLogicRangeGroupCondition.f2262IS;
        }
        if (i == 2) {
            return DisplayLogicRangeGroupCondition.IS_NOT;
        }
        if (i == 3) {
            return DisplayLogicRangeGroupCondition.IS_BETWEEN;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return DisplayLogicRangeGroupCondition.HAS_ANY_VALUE;
    }

    private static final DisplayLogicRangeGroup toCoreGroup(RangeDisplayLogicGroup rangeDisplayLogicGroup) {
        return new DisplayLogicRangeGroup(toCoreCondition(rangeDisplayLogicGroup.getCondition()), rangeDisplayLogicGroup.getValue());
    }

    public static final RangeDisplayLogic toCoreLogic(com.survicate.surveys.entities.survey.surveyLogic.display.RangeDisplayLogic rangeDisplayLogic) {
        Intrinsics.checkNotNullParameter(rangeDisplayLogic, "<this>");
        long pointId = rangeDisplayLogic.getPointId();
        List<RangeDisplayLogicGroup> groups = rangeDisplayLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((RangeDisplayLogicGroup) it.next()));
        }
        return new RangeDisplayLogic(pointId, arrayList, DisplayLogicExKt.toCoreOperator(rangeDisplayLogic.getGroupOperator()));
    }
}
