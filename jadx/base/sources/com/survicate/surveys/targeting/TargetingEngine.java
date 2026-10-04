package com.survicate.surveys.targeting;

import com.survicate.surveys.PersistenceManager;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.core.models.ActiveScreen;
import com.survicate.surveys.core.models.ScreenOrientation;
import com.survicate.surveys.core.providers.ActiveScreenStore;
import com.survicate.surveys.core.targeting.TargetingMode;
import com.survicate.surveys.core.targeting.backend.BackendTargetingResultStore;
import com.survicate.surveys.entities.survey.Survey;
import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.entities.survey.WorkspaceKt;
import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import com.survicate.surveys.helpers.AndroidLocaleProvider;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.helpers.Observable;
import com.survicate.surveys.infrastructure.storage.contacts.AuthenticationEnforcement;
import com.survicate.surveys.infrastructure.storage.contacts.BackendTargetingState;
import com.survicate.surveys.infrastructure.storage.contacts.ContactsRepository;
import com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventHistoryStore;
import com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventStore;
import com.survicate.surveys.infrastructure.storage.interfaces.PresentationStateStore;
import com.survicate.surveys.infrastructure.storage.interfaces.SuggestionsRepository;
import com.survicate.surveys.presentation.base.DisplayEngine;
import com.survicate.surveys.targeting.displayfilter.EventDisplayFilter;
import com.survicate.surveys.targeting.provider.PresentationTimesProvider;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.utils.AndroidScreenOrientationProvider;
import com.survicate.surveys.utils.FeatureFlags;
import com.survicate.surveys.utils.TimestampProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: TargetingEngine.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020'¢\u0006\u0004\b(\u0010)J\u0012\u00105\u001a\u0002062\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u00107\u001a\u0002062\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u00108\u001a\u0002062\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u00109\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u0010:\u001a\u0002062\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u0010;\u001a\u0002062\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u000e\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020>J\u000e\u0010?\u001a\u0002062\u0006\u0010=\u001a\u00020>J\"\u0010@\u001a\u0002062\u0006\u0010A\u001a\u00020>2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020>0CJ\u0010\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u000206H\u0002J\b\u0010H\u001a\u000204H\u0002J \u0010I\u001a\u0002062\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\u0016\u0010J\u001a\u0002062\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u0016\u0010K\u001a\u0002062\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u000200H\u0002J\b\u0010N\u001a\u000206H\u0002J\u0006\u0010O\u001a\u000206J\b\u0010P\u001a\u000206H\u0002J\u0017\u0010Q\u001a\u0002062\f\u0010R\u001a\b\u0012\u0004\u0012\u0002060SH\u0082\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, m1599d2 = {"Lcom/survicate/surveys/targeting/TargetingEngine;", "", "displayEngine", "Lcom/survicate/surveys/presentation/base/DisplayEngine;", "activeScreenStore", "Lcom/survicate/surveys/core/providers/ActiveScreenStore;", "activeEventStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventStore;", "presentationStateStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/PresentationStateStore;", "activeEventHistoryStore", "Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventHistoryStore;", "screenDelayTargeting", "Lcom/survicate/surveys/targeting/ScreenDelayTargeting;", "eventDelayTargeting", "Lcom/survicate/surveys/targeting/EventDelayTargeting;", "timeIntervalTargeting", "Lcom/survicate/surveys/targeting/TimeIntervalTargeting;", "suggestionsRepository", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SuggestionsRepository;", "contactsRepository", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;", "backendTargetingResultLoader", "Lcom/survicate/surveys/targeting/BackendTargetingResultLoader;", "backendTargetingResultStore", "Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;", "presentationTimesProvider", "Lcom/survicate/surveys/targeting/provider/PresentationTimesProvider;", "timestampProvider", "Lcom/survicate/surveys/utils/TimestampProvider;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "persistenceManager", "Lcom/survicate/surveys/PersistenceManager;", "localeProvider", "Lcom/survicate/surveys/helpers/AndroidLocaleProvider;", "screenOrientationProvider", "Lcom/survicate/surveys/utils/AndroidScreenOrientationProvider;", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/presentation/base/DisplayEngine;Lcom/survicate/surveys/core/providers/ActiveScreenStore;Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventStore;Lcom/survicate/surveys/infrastructure/storage/interfaces/PresentationStateStore;Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventHistoryStore;Lcom/survicate/surveys/targeting/ScreenDelayTargeting;Lcom/survicate/surveys/targeting/EventDelayTargeting;Lcom/survicate/surveys/targeting/TimeIntervalTargeting;Lcom/survicate/surveys/infrastructure/storage/interfaces/SuggestionsRepository;Lcom/survicate/surveys/infrastructure/storage/contacts/ContactsRepository;Lcom/survicate/surveys/targeting/BackendTargetingResultLoader;Lcom/survicate/surveys/core/targeting/backend/BackendTargetingResultStore;Lcom/survicate/surveys/targeting/provider/PresentationTimesProvider;Lcom/survicate/surveys/utils/TimestampProvider;Lcom/survicate/surveys/core/logging/SdkLogger;Lcom/survicate/surveys/PersistenceManager;Lcom/survicate/surveys/helpers/AndroidLocaleProvider;Lcom/survicate/surveys/utils/AndroidScreenOrientationProvider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "targetingLock", "Ljava/lang/Object;", "surveys", "", "Lcom/survicate/surveys/entities/survey/Survey;", "workspace", "Lcom/survicate/surveys/entities/survey/Workspace;", "hybridChallengeInProgress", "", "updateSurveys", "", "updateDelayTargeting", "updateTimeIntervalTargeting", "canStartTimeIntervalTargeting", "updateSuggestions", "updateContactsRepository", "userEntersScreen", "screen", "", "userLeavesScreen", "invokeEvent", "eventName", "eventProperties", "", "canScheduleDelayFor", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "challengeSurveys", "canPerformHybridChallenge", "performHybridChallengeFor", "finalizeHybridChallengeFor", "showOldestSeenSurvey", "showSurvey", "survey", "restartTimeIntervalTargeting", "clearAll", "clearHybridChallengeState", "withTargetingLock", "block", "Lkotlin/Function0;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TargetingEngine {
    private final ActiveEventHistoryStore activeEventHistoryStore;
    private final ActiveEventStore activeEventStore;
    private final ActiveScreenStore activeScreenStore;
    private final BackendTargetingResultLoader backendTargetingResultLoader;
    private final BackendTargetingResultStore backendTargetingResultStore;
    private final ContactsRepository contactsRepository;
    private final CoroutineScope coroutineScope;
    private final DisplayEngine displayEngine;
    private final EventDelayTargeting eventDelayTargeting;
    private boolean hybridChallengeInProgress;
    private final SdkLogger logger;
    private final PresentationStateStore presentationStateStore;
    private final PresentationTimesProvider presentationTimesProvider;
    private final ScreenDelayTargeting screenDelayTargeting;
    private final SuggestionsRepository suggestionsRepository;
    private List<Survey> surveys;
    private final Object targetingLock;
    private final TimeIntervalTargeting timeIntervalTargeting;
    private final TimestampProvider timestampProvider;
    private Workspace workspace;

    public TargetingEngine(DisplayEngine displayEngine, ActiveScreenStore activeScreenStore, ActiveEventStore activeEventStore, PresentationStateStore presentationStateStore, ActiveEventHistoryStore activeEventHistoryStore, ScreenDelayTargeting screenDelayTargeting, EventDelayTargeting eventDelayTargeting, TimeIntervalTargeting timeIntervalTargeting, SuggestionsRepository suggestionsRepository, ContactsRepository contactsRepository, BackendTargetingResultLoader backendTargetingResultLoader, BackendTargetingResultStore backendTargetingResultStore, PresentationTimesProvider presentationTimesProvider, TimestampProvider timestampProvider, SdkLogger logger, PersistenceManager persistenceManager, AndroidLocaleProvider localeProvider, AndroidScreenOrientationProvider screenOrientationProvider, CoroutineDispatcher mainDispatcher) {
        Intrinsics.checkNotNullParameter(displayEngine, "displayEngine");
        Intrinsics.checkNotNullParameter(activeScreenStore, "activeScreenStore");
        Intrinsics.checkNotNullParameter(activeEventStore, "activeEventStore");
        Intrinsics.checkNotNullParameter(presentationStateStore, "presentationStateStore");
        Intrinsics.checkNotNullParameter(activeEventHistoryStore, "activeEventHistoryStore");
        Intrinsics.checkNotNullParameter(screenDelayTargeting, "screenDelayTargeting");
        Intrinsics.checkNotNullParameter(eventDelayTargeting, "eventDelayTargeting");
        Intrinsics.checkNotNullParameter(timeIntervalTargeting, "timeIntervalTargeting");
        Intrinsics.checkNotNullParameter(suggestionsRepository, "suggestionsRepository");
        Intrinsics.checkNotNullParameter(contactsRepository, "contactsRepository");
        Intrinsics.checkNotNullParameter(backendTargetingResultLoader, "backendTargetingResultLoader");
        Intrinsics.checkNotNullParameter(backendTargetingResultStore, "backendTargetingResultStore");
        Intrinsics.checkNotNullParameter(presentationTimesProvider, "presentationTimesProvider");
        Intrinsics.checkNotNullParameter(timestampProvider, "timestampProvider");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(persistenceManager, "persistenceManager");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(screenOrientationProvider, "screenOrientationProvider");
        Intrinsics.checkNotNullParameter(mainDispatcher, "mainDispatcher");
        this.displayEngine = displayEngine;
        this.activeScreenStore = activeScreenStore;
        this.activeEventStore = activeEventStore;
        this.presentationStateStore = presentationStateStore;
        this.activeEventHistoryStore = activeEventHistoryStore;
        this.screenDelayTargeting = screenDelayTargeting;
        this.eventDelayTargeting = eventDelayTargeting;
        this.timeIntervalTargeting = timeIntervalTargeting;
        this.suggestionsRepository = suggestionsRepository;
        this.contactsRepository = contactsRepository;
        this.backendTargetingResultLoader = backendTargetingResultLoader;
        this.backendTargetingResultStore = backendTargetingResultStore;
        this.presentationTimesProvider = presentationTimesProvider;
        this.timestampProvider = timestampProvider;
        this.logger = logger;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(mainDispatcher.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.targetingLock = new Object();
        this.surveys = CollectionsKt.emptyList();
        displayEngine.setRechallengeSurveys(new C84851(this));
        Observable<Workspace> observableObserveWorkspace = persistenceManager.observeWorkspace();
        final Function1 function1 = new Function1() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TargetingEngine._init_$lambda$1(this.f$0, (Workspace) obj);
            }
        };
        observableObserveWorkspace.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda1
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function1.invoke(obj);
            }
        });
        Observable<List<UserTrait>> observableObserveTraits = persistenceManager.observeTraits();
        final Function1 function12 = new Function1() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TargetingEngine._init_$lambda$3(this.f$0, (List) obj);
            }
        };
        observableObserveTraits.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda3
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function12.invoke(obj);
            }
        });
        Observable<String> observableObserveLocale = localeProvider.observeLocale();
        final Function1 function13 = new Function1() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TargetingEngine._init_$lambda$6(this.f$0, (String) obj);
            }
        };
        observableObserveLocale.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda5
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function13.invoke(obj);
            }
        });
        Observable<ScreenOrientation> observableObserveOrientationChanges = screenOrientationProvider.observeOrientationChanges();
        final Function1 function14 = new Function1() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TargetingEngine._init_$lambda$8(this.f$0, (ScreenOrientation) obj);
            }
        };
        observableObserveOrientationChanges.addObserver(new Observable.Observer() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda7
            @Override // com.survicate.surveys.helpers.Observable.Observer
            public final void update(Object obj) {
                function14.invoke(obj);
            }
        });
        eventDelayTargeting.setOnDelayElapsed(new Function0() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TargetingEngine._init_$lambda$11(this.f$0);
            }
        });
        timeIntervalTargeting.setOnTimePassed(new Function0() { // from class: com.survicate.surveys.targeting.TargetingEngine$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TargetingEngine._init_$lambda$12(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.TargetingEngine$1 */
    /* JADX INFO: compiled from: TargetingEngine.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84851 extends FunctionReferenceImpl implements Function0<Unit> {
        C84851(Object obj) {
            super(0, obj, TargetingEngine.class, "challengeSurveys", "challengeSurveys()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((TargetingEngine) this.receiver).challengeSurveys();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$3(TargetingEngine targetingEngine, List list) {
        targetingEngine.challengeSurveys();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$8(TargetingEngine targetingEngine, ScreenOrientation screenOrientation) {
        targetingEngine.screenDelayTargeting.scheduleScreenOrientationDelay(new TargetingEngine$5$1(targetingEngine));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$12(TargetingEngine targetingEngine) {
        if (targetingEngine.contactsRepository.getIsBackendTargetingAllowed()) {
            targetingEngine.challengeSurveys();
        }
        return Unit.INSTANCE;
    }

    private final void updateSurveys(Workspace workspace) {
        List<Survey> listEmptyList;
        if (workspace == null || (listEmptyList = workspace.getSurveys()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        this.surveys = listEmptyList;
    }

    private final void updateDelayTargeting(Workspace workspace) {
        if (workspace == null) {
            this.screenDelayTargeting.clear();
            this.eventDelayTargeting.clear();
        } else {
            this.screenDelayTargeting.setupDelayTriggers(WorkspaceKt.getScreenDelayTriggers(workspace));
            this.screenDelayTargeting.updateActiveScreens(this.activeScreenStore.provideActiveScreens(), new C84871(this));
            this.eventDelayTargeting.setupDelayTriggers(WorkspaceKt.getEventDelayTriggers(workspace));
        }
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.TargetingEngine$updateDelayTargeting$1 */
    /* JADX INFO: compiled from: TargetingEngine.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    /* synthetic */ class C84871 extends FunctionReferenceImpl implements Function0<Unit> {
        C84871(Object obj) {
            super(0, obj, TargetingEngine.class, "challengeSurveys", "challengeSurveys()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((TargetingEngine) this.receiver).challengeSurveys();
        }
    }

    private final void updateTimeIntervalTargeting(Workspace workspace) {
        if (!canStartTimeIntervalTargeting(workspace)) {
            this.timeIntervalTargeting.clear();
        } else {
            this.timeIntervalTargeting.start();
        }
    }

    private final boolean canStartTimeIntervalTargeting(Workspace workspace) {
        if (workspace == null || !workspace.getBackendTargetingEnabled()) {
            return false;
        }
        List<Survey> surveys = workspace.getSurveys();
        if ((surveys instanceof Collection) && surveys.isEmpty()) {
            return false;
        }
        Iterator<T> it = surveys.iterator();
        while (it.hasNext()) {
            if (((Survey) it.next()).isContactMode()) {
                return true;
            }
        }
        return false;
    }

    private final void updateSuggestions(Workspace workspace) {
        if (workspace == null) {
            this.suggestionsRepository.clear();
        } else {
            this.suggestionsRepository.updateSuggestionsFrom(workspace);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateContactsRepository(Workspace workspace) {
        BackendTargetingState backendTargetingState;
        AuthenticationEnforcement authenticationEnforcement;
        ContactsRepository contactsRepository = this.contactsRepository;
        if (workspace != null) {
            if (workspace.getBackendTargetingEnabled()) {
                backendTargetingState = BackendTargetingState.ENABLED;
            } else {
                backendTargetingState = BackendTargetingState.DISABLED;
            }
            if (backendTargetingState == null) {
            }
        } else {
            backendTargetingState = BackendTargetingState.UNKNOWN;
        }
        contactsRepository.setBackendTargetingState(backendTargetingState);
        ContactsRepository contactsRepository2 = this.contactsRepository;
        if (workspace != null) {
            if (workspace.getEnforceUserAuthentication()) {
                authenticationEnforcement = AuthenticationEnforcement.REQUIRED;
            } else {
                authenticationEnforcement = AuthenticationEnforcement.OPTIONAL;
            }
            if (authenticationEnforcement == null) {
            }
        } else {
            authenticationEnforcement = AuthenticationEnforcement.UNKNOWN;
        }
        contactsRepository2.setAuthenticationEnforcement(authenticationEnforcement);
    }

    private final boolean canScheduleDelayFor(ActiveEvent activeEvent) {
        List<Survey> list = this.surveys;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, ((Survey) it.next()).getDisplayFilters());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof EventDisplayFilter) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            if (((EventDisplayFilter) it2.next()).canScheduleDelayFor(activeEvent)) {
                return true;
            }
        }
        return false;
    }

    private final boolean canPerformHybridChallenge() {
        return FeatureFlags.INSTANCE.isBackendTargetingEnabled() && !this.hybridChallengeInProgress && this.contactsRepository.getIsBackendTargetingAllowed();
    }

    private final void performHybridChallengeFor(List<Survey> surveys, ActiveEvent activeEvent) {
        this.hybridChallengeInProgress = true;
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C84861(surveys, activeEvent, null), 3, null);
    }

    /* JADX INFO: renamed from: com.survicate.surveys.targeting.TargetingEngine$performHybridChallengeFor$1 */
    /* JADX INFO: compiled from: TargetingEngine.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.targeting.TargetingEngine$performHybridChallengeFor$1", m1609f = "TargetingEngine.kt", m1610i = {0}, m1611l = {255}, m1612m = "invokeSuspend", m1613n = {"$this$launch"}, m1615s = {"L$0"})
    static final class C84861 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ActiveEvent $activeEvent;
        final /* synthetic */ List<Survey> $surveys;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C84861(List<Survey> list, ActiveEvent activeEvent, Continuation<? super C84861> continuation) {
            super(2, continuation);
            this.$surveys = list;
            this.$activeEvent = activeEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C84861 c84861 = TargetingEngine.this.new C84861(this.$surveys, this.$activeEvent, continuation);
            c84861.L$0 = obj;
            return c84861;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C84861) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Exception e;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    try {
                        this.L$0 = coroutineScope2;
                        this.label = 1;
                        if (TargetingEngine.this.backendTargetingResultLoader.loadResultsFor(this.$surveys, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope = coroutineScope2;
                    } catch (Exception e2) {
                        coroutineScope = coroutineScope2;
                        e = e2;
                        CoroutineScopeKt.ensureActive(coroutineScope);
                        TargetingEngine.this.logger.error(LogTags.TARGETING, "Backend targeting failed", e);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    coroutineScope = (CoroutineScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e3) {
                        e = e3;
                        CoroutineScopeKt.ensureActive(coroutineScope);
                        TargetingEngine.this.logger.error(LogTags.TARGETING, "Backend targeting failed", e);
                    }
                }
                TargetingEngine.this.activeEventStore.savePostponedEvent(this.$activeEvent);
                TargetingEngine.this.finalizeHybridChallengeFor(this.$surveys);
                TargetingEngine.this.clearHybridChallengeState();
                TargetingEngine.this.restartTimeIntervalTargeting();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                TargetingEngine.this.clearHybridChallengeState();
                TargetingEngine.this.restartTimeIntervalTargeting();
                throw th;
            }
        }
    }

    private final void showOldestSeenSurvey(List<Survey> surveys) {
        Object obj;
        Map<String, Long> mapLoadLastPresentationTimes = this.presentationTimesProvider.loadLastPresentationTimes();
        Iterator<T> it = surveys.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                Long l = mapLoadLastPresentationTimes.get(((Survey) next).getId());
                long jLongValue = l != null ? l.longValue() : 0L;
                do {
                    Object next2 = it.next();
                    Long l2 = mapLoadLastPresentationTimes.get(((Survey) next2).getId());
                    long jLongValue2 = l2 != null ? l2.longValue() : 0L;
                    if (jLongValue > jLongValue2) {
                        next = next2;
                        jLongValue = jLongValue2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        Survey survey = (Survey) obj;
        if (survey == null) {
            return;
        }
        showSurvey(survey);
    }

    private final void showSurvey(Survey survey) {
        if (this.displayEngine.isShowingSurvey()) {
            return;
        }
        this.logger.info(LogTags.TARGETING, "Survey ready to show: " + survey);
        this.presentationStateStore.saveAnySurveyPresentedInSession(true);
        survey.resetState();
        DisplayEngine displayEngine = this.displayEngine;
        Workspace workspace = this.workspace;
        List<SurveyTranslation> translations = workspace != null ? workspace.getTranslations() : null;
        if (translations == null) {
            translations = CollectionsKt.emptyList();
        }
        displayEngine.showSurvey(survey, translations);
        this.backendTargetingResultStore.markSurveyAsDisplayed(survey.getId());
    }

    private final void withTargetingLock(Function0<Unit> block) {
        synchronized (this.targetingLock) {
            block.invoke();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void userEntersScreen(String screen) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        synchronized (this.targetingLock) {
            Set<ActiveScreen> setProvideActiveScreens = this.activeScreenStore.provideActiveScreens();
            Set<ActiveScreen> set = setProvideActiveScreens;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((ActiveScreen) it.next()).getScreenName(), screen)) {
                        break;
                    }
                }
            }
            Set<ActiveScreen> setPlus = SetsKt.plus(setProvideActiveScreens, new ActiveScreen(screen, this.timestampProvider.currentTimeMillis()));
            this.activeScreenStore.saveActiveScreens(setPlus);
            this.screenDelayTargeting.updateActiveScreens(setPlus, new TargetingEngine$userEntersScreen$1$1(this));
            challengeSurveys();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void userLeavesScreen(String screen) {
        Object next;
        Intrinsics.checkNotNullParameter(screen, "screen");
        synchronized (this.targetingLock) {
            Set<ActiveScreen> setProvideActiveScreens = this.activeScreenStore.provideActiveScreens();
            Iterator<T> it = setProvideActiveScreens.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((ActiveScreen) next).getScreenName(), screen)) {
                        break;
                    }
                }
            }
            ActiveScreen activeScreen = (ActiveScreen) next;
            if (activeScreen != null) {
                Set<ActiveScreen> setMinus = SetsKt.minus(setProvideActiveScreens, activeScreen);
                this.activeScreenStore.saveActiveScreens(setMinus);
                this.screenDelayTargeting.updateActiveScreens(setMinus, new TargetingEngine$userLeavesScreen$1$1(this));
            }
            challengeSurveys();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void invokeEvent(String eventName, Map<String, String> eventProperties) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventProperties, "eventProperties");
        synchronized (this.targetingLock) {
            ActiveEvent activeEvent = new ActiveEvent(eventName, eventProperties, this.timestampProvider.currentTimeMillis(), this.activeEventHistoryStore.findMatchingHistory(eventName));
            this.activeEventStore.saveActiveEvent(activeEvent);
            this.contactsRepository.addEvent(activeEvent);
            if (canScheduleDelayFor(activeEvent)) {
                this.eventDelayTargeting.scheduleDelayFor(activeEvent);
            }
            challengeSurveys();
            this.activeEventHistoryStore.saveHistoryFor(activeEvent);
            this.suggestionsRepository.addEventSuggestionFor(activeEvent);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void challengeSurveys() {
        synchronized (this.targetingLock) {
            this.backendTargetingResultStore.setTargetingMode(TargetingMode.LOCAL);
            List<Survey> list = this.surveys;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Survey survey = (Survey) next;
                if (survey.canBeDisplayed()) {
                    String id = survey.getId();
                    Survey currentSurvey = this.displayEngine.getCurrentSurvey();
                    if (!Intrinsics.areEqual(id, currentSurvey != null ? currentSurvey.getId() : null)) {
                        arrayList.add(next);
                    }
                }
            }
            ArrayList arrayList2 = arrayList;
            this.logger.info(LogTags.TARGETING, "Surveys approved locally: " + arrayList2.size());
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList2) {
                if (((Survey) obj).isContactMode()) {
                    arrayList3.add(obj);
                } else {
                    arrayList4.add(obj);
                }
            }
            Pair pair = new Pair(arrayList3, arrayList4);
            List<Survey> list2 = (List) pair.component1();
            List<Survey> list3 = (List) pair.component2();
            if (!list3.isEmpty()) {
                showOldestSeenSurvey(list3);
            } else if (!list2.isEmpty() && canPerformHybridChallenge()) {
                performHybridChallengeFor(list2, this.activeEventStore.provideActiveEvent());
            }
            this.activeEventStore.saveActiveEvent(null);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finalizeHybridChallengeFor(List<Survey> surveys) {
        synchronized (this.targetingLock) {
            this.backendTargetingResultStore.setTargetingMode(TargetingMode.HYBRID);
            ArrayList arrayList = new ArrayList();
            for (Object obj : surveys) {
                if (((Survey) obj).canBeDisplayed()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            this.logger.info(LogTags.TARGETING, "Approved surveys: " + arrayList2.size());
            if (!arrayList2.isEmpty()) {
                showOldestSeenSurvey(arrayList2);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restartTimeIntervalTargeting() {
        synchronized (this.targetingLock) {
            if (canStartTimeIntervalTargeting(this.workspace)) {
                this.timeIntervalTargeting.start();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearAll() {
        synchronized (this.targetingLock) {
            JobKt__JobKt.cancelChildren$default(this.coroutineScope.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
            clearHybridChallengeState();
            this.activeScreenStore.saveActiveScreens(SetsKt.emptySet());
            this.activeEventStore.saveActiveEvent(null);
            this.presentationStateStore.saveAnySurveyPresentedInSession(false);
            this.screenDelayTargeting.clear();
            this.eventDelayTargeting.clear();
            this.timeIntervalTargeting.clear();
            this.suggestionsRepository.clear();
            this.contactsRepository.clear();
            this.backendTargetingResultStore.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearHybridChallengeState() {
        synchronized (this.targetingLock) {
            this.hybridChallengeInProgress = false;
            this.activeEventStore.savePostponedEvent(null);
            this.backendTargetingResultStore.setTargetingMode(TargetingMode.LOCAL);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(TargetingEngine targetingEngine, Workspace workspace) {
        synchronized (targetingEngine.targetingLock) {
            targetingEngine.workspace = workspace;
            targetingEngine.updateSurveys(workspace);
            targetingEngine.updateDelayTargeting(workspace);
            targetingEngine.updateTimeIntervalTargeting(workspace);
            targetingEngine.updateSuggestions(workspace);
            targetingEngine.updateContactsRepository(workspace);
            targetingEngine.challengeSurveys();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$6(TargetingEngine targetingEngine, String str) {
        synchronized (targetingEngine.targetingLock) {
            targetingEngine.logger.info(LogTags.TARGETING, "Locale changed: " + str);
            targetingEngine.challengeSurveys();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$11(TargetingEngine targetingEngine) {
        synchronized (targetingEngine.targetingLock) {
            targetingEngine.challengeSurveys();
            targetingEngine.eventDelayTargeting.removeOutdatedEvents();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
