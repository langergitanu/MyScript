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
public final class BackgroundPatternPillViewBinding implements ViewBinding {
    public final MaterialCardView pagePatternCard;
    public final ImageView pagePatternIllustration;
    private final MaterialCardView rootView;

    private BackgroundPatternPillViewBinding(MaterialCardView materialCardView, MaterialCardView materialCardView2, ImageView imageView) {
        this.rootView = materialCardView;
        this.pagePatternCard = materialCardView2;
        this.pagePatternIllustration = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static BackgroundPatternPillViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BackgroundPatternPillViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.background_pattern_pill_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BackgroundPatternPillViewBinding bind(View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        int i = C6079R.id.page_pattern_illustration;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            return new BackgroundPatternPillViewBinding(materialCardView, materialCardView, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
