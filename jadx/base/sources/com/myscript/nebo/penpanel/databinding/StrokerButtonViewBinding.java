package com.myscript.nebo.penpanel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.myscript.nebo.penpanel.C6693R;

/* JADX INFO: loaded from: classes7.dex */
public final class StrokerButtonViewBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView strokerButtonView;

    private StrokerButtonViewBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.strokerButtonView = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static StrokerButtonViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StrokerButtonViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6693R.layout.stroker_button_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static StrokerButtonViewBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new StrokerButtonViewBinding(textView, textView);
    }
}
