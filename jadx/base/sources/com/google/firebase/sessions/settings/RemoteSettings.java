package com.google.firebase.sessions.settings;

import android.os.Build;
import android.util.Log;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.FirebaseSessions;
import com.google.firebase.sessions.InstallationId;
import com.google.firebase.sessions.TimeProvider;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: RemoteSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u0000 %2\u00020\u0001:\u0001%B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010 \u001a\u00020\u001dH\u0081@¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, m1599d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "timeProvider", "Lcom/google/firebase/sessions/TimeProvider;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "<init>", "(Lcom/google/firebase/sessions/TimeProvider;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Lcom/google/firebase/sessions/settings/SettingsCache;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "sessionEnabled", "", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "samplingRate", "", "getSamplingRate", "()Ljava/lang/Double;", "updateSettings", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSettingsStale", "clearCachedSettings", "clearCachedSettings$com_google_firebase_firebase_sessions", "sanitize", "", CmcdData.STREAMING_FORMAT_SS, "Companion", "com.google.firebase-firebase-sessions"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);
    private static final int defaultCacheDuration;
    private static final Regex sanitizeRegex;
    private final ApplicationInfo appInfo;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final Mutex fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final SettingsCache settingsCache;
    private final TimeProvider timeProvider;

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 */
    /* JADX INFO: compiled from: RemoteSettings.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.google.firebase.sessions.settings.RemoteSettings", m1609f = "RemoteSettings.kt", m1610i = {0, 0, 1, 1, 2}, m1611l = {165, MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64, PDFACompliance.e_PDFA9_5}, m1612m = "updateSettings", m1613n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
    static final class C59061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C59061(Continuation<? super C59061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteSettings.this.updateSettings(this);
        }
    }

    @Inject
    public RemoteSettings(TimeProvider timeProvider, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, SettingsCache settingsCache) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(settingsCache, "settingsCache");
        this.timeProvider = timeProvider;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.settingsCache = settingsCache;
        this.fetchInProgress = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return this.settingsCache.sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* JADX INFO: renamed from: getSessionRestartTimeout-FghU774 */
    public Duration mo12503getSessionRestartTimeoutFghU774() {
        Integer numSessionRestartTimeout = this.settingsCache.sessionRestartTimeout();
        if (numSessionRestartTimeout == null) {
            return null;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m15854boximpl(DurationKt.toDuration(numSessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return this.settingsCache.sessionSamplingRate();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00bd A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004b, B:45:0x00af, B:47:0x00bd, B:51:0x00c9), top: B:65:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object updateSettings(Continuation<? super Unit> continuation) throws Throwable {
        C59061 c59061;
        Mutex mutex;
        RemoteSettings remoteSettings;
        Mutex mutex2;
        Throwable th;
        Mutex mutex3;
        String fid;
        if (continuation instanceof C59061) {
            c59061 = (C59061) continuation;
            if ((c59061.label & Integer.MIN_VALUE) != 0) {
                c59061.label -= Integer.MIN_VALUE;
            } else {
                c59061 = new C59061(continuation);
            }
        }
        Object obj = c59061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c59061.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.fetchInProgress.isLocked() && !this.settingsCache.hasCacheExpired()) {
                    return Unit.INSTANCE;
                }
                mutex = this.fetchInProgress;
                c59061.L$0 = this;
                c59061.L$1 = mutex;
                c59061.label = 1;
                if (mutex.lock(null, c59061) != coroutine_suspended) {
                    remoteSettings = this;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) c59061.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                mutex3 = (Mutex) c59061.L$1;
                remoteSettings = (RemoteSettings) c59061.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    fid = ((InstallationId) obj).getFid();
                    if (!Intrinsics.areEqual(fid, "")) {
                        Log.w(FirebaseSessions.TAG, "Error getting Firebase Installation ID. Skipping this Session Event.");
                        Unit unit2 = Unit.INSTANCE;
                        mutex3.unlock(null);
                        return unit2;
                    }
                    String INCREMENTAL = Build.VERSION.INCREMENTAL;
                    Intrinsics.checkNotNullExpressionValue(INCREMENTAL, "INCREMENTAL");
                    String RELEASE = Build.VERSION.RELEASE;
                    Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
                    Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.m1606to("X-Crashlytics-Installation-ID", fid), TuplesKt.m1606to("X-Crashlytics-Device-Model", remoteSettings.sanitize(Build.MANUFACTURER + Build.MODEL)), TuplesKt.m1606to("X-Crashlytics-OS-Build-Version", remoteSettings.sanitize(INCREMENTAL)), TuplesKt.m1606to("X-Crashlytics-OS-Display-Version", remoteSettings.sanitize(RELEASE)), TuplesKt.m1606to("X-Crashlytics-API-Client-Version", remoteSettings.appInfo.getSessionSdkVersion()));
                    Log.d(FirebaseSessions.TAG, "Fetching settings from server.");
                    CrashlyticsSettingsFetcher crashlyticsSettingsFetcher = remoteSettings.configsFetcher;
                    RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(remoteSettings, null);
                    RemoteSettings$updateSettings$2$2 remoteSettings$updateSettings$2$2 = new RemoteSettings$updateSettings$2$2(null);
                    c59061.L$0 = mutex3;
                    c59061.L$1 = null;
                    c59061.label = 3;
                    if (crashlyticsSettingsFetcher.doConfigFetch(mapMapOf, remoteSettings$updateSettings$2$1, remoteSettings$updateSettings$2$2, c59061) != coroutine_suspended) {
                        mutex2 = mutex3;
                        Unit unit3 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th3) {
                    th = th3;
                    mutex2 = mutex3;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex4 = (Mutex) c59061.L$1;
            remoteSettings = (RemoteSettings) c59061.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex4;
            if (!remoteSettings.settingsCache.hasCacheExpired()) {
                Log.d(FirebaseSessions.TAG, "Remote settings cache not expired. Using cached values.");
                Unit unit4 = Unit.INSTANCE;
                mutex.unlock(null);
                return unit4;
            }
            InstallationId.Companion companion = InstallationId.INSTANCE;
            FirebaseInstallationsApi firebaseInstallationsApi = remoteSettings.firebaseInstallationsApi;
            c59061.L$0 = remoteSettings;
            c59061.L$1 = mutex;
            c59061.label = 2;
            Object objCreate = companion.create(firebaseInstallationsApi, c59061);
            if (objCreate != coroutine_suspended) {
                mutex3 = mutex;
                obj = objCreate;
                fid = ((InstallationId) obj).getFid();
                if (!Intrinsics.areEqual(fid, "")) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            mutex2 = mutex;
            th = th4;
            mutex2.unlock(null);
            throw th;
        }
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return this.settingsCache.hasCacheExpired();
    }

    public final Object clearCachedSettings$com_google_firebase_firebase_sessions(Continuation<? super Unit> continuation) {
        Object objUpdateConfigs = this.settingsCache.updateConfigs(SessionConfigsSerializer.INSTANCE.getDefaultValue(), continuation);
        return objUpdateConfigs == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfigs : Unit.INSTANCE;
    }

    private final String sanitize(String s) {
        return sanitizeRegex.replace(s, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: RemoteSettings.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "<init>", "()V", "defaultCacheDuration", "", "getDefaultCacheDuration", "()I", "sanitizeRegex", "Lkotlin/text/Regex;", "getSanitizeRegex", "()Lkotlin/text/Regex;", "com.google.firebase-firebase-sessions"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getDefaultCacheDuration() {
            return RemoteSettings.defaultCacheDuration;
        }

        public final Regex getSanitizeRegex() {
            return RemoteSettings.sanitizeRegex;
        }
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        defaultCacheDuration = (int) Duration.m15870getInWholeSecondsimpl(DurationKt.toDuration(24, DurationUnit.HOURS));
        sanitizeRegex = new Regex("com/google/firebase/sessions//");
    }
}
