package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class RenewalOfferBannerViewBinding implements ViewBinding {
    public final MaterialButton renewalBannerActionButton;
    public final MaterialCardView renewalBannerCard;
    public final TextView renewalBannerDescription;
    public final ImageView renewalBannerIllustration;
    public final TextView renewalBannerTitle;
    private final MaterialCardView rootView;

    private RenewalOfferBannerViewBinding(MaterialCardView materialCardView, MaterialButton materialButton, MaterialCardView materialCardView2, TextView textView, ImageView imageView, TextView textView2) {
        this.rootView = materialCardView;
        this.renewalBannerActionButton = materialButton;
        this.renewalBannerCard = materialCardView2;
        this.renewalBannerDescription = textView;
        this.renewalBannerIllustration = imageView;
        this.renewalBannerTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RenewalOfferBannerViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RenewalOfferBannerViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.renewal_offer_banner_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RenewalOfferBannerViewBinding bind(View view) {
        int i = C6079R.id.renewal_banner_action_button;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            i = C6079R.id.renewal_banner_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C6079R.id.renewal_banner_illustration;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C6079R.id.renewal_banner_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new RenewalOfferBannerViewBinding(materialCardView, materialButton, materialCardView, textView, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
