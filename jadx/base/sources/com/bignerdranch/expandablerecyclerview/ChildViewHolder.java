package com.bignerdranch.expandablerecyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class ChildViewHolder<C> extends RecyclerView.ViewHolder {
    C mChild;
    ExpandableRecyclerAdapter mExpandableAdapter;

    public ChildViewHolder(View view) {
        super(view);
    }

    public C getChild() {
        return this.mChild;
    }

    public int getParentAdapterPosition() {
        int adapterPosition = getAdapterPosition();
        ExpandableRecyclerAdapter expandableRecyclerAdapter = this.mExpandableAdapter;
        if (expandableRecyclerAdapter == null || adapterPosition == -1) {
            return -1;
        }
        return expandableRecyclerAdapter.getNearestParentPosition(adapterPosition);
    }

    public int getChildAdapterPosition() {
        int adapterPosition = getAdapterPosition();
        ExpandableRecyclerAdapter expandableRecyclerAdapter = this.mExpandableAdapter;
        if (expandableRecyclerAdapter == null || adapterPosition == -1) {
            return -1;
        }
        return expandableRecyclerAdapter.getChildPosition(adapterPosition);
    }
}
