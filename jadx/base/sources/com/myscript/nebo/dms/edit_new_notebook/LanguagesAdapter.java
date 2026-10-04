package com.myscript.nebo.dms.edit_new_notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.myscript.nebo.dms.C6208R;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class LanguagesAdapter extends ArrayAdapter<DisplayableLocale> {
    private boolean mIsEnabled;
    private final boolean mWithHint;

    public LanguagesAdapter(Context context, List<DisplayableLocale> list, boolean z) {
        super(context, C6208R.layout.item_spinner, list);
        setDropDownViewResource(C6208R.layout.item_spinner_dropdown);
        this.mWithHint = z;
        this.mIsEnabled = true;
    }

    public void setEnabled(boolean z) {
        this.mIsEnabled = z;
    }

    public void updateLanguages(List<DisplayableLocale> list) {
        Collections.sort(list);
        clear();
        addAll(list);
        if (this.mWithHint || list.isEmpty()) {
            add(new DisplayableLocale(null, null));
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!isEmpty() && this.mWithHint && i == getCount() - 1) {
            TextView textView = new TextView(getContext());
            textView.setHeight(0);
            textView.setVisibility(8);
            return textView;
        }
        return super.getDropDownView(i, null, viewGroup);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView;
        Context context = getContext();
        if (view == null) {
            textView = (TextView) LayoutInflater.from(context).inflate(C6208R.layout.item_spinner, viewGroup, false);
        } else {
            textView = (TextView) view;
        }
        DisplayableLocale item = getItem(i);
        if (this.mWithHint && !item.isValid()) {
            textView.setText(context.getString(C6208R.string.dialog_notebook_language_hint));
        } else {
            textView.setText(item.toString());
        }
        textView.setEnabled(this.mIsEnabled);
        return textView;
    }

    public int getPosition(String str) {
        for (int i = 0; i < super.getCount(); i++) {
            String locale = getItem(i).getLocale();
            if (locale != null && locale.equals(str)) {
                return i;
            }
        }
        return -1;
    }
}
