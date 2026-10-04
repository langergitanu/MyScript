package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.core.logic.branch.TextBranchLogic;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicTextCondition;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicTextGroup;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.text.SurveyLogicTextCondition;
import com.survicate.surveys.entities.survey.surveyLogic.text.SurveyPointTextLogic;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicTextEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicTextCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyLogicTextCondition;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/branch/TextBranchLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/text/SurveyPointTextLogic;", "toCoreTextAnswered", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Text;", "", "pointId", "", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicTextExKt {

    /* JADX INFO: compiled from: BranchLogicTextEx.kt */
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

    public static final BranchLogicTextCondition toCoreCondition(SurveyLogicTextCondition surveyLogicTextCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicTextCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicTextCondition.ordinal()];
        if (i == 1) {
            return BranchLogicTextCondition.ANSWER_CONTAINS;
        }
        if (i == 2) {
            return BranchLogicTextCondition.ANSWER_DOES_NOT_CONTAIN;
        }
        if (i == 3) {
            return BranchLogicTextCondition.QUESTION_IS_ANSWERED;
        }
        if (i == 4) {
            return BranchLogicTextCondition.QUESTION_IS_NOT_ANSWERED;
        }
        if (i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        return BranchLogicTextCondition.HAS_ANY_VALUE;
    }

    public static final TextBranchLogic toCoreLogic(SurveyPointTextLogic surveyPointTextLogic) {
        Intrinsics.checkNotNullParameter(surveyPointTextLogic, "<this>");
        int orderNumber = surveyPointTextLogic.getOrderNumber();
        long goTo = surveyPointTextLogic.getGoTo();
        BranchLogicTextCondition coreCondition = toCoreCondition(surveyPointTextLogic.getCondition());
        List<String> values = surveyPointTextLogic.getValues();
        SurveyLogicOperator operator = surveyPointTextLogic.getOperator();
        return new TextBranchLogic(orderNumber, goTo, new BranchLogicTextGroup(coreCondition, values, operator != null ? BranchLogicExKt.toCoreOperator(operator) : null));
    }

    public static /* synthetic */ QuestionAnswered.Text toCoreTextAnswered$default(String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return toCoreTextAnswered(str, j);
    }

    public static final QuestionAnswered.Text toCoreTextAnswered(String str, long j) {
        if (str == null) {
            str = "";
        }
        return new QuestionAnswered.Text(j, str);
    }
}
