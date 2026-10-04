package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.editing.PageIndicatorEditText;

/* JADX INFO: loaded from: classes3.dex */
public final class ChildPagesFragmentBinding implements ViewBinding {
    public final ComposeView childPagesList;
    public final PageIndicatorEditText childPagesWidget;
    public final ComposeView discoverabilityTooltip;
    private final FrameLayout rootView;

    private ChildPagesFragmentBinding(FrameLayout frameLayout, ComposeView composeView, PageIndicatorEditText pageIndicatorEditText, ComposeView composeView2) {
        this.rootView = frameLayout;
        this.childPagesList = composeView;
        this.childPagesWidget = pageIndicatorEditText;
        this.discoverabilityTooltip = composeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ChildPagesFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ChildPagesFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.child_pages_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ChildPagesFragmentBinding bind(View view) {
        int i = C6079R.id.child_pages_list;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
        if (composeView != null) {
            i = C6079R.id.child_pages_widget;
            PageIndicatorEditText pageIndicatorEditText = (PageIndicatorEditText) ViewBindings.findChildViewById(view, i);
            if (pageIndicatorEditText != null) {
                i = C6079R.id.discoverability_tooltip;
                ComposeView composeView2 = (ComposeView) ViewBindings.findChildViewById(view, i);
                if (composeView2 != null) {
                    return new ChildPagesFragmentBinding((FrameLayout) view, composeView, pageIndicatorEditText, composeView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
