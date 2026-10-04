package com.myscript.nebo.languagemanager.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.myscript.nebo.languagemanager.C6611R;

/* JADX INFO: loaded from: classes7.dex */
public final class ItemHeaderBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView txtHeaderTitle;

    private ItemHeaderBinding(TextView textView, TextView textView2) {
        this.rootView = textView;
        this.txtHeaderTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static ItemHeaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemHeaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(C6611R.layout.item_header, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHeaderBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        TextView textView = (TextView) view;
        return new ItemHeaderBinding(textView, textView);
    }
}
