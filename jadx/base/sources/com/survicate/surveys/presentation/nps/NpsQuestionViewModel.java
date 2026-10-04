package com.survicate.surveys.presentation.nps;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.models.SurvicateNpsAnswerOption;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsPointSettings;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.nps.micro.MicroSurveyPointNpsContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModelKt;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.QuestionValidationStateBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NpsQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u00102\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020/J\u000e\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u000201J\b\u00107\u001a\u00020\u0015H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u0011\u0010\"\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, m1599d2 = {"Lcom/survicate/surveys/presentation/nps/NpsQuestionViewModel;", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "savedState", "Landroid/os/Bundle;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;Landroid/os/Bundle;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsSurveyPoint;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "bindingData", "Lcom/survicate/surveys/presentation/nps/micro/MicroSurveyPointNpsContentView$BindingData;", "getBindingData", "()Lcom/survicate/surveys/presentation/nps/micro/MicroSurveyPointNpsContentView$BindingData;", "canSubmitImmediately", "", "getCanSubmitImmediately", "()Z", "settings", "Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/nps/SurveyNpsPointSettings;", "selectedAnswer", "Lcom/survicate/surveys/entities/models/SurvicateNpsAnswerOption;", "commentText", "", "restoreFromSavedState", "onAnswerSelected", "option", "onCommentChanged", "text", "computeValidationState", "getAnswer", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "toSavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class NpsQuestionViewModel implements QuestionViewModel {
    private final SurveyAnswerType answerType;
    private String commentText;
    private Function0<Unit> onAutoSubmitRequested;
    private Function0<Unit> onValidationChanged;
    private final long pointId;
    private final ResolvedQuestionTexts resolvedTexts;
    private SurvicateNpsAnswerOption selectedAnswer;
    private final SurveyNpsSurveyPoint surveyPoint;

    public NpsQuestionViewModel(SurveyNpsSurveyPoint surveyPoint, ResolvedQuestionTexts resolvedTexts, Bundle bundle) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        this.surveyPoint = surveyPoint;
        this.resolvedTexts = resolvedTexts;
        this.pointId = getSurveyPoint().getId();
        this.answerType = SurveyAnswerType.NPS;
        this.commentText = "";
        restoreFromSavedState(bundle);
    }

    public /* synthetic */ NpsQuestionViewModel(SurveyNpsSurveyPoint surveyNpsSurveyPoint, ResolvedQuestionTexts resolvedQuestionTexts, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(surveyNpsSurveyPoint, resolvedQuestionTexts, (i & 4) != 0 ? null : bundle);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public SurveyNpsSurveyPoint getSurveyPoint() {
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
        return computeValidationState();
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

    public final MicroSurveyPointNpsContentView.BindingData getBindingData() {
        return new MicroSurveyPointNpsContentView.BindingData(getSurveyPoint(), QuestionViewModelKt.create(QuestionHeaderBindingData.INSTANCE, this.resolvedTexts, getSurveyPoint().isMandatory(), getSurveyPoint().getSurveyPointImage()), this.resolvedTexts.getCommentHint());
    }

    private final boolean getCanSubmitImmediately() {
        return !getSettings().getAddComment();
    }

    private final SurveyNpsPointSettings getSettings() {
        return getSurveyPoint().getSettings();
    }

    public final void onAnswerSelected(SurvicateNpsAnswerOption option) {
        Function0<Unit> onAutoSubmitRequested;
        Intrinsics.checkNotNullParameter(option, "option");
        this.selectedAnswer = option;
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
        if (!getCanSubmitImmediately() || (onAutoSubmitRequested = getOnAutoSubmitRequested()) == null) {
            return;
        }
        onAutoSubmitRequested.invoke();
    }

    public final void onCommentChanged(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.commentText = text;
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
    }

    private final QuestionValidationState computeValidationState() {
        return QuestionValidationStateBuilder.INSTANCE.buildNpsValidationState(getSettings(), this.selectedAnswer != null, true ^ StringsKt.isBlank(this.commentText));
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public List<SurveyAnswer> getAnswer() {
        SurvicateNpsAnswerOption survicateNpsAnswerOption = this.selectedAnswer;
        if (survicateNpsAnswerOption == null) {
            return CollectionsKt.emptyList();
        }
        String str = this.commentText;
        if (StringsKt.isBlank(str) || !getSettings().getAddComment()) {
            str = null;
        }
        SurveyAnswer surveyAnswer = new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
        surveyAnswer.setContent(String.valueOf(survicateNpsAnswerOption.getValue()));
        surveyAnswer.setAnswer(String.valueOf(survicateNpsAnswerOption.getValue()));
        surveyAnswer.setAnswerId(Long.valueOf(survicateNpsAnswerOption.getValue()));
        surveyAnswer.setComment(str);
        return CollectionsKt.listOf(surveyAnswer);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Bundle toSavedState() {
        return BundleKt.bundleOf(TuplesKt.m1606to("SAVED_STATE", new MicroSurveyPointNpsContentView.SavedState(this.selectedAnswer, this.commentText)));
    }

    private final void restoreFromSavedState(Bundle savedState) {
        Parcelable parcelable;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointNpsContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointNpsContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointNpsContentView.SavedState) parcelable2;
            }
            MicroSurveyPointNpsContentView.SavedState savedState2 = (MicroSurveyPointNpsContentView.SavedState) parcelable;
            if (savedState2 == null) {
                return;
            }
            this.selectedAnswer = savedState2.getSelectedAnswer();
            this.commentText = savedState2.getCommentFieldText();
        }
    }
}
