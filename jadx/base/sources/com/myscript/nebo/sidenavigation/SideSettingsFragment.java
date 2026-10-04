package com.myscript.nebo.sidenavigation;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.myscript.android.utils.LocaleExt;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.featureflags.RuntimeFeatureFlagHelper;
import com.myscript.nebo.featureflags.feature.InternalFlag;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.languagemanager.presentation.LanguageViewModel;
import com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import com.myscript.nebo.settings.BadgesPreference;
import com.myscript.nebo.userdict.p035ui.UserDictionaryFragment;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SideSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001c\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020#H\u0002J\u0016\u00101\u001a\u00020!2\f\u00102\u001a\b\u0012\u0004\u0012\u00020%03H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u00065"}, m1599d2 = {"Lcom/myscript/nebo/sidenavigation/SideSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "languageViewModel", "Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "getLanguageViewModel", "()Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "languageViewModel$delegate", "Lkotlin/Lazy;", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "onViewCreated", "view", "Landroid/view/View;", "configureInternalSettings", "onUserDictionaryRequested", "onPreferenceTreeClick", "preference", "Landroidx/preference/Preference;", "openFragment", "fragmentString", "args", "updateLanguages", "languagesToUpdate", "", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SideSettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    public static final String SETTINGS_SUBMENU = "settings_submenu";
    public static final String TAG = "SideSettingsFragmentTag";

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;

    /* JADX INFO: renamed from: languageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy languageViewModel;
    private Navigator navigator;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final SideSettingsFragment newInstance(Class<?> cls) {
        return INSTANCE.newInstance(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Fragment openFragment$lambda$0(Fragment fragment) {
        return fragment;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return 0;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    public SideSettingsFragment() {
        final SideSettingsFragment sideSettingsFragment = this;
        final Function0 function0 = null;
        this.languageViewModel = FragmentViewModelLazyKt.createViewModelLazy(sideSettingsFragment, Reflection.getOrCreateKotlinClass(LanguageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return sideSettingsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? sideSettingsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SideSettingsFragment.languageViewModel_delegate$lambda$0(this.f$0);
            }
        });
        this.freemiumLimitationViewModel = FragmentViewModelLazyKt.createViewModelLazy(sideSettingsFragment, Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return sideSettingsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? sideSettingsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreemiumLimitationViewModel.Factory;
            }
        });
    }

    /* JADX INFO: compiled from: SideSettingsFragment.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/sidenavigation/SideSettingsFragment$Companion;", "", "<init>", "()V", "TAG", "", "SETTINGS_SUBMENU", "newInstance", "Lcom/myscript/nebo/sidenavigation/SideSettingsFragment;", "childFragmentClass", "Ljava/lang/Class;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SideSettingsFragment newInstance(Class<?> childFragmentClass) {
            SideSettingsFragment sideSettingsFragment = new SideSettingsFragment();
            if (childFragmentClass != null) {
                Bundle bundle = new Bundle();
                bundle.putString(SideSettingsFragment.SETTINGS_SUBMENU, childFragmentClass.getCanonicalName());
                sideSettingsFragment.setArguments(bundle);
            }
            return sideSettingsFragment;
        }
    }

    private final LanguageViewModel getLanguageViewModel() {
        return (LanguageViewModel) this.languageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory languageViewModel_delegate$lambda$0(SideSettingsFragment sideSettingsFragment) {
        FragmentActivity fragmentActivityRequireActivity = sideSettingsFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Configuration configuration = fragmentActivityRequireActivity.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        Locale primaryLocale = LocaleExt.getPrimaryLocale(configuration);
        ComponentCallbacks2 application = fragmentActivityRequireActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider");
        return new LanguageViewModel.Factory(new LanguageNameHelper(primaryLocale), ((ISuggestedLanguagesProvider) application).provideSuggestedLanguages());
    }

    private final FreemiumLimitationViewModel getFreemiumLimitationViewModel() {
        return (FreemiumLimitationViewModel) this.freemiumLimitationViewModel.getValue();
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        if (this.navigator == null) {
            FragmentManager fragmentManagerRequireFragmentManager = requireFragmentManager();
            Intrinsics.checkNotNullExpressionValue(fragmentManagerRequireFragmentManager, "requireFragmentManager(...)");
            this.navigator = new Navigator(fragmentManagerRequireFragmentManager, C6079R.id.side_navigation_fragment_container, C6079R.id.side_navigation_app_bar_frame);
        }
        return this.navigator;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        String string;
        setPreferencesFromResource(C6079R.xml.side_settings, rootKey);
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_user_dictionary_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$$ExternalSyntheticLambda5
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return SideSettingsFragment.onCreatePreferences$lambda$0(this.f$0, preference);
                }
            });
        }
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(SETTINGS_SUBMENU)) != null) {
            Bundle bundleRequireArguments = requireArguments();
            Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
            openFragment(string, bundleRequireArguments);
        }
        configureInternalSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$0(SideSettingsFragment sideSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        sideSettingsFragment.onUserDictionaryRequested();
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getLanguageViewModel().getLanguagesToUpdate().observe(getViewLifecycleOwner(), new SideSettingsFragment$sam$androidx_lifecycle_Observer$0(new C68131(this)));
        configureInternalSettings();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sidenavigation.SideSettingsFragment$onViewCreated$1 */
    /* JADX INFO: compiled from: SideSettingsFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68131 extends FunctionReferenceImpl implements Function1<List<? extends String>, Unit> {
        C68131(Object obj) {
            super(1, obj, SideSettingsFragment.class, "updateLanguages", "updateLanguages(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((SideSettingsFragment) this.receiver).updateLanguages(p0);
        }
    }

    private final void configureInternalSettings() {
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_internal_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setVisible(RuntimeFeatureFlagHelper.isFeatureEnabled(InternalFlag.INTERNAL));
        }
    }

    private final void onUserDictionaryRequested() {
        Navigator navigator = getNavigator();
        if (navigator != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UserDictionaryFragment onUserDictionaryRequested$lambda$0() {
        return UserDictionaryFragment.INSTANCE.newInstance();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference preference) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        final Bundle extras = preference.getExtras();
        Intrinsics.checkNotNullExpressionValue(extras, "getExtras(...)");
        final String fragment = preference.getFragment();
        if (fragment == null) {
            return false;
        }
        if (Intrinsics.areEqual(preference.getKey(), getString(C6079R.string.pref_cloud_sync_settings_key))) {
            getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_SYNC_SETTING_INTERACTION, new Function0() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SideSettingsFragment.onPreferenceTreeClick$lambda$0(this.f$0, fragment, extras);
                }
            });
            return true;
        }
        openFragment(fragment, extras);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPreferenceTreeClick$lambda$0(SideSettingsFragment sideSettingsFragment, String str, Bundle bundle) {
        sideSettingsFragment.openFragment(str, bundle);
        return Unit.INSTANCE;
    }

    private final void openFragment(String fragmentString, Bundle args) {
        FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        final Fragment fragmentInstantiate = supportFragmentManager.getFragmentFactory().instantiate(requireActivity().getClassLoader(), fragmentString);
        Intrinsics.checkNotNullExpressionValue(fragmentInstantiate, "instantiate(...)");
        fragmentInstantiate.setArguments(args);
        fragmentInstantiate.setTargetFragment(this, 0);
        Navigator navigator = getNavigator();
        if (navigator != null) {
            navigator.pushFragment(fragmentString, false, new Function0() { // from class: com.myscript.nebo.sidenavigation.SideSettingsFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SideSettingsFragment.openFragment$lambda$0(fragmentInstantiate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLanguages(List<String> languagesToUpdate) {
        BadgesPreference badgesPreference = (BadgesPreference) findPreference(getString(C6079R.string.pref_writing_category_key));
        if (badgesPreference != null) {
            badgesPreference.setBadgeCount(languagesToUpdate.size());
        }
    }
}
