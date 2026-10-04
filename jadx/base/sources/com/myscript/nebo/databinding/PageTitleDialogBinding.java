package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class PageTitleDialogBinding implements ViewBinding {
    public final TextInputEditText pageTitle;
    private final ScrollView rootView;

    private PageTitleDialogBinding(ScrollView scrollView, TextInputEditText textInputEditText) {
        this.rootView = scrollView;
        this.pageTitle = textInputEditText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ScrollView getRoot() {
        return this.rootView;
    }

    public static PageTitleDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PageTitleDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.page_title_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static PageTitleDialogBinding bind(View view) {
        int i = C6079R.id.page_title;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, i);
        if (textInputEditText != null) {
            return new PageTitleDialogBinding((ScrollView) view, textInputEditText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
