package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class CrossSellDialogLayoutBinding implements ViewBinding {
    public final MaterialButton crossSellCta;
    public final ImageView crossSellIllustration;
    public final TextView crossSellMessage;
    public final TextView crossSellTitle;
    public final MaterialToolbar crossSellToolbar;
    private final FrameLayout rootView;

    private CrossSellDialogLayoutBinding(FrameLayout frameLayout, MaterialButton materialButton, ImageView imageView, TextView textView, TextView textView2, MaterialToolbar materialToolbar) {
        this.rootView = frameLayout;
        this.crossSellCta = materialButton;
        this.crossSellIllustration = imageView;
        this.crossSellMessage = textView;
        this.crossSellTitle = textView2;
        this.crossSellToolbar = materialToolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static CrossSellDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CrossSellDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.cross_sell_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CrossSellDialogLayoutBinding bind(View view) {
        int i = C6079R.id.cross_sell_cta;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = C6079R.id.cross_sell_illustration;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C6079R.id.cross_sell_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C6079R.id.cross_sell_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C6079R.id.cross_sell_toolbar;
                        MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                        if (materialToolbar != null) {
                            return new CrossSellDialogLayoutBinding((FrameLayout) view, materialButton, imageView, textView, textView2, materialToolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
