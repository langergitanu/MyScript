package com.myscript.nebo.dms.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.myscript.nebo.dms.C6208R;

/* JADX INFO: loaded from: classes7.dex */
public class SearchBar extends RelativeLayout {
    private View mProgress;
    private View mRootView;
    private TextView mText;

    public SearchBar(Context context) {
        super(context);
        init();
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SearchBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C6208R.layout.view_bar_search, (ViewGroup) this, true);
        this.mRootView = viewInflate;
        TextView textView = (TextView) viewInflate.findViewById(C6208R.id.view_dms_search_label);
        this.mText = textView;
        textView.setText(getResources().getQuantityString(C6208R.plurals.search_result_folders, 0, 0));
        View viewFindViewById = this.mRootView.findViewById(C6208R.id.view_dms_search_progress);
        this.mProgress = viewFindViewById;
        viewFindViewById.setVisibility(8);
    }

    public void setSearchResult(int i, int i2) {
        Resources resources = getResources();
        this.mText.setText(resources.getString(C6208R.string.search_results, resources.getQuantityString(C6208R.plurals.search_result_count, i2, Integer.valueOf(i2)), resources.getQuantityString(C6208R.plurals.search_result_folders, i, Integer.valueOf(i))));
    }

    public void showProgress(boolean z) {
        View view = this.mProgress;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
