package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class TrashFragmentBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final Group trashEmptyState;
    public final ImageView trashEmptyStateImage;
    public final TextView trashEmptyStateMessage;
    public final ProgressBar trashLoadingProgress;
    public final RecyclerView trashRecyclerView;

    private TrashFragmentBinding(ConstraintLayout constraintLayout, Group group, ImageView imageView, TextView textView, ProgressBar progressBar, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.trashEmptyState = group;
        this.trashEmptyStateImage = imageView;
        this.trashEmptyStateMessage = textView;
        this.trashLoadingProgress = progressBar;
        this.trashRecyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TrashFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TrashFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.trash_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TrashFragmentBinding bind(View view) {
        int i = C6079R.id.trash_empty_state;
        Group group = (Group) ViewBindings.findChildViewById(view, i);
        if (group != null) {
            i = C6079R.id.trash_empty_state_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = C6079R.id.trash_empty_state_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = C6079R.id.trash_loading_progress;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                    if (progressBar != null) {
                        i = C6079R.id.trash_recycler_view;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            return new TrashFragmentBinding((ConstraintLayout) view, group, imageView, textView, progressBar, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
