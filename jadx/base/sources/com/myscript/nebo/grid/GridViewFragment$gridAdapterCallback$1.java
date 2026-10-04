package com.myscript.nebo.grid;

import android.app.Application;
import android.content.ClipData;
import android.graphics.Point;
import android.view.View;
import androidx.appcompat.C0028R;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.common.utils.PopupUtils;
import com.myscript.nebo.dms.DragPageClipDataHelper;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.grid.GridRecyclerViewAdapter;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridViewFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, m1599d2 = {"com/myscript/nebo/grid/GridViewFragment$gridAdapterCallback$1", "Lcom/myscript/nebo/grid/GridRecyclerViewAdapter$Callback;", "isDragging", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "isDragConfirmed", "onPageClicked", "", "onSelectionChanged", "onDragStarted", "view", "Landroid/view/View;", "onMoreButtonClicked", "x", "", "y", "onBottomBarClicked", "movePage", "newPosition", "requestThumbnail", "pageModel", "Lcom/myscript/nebo/dms/core/model/PageModel;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GridViewFragment$gridAdapterCallback$1 implements GridRecyclerViewAdapter.Callback {
    final /* synthetic */ GridViewFragment this$0;

    GridViewFragment$gridAdapterCallback$1(GridViewFragment gridViewFragment) {
        this.this$0 = gridViewFragment;
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public boolean isDragging(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        return Intrinsics.areEqual(pageKey, this.this$0.draggedItemPageKey);
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public boolean isDragConfirmed(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        PageKey pageKey2 = this.this$0.draggedItemPageKey;
        return pageKey2 != null && this.this$0.isDragConfirmed && isDragging(pageKey2);
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public void onPageClicked(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        if (this.this$0.getGridViewModel().getIsSelectionMode()) {
            TechnicalLogger logger = this.this$0.getLogger();
            final GridViewFragment gridViewFragment = this.this$0;
            TechnicalLoggerExt.logAction(logger, MainViewFragment.TAG, "Grid selection changed", new Function0() { // from class: com.myscript.nebo.grid.GridViewFragment$gridAdapterCallback$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return GridViewFragment$gridAdapterCallback$1.onPageClicked$lambda$1(gridViewFragment);
                }
            });
            this.this$0.getGridViewModel().togglePageSelection(pageKey);
            return;
        }
        this.this$0.getGridViewModel().openPage(pageKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String onPageClicked$lambda$1(GridViewFragment gridViewFragment) {
        return "count=" + gridViewFragment.getGridViewModel().getSelectedPages().size() + " hasSelection=" + gridViewFragment.getGridViewModel().getIsSelectionMode();
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public void onSelectionChanged(PageKey pageKey) {
        if (pageKey != null) {
            this.this$0.getGridViewModel().togglePageSelection(pageKey);
        }
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public boolean onDragStarted(View view, PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Application application = this.this$0.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.NeboApplication");
        NeboApplication neboApplication = (NeboApplication) application;
        if (this.this$0.getGridViewModel().isSearchModeActive() || !neboApplication.isDnDActivated() || view == null) {
            return false;
        }
        view.setTag(pageKey);
        int x = (int) (this.this$0.lastTouchPoint.x - (view.getX() + view.getPaddingStart()));
        int y = (int) (this.this$0.lastTouchPoint.y - (view.getY() + view.getPaddingTop()));
        GridViewFragment gridViewFragment = this.this$0;
        Object tag = view.getTag(C6079R.id.page_id_page_view_key);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.myscript.snt.core.PageKey");
        gridViewFragment.draggedItemPageKey = (PageKey) tag;
        GridViewFragment gridViewFragment2 = this.this$0;
        GridRecyclerViewAdapter gridRecyclerViewAdapter = gridViewFragment2.gridRecyclerViewAdapter;
        gridViewFragment2.draggedItemStartIndex = gridRecyclerViewAdapter != null ? gridRecyclerViewAdapter.getItemPosition(this.this$0.draggedItemPageKey) : 0;
        ClipData pageClipData = DragPageClipDataHelper.getPageClipData(this.this$0.draggedItemPageKey);
        GridViewFragment gridViewFragment3 = this.this$0;
        gridViewFragment3.setItemDragging(gridViewFragment3.draggedItemPageKey, true);
        PageDragShadowBuilder.startDrag(view, pageClipData, new Point(x, y));
        return true;
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public void onMoreButtonClicked(int x, int y, PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        this.this$0.openedPageMenuKey = pageKey;
        PopupUtils.launchPopupMenu(this.this$0.getActivity(), "PAGE_ITEM_MORE_MENU", C6079R.menu.page_item_more_menu, GravityCompat.START, C0028R.attr.actionOverflowMenuStyle, x, y, false, this.this$0.popupMenuCreationListener);
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public void onBottomBarClicked(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        if (this.this$0.getGridViewModel().getIsSelectionMode()) {
            this.this$0.getGridViewModel().togglePageSelection(pageKey);
            return;
        }
        PageModel page = this.this$0.getGridViewModel().getPage(pageKey);
        if (page != null) {
            GridViewFragment gridViewFragment = this.this$0;
            NoteNameDialog noteNameDialogNewInstance = NoteNameDialog.INSTANCE.newInstance(pageKey, page.getTitle());
            FragmentManager parentFragmentManager = gridViewFragment.getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
            noteNameDialogNewInstance.show(parentFragmentManager);
        }
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public void movePage(PageKey pageKey, int newPosition) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        this.this$0.getGridViewModel().movePage(pageKey, newPosition);
    }

    @Override // com.myscript.nebo.grid.GridRecyclerViewAdapter.Callback
    public void requestThumbnail(PageModel pageModel) {
        Intrinsics.checkNotNullParameter(pageModel, "pageModel");
        this.this$0.getGridViewModel().requestThumbnail(pageModel);
    }
}
