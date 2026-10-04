package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class SearchResultsBinding implements ViewBinding {
    public final TextView hits;
    public final TextView navHits;
    private final ConstraintLayout rootView;
    public final ImageView searchNext;
    public final ImageView searchPrevious;
    public final ConstraintLayout searchResultsLayout;
    public final ProgressBar secondaryToolbarSearchProgressBar;

    private SearchResultsBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ProgressBar progressBar) {
        this.rootView = constraintLayout;
        this.hits = textView;
        this.navHits = textView2;
        this.searchNext = imageView;
        this.searchPrevious = imageView2;
        this.searchResultsLayout = constraintLayout2;
        this.secondaryToolbarSearchProgressBar = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SearchResultsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SearchResultsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.search_results, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SearchResultsBinding bind(View view) {
        int i = C6079R.id.hits;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C6079R.id.nav_hits;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = C6079R.id.search_next;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C6079R.id.search_previous;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = C6079R.id.secondary_toolbar_search_progressBar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            return new SearchResultsBinding(constraintLayout, textView, textView2, imageView, imageView2, constraintLayout, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
