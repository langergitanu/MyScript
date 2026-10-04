package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.core.logic.branch.SingleChoiceBranchLogic;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicSingleChoiceCondition;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicSingleChoiceGroup;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.survey.surveyLogic.single.SurveyLogicSingleCondition;
import com.survicate.surveys.entities.survey.surveyLogic.single.SurveyPointSingleLogic;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicSingleEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicSingleChoiceCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/single/SurveyLogicSingleCondition;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/branch/SingleChoiceBranchLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/single/SurveyPointSingleLogic;", "toCoreSingleAnswered", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Single;", "", "pointId", "(Ljava/lang/Long;J)Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Single;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicSingleExKt {

    /* JADX INFO: compiled from: BranchLogicSingleEx.kt */
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

    public static final BranchLogicSingleChoiceCondition toCoreCondition(SurveyLogicSingleCondition surveyLogicSingleCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicSingleCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicSingleCondition.ordinal()];
        if (i == 1) {
            return BranchLogicSingleChoiceCondition.f2259IS;
        }
        if (i == 2) {
            return BranchLogicSingleChoiceCondition.IS_NOT;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return BranchLogicSingleChoiceCondition.HAS_ANY_VALUE;
    }

    public static final SingleChoiceBranchLogic toCoreLogic(SurveyPointSingleLogic surveyPointSingleLogic) {
        Intrinsics.checkNotNullParameter(surveyPointSingleLogic, "<this>");
        return new SingleChoiceBranchLogic(surveyPointSingleLogic.getOrderNumber(), surveyPointSingleLogic.getGoTo(), new BranchLogicSingleChoiceGroup(toCoreCondition(surveyPointSingleLogic.getCondition()), surveyPointSingleLogic.getValues()));
    }

    public static /* synthetic */ QuestionAnswered.Single toCoreSingleAnswered$default(Long l, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return toCoreSingleAnswered(l, j);
    }

    public static final QuestionAnswered.Single toCoreSingleAnswered(Long l, long j) {
        return new QuestionAnswered.Single(j, l);
    }
}
