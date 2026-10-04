package com.bignerdranch.expandablerecyclerview;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.bignerdranch.expandablerecyclerview.model.ExpandableWrapper;
import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ExpandableRecyclerAdapter<P extends Parent<C>, C, PVH extends ParentViewHolder, CVH extends ChildViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String EXPANDED_STATE_MAP = "ExpandableRecyclerAdapter.ExpandedStateMap";
    private static final int INVALID_FLAT_POSITION = -1;
    public static final int TYPE_CHILD = 1;
    public static final int TYPE_FIRST_USER = 2;
    public static final int TYPE_PARENT = 0;
    private ExpandCollapseListener mExpandCollapseListener;
    protected Map<String, Boolean> mExpansionStateMap;
    protected List<ExpandableWrapper<P, C>> mFlatItemList;
    private List<P> mParentList;
    private ParentViewHolder.ParentViewHolderExpandCollapseListener mParentViewHolderExpandCollapseListener = new ParentViewHolder.ParentViewHolderExpandCollapseListener() { // from class: com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter.1
        @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder.ParentViewHolderExpandCollapseListener
        public void onParentExpanded(int i) {
            ExpandableRecyclerAdapter.this.parentExpandedFromViewHolder(i);
        }

        @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder.ParentViewHolderExpandCollapseListener
        public void onParentCollapsed(int i) {
            ExpandableRecyclerAdapter.this.parentCollapsedFromViewHolder(i);
        }
    };
    private List<RecyclerView> mAttachedRecyclerViewPool = new ArrayList();

    public interface ExpandCollapseListener {
        void onParentCollapsed(int i);

        void onParentExpanded(int i);
    }

    public int getChildViewType(int i, int i2) {
        return 1;
    }

    public int getParentViewType(int i) {
        return 0;
    }

    public boolean isParentViewType(int i) {
        return i == 0;
    }

    public abstract void onBindChildViewHolder(CVH cvh, int i, int i2, C c);

    public abstract void onBindParentViewHolder(PVH pvh, int i, P p);

    public abstract CVH onCreateChildViewHolder(ViewGroup viewGroup, int i);

    public abstract PVH onCreateParentViewHolder(ViewGroup viewGroup, int i);

    public ExpandableRecyclerAdapter(List<P> list) {
        this.mParentList = list;
        this.mFlatItemList = generateFlattenedParentChildList(list);
        this.mExpansionStateMap = new HashMap(this.mParentList.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (isParentViewType(i)) {
            ParentViewHolder parentViewHolderOnCreateParentViewHolder = onCreateParentViewHolder(viewGroup, i);
            parentViewHolderOnCreateParentViewHolder.setParentViewHolderExpandCollapseListener(this.mParentViewHolderExpandCollapseListener);
            parentViewHolderOnCreateParentViewHolder.mExpandableAdapter = this;
            return parentViewHolderOnCreateParentViewHolder;
        }
        ChildViewHolder childViewHolderOnCreateChildViewHolder = onCreateChildViewHolder(viewGroup, i);
        childViewHolderOnCreateChildViewHolder.mExpandableAdapter = this;
        return childViewHolderOnCreateChildViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (i > this.mFlatItemList.size()) {
            throw new IllegalStateException("Trying to bind item out of bounds, size " + this.mFlatItemList.size() + " flatPosition " + i + ". Was the data changed without a call to notify...()?");
        }
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(i);
        if (expandableWrapper.isParent()) {
            ParentViewHolder parentViewHolder = (ParentViewHolder) viewHolder;
            if (parentViewHolder.shouldItemViewClickToggleExpansion()) {
                parentViewHolder.setMainItemClickToExpand();
            }
            parentViewHolder.setExpanded(expandableWrapper.isExpanded());
            parentViewHolder.mParent = (P) expandableWrapper.getParent();
            onBindParentViewHolder(parentViewHolder, getNearestParentPosition(i), expandableWrapper.getParent());
            return;
        }
        ChildViewHolder childViewHolder = (ChildViewHolder) viewHolder;
        childViewHolder.mChild = expandableWrapper.getChild();
        onBindChildViewHolder(childViewHolder, getNearestParentPosition(i), getChildPosition(i), expandableWrapper.getChild());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mFlatItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.mFlatItemList.get(i).isParent()) {
            return getParentViewType(getNearestParentPosition(i));
        }
        return getChildViewType(getNearestParentPosition(i), getChildPosition(i));
    }

    public List<P> getParentList() {
        return this.mParentList;
    }

    public void setParentList(List<P> list, boolean z) {
        this.mParentList = list;
        notifyParentDataSetChanged(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mAttachedRecyclerViewPool.add(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mAttachedRecyclerViewPool.remove(recyclerView);
    }

    public void setExpandCollapseListener(ExpandCollapseListener expandCollapseListener) {
        this.mExpandCollapseListener = expandCollapseListener;
    }

    protected void parentExpandedFromViewHolder(int i) {
        updateExpandedParent(this.mFlatItemList.get(i), i, true);
    }

    protected void parentCollapsedFromViewHolder(int i) {
        updateCollapsedParent(this.mFlatItemList.get(i), i, true);
    }

    public void expandParent(P p) {
        int iIndexOf = this.mFlatItemList.indexOf(new ExpandableWrapper((Parent) p));
        if (iIndexOf == -1) {
            return;
        }
        expandViews(this.mFlatItemList.get(iIndexOf), iIndexOf);
    }

    public void expandParent(int i) {
        expandParent(this.mParentList.get(i));
    }

    public void expandParentRange(int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            expandParent(i);
            i++;
        }
    }

    public void expandAllParents() {
        Iterator<P> it = this.mParentList.iterator();
        while (it.hasNext()) {
            expandParent(it.next());
        }
    }

    public void collapseParent(P p) {
        int iIndexOf = this.mFlatItemList.indexOf(new ExpandableWrapper((Parent) p));
        if (iIndexOf == -1) {
            return;
        }
        collapseViews(this.mFlatItemList.get(iIndexOf), iIndexOf);
    }

    public void collapseParent(int i) {
        collapseParent(this.mParentList.get(i));
    }

    public void collapseParentRange(int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            collapseParent(i);
            i++;
        }
    }

    public void collapseAllParents() {
        Iterator<P> it = this.mParentList.iterator();
        while (it.hasNext()) {
            collapseParent(it.next());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable(EXPANDED_STATE_MAP, generateExpandedStateMap());
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(EXPANDED_STATE_MAP)) {
            return;
        }
        HashMap map = (HashMap) bundle.getSerializable(EXPANDED_STATE_MAP);
        this.mExpansionStateMap = map;
        if (map == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.mParentList.size();
        for (int i = 0; i < size; i++) {
            ExpandableWrapper expandableWrapper = new ExpandableWrapper((Parent) this.mParentList.get(i));
            arrayList.add(expandableWrapper);
            if (this.mExpansionStateMap.containsKey(Integer.valueOf(i))) {
                boolean zBooleanValue = this.mExpansionStateMap.get(Integer.valueOf(i)).booleanValue();
                expandableWrapper.setExpanded(zBooleanValue);
                if (zBooleanValue) {
                    List<ExpandableWrapper<P, C>> wrappedChildList = expandableWrapper.getWrappedChildList();
                    int size2 = wrappedChildList.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        arrayList.add(wrappedChildList.get(i2));
                    }
                }
            }
        }
        this.mFlatItemList = arrayList;
        notifyDataSetChanged();
    }

    private void expandViews(ExpandableWrapper<P, C> expandableWrapper, int i) {
        Iterator<RecyclerView> it = this.mAttachedRecyclerViewPool.iterator();
        while (it.hasNext()) {
            ParentViewHolder parentViewHolder = (ParentViewHolder) it.next().findViewHolderForAdapterPosition(i);
            if (parentViewHolder != null && !parentViewHolder.isExpanded()) {
                parentViewHolder.setExpanded(true);
                parentViewHolder.onExpansionToggled(false);
            }
        }
        updateExpandedParent(expandableWrapper, i, false);
    }

    private void collapseViews(ExpandableWrapper<P, C> expandableWrapper, int i) {
        Iterator<RecyclerView> it = this.mAttachedRecyclerViewPool.iterator();
        while (it.hasNext()) {
            ParentViewHolder parentViewHolder = (ParentViewHolder) it.next().findViewHolderForAdapterPosition(i);
            if (parentViewHolder != null && parentViewHolder.isExpanded()) {
                parentViewHolder.setExpanded(false);
                parentViewHolder.onExpansionToggled(true);
            }
        }
        updateCollapsedParent(expandableWrapper, i, false);
    }

    private void updateExpandedParent(ExpandableWrapper<P, C> expandableWrapper, int i, boolean z) {
        ExpandCollapseListener expandCollapseListener;
        if (expandableWrapper.isExpanded()) {
            return;
        }
        expandableWrapper.setExpanded(true);
        this.mExpansionStateMap.put(expandableWrapper.getParent().getKey(), true);
        List<ExpandableWrapper<P, C>> wrappedChildList = expandableWrapper.getWrappedChildList();
        if (wrappedChildList != null) {
            int size = wrappedChildList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mFlatItemList.add(i + i2 + 1, wrappedChildList.get(i2));
            }
            notifyItemRangeInserted(i + 1, size);
        }
        if (!z || (expandCollapseListener = this.mExpandCollapseListener) == null) {
            return;
        }
        expandCollapseListener.onParentExpanded(getNearestParentPosition(i));
    }

    private void updateCollapsedParent(ExpandableWrapper<P, C> expandableWrapper, int i, boolean z) {
        ExpandCollapseListener expandCollapseListener;
        if (expandableWrapper.isExpanded()) {
            expandableWrapper.setExpanded(false);
            this.mExpansionStateMap.put(expandableWrapper.getParent().getKey(), false);
            List<ExpandableWrapper<P, C>> wrappedChildList = expandableWrapper.getWrappedChildList();
            if (wrappedChildList != null) {
                int size = wrappedChildList.size();
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    this.mFlatItemList.remove(i + i2 + 1);
                }
                notifyItemRangeRemoved(i + 1, size);
            }
            if (!z || (expandCollapseListener = this.mExpandCollapseListener) == null) {
                return;
            }
            expandCollapseListener.onParentCollapsed(getNearestParentPosition(i));
        }
    }

    int getNearestParentPosition(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = -1;
        for (int i3 = 0; i3 <= i; i3++) {
            if (this.mFlatItemList.get(i3).isParent()) {
                i2++;
            }
        }
        return i2;
    }

    int getChildPosition(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = this.mFlatItemList.get(i3).isParent() ? 0 : i2 + 1;
        }
        return i2;
    }

    public void notifyParentDataSetChanged(boolean z) {
        if (z) {
            this.mFlatItemList = generateFlattenedParentChildList(this.mParentList, this.mExpansionStateMap);
        } else {
            this.mFlatItemList = generateFlattenedParentChildList(this.mParentList);
        }
        notifyDataSetChanged();
    }

    public void notifyParentInserted(int i) {
        int size;
        P p = this.mParentList.get(i);
        if (i < this.mParentList.size() - 1) {
            size = getFlatParentPosition(i);
        } else {
            size = this.mFlatItemList.size();
        }
        notifyItemRangeInserted(size, addParentWrapper(size, p));
    }

    public void notifyParentRangeInserted(int i, int i2) {
        int size;
        if (i < this.mParentList.size() - i2) {
            size = getFlatParentPosition(i);
        } else {
            size = this.mFlatItemList.size();
        }
        int i3 = i2 + i;
        int i4 = 0;
        int i5 = size;
        while (i < i3) {
            int iAddParentWrapper = addParentWrapper(i5, this.mParentList.get(i));
            i5 += iAddParentWrapper;
            i4 += iAddParentWrapper;
            i++;
        }
        notifyItemRangeInserted(size, i4);
    }

    private int addParentWrapper(int i, P p) {
        ExpandableWrapper<P, C> expandableWrapper = new ExpandableWrapper<>((Parent) p);
        this.mFlatItemList.add(i, expandableWrapper);
        if (!expandableWrapper.isParentInitiallyExpanded()) {
            return 1;
        }
        expandableWrapper.setExpanded(true);
        List<ExpandableWrapper<P, C>> wrappedChildList = expandableWrapper.getWrappedChildList();
        this.mFlatItemList.addAll(i + 1, wrappedChildList);
        return wrappedChildList.size() + 1;
    }

    public void notifyParentRemoved(int i) {
        int flatParentPosition = getFlatParentPosition(i);
        notifyItemRangeRemoved(flatParentPosition, removeParentWrapper(flatParentPosition));
    }

    public void notifyParentRangeRemoved(int i, int i2) {
        int flatParentPosition = getFlatParentPosition(i);
        int iRemoveParentWrapper = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            iRemoveParentWrapper += removeParentWrapper(flatParentPosition);
        }
        notifyItemRangeRemoved(flatParentPosition, iRemoveParentWrapper);
    }

    private int removeParentWrapper(int i) {
        ExpandableWrapper<P, C> expandableWrapperRemove = this.mFlatItemList.remove(i);
        int i2 = 1;
        if (expandableWrapperRemove.isExpanded()) {
            int size = expandableWrapperRemove.getWrappedChildList().size();
            for (int i3 = 0; i3 < size; i3++) {
                this.mFlatItemList.remove(i);
                i2++;
            }
        }
        return i2;
    }

    public void notifyParentChanged(int i) {
        P p = this.mParentList.get(i);
        int flatParentPosition = getFlatParentPosition(i);
        notifyItemRangeChanged(flatParentPosition, changeParentWrapper(flatParentPosition, p));
    }

    public void notifyParentRangeChanged(int i, int i2) {
        int flatParentPosition = getFlatParentPosition(i);
        int i3 = flatParentPosition;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int iChangeParentWrapper = changeParentWrapper(i3, this.mParentList.get(i));
            i4 += iChangeParentWrapper;
            i3 += iChangeParentWrapper;
            i++;
        }
        notifyItemRangeChanged(flatParentPosition, i4);
    }

    private int changeParentWrapper(int i, P p) {
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(i);
        expandableWrapper.setParent(p);
        if (!expandableWrapper.isExpanded()) {
            return 1;
        }
        List<ExpandableWrapper<P, C>> wrappedChildList = expandableWrapper.getWrappedChildList();
        int size = wrappedChildList.size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            this.mFlatItemList.set(i + i3 + 1, wrappedChildList.get(i3));
            i2++;
        }
        return i2;
    }

    public void notifyParentMoved(int i, int i2) {
        int flatParentPosition = getFlatParentPosition(i);
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(flatParentPosition);
        boolean zIsExpanded = expandableWrapper.isExpanded();
        int size = (!zIsExpanded || (zIsExpanded && expandableWrapper.getWrappedChildList().size() == 0)) ? 0 : expandableWrapper.getWrappedChildList().size();
        int size2 = 0;
        for (int i3 = 0; i3 < size + 1; i3++) {
            this.mFlatItemList.remove(flatParentPosition);
            size2++;
        }
        notifyItemRangeRemoved(flatParentPosition, size2);
        int flatParentPosition2 = getFlatParentPosition(i2);
        if (flatParentPosition2 == -1) {
            flatParentPosition2 = this.mFlatItemList.size();
        }
        this.mFlatItemList.add(flatParentPosition2, expandableWrapper);
        if (size > 0) {
            List<ExpandableWrapper<P, C>> wrappedChildList = expandableWrapper.getWrappedChildList();
            size2 = wrappedChildList.size() + 1;
            this.mFlatItemList.addAll(flatParentPosition2 + 1, wrappedChildList);
        }
        this.mExpansionStateMap.put(expandableWrapper.getParent().getKey(), Boolean.valueOf(expandableWrapper.isExpanded()));
        Iterator<Map.Entry<String, Boolean>> it = this.mExpansionStateMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Boolean> next = it.next();
            Iterator<P> it2 = this.mParentList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (next.getKey().equals(it2.next().getKey())) {
                        break;
                    }
                } else {
                    it.remove();
                    break;
                }
            }
        }
        notifyItemRangeInserted(flatParentPosition2, size2);
    }

    public void notifyChildInserted(int i, int i2) {
        int flatParentPosition = getFlatParentPosition(i);
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(flatParentPosition);
        expandableWrapper.setParent(this.mParentList.get(i));
        if (expandableWrapper.isExpanded()) {
            int i3 = flatParentPosition + i2 + 1;
            this.mFlatItemList.add(i3, expandableWrapper.getWrappedChildList().get(i2));
            notifyItemInserted(i3);
        }
    }

    public void notifyChildRangeInserted(int i, int i2, int i3) {
        int flatParentPosition = getFlatParentPosition(i);
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(flatParentPosition);
        expandableWrapper.setParent(this.mParentList.get(i));
        if (expandableWrapper.isExpanded()) {
            List<ExpandableWrapper<P, C>> wrappedChildList = expandableWrapper.getWrappedChildList();
            for (int i4 = 0; i4 < i3; i4++) {
                this.mFlatItemList.add(flatParentPosition + i2 + i4 + 1, wrappedChildList.get(i2 + i4));
            }
            notifyItemRangeInserted(flatParentPosition + i2 + 1, i3);
        }
    }

    public void notifyChildRemoved(int i, int i2) {
        int flatParentPosition = getFlatParentPosition(i);
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(flatParentPosition);
        expandableWrapper.setParent(this.mParentList.get(i));
        if (expandableWrapper.isExpanded()) {
            int i3 = flatParentPosition + i2 + 1;
            this.mFlatItemList.remove(i3);
            notifyItemRemoved(i3);
        }
    }

    public void notifyChildRangeRemoved(int i, int i2, int i3) {
        int flatParentPosition = getFlatParentPosition(i);
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(flatParentPosition);
        expandableWrapper.setParent(this.mParentList.get(i));
        if (expandableWrapper.isExpanded()) {
            for (int i4 = 0; i4 < i3; i4++) {
                this.mFlatItemList.remove(flatParentPosition + i2 + 1);
            }
            notifyItemRangeRemoved(flatParentPosition + i2 + 1, i3);
        }
    }

    public void notifyChildChanged(int i, int i2) {
        P p = this.mParentList.get(i);
        int flatParentPosition = getFlatParentPosition(i);
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(flatParentPosition);
        expandableWrapper.setParent(p);
        if (expandableWrapper.isExpanded()) {
            int i3 = flatParentPosition + i2 + 1;
            this.mFlatItemList.set(i3, expandableWrapper.getWrappedChildList().get(i2));
            notifyItemChanged(i3);
        }
    }

    public void notifyChildRangeChanged(int i, int i2, int i3) {
        P p = this.mParentList.get(i);
        int flatParentPosition = getFlatParentPosition(i);
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(flatParentPosition);
        expandableWrapper.setParent(p);
        if (expandableWrapper.isExpanded()) {
            int i4 = flatParentPosition + i2 + 1;
            for (int i5 = 0; i5 < i3; i5++) {
                this.mFlatItemList.set(i4 + i5, expandableWrapper.getWrappedChildList().get(i2 + i5));
            }
            notifyItemRangeChanged(i4, i3);
        }
    }

    public void notifyChildMoved(int i, int i2, int i3) {
        P p = this.mParentList.get(i);
        int flatParentPosition = getFlatParentPosition(i);
        ExpandableWrapper<P, C> expandableWrapper = this.mFlatItemList.get(flatParentPosition);
        expandableWrapper.setParent(p);
        if (expandableWrapper.isExpanded()) {
            int i4 = flatParentPosition + 1;
            int i5 = i2 + i4;
            int i6 = i4 + i3;
            this.mFlatItemList.add(i6, this.mFlatItemList.remove(i5));
            notifyItemMoved(i5, i6);
        }
    }

    public List<ExpandableWrapper<P, C>> generateFlattenedParentChildList(List<P> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            P p = list.get(i);
            generateParentWrapper(arrayList, p, p.isInitiallyExpanded());
        }
        return arrayList;
    }

    protected List<ExpandableWrapper<P, C>> generateFlattenedParentChildList(List<P> list, Map<String, Boolean> map) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            P p = list.get(i);
            Boolean bool = map.get(p.getKey());
            generateParentWrapper(arrayList, p, bool == null ? p.isInitiallyExpanded() : bool.booleanValue());
        }
        return arrayList;
    }

    private void generateParentWrapper(List<ExpandableWrapper<P, C>> list, P p, boolean z) {
        ExpandableWrapper<P, C> expandableWrapper = new ExpandableWrapper<>((Parent) p);
        list.add(expandableWrapper);
        if (z) {
            generateExpandedChildren(list, expandableWrapper);
        }
    }

    private void generateExpandedChildren(List<ExpandableWrapper<P, C>> list, ExpandableWrapper<P, C> expandableWrapper) {
        expandableWrapper.setExpanded(true);
        List<ExpandableWrapper<P, C>> wrappedChildList = expandableWrapper.getWrappedChildList();
        int size = wrappedChildList.size();
        for (int i = 0; i < size; i++) {
            list.add(wrappedChildList.get(i));
        }
    }

    private HashMap<String, Boolean> generateExpandedStateMap() {
        HashMap<String, Boolean> map = new HashMap<>();
        map.putAll(this.mExpansionStateMap);
        return map;
    }

    private int getFlatParentPosition(int i) {
        int size = this.mFlatItemList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mFlatItemList.get(i3).isParent() && (i2 = i2 + 1) > i) {
                return i3;
            }
        }
        return -1;
    }
}
