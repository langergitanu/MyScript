package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.myscript.nebo.penpanel.C6693R;

/* JADX INFO: loaded from: classes7.dex */
public final class ToolbarconfigurationDialogToolbarDividerBinding implements ViewBinding {
    private final View rootView;

    private ToolbarconfigurationDialogToolbarDividerBinding(View view) {
        this.rootView = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ToolbarconfigurationDialogToolbarDividerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToolbarconfigurationDialogToolbarDividerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.toolbarconfiguration_dialog_toolbar_divider, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ToolbarconfigurationDialogToolbarDividerBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new ToolbarconfigurationDialogToolbarDividerBinding(view);
    }
}
