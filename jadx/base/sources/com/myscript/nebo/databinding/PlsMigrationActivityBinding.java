package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PlsMigrationActivityBinding implements ViewBinding {
    public final Guideline plsMigrationBottomGuide;
    public final MaterialButton plsMigrationCta;
    public final ImageView plsMigrationIllustration;
    public final ContentLoadingProgressBar plsMigrationProgress;
    public final TextView plsMigrationText;
    public final TextView plsMigrationTitle;
    public final Guideline plsMigrationTopGuide;
    private final ConstraintLayout rootView;

    private PlsMigrationActivityBinding(ConstraintLayout constraintLayout, Guideline guideline, MaterialButton materialButton, ImageView imageView, ContentLoadingProgressBar contentLoadingProgressBar, TextView textView, TextView textView2, Guideline guideline2) {
        this.rootView = constraintLayout;
        this.plsMigrationBottomGuide = guideline;
        this.plsMigrationCta = materialButton;
        this.plsMigrationIllustration = imageView;
        this.plsMigrationProgress = contentLoadingProgressBar;
        this.plsMigrationText = textView;
        this.plsMigrationTitle = textView2;
        this.plsMigrationTopGuide = guideline2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PlsMigrationActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PlsMigrationActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.pls_migration_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PlsMigrationActivityBinding bind(View view) {
        int i = C6079R.id.pls_migration_bottom_guide;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
        if (guideline != null) {
            i = C6079R.id.pls_migration_cta;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = C6079R.id.pls_migration_illustration;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C6079R.id.pls_migration_progress;
                    ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) ViewBindings.findChildViewById(view, i);
                    if (contentLoadingProgressBar != null) {
                        i = C6079R.id.pls_migration_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = C6079R.id.pls_migration_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = C6079R.id.pls_migration_top_guide;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline2 != null) {
                                    return new PlsMigrationActivityBinding((ConstraintLayout) view, guideline, materialButton, imageView, contentLoadingProgressBar, textView, textView2, guideline2);
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
