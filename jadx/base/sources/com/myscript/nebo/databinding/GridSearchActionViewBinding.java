package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class GridSearchActionViewBinding implements ViewBinding {
    public final ImageView actionCloseSearch;
    public final ImageView actionSearch;
    public final AutoCompleteTextView edittextSearch;
    public final LinearLayout gridViewToolbarActions;
    private final LinearLayout rootView;

    private GridSearchActionViewBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, AutoCompleteTextView autoCompleteTextView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.actionCloseSearch = imageView;
        this.actionSearch = imageView2;
        this.edittextSearch = autoCompleteTextView;
        this.gridViewToolbarActions = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static GridSearchActionViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GridSearchActionViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.grid_search_action_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static GridSearchActionViewBinding bind(View view) {
        int i = C6079R.id.action_close_search;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = C6079R.id.action_search;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = C6079R.id.edittext_search;
                AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                if (autoCompleteTextView != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new GridSearchActionViewBinding(linearLayout, imageView, imageView2, autoCompleteTextView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
