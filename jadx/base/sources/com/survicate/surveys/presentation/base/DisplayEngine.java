package com.survicate.surveys.presentation.base;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.AnswerDetails;
import com.survicate.surveys.AnswersManager;
import com.survicate.surveys.TextRecallingManager;
import com.survicate.surveys.WorkspaceLoader;
import com.survicate.surveys.components.displayLogic.DisplayLogicExKt;
import com.survicate.surveys.components.surveyLogic.SurveyLogic;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.logic.display.DisplayLogicController;
import com.survicate.surveys.core.logic.display.models.QuestionSuggestion;
import com.survicate.surveys.core.providers.LocaleProvider;
import com.survicate.surveys.entities.models.SurveyPointDisplayRequest;
import com.survicate.surveys.entities.survey.Survey;
import com.survicate.surveys.entities.survey.SurveyMessages;
import com.survicate.surveys.entities.survey.SurveySettings;
import com.survicate.surveys.entities.survey.questions.SurveyPoint;
import com.survicate.surveys.entities.survey.theme.Theme;
import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import com.survicate.surveys.helpers.BehaviourObservable;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.helpers.url.UrlBuilder;
import com.survicate.surveys.infrastructure.environment.WorkspaceKeyProvider;
import com.survicate.surveys.infrastructure.network.SurveyAnswer;
import com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionRepository;
import com.survicate.surveys.infrastructure.storage.interfaces.QuestionAnswerItem;
import com.survicate.surveys.infrastructure.storage.survey.SurveyAnswerFactory;
import com.survicate.surveys.infrastructure.storage.survey.SurveyStore;
import com.survicate.surveys.presentation.design.DisplayDesignEngine;
import com.survicate.surveys.presentation.design.DisplayDesignFactory;
import com.survicate.surveys.presentation.design.DisplayDesignProvider;
import com.survicate.surveys.surveys.PresentationStyle;
import com.survicate.surveys.utils.SurveyThemeProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: DisplayEngine.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 §\u00012\u00020\u0001:\u0002§\u0001B\u008b\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!¢\u0006\u0004\b\"\u0010#J\b\u0010f\u001a\u00020gH\u0016J\u001c\u0010h\u001a\u00020^2\u0006\u0010i\u001a\u00020C2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020H0GJ\u000e\u0010k\u001a\u00020^2\u0006\u0010l\u001a\u00020mJ\u0018\u0010n\u001a\u00020@2\u0006\u0010o\u001a\u00020U2\u0006\u0010p\u001a\u00020qH\u0002J\u0010\u0010r\u001a\u00020@2\u0006\u0010o\u001a\u00020UH\u0002J\u0010\u0010s\u001a\u00020@2\u0006\u0010p\u001a\u00020qH\u0002J\u000e\u0010t\u001a\u00020@2\u0006\u0010o\u001a\u00020UJ\u0006\u0010u\u001a\u00020^J\u0006\u0010v\u001a\u00020^J\u0006\u0010w\u001a\u00020@J\u0012\u0010x\u001a\u00020^2\b\u0010y\u001a\u0004\u0018\u00010UH\u0002J\u0006\u0010z\u001a\u00020^J\u0006\u0010{\u001a\u00020@J\b\u0010|\u001a\u0004\u0018\u00010PJ\f\u0010}\u001a\b\u0012\u0004\u0012\u00020P0GJ\u0006\u0010~\u001a\u00020@J\u0010\u0010\u007f\u001a\u00020^2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0084\u0001\u001a\u00020UJ\u000b\u0010\u0085\u0001\u001a\u0004\u0018\u00010CH\u0002J\u0011\u0010\u0086\u0001\u001a\u00020^2\u0006\u0010i\u001a\u00020CH\u0002J\u0011\u0010\u0087\u0001\u001a\u00020@2\u0006\u0010i\u001a\u00020CH\u0002J\u0014\u0010\u0088\u0001\u001a\u00030\u0081\u00012\b\u0010y\u001a\u0004\u0018\u00010UH\u0002J\u0015\u0010\u0089\u0001\u001a\u0004\u0018\u00010U2\b\u0010p\u001a\u0004\u0018\u00010qH\u0002J$\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0006\u0010D\u001a\u00020C2\b\u0010\u008b\u0001\u001a\u00030\u0081\u0001H\u0002¢\u0006\u0003\u0010\u008c\u0001J\u0011\u0010\u008d\u0001\u001a\u00020@2\u0006\u0010i\u001a\u00020CH\u0002J\u001f\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0081\u0001*\u00020C2\u0007\u0010\u008f\u0001\u001a\u00020YH\u0002¢\u0006\u0003\u0010\u0090\u0001J\u0007\u0010\u0091\u0001\u001a\u00020@J\u0019\u0010\u0092\u0001\u001a\u00020^2\u0007\u0010\u0093\u0001\u001a\u00020Q2\u0007\u0010\u0094\u0001\u001a\u00020PJ\u0010\u0010\u0095\u0001\u001a\u00020^2\u0007\u0010\u0094\u0001\u001a\u00020PJ\u000b\u0010\u0096\u0001\u001a\u0004\u0018\u00010QH\u0002J\u0014\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u00012\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001J\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001J\u0010\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0081\u0001¢\u0006\u0003\u0010\u009e\u0001J\u0007\u0010\u009f\u0001\u001a\u00020@J\u0010\u0010 \u0001\u001a\u00020@2\u0007\u0010\u0084\u0001\u001a\u00020UJ\u0011\u0010¡\u0001\u001a\u00020^2\b\u0010¢\u0001\u001a\u00030£\u0001J\u001a\u0010¤\u0001\u001a\t\u0012\u0005\u0012\u00030¥\u00010G2\b\u0010¦\u0001\u001a\u00030\u0081\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020@8F¢\u0006\u0006\u001a\u0004\b?\u0010AR\"\u0010D\u001a\u0004\u0018\u00010C2\b\u0010B\u001a\u0004\u0018\u00010C@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR*\u0010I\u001a\b\u0012\u0004\u0012\u00020H0G2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020H0G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010N\u001a\u001e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q0Oj\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q`RX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020U0TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\\\u001a\b\u0012\u0004\u0012\u00020^0]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR \u0010c\u001a\b\u0012\u0004\u0012\u00020^0]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010`\"\u0004\be\u0010b¨\u0006¨\u0001"}, m1599d2 = {"Lcom/survicate/surveys/presentation/base/DisplayEngine;", "Lcom/survicate/surveys/presentation/design/DisplayDesignProvider;", "activityLauncher", "Lcom/survicate/surveys/presentation/base/SurvicateActivityLauncher;", "answersManager", "Lcom/survicate/surveys/AnswersManager;", "displayDesignEngine", "Lcom/survicate/surveys/presentation/design/DisplayDesignEngine;", "surveyThemeProvider", "Lcom/survicate/surveys/utils/SurveyThemeProvider;", "textRecallingManager", "Lcom/survicate/surveys/TextRecallingManager;", "surveyStore", "Lcom/survicate/surveys/infrastructure/storage/survey/SurveyStore;", "surveyAnswerFactory", "Lcom/survicate/surveys/infrastructure/storage/survey/SurveyAnswerFactory;", "urlBuilder", "Lcom/survicate/surveys/helpers/url/UrlBuilder;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "surveyLogic", "Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;", "displayLogic", "Lcom/survicate/surveys/core/logic/display/DisplayLogicController;", "followUpQuestionRepository", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "localeProvider", "Lcom/survicate/surveys/core/providers/LocaleProvider;", "workspaceKeyProvider", "Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyProvider;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/presentation/base/SurvicateActivityLauncher;Lcom/survicate/surveys/AnswersManager;Lcom/survicate/surveys/presentation/design/DisplayDesignEngine;Lcom/survicate/surveys/utils/SurveyThemeProvider;Lcom/survicate/surveys/TextRecallingManager;Lcom/survicate/surveys/infrastructure/storage/survey/SurveyStore;Lcom/survicate/surveys/infrastructure/storage/survey/SurveyAnswerFactory;Lcom/survicate/surveys/helpers/url/UrlBuilder;Lcom/survicate/surveys/helpers/ViewDependencies;Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;Lcom/survicate/surveys/core/logic/display/DisplayLogicController;Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;Lcom/survicate/surveys/core/logging/SdkLogger;Lcom/survicate/surveys/core/providers/LocaleProvider;Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyProvider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getTextRecallingManager", "()Lcom/survicate/surveys/TextRecallingManager;", "getSurveyStore", "()Lcom/survicate/surveys/infrastructure/storage/survey/SurveyStore;", "getSurveyAnswerFactory", "()Lcom/survicate/surveys/infrastructure/storage/survey/SurveyAnswerFactory;", "getUrlBuilder", "()Lcom/survicate/surveys/helpers/url/UrlBuilder;", "getViewDependencies", "()Lcom/survicate/surveys/helpers/ViewDependencies;", "getSurveyLogic", "()Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;", "getDisplayLogic", "()Lcom/survicate/surveys/core/logic/display/DisplayLogicController;", "getFollowUpQuestionRepository", "()Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;", "getLogger", "()Lcom/survicate/surveys/core/logging/SdkLogger;", "getLocaleProvider", "()Lcom/survicate/surveys/core/providers/LocaleProvider;", "getWorkspaceKeyProvider", "()Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyProvider;", "surveyPointObservable", "Lcom/survicate/surveys/helpers/BehaviourObservable;", "Lcom/survicate/surveys/entities/models/SurveyPointDisplayRequest;", "getSurveyPointObservable", "()Lcom/survicate/surveys/helpers/BehaviourObservable;", "isShowingSurvey", "", "()Z", "value", "Lcom/survicate/surveys/entities/survey/Survey;", "currentSurvey", "getCurrentSurvey", "()Lcom/survicate/surveys/entities/survey/Survey;", "", "Lcom/survicate/surveys/entities/survey/translations/SurveyTranslation;", "availableTranslations", "getAvailableTranslations", "()Ljava/util/List;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "activityListeners", "Ljava/util/HashMap;", "", "Lcom/survicate/surveys/presentation/base/ActivityListener;", "Lkotlin/collections/HashMap;", "surveyPointStack", "Ljava/util/Stack;", "Lcom/survicate/surveys/entities/survey/questions/SurveyPoint;", "currentActivityUuid", "alreadySubmittedQuestions", "", "", "shouldOverwriteNextAnswers", "receivedAnswer", "reloadWorkspace", "Lkotlin/Function0;", "", "getReloadWorkspace", "()Lkotlin/jvm/functions/Function0;", "setReloadWorkspace", "(Lkotlin/jvm/functions/Function0;)V", "rechallengeSurveys", "getRechallengeSurveys", "setRechallengeSurveys", "provideDesignFactory", "Lcom/survicate/surveys/presentation/design/DisplayDesignFactory;", "showSurvey", "survey", "translations", "questionAnswered", "answerDetails", "Lcom/survicate/surveys/AnswerDetails;", "isSurveyFinished", "question", "answerAction", "Lcom/survicate/surveys/presentation/base/SurveyAnswerAction;", "isLastQuestionOnList", "isLastQuestionByLogic", "isFirstQuestion", "surveyClosed", "forceClose", "shouldHideFooter", "showNextOrFinish", "nextPoint", "showPreviousQuestion", "shouldShowProgressBar", "getDefaultSurveyLanguage", "getAvailableLanguages", "shouldShowLanguageSelector", "setLayoutDirection", "layoutDirection", "", "getSurveyProgressInPercents", "", "surveyPoint", "closeSurvey", "reloadWorkspaceIfNeeded", "isSurveyFastRecurring", "resolveMaxPath", "resolveNextSurveyPoint", "nextPointIdByDisplayLogic", "nextQuestionIndex", "(Lcom/survicate/surveys/entities/survey/Survey;I)Ljava/lang/Integer;", "checkSurveyNotEmpty", "findPointIndexById", "id", "(Lcom/survicate/surveys/entities/survey/Survey;J)Ljava/lang/Integer;", "isSurveyFullScreen", "setActivityListener", "activityListener", "activityUuid", "clearActivityListener", "getActivityListener", "getSurveyTheme", "Lcom/survicate/surveys/entities/survey/theme/Theme;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "getSurveyMessages", "Lcom/survicate/surveys/entities/survey/SurveyMessages;", "getSurveyFollowUpLimit", "()Ljava/lang/Integer;", "hasNavigationButtons", "wasQuestionAlreadySubmitted", "setWorkspaceReloadAction", "workspaceLoader", "Lcom/survicate/surveys/WorkspaceLoader;", "getQuestionSuggestionsFrom", "Lcom/survicate/surveys/core/logic/display/models/QuestionSuggestion;", FirebaseAnalytics.Param.INDEX, "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayEngine implements DisplayDesignProvider {
    private static final long RECHALLENGE_DELAY_MS = 400;
    private final SurvicateActivityLauncher activityLauncher;
    private final HashMap<String, ActivityListener> activityListeners;
    private Set<Long> alreadySubmittedQuestions;
    private final AnswersManager answersManager;
    private List<SurveyTranslation> availableTranslations;
    private final CoroutineScope coroutineScope;
    private String currentActivityUuid;
    private Survey currentSurvey;
    private final DisplayDesignEngine displayDesignEngine;
    private final DisplayLogicController displayLogic;
    private final FollowUpQuestionRepository followUpQuestionRepository;
    private final LocaleProvider localeProvider;
    private final SdkLogger logger;
    private boolean receivedAnswer;
    private Function0<Unit> rechallengeSurveys;
    private Function0<Unit> reloadWorkspace;
    private boolean shouldOverwriteNextAnswers;
    private final SurveyAnswerFactory surveyAnswerFactory;
    private final SurveyLogic surveyLogic;
    private final BehaviourObservable<SurveyPointDisplayRequest> surveyPointObservable;
    private final Stack<SurveyPoint> surveyPointStack;
    private final SurveyStore surveyStore;
    private final SurveyThemeProvider surveyThemeProvider;
    private final TextRecallingManager textRecallingManager;
    private final UrlBuilder urlBuilder;
    private final ViewDependencies viewDependencies;
    private final WorkspaceKeyProvider workspaceKeyProvider;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisplayEngine(SurvicateActivityLauncher activityLauncher, AnswersManager answersManager, DisplayDesignEngine displayDesignEngine, SurveyThemeProvider surveyThemeProvider, TextRecallingManager textRecallingManager, SurveyStore surveyStore, SurveyAnswerFactory surveyAnswerFactory, UrlBuilder urlBuilder, ViewDependencies viewDependencies, SurveyLogic surveyLogic, DisplayLogicController displayLogic, FollowUpQuestionRepository followUpQuestionRepository, SdkLogger logger, LocaleProvider localeProvider, WorkspaceKeyProvider workspaceKeyProvider) {
        this(activityLauncher, answersManager, displayDesignEngine, surveyThemeProvider, textRecallingManager, surveyStore, surveyAnswerFactory, urlBuilder, viewDependencies, surveyLogic, displayLogic, followUpQuestionRepository, logger, localeProvider, workspaceKeyProvider, null, 32768, null);
        Intrinsics.checkNotNullParameter(activityLauncher, "activityLauncher");
        Intrinsics.checkNotNullParameter(answersManager, "answersManager");
        Intrinsics.checkNotNullParameter(displayDesignEngine, "displayDesignEngine");
        Intrinsics.checkNotNullParameter(surveyThemeProvider, "surveyThemeProvider");
        Intrinsics.checkNotNullParameter(textRecallingManager, "textRecallingManager");
        Intrinsics.checkNotNullParameter(surveyStore, "surveyStore");
        Intrinsics.checkNotNullParameter(surveyAnswerFactory, "surveyAnswerFactory");
        Intrinsics.checkNotNullParameter(urlBuilder, "urlBuilder");
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(surveyLogic, "surveyLogic");
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        Intrinsics.checkNotNullParameter(followUpQuestionRepository, "followUpQuestionRepository");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(workspaceKeyProvider, "workspaceKeyProvider");
    }

    public DisplayEngine(SurvicateActivityLauncher activityLauncher, AnswersManager answersManager, DisplayDesignEngine displayDesignEngine, SurveyThemeProvider surveyThemeProvider, TextRecallingManager textRecallingManager, SurveyStore surveyStore, SurveyAnswerFactory surveyAnswerFactory, UrlBuilder urlBuilder, ViewDependencies viewDependencies, SurveyLogic surveyLogic, DisplayLogicController displayLogic, FollowUpQuestionRepository followUpQuestionRepository, SdkLogger logger, LocaleProvider localeProvider, WorkspaceKeyProvider workspaceKeyProvider, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(activityLauncher, "activityLauncher");
        Intrinsics.checkNotNullParameter(answersManager, "answersManager");
        Intrinsics.checkNotNullParameter(displayDesignEngine, "displayDesignEngine");
        Intrinsics.checkNotNullParameter(surveyThemeProvider, "surveyThemeProvider");
        Intrinsics.checkNotNullParameter(textRecallingManager, "textRecallingManager");
        Intrinsics.checkNotNullParameter(surveyStore, "surveyStore");
        Intrinsics.checkNotNullParameter(surveyAnswerFactory, "surveyAnswerFactory");
        Intrinsics.checkNotNullParameter(urlBuilder, "urlBuilder");
        Intrinsics.checkNotNullParameter(viewDependencies, "viewDependencies");
        Intrinsics.checkNotNullParameter(surveyLogic, "surveyLogic");
        Intrinsics.checkNotNullParameter(displayLogic, "displayLogic");
        Intrinsics.checkNotNullParameter(followUpQuestionRepository, "followUpQuestionRepository");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(workspaceKeyProvider, "workspaceKeyProvider");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.activityLauncher = activityLauncher;
        this.answersManager = answersManager;
        this.displayDesignEngine = displayDesignEngine;
        this.surveyThemeProvider = surveyThemeProvider;
        this.textRecallingManager = textRecallingManager;
        this.surveyStore = surveyStore;
        this.surveyAnswerFactory = surveyAnswerFactory;
        this.urlBuilder = urlBuilder;
        this.viewDependencies = viewDependencies;
        this.surveyLogic = surveyLogic;
        this.displayLogic = displayLogic;
        this.followUpQuestionRepository = followUpQuestionRepository;
        this.logger = logger;
        this.localeProvider = localeProvider;
        this.workspaceKeyProvider = workspaceKeyProvider;
        this.surveyPointObservable = new BehaviourObservable<>();
        this.availableTranslations = CollectionsKt.emptyList();
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(mainDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.activityListeners = new HashMap<>();
        this.surveyPointStack = new Stack<>();
        this.alreadySubmittedQuestions = SetsKt.emptySet();
        this.reloadWorkspace = new Function0() { // from class: com.survicate.surveys.presentation.base.DisplayEngine$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        this.rechallengeSurveys = new Function0() { // from class: com.survicate.surveys.presentation.base.DisplayEngine$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
    }

    public final TextRecallingManager getTextRecallingManager() {
        return this.textRecallingManager;
    }

    public final SurveyStore getSurveyStore() {
        return this.surveyStore;
    }

    public final SurveyAnswerFactory getSurveyAnswerFactory() {
        return this.surveyAnswerFactory;
    }

    public final UrlBuilder getUrlBuilder() {
        return this.urlBuilder;
    }

    public final ViewDependencies getViewDependencies() {
        return this.viewDependencies;
    }

    public final SurveyLogic getSurveyLogic() {
        return this.surveyLogic;
    }

    public final DisplayLogicController getDisplayLogic() {
        return this.displayLogic;
    }

    public final FollowUpQuestionRepository getFollowUpQuestionRepository() {
        return this.followUpQuestionRepository;
    }

    public final SdkLogger getLogger() {
        return this.logger;
    }

    public final LocaleProvider getLocaleProvider() {
        return this.localeProvider;
    }

    public final WorkspaceKeyProvider getWorkspaceKeyProvider() {
        return this.workspaceKeyProvider;
    }

    public /* synthetic */ DisplayEngine(SurvicateActivityLauncher survicateActivityLauncher, AnswersManager answersManager, DisplayDesignEngine displayDesignEngine, SurveyThemeProvider surveyThemeProvider, TextRecallingManager textRecallingManager, SurveyStore surveyStore, SurveyAnswerFactory surveyAnswerFactory, UrlBuilder urlBuilder, ViewDependencies viewDependencies, SurveyLogic surveyLogic, DisplayLogicController displayLogicController, FollowUpQuestionRepository followUpQuestionRepository, SdkLogger sdkLogger, LocaleProvider localeProvider, WorkspaceKeyProvider workspaceKeyProvider, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(survicateActivityLauncher, answersManager, displayDesignEngine, surveyThemeProvider, textRecallingManager, surveyStore, surveyAnswerFactory, urlBuilder, viewDependencies, surveyLogic, displayLogicController, followUpQuestionRepository, sdkLogger, localeProvider, workspaceKeyProvider, (i & 32768) != 0 ? Dispatchers.getMain() : coroutineDispatcher);
    }

    public final BehaviourObservable<SurveyPointDisplayRequest> getSurveyPointObservable() {
        return this.surveyPointObservable;
    }

    public final boolean isShowingSurvey() {
        return this.currentSurvey != null;
    }

    public final Survey getCurrentSurvey() {
        return this.currentSurvey;
    }

    public final List<SurveyTranslation> getAvailableTranslations() {
        return this.availableTranslations;
    }

    public final Function0<Unit> getReloadWorkspace() {
        return this.reloadWorkspace;
    }

    public final void setReloadWorkspace(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.reloadWorkspace = function0;
    }

    public final Function0<Unit> getRechallengeSurveys() {
        return this.rechallengeSurveys;
    }

    public final void setRechallengeSurveys(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.rechallengeSurveys = function0;
    }

    @Override // com.survicate.surveys.presentation.design.DisplayDesignProvider
    public DisplayDesignFactory provideDesignFactory() {
        return this.displayDesignEngine;
    }

    public final void showSurvey(Survey survey, List<SurveyTranslation> translations) {
        Intrinsics.checkNotNullParameter(survey, "survey");
        Intrinsics.checkNotNullParameter(translations, "translations");
        this.currentSurvey = survey;
        this.availableTranslations = translations;
        this.activityLauncher.show();
        showNextOrFinish(resolveNextSurveyPoint(null));
        this.answersManager.surveySeen(survey);
        this.receivedAnswer = false;
    }

    public final void questionAnswered(AnswerDetails answerDetails) {
        Intrinsics.checkNotNullParameter(answerDetails, "answerDetails");
        this.receivedAnswer = true;
        SurveyAnswerAction answerAction = answerDetails.getAnswerAction();
        SurveyPoint surveyPoint = answerDetails.getSurveyPoint();
        if (answerAction.getAnswers().isEmpty()) {
            throw new IllegalArgumentException("The answer list must not be empty to comply with backend contract.".toString());
        }
        this.alreadySubmittedQuestions = SetsKt.plus(this.alreadySubmittedQuestions, Long.valueOf(surveyPoint.getId()));
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84252(answerAction, this, surveyPoint, answerDetails, null), 3, null);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.base.DisplayEngine$questionAnswered$2 */
    /* JADX INFO: compiled from: DisplayEngine.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.base.DisplayEngine$questionAnswered$2", m1609f = "DisplayEngine.kt", m1610i = {0}, m1611l = {112}, m1612m = "invokeSuspend", m1613n = {"nextPoint"}, m1615s = {"L$0"})
    static final class C84252 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SurveyAnswerAction $answerAction;
        final /* synthetic */ AnswerDetails $answerDetails;
        final /* synthetic */ SurveyPoint $question;
        Object L$0;
        int label;
        final /* synthetic */ DisplayEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84252(SurveyAnswerAction surveyAnswerAction, DisplayEngine displayEngine, SurveyPoint surveyPoint, AnswerDetails answerDetails, Continuation<? super C84252> continuation) {
            super(2, continuation);
            this.$answerAction = surveyAnswerAction;
            this.this$0 = displayEngine;
            this.$question = surveyPoint;
            this.$answerDetails = answerDetails;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C84252(this.$answerAction, this.this$0, this.$question, this.$answerDetails, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84252) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SurveyPoint surveyPoint;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ((SurveyAnswer) CollectionsKt.last((List) this.$answerAction.getAnswers())).setFinished(Boxing.boxBoolean(this.this$0.isSurveyFinished(this.$question, this.$answerAction)));
                SurveyPoint surveyPointResolveNextSurveyPoint = this.this$0.resolveNextSurveyPoint(this.$answerAction);
                this.L$0 = surveyPointResolveNextSurveyPoint;
                this.label = 1;
                if (this.this$0.answersManager.questionAnswered(this.$answerDetails, this.this$0.shouldOverwriteNextAnswers, this.this$0.resolveMaxPath(surveyPointResolveNextSurveyPoint), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                surveyPoint = surveyPointResolveNextSurveyPoint;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                surveyPoint = (SurveyPoint) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.showNextOrFinish(surveyPoint);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSurveyFinished(SurveyPoint question, SurveyAnswerAction answerAction) {
        return isLastQuestionOnList(question) || isLastQuestionByLogic(answerAction);
    }

    private final boolean isLastQuestionOnList(SurveyPoint question) {
        List<SurveyPoint> points;
        SurveyPoint surveyPoint;
        Survey survey = this.currentSurvey;
        return (survey == null || (points = survey.getPoints()) == null || (surveyPoint = (SurveyPoint) CollectionsKt.lastOrNull((List) points)) == null || surveyPoint.getId() != question.getId()) ? false : true;
    }

    private final boolean isLastQuestionByLogic(SurveyAnswerAction answerAction) {
        Long nextQuestionId = answerAction.getNextQuestionId();
        return nextQuestionId != null && nextQuestionId.longValue() == -1;
    }

    public final boolean isFirstQuestion(SurveyPoint question) {
        List<SurveyPoint> points;
        SurveyPoint surveyPoint;
        Intrinsics.checkNotNullParameter(question, "question");
        Survey survey = this.currentSurvey;
        return (survey == null || (points = survey.getPoints()) == null || (surveyPoint = (SurveyPoint) CollectionsKt.firstOrNull((List) points)) == null || surveyPoint.getId() != question.getId()) ? false : true;
    }

    public final void surveyClosed() {
        Survey surveyCloseSurvey = closeSurvey();
        if (surveyCloseSurvey == null) {
            return;
        }
        this.answersManager.surveyClosed(surveyCloseSurvey);
        reloadWorkspaceIfNeeded(surveyCloseSurvey);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.base.DisplayEngine$forceClose$1 */
    /* JADX INFO: compiled from: DisplayEngine.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.base.DisplayEngine$forceClose$1", m1609f = "DisplayEngine.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C84241(Continuation<? super C84241> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisplayEngine.this.new C84241(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DisplayEngine.this.closeSurvey();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void forceClose() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84241(null), 3, null);
    }

    public final boolean shouldHideFooter() {
        SurveySettings settings;
        Survey survey = this.currentSurvey;
        if (survey == null || (settings = survey.getSettings()) == null) {
            return true;
        }
        return settings.getHideFooter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNextOrFinish(SurveyPoint nextPoint) {
        if (nextPoint != null) {
            this.surveyPointObservable.notifyObservers(new SurveyPointDisplayRequest(nextPoint, false));
            this.surveyPointStack.push(nextPoint);
        } else {
            Survey surveyCloseSurvey = closeSurvey();
            if (surveyCloseSurvey == null) {
                return;
            }
            this.answersManager.surveyCompleted(surveyCloseSurvey);
            reloadWorkspaceIfNeeded(surveyCloseSurvey);
        }
    }

    public final void showPreviousQuestion() {
        Survey survey = this.currentSurvey;
        if (survey != null && this.surveyPointStack.size() > 1) {
            survey.decrementAnswerCount();
            this.shouldOverwriteNextAnswers = true;
            this.surveyPointStack.pop();
            SurveyPoint surveyPointPeek = this.surveyPointStack.peek();
            Intrinsics.checkNotNull(surveyPointPeek);
            this.surveyPointObservable.notifyObservers(new SurveyPointDisplayRequest(surveyPointPeek, true));
        }
    }

    public final boolean shouldShowProgressBar() {
        SurveySettings settings;
        Survey survey = this.currentSurvey;
        return (survey == null || (settings = survey.getSettings()) == null || !settings.getShowProgressBar()) ? false : true;
    }

    public final String getDefaultSurveyLanguage() {
        SurveySettings settings;
        String surveyLanguage;
        Survey survey = this.currentSurvey;
        if (survey == null || (settings = survey.getSettings()) == null || (surveyLanguage = settings.getSurveyLanguage()) == null) {
            return null;
        }
        String str = surveyLanguage;
        return str.length() != 0 ? str : null;
    }

    public final List<String> getAvailableLanguages() {
        SurveySettings settings;
        List<String> languages;
        String defaultSurveyLanguage = getDefaultSurveyLanguage();
        if (defaultSurveyLanguage == null) {
            return CollectionsKt.emptyList();
        }
        Survey survey = this.currentSurvey;
        if (survey == null || (settings = survey.getSettings()) == null || (languages = settings.getLanguages()) == null) {
            return CollectionsKt.emptyList();
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(defaultSurveyLanguage);
        ArrayList arrayList = new ArrayList();
        for (Object obj : languages) {
            if (!Intrinsics.areEqual((String) obj, defaultSurveyLanguage)) {
                arrayList.add(obj);
            }
        }
        listCreateListBuilder.addAll(arrayList);
        return CollectionsKt.build(listCreateListBuilder);
    }

    public final boolean shouldShowLanguageSelector() {
        SurveySettings settings;
        Survey survey = this.currentSurvey;
        return ((survey == null || (settings = survey.getSettings()) == null) ? false : Intrinsics.areEqual((Object) settings.getShowLanguageSelector(), (Object) true)) && getAvailableLanguages().size() > 1;
    }

    public final void setLayoutDirection(int layoutDirection) {
        ActivityListener activityListener = getActivityListener();
        if (activityListener != null) {
            activityListener.setLayoutDirection(layoutDirection);
        }
    }

    public final double getSurveyProgressInPercents(SurveyPoint surveyPoint) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        Survey survey = this.currentSurvey;
        return survey == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : this.answersManager.calculateCompletionRate(survey.getAnswerCount(), surveyPoint.getMaxPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Survey closeSurvey() {
        Survey survey = this.currentSurvey;
        if (survey == null) {
            return null;
        }
        ActivityListener activityListener = getActivityListener();
        if (activityListener != null) {
            activityListener.finishActivity();
        }
        this.surveyStore.clearStore();
        this.currentActivityUuid = null;
        this.alreadySubmittedQuestions = SetsKt.emptySet();
        this.surveyPointStack.clear();
        this.shouldOverwriteNextAnswers = false;
        this.currentSurvey = null;
        return survey;
    }

    private final void reloadWorkspaceIfNeeded(Survey survey) {
        boolean zIsSurveyFastRecurring = isSurveyFastRecurring(survey);
        if (!this.receivedAnswer || !zIsSurveyFastRecurring) {
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84261(null), 3, null);
        } else {
            this.reloadWorkspace.invoke();
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.presentation.base.DisplayEngine$reloadWorkspaceIfNeeded$1 */
    /* JADX INFO: compiled from: DisplayEngine.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.presentation.base.DisplayEngine$reloadWorkspaceIfNeeded$1", m1609f = "DisplayEngine.kt", m1610i = {}, m1611l = {231}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C84261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C84261(Continuation<? super C84261> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DisplayEngine.this.new C84261(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(400L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            DisplayEngine.this.getRechallengeSurveys().invoke();
            return Unit.INSTANCE;
        }
    }

    private final boolean isSurveyFastRecurring(Survey survey) {
        SurveySettings settings = survey.getSettings();
        return settings.getRecurring() && ((settings.getRecurringPeriodSeconds() > (-1L) ? 1 : (settings.getRecurringPeriodSeconds() == (-1L) ? 0 : -1)) == 0 || (settings.getRecurringPeriodSeconds() > TimeUnit.MINUTES.toSeconds(10L) ? 1 : (settings.getRecurringPeriodSeconds() == TimeUnit.MINUTES.toSeconds(10L) ? 0 : -1)) <= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int resolveMaxPath(SurveyPoint nextPoint) {
        if (nextPoint == null) {
            return 0;
        }
        return nextPoint.getMaxPath() + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SurveyPoint resolveNextSurveyPoint(SurveyAnswerAction answerAction) {
        Integer numValueOf;
        Survey survey = this.currentSurvey;
        if (survey == null) {
            this.logger.error(LogTags.PRESENTATION, "Current survey is null. It's an internal error.", new IllegalStateException("Current survey is null. It's an internal error."));
            return null;
        }
        if (!checkSurveyNotEmpty(survey)) {
            return null;
        }
        if (answerAction == null) {
            return survey.getPoints().get(0);
        }
        if (answerAction.getNextQuestionId() != null) {
            numValueOf = findPointIndexById(survey, answerAction.getNextQuestionId().longValue());
        } else {
            Integer numFindPointIndexById = findPointIndexById(survey, answerAction.getCurrentQuestionId());
            numValueOf = (numFindPointIndexById == null || numFindPointIndexById.intValue() + 1 >= survey.getPoints().size()) ? null : Integer.valueOf(numFindPointIndexById.intValue() + 1);
        }
        if (numValueOf != null) {
            numValueOf = nextPointIdByDisplayLogic(survey, numValueOf.intValue());
        }
        if (numValueOf != null) {
            return survey.getPoints().get(numValueOf.intValue());
        }
        return null;
    }

    private final Integer nextPointIdByDisplayLogic(Survey currentSurvey, int nextQuestionIndex) {
        List<QuestionAnswerItem> answers = this.surveyStore.getAnswers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(answers, 10));
        Iterator<T> it = answers.iterator();
        while (it.hasNext()) {
            arrayList.add(((QuestionAnswerItem) it.next()).getAnswer());
        }
        Long lResolveNextPointId = DisplayLogicController.INSTANCE.resolveNextPointId(CollectionsKt.filterNotNull(arrayList), getQuestionSuggestionsFrom(nextQuestionIndex));
        if (lResolveNextPointId != null) {
            return findPointIndexById(currentSurvey, lResolveNextPointId.longValue());
        }
        return null;
    }

    private final boolean checkSurveyNotEmpty(Survey survey) {
        if (!survey.getPoints().isEmpty()) {
            return true;
        }
        this.logger.info(LogTags.PRESENTATION, "Survey " + survey.getName() + '(' + survey.getId() + ") has no questions to show.");
        return false;
    }

    private final Integer findPointIndexById(Survey survey, long j) {
        int size = survey.getPoints().size();
        for (int i = 0; i < size; i++) {
            if (survey.getPoints().get(i).getId() == j) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    public final boolean isSurveyFullScreen() {
        SurveySettings settings;
        Survey survey = this.currentSurvey;
        if (survey == null || (settings = survey.getSettings()) == null) {
            return true;
        }
        return Intrinsics.areEqual(settings.getPresentationStyle(), PresentationStyle.FULLSCREEN);
    }

    public final void setActivityListener(ActivityListener activityListener, String activityUuid) {
        Intrinsics.checkNotNullParameter(activityListener, "activityListener");
        Intrinsics.checkNotNullParameter(activityUuid, "activityUuid");
        this.activityListeners.put(activityUuid, activityListener);
        this.currentActivityUuid = activityUuid;
    }

    public final void clearActivityListener(String activityUuid) {
        Intrinsics.checkNotNullParameter(activityUuid, "activityUuid");
        this.activityListeners.remove(activityUuid);
    }

    private final ActivityListener getActivityListener() {
        String str = this.currentActivityUuid;
        if (str == null) {
            return null;
        }
        return this.activityListeners.get(str);
    }

    public final Theme getSurveyTheme(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Survey survey = this.currentSurvey;
        if (survey == null) {
            return null;
        }
        return this.surveyThemeProvider.getCurrentTheme(survey.getTheme(), context);
    }

    public final SurveyMessages getSurveyMessages() {
        SurveySettings settings;
        SurveyMessages messages;
        Survey survey = this.currentSurvey;
        return (survey == null || (settings = survey.getSettings()) == null || (messages = settings.getMessages()) == null) ? new SurveyMessages((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null) : messages;
    }

    public final Integer getSurveyFollowUpLimit() {
        SurveySettings settings;
        Survey survey = this.currentSurvey;
        if (survey == null || (settings = survey.getSettings()) == null) {
            return null;
        }
        return settings.getFollowupLimit();
    }

    public final boolean hasNavigationButtons() {
        Survey survey = this.currentSurvey;
        if (survey == null) {
            return false;
        }
        return survey.getSettings().getNavigationEnabled();
    }

    public final boolean wasQuestionAlreadySubmitted(SurveyPoint surveyPoint) {
        Intrinsics.checkNotNullParameter(surveyPoint, "surveyPoint");
        return this.alreadySubmittedQuestions.contains(Long.valueOf(surveyPoint.getId()));
    }

    public final void setWorkspaceReloadAction(final WorkspaceLoader workspaceLoader) {
        Intrinsics.checkNotNullParameter(workspaceLoader, "workspaceLoader");
        this.reloadWorkspace = new Function0() { // from class: com.survicate.surveys.presentation.base.DisplayEngine$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DisplayEngine.setWorkspaceReloadAction$lambda$7(workspaceLoader);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setWorkspaceReloadAction$lambda$7(WorkspaceLoader workspaceLoader) {
        workspaceLoader.loadWorkspace(true);
        return Unit.INSTANCE;
    }

    private final List<QuestionSuggestion> getQuestionSuggestionsFrom(int index) {
        Survey survey = this.currentSurvey;
        if (survey == null) {
            return CollectionsKt.emptyList();
        }
        List<SurveyPoint> listSubList = survey.getPoints().subList(index, survey.getPoints().size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList, 10));
        Iterator<T> it = listSubList.iterator();
        while (it.hasNext()) {
            arrayList.add(DisplayLogicExKt.toQuestionSuggestion((SurveyPoint) it.next()));
        }
        return arrayList;
    }
}
