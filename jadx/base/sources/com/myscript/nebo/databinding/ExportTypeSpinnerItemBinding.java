package com.myscript.nebo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes3.dex */
public final class ExportTypeSpinnerItemBinding implements ViewBinding {
    public final TextView exportTypeLabel;
    private final TextView rootView;

    private ExportTypeSpinnerItemBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.exportTypeLabel = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static ExportTypeSpinnerItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ExportTypeSpinnerItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6079R.layout.export_type_spinner_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ExportTypeSpinnerItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new ExportTypeSpinnerItemBinding(textView, textView);
    }
}
