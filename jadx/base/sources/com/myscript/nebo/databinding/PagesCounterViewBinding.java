package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PagesCounterViewBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout;
    public final ImageView imgBannerLarge;
    public final MaterialCardView mainContainer;
    public final MaterialButton pageCounterActionButton;
    public final TextView pageCounterDescription;
    public final TextView pageCounterTitle;
    private final MaterialCardView rootView;

    private PagesCounterViewBinding(MaterialCardView materialCardView, ConstraintLayout constraintLayout, ImageView imageView, MaterialCardView materialCardView2, MaterialButton materialButton, TextView textView, TextView textView2) {
        this.rootView = materialCardView;
        this.constraintLayout = constraintLayout;
        this.imgBannerLarge = imageView;
        this.mainContainer = materialCardView2;
        this.pageCounterActionButton = materialButton;
        this.pageCounterDescription = textView;
        this.pageCounterTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static PagesCounterViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PagesCounterViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.pages_counter_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PagesCounterViewBinding bind(View view) {
        int i = C6079R.id.constraint_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, C6079R.id.img_banner_large);
            MaterialCardView materialCardView = (MaterialCardView) view;
            i = C6079R.id.page_counter_action_button;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = C6079R.id.page_counter_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C6079R.id.page_counter_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new PagesCounterViewBinding(materialCardView, constraintLayout, imageView, materialCardView, materialButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
