package com.myscript.nebo.languagemanager.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.languagemanager.C6611R;

/* JADX INFO: loaded from: classes7.dex */
public final class LanguageManagerFragmentBinding implements ViewBinding {
    public final FrameLayout dmsRmcFragmentLanguageContainer;
    public final RecyclerView languageList;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final TextView txtLanguageInfo;

    private LanguageManagerFragmentBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, RecyclerView recyclerView, ProgressBar progressBar, TextView textView) {
        this.rootView = constraintLayout;
        this.dmsRmcFragmentLanguageContainer = frameLayout;
        this.languageList = recyclerView;
        this.progressBar = progressBar;
        this.txtLanguageInfo = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LanguageManagerFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LanguageManagerFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6611R.layout.language_manager_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LanguageManagerFragmentBinding bind(View view) {
        int i = C6611R.id.dms_rmc_fragment_language_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C6611R.id.language_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = C6611R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = C6611R.id.txt_language_info;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new LanguageManagerFragmentBinding((ConstraintLayout) view, frameLayout, recyclerView, progressBar, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
