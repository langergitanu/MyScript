package com.myscript.nebo.settings;

import android.content.ComponentCallbacks2;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.account.UserProfileManager;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: NeboAISettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006)"}, m1599d2 = {"Lcom/myscript/nebo/settings/NeboAISettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "<init>", "()V", "aiContainerViewModel", "Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;", "getAiContainerViewModel", "()Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;", "aiContainerViewModel$delegate", "Lkotlin/Lazy;", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "onCreatePreferences", "", "savedInstanceState", "Landroid/os/Bundle;", "rootKey", "", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "onViewCreated", "view", "Landroid/view/View;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboAISettingsFragment extends PreferenceFragmentCompat implements NestedFragment {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: aiContainerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy aiContainerViewModel;

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;
    private Navigator navigator;

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return 0;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    public NeboAISettingsFragment() {
        final NeboAISettingsFragment neboAISettingsFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NeboAISettingsFragment.aiContainerViewModel_delegate$lambda$0();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return neboAISettingsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function02.invoke();
            }
        });
        final Function0 function03 = null;
        this.aiContainerViewModel = FragmentViewModelLazyKt.createViewModelLazy(neboAISettingsFragment, Reflection.getOrCreateKotlinClass(AIContainerViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM11616viewModels$lambda1 = FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM11616viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM11616viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0);
        this.freemiumLimitationViewModel = FragmentViewModelLazyKt.createViewModelLazy(neboAISettingsFragment, Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return neboAISettingsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                return (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) ? neboAISettingsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreemiumLimitationViewModel.Factory;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory aiContainerViewModel_delegate$lambda$0() {
        return AIContainerViewModel.INSTANCE.getFactory();
    }

    private final AIContainerViewModel getAiContainerViewModel() {
        return (AIContainerViewModel) this.aiContainerViewModel.getValue();
    }

    private final FreemiumLimitationViewModel getFreemiumLimitationViewModel() {
        return (FreemiumLimitationViewModel) this.freemiumLimitationViewModel.getValue();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.ai_settings);
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_nebo_ai_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getAiContainerViewModel().isAIEnabled().observe(getViewLifecycleOwner(), new NeboAISettingsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NeboAISettingsFragment.onViewCreated$lambda$0(this.f$0, (Boolean) obj);
            }
        }));
        SwitchPreference switchPreference = (SwitchPreference) findPreference(getString(C6079R.string.pref_nebo_ai_key));
        if (switchPreference != null) {
            switchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: com.myscript.nebo.settings.NeboAISettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceChangeListener
                public final boolean onPreferenceChange(Preference preference, Object obj) {
                    return NeboAISettingsFragment.onViewCreated$lambda$1(this.f$0, preference, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(NeboAISettingsFragment neboAISettingsFragment, Boolean bool) {
        SwitchPreference switchPreference = (SwitchPreference) neboAISettingsFragment.findPreference(neboAISettingsFragment.getString(C6079R.string.pref_nebo_ai_key));
        if (switchPreference != null) {
            Intrinsics.checkNotNull(bool);
            switchPreference.setChecked(bool.booleanValue());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$1(NeboAISettingsFragment neboAISettingsFragment, Preference preference, Object obj) {
        Intrinsics.checkNotNullParameter(preference, "preference");
        AIContainerViewModel aiContainerViewModel = neboAISettingsFragment.getAiContainerViewModel();
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        aiContainerViewModel.setAIEnabled(((Boolean) obj).booleanValue());
        if (Intrinsics.areEqual((Object) neboAISettingsFragment.getAiContainerViewModel().isAIEnabled().getValue(), (Object) true)) {
            ComponentCallbacks2 application = neboAISettingsFragment.requireActivity().getApplication();
            UserProfileManager.Provider provider = application instanceof UserProfileManager.Provider ? (UserProfileManager.Provider) application : null;
            UserProfileManager userProfileManagerProvideUserProfileManager = provider != null ? provider.provideUserProfileManager() : null;
            if (!(userProfileManagerProvideUserProfileManager != null ? userProfileManagerProvideUserProfileManager.hasAccessToAllFeatures() : false)) {
                neboAISettingsFragment.getFreemiumLimitationViewModel().trigger(FreemiumLimitationTrigger.TRIGGER_AI_BUTTON_SHOW_HIDE_SETTING);
            }
        }
        return false;
    }
}
