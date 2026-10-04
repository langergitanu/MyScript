package com.survicate.surveys.entities.survey.questions.question.rating;

import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import kotlin.Metadata;

/* JADX INFO: compiled from: SurveyPointRatingSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/questions/question/rating/SurveyPointRatingSettings;", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionPointSettings;", "isMandatory", "", "()Z", "isCommentMandatory", "()Ljava/lang/Boolean;", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "getDisclaimerSettings", "()Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurveyPointRatingSettings extends SurveyQuestionPointSettings {
    @Override // com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    DisclaimerSettings getDisclaimerSettings();

    Boolean isCommentMandatory();

    @Override // com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings
    boolean isMandatory();
}
