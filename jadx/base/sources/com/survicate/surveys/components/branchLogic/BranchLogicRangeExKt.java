package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.core.logic.branch.RangeBranchLogic;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicRangeCondition;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicRangeGroup;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyLogicRangeCondition;
import com.survicate.surveys.entities.survey.surveyLogic.range.SurveyPointRangeLogic;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicRangeEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicRangeCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/range/SurveyLogicRangeCondition;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/branch/RangeBranchLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/range/SurveyPointRangeLogic;", "toCoreRangeAnswered", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Range;", "", "pointId", "(Ljava/lang/Long;J)Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Range;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicRangeExKt {

    /* JADX INFO: compiled from: BranchLogicRangeEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicRangeCondition.values().length];
            try {
                iArr[SurveyLogicRangeCondition.f2285IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicRangeCondition.IS_NOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicRangeCondition.IS_BETWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyLogicRangeCondition.HAS_ANY_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final BranchLogicRangeCondition toCoreCondition(SurveyLogicRangeCondition surveyLogicRangeCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicRangeCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicRangeCondition.ordinal()];
        if (i == 1) {
            return BranchLogicRangeCondition.f2258IS;
        }
        if (i == 2) {
            return BranchLogicRangeCondition.IS_NOT;
        }
        if (i == 3) {
            return BranchLogicRangeCondition.IS_BETWEEN;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return BranchLogicRangeCondition.HAS_ANY_VALUE;
    }

    public static final RangeBranchLogic toCoreLogic(SurveyPointRangeLogic surveyPointRangeLogic) {
        Intrinsics.checkNotNullParameter(surveyPointRangeLogic, "<this>");
        return new RangeBranchLogic(surveyPointRangeLogic.getOrderNumber(), surveyPointRangeLogic.getGoTo(), new BranchLogicRangeGroup(toCoreCondition(surveyPointRangeLogic.getCondition()), surveyPointRangeLogic.getValues()));
    }

    public static /* synthetic */ QuestionAnswered.Range toCoreRangeAnswered$default(Long l, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return toCoreRangeAnswered(l, j);
    }

    public static final QuestionAnswered.Range toCoreRangeAnswered(Long l, long j) {
        return new QuestionAnswered.Range(j, l);
    }
}
