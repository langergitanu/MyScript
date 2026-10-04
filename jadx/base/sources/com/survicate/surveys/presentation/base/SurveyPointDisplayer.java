package com.survicate.surveys.presentation.base;

import android.app.Activity;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.AnswerDetails;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.entities.survey.Survey;
import com.survicate.surveys.entities.survey.SurveyMessages;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.ButtonLinkCtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.CtaSettings;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.entities.survey.theme.ThemeSettings;
import com.survicate.surveys.entities.survey.translations.SurveyPointTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.helpers.url.UrlBuilder;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionRepository;
import com.survicate.surveys.infrastructure.storage.survey.SurveyAnswerFactory;
import com.survicate.surveys.infrastructure.storage.survey.SurveyStore;
import com.survicate.surveys.presentation.base.micro.ButtonTextResolver;
import com.survicate.surveys.presentation.cta.CallToActionUtil;
import com.survicate.surveys.presentation.widget.QuestionHeaderBindingData;
import com.survicate.surveys.presentation.widget.SubmitViewConfiguration;
import com.survicate.surveys.presentation.widget.SurveyHeaderBindingData;
import com.survicate.surveys.presentation.widget.SurveyPointImageBindingData;
import com.survicate.surveys.surveys.QuestionSurveyAnswerType;
import com.survicate.surveys.utils.LocaleUtils;
import com.survicate.surveys.utils.OpenIntentsUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyPointDisplayer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H&J\u0016\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000200J\u0018\u0010;\u001a\u00020<2\u0006\u00108\u001a\u0002092\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u000200H\u0002J\u000e\u0010@\u001a\u0002072\u0006\u00108\u001a\u000209J\u001e\u0010A\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u000207J\u0010\u0010G\u001a\u0002072\b\u0010H\u001a\u0004\u0018\u00010IJ\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\u00020M2\u0006\u0010D\u001a\u00020EJ\u0006\u0010N\u001a\u00020OJ\b\u0010P\u001a\u00020QH\u0002J\u0015\u0010R\u001a\u00020S2\u0006\u0010D\u001a\u00020EH\u0000¢\u0006\u0002\bTJ\u0006\u0010U\u001a\u000200J\u000e\u0010V\u001a\u0002072\u0006\u0010W\u001a\u00020\u0015J\u0010\u0010X\u001a\u0002072\u0006\u0010W\u001a\u00020\u0015H\u0002J\u0012\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010W\u001a\u00020\u0015H\u0002R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0014\u0010\fR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020,X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006["}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/SurveyPointDisplayer;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "", "surveyPoint", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "surveyViewModel", "Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "<init>", "(Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;Lcom/survicate/surveys/presentation/base/DisplayEngine;Lcom/survicate/surveys/presentation/base/SurveyViewModel;)V", "getSurveyPoint", "()Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "getDisplayEngine", "()Lcom/survicate/surveys/presentation/base/DisplayEngine;", "getSurveyViewModel", "()Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "value", "translatedPoint", "getTranslatedPoint", "", "surveyLanguage", "getSurveyLanguage", "()Ljava/lang/String;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "getViewDependencies", "()Lcom/survicate/surveys/helpers/ViewDependencies;", "urlBuilder", "Lcom/survicate/surveys/helpers/url/UrlBuilder;", "surveyStore", "Lcom/survicate/surveys/infrastructure/storage/survey/SurveyStore;", "getSurveyStore", "()Lcom/survicate/surveys/infrastructure/storage/survey/SurveyStore;", "surveyAnswerFactory", "Lcom/survicate/surveys/infrastructure/storage/survey/SurveyAnswerFactory;", "getSurveyAnswerFactory", "()Lcom/survicate/surveys/infrastructure/storage/survey/SurveyAnswerFactory;", "followUpQuestionRepository", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;", "getFollowUpQuestionRepository", "()Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "getLogger", "()Lcom/survicate/surveys/core/logging/SdkLogger;", "isFirstQuestion", "", "resolveAnswerAction", "Lcom/survicate/surveys/presentation/base/SurveyAnswerAction;", "answers", "", "Lcom/survicate/surveys/infrastructure/network/SurveyAnswer;", "onSingleChoiceAnswerSelected", "", "viewAnswer", "Lcom/survicate/surveys/presentation/base/SurveyPointViewAnswer;", "canSubmitImmediately", "createAnswerDetails", "Lcom/survicate/surveys/AnswerDetails;", "survey", "Lcom/survicate/surveys/entities/survey/Survey;", "isFirstQuestionForFirstTime", "onQuestionSubmit", "onCtaSubmit", "ctaPoint", "Lcom/survicate/surveys/entities/survey/questions/cta/SurveyCtaSurveyPoint;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "onBackClick", "onPoweredByClick", "activity", "Landroid/app/Activity;", "getSurveyMessages", "Lcom/survicate/surveys/entities/survey/SurveyMessages;", "getSurveyHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;", "getQuestionHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/QuestionHeaderBindingData;", "getSurveyPointImageBindingData", "Lcom/survicate/surveys/presentation/widget/SurveyPointImageBindingData;", "getSubmitViewConfiguration", "Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "getSubmitViewConfiguration$survicate_sdk_release", "shouldDisplayAnswerRequiredLabel", "onLanguageSelected", "langCode", "translatePoint", "getSurveyTranslationFor", "Lcom/survicate/surveys/entities/survey/translations/SurveyTranslation;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class SurveyPointDisplayer<T extends SurveyPoint> {
    private final DisplayEngine displayEngine;
    private final FollowUpQuestionRepository followUpQuestionRepository;
    private final SdkLogger logger;
    private final SurveyAnswerFactory surveyAnswerFactory;
    private String surveyLanguage;
    private final T surveyPoint;
    private final SurveyStore surveyStore;
    private final SurveyViewModel surveyViewModel;
    private T translatedPoint;
    private final UrlBuilder urlBuilder;
    private final ViewDependencies viewDependencies;

    public abstract SurveyAnswerAction resolveAnswerAction(List<SurveyAnswer> answers);

    public SurveyPointDisplayer(T surveyPoint, DisplayEngine displayEngine, SurveyViewModel surveyViewModel) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(displayEngine, "displayEngine");
        Intrinsics.checkNotNullParameter(surveyViewModel, "surveyViewModel");
        this.surveyPoint = surveyPoint;
        this.displayEngine = displayEngine;
        this.surveyViewModel = surveyViewModel;
        this.translatedPoint = surveyPoint;
        this.surveyLanguage = displayEngine.getDefaultSurveyLanguage();
        this.viewDependencies = displayEngine.getViewDependencies();
        this.urlBuilder = displayEngine.getUrlBuilder();
        this.surveyStore = displayEngine.getSurveyStore();
        this.surveyAnswerFactory = displayEngine.getSurveyAnswerFactory();
        this.followUpQuestionRepository = displayEngine.getFollowUpQuestionRepository();
        this.logger = displayEngine.getLogger();
        displayEngine.setLayoutDirection(surveyViewModel.getLayoutDirection());
        translatePoint(surveyViewModel.getPreferredLanguage());
    }

    public final T getSurveyPoint() {
        return this.surveyPoint;
    }

    protected final DisplayEngine getDisplayEngine() {
        return this.displayEngine;
    }

    protected final SurveyViewModel getSurveyViewModel() {
        return this.surveyViewModel;
    }

    public final T getTranslatedPoint() {
        return this.translatedPoint;
    }

    public final String getSurveyLanguage() {
        return this.surveyLanguage;
    }

    public final ViewDependencies getViewDependencies() {
        return this.viewDependencies;
    }

    protected final SurveyStore getSurveyStore() {
        return this.surveyStore;
    }

    protected final SurveyAnswerFactory getSurveyAnswerFactory() {
        return this.surveyAnswerFactory;
    }

    protected final FollowUpQuestionRepository getFollowUpQuestionRepository() {
        return this.followUpQuestionRepository;
    }

    protected final SdkLogger getLogger() {
        return this.logger;
    }

    private final boolean isFirstQuestion() {
        return this.displayEngine.isFirstQuestion(this.surveyPoint);
    }

    public final void onSingleChoiceAnswerSelected(SurveyPointViewAnswer viewAnswer, boolean canSubmitImmediately) {
        Survey currentSurvey;
        Intrinsics.checkNotNullParameter(viewAnswer, "viewAnswer");
        if (canSubmitImmediately && this.surveyPoint.isMandatory()) {
            if ((!this.displayEngine.hasNavigationButtons() || isFirstQuestionForFirstTime()) && (currentSurvey = this.displayEngine.getCurrentSurvey()) != null) {
                this.displayEngine.questionAnswered(createAnswerDetails(viewAnswer, currentSurvey));
            }
        }
    }

    private final AnswerDetails createAnswerDetails(SurveyPointViewAnswer viewAnswer, Survey survey) {
        return new AnswerDetails(resolveAnswerAction(viewAnswer.getAnswers()), this.surveyPoint, survey, this.surveyLanguage, viewAnswer.getDisclaimerAccepted());
    }

    private final boolean isFirstQuestionForFirstTime() {
        return isFirstQuestion() && !this.displayEngine.wasQuestionAlreadySubmitted(this.surveyPoint);
    }

    public final void onQuestionSubmit(SurveyPointViewAnswer viewAnswer) {
        Intrinsics.checkNotNullParameter(viewAnswer, "viewAnswer");
        Survey currentSurvey = this.displayEngine.getCurrentSurvey();
        if (currentSurvey == null) {
            return;
        }
        this.displayEngine.questionAnswered(createAnswerDetails(viewAnswer, currentSurvey));
    }

    public final void onCtaSubmit(SurveyPointViewAnswer viewAnswer, SurveyCtaSurveyPoint ctaPoint, Context context) {
        Intrinsics.checkNotNullParameter(viewAnswer, "viewAnswer");
        Intrinsics.checkNotNullParameter(ctaPoint, "ctaPoint");
        Intrinsics.checkNotNullParameter(context, "context");
        Survey currentSurvey = this.displayEngine.getCurrentSurvey();
        if (currentSurvey == null) {
            return;
        }
        this.displayEngine.questionAnswered(createAnswerDetails(viewAnswer, currentSurvey));
        CtaSettings ctaSettings = ctaPoint.getCtaSettings();
        if (ctaSettings instanceof ButtonLinkCtaSettings) {
            CallToActionUtil.openCtaLink((ButtonLinkCtaSettings) ctaSettings, context);
        }
    }

    public final void onBackClick() {
        this.displayEngine.showPreviousQuestion();
    }

    public final void onPoweredByClick(Activity activity) {
        Survey currentSurvey;
        if (activity == null || (currentSurvey = this.displayEngine.getCurrentSurvey()) == null) {
            return;
        }
        OpenIntentsUtils.openLink(activity, this.urlBuilder.buildPoweredBySurvicateUrl(currentSurvey.getId()));
    }

    public final SurveyMessages getSurveyMessages() {
        SurveyMessages surveyMessages = this.displayEngine.getSurveyMessages();
        SurveyTranslation surveyTranslationFor = getSurveyTranslationFor(this.surveyViewModel.getPreferredLanguage());
        return surveyTranslationFor == null ? surveyMessages : surveyMessages.translatedWith(surveyTranslationFor.getSettings().getMessages());
    }

    public final SurveyHeaderBindingData getSurveyHeaderBindingData(Context context) {
        ThemeSettings themeSettingsEmpty;
        Intrinsics.checkNotNullParameter(context, "context");
        Theme surveyTheme = this.displayEngine.getSurveyTheme(context);
        if (surveyTheme == null || (themeSettingsEmpty = surveyTheme.getSettings()) == null) {
            themeSettingsEmpty = ThemeSettings.INSTANCE.empty();
        }
        return new SurveyHeaderBindingData(themeSettingsEmpty, this.displayEngine.getViewDependencies().getImageLoader(), this.displayEngine.shouldShowProgressBar(), this.displayEngine.getSurveyProgressInPercents(this.surveyPoint), this.displayEngine.shouldShowLanguageSelector(), this.displayEngine.getAvailableLanguages(), this.surveyLanguage);
    }

    public final QuestionHeaderBindingData getQuestionHeaderBindingData() {
        String strReplaceTags = this.displayEngine.getTextRecallingManager().replaceTags(this.translatedPoint.getDescription());
        String strReplaceTags2 = this.displayEngine.getTextRecallingManager().replaceTags(this.translatedPoint.getContent());
        String answerRequiredText = getSurveyMessages().getAnswerRequiredText();
        if (strReplaceTags == null) {
            strReplaceTags = "";
        }
        return new QuestionHeaderBindingData(strReplaceTags, strReplaceTags2 == null ? "" : strReplaceTags2, answerRequiredText == null ? "" : answerRequiredText, shouldDisplayAnswerRequiredLabel(), getSurveyPointImageBindingData());
    }

    private final SurveyPointImageBindingData getSurveyPointImageBindingData() {
        return new SurveyPointImageBindingData(this.surveyPoint.getSurveyPointImage());
    }

    public final SubmitViewConfiguration getSubmitViewConfiguration$survicate_sdk_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ButtonTextResolver buttonTextResolver = new ButtonTextResolver(getSurveyMessages());
        return new SubmitViewConfiguration(buttonTextResolver.resolveBackButtonText(context), buttonTextResolver.resolveSubmitButtonText(context, this.translatedPoint), this.displayEngine.hasNavigationButtons(), isFirstQuestion(), isFirstQuestionForFirstTime(), !this.displayEngine.shouldHideFooter());
    }

    public final boolean shouldDisplayAnswerRequiredLabel() {
        if (!this.surveyPoint.isMandatory()) {
            return false;
        }
        T t = this.surveyPoint;
        return ((t instanceof SurveyCtaSurveyPoint) || Intrinsics.areEqual(t.getAnswerType(), QuestionSurveyAnswerType.DATE)) ? false : true;
    }

    public final void onLanguageSelected(String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        this.surveyViewModel.onLanguageSelected(langCode);
        this.displayEngine.setLayoutDirection(this.surveyViewModel.getLayoutDirection());
        translatePoint(langCode);
    }

    private final void translatePoint(String langCode) {
        Object next;
        if (Intrinsics.areEqual(langCode, this.displayEngine.getDefaultSurveyLanguage())) {
            this.translatedPoint = this.surveyPoint;
            this.surveyLanguage = langCode;
            return;
        }
        SurveyTranslation surveyTranslationFor = getSurveyTranslationFor(langCode);
        if (surveyTranslationFor == null) {
            return;
        }
        this.surveyLanguage = surveyTranslationFor.getLanguageCode();
        Iterator<T> it = surveyTranslationFor.getPoints().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SurveyPointTranslation) next).getId() == this.surveyPoint.getId()) {
                    break;
                }
            }
        }
        SurveyPointTranslation surveyPointTranslation = (SurveyPointTranslation) next;
        if (surveyPointTranslation == null) {
            return;
        }
        Object objTranslatedWith = this.surveyPoint.translatedWith(surveyPointTranslation);
        Intrinsics.checkNotNull(objTranslatedWith, "null cannot be cast to non-null type T of com.survicate.surveys.presentation.base.SurveyPointDisplayer");
        this.translatedPoint = (T) objTranslatedWith;
    }

    private final SurveyTranslation getSurveyTranslationFor(String langCode) {
        Survey currentSurvey = this.displayEngine.getCurrentSurvey();
        if (currentSurvey == null) {
            return null;
        }
        return LocaleUtils.INSTANCE.findMatchingTranslation(currentSurvey.getId(), langCode, this.displayEngine.getAvailableTranslations());
    }
}
