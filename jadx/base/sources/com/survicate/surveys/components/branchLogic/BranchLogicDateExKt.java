package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.core.logic.branch.DateBranchLogic;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicDateCondition;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicDateGroup;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.survey.surveyLogic.date.SurveyLogicDateCondition;
import com.survicate.surveys.entities.survey.surveyLogic.date.SurveyPointDateLogic;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicDateEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicDateCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/date/SurveyLogicDateCondition;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/branch/DateBranchLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/date/SurveyPointDateLogic;", "toCoreDateAnswered", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Date;", "", "pointId", "", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicDateExKt {

    /* JADX INFO: compiled from: BranchLogicDateEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicDateCondition.values().length];
            try {
                iArr[SurveyLogicDateCondition.QUESTION_IS_ANSWERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicDateCondition.QUESTION_IS_NOT_ANSWERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicDateCondition.HAS_ANY_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final BranchLogicDateCondition toCoreCondition(SurveyLogicDateCondition surveyLogicDateCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicDateCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicDateCondition.ordinal()];
        if (i == 1) {
            return BranchLogicDateCondition.QUESTION_IS_ANSWERED;
        }
        if (i == 2) {
            return BranchLogicDateCondition.QUESTION_IS_NOT_ANSWERED;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return BranchLogicDateCondition.HAS_ANY_VALUE;
    }

    public static final DateBranchLogic toCoreLogic(SurveyPointDateLogic surveyPointDateLogic) {
        Intrinsics.checkNotNullParameter(surveyPointDateLogic, "<this>");
        return new DateBranchLogic(surveyPointDateLogic.getOrderNumber(), surveyPointDateLogic.getGoTo(), new BranchLogicDateGroup(toCoreCondition(surveyPointDateLogic.getCondition())));
    }

    public static /* synthetic */ QuestionAnswered.Date toCoreDateAnswered$default(String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return toCoreDateAnswered(str, j);
    }

    public static final QuestionAnswered.Date toCoreDateAnswered(String str, long j) {
        if (str == null) {
            str = "";
        }
        return new QuestionAnswered.Date(j, str);
    }
}
