package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.ToolPillView;

/* JADX INFO: loaded from: classes7.dex */
public final class ToolPillViewBinding implements ViewBinding {
    private final ToolPillView rootView;
    public final ToolPillView toolPillView;

    private ToolPillViewBinding(ToolPillView toolPillView, ToolPillView toolPillView2) {
        this.rootView = toolPillView;
        this.toolPillView = toolPillView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ToolPillView getRoot() {
        return this.rootView;
    }

    public static ToolPillViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ToolPillViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.tool_pill_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ToolPillViewBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ToolPillView toolPillView = (ToolPillView) view;
        return new ToolPillViewBinding(toolPillView, toolPillView);
    }
}
