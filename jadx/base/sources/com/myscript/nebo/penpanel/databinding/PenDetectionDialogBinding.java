package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.InkTestView;

/* JADX INFO: loaded from: classes7.dex */
public final class PenDetectionDialogBinding implements ViewBinding {
    public final InkTestView penDetectionArea;
    public final FrameLayout penDetectionAreaContainer;
    public final Button penDetectionDialogNegativeButton;
    public final ImageView penDetectionPanelDone;
    public final FrameLayout penDetectionPanelUserInput;
    public final TextView penDetectionPanelWriteHere;
    private final LinearLayout rootView;

    private PenDetectionDialogBinding(LinearLayout linearLayout, InkTestView inkTestView, FrameLayout frameLayout, Button button, ImageView imageView, FrameLayout frameLayout2, TextView textView) {
        this.rootView = linearLayout;
        this.penDetectionArea = inkTestView;
        this.penDetectionAreaContainer = frameLayout;
        this.penDetectionDialogNegativeButton = button;
        this.penDetectionPanelDone = imageView;
        this.penDetectionPanelUserInput = frameLayout2;
        this.penDetectionPanelWriteHere = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PenDetectionDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PenDetectionDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.pen_detection_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PenDetectionDialogBinding bind(View view) {
        int i = C6693R.id.pen_detection_area;
        InkTestView inkTestView = (InkTestView) ViewBindings.findChildViewById(view, i);
        if (inkTestView != null) {
            i = C6693R.id.pen_detection_area_container;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = C6693R.id.pen_detection_dialog_negative_button;
                Button button = (Button) ViewBindings.findChildViewById(view, i);
                if (button != null) {
                    i = C6693R.id.pen_detection_panel_done;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = C6693R.id.pen_detection_panel_user_input;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = C6693R.id.pen_detection_panel_write_here;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new PenDetectionDialogBinding((LinearLayout) view, inkTestView, frameLayout, button, imageView, frameLayout2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
