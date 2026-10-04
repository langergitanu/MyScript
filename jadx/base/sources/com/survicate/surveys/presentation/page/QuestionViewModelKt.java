package com.survicate.surveys.presentation.page;

import com.survicate.surveys.entities.survey.questions.SurveyPointImage;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.presentation.widget.SurveyPointImageBindingData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¨\u0006\t"}, m1599d2 = {"create", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData$Factory;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "showAnswerRequiredLabel", "", "pointImage", "Lcom/survicate/surveys/entities/survey/questions/SurveyPointImage;", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class QuestionViewModelKt {
    public static final QuestionHeaderBindingData create(QuestionHeaderBindingData.Companion companion, ResolvedQuestionTexts resolvedTexts, boolean z, SurveyPointImage surveyPointImage) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        return new QuestionHeaderBindingData(resolvedTexts.getIntroduction(), resolvedTexts.getTitle(), resolvedTexts.getAnswerRequiredLabel(), z, new SurveyPointImageBindingData(surveyPointImage));
    }
}
