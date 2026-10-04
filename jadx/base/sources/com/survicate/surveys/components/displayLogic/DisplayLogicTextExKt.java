package com.survicate.surveys.components.displayLogic;

import com.survicate.surveys.core.logic.display.TextDisplayLogic;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicTextGroup;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicTextGroupCondition;
import com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogicGroup;
import com.survicate.surveys.entities.survey.surveyLogic.text.SurveyLogicTextCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicTextEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicTextGroupCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyLogicTextCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicTextGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogicGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/display/TextDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/TextDisplayLogic;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicTextExKt {

    /* JADX INFO: compiled from: DisplayLogicTextEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicTextCondition.values().length];
            try {
                iArr[SurveyLogicTextCondition.ANSWER_CONTAINS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicTextCondition.ANSWER_DOES_NOT_CONTAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicTextCondition.QUESTION_IS_ANSWERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyLogicTextCondition.QUESTION_IS_NOT_ANSWERED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SurveyLogicTextCondition.HAS_ANY_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DisplayLogicTextGroupCondition toCoreCondition(SurveyLogicTextCondition surveyLogicTextCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicTextCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicTextCondition.ordinal()];
        if (i == 1) {
            return DisplayLogicTextGroupCondition.ANSWER_CONTAINS;
        }
        if (i == 2) {
            return DisplayLogicTextGroupCondition.ANSWER_DOES_NOT_CONTAIN;
        }
        if (i == 3) {
            return DisplayLogicTextGroupCondition.QUESTION_IS_ANSWERED;
        }
        if (i == 4) {
            return DisplayLogicTextGroupCondition.QUESTION_IS_NOT_ANSWERED;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return DisplayLogicTextGroupCondition.HAS_ANY_VALUE;
    }

    private static final DisplayLogicTextGroup toCoreGroup(TextDisplayLogicGroup textDisplayLogicGroup) {
        return new DisplayLogicTextGroup(toCoreCondition(textDisplayLogicGroup.getCondition()), textDisplayLogicGroup.getValue(), DisplayLogicExKt.toCoreOperator(textDisplayLogicGroup.getValueOperator()));
    }

    public static final TextDisplayLogic toCoreLogic(com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogic textDisplayLogic) {
        Intrinsics.checkNotNullParameter(textDisplayLogic, "<this>");
        long pointId = textDisplayLogic.getPointId();
        List<TextDisplayLogicGroup> groups = textDisplayLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((TextDisplayLogicGroup) it.next()));
        }
        return new TextDisplayLogic(pointId, arrayList, DisplayLogicExKt.toCoreOperator(textDisplayLogic.getGroupOperator()));
    }
}
