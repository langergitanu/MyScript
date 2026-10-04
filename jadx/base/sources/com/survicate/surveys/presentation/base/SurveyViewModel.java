package com.survicate.surveys.presentation.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.AnswerDetails;
import com.survicate.surveys.components.branchLogic.BranchLogicResolver;
import com.survicate.surveys.entities.survey.Survey;
import com.survicate.surveys.entities.survey.SurveyAnswerType;
import com.survicate.surveys.entities.survey.SurveyMessages;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint;
import com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint;
import com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint;
import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.entities.survey.theme.ThemeSettings;
import com.survicate.surveys.entities.survey.translations.SurveyMessagesTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyPointTranslation;
import com.survicate.surveys.entities.survey.translations.SurveySettingsTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.presentation.base.micro.ButtonTextResolver;
import com.survicate.surveys.presentation.csat.CsatQuestionViewModel;
import com.survicate.surveys.presentation.cta.CtaQuestionViewModel;
import com.survicate.surveys.presentation.date.DateQuestionViewModel;
import com.survicate.surveys.presentation.form.FormQuestionViewModel;
import com.survicate.surveys.presentation.matrix.MatrixQuestionViewModel;
import com.survicate.surveys.presentation.multiple.MultipleChoiceQuestionViewModel;
import com.survicate.surveys.presentation.nps.NpsQuestionViewModel;
import com.survicate.surveys.presentation.numerical.NumericalQuestionViewModel;
import com.survicate.surveys.presentation.page.QuestionViewModel;
import com.survicate.surveys.presentation.page.ResolvedQuestionTexts;
import com.survicate.surveys.presentation.page.SurveyPageAnswer;
import com.survicate.surveys.presentation.page.SurveyPageConfiguration;
import com.survicate.surveys.presentation.page.SurveyPageContentViewFactory;
import com.survicate.surveys.presentation.page.SurveyPageViewModel;
import com.survicate.surveys.presentation.shape.ShapeQuestionViewModel;
import com.survicate.surveys.presentation.single.SingleChoiceQuestionViewModel;
import com.survicate.surveys.presentation.smileyscale.SmileyScaleQuestionViewModel;
import com.survicate.surveys.presentation.text.TextQuestionViewModel;
import com.survicate.surveys.presentation.widget.SubmitViewConfiguration;
import com.survicate.surveys.presentation.widget.SurveyHeaderBindingData;
import com.survicate.surveys.utils.FeatureFlags;
import com.survicate.surveys.utils.LayoutDirectionProvider;
import com.survicate.surveys.utils.LocaleUtils;
import com.survicate.surveys.utils.OpenIntentsUtils;
import com.survicate.surveys.utils.SurvicateLocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyViewModel.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 P2\u00020\u0001:\u0001PB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0014J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\u0013J\u0016\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0014J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001e\u001a\u00020\u0013J\u0015\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b#J\n\u0010$\u001a\u0004\u0018\u00010%H\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0'2\u0006\u0010!\u001a\u00020\"H\u0002J\u001a\u0010(\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"2\b\u0010)\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010%H\u0002J\"\u0010-\u001a\u00020.2\u0006\u0010!\u001a\u00020\"2\u0006\u0010/\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u00101\u001a\u0002022\u0006\u0010!\u001a\u00020\"2\u0006\u0010/\u001a\u00020+H\u0002J\u0010\u00103\u001a\u0002042\u0006\u0010!\u001a\u00020\"H\u0002J\u0014\u00105\u001a\u0004\u0018\u00010\t2\b\u0010,\u001a\u0004\u0018\u00010%H\u0002J\u0010\u00106\u001a\u0002072\u0006\u0010!\u001a\u00020\"H\u0002J\u0015\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0019J\u0006\u0010=\u001a\u00020\u0019J\u000e\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\tJ\u000e\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u0002072\u0006\u0010D\u001a\u00020\"J\u0010\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020HJ \u0010I\u001a\u00020J2\u0006\u0010G\u001a\u00020H2\u0006\u0010!\u001a\u00020\"2\b\u0010K\u001a\u0004\u0018\u00010\tJ-\u0010L\u001a\u00020M2\u0006\u0010G\u001a\u00020H2\u0006\u0010!\u001a\u00020\"2\u0006\u0010/\u001a\u00020+2\u0006\u0010N\u001a\u000207H\u0000¢\u0006\u0002\bOR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/SurveyViewModel;", "Lcom/survicate/surveys/presentation/base/BaseViewModel;", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "layoutDirectionProvider", "Lcom/survicate/surveys/utils/LayoutDirectionProvider;", "<init>", "(Lcom/survicate/surveys/presentation/base/DisplayEngine;Lcom/survicate/surveys/utils/LayoutDirectionProvider;)V", "preferredLanguage", "", "getPreferredLanguage", "()Ljava/lang/String;", "layoutDirection", "", "getLayoutDirection", "()I", "selectedLanguage", "surveyPointUiState", "", "", "Landroid/os/Bundle;", "surveyPagesState", "currentPageVm", "Lcom/survicate/surveys/presentation/page/SurveyPageViewModel;", "savePointState", "", "pointId", "state", "restorePointState", "savePageState", "pageId", "restorePageState", "enterPage", "surveyPoint", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "enterPage$survicate_sdk_release", "findSurveyTranslation", "Lcom/survicate/surveys/entities/survey/translations/SurveyTranslation;", "pointsForPage", "", "translatePoint", "surveyTranslation", "getSurveyMessages", "Lcom/survicate/surveys/entities/survey/SurveyMessages;", "translation", "createQuestionViewModel", "Lcom/survicate/surveys/presentation/page/QuestionViewModel;", "messages", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "resolveQuestionTexts", "Lcom/survicate/surveys/presentation/page/ResolvedQuestionTexts;", "getPageConfiguration", "Lcom/survicate/surveys/presentation/page/SurveyPageConfiguration;", "resolveCurrentLanguageCode", "restoreDisclaimerAccepted", "", "onPageSubmit", "pageAnswer", "Lcom/survicate/surveys/presentation/page/SurveyPageAnswer;", "onPageSubmit$survicate_sdk_release", "onPageBack", "onSurveyClosed", "onLanguageSelected", "langCode", "onPoweredByClick", "activity", "Landroid/app/Activity;", "wasQuestionAlreadySubmitted", "point", "getSurveyTheme", "Lcom/survicate/surveys/entities/survey/theme/Theme;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "getSurveyHeaderBindingData", "Lcom/survicate/surveys/presentation/widget/SurveyHeaderBindingData;", "currentLanguage", "getSubmitViewConfiguration", "Lcom/survicate/surveys/presentation/widget/SubmitViewConfiguration;", "isMultiQuestion", "getSubmitViewConfiguration$survicate_sdk_release", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyViewModel extends BaseViewModel {
    public static final String KEY_DISCLAIMER_ACCEPTED = "PAGE_DISCLAIMER_ACCEPTED";
    private SurveyPageViewModel currentPageVm;
    private final DisplayEngine displayEngine;
    private final LayoutDirectionProvider layoutDirectionProvider;
    private String selectedLanguage;
    private final Map<Long, Bundle> surveyPagesState;
    private final Map<Long, Bundle> surveyPointUiState;

    /* JADX INFO: compiled from: SurveyViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurveyAnswerType.values().length];
            try {
                iArr[SurveyAnswerType.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurveyAnswerType.MULTIPLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurveyAnswerType.NPS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SurveyAnswerType.SMILEY_SCALE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SurveyAnswerType.CSAT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SurveyAnswerType.NUMERICAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SurveyAnswerType.SHAPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SurveyAnswerType.DATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[SurveyAnswerType.TEXT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[SurveyAnswerType.MATRIX.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[SurveyAnswerType.FORM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_NEXT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_LINK.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[SurveyAnswerType.BUTTON_CLOSE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SurveyViewModel(DisplayEngine displayEngine, LayoutDirectionProvider layoutDirectionProvider) {
        Intrinsics.checkNotNullParameter(displayEngine, "displayEngine");
        Intrinsics.checkNotNullParameter(layoutDirectionProvider, "layoutDirectionProvider");
        this.displayEngine = displayEngine;
        this.layoutDirectionProvider = layoutDirectionProvider;
        this.surveyPointUiState = new LinkedHashMap();
        this.surveyPagesState = new LinkedHashMap();
    }

    public final String getPreferredLanguage() {
        String str = this.selectedLanguage;
        return str == null ? this.displayEngine.getLocaleProvider().getAppLanguage() : str;
    }

    public final int getLayoutDirection() {
        return this.layoutDirectionProvider.getLayoutDirection(getPreferredLanguage());
    }

    public final void savePointState(long pointId, Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.surveyPointUiState.put(Long.valueOf(pointId), state);
    }

    public final Bundle restorePointState(long pointId) {
        return this.surveyPointUiState.get(Long.valueOf(pointId));
    }

    public final void savePageState(long pageId, Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.surveyPagesState.put(Long.valueOf(pageId), state);
    }

    public final Bundle restorePageState(long pageId) {
        return this.surveyPagesState.get(Long.valueOf(pageId));
    }

    public final SurveyPageViewModel enterPage$survicate_sdk_release(SurveyPoint surveyPoint) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        this.displayEngine.setLayoutDirection(getLayoutDirection());
        SurveyTranslation surveyTranslationFindSurveyTranslation = findSurveyTranslation();
        List<SurveyPoint> listPointsForPage = pointsForPage(surveyPoint);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listPointsForPage, 10));
        Iterator<T> it = listPointsForPage.iterator();
        while (it.hasNext()) {
            arrayList.add(translatePoint((SurveyPoint) it.next(), surveyTranslationFindSurveyTranslation));
        }
        ArrayList arrayList2 = arrayList;
        SurveyMessages surveyMessages = getSurveyMessages(surveyTranslationFindSurveyTranslation);
        String strResolveCurrentLanguageCode = resolveCurrentLanguageCode(surveyTranslationFindSurveyTranslation);
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(createQuestionViewModel((SurveyPoint) it2.next(), surveyMessages, strResolveCurrentLanguageCode));
        }
        SurveyPoint surveyPoint2 = (SurveyPoint) CollectionsKt.first((List) arrayList2);
        SurveyPageViewModel surveyPageViewModel = new SurveyPageViewModel(this, getPageConfiguration(surveyPoint2), this.displayEngine.getViewDependencies(), arrayList4, strResolveCurrentLanguageCode, surveyMessages, surveyPoint2.getDisclaimerSettings(), restoreDisclaimerAccepted(surveyPoint2));
        this.currentPageVm = surveyPageViewModel;
        return surveyPageViewModel;
    }

    private final SurveyTranslation findSurveyTranslation() {
        Survey currentSurvey = this.displayEngine.getCurrentSurvey();
        if (currentSurvey == null) {
            return null;
        }
        String preferredLanguage = getPreferredLanguage();
        if (Intrinsics.areEqual(preferredLanguage, this.displayEngine.getDefaultSurveyLanguage())) {
            return null;
        }
        return LocaleUtils.INSTANCE.findMatchingTranslation(currentSurvey.getId(), preferredLanguage, this.displayEngine.getAvailableTranslations());
    }

    private final List<SurveyPoint> pointsForPage(SurveyPoint surveyPoint) {
        if (!FeatureFlags.INSTANCE.isMultipleQuestionsPerPageEnabled()) {
            return CollectionsKt.listOf(surveyPoint);
        }
        Survey currentSurvey = this.displayEngine.getCurrentSurvey();
        if (currentSurvey == null) {
            return CollectionsKt.listOf(surveyPoint);
        }
        List<SurveyPoint> points = currentSurvey.getPoints();
        ArrayList arrayList = new ArrayList();
        for (Object obj : points) {
            if (SurveyPageContentViewFactory.INSTANCE.isSupportedType(((SurveyPoint) obj).getAnswerType())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final SurveyPoint translatePoint(SurveyPoint surveyPoint, SurveyTranslation surveyTranslation) {
        List<SurveyPointTranslation> points;
        Object next;
        if (surveyTranslation == null || (points = surveyTranslation.getPoints()) == null) {
            return surveyPoint;
        }
        Iterator<T> it = points.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SurveyPointTranslation) next).getId() == surveyPoint.getId()) {
                break;
            }
        }
        SurveyPointTranslation surveyPointTranslation = (SurveyPointTranslation) next;
        return surveyPointTranslation != null ? surveyPoint.translatedWith(surveyPointTranslation) : surveyPoint;
    }

    private final SurveyMessages getSurveyMessages(SurveyTranslation translation) {
        SurveySettingsTranslation settings;
        SurveyMessagesTranslation messages;
        SurveyMessages surveyMessages = this.displayEngine.getSurveyMessages();
        return (translation == null || (settings = translation.getSettings()) == null || (messages = settings.getMessages()) == null) ? surveyMessages : surveyMessages.translatedWith(messages);
    }

    private final QuestionViewModel createQuestionViewModel(SurveyPoint surveyPoint, SurveyMessages messages, String languageCode) {
        ResolvedQuestionTexts resolvedQuestionTextsResolveQuestionTexts = resolveQuestionTexts(surveyPoint, messages);
        Bundle bundleRestorePointState = restorePointState(surveyPoint.getId());
        SurveyAnswerType surveyAnswerTypeFromString = SurveyAnswerType.INSTANCE.fromString(surveyPoint.getAnswerType());
        switch (surveyAnswerTypeFromString == null ? -1 : WhenMappings.$EnumSwitchMapping$0[surveyAnswerTypeFromString.ordinal()]) {
            case 1:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                return new SingleChoiceQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 2:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                return new MultipleChoiceQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 3:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.nps.SurveyNpsSurveyPoint");
                return new NpsQuestionViewModel((SurveyNpsSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 4:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                return new SmileyScaleQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 5:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                return new CsatQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 6:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                return new NumericalQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 7:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                return new ShapeQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 8:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                SurvicateLocalDate.Companion companion = SurvicateLocalDate.INSTANCE;
                Calendar calendar = Calendar.getInstance();
                Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
                return new DateQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, companion.fromCalendar(calendar), bundleRestorePointState);
            case 9:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                return new TextQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, this.displayEngine.getFollowUpQuestionRepository(), languageCode, this.displayEngine.getSurveyFollowUpLimit(), null, bundleRestorePointState, 32, null);
            case 10:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint");
                return new MatrixQuestionViewModel((SurveyQuestionSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 11:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.form.SurveyFormSurveyPoint");
                return new FormQuestionViewModel((SurveyFormSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts, bundleRestorePointState);
            case 12:
            case 13:
            case 14:
                Intrinsics.checkNotNull(surveyPoint, "null cannot be cast to non-null type com.survicate.surveys.entities.survey.questions.cta.SurveyCtaSurveyPoint");
                return new CtaQuestionViewModel((SurveyCtaSurveyPoint) surveyPoint, resolvedQuestionTextsResolveQuestionTexts);
            default:
                throw new IllegalArgumentException("Unsupported answer type: " + surveyPoint.getAnswerType());
        }
    }

    private final ResolvedQuestionTexts resolveQuestionTexts(SurveyPoint surveyPoint, SurveyMessages messages) {
        String strReplaceTags = this.displayEngine.getTextRecallingManager().replaceTags(surveyPoint.getContent());
        if (strReplaceTags == null) {
            strReplaceTags = "";
        }
        String strReplaceTags2 = this.displayEngine.getTextRecallingManager().replaceTags(surveyPoint.getDescription());
        if (strReplaceTags2 == null) {
            strReplaceTags2 = "";
        }
        String answerRequiredText = messages.getAnswerRequiredText();
        if (answerRequiredText == null) {
            answerRequiredText = "";
        }
        String inputTextPlaceholder = messages.getInputTextPlaceholder();
        return new ResolvedQuestionTexts(strReplaceTags, strReplaceTags2, answerRequiredText, inputTextPlaceholder != null ? inputTextPlaceholder : "");
    }

    private final SurveyPageConfiguration getPageConfiguration(SurveyPoint surveyPoint) {
        return new SurveyPageConfiguration(this.displayEngine.isSurveyFullScreen(), !this.displayEngine.shouldHideFooter(), this.displayEngine.hasNavigationButtons(), this.displayEngine.isFirstQuestion(surveyPoint));
    }

    private final String resolveCurrentLanguageCode(SurveyTranslation translation) {
        String languageCode;
        return (translation == null || (languageCode = translation.getLanguageCode()) == null) ? this.displayEngine.getDefaultSurveyLanguage() : languageCode;
    }

    private final boolean restoreDisclaimerAccepted(SurveyPoint surveyPoint) {
        Bundle bundleRestorePageState = restorePageState(surveyPoint.getId());
        if (bundleRestorePageState != null) {
            return bundleRestorePageState.getBoolean(KEY_DISCLAIMER_ACCEPTED);
        }
        return false;
    }

    public final void onPageSubmit$survicate_sdk_release(SurveyPageAnswer pageAnswer) {
        Survey currentSurvey;
        Object next;
        Intrinsics.checkNotNullParameter(pageAnswer, "pageAnswer");
        if (FeatureFlags.INSTANCE.isMultipleQuestionsPerPageEnabled() || (currentSurvey = this.displayEngine.getCurrentSurvey()) == null) {
            return;
        }
        SurveyPageAnswer.PointAnswer pointAnswer = (SurveyPageAnswer.PointAnswer) CollectionsKt.first((List) pageAnswer.getPointAnswers());
        Iterator<T> it = currentSurvey.getPoints().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SurveyPoint) next).getId() == pointAnswer.getPointId()) {
                    break;
                }
            }
        }
        SurveyPoint surveyPoint = (SurveyPoint) next;
        if (surveyPoint == null) {
            return;
        }
        List<SurveyAnswer> answers = pointAnswer.getAnswers();
        this.displayEngine.getSurveyStore().saveAnswer(this.displayEngine.getSurveyAnswerFactory().create(surveyPoint, answers));
        SurveyAnswerAction surveyAnswerAction = new SurveyAnswerAction(answers, BranchLogicResolver.INSTANCE.resolve(surveyPoint, answers, this.displayEngine.getSurveyLogic()), surveyPoint.getId());
        SurveyPageViewModel surveyPageViewModel = this.currentPageVm;
        this.displayEngine.questionAnswered(new AnswerDetails(surveyAnswerAction, surveyPoint, currentSurvey, surveyPageViewModel != null ? surveyPageViewModel.getCurrentLanguageCode() : null, pageAnswer.getDisclaimerAccepted()));
    }

    public final void onPageBack() {
        this.displayEngine.showPreviousQuestion();
    }

    public final void onSurveyClosed() {
        this.displayEngine.surveyClosed();
    }

    public final void onLanguageSelected(String langCode) {
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        this.selectedLanguage = langCode;
        this.displayEngine.setLayoutDirection(getLayoutDirection());
    }

    public final void onPoweredByClick(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Survey currentSurvey = this.displayEngine.getCurrentSurvey();
        if (currentSurvey == null) {
            return;
        }
        OpenIntentsUtils.openLink(activity, this.displayEngine.getUrlBuilder().buildPoweredBySurvicateUrl(currentSurvey.getId()));
    }

    public final boolean wasQuestionAlreadySubmitted(SurveyPoint point) {
        Intrinsics.checkNotNullParameter(point, "point");
        return this.displayEngine.wasQuestionAlreadySubmitted(point);
    }

    public final Theme getSurveyTheme(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.displayEngine.getSurveyTheme(context);
    }

    public final SurveyHeaderBindingData getSurveyHeaderBindingData(Context context, SurveyPoint surveyPoint, String currentLanguage) {
        ThemeSettings themeSettingsEmpty;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Theme surveyTheme = this.displayEngine.getSurveyTheme(context);
        if (surveyTheme == null || (themeSettingsEmpty = surveyTheme.getSettings()) == null) {
            themeSettingsEmpty = ThemeSettings.INSTANCE.empty();
        }
        return new SurveyHeaderBindingData(themeSettingsEmpty, this.displayEngine.getViewDependencies().getImageLoader(), this.displayEngine.shouldShowProgressBar(), this.displayEngine.getSurveyProgressInPercents(surveyPoint), this.displayEngine.shouldShowLanguageSelector(), this.displayEngine.getAvailableLanguages(), currentLanguage);
    }

    public final SubmitViewConfiguration getSubmitViewConfiguration$survicate_sdk_release(Context context, SurveyPoint surveyPoint, SurveyMessages messages, boolean isMultiQuestion) {
        String strResolveSubmitButtonText;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Intrinsics.checkNotNullParameter(messages, "messages");
        ButtonTextResolver buttonTextResolver = new ButtonTextResolver(messages);
        if (isMultiQuestion) {
            strResolveSubmitButtonText = buttonTextResolver.resolveGenericSubmitText(context);
        } else {
            strResolveSubmitButtonText = buttonTextResolver.resolveSubmitButtonText(context, surveyPoint);
        }
        return new SubmitViewConfiguration(buttonTextResolver.resolveBackButtonText(context), strResolveSubmitButtonText, this.displayEngine.hasNavigationButtons(), this.displayEngine.isFirstQuestion(surveyPoint), this.displayEngine.isFirstQuestion(surveyPoint) && !this.displayEngine.wasQuestionAlreadySubmitted(surveyPoint), !this.displayEngine.shouldHideFooter());
    }
}
