package com.myscript.nebo.grid;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.grid.GridItemViewHolder;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.PageType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridRecyclerViewAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u000256B\u0017\b\u0000\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001eH\u0016J\u001a\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010,\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010-\u001a\u00020\u00172\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0018\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u0015H\u0016J\u000e\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0015J\u0010\u00104\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u00067"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/myscript/nebo/grid/GridItemViewHolder;", "Lcom/myscript/nebo/grid/ItemTouchHelperAdapter;", "Lcom/myscript/nebo/grid/GridItemViewHolder$Callback;", "pageModels", "", "Lcom/myscript/nebo/dms/core/model/PageModel;", "<init>", "(Ljava/util/List;)V", "", "callback", "Lcom/myscript/nebo/grid/GridRecyclerViewAdapter$Callback;", "getCallback", "()Lcom/myscript/nebo/grid/GridRecyclerViewAdapter$Callback;", "setCallback", "(Lcom/myscript/nebo/grid/GridRecyclerViewAdapter$Callback;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "getItemViewType", "getItemCount", "isDragging", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "isDragConfirmed", "onPageClicked", "onSelectionChanged", "selected", "onDragStarted", "view", "Landroid/view/View;", "onMoreButtonClicked", "x", "y", "onBottomBarClicked", "onThumbnailReady", "swapData", "newPageModels", "onItemMoved", "fromPosition", "toPosition", "onItemDropped", "newPosition", "getItemPosition", "PageItemDiffCallback", "Callback", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridItemViewHolder> implements ItemTouchHelperAdapter, GridItemViewHolder.Callback {
    public static final int $stable = 8;
    private Callback callback;
    private final List<PageModel> pageModels;

    /* JADX INFO: compiled from: GridRecyclerViewAdapter.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridRecyclerViewAdapter$Callback;", "", "isDragging", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "isDragConfirmed", "onPageClicked", "", "onSelectionChanged", "onDragStarted", "view", "Landroid/view/View;", "onMoreButtonClicked", "x", "", "y", "onBottomBarClicked", "movePage", "newPosition", "requestThumbnail", "pageModel", "Lcom/myscript/nebo/dms/core/model/PageModel;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        boolean isDragConfirmed(PageKey pageKey);

        boolean isDragging(PageKey pageKey);

        void movePage(PageKey pageKey, int newPosition);

        void onBottomBarClicked(PageKey pageKey);

        boolean onDragStarted(View view, PageKey pageKey);

        void onMoreButtonClicked(int x, int y, PageKey pageKey);

        void onPageClicked(PageKey pageKey);

        void onSelectionChanged(PageKey pageKey);

        void requestThumbnail(PageModel pageModel);
    }

    public GridRecyclerViewAdapter(List<PageModel> pageModels) {
        Intrinsics.checkNotNullParameter(pageModels, "pageModels");
        ArrayList arrayList = new ArrayList();
        this.pageModels = arrayList;
        arrayList.addAll(pageModels);
    }

    /* JADX INFO: compiled from: GridRecyclerViewAdapter.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/grid/GridRecyclerViewAdapter$PageItemDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/myscript/nebo/dms/core/model/PageModel;", "newList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class PageItemDiffCallback extends DiffUtil.Callback {
        private final List<PageModel> newList;
        private final List<PageModel> oldList;

        public PageItemDiffCallback(List<PageModel> oldList, List<PageModel> newList) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newList.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.oldList.get(oldItemPosition).getPageKey(), this.newList.get(newItemPosition).getPageKey());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return Intrinsics.areEqual(this.oldList.get(oldItemPosition), this.newList.get(newItemPosition));
        }
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new GridItemViewHolder(parent, GridItemViewHolder.INSTANCE.getLayoutRes(viewType));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(GridItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        synchronized (this) {
            if (position >= 0) {
                if (position < this.pageModels.size()) {
                    final PageModel pageModel = this.pageModels.get(position);
                    boolean isSelected = pageModel.getIsSelected();
                    holder.itemView.post(new Runnable() { // from class: com.myscript.nebo.grid.GridRecyclerViewAdapter$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            GridRecyclerViewAdapter.onBindViewHolder$lambda$1(this.f$0, pageModel);
                        }
                    });
                    File thumbnailFile = pageModel.getThumbnailFile();
                    holder.bind(pageModel, thumbnailFile != null ? thumbnailFile.getAbsolutePath() : null, isSelected, this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(GridRecyclerViewAdapter gridRecyclerViewAdapter, PageModel pageModel) {
        Callback callback = gridRecyclerViewAdapter.callback;
        if (callback != null) {
            callback.requestThumbnail(pageModel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(GridItemViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.unbind();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (this.pageModels.get(position).getPageType() != PageType.PDF && !this.pageModels.get(position).isContainer()) {
            return GridItemViewHolder.GRID_VIEW_PAGE_ITEM_TYPE;
        }
        return GridItemViewHolder.GRID_VIEW_PDF_ITEM_TYPE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public synchronized int getItemCount() {
        return this.pageModels.size();
    }

    @Override // com.myscript.nebo.grid.GridItemViewHolder.Callback
    public boolean isDragging(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Callback callback = this.callback;
        if (callback != null) {
            return callback.isDragging(pageKey);
        }
        return false;
    }

    @Override // com.myscript.nebo.grid.GridItemViewHolder.Callback
    public boolean isDragConfirmed(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Callback callback = this.callback;
        if (callback != null) {
            return callback.isDragConfirmed(pageKey);
        }
        return false;
    }

    @Override // com.myscript.nebo.grid.GridItemViewHolder.Callback
    public void onPageClicked(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onPageClicked(pageKey);
        }
    }

    @Override // com.myscript.nebo.grid.GridItemViewHolder.Callback
    public void onSelectionChanged(PageKey pageKey, boolean selected) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onSelectionChanged(pageKey);
        }
    }

    @Override // com.myscript.nebo.grid.GridItemViewHolder.Callback
    public boolean onDragStarted(View view, PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Callback callback = this.callback;
        if (callback != null) {
            return callback.onDragStarted(view, pageKey);
        }
        return false;
    }

    @Override // com.myscript.nebo.grid.GridItemViewHolder.Callback
    public void onMoreButtonClicked(int x, int y, PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onMoreButtonClicked(x, y, pageKey);
        }
    }

    @Override // com.myscript.nebo.grid.GridItemViewHolder.Callback
    public void onBottomBarClicked(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        Callback callback = this.callback;
        if (callback != null) {
            callback.onBottomBarClicked(pageKey);
        }
    }

    public final void onThumbnailReady(PageKey pageKey) {
        Intrinsics.checkNotNullParameter(pageKey, "pageKey");
        notifyItemChanged(getItemPosition(pageKey));
    }

    public final synchronized void swapData(List<PageModel> newPageModels) {
        if (newPageModels == null) {
            return;
        }
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new PageItemDiffCallback(this.pageModels, newPageModels));
        Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
        this.pageModels.clear();
        this.pageModels.addAll(newPageModels);
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    @Override // com.myscript.nebo.grid.ItemTouchHelperAdapter
    public synchronized boolean onItemMoved(int fromPosition, int toPosition) {
        try {
            if (fromPosition < toPosition) {
                int i = fromPosition;
                while (i < toPosition) {
                    int i2 = i + 1;
                    Collections.swap(this.pageModels, i, i2);
                    i = i2;
                }
            } else {
                int i3 = toPosition + 1;
                if (i3 <= fromPosition) {
                    int i4 = fromPosition;
                    while (true) {
                        Collections.swap(this.pageModels, i4, i4 - 1);
                        if (i4 == i3) {
                            break;
                        }
                        i4--;
                    }
                }
            }
            notifyItemMoved(fromPosition, toPosition);
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    public final void onItemDropped(int newPosition) {
        Callback callback;
        if (newPosition < 0 || newPosition >= this.pageModels.size() || (callback = this.callback) == null) {
            return;
        }
        callback.movePage(this.pageModels.get(newPosition).getPageKey(), newPosition);
    }

    public final int getItemPosition(PageKey pageKey) {
        Iterator<PageModel> it = this.pageModels.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().getPageKey(), pageKey)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
