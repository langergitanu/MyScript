package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PageBackgroundLayoutBinding implements ViewBinding {
    public final RecyclerView backgroundColorList;
    public final TextView backgroundColorListTitle;
    public final TextView backgroundDialogTitle;
    public final RecyclerView backgroundPatternList;
    public final TextView backgroundPatternListTitle;
    public final MaterialCardView pageBackgroundNotebookWarning;
    private final LinearLayout rootView;

    private PageBackgroundLayoutBinding(LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, RecyclerView recyclerView2, TextView textView3, MaterialCardView materialCardView) {
        this.rootView = linearLayout;
        this.backgroundColorList = recyclerView;
        this.backgroundColorListTitle = textView;
        this.backgroundDialogTitle = textView2;
        this.backgroundPatternList = recyclerView2;
        this.backgroundPatternListTitle = textView3;
        this.pageBackgroundNotebookWarning = materialCardView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PageBackgroundLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PageBackgroundLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.page_background_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PageBackgroundLayoutBinding bind(View view) {
        int i = C6079R.id.background_color_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = C6079R.id.background_color_list_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C6079R.id.background_dialog_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = C6079R.id.background_pattern_list;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView2 != null) {
                        i = C6079R.id.background_pattern_list_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = C6079R.id.page_background_notebook_warning;
                            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                            if (materialCardView != null) {
                                return new PageBackgroundLayoutBinding((LinearLayout) view, recyclerView, textView, textView2, recyclerView2, textView3, materialCardView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
