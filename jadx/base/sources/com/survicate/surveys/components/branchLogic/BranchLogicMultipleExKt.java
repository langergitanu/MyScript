package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.core.logic.branch.MultipleChoiceBranchLogic;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicMultipleChoiceCondition;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicMultipleChoiceGroup;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyLogicMultipleCondition;
import com.survicate.surveys.entities.survey.surveyLogic.multiple.SurveyPointMultipleLogic;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicMultipleEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\tH\u0000¨\u0006\u000b"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicMultipleChoiceCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyLogicMultipleCondition;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/branch/MultipleChoiceBranchLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/multiple/SurveyPointMultipleLogic;", "toCoreMultipleAnswered", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Multiple;", "", "", "pointId", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicMultipleExKt {

    /* JADX INFO: compiled from: BranchLogicMultipleEx.kt */
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

    public static final BranchLogicMultipleChoiceCondition toCoreCondition(SurveyLogicMultipleCondition surveyLogicMultipleCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicMultipleCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicMultipleCondition.ordinal()];
        if (i == 1) {
            return BranchLogicMultipleChoiceCondition.IS_EXACTLY;
        }
        if (i == 2) {
            return BranchLogicMultipleChoiceCondition.INCLUDES_ALL;
        }
        if (i == 3) {
            return BranchLogicMultipleChoiceCondition.INCLUDES_ANY;
        }
        if (i == 4) {
            return BranchLogicMultipleChoiceCondition.DOES_NOT_INCLUDE_ANY;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return BranchLogicMultipleChoiceCondition.HAS_ANY_VALUE;
    }

    public static final MultipleChoiceBranchLogic toCoreLogic(SurveyPointMultipleLogic surveyPointMultipleLogic) {
        Intrinsics.checkNotNullParameter(surveyPointMultipleLogic, "<this>");
        return new MultipleChoiceBranchLogic(surveyPointMultipleLogic.getOrderNumber(), surveyPointMultipleLogic.getGoTo(), new BranchLogicMultipleChoiceGroup(toCoreCondition(surveyPointMultipleLogic.getCondition()), surveyPointMultipleLogic.getValues()));
    }

    public static /* synthetic */ QuestionAnswered.Multiple toCoreMultipleAnswered$default(List list, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return toCoreMultipleAnswered(list, j);
    }

    public static final QuestionAnswered.Multiple toCoreMultipleAnswered(List<Long> list, long j) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return new QuestionAnswered.Multiple(j, list);
    }
}
