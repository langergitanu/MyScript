package com.survicate.surveys.components.displayLogic;

import com.survicate.surveys.core.logic.display.FormDisplayLogic;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicFormCondition;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicFormGroup;
import com.survicate.surveys.entities.survey.surveyLogic.display.FormDisplayLogicGroup;
import com.survicate.surveys.entities.survey.surveyLogic.form.SurveyLogicFormCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicFormEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicFormCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicFormGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/FormDisplayLogicGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/display/FormDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/FormDisplayLogic;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicFormExKt {

    /* JADX INFO: compiled from: DisplayLogicFormEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicFormCondition.values().length];
            try {
                iArr[SurveyLogicFormCondition.IS_FILLED_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicFormCondition.IS_NOT_FILLED_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicFormCondition.HAS_ANY_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DisplayLogicFormCondition toCoreCondition(SurveyLogicFormCondition surveyLogicFormCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicFormCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicFormCondition.ordinal()];
        if (i == 1) {
            return DisplayLogicFormCondition.IS_FILLED_IN;
        }
        if (i == 2) {
            return DisplayLogicFormCondition.IS_NOT_FILLED_IN;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return DisplayLogicFormCondition.HAS_ANY_VALUE;
    }

    private static final DisplayLogicFormGroup toCoreGroup(FormDisplayLogicGroup formDisplayLogicGroup) {
        return new DisplayLogicFormGroup(toCoreCondition(formDisplayLogicGroup.getCondition()), DisplayLogicExKt.toCoreOperator(formDisplayLogicGroup.getFieldIdOperator()), formDisplayLogicGroup.getFieldId());
    }

    public static final FormDisplayLogic toCoreLogic(com.survicate.surveys.entities.survey.surveyLogic.display.FormDisplayLogic formDisplayLogic) {
        Intrinsics.checkNotNullParameter(formDisplayLogic, "<this>");
        long pointId = formDisplayLogic.getPointId();
        List<FormDisplayLogicGroup> groups = formDisplayLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((FormDisplayLogicGroup) it.next()));
        }
        return new FormDisplayLogic(pointId, arrayList, DisplayLogicExKt.toCoreOperator(formDisplayLogic.getGroupOperator()));
    }
}
