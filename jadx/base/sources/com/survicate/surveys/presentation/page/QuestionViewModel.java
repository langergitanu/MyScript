package com.survicate.surveys.presentation.page;

import android.os.Bundle;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: QuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J\b\u0010\u001f\u001a\u00020 H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006!"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "getAnswer", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "toSavedState", "Landroid/os/Bundle;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface QuestionViewModel {
    List<SurveyAnswer> getAnswer();

    SurveyAnswerType getAnswerType();

    Function0<Unit> getOnAutoSubmitRequested();

    Function0<Unit> getOnValidationChanged();

    long getPointId();

    SurveyPoint getSurveyPoint();

    QuestionValidationState getValidationState();

    void setOnAutoSubmitRequested(Function0<Unit> function0);

    void setOnValidationChanged(Function0<Unit> function0);

    Bundle toSavedState();
}
