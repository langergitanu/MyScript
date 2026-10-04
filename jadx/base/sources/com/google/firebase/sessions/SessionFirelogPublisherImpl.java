package com.google.firebase.sessions;

import android.util.Log;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: SessionFirelogPublisher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisherImpl;", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "sessionSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/EventGDTLoggerInterface;Lkotlin/coroutines/CoroutineContext;)V", "mayLogSession", "", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "attemptLoggingSessionEvent", "sessionEvent", "Lcom/google/firebase/sessions/SessionEvent;", "shouldLogSession", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldCollectEvents", "Companion", "com.google.firebase-firebase-sessions"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {
    private static final double randomValueForSampling = Math.random();
    private final CoroutineContext backgroundDispatcher;
    private final EventGDTLoggerInterface eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final SessionsSettings sessionSettings;

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 */
    /* JADX INFO: compiled from: SessionFirelogPublisher.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", m1609f = "SessionFirelogPublisher.kt", m1610i = {0, 1}, m1611l = {98, 104}, m1612m = "shouldLogSession", m1613n = {"this", "this"}, m1615s = {"L$0", "L$0"})
    static final class C59001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C59001(Continuation<? super C59001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionFirelogPublisherImpl.this.shouldLogSession(this);
        }
    }

    @Inject
    public SessionFirelogPublisherImpl(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, SessionsSettings sessionSettings, EventGDTLoggerInterface eventGDTLogger, @Background CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(sessionSettings, "sessionSettings");
        Intrinsics.checkNotNullParameter(eventGDTLogger, "eventGDTLogger");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallations;
        this.sessionSettings = sessionSettings;
        this.eventGDTLogger = eventGDTLogger;
        this.backgroundDispatcher = backgroundDispatcher;
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$mayLogSession$1 */
    /* JADX INFO: compiled from: SessionFirelogPublisher.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$mayLogSession$1", m1609f = "SessionFirelogPublisher.kt", m1610i = {2}, m1611l = {70, TsExtractor.TS_SYNC_BYTE, 77}, m1612m = "invokeSuspend", m1613n = {"installationId"}, m1615s = {"L$0"})
    static final class C58991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionDetails $sessionDetails;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C58991(SessionDetails sessionDetails, Continuation<? super C58991> continuation) {
            super(2, continuation);
            this.$sessionDetails = sessionDetails;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionFirelogPublisherImpl.this.new C58991(this.$sessionDetails, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C58991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00a1  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            InstallationId installationId;
            SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
            Object registeredSubscribers$com_google_firebase_firebase_sessions;
            FirebaseApp firebaseApp;
            SessionDetails sessionDetails;
            SessionEvents sessionEvents;
            SessionsSettings sessionsSettings;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = SessionFirelogPublisherImpl.this.shouldLogSession(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    SessionsSettings sessionsSettings2 = (SessionsSettings) this.L$5;
                    SessionDetails sessionDetails2 = (SessionDetails) this.L$4;
                    FirebaseApp firebaseApp2 = (FirebaseApp) this.L$3;
                    SessionEvents sessionEvents2 = (SessionEvents) this.L$2;
                    sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) this.L$1;
                    installationId = (InstallationId) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sessionsSettings = sessionsSettings2;
                    sessionEvents = sessionEvents2;
                    sessionDetails = sessionDetails2;
                    firebaseApp = firebaseApp2;
                    SessionFirelogPublisherImpl sessionFirelogPublisherImpl2 = sessionFirelogPublisherImpl;
                    Map<SessionSubscriber.Name, ? extends SessionSubscriber> map = (Map) obj;
                    InstallationId installationId2 = installationId;
                    sessionFirelogPublisherImpl2.attemptLoggingSessionEvent(sessionEvents.buildSession(firebaseApp, sessionDetails, sessionsSettings, map, installationId2.getFid(), installationId2.getAuthToken()));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                installationId = (InstallationId) obj;
                sessionFirelogPublisherImpl = SessionFirelogPublisherImpl.this;
                SessionEvents sessionEvents3 = SessionEvents.INSTANCE;
                FirebaseApp firebaseApp3 = SessionFirelogPublisherImpl.this.firebaseApp;
                SessionDetails sessionDetails3 = this.$sessionDetails;
                SessionsSettings sessionsSettings3 = SessionFirelogPublisherImpl.this.sessionSettings;
                this.L$0 = installationId;
                this.L$1 = sessionFirelogPublisherImpl;
                this.L$2 = sessionEvents3;
                this.L$3 = firebaseApp3;
                this.L$4 = sessionDetails3;
                this.L$5 = sessionsSettings3;
                this.label = 3;
                registeredSubscribers$com_google_firebase_firebase_sessions = FirebaseSessionsDependencies.INSTANCE.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
                if (registeredSubscribers$com_google_firebase_firebase_sessions != coroutine_suspended) {
                    firebaseApp = firebaseApp3;
                    obj = registeredSubscribers$com_google_firebase_firebase_sessions;
                    sessionDetails = sessionDetails3;
                    sessionEvents = sessionEvents3;
                    sessionsSettings = sessionsSettings3;
                    SessionFirelogPublisherImpl sessionFirelogPublisherImpl22 = sessionFirelogPublisherImpl;
                    Map<SessionSubscriber.Name, ? extends SessionSubscriber> map2 = (Map) obj;
                    InstallationId installationId22 = installationId;
                    sessionFirelogPublisherImpl22.attemptLoggingSessionEvent(sessionEvents.buildSession(firebaseApp, sessionDetails, sessionsSettings, map2, installationId22.getFid(), installationId22.getAuthToken()));
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
                this.label = 2;
                obj = InstallationId.INSTANCE.create(SessionFirelogPublisherImpl.this.firebaseInstallations, this);
                if (obj != coroutine_suspended) {
                    installationId = (InstallationId) obj;
                    sessionFirelogPublisherImpl = SessionFirelogPublisherImpl.this;
                    SessionEvents sessionEvents32 = SessionEvents.INSTANCE;
                    FirebaseApp firebaseApp32 = SessionFirelogPublisherImpl.this.firebaseApp;
                    SessionDetails sessionDetails32 = this.$sessionDetails;
                    SessionsSettings sessionsSettings32 = SessionFirelogPublisherImpl.this.sessionSettings;
                    this.L$0 = installationId;
                    this.L$1 = sessionFirelogPublisherImpl;
                    this.L$2 = sessionEvents32;
                    this.L$3 = firebaseApp32;
                    this.L$4 = sessionDetails32;
                    this.L$5 = sessionsSettings32;
                    this.label = 3;
                    registeredSubscribers$com_google_firebase_firebase_sessions = FirebaseSessionsDependencies.INSTANCE.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
                    if (registeredSubscribers$com_google_firebase_firebase_sessions != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void mayLogSession(SessionDetails sessionDetails) {
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new C58991(sessionDetails, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attemptLoggingSessionEvent(SessionEvent sessionEvent) {
        try {
            this.eventGDTLogger.log(sessionEvent);
            Log.d(FirebaseSessions.TAG, "Successfully logged Session Start event.");
        } catch (RuntimeException e) {
            Log.e(FirebaseSessions.TAG, "Error logging Session Start event to DataTransport: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object shouldLogSession(Continuation<? super Boolean> continuation) {
        C59001 c59001;
        SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
        SessionFirelogPublisherImpl sessionFirelogPublisherImpl2;
        if (continuation instanceof C59001) {
            c59001 = (C59001) continuation;
            if ((c59001.label & Integer.MIN_VALUE) != 0) {
                c59001.label -= Integer.MIN_VALUE;
            } else {
                c59001 = new C59001(continuation);
            }
        }
        Object registeredSubscribers$com_google_firebase_firebase_sessions = c59001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c59001.label;
        if (i == 0) {
            ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
            FirebaseSessionsDependencies firebaseSessionsDependencies = FirebaseSessionsDependencies.INSTANCE;
            c59001.L$0 = this;
            c59001.label = 1;
            registeredSubscribers$com_google_firebase_firebase_sessions = firebaseSessionsDependencies.getRegisteredSubscribers$com_google_firebase_firebase_sessions(c59001);
            if (registeredSubscribers$com_google_firebase_firebase_sessions != coroutine_suspended) {
                sessionFirelogPublisherImpl = this;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            sessionFirelogPublisherImpl2 = (SessionFirelogPublisherImpl) c59001.L$0;
            ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
            if (sessionFirelogPublisherImpl2.sessionSettings.getSessionsEnabled()) {
                Log.d(FirebaseSessions.TAG, "Sessions SDK disabled through settings API. Events will not be sent.");
                return Boxing.boxBoolean(false);
            }
            if (!sessionFirelogPublisherImpl2.shouldCollectEvents()) {
                Log.d(FirebaseSessions.TAG, "Sessions SDK has dropped this session due to sampling.");
                return Boxing.boxBoolean(false);
            }
            return Boxing.boxBoolean(true);
        }
        sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) c59001.L$0;
        ResultKt.throwOnFailure(registeredSubscribers$com_google_firebase_firebase_sessions);
        Collection collectionValues = ((Map) registeredSubscribers$com_google_firebase_firebase_sessions).values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((SessionSubscriber) it.next()).isDataCollectionEnabled()) {
                    SessionsSettings sessionsSettings = sessionFirelogPublisherImpl.sessionSettings;
                    c59001.L$0 = sessionFirelogPublisherImpl;
                    c59001.label = 2;
                    if (sessionsSettings.updateSettings(c59001) != coroutine_suspended) {
                        sessionFirelogPublisherImpl2 = sessionFirelogPublisherImpl;
                        if (sessionFirelogPublisherImpl2.sessionSettings.getSessionsEnabled()) {
                        }
                    }
                    return coroutine_suspended;
                }
            }
        }
        Log.d(FirebaseSessions.TAG, "Sessions SDK disabled through data collection. Events will not be sent.");
        return Boxing.boxBoolean(false);
    }

    private final boolean shouldCollectEvents() {
        return randomValueForSampling <= this.sessionSettings.getSamplingRate();
    }
}
