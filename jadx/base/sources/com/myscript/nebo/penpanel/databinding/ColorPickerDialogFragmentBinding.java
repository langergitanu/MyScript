package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.ColorCircle;
import com.myscript.nebo.penpanel.ColorSeekBar;

/* JADX INFO: loaded from: classes7.dex */
public final class ColorPickerDialogFragmentBinding implements ViewBinding {
    public final ColorSeekBar brightnessSeekbar;
    public final TextView colorAccuracyDisclaimer;
    public final ColorCircle colorCircle;
    public final LinearLayout colorPicker;
    public final MaterialToolbar colorPickerToolbar;
    private final LinearLayout rootView;
    public final ColorSeekBar saturationSeekbar;

    private ColorPickerDialogFragmentBinding(LinearLayout linearLayout, ColorSeekBar colorSeekBar, TextView textView, ColorCircle colorCircle, LinearLayout linearLayout2, MaterialToolbar materialToolbar, ColorSeekBar colorSeekBar2) {
        this.rootView = linearLayout;
        this.brightnessSeekbar = colorSeekBar;
        this.colorAccuracyDisclaimer = textView;
        this.colorCircle = colorCircle;
        this.colorPicker = linearLayout2;
        this.colorPickerToolbar = materialToolbar;
        this.saturationSeekbar = colorSeekBar2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ColorPickerDialogFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ColorPickerDialogFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.color_picker_dialog_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ColorPickerDialogFragmentBinding bind(View view) {
        ColorSeekBar colorSeekBar = (ColorSeekBar) ViewBindings.findChildViewById(view, C6693R.id.brightness_seekbar);
        TextView textView = (TextView) ViewBindings.findChildViewById(view, C6693R.id.color_accuracy_disclaimer);
        ColorCircle colorCircle = (ColorCircle) ViewBindings.findChildViewById(view, C6693R.id.color_circle);
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, C6693R.id.color_picker);
        int i = C6693R.id.color_picker_toolbar;
        MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
        if (materialToolbar != null) {
            return new ColorPickerDialogFragmentBinding((LinearLayout) view, colorSeekBar, textView, colorCircle, linearLayout, materialToolbar, (ColorSeekBar) ViewBindings.findChildViewById(view, C6693R.id.saturation_seekbar));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
