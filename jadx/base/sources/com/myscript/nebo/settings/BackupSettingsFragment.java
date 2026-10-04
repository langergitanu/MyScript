package com.myscript.nebo.settings;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.backup.BackupRestoreUINavigation;
import com.myscript.nebo.backup.BackupRestoreViewModel;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.LibraryViewModel;
import com.myscript.snt.dms.NeboBackupController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BackupSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010/\u001a\u000200H\u0016J\u001a\u00101\u001a\u0002002\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001c\u00106\u001a\u0002002\b\u00104\u001a\u0004\u0018\u0001052\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u000200H\u0016J\"\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u001a2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u0010\u0010?\u001a\u0002002\u0006\u0010@\u001a\u000205H\u0016J\u0010\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020&H\u0002J\b\u0010C\u001a\u000200H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020*8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006E"}, m1599d2 = {"Lcom/myscript/nebo/settings/BackupSettingsFragment;", "Landroidx/preference/PreferenceFragmentCompat;", "Lcom/myscript/android/utils/NestedFragment;", "Lcom/myscript/nebo/backup/BackupRestoreUINavigation$IBackupRestoreContext;", "<init>", "()V", "libraryViewModel", "Lcom/myscript/nebo/dms/core/LibraryViewModel;", "getLibraryViewModel", "()Lcom/myscript/nebo/dms/core/LibraryViewModel;", "libraryViewModel$delegate", "Lkotlin/Lazy;", "backupViewModel", "Lcom/myscript/nebo/backup/BackupRestoreViewModel;", "getBackupViewModel", "()Lcom/myscript/nebo/backup/BackupRestoreViewModel;", "backupViewModel$delegate", "backupRestoreUINavigation", "Lcom/myscript/nebo/backup/BackupRestoreUINavigation;", "getBackupRestoreUINavigation", "()Lcom/myscript/nebo/backup/BackupRestoreUINavigation;", "backupRestoreUINavigation$delegate", "backupSave", "Landroidx/preference/Preference;", "backupRestore", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "isFragmentReady", "()Z", "updateSettingsItems", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePreferences", "rootKey", "", "onResume", "onActivityResult", "requestCode", "resultCode", "returnIntent", "Landroid/content/Intent;", "onSaveInstanceState", "outState", "onSyncAndBackupNotebooks", "useLegacyFormat", "onRestoreNotebooks", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackupSettingsFragment extends PreferenceFragmentCompat implements NestedFragment, BackupRestoreUINavigation.IBackupRestoreContext {
    public static final String TAG = "BackupSettingsFragmentTag";
    private Preference backupRestore;

    /* JADX INFO: renamed from: backupRestoreUINavigation$delegate, reason: from kotlin metadata */
    private final Lazy backupRestoreUINavigation = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return BackupSettingsFragment.backupRestoreUINavigation_delegate$lambda$0(this.f$0);
        }
    });
    private Preference backupSave;

    /* JADX INFO: renamed from: backupViewModel$delegate, reason: from kotlin metadata */
    private final Lazy backupViewModel;

    /* JADX INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;
    private Navigator navigator;
    public static final int $stable = 8;

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return 0;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return false;
    }

    public BackupSettingsFragment() {
        final BackupSettingsFragment backupSettingsFragment = this;
        final Function0 function0 = null;
        this.libraryViewModel = FragmentViewModelLazyKt.createViewModelLazy(backupSettingsFragment, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return backupSettingsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? backupSettingsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LibraryViewModel.Factory;
            }
        });
        this.backupViewModel = FragmentViewModelLazyKt.createViewModelLazy(backupSettingsFragment, Reflection.getOrCreateKotlinClass(BackupRestoreViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return backupSettingsFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? backupSettingsFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BackupSettingsFragment.backupViewModel_delegate$lambda$0();
            }
        });
    }

    private final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    private final BackupRestoreViewModel getBackupViewModel() {
        return (BackupRestoreViewModel) this.backupViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory backupViewModel_delegate$lambda$0() {
        return BackupRestoreViewModel.INSTANCE.getFactory();
    }

    private final BackupRestoreUINavigation getBackupRestoreUINavigation() {
        return (BackupRestoreUINavigation) this.backupRestoreUINavigation.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackupRestoreUINavigation backupRestoreUINavigation_delegate$lambda$0(BackupSettingsFragment backupSettingsFragment) {
        return new BackupRestoreUINavigation(backupSettingsFragment, backupSettingsFragment.getBackupViewModel());
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6079R.string.side_panel_settings_backup_title;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    @Override // com.myscript.nebo.backup.BackupRestoreUINavigation.IBackupRestoreContext
    public Fragment getFragment() {
        return this;
    }

    @Override // com.myscript.nebo.backup.BackupRestoreUINavigation.IBackupRestoreContext
    public boolean isFragmentReady() {
        return getNavigator() != null;
    }

    @Override // com.myscript.nebo.backup.BackupRestoreUINavigation.IBackupRestoreContext
    public void updateSettingsItems() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    BackupSettingsFragment.updateSettingsItems$lambda$0(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateSettingsItems$lambda$0(BackupSettingsFragment backupSettingsFragment) {
        Preference preference = backupSettingsFragment.backupSave;
        if (preference != null && preference.isVisible()) {
            FragmentActivity activity = backupSettingsFragment.getActivity();
            ComponentCallbacks2 application = activity != null ? activity.getApplication() : null;
            LibraryRepository.Provider provider = application instanceof LibraryRepository.Provider ? (LibraryRepository.Provider) application : null;
            LibraryRepository libraryRepositoryProvideLibraryRepository = provider != null ? provider.provideLibraryRepository() : null;
            boolean z = false;
            boolean z2 = (libraryRepositoryProvideLibraryRepository == null || libraryRepositoryProvideLibraryRepository.isEmpty()) ? false : true;
            boolean zIsInScreenSequence = backupSettingsFragment.getBackupRestoreUINavigation().isInScreenSequence();
            if (z2 && !zIsInScreenSequence) {
                z = true;
            }
            Preference preference2 = backupSettingsFragment.backupSave;
            if (preference2 != null) {
                preference2.setEnabled(z);
            }
        }
        Preference preference3 = backupSettingsFragment.backupRestore;
        if (preference3 == null || !preference3.isVisible()) {
            return;
        }
        boolean zIsInScreenSequence2 = backupSettingsFragment.getBackupRestoreUINavigation().isInScreenSequence();
        Preference preference4 = backupSettingsFragment.backupRestore;
        if (preference4 != null) {
            preference4.setEnabled(!zIsInScreenSequence2);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getLibraryViewModel().getState().observe(getViewLifecycleOwner(), new BackupSettingsFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackupSettingsFragment.onViewCreated$lambda$0(this.f$0, (LibraryViewModel.State) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(BackupSettingsFragment backupSettingsFragment, LibraryViewModel.State state) {
        backupSettingsFragment.updateSettingsItems();
        return Unit.INSTANCE;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(C6079R.xml.backup_settings);
        this.backupSave = findPreference(getString(C6079R.string.pref_backup_save_key));
        this.backupRestore = findPreference(getString(C6079R.string.pref_backup_restore_key));
        Preference preference = this.backupSave;
        if (preference != null) {
            preference.setSummary(getString(C6079R.string.settings_group_backup_prompt, NeboBackupController.archiveExtension()));
        }
        Preference preference2 = this.backupSave;
        if (preference2 != null) {
            preference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$$ExternalSyntheticLambda0
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference3) {
                    return BackupSettingsFragment.onCreatePreferences$lambda$0(this.f$0, preference3);
                }
            });
        }
        Preference preference3 = this.backupRestore;
        if (preference3 != null) {
            preference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: com.myscript.nebo.settings.BackupSettingsFragment$$ExternalSyntheticLambda1
                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference4) {
                    return BackupSettingsFragment.onCreatePreferences$lambda$1(this.f$0, preference4);
                }
            });
        }
        updateSettingsItems();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$0(BackupSettingsFragment backupSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Preference preference = backupSettingsFragment.backupSave;
        if (preference != null) {
            preference.setEnabled(false);
        }
        Preference preference2 = backupSettingsFragment.backupRestore;
        if (preference2 != null) {
            preference2.setEnabled(false);
        }
        backupSettingsFragment.onSyncAndBackupNotebooks(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreatePreferences$lambda$1(BackupSettingsFragment backupSettingsFragment, Preference it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Preference preference = backupSettingsFragment.backupSave;
        if (preference != null) {
            preference.setEnabled(false);
        }
        Preference preference2 = backupSettingsFragment.backupRestore;
        if (preference2 != null) {
            preference2.setEnabled(false);
        }
        backupSettingsFragment.onRestoreNotebooks();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getBackupRestoreUINavigation().settingsFragmentResumed();
        updateSettingsItems();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent returnIntent) {
        getBackupRestoreUINavigation().onParentFragmentNotifyActivityResult(requestCode, resultCode, returnIntent);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        getBackupRestoreUINavigation().saveInstanceState(outState);
    }

    private final void onSyncAndBackupNotebooks(boolean useLegacyFormat) {
        getBackupRestoreUINavigation().onSyncAndBackupNotebooks(useLegacyFormat);
    }

    private final void onRestoreNotebooks() {
        if (isFragmentReady()) {
            getBackupRestoreUINavigation().onRestoreNotebooks();
        }
    }
}
