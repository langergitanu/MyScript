package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class ManagePagesDialogBinding implements ViewBinding {
    public final ComposeView managePagesDialogCompose;
    public final MaterialToolbar managePagesDialogFragmentToolbar;
    public final FrameLayout managePagesDialogFragmentToolbarContainer;
    private final LinearLayout rootView;

    private ManagePagesDialogBinding(LinearLayout linearLayout, ComposeView composeView, MaterialToolbar materialToolbar, FrameLayout frameLayout) {
        this.rootView = linearLayout;
        this.managePagesDialogCompose = composeView;
        this.managePagesDialogFragmentToolbar = materialToolbar;
        this.managePagesDialogFragmentToolbarContainer = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ManagePagesDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ManagePagesDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.manage_pages_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ManagePagesDialogBinding bind(View view) {
        int i = C6079R.id.manage_pages_dialog_compose;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
        if (composeView != null) {
            i = C6079R.id.manage_pages_dialog_fragment_toolbar;
            MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
            if (materialToolbar != null) {
                i = C6079R.id.manage_pages_dialog_fragment_toolbar_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    return new ManagePagesDialogBinding((LinearLayout) view, composeView, materialToolbar, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
