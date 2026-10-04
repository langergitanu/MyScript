package com.myscript.nebo.trash.p033ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.Navigator;
import com.myscript.android.utils.NestedFragment;
import com.myscript.android.utils.SelectionMode;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.expandlist.DmsSimpleAdapter;
import com.myscript.nebo.grid.MainViewModel;
import com.myscript.nebo.trash.TrashViewModel;
import com.myscript.nebo.trash.TrashedCollectionsUIState;
import com.myscript.snt.core.CollectionKey;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TrashedNotebooksFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 H2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001HB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020*H\u0016J\u0010\u00106\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0002J\u0018\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\u0006\u0010+\u001a\u00020,H\u0016J\u001a\u0010<\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010=\u001a\u00020&2\u0006\u0010:\u001a\u00020;2\b\u0010>\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010?\u001a\u00020*2\u0006\u0010:\u001a\u00020;H\u0016J\u0018\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020CH\u0002J\u001e\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020\u00072\f\u0010F\u001a\b\u0012\u0004\u0012\u00020*0GH\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, m1599d2 = {"Lcom/myscript/nebo/trash/ui/TrashedNotebooksFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/android/utils/NestedFragment;", "Lcom/myscript/android/utils/SelectionMode$Callback;", "<init>", "()V", "titleRes", "", "getTitleRes", "()I", "menuRes", "getMenuRes", "navigator", "Lcom/myscript/android/utils/Navigator;", "getNavigator", "()Lcom/myscript/android/utils/Navigator;", "setNavigator", "(Lcom/myscript/android/utils/Navigator;)V", "mainViewModel", "Lcom/myscript/nebo/grid/MainViewModel;", "getMainViewModel", "()Lcom/myscript/nebo/grid/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "trashViewModel", "Lcom/myscript/nebo/trash/TrashViewModel;", "getTrashViewModel", "()Lcom/myscript/nebo/trash/TrashViewModel;", "trashViewModel$delegate", "trashList", "Landroidx/recyclerview/widget/RecyclerView;", "trashAdapter", "Lcom/myscript/nebo/dms/expandlist/DmsSimpleAdapter;", "emptyState", "Landroidx/constraintlayout/widget/Group;", "loadingProgress", "Landroid/widget/ProgressBar;", "onMenuItemClicked", "", "menuItem", "Landroid/view/MenuItem;", "onPrepareOptionsMenu", "", "menu", "Landroid/view/Menu;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onTrashStateChanged", "state", "Lcom/myscript/nebo/trash/TrashedCollectionsUIState;", "onCreateSelectionMode", "mode", "Lcom/myscript/android/utils/SelectionMode;", "onPrepareSelectionMode", "onSelectionItemClicked", "item", "onDestroySelectionMode", "showCollectionMoreMenu", "anchor", "collectionKey", "Lcom/myscript/snt/core/CollectionKey;", "displayDeleteConfirmationDialog", "itemsToDeleteCount", "deleteAction", "Lkotlin/Function0;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TrashedNotebooksFragment extends Fragment implements NestedFragment, SelectionMode.Callback {
    public static final String TAG = "TrashedNotebooksFragment";
    private Group emptyState;
    private ProgressBar loadingProgress;

    /* JADX INFO: renamed from: mainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mainViewModel;
    private Navigator navigator;
    private DmsSimpleAdapter trashAdapter = new DmsSimpleAdapter(new Function1() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return TrashedNotebooksFragment.trashAdapter$lambda$0(this.f$0, (FolderModel) obj);
        }
    }, new Function1() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return TrashedNotebooksFragment.trashAdapter$lambda$1(this.f$0, (FolderModel) obj);
        }
    }, new Function1() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return Boolean.valueOf(TrashedNotebooksFragment.trashAdapter$lambda$2(this.f$0, (FolderModel) obj));
        }
    }, new Function2() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return TrashedNotebooksFragment.trashAdapter$lambda$3(this.f$0, (View) obj, (CollectionKey) obj2);
        }
    });
    private RecyclerView trashList;

    /* JADX INFO: renamed from: trashViewModel$delegate, reason: from kotlin metadata */
    private final Lazy trashViewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final TrashedNotebooksFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public TrashedNotebooksFragment() {
        final TrashedNotebooksFragment trashedNotebooksFragment = this;
        final Function0 function0 = null;
        this.mainViewModel = FragmentViewModelLazyKt.createViewModelLazy(trashedNotebooksFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return trashedNotebooksFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? trashedNotebooksFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainViewModel.Factory;
            }
        });
        this.trashViewModel = FragmentViewModelLazyKt.createViewModelLazy(trashedNotebooksFragment, Reflection.getOrCreateKotlinClass(TrashViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return trashedNotebooksFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? trashedNotebooksFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TrashedNotebooksFragment.trashViewModel_delegate$lambda$0();
            }
        });
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getTitleRes() {
        return C6208R.string.trash;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public int getMenuRes() {
        return C6079R.menu.side_trash;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public Navigator getNavigator() {
        return this.navigator;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel.getValue();
    }

    private final TrashViewModel getTrashViewModel() {
        return (TrashViewModel) this.trashViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory trashViewModel_delegate$lambda$0() {
        return TrashViewModel.INSTANCE.getFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trashAdapter$lambda$0(TrashedNotebooksFragment trashedNotebooksFragment, FolderModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (trashedNotebooksFragment.getTrashViewModel().onFolderClicked(it)) {
            trashedNotebooksFragment.getMainViewModel().closeNavigationDrawer();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trashAdapter$lambda$1(TrashedNotebooksFragment trashedNotebooksFragment, FolderModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        trashedNotebooksFragment.getTrashViewModel().toggleFolderSelection(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean trashAdapter$lambda$2(TrashedNotebooksFragment trashedNotebooksFragment, FolderModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        trashedNotebooksFragment.getTrashViewModel().toggleFolderSelection(it);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit trashAdapter$lambda$3(TrashedNotebooksFragment trashedNotebooksFragment, View anchor, CollectionKey collectionKey) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(collectionKey, "collectionKey");
        trashedNotebooksFragment.showCollectionMoreMenu(anchor, collectionKey);
        return Unit.INSTANCE;
    }

    @Override // com.myscript.android.utils.NestedFragment
    public boolean onMenuItemClicked(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        int itemId = menuItem.getItemId();
        if (itemId == C6079R.id.side_trash_select) {
            getTrashViewModel().activateFoldersSelectionMode(true);
        } else if (itemId == C6079R.id.side_trash_empty) {
            String cloudProvider = getTrashViewModel().getCloudProvider();
            String string = getString(!StringsKt.isBlank(cloudProvider) ? C6079R.string.empty_trash_message_with_cloud : C6079R.string.empty_trash_message_no_cloud, cloudProvider);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            new MaterialAlertDialogBuilder(requireActivity()).setTitle(C6079R.string.empty_trash_dialog_title).setMessage((CharSequence) string).setPositiveButton(C6079R.string.empty_trash_dialog_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    TrashedNotebooksFragment.onMenuItemClicked$lambda$0(this.f$0, dialogInterface, i);
                }
            }).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).show();
        } else {
            if (itemId != C6079R.id.side_trash_recover_all) {
                return false;
            }
            getTrashViewModel().restoreAllCollections();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMenuItemClicked$lambda$0(TrashedNotebooksFragment trashedNotebooksFragment, DialogInterface dialogInterface, int i) {
        trashedNotebooksFragment.getTrashViewModel().emptyTrash();
    }

    @Override // androidx.fragment.app.Fragment, com.myscript.android.utils.NestedFragment
    public void onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        boolean enableFoldersMenuActions = getTrashViewModel().getEnableFoldersMenuActions();
        MenuItem menuItemFindItem = menu.findItem(C6079R.id.side_trash_select);
        if (menuItemFindItem != null) {
            menuItemFindItem.setEnabled(enableFoldersMenuActions);
        }
        MenuItem menuItemFindItem2 = menu.findItem(C6079R.id.side_trash_recover_all);
        if (menuItemFindItem2 != null) {
            menuItemFindItem2.setEnabled(enableFoldersMenuActions);
        }
        MenuItem menuItemFindItem3 = menu.findItem(C6079R.id.side_trash_empty);
        if (menuItemFindItem3 != null) {
            menuItemFindItem3.setEnabled(enableFoldersMenuActions);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C6079R.layout.trash_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C6079R.id.trash_recycler_view);
        this.trashList = recyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(this.trashAdapter);
        }
        this.emptyState = (Group) viewInflate.findViewById(C6079R.id.trash_empty_state);
        this.loadingProgress = (ProgressBar) viewInflate.findViewById(C6079R.id.trash_loading_progress);
        getTrashViewModel().getTrashedCollectionsState().observe(getViewLifecycleOwner(), new TrashedNotebooksFragment$sam$androidx_lifecycle_Observer$0(new C68601(this)));
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$onCreateView$1 */
    /* JADX INFO: compiled from: TrashedNotebooksFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C68601 extends FunctionReferenceImpl implements Function1<TrashedCollectionsUIState, Unit> {
        C68601(Object obj) {
            super(1, obj, TrashedNotebooksFragment.class, "onTrashStateChanged", "onTrashStateChanged(Lcom/myscript/nebo/trash/TrashedCollectionsUIState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TrashedCollectionsUIState trashedCollectionsUIState) {
            invoke2(trashedCollectionsUIState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TrashedCollectionsUIState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((TrashedNotebooksFragment) this.receiver).onTrashStateChanged(p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Navigator navigator;
        Navigator navigator2 = getNavigator();
        if (navigator2 != null && navigator2.hasSelectionMode() && (navigator = getNavigator()) != null) {
            navigator.stopSelectionMode();
        }
        this.loadingProgress = null;
        this.emptyState = null;
        RecyclerView recyclerView = this.trashList;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        this.trashList = null;
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTrashStateChanged(TrashedCollectionsUIState state) {
        Navigator navigator;
        this.trashAdapter.setParentList(state.getCollections(), false);
        Group group = this.emptyState;
        if (group != null) {
            group.setVisibility(state.getShowEmptyState() ? 0 : 8);
        }
        ProgressBar progressBar = this.loadingProgress;
        if (progressBar != null) {
            progressBar.setVisibility(state.getShowProgress() ? 0 : 8);
        }
        Navigator navigator2 = getNavigator();
        boolean zHasSelectionMode = navigator2 != null ? navigator2.hasSelectionMode() : false;
        if (state.isSelectionMode() && !zHasSelectionMode) {
            Navigator navigator3 = getNavigator();
            if (navigator3 != null) {
                navigator3.startSelectionMode();
            }
        } else if (!state.isSelectionMode() && zHasSelectionMode && (navigator = getNavigator()) != null) {
            navigator.stopSelectionMode();
        }
        Navigator navigator4 = getNavigator();
        if (navigator4 != null) {
            navigator4.invalidateSelectionMode();
        }
        Navigator navigator5 = getNavigator();
        if (navigator5 != null) {
            navigator5.invalidateOptionsMenu();
        }
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onCreateSelectionMode(SelectionMode mode, Menu menu) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(menu, "menu");
        MenuInflater menuInflater = mode.getMenuInflater();
        if (menuInflater != null) {
            menuInflater.inflate(C6079R.menu.trash_selection_mode_menu, menu);
        }
        getTrashViewModel().activateFoldersSelectionMode(true);
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onPrepareSelectionMode(SelectionMode mode, Menu menu) {
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        MenuItem menuItemFindItem3;
        MenuItem menuItemFindItem4;
        Intrinsics.checkNotNullParameter(mode, "mode");
        int selectedFoldersCount = getTrashViewModel().getSelectedFoldersCount();
        mode.setTitle(getResources().getQuantityString(C6208R.plurals.folder_selected_count, selectedFoldersCount, Integer.valueOf(selectedFoldersCount)));
        boolean enableFoldersMenuActions = getTrashViewModel().getEnableFoldersMenuActions();
        if (menu != null && (menuItemFindItem4 = menu.findItem(C6079R.id.trash_deselect_all_menu_item)) != null) {
            menuItemFindItem4.setEnabled(enableFoldersMenuActions);
        }
        if (menu != null && (menuItemFindItem3 = menu.findItem(C6079R.id.trash_select_all_menu_item)) != null) {
            menuItemFindItem3.setEnabled(getTrashViewModel().getEnableSelectAllFolders());
        }
        if (menu != null && (menuItemFindItem2 = menu.findItem(C6079R.id.trash_delete_selection_menu_item)) != null) {
            menuItemFindItem2.setEnabled(enableFoldersMenuActions);
        }
        if (menu == null || (menuItemFindItem = menu.findItem(C6079R.id.trash_restore_selection_menu_item)) == null) {
            return true;
        }
        menuItemFindItem.setEnabled(enableFoldersMenuActions);
        return true;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public boolean onSelectionItemClicked(SelectionMode mode, MenuItem item) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Integer numValueOf = item != null ? Integer.valueOf(item.getItemId()) : null;
        int i = C6079R.id.trash_select_all_menu_item;
        if (numValueOf != null && numValueOf.intValue() == i) {
            getTrashViewModel().selectAllFolders();
            return true;
        }
        int i2 = C6079R.id.trash_deselect_all_menu_item;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            getTrashViewModel().deselectAllFolders();
            return true;
        }
        int i3 = C6079R.id.trash_delete_selection_menu_item;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            displayDeleteConfirmationDialog(getTrashViewModel().getSelectedFoldersCount(), new Function0() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrashedNotebooksFragment.onSelectionItemClicked$lambda$0(this.f$0);
                }
            });
            return true;
        }
        int i4 = C6079R.id.trash_restore_selection_menu_item;
        if (numValueOf == null || numValueOf.intValue() != i4) {
            return false;
        }
        getTrashViewModel().restoreSelectedFolders();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelectionItemClicked$lambda$0(TrashedNotebooksFragment trashedNotebooksFragment) {
        trashedNotebooksFragment.getTrashViewModel().deleteSelectedFolders();
        return Unit.INSTANCE;
    }

    @Override // com.myscript.android.utils.SelectionMode.Callback
    public void onDestroySelectionMode(SelectionMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        getTrashViewModel().activateFoldersSelectionMode(false);
    }

    private final void showCollectionMoreMenu(View anchor, final CollectionKey collectionKey) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), anchor);
        popupMenu.getMenuInflater().inflate(C6208R.menu.collection_item_more_menu, popupMenu.getMenu());
        popupMenu.setForceShowIcon(true);
        popupMenu.getMenu().findItem(C6208R.id.collection_item_more_menu_edit).setVisible(false);
        popupMenu.getMenu().findItem(C6208R.id.collection_item_more_menu_delete).setEnabled(true);
        popupMenu.getMenu().findItem(C6208R.id.collection_item_more_menu_recover).setVisible(true);
        popupMenu.getMenu().findItem(C6208R.id.collection_item_more_menu_new_folder).setVisible(false);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda0
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return TrashedNotebooksFragment.showCollectionMoreMenu$lambda$0$0(this.f$0, collectionKey, menuItem);
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showCollectionMoreMenu$lambda$0$0(final TrashedNotebooksFragment trashedNotebooksFragment, final CollectionKey collectionKey, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C6208R.id.collection_item_more_menu_delete) {
            trashedNotebooksFragment.displayDeleteConfirmationDialog(1, new Function0() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return TrashedNotebooksFragment.showCollectionMoreMenu$lambda$0$0$0(this.f$0, collectionKey);
                }
            });
            return true;
        }
        if (itemId != C6208R.id.collection_item_more_menu_recover) {
            return false;
        }
        trashedNotebooksFragment.getTrashViewModel().restoreCollection(collectionKey);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showCollectionMoreMenu$lambda$0$0$0(TrashedNotebooksFragment trashedNotebooksFragment, CollectionKey collectionKey) {
        trashedNotebooksFragment.getTrashViewModel().deleteCollection(collectionKey);
        return Unit.INSTANCE;
    }

    private final void displayDeleteConfirmationDialog(int itemsToDeleteCount, final Function0<Unit> deleteAction) {
        String cloudProvider = getTrashViewModel().getCloudProvider();
        String quantityString = getResources().getQuantityString(!StringsKt.isBlank(cloudProvider) ? C6079R.plurals.delete_trashed_pages_with_cloud : C6079R.plurals.delete_trashed_pages_no_cloud, itemsToDeleteCount, cloudProvider);
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        new MaterialAlertDialogBuilder(requireActivity()).setTitle(C6079R.string.delete_permanently_dialog_title).setMessage((CharSequence) quantityString).setPositiveButton(C6079R.string.delete_permanently_dialog_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.trash.ui.TrashedNotebooksFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                deleteAction.invoke();
            }
        }).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).create().show();
    }

    /* JADX INFO: compiled from: TrashedNotebooksFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/trash/ui/TrashedNotebooksFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/trash/ui/TrashedNotebooksFragment;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TrashedNotebooksFragment newInstance() {
            return new TrashedNotebooksFragment();
        }
    }
}
