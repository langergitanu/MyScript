package com.myscript.nebo.rating;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.myscript.android.utils.ActivityLifecycleCallbacksAdapter;
import com.myscript.android.utils.LongSharedPreferencesProperty;
import com.myscript.android.utils.NullableStringSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.nebo.BuildConfig;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.common.IClock;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.editing.EditingActivity;
import com.myscript.nebo.grid.MainActivity;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.rating.PreRatingFilter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.p039io.CloseableKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: PreRatingFilter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\b\u0007\u0018\u0000 [2\u00020\u0001:\u0003YZ[Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020=J\b\u0010?\u001a\u00020=H\u0002J\u0017\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020BH\u0002¢\u0006\u0004\bC\u0010DJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020FJ\u000e\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u00020JJ\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020;0LH\u0087@¢\u0006\u0002\u0010MJ\u000e\u0010N\u001a\u00020F2\u0006\u0010O\u001a\u00020;J\u001c\u0010P\u001a\u00020F2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0LH\u0082@¢\u0006\u0002\u0010QJ\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020;0L2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0LH\u0002J\u0006\u0010S\u001a\u00020=J\u0006\u0010T\u001a\u00020=J\b\u0010U\u001a\u00020=H\u0002J\b\u0010V\u001a\u00020FH\u0007J\u0010\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R+\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020 8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010$\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b,\u0010\"R\u0014\u0010.\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\"R\u001a\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020 01X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u001cR\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u00106\u001a\n 8*\u0004\u0018\u00010707X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\"}, m1599d2 = {"Lcom/myscript/nebo/rating/PreRatingFilter;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "clock", "Lcom/myscript/nebo/common/IClock;", "neboNetworkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "versionName", "", "buildNumber", "", "sessionFile", "Ljava/io/File;", "sharedPreferences", "Landroid/content/SharedPreferences;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "ioDispatcher", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/common/IClock;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;Lcom/myscript/nebo/log/TechnicalLogger;Ljava/lang/String;ILjava/io/File;Landroid/content/SharedPreferences;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;)V", "getApplication", "()Landroid/app/Application;", "storedVersionSinceLastDisplay", "getStoredVersionSinceLastDisplay", "()Ljava/lang/String;", "storedVersionSinceLastDisplay$delegate", "Lcom/myscript/android/utils/NullableStringSharedPreferencesProperty;", "lastCrashTimestampMillis", "", "getLastCrashTimestampMillis", "()J", "lastCrashTimestampMillis$delegate", "Lcom/myscript/android/utils/LongSharedPreferencesProperty;", "<set-?>", "lastCorruptedPageMillis", "getLastCorruptedPageMillis", "setLastCorruptedPageMillis", "(J)V", "lastCorruptedPageMillis$delegate", "lastPreRatingFilterActionMillis", "getLastPreRatingFilterActionMillis", "lastPreRatingFilterActionMillis$delegate", "currentTimestamp", "getCurrentTimestamp", "currentSession", "", "currentVersion", "getCurrentVersion", "onActivityLifecycleUpdate", "Landroid/app/Application$ActivityLifecycleCallbacks;", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "sessions", "", "Lcom/myscript/nebo/rating/PreRatingFilter$Session;", "preRatingAlertCanBePresentedAfterSuccessfulPurchase", "", "preRatingAlertCanBePresentedAfterClosingANote", "shouldShowPreRatingForUsersBasedOnSessionTime", "shouldShowPreRatingBasedOnStandardCriteria", "currentTime", "Lkotlin/time/Duration;", "shouldShowPreRatingBasedOnStandardCriteria-LRDsOJo", "(J)Z", "saveCrash", "", "saveCorruptedPage", "savePreFilterAction", "action", "Lcom/myscript/nebo/rating/PreRatingFilterAction;", "loadSessions", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSession", "session", "saveSessions", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "packSessions", "requestPreRatingFilterAfterClosingANote", "requestPreRatingFilterAfterPurchase", "isConnected", "storeVersionWhenDisplayed", "formattedVersion", "version", "Provider", "Session", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PreRatingFilter {
    private static final String FILE_SESSION = "sessions.json";
    private static final long MIN_CORRUPTION_LESS_DAYS;
    private static final long MIN_CRASH_LESS_DAYS;
    private static final long MIN_LATER_LESS_DAYS;
    private static final long MIN_LOVE_IT_LESS_YEAR;
    private static final long MIN_NEEDS_REWORK_LESS_DAYS;
    private static final long MIN_SESSION_TIME;
    private static final String PREF_LAST_CORRUPTED_PAGE_TIMESTAMP_MILLIS = "pref_pre_rating_last_corrupted_page_timestamp_millis";
    private static final String PREF_LAST_CRASH_TIMESTAMP_MILLIS = "pref_pre_rating_last_crash_timestamp_millis";
    private static final String PREF_LAST_PRE_FILTER_ACTION = "pref_pre_rating_last_pre_filter_action";
    private static final String PREF_LAST_PRE_FILTER_ACTION_TIMESTAMP_MILLIS = "pref_pre_rating_last_pre_filter_action_timestamp_millis";
    private static final String PREF_RESET_SESSION_TIME_5_12_4 = "pref_pre_rating_reset_session_time_5_12_4";
    private static final String PREF_VERSION_SINCE_LAST_DISPLAY = "pref_pre_rating_version_since_last_display";
    private static final long ROLLING_DAYS;
    private static final String TAG = "PreRatingFilter";
    private final Application application;
    private final int buildNumber;
    private final IClock clock;
    private final CoroutineScope coroutineScope;
    private final Map<String, Long> currentSession;
    private final Gson gson;
    private final CoroutineContext ioDispatcher;

    /* JADX INFO: renamed from: lastCorruptedPageMillis$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty lastCorruptedPageMillis;

    /* JADX INFO: renamed from: lastCrashTimestampMillis$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty lastCrashTimestampMillis;

    /* JADX INFO: renamed from: lastPreRatingFilterActionMillis$delegate, reason: from kotlin metadata */
    private final LongSharedPreferencesProperty lastPreRatingFilterActionMillis;
    private final TechnicalLogger logger;
    private final NeboNetworkStateRepository neboNetworkStateRepository;
    private final Application.ActivityLifecycleCallbacks onActivityLifecycleUpdate;
    private final File sessionFile;
    private final List<Session> sessions;
    private final SharedPreferences sharedPreferences;

    /* JADX INFO: renamed from: storedVersionSinceLastDisplay$delegate, reason: from kotlin metadata */
    private final NullableStringSharedPreferencesProperty storedVersionSinceLastDisplay;
    private final String versionName;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new PropertyReference1Impl(PreRatingFilter.class, "storedVersionSinceLastDisplay", "getStoredVersionSinceLastDisplay()Ljava/lang/String;", 0), new PropertyReference1Impl(PreRatingFilter.class, "lastCrashTimestampMillis", "getLastCrashTimestampMillis()J", 0), new MutablePropertyReference1Impl(PreRatingFilter.class, "lastCorruptedPageMillis", "getLastCorruptedPageMillis()J", 0), new PropertyReference1Impl(PreRatingFilter.class, "lastPreRatingFilterActionMillis", "getLastPreRatingFilterActionMillis()J", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: PreRatingFilter.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/rating/PreRatingFilter$Provider;", "", "providePreRatingFilter", "Lcom/myscript/nebo/rating/PreRatingFilter;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        PreRatingFilter providePreRatingFilter();
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        MIN_CORRUPTION_LESS_DAYS = DurationKt.toDuration(60, DurationUnit.DAYS);
        Duration.Companion companion2 = Duration.INSTANCE;
        MIN_CRASH_LESS_DAYS = DurationKt.toDuration(7, DurationUnit.DAYS);
        Duration.Companion companion3 = Duration.INSTANCE;
        MIN_LATER_LESS_DAYS = DurationKt.toDuration(20, DurationUnit.DAYS);
        Duration.Companion companion4 = Duration.INSTANCE;
        MIN_NEEDS_REWORK_LESS_DAYS = DurationKt.toDuration(60, DurationUnit.DAYS);
        Duration.Companion companion5 = Duration.INSTANCE;
        MIN_LOVE_IT_LESS_YEAR = DurationKt.toDuration(365, DurationUnit.DAYS);
        Duration.Companion companion6 = Duration.INSTANCE;
        ROLLING_DAYS = DurationKt.toDuration(14, DurationUnit.DAYS);
        Duration.Companion companion7 = Duration.INSTANCE;
        MIN_SESSION_TIME = DurationKt.toDuration(10, DurationUnit.MINUTES);
    }

    public PreRatingFilter(Application application, IClock clock, NeboNetworkStateRepository neboNetworkStateRepository, TechnicalLogger technicalLogger, String versionName, int i, File sessionFile, SharedPreferences sharedPreferences, CoroutineScope coroutineScope, CoroutineContext ioDispatcher) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(neboNetworkStateRepository, "neboNetworkStateRepository");
        Intrinsics.checkNotNullParameter(versionName, "versionName");
        Intrinsics.checkNotNullParameter(sessionFile, "sessionFile");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.application = application;
        this.clock = clock;
        this.neboNetworkStateRepository = neboNetworkStateRepository;
        this.logger = technicalLogger;
        this.versionName = versionName;
        this.buildNumber = i;
        this.sessionFile = sessionFile;
        this.sharedPreferences = sharedPreferences;
        this.coroutineScope = coroutineScope;
        this.ioDispatcher = ioDispatcher;
        this.storedVersionSinceLastDisplay = SharedPreferencesExtKt.nullableStringPref(sharedPreferences, PREF_VERSION_SINCE_LAST_DISPLAY, null);
        this.lastCrashTimestampMillis = SharedPreferencesExtKt.longPref$default(sharedPreferences, PREF_LAST_CRASH_TIMESTAMP_MILLIS, 0L, 2, null);
        this.lastCorruptedPageMillis = SharedPreferencesExtKt.longPref$default(sharedPreferences, PREF_LAST_CORRUPTED_PAGE_TIMESTAMP_MILLIS, 0L, 2, null);
        this.lastPreRatingFilterActionMillis = SharedPreferencesExtKt.longPref$default(sharedPreferences, PREF_LAST_PRE_FILTER_ACTION_TIMESTAMP_MILLIS, 0L, 2, null);
        this.currentSession = new LinkedHashMap();
        this.onActivityLifecycleUpdate = new ActivityLifecycleCallbacksAdapter() { // from class: com.myscript.nebo.rating.PreRatingFilter$onActivityLifecycleUpdate$1
            @Override // com.myscript.android.utils.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                try {
                    if (PreRatingFilter.INSTANCE.shouldExtractSessionFromActivity(activity)) {
                        this.this$0.currentSession.put(PreRatingFilter.INSTANCE.getKeyFromActivity(activity), Long.valueOf(this.this$0.getCurrentTimestamp()));
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.myscript.android.utils.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onActivityPaused(activity);
                try {
                    if (PreRatingFilter.INSTANCE.shouldExtractSessionFromActivity(activity)) {
                        String keyFromActivity = PreRatingFilter.INSTANCE.getKeyFromActivity(activity);
                        Long l = (Long) this.this$0.currentSession.get(keyFromActivity);
                        if (l != null) {
                            long jLongValue = l.longValue();
                            this.this$0.currentSession.remove(keyFromActivity);
                            this.this$0.saveSession(new PreRatingFilter.Session(jLongValue, this.this$0.getCurrentTimestamp() - jLongValue));
                        }
                    }
                } catch (Exception unused) {
                }
            }
        };
        this.gson = new GsonBuilder().create();
        this.sessions = new ArrayList();
        if (Intrinsics.areEqual(getCurrentVersion(), "5.12.4") && !sharedPreferences.contains(PREF_RESET_SESSION_TIME_5_12_4)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(PREF_RESET_SESSION_TIME_5_12_4, true);
            sessionFile.delete();
            editorEdit.commit();
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C67442(null), 3, null);
    }

    public final Application getApplication() {
        return this.application;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PreRatingFilter(Application application, IClock iClock, NeboNetworkStateRepository neboNetworkStateRepository, TechnicalLogger technicalLogger, String str, int i, File file, SharedPreferences sharedPreferences, CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        SharedPreferences sharedPreferences2;
        CoroutineContext coroutineContextFrom;
        TechnicalLogger technicalLogger2 = (i2 & 8) != 0 ? null : technicalLogger;
        String str2 = (i2 & 16) != 0 ? BuildConfig.VERSION_NAME : str;
        int i3 = (i2 & 32) != 0 ? 17964 : i;
        File file2 = (i2 & 64) != 0 ? new File(application.getFilesDir(), FILE_SESSION) : file;
        if ((i2 & 128) != 0) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
            sharedPreferences2 = defaultSharedPreferences;
        } else {
            sharedPreferences2 = sharedPreferences;
        }
        CoroutineScope coroutineScope2 = (i2 & 256) != 0 ? GlobalScope.INSTANCE : coroutineScope;
        if ((i2 & 512) != 0) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
            coroutineContextFrom = ExecutorsKt.from(executorServiceNewSingleThreadExecutor);
        } else {
            coroutineContextFrom = coroutineContext;
        }
        this(application, iClock, neboNetworkStateRepository, technicalLogger2, str2, i3, file2, sharedPreferences2, coroutineScope2, coroutineContextFrom);
    }

    private final String getStoredVersionSinceLastDisplay() {
        return this.storedVersionSinceLastDisplay.getValue((Object) this, $$delegatedProperties[0]);
    }

    private final long getLastCrashTimestampMillis() {
        return this.lastCrashTimestampMillis.getValue((Object) this, $$delegatedProperties[1]).longValue();
    }

    private final long getLastCorruptedPageMillis() {
        return this.lastCorruptedPageMillis.getValue((Object) this, $$delegatedProperties[2]).longValue();
    }

    private final void setLastCorruptedPageMillis(long j) {
        this.lastCorruptedPageMillis.setValue(this, $$delegatedProperties[2], j);
    }

    private final long getLastPreRatingFilterActionMillis() {
        return this.lastPreRatingFilterActionMillis.getValue((Object) this, $$delegatedProperties[3]).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getCurrentTimestamp() {
        return this.clock.getTime();
    }

    private final String getCurrentVersion() {
        return formattedVersion(this.versionName + "." + this.buildNumber);
    }

    /* JADX INFO: compiled from: PreRatingFilter.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/rating/PreRatingFilter$Session;", "", "startTimestampMillis", "", "durationMillis", "<init>", "(JJ)V", "getStartTimestampMillis", "()J", "getDurationMillis", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Session {
        public static final int $stable = 0;

        @SerializedName("duration_millis")
        private final long durationMillis;

        @SerializedName("start_timestamp_millis")
        private final long startTimestampMillis;

        public static /* synthetic */ Session copy$default(Session session, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = session.startTimestampMillis;
            }
            if ((i & 2) != 0) {
                j2 = session.durationMillis;
            }
            return session.copy(j, j2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getStartTimestampMillis() {
            return this.startTimestampMillis;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getDurationMillis() {
            return this.durationMillis;
        }

        public final Session copy(long startTimestampMillis, long durationMillis) {
            return new Session(startTimestampMillis, durationMillis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Session)) {
                return false;
            }
            Session session = (Session) other;
            return this.startTimestampMillis == session.startTimestampMillis && this.durationMillis == session.durationMillis;
        }

        public int hashCode() {
            return (Long.hashCode(this.startTimestampMillis) * 31) + Long.hashCode(this.durationMillis);
        }

        public String toString() {
            return "Session(startTimestampMillis=" + this.startTimestampMillis + ", durationMillis=" + this.durationMillis + ")";
        }

        public Session(long j, long j2) {
            this.startTimestampMillis = j;
            this.durationMillis = j2;
        }

        public final long getStartTimestampMillis() {
            return this.startTimestampMillis;
        }

        public final long getDurationMillis() {
            return this.durationMillis;
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.rating.PreRatingFilter$2 */
    /* JADX INFO: compiled from: PreRatingFilter.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.rating.PreRatingFilter$2", m1609f = "PreRatingFilter.kt", m1610i = {}, m1611l = {148}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {149}, m1615s = {}, m1616v = 2)
    static final class C67442 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C67442(Continuation<? super C67442> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreRatingFilter.this.new C67442(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67442) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List list2 = PreRatingFilter.this.sessions;
                this.L$0 = list2;
                this.label = 1;
                Object objLoadSessions = PreRatingFilter.this.loadSessions(this);
                if (objLoadSessions == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = objLoadSessions;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            list.addAll((Collection) obj);
            PreRatingFilter.this.getApplication().registerActivityLifecycleCallbacks(PreRatingFilter.this.onActivityLifecycleUpdate);
            return Unit.INSTANCE;
        }
    }

    public final boolean preRatingAlertCanBePresentedAfterSuccessfulPurchase() {
        if (RetailMode.INSTANCE.isEnabled()) {
            return false;
        }
        String string = this.sharedPreferences.getString(PREF_LAST_PRE_FILTER_ACTION, "NONE");
        PreRatingFilterAction preRatingFilterActionValueOf = PreRatingFilterAction.valueOf(string != null ? string : "NONE");
        boolean z = preRatingFilterActionValueOf == PreRatingFilterAction.LATER;
        Duration.Companion companion = Duration.INSTANCE;
        long duration = DurationKt.toDuration(getCurrentTimestamp(), DurationUnit.MILLISECONDS);
        Duration.Companion companion2 = Duration.INSTANCE;
        return (!isConnected() || (Duration.m15855compareToLRDsOJo(Duration.m15884minusLRDsOJo(duration, DurationKt.toDuration(getLastPreRatingFilterActionMillis(), DurationUnit.MILLISECONDS)), MIN_LOVE_IT_LESS_YEAR) < 0 && preRatingFilterActionValueOf == PreRatingFilterAction.LOVE_IT) || z) ? false : true;
    }

    public final boolean preRatingAlertCanBePresentedAfterClosingANote() {
        boolean z = false;
        if (RetailMode.INSTANCE.isEnabled()) {
            return false;
        }
        Duration.Companion companion = Duration.INSTANCE;
        if (m13361shouldShowPreRatingBasedOnStandardCriteriaLRDsOJo(DurationKt.toDuration(getCurrentTimestamp(), DurationUnit.MILLISECONDS)) && shouldShowPreRatingForUsersBasedOnSessionTime()) {
            z = true;
        }
        if (z) {
            storeVersionWhenDisplayed();
        }
        return z;
    }

    private final boolean shouldShowPreRatingForUsersBasedOnSessionTime() {
        long jM15867getInWholeMillisecondsimpl = Duration.m15867getInWholeMillisecondsimpl(MIN_SESSION_TIME);
        Iterator<T> it = this.sessions.iterator();
        long durationMillis = 0;
        while (it.hasNext()) {
            durationMillis += ((Session) it.next()).getDurationMillis();
        }
        return durationMillis >= jM15867getInWholeMillisecondsimpl;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX INFO: renamed from: shouldShowPreRatingBasedOnStandardCriteria-LRDsOJo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m13361shouldShowPreRatingBasedOnStandardCriteriaLRDsOJo(long currentTime) {
        boolean z;
        String string = this.sharedPreferences.getString(PREF_LAST_PRE_FILTER_ACTION, "NONE");
        PreRatingFilterAction preRatingFilterActionValueOf = PreRatingFilterAction.valueOf(string != null ? string : "NONE");
        String storedVersionSinceLastDisplay = getStoredVersionSinceLastDisplay();
        if (storedVersionSinceLastDisplay == null || storedVersionSinceLastDisplay.length() <= 0) {
            z = false;
        } else {
            String storedVersionSinceLastDisplay2 = getStoredVersionSinceLastDisplay();
            if (storedVersionSinceLastDisplay2 == null) {
                storedVersionSinceLastDisplay2 = "";
            }
            if (Intrinsics.areEqual(formattedVersion(storedVersionSinceLastDisplay2), getCurrentVersion())) {
                z = true;
            }
        }
        Duration.Companion companion = Duration.INSTANCE;
        boolean z2 = Duration.m15855compareToLRDsOJo(Duration.m15884minusLRDsOJo(currentTime, DurationKt.toDuration(getLastCrashTimestampMillis(), DurationUnit.MILLISECONDS)), MIN_CRASH_LESS_DAYS) < 0;
        Duration.Companion companion2 = Duration.INSTANCE;
        boolean z3 = Duration.m15855compareToLRDsOJo(Duration.m15884minusLRDsOJo(currentTime, DurationKt.toDuration(getLastCorruptedPageMillis(), DurationUnit.MILLISECONDS)), MIN_CORRUPTION_LESS_DAYS) < 0;
        Duration.Companion companion3 = Duration.INSTANCE;
        boolean z4 = Duration.m15855compareToLRDsOJo(Duration.m15884minusLRDsOJo(currentTime, DurationKt.toDuration(getLastPreRatingFilterActionMillis(), DurationUnit.MILLISECONDS)), MIN_LATER_LESS_DAYS) < 0 && preRatingFilterActionValueOf == PreRatingFilterAction.LATER;
        Duration.Companion companion4 = Duration.INSTANCE;
        boolean z5 = Duration.m15855compareToLRDsOJo(Duration.m15884minusLRDsOJo(currentTime, DurationKt.toDuration(getLastPreRatingFilterActionMillis(), DurationUnit.MILLISECONDS)), MIN_LOVE_IT_LESS_YEAR) < 0 && preRatingFilterActionValueOf == PreRatingFilterAction.LOVE_IT;
        Duration.Companion companion5 = Duration.INSTANCE;
        return (z || z2 || z3 || !isConnected() || z4 || z5 || (Duration.m15855compareToLRDsOJo(Duration.m15884minusLRDsOJo(currentTime, DurationKt.toDuration(getLastPreRatingFilterActionMillis(), DurationUnit.MILLISECONDS)), MIN_NEEDS_REWORK_LESS_DAYS) < 0 && preRatingFilterActionValueOf == PreRatingFilterAction.NEEDS_REWORK)) ? false : true;
    }

    public final void saveCrash() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putLong(PREF_LAST_CRASH_TIMESTAMP_MILLIS, getCurrentTimestamp());
        editorEdit.commit();
    }

    public final void saveCorruptedPage() {
        setLastCorruptedPageMillis(getCurrentTimestamp());
    }

    public final void savePreFilterAction(PreRatingFilterAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(PREF_LAST_PRE_FILTER_ACTION, action.name());
        editorEdit.putLong(PREF_LAST_PRE_FILTER_ACTION_TIMESTAMP_MILLIS, getCurrentTimestamp());
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.rating.PreRatingFilter$loadSessions$2 */
    /* JADX INFO: compiled from: PreRatingFilter.kt */
    @Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/nebo/rating/PreRatingFilter$Session;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.rating.PreRatingFilter$loadSessions$2", m1609f = "PreRatingFilter.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67452 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Session>>, Object> {
        int label;

        C67452(Continuation<? super C67452> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreRatingFilter.this.new C67452(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Session>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<Session>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<Session>> continuation) {
            return ((C67452) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (PreRatingFilter.this.sessionFile.isFile()) {
                    try {
                        JsonReader jsonReader = new JsonReader(new FileReader(PreRatingFilter.this.sessionFile));
                        PreRatingFilter preRatingFilter = PreRatingFilter.this;
                        try {
                            Type type = new TypeToken<List<? extends Session>>() { // from class: com.myscript.nebo.rating.PreRatingFilter$loadSessions$2$1$type$1
                            }.getType();
                            List listEmptyList = (List) preRatingFilter.gson.fromJson(jsonReader, type);
                            if (listEmptyList == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            CloseableKt.closeFinally(jsonReader, null);
                            return listEmptyList;
                        } finally {
                        }
                    } catch (Exception e) {
                        Log.e(PreRatingFilter.TAG, "Session json file not found or reading error", e);
                        return CollectionsKt.emptyList();
                    }
                } else {
                    return CollectionsKt.emptyList();
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object loadSessions(Continuation<? super List<Session>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new C67452(null), continuation);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.rating.PreRatingFilter$saveSession$1 */
    /* JADX INFO: compiled from: PreRatingFilter.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.rating.PreRatingFilter$saveSession$1", m1609f = "PreRatingFilter.kt", m1610i = {}, m1611l = {263}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {264}, m1615s = {}, m1616v = 2)
    static final class C67461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67461(Continuation<? super C67461> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreRatingFilter.this.new C67461(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PreRatingFilter preRatingFilter = PreRatingFilter.this;
                this.label = 1;
                if (preRatingFilter.saveSessions(CollectionsKt.toList(preRatingFilter.sessions), this) == coroutine_suspended) {
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

    public final void saveSession(Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        this.sessions.add(session);
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C67461(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.rating.PreRatingFilter$saveSessions$2 */
    /* JADX INFO: compiled from: PreRatingFilter.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.rating.PreRatingFilter$saveSessions$2", m1609f = "PreRatingFilter.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67472 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Session> $sessions;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67472(List<Session> list, Continuation<? super C67472> continuation) {
            super(2, continuation);
            this.$sessions = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PreRatingFilter.this.new C67472(this.$sessions, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67472) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (!PreRatingFilter.this.sessionFile.exists()) {
                    try {
                        if (!PreRatingFilter.this.sessionFile.createNewFile()) {
                            Log.e(PreRatingFilter.TAG, "Error while creating session Json file");
                            return Unit.INSTANCE;
                        }
                    } catch (IOException e) {
                        Log.e(PreRatingFilter.TAG, "Error while creating session Json file", e);
                        return Unit.INSTANCE;
                    }
                }
                try {
                    List listPackSessions = PreRatingFilter.this.packSessions(this.$sessions);
                    FileWriter fileWriter = new FileWriter(PreRatingFilter.this.sessionFile);
                    try {
                        PreRatingFilter.this.gson.toJson(listPackSessions, fileWriter);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileWriter, null);
                    } finally {
                    }
                } catch (IOException e2) {
                    Log.e(PreRatingFilter.TAG, "Failed to serialize session", e2);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveSessions(List<Session> list, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C67472(list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Session> packSessions(List<Session> sessions) {
        Duration.Companion companion = Duration.INSTANCE;
        long duration = DurationKt.toDuration(getCurrentTimestamp(), DurationUnit.MILLISECONDS);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : sessions) {
            Duration.Companion companion2 = Duration.INSTANCE;
            if (Duration.m15855compareToLRDsOJo(Duration.m15884minusLRDsOJo(duration, DurationKt.toDuration(((Session) obj).getStartTimestampMillis(), DurationUnit.MILLISECONDS)), ROLLING_DAYS) < 0) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List<Session> list = (List) pair.component1();
        List list2 = (List) pair.component2();
        if (list2.isEmpty()) {
            return list;
        }
        Iterator it = list2.iterator();
        long durationMillis = 0;
        while (it.hasNext()) {
            durationMillis += ((Session) it.next()).getDurationMillis();
        }
        long jM15884minusLRDsOJo = Duration.m15884minusLRDsOJo(duration, ROLLING_DAYS);
        Duration.Companion companion3 = Duration.INSTANCE;
        return CollectionsKt.plus((Collection) CollectionsKt.listOf(new Session(Duration.m15867getInWholeMillisecondsimpl(Duration.m15884minusLRDsOJo(jM15884minusLRDsOJo, DurationKt.toDuration(1, DurationUnit.DAYS))), durationMillis)), (Iterable) list);
    }

    public final boolean requestPreRatingFilterAfterClosingANote() {
        return preRatingAlertCanBePresentedAfterClosingANote();
    }

    public final boolean requestPreRatingFilterAfterPurchase() {
        return preRatingAlertCanBePresentedAfterSuccessfulPurchase();
    }

    private final boolean isConnected() {
        NeboNetworkState value = this.neboNetworkStateRepository.getNeboNetworkState().getValue();
        if (value != null) {
            return value.isDataTransferAllowed();
        }
        return false;
    }

    public final void storeVersionWhenDisplayed() {
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(PREF_VERSION_SINCE_LAST_DISPLAY, getCurrentVersion());
        editorEdit.apply();
    }

    private final String formattedVersion(String version) {
        String strSubstring = version.substring(0, StringsKt.lastIndexOf$default((CharSequence) version, '.', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* JADX INFO: compiled from: PreRatingFilter.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/rating/PreRatingFilter$Companion;", "", "<init>", "()V", "TAG", "", "PREF_LAST_CRASH_TIMESTAMP_MILLIS", "PREF_LAST_CORRUPTED_PAGE_TIMESTAMP_MILLIS", "PREF_LAST_PRE_FILTER_ACTION", "PREF_LAST_PRE_FILTER_ACTION_TIMESTAMP_MILLIS", "FILE_SESSION", "PREF_RESET_SESSION_TIME_5_12_4", "PREF_VERSION_SINCE_LAST_DISPLAY", "MIN_CORRUPTION_LESS_DAYS", "Lkotlin/time/Duration;", "J", "MIN_CRASH_LESS_DAYS", "MIN_LATER_LESS_DAYS", "MIN_NEEDS_REWORK_LESS_DAYS", "MIN_LOVE_IT_LESS_YEAR", "ROLLING_DAYS", "MIN_SESSION_TIME", "shouldExtractSessionFromActivity", "", "activity", "Landroid/app/Activity;", "getKeyFromActivity", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean shouldExtractSessionFromActivity(Activity activity) {
            return (activity instanceof MainActivity) || (activity instanceof EditingActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getKeyFromActivity(Activity activity) {
            String simpleName = activity.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            return simpleName;
        }
    }
}
