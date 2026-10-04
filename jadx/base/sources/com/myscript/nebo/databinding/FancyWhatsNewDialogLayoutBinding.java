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
public final class FancyWhatsNewDialogLayoutBinding implements ViewBinding {
    public final MaterialButton fancyWhatsNewCta;
    public final ImageView fancyWhatsNewIllustration;
    public final TextView fancyWhatsNewMessage;
    public final TextView fancyWhatsNewTitle;
    public final MaterialToolbar fancyWhatsNewToolbar;
    private final FrameLayout rootView;

    private FancyWhatsNewDialogLayoutBinding(FrameLayout frameLayout, MaterialButton materialButton, ImageView imageView, TextView textView, TextView textView2, MaterialToolbar materialToolbar) {
        this.rootView = frameLayout;
        this.fancyWhatsNewCta = materialButton;
        this.fancyWhatsNewIllustration = imageView;
        this.fancyWhatsNewMessage = textView;
        this.fancyWhatsNewTitle = textView2;
        this.fancyWhatsNewToolbar = materialToolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FancyWhatsNewDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FancyWhatsNewDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.fancy_whats_new_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FancyWhatsNewDialogLayoutBinding bind(View view) {
        int i = C6079R.id.fancy_whats_new_cta;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = C6079R.id.fancy_whats_new_illustration;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C6079R.id.fancy_whats_new_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C6079R.id.fancy_whats_new_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = C6079R.id.fancy_whats_new_toolbar;
                        MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                        if (materialToolbar != null) {
                            return new FancyWhatsNewDialogLayoutBinding((FrameLayout) view, materialButton, imageView, textView, textView2, materialToolbar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
