package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.nebo.editing.impl.p027ui.NestedScrollableSwipeFilter;

/* JADX INFO: loaded from: classes3.dex */
public final class PageFragmentBinding implements ViewBinding {
    public final DocumentRenderingView documentRenderingView;
    public final ConstraintLayout editingConstraintLayout;
    public final View editingContentTouchInterceptor;
    public final FrameLayout editingLayout;
    public final NestedScrollableSwipeFilter nestedViewpagerHost;
    public final FrameLayout pageFragmentLoadingProgressBar;
    public final ImageView pageFragmentPlaceholder;
    private final ConstraintLayout rootView;

    private PageFragmentBinding(ConstraintLayout constraintLayout, DocumentRenderingView documentRenderingView, ConstraintLayout constraintLayout2, View view, FrameLayout frameLayout, NestedScrollableSwipeFilter nestedScrollableSwipeFilter, FrameLayout frameLayout2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.documentRenderingView = documentRenderingView;
        this.editingConstraintLayout = constraintLayout2;
        this.editingContentTouchInterceptor = view;
        this.editingLayout = frameLayout;
        this.nestedViewpagerHost = nestedScrollableSwipeFilter;
        this.pageFragmentLoadingProgressBar = frameLayout2;
        this.pageFragmentPlaceholder = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PageFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PageFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.page_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PageFragmentBinding bind(View view) {
        int i = C6079R.id.document_rendering_view;
        DocumentRenderingView documentRenderingView = (DocumentRenderingView) ViewBindings.findChildViewById(view, i);
        if (documentRenderingView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = C6079R.id.editing_content_touch_interceptor;
            View viewFindChildViewById = ViewBindings.findChildViewById(view, i);
            if (viewFindChildViewById != null) {
                i = C6079R.id.editing_layout;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = C6079R.id.nested_viewpager_host;
                    NestedScrollableSwipeFilter nestedScrollableSwipeFilter = (NestedScrollableSwipeFilter) ViewBindings.findChildViewById(view, i);
                    if (nestedScrollableSwipeFilter != null) {
                        i = C6079R.id.page_fragment_loading_progressBar;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = C6079R.id.page_fragment_placeholder;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                return new PageFragmentBinding(constraintLayout, documentRenderingView, constraintLayout, viewFindChildViewById, frameLayout, nestedScrollableSwipeFilter, frameLayout2, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
