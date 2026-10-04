package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class NoteCreationDialogBinding implements ViewBinding {
    public final ComposeView noteCreationDialogCompose;
    public final FragmentContainerView noteCreationDialogFragmentContainer;
    public final MaterialToolbar noteCreationDialogFragmentToolbar;
    private final LinearLayout rootView;

    private NoteCreationDialogBinding(LinearLayout linearLayout, ComposeView composeView, FragmentContainerView fragmentContainerView, MaterialToolbar materialToolbar) {
        this.rootView = linearLayout;
        this.noteCreationDialogCompose = composeView;
        this.noteCreationDialogFragmentContainer = fragmentContainerView;
        this.noteCreationDialogFragmentToolbar = materialToolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NoteCreationDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static NoteCreationDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.note_creation_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static NoteCreationDialogBinding bind(View view) {
        int i = C6079R.id.note_creation_dialog_compose;
        ComposeView composeView = (ComposeView) ViewBindings.findChildViewById(view, i);
        if (composeView != null) {
            i = C6079R.id.note_creation_dialog_fragment_container;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, i);
            if (fragmentContainerView != null) {
                i = C6079R.id.note_creation_dialog_fragment_toolbar;
                MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                if (materialToolbar != null) {
                    return new NoteCreationDialogBinding((LinearLayout) view, composeView, fragmentContainerView, materialToolbar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
