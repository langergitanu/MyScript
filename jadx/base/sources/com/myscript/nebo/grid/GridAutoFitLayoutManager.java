package com.myscript.nebo.grid;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.android.utils.ScreenUtils;

/* JADX INFO: loaded from: classes7.dex */
public class GridAutoFitLayoutManager extends GridLayoutManager {
    private static int DP_STEP = 240;
    private Context mContext;

    GridAutoFitLayoutManager(Context context) {
        super(context, 1);
        this.mContext = context;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iRound = Math.round(ScreenUtils.pxToDp(this.mContext, (getWidth() - getPaddingRight()) - getPaddingLeft()) / DP_STEP) + 1;
        if (getSpanCount() != iRound) {
            setSpanCount(iRound);
        }
        super.onLayoutChildren(recycler, state);
    }
}
