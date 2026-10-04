package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.core.logic.branch.FormBranchLogic;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicFormCondition;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicFormGroup;
import com.survicate.surveys.core.logic.display.models.FormAnswer;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.form.SurveyLogicFormCondition;
import com.survicate.surveys.entities.survey.surveyLogic.form.SurveyLogicFormGroup;
import com.survicate.surveys.entities.survey.surveyLogic.form.SurveyPointFormLogic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicFormEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0000\u001a(\u0010\t\u001a\u00020\n*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0000¨\u0006\u0010"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicFormCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicFormGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyLogicFormGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/branch/FormBranchLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/form/SurveyPointFormLogic;", "toCoreFormAnswered", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Form;", "", "Lkotlin/Pair;", "", "", "pointId", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicFormExKt {

    /* JADX INFO: compiled from: BranchLogicFormEx.kt */
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

    public static final BranchLogicFormCondition toCoreCondition(SurveyLogicFormCondition surveyLogicFormCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicFormCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicFormCondition.ordinal()];
        if (i == 1) {
            return BranchLogicFormCondition.IS_FILLED_IN;
        }
        if (i == 2) {
            return BranchLogicFormCondition.IS_NOT_FILLED_IN;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return BranchLogicFormCondition.HAS_ANY_VALUE;
    }

    private static final BranchLogicFormGroup toCoreGroup(SurveyLogicFormGroup surveyLogicFormGroup) {
        BranchLogicFormCondition coreCondition = toCoreCondition(surveyLogicFormGroup.getCondition());
        SurveyLogicOperator fieldOperator = surveyLogicFormGroup.getFieldOperator();
        return new BranchLogicFormGroup(coreCondition, fieldOperator != null ? BranchLogicExKt.toCoreOperator(fieldOperator) : null, surveyLogicFormGroup.getFields());
    }

    public static final FormBranchLogic toCoreLogic(SurveyPointFormLogic surveyPointFormLogic) {
        Intrinsics.checkNotNullParameter(surveyPointFormLogic, "<this>");
        int orderNumber = surveyPointFormLogic.getOrderNumber();
        long goTo = surveyPointFormLogic.getGoTo();
        List<SurveyLogicFormGroup> groups = surveyPointFormLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((SurveyLogicFormGroup) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        SurveyLogicOperator logicOperator = surveyPointFormLogic.getLogicOperator();
        return new FormBranchLogic(orderNumber, goTo, arrayList2, logicOperator != null ? BranchLogicExKt.toCoreOperator(logicOperator) : null);
    }

    public static /* synthetic */ QuestionAnswered.Form toCoreFormAnswered$default(List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return toCoreFormAnswered(list, j);
    }

    public static final QuestionAnswered.Form toCoreFormAnswered(List<Pair<Long, String>> list, long j) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<Pair<Long, String>> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(new FormAnswer(((Number) pair.getFirst()).longValue(), (String) pair.getSecond()));
        }
        return new QuestionAnswered.Form(j, arrayList);
    }
}
