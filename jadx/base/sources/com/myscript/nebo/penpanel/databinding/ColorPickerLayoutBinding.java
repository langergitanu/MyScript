package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.ColorCircle;
import com.myscript.nebo.penpanel.ColorSeekBar;

/* JADX INFO: loaded from: classes7.dex */
public final class ColorPickerLayoutBinding implements ViewBinding {
    public final ColorSeekBar brightnessSeekbar;
    public final TextView colorAccuracyDisclaimer;
    public final ColorCircle colorCircle;
    private final LinearLayout rootView;
    public final ColorSeekBar saturationSeekbar;

    private ColorPickerLayoutBinding(LinearLayout linearLayout, ColorSeekBar colorSeekBar, TextView textView, ColorCircle colorCircle, ColorSeekBar colorSeekBar2) {
        this.rootView = linearLayout;
        this.brightnessSeekbar = colorSeekBar;
        this.colorAccuracyDisclaimer = textView;
        this.colorCircle = colorCircle;
        this.saturationSeekbar = colorSeekBar2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ColorPickerLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ColorPickerLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.color_picker_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ColorPickerLayoutBinding bind(View view) {
        int i = C6693R.id.brightness_seekbar;
        ColorSeekBar colorSeekBar = (ColorSeekBar) ViewBindings.findChildViewById(view, i);
        if (colorSeekBar != null) {
            i = C6693R.id.color_accuracy_disclaimer;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C6693R.id.color_circle;
                ColorCircle colorCircle = (ColorCircle) ViewBindings.findChildViewById(view, i);
                if (colorCircle != null) {
                    i = C6693R.id.saturation_seekbar;
                    ColorSeekBar colorSeekBar2 = (ColorSeekBar) ViewBindings.findChildViewById(view, i);
                    if (colorSeekBar2 != null) {
                        return new ColorPickerLayoutBinding((LinearLayout) view, colorSeekBar, textView, colorCircle, colorSeekBar2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
