package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.myscript.nebo.penpanel.C6693R;
import com.myscript.nebo.penpanel.InkTestView;

/* JADX INFO: loaded from: classes7.dex */
public final class TestHereBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final InkTestView testInkInput;

    private TestHereBinding(FrameLayout frameLayout, InkTestView inkTestView) {
        this.rootView = frameLayout;
        this.testInkInput = inkTestView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static TestHereBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TestHereBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.test_here, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TestHereBinding bind(View view) {
        int i = C6693R.id.test_ink_input;
        InkTestView inkTestView = (InkTestView) ViewBindings.findChildViewById(view, i);
        if (inkTestView != null) {
            return new TestHereBinding((FrameLayout) view, inkTestView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
