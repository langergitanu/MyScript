package com.myscript.nebo.databinding;

import android.gesture.GestureOverlayView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.banner.BannerLayout;
import com.myscript.nebo.editing.PageIndicator;
import com.myscript.nebo.editing.zoom.ZoomIndicatorView;

/* JADX INFO: loaded from: classes3.dex */
public final class EditingContentLayoutBinding implements ViewBinding {
    public final FragmentContainerView childPagesSidePanel;
    public final Guideline childPagesSidePanelGuideline;
    public final ConstraintLayout contentConstraintLayout;
    public final BannerLayout editingViewBanner;
    public final LinearLayout newPageInsertionFeedbackLayout;
    public final CircularProgressIndicator newPageInsertionFeedbackTimerProgressBar;
    public final ViewPager2 pageFragmentViewPager;
    public final GestureOverlayView pageFragmentViewPagerTouchOverlay;
    public final PageIndicator pageIndicatorWidget;
    private final ConstraintLayout rootView;
    public final ZoomIndicatorView zoomIndicatorPanel;

    private EditingContentLayoutBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, Guideline guideline, ConstraintLayout constraintLayout2, BannerLayout bannerLayout, LinearLayout linearLayout, CircularProgressIndicator circularProgressIndicator, ViewPager2 viewPager2, GestureOverlayView gestureOverlayView, PageIndicator pageIndicator, ZoomIndicatorView zoomIndicatorView) {
        this.rootView = constraintLayout;
        this.childPagesSidePanel = fragmentContainerView;
        this.childPagesSidePanelGuideline = guideline;
        this.contentConstraintLayout = constraintLayout2;
        this.editingViewBanner = bannerLayout;
        this.newPageInsertionFeedbackLayout = linearLayout;
        this.newPageInsertionFeedbackTimerProgressBar = circularProgressIndicator;
        this.pageFragmentViewPager = viewPager2;
        this.pageFragmentViewPagerTouchOverlay = gestureOverlayView;
        this.pageIndicatorWidget = pageIndicator;
        this.zoomIndicatorPanel = zoomIndicatorView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EditingContentLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EditingContentLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.editing_content_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EditingContentLayoutBinding bind(View view) {
        int i = C6079R.id.child_pages_side_panel;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
        if (fragmentContainerView != null) {
            i = C6079R.id.child_pages_side_panel_guideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
            if (guideline != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = C6079R.id.editing_view_banner;
                BannerLayout bannerLayout = (BannerLayout) ViewBindings.findChildViewById(view, i);
                if (bannerLayout != null) {
                    i = C6079R.id.new_page_insertion_feedback_layout;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = C6079R.id.new_page_insertion_feedback_timer_progress_bar;
                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, i);
                        if (circularProgressIndicator != null) {
                            i = C6079R.id.page_fragment_view_pager;
                            ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i);
                            if (viewPager2 != null) {
                                i = C6079R.id.page_fragment_view_pager_touch_overlay;
                                GestureOverlayView gestureOverlayView = (GestureOverlayView) ViewBindings.findChildViewById(view, i);
                                if (gestureOverlayView != null) {
                                    i = C6079R.id.page_indicator_widget;
                                    PageIndicator pageIndicator = (PageIndicator) ViewBindings.findChildViewById(view, i);
                                    if (pageIndicator != null) {
                                        i = C6079R.id.zoom_indicator_panel;
                                        ZoomIndicatorView zoomIndicatorView = (ZoomIndicatorView) ViewBindings.findChildViewById(view, i);
                                        if (zoomIndicatorView != null) {
                                            return new EditingContentLayoutBinding(constraintLayout, fragmentContainerView, guideline, constraintLayout, bannerLayout, linearLayout, circularProgressIndicator, viewPager2, gestureOverlayView, pageIndicator, zoomIndicatorView);
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
