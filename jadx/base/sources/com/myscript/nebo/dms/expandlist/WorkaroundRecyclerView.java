package com.myscript.nebo.dms.expandlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes7.dex */
public class WorkaroundRecyclerView extends RecyclerView {
    public WorkaroundRecyclerView(Context context) {
        super(context);
    }

    public WorkaroundRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WorkaroundRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollToPosition(int i) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || adapter.getItemCount() >= i) {
            return;
        }
        super.smoothScrollToPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null || adapter.getItemCount() >= i) {
            return;
        }
        super.scrollToPosition(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        super.addView(view);
    }
}
