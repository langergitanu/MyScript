package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class TrashScreenToolbarBinding implements ViewBinding {
    private final AppBarLayout rootView;
    public final AppBarLayout trashedPagesAppBar;
    public final MaterialToolbar trashedPagesToolbar;
    public final FrameLayout trashedPagesToolbarContainer;

    private TrashScreenToolbarBinding(AppBarLayout appBarLayout, AppBarLayout appBarLayout2, MaterialToolbar materialToolbar, FrameLayout frameLayout) {
        this.rootView = appBarLayout;
        this.trashedPagesAppBar = appBarLayout2;
        this.trashedPagesToolbar = materialToolbar;
        this.trashedPagesToolbarContainer = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public AppBarLayout getRoot() {
        return this.rootView;
    }

    public static TrashScreenToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TrashScreenToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.trash_screen_toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TrashScreenToolbarBinding bind(View view) {
        AppBarLayout appBarLayout = (AppBarLayout) view;
        int i = C6079R.id.trashed_pages_toolbar;
        MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
        if (materialToolbar != null) {
            i = C6079R.id.trashed_pages_toolbar_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                return new TrashScreenToolbarBinding(appBarLayout, appBarLayout, materialToolbar, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
