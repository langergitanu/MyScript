package com.survicate.surveys.presentation.form;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormField;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.form.micro.MicroSurveyPointFormContentView;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModelKt;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.page.SubmitInterceptingQuestion;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.utils.QuestionValidationStateBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FormQuestionViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002000/2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u000200J\b\u00105\u001a\u00020'H\u0016J\b\u00106\u001a\u00020\u0016H\u0002J\b\u00107\u001a\u00020'H\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0016J\b\u0010;\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR\u0011\u0010*\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, m1599d2 = {"Lcom/survicate/surveys/presentation/form/FormQuestionViewModel;", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "Lcom/survicate/surveys/presentation/page/SubmitInterceptingQuestion;", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "resolvedTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "savedState", "Landroid/os/Bundle;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;Landroid/os/Bundle;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/form/SurveyFormSurveyPoint;", "pointId", "", "getPointId", "()J", "answerType", "Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "getAnswerType", "()Lcom/survicate/surveys/entities/survey/SurveyAnswerType;", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onAutoSubmitRequested", "getOnAutoSubmitRequested", "setOnAutoSubmitRequested", "onSubmitRequested", "getOnSubmitRequested", "setOnSubmitRequested", "onValidateFieldsRequested", "", "getOnValidateFieldsRequested", "setOnValidateFieldsRequested", "bindingData", "Lcom/survicate/surveys/presentation/form/micro/MicroSurveyPointFormContentView$BindingData;", "getBindingData", "()Lcom/survicate/surveys/presentation/form/micro/MicroSurveyPointFormContentView$BindingData;", "fieldValues", "", "", "restoreFieldValues", "onFieldInputChanged", "fieldId", "value", "interceptSubmit", "computeValidationState", "areRequiredFieldsFilled", "getAnswer", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "toSavedState", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FormQuestionViewModel implements QuestionViewModel, SubmitInterceptingQuestion {
    private final SurveyAnswerType answerType;
    private final Map<Long, String> fieldValues;
    private Function0<Unit> onAutoSubmitRequested;
    private Function0<Unit> onSubmitRequested;
    private Function0<Boolean> onValidateFieldsRequested;
    private Function0<Unit> onValidationChanged;
    private final long pointId;
    private final ResolvedQuestionTexts resolvedTexts;
    private final SurveyFormSurveyPoint surveyPoint;

    public FormQuestionViewModel(SurveyFormSurveyPoint surveyPoint, ResolvedQuestionTexts resolvedTexts, Bundle bundle) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(resolvedTexts, "resolvedTexts");
        this.surveyPoint = surveyPoint;
        this.resolvedTexts = resolvedTexts;
        this.pointId = getSurveyPoint().getId();
        this.answerType = SurveyAnswerType.FORM;
        this.fieldValues = restoreFieldValues(bundle);
    }

    public /* synthetic */ FormQuestionViewModel(SurveyFormSurveyPoint surveyFormSurveyPoint, ResolvedQuestionTexts resolvedQuestionTexts, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(surveyFormSurveyPoint, resolvedQuestionTexts, (i & 4) != 0 ? null : bundle);
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public SurveyFormSurveyPoint getSurveyPoint() {
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

    @Override // com.survicate.surveys.presentation.page.SubmitInterceptingQuestion
    public Function0<Unit> getOnSubmitRequested() {
        return this.onSubmitRequested;
    }

    @Override // com.survicate.surveys.presentation.page.SubmitInterceptingQuestion
    public void setOnSubmitRequested(Function0<Unit> function0) {
        this.onSubmitRequested = function0;
    }

    public final Function0<Boolean> getOnValidateFieldsRequested() {
        return this.onValidateFieldsRequested;
    }

    public final void setOnValidateFieldsRequested(Function0<Boolean> function0) {
        this.onValidateFieldsRequested = function0;
    }

    public final MicroSurveyPointFormContentView.BindingData getBindingData() {
        return new MicroSurveyPointFormContentView.BindingData(getSurveyPoint(), QuestionViewModelKt.create(QuestionHeaderBindingData.INSTANCE, this.resolvedTexts, getSurveyPoint().isMandatory(), getSurveyPoint().getSurveyPointImage()));
    }

    public final void onFieldInputChanged(long fieldId, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.fieldValues.put(Long.valueOf(fieldId), value);
        Function0<Unit> onValidationChanged = getOnValidationChanged();
        if (onValidationChanged != null) {
            onValidationChanged.invoke();
        }
    }

    @Override // com.survicate.surveys.presentation.page.SubmitInterceptingQuestion
    public boolean interceptSubmit() {
        return !(this.onValidateFieldsRequested != null ? r0.invoke().booleanValue() : true);
    }

    private final QuestionValidationState computeValidationState() {
        return QuestionValidationStateBuilder.INSTANCE.buildFormValidationState(areRequiredFieldsFilled());
    }

    private final boolean areRequiredFieldsFilled() {
        List<SurveyFormField> fields = getSurveyPoint().getFields();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fields) {
            if (((SurveyFormField) obj).getRequired()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return true;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            if (this.fieldValues.get(Long.valueOf(((SurveyFormField) it.next()).getId())) == null || !(!StringsKt.isBlank(r1))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public List<SurveyAnswer> getAnswer() {
        List<SurveyFormField> fields = getSurveyPoint().getFields();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fields, 10));
        for (SurveyFormField surveyFormField : fields) {
            SurveyAnswer surveyAnswer = new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null);
            surveyAnswer.setAnswerType(surveyFormField.getFieldType());
            String str = this.fieldValues.get(Long.valueOf(surveyFormField.getId()));
            if (str == null) {
                str = "";
            }
            surveyAnswer.setContent(str);
            surveyAnswer.setAnswerId(Long.valueOf(surveyFormField.getId()));
            arrayList.add(surveyAnswer);
        }
        return arrayList;
    }

    @Override // com.survicate.surveys.presentation.page.QuestionViewModel
    public Bundle toSavedState() {
        List<SurveyFormField> fields = getSurveyPoint().getFields();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(fields, 10)), 16));
        for (SurveyFormField surveyFormField : fields) {
            Long lValueOf = Long.valueOf(surveyFormField.getId());
            String str = this.fieldValues.get(Long.valueOf(surveyFormField.getId()));
            if (str == null) {
                str = "";
            }
            Pair pairM1606to = TuplesKt.m1606to(lValueOf, str);
            linkedHashMap.put(pairM1606to.getFirst(), pairM1606to.getSecond());
        }
        return BundleKt.bundleOf(TuplesKt.m1606to("SAVED_STATE", new MicroSurveyPointFormContentView.SavedState(linkedHashMap)));
    }

    private final Map<Long, String> restoreFieldValues(Bundle savedState) {
        Map<Long, String> inputs;
        Map<Long, String> mutableMap;
        Parcelable parcelable;
        MicroSurveyPointFormContentView.SavedState savedState2 = null;
        if (savedState != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) savedState.getParcelable("SAVED_STATE", MicroSurveyPointFormContentView.SavedState.class);
            } else {
                Parcelable parcelable2 = savedState.getParcelable("SAVED_STATE");
                parcelable = (MicroSurveyPointFormContentView.SavedState) (parcelable2 instanceof MicroSurveyPointFormContentView.SavedState ? parcelable2 : null);
            }
            savedState2 = (MicroSurveyPointFormContentView.SavedState) parcelable;
        }
        return (savedState2 == null || (inputs = savedState2.getInputs()) == null || (mutableMap = MapsKt.toMutableMap(inputs)) == null) ? new LinkedHashMap() : mutableMap;
    }
}
