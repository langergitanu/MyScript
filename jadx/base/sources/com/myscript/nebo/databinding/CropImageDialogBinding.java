package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class CropImageDialogBinding implements ViewBinding {
    public final LinearLayout buttonsLayout;
    public final Button cancelButton;
    public final FragmentContainerView fragmentContainer;
    public final Button okButton;
    private final LinearLayout rootView;

    private CropImageDialogBinding(LinearLayout linearLayout, LinearLayout linearLayout2, Button button, FragmentContainerView fragmentContainerView, Button button2) {
        this.rootView = linearLayout;
        this.buttonsLayout = linearLayout2;
        this.cancelButton = button;
        this.fragmentContainer = fragmentContainerView;
        this.okButton = button2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CropImageDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CropImageDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.crop_image_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CropImageDialogBinding bind(View view) {
        int i = C6079R.id.buttons_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = C6079R.id.cancel_button;
            Button button = (Button) ViewBindings.findChildViewById(view, i);
            if (button != null) {
                i = C6079R.id.fragment_container;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
                if (fragmentContainerView != null) {
                    i = C6079R.id.ok_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                    if (button2 != null) {
                        return new CropImageDialogBinding((LinearLayout) view, linearLayout, button, fragmentContainerView, button2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
