package com.myscript.nebo.settings;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SeekBarPreference;
import androidx.preference.SwitchPreferenceCompat;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.atk.core.MotionPredictionParams;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.discoverability.DiscoveryRepository;
import com.myscript.nebo.discoverability.session.SessionManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactory;
import com.myscript.nebo.editing.impl.p027ui.prediction.MotionPredictionParamsFactoryProvider;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.myscript.nebo.purchase.FreePeriodState;
import com.myscript.nebo.purchase.FreePeriodStatus;
import com.myscript.nebo.purchase.FreePeriodType;
import com.myscript.nebo.purchase.ISubscriptionRepository;
import com.myscript.nebo.purchase.NeboUserProfileManager;
import com.myscript.nebo.purchase.SubscriptionRepository;
import com.myscript.nebo.sso.api.ISSOManager;
import com.myscript.nebo.sso.model.UserData;
import com.pdftron.pdf.pdfa.PDFACompliance;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: InternalSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0002J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J \u0010\u001e\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0015H\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020\fH\u0002J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u000206H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u001dX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00067"}, m1599d2 = {"Lcom/myscript/nebo/settings/InternalSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "userData", "Lcom/myscript/nebo/sso/model/UserData;", "ssoManager", "Lcom/myscript/nebo/sso/api/ISSOManager;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "getSubscriptionRepository", "Lcom/myscript/nebo/purchase/SubscriptionRepository;", "getProfileManager", "Lcom/myscript/nebo/purchase/NeboUserProfileManager;", "setupFreePeriodOverrides", "setupRenewalOfferOverride", "applyTrialOverride", "repo", "remainingDays", "", "applyOEMOverride", "durationDays", "clearOverride", "formatFreePeriodState", "state", "Lcom/myscript/nebo/purchase/FreePeriodState;", "clearTooltipDataStore", "updatePredictionDuration", "enabled", "", "setDegradedMode", "titleRes", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "menuItem", "Landroid/view/MenuItem;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InternalSettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    public static final int $stable = 8;
    private LibraryRepository libraryRepository;
    private final int menuRes;
    private Navigator navigator;
    private ISSOManager ssoManager;
    private final int titleRes = C6079R.string.internal_side_panel_settings_title;
    private UserData userData;

    /* JADX INFO: compiled from: InternalSettingsFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FreePeriodStatus.values().length];
            try {
                iArr[FreePeriodStatus.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FreePeriodStatus.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FreePeriodStatus.Expired.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FreePeriodStatus.NotStarted.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FreePeriodType.values().length];
            try {
                iArr2[FreePeriodType.Trial.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FreePeriodType.OEMOffer.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FreePeriodType.None.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.internal_settings);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        this.libraryRepository = ((LibraryRepository.Provider) application).provideLibraryRepository();
        ComponentCallbacks2 application2 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type com.myscript.nebo.sso.model.UserData.Provider");
        this.userData = ((UserData.Provider) application2).provideUserData();
        ComponentCallbacks2 application3 = requireActivity().getApplication();
        Intrinsics.checkNotNull(application3, "null cannot be cast to non-null type com.myscript.nebo.sso.api.ISSOManager.Provider");
        this.ssoManager = ((ISSOManager.Provider) application3).provideSSOManager();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(C6079R.string.pref_internal_preprod_sso_key));
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return InternalSettingsFragment.onViewCreated$lambda$0$0(this.f$0, preference);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat2 = (SwitchPreferenceCompat) findPreference(getString(C6079R.string.pref_internal_sync_degraded_key));
        if (switchPreferenceCompat2 != null) {
            switchPreferenceCompat2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda4
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return InternalSettingsFragment.onViewCreated$lambda$1$0(this.f$0, preference);
                }
            });
        }
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(getString(C6079R.string.pref_internal_sync_degraded_upload_dial_key));
        if (editTextPreference != null) {
            editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda5
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.onViewCreated$lambda$2$0(this.f$0, preference, obj);
                }
            });
        }
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference(getString(C6079R.string.pref_internal_sync_degraded_download_dial_key));
        if (editTextPreference2 != null) {
            editTextPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda6
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.onViewCreated$lambda$3$0(this.f$0, preference, obj);
                }
            });
        }
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) findPreference(getString(C6079R.string.pref_internal_colorize_prediction_early_access_features_key));
        if (switchPreferenceCompat3 != null) {
            SwitchPreferenceCompat switchPreferenceCompat4 = (SwitchPreferenceCompat) findPreference(getString(C6079R.string.pref_internal_colorize_prediction_early_access_features_key));
            updatePredictionDuration(switchPreferenceCompat4 != null ? switchPreferenceCompat4.isChecked() : false);
            switchPreferenceCompat3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda7
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.onViewCreated$lambda$4$0(this.f$0, preference, obj);
                }
            });
        }
        setupFreePeriodOverrides();
        setupRenewalOfferOverride();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0$0(InternalSettingsFragment internalSettingsFragment, Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        UserData userData = internalSettingsFragment.userData;
        if (userData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userData");
            userData = null;
        }
        userData.logout();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1$0(InternalSettingsFragment internalSettingsFragment, Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        internalSettingsFragment.setDegradedMode();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2$0(InternalSettingsFragment internalSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        internalSettingsFragment.setDegradedMode();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3$0(InternalSettingsFragment internalSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        internalSettingsFragment.setDegradedMode();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4$0(InternalSettingsFragment internalSettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        internalSettingsFragment.updatePredictionDuration(((Boolean) obj).booleanValue());
        return true;
    }

    private final SubscriptionRepository getSubscriptionRepository() {
        ComponentCallbacks2 application = requireActivity().getApplication();
        ISubscriptionRepository.Provider provider = application instanceof ISubscriptionRepository.Provider ? (ISubscriptionRepository.Provider) application : null;
        ISubscriptionRepository iSubscriptionRepositoryProvideSubscriptionRepository = provider != null ? provider.provideSubscriptionRepository() : null;
        if (iSubscriptionRepositoryProvideSubscriptionRepository instanceof SubscriptionRepository) {
            return (SubscriptionRepository) iSubscriptionRepositoryProvideSubscriptionRepository;
        }
        return null;
    }

    private final NeboUserProfileManager getProfileManager() {
        ComponentCallbacks2 application = requireActivity().getApplication();
        UserProfileManager.Provider provider = application instanceof UserProfileManager.Provider ? (UserProfileManager.Provider) application : null;
        UserProfileManager userProfileManagerProvideUserProfileManager = provider != null ? provider.provideUserProfileManager() : null;
        if (userProfileManagerProvideUserProfileManager instanceof NeboUserProfileManager) {
            return (NeboUserProfileManager) userProfileManagerProvideUserProfileManager;
        }
        return null;
    }

    private final void setupFreePeriodOverrides() {
        final NeboUserProfileManager profileManager;
        boolean z;
        final SwitchPreferenceCompat switchPreferenceCompat;
        final SwitchPreferenceCompat switchPreferenceCompat2;
        final InternalSettingsFragment internalSettingsFragment = this;
        final SubscriptionRepository subscriptionRepository = internalSettingsFragment.getSubscriptionRepository();
        if (subscriptionRepository == null || (profileManager = internalSettingsFragment.getProfileManager()) == null) {
            return;
        }
        SwitchPreferenceCompat switchPreferenceCompat3 = (SwitchPreferenceCompat) internalSettingsFragment.findPreference(internalSettingsFragment.getString(C6079R.string.pref_internal_qa_simulate_paid_key));
        Preference preferenceFindPreference = internalSettingsFragment.findPreference(internalSettingsFragment.getString(C6079R.string.pref_internal_qa_free_period_status_key));
        final SwitchPreferenceCompat switchPreferenceCompat4 = (SwitchPreferenceCompat) internalSettingsFragment.findPreference(internalSettingsFragment.getString(C6079R.string.pref_internal_qa_free_trial_override_key));
        final SeekBarPreference seekBarPreference = (SeekBarPreference) internalSettingsFragment.findPreference(internalSettingsFragment.getString(C6079R.string.pref_internal_qa_free_trial_remaining_key));
        final SwitchPreferenceCompat switchPreferenceCompat5 = (SwitchPreferenceCompat) internalSettingsFragment.findPreference(internalSettingsFragment.getString(C6079R.string.pref_internal_qa_oem_offer_override_key));
        final SeekBarPreference seekBarPreference2 = (SeekBarPreference) internalSettingsFragment.findPreference(internalSettingsFragment.getString(C6079R.string.pref_internal_qa_oem_offer_duration_key));
        final SeekBarPreference seekBarPreference3 = (SeekBarPreference) internalSettingsFragment.findPreference(internalSettingsFragment.getString(C6079R.string.pref_internal_qa_oem_offer_remaining_key));
        setupFreePeriodOverrides$setFreePeriodControlsEnabled(switchPreferenceCompat4, switchPreferenceCompat5, seekBarPreference, seekBarPreference2, seekBarPreference3, !(switchPreferenceCompat3 != null && switchPreferenceCompat3.isChecked()));
        if (switchPreferenceCompat3 != null) {
            z = true;
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda8
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.setupFreePeriodOverrides$lambda$0(switchPreferenceCompat4, this, subscriptionRepository, switchPreferenceCompat5, profileManager, seekBarPreference, seekBarPreference2, seekBarPreference3, preference, obj);
                }
            };
            internalSettingsFragment = this;
            switchPreferenceCompat5 = switchPreferenceCompat5;
            seekBarPreference = seekBarPreference;
            subscriptionRepository = subscriptionRepository;
            seekBarPreference2 = seekBarPreference2;
            switchPreferenceCompat = switchPreferenceCompat4;
            switchPreferenceCompat3.setOnPreferenceChangeListener(onPreferenceChangeListener);
        } else {
            z = true;
            switchPreferenceCompat = switchPreferenceCompat4;
        }
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled((switchPreferenceCompat == null || switchPreferenceCompat.isChecked() != z) ? false : z);
        }
        if (seekBarPreference2 != null) {
            seekBarPreference2.setEnabled((switchPreferenceCompat5 == null || switchPreferenceCompat5.isChecked() != z) ? false : z);
        }
        if (seekBarPreference3 != null) {
            if (switchPreferenceCompat5 == null || switchPreferenceCompat5.isChecked() != z) {
                z = false;
            }
            seekBarPreference3.setEnabled(z);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(internalSettingsFragment), null, null, new C67832(subscriptionRepository, preferenceFindPreference, internalSettingsFragment, null), 3, null);
        if (switchPreferenceCompat != null) {
            final SeekBarPreference seekBarPreference4 = seekBarPreference;
            switchPreferenceCompat2 = switchPreferenceCompat5;
            seekBarPreference = seekBarPreference4;
            switchPreferenceCompat.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda9
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.setupFreePeriodOverrides$lambda$1(seekBarPreference4, switchPreferenceCompat5, seekBarPreference2, seekBarPreference3, internalSettingsFragment, subscriptionRepository, preference, obj);
                }
            });
        } else {
            switchPreferenceCompat2 = switchPreferenceCompat5;
        }
        if (seekBarPreference != null) {
            seekBarPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda10
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.setupFreePeriodOverrides$lambda$2(switchPreferenceCompat, internalSettingsFragment, subscriptionRepository, preference, obj);
                }
            });
        }
        if (switchPreferenceCompat2 != null) {
            final SeekBarPreference seekBarPreference5 = seekBarPreference2;
            final SwitchPreferenceCompat switchPreferenceCompat6 = switchPreferenceCompat;
            Preference.OnPreferenceChangeListener onPreferenceChangeListener2 = new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda11
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.setupFreePeriodOverrides$lambda$3(seekBarPreference5, seekBarPreference3, switchPreferenceCompat6, seekBarPreference, internalSettingsFragment, subscriptionRepository, preference, obj);
                }
            };
            seekBarPreference2 = seekBarPreference5;
            switchPreferenceCompat2.setOnPreferenceChangeListener(onPreferenceChangeListener2);
        }
        if (seekBarPreference3 != null) {
            seekBarPreference3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda12
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.setupFreePeriodOverrides$lambda$4(switchPreferenceCompat2, internalSettingsFragment, subscriptionRepository, seekBarPreference2, preference, obj);
                }
            });
        }
        if (seekBarPreference2 != null) {
            seekBarPreference2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.setupFreePeriodOverrides$lambda$5(switchPreferenceCompat2, seekBarPreference3, internalSettingsFragment, subscriptionRepository, preference, obj);
                }
            });
        }
    }

    private static final void setupFreePeriodOverrides$setFreePeriodControlsEnabled(SwitchPreferenceCompat switchPreferenceCompat, SwitchPreferenceCompat switchPreferenceCompat2, SeekBarPreference seekBarPreference, SeekBarPreference seekBarPreference2, SeekBarPreference seekBarPreference3, boolean z) {
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setEnabled(z);
        }
        if (switchPreferenceCompat2 != null) {
            switchPreferenceCompat2.setEnabled(z);
        }
        boolean z2 = false;
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled(z && switchPreferenceCompat != null && switchPreferenceCompat.isChecked());
        }
        if (seekBarPreference2 != null) {
            seekBarPreference2.setEnabled(z && switchPreferenceCompat2 != null && switchPreferenceCompat2.isChecked());
        }
        if (seekBarPreference3 != null) {
            if (z && switchPreferenceCompat2 != null && switchPreferenceCompat2.isChecked()) {
                z2 = true;
            }
            seekBarPreference3.setEnabled(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupFreePeriodOverrides$lambda$0(SwitchPreferenceCompat switchPreferenceCompat, InternalSettingsFragment internalSettingsFragment, SubscriptionRepository subscriptionRepository, SwitchPreferenceCompat switchPreferenceCompat2, NeboUserProfileManager neboUserProfileManager, SeekBarPreference seekBarPreference, SeekBarPreference seekBarPreference2, SeekBarPreference seekBarPreference3, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean) obj).booleanValue()) {
            if (switchPreferenceCompat != null && switchPreferenceCompat.isChecked()) {
                switchPreferenceCompat.setChecked(false);
                internalSettingsFragment.clearOverride(subscriptionRepository);
            }
            if (switchPreferenceCompat2 != null && switchPreferenceCompat2.isChecked()) {
                switchPreferenceCompat2.setChecked(false);
                internalSettingsFragment.clearOverride(subscriptionRepository);
            }
            setupFreePeriodOverrides$setFreePeriodControlsEnabled(switchPreferenceCompat, switchPreferenceCompat2, seekBarPreference, seekBarPreference2, seekBarPreference3, false);
            neboUserProfileManager.debugSetSimulatePaidEntitlement();
        } else {
            setupFreePeriodOverrides$setFreePeriodControlsEnabled(switchPreferenceCompat, switchPreferenceCompat2, seekBarPreference, seekBarPreference2, seekBarPreference3, true);
            neboUserProfileManager.debugClearSimulatePaidEntitlement();
        }
        return true;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.InternalSettingsFragment$setupFreePeriodOverrides$2 */
    /* JADX INFO: compiled from: InternalSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.InternalSettingsFragment$setupFreePeriodOverrides$2", m1609f = "InternalSettingsFragment.kt", m1610i = {}, m1611l = {158}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C67832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Preference $statusPref;
        final /* synthetic */ SubscriptionRepository $subscriptionRepository;
        int label;
        final /* synthetic */ InternalSettingsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67832(SubscriptionRepository subscriptionRepository, Preference preference, InternalSettingsFragment internalSettingsFragment, Continuation<? super C67832> continuation) {
            super(2, continuation);
            this.$subscriptionRepository = subscriptionRepository;
            this.$statusPref = preference;
            this.this$0 = internalSettingsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67832(this.$subscriptionRepository, this.$statusPref, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<FreePeriodState> freePeriodState = this.$subscriptionRepository.getFreePeriodState();
                final Preference preference = this.$statusPref;
                final InternalSettingsFragment internalSettingsFragment = this.this$0;
                this.label = 1;
                if (freePeriodState.collect(new FlowCollector() { // from class: com.myscript.nebo.settings.InternalSettingsFragment.setupFreePeriodOverrides.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((FreePeriodState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(FreePeriodState freePeriodState2, Continuation<? super Unit> continuation) {
                        Preference preference2 = preference;
                        if (preference2 != null) {
                            preference2.setSummary(internalSettingsFragment.formatFreePeriodState(freePeriodState2));
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupFreePeriodOverrides$lambda$1(SeekBarPreference seekBarPreference, SwitchPreferenceCompat switchPreferenceCompat, SeekBarPreference seekBarPreference2, SeekBarPreference seekBarPreference3, InternalSettingsFragment internalSettingsFragment, SubscriptionRepository subscriptionRepository, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled(zBooleanValue);
        }
        if (zBooleanValue) {
            if (switchPreferenceCompat != null) {
                switchPreferenceCompat.setChecked(false);
            }
            if (seekBarPreference2 != null) {
                seekBarPreference2.setEnabled(false);
            }
            if (seekBarPreference3 != null) {
                seekBarPreference3.setEnabled(false);
            }
            internalSettingsFragment.applyTrialOverride(subscriptionRepository, seekBarPreference != null ? seekBarPreference.getValue() : 3);
            return true;
        }
        internalSettingsFragment.clearOverride(subscriptionRepository);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupFreePeriodOverrides$lambda$2(SwitchPreferenceCompat switchPreferenceCompat, InternalSettingsFragment internalSettingsFragment, SubscriptionRepository subscriptionRepository, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        if (switchPreferenceCompat != null && switchPreferenceCompat.isChecked()) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            internalSettingsFragment.applyTrialOverride(subscriptionRepository, ((Integer) obj).intValue());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupFreePeriodOverrides$lambda$3(SeekBarPreference seekBarPreference, SeekBarPreference seekBarPreference2, SwitchPreferenceCompat switchPreferenceCompat, SeekBarPreference seekBarPreference3, InternalSettingsFragment internalSettingsFragment, SubscriptionRepository subscriptionRepository, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled(zBooleanValue);
        }
        if (seekBarPreference2 != null) {
            seekBarPreference2.setEnabled(zBooleanValue);
        }
        if (zBooleanValue) {
            if (switchPreferenceCompat != null) {
                switchPreferenceCompat.setChecked(false);
            }
            if (seekBarPreference3 != null) {
                seekBarPreference3.setEnabled(false);
            }
            internalSettingsFragment.applyOEMOverride(subscriptionRepository, seekBarPreference2 != null ? seekBarPreference2.getValue() : 15, seekBarPreference != null ? seekBarPreference.getValue() : 30);
            return true;
        }
        internalSettingsFragment.clearOverride(subscriptionRepository);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupFreePeriodOverrides$lambda$4(SwitchPreferenceCompat switchPreferenceCompat, InternalSettingsFragment internalSettingsFragment, SubscriptionRepository subscriptionRepository, SeekBarPreference seekBarPreference, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        if (switchPreferenceCompat != null && switchPreferenceCompat.isChecked()) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            internalSettingsFragment.applyOEMOverride(subscriptionRepository, ((Integer) obj).intValue(), seekBarPreference != null ? seekBarPreference.getValue() : 30);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupFreePeriodOverrides$lambda$5(SwitchPreferenceCompat switchPreferenceCompat, SeekBarPreference seekBarPreference, InternalSettingsFragment internalSettingsFragment, SubscriptionRepository subscriptionRepository, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        if (switchPreferenceCompat != null && switchPreferenceCompat.isChecked()) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            int iIntValue = ((Integer) obj).intValue();
            int value = seekBarPreference != null ? seekBarPreference.getValue() : 15;
            if (seekBarPreference != null) {
                seekBarPreference.setMax(iIntValue);
            }
            if (value > iIntValue && seekBarPreference != null) {
                seekBarPreference.setValue(iIntValue);
            }
            internalSettingsFragment.applyOEMOverride(subscriptionRepository, RangesKt.coerceAtMost(seekBarPreference != null ? seekBarPreference.getValue() : 15, iIntValue), iIntValue);
        }
        return true;
    }

    private final void setupRenewalOfferOverride() {
        final SubscriptionRepository subscriptionRepository = getSubscriptionRepository();
        if (subscriptionRepository == null) {
            return;
        }
        final SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(C6079R.string.pref_internal_qa_renewal_offer_override_key));
        final SeekBarPreference seekBarPreference = (SeekBarPreference) findPreference(getString(C6079R.string.pref_internal_qa_renewal_offer_remaining_key));
        if (seekBarPreference != null) {
            boolean z = false;
            if (switchPreferenceCompat != null && switchPreferenceCompat.isChecked()) {
                z = true;
            }
            seekBarPreference.setEnabled(z);
        }
        if (switchPreferenceCompat != null && switchPreferenceCompat.isChecked()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67841(subscriptionRepository, seekBarPreference, null), 3, null);
        }
        if (switchPreferenceCompat != null) {
            switchPreferenceCompat.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.setupRenewalOfferOverride$lambda$0(seekBarPreference, this, subscriptionRepository, preference, obj);
                }
            });
        }
        if (seekBarPreference != null) {
            seekBarPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.InternalSettingsFragment$$ExternalSyntheticLambda3
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return InternalSettingsFragment.setupRenewalOfferOverride$lambda$1(switchPreferenceCompat, this, subscriptionRepository, preference, obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.InternalSettingsFragment$setupRenewalOfferOverride$1 */
    /* JADX INFO: compiled from: InternalSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.InternalSettingsFragment$setupRenewalOfferOverride$1", m1609f = "InternalSettingsFragment.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C67841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SeekBarPreference $renewalRemainingSlider;
        final /* synthetic */ SubscriptionRepository $subscriptionRepository;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67841(SubscriptionRepository subscriptionRepository, SeekBarPreference seekBarPreference, Continuation<? super C67841> continuation) {
            super(2, continuation);
            this.$subscriptionRepository = subscriptionRepository;
            this.$renewalRemainingSlider = seekBarPreference;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67841(this.$subscriptionRepository, this.$renewalRemainingSlider, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SubscriptionRepository subscriptionRepository = this.$subscriptionRepository;
            SeekBarPreference seekBarPreference = this.$renewalRemainingSlider;
            subscriptionRepository.debugOverrideRenewalOffer(seekBarPreference != null ? seekBarPreference.getValue() : 48);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupRenewalOfferOverride$lambda$0(SeekBarPreference seekBarPreference, InternalSettingsFragment internalSettingsFragment, SubscriptionRepository subscriptionRepository, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled(zBooleanValue);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(internalSettingsFragment), null, null, new InternalSettingsFragment$setupRenewalOfferOverride$2$1(zBooleanValue, subscriptionRepository, seekBarPreference, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupRenewalOfferOverride$lambda$1(SwitchPreferenceCompat switchPreferenceCompat, InternalSettingsFragment internalSettingsFragment, SubscriptionRepository subscriptionRepository, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "<unused var>");
        if (switchPreferenceCompat != null && switchPreferenceCompat.isChecked()) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(internalSettingsFragment), null, null, new InternalSettingsFragment$setupRenewalOfferOverride$3$1(subscriptionRepository, obj, null), 3, null);
        }
        return true;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.InternalSettingsFragment$applyTrialOverride$1 */
    /* JADX INFO: compiled from: InternalSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.InternalSettingsFragment$applyTrialOverride$1", m1609f = "InternalSettingsFragment.kt", m1610i = {}, m1611l = {279}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {284}, m1615s = {}, m1616v = 2)
    static final class C67801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $remainingDays;
        final /* synthetic */ SubscriptionRepository $repo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67801(SubscriptionRepository subscriptionRepository, int i, Continuation<? super C67801> continuation) {
            super(2, continuation);
            this.$repo = subscriptionRepository;
            this.$remainingDays = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67801(this.$repo, this.$remainingDays, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$repo.debugOverrideFreePeriod(FreePeriodType.Trial, this.$remainingDays, 7, this) == coroutine_suspended) {
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

    private final void applyTrialOverride(SubscriptionRepository repo, int remainingDays) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67801(repo, remainingDays, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.InternalSettingsFragment$applyOEMOverride$1 */
    /* JADX INFO: compiled from: InternalSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.InternalSettingsFragment$applyOEMOverride$1", m1609f = "InternalSettingsFragment.kt", m1610i = {}, m1611l = {289}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {294}, m1615s = {}, m1616v = 2)
    static final class C67791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $durationDays;
        final /* synthetic */ int $remainingDays;
        final /* synthetic */ SubscriptionRepository $repo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67791(SubscriptionRepository subscriptionRepository, int i, int i2, Continuation<? super C67791> continuation) {
            super(2, continuation);
            this.$repo = subscriptionRepository;
            this.$remainingDays = i;
            this.$durationDays = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67791(this.$repo, this.$remainingDays, this.$durationDays, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$repo.debugOverrideFreePeriod(FreePeriodType.OEMOffer, this.$remainingDays, this.$durationDays, this) == coroutine_suspended) {
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

    private final void applyOEMOverride(SubscriptionRepository repo, int remainingDays, int durationDays) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67791(repo, remainingDays, durationDays, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.InternalSettingsFragment$clearOverride$1 */
    /* JADX INFO: compiled from: InternalSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.InternalSettingsFragment$clearOverride$1", m1609f = "InternalSettingsFragment.kt", m1610i = {}, m1611l = {AIContainerViewModel.SUMMARIZE_MIN_LIMIT}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {300}, m1615s = {}, m1616v = 2)
    static final class C67811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SubscriptionRepository $repo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67811(SubscriptionRepository subscriptionRepository, Continuation<? super C67811> continuation) {
            super(2, continuation);
            this.$repo = subscriptionRepository;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67811(this.$repo, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$repo.debugClearFreePeriodOverride(this) == coroutine_suspended) {
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

    private final void clearOverride(SubscriptionRepository repo) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67811(repo, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatFreePeriodState(FreePeriodState state) {
        String str;
        String str2;
        int i = WhenMappings.$EnumSwitchMapping$0[state.getStatus().ordinal()];
        if (i == 1) {
            str = "Unknown";
        } else if (i == 2) {
            str = "Active ✅";
        } else if (i == 3) {
            str = "Expired ❌";
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            str = "Not Started";
        }
        int i2 = WhenMappings.$EnumSwitchMapping$1[state.getType().ordinal()];
        if (i2 == 1) {
            str2 = "Trial";
        } else if (i2 == 2) {
            str2 = "OEM Offer";
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str2 = "None";
        }
        return str + " | " + str2 + " | remaining: " + Duration.m15864getInWholeDaysimpl(state.m13345getRemainingDaysUwyO8pc()) + "d | duration: " + Duration.m15864getInWholeDaysimpl(state.m13344getDurationDaysUwyO8pc()) + "d";
    }

    private final void clearTooltipDataStore() {
        Context context = getContext();
        Object applicationContext = context != null ? context.getApplicationContext() : null;
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.myscript.nebo.discoverability.DiscoveryRepository.Provider");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C67821(((DiscoveryRepository.Provider) applicationContext).provideDiscoveryRepository(), this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.InternalSettingsFragment$clearTooltipDataStore$1 */
    /* JADX INFO: compiled from: InternalSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.settings.InternalSettingsFragment$clearTooltipDataStore$1", m1609f = "InternalSettingsFragment.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_2_4}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {PDFACompliance.e_PDFA3_2_5}, m1615s = {}, m1616v = 2)
    static final class C67821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DiscoveryRepository $tooltipRepository;
        int label;
        final /* synthetic */ InternalSettingsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C67821(DiscoveryRepository discoveryRepository, InternalSettingsFragment internalSettingsFragment, Continuation<? super C67821> continuation) {
            super(2, continuation);
            this.$tooltipRepository = discoveryRepository;
            this.this$0 = internalSettingsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C67821(this.$tooltipRepository, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$tooltipRepository.clear(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Context context = this.this$0.getContext();
            Object applicationContext = context != null ? context.getApplicationContext() : null;
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.myscript.nebo.discoverability.session.SessionManager.Provider");
            ((SessionManager.Provider) applicationContext).provideDiscoverySessionManager().clearSessionCount();
            return Unit.INSTANCE;
        }
    }

    private final void updatePredictionDuration(boolean enabled) {
        SeekBarPreference seekBarPreference = (SeekBarPreference) findPreference(getString(C6079R.string.pref_internal_prediction_duration));
        if (seekBarPreference != null) {
            seekBarPreference.setEnabled(enabled);
            if (enabled) {
                return;
            }
            Context context = getContext();
            Object applicationContext = context != null ? context.getApplicationContext() : null;
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.myscript.nebo.editing.impl.ui.prediction.MotionPredictionParamsFactoryProvider");
            MotionPredictionParamsFactory motionPredictionParamsFactoryProvideMotionPredictionParamsFactory = ((MotionPredictionParamsFactoryProvider) applicationContext).provideMotionPredictionParamsFactory();
            MotionPredictionParams motionPredictionParamsProvideMotionPredictionParams = motionPredictionParamsFactoryProvideMotionPredictionParamsFactory.provideCustomMotionPredictionParams() ? motionPredictionParamsFactoryProvideMotionPredictionParamsFactory.provideMotionPredictionParams(getContext(), null) : motionPredictionParamsFactoryProvideMotionPredictionParamsFactory.defaultMotionPredictionParams();
            if (motionPredictionParamsProvideMotionPredictionParams != null) {
                long durationMs = motionPredictionParamsProvideMotionPredictionParams.getDurationMs();
                seekBarPreference.setDefaultValue(Long.valueOf(durationMs));
                seekBarPreference.setValue((int) durationMs);
            }
        }
    }

    private final void setDegradedMode() {
        String text;
        EditTextPreference editTextPreference;
        String text2;
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        LibraryRepository libraryRepositoryProvideLibraryRepository = ((LibraryRepository.Provider) application).provideLibraryRepository();
        SwitchPreferenceCompat switchPreferenceCompat = (SwitchPreferenceCompat) findPreference(getString(C6079R.string.pref_internal_sync_degraded_key));
        int i = 0;
        if (switchPreferenceCompat != null ? switchPreferenceCompat.isChecked() : false) {
            try {
                editTextPreference = (EditTextPreference) findPreference(getString(C6079R.string.pref_internal_sync_degraded_upload_dial_key));
            } catch (NumberFormatException unused) {
            }
            int i2 = (editTextPreference == null || (text2 = editTextPreference.getText()) == null) ? 0 : Integer.parseInt(text2);
            try {
                EditTextPreference editTextPreference2 = (EditTextPreference) findPreference(getString(C6079R.string.pref_internal_sync_degraded_download_dial_key));
                if (editTextPreference2 != null && (text = editTextPreference2.getText()) != null) {
                    i = Integer.parseInt(text);
                }
            } catch (NumberFormatException unused2) {
            }
            libraryRepositoryProvideLibraryRepository.setSyncDegradedMode(i2, i);
            return;
        }
        libraryRepositoryProvideLibraryRepository.disableSyncDegradedMode();
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return this.titleRes;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return this.menuRes;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }
}
