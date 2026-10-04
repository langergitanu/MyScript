package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.debug.UOCView;

/* JADX INFO: loaded from: classes3.dex */
public final class MainActivityBinding implements ViewBinding {
    public final UOCView appDebugUserObjectCount;
    public final ComposeView dataCollectDialog;
    public final ComposeView mainActivityComposeDialogHost;
    public final View mainActivityContentOverlay;
    public final Guideline mainActivityGridGuideline;
    public final ComposeView mainActivityLenovoMigration;
    public final ProgressBar mainActivityLoadingProgress;
    public final ComposeView mainActivityOemOffer;
    public final ComposeView mainActivityPaywall;
    public final ComposeView mainActivityRenewalOffer;
    public final ConstraintLayout mainActivitySideBySideLayout;
    public final FrameLayout mainActivitySidePanel;
    public final Guideline mainActivitySidepanelGuideline;
    public final FragmentContainerView mainFragmentLayout;
    private final ConstraintLayout rootView;

    private MainActivityBinding(ConstraintLayout constraintLayout, UOCView uOCView, ComposeView composeView, ComposeView composeView2, View view, Guideline guideline, ComposeView composeView3, ProgressBar progressBar, ComposeView composeView4, ComposeView composeView5, ComposeView composeView6, ConstraintLayout constraintLayout2, FrameLayout frameLayout, Guideline guideline2, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.appDebugUserObjectCount = uOCView;
        this.dataCollectDialog = composeView;
        this.mainActivityComposeDialogHost = composeView2;
        this.mainActivityContentOverlay = view;
        this.mainActivityGridGuideline = guideline;
        this.mainActivityLenovoMigration = composeView3;
        this.mainActivityLoadingProgress = progressBar;
        this.mainActivityOemOffer = composeView4;
        this.mainActivityPaywall = composeView5;
        this.mainActivityRenewalOffer = composeView6;
        this.mainActivitySideBySideLayout = constraintLayout2;
        this.mainActivitySidePanel = frameLayout;
        this.mainActivitySidepanelGuideline = guideline2;
        this.mainFragmentLayout = fragmentContainerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MainActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MainActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.main_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MainActivityBinding bind(View view) {
        View viewFindChildViewById;
        int i = C6079R.id.app_debug_userObjectCount;
        UOCView uOCView = (UOCView) ViewBindings.findChildViewById(view, i);
        if (uOCView != null) {
            i = C6079R.id.data_collect_dialog;
            ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
            if (composeView != null) {
                i = C6079R.id.main_activity_compose_dialog_host;
                ComposeView composeView2 = (ComposeView) ViewBindings.findChildViewById(view, i);
                if (composeView2 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = C6079R.id.main_activity_content_overlay))) != null) {
                    i = C6079R.id.main_activity_grid_guideline;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline != null) {
                        i = C6079R.id.main_activity_lenovo_migration;
                        ComposeView composeView3 = (ComposeView) ViewBindings.findChildViewById(view, i);
                        if (composeView3 != null) {
                            i = C6079R.id.main_activity_loading_progress;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = C6079R.id.main_activity_oem_offer;
                                ComposeView composeView4 = (ComposeView) ViewBindings.findChildViewById(view, i);
                                if (composeView4 != null) {
                                    i = C6079R.id.main_activity_paywall;
                                    ComposeView composeView5 = (ComposeView) ViewBindings.findChildViewById(view, i);
                                    if (composeView5 != null) {
                                        i = C6079R.id.main_activity_renewal_offer;
                                        ComposeView composeView6 = (ComposeView) ViewBindings.findChildViewById(view, i);
                                        if (composeView6 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i = C6079R.id.main_activity_side_panel;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                            if (frameLayout != null) {
                                                i = C6079R.id.main_activity_sidepanel_guideline;
                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline2 != null) {
                                                    i = C6079R.id.main_fragment_layout;
                                                    FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                                                    if (fragmentContainerView != null) {
                                                        return new MainActivityBinding(constraintLayout, uOCView, composeView, composeView2, viewFindChildViewById, guideline, composeView3, progressBar, composeView4, composeView5, composeView6, constraintLayout, frameLayout, guideline2, fragmentContainerView);
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
