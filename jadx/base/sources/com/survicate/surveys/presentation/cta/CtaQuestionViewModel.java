package com.survicate.surveys.presentation.cta;

import android.os.Bundle;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.cta.micro.MicroSurveyPointCtaContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModelKt;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CtaQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\b\u0010'\u001a\u00020(H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006)"}, m1599d2 = {"Lcom/survicate/surveys/presentation/cta/CtaQuestionViewModel;", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "bindingData", "Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaContentView$BindingData;", "getBindingData", "()Lcom/survicate/surveys/presentation/cta/micro/MicroSurveyPointCtaContentView$BindingData;", "getAnswer", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "toSavedState", "Landroid/os/Bundle;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CtaQuestionViewModel implements QuestionViewModel {
    private final SurveyAnswerType answerType;
    private Function0<Unit> onAutoSubmitRequested;
    private Function0<Unit> onValidationChanged;
    private final long pointId;
    private final ResolvedQuestionTexts resolvedTexts;
    private final SurveyCtaSurveyPoint surveyPoint;
    private final QuestionValidationState validationState;

    public CtaQuestionViewModel(SurveyCtaSurveyPoint surveyPoint, ResolvedQuestionTexts resolvedTexts) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        this.surveyPoint = surveyPoint;
        this.resolvedTexts = resolvedTexts;
        this.pointId = getSurveyPoint().getId();
        SurveyAnswerType surveyAnswerTypeFromString = SurveyAnswerType.INSTANCE.fromString(getSurveyPoint().getAnswerType());
        if (surveyAnswerTypeFromString == null) {
            throw new IllegalStateException(("CTA survey point has an unsupported answer type: " + getSurveyPoint().getAnswerType()).toString());
        }
        this.answerType = surveyAnswerTypeFromString;
        this.validationState = new QuestionValidationState(true, false);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public SurveyCtaSurveyPoint getSurveyPoint() {
        return this.surveyPoint;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public long getPointId() {
        return this.pointId;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public SurveyAnswerType getAnswerType() {
        return this.answerType;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public QuestionValidationState getValidationState() {
        return this.validationState;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Function0<Unit> getOnValidationChanged() {
        return this.onValidationChanged;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public void setOnValidationChanged(Function0<Unit> function0) {
        this.onValidationChanged = function0;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Function0<Unit> getOnAutoSubmitRequested() {
        return this.onAutoSubmitRequested;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public void setOnAutoSubmitRequested(Function0<Unit> function0) {
        this.onAutoSubmitRequested = function0;
    }

    public final MicroSurveyPointCtaContentView.BindingData getBindingData() {
        return new MicroSurveyPointCtaContentView.BindingData(QuestionViewModelKt.create(QuestionHeaderBindingData.INSTANCE, this.resolvedTexts, false, getSurveyPoint().getSurveyPointImage()));
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public List<SurveyAnswer> getAnswer() {
        SurveyAnswer surveyAnswer = new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
        surveyAnswer.setCtaSuccess(true);
        return CollectionsKt.listOf(surveyAnswer);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Bundle toSavedState() {
        return new Bundle();
    }
}
