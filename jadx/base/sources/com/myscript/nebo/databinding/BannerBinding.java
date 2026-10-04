package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class BannerBinding implements ViewBinding {
    public final ConstraintLayout permanentBanner;
    public final TextView permanentBannerAction;
    public final ImageButton permanentBannerClose;
    public final TextView permanentBannerMessage;
    public final TextView permanentBannerSecondaryAction;
    private final LinearLayout rootView;
    public final ConstraintLayout transientBanner;
    public final TextView transientBannerAction;
    public final TextView transientBannerMessage;
    public final ProgressBar transientBannerProgress;
    public final TextView transientBannerSecondaryAction;

    private BannerBinding(LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, ImageButton imageButton, TextView textView2, TextView textView3, ConstraintLayout constraintLayout2, TextView textView4, TextView textView5, ProgressBar progressBar, TextView textView6) {
        this.rootView = linearLayout;
        this.permanentBanner = constraintLayout;
        this.permanentBannerAction = textView;
        this.permanentBannerClose = imageButton;
        this.permanentBannerMessage = textView2;
        this.permanentBannerSecondaryAction = textView3;
        this.transientBanner = constraintLayout2;
        this.transientBannerAction = textView4;
        this.transientBannerMessage = textView5;
        this.transientBannerProgress = progressBar;
        this.transientBannerSecondaryAction = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.banner, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BannerBinding bind(View view) {
        int i = C6079R.id.permanent_banner;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = C6079R.id.permanent_banner_action;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = C6079R.id.permanent_banner_close;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                if (imageButton != null) {
                    i = C6079R.id.permanent_banner_message;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C6079R.id.permanent_banner_secondary_action;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = C6079R.id.transient_banner;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                i = C6079R.id.transient_banner_action;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = C6079R.id.transient_banner_message;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = C6079R.id.transient_banner_progress;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                        if (progressBar != null) {
                                            i = C6079R.id.transient_banner_secondary_action;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView6 != null) {
                                                return new BannerBinding((LinearLayout) view, constraintLayout, textView, imageButton, textView2, textView3, constraintLayout2, textView4, textView5, progressBar, textView6);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
