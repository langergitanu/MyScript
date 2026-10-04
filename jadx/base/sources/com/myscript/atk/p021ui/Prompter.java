package com.myscript.atk.p021ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Prompter extends RecyclerView {
    private PrompterAdapter mAdapter;

    public Prompter(Context context, View.OnClickListener onClickListener) {
        super(context);
        init(context, onClickListener);
    }

    public Prompter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, null);
    }

    public Prompter(Context context, AttributeSet attributeSet, View.OnClickListener onClickListener) {
        super(context, attributeSet);
        init(context, onClickListener);
    }

    private void init(Context context, View.OnClickListener onClickListener) {
        this.mAdapter = new PrompterAdapter(onClickListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        linearLayoutManager.setRecycleChildrenOnDetach(true);
        setLayoutManager(linearLayoutManager);
        setId(C6033R.id.prompter);
        setItemAnimator(null);
        setAdapter(this.mAdapter);
        setHasFixedSize(true);
        setMinimumHeight(1);
        getRecycledViewPool().setMaxRecycledViews(0, 30);
    }

    public void setCustomTypeface(Typeface typeface) {
        this.mAdapter.setCustomTypeface(typeface);
    }

    public List<PrompterWord> getWords() {
        return this.mAdapter.getWords();
    }

    public void clear() {
        this.mAdapter.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        smoothScrollToPosition(i);
    }

    public boolean contains(int i) {
        return this.mAdapter.contains(i);
    }

    public void setListener(View.OnClickListener onClickListener) {
        this.mAdapter.setListener(onClickListener);
    }

    public void setWords(List<PrompterWord> list) {
        this.mAdapter.setWords(list);
    }
}
