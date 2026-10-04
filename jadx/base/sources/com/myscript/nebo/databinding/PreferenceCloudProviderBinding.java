package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PreferenceCloudProviderBinding implements ViewBinding {
    public final ProgressBar cloudProviderProgress;
    private final ProgressBar rootView;

    private PreferenceCloudProviderBinding(ProgressBar progressBar, ProgressBar progressBar2) {
        this.rootView = progressBar;
        this.cloudProviderProgress = progressBar2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ProgressBar getRoot() {
        return this.rootView;
    }

    public static PreferenceCloudProviderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PreferenceCloudProviderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.preference_cloud_provider, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PreferenceCloudProviderBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ProgressBar progressBar = (ProgressBar) view;
        return new PreferenceCloudProviderBinding(progressBar, progressBar);
    }
}
