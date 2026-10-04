package com.myscript.nebo.settings;

import android.content.ComponentCallbacks2;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;
import com.google.android.material.snackbar.Snackbar;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.nebo.analytics.C6150R;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PrivacySettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001cH\u0002J\b\u0010*\u001a\u00020\u001cH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006+"}, m1599d2 = {"Lcom/myscript/nebo/settings/PrivacySettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "setupShareMyNotes", "getShareMyNotesSetting", "setShareMyNotesPrefEnabled", "shareMyNotesPrefEnabled", "setShareMyNotesPrefChecked", "shareMyNotesPrefChecked", "onShareMyNotesClicked", "preference", "Landroidx/preference/Preference;", "setShareMyNotesSetting", "checked", "hasInternetAccess", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PrivacySettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    public static final int $stable = 8;
    private Navigator navigator;
    private ISSOManager ssoManager;
    private UserData userData;

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return 0;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.privacy_settings);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.sso.model.UserData.Provider");
        this.userData = ((UserData.Provider) application).provideUserData();
        this.ssoManager = ((ISSOManager.Provider) application).provideSSOManager();
        setupShareMyNotes();
        Preference preferenceFindPreference = findPreference(getString(C6150R.string.pref_analytics_log_event_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.PrivacySettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return PrivacySettingsFragment.onCreatePreferences$lambda$0(preference, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$0(Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        AnalyticsController.setUserPersonalizedSettings(true);
        return true;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_privacy_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    private final void setupShareMyNotes() {
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_share_notes_key));
        if (preferenceFindPreference != null) {
            UserData userData = this.userData;
            if (userData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userData");
                userData = null;
            }
            if (!userData.hasUser()) {
                preferenceFindPreference.setVisible(false);
                return;
            }
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.PrivacySettingsFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return PrivacySettingsFragment.setupShareMyNotes$lambda$0(this.f$0, preference);
                }
            });
            preferenceFindPreference.setVisible(true);
            setShareMyNotesPrefEnabled(hasInternetAccess());
            getShareMyNotesSetting();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupShareMyNotes$lambda$0(PrivacySettingsFragment privacySettingsFragment, Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        return privacySettingsFragment.onShareMyNotesClicked(preference);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.PrivacySettingsFragment$getShareMyNotesSetting$1 */
    /* JADX INFO: compiled from: PrivacySettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.PrivacySettingsFragment$getShareMyNotesSetting$1", m1609f = "PrivacySettingsFragment.kt", m1610i = {}, m1611l = {72}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {75}, m1615s = {}, m1616v = 2)
    static final class C67891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C67891(Continuation<? super C67891> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PrivacySettingsFragment.this.new C67891(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.myscript.nebo.settings.PrivacySettingsFragment$getShareMyNotesSetting$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PrivacySettingsFragment.kt */
        @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "com.myscript.nebo.settings.PrivacySettingsFragment$getShareMyNotesSetting$1$1", m1609f = "PrivacySettingsFragment.kt", m1610i = {}, m1611l = {73}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {74}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ PrivacySettingsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(PrivacySettingsFragment privacySettingsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = privacySettingsFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    ISSOManager iSSOManager = this.this$0.ssoManager;
                    if (iSSOManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
                        iSSOManager = null;
                    }
                    this.label = 1;
                    if (ISSOManager.fetchAccount$default(iSSOManager, null, this, 1, null) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            UserData userData = null;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(PrivacySettingsFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (PrivacySettingsFragment.this.isAdded()) {
                PrivacySettingsFragment privacySettingsFragment = PrivacySettingsFragment.this;
                UserData userData2 = privacySettingsFragment.userData;
                if (userData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userData");
                } else {
                    userData = userData2;
                }
                privacySettingsFragment.setShareMyNotesPrefChecked(userData.isNotesSharingActivated());
            }
            return Unit.INSTANCE;
        }
    }

    private final void getShareMyNotesSetting() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67891(null), 3, null);
    }

    private final void setShareMyNotesPrefEnabled(boolean shareMyNotesPrefEnabled) {
        SwitchPreferenceCompat switchPreferenceCompat;
        if (!isAdded() || (switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(C6079R.string.pref_share_notes_key))) == null) {
            return;
        }
        switchPreferenceCompat.setEnabled(shareMyNotesPrefEnabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShareMyNotesPrefChecked(boolean shareMyNotesPrefChecked) {
        SwitchPreferenceCompat switchPreferenceCompat;
        if (!isAdded() || (switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(C6079R.string.pref_share_notes_key))) == null) {
            return;
        }
        switchPreferenceCompat.setChecked(shareMyNotesPrefChecked);
    }

    private final boolean onShareMyNotesClicked(Preference preference) {
        Intrinsics.checkNotNull(preference, "null cannot be cast to non-null type androidx.preference.SwitchPreferenceCompat");
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) preference;
        if (hasInternetAccess()) {
            setShareMyNotesSetting(switchPreferenceCompat.isChecked());
            return true;
        }
        switchPreferenceCompat.setChecked(!switchPreferenceCompat.isChecked());
        View view = getView();
        if (view != null) {
            Snackbar.make(view, getString(C6079R.string.check_internet_access), 0).show();
        }
        return false;
    }

    private final void setShareMyNotesSetting(boolean checked) {
        ISSOManager iSSOManager = this.ssoManager;
        if (iSSOManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ssoManager");
            iSSOManager = null;
        }
        iSSOManager.saveShareMyNotesSetting(checked, new ISSOManager.OnShareSavedListener() { // from class: com.myscript.nebo.settings.PrivacySettingsFragment$$ExternalSyntheticLambda0
            @Override // com.myscript.nebo.sso.api.ISSOManager.OnShareSavedListener
            public final void onShareSaved(boolean z) {
                PrivacySettingsFragment.setShareMyNotesSetting$lambda$0(this.f$0, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setShareMyNotesSetting$lambda$0(PrivacySettingsFragment privacySettingsFragment, boolean z) {
        if (privacySettingsFragment.isAdded()) {
            if (z) {
                SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) privacySettingsFragment.findPreference(privacySettingsFragment.getString(C6079R.string.pref_share_notes_key));
                if (switchPreferenceCompat != null) {
                    UserData userData = privacySettingsFragment.userData;
                    if (userData == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userData");
                        userData = null;
                    }
                    switchPreferenceCompat.setChecked(userData.isNotesSharingActivated());
                    return;
                }
                return;
            }
            View view = privacySettingsFragment.getView();
            if (view != null) {
                Snackbar.make(view, privacySettingsFragment.getString(C6079R.string.check_internet_access_alert), 0).show();
            }
        }
    }

    private final boolean hasInternetAccess() {
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider");
        NeboNetworkState value = ((NeboNetworkStateRepositoryProvider) application).provideNeboNetworkStateRepository().getNeboNetworkState().getValue();
        if (value == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return value.isDataTransferAllowed();
    }
}
