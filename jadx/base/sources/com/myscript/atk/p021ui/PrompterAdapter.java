package com.myscript.atk.p021ui;

import android.graphics.Typeface;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class PrompterAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Typeface mCustomTypeface;
    private View.OnClickListener mOnClickListener;
    private List<PrompterWord> mWords = new ArrayList();
    private SparseArray<PrompterWord> mIndexedWords = new SparseArray<>();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        PrompterWordControl mWc;

        public ViewHolder(View view) {
            super(view);
            this.mWc = (PrompterWordControl) view;
        }
    }

    public PrompterAdapter(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setCustomTypeface(Typeface typeface) {
        this.mCustomTypeface = typeface;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PrompterWordControl prompterWordControl = (PrompterWordControl) LayoutInflater.from(viewGroup.getContext()).inflate(C6033R.layout.prompter_word_control_layout, viewGroup, false);
        prompterWordControl.setTypeface(this.mCustomTypeface);
        prompterWordControl.setOnClickListener(this.mOnClickListener);
        return new ViewHolder(prompterWordControl);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        PrompterWord prompterWord = this.mWords.get(i);
        if (prompterWord != null) {
            viewHolder.mWc.update(prompterWord, i);
            viewHolder.mWc.animateUpdatedWord();
            ViewGroup.LayoutParams layoutParams = viewHolder.mWc.getLayoutParams();
            if (prompterWord.state() == PrompterWordState.Delete) {
                viewHolder.mWc.setVisibility(8);
                layoutParams.width = 1;
                viewHolder.mWc.setLayoutParams(layoutParams);
            } else {
                viewHolder.mWc.setVisibility(0);
                layoutParams.width = -2;
                viewHolder.mWc.setLayoutParams(layoutParams);
                viewHolder.mWc.getWord().setState(PrompterWordState.None);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mWords.size();
    }

    public List<PrompterWord> getWords() {
        return this.mWords;
    }

    public void clear() {
        this.mWords.clear();
        notifyDataSetChanged();
    }

    public void setWords(List<PrompterWord> list) {
        this.mWords = list;
        notifyDataSetChanged();
    }

    public boolean contains(int i) {
        return this.mIndexedWords.get(i) != null;
    }

    public void setListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
