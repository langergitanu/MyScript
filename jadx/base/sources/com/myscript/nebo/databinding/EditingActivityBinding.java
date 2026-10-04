package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class EditingActivityBinding implements ViewBinding {
    public final ComposeView aiPane;
    public final ComposeView dataCollectDialog;
    public final ComposeView discoverabilityTooltip;
    public final FrameLayout editingActivityFrameLayout;
    public final FrameLayout editingActivitySecondaryToolbar;
    public final MaterialToolbar editingActivityToolbar;
    public final ComposeView mainActivityComposeDialogHost;
    public final ComposeView mainActivityPaywall;
    public final ImageView retailQrToolbarBadge;
    private final FrameLayout rootView;
    public final LinearLayout secondaryToolbarContainer;

    private EditingActivityBinding(FrameLayout frameLayout, ComposeView composeView, ComposeView composeView2, ComposeView composeView3, FrameLayout frameLayout2, FrameLayout frameLayout3, MaterialToolbar materialToolbar, ComposeView composeView4, ComposeView composeView5, ImageView imageView, LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.aiPane = composeView;
        this.dataCollectDialog = composeView2;
        this.discoverabilityTooltip = composeView3;
        this.editingActivityFrameLayout = frameLayout2;
        this.editingActivitySecondaryToolbar = frameLayout3;
        this.editingActivityToolbar = materialToolbar;
        this.mainActivityComposeDialogHost = composeView4;
        this.mainActivityPaywall = composeView5;
        this.retailQrToolbarBadge = imageView;
        this.secondaryToolbarContainer = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static EditingActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EditingActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.editing_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EditingActivityBinding bind(View view) {
        int i = C6079R.id.ai_pane;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
        if (composeView != null) {
            i = C6079R.id.data_collect_dialog;
            ComposeView composeView2 = (ComposeView) ViewBindings.findChildViewById(view, i);
            if (composeView2 != null) {
                i = C6079R.id.discoverability_tooltip;
                ComposeView composeView3 = (ComposeView) ViewBindings.findChildViewById(view, i);
                if (composeView3 != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = C6079R.id.editing_activity_secondary_toolbar;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = C6079R.id.editing_activity_toolbar;
                        MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                        if (materialToolbar != null) {
                            i = C6079R.id.main_activity_compose_dialog_host;
                            ComposeView composeView4 = (ComposeView) ViewBindings.findChildViewById(view, i);
                            if (composeView4 != null) {
                                i = C6079R.id.main_activity_paywall;
                                ComposeView composeView5 = (ComposeView) ViewBindings.findChildViewById(view, i);
                                if (composeView5 != null) {
                                    i = C6079R.id.retail_qr_toolbar_badge;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView != null) {
                                        i = C6079R.id.secondary_toolbar_container;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            return new EditingActivityBinding(frameLayout, composeView, composeView2, composeView3, frameLayout, frameLayout2, materialToolbar, composeView4, composeView5, imageView, linearLayout);
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
