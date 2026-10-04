package com.myscript.nebo.settings;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.LocaleExt;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.utils.FeatureHelper;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.languagemanager.presentation.LanguageManagerFragment;
import com.myscript.nebo.languagemanager.presentation.LanguageViewModel;
import com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.InkSettings;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: WritingSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u001a\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020,H\u0002J\u0016\u00100\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001802H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00063"}, m1599d2 = {"Lcom/myscript/nebo/settings/WritingSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "languageViewModel", "Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "getLanguageViewModel", "()Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "languageViewModel$delegate", "Lkotlin/Lazy;", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "onPreferencesChanged", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "onFontSizeSettingsRequested", "onLanguageManagerRequested", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "onRestoreColorsClicked", "updateLanguages", "languagesToUpdate", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WritingSettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;

    /* JADX INFO: renamed from: languageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy languageViewModel;
    private Navigator navigator;
    private final SharedPreferences.OnSharedPreferenceChangeListener onPreferencesChanged = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$$ExternalSyntheticLambda9
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            WritingSettingsFragment.onPreferencesChanged$lambda$0(this.f$0, sharedPreferences, str);
        }
    };

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return 0;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    public WritingSettingsFragment() {
        final WritingSettingsFragment writingSettingsFragment = this;
        final Function0 function0 = null;
        this.languageViewModel = FragmentViewModelLazyKt.createViewModelLazy(writingSettingsFragment, Reflection.getOrCreateKotlinClass(LanguageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return writingSettingsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? writingSettingsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WritingSettingsFragment.languageViewModel_delegate$lambda$0(this.f$0);
            }
        });
        this.freemiumLimitationViewModel = FragmentViewModelLazyKt.createViewModelLazy(writingSettingsFragment, Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return writingSettingsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? writingSettingsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreemiumLimitationViewModel.Factory;
            }
        });
    }

    private final LanguageViewModel getLanguageViewModel() {
        return (LanguageViewModel) this.languageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory languageViewModel_delegate$lambda$0(WritingSettingsFragment writingSettingsFragment) {
        FragmentActivity fragmentActivityRequireActivity = writingSettingsFragment.requireActivity();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPreferencesChanged$lambda$0(WritingSettingsFragment writingSettingsFragment, SharedPreferences sharedPreferences, String str) {
        SwitchPreference switchPreference;
        String string = writingSettingsFragment.getString(C6079R.string.pref_enable_keyboard_interactions_key);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (writingSettingsFragment.isResumed() || !Intrinsics.areEqual(str, string) || (switchPreference = (SwitchPreference) writingSettingsFragment.findPreference(string)) == null) {
            return;
        }
        switchPreference.setChecked(sharedPreferences.getBoolean(string, writingSettingsFragment.requireActivity().getResources().getBoolean(C6079R.bool.pref_enable_keyboard_interactions_default)));
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
        if (sharedPreferences != null) {
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.onPreferencesChanged);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.writing_settings);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        SharedPreferences sharedPreferences = getPreferenceManager().getSharedPreferences();
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.onPreferencesChanged);
        }
        super.onDestroy();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Preference preferenceFindPreference = findPreference(getString(C6079R.string.pref_restore_colors_key));
        if (preferenceFindPreference != null) {
            preferenceFindPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$$ExternalSyntheticLambda2
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return WritingSettingsFragment.onViewCreated$lambda$0(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference2 = findPreference(getString(C6079R.string.pref_text_display_category_key));
        if (preferenceFindPreference2 != null) {
            preferenceFindPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$$ExternalSyntheticLambda3
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return WritingSettingsFragment.onViewCreated$lambda$1(this.f$0, preference);
                }
            });
        }
        Preference preferenceFindPreference3 = findPreference(getString(C6079R.string.pref_language_manager_key));
        if (preferenceFindPreference3 != null) {
            preferenceFindPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$$ExternalSyntheticLambda4
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return WritingSettingsFragment.onViewCreated$lambda$2(this.f$0, preference);
                }
            });
        }
        getLanguageViewModel().getLanguagesToUpdate().observe(getViewLifecycleOwner(), new WritingSettingsFragment$sam$androidx_lifecycle_Observer$0(new C68004(this)));
        final SwitchPreference switchPreference = (SwitchPreference) findPreference(getString(C6079R.string.pref_prompter_key));
        if (switchPreference != null) {
            ComponentCallbacks2 application = requireActivity().getApplication();
            UserProfileManager.Provider provider = application instanceof UserProfileManager.Provider ? (UserProfileManager.Provider) application : null;
            final UserProfileManager userProfileManagerProvideUserProfileManager = provider != null ? provider.provideUserProfileManager() : null;
            if (!(userProfileManagerProvideUserProfileManager != null ? userProfileManagerProvideUserProfileManager.hasAccessToAllFeatures() : false)) {
                switchPreference.setChecked(false);
            }
            switchPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$$ExternalSyntheticLambda5
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    return WritingSettingsFragment.onViewCreated$lambda$3$0(switchPreference, userProfileManagerProvideUserProfileManager, this, preference);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0(WritingSettingsFragment writingSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return writingSettingsFragment.onRestoreColorsClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1(WritingSettingsFragment writingSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        writingSettingsFragment.onFontSizeSettingsRequested();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2(WritingSettingsFragment writingSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!FeatureHelper.checkFeatureAvailable(writingSettingsFragment.requireContext(), C6079R.bool.manage_languages_enabled)) {
            return true;
        }
        writingSettingsFragment.onLanguageManagerRequested();
        return true;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.settings.WritingSettingsFragment$onViewCreated$4 */
    /* JADX INFO: compiled from: WritingSettingsFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68004 extends FunctionReferenceImpl implements Function1<List<? extends String>, Unit> {
        C68004(Object obj) {
            super(1, obj, WritingSettingsFragment.class, "updateLanguages", "updateLanguages(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((WritingSettingsFragment) this.receiver).updateLanguages(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$3$0(SwitchPreference switchPreference, UserProfileManager userProfileManager, WritingSettingsFragment writingSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!switchPreference.isChecked()) {
            return true;
        }
        if (userProfileManager != null ? userProfileManager.hasAccessToAllFeatures() : false) {
            return true;
        }
        writingSettingsFragment.getFreemiumLimitationViewModel().trigger(FreemiumLimitationTrigger.TRIGGER_CONVERSION_PREVIEW_TOGGLE);
        return true;
    }

    private final void onFontSizeSettingsRequested() {
        Navigator navigator = getNavigator();
        if (navigator != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextDisplaySettingsFragment onFontSizeSettingsRequested$lambda$0() {
        return new TextDisplaySettingsFragment();
    }

    private final void onLanguageManagerRequested() {
        Navigator navigator = getNavigator();
        if (navigator != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LanguageManagerFragment onLanguageManagerRequested$lambda$0() {
        return LanguageManagerFragment.INSTANCE.newInstance();
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_writing_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    private final boolean onRestoreColorsClicked() {
        final Application application = requireActivity().getApplication();
        new MaterialAlertDialogBuilder(requireContext()).setTitle(C6079R.string.confirm_restore_default_colors).setMessage(C6079R.string.confirm_restore_default_colors_details).setPositiveButton(C6079R.string.settings_confirm_restore_colors, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.settings.WritingSettingsFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                WritingSettingsFragment.onRestoreColorsClicked$lambda$0(application, dialogInterface, i);
            }
        }).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRestoreColorsClicked$lambda$0(Application application, DialogInterface dialogInterface, int i) {
        InkSettings.Companion companion = InkSettings.INSTANCE;
        Intrinsics.checkNotNull(application);
        companion.resetColors(application, C6079R.array.default_predefined_ink_colors, C6693R.color.default_pen_color, C6693R.color.default_highlighter_color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLanguages(List<String> languagesToUpdate) {
        BadgesPreference badgesPreference = (BadgesPreference) findPreference(getString(C6079R.string.pref_language_manager_key));
        if (badgesPreference != null) {
            badgesPreference.setBadgeCount(languagesToUpdate.size());
        }
    }
}
