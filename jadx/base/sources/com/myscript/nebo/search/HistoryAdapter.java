package com.myscript.nebo.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.myscript.nebo.C6079R;

/* JADX INFO: loaded from: classes7.dex */
public class HistoryAdapter extends ArrayAdapter<String> {
    private static final int HISTORY_CLEAR_TYPE = 1;
    private static final int HISTORY_ITEM_TYPE = 0;
    private LayoutInflater mLayoutInflater;

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public HistoryAdapter(Context context) {
        super(context, -1);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        int count = super.getCount();
        return super.getCount() > 0 ? count + 1 : count;
    }

    public boolean isClearItem(int i) {
        return i == super.getCount();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public String getItem(int i) {
        if (isClearItem(i)) {
            return "";
        }
        return (String) super.getItem(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return isClearItem(i) ? 1 : 0;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean zIsClearItem = isClearItem(i);
        if (view == null) {
            view = this.mLayoutInflater.inflate(zIsClearItem ? C6079R.layout.history_item_clear : C6079R.layout.history_item, viewGroup, false);
        }
        if (!zIsClearItem) {
            ((TextView) view.findViewById(C6079R.id.history_item_text)).setText(getItem(i));
        }
        return view;
    }
}
