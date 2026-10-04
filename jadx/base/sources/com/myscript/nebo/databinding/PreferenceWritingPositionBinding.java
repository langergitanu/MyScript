package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PreferenceWritingPositionBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageButton writingPositionLeftBottom;
    public final ImageButton writingPositionLeftMiddle;
    public final ImageButton writingPositionLeftTop;
    public final ImageButton writingPositionRightBottom;
    public final ImageButton writingPositionRightMiddle;
    public final ImageButton writingPositionRightTop;

    private PreferenceWritingPositionBinding(LinearLayout linearLayout, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6) {
        this.rootView = linearLayout;
        this.writingPositionLeftBottom = imageButton;
        this.writingPositionLeftMiddle = imageButton2;
        this.writingPositionLeftTop = imageButton3;
        this.writingPositionRightBottom = imageButton4;
        this.writingPositionRightMiddle = imageButton5;
        this.writingPositionRightTop = imageButton6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceWritingPositionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PreferenceWritingPositionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.preference_writing_position, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PreferenceWritingPositionBinding bind(View view) {
        int i = C6079R.id.writing_position_left_bottom;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = C6079R.id.writing_position_left_middle;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, i);
            if (imageButton2 != null) {
                i = C6079R.id.writing_position_left_top;
                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, i);
                if (imageButton3 != null) {
                    i = C6079R.id.writing_position_right_bottom;
                    ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, i);
                    if (imageButton4 != null) {
                        i = C6079R.id.writing_position_right_middle;
                        ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view, i);
                        if (imageButton5 != null) {
                            i = C6079R.id.writing_position_right_top;
                            ImageButton imageButton6 = (ImageButton) ViewBindings.findChildViewById(view, i);
                            if (imageButton6 != null) {
                                return new PreferenceWritingPositionBinding((LinearLayout) view, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
