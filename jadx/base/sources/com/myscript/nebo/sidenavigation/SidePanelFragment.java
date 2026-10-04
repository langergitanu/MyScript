package com.myscript.nebo.sidenavigation;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationBarView;
import com.myscript.android.utils.LocaleExt;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.backup.BackupRestoreUINavigation;
import com.myscript.nebo.databinding.SideNavigationViewBinding;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.expandlist.DmsContentListFragment;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.grid.MainActivity;
import com.myscript.nebo.grid.MainViewModel;
import com.myscript.nebo.languagemanager.presentation.LanguageViewModel;
import com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import com.myscript.nebo.settings.BackupSettingsFragment;
import com.myscript.nebo.sidenavigation.SidePanelFragment;
import com.myscript.nebo.trash.p033ui.TrashedNotebooksFragment;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.List;
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

/* JADX INFO: compiled from: SidePanelFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0002rsB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00103\u001a\u00020*H\u0016J\u001a\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00106\u001a\u00020*H\u0016J\b\u00107\u001a\u00020*H\u0016J\u0006\u00108\u001a\u00020'J\u0010\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020*H\u0016J\b\u0010?\u001a\u00020'H\u0016J\b\u0010@\u001a\u00020*H\u0016J\b\u0010A\u001a\u00020*H\u0016J\u0010\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u00020'2\u0006\u0010F\u001a\u00020GH\u0002J\u0012\u0010I\u001a\u00020!2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0003J\u0012\u0010K\u001a\u00020'2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010N\u001a\u00020*2\b\u0010J\u001a\u0004\u0018\u00010\u00012\u0006\u0010K\u001a\u00020'H\u0002J\b\u0010O\u001a\u00020*H\u0002J\u0006\u0010P\u001a\u00020*J\b\u0010Q\u001a\u00020*H\u0002J\b\u0010R\u001a\u00020*H\u0002J\b\u0010S\u001a\u00020*H\u0002J\u0006\u0010T\u001a\u00020*J\u0006\u0010U\u001a\u00020*J\u0006\u0010V\u001a\u00020*J\u000e\u0010W\u001a\u00020*2\u0006\u0010X\u001a\u00020%J\u0006\u0010Y\u001a\u00020*J\u0006\u0010Z\u001a\u00020*J\u0010\u0010[\u001a\u00020*2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010^\u001a\u00020'H\u0016J\b\u0010_\u001a\u00020'H\u0016J\b\u0010`\u001a\u00020'H\u0016J\b\u0010a\u001a\u00020bH\u0016J\u0018\u0010c\u001a\u00020*2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020DH\u0016J\u0010\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020DH\u0016J\u0016\u0010i\u001a\u00020*2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020D0kH\u0016J\u0010\u0010l\u001a\u00020*2\b\u0010m\u001a\u0004\u0018\u00010DJ\u0006\u0010n\u001a\u00020*J\b\u0010o\u001a\u00020*H\u0002J\b\u0010p\u001a\u00020*H\u0002J\b\u0010q\u001a\u00020*H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\n\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006t"}, m1599d2 = {"Lcom/myscript/nebo/sidenavigation/SidePanelFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment$Callback;", "<init>", "()V", "languageViewModel", "Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "getLanguageViewModel", "()Lcom/myscript/nebo/languagemanager/presentation/LanguageViewModel;", "languageViewModel$delegate", "Lkotlin/Lazy;", "navigator", "Lcom/myscript/android/utils/Navigator;", "activeFragment", "getActiveFragment", "()Landroidx/fragment/app/Fragment;", "viewBinding", "Lcom/myscript/nebo/databinding/SideNavigationViewBinding;", "mainNavigationBar", "Lcom/google/android/material/navigation/NavigationBarView;", "getMainNavigationBar", "()Lcom/google/android/material/navigation/NavigationBarView;", "mainViewModel", "Lcom/myscript/nebo/grid/MainViewModel;", "getMainViewModel", "()Lcom/myscript/nebo/grid/MainViewModel;", "mainViewModel$delegate", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "lastRequestedMainNavigationVisibility", "", "callback", "Lcom/myscript/nebo/sidenavigation/SidePanelFragment$Callback;", "uriForBackupRestore", "Landroid/net/Uri;", "isSearching", "", "()Z", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "onStop", "onDestroyView", "hasNestedNavigation", "onBackPressed", "Landroidx/activity/OnBackPressedCallback;", "onAttach", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "onDetach", "isSyncToolbarEnabled", "onNewFolderRequested", "onNewCollectionRequested", "onEditSelection", "selectedNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "onMainNavigationItemClick", "item", "Landroid/view/MenuItem;", "onToolbarMenuItemClick", "toMainNavigationMenuItemId", "fragment", "isMainFragment", "onNestedFragmentChanged", "Lcom/myscript/android/utils/Navigator$Listener;", "updateToolbar", "onNavigationIconClicked", "onSidePanelOpened", "showDMSFragment", "showTrashFragment", "showSettingsFragment", "showHelpFragment", "showSyncSettingsFragment", "showBackupSettingsFragment", "showBackupSettingsFragmentForRestore", "uri", "onShowSearch", "onHideSearch", "onSyncRequested", "folderModel", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "isAutoSyncEnabled", "isSidePanelOpen", "isCloudConnected", "getSearchLabel", "", "movePage", "pageKey", "Lcom/myscript/snt/core/PageKey;", "newNotebookKey", "onFolderClicked", "notebokKey", "moveToTrash", "notebookKeys", "", "onNotebookOpenChanged", "notebookKey", "stopSelection", "showMainNavigation", "hideMainNavigation", "updateSettingsBadgeVisibility", "Callback", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SidePanelFragment extends Fragment implements DmsContentListFragment.Callback {
    public static final String TAG = "SidePanelFragment";
    private Callback callback;

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;

    /* JADX INFO: renamed from: languageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy languageViewModel;
    private int lastRequestedMainNavigationVisibility;

    /* JADX INFO: renamed from: mainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mainViewModel;
    private Navigator navigator;
    private final OnBackPressedCallback onBackPressed = new OnBackPressedCallback() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$onBackPressed$1
        {
            super(true);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            if (this.this$0.hasNestedNavigation()) {
                Navigator navigator = this.this$0.navigator;
                if (navigator != null) {
                    navigator.popFragment();
                    return;
                }
                return;
            }
            if (getIsEnabled()) {
                setEnabled(false);
                this.this$0.requireActivity().onBackPressed();
            }
        }
    };
    private final Navigator.Listener onNestedFragmentChanged = new Navigator.Listener() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$onNestedFragmentChanged$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.myscript.android.utils.Navigator.Listener
        public void onFragmentChanged(Fragment fragment) {
            Navigator navigator;
            Menu menu;
            MenuItem menuItemFindItem;
            boolean zIsMainFragment = this.this$0.isMainFragment(fragment);
            this.this$0.updateToolbar(fragment, zIsMainFragment);
            if (this.this$0.navigator != null && (fragment instanceof NestedFragment)) {
                ((NestedFragment) fragment).setNavigator(this.this$0.navigator);
            }
            if (zIsMainFragment && (navigator = this.this$0.navigator) != null && !navigator.hasSelectionMode()) {
                this.this$0.showMainNavigation();
                NavigationBarView mainNavigationBar = this.this$0.getMainNavigationBar();
                if (mainNavigationBar != null && (menu = mainNavigationBar.getMenu()) != null && (menuItemFindItem = menu.findItem(this.this$0.toMainNavigationMenuItemId(fragment))) != null) {
                    menuItemFindItem.setChecked(true);
                }
            } else if (fragment != 0) {
                if ((fragment instanceof BackupSettingsFragment) && this.this$0.uriForBackupRestore != null) {
                    Intent intent = new Intent();
                    intent.setData(this.this$0.uriForBackupRestore);
                    this.this$0.uriForBackupRestore = null;
                    ((BackupSettingsFragment) fragment).onActivityResult(BackupRestoreUINavigation.BackupRestoreAction.RestoreSelect.ordinal(), -1, intent);
                }
                this.this$0.hideMainNavigation();
            }
            this.this$0.updateSettingsBadgeVisibility();
        }

        @Override // com.myscript.android.utils.Navigator.Listener
        public void invalidateOptionsMenu() {
            SideNavigationViewBinding sideNavigationViewBinding;
            MaterialToolbar materialToolbar;
            Menu menu;
            ActivityResultCaller activeFragment = this.this$0.getActiveFragment();
            NestedFragment nestedFragment = activeFragment instanceof NestedFragment ? (NestedFragment) activeFragment : null;
            if (nestedFragment == null || (sideNavigationViewBinding = this.this$0.viewBinding) == null || (materialToolbar = sideNavigationViewBinding.sideNavigationToolbar) == null || (menu = materialToolbar.getMenu()) == null) {
                return;
            }
            nestedFragment.onPrepareOptionsMenu(menu);
        }

        @Override // com.myscript.android.utils.Navigator.Listener
        public void onSelectionModeStarted() {
            this.this$0.hideMainNavigation();
            SidePanelFragment.Callback callback = this.this$0.callback;
            if (callback != null) {
                callback.onDMSSelectionChanged(true);
            }
            SidePanelFragment.Callback callback2 = this.this$0.callback;
            if (callback2 != null) {
                callback2.closeSearchIfNotStarted();
            }
        }

        @Override // com.myscript.android.utils.Navigator.Listener
        public void onSelectionModeStopped() {
            this.this$0.showMainNavigation();
            SidePanelFragment.Callback callback = this.this$0.callback;
            if (callback != null) {
                callback.onDMSSelectionChanged(false);
            }
        }
    };
    private Uri uriForBackupRestore;
    private SideNavigationViewBinding viewBinding;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: SidePanelFragment.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\tH&J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH&J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH&J\u0016\u0010\u001c\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001eH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0012\u0010\u0007\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sidenavigation/SidePanelFragment$Callback;", "", "isCloudConnected", "", "()Z", "isAutoSyncEnabled", "isSearching", "isLastSyncActionAUserAction", "close", "", "setLoadingEnabled", "enabled", "onSyncRequested", "notebookKey", "Lcom/myscript/snt/core/NotebookKey;", "resumeSync", "onDMSSelectionChanged", "isSelectionMode", "searchLabel", "", "getSearchLabel", "()Ljava/lang/String;", "closeSearchIfNotStarted", "movePage", "pageKey", "Lcom/myscript/snt/core/PageKey;", "newNotebookKey", "onFolderClicked", "moveToTrash", "notebookKeys", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void close();

        void closeSearchIfNotStarted();

        String getSearchLabel();

        boolean isAutoSyncEnabled();

        boolean isCloudConnected();

        boolean isLastSyncActionAUserAction();

        boolean isSearching();

        void movePage(PageKey pageKey, NotebookKey newNotebookKey);

        void moveToTrash(List<? extends NotebookKey> notebookKeys);

        void onDMSSelectionChanged(boolean isSelectionMode);

        void onFolderClicked(NotebookKey notebookKey);

        void onSyncRequested(NotebookKey notebookKey);

        void resumeSync();

        void setLoadingEnabled(boolean enabled);
    }

    @JvmStatic
    public static final SidePanelFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public SidePanelFragment() {
        final SidePanelFragment sidePanelFragment = this;
        final Function0 function0 = null;
        this.languageViewModel = FragmentViewModelLazyKt.createViewModelLazy(sidePanelFragment, Reflection.getOrCreateKotlinClass(LanguageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return sidePanelFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? sidePanelFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SidePanelFragment.languageViewModel_delegate$lambda$0(this.f$0);
            }
        });
        this.mainViewModel = FragmentViewModelLazyKt.createViewModelLazy(sidePanelFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return sidePanelFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? sidePanelFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainViewModel.Factory;
            }
        });
        this.freemiumLimitationViewModel = FragmentViewModelLazyKt.createViewModelLazy(sidePanelFragment, Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return sidePanelFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$special$$inlined$activityViewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? sidePanelFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda9
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
    public static final ViewModelProvider.Factory languageViewModel_delegate$lambda$0(SidePanelFragment sidePanelFragment) {
        FragmentActivity fragmentActivityRequireActivity = sidePanelFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        Configuration configuration = fragmentActivityRequireActivity.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        LanguageNameHelper languageNameHelper = new LanguageNameHelper(LocaleExt.getPrimaryLocale(configuration));
        ComponentCallbacks2 application = fragmentActivityRequireActivity.getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider");
        return new LanguageViewModel.Factory(languageNameHelper, ((ISuggestedLanguagesProvider) application).provideSuggestedLanguages());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment getActiveFragment() {
        Navigator navigator = this.navigator;
        if (navigator != null) {
            return navigator.getActiveFragment();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NavigationBarView getMainNavigationBar() {
        SideNavigationViewBinding sideNavigationViewBinding = this.viewBinding;
        return sideNavigationViewBinding != null ? sideNavigationViewBinding.bottomNavigation : null;
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel.getValue();
    }

    private final FreemiumLimitationViewModel getFreemiumLimitationViewModel() {
        return (FreemiumLimitationViewModel) this.freemiumLimitationViewModel.getValue();
    }

    private final boolean isSearching() {
        Callback callback = this.callback;
        if (callback != null) {
            return callback.isSearching();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        this.navigator = new Navigator(childFragmentManager, C6079R.id.side_navigation_fragment_container, C6079R.id.side_navigation_app_bar_frame);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        SideNavigationViewBinding sideNavigationViewBindingInflate = SideNavigationViewBinding.inflate(inflater);
        this.viewBinding = sideNavigationViewBindingInflate;
        return sideNavigationViewBindingInflate != null ? sideNavigationViewBindingInflate.getRoot() : null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        MaterialToolbar materialToolbar;
        MaterialToolbar materialToolbar2;
        super.onStart();
        Navigator navigator = this.navigator;
        if (navigator != null) {
            navigator.addListener(this.onNestedFragmentChanged);
        }
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            navigator2.restoreFragment(DmsContentListFragment.TAG, new C68071(DmsContentListFragment.INSTANCE));
        }
        SideNavigationViewBinding sideNavigationViewBinding = this.viewBinding;
        if (sideNavigationViewBinding != null && (materialToolbar2 = sideNavigationViewBinding.sideNavigationToolbar) != null) {
            materialToolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.onNavigationIconClicked();
                }
            });
        }
        SideNavigationViewBinding sideNavigationViewBinding2 = this.viewBinding;
        if (sideNavigationViewBinding2 != null && (materialToolbar = sideNavigationViewBinding2.sideNavigationToolbar) != null) {
            materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda4
                @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return this.f$0.onToolbarMenuItemClick(menuItem);
                }
            });
        }
        NavigationBarView mainNavigationBar = getMainNavigationBar();
        if (mainNavigationBar != null) {
            mainNavigationBar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda5
                @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
                public final boolean onNavigationItemSelected(MenuItem menuItem) {
                    return this.f$0.onMainNavigationItemClick(menuItem);
                }
            });
        }
        Callback callback = this.callback;
        if (callback != null && callback.isSearching()) {
            onShowSearch();
            return;
        }
        Navigator navigator3 = this.navigator;
        if (navigator3 == null || navigator3.hasSelectionMode()) {
            return;
        }
        onHideSearch();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sidenavigation.SidePanelFragment$onStart$1 */
    /* JADX INFO: compiled from: SidePanelFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68071 extends FunctionReferenceImpl implements Function0<DmsContentListFragment> {
        C68071(Object obj) {
            super(0, obj, DmsContentListFragment.Companion.class, "newInstance", "newInstance()Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DmsContentListFragment invoke() {
            return ((DmsContentListFragment.Companion) this.receiver).newInstance();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (RetailMode.INSTANCE.isEnabled()) {
            NavigationBarView mainNavigationBar = getMainNavigationBar();
            if (mainNavigationBar != null) {
                mainNavigationBar.setVisibility(8);
            }
            SideNavigationViewBinding sideNavigationViewBinding = this.viewBinding;
            if (sideNavigationViewBinding != null && (imageView = sideNavigationViewBinding.retailQrCard) != null) {
                imageView.setVisibility(0);
            }
        }
        getLanguageViewModel().getLanguagesToUpdate().observe(getViewLifecycleOwner(), new SidePanelFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SidePanelFragment.onViewCreated$lambda$0(this.f$0, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(SidePanelFragment sidePanelFragment, List list) {
        sidePanelFragment.updateSettingsBadgeVisibility();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        MaterialToolbar materialToolbar;
        MaterialToolbar materialToolbar2;
        Navigator navigator = this.navigator;
        if (navigator != null) {
            navigator.removeListener(this.onNestedFragmentChanged);
        }
        SideNavigationViewBinding sideNavigationViewBinding = this.viewBinding;
        if (sideNavigationViewBinding != null && (materialToolbar2 = sideNavigationViewBinding.sideNavigationToolbar) != null) {
            materialToolbar2.setNavigationOnClickListener(null);
        }
        SideNavigationViewBinding sideNavigationViewBinding2 = this.viewBinding;
        if (sideNavigationViewBinding2 != null && (materialToolbar = sideNavigationViewBinding2.sideNavigationToolbar) != null) {
            materialToolbar.setOnMenuItemClickListener(null);
        }
        NavigationBarView mainNavigationBar = getMainNavigationBar();
        if (mainNavigationBar != null) {
            mainNavigationBar.setOnItemSelectedListener(null);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.viewBinding = null;
        super.onDestroyView();
    }

    public final boolean hasNestedNavigation() {
        return (this.navigator == null || isMainFragment(getActiveFragment())) ? false : true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwnerRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcherOwnerRequireActivity, "requireActivity(...)");
        onBackPressedDispatcherOwnerRequireActivity.getOnBackPressedDispatcher().addCallback(this, this.onBackPressed);
        Callback callback = onBackPressedDispatcherOwnerRequireActivity instanceof Callback ? (Callback) onBackPressedDispatcherOwnerRequireActivity : null;
        if (callback == null) {
            throw new IllegalStateException("Parent activity must implements SidePanelFragment.Callback".toString());
        }
        this.callback = callback;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() throws Exception {
        this.onBackPressed.remove();
        this.callback = null;
        super.onDetach();
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public boolean isSyncToolbarEnabled() {
        return !RetailMode.INSTANCE.isEnabled();
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public void onNewFolderRequested() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.myscript.nebo.grid.MainActivity");
        MainActivity.requestNewFolderDialog$default((MainActivity) fragmentActivityRequireActivity, null, 1, null);
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public void onNewCollectionRequested() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.myscript.nebo.grid.MainActivity");
        ((MainActivity) fragmentActivityRequireActivity).requestNewCollectionDialog();
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public void onEditSelection(NotebookKey selectedNotebookKey) {
        Intrinsics.checkNotNullParameter(selectedNotebookKey, "selectedNotebookKey");
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.myscript.nebo.grid.MainActivity");
        ((MainActivity) fragmentActivityRequireActivity).requestFolderMenuEdit(selectedNotebookKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onMainNavigationItemClick(MenuItem item) {
        Callback callback = this.callback;
        if (callback != null) {
            callback.closeSearchIfNotStarted();
        }
        int itemId = item.getItemId();
        if (itemId == C6079R.id.side_panel_books) {
            showDMSFragment();
            return true;
        }
        if (itemId == C6079R.id.side_panel_help) {
            showHelpFragment();
            return true;
        }
        if (itemId == C6079R.id.side_panel_trash) {
            showTrashFragment();
            return true;
        }
        if (itemId != C6079R.id.side_panel_settings) {
            return false;
        }
        showSettingsFragment();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onToolbarMenuItemClick(MenuItem item) {
        Callback callback = this.callback;
        if (callback != null) {
            callback.closeSearchIfNotStarted();
        }
        ActivityResultCaller activeFragment = getActiveFragment();
        NestedFragment nestedFragment = activeFragment instanceof NestedFragment ? (NestedFragment) activeFragment : null;
        if (nestedFragment != null) {
            return nestedFragment.onMenuItemClicked(item);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMainNavigationMenuItemId(Fragment fragment) {
        if (fragment instanceof DmsContentListFragment) {
            return C6079R.id.side_panel_books;
        }
        if (fragment instanceof TrashedNotebooksFragment) {
            return C6079R.id.side_panel_trash;
        }
        if (fragment instanceof SideSettingsFragment) {
            return C6079R.id.side_panel_settings;
        }
        if (fragment instanceof SideHelpFragment) {
            return C6079R.id.side_panel_help;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMainFragment(Fragment fragment) {
        return (fragment instanceof DmsContentListFragment) || (fragment instanceof TrashedNotebooksFragment) || (fragment instanceof SideSettingsFragment) || (fragment instanceof SideHelpFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateToolbar(final Fragment fragment, boolean isMainFragment) {
        final MaterialToolbar materialToolbar;
        if (fragment == 0) {
            return;
        }
        if (!(fragment instanceof NestedFragment)) {
            throw new IllegalArgumentException("Given fragment isn't a nested `NestedFragment`".toString());
        }
        SideNavigationViewBinding sideNavigationViewBinding = this.viewBinding;
        if (sideNavigationViewBinding == null || (materialToolbar = sideNavigationViewBinding.sideNavigationToolbar) == null) {
            return;
        }
        if (fragment.isAdded()) {
            materialToolbar.setTitle(((NestedFragment) fragment).getTitleRes());
        }
        materialToolbar.setActivated(!isMainFragment);
        materialToolbar.getMenu().clear();
        int menuRes = ((NestedFragment) fragment).getMenuRes();
        if (menuRes != 0) {
            materialToolbar.inflateMenu(menuRes);
            materialToolbar.post(new Runnable() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    SidePanelFragment.updateToolbar$lambda$1(fragment, materialToolbar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void updateToolbar$lambda$1(Fragment fragment, MaterialToolbar materialToolbar) {
        if (fragment.isAdded()) {
            Menu menu = materialToolbar.getMenu();
            Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
            ((NestedFragment) fragment).onPrepareOptionsMenu(menu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onNavigationIconClicked() {
        if (isMainFragment(getActiveFragment())) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.close();
            }
        } else {
            Navigator navigator = this.navigator;
            if (navigator != null) {
                navigator.popFragment();
            }
        }
        Fragment activeFragment = getActiveFragment();
        DmsContentListFragment dmsContentListFragment = activeFragment instanceof DmsContentListFragment ? (DmsContentListFragment) activeFragment : null;
        if (dmsContentListFragment != null) {
            dmsContentListFragment.setCurrentTooltipVisible(false);
        }
    }

    public final void onSidePanelOpened() {
        Fragment activeFragment = getActiveFragment();
        DmsContentListFragment dmsContentListFragment = activeFragment instanceof DmsContentListFragment ? (DmsContentListFragment) activeFragment : null;
        if (dmsContentListFragment != null) {
            dmsContentListFragment.setCurrentTooltipVisible(true);
        }
    }

    private final void showDMSFragment() {
        getMainViewModel().navigateToNotebooks();
        Navigator navigator = this.navigator;
        if (navigator != null) {
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sidenavigation.SidePanelFragment$showDMSFragment$1 */
    /* JADX INFO: compiled from: SidePanelFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68101 extends FunctionReferenceImpl implements Function0<DmsContentListFragment> {
        C68101(Object obj) {
            super(0, obj, DmsContentListFragment.Companion.class, "newInstance", "newInstance()Lcom/myscript/nebo/dms/expandlist/DmsContentListFragment;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DmsContentListFragment invoke() {
            return ((DmsContentListFragment.Companion) this.receiver).newInstance();
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sidenavigation.SidePanelFragment$showTrashFragment$1 */
    /* JADX INFO: compiled from: SidePanelFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68121 extends FunctionReferenceImpl implements Function0<TrashedNotebooksFragment> {
        C68121(Object obj) {
            super(0, obj, TrashedNotebooksFragment.Companion.class, "newInstance", "newInstance()Lcom/myscript/nebo/trash/ui/TrashedNotebooksFragment;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TrashedNotebooksFragment invoke() {
            return ((TrashedNotebooksFragment.Companion) this.receiver).newInstance();
        }
    }

    private final void showTrashFragment() {
        getMainViewModel().navigateToTrash();
        Navigator navigator = this.navigator;
        if (navigator != null) {
        }
    }

    private final void showSettingsFragment() {
        getMainViewModel().navigateToNotebooks();
        Navigator navigator = this.navigator;
        if (navigator != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SideSettingsFragment showSettingsFragment$lambda$0() {
        return SideSettingsFragment.INSTANCE.newInstance(null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sidenavigation.SidePanelFragment$showHelpFragment$1 */
    /* JADX INFO: compiled from: SidePanelFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68111 extends FunctionReferenceImpl implements Function0<SideHelpFragment> {
        public static final C68111 INSTANCE = new C68111();

        C68111() {
            super(0, SideHelpFragment.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SideHelpFragment invoke() {
            return new SideHelpFragment();
        }
    }

    public final void showHelpFragment() {
        getMainViewModel().navigateToNotebooks();
        Navigator navigator = this.navigator;
        if (navigator != null) {
        }
    }

    public final void showSyncSettingsFragment() {
        getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_SYNC_SETTING_INTERACTION, new Function0() { // from class: com.myscript.nebo.sidenavigation.SidePanelFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SidePanelFragment.showSyncSettingsFragment$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showSyncSettingsFragment$lambda$0(SidePanelFragment sidePanelFragment) {
        Navigator navigator = sidePanelFragment.navigator;
        if (navigator != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sidenavigation.SidePanelFragment$showBackupSettingsFragment$1 */
    /* JADX INFO: compiled from: SidePanelFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68081 extends FunctionReferenceImpl implements Function0<BackupSettingsFragment> {
        public static final C68081 INSTANCE = new C68081();

        C68081() {
            super(0, BackupSettingsFragment.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BackupSettingsFragment invoke() {
            return new BackupSettingsFragment();
        }
    }

    public final void showBackupSettingsFragment() {
        Navigator navigator = this.navigator;
        if (navigator != null) {
        }
    }

    public final void showBackupSettingsFragmentForRestore(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        showSettingsFragment();
        this.uriForBackupRestore = uri;
        Navigator navigator = this.navigator;
        if (navigator != null) {
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.sidenavigation.SidePanelFragment$showBackupSettingsFragmentForRestore$1 */
    /* JADX INFO: compiled from: SidePanelFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68091 extends FunctionReferenceImpl implements Function0<BackupSettingsFragment> {
        public static final C68091 INSTANCE = new C68091();

        C68091() {
            super(0, BackupSettingsFragment.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BackupSettingsFragment invoke() {
            return new BackupSettingsFragment();
        }
    }

    public final void onShowSearch() {
        MaterialToolbar materialToolbar;
        SideNavigationViewBinding sideNavigationViewBinding = this.viewBinding;
        if (sideNavigationViewBinding != null && (materialToolbar = sideNavigationViewBinding.sideNavigationToolbar) != null) {
            materialToolbar.setTitle(C6208R.string.search_toolbar_title);
        }
        showDMSFragment();
        hideMainNavigation();
    }

    public final void onHideSearch() {
        SideNavigationViewBinding sideNavigationViewBinding;
        MaterialToolbar materialToolbar;
        ActivityResultCaller activeFragment = getActiveFragment();
        NestedFragment nestedFragment = activeFragment instanceof NestedFragment ? (NestedFragment) activeFragment : null;
        if (nestedFragment != null && (sideNavigationViewBinding = this.viewBinding) != null && (materialToolbar = sideNavigationViewBinding.sideNavigationToolbar) != null) {
            materialToolbar.setTitle(nestedFragment.getTitleRes());
        }
        showMainNavigation();
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public void onSyncRequested(FolderModel folderModel) {
        Intrinsics.checkNotNullParameter(folderModel, "folderModel");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onSyncRequested(folderModel.getNotebookKey());
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public boolean isAutoSyncEnabled() {
        Callback callback = this.callback;
        if (callback != null) {
            return callback.isAutoSyncEnabled();
        }
        return false;
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public boolean isSidePanelOpen() {
        return getMainViewModel().getIsSidePanelOpen();
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public boolean isCloudConnected() {
        Callback callback = this.callback;
        if (callback != null) {
            return callback.isCloudConnected();
        }
        return false;
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public String getSearchLabel() {
        String searchLabel;
        Callback callback = this.callback;
        return (callback == null || (searchLabel = callback.getSearchLabel()) == null) ? "" : searchLabel;
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public void movePage(PageKey pageKey, NotebookKey newNotebookKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Intrinsics.checkNotNullParameter(newNotebookKey, "newNotebookKey");
        Callback callback = this.callback;
        if (callback != null) {
            callback.movePage(pageKey, newNotebookKey);
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public void onFolderClicked(NotebookKey notebokKey) {
        Intrinsics.checkNotNullParameter(notebokKey, "notebokKey");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onFolderClicked(notebokKey);
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.DmsContentListFragment.Callback
    public void moveToTrash(List<? extends NotebookKey> notebookKeys) {
        Intrinsics.checkNotNullParameter(notebookKeys, "notebookKeys");
        Navigator navigator = this.navigator;
        if (navigator != null) {
            navigator.stopSelectionMode();
        }
        Callback callback = this.callback;
        if (callback != null) {
            callback.moveToTrash(notebookKeys);
        }
    }

    public final void onNotebookOpenChanged(NotebookKey notebookKey) {
        Fragment activeFragment = getActiveFragment();
        DmsContentListFragment dmsContentListFragment = activeFragment instanceof DmsContentListFragment ? (DmsContentListFragment) activeFragment : null;
        if (dmsContentListFragment == null) {
            return;
        }
        dmsContentListFragment.onNotebookOpenChange(notebookKey);
    }

    public final void stopSelection() {
        Navigator navigator = this.navigator;
        if (navigator != null) {
            navigator.stopSelectionMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMainNavigation() {
        ConstraintLayout constraintLayout;
        SideNavigationViewBinding sideNavigationViewBinding = this.viewBinding;
        if (sideNavigationViewBinding == null || (constraintLayout = sideNavigationViewBinding.sideNavigationContent) == null) {
            return;
        }
        int i = (!isMainFragment(getActiveFragment()) || isSearching()) ? 8 : 0;
        if (this.lastRequestedMainNavigationVisibility == i) {
            return;
        }
        this.lastRequestedMainNavigationVisibility = i;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.clear(C6079R.id.bottom_navigation, 3);
        constraintSet.clear(C6079R.id.bottom_navigation, 4);
        constraintSet.connect(C6079R.id.bottom_navigation, 4, 0, 4);
        AutoTransition autoTransition = new AutoTransition();
        constraintSet.applyTo(constraintLayout);
        TransitionManager.beginDelayedTransition(constraintLayout, autoTransition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideMainNavigation() {
        ConstraintLayout constraintLayout;
        SideNavigationViewBinding sideNavigationViewBinding = this.viewBinding;
        if (sideNavigationViewBinding == null || (constraintLayout = sideNavigationViewBinding.sideNavigationContent) == null) {
            return;
        }
        this.lastRequestedMainNavigationVisibility = 8;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.clear(C6079R.id.bottom_navigation, 3);
        constraintSet.clear(C6079R.id.bottom_navigation, 4);
        constraintSet.connect(C6079R.id.bottom_navigation, 3, 0, 4);
        AutoTransition autoTransition = new AutoTransition();
        constraintSet.applyTo(constraintLayout);
        TransitionManager.beginDelayedTransition(constraintLayout, autoTransition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSettingsBadgeVisibility() {
        BadgeDrawable orCreateBadge;
        NavigationBarView mainNavigationBar = getMainNavigationBar();
        if (mainNavigationBar == null || (orCreateBadge = mainNavigationBar.getOrCreateBadge(C6079R.id.side_panel_settings)) == null) {
            return;
        }
        List<String> value = getLanguageViewModel().getLanguagesToUpdate().getValue();
        int size = value != null ? value.size() : 0;
        if (size > 0) {
            orCreateBadge.setNumber(size);
            orCreateBadge.setVisible(true);
        } else {
            orCreateBadge.clearNumber();
            orCreateBadge.setVisible(false);
        }
    }

    /* JADX INFO: compiled from: SidePanelFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/sidenavigation/SidePanelFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/sidenavigation/SidePanelFragment;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SidePanelFragment newInstance() {
            return new SidePanelFragment();
        }
    }
}
