package com.myscript.nebo.dms.expandlist;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.model.ExpandableWrapper;
import com.myscript.android.utils.StableIdKeyProvider;
import com.myscript.nebo.common.OngoingProgress;
import com.myscript.nebo.dms.core.CollectionItemsHelper;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.core.model.SelectionState;
import com.myscript.nebo.dms.expandlist.NotebookItemViewHolder;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
class DmsAdapter extends ExpandableRecyclerAdapter<CollectionModel, FolderModel, CollectionItemViewHolder, DmsChildItemViewHolder> implements ExpandableRecyclerAdapter.ExpandCollapseListener, NotebookItemViewHolder.OnNotebookClickedListener {
    private static final int CHILD_VIEW_TYPE_NOTEBOOK = 1;
    private static final int PARENT_VIEW_TYPE_COLLECTION = 0;
    private final Callback mListener;
    private final Map<NotebookKey, OngoingProgress> mOngoingProgresses;
    private final Map<CollectionKey, List<NotebookKey>> mSelectedNotebookKeys;
    private final StableIdKeyProvider<String> mStableIds;

    interface Callback {
        boolean doesCurrentNetworkProvideDownload();

        boolean isDragConfirmed();

        boolean isEmptySelectionEnabled();

        void onFolderClicked(FolderModel folderModel);

        boolean onFolderDrag(View view, FolderModel folderModel);

        void onSelectionUpdated(int i);

        void onSyncCancelRequested(FolderModel folderModel);

