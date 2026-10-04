package com.survicate.surveys;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.survicate.surveys.core.targeting.provider.CoreUserTraitsProvider;
import com.survicate.surveys.core.traits.CoreUserTrait;
import com.survicate.surveys.entities.models.ActiveEventHistory;
import com.survicate.surveys.entities.models.ActiveEventHistoryKt;
import com.survicate.surveys.entities.models.ContactAction;
import com.survicate.surveys.entities.models.Respondent;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.entities.survey.Workspace;
import com.survicate.surveys.helpers.BehaviourObservable;
import com.survicate.surveys.helpers.Observable;
import com.survicate.surveys.helpers.UserTraitUtilsKt;
import com.survicate.surveys.infrastructure.storage.MigrationsKt;
import com.survicate.surveys.infrastructure.storage.SurvicateSessionStore;
import com.survicate.surveys.infrastructure.storage.SurvicateStore;
import com.survicate.surveys.infrastructure.storage.SurvicateStoreMigration;
import com.survicate.surveys.infrastructure.storage.SurvicateSynchronizationStore;
import com.survicate.surveys.infrastructure.storage.contacts.ContactStore;
import com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventHistoryStore;
import com.survicate.surveys.infrastructure.storage.respondent.RespondentStore;
import com.survicate.surveys.targeting.ActiveEvent;
import com.survicate.surveys.targeting.provider.PresentationTimesProvider;
import com.survicate.surveys.targeting.provider.SeenSurveysProvider;
import com.survicate.surveys.targeting.provider.UserTraitsProvider;
import com.survicate.surveys.traits.UserTrait;
import com.survicate.surveys.traits.UserTraitExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PersistenceManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B3\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J*\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H 0#H\u0002J'\u0010$\u001a\u00020\u001f\"\u0004\b\u0000\u0010 *\b\u0012\u0004\u0012\u0002H 0\u00152\b\u0010%\u001a\u0004\u0018\u0001H H\u0002¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0016J\u0016\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010/\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u00100\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u00101\u001a\u0002022\u0006\u0010*\u001a\u00020+J\u0010\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u001f2\u0006\u00104\u001a\u000205H\u0016J\u000e\u00107\u001a\b\u0012\u0004\u0012\u0002050\u0018H\u0016J\u0010\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010?\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010@\u001a\u00020\u001fH\u0016J\u0014\u0010A\u001a\u00020\u001f2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0006\u0010C\u001a\u00020\u001fJ\u000e\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160EJ\u0012\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180EJ\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020+H\u0002J\u0010\u0010J\u001a\u00020\u001f2\u0006\u0010K\u001a\u00020-H\u0016J\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u0018H\u0016J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020+0QH\u0016J\u0014\u0010R\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020-0SH\u0016J\u0014\u0010T\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020-0SH\u0016J\b\u0010U\u001a\u0004\u0018\u00010\u0016J\u0010\u0010V\u001a\u0004\u0018\u00010\u00192\u0006\u0010W\u001a\u00020+J\u0012\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020+H\u0016J\u0010\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020]H\u0016J\u0010\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020`H\u0016J\u000e\u0010b\u001a\b\u0012\u0004\u0012\u00020`0\u0018H\u0016J(\u0010c\u001a\u00020\u001f2\u001e\u0010d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020`0\u00180eH\u0016J\b\u0010f\u001a\u00020\u001fH\u0016J\b\u0010g\u001a\u00020\u001fH\u0016J\u0014\u0010h\u001a\u00020\u001f2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020j0\u0018J\f\u0010k\u001a\b\u0012\u0004\u0012\u00020j0\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006l"}, m1599d2 = {"Lcom/survicate/surveys/PersistenceManager;", "Lcom/survicate/surveys/targeting/provider/UserTraitsProvider;", "Lcom/survicate/surveys/core/targeting/provider/CoreUserTraitsProvider;", "Lcom/survicate/surveys/targeting/provider/SeenSurveysProvider;", "Lcom/survicate/surveys/targeting/provider/PresentationTimesProvider;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventHistoryStore;", "Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentStore;", "Lcom/survicate/surveys/infrastructure/storage/contacts/ContactStore;", "store", "Lcom/survicate/surveys/infrastructure/storage/SurvicateStore;", "synchronizationStore", "Lcom/survicate/surveys/infrastructure/storage/SurvicateSynchronizationStore;", "sessionStore", "Lcom/survicate/surveys/infrastructure/storage/SurvicateSessionStore;", "versionProvider", "Lcom/survicate/surveys/SurvicateVersionProvider;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/survicate/surveys/infrastructure/storage/SurvicateStore;Lcom/survicate/surveys/infrastructure/storage/SurvicateSynchronizationStore;Lcom/survicate/surveys/infrastructure/storage/SurvicateSessionStore;Lcom/survicate/surveys/SurvicateVersionProvider;Lkotlinx/coroutines/CoroutineDispatcher;)V", "workspaceObservable", "Lcom/survicate/surveys/helpers/BehaviourObservable;", "Lcom/survicate/surveys/entities/survey/Workspace;", "traitsObservable", "", "Lcom/survicate/surveys/traits/UserTrait;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "migrations", "Lcom/survicate/surveys/infrastructure/storage/SurvicateStoreMigration;", "initializeDataFromStore", "", ExifInterface.GPS_DIRECTION_TRUE, "observable", "loader", "Ljava/util/concurrent/Callable;", "notifyIfEmpty", "data", "(Lcom/survicate/surveys/helpers/BehaviourObservable;Ljava/lang/Object;)V", "saveWorkspace", "workspace", "saveSeenSurvey", "surveyId", "", "presentationTimeMs", "", "saveSeenSurveyId", "updateSurveyFirstPresentationTimeIfShould", "updateSurveyLastPresentationTime", "surveyWasSeen", "", "saveRespondentEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/entities/models/RespondentEvent;", "removeRespondentEvent", "loadRespondentEvents", "saveSurveySeenEvent", "seenEvent", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "saveQuestionAnsweredEvent", "answerEvent", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "removeSurveySeenEvent", "removeQuestionAnsweredEvent", "clearRespondentEvents", "saveTraits", "newTraits", "clearAll", "observeWorkspace", "Lcom/survicate/surveys/helpers/Observable;", "observeTraits", "provideRespondent", "Lcom/survicate/surveys/entities/models/Respondent;", "getOrCreateVisitorUuid", "saveRespondentVerificationTime", "timeMs", "loadUserTraits", "provideUserTraits", "provideCoreUserTraits", "Lcom/survicate/surveys/core/traits/CoreUserTrait;", "loadSeenSurveyIds", "", "loadFirstPresentationTimes", "", "loadLastPresentationTimes", "getWorkspace", "findUserTrait", "attribute", "findMatchingHistory", "Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "eventName", "saveHistoryFor", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "saveContactAction", "action", "Lcom/survicate/surveys/entities/models/ContactAction;", "removeContactAction", "loadContactActions", "updateContactActions", "transform", "Lkotlin/Function1;", "clearUserData", "clearRespondentVerificationTime", "saveResponseAttributes", "attributes", "Lcom/survicate/surveys/ResponseAttribute;", "loadResponseAttributes", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class PersistenceManager implements UserTraitsProvider, CoreUserTraitsProvider, SeenSurveysProvider, PresentationTimesProvider, ActiveEventHistoryStore, RespondentStore, ContactStore {
    private final CoroutineScope coroutineScope;
    private final List<SurvicateStoreMigration> migrations;
    private final SurvicateSessionStore sessionStore;
    private final SurvicateStore store;
    private final SurvicateSynchronizationStore synchronizationStore;
    private final BehaviourObservable<List<UserTrait>> traitsObservable;
    private final BehaviourObservable<Workspace> workspaceObservable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PersistenceManager(SurvicateStore store, SurvicateSynchronizationStore synchronizationStore, SurvicateSessionStore sessionStore, SurvicateVersionProvider versionProvider) {
        this(store, synchronizationStore, sessionStore, versionProvider, null, 16, null);
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(synchronizationStore, "synchronizationStore");
        Intrinsics.checkNotNullParameter(sessionStore, "sessionStore");
        Intrinsics.checkNotNullParameter(versionProvider, "versionProvider");
    }

    public PersistenceManager(SurvicateStore store, SurvicateSynchronizationStore synchronizationStore, SurvicateSessionStore sessionStore, SurvicateVersionProvider versionProvider, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(synchronizationStore, "synchronizationStore");
        Intrinsics.checkNotNullParameter(sessionStore, "sessionStore");
        Intrinsics.checkNotNullParameter(versionProvider, "versionProvider");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.store = store;
        this.synchronizationStore = synchronizationStore;
        this.sessionStore = sessionStore;
        this.workspaceObservable = new BehaviourObservable<>();
        BehaviourObservable<List<UserTrait>> behaviourObservable = new BehaviourObservable<>();
        this.traitsObservable = behaviourObservable;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(ioDispatcher);
        List<SurvicateStoreMigration> listListOf = CollectionsKt.listOf((Object[]) new SurvicateStoreMigration[]{MigrationsKt.getMIGRATION_1_2(), MigrationsKt.getMIGRATION_2_3(), MigrationsKt.getMIGRATION_3_4()});
        this.migrations = listListOf;
        store.migrateSchemaIfNeeded(listListOf);
        if (!versionProvider.isSavedVersionUpToDate(store.loadSavedSdkVersion())) {
            synchronizationStore.clear();
            String sdkVersion = versionProvider.getSdkVersion();
            Intrinsics.checkNotNullExpressionValue(sdkVersion, "getSdkVersion(...)");
            store.saveCurrentSdkVersion(sdkVersion);
        }
        initializeDataFromStore(behaviourObservable, new Callable() { // from class: com.survicate.surveys.PersistenceManager$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PersistenceManager._init_$lambda$0(this.f$0);
            }
        });
    }

    public /* synthetic */ PersistenceManager(SurvicateStore survicateStore, SurvicateSynchronizationStore survicateSynchronizationStore, SurvicateSessionStore survicateSessionStore, SurvicateVersionProvider survicateVersionProvider, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(survicateStore, survicateSynchronizationStore, survicateSessionStore, survicateVersionProvider, (i & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _init_$lambda$0(PersistenceManager persistenceManager) {
        return persistenceManager.store.loadTraits();
    }

    /* JADX INFO: renamed from: com.survicate.surveys.PersistenceManager$initializeDataFromStore$1 */
    /* JADX INFO: compiled from: PersistenceManager.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.survicate.surveys.PersistenceManager$initializeDataFromStore$1", m1609f = "PersistenceManager.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C83681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Callable<T> $loader;
        final /* synthetic */ BehaviourObservable<T> $observable;
        int label;
        final /* synthetic */ PersistenceManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C83681(Callable<T> callable, PersistenceManager persistenceManager, BehaviourObservable<T> behaviourObservable, Continuation<? super C83681> continuation) {
            super(2, continuation);
            this.$loader = callable;
            this.this$0 = persistenceManager;
            this.$observable = behaviourObservable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C83681(this.$loader, this.this$0, this.$observable, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C83681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.notifyIfEmpty(this.$observable, this.$loader.call());
            return Unit.INSTANCE;
        }
    }

    private final <T> void initializeDataFromStore(BehaviourObservable<T> observable, Callable<T> loader) {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C83681(loader, this, observable, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void notifyIfEmpty(BehaviourObservable<T> behaviourObservable, T t) {
        if (behaviourObservable.getLastValue() == null) {
            behaviourObservable.notifyObservers(t);
        }
    }

    public final void saveWorkspace(Workspace workspace) {
        Intrinsics.checkNotNullParameter(workspace, "workspace");
        this.sessionStore.saveWorkspace(workspace);
        this.workspaceObservable.notifyObservers(workspace);
    }

    public final void saveSeenSurvey(String surveyId, long presentationTimeMs) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        saveSeenSurveyId(surveyId);
        updateSurveyFirstPresentationTimeIfShould(surveyId, presentationTimeMs);
        updateSurveyLastPresentationTime(surveyId, presentationTimeMs);
    }

    private final void saveSeenSurveyId(String surveyId) {
        HashSet hashSet = new HashSet(this.store.loadSeenSurveyIds());
        if (hashSet.contains(surveyId)) {
            return;
        }
        hashSet.add(surveyId);
        this.store.saveSeenSurveyIds(hashSet);
    }

    private final void updateSurveyFirstPresentationTimeIfShould(String surveyId, long presentationTimeMs) {
        HashMap map = new HashMap(this.store.loadFirstPresentationTimes());
        if (map.containsKey(surveyId)) {
            return;
        }
        HashMap map2 = map;
        map2.put(surveyId, Long.valueOf(presentationTimeMs));
        this.store.saveSurveysFirstPresentationTimes(map2);
    }

    private final void updateSurveyLastPresentationTime(String surveyId, long presentationTimeMs) {
        HashMap map = new HashMap(this.store.loadLastPresentationTimes());
        map.put(surveyId, Long.valueOf(presentationTimeMs));
        this.store.saveSurveysLastPresentationTimes(map);
    }

    public final boolean surveyWasSeen(String surveyId) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        return this.store.loadSeenSurveyIds().contains(surveyId);
    }

    @Override // com.survicate.surveys.infrastructure.storage.respondent.RespondentStore
    public void saveRespondentEvent(RespondentEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof RespondentEvent.SurveySeen) {
            saveSurveySeenEvent((RespondentEvent.SurveySeen) event);
        } else {
            if (!(event instanceof RespondentEvent.QuestionAnswered)) {
                throw new NoWhenBranchMatchedException();
            }
            saveQuestionAnsweredEvent((RespondentEvent.QuestionAnswered) event);
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.respondent.RespondentStore
    public void removeRespondentEvent(RespondentEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof RespondentEvent.SurveySeen) {
            removeSurveySeenEvent((RespondentEvent.SurveySeen) event);
        } else {
            if (!(event instanceof RespondentEvent.QuestionAnswered)) {
                throw new NoWhenBranchMatchedException();
            }
            removeQuestionAnsweredEvent((RespondentEvent.QuestionAnswered) event);
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.respondent.RespondentStore
    public List<RespondentEvent> loadRespondentEvents() {
        return CollectionsKt.plus((Collection) this.synchronizationStore.loadSeenEventsToSend(), (Iterable) this.synchronizationStore.loadAnswerEventsToSend());
    }

    private final void saveSurveySeenEvent(RespondentEvent.SurveySeen seenEvent) {
        this.synchronizationStore.saveSeenEventsToSend(CollectionsKt.plus((Collection<? extends RespondentEvent.SurveySeen>) this.synchronizationStore.loadSeenEventsToSend(), seenEvent));
    }

    private final void saveQuestionAnsweredEvent(RespondentEvent.QuestionAnswered answerEvent) {
        this.synchronizationStore.saveAnswerEventsToSend(CollectionsKt.plus((Collection<? extends RespondentEvent.QuestionAnswered>) this.synchronizationStore.loadAnswerEventsToSend(), answerEvent));
    }

    private final void removeSurveySeenEvent(RespondentEvent.SurveySeen seenEvent) {
        this.synchronizationStore.saveSeenEventsToSend(CollectionsKt.minus(this.synchronizationStore.loadSeenEventsToSend(), seenEvent));
    }

    private final void removeQuestionAnsweredEvent(RespondentEvent.QuestionAnswered answerEvent) {
        this.synchronizationStore.saveAnswerEventsToSend(CollectionsKt.minus(this.synchronizationStore.loadAnswerEventsToSend(), answerEvent));
    }

    @Override // com.survicate.surveys.infrastructure.storage.respondent.RespondentStore
    public void clearRespondentEvents() {
        this.synchronizationStore.clear();
    }

    public final void saveTraits(List<? extends UserTrait> newTraits) {
        Intrinsics.checkNotNullParameter(newTraits, "newTraits");
        List<UserTrait> listUpdatedWith = UserTraitUtilsKt.updatedWith(this.store.loadTraits(), newTraits);
        this.store.saveUserTraits(listUpdatedWith);
        this.traitsObservable.notifyObservers(listUpdatedWith);
    }

    public final void clearAll() {
        this.store.clear();
        this.sessionStore.clear();
        this.workspaceObservable.notifyObservers(this.sessionStore.getWorkspace());
        this.traitsObservable.notifyObservers(this.store.loadTraits());
    }

    public final Observable<Workspace> observeWorkspace() {
        return this.workspaceObservable;
    }

    public final Observable<List<UserTrait>> observeTraits() {
        return this.traitsObservable;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.RespondentProvider
    public Respondent provideRespondent() {
        return new Respondent(getOrCreateVisitorUuid(), this.store.loadRespondentVerificationTimeMs());
    }

    private final String getOrCreateVisitorUuid() {
        String strLoadVisitorUuid = this.store.loadVisitorUuid();
        if (strLoadVisitorUuid != null) {
            return strLoadVisitorUuid;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.store.saveVisitorUuid(string);
        return string;
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactStore
    public void saveRespondentVerificationTime(long timeMs) {
        this.store.saveRespondentVerificationTimeMs(Long.valueOf(timeMs));
    }

    public final List<UserTrait> loadUserTraits() {
        return this.store.loadTraits();
    }

    @Override // com.survicate.surveys.targeting.provider.UserTraitsProvider
    public List<UserTrait> provideUserTraits() {
        return loadUserTraits();
    }

    @Override // com.survicate.surveys.core.targeting.provider.CoreUserTraitsProvider
    public List<CoreUserTrait> provideCoreUserTraits() {
        List<UserTrait> listLoadUserTraits = loadUserTraits();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listLoadUserTraits, 10));
        Iterator<T> it = listLoadUserTraits.iterator();
        while (it.hasNext()) {
            arrayList.add(UserTraitExtensionsKt.toCoreUserTrait((UserTrait) it.next()));
        }
        return arrayList;
    }

    @Override // com.survicate.surveys.targeting.provider.SeenSurveysProvider
    public Set<String> loadSeenSurveyIds() {
        return this.store.loadSeenSurveyIds();
    }

    @Override // com.survicate.surveys.targeting.provider.PresentationTimesProvider
    public Map<String, Long> loadFirstPresentationTimes() {
        return this.store.loadFirstPresentationTimes();
    }

    @Override // com.survicate.surveys.targeting.provider.PresentationTimesProvider
    public Map<String, Long> loadLastPresentationTimes() {
        return this.store.loadLastPresentationTimes();
    }

    public final Workspace getWorkspace() {
        return this.sessionStore.getWorkspace();
    }

    public final UserTrait findUserTrait(String attribute) {
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        return this.store.findUserTrait(attribute);
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventHistoryStore
    public ActiveEventHistory findMatchingHistory(String eventName) {
        Object next;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Iterator<T> it = this.store.loadEventsHistory().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((ActiveEventHistory) next).getEventName(), eventName)) {
                break;
            }
        }
        return (ActiveEventHistory) next;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventHistoryStore
    public void saveHistoryFor(ActiveEvent activeEvent) {
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        List<ActiveEventHistory> mutableList = CollectionsKt.toMutableList((Collection) this.store.loadEventsHistory());
        Iterator<ActiveEventHistory> it = mutableList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getEventName(), activeEvent.getName())) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            mutableList.set(i, ActiveEventHistoryKt.updatedWithNewOccurrence(mutableList.get(i), activeEvent.getInvokeTimeMs()));
        } else {
            mutableList.add(ActiveEventHistory.INSTANCE.fromActiveEvent(activeEvent));
        }
        this.store.saveEventsHistory(mutableList);
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactStore
    public void saveContactAction(ContactAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.store.saveContactActions(CollectionsKt.plus((Collection<? extends ContactAction>) this.store.loadContactActions(), action));
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactStore
    public void removeContactAction(ContactAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.store.saveContactActions(CollectionsKt.minus(this.store.loadContactActions(), action));
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactStore
    public List<ContactAction> loadContactActions() {
        return this.store.loadContactActions();
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactStore
    public void updateContactActions(Function1<? super List<? extends ContactAction>, ? extends List<? extends ContactAction>> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.store.saveContactActions(transform.invoke(this.store.loadContactActions()));
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactStore
    public void clearUserData() {
        this.store.clearUserData();
    }

    @Override // com.survicate.surveys.infrastructure.storage.contacts.ContactStore
    public void clearRespondentVerificationTime() {
        this.store.saveRespondentVerificationTimeMs(null);
    }

    public final void saveResponseAttributes(List<ResponseAttribute> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.sessionStore.saveResponseAttributes(attributes);
    }

    public final List<ResponseAttribute> loadResponseAttributes() {
        return this.sessionStore.provideResponseAttributes();
    }
}
