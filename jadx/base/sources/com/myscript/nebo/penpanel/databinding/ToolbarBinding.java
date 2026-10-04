package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.penpanel.C6693R;

/* JADX INFO: loaded from: classes7.dex */
public final class ToolbarBinding implements ViewBinding {
    public final ImageButton actionAddColor;
    public final RecyclerView colorsList;
    public final ImageView highlighterColorNone;
    private final LinearLayout rootView;
    public final RecyclerView toolsList;

    private ToolbarBinding(LinearLayout linearLayout, ImageButton imageButton, RecyclerView recyclerView, ImageView imageView, RecyclerView recyclerView2) {
        this.rootView = linearLayout;
        this.actionAddColor = imageButton;
        this.colorsList = recyclerView;
        this.highlighterColorNone = imageView;
        this.toolsList = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ToolbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToolbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.toolbar, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ToolbarBinding bind(View view) {
        int i = C6693R.id.action_add_color;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = C6693R.id.colors_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
            if (recyclerView != null) {
                i = C6693R.id.highlighter_color_none;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C6693R.id.tools_list;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView2 != null) {
                        return new ToolbarBinding((LinearLayout) view, imageButton, recyclerView, imageView, recyclerView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