        void onSyncRequested(FolderModel folderModel);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public int getChildViewType(int i, int i2) {
        return 1;
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public int getParentViewType(int i) {
        return 0;
    }

    DmsAdapter(Callback callback) {
        super(new ArrayList());
        this.mOngoingProgresses = new ConcurrentHashMap();
        this.mStableIds = new StableIdKeyProvider<>();
        setHasStableIds(true);
        this.mListener = callback;
        setExpandCollapseListener(this);
        this.mSelectedNotebookKeys = new HashMap();
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public CollectionItemViewHolder onCreateParentViewHolder(ViewGroup viewGroup, int i) {
        return new CollectionItemViewHolder(viewGroup);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public DmsChildItemViewHolder onCreateChildViewHolder(ViewGroup viewGroup, int i) {
        return new NotebookItemViewHolder(viewGroup, this.mOngoingProgresses);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public void onBindParentViewHolder(CollectionItemViewHolder collectionItemViewHolder, int i, CollectionModel collectionModel) {
        collectionItemViewHolder.bind(collectionModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof CollectionItemViewHolder) {
            ((CollectionItemViewHolder) viewHolder).unbind();
        }
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public void onBindChildViewHolder(DmsChildItemViewHolder dmsChildItemViewHolder, int i, int i2, FolderModel folderModel) {
        if (dmsChildItemViewHolder instanceof NotebookItemViewHolder) {
            boolean zContainsSelectedNotebook = containsSelectedNotebook(folderModel.getNotebookKey());
            SelectionState selectionState = SelectionState.NOT_SELECTABLE;
            if (isSelectionModeEnabled()) {
                selectionState = zContainsSelectedNotebook ? SelectionState.SELECTED : SelectionState.UNSELECTED;
            }
            folderModel.setSelectionState(selectionState);
            ((NotebookItemViewHolder) dmsChildItemViewHolder).bind(folderModel, this, zContainsSelectedNotebook);
        }
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter.ExpandCollapseListener
    public void onParentExpanded(int i) {
        expandCollection(getParentList().get(i), true);
    }

    private void expandCollection(CollectionModel collectionModel, boolean z) {
        collectionModel.setExpanded(z);
    }

    void expandCollection(CollectionKey collectionKey) {
        CollectionModel collectionItem = getCollectionItem(collectionKey);
        if (collectionItem == null || collectionItem.getIsExpanded()) {
            return;
        }
        expandParent(collectionItem);
        expandCollection(collectionItem, true);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter.ExpandCollapseListener
    public void onParentCollapsed(int i) {
        expandCollection(getParentList().get(i), false);
    }

    public int getFlatParentPosition(CollectionKey collectionKey) {
        int size = 0;
        for (CollectionModel collectionModel : getParentList()) {
            if (collectionModel.getCollectionKey().equals(collectionKey)) {
                return size;
            }
            if (collectionModel.getIsExpanded()) {
                size += collectionModel.getChildList().size();
            }
            size++;
        }
        return -1;
    }

    int getFlatChildPosition(CollectionKey collectionKey, NotebookKey notebookKey) {
        CollectionModel next;
        Iterator<CollectionModel> it = getParentList().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.getCollectionKey().equals(collectionKey)) {
                break;
            }
        }
        int i = -1;
        if (next == null) {
            return -1;
        }
        int flatParentPosition = getFlatParentPosition(collectionKey);
        if (next.getIsExpanded()) {
            for (int i2 = 0; i2 < next.getChildList().size(); i2++) {
                if (next.getFolder(i2).getNotebookKey().equals(notebookKey)) {
                    i = i2;
                }
            }
            if (i >= 0) {
                return flatParentPosition + i + 1;
            }
        }
        return flatParentPosition;
    }

    void setNotebookSyncProgress(NotebookKey notebookKey, int i, int i2) {
        this.mOngoingProgresses.put(notebookKey, new OngoingProgress(i, i2));
        notifyNotebookChanged(notebookKey);
    }

    private void notifyNotebookChanged(NotebookKey notebookKey) {
        int i;
        int[] childPosition = CollectionItemsHelper.getChildPosition(getParentList(), notebookKey);
        int i2 = childPosition[0];
        if (i2 == -1 || (i = childPosition[1]) == -1) {
            return;
        }
        notifyChildChanged(i2, i);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public void setParentList(List<CollectionModel> list, boolean z) {
        ArrayList<CollectionModel> arrayList = new ArrayList();
        Iterator<CollectionModel> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CollectionModel.copy(it.next()));
        }
        if (this.mExpansionStateMap != null && !this.mExpansionStateMap.isEmpty()) {
            for (CollectionModel collectionModel : arrayList) {
                if (this.mExpansionStateMap.containsKey(collectionModel.getKey())) {
                    collectionModel.setExpanded(this.mExpansionStateMap.get(collectionModel.getKey()).booleanValue());
                }
            }
        }
        super.setParentList(arrayList, z);
    }

    private CollectionModel getCollectionItem(CollectionKey collectionKey) {
        for (CollectionModel collectionModel : getParentList()) {
            if (collectionModel.getCollectionKey().equals(collectionKey)) {
                return collectionModel;
            }
        }
        return null;
    }

    @Override // com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.OnNotebookClickedListener
    public boolean isSelectionModeEnabled() {
        return !this.mSelectedNotebookKeys.isEmpty() || this.mListener.isEmptySelectionEnabled();
    }

    @Override // com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.OnNotebookClickedListener
    public boolean doesCurrentNetworkProvideDownload() {
        return this.mListener.doesCurrentNetworkProvideDownload();
    }

    @Override // com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.OnNotebookClickedListener
    public void onSyncRequested(FolderModel folderModel) {
        Callback callback = this.mListener;
        if (callback != null) {
            callback.onSyncRequested(folderModel);
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.OnNotebookClickedListener
    public void onSyncCancelRequested(FolderModel folderModel) {
        Callback callback = this.mListener;
        if (callback != null) {
            callback.onSyncCancelRequested(folderModel);
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.OnNotebookClickedListener
    public void onNotebookClicked(FolderModel folderModel) {
        Callback callback = this.mListener;
        if (callback != null) {
            callback.onFolderClicked(folderModel);
        }
    }

    @Override // com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.OnNotebookClickedListener
    public void onSelectionChanged(FolderModel folderModel, boolean z) {
        CollectionModel parent = getParent(folderModel.getNotebookKey());
        if (parent == null) {
            return;
        }
        if (z) {
            addSelectedNotebook(parent.getCollectionKey(), folderModel.getNotebookKey());
        } else {
            removeSelectedNotebook(folderModel.getNotebookKey());
        }
        notifyNotebookChanged(folderModel.getNotebookKey());
        this.mListener.onSelectionUpdated(selectedNotebookCount());
    }

    @Override // com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.OnNotebookClickedListener
    public boolean onDragStarted(View view, FolderModel folderModel) {
        return this.mListener.onFolderDrag(view, folderModel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (i < 0 || i >= this.mFlatItemList.size()) {
            throw new IllegalStateException("Trying to get DMS item at position " + i);
        }
        ExpandableWrapper expandableWrapper = (ExpandableWrapper) this.mFlatItemList.get(i);
        if (expandableWrapper.isParent()) {
            return this.mStableIds.getItemId(((CollectionModel) expandableWrapper.getParent()).getCollectionKey().serialize());
        }
        return this.mStableIds.getItemId(((FolderModel) expandableWrapper.getChild()).getNotebookKey().serialize());
    }

    void openNotebook(NotebookKey notebookKey) {
        Iterator<CollectionModel> it = getParentList().iterator();
        while (it.hasNext()) {
            for (FolderModel folderModel : it.next().getChildList()) {
                if (folderModel.getNotebookKey().equals(notebookKey)) {
                    folderModel.setOpened(true);
                    notifyNotebookChanged(folderModel.getNotebookKey());
                } else if (folderModel.isOpened()) {
                    folderModel.setOpened(false);
                    notifyNotebookChanged(folderModel.getNotebookKey());
                }
            }
        }
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public void notifyParentDataSetChanged(boolean z) {
        if (!z) {
            super.notifyParentDataSetChanged(false);
            return;
        }
        final List<ExpandableWrapper<CollectionModel, FolderModel>> listGenerateFlattenedParentChildList = generateFlattenedParentChildList(getParentList(), this.mExpansionStateMap);
        final List<ExpandableWrapper<P, C>> list = this.mFlatItemList;
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: com.myscript.nebo.dms.expandlist.DmsAdapter.1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return list.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return listGenerateFlattenedParentChildList.size();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                if (i < 0 || i >= list.size() || i2 < 0 || i2 >= listGenerateFlattenedParentChildList.size()) {
                    return false;
                }
                ExpandableWrapper expandableWrapper = (ExpandableWrapper) list.get(i);
                ExpandableWrapper expandableWrapper2 = (ExpandableWrapper) listGenerateFlattenedParentChildList.get(i2);
                if (expandableWrapper.isParent() != expandableWrapper2.isParent()) {
                    return false;
                }
                if (expandableWrapper.isParent()) {
                    return ((CollectionModel) expandableWrapper.getParent()).equals(expandableWrapper2.getParent());
                }
                return ((FolderModel) expandableWrapper.getChild()).equals(expandableWrapper2.getChild());
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                if (i < 0 || i >= list.size() || i2 < 0 || i2 >= listGenerateFlattenedParentChildList.size()) {
                    return false;
                }
                ExpandableWrapper expandableWrapper = (ExpandableWrapper) list.get(i);
                ExpandableWrapper expandableWrapper2 = (ExpandableWrapper) listGenerateFlattenedParentChildList.get(i2);
                if (expandableWrapper.isParent() != expandableWrapper2.isParent()) {
                    return false;
                }
                if (expandableWrapper.isParent()) {
                    return DmsAdapter.areContentsTheSame((CollectionModel) expandableWrapper.getParent(), (CollectionModel) expandableWrapper2.getParent());
                }
                return DmsAdapter.areContentsTheSame((FolderModel) expandableWrapper.getChild(), (FolderModel) expandableWrapper2.getChild());
            }
        });
        this.mFlatItemList = listGenerateFlattenedParentChildList;
        diffResultCalculateDiff.dispatchUpdatesTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean areContentsTheSame(CollectionModel collectionModel, CollectionModel collectionModel2) {
        if (collectionModel == null || !collectionModel.equals(collectionModel2)) {
            return false;
        }
        return collectionModel.getChildList().size() == collectionModel2.getChildList().size() && collectionModel.getName().equals(collectionModel2.getName()) && collectionModel.getIsExpanded() == collectionModel2.getIsExpanded() && collectionModel.getIsSearch() == collectionModel2.getIsSearch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean areContentsTheSame(FolderModel folderModel, FolderModel folderModel2) {
        return folderModel != null && folderModel.equals(folderModel2) && folderModel.getName().equals(folderModel2.getName()) && folderModel.getColor() == folderModel2.getColor() && folderModel.getLastModificationDate() == folderModel2.getLastModificationDate() && folderModel.isValid() == folderModel2.isValid() && folderModel.isSupported() == folderModel2.isSupported() && folderModel.getSearchCount() == folderModel2.getSearchCount() && folderModel.isLocal() == folderModel2.isLocal();
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    protected void parentCollapsedFromViewHolder(int i) {
        if (i < 0) {
            return;
        }
        super.parentCollapsedFromViewHolder(i);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    protected void parentExpandedFromViewHolder(int i) {
        if (i < 0) {
            return;
        }
        super.parentExpandedFromViewHolder(i);
    }

    List<NotebookKey> getSelection() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<CollectionKey, List<NotebookKey>>> it = this.mSelectedNotebookKeys.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getValue());
        }
        return arrayList;
    }

    void selectAll() {
        for (CollectionModel collectionModel : getParentList()) {
            for (FolderModel folderModel : collectionModel.getChildList()) {
                if (!containsSelectedNotebook(folderModel.getNotebookKey())) {
                    addSelectedNotebook(collectionModel.getCollectionKey(), folderModel.getNotebookKey());
                }
            }
        }
        this.mListener.onSelectionUpdated(selectedNotebookCount());
        notifyDataSetChanged();
    }

    void clearSelection() {
        if (this.mSelectedNotebookKeys.isEmpty()) {
            return;
        }
        this.mSelectedNotebookKeys.clear();
        this.mListener.onSelectionUpdated(selectedNotebookCount());
    }

    private void addSelectedNotebook(CollectionKey collectionKey, NotebookKey notebookKey) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(notebookKey);
        for (Map.Entry<CollectionKey, List<NotebookKey>> entry : this.mSelectedNotebookKeys.entrySet()) {
            if (entry.getKey().equals(collectionKey)) {
                arrayList.addAll(entry.getValue());
            }
        }
        this.mSelectedNotebookKeys.put(collectionKey, arrayList);
    }

    private boolean removeSelectedNotebook(NotebookKey notebookKey) {
        CollectionKey key = null;
        for (Map.Entry<CollectionKey, List<NotebookKey>> entry : this.mSelectedNotebookKeys.entrySet()) {
            Iterator<NotebookKey> it = entry.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().equals(notebookKey)) {
                    key = entry.getKey();
                    break;
                }
            }
            if (key != null) {
                break;
            }
        }
        if (key == null) {
            return false;
        }
        LinkedList linkedList = new LinkedList(this.mSelectedNotebookKeys.remove(key));
        linkedList.remove(notebookKey);
        this.mSelectedNotebookKeys.put(key, linkedList);
        return true;
    }

    private boolean containsSelectedNotebook(NotebookKey notebookKey) {
        Iterator<Map.Entry<CollectionKey, List<NotebookKey>>> it = this.mSelectedNotebookKeys.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().contains(notebookKey)) {
                return true;
            }
        }
        return false;
    }

    private int selectedNotebookCount() {
        Iterator<Map.Entry<CollectionKey, List<NotebookKey>>> it = this.mSelectedNotebookKeys.entrySet().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().getValue().size();
        }
        return size;
    }

    @Override // com.myscript.nebo.dms.expandlist.NotebookItemViewHolder.OnNotebookClickedListener
    public boolean isDragConfirmed() {
        return this.mListener.isDragConfirmed();
    }

    private CollectionModel getParent(NotebookKey notebookKey) {
        for (CollectionModel collectionModel : getParentList()) {
            Iterator<FolderModel> it = collectionModel.getChildList().iterator();
            while (it.hasNext()) {
                if (it.next().getNotebookKey().equals(notebookKey)) {
                    return collectionModel;
                }
            }
        }
        return null;
    }

    @Deprecated
    public FolderModel getItem(NotebookKey notebookKey) {
        Iterator<CollectionModel> it = getParentList().iterator();
        while (it.hasNext()) {
            for (FolderModel folderModel : it.next().getChildList()) {
                if (folderModel.getNotebookKey().equals(notebookKey)) {
                    return folderModel;
                }
            }
        }
        return null;
    }
}
