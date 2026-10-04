package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.myscript.nebo.penpanel.C6693R;

/* JADX INFO: loaded from: classes7.dex */
public final class EraserPolicyButtonBinding implements ViewBinding {
    private final MaterialButton rootView;

    private EraserPolicyButtonBinding(MaterialButton materialButton) {
        this.rootView = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialButton getRoot() {
        return this.rootView;
    }

    public static EraserPolicyButtonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EraserPolicyButtonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.eraser_policy_button, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static EraserPolicyButtonBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new EraserPolicyButtonBinding((MaterialButton) view);
    }
}
