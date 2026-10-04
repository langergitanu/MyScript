package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.myscript.nebo.penpanel.C6693R;

/* JADX INFO: loaded from: classes7.dex */
public final class ToolconfigurationDialogBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout toolconfigurationOptionsButtons;
    public final MaterialCardView toolconfigurationTestHerePanel;
    public final LinearLayout toolconfigurationThicknessButtons;
    public final Toolbar toolconfigurationToolbar;

    private ToolconfigurationDialogBinding(LinearLayout linearLayout, LinearLayout linearLayout2, MaterialCardView materialCardView, LinearLayout linearLayout3, Toolbar toolbar) {
        this.rootView = linearLayout;
        this.toolconfigurationOptionsButtons = linearLayout2;
        this.toolconfigurationTestHerePanel = materialCardView;
        this.toolconfigurationThicknessButtons = linearLayout3;
        this.toolconfigurationToolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ToolconfigurationDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToolconfigurationDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.toolconfiguration_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ToolconfigurationDialogBinding bind(View view) {
        int i = C6693R.id.toolconfiguration_options_buttons;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C6693R.id.toolconfiguration_test_here_panel;
            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
            if (materialCardView != null) {
                i = C6693R.id.toolconfiguration_thickness_buttons;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = C6693R.id.toolconfiguration_toolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i);
                    if (toolbar != null) {
                        return new ToolconfigurationDialogBinding((LinearLayout) view, linearLayout, materialCardView, linearLayout2, toolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
