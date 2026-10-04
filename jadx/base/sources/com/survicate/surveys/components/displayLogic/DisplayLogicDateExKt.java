package com.survicate.surveys.components.displayLogic;

import com.survicate.surveys.core.logic.display.DateDisplayLogic;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicDateGroup;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicDateGroupCondition;
import com.survicate.surveys.entities.survey.surveyLogic.date.SurveyLogicDateCondition;
import com.survicate.surveys.entities.survey.surveyLogic.display.DateDisplayLogicGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicDateEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicDateGroupCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/date/SurveyLogicDateCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicDateGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DateDisplayLogicGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/display/DateDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DateDisplayLogic;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicDateExKt {

    /* JADX INFO: compiled from: DisplayLogicDateEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicDateCondition.values().length];
            try {
                iArr[SurveyLogicDateCondition.HAS_ANY_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicDateCondition.QUESTION_IS_ANSWERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicDateCondition.QUESTION_IS_NOT_ANSWERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DisplayLogicDateGroupCondition toCoreCondition(SurveyLogicDateCondition surveyLogicDateCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicDateCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicDateCondition.ordinal()];
        if (i == 1) {
            return DisplayLogicDateGroupCondition.HAS_ANY_VALUE;
        }
        if (i == 2) {
            return DisplayLogicDateGroupCondition.QUESTION_IS_ANSWERED;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return DisplayLogicDateGroupCondition.QUESTION_IS_NOT_ANSWERED;
    }

    private static final DisplayLogicDateGroup toCoreGroup(DateDisplayLogicGroup dateDisplayLogicGroup) {
        return new DisplayLogicDateGroup(toCoreCondition(dateDisplayLogicGroup.getCondition()), dateDisplayLogicGroup.getValue());
    }

    public static final DateDisplayLogic toCoreLogic(com.survicate.surveys.entities.survey.surveyLogic.display.DateDisplayLogic dateDisplayLogic) {
        Intrinsics.checkNotNullParameter(dateDisplayLogic, "<this>");
        long pointId = dateDisplayLogic.getPointId();
        List<DateDisplayLogicGroup> groups = dateDisplayLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((DateDisplayLogicGroup) it.next()));
        }
        return new DateDisplayLogic(pointId, arrayList, DisplayLogicExKt.toCoreOperator(dateDisplayLogic.getGroupOperator()));
    }
}
