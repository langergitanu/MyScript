package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PdfOptimizationOverlayBinding implements ViewBinding {
    public final TextView pdfOptimOverlayMessage;
    public final FrameLayout pdfOptimOverlayRoot;
    private final FrameLayout rootView;

    private PdfOptimizationOverlayBinding(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.pdfOptimOverlayMessage = textView;
        this.pdfOptimOverlayRoot = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PdfOptimizationOverlayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PdfOptimizationOverlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.pdf_optimization_overlay, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PdfOptimizationOverlayBinding bind(View view) {
        int i = C6079R.id.pdf_optim_overlay_message;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new PdfOptimizationOverlayBinding(frameLayout, textView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
