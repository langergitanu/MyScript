package com.myscript.nebo.grid;

import android.R;
import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.myscript.android.utils.ComposeViewManager;
import com.myscript.android.utils.FloatingActionButtonMenu;
import com.myscript.android.utils.LocaleExt;
import com.myscript.android.utils.SelectionMode;
import com.myscript.android.utils.TextViewExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.MainActivityDetailFragment;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.Shortcut;
import com.myscript.nebo.analytics.AnalyticsController;
import com.myscript.nebo.analytics.firebase.PaywallOrigin;
import com.myscript.nebo.banner.Banner;
import com.myscript.nebo.banner.BannerLayout;
import com.myscript.nebo.banner.BannerViewModel;
import com.myscript.nebo.banner.Priority;
import com.myscript.nebo.banner.Type;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.PickDocumentContract;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.common.network.NeboNetworkStateRepositoryProvider;
import com.myscript.nebo.common.utils.FeatureHelper;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.discoverability.p024ui.compose.TooltipComposableProviderImpl;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.dialog.FolderPickerDialog;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeature;
import com.myscript.nebo.dms.discoverability.GridDiscoverableFeatureKt;
import com.myscript.nebo.dms.sharepage.dialog.SharePageDialog;
import com.myscript.nebo.editing.EditingActivity;
import com.myscript.nebo.export.ExportDialog;
import com.myscript.nebo.freemium.FreemiumBannerView;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.freemium.RenewalOfferBannerView;
import com.myscript.nebo.grid.DisplayMode;
import com.myscript.nebo.grid.EmptyState;
import com.myscript.nebo.grid.GridViewModel;
import com.myscript.nebo.grid.MainViewFragment;
import com.myscript.nebo.grid.SearchState;
import com.myscript.nebo.grid.p029ui.compose.NotesDisplayControlsKt;
import com.myscript.nebo.languagemanager.presentation.LanguageViewModel;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import com.myscript.nebo.languagemanager.util.ISuggestedLanguagesProvider;
import com.myscript.nebo.languagemanager.util.LanguageNameHelper;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.note.NoteType;
import com.myscript.nebo.note.p030ui.NoteCreationDialogFragment;
import com.myscript.nebo.note.p030ui.NoteEditingDialogFragment;
import com.myscript.nebo.rating.RatingInviteDialogImpl;
import com.myscript.nebo.rating.feedback.FeedBackDialog;
import com.myscript.nebo.sso.p032ui.login.LoginActivityHelperKt;
import com.myscript.nebo.storage.StorageKt;
import com.myscript.nebo.storage.StorageState;
import com.myscript.nebo.trash.p033ui.TrashDiscoverabilityDialogKt;
import com.myscript.nebo.utils.NewFeatureVisibilityHelper;
import com.myscript.nebo.utils.SupportUtilsKt;
import com.myscript.nebo.whatsnew.ApplicationState;
import com.myscript.nebo.whatsnew.IApplicationStateProvider;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public class MainViewFragment extends Fragment implements MainActivityDetailFragment {
    private static final String BANNER_ID_CORRUPTED_PAGE = "MainActivity.BANNER_ID_CORRUPTED_PAGE";
    private static final String BANNER_ID_STORAGE_WARNING = "MainActivity.BANNER_ID_STORAGE_WARNING";
    public static final String TAG = "MainViewFragment";
    private FreemiumLimitationViewModel freemiumLimitationViewModel;
    private FloatingActionButtonMenu mAddPageButton;
    private BannerLayout mBannerLayout;
    private BannerViewModel mBannerViewModel;
    private AlertDialog mCriticalStoragePopup;
    private ComposeView mDiscoverabilityTooltip;
    private View mEmptyState;
    private ImageView mEmptyStateImage;
    private TextView mEmptyStateSubtitle;
    private TextView mEmptyStateTitle;
    private FreemiumBannerView mFreemiumBanner;
    private GridViewModel mGridViewModel;
    private LanguageViewModel mLanguageViewModel;
    private LibraryRepository mLibraryRepository;
    private View mLoadingProgress;
    private TechnicalLogger mLogger;
    private MainViewModel mMainViewModel;
    private ComposeView mPreRatingView;
    private RenewalOfferBannerView mRenewalBanner;
    private GridSearchView mSearchView;
    private SelectionMode mSelectionMode;
    private Toolbar mToolbar;
    private final MenuProvider mMenuProvider = new C65531();
    private final SelectionMode.Callback mSelectionModeCallback = new C65542();
    private final ActivityResultLauncher<Intent> mEditingLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$0((ActivityResult) obj);
        }
    });
    private final ActivityResultLauncher<String[]> mGetContent = registerForActivityResult(new PickDocumentContract(), new ActivityResultCallback() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda2
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$1((Uri) obj);
        }
    });
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.myscript.nebo.grid.MainViewFragment.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            MainViewFragment mainViewFragment = MainViewFragment.this;
            mainViewFragment.updateTooltip(mainViewFragment.mMainViewModel.getDiscoveryTooltip().getValue());
        }
    };
    private final ActivityResultLauncher<Intent> loginActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda3
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$9((ActivityResult) obj);
        }
    });

    interface ActionListener {
        void onExport(List<PageKey> list);

        void onStartDraggingPage();
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewFragment$1 */
    class C65531 implements MenuProvider {
        C65531() {
        }

        @Override // androidx.core.view.MenuProvider
        public void onPrepareMenu(Menu menu) {
            if ((MainViewFragment.this.mGridViewModel.getSearchState().getValue() instanceof SearchState.Closed) && MainViewFragment.this.mGridViewModel.hasNotebookOpen()) {
                boolean z = !MainViewFragment.this.mGridViewModel.isEmpty();
                MenuItem menuItemFindItem = menu.findItem(C6079R.id.main_view_more_menu_select);
                if (menuItemFindItem != null) {
                    menuItemFindItem.setEnabled(z);
                }
                MenuItem menuItemFindItem2 = menu.findItem(C6079R.id.main_view_more_menu_import);
                if (menuItemFindItem2 != null) {
                    menuItemFindItem2.setEnabled(MainViewFragment.this.mGridViewModel.hasNotebookOpen());
                }
                MenuItem menuItemFindItem3 = menu.findItem(C6079R.id.main_view_more_menu_export);
                if (menuItemFindItem3 != null) {
                    menuItemFindItem3.setEnabled(MainViewFragment.this.mGridViewModel.getCanExport());
                }
            } else {
                menu.clear();
            }
            super.onPrepareMenu(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
            menu.clear();
            menuInflater.inflate(C6079R.menu.main_view_more_menu, menu);
            if (RetailMode.INSTANCE.isEnabled()) {
                menu.removeItem(C6079R.id.main_view_more_menu_import);
                menu.removeItem(C6079R.id.main_view_more_menu_export);
            }
        }

        @Override // androidx.core.view.MenuProvider
        public boolean onMenuItemSelected(MenuItem menuItem) {
            if (MainViewFragment.this.mLibraryRepository == null) {
                return false;
            }
            final NotebookKey openedNotebookKey = MainViewFragment.this.mGridViewModel.getOpenedNotebookKey();
            int itemId = menuItem.getItemId();
            if (itemId == C6079R.id.main_view_more_menu_search) {
                MainViewFragment.this.mGridViewModel.openSearch();
                return true;
            }
            if (itemId == C6079R.id.main_view_more_menu_select && openedNotebookKey != null) {
                MainViewFragment.this.mGridViewModel.activatePagesSelectionMode(true);
                return true;
            }
            if (itemId == C6079R.id.main_view_more_menu_import && openedNotebookKey != null) {
                if (!FeatureHelper.checkFeatureAvailable(MainViewFragment.this.requireContext(), C6079R.bool.export_enabled)) {
                    return false;
                }
                MainViewFragment.this.mGetContent.launch(new String[]{"binary/octet-stream", "application/zip", "application/octet-stream", "application/binary", "application/x-zip"});
                return true;
            }
            if (itemId != C6079R.id.main_view_more_menu_export || openedNotebookKey == null || !FeatureHelper.checkFeatureAvailable(MainViewFragment.this.requireContext(), C6079R.bool.export_enabled)) {
                return false;
            }
            final List<PageKey> pageKeys = MainViewFragment.this.mLibraryRepository.getPageKeys(openedNotebookKey);
            TechnicalLoggerExt.logAction(MainViewFragment.this.mLogger, MainViewFragment.TAG, "Export folder", new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MainViewFragment.C65531.lambda$onMenuItemSelected$0(openedNotebookKey, pageKeys);
                }
            });
            ExportDialog.newInstance(pageKeys).show(MainViewFragment.this.getParentFragmentManager());
            return true;
        }

        static /* synthetic */ String lambda$onMenuItemSelected$0(NotebookKey notebookKey, List list) {
            return "notebook key=" + notebookKey.uuid() + " page count=" + list.size();
        }
    }

    private void openSyncOnGoingPopup() {
        TechnicalLoggerExt.logAction(this.mLogger, TAG, "Search while syncing");
        new MaterialAlertDialogBuilder(requireContext()).setTitle(C6208R.string.search_notebooks_syncing_title).setMessage(C6208R.string.search_notes_syncing).setNegativeButton(C6208R.string.search_notebooks_syncing_button, (DialogInterface.OnClickListener) null).show();
    }

    @Override // com.myscript.nebo.MainActivityDetailFragment
    public Toolbar getToolbar() {
        return this.mToolbar;
    }

    @Override // com.myscript.nebo.MainActivityDetailFragment
    public boolean onShortcut(Shortcut shortcut) {
        if (shortcut == Shortcut.SEARCH) {
            this.mGridViewModel.openSearch();
            return true;
        }
        if (shortcut != Shortcut.ESCAPE) {
            return false;
        }
        if (!(this.mGridViewModel.getSearchState().getValue() instanceof SearchState.Open)) {
            return true;
        }
        this.mGridViewModel.closeSearch();
        return true;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.MainViewFragment$2 */
    class C65542 implements SelectionMode.Callback {
        C65542() {
        }

        @Override // com.myscript.android.utils.SelectionMode.Callback
        public boolean onCreateSelectionMode(SelectionMode selectionMode, Menu menu) {
            selectionMode.getMenuInflater().inflate(C6079R.menu.page_selection_menu, menu);
            if (!RetailMode.INSTANCE.isEnabled()) {
                return true;
            }
            menu.removeItem(C6079R.id.page_export);
            return true;
        }

        @Override // com.myscript.android.utils.SelectionMode.Callback
        public boolean onPrepareSelectionMode(SelectionMode selectionMode, Menu menu) {
            if (MainViewFragment.this.mSelectionMode == null) {
                return true;
            }
            FolderUIState value = MainViewFragment.this.mGridViewModel.getFolderUIState().getValue();
            if (value == null) {
                return false;
            }
            SelectionModeState selectionModeState = value.getSelectionModeState();
            menu.findItem(C6079R.id.page_share).setEnabled(selectionModeState.getCanShare());
            MenuItem menuItemFindItem = menu.findItem(C6079R.id.page_export);
            if (menuItemFindItem != null) {
                menuItemFindItem.setEnabled(selectionModeState.getCanExport());
            }
            menu.findItem(C6079R.id.page_duplicate).setEnabled(selectionModeState.getCanDuplicate());
            menu.findItem(C6079R.id.page_edit).setEnabled(selectionModeState.getCanEdit());
            menu.findItem(C6079R.id.page_move_selection).setEnabled(selectionModeState.getCanMove());
            menu.findItem(C6079R.id.page_delete_selection).setEnabled(selectionModeState.getCanDelete());
            menu.findItem(C6079R.id.page_select_all).setEnabled(selectionModeState.getCanSelectAll());
            menu.findItem(C6079R.id.page_unselect_all).setEnabled(selectionModeState.getCanUnselectAll());
            int selectedItemCount = selectionModeState.getSelectedItemCount();
            MainViewFragment.this.mSelectionMode.setTitle(MainViewFragment.this.getResources().getQuantityString(C6079R.plurals.note_selected_count, selectedItemCount, Integer.valueOf(selectedItemCount)));
            return true;
        }

        @Override // com.myscript.android.utils.SelectionMode.Callback
        public boolean onSelectionItemClicked(SelectionMode selectionMode, MenuItem menuItem) {
            List<PageKey> selectedPageKeys = MainViewFragment.this.mGridViewModel.getSelectedPageKeys();
            final PageKey pageKey = selectedPageKeys.size() == 1 ? selectedPageKeys.get(0) : null;
            int itemId = menuItem.getItemId();
            if (itemId == C6079R.id.page_share) {
                if (pageKey != null) {
                    PageModel page = MainViewFragment.this.mGridViewModel.getPage(pageKey);
                    String title = page != null ? page.getTitle() : null;
                    if (title == null) {
                        title = "";
                    }
                    SharePageDialog.newInstance(pageKey, title).show(MainViewFragment.this.getParentFragmentManager(), SharePageDialog.TAG);
                }
            } else if (itemId == C6079R.id.page_export) {
                if (!FeatureHelper.checkFeatureAvailable(MainViewFragment.this.requireActivity(), C6079R.bool.export_enabled)) {
                    return false;
                }
                TechnicalLoggerExt.logPagesDetails(MainViewFragment.this.mLogger, MainViewFragment.TAG, "Export pages", selectedPageKeys, MainViewFragment.this.mGridViewModel.getSelectedPages());
                ExportDialog.newInstance(selectedPageKeys).show(MainViewFragment.this.requireActivity().getSupportFragmentManager());
            } else if (itemId == C6079R.id.page_move_selection) {
                MainViewFragment.this.launchNotebookPickerDialog(selectedPageKeys);
            } else if (itemId == C6079R.id.page_delete_selection) {
                MainViewFragment.this.mGridViewModel.moveToTrash(selectedPageKeys);
                AppCompatActivity appCompatActivity = (AppCompatActivity) MainViewFragment.this.requireActivity();
                if (!NewFeatureVisibilityHelper.hasFeatureBeenDiscovered(appCompatActivity, NewFeatureVisibilityHelper.Key.TRASH)) {
                    TrashDiscoverabilityDialogKt.showTrashDiscoverabilityDialog(appCompatActivity);
                }
            } else if (itemId == C6079R.id.page_select_all) {
                MainViewFragment.this.mGridViewModel.selectAll();
            } else if (itemId == C6079R.id.page_unselect_all) {
                MainViewFragment.this.mGridViewModel.deselectAll();
            } else if (itemId == C6079R.id.page_duplicate) {
                if (pageKey != null) {
                    MainViewFragment.this.freemiumLimitationViewModel.tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_GRID_VIEW_DUPLICATE, new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return this.f$0.lambda$onSelectionItemClicked$0(pageKey);
                        }
                    });
                }
            } else if (itemId == C6079R.id.page_edit && pageKey != null) {
                PageModel page2 = MainViewFragment.this.mGridViewModel.getPage(pageKey);
                if (page2 != null && page2.isContainer()) {
                    NoteEditingDialogFragment.newInstance(pageKey).show(MainViewFragment.this.getChildFragmentManager());
                } else {
                    MainViewFragment.this.launchPageTitleDialog(pageKey);
                }
                MainViewFragment.this.finishSelectionMode();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit lambda$onSelectionItemClicked$0(PageKey pageKey) {
            MainViewFragment.this.duplicatePage(pageKey);
            return Unit.INSTANCE;
        }

        @Override // com.myscript.android.utils.SelectionMode.Callback
        public void onDestroySelectionMode(SelectionMode selectionMode) {
            MainViewFragment.this.finishSelectionMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        Intent data = activityResult.getData();
        String stringExtra = data != null ? data.getStringExtra(EditingActivity.PAGE_KEY_ARGUMENT) : null;
        handleEditingActivityResult(resultCode, stringExtra != null ? PageKey.deserialize(stringExtra) : null, activityResult.getResultCode() == 40, activityResult.getResultCode() == 41);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Uri uri) {
        if (uri != null) {
            ((MainActivity) requireActivity()).handleNeboFileImport(uri);
        }
    }

    public static MainViewFragment newInstance() {
        return new MainViewFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        ComponentCallbacks2 application = fragmentActivityRequireActivity.getApplication();
        this.mLogger = ((TechnicalLoggerProvider) application).provideTechnicalLogger();
        this.mMainViewModel = (MainViewModel) new ViewModelProvider(fragmentActivityRequireActivity, MainViewModel.Factory).get(MainViewModel.class);
        this.freemiumLimitationViewModel = (FreemiumLimitationViewModel) new ViewModelProvider(fragmentActivityRequireActivity, FreemiumLimitationViewModel.Factory).get(FreemiumLimitationViewModel.class);
        this.mLibraryRepository = ((LibraryRepository.Provider) application).provideLibraryRepository();
        this.mGridViewModel = (GridViewModel) new ViewModelProvider(fragmentActivityRequireActivity, GridViewModel.Factory).get(GridViewModel.class);
        this.mBannerViewModel = (BannerViewModel) new ViewModelProvider(fragmentActivityRequireActivity).get(BannerViewModel.class);
        this.mLanguageViewModel = (LanguageViewModel) new ViewModelProvider(fragmentActivityRequireActivity, new LanguageViewModel.Factory(new LanguageNameHelper(LocaleExt.getPrimaryLocale(getResources().getConfiguration())), ((ISuggestedLanguagesProvider) application).provideSuggestedLanguages())).get(LanguageViewModel.class);
        getChildFragmentManager().setFragmentResultListener(NoteNameDialog.REQUEST_KEY, this, new FragmentResultListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda37
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle2) {
                this.f$0.lambda$onCreate$2(str, bundle2);
            }
        });
        FragmentManager parentFragmentManager = getParentFragmentManager();
        parentFragmentManager.setFragmentResultListener(FolderPickerDialog.MOVE_PAGES_REQUEST_KEY, this, new FragmentResultListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda38
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle2) {
                this.f$0.lambda$onCreate$3(str, bundle2);
            }
        });
        parentFragmentManager.setFragmentResultListener(NoteCreationDialogFragment.REQUEST_KEY, this, new FragmentResultListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda39
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle2) {
                this.f$0.lambda$onCreate$4(str, bundle2);
            }
        });
        parentFragmentManager.setFragmentResultListener(DownloadLanguageDialogFragment.REQUEST_KEY, this, new FragmentResultListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda40
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle2) {
                this.f$0.lambda$onCreate$5(str, bundle2);
            }
        });
        parentFragmentManager.setFragmentResultListener(ExportDialog.REQUEST_KEY, this, new FragmentResultListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda41
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle2) {
                this.f$0.lambda$onCreate$6(str, bundle2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(String str, Bundle bundle) {
        String string = bundle.getString("PAGE_KEY_KEY", null);
        String string2 = bundle.getString(NoteNameDialog.NOTE_NAME_KEY, null);
        if (string == null || string2 == null) {
            return;
        }
        onPageTitleChanged(PageKey.deserialize(string), string2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(String str, Bundle bundle) {
        onTargetFolderSelectionResult(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(String str, Bundle bundle) {
        onNoteCreationRequest(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(String str, Bundle bundle) {
        onMissingLanguageDownloaded(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(String str, Bundle bundle) {
        if (bundle.getInt("RESULT_KEY") == 0) {
            this.mGridViewModel.activatePagesSelectionMode(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.main_view_fragment, viewGroup, false);
        this.mToolbar = (Toolbar) viewInflate.findViewById(C6079R.id.main_activity_toolbar);
        AppCompatActivity appCompatActivity = (AppCompatActivity) requireActivity();
        appCompatActivity.setSupportActionBar(this.mToolbar);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        this.mSearchView = (GridSearchView) viewInflate.findViewById(C6079R.id.main_search_view);
        BannerLayout bannerLayout = (BannerLayout) viewInflate.findViewById(C6079R.id.main_view_banner);
        this.mBannerLayout = bannerLayout;
        bannerLayout.setCallback(this.mBannerViewModel);
        ComposeView composeView = (ComposeView) viewInflate.findViewById(C6079R.id.grid_sort_component);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        NotesDisplayControlsKt.setNotesDisplayControlsContent(composeView, this.mGridViewModel);
        View viewFindViewById = viewInflate.findViewById(C6079R.id.main_empty_state);
        this.mEmptyState = viewFindViewById;
        viewFindViewById.setVisibility(8);
        this.mEmptyStateImage = (ImageView) viewInflate.findViewById(C6079R.id.main_empty_state_image);
        this.mEmptyStateTitle = (TextView) viewInflate.findViewById(C6079R.id.main_empty_state_title);
        this.mEmptyStateSubtitle = (TextView) viewInflate.findViewById(C6079R.id.main_empty_state_subtitle);
        this.mLoadingProgress = viewInflate.findViewById(C6079R.id.main_view_loading_progress);
        this.mAddPageButton = (FloatingActionButtonMenu) viewInflate.findViewById(C6079R.id.main_add_page_button);
        FreemiumBannerView freemiumBannerView = (FreemiumBannerView) viewInflate.findViewById(C6079R.id.pages_counter_view);
        this.mFreemiumBanner = freemiumBannerView;
        freemiumBannerView.setActionButtonListener(new View.OnClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onCreateView$7(view);
            }
        });
        RenewalOfferBannerView renewalOfferBannerView = (RenewalOfferBannerView) viewInflate.findViewById(C6079R.id.renewal_offer_banner);
        this.mRenewalBanner = renewalOfferBannerView;
        renewalOfferBannerView.setOnCtaClickListener(new Runnable() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCreateView$8();
            }
        });
        this.mDiscoverabilityTooltip = (ComposeView) viewInflate.findViewById(C6079R.id.discoverability_tooltip);
        ComposeView composeView2 = (ComposeView) viewInflate.findViewById(C6079R.id.pre_rating_view);
        this.mPreRatingView = composeView2;
        composeView2.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$7(View view) {
        this.mGridViewModel.onBannerActionButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$8() {
        this.mGridViewModel.onBannerActionButtonClicked();
    }

    private void showFolderGridView() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(GridViewFragment.TAG);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = GridViewFragment.newInstance();
        }
        childFragmentManager.beginTransaction().setCustomAnimations(R.anim.fade_in, 0).replace(C6079R.id.folder_view_fragment_container, fragmentFindFragmentByTag, GridViewFragment.TAG).commit();
    }

    private void showFolderListView() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Fragment fragmentFindFragmentByTag = childFragmentManager.findFragmentByTag(ListViewFragment.TAG);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = ListViewFragment.newInstance();
        }
        childFragmentManager.beginTransaction().setCustomAnimations(R.anim.fade_in, 0).replace(C6079R.id.folder_view_fragment_container, fragmentFindFragmentByTag, ListViewFragment.TAG).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$9(ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            this.mMainViewModel.showPaywall(PaywallOrigin.GridViewBanner);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        requireActivity().addMenuProvider(this.mMenuProvider, viewLifecycleOwner, Lifecycle.State.RESUMED);
        this.mGridViewModel.getFolderUIState().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda16
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.bindNotebookUI((FolderUIState) obj);
            }
        });
        LiveData<List<String>> history = this.mGridViewModel.getHistory();
        final GridSearchView gridSearchView = this.mSearchView;
        Objects.requireNonNull(gridSearchView);
        history.observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda24
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                gridSearchView.updateSearchHistory((List) obj);
            }
        });
        this.mGridViewModel.getSearchState().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda25
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.bindSearchView((SearchState) obj);
            }
        });
        this.mGridViewModel.getStorageState().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda26
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.onStorageStateChanged((StorageState) obj);
            }
        });
        this.mGridViewModel.getOpenPageEvent().observe(this, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda27
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.onOpenPageEvent((GridViewModel.OpenPageEvent) obj);
            }
        });
        this.mGridViewModel.getTooRecentNoteEvent().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda28
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.onTooRecentNoteEvent((Void) obj);
            }
        });
        this.mGridViewModel.getMissingLanguageEvent().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda29
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.onMissingLanguageEvent((GridViewModel.MissingLanguageEvent) obj);
            }
        });
        this.mGridViewModel.getGridBannerState().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda30
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.onBannerStateChanged((GridBannerState) obj);
            }
        });
        this.mGridViewModel.getScrollToPageEvent().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda31
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.scrollToPage((PageKey) obj);
            }
        });
        this.mMainViewModel.isDetailFragmentAvailable().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda32
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.availabilityChanged(((Boolean) obj).booleanValue());
            }
        });
        LiveData<Banner> currentPermanentBanner = this.mBannerViewModel.getCurrentPermanentBanner();
        final BannerLayout bannerLayout = this.mBannerLayout;
        Objects.requireNonNull(bannerLayout);
        currentPermanentBanner.observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda17
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bannerLayout.permanentBannerChanged((Banner) obj);
            }
        });
        LiveData<Banner> currentTransientBanner = this.mBannerViewModel.getCurrentTransientBanner();
        final BannerLayout bannerLayout2 = this.mBannerLayout;
        Objects.requireNonNull(bannerLayout2);
        currentTransientBanner.observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda18
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                bannerLayout2.transientBannerChanged((Banner) obj);
            }
        });
        this.mLanguageViewModel.getLanguages().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda19
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.onLanguagesUpdated((List) obj);
            }
        });
        this.mGridViewModel.getShowPaywallEvent().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda20
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onViewCreated$10((Boolean) obj);
            }
        });
        this.mGridViewModel.getShowSignIn().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda21
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onViewCreated$11((Boolean) obj);
            }
        });
        this.mMainViewModel.getShowPreRating().observe(viewLifecycleOwner, new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.onPreRating((PreRatingFilterState) obj);
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$10(Boolean bool) {
        if (bool.booleanValue()) {
            GridBannerState value = this.mGridViewModel.getGridBannerState().getValue();
            this.mMainViewModel.showPaywall(value != null && value.getStatus() == UserStatus.RenewalOffer ? PaywallOrigin.RenewalOffer : PaywallOrigin.GridViewBanner);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$11(Boolean bool) {
        if (bool.booleanValue()) {
            this.loginActivityLauncher.launch(LoginActivityHelperKt.getLoginActivityIntent(requireActivity()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToPage(PageKey pageKey) {
        if (pageKey == null) {
            return;
        }
        ActivityResultCaller activityResultCallerFindFragmentById = getChildFragmentManager().findFragmentById(C6079R.id.folder_view_fragment_container);
        if (activityResultCallerFindFragmentById instanceof INotesViewFragment) {
            ((INotesViewFragment) activityResultCallerFindFragmentById).smoothScrollTo(pageKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTooRecentNoteEvent(Void r3) {
        new MaterialAlertDialogBuilder(requireContext()).setTitle(C6079R.string.too_recent_content_alert_dialog_title).setMessage(C6079R.string.too_recent_note_alert_dialog_message).setPositiveButton(C6079R.string.too_recent_content_alert_dialog_check_for_update_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda50
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$onTooRecentNoteEvent$12(dialogInterface, i);
            }
        }).setNegativeButton(C6079R.string.too_recent_content_alert_dialog_check_later_button, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTooRecentNoteEvent$12(DialogInterface dialogInterface, int i) {
        PlatformUtils.openPlayStore(requireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLanguagesUpdated(List<LanguageManagerItem> list) {
        this.mGridViewModel.installedLanguagesUpdated();
        List<String> installedLanguageKeys = this.mLanguageViewModel.getInstalledLanguageKeys();
        LibraryRepository libraryRepository = this.mLibraryRepository;
        if (libraryRepository != null) {
            libraryRepository.checkLastChosenLanguage(installedLanguageKeys);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mSearchView.setOnSearchIconClicked(new View.OnClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onStart$13(view);
            }
        });
        this.mSearchView.setOnCloseButtonClicked(new View.OnClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$onStart$14(view);
            }
        });
        this.mSearchView.setOnHistoryItemClickListener(new OnHistoryItemClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda9
            @Override // com.myscript.nebo.grid.OnHistoryItemClickListener
            public final void onHistoryItemClicked(String str, boolean z) {
                this.f$0.lambda$onStart$15(str, z);
            }
        });
        this.mSearchView.setOnSearchTriggered(new OnSearchTriggeredListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda10
            @Override // com.myscript.nebo.grid.OnSearchTriggeredListener
            public final boolean onSearchTriggered(String str) {
                return this.f$0.lambda$onStart$16(str);
            }
        });
        this.mAddPageButton.setListener(new FloatingActionButtonMenu.OnMenuItemClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda12
            @Override // com.myscript.android.utils.FloatingActionButtonMenu.OnMenuItemClickListener
            public final void onMenuItemClick(MenuItem menuItem) {
                this.f$0.lambda$onStart$19(menuItem);
            }
        });
        TextViewExt.clearLastHoveredView(this.mEmptyStateTitle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$13(View view) {
        LibraryRepository libraryRepository = this.mLibraryRepository;
        if (libraryRepository != null && libraryRepository.isCloudSyncOngoing()) {
            openSyncOnGoingPopup();
        } else {
            this.mGridViewModel.openSearch();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$14(View view) {
        this.mGridViewModel.closeSearch(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$15(String str, boolean z) {
        if (z) {
            this.mGridViewModel.clearHistory();
        } else {
            this.mGridViewModel.search(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onStart$16(String str) {
        return this.mGridViewModel.search(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStart$19(MenuItem menuItem) {
        boolean zHasNotebookOpen = this.mGridViewModel.hasNotebookOpen();
        int itemId = menuItem.getItemId();
        if (itemId == C6079R.id.action_text_page && zHasNotebookOpen) {
            this.freemiumLimitationViewModel.tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_GRID_CREATE_BUTTON, new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onStart$17();
                }
            });
            return;
        }
        if (itemId == C6079R.id.action_raw_content_page && zHasNotebookOpen) {
            this.freemiumLimitationViewModel.tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_GRID_CREATE_BUTTON, new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onStart$18();
                }
            });
            return;
        }
        if (itemId == C6079R.id.action_notebook && zHasNotebookOpen) {
            NoteCreationDialogFragment.newInstance(NoteType.Notebook).show(getParentFragmentManager());
        } else if (itemId == C6079R.id.action_pdf_import) {
            ((MainActivity) requireActivity()).launchImport();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onStart$17() {
        NoteCreationDialogFragment.newInstance(NoteType.Document).show(getParentFragmentManager());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onStart$18() {
        NoteCreationDialogFragment.newInstance(NoteType.Board).show(getParentFragmentManager());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpenPageEvent(GridViewModel.OpenPageEvent openPageEvent) {
        this.mEditingLauncher.launch(EditingActivity.getPageIntent(requireActivity(), openPageEvent.getPageKey(), openPageEvent.getContentType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMissingLanguageEvent(GridViewModel.MissingLanguageEvent missingLanguageEvent) {
        NeboNetworkState value = ((NeboNetworkStateRepositoryProvider) requireActivity().getApplication()).provideNeboNetworkStateRepository().getNeboNetworkState().getValue();
        if (value != null && value.isDataTransferAllowed()) {
            DownloadLanguageDialogFragment.newInstance(missingLanguageEvent.getPageKey(), missingLanguageEvent.getLanguageTag()).show(getParentFragmentManager());
        } else {
            new MaterialAlertDialogBuilder(requireContext()).setTitle(C6079R.string.download_language_no_internet_title).setMessage(C6079R.string.download_language_no_internet_message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda49
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void availabilityChanged(boolean z) {
        this.mGridViewModel.setViewAvailable(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBannerStateChanged(GridBannerState gridBannerState) {
        boolean z = gridBannerState.getStatus() == UserStatus.RenewalOffer;
        this.mRenewalBanner.setRemainingHours(gridBannerState.getRenewalOfferRemainingHours());
        this.mRenewalBanner.setVisibility((z && gridBannerState.isVisible()) ? 0 : 8);
        if (z) {
            this.mFreemiumBanner.setVisibility(false);
        } else {
            this.mFreemiumBanner.updateState(gridBannerState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreRating(PreRatingFilterState preRatingFilterState) {
        if (preRatingFilterState.getShow()) {
            ComposeViewManager.INSTANCE.setComposableContent(this.mPreRatingView, new RatingInviteDialogImpl(preRatingFilterState.getAnalyticsOrigin(), new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onPreRating$21();
                }
            }, new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onPreRating$22();
                }
            }, new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda33
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$onPreRating$24();
                }
            }));
            this.mPreRatingView.setVisibility(0);
        } else {
            this.mPreRatingView.setContent(null);
            this.mPreRatingView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onPreRating$21() {
        this.mMainViewModel.dismissPreRating();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onPreRating$22() {
        this.mMainViewModel.preRatingFilterNeedsWork();
        new FeedBackDialog().show(getParentFragmentManager());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onPreRating$24() {
        this.mMainViewModel.preRatingLoveIt();
        final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(requireActivity());
        reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$onPreRating$23(reviewManagerCreate, task);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPreRating$23(ReviewManager reviewManager, Task task) {
        if (task.isSuccessful()) {
            reviewManager.launchReviewFlow(requireActivity(), (ReviewInfo) task.getResult());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindNotebookUI(FolderUIState folderUIState) {
        SelectionMode selectionMode;
        ActionBar supportActionBar = ((AppCompatActivity) requireActivity()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(folderUIState.getFolderName());
        }
        if (folderUIState.getSelectionModeState().isSelectionMode()) {
            SelectionMode selectionMode2 = this.mSelectionMode;
            if (selectionMode2 == null) {
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                this.mSelectionMode = SelectionMode.startSelectionMode(fragmentActivityRequireActivity, (ViewGroup) fragmentActivityRequireActivity.findViewById(C6079R.id.toolbar_container), this.mSelectionModeCallback);
                TechnicalLoggerExt.logAction(this.mLogger, TAG, "Selection mode started", new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return this.f$0.lambda$bindNotebookUI$25();
                    }
                });
                this.mSelectionMode.invalidate();
            } else {
                selectionMode2.invalidate();
            }
        } else if (!folderUIState.getSelectionModeState().isSelectionMode() && (selectionMode = this.mSelectionMode) != null) {
            selectionMode.finish();
            TechnicalLoggerExt.logAction(this.mLogger, TAG, "Selection mode stopped", new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$bindNotebookUI$26();
                }
            });
            this.mSelectionMode = null;
        }
        updateAddButtonState(folderUIState.getCanModify());
        EmptyState emptyState = folderUIState.getEmptyState();
        this.mEmptyState.setVisibility(emptyState.getIsShown() ? 0 : 8);
        if (!(emptyState instanceof EmptyState.NotEmpty)) {
            this.mEmptyStateImage.setImageDrawable(AppCompatResources.getDrawable(requireContext(), emptyState.getImageResource()));
            this.mEmptyStateTitle.setText(emptyState.getTitleResource());
            if (emptyState instanceof EmptyState.EmptySearch) {
                EmptyState.EmptySearch emptySearch = (EmptyState.EmptySearch) emptyState;
                this.mEmptyStateSubtitle.setText(getString(C6079R.string.pages_grid_no_search_result_subtext, emptySearch.getSearchLabel(), emptySearch.getNotebookName()));
            } else if (emptyState.getSubtitleResource() != 0) {
                this.mEmptyStateSubtitle.setText(emptyState.getSubtitleResource());
                this.mEmptyStateSubtitle.setVisibility(0);
            } else {
                this.mEmptyStateSubtitle.setText("");
                this.mEmptyStateSubtitle.setVisibility(8);
            }
        }
        this.mLoadingProgress.setVisibility(folderUIState.isLoading() ? 0 : 8);
        updateCorruptedBanner(folderUIState.getNotebookKey(), folderUIState.getFolderState() == FolderState.Loaded, folderUIState.getHasCorrupted());
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(C6079R.id.folder_view_fragment_container);
        if (folderUIState.getDisplayMode() instanceof DisplayMode.List) {
            if (!(fragmentFindFragmentById instanceof ListViewFragment) || !fragmentFindFragmentById.isVisible()) {
                showFolderListView();
            }
        } else if (!(fragmentFindFragmentById instanceof GridViewFragment) || !fragmentFindFragmentById.isVisible()) {
            showFolderGridView();
        }
        this.mMainViewModel.getDiscoveryTooltip().observe(getViewLifecycleOwner(), new Observer() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda45
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.updateTooltip((TooltipUIState) obj);
            }
        });
        requireActivity().invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$bindNotebookUI$25() {
        return this.mSelectionMode.getClass().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$bindNotebookUI$26() {
        return this.mSelectionMode.getClass().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTooltip(TooltipUIState tooltipUIState) {
        if (tooltipUIState == null || tooltipUIState.getUserData() == null || !(tooltipUIState.getUserData() instanceof GridDiscoverableFeature.DiscoverableFeatureDestination) || tooltipUIState.getUserData() != GridDiscoverableFeature.DiscoverableFeatureDestination.MAIN_FRAGMENT) {
            tooltipUIState = null;
        }
        if (tooltipUIState != null && tooltipUIState.getId() == GridDiscoverableFeatureKt.getGridDiscoverableFeatures().indexOf(GridDiscoverableFeature.AddNoteFeature.INSTANCE) && this.mAddPageButton.fabRectLocationInWindow().isEmpty()) {
            return;
        }
        ComposeViewManager.INSTANCE.setComposableContent(this.mDiscoverabilityTooltip, new TooltipComposableProviderImpl(tooltipUIState, this.mAddPageButton.fabRectLocationInWindow(), new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$updateTooltip$27();
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$updateTooltip$27() {
        this.mMainViewModel.dismissCurrentTooltip();
        return Unit.INSTANCE;
    }

    private void updateAddButtonState(boolean z) {
        this.mAddPageButton.setEnabled(z);
        this.mAddPageButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$updateAddButtonState$28(view);
            }
        });
        if (z) {
            this.mAddPageButton.show();
        } else {
            this.mAddPageButton.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateAddButtonState$28(View view) {
        this.mMainViewModel.discover(GridDiscoverableFeature.AddNoteFeature.INSTANCE);
        this.mAddPageButton.toggleMenuVisibility();
    }

    private void onNoteCreationRequest(Bundle bundle) {
        NoteCreationDialogFragment.Result Result = NoteCreationDialogFragment.Result(bundle);
        if (Result instanceof NoteCreationDialogFragment.Result.Notebook) {
            NoteCreationDialogFragment.Result.Notebook notebook = (NoteCreationDialogFragment.Result.Notebook) Result;
            this.mGridViewModel.addNotebook(Result.getName(), Result.getLanguage(), notebook.getCoverColors(), notebook.getPaperSize(), notebook.getPageColor(), notebook.getPagePattern());
        } else if (Result instanceof NoteCreationDialogFragment.Result.Document) {
            this.mGridViewModel.addDocument(Result.getName(), Result.getLanguage(), ((NoteCreationDialogFragment.Result.Document) Result).getPageColor());
        } else if (Result instanceof NoteCreationDialogFragment.Result.Board) {
            NoteCreationDialogFragment.Result.Board board = (NoteCreationDialogFragment.Result.Board) Result;
            this.mGridViewModel.addBoard(Result.getName(), Result.getLanguage(), board.getPageColor(), board.getPagePattern());
        }
    }

    private void onMissingLanguageDownloaded(Bundle bundle) {
        String string;
        if (!bundle.getBoolean(DownloadLanguageDialogFragment.SUCCESS_RESULT_KEY, false) || (string = bundle.getString(DownloadLanguageDialogFragment.NOTEKEY_RESULT_KEY)) == null || MainViewFragment$$ExternalSyntheticBackport0.m1066m(string)) {
            return;
        }
        this.mGridViewModel.openPage(PageKey.deserialize(string));
    }

    void launchNotebookPickerDialog(List<PageKey> list) {
        if (list.isEmpty() || this.mGridViewModel.getFolderUIState().getValue() == null) {
            return;
        }
        FolderPickerDialog.toMovePages(list).show(getParentFragmentManager());
    }

    private void onTargetFolderSelectionResult(Bundle bundle) {
        if (bundle.getInt("RESULT_KEY") == 0) {
            FolderPickerDialog.Result.PagesMove pagesMove = (FolderPickerDialog.Result.PagesMove) FolderPickerDialog.Result(bundle);
            List<? extends PageKey> listFilter = CollectionsKt.filter(pagesMove.getPageKeys(), new Function1() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(((PageKey) obj).isValid());
                }
            });
            NotebookKey notebookKey = pagesMove.getNotebookKey();
            if (listFilter.isEmpty() || notebookKey == null || !notebookKey.isValid()) {
                return;
            }
            this.mGridViewModel.movePages(listFilter, notebookKey);
        }
    }

    void launchPageTitleDialog(PageKey pageKey) {
        PageModel page = this.mGridViewModel.getPage(pageKey);
        if (page != null) {
            NoteNameDialog.newInstance(pageKey, page.getTitle()).show(getChildFragmentManager());
        }
    }

    private void onPageTitleChanged(PageKey pageKey, String str) {
        this.mGridViewModel.updatePageTitle(pageKey, str);
    }

    public void finishSelectionMode() {
        this.mGridViewModel.activatePagesSelectionMode(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GridSearchView gridSearchView = this.mSearchView;
        if (gridSearchView != null) {
            gridSearchView.setOnSearchIconClicked(null);
            this.mSearchView.setOnSearchTriggered(null);
            this.mSearchView.setOnCloseButtonClicked(null);
            this.mSearchView.setOnHistoryItemClickListener(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ViewTreeObserver viewTreeObserver;
        View view = getView();
        if (view != null && (viewTreeObserver = view.getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.globalLayoutListener);
        }
        this.mSearchView = null;
        this.mAddPageButton.setListener(null);
        this.mAddPageButton.setOnClickListener(null);
        requireActivity().removeMenuProvider(this.mMenuProvider);
        this.mFreemiumBanner.setActionButtonListener(null);
        this.mRenewalBanner.setOnCtaClickListener(null);
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mBannerViewModel != null) {
            this.mBannerLayout.setCallback(null);
            this.mBannerViewModel = null;
        }
        this.mLibraryRepository = null;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duplicatePage(PageKey pageKey) {
        this.mGridViewModel.duplicatePage(pageKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindSearchView(SearchState searchState) {
        if (searchState instanceof SearchState.Open) {
            TechnicalLoggerExt.logAction(this.mLogger, TAG, "Open Search");
            this.mSearchView.open(true);
        } else if (searchState instanceof SearchState.Searching) {
            TechnicalLoggerExt.logAction(this.mLogger, TAG, "Search", new Function0() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$bindSearchView$29();
                }
            });
            this.mSearchView.searchUpdated();
        } else if (searchState instanceof SearchState.Closed) {
            TechnicalLoggerExt.logAction(this.mLogger, TAG, "Close Search");
            this.mSearchView.close();
        } else {
            throw new IllegalArgumentException("Unknown search state");
        }
        requireActivity().invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$bindSearchView$29() {
        return "query='" + this.mGridViewModel.getSearchQuery() + "'";
    }

    public void onDiscardSearch() {
        this.mGridViewModel.stopSearch();
    }

    public void closeSearchIfNotStarted() {
        if (this.mGridViewModel.getSearchState().getValue() instanceof SearchState.Open) {
            this.mGridViewModel.closeSearch();
        }
    }

    private String getNotebookCorruptedBannerId(NotebookKey notebookKey) {
        return "MainActivity.BANNER_ID_CORRUPTED_PAGE." + notebookKey.uuid();
    }

    private void updateCorruptedBanner(NotebookKey notebookKey, boolean z, boolean z2) {
        if (this.mGridViewModel.hasNotebookOpen() && z && notebookKey != null) {
            String notebookCorruptedBannerId = getNotebookCorruptedBannerId(notebookKey);
            if (z2) {
                this.mBannerViewModel.push(new Banner.CorruptedBanner(notebookCorruptedBannerId, getString(C6079R.string.corrupted_banner_notes_message), Type.PERMANENT, getString(C6079R.string.corrupted_banner_contact_support), new Runnable() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda44
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$updateCorruptedBanner$30();
                    }
                }), true);
            } else {
                this.mBannerViewModel.dismiss(Priority.FORBIDDEN, false);
                this.mBannerViewModel.dismiss(Priority.CORRUPTED, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateCorruptedBanner$30() {
        SupportUtilsKt.openSupportWebsite(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStorageStateChanged(StorageState storageState) {
        if (storageState instanceof StorageState.Critical) {
            this.mBannerViewModel.dismiss(BANNER_ID_STORAGE_WARNING);
            BannerViewModel.removeBannerFromBlackList(BANNER_ID_STORAGE_WARNING);
            if (this.mGridViewModel.hasStoragePopupBeenShown()) {
                return;
            }
            logStorageAnalytics(true, Long.valueOf(storageState.getAvailableSpace()));
            AlertDialog alertDialog = this.mCriticalStoragePopup;
            if (alertDialog == null) {
                MaterialAlertDialogBuilder onDismissListener = new MaterialAlertDialogBuilder(requireContext()).setTitle(C6079R.string.popup_low_storage_title).setMessage(C6079R.string.popup_low_storage_message).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).setCancelable(false).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda46
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f$0.lambda$onStorageStateChanged$31(dialogInterface);
                    }
                });
                onDismissListener.setPositiveButton(C6079R.string.popup_low_storage_setting, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda47
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onStorageStateChanged$32(dialogInterface, i);
                    }
                });
                this.mCriticalStoragePopup = onDismissListener.create();
                return;
            } else {
                if (alertDialog.isShowing()) {
                    return;
                }
                this.mCriticalStoragePopup.show();
                return;
            }
        }
        if (storageState instanceof StorageState.Low) {
            this.mGridViewModel.setStoragePopupSeen(false);
            Banner value = this.mBannerViewModel.getCurrentPermanentBanner().getValue();
            if (value == null || !value.getId().equals(BANNER_ID_STORAGE_WARNING)) {
                logStorageAnalytics(false, Long.valueOf(storageState.getAvailableSpace()));
            }
            this.mBannerViewModel.push(new Banner.WarningBanner(BANNER_ID_STORAGE_WARNING, getString(C6079R.string.banner_low_storage_message), Type.PERMANENT, getString(C6079R.string.banner_low_storage_setting), new Runnable() { // from class: com.myscript.nebo.grid.MainViewFragment$$ExternalSyntheticLambda48
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onStorageStateChanged$33();
                }
            }), true);
            return;
        }
        this.mBannerViewModel.dismiss(BANNER_ID_STORAGE_WARNING);
        BannerViewModel.removeBannerFromBlackList(BANNER_ID_STORAGE_WARNING);
        this.mGridViewModel.setStoragePopupSeen(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStorageStateChanged$31(DialogInterface dialogInterface) {
        this.mGridViewModel.setStoragePopupSeen(true);
        this.mCriticalStoragePopup = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStorageStateChanged$32(DialogInterface dialogInterface, int i) {
        startActivity(new Intent("android.os.storage.action.MANAGE_STORAGE"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStorageStateChanged$33() {
        startActivity(new Intent("android.os.storage.action.MANAGE_STORAGE"));
    }

    private void logStorageAnalytics(boolean z, Long l) {
        AnalyticsController.logDevAnalytics("low_storage", StorageKt.getStorageAnalytics(z, l.longValue()));
    }

    public void handleEditingActivityResult(int i, PageKey pageKey, boolean z, boolean z2) {
        this.mGridViewModel.closePage();
        if (pageKey != null) {
            if (z) {
                NotebookKey openedNotebookKey = this.mGridViewModel.getOpenedNotebookKey();
                if (openedNotebookKey != null) {
                    BannerViewModel.removeBannerFromBlackList(getNotebookCorruptedBannerId(openedNotebookKey));
                }
                this.mMainViewModel.saveCorruptPage();
            } else {
                BannerViewModel.removeBannerFromBlackList("MainActivity.BANNER_ID_CORRUPTED_PAGE." + pageKey.hashCode());
                this.mMainViewModel.requestPreRatingFilterAfterClosingANote();
            }
            ActivityResultCaller activityResultCallerFindFragmentById = getChildFragmentManager().findFragmentById(C6079R.id.folder_view_fragment_container);
            if (activityResultCallerFindFragmentById instanceof INotesViewFragment) {
                ((INotesViewFragment) activityResultCallerFindFragmentById).smoothScrollTo(pageKey);
            }
        }
        ApplicationState applicationStateProvideApplicationState = ((IApplicationStateProvider) requireActivity().getApplication()).provideApplicationState();
        if (i == -1) {
            String noteCrashCountKey = applicationStateProvideApplicationState.getNoteCrashCountKey();
            if (z2 || noteCrashCountKey == null) {
                return;
            }
            applicationStateProvideApplicationState.resetCrashCount(noteCrashCountKey);
        }
    }

    void stopLongPressTimer() {
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(C6079R.id.folder_view_fragment_container);
        if (fragmentFindFragmentById instanceof GridViewFragment) {
            ((GridViewFragment) fragmentFindFragmentById).stopLongPressTimer();
        }
    }
}
