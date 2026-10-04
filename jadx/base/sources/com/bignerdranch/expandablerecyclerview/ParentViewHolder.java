package com.bignerdranch.expandablerecyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bignerdranch.expandablerecyclerview.model.Parent;

/* JADX INFO: loaded from: classes4.dex */
public class ParentViewHolder<P extends Parent<C>, C> extends RecyclerView.ViewHolder implements View.OnClickListener {
    ExpandableRecyclerAdapter mExpandableAdapter;
    private boolean mExpanded;
    P mParent;
    private ParentViewHolderExpandCollapseListener mParentViewHolderExpandCollapseListener;

    interface ParentViewHolderExpandCollapseListener {
        void onParentCollapsed(int i);

        void onParentExpanded(int i);
    }

    public void onExpansionToggled(boolean z) {
    }

    public boolean shouldItemViewClickToggleExpansion() {
        return true;
    }

    public ParentViewHolder(View view) {
        super(view);
        this.mExpanded = false;
    }

    public P getParent() {
        return this.mParent;
    }

    public int getParentAdapterPosition() {
        int adapterPosition = getAdapterPosition();
        return adapterPosition == -1 ? adapterPosition : this.mExpandableAdapter.getNearestParentPosition(adapterPosition);
    }

    public void setMainItemClickToExpand() {
        this.itemView.setOnClickListener(this);
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    public void setExpanded(boolean z) {
        this.mExpanded = z;
    }

    void setParentViewHolderExpandCollapseListener(ParentViewHolderExpandCollapseListener parentViewHolderExpandCollapseListener) {
        this.mParentViewHolderExpandCollapseListener = parentViewHolderExpandCollapseListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mExpanded) {
            collapseView();
        } else {
            expandView();
        }
    }

    protected void expandView() {
        setExpanded(true);
        onExpansionToggled(false);
        ParentViewHolderExpandCollapseListener parentViewHolderExpandCollapseListener = this.mParentViewHolderExpandCollapseListener;
        if (parentViewHolderExpandCollapseListener != null) {
            parentViewHolderExpandCollapseListener.onParentExpanded(getAdapterPosition());
        }
    }

    protected void collapseView() {
        setExpanded(false);
        onExpansionToggled(true);
        ParentViewHolderExpandCollapseListener parentViewHolderExpandCollapseListener = this.mParentViewHolderExpandCollapseListener;
        if (parentViewHolderExpandCollapseListener != null) {
            parentViewHolderExpandCollapseListener.onParentCollapsed(getAdapterPosition());
        }
    }
}
