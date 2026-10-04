package com.myscript.nebo.sso;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.media3.common.MimeTypes;
import androidx.preference.PreferenceManager;
import com.google.common.net.HttpHeaders;
import com.myscript.android.utils.IntSharedPreferencesProperty;
import com.myscript.android.utils.SharedPreferencesExtKt;
import com.myscript.nebo.common.IClock;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepository;
import com.myscript.nebo.sso.model.UserData;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: HelpUsManager.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0003*+,B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\rH\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006-"}, m1599d2 = {"Lcom/myscript/nebo/sso/HelpUsManager;", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "clock", "Lcom/myscript/nebo/common/IClock;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "networkStateRepository", "Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/common/IClock;Lcom/myscript/nebo/sso/model/UserData;Lcom/myscript/nebo/common/network/NeboNetworkStateRepository;)V", "showAfterLogIn", "", "activeConsumer", "Lcom/myscript/nebo/sso/IHelpUsConsumer;", "sharedPreferences", "Landroid/content/SharedPreferences;", "onSharedPreferenceChanged", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "getOnSharedPreferenceChanged", "()Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "dialogShownTimestamp", "", "getDialogShownTimestamp", "()J", "<set-?>", "", "userActionCounter", "getUserActionCounter", "()I", "setUserActionCounter", "(I)V", "userActionCounter$delegate", "Lcom/myscript/android/utils/IntSharedPreferencesProperty;", "increaseUserActionCounter", "", "isLastNotesSharingRequestDateValid", "showDialogIfNeeded", "origin", "Lcom/myscript/nebo/sso/HelpUsManager$Origin;", "userLoggedIn", "Provider", HttpHeaders.ORIGIN, "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HelpUsManager {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {new MutablePropertyReference1Impl(HelpUsManager.class, "userActionCounter", "getUserActionCounter()I", 0)};
    private static final int MIN_INTERVAL_SHOWING_DAYS = 180;
    private static final int MIN_USER_ACTIONS = 2;
    private static final String PREF_HELP_US_USER_ACTION_KEY = "pref_help_us_user_action_key";
    private IHelpUsConsumer activeConsumer;
    private final IClock clock;
    private final NeboNetworkStateRepository networkStateRepository;
    private final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChanged;
    private final SharedPreferences sharedPreferences;
    private boolean showAfterLogIn;

    /* JADX INFO: renamed from: userActionCounter$delegate, reason: from kotlin metadata */
    private final IntSharedPreferencesProperty userActionCounter;
    private final UserData userData;

    /* JADX INFO: compiled from: HelpUsManager.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/HelpUsManager$Provider;", "", "provideHelpUsManager", "Lcom/myscript/nebo/sso/HelpUsManager;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        HelpUsManager provideHelpUsManager();
    }

    public HelpUsManager(Application application, IClock clock, UserData userData, NeboNetworkStateRepository networkStateRepository) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(clock, "clock");
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(networkStateRepository, "networkStateRepository");
        this.clock = clock;
        this.userData = userData;
        this.networkStateRepository = networkStateRepository;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.sharedPreferences = defaultSharedPreferences;
        this.onSharedPreferenceChanged = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.myscript.nebo.sso.HelpUsManager$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                HelpUsManager.onSharedPreferenceChanged$lambda$0(this.f$0, sharedPreferences, str);
            }
        };
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.myscript.nebo.sso.HelpUsManager.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (activity instanceof IHelpUsConsumer) {
                    HelpUsManager.this.activeConsumer = (IHelpUsConsumer) activity;
                    if (savedInstanceState == null) {
                        HelpUsManager.this.showDialogIfNeeded(Origin.FROM_START_UP);
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (activity instanceof IHelpUsConsumer) {
                    HelpUsManager.this.activeConsumer = (IHelpUsConsumer) activity;
                    HelpUsManager.this.sharedPreferences.registerOnSharedPreferenceChangeListener(HelpUsManager.this.getOnSharedPreferenceChanged());
                    if (HelpUsManager.this.showAfterLogIn) {
                        HelpUsManager.this.showDialogIfNeeded(Origin.FROM_LOGIN);
                        HelpUsManager.this.showAfterLogIn = false;
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                HelpUsManager.this.sharedPreferences.unregisterOnSharedPreferenceChangeListener(HelpUsManager.this.getOnSharedPreferenceChanged());
                HelpUsManager.this.activeConsumer = null;
            }
        });
        this.userActionCounter = SharedPreferencesExtKt.intPref(defaultSharedPreferences, PREF_HELP_US_USER_ACTION_KEY, 0);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: HelpUsManager.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/sso/HelpUsManager$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "FROM_START_UP", "FROM_USER_ACTION", "FROM_LOGIN", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Origin {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Origin[] $VALUES;
        public static final Origin FROM_START_UP = new Origin("FROM_START_UP", 0);
        public static final Origin FROM_USER_ACTION = new Origin("FROM_USER_ACTION", 1);
        public static final Origin FROM_LOGIN = new Origin("FROM_LOGIN", 2);

        private static final /* synthetic */ Origin[] $values() {
            return new Origin[]{FROM_START_UP, FROM_USER_ACTION, FROM_LOGIN};
        }

        public static EnumEntries<Origin> getEntries() {
            return $ENTRIES;
        }

        public static Origin valueOf(String str) {
            return (Origin) Enum.valueOf(Origin.class, str);
        }

        public static Origin[] values() {
            return (Origin[]) $VALUES.clone();
        }

        private Origin(String str, int i) {
        }

        static {
            Origin[] originArr$values = $values();
            $VALUES = originArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(originArr$values);
        }
    }

    public final SharedPreferences.OnSharedPreferenceChangeListener getOnSharedPreferenceChanged() {
        return this.onSharedPreferenceChanged;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSharedPreferenceChanged$lambda$0(HelpUsManager helpUsManager, SharedPreferences sharedPreferences, String str) {
        if (str != null && str.hashCode() == -2102588981 && str.equals(PREF_HELP_US_USER_ACTION_KEY)) {
            helpUsManager.showDialogIfNeeded(Origin.FROM_USER_ACTION);
        }
    }

    private final long getDialogShownTimestamp() {
        return this.userData.getNotesSharingRequestDate();
    }

    private final int getUserActionCounter() {
        return this.userActionCounter.getValue((Object) this, $$delegatedProperties[0]).intValue();
    }

    private final void setUserActionCounter(int i) {
        this.userActionCounter.setValue(this, $$delegatedProperties[0], i);
    }

    public final void increaseUserActionCounter() {
        setUserActionCounter(getUserActionCounter() + 1);
    }

    private final boolean isLastNotesSharingRequestDateValid() {
        return getDialogShownTimestamp() != 0 && ((int) ((this.clock.getTime() - getDialogShownTimestamp()) / 86400000)) < 180;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialogIfNeeded(Origin origin) {
        IHelpUsConsumer iHelpUsConsumer = this.activeConsumer;
        if (iHelpUsConsumer == null) {
            return;
        }
        NeboNetworkState value = this.networkStateRepository.getNeboNetworkState().getValue();
        boolean zIsDataTransferAllowed = value != null ? value.isDataTransferAllowed() : false;
        boolean zIsLastNotesSharingRequestDateValid = isLastNotesSharingRequestDateValid();
        if (iHelpUsConsumer.canShowHelpUsDialog() && this.userData.hasUser() && !this.userData.isNotesSharingActivated() && zIsDataTransferAllowed && origin != Origin.FROM_LOGIN) {
            if (origin == Origin.FROM_START_UP) {
                if (zIsLastNotesSharingRequestDateValid) {
                    return;
                }
            } else if (origin != Origin.FROM_USER_ACTION || zIsLastNotesSharingRequestDateValid || getUserActionCounter() < 2) {
                return;
            }
            iHelpUsConsumer.showHelpUsDialog();
            if (origin == Origin.FROM_USER_ACTION) {
                setUserActionCounter(0);
            }
            this.userData.setNotesSharingRequestDate(this.clock.getTime());
        }
    }

    public final void userLoggedIn() {
        this.showAfterLogIn = true;
    }
}
