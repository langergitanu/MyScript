package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.android.utils.FloatingActionButtonMenu;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.banner.BannerLayout;
import com.myscript.nebo.freemium.FreemiumBannerView;
import com.myscript.nebo.freemium.RenewalOfferBannerView;
import com.myscript.nebo.grid.GridSearchView;

/* JADX INFO: loaded from: classes3.dex */
public final class MainViewFragmentBinding implements ViewBinding {
    public final AppBarLayout activityMainAppBar;
    public final LinearLayout activityMainAppBarContainer;
    public final ComposeView discoverabilityTooltip;
    public final FrameLayout folderParentContainer;
    public final FragmentContainerView folderViewFragmentContainer;
    public final ComposeView gridSortComponent;
    public final MaterialToolbar mainActivityToolbar;
    public final FloatingActionButtonMenu mainAddPageButton;
    public final LinearLayout mainEmptyState;
    public final ImageView mainEmptyStateImage;
    public final TextView mainEmptyStateSubtitle;
    public final TextView mainEmptyStateTitle;
    public final GridSearchView mainSearchView;
    public final BannerLayout mainViewBanner;
    public final ProgressBar mainViewLoadingProgress;
    public final FreemiumBannerView pagesCounterView;
    public final ComposeView preRatingView;
    public final RenewalOfferBannerView renewalOfferBanner;
    private final FrameLayout rootView;
    public final FrameLayout toolbarContainer;

    private MainViewFragmentBinding(FrameLayout frameLayout, AppBarLayout appBarLayout, LinearLayout linearLayout, ComposeView composeView, FrameLayout frameLayout2, FragmentContainerView fragmentContainerView, ComposeView composeView2, MaterialToolbar materialToolbar, FloatingActionButtonMenu floatingActionButtonMenu, LinearLayout linearLayout2, ImageView imageView, TextView textView, TextView textView2, GridSearchView gridSearchView, BannerLayout bannerLayout, ProgressBar progressBar, FreemiumBannerView freemiumBannerView, ComposeView composeView3, RenewalOfferBannerView renewalOfferBannerView, FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.activityMainAppBar = appBarLayout;
        this.activityMainAppBarContainer = linearLayout;
        this.discoverabilityTooltip = composeView;
        this.folderParentContainer = frameLayout2;
        this.folderViewFragmentContainer = fragmentContainerView;
        this.gridSortComponent = composeView2;
        this.mainActivityToolbar = materialToolbar;
        this.mainAddPageButton = floatingActionButtonMenu;
        this.mainEmptyState = linearLayout2;
        this.mainEmptyStateImage = imageView;
        this.mainEmptyStateSubtitle = textView;
        this.mainEmptyStateTitle = textView2;
        this.mainSearchView = gridSearchView;
        this.mainViewBanner = bannerLayout;
        this.mainViewLoadingProgress = progressBar;
        this.pagesCounterView = freemiumBannerView;
        this.preRatingView = composeView3;
        this.renewalOfferBanner = renewalOfferBannerView;
        this.toolbarContainer = frameLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MainViewFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MainViewFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.main_view_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MainViewFragmentBinding bind(View view) {
        int i = C6079R.id.activity_main_app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i);
        if (appBarLayout != null) {
            i = C6079R.id.activity_main_app_bar_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = C6079R.id.discoverability_tooltip;
                ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
                if (composeView != null) {
                    i = C6079R.id.folder_parent_container;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null) {
                        i = C6079R.id.folder_view_fragment_container;
                        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                        if (fragmentContainerView != null) {
                            i = C6079R.id.grid_sort_component;
                            ComposeView composeView2 = (ComposeView) ViewBindings.findChildViewById(view, i);
                            if (composeView2 != null) {
                                i = C6079R.id.main_activity_toolbar;
                                MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                                if (materialToolbar != null) {
                                    i = C6079R.id.main_add_page_button;
                                    FloatingActionButtonMenu floatingActionButtonMenu = (FloatingActionButtonMenu) ViewBindings.findChildViewById(view, i);
                                    if (floatingActionButtonMenu != null) {
                                        i = C6079R.id.main_empty_state;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = C6079R.id.main_empty_state_image;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView != null) {
                                                i = C6079R.id.main_empty_state_subtitle;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = C6079R.id.main_empty_state_title;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = C6079R.id.main_search_view;
                                                        GridSearchView gridSearchView = (GridSearchView) ViewBindings.findChildViewById(view, i);
                                                        if (gridSearchView != null) {
                                                            i = C6079R.id.main_view_banner;
                                                            BannerLayout bannerLayout = (BannerLayout) ViewBindings.findChildViewById(view, i);
                                                            if (bannerLayout != null) {
                                                                i = C6079R.id.main_view_loading_progress;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                if (progressBar != null) {
                                                                    i = C6079R.id.pages_counter_view;
                                                                    FreemiumBannerView freemiumBannerView = (FreemiumBannerView) ViewBindings.findChildViewById(view, i);
                                                                    if (freemiumBannerView != null) {
                                                                        i = C6079R.id.pre_rating_view;
                                                                        ComposeView composeView3 = (ComposeView) ViewBindings.findChildViewById(view, i);
                                                                        if (composeView3 != null) {
                                                                            i = C6079R.id.renewal_offer_banner;
                                                                            RenewalOfferBannerView renewalOfferBannerView = (RenewalOfferBannerView) ViewBindings.findChildViewById(view, i);
                                                                            if (renewalOfferBannerView != null) {
                                                                                i = C6079R.id.toolbar_container;
                                                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (frameLayout2 != null) {
                                                                                    return new MainViewFragmentBinding((FrameLayout) view, appBarLayout, linearLayout, composeView, frameLayout, fragmentContainerView, composeView2, materialToolbar, floatingActionButtonMenu, linearLayout2, imageView, textView, textView2, gridSearchView, bannerLayout, progressBar, freemiumBannerView, composeView3, renewalOfferBannerView, frameLayout2);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
