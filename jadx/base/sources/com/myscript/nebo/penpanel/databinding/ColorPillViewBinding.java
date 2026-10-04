package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.ColorPillView;

/* JADX INFO: loaded from: classes7.dex */
public final class ColorPillViewBinding implements ViewBinding {
    public final ColorPillView colorPillView;
    private final FrameLayout rootView;

    private ColorPillViewBinding(FrameLayout frameLayout, ColorPillView colorPillView) {
        this.rootView = frameLayout;
        this.colorPillView = colorPillView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ColorPillViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ColorPillViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.color_pill_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ColorPillViewBinding bind(View view) {
        int i = C6693R.id.color_pill_view;
        ColorPillView colorPillView = (ColorPillView) ViewBindings.findChildViewById(view, i);
        if (colorPillView != null) {
            return new ColorPillViewBinding((FrameLayout) view, colorPillView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
