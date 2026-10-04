package com.survicate.surveys.presentation.date;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionPointSettings;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.date.SurveyPointDateSettings;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.date.micro.MicroSurveyPointDateContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModelKt;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import com.survicate.surveys.utils.QuestionValidationStateBuilder;
import com.survicate.surveys.utils.SurvicateLocalDate;
import com.survicate.surveys.utils.SurvicateLocalDateFormatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DateQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u00108\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0006\u00109\u001a\u00020\u001cJ\u000e\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020\u0007J\u000e\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u000207J\b\u0010>\u001a\u00020\u0017H\u0002J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@H\u0016J\b\u0010B\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R(\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010'\"\u0004\b,\u0010)R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00101\u001a\u0002028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, m1599d2 = {"Lcom/survicate/surveys/presentation/date/DateQuestionViewModel;", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "initialDate", "Lcom/survicate/surveys/utils/SurvicateLocalDate;", "savedState", "Landroid/os/Bundle;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;Lcom/survicate/surveys/utils/SurvicateLocalDate;Landroid/os/Bundle;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "onShowDatePickerRequested", "Lkotlin/Function1;", "getOnShowDatePickerRequested", "()Lkotlin/jvm/functions/Function1;", "setOnShowDatePickerRequested", "(Lkotlin/jvm/functions/Function1;)V", "onSelectedDateChanged", "getOnSelectedDateChanged", "setOnSelectedDateChanged", "bindingData", "Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView$BindingData;", "getBindingData", "()Lcom/survicate/surveys/presentation/date/micro/MicroSurveyPointDateContentView$BindingData;", "settings", "Lcom/survicate/surveys/entities/survey/questions/question/date/SurveyPointDateSettings;", "getSettings", "()Lcom/survicate/surveys/entities/survey/questions/question/date/SurveyPointDateSettings;", "selectedDate", "commentText", "", "restoreFromSavedState", "onSelectDate", "onDateSelected", QuestionSurveyAnswerType.DATE, "onCommentChanged", "text", "computeValidationState", "getAnswer", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "toSavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DateQuestionViewModel implements QuestionViewModel {
    private final SurveyAnswerType answerType;
    private String commentText;
    private final SurvicateLocalDate initialDate;
    private Function0<Unit> onAutoSubmitRequested;
    private Function1<? super SurvicateLocalDate, Unit> onSelectedDateChanged;
    private Function1<? super SurvicateLocalDate, Unit> onShowDatePickerRequested;
    private Function0<Unit> onValidationChanged;
    private final long pointId;
    private final ResolvedQuestionTexts resolvedTexts;
    private SurvicateLocalDate selectedDate;
    private final SurveyQuestionSurveyPoint surveyPoint;

    public DateQuestionViewModel(SurveyQuestionSurveyPoint surveyPoint, ResolvedQuestionTexts resolvedTexts, SurvicateLocalDate initialDate, Bundle bundle) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        Intrinsics.checkNotNullParameter(initialDate, "initialDate");
        this.surveyPoint = surveyPoint;
        this.resolvedTexts = resolvedTexts;
        this.initialDate = initialDate;
        this.pointId = getSurveyPoint().getId();
        this.answerType = SurveyAnswerType.DATE;
        this.selectedDate = initialDate;
        this.commentText = "";
        restoreFromSavedState(bundle);
    }

    public /* synthetic */ DateQuestionViewModel(SurveyQuestionSurveyPoint surveyQuestionSurveyPoint, ResolvedQuestionTexts resolvedQuestionTexts, SurvicateLocalDate survicateLocalDate, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(surveyQuestionSurveyPoint, resolvedQuestionTexts, survicateLocalDate, (i & 8) != 0 ? null : bundle);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public SurveyQuestionSurveyPoint getSurveyPoint() {
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

    public final Function1<SurvicateLocalDate, Unit> getOnShowDatePickerRequested() {
        return this.onShowDatePickerRequested;
    }

    public final void setOnShowDatePickerRequested(Function1<? super SurvicateLocalDate, Unit> function1) {
        this.onShowDatePickerRequested = function1;
    }

    public final Function1<SurvicateLocalDate, Unit> getOnSelectedDateChanged() {
        return this.onSelectedDateChanged;
    }

    public final void setOnSelectedDateChanged(Function1<? super SurvicateLocalDate, Unit> function1) {
        this.onSelectedDateChanged = function1;
    }

    public final MicroSurveyPointDateContentView.BindingData getBindingData() {
        return new MicroSurveyPointDateContentView.BindingData(getSurveyPoint(), QuestionViewModelKt.create(QuestionHeaderBindingData.INSTANCE, this.resolvedTexts, false, getSurveyPoint().getSurveyPointImage()), this.resolvedTexts.getCommentHint(), this.selectedDate);
    }

    private final SurveyPointDateSettings getSettings() {
        SurveyQuestionPointSettings settings = getSurveyPoint().getSettings();
        Intrinsics.checkNotNull(settings, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.date.SurveyPointDateSettings");
        return (SurveyPointDateSettings) settings;
    }

    public final void onSelectDate() {
        Function1<? super SurvicateLocalDate, Unit> function1 = this.onShowDatePickerRequested;
        if (function1 != null) {
            function1.invoke(this.selectedDate);
        }
    }

    public final void onDateSelected(SurvicateLocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.selectedDate = date;
        Function1<? super SurvicateLocalDate, Unit> function1 = this.onSelectedDateChanged;
        if (function1 != null) {
            function1.invoke(date);
        }
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
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
        return QuestionValidationStateBuilder.INSTANCE.buildDateValidationState(getSettings(), !StringsKt.isBlank(this.commentText));
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public List<SurveyAnswer> getAnswer() {
        String asRespondentDate = SurvicateLocalDateFormatter.INSTANCE.formatAsRespondentDate(this.selectedDate);
        String str = this.commentText;
        if (StringsKt.isBlank(str) || !getSettings().getAddComment()) {
            str = null;
        }
        SurveyAnswer surveyAnswer = new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
        surveyAnswer.setContent(asRespondentDate);
        surveyAnswer.setAnswer(asRespondentDate);
        surveyAnswer.setComment(str);
        return CollectionsKt.listOf(surveyAnswer);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Bundle toSavedState() {
        return BundleKt.bundleOf(TuplesKt.m1606to("SAVED_STATE", new MicroSurveyPointDateContentView.SavedState(this.selectedDate, this.commentText)));
    }

    private final void restoreFromSavedState(Bundle savedState) {
        Parcelable parcelable;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointDateContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                if (!(parcelable2 instanceof MicroSurveyPointDateContentView.SavedState)) {
                    parcelable2 = null;
                }
                parcelable = (MicroSurveyPointDateContentView.SavedState) parcelable2;
            }
            MicroSurveyPointDateContentView.SavedState savedState2 = (MicroSurveyPointDateContentView.SavedState) parcelable;
            if (savedState2 == null) {
                return;
            }
            this.selectedDate = savedState2.getSelectedDate();
            this.commentText = savedState2.getCommentFieldText();
        }
    }
}
