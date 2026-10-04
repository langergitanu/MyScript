package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PageIndicatorWidgetBinding implements ViewBinding {
    public final ImageView editingPageWidgetSidePanelToggle;
    private final MaterialCardView rootView;

    private PageIndicatorWidgetBinding(MaterialCardView materialCardView, ImageView imageView) {
        this.rootView = materialCardView;
        this.editingPageWidgetSidePanelToggle = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static PageIndicatorWidgetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PageIndicatorWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.page_indicator_widget, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PageIndicatorWidgetBinding bind(View view) {
        int i = C6079R.id.editing_page_widget_side_panel_toggle;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new PageIndicatorWidgetBinding((MaterialCardView) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
