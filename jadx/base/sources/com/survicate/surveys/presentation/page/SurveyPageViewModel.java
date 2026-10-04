package com.survicate.surveys.presentation.page;

import android.app.Activity;
import android.content.Context;
import androidx.core.os.BundleKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.entities.models.QuestionValidationState;
import com.survicate.surveys.entities.survey.SurveyMessages;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettings;
import com.survicate.surveys.entities.survey.questions.DisclaimerSettingsKt;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.ButtonLinkCtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.CtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.base.SurveyViewModel;
import com.survicate.surveys.presentation.page.SurveyPageAnswer;
import com.survicate.surveys.presentation.page.SurveyPageView;
import com.survicate.surveys.utils.FeatureFlags;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPageViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J\u0010\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010:\u001a\u00020;J\u000e\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\fJ\u000e\u0010@\u001a\u00020#2\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020#J\u0006\u0010D\u001a\u00020#J\u000e\u0010E\u001a\u00020#2\u0006\u0010F\u001a\u00020\u0012J\u0010\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020\nH\u0002J\u0006\u0010I\u001a\u00020#J\b\u0010J\u001a\u00020#H\u0002J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\nH\u0002J\b\u0010N\u001a\u00020\u001eH\u0002J\u0006\u0010O\u001a\u00020#J\u0006\u0010P\u001a\u00020#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020#\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u00100\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0014\u00102\u001a\u0002038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001c¨\u0006Q"}, m1599d2 = {"Lcom/survicate/surveys/presentation/page/SurveyPageViewModel;", "", "surveyViewModel", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "pageConfiguration", "Lcom/survicate/surveys/presentation/page/SurveyPageConfiguration;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "questionViewModels", "", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "currentLanguageCode", "", "surveyMessages", "Lcom/survicate/surveys/entities/survey/SurveyMessages;", "disclaimerSettings", "Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;", "initialDisclaimerAccepted", "", "<init>", "(Lcom/survicate/surveys/presentation/base/SurveyViewModel;Lcom/survicate/surveys/presentation/page/SurveyPageConfiguration;Lcom/survicate/surveys/helpers/ViewDependencies;Ljava/util/List;Ljava/lang/String;Lcom/survicate/surveys/entities/survey/SurveyMessages;Lcom/survicate/surveys/entities/survey/questions/DisclaimerSettings;Z)V", "getViewDependencies", "()Lcom/survicate/surveys/helpers/ViewDependencies;", "getQuestionViewModels", "()Ljava/util/List;", "getCurrentLanguageCode", "()Ljava/lang/String;", "isFullScreen", "()Z", "validationState", "Lcom/survicate/surveys/entities/models/QuestionValidationState;", "getValidationState", "()Lcom/survicate/surveys/entities/models/QuestionValidationState;", "onValidationChanged", "Lkotlin/Function0;", "", "getOnValidationChanged", "()Lkotlin/jvm/functions/Function0;", "setOnValidationChanged", "(Lkotlin/jvm/functions/Function0;)V", "onOpenLinkRequested", "Lkotlin/Function1;", "Lcom/survicate/surveys/entities/survey/questions/cta/ButtonLinkCtaSettings;", "getOnOpenLinkRequested", "()Lkotlin/jvm/functions/Function1;", "setOnOpenLinkRequested", "(Lkotlin/jvm/functions/Function1;)V", "value", "disclaimerAccepted", "getDisclaimerAccepted", "firstPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "getFirstPoint", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "hasMultipleQuestions", "getHasMultipleQuestions", "getBindingData", "Lcom/survicate/surveys/presentation/page/SurveyPageView$BindingData;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "getSurveyTheme", "Lcom/survicate/surveys/entities/survey/theme/Theme;", "onLanguageSelected", "langCode", "onPoweredByClick", "activity", "Landroid/app/Activity;", "onBack", "onSurveyClosed", "onDisclaimerToggle", "accepted", "tryAutoSubmit", "questionViewModel", "onSubmit", "submitPageAnswer", "buildPointAnswer", "Lcom/survicate/surveys/presentation/page/SurveyPageAnswer$PointAnswer;", "questionVm", "computeValidationState", "savePageState", "dispose", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyPageViewModel {
    private final String currentLanguageCode;
    private boolean disclaimerAccepted;
    private final DisclaimerSettings disclaimerSettings;
    private Function1<? super ButtonLinkCtaSettings, Unit> onOpenLinkRequested;
    private Function0<Unit> onValidationChanged;
    private final SurveyPageConfiguration pageConfiguration;
    private final List<QuestionViewModel> questionViewModels;
    private final SurveyMessages surveyMessages;
    private final SurveyViewModel surveyViewModel;
    private final ViewDependencies viewDependencies;

    /* JADX WARN: Multi-variable type inference failed */
    public SurveyPageViewModel(SurveyViewModel surveyViewModel, SurveyPageConfiguration pageConfiguration, ViewDependencies viewDependencies, List<? extends QuestionViewModel> questionViewModels, String str, SurveyMessages surveyMessages, DisclaimerSettings disclaimerSettings, boolean z) {
        Intrinsics.checkNotNullParameter(surveyViewModel, "surveyViewModel");
        Intrinsics.checkNotNullParameter(pageConfiguration, "pageConfiguration");
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(questionViewModels, "questionViewModels");
        Intrinsics.checkNotNullParameter(surveyMessages, "surveyMessages");
        this.surveyViewModel = surveyViewModel;
        this.pageConfiguration = pageConfiguration;
        this.viewDependencies = viewDependencies;
        this.questionViewModels = questionViewModels;
        this.currentLanguageCode = str;
        this.surveyMessages = surveyMessages;
        this.disclaimerSettings = disclaimerSettings;
        this.disclaimerAccepted = z;
        for (final QuestionViewModel questionViewModel : questionViewModels) {
            questionViewModel.setOnValidationChanged(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageViewModel._init_$lambda$0(this.f$0);
                }
            });
            questionViewModel.setOnAutoSubmitRequested(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageViewModel$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SurveyPageViewModel._init_$lambda$1(this.f$0, questionViewModel);
                }
            });
            if (questionViewModel instanceof SubmitInterceptingQuestion) {
                ((SubmitInterceptingQuestion) questionViewModel).setOnSubmitRequested(new Function0() { // from class: com.survicate.surveys.presentation.page.SurveyPageViewModel$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SurveyPageViewModel._init_$lambda$2(this.f$0);
                    }
                });
            }
        }
    }

    public /* synthetic */ SurveyPageViewModel(SurveyViewModel surveyViewModel, SurveyPageConfiguration surveyPageConfiguration, ViewDependencies viewDependencies, List list, String str, SurveyMessages surveyMessages, DisclaimerSettings disclaimerSettings, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(surveyViewModel, surveyPageConfiguration, viewDependencies, list, str, surveyMessages, disclaimerSettings, (i & 128) != 0 ? false : z);
    }

    public final ViewDependencies getViewDependencies() {
        return this.viewDependencies;
    }

    public final List<QuestionViewModel> getQuestionViewModels() {
        return this.questionViewModels;
    }

    public final String getCurrentLanguageCode() {
        return this.currentLanguageCode;
    }

    public final boolean isFullScreen() {
        return this.pageConfiguration.isFullScreen();
    }

    public final QuestionValidationState getValidationState() {
        return computeValidationState();
    }

    public final Function0<Unit> getOnValidationChanged() {
        return this.onValidationChanged;
    }

    public final void setOnValidationChanged(Function0<Unit> function0) {
        this.onValidationChanged = function0;
    }

    public final Function1<ButtonLinkCtaSettings, Unit> getOnOpenLinkRequested() {
        return this.onOpenLinkRequested;
    }

    public final void setOnOpenLinkRequested(Function1<? super ButtonLinkCtaSettings, Unit> function1) {
        this.onOpenLinkRequested = function1;
    }

    public final boolean getDisclaimerAccepted() {
        return this.disclaimerAccepted;
    }

    private final SurveyPoint getFirstPoint() {
        return ((QuestionViewModel) CollectionsKt.first((List) this.questionViewModels)).getSurveyPoint();
    }

    private final boolean getHasMultipleQuestions() {
        return this.questionViewModels.size() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(SurveyPageViewModel surveyPageViewModel) {
        Function0<Unit> function0 = surveyPageViewModel.onValidationChanged;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(SurveyPageViewModel surveyPageViewModel, QuestionViewModel questionViewModel) {
        surveyPageViewModel.tryAutoSubmit(questionViewModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(SurveyPageViewModel surveyPageViewModel) {
        surveyPageViewModel.submitPageAnswer();
        return Unit.INSTANCE;
    }

    public final SurveyPageView.BindingData getBindingData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SurveyPageView.BindingData(this.surveyViewModel.getSurveyHeaderBindingData(context, getFirstPoint(), this.currentLanguageCode), this.surveyViewModel.getSubmitViewConfiguration$survicate_sdk_release(context, getFirstPoint(), this.surveyMessages, getHasMultipleQuestions()), this.pageConfiguration.isFooterVisible(), isFullScreen(), this.questionViewModels, this.disclaimerSettings, this.disclaimerAccepted);
    }

    public final Theme getSurveyTheme(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.surveyViewModel.getSurveyTheme(context);
    }

    public final void onLanguageSelected(String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        this.surveyViewModel.onLanguageSelected(langCode);
    }

    public final void onPoweredByClick(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.surveyViewModel.onPoweredByClick(activity);
    }

    public final void onBack() {
        this.surveyViewModel.onPageBack();
    }

    public final void onSurveyClosed() {
        this.surveyViewModel.onSurveyClosed();
    }

    public final void onDisclaimerToggle(boolean accepted) {
        this.disclaimerAccepted = accepted;
        Function0<Unit> function0 = this.onValidationChanged;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void tryAutoSubmit(QuestionViewModel questionViewModel) {
        if (!getHasMultipleQuestions() && questionViewModel.getSurveyPoint().isMandatory()) {
            DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
            if (disclaimerSettings == null || !disclaimerSettings.getCheckboxVisible()) {
                boolean z = this.pageConfiguration.isFirstSurveyPoint() && !this.surveyViewModel.wasQuestionAlreadySubmitted(questionViewModel.getSurveyPoint());
                if (!this.pageConfiguration.getHasNavigationButtons() || z) {
                    onSubmit();
                }
            }
        }
    }

    public final void onSubmit() {
        if (getValidationState().isSuccess()) {
            QuestionViewModel questionViewModel = (QuestionViewModel) CollectionsKt.singleOrNull((List) this.questionViewModels);
            if ((questionViewModel instanceof SubmitInterceptingQuestion) && ((SubmitInterceptingQuestion) questionViewModel).interceptSubmit()) {
                return;
            }
            submitPageAnswer();
        }
    }

    private final void submitPageAnswer() {
        Function1<? super ButtonLinkCtaSettings, Unit> function1;
        if (getValidationState().isSuccess()) {
            List<QuestionViewModel> list = this.questionViewModels;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(buildPointAnswer((QuestionViewModel) it.next()));
            }
            ArrayList arrayList2 = arrayList;
            DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
            this.surveyViewModel.onPageSubmit$survicate_sdk_release(new SurveyPageAnswer(arrayList2, disclaimerSettings != null ? DisclaimerSettingsKt.getCheckboxStateToSend(disclaimerSettings, this.disclaimerAccepted) : null));
            SurveyPoint firstPoint = getFirstPoint();
            SurveyCtaSurveyPoint surveyCtaSurveyPoint = firstPoint instanceof SurveyCtaSurveyPoint ? (SurveyCtaSurveyPoint) firstPoint : null;
            CtaSettings ctaSettings = surveyCtaSurveyPoint != null ? surveyCtaSurveyPoint.getCtaSettings() : null;
            ButtonLinkCtaSettings buttonLinkCtaSettings = ctaSettings instanceof ButtonLinkCtaSettings ? (ButtonLinkCtaSettings) ctaSettings : null;
            if (FeatureFlags.INSTANCE.isMultipleQuestionsPerPageEnabled() || buttonLinkCtaSettings == null || (function1 = this.onOpenLinkRequested) == null) {
                return;
            }
            function1.invoke(buttonLinkCtaSettings);
        }
    }

    private final SurveyPageAnswer.PointAnswer buildPointAnswer(QuestionViewModel questionVm) {
        List<SurveyAnswer> answer = questionVm.getAnswer();
        if (answer.isEmpty()) {
            answer = CollectionsKt.listOf(new SurveyAnswer(null, null, null, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, 4095, null));
        }
        return new SurveyPageAnswer.PointAnswer(questionVm.getPointId(), answer);
    }

    private final QuestionValidationState computeValidationState() {
        boolean z;
        DisclaimerSettings disclaimerSettings = this.disclaimerSettings;
        boolean z2 = false;
        boolean z3 = disclaimerSettings == null || !disclaimerSettings.getCheckboxVisible() || !this.disclaimerSettings.getCheckboxRequired() || this.disclaimerAccepted;
        if (getHasMultipleQuestions()) {
            List<QuestionViewModel> list = this.questionViewModels;
            if ((list instanceof Collection) && list.isEmpty()) {
                z = true;
            } else {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!((QuestionViewModel) it.next()).getValidationState().isSuccess()) {
                        z = false;
                        break;
                    }
                }
                z = true;
            }
            return new QuestionValidationState(z && z3, false);
        }
        QuestionValidationState validationState = ((QuestionViewModel) CollectionsKt.first((List) this.questionViewModels)).getValidationState();
        DisclaimerSettings disclaimerSettings2 = this.disclaimerSettings;
        boolean z4 = disclaimerSettings2 != null && disclaimerSettings2.getCheckboxVisible();
        boolean z5 = validationState.isSuccess() && z3;
        if (validationState.getHideDefaultSubmitButton() && !z4) {
            z2 = true;
        }
        return new QuestionValidationState(z5, z2);
    }

    public final void savePageState() {
        for (QuestionViewModel questionViewModel : this.questionViewModels) {
            this.surveyViewModel.savePointState(questionViewModel.getPointId(), questionViewModel.toSavedState());
        }
        if (this.disclaimerSettings != null) {
            this.surveyViewModel.savePageState(getFirstPoint().getId(), BundleKt.bundleOf(TuplesKt.m1606to(SurveyViewModel.KEY_DISCLAIMER_ACCEPTED, Boolean.valueOf(this.disclaimerAccepted))));
        }
    }

    public final void dispose() {
        for (QuestionViewModel questionViewModel : this.questionViewModels) {
            if (questionViewModel instanceof DisposableQuestion) {
                ((DisposableQuestion) questionViewModel).dispose();
            }
        }
    }
}
