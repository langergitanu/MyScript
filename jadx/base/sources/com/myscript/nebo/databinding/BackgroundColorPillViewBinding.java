package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.penpanel.ColorPillView;

/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundColorPillViewBinding implements ViewBinding {
    public final ColorPillView colorPillView;
    private final FrameLayout rootView;

    private BackgroundColorPillViewBinding(FrameLayout frameLayout, ColorPillView colorPillView) {
        this.rootView = frameLayout;
        this.colorPillView = colorPillView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BackgroundColorPillViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BackgroundColorPillViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.background_color_pill_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BackgroundColorPillViewBinding bind(View view) {
        int i = C6079R.id.color_pill_view;
        ColorPillView colorPillView = (ColorPillView) ViewBindings.findChildViewById(view, i);
        if (colorPillView != null) {
            return new BackgroundColorPillViewBinding((FrameLayout) view, colorPillView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
