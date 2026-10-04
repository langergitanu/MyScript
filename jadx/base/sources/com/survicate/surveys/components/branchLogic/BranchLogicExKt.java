package com.survicate.surveys.components.branchLogic;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1599d2 = {"toCoreOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicExKt {

    /* JADX INFO: compiled from: BranchLogicEx.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyLogicOperator.values().length];
            try {
                iArr[SurveyLogicOperator.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyLogicOperator.f2283OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final AndOrOperator toCoreOperator(SurveyLogicOperator surveyLogicOperator) {
        Intrinsics.checkNotNullParameter(surveyLogicOperator, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[surveyLogicOperator.ordinal()];
        if (i == 1) {
            return AndOrOperator.AND;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return AndOrOperator.f2260OR;
    }
}
