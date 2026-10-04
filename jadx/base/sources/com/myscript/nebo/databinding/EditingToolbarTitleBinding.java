package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.view.LanguagePill;

/* JADX INFO: loaded from: classes3.dex */
public final class EditingToolbarTitleBinding implements ViewBinding {
    public final TextView folderTitle;
    public final LanguagePill languagePill;
    public final TextView pageTitle;
    public final ConstraintLayout pageTitleContainer;
    private final ConstraintLayout rootView;

    private EditingToolbarTitleBinding(ConstraintLayout constraintLayout, TextView textView, LanguagePill languagePill, TextView textView2, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.folderTitle = textView;
        this.languagePill = languagePill;
        this.pageTitle = textView2;
        this.pageTitleContainer = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EditingToolbarTitleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EditingToolbarTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.editing_toolbar_title, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EditingToolbarTitleBinding bind(View view) {
        int i = C6079R.id.folder_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = C6079R.id.language_pill;
            LanguagePill languagePill = (LanguagePill) ViewBindings.findChildViewById(view, i);
            if (languagePill != null) {
                i = C6079R.id.page_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new EditingToolbarTitleBinding(constraintLayout, textView, languagePill, textView2, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
