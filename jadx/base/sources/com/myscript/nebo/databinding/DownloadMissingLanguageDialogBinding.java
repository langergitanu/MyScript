package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadMissingLanguageDialogBinding implements ViewBinding {
    public final TextView downloadMissingLanguageMessage;
    public final ProgressBar downloadMissingLanguageProgress;
    private final LinearLayout rootView;

    private DownloadMissingLanguageDialogBinding(LinearLayout linearLayout, TextView textView, ProgressBar progressBar) {
        this.rootView = linearLayout;
        this.downloadMissingLanguageMessage = textView;
        this.downloadMissingLanguageProgress = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DownloadMissingLanguageDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DownloadMissingLanguageDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.download_missing_language_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DownloadMissingLanguageDialogBinding bind(View view) {
        int i = C6079R.id.download_missing_language_message;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C6079R.id.download_missing_language_progress;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
            if (progressBar != null) {
                return new DownloadMissingLanguageDialogBinding((LinearLayout) view, textView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
