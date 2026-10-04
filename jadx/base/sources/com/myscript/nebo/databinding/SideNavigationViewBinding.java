package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class SideNavigationViewBinding implements ViewBinding {
    public final BottomNavigationView bottomNavigation;
    public final ImageView retailQrCard;
    private final ConstraintLayout rootView;
    public final FrameLayout sideNavigationAppBarFrame;
    public final ConstraintLayout sideNavigationContent;
    public final FragmentContainerView sideNavigationFragmentContainer;
    public final MaterialToolbar sideNavigationToolbar;
    public final AppBarLayout sideNavigationViewAppbarlayout;

    private SideNavigationViewBinding(ConstraintLayout constraintLayout, BottomNavigationView bottomNavigationView, ImageView imageView, FrameLayout frameLayout, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView, MaterialToolbar materialToolbar, AppBarLayout appBarLayout) {
        this.rootView = constraintLayout;
        this.bottomNavigation = bottomNavigationView;
        this.retailQrCard = imageView;
        this.sideNavigationAppBarFrame = frameLayout;
        this.sideNavigationContent = constraintLayout2;
        this.sideNavigationFragmentContainer = fragmentContainerView;
        this.sideNavigationToolbar = materialToolbar;
        this.sideNavigationViewAppbarlayout = appBarLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SideNavigationViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SideNavigationViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.side_navigation_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static SideNavigationViewBinding bind(View view) {
        int i = C6079R.id.bottom_navigation;
        BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(view, i);
        if (bottomNavigationView != null) {
            i = C6079R.id.retail_qr_card;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C6079R.id.side_navigation_app_bar_frame;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = C6079R.id.side_navigation_fragment_container;
                    FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                    if (fragmentContainerView != null) {
                        i = C6079R.id.side_navigation_toolbar;
                        MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                        if (materialToolbar != null) {
                            i = C6079R.id.side_navigation_view_appbarlayout;
                            AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i);
                            if (appBarLayout != null) {
                                return new SideNavigationViewBinding(constraintLayout, bottomNavigationView, imageView, frameLayout, constraintLayout, fragmentContainerView, materialToolbar, appBarLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
