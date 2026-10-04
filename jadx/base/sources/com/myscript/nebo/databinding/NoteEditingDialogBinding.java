package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class NoteEditingDialogBinding implements ViewBinding {
    public final ComposeView noteEditingDialogCompose;
    public final MaterialToolbar noteEditionDialogFragmentToolbar;
    private final LinearLayout rootView;

    private NoteEditingDialogBinding(LinearLayout linearLayout, ComposeView composeView, MaterialToolbar materialToolbar) {
        this.rootView = linearLayout;
        this.noteEditingDialogCompose = composeView;
        this.noteEditionDialogFragmentToolbar = materialToolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NoteEditingDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NoteEditingDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.note_editing_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NoteEditingDialogBinding bind(View view) {
        int i = C6079R.id.note_editing_dialog_compose;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
        if (composeView != null) {
            i = C6079R.id.note_edition_dialog_fragment_toolbar;
            MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
            if (materialToolbar != null) {
                return new NoteEditingDialogBinding((LinearLayout) view, composeView, materialToolbar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
