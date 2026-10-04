package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.divider.MaterialDivider;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class ZoomPanelViewBinding implements ViewBinding {
    private final MaterialCardView rootView;
    public final MaterialDivider zoomFeedbackDivider;
    public final ImageView zoomFeedbackLockIcon;
    public final TextView zoomFeedbackLockNotif;
    public final LinearLayout zoomFeedbackLockToggle;
    public final Button zoomFeedbackValue;
    public final MaterialCardView zoomFeedbackWidget;

    private ZoomPanelViewBinding(MaterialCardView materialCardView, MaterialDivider materialDivider, ImageView imageView, TextView textView, LinearLayout linearLayout, Button button, MaterialCardView materialCardView2) {
        this.rootView = materialCardView;
        this.zoomFeedbackDivider = materialDivider;
        this.zoomFeedbackLockIcon = imageView;
        this.zoomFeedbackLockNotif = textView;
        this.zoomFeedbackLockToggle = linearLayout;
        this.zoomFeedbackValue = button;
        this.zoomFeedbackWidget = materialCardView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static ZoomPanelViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ZoomPanelViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.zoom_panel_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ZoomPanelViewBinding bind(View view) {
        int i = C6079R.id.zoom_feedback_divider;
        MaterialDivider materialDivider = (MaterialDivider) ViewBindings.findChildViewById(view, i);
        if (materialDivider != null) {
            i = C6079R.id.zoom_feedback_lock_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C6079R.id.zoom_feedback_lock_notif;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C6079R.id.zoom_feedback_lock_toggle;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = C6079R.id.zoom_feedback_value;
                        Button button = (Button) ViewBindings.findChildViewById(view, i);
                        if (button != null) {
                            MaterialCardView materialCardView = (MaterialCardView) view;
                            return new ZoomPanelViewBinding(materialCardView, materialDivider, imageView, textView, linearLayout, button, materialCardView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
