package com.survicate.surveys.components.displayLogic;

import com.survicate.surveys.core.logic.display.MatrixDisplayLogic;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicMatrixGroup;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicMatrixGroupCondition;
import com.survicate.surveys.entities.survey.surveyLogic.display.MatrixDisplayLogicGroup;
import com.survicate.surveys.entities.survey.surveyLogic.matrix.SurveyLogicMatrixCondition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicMatrixEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, m1599d2 = {"toCoreCondition", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMatrixGroupCondition;", "Lcom/survicate/surveys/entities/survey/surveyLogic/matrix/SurveyLogicMatrixCondition;", "toCoreGroup", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicMatrixGroup;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/MatrixDisplayLogicGroup;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/display/MatrixDisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/MatrixDisplayLogic;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicMatrixExKt {

    /* JADX INFO: compiled from: DisplayLogicMatrixEx.kt */
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

    public static final DisplayLogicMatrixGroupCondition toCoreCondition(SurveyLogicMatrixCondition surveyLogicMatrixCondition) {
        Intrinsics.checkNotNullParameter(surveyLogicMatrixCondition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicMatrixCondition.ordinal()];
        if (i == 1) {
            return DisplayLogicMatrixGroupCondition.f2261IS;
        }
        if (i == 2) {
            return DisplayLogicMatrixGroupCondition.IS_NOT;
        }
        if (i == 3) {
            return DisplayLogicMatrixGroupCondition.IS_BETWEEN;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return DisplayLogicMatrixGroupCondition.HAS_ANY_VALUE;
    }

    private static final DisplayLogicMatrixGroup toCoreGroup(MatrixDisplayLogicGroup matrixDisplayLogicGroup) {
        return new DisplayLogicMatrixGroup(toCoreCondition(matrixDisplayLogicGroup.getCondition()), matrixDisplayLogicGroup.getValue(), matrixDisplayLogicGroup.getAnswerId(), DisplayLogicExKt.toCoreOperator(matrixDisplayLogicGroup.getAnswerIdOperator()));
    }

    public static final MatrixDisplayLogic toCoreLogic(com.survicate.surveys.entities.survey.surveyLogic.display.MatrixDisplayLogic matrixDisplayLogic) {
        Intrinsics.checkNotNullParameter(matrixDisplayLogic, "<this>");
        long pointId = matrixDisplayLogic.getPointId();
        List<MatrixDisplayLogicGroup> groups = matrixDisplayLogic.getGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(groups, 10));
        Iterator<T> it = groups.iterator();
        while (it.hasNext()) {
            arrayList.add(toCoreGroup((MatrixDisplayLogicGroup) it.next()));
        }
        return new MatrixDisplayLogic(pointId, arrayList, DisplayLogicExKt.toCoreOperator(matrixDisplayLogic.getGroupOperator()));
    }
}
