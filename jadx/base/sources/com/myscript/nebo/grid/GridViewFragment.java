package com.myscript.nebo.grid;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.RetailMode;
import com.myscript.nebo.common.utils.FeatureHelper;
import com.myscript.nebo.common.utils.PopupUtils;
import com.myscript.nebo.dms.DragPageClipDataHelper;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.dialog.FolderPickerDialog;
import com.myscript.nebo.export.ExportDialog;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.grid.MainViewFragment;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.snt.core.IThumbnailerNotificationListener;
import com.myscript.snt.core.PageKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: GridViewFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002)0\b\u0007\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J$\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010C\u001a\u0002082\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u000208H\u0002J\u0018\u0010G\u001a\u0002082\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0002J\u0018\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020<2\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u0002082\u0006\u0010P\u001a\u00020\"H\u0002J\u0010\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020 H\u0002J\u0006\u0010S\u001a\u000208J\u0010\u0010T\u001a\u0002082\u0006\u0010P\u001a\u00020\"H\u0016J\u0018\u0010U\u001a\u0002082\b\u0010P\u001a\u0004\u0018\u00010\"2\u0006\u0010V\u001a\u00020 J\u0010\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020YH\u0002J\b\u0010Z\u001a\u000208H\u0002J\b\u0010[\u001a\u000208H\u0016J\b\u0010\\\u001a\u000208H\u0016J\b\u0010]\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0004\n\u0002\u00101R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\b4\u00105¨\u0006_"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/nebo/grid/INotesViewFragment;", "<init>", "()V", "mainViewModel", "Lcom/myscript/nebo/grid/MainViewModel;", "getMainViewModel", "()Lcom/myscript/nebo/grid/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "gridViewModel", "Lcom/myscript/nebo/grid/GridViewModel;", "getGridViewModel", "()Lcom/myscript/nebo/grid/GridViewModel;", "gridViewModel$delegate", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "gridRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "gridRecyclerViewAdapter", "Lcom/myscript/nebo/grid/GridRecyclerViewAdapter;", "gridItemDecoration", "Lcom/myscript/nebo/grid/GridViewItemDecoration;", "maxElevation", "", "draggedItemLastIndex", "draggedItemStartIndex", "isDragConfirmed", "", "draggedItemPageKey", "Lcom/myscript/snt/core/PageKey;", "lastTouchPoint", "Landroid/graphics/PointF;", "popupMenu", "Landroidx/appcompat/widget/PopupMenu;", "openedPageMenuKey", "itemTouchListener", "com/myscript/nebo/grid/GridViewFragment$itemTouchListener$1", "Lcom/myscript/nebo/grid/GridViewFragment$itemTouchListener$1;", "thumbnailListener", "Lcom/myscript/snt/core/IThumbnailerNotificationListener;", "popupMenuCreationListener", "Lcom/myscript/nebo/common/utils/PopupUtils$PopupInfoMenuCallback;", "gridAdapterCallback", "com/myscript/nebo/grid/GridViewFragment$gridAdapterCallback$1", "Lcom/myscript/nebo/grid/GridViewFragment$gridAdapterCallback$1;", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "folderStateChanged", "folderUIState", "Lcom/myscript/nebo/grid/FolderUIState;", "resetToolbarElevation", "setItemDraggedOn", "x", "", "y", "onDrag", "v", NotificationCompat.CATEGORY_EVENT, "Landroid/view/DragEvent;", "disableLongPressTimer", "pageKey", "setDragConfirmed", "confirmed", "stopLongPressTimer", "smoothScrollTo", "setItemDragging", "isDragging", "onPopupMenuItemClick", "item", "Landroid/view/MenuItem;", "resetPopupMenu", "onStop", "onDestroyView", "onDestroy", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GridViewFragment extends Fragment implements INotesViewFragment {
    private static final String PAGE_ITEM_MORE_MENU = "PAGE_ITEM_MORE_MENU";
    public static final String TAG = "GridViewFragment";
    private PageKey draggedItemPageKey;

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;
    private GridViewItemDecoration gridItemDecoration;
    private RecyclerView gridRecyclerView;

    /* JADX INFO: renamed from: gridViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gridViewModel;
    private boolean isDragConfirmed;

    /* JADX INFO: renamed from: mainViewModel$delegate, reason: from kotlin metadata */
    private final Lazy mainViewModel;
    private int maxElevation;
    private PageKey openedPageMenuKey;
    private PopupMenu popupMenu;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return GridViewFragment.logger_delegate$lambda$0(this.f$0);
        }
    });
    private GridRecyclerViewAdapter gridRecyclerViewAdapter = new GridRecyclerViewAdapter(new ArrayList());
    private int draggedItemLastIndex = -1;
    private int draggedItemStartIndex = -1;
    private final PointF lastTouchPoint = new PointF();
    private final GridViewFragment$itemTouchListener$1 itemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.myscript.nebo.grid.GridViewFragment$itemTouchListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean b) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(e, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            Intrinsics.checkNotNullParameter(rv, "rv");
            Intrinsics.checkNotNullParameter(e, "e");
            this.this$0.lastTouchPoint.set(e.getX(), e.getY());
            return false;
        }
    };
    private final IThumbnailerNotificationListener thumbnailListener = new IThumbnailerNotificationListener() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda10
        @Override // com.myscript.snt.core.IThumbnailerNotificationListener
        public final void thumbnailCreated(PageKey pageKey, String str, boolean z) {
            GridViewFragment.thumbnailListener$lambda$0(this.f$0, pageKey, str, z);
        }
    };
    private final PopupUtils.PopupInfoMenuCallback popupMenuCreationListener = new PopupUtils.PopupInfoMenuCallback() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda11
        @Override // com.myscript.nebo.common.utils.PopupUtils.PopupInfoMenuCallback
        public final void popupMenuCreated(PopupMenu popupMenu, PopupUtils.PopupInfoSaveInstanceState popupInfoSaveInstanceState) {
            GridViewFragment.popupMenuCreationListener$lambda$0(this.f$0, popupMenu, popupInfoSaveInstanceState);
        }
    };
    private final GridViewFragment$gridAdapterCallback$1 gridAdapterCallback = new GridViewFragment$gridAdapterCallback$1(this);

    @JvmStatic
    public static final GridViewFragment newInstance() {
        return INSTANCE.newInstance();
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [com.myscript.nebo.grid.GridViewFragment$itemTouchListener$1] */
    public GridViewFragment() {
        final GridViewFragment gridViewFragment = this;
        final Function0 function0 = null;
        this.mainViewModel = FragmentViewModelLazyKt.createViewModelLazy(gridViewFragment, Reflection.getOrCreateKotlinClass(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.GridViewFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gridViewFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.GridViewFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gridViewFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainViewModel.Factory;
            }
        });
        this.gridViewModel = FragmentViewModelLazyKt.createViewModelLazy(gridViewFragment, Reflection.getOrCreateKotlinClass(GridViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.GridViewFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gridViewFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.GridViewFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gridViewFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GridViewModel.Factory;
            }
        });
        this.freemiumLimitationViewModel = FragmentViewModelLazyKt.createViewModelLazy(gridViewFragment, Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.GridViewFragment$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return gridViewFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.GridViewFragment$special$$inlined$activityViewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? gridViewFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreemiumLimitationViewModel.Factory;
            }
        });
    }

    private final MainViewModel getMainViewModel() {
        return (MainViewModel) this.mainViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GridViewModel getGridViewModel() {
        return (GridViewModel) this.gridViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(GridViewFragment gridViewFragment) {
        ComponentCallbacks2 application = gridViewFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) application).provideTechnicalLogger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void thumbnailListener$lambda$0(final GridViewFragment gridViewFragment, final PageKey pageKey, String str, boolean z) {
        View view = gridViewFragment.getView();
        if (z && gridViewFragment.isAdded() && view != null) {
            view.post(new Runnable() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    GridViewFragment.thumbnailListener$lambda$0$0(this.f$0, pageKey);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void thumbnailListener$lambda$0$0(GridViewFragment gridViewFragment, PageKey pageKey) {
        GridRecyclerViewAdapter gridRecyclerViewAdapter = gridViewFragment.gridRecyclerViewAdapter;
        if (gridRecyclerViewAdapter != null) {
            Intrinsics.checkNotNull(pageKey);
            gridRecyclerViewAdapter.onThumbnailReady(pageKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popupMenuCreationListener$lambda$0(final GridViewFragment gridViewFragment, PopupMenu popupMenu, PopupUtils.PopupInfoSaveInstanceState popupInfoSaveInstanceState) {
        Menu menu;
        MenuItem menuItemFindItem;
        PopupMenu popupMenu2;
        Menu menu2;
        gridViewFragment.resetPopupMenu();
        gridViewFragment.popupMenu = popupMenu;
        if (popupMenu != null) {
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda2
                @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    return GridViewFragment.popupMenuCreationListener$lambda$0$0(this.f$0, menuItem);
                }
            });
        }
        if (!Intrinsics.areEqual(PAGE_ITEM_MORE_MENU, popupInfoSaveInstanceState.popupKey) || gridViewFragment.openedPageMenuKey == null) {
            return;
        }
        if (RetailMode.INSTANCE.isEnabled() && (popupMenu2 = gridViewFragment.popupMenu) != null && (menu2 = popupMenu2.getMenu()) != null) {
            menu2.removeItem(C6079R.id.page_item_more_menu_export);
        }
        PageKey pageKey = gridViewFragment.openedPageMenuKey;
        if (pageKey != null) {
            PageModel page = gridViewFragment.getGridViewModel().getPage(pageKey);
            boolean z = page != null && page.getIsExportable();
            PopupMenu popupMenu3 = gridViewFragment.popupMenu;
            if (popupMenu3 == null || (menu = popupMenu3.getMenu()) == null || (menuItemFindItem = menu.findItem(C6079R.id.page_item_more_menu_export)) == null) {
                return;
            }
            menuItemFindItem.setEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean popupMenuCreationListener$lambda$0$0(GridViewFragment gridViewFragment, MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return gridViewFragment.onPopupMenuItemClick(item);
    }

    private final FreemiumLimitationViewModel getFreemiumLimitationViewModel() {
        return (FreemiumLimitationViewModel) this.freemiumLimitationViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.gridItemDecoration = new GridViewItemDecoration(contextRequireContext);
        this.maxElevation = requireContext().getResources().getDimensionPixelSize(C6079R.dimen.elevation_toolbar);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(C6079R.layout.folder_grid_view, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C6079R.id.pages_grid_recyclerView);
        recyclerView.addOnItemTouchListener(this.itemTouchListener);
        recyclerView.setOnDragListener(new View.OnDragListener() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                return GridViewFragment.onCreateView$lambda$0$0(this.f$0, view, dragEvent);
            }
        });
        recyclerView.setLayoutManager(new GridAutoFitLayoutManager(requireContext()));
        recyclerView.setAdapter(this.gridRecyclerViewAdapter);
        GridViewItemDecoration gridViewItemDecoration = this.gridItemDecoration;
        if (gridViewItemDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridItemDecoration");
            gridViewItemDecoration = null;
        }
        recyclerView.addItemDecoration(gridViewItemDecoration);
        GridRecyclerViewAdapter gridRecyclerViewAdapter = this.gridRecyclerViewAdapter;
        if (gridRecyclerViewAdapter != null) {
            gridRecyclerViewAdapter.setCallback(this.gridAdapterCallback);
        }
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        FragmentActivity activity = getActivity();
        final View viewFindViewById = activity != null ? activity.findViewById(C6079R.id.activity_main_app_bar_container) : null;
        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
                GridViewFragment.onCreateView$lambda$0$1(this.f$0, viewFindViewById, view, i, i2, i3, i4);
            }
        });
        this.gridRecyclerView = recyclerView;
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateView$lambda$0$0(GridViewFragment gridViewFragment, View v, DragEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        return gridViewFragment.onDrag(v, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$1(GridViewFragment gridViewFragment, View view, View view2, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(view2, "<unused var>");
        RecyclerView recyclerView = gridViewFragment.gridRecyclerView;
        if (recyclerView == null || view == null) {
            return;
        }
        ToolbarExtKt.setElevationBasedOnScroll(view, recyclerView.computeVerticalScrollOffset(), recyclerView.computeVerticalScrollRange(), gridViewFragment.maxElevation);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getGridViewModel().getFolderUIState().observe(getViewLifecycleOwner(), new GridViewFragment$sam$androidx_lifecycle_Observer$0(new C64841(this)));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.GridViewFragment$onViewCreated$1 */
    /* JADX INFO: compiled from: GridViewFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64841 extends FunctionReferenceImpl implements Function1<FolderUIState, Unit> {
        C64841(Object obj) {
            super(1, obj, GridViewFragment.class, "folderStateChanged", "folderStateChanged(Lcom/myscript/nebo/grid/FolderUIState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FolderUIState folderUIState) {
            invoke2(folderUIState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FolderUIState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((GridViewFragment) this.receiver).folderStateChanged(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void folderStateChanged(FolderUIState folderUIState) {
        GridRecyclerViewAdapter gridRecyclerViewAdapter;
        if (!getGridViewModel().getIsBeingModified() && (gridRecyclerViewAdapter = this.gridRecyclerViewAdapter) != null) {
            gridRecyclerViewAdapter.swapData(folderUIState.getPages());
        }
        if (getGridViewModel().getIsSelectionMode()) {
            return;
        }
        this.openedPageMenuKey = null;
    }

    private final void resetToolbarElevation() {
        FragmentActivity activity = getActivity();
        View viewFindViewById = activity != null ? activity.findViewById(C6079R.id.activity_main_app_bar_container) : null;
        if (viewFindViewById != null) {
            viewFindViewById.setElevation(0.0f);
        }
    }

    private final void setItemDraggedOn(float x, float y) {
        PageKey pageKey;
        RecyclerView recyclerView = this.gridRecyclerView;
        if (recyclerView != null) {
            float fMmToPx = ScreenUtils.mmToPx(getContext(), 10.0f);
            boolean z = y < ((float) recyclerView.getTop()) + fMmToPx;
            boolean z2 = y > ((float) recyclerView.getBottom()) - fMmToPx;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.myscript.nebo.grid.GridAutoFitLayoutManager");
            GridAutoFitLayoutManager gridAutoFitLayoutManager = (GridAutoFitLayoutManager) layoutManager;
            int iFindFirstCompletelyVisibleItemPosition = gridAutoFitLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iFindLastCompletelyVisibleItemPosition = gridAutoFitLayoutManager.findLastCompletelyVisibleItemPosition();
            if (z) {
                recyclerView.smoothScrollToPosition(Math.max(iFindFirstCompletelyVisibleItemPosition - 1, 0));
            } else if (z2) {
                int i = iFindLastCompletelyVisibleItemPosition + 1;
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                recyclerView.smoothScrollToPosition(Math.min(i, adapter != null ? adapter.getItemCount() : 0));
            }
            GridRecyclerViewAdapter gridRecyclerViewAdapter = this.gridRecyclerViewAdapter;
            int itemPosition = gridRecyclerViewAdapter != null ? gridRecyclerViewAdapter.getItemPosition(this.draggedItemPageKey) : 0;
            RecyclerView recyclerView2 = recyclerView;
            int childCount = recyclerView2.getChildCount();
            int itemPosition2 = -1;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView2.getChildAt(i2);
                if (childAt.getTop() < y && childAt.getBottom() > y && childAt.getLeft() < x && childAt.getRight() > x) {
                    RecyclerView recyclerView3 = this.gridRecyclerView;
                    RecyclerView.ViewHolder childViewHolder = recyclerView3 != null ? recyclerView3.getChildViewHolder(childAt) : null;
                    if ((childViewHolder instanceof GridItemViewHolder) && (pageKey = ((GridItemViewHolder) childViewHolder).getPageKey()) != null) {
                        GridRecyclerViewAdapter gridRecyclerViewAdapter2 = this.gridRecyclerViewAdapter;
                        itemPosition2 = gridRecyclerViewAdapter2 != null ? gridRecyclerViewAdapter2.getItemPosition(pageKey) : -1;
                        if (!Intrinsics.areEqual(pageKey, this.draggedItemPageKey)) {
                            int left = (childAt.getLeft() + childAt.getRight()) / 2;
                            if (itemPosition2 < itemPosition) {
                                if (x > left) {
                                    itemPosition2++;
                                }
                            } else if (x <= left) {
                                itemPosition2--;
                            }
                        }
                    }
                }
            }
            if (itemPosition2 == -1 || itemPosition2 == this.draggedItemLastIndex) {
                return;
            }
            GridRecyclerViewAdapter gridRecyclerViewAdapter3 = this.gridRecyclerViewAdapter;
            if (gridRecyclerViewAdapter3 != null) {
                gridRecyclerViewAdapter3.onItemMoved(itemPosition, itemPosition2);
            }
            this.draggedItemLastIndex = itemPosition2;
        }
    }

    private final boolean onDrag(View v, DragEvent event) {
        int i;
        GridRecyclerViewAdapter gridRecyclerViewAdapter;
        if (!isAdded()) {
            return false;
        }
        int action = event.getAction();
        boolean z = getResources().getBoolean(C6079R.bool.side_panel_side_by_side);
        switch (action) {
            case 1:
                if (event.getClipDescription() == null || !event.getClipDescription().hasMimeType(DragPageClipDataHelper.DRAG_PAGE_MIME)) {
                }
                break;
            case 2:
                int[] iArr = new int[2];
                RecyclerView recyclerView = this.gridRecyclerView;
                if (recyclerView != null) {
                    recyclerView.getLocationInWindow(iArr);
                }
                int iDpToPx = ScreenUtils.dpToPx(getContext(), 48.0f);
                int i2 = (int) (this.lastTouchPoint.x - iArr[0]);
                int i3 = (int) (this.lastTouchPoint.y - iArr[1]);
                float f = iDpToPx;
                if (Math.abs(event.getX() - i2) > f || Math.abs(event.getY() - i3) > f) {
                    setDragConfirmed(true);
                }
                if (event.getX() < f) {
                    MainViewModel.requestSidePanelVisibility$default(getMainViewModel(), true, false, 2, null);
                } else if (!getMainViewModel().getIsSidePanelOpen() || z) {
                    setItemDraggedOn(event.getX(), event.getY());
                }
                break;
            case 3:
                if (!getMainViewModel().getIsSidePanelOpen() || z) {
                    GridRecyclerViewAdapter gridRecyclerViewAdapter2 = this.gridRecyclerViewAdapter;
                    int itemPosition = gridRecyclerViewAdapter2 != null ? gridRecyclerViewAdapter2.getItemPosition(this.draggedItemPageKey) : -1;
                    if (itemPosition != -1 && this.draggedItemStartIndex != itemPosition && (i = this.draggedItemLastIndex) != -1 && (gridRecyclerViewAdapter = this.gridRecyclerViewAdapter) != null) {
                        gridRecyclerViewAdapter.onItemDropped(i);
                    }
                }
                break;
            case 4:
                PageKey pageKey = this.draggedItemPageKey;
                if (pageKey != null) {
                    setItemDragging(pageKey, false);
                    if (!z) {
                        MainViewModel.requestSidePanelVisibility$default(getMainViewModel(), false, false, 2, null);
                    }
                    disableLongPressTimer(pageKey);
                    setDragConfirmed(false);
                    this.draggedItemPageKey = null;
                    this.draggedItemStartIndex = -1;
                    this.draggedItemLastIndex = -1;
                }
                break;
            case 5:
                if (!z) {
                    MainViewModel.requestSidePanelVisibility$default(getMainViewModel(), false, false, 2, null);
                }
                break;
            case 6:
                setDragConfirmed(true);
                break;
        }
        return false;
    }

    private final void disableLongPressTimer(PageKey pageKey) {
        GridItemViewHolder gridItemViewHolder;
        PageKey pageKey2;
        RecyclerView recyclerView = this.gridRecyclerView;
        if (recyclerView != null) {
            RecyclerView recyclerView2 = recyclerView;
            int childCount = recyclerView2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView2.getChildAt(i);
                RecyclerView recyclerView3 = this.gridRecyclerView;
                RecyclerView.ViewHolder childViewHolder = recyclerView3 != null ? recyclerView3.getChildViewHolder(childAt) : null;
                if ((childViewHolder instanceof GridItemViewHolder) && (pageKey2 = (gridItemViewHolder = (GridItemViewHolder) childViewHolder).getPageKey()) != null && Intrinsics.areEqual(pageKey2, pageKey)) {
                    gridItemViewHolder.onDragStopped();
                    return;
                }
            }
        }
    }

    private final void setDragConfirmed(boolean confirmed) {
        this.isDragConfirmed = confirmed;
        getGridViewModel().setIsBeingModified(confirmed);
        GridViewModel.closeSearch$default(getGridViewModel(), false, 1, null);
        KeyEventDispatcher.Component activity = getActivity();
        MainViewFragment.ActionListener actionListener = activity instanceof MainViewFragment.ActionListener ? (MainViewFragment.ActionListener) activity : null;
        if (actionListener != null) {
            actionListener.onStartDraggingPage();
        }
    }

    public final void stopLongPressTimer() {
        RecyclerView recyclerView = this.gridRecyclerView;
        if (recyclerView != null) {
            RecyclerView recyclerView2 = recyclerView;
            int childCount = recyclerView2.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView2.getChildAt(i);
                RecyclerView recyclerView3 = this.gridRecyclerView;
                RecyclerView.ViewHolder childViewHolder = recyclerView3 != null ? recyclerView3.getChildViewHolder(childAt) : null;
                GridItemViewHolder gridItemViewHolder = childViewHolder instanceof GridItemViewHolder ? (GridItemViewHolder) childViewHolder : null;
                if (gridItemViewHolder != null) {
                    gridItemViewHolder.stopLongPressTimer();
                }
            }
        }
    }

    @Override // com.myscript.nebo.grid.INotesViewFragment
    public void smoothScrollTo(PageKey pageKey) {
        GridRecyclerViewAdapter gridRecyclerViewAdapter;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        if (this.gridRecyclerView == null || (gridRecyclerViewAdapter = this.gridRecyclerViewAdapter) == null) {
            return;
        }
        int itemPosition = gridRecyclerViewAdapter != null ? gridRecyclerViewAdapter.getItemPosition(pageKey) : -1;
        if (itemPosition < 0 || (recyclerView = this.gridRecyclerView) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition(itemPosition);
    }

    public final void setItemDragging(final PageKey pageKey, boolean isDragging) {
        GridRecyclerViewAdapter gridRecyclerViewAdapter;
        this.draggedItemPageKey = isDragging ? pageKey : null;
        if (pageKey == null) {
            return;
        }
        GridRecyclerViewAdapter gridRecyclerViewAdapter2 = this.gridRecyclerViewAdapter;
        int itemPosition = gridRecyclerViewAdapter2 != null ? gridRecyclerViewAdapter2.getItemPosition(pageKey) : -1;
        TechnicalLoggerExt.logAction(getLogger(), MainViewFragment.TAG, isDragging ? "Page dragging" : "Page dropped", new Function0() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return pageKey.uuid();
            }
        });
        if (itemPosition == -1 || (gridRecyclerViewAdapter = this.gridRecyclerViewAdapter) == null) {
            return;
        }
        gridRecyclerViewAdapter.notifyItemChanged(itemPosition);
    }

    private final boolean onPopupMenuItemClick(MenuItem item) {
        final PageKey pageKey = this.openedPageMenuKey;
        if (pageKey != null) {
            int itemId = item.getItemId();
            if (itemId == C6079R.id.page_item_more_menu_delete) {
                List<? extends PageKey> listListOf = CollectionsKt.listOf(pageKey);
                this.openedPageMenuKey = null;
                getGridViewModel().moveToTrash(listListOf);
                return true;
            }
            if (itemId == C6079R.id.page_item_more_menu_move) {
                List<? extends PageKey> listListOf2 = CollectionsKt.listOf(pageKey);
                this.openedPageMenuKey = null;
                if (getGridViewModel().getFolderUIState().getValue() != null) {
                    FolderPickerDialog movePages = FolderPickerDialog.INSTANCE.toMovePages(listListOf2);
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
                    movePages.show(parentFragmentManager);
                }
                return true;
            }
            if (itemId == C6079R.id.page_item_more_menu_duplicate_page) {
                getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_GRID_VIEW_DUPLICATE, new Function0() { // from class: com.myscript.nebo.grid.GridViewFragment$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GridViewFragment.onPopupMenuItemClick$lambda$0$0(this.f$0, pageKey);
                    }
                });
                return true;
            }
            if (itemId == C6079R.id.page_item_more_menu_rename_page) {
                PageModel page = getGridViewModel().getPage(pageKey);
                if (page != null) {
                    NoteNameDialog noteNameDialogNewInstance = NoteNameDialog.INSTANCE.newInstance(pageKey, page.getTitle());
                    FragmentManager parentFragmentManager2 = getParentFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(parentFragmentManager2, "getParentFragmentManager(...)");
                    noteNameDialogNewInstance.show(parentFragmentManager2);
                }
                this.openedPageMenuKey = null;
                return true;
            }
            if (itemId != C6079R.id.page_item_more_menu_export || !FeatureHelper.checkFeatureAvailable(requireActivity(), C6079R.bool.export_enabled)) {
                return false;
            }
            List listListOf3 = CollectionsKt.listOf(pageKey);
            TechnicalLoggerExt.logPagesDetails(getLogger(), TAG, "Export pages", listListOf3, getGridViewModel().getSelectedPages());
            ExportDialog exportDialogNewInstance$default = ExportDialog.Companion.newInstance$default(ExportDialog.INSTANCE, listListOf3, (List) null, (String) null, 6, (Object) null);
            FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            exportDialogNewInstance$default.show(supportFragmentManager);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPopupMenuItemClick$lambda$0$0(GridViewFragment gridViewFragment, PageKey pageKey) {
        gridViewFragment.getGridViewModel().duplicatePage(pageKey);
        gridViewFragment.openedPageMenuKey = null;
        return Unit.INSTANCE;
    }

    private final void resetPopupMenu() {
        PopupMenu popupMenu = this.popupMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
            popupMenu.setOnMenuItemClickListener(null);
        }
        this.popupMenu = null;
        PopupUtils.reset();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        resetPopupMenu();
        setItemDragging(this.draggedItemPageKey, false);
        resetToolbarElevation();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView = this.gridRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeOnItemTouchListener(this.itemTouchListener);
        }
        RecyclerView recyclerView2 = this.gridRecyclerView;
        GridViewItemDecoration gridViewItemDecoration = null;
        if (recyclerView2 != null) {
            recyclerView2.setOnDragListener(null);
        }
        RecyclerView recyclerView3 = this.gridRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setOnScrollChangeListener(null);
        }
        RecyclerView recyclerView4 = this.gridRecyclerView;
        if (recyclerView4 != null) {
            GridViewItemDecoration gridViewItemDecoration2 = this.gridItemDecoration;
            if (gridViewItemDecoration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gridItemDecoration");
            } else {
                gridViewItemDecoration = gridViewItemDecoration2;
            }
            recyclerView4.removeItemDecoration(gridViewItemDecoration);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        RecyclerView recyclerView = this.gridRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        this.gridRecyclerView = null;
        GridRecyclerViewAdapter gridRecyclerViewAdapter = this.gridRecyclerViewAdapter;
        if (gridRecyclerViewAdapter != null) {
            gridRecyclerViewAdapter.setCallback(null);
        }
        this.gridRecyclerViewAdapter = null;
        super.onDestroy();
    }

    /* JADX INFO: compiled from: GridViewFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridViewFragment$Companion;", "", "<init>", "()V", "TAG", "", GridViewFragment.PAGE_ITEM_MORE_MENU, "newInstance", "Lcom/myscript/nebo/grid/GridViewFragment;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GridViewFragment newInstance() {
            return new GridViewFragment();
        }
    }
}
