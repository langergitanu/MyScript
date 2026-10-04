package com.survicate.surveys.components.displayLogic;

import com.survicate.surveys.core.logic.display.MultipleChoiceDisplayLogic;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicMultipleChoiceGroup;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicMultipleChoiceGroupCondition;
import com.survicate.surveys.entities.survey.surveyLogic.display.MultipleChoiceDisplayLogicGroup;
import com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyLogicMultipleCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicMultipleEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMultipleChoiceGroupCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMultipleChoiceGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/MultipleChoiceDisplayLogicGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/display/MultipleChoiceDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/MultipleChoiceDisplayLogic;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicMultipleExKt {

    /* JADX INFO: compiled from: DisplayLogicMultipleEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicMultipleCondition.values().length];
            try {
                iArr[SurveyLogicMultipleCondition.IS_EXACTLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicMultipleCondition.INCLUDES_ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicMultipleCondition.INCLUDES_ANY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyLogicMultipleCondition.DOES_NOT_INCLUDE_ANY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SurveyLogicMultipleCondition.HAS_ANY_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DisplayLogicMultipleChoiceGroupCondition toCoreCondition(SurveyLogicMultipleCondition surveyLogicMultipleCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicMultipleCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicMultipleCondition.ordinal()];
        if (i == 1) {
            return DisplayLogicMultipleChoiceGroupCondition.IS_EXACTLY;
        }
        if (i == 2) {
            return DisplayLogicMultipleChoiceGroupCondition.INCLUDES_ALL;
        }
        if (i == 3) {
            return DisplayLogicMultipleChoiceGroupCondition.INCLUDES_ANY;
        }
        if (i == 4) {
            return DisplayLogicMultipleChoiceGroupCondition.DOES_NOT_INCLUDE_ANY;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return DisplayLogicMultipleChoiceGroupCondition.HAS_ANY_VALUE;
    }

    private static final DisplayLogicMultipleChoiceGroup toCoreGroup(MultipleChoiceDisplayLogicGroup multipleChoiceDisplayLogicGroup) {
        return new DisplayLogicMultipleChoiceGroup(toCoreCondition(multipleChoiceDisplayLogicGroup.getCondition()), multipleChoiceDisplayLogicGroup.getValue());
    }

    public static final MultipleChoiceDisplayLogic toCoreLogic(com.survicate.surveys.entities.survey.surveyLogic.display.MultipleChoiceDisplayLogic multipleChoiceDisplayLogic) {
        Intrinsics.checkNotNullParameter(multipleChoiceDisplayLogic, "<this>");
        long pointId = multipleChoiceDisplayLogic.getPointId();
        List<MultipleChoiceDisplayLogicGroup> groups = multipleChoiceDisplayLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((MultipleChoiceDisplayLogicGroup) it.next()));
        }
        return new MultipleChoiceDisplayLogic(pointId, arrayList, DisplayLogicExKt.toCoreOperator(multipleChoiceDisplayLogic.getGroupOperator()));
    }
}
