package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.nebo.penpanel.InkTestView;

/* JADX INFO: loaded from: classes3.dex */
public final class PagePreviewPreferenceBinding implements ViewBinding {
    public final DocumentRenderingView documentRenderingView;
    public final FrameLayout pagePreview;
    public final TextView pagePreviewInkTestHereLabel;
    public final InkTestView pagePreviewInkTestView;
    public final ConstraintLayout pagePreviewLayout;
    public final ProgressBar pagePreviewLoading;
    private final ConstraintLayout rootView;

    private PagePreviewPreferenceBinding(ConstraintLayout constraintLayout, DocumentRenderingView documentRenderingView, FrameLayout frameLayout, TextView textView, InkTestView inkTestView, ConstraintLayout constraintLayout2, ProgressBar progressBar) {
        this.rootView = constraintLayout;
        this.documentRenderingView = documentRenderingView;
        this.pagePreview = frameLayout;
        this.pagePreviewInkTestHereLabel = textView;
        this.pagePreviewInkTestView = inkTestView;
        this.pagePreviewLayout = constraintLayout2;
        this.pagePreviewLoading = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PagePreviewPreferenceBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PagePreviewPreferenceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.page_preview_preference, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PagePreviewPreferenceBinding bind(View view) {
        int i = C6079R.id.document_rendering_view;
        DocumentRenderingView documentRenderingView = (DocumentRenderingView) ViewBindings.findChildViewById(view, i);
        if (documentRenderingView != null) {
            i = C6079R.id.page_preview;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = C6079R.id.page_preview_ink_test_here_label;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C6079R.id.page_preview_ink_test_view;
                    InkTestView inkTestView = (InkTestView) ViewBindings.findChildViewById(view, i);
                    if (inkTestView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = C6079R.id.page_preview_loading;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                        if (progressBar != null) {
                            return new PagePreviewPreferenceBinding(constraintLayout, documentRenderingView, frameLayout, textView, inkTestView, constraintLayout, progressBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
