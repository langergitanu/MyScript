package com.survicate.surveys.components.displayLogic;

import com.survicate.surveys.core.logic.display.SingleChoiceDisplayLogic;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicSingleChoiceGroup;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicSingleChoiceGroupCondition;
import com.survicate.surveys.entities.survey.surveyLogic.display.SingleChoiceDisplayLogicGroup;
import com.survicate.surveys.entities.survey.surveyLogic.single.SurveyLogicSingleCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicSingleEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicSingleChoiceGroupCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/single/SurveyLogicSingleCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicSingleChoiceGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/SingleChoiceDisplayLogicGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/display/SingleChoiceDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/SingleChoiceDisplayLogic;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicSingleExKt {

    /* JADX INFO: compiled from: DisplayLogicSingleEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicSingleCondition.values().length];
            try {
                iArr[SurveyLogicSingleCondition.f2286IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicSingleCondition.IS_NOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicSingleCondition.HAS_ANY_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DisplayLogicSingleChoiceGroupCondition toCoreCondition(SurveyLogicSingleCondition surveyLogicSingleCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicSingleCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicSingleCondition.ordinal()];
        if (i == 1) {
            return DisplayLogicSingleChoiceGroupCondition.f2263IS;
        }
        if (i == 2) {
            return DisplayLogicSingleChoiceGroupCondition.IS_NOT;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return DisplayLogicSingleChoiceGroupCondition.HAS_ANY_VALUE;
    }

    private static final DisplayLogicSingleChoiceGroup toCoreGroup(SingleChoiceDisplayLogicGroup singleChoiceDisplayLogicGroup) {
        return new DisplayLogicSingleChoiceGroup(toCoreCondition(singleChoiceDisplayLogicGroup.getCondition()), singleChoiceDisplayLogicGroup.getValue());
    }

    public static final SingleChoiceDisplayLogic toCoreLogic(com.survicate.surveys.entities.survey.surveyLogic.display.SingleChoiceDisplayLogic singleChoiceDisplayLogic) {
        Intrinsics.checkNotNullParameter(singleChoiceDisplayLogic, "<this>");
        long pointId = singleChoiceDisplayLogic.getPointId();
        List<SingleChoiceDisplayLogicGroup> groups = singleChoiceDisplayLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((SingleChoiceDisplayLogicGroup) it.next()));
        }
        return new SingleChoiceDisplayLogic(pointId, arrayList, DisplayLogicExKt.toCoreOperator(singleChoiceDisplayLogic.getGroupOperator()));
    }
}
