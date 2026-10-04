package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class InitContentActivityBinding implements ViewBinding {
    public final ContentLoadingProgressBar initContentProgress;
    private final FrameLayout rootView;

    private InitContentActivityBinding(FrameLayout frameLayout, ContentLoadingProgressBar contentLoadingProgressBar) {
        this.rootView = frameLayout;
        this.initContentProgress = contentLoadingProgressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static InitContentActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static InitContentActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.init_content_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static InitContentActivityBinding bind(View view) {
        int i = C6079R.id.init_content_progress;
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) ViewBindings.findChildViewById(view, i);
        if (contentLoadingProgressBar != null) {
            return new InitContentActivityBinding((FrameLayout) view, contentLoadingProgressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
