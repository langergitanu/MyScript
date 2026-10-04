package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.InkTestView;

/* JADX INFO: loaded from: classes7.dex */
public final class ToolconfigurationDialogInkTestViewBinding implements ViewBinding {
    private final InkTestView rootView;
    public final InkTestView toolconfigurationInkTestView;

    private ToolconfigurationDialogInkTestViewBinding(InkTestView inkTestView, InkTestView inkTestView2) {
        this.rootView = inkTestView;
        this.toolconfigurationInkTestView = inkTestView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public InkTestView getRoot() {
        return this.rootView;
    }

    public static ToolconfigurationDialogInkTestViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToolconfigurationDialogInkTestViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.toolconfiguration_dialog_ink_test_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ToolconfigurationDialogInkTestViewBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        InkTestView inkTestView = (InkTestView) view;
        return new ToolconfigurationDialogInkTestViewBinding(inkTestView, inkTestView);
    }
}
