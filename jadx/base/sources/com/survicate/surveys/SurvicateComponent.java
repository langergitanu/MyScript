package com.survicate.surveys;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.survicate.surveys.components.surveyLogic.SurveyLogic;
import com.survicate.surveys.components.surveyLogic.SurveyLogicImpl;
import com.survicate.surveys.core.logging.LoggerConfig;
import com.survicate.surveys.core.logging.LoggerFactoryKt;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.logic.display.DisplayLogicController;
import com.survicate.surveys.core.providers.ActiveScreenProvider;
import com.survicate.surveys.core.providers.ActiveScreenStore;
import com.survicate.surveys.core.providers.PresentationStateProvider;
import com.survicate.surveys.core.providers.SurveyChanceStore;
import com.survicate.surveys.core.queue.SurvicateTaskScheduler;
import com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore;
import com.survicate.surveys.core.targeting.backend.SurvicateBackendTargetingResultStore;
import com.survicate.surveys.core.targeting.provider.CoreUserTraitsProvider;
import com.survicate.surveys.core.utils.Executor;
import com.survicate.surveys.core.utils.SurvicateExecutor;
import com.survicate.surveys.helpers.AndroidLocaleProvider;
import com.survicate.surveys.helpers.NetworkStateProvider;
import com.survicate.surveys.helpers.SurvicateLogger;
import com.survicate.surveys.helpers.ViewDependencies;
import com.survicate.surveys.helpers.ViewDependenciesImpl;
import com.survicate.surveys.helpers.url.UrlBuilder;
import com.survicate.surveys.helpers.url.UrlBuilderImpl;
import com.survicate.surveys.infrastructure.environment.HostProvider;
import com.survicate.surveys.infrastructure.environment.SurvicateHostProvider;
import com.survicate.surveys.infrastructure.environment.SurvicateUrlProvider;
import com.survicate.surveys.infrastructure.environment.UrlProvider;
import com.survicate.surveys.infrastructure.environment.WorkspaceKeyStore;
import com.survicate.surveys.infrastructure.network.RespondentApi;
import com.survicate.surveys.infrastructure.network.RespondentRequestFactory;
import com.survicate.surveys.infrastructure.network.SuggestionsApi;
import com.survicate.surveys.infrastructure.network.SuggestionsRequestFactory;
import com.survicate.surveys.infrastructure.network.SurvicateHttpClient;
import com.survicate.surveys.infrastructure.network.SurvicateRespondentApi;
import com.survicate.surveys.infrastructure.network.SurvicateRespondentRequestFactory;
import com.survicate.surveys.infrastructure.network.SurvicateSuggestionsApi;
import com.survicate.surveys.infrastructure.network.SurvicateSuggestionsRequestFactory;
import com.survicate.surveys.infrastructure.network.SurvicateWorkspaceApi;
import com.survicate.surveys.infrastructure.network.SurvicateWorkspaceRequestFactory;
import com.survicate.surveys.infrastructure.network.WorkspaceApi;
import com.survicate.surveys.infrastructure.network.WorkspaceRequestFactory;
import com.survicate.surveys.infrastructure.network.contacts.ContactsApi;
import com.survicate.surveys.infrastructure.network.contacts.ContactsRequestFactory;
import com.survicate.surveys.infrastructure.network.contacts.ContactsSerializer;
import com.survicate.surveys.infrastructure.network.contacts.SurvicateContactsApi;
import com.survicate.surveys.infrastructure.network.contacts.SurvicateContactsRequestFactory;
import com.survicate.surveys.infrastructure.network.contacts.SurvicateContactsSerializer;
import com.survicate.surveys.infrastructure.network.image.SurvicateImageLoader;
import com.survicate.surveys.infrastructure.network.image.SurvicateImageLoaderImpl;
import com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionApi;
import com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionRepository;
import com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionRequestFactory;
import com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionSerializer;
import com.survicate.surveys.infrastructure.network.p038ai.SurvicateFollowUpQuestionApi;
import com.survicate.surveys.infrastructure.network.p038ai.SurvicateFollowUpQuestionRepository;
import com.survicate.surveys.infrastructure.network.p038ai.SurvicateFollowUpQuestionRequestFactory;
import com.survicate.surveys.infrastructure.network.p038ai.SurvicateFollowUpQuestionSerializer;
import com.survicate.surveys.infrastructure.serialization.JsonSerializationProvider;
import com.survicate.surveys.infrastructure.serialization.RespondentSerializer;
import com.survicate.surveys.infrastructure.serialization.SuggestionsSerializer;
import com.survicate.surveys.infrastructure.serialization.SurvicateJsonSerializer;
import com.survicate.surveys.infrastructure.serialization.SurvicateRespondentSerializer;
import com.survicate.surveys.infrastructure.serialization.SurvicateSerializer;
import com.survicate.surveys.infrastructure.serialization.SurvicateSuggestionsSerializer;
import com.survicate.surveys.infrastructure.serialization.SurvicateWorkspaceSerializer;
import com.survicate.surveys.infrastructure.serialization.WorkspaceSerializer;
import com.survicate.surveys.infrastructure.storage.SerializedSharedPrefsSurvicateStore;
import com.survicate.surveys.infrastructure.storage.SerializedSharedPrefsSurvicateSynchronizationStore;
import com.survicate.surveys.infrastructure.storage.SurvicateSessionStore;
import com.survicate.surveys.infrastructure.storage.SurvicateStore;
import com.survicate.surveys.infrastructure.storage.SurvicateSuggestionsRepository;
import com.survicate.surveys.infrastructure.storage.SurvicateSynchronizationStore;
import com.survicate.surveys.infrastructure.storage.contacts.ContactActionSerializer;
import com.survicate.surveys.infrastructure.storage.contacts.ContactAttributesThrottle;
import com.survicate.surveys.infrastructure.storage.contacts.ContactEventsThrottle;
import com.survicate.surveys.infrastructure.storage.contacts.ContactStore;
import com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository;
import com.survicate.surveys.infrastructure.storage.contacts.EmptyContactsRepository;
import com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactActionSerializer;
import com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactAttributesThrottle;
import com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactEventsThrottle;
import com.survicate.surveys.infrastructure.storage.contacts.SurvicateContactsRepository;
import com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventHistoryStore;
import com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventStore;
import com.survicate.surveys.infrastructure.storage.interfaces.LocaleStore;
import com.survicate.surveys.infrastructure.storage.interfaces.PresentationStateStore;
import com.survicate.surveys.infrastructure.storage.interfaces.RespondentProvider;
import com.survicate.surveys.infrastructure.storage.interfaces.SuggestionsRepository;
import com.survicate.surveys.infrastructure.storage.interfaces.SurvicateFontSystemProvider;
import com.survicate.surveys.infrastructure.storage.interfaces.SurvicateFontSystemStore;
import com.survicate.surveys.infrastructure.storage.respondent.RespondentRepository;
import com.survicate.surveys.infrastructure.storage.respondent.RespondentStore;
import com.survicate.surveys.infrastructure.storage.respondent.SurvicateRespondentRepository;
import com.survicate.surveys.infrastructure.storage.survey.SurveyAnswerFactory;
import com.survicate.surveys.infrastructure.storage.survey.SurveyStore;
import com.survicate.surveys.presentation.base.DisplayEngine;
import com.survicate.surveys.presentation.base.SurvicateActivityLauncher;
import com.survicate.surveys.presentation.design.DisplayDesignEngine;
import com.survicate.surveys.presentation.design.SurvicateDisplayDesignEngine;
import com.survicate.surveys.presentation.theming.FontProvider;
import com.survicate.surveys.presentation.theming.SurvicateFontProvider;
import com.survicate.surveys.targeting.BackendTargetingResultLoader;
import com.survicate.surveys.targeting.DisabledTimeIntervalTargeting;
import com.survicate.surveys.targeting.EventDelayTargeting;
import com.survicate.surveys.targeting.EventDelayTargetingImpl;
import com.survicate.surveys.targeting.ScreenDelayTargeting;
import com.survicate.surveys.targeting.SurvicateTimeIntervalTargeting;
import com.survicate.surveys.targeting.TargetingEngine;
import com.survicate.surveys.targeting.TargetingFiltersFactory;
import com.survicate.surveys.targeting.TimeIntervalTargeting;
import com.survicate.surveys.targeting.provider.ActiveEventProvider;
import com.survicate.surveys.targeting.provider.DelayedEventProvider;
import com.survicate.surveys.targeting.provider.PresentationTimesProvider;
import com.survicate.surveys.targeting.provider.SeenSurveysProvider;
import com.survicate.surveys.targeting.provider.UserTraitsProvider;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.AndroidScreenOrientationProvider;
import com.survicate.surveys.utils.AndroidScreenOrientationProviderImpl;
import com.survicate.surveys.utils.AppLifecycleProvider;
import com.survicate.surveys.utils.AppStateProvider;
import com.survicate.surveys.utils.FeatureFlags;
import com.survicate.surveys.utils.SurvicateAppLifecycleProvider;
import com.survicate.surveys.utils.SurvicateAppStateProvider;
import com.survicate.surveys.utils.SurvicateThemeModeStore;
import com.survicate.surveys.utils.ThemeModeStore;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: SurvicateComponent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0098\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0007\u0010\u0089\u0001\u001a\u00020\tJ\u0007\u0010\u008a\u0001\u001a\u00020\rJ\u0007\u0010\u008b\u0001\u001a\u00020\u000fJ\u0007\u0010\u008c\u0001\u001a\u00020\u000bJ\u0007\u0010\u008d\u0001\u001a\u00020\u0018J\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0002J\u0007\u0010\u0090\u0001\u001a\u00020\u0011J\u0007\u0010\u0091\u0001\u001a\u00020\u0016J\u0007\u0010\u0092\u0001\u001a\u00020&J\t\u0010\u0093\u0001\u001a\u00020&H\u0002J\t\u0010\u0094\u0001\u001a\u00020NH\u0002J\t\u0010\u0095\u0001\u001a\u00020RH\u0002J\t\u0010\u0096\u0001\u001a\u00020PH\u0002J\t\u0010\u0097\u0001\u001a\u00020LH\u0002J\t\u0010\u0098\u0001\u001a\u000204H\u0002J\t\u0010\u0099\u0001\u001a\u000206H\u0002J\t\u0010\u009a\u0001\u001a\u00020\"H\u0002J\t\u0010\u009b\u0001\u001a\u00020$H\u0002J\t\u0010\u009c\u0001\u001a\u00020 H\u0002J\t\u0010\u009d\u0001\u001a\u000208H\u0002J\t\u0010\u009e\u0001\u001a\u00020\u001eH\u0002J\t\u0010\u009f\u0001\u001a\u00020\u001aH\u0002J\b\u0010 \u0001\u001a\u00030¡\u0001J\n\u0010¢\u0001\u001a\u00030£\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030¥\u0001H\u0002J\n\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\n\u0010¨\u0001\u001a\u00030©\u0001H\u0002J\t\u0010ª\u0001\u001a\u00020\u001cH\u0002J\t\u0010«\u0001\u001a\u00020\u0013H\u0002J\u0007\u0010¬\u0001\u001a\u00020\u0013J\t\u0010\u00ad\u0001\u001a\u00020(H\u0002J\t\u0010®\u0001\u001a\u00020*H\u0002J\t\u0010¯\u0001\u001a\u00020,H\u0002J\t\u0010°\u0001\u001a\u00020.H\u0002J\t\u0010±\u0001\u001a\u000200H\u0002J\n\u0010²\u0001\u001a\u00030³\u0001H\u0002J\n\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\n\u0010¶\u0001\u001a\u00030·\u0001H\u0002J\n\u0010¸\u0001\u001a\u00030¹\u0001H\u0002J\n\u0010º\u0001\u001a\u00030»\u0001H\u0002J\n\u0010¼\u0001\u001a\u00030½\u0001H\u0002J\n\u0010¾\u0001\u001a\u00030¿\u0001H\u0002J\n\u0010À\u0001\u001a\u00030Á\u0001H\u0002J\n\u0010Â\u0001\u001a\u00030Ã\u0001H\u0002J\t\u0010Ä\u0001\u001a\u000202H\u0002J\t\u0010Å\u0001\u001a\u00020:H\u0002J\u0007\u0010Æ\u0001\u001a\u00020<J\b\u0010Ç\u0001\u001a\u00030È\u0001J\n\u0010É\u0001\u001a\u00030Ê\u0001H\u0002J\t\u0010Ë\u0001\u001a\u00020>H\u0002J\t\u0010Ì\u0001\u001a\u00020@H\u0002J\t\u0010Í\u0001\u001a\u00020BH\u0002J\u0007\u0010Î\u0001\u001a\u00020FJ\t\u0010Ï\u0001\u001a\u00020HH\u0002J\t\u0010Ð\u0001\u001a\u00020JH\u0002J\t\u0010Ñ\u0001\u001a\u00020TH\u0002J\t\u0010Ò\u0001\u001a\u00020VH\u0002J\t\u0010Ó\u0001\u001a\u00020XH\u0002J\t\u0010Ô\u0001\u001a\u00020ZH\u0002J\t\u0010Õ\u0001\u001a\u00020\\H\u0002J\t\u0010Ö\u0001\u001a\u00020^H\u0002J\t\u0010×\u0001\u001a\u00020`H\u0002J\t\u0010Ø\u0001\u001a\u00020bH\u0002J\t\u0010Ù\u0001\u001a\u00020DH\u0002J\t\u0010Ú\u0001\u001a\u00020dH\u0002J\t\u0010Û\u0001\u001a\u00020fH\u0002J\t\u0010Ü\u0001\u001a\u00020hH\u0002J\t\u0010Ý\u0001\u001a\u00020jH\u0002J\t\u0010Þ\u0001\u001a\u00020lH\u0002J\t\u0010ß\u0001\u001a\u00020nH\u0002J\u0007\u0010à\u0001\u001a\u00020xJ\t\u0010á\u0001\u001a\u00020xH\u0002J\t\u0010â\u0001\u001a\u00020pH\u0002J\t\u0010ã\u0001\u001a\u00020rH\u0002J\t\u0010ä\u0001\u001a\u00020tH\u0002J\t\u0010å\u0001\u001a\u00020vH\u0002J\n\u0010æ\u0001\u001a\u00030ç\u0001H\u0002J\n\u0010è\u0001\u001a\u00030é\u0001H\u0002J\t\u0010ê\u0001\u001a\u00020zH\u0002J\t\u0010ë\u0001\u001a\u00020|H\u0002J\t\u0010ì\u0001\u001a\u00020~H\u0002J\t\u0010í\u0001\u001a\u00020~H\u0002J\n\u0010î\u0001\u001a\u00030\u0080\u0001H\u0002J\n\u0010ï\u0001\u001a\u00030\u0082\u0001H\u0002J\n\u0010ð\u0001\u001a\u00030\u0084\u0001H\u0002J\b\u0010ñ\u0001\u001a\u00030\u0086\u0001J\b\u0010ò\u0001\u001a\u00030\u0088\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u0004\u0018\u00010pX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010s\u001a\u0004\u0018\u00010tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u0004\u0018\u00010vX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u00010|X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u0004\u0018\u00010~X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006ó\u0001"}, m1599d2 = {"Lcom/survicate/surveys/SurvicateComponent;", "", "applicationContext", "Landroid/content/Context;", "loggerEnabled", "", "<init>", "(Landroid/content/Context;Z)V", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "answersManager", "Lcom/survicate/surveys/AnswersManager;", "persistenceManager", "Lcom/survicate/surveys/PersistenceManager;", "eventManager", "Lcom/survicate/surveys/EventManager;", "targetingEngine", "Lcom/survicate/surveys/targeting/TargetingEngine;", "sdkLogger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "survicateLogger", "workspaceLoader", "Lcom/survicate/surveys/WorkspaceLoader;", "respondentRepository", "Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentRepository;", "sessionStore", "Lcom/survicate/surveys/infrastructure/storage/SurvicateSessionStore;", "textRecallingManager", "Lcom/survicate/surveys/TextRecallingManager;", "jsonSerialization", "Lkotlinx/serialization/json/Json;", "serializer", "Lcom/survicate/surveys/infrastructure/serialization/SurvicateSerializer;", "survicateStore", "Lcom/survicate/surveys/infrastructure/storage/SurvicateStore;", "sharedPrefs", "Landroid/content/SharedPreferences;", "workspaceKeyStore", "Lcom/survicate/surveys/infrastructure/environment/WorkspaceKeyStore;", "localeProvider", "Lcom/survicate/surveys/helpers/AndroidLocaleProvider;", "screenOrientationProvider", "Lcom/survicate/surveys/utils/AndroidScreenOrientationProvider;", "networkStateProvider", "Lcom/survicate/surveys/helpers/NetworkStateProvider;", "synchronizationStore", "Lcom/survicate/surveys/infrastructure/storage/SurvicateSynchronizationStore;", "targetingFiltersFactory", "Lcom/survicate/surveys/targeting/TargetingFiltersFactory;", "versionProvider", "Lcom/survicate/surveys/SurvicateVersionProvider;", "hostProvider", "Lcom/survicate/surveys/infrastructure/environment/HostProvider;", "urlProvider", "Lcom/survicate/surveys/infrastructure/environment/UrlProvider;", "httpClient", "Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;", "displayDesignEngine", "Lcom/survicate/surveys/presentation/design/DisplayDesignEngine;", "themeModeStore", "Lcom/survicate/surveys/utils/ThemeModeStore;", "urlBuilder", "Lcom/survicate/surveys/helpers/url/UrlBuilder;", "imageLoader", "Lcom/survicate/surveys/infrastructure/network/image/SurvicateImageLoader;", "surveyLogic", "Lcom/survicate/surveys/components/surveyLogic/SurveyLogic;", "displayLogicController", "Lcom/survicate/surveys/core/logic/display/DisplayLogicController;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "screenDelayTargeting", "Lcom/survicate/surveys/targeting/ScreenDelayTargeting;", "eventDelayTargeting", "Lcom/survicate/surveys/targeting/EventDelayTargeting;", "respondentApi", "Lcom/survicate/surveys/infrastructure/network/RespondentApi;", "workspaceApi", "Lcom/survicate/surveys/infrastructure/network/WorkspaceApi;", "workspaceSerializer", "Lcom/survicate/surveys/infrastructure/serialization/WorkspaceSerializer;", "workspaceRequestFactory", "Lcom/survicate/surveys/infrastructure/network/WorkspaceRequestFactory;", "suggestionsRepository", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SuggestionsRepository;", "suggestionsApi", "Lcom/survicate/surveys/infrastructure/network/SuggestionsApi;", "suggestionsRequestFactory", "Lcom/survicate/surveys/infrastructure/network/SuggestionsRequestFactory;", "suggestionsSerializer", "Lcom/survicate/surveys/infrastructure/serialization/SuggestionsSerializer;", "respondentRequestFactory", "Lcom/survicate/surveys/infrastructure/network/RespondentRequestFactory;", "respondentSerializer", "Lcom/survicate/surveys/infrastructure/serialization/RespondentSerializer;", "surveyStore", "Lcom/survicate/surveys/infrastructure/storage/survey/SurveyStore;", "surveyAnswerFactory", "Lcom/survicate/surveys/infrastructure/storage/survey/SurveyAnswerFactory;", "viewDependencies", "Lcom/survicate/surveys/helpers/ViewDependencies;", "fontProvider", "Lcom/survicate/surveys/presentation/theming/FontProvider;", "followUpQuestionRepository", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;", "followUpQuestionApi", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionApi;", "followUpQuestionRequestFactory", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestFactory;", "followUpQuestionSerializer", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionSerializer;", "contactsApi", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsApi;", "contactsRequestFactory", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsRequestFactory;", "contactsSerializer", "Lcom/survicate/surveys/infrastructure/network/contacts/ContactsSerializer;", "contactActionSerializer", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactActionSerializer;", "contactsRepository", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;", "backendTargetingResultLoader", "Lcom/survicate/surveys/targeting/BackendTargetingResultLoader;", "backendTargetingResultStore", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;", "timeIntervalTargeting", "Lcom/survicate/surveys/targeting/TimeIntervalTargeting;", "appLifecycleProvider", "Lcom/survicate/surveys/utils/AppLifecycleProvider;", "appStateProvider", "Lcom/survicate/surveys/utils/AppStateProvider;", "contactEventsThrottle", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactEventsThrottle;", "contactAttributesThrottle", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactAttributesThrottle;", "sdkExecutor", "Lcom/survicate/surveys/core/utils/Executor;", "obtainDisplayEngine", "obtainPersistenceManager", "obtainEventManager", "obtainAnswersManager", "provideRespondentRepository", "provideRespondentStore", "Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentStore;", "obtainTargetingEngine", "obtainWorkspaceLoader", "obtainWorkspaceKeyStore", "provideWorkspaceKeyStore", "provideWorkspaceApi", "provideWorkspaceRequestFactory", "provideWorkspaceSerializer", "provideRespondentApi", "provideHostProvider", "provideUrlProvider", "provideSurvicateStore", "provideSharedPreferences", "provideSerializer", "provideHttpClient", "provideJsonSerialization", "provideSessionStore", "provideLocaleStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/LocaleStore;", "provideActiveScreenStore", "Lcom/survicate/surveys/core/providers/ActiveScreenStore;", "provideActiveEventStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventStore;", "providePresentationStateStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/PresentationStateStore;", "provideActiveEventHistoryStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventHistoryStore;", "provideTextRecallingManager", "provideSdkLogger", "provideLogger", "provideLocaleProvider", "provideScreenOrientationProvider", "provideNetworkStateProvider", "provideSynchronizationStore", "provideTargetingFiltersFactory", "provideActiveScreenProvider", "Lcom/survicate/surveys/core/providers/ActiveScreenProvider;", "provideActiveEventProvider", "Lcom/survicate/surveys/targeting/provider/ActiveEventProvider;", "provideUserTraitsProvider", "Lcom/survicate/surveys/targeting/provider/UserTraitsProvider;", "provideCoreUserTraitsProvider", "Lcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;", "provideSeenSurveysProvider", "Lcom/survicate/surveys/targeting/provider/SeenSurveysProvider;", "providePresentationTimesProvider", "Lcom/survicate/surveys/targeting/provider/PresentationTimesProvider;", "provideDelayedEventProvider", "Lcom/survicate/surveys/targeting/provider/DelayedEventProvider;", "providePresentationStateProvider", "Lcom/survicate/surveys/core/providers/PresentationStateProvider;", "provideSurveyChanceStore", "Lcom/survicate/surveys/core/providers/SurveyChanceStore;", "provideVersionProvider", "provideDisplayDesignEngine", "provideThemeModeStore", "provideFontSystemStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SurvicateFontSystemStore;", "provideFontSystemProvider", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SurvicateFontSystemProvider;", "provideUrlBuilder", "provideImageLoader", "provideSurveyLogic", "provideTimestampProvider", "provideScreenDelayTargeting", "provideEventDelayTargeting", "provideSuggestionsRepository", "provideSuggestionsApi", "provideSuggestionsRequestFactory", "provideSuggestionsSerializer", "provideRespondentRequestFactory", "provideRespondentSerializer", "provideSurveyStore", "provideSurveyAnswerFactory", "provideDisplayLogicController", "provideViewDependencies", "provideFontProvider", "provideFollowUpQuestionRepository", "provideFollowUpQuestionApi", "provideFollowUpQuestionRequestFactory", "provideFollowUpQuestionSerializer", "provideContactsRepository", "createContactsRepository", "provideContactsApi", "provideContactsRequestFactory", "provideContactsSerializer", "provideContactActionSerializer", "provideContactStore", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactStore;", "provideRespondentProvider", "Lcom/survicate/surveys/infrastructure/storage/interfaces/RespondentProvider;", "provideBackendTargetingResultLoader", "provideBackendTargetingResultStore", "provideTimeIntervalTargeting", "createTimeIntervalTargeting", "provideAppLifecycleProvider", "provideAppStateProvider", "provideContactEventsThrottle", "provideContactAttributesThrottle", "provideSdkExecutor", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateComponent {
    private AnswersManager answersManager;
    private AppLifecycleProvider appLifecycleProvider;
    private AppStateProvider appStateProvider;
    private final Context applicationContext;
    private BackendTargetingResultLoader backendTargetingResultLoader;
    private BackendTargetingResultStore backendTargetingResultStore;
    private ContactActionSerializer contactActionSerializer;
    private ContactAttributesThrottle contactAttributesThrottle;
    private ContactEventsThrottle contactEventsThrottle;
    private ContactsApi contactsApi;
    private ContactsRepository contactsRepository;
    private ContactsRequestFactory contactsRequestFactory;
    private ContactsSerializer contactsSerializer;
    private DisplayDesignEngine displayDesignEngine;
    private DisplayEngine displayEngine;
    private DisplayLogicController displayLogicController;
    private EventDelayTargeting eventDelayTargeting;
    private EventManager eventManager;
    private FollowUpQuestionApi followUpQuestionApi;
    private FollowUpQuestionRepository followUpQuestionRepository;
    private FollowUpQuestionRequestFactory followUpQuestionRequestFactory;
    private FollowUpQuestionSerializer followUpQuestionSerializer;
    private FontProvider fontProvider;
    private HostProvider hostProvider;
    private SurvicateHttpClient httpClient;
    private SurvicateImageLoader imageLoader;
    private Json jsonSerialization;
    private AndroidLocaleProvider localeProvider;
    private final boolean loggerEnabled;
    private NetworkStateProvider networkStateProvider;
    private PersistenceManager persistenceManager;
    private RespondentApi respondentApi;
    private RespondentRepository respondentRepository;
    private RespondentRequestFactory respondentRequestFactory;
    private RespondentSerializer respondentSerializer;
    private ScreenDelayTargeting screenDelayTargeting;
    private AndroidScreenOrientationProvider screenOrientationProvider;
    private Executor sdkExecutor;
    private SdkLogger sdkLogger;
    private SurvicateSerializer serializer;
    private SurvicateSessionStore sessionStore;
    private SharedPreferences sharedPrefs;
    private SuggestionsApi suggestionsApi;
    private SuggestionsRepository suggestionsRepository;
    private SuggestionsRequestFactory suggestionsRequestFactory;
    private SuggestionsSerializer suggestionsSerializer;
    private SurveyAnswerFactory surveyAnswerFactory;
    private SurveyLogic surveyLogic;
    private SurveyStore surveyStore;
    private SdkLogger survicateLogger;
    private SurvicateStore survicateStore;
    private SurvicateSynchronizationStore synchronizationStore;
    private TargetingEngine targetingEngine;
    private TargetingFiltersFactory targetingFiltersFactory;
    private TextRecallingManager textRecallingManager;
    private ThemeModeStore themeModeStore;
    private TimeIntervalTargeting timeIntervalTargeting;
    private TimestampProvider timestampProvider;
    private UrlBuilder urlBuilder;
    private UrlProvider urlProvider;
    private SurvicateVersionProvider versionProvider;
    private ViewDependencies viewDependencies;
    private WorkspaceApi workspaceApi;
    private WorkspaceKeyStore workspaceKeyStore;
    private WorkspaceLoader workspaceLoader;
    private WorkspaceRequestFactory workspaceRequestFactory;
    private WorkspaceSerializer workspaceSerializer;

    public SurvicateComponent(Context applicationContext, boolean z) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
        this.loggerEnabled = z;
    }

    public final synchronized DisplayEngine obtainDisplayEngine() {
        DisplayEngine displayEngine;
        if (this.displayEngine == null) {
            this.displayEngine = new DisplayEngine(new SurvicateActivityLauncher(this.applicationContext, provideLogger()), obtainAnswersManager(), provideDisplayDesignEngine(), provideThemeModeStore(), provideTextRecallingManager(), provideSurveyStore(), provideSurveyAnswerFactory(), provideUrlBuilder(), provideViewDependencies(), provideSurveyLogic(), provideDisplayLogicController(), provideFollowUpQuestionRepository(), provideLogger(), provideLocaleProvider(), provideWorkspaceKeyStore(), null, 32768, null);
        }
        displayEngine = this.displayEngine;
        Intrinsics.checkNotNull(displayEngine);
        return displayEngine;
    }

    public final synchronized PersistenceManager obtainPersistenceManager() {
        PersistenceManager persistenceManager;
        if (this.persistenceManager == null) {
            this.persistenceManager = new PersistenceManager(provideSurvicateStore(), provideSynchronizationStore(), provideSessionStore(), provideVersionProvider(), null, 16, null);
        }
        persistenceManager = this.persistenceManager;
        Intrinsics.checkNotNull(persistenceManager);
        return persistenceManager;
    }

    public final synchronized EventManager obtainEventManager() {
        EventManager eventManager;
        if (this.eventManager == null) {
            this.eventManager = new EventManager(new Handler(Looper.getMainLooper()), obtainPersistenceManager());
        }
        eventManager = this.eventManager;
        Intrinsics.checkNotNull(eventManager);
        return eventManager;
    }

    public final synchronized AnswersManager obtainAnswersManager() {
        AnswersManager answersManager;
        if (this.answersManager == null) {
            CoroutineDispatcher coroutineDispatcher = null;
            this.answersManager = new AnswersManager(obtainPersistenceManager(), obtainEventManager(), provideRespondentRepository(), provideContactsRepository(), provideTimestampProvider(), provideLogger(), new C83711(provideSdkExecutor(), null), coroutineDispatcher, 128, null);
        }
        answersManager = this.answersManager;
        Intrinsics.checkNotNull(answersManager);
        return answersManager;
    }

    /* JADX INFO: renamed from: com.survicate.surveys.SurvicateComponent$obtainAnswersManager$1 */
    /* JADX INFO: compiled from: SurvicateComponent.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, m1599d2 = {"<anonymous>", "", "traits", "", "Lcom/survicate/surveys/traits/UserTrait;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.SurvicateComponent$obtainAnswersManager$1", m1609f = "SurvicateComponent.kt", m1610i = {}, m1611l = {988}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C83711 extends SuspendLambda implements Function2<List<? extends UserTrait>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Executor $sdkExecutor;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C83711(Executor executor, Continuation<? super C83711> continuation) {
            super(2, continuation);
            this.$sdkExecutor = executor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C83711 c83711 = new C83711(this.$sdkExecutor, continuation);
            c83711.L$0 = obj;
            return c83711;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(List<? extends UserTrait> list, Continuation<? super Unit> continuation) {
            return ((C83711) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Survicate.setUserTraits((List) this.L$0);
                Executor executor = this.$sdkExecutor;
                this.L$0 = executor;
                this.label = 1;
                C83711 c83711 = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(c83711), 1);
                cancellableContinuationImpl.initCancellability();
                final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                executor.post(new Function0<Unit>() { // from class: com.survicate.surveys.SurvicateComponent$obtainAnswersManager$1$1$1
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m14499constructorimpl(Unit.INSTANCE));
                    }
                });
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c83711);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final synchronized RespondentRepository provideRespondentRepository() {
        RespondentRepository respondentRepository;
        if (this.respondentRepository == null) {
            this.respondentRepository = new SurvicateRespondentRepository(provideRespondentApi(), provideRespondentStore(), new SurvicateTaskScheduler(), provideAppStateProvider(), provideLogger());
        }
        respondentRepository = this.respondentRepository;
        Intrinsics.checkNotNull(respondentRepository);
        return respondentRepository;
    }

    private final RespondentStore provideRespondentStore() {
        return obtainPersistenceManager();
    }

    public final synchronized TargetingEngine obtainTargetingEngine() {
        TargetingEngine targetingEngine;
        if (this.targetingEngine == null) {
            this.targetingEngine = new TargetingEngine(obtainDisplayEngine(), provideActiveScreenStore(), provideActiveEventStore(), providePresentationStateStore(), provideActiveEventHistoryStore(), provideScreenDelayTargeting(), provideEventDelayTargeting(), provideTimeIntervalTargeting(), provideSuggestionsRepository(), provideContactsRepository(), provideBackendTargetingResultLoader(), provideBackendTargetingResultStore(), providePresentationTimesProvider(), provideTimestampProvider(), provideLogger(), obtainPersistenceManager(), provideLocaleProvider(), provideScreenOrientationProvider(), Dispatchers.getMain());
        }
        targetingEngine = this.targetingEngine;
        Intrinsics.checkNotNull(targetingEngine);
        return targetingEngine;
    }

    public final synchronized WorkspaceLoader obtainWorkspaceLoader() {
        WorkspaceLoader workspaceLoader;
        if (this.workspaceLoader == null) {
            this.workspaceLoader = new WorkspaceLoader(provideWorkspaceApi(), obtainPersistenceManager(), provideTargetingFiltersFactory(), provideLogger(), null, 16, null);
        }
        workspaceLoader = this.workspaceLoader;
        Intrinsics.checkNotNull(workspaceLoader);
        return workspaceLoader;
    }

    public final WorkspaceKeyStore obtainWorkspaceKeyStore() {
        return provideWorkspaceKeyStore();
    }

    private final synchronized WorkspaceKeyStore provideWorkspaceKeyStore() {
        WorkspaceKeyStore workspaceKeyStore;
        if (this.workspaceKeyStore == null) {
            this.workspaceKeyStore = new WorkspaceKeyStore(this.applicationContext, provideLogger());
        }
        workspaceKeyStore = this.workspaceKeyStore;
        Intrinsics.checkNotNull(workspaceKeyStore);
        return workspaceKeyStore;
    }

    private final synchronized WorkspaceApi provideWorkspaceApi() {
        WorkspaceApi workspaceApi;
        if (this.workspaceApi == null) {
            this.workspaceApi = new SurvicateWorkspaceApi(provideWorkspaceRequestFactory(), provideWorkspaceSerializer(), provideHttpClient());
        }
        workspaceApi = this.workspaceApi;
        Intrinsics.checkNotNull(workspaceApi);
        return workspaceApi;
    }

    private final synchronized WorkspaceRequestFactory provideWorkspaceRequestFactory() {
        WorkspaceRequestFactory workspaceRequestFactory;
        if (this.workspaceRequestFactory == null) {
            this.workspaceRequestFactory = new SurvicateWorkspaceRequestFactory(provideUrlProvider(), provideWorkspaceSerializer());
        }
        workspaceRequestFactory = this.workspaceRequestFactory;
        Intrinsics.checkNotNull(workspaceRequestFactory);
        return workspaceRequestFactory;
    }

    private final synchronized WorkspaceSerializer provideWorkspaceSerializer() {
        WorkspaceSerializer workspaceSerializer;
        if (this.workspaceSerializer == null) {
            this.workspaceSerializer = new SurvicateWorkspaceSerializer(provideJsonSerialization());
        }
        workspaceSerializer = this.workspaceSerializer;
        Intrinsics.checkNotNull(workspaceSerializer);
        return workspaceSerializer;
    }

    private final synchronized RespondentApi provideRespondentApi() {
        RespondentApi respondentApi;
        if (this.respondentApi == null) {
            this.respondentApi = new SurvicateRespondentApi(provideHttpClient(), provideRespondentRequestFactory());
        }
        respondentApi = this.respondentApi;
        Intrinsics.checkNotNull(respondentApi);
        return respondentApi;
    }

    private final synchronized HostProvider provideHostProvider() {
        HostProvider hostProvider;
        if (this.hostProvider == null) {
            this.hostProvider = new SurvicateHostProvider(this.applicationContext, provideLogger());
        }
        hostProvider = this.hostProvider;
        Intrinsics.checkNotNull(hostProvider);
        return hostProvider;
    }

    private final synchronized UrlProvider provideUrlProvider() {
        UrlProvider urlProvider;
        if (this.urlProvider == null) {
            this.urlProvider = new SurvicateUrlProvider(provideHostProvider(), provideWorkspaceKeyStore());
        }
        urlProvider = this.urlProvider;
        Intrinsics.checkNotNull(urlProvider);
        return urlProvider;
    }

    private final synchronized SurvicateStore provideSurvicateStore() {
        SurvicateStore survicateStore;
        if (this.survicateStore == null) {
            this.survicateStore = new SerializedSharedPrefsSurvicateStore(provideSharedPreferences(), provideSerializer(), provideContactActionSerializer(), provideLogger());
        }
        survicateStore = this.survicateStore;
        Intrinsics.checkNotNull(survicateStore);
        return survicateStore;
    }

    private final synchronized SharedPreferences provideSharedPreferences() {
        SharedPreferences sharedPreferences;
        if (this.sharedPrefs == null) {
            this.sharedPrefs = this.applicationContext.getSharedPreferences("Survicate", 0);
        }
        sharedPreferences = this.sharedPrefs;
        Intrinsics.checkNotNull(sharedPreferences);
        return sharedPreferences;
    }

    private final synchronized SurvicateSerializer provideSerializer() {
        SurvicateSerializer survicateSerializer;
        if (this.serializer == null) {
            this.serializer = new SurvicateJsonSerializer(provideJsonSerialization());
        }
        survicateSerializer = this.serializer;
        Intrinsics.checkNotNull(survicateSerializer);
        return survicateSerializer;
    }

    private final synchronized SurvicateHttpClient provideHttpClient() {
        SurvicateHttpClient survicateHttpClient;
        if (this.httpClient == null) {
            this.httpClient = new SurvicateHttpClient();
        }
        survicateHttpClient = this.httpClient;
        Intrinsics.checkNotNull(survicateHttpClient);
        return survicateHttpClient;
    }

    private final synchronized Json provideJsonSerialization() {
        Json json;
        if (this.jsonSerialization == null) {
            this.jsonSerialization = JsonSerializationProvider.provide();
        }
        json = this.jsonSerialization;
        Intrinsics.checkNotNull(json);
        return json;
    }

    private final synchronized SurvicateSessionStore provideSessionStore() {
        SurvicateSessionStore survicateSessionStore;
        if (this.sessionStore == null) {
            this.sessionStore = new SurvicateSessionStore();
        }
        survicateSessionStore = this.sessionStore;
        Intrinsics.checkNotNull(survicateSessionStore);
        return survicateSessionStore;
    }

    public final LocaleStore provideLocaleStore() {
        return provideLocaleProvider();
    }

    private final ActiveScreenStore provideActiveScreenStore() {
        return provideSessionStore();
    }

    private final ActiveEventStore provideActiveEventStore() {
        return provideSessionStore();
    }

    private final PresentationStateStore providePresentationStateStore() {
        return provideSessionStore();
    }

    private final ActiveEventHistoryStore provideActiveEventHistoryStore() {
        return obtainPersistenceManager();
    }

    private final synchronized TextRecallingManager provideTextRecallingManager() {
        TextRecallingManager textRecallingManager;
        if (this.textRecallingManager == null) {
            this.textRecallingManager = new TextRecallingManager(obtainPersistenceManager(), provideSurveyStore());
        }
        textRecallingManager = this.textRecallingManager;
        Intrinsics.checkNotNull(textRecallingManager);
        return textRecallingManager;
    }

    private final synchronized SdkLogger provideSdkLogger() {
        SdkLogger sdkLogger;
        if (this.sdkLogger == null) {
            this.sdkLogger = LoggerFactoryKt.createLogger("8.3.0", new LoggerConfig(this.loggerEnabled));
        }
        sdkLogger = this.sdkLogger;
        Intrinsics.checkNotNull(sdkLogger);
        return sdkLogger;
    }

    public final synchronized SdkLogger provideLogger() {
        SdkLogger sdkLogger;
        if (this.survicateLogger == null) {
            this.survicateLogger = new SurvicateLogger(provideSdkLogger());
        }
        sdkLogger = this.survicateLogger;
        Intrinsics.checkNotNull(sdkLogger);
        return sdkLogger;
    }

    private final synchronized AndroidLocaleProvider provideLocaleProvider() {
        AndroidLocaleProvider androidLocaleProvider;
        if (this.localeProvider == null) {
            this.localeProvider = new AndroidLocaleProvider(this.applicationContext);
        }
        androidLocaleProvider = this.localeProvider;
        Intrinsics.checkNotNull(androidLocaleProvider);
        return androidLocaleProvider;
    }

    private final synchronized AndroidScreenOrientationProvider provideScreenOrientationProvider() {
        AndroidScreenOrientationProvider androidScreenOrientationProvider;
        if (this.screenOrientationProvider == null) {
            this.screenOrientationProvider = new AndroidScreenOrientationProviderImpl(this.applicationContext, provideLogger());
        }
        androidScreenOrientationProvider = this.screenOrientationProvider;
        Intrinsics.checkNotNull(androidScreenOrientationProvider);
        return androidScreenOrientationProvider;
    }

    private final synchronized NetworkStateProvider provideNetworkStateProvider() {
        NetworkStateProvider networkStateProvider;
        if (this.networkStateProvider == null) {
            this.networkStateProvider = NetworkStateProvider.INSTANCE.create(this.applicationContext);
        }
        networkStateProvider = this.networkStateProvider;
        Intrinsics.checkNotNull(networkStateProvider);
        return networkStateProvider;
    }

    private final synchronized SurvicateSynchronizationStore provideSynchronizationStore() {
        SurvicateSynchronizationStore survicateSynchronizationStore;
        if (this.synchronizationStore == null) {
            this.synchronizationStore = new SerializedSharedPrefsSurvicateSynchronizationStore(provideSharedPreferences(), provideSerializer(), provideLogger());
        }
        survicateSynchronizationStore = this.synchronizationStore;
        Intrinsics.checkNotNull(survicateSynchronizationStore);
        return survicateSynchronizationStore;
    }

    private final synchronized TargetingFiltersFactory provideTargetingFiltersFactory() {
        TargetingFiltersFactory targetingFiltersFactory;
        if (this.targetingFiltersFactory == null) {
            this.targetingFiltersFactory = new TargetingFiltersFactory(provideActiveScreenProvider(), provideActiveEventProvider(), provideCoreUserTraitsProvider(), provideSeenSurveysProvider(), providePresentationTimesProvider(), provideDelayedEventProvider(), provideLocaleProvider(), provideScreenOrientationProvider(), providePresentationStateProvider(), provideSurveyChanceStore(), provideTimestampProvider(), provideBackendTargetingResultStore(), provideLogger());
        }
        targetingFiltersFactory = this.targetingFiltersFactory;
        Intrinsics.checkNotNull(targetingFiltersFactory);
        return targetingFiltersFactory;
    }

    private final ActiveScreenProvider provideActiveScreenProvider() {
        return provideActiveScreenStore();
    }

    private final ActiveEventProvider provideActiveEventProvider() {
        return provideActiveEventStore();
    }

    private final UserTraitsProvider provideUserTraitsProvider() {
        return obtainPersistenceManager();
    }

    private final CoreUserTraitsProvider provideCoreUserTraitsProvider() {
        return obtainPersistenceManager();
    }

    private final SeenSurveysProvider provideSeenSurveysProvider() {
        return obtainPersistenceManager();
    }

    private final PresentationTimesProvider providePresentationTimesProvider() {
        return obtainPersistenceManager();
    }

    private final DelayedEventProvider provideDelayedEventProvider() {
        return provideEventDelayTargeting();
    }

    private final PresentationStateProvider providePresentationStateProvider() {
        return providePresentationStateStore();
    }

    private final SurveyChanceStore provideSurveyChanceStore() {
        return provideSessionStore();
    }

    private final synchronized SurvicateVersionProvider provideVersionProvider() {
        SurvicateVersionProvider survicateVersionProvider;
        if (this.versionProvider == null) {
            this.versionProvider = new SurvicateVersionProvider();
        }
        survicateVersionProvider = this.versionProvider;
        Intrinsics.checkNotNull(survicateVersionProvider);
        return survicateVersionProvider;
    }

    private final synchronized DisplayDesignEngine provideDisplayDesignEngine() {
        DisplayDesignEngine displayDesignEngine;
        if (this.displayDesignEngine == null) {
            this.displayDesignEngine = new SurvicateDisplayDesignEngine();
        }
        displayDesignEngine = this.displayDesignEngine;
        Intrinsics.checkNotNull(displayDesignEngine);
        return displayDesignEngine;
    }

    public final synchronized ThemeModeStore provideThemeModeStore() {
        ThemeModeStore themeModeStore;
        if (this.themeModeStore == null) {
            this.themeModeStore = new SurvicateThemeModeStore();
        }
        themeModeStore = this.themeModeStore;
        Intrinsics.checkNotNull(themeModeStore);
        return themeModeStore;
    }

    public final SurvicateFontSystemStore provideFontSystemStore() {
        return provideSessionStore();
    }

    private final SurvicateFontSystemProvider provideFontSystemProvider() {
        return provideSessionStore();
    }

    private final synchronized UrlBuilder provideUrlBuilder() {
        UrlBuilder urlBuilder;
        if (this.urlBuilder == null) {
            this.urlBuilder = new UrlBuilderImpl();
        }
        urlBuilder = this.urlBuilder;
        Intrinsics.checkNotNull(urlBuilder);
        return urlBuilder;
    }

    private final synchronized SurvicateImageLoader provideImageLoader() {
        SurvicateImageLoader survicateImageLoader;
        if (this.imageLoader == null) {
            this.imageLoader = new SurvicateImageLoaderImpl(this.applicationContext);
        }
        survicateImageLoader = this.imageLoader;
        Intrinsics.checkNotNull(survicateImageLoader);
        return survicateImageLoader;
    }

    private final synchronized SurveyLogic provideSurveyLogic() {
        SurveyLogic surveyLogic;
        if (this.surveyLogic == null) {
            this.surveyLogic = new SurveyLogicImpl();
        }
        surveyLogic = this.surveyLogic;
        Intrinsics.checkNotNull(surveyLogic);
        return surveyLogic;
    }

    public final synchronized TimestampProvider provideTimestampProvider() {
        TimestampProvider timestampProvider;
        if (this.timestampProvider == null) {
            this.timestampProvider = new TimestampProvider() { // from class: com.survicate.surveys.SurvicateComponent$$ExternalSyntheticLambda0
                @Override // com.survicate.surveys.utils.TimestampProvider, com.survicate.surveys.core.providers.TimestampProvider
                public final long currentTimeMillis() {
                    return System.currentTimeMillis();
                }
            };
        }
        timestampProvider = this.timestampProvider;
        Intrinsics.checkNotNull(timestampProvider);
        return timestampProvider;
    }

    private final synchronized ScreenDelayTargeting provideScreenDelayTargeting() {
        ScreenDelayTargeting screenDelayTargeting;
        if (this.screenDelayTargeting == null) {
            this.screenDelayTargeting = new ScreenDelayTargeting(provideTimestampProvider(), provideLogger(), Dispatchers.getMain());
        }
        screenDelayTargeting = this.screenDelayTargeting;
        Intrinsics.checkNotNull(screenDelayTargeting);
        return screenDelayTargeting;
    }

    private final synchronized EventDelayTargeting provideEventDelayTargeting() {
        EventDelayTargeting eventDelayTargeting;
        if (this.eventDelayTargeting == null) {
            this.eventDelayTargeting = new EventDelayTargetingImpl(provideTimestampProvider(), provideLogger(), Dispatchers.getMain());
        }
        eventDelayTargeting = this.eventDelayTargeting;
        Intrinsics.checkNotNull(eventDelayTargeting);
        return eventDelayTargeting;
    }

    private final synchronized SuggestionsRepository provideSuggestionsRepository() {
        SuggestionsRepository suggestionsRepository;
        if (this.suggestionsRepository == null) {
            this.suggestionsRepository = new SurvicateSuggestionsRepository(provideSuggestionsApi(), provideLogger(), Dispatchers.getIO());
        }
        suggestionsRepository = this.suggestionsRepository;
        Intrinsics.checkNotNull(suggestionsRepository);
        return suggestionsRepository;
    }

    private final synchronized SuggestionsApi provideSuggestionsApi() {
        SuggestionsApi suggestionsApi;
        if (this.suggestionsApi == null) {
            this.suggestionsApi = new SurvicateSuggestionsApi(provideHttpClient(), provideSuggestionsRequestFactory());
        }
        suggestionsApi = this.suggestionsApi;
        Intrinsics.checkNotNull(suggestionsApi);
        return suggestionsApi;
    }

    private final synchronized SuggestionsRequestFactory provideSuggestionsRequestFactory() {
        SuggestionsRequestFactory suggestionsRequestFactory;
        if (this.suggestionsRequestFactory == null) {
            this.suggestionsRequestFactory = new SurvicateSuggestionsRequestFactory(provideUrlProvider(), provideSuggestionsSerializer());
        }
        suggestionsRequestFactory = this.suggestionsRequestFactory;
        Intrinsics.checkNotNull(suggestionsRequestFactory);
        return suggestionsRequestFactory;
    }

    private final synchronized SuggestionsSerializer provideSuggestionsSerializer() {
        SuggestionsSerializer suggestionsSerializer;
        if (this.suggestionsSerializer == null) {
            this.suggestionsSerializer = new SurvicateSuggestionsSerializer(provideJsonSerialization());
        }
        suggestionsSerializer = this.suggestionsSerializer;
        Intrinsics.checkNotNull(suggestionsSerializer);
        return suggestionsSerializer;
    }

    private final synchronized RespondentRequestFactory provideRespondentRequestFactory() {
        RespondentRequestFactory respondentRequestFactory;
        if (this.respondentRequestFactory == null) {
            this.respondentRequestFactory = new SurvicateRespondentRequestFactory(provideRespondentSerializer(), provideUrlProvider());
        }
        respondentRequestFactory = this.respondentRequestFactory;
        Intrinsics.checkNotNull(respondentRequestFactory);
        return respondentRequestFactory;
    }

    private final synchronized RespondentSerializer provideRespondentSerializer() {
        RespondentSerializer respondentSerializer;
        if (this.respondentSerializer == null) {
            this.respondentSerializer = new SurvicateRespondentSerializer(provideJsonSerialization());
        }
        respondentSerializer = this.respondentSerializer;
        Intrinsics.checkNotNull(respondentSerializer);
        return respondentSerializer;
    }

    private final synchronized SurveyStore provideSurveyStore() {
        SurveyStore surveyStore;
        if (this.surveyStore == null) {
            this.surveyStore = new SurveyStore();
        }
        surveyStore = this.surveyStore;
        Intrinsics.checkNotNull(surveyStore);
        return surveyStore;
    }

    private final synchronized SurveyAnswerFactory provideSurveyAnswerFactory() {
        SurveyAnswerFactory surveyAnswerFactory;
        if (this.surveyAnswerFactory == null) {
            this.surveyAnswerFactory = new SurveyAnswerFactory();
        }
        surveyAnswerFactory = this.surveyAnswerFactory;
        Intrinsics.checkNotNull(surveyAnswerFactory);
        return surveyAnswerFactory;
    }

    private final synchronized DisplayLogicController provideDisplayLogicController() {
        DisplayLogicController displayLogicController;
        if (this.displayLogicController == null) {
            this.displayLogicController = DisplayLogicController.INSTANCE;
        }
        displayLogicController = this.displayLogicController;
        Intrinsics.checkNotNull(displayLogicController);
        return displayLogicController;
    }

    private final synchronized ViewDependencies provideViewDependencies() {
        ViewDependencies viewDependencies;
        if (this.viewDependencies == null) {
            this.viewDependencies = new ViewDependenciesImpl(provideImageLoader(), provideFontProvider());
        }
        viewDependencies = this.viewDependencies;
        Intrinsics.checkNotNull(viewDependencies);
        return viewDependencies;
    }

    private final synchronized FontProvider provideFontProvider() {
        FontProvider fontProvider;
        if (this.fontProvider == null) {
            this.fontProvider = new SurvicateFontProvider(provideFontSystemProvider(), provideLogger());
        }
        fontProvider = this.fontProvider;
        Intrinsics.checkNotNull(fontProvider);
        return fontProvider;
    }

    private final synchronized FollowUpQuestionRepository provideFollowUpQuestionRepository() {
        FollowUpQuestionRepository followUpQuestionRepository;
        if (this.followUpQuestionRepository == null) {
            this.followUpQuestionRepository = new SurvicateFollowUpQuestionRepository(provideFollowUpQuestionApi(), provideWorkspaceKeyStore(), provideLogger());
        }
        followUpQuestionRepository = this.followUpQuestionRepository;
        Intrinsics.checkNotNull(followUpQuestionRepository);
        return followUpQuestionRepository;
    }

    private final synchronized FollowUpQuestionApi provideFollowUpQuestionApi() {
        FollowUpQuestionApi followUpQuestionApi;
        if (this.followUpQuestionApi == null) {
            this.followUpQuestionApi = new SurvicateFollowUpQuestionApi(provideFollowUpQuestionRequestFactory(), provideFollowUpQuestionSerializer(), provideHttpClient(), Dispatchers.getIO());
        }
        followUpQuestionApi = this.followUpQuestionApi;
        Intrinsics.checkNotNull(followUpQuestionApi);
        return followUpQuestionApi;
    }

    private final synchronized FollowUpQuestionRequestFactory provideFollowUpQuestionRequestFactory() {
        FollowUpQuestionRequestFactory followUpQuestionRequestFactory;
        if (this.followUpQuestionRequestFactory == null) {
            this.followUpQuestionRequestFactory = new SurvicateFollowUpQuestionRequestFactory(provideFollowUpQuestionSerializer(), provideUrlProvider());
        }
        followUpQuestionRequestFactory = this.followUpQuestionRequestFactory;
        Intrinsics.checkNotNull(followUpQuestionRequestFactory);
        return followUpQuestionRequestFactory;
    }

    private final synchronized FollowUpQuestionSerializer provideFollowUpQuestionSerializer() {
        FollowUpQuestionSerializer followUpQuestionSerializer;
        if (this.followUpQuestionSerializer == null) {
            this.followUpQuestionSerializer = new SurvicateFollowUpQuestionSerializer(provideJsonSerialization());
        }
        followUpQuestionSerializer = this.followUpQuestionSerializer;
        Intrinsics.checkNotNull(followUpQuestionSerializer);
        return followUpQuestionSerializer;
    }

    public final synchronized ContactsRepository provideContactsRepository() {
        ContactsRepository contactsRepository;
        if (this.contactsRepository == null) {
            this.contactsRepository = createContactsRepository();
        }
        contactsRepository = this.contactsRepository;
        Intrinsics.checkNotNull(contactsRepository);
        return contactsRepository;
    }

    private final ContactsRepository createContactsRepository() {
        if (FeatureFlags.INSTANCE.isBackendTargetingEnabled()) {
            return new SurvicateContactsRepository(provideContactsApi(), provideContactStore(), provideBackendTargetingResultStore(), new SurvicateTaskScheduler(), provideContactEventsThrottle(), provideRespondentProvider(), provideUserTraitsProvider(), provideAppStateProvider(), provideTimestampProvider(), provideLogger(), Dispatchers.getIO());
        }
        return new EmptyContactsRepository();
    }

    private final synchronized ContactsApi provideContactsApi() {
        ContactsApi contactsApi;
        if (this.contactsApi == null) {
            this.contactsApi = new SurvicateContactsApi(provideHttpClient(), provideContactsRequestFactory(), provideContactsSerializer());
        }
        contactsApi = this.contactsApi;
        Intrinsics.checkNotNull(contactsApi);
        return contactsApi;
    }

    private final synchronized ContactsRequestFactory provideContactsRequestFactory() {
        ContactsRequestFactory contactsRequestFactory;
        if (this.contactsRequestFactory == null) {
            this.contactsRequestFactory = new SurvicateContactsRequestFactory(provideUrlProvider(), provideContactsSerializer());
        }
        contactsRequestFactory = this.contactsRequestFactory;
        Intrinsics.checkNotNull(contactsRequestFactory);
        return contactsRequestFactory;
    }

    private final synchronized ContactsSerializer provideContactsSerializer() {
        ContactsSerializer contactsSerializer;
        if (this.contactsSerializer == null) {
            this.contactsSerializer = new SurvicateContactsSerializer(provideJsonSerialization());
        }
        contactsSerializer = this.contactsSerializer;
        Intrinsics.checkNotNull(contactsSerializer);
        return contactsSerializer;
    }

    private final synchronized ContactActionSerializer provideContactActionSerializer() {
        ContactActionSerializer contactActionSerializer;
        if (this.contactActionSerializer == null) {
            this.contactActionSerializer = new SurvicateContactActionSerializer(provideJsonSerialization());
        }
        contactActionSerializer = this.contactActionSerializer;
        Intrinsics.checkNotNull(contactActionSerializer);
        return contactActionSerializer;
    }

    private final ContactStore provideContactStore() {
        return obtainPersistenceManager();
    }

    private final RespondentProvider provideRespondentProvider() {
        return obtainPersistenceManager();
    }

    private final synchronized BackendTargetingResultLoader provideBackendTargetingResultLoader() {
        BackendTargetingResultLoader backendTargetingResultLoader;
        if (this.backendTargetingResultLoader == null) {
            this.backendTargetingResultLoader = new BackendTargetingResultLoader(provideBackendTargetingResultStore(), provideContactsRepository(), BackendTargetingResultLoader.INSTANCE.defaultBackoffStrategy(), provideLogger());
        }
        backendTargetingResultLoader = this.backendTargetingResultLoader;
        Intrinsics.checkNotNull(backendTargetingResultLoader);
        return backendTargetingResultLoader;
    }

    private final synchronized BackendTargetingResultStore provideBackendTargetingResultStore() {
        BackendTargetingResultStore backendTargetingResultStore;
        if (this.backendTargetingResultStore == null) {
            this.backendTargetingResultStore = new SurvicateBackendTargetingResultStore(provideTimestampProvider());
        }
        backendTargetingResultStore = this.backendTargetingResultStore;
        Intrinsics.checkNotNull(backendTargetingResultStore);
        return backendTargetingResultStore;
    }

    private final synchronized TimeIntervalTargeting provideTimeIntervalTargeting() {
        TimeIntervalTargeting timeIntervalTargeting;
        if (this.timeIntervalTargeting == null) {
            this.timeIntervalTargeting = createTimeIntervalTargeting();
        }
        timeIntervalTargeting = this.timeIntervalTargeting;
        Intrinsics.checkNotNull(timeIntervalTargeting);
        return timeIntervalTargeting;
    }

    private final TimeIntervalTargeting createTimeIntervalTargeting() {
        if (FeatureFlags.INSTANCE.isBackendTargetingEnabled()) {
            return new SurvicateTimeIntervalTargeting(provideTimestampProvider(), provideAppLifecycleProvider(), provideLogger(), Dispatchers.getMain());
        }
        return new DisabledTimeIntervalTargeting();
    }

    private final synchronized AppLifecycleProvider provideAppLifecycleProvider() {
        AppLifecycleProvider appLifecycleProvider;
        if (this.appLifecycleProvider == null) {
            this.appLifecycleProvider = new SurvicateAppLifecycleProvider();
        }
        appLifecycleProvider = this.appLifecycleProvider;
        Intrinsics.checkNotNull(appLifecycleProvider);
        return appLifecycleProvider;
    }

    private final synchronized AppStateProvider provideAppStateProvider() {
        AppStateProvider appStateProvider;
        if (this.appStateProvider == null) {
            this.appStateProvider = new SurvicateAppStateProvider(provideNetworkStateProvider(), provideAppLifecycleProvider());
        }
        appStateProvider = this.appStateProvider;
        Intrinsics.checkNotNull(appStateProvider);
        return appStateProvider;
    }

    private final synchronized ContactEventsThrottle provideContactEventsThrottle() {
        ContactEventsThrottle contactEventsThrottle;
        if (this.contactEventsThrottle == null) {
            this.contactEventsThrottle = new SurvicateContactEventsThrottle(provideContactStore(), Dispatchers.getDefault());
        }
        contactEventsThrottle = this.contactEventsThrottle;
        Intrinsics.checkNotNull(contactEventsThrottle);
        return contactEventsThrottle;
    }

    public final synchronized ContactAttributesThrottle provideContactAttributesThrottle() {
        ContactAttributesThrottle contactAttributesThrottle;
        if (this.contactAttributesThrottle == null) {
            this.contactAttributesThrottle = new SurvicateContactAttributesThrottle(obtainPersistenceManager(), provideContactsRepository(), provideTimestampProvider(), provideSdkExecutor(), Dispatchers.getDefault());
        }
        contactAttributesThrottle = this.contactAttributesThrottle;
        Intrinsics.checkNotNull(contactAttributesThrottle);
        return contactAttributesThrottle;
    }

    public final synchronized Executor provideSdkExecutor() {
        Executor executor;
        if (this.sdkExecutor == null) {
            this.sdkExecutor = new SurvicateExecutor(Dispatchers.getDefault());
        }
        executor = this.sdkExecutor;
        Intrinsics.checkNotNull(executor);
        return executor;
    }
}
