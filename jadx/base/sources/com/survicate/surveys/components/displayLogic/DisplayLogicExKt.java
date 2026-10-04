package com.survicate.surveys.components.displayLogic;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.DisplayLogic;
import com.survicate.surveys.core.logic.display.models.QuestionSuggestion;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.surveyLogic.SurveyLogicOperator;
import com.survicate.surveys.entities.survey.surveyLogic.display.DateDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.FormDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.MatrixDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.MultipleChoiceDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.RangeDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.SingleChoiceDisplayLogic;
import com.survicate.surveys.entities.survey.surveyLogic.display.TextDisplayLogic;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicEx.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b¨\u0006\t"}, m1599d2 = {"toCoreOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "Lcom/survicate/surveys/entities/survey/surveyLogic/SurveyLogicOperator;", "toCoreLogic", "Lcom/survicate/surveys/core/logic/display/DisplayLogic;", "Lcom/survicate/surveys/entities/survey/surveyLogic/display/DisplayLogic;", "toQuestionSuggestion", "Lcom/survicate/surveys/core/logic/display/models/QuestionSuggestion;", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicExKt {

    /* JADX INFO: compiled from: DisplayLogicEx.kt */
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

    public static final DisplayLogic toCoreLogic(com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic displayLogic) {
        Intrinsics.checkNotNullParameter(displayLogic, "<this>");
        if (displayLogic instanceof TextDisplayLogic) {
            return DisplayLogicTextExKt.toCoreLogic((TextDisplayLogic) displayLogic);
        }
        if (displayLogic instanceof DateDisplayLogic) {
            return DisplayLogicDateExKt.toCoreLogic((DateDisplayLogic) displayLogic);
        }
        if (displayLogic instanceof RangeDisplayLogic) {
            return DisplayLogicRangeExKt.toCoreLogic((RangeDisplayLogic) displayLogic);
        }
        if (displayLogic instanceof SingleChoiceDisplayLogic) {
            return DisplayLogicSingleExKt.toCoreLogic((SingleChoiceDisplayLogic) displayLogic);
        }
        if (displayLogic instanceof MultipleChoiceDisplayLogic) {
            return DisplayLogicMultipleExKt.toCoreLogic((MultipleChoiceDisplayLogic) displayLogic);
        }
        if (displayLogic instanceof MatrixDisplayLogic) {
            return DisplayLogicMatrixExKt.toCoreLogic((MatrixDisplayLogic) displayLogic);
        }
        if (displayLogic instanceof FormDisplayLogic) {
            return DisplayLogicFormExKt.toCoreLogic((FormDisplayLogic) displayLogic);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final QuestionSuggestion toQuestionSuggestion(SurveyPoint surveyPoint) {
        AndOrOperator coreOperator;
        AndOrOperator coreOperator2;
        AndOrOperator coreOperator3;
        AndOrOperator coreOperator4;
        Intrinsics.checkNotNullParameter(surveyPoint, "<this>");
        if (surveyPoint instanceof SurveyCtaSurveyPoint) {
            SurveyCtaSurveyPoint surveyCtaSurveyPoint = (SurveyCtaSurveyPoint) surveyPoint;
            long id = surveyCtaSurveyPoint.getId();
            SurveyLogicOperator displayLogicOperator = surveyCtaSurveyPoint.getCtaSettings().getDisplayLogicOperator();
            if (displayLogicOperator == null || (coreOperator4 = toCoreOperator(displayLogicOperator)) == null) {
                coreOperator4 = AndOrOperator.AND;
            }
            List<com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic> displayLogic = surveyCtaSurveyPoint.getCtaSettings().getDisplayLogic();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(displayLogic, 10));
            Iterator<T> it = displayLogic.iterator();
            while (it.hasNext()) {
                arrayList.add(toCoreLogic((com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic) it.next()));
            }
            return new QuestionSuggestion(id, coreOperator4, arrayList);
        }
        if (surveyPoint instanceof SurveyFormSurveyPoint) {
            SurveyFormSurveyPoint surveyFormSurveyPoint = (SurveyFormSurveyPoint) surveyPoint;
            long id2 = surveyFormSurveyPoint.getId();
            SurveyLogicOperator displayLogicOperator2 = surveyFormSurveyPoint.getSettings().getDisplayLogicOperator();
            if (displayLogicOperator2 == null || (coreOperator3 = toCoreOperator(displayLogicOperator2)) == null) {
                coreOperator3 = AndOrOperator.AND;
            }
            List<com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic> displayLogic2 = surveyFormSurveyPoint.getSettings().getDisplayLogic();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(displayLogic2, 10));
            Iterator<T> it2 = displayLogic2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(toCoreLogic((com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic) it2.next()));
            }
            return new QuestionSuggestion(id2, coreOperator3, arrayList2);
        }
        if (surveyPoint instanceof SurveyNpsSurveyPoint) {
            SurveyNpsSurveyPoint surveyNpsSurveyPoint = (SurveyNpsSurveyPoint) surveyPoint;
            long id3 = surveyNpsSurveyPoint.getId();
            SurveyLogicOperator displayLogicOperator3 = surveyNpsSurveyPoint.getSettings().getDisplayLogicOperator();
            if (displayLogicOperator3 == null || (coreOperator2 = toCoreOperator(displayLogicOperator3)) == null) {
                coreOperator2 = AndOrOperator.AND;
            }
            List<com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic> displayLogic3 = surveyNpsSurveyPoint.getSettings().getDisplayLogic();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(displayLogic3, 10));
            Iterator<T> it3 = displayLogic3.iterator();
            while (it3.hasNext()) {
                arrayList3.add(toCoreLogic((com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic) it3.next()));
            }
            return new QuestionSuggestion(id3, coreOperator2, arrayList3);
        }
        if (surveyPoint instanceof SurveyQuestionSurveyPoint) {
            SurveyQuestionSurveyPoint surveyQuestionSurveyPoint = (SurveyQuestionSurveyPoint) surveyPoint;
            long id4 = surveyQuestionSurveyPoint.getId();
            SurveyLogicOperator displayLogicOperator4 = surveyQuestionSurveyPoint.getSettings().getDisplayLogicOperator();
            if (displayLogicOperator4 == null || (coreOperator = toCoreOperator(displayLogicOperator4)) == null) {
                coreOperator = AndOrOperator.AND;
            }
            List<com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic> displayLogic4 = surveyQuestionSurveyPoint.getSettings().getDisplayLogic();
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(displayLogic4, 10));
            Iterator<T> it4 = displayLogic4.iterator();
            while (it4.hasNext()) {
                arrayList4.add(toCoreLogic((com.survicate.surveys.entities.survey.surveyLogic.display.DisplayLogic) it4.next()));
            }
            return new QuestionSuggestion(id4, coreOperator, arrayList4);
        }
        throw new IllegalArgumentException("Unsupported survey point");
    }
}
