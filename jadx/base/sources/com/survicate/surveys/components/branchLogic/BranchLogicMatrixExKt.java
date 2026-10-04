package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.core.logic.branch.MatrixBranchLogic;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicMatrixCondition;
import com.survicate.surveys.core.logic.branch.groups.BranchLogicMatrixGroup;
import com.survicate.surveys.core.logic.display.models.MatrixAnswer;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixCondition;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixGroup;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyPointMatrixLogic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicMatrixEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0000\u001a\u001d\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicMatrixCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicMatrixGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/branch/MatrixBranchLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyPointMatrixLogic;", "toCoreMatrixAnswered", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Matrix;", "Lcom/survicate/surveys/entities/models/MatrixAnswer;", "pointId", "", "toCoreMatrixAnswered-1MonJVE", "(Ljava/util/Map;J)Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered$Matrix;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicMatrixExKt {

    /* JADX INFO: compiled from: BranchLogicMatrixEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicMatrixCondition.values().length];
            try {
                iArr[SurveyLogicMatrixCondition.f2284IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicMatrixCondition.IS_NOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyLogicMatrixCondition.IS_BETWEEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyLogicMatrixCondition.HAS_ANY_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final BranchLogicMatrixCondition toCoreCondition(SurveyLogicMatrixCondition surveyLogicMatrixCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicMatrixCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicMatrixCondition.ordinal()];
        if (i == 1) {
            return BranchLogicMatrixCondition.f2257IS;
        }
        if (i == 2) {
            return BranchLogicMatrixCondition.IS_NOT;
        }
        if (i == 3) {
            return BranchLogicMatrixCondition.IS_BETWEEN;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return BranchLogicMatrixCondition.HAS_ANY_VALUE;
    }

    private static final BranchLogicMatrixGroup toCoreGroup(SurveyLogicMatrixGroup surveyLogicMatrixGroup) {
        BranchLogicMatrixCondition coreCondition = toCoreCondition(surveyLogicMatrixGroup.getCondition());
        List<Long> values = surveyLogicMatrixGroup.getValues();
        List<Long> answerIds = surveyLogicMatrixGroup.getAnswerIds();
        SurveyLogicOperator answerIdOperator = surveyLogicMatrixGroup.getAnswerIdOperator();
        return new BranchLogicMatrixGroup(coreCondition, values, answerIds, answerIdOperator != null ? BranchLogicExKt.toCoreOperator(answerIdOperator) : null);
    }

    public static final MatrixBranchLogic toCoreLogic(SurveyPointMatrixLogic surveyPointMatrixLogic) {
        Intrinsics.checkNotNullParameter(surveyPointMatrixLogic, "<this>");
        int orderNumber = surveyPointMatrixLogic.getOrderNumber();
        long goTo = surveyPointMatrixLogic.getGoTo();
        List<SurveyLogicMatrixGroup> groups = surveyPointMatrixLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((SurveyLogicMatrixGroup) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        SurveyLogicOperator groupOperator = surveyPointMatrixLogic.getGroupOperator();
        return new MatrixBranchLogic(orderNumber, goTo, arrayList2, groupOperator != null ? BranchLogicExKt.toCoreOperator(groupOperator) : null);
    }

    /* JADX INFO: renamed from: toCoreMatrixAnswered-1MonJVE$default, reason: not valid java name */
    public static /* synthetic */ QuestionAnswered.Matrix m14340toCoreMatrixAnswered1MonJVE$default(Map map, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return m14339toCoreMatrixAnswered1MonJVE(map, j);
    }

    /* JADX INFO: renamed from: toCoreMatrixAnswered-1MonJVE, reason: not valid java name */
    public static final QuestionAnswered.Matrix m14339toCoreMatrixAnswered1MonJVE(Map<Long, ? extends Long> toCoreMatrixAnswered, long j) {
        Intrinsics.checkNotNullParameter(toCoreMatrixAnswered, "$this$toCoreMatrixAnswered");
        Set<Map.Entry<Long, ? extends Long>> setEntrySet = toCoreMatrixAnswered.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            arrayList.add(new MatrixAnswer(((Number) entry.getKey()).longValue(), ((Number) entry.getValue()).longValue()));
        }
        return new QuestionAnswered.Matrix(j, arrayList);
    }
}
