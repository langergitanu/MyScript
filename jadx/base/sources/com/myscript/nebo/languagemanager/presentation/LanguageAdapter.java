package com.myscript.nebo.languagemanager.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.languagemanager.databinding.ItemExplanationsBinding;
import com.myscript.nebo.languagemanager.databinding.ItemHeaderBinding;
import com.myscript.nebo.languagemanager.databinding.ItemLanguageBinding;
import com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/LanguageAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/myscript/nebo/languagemanager/presentation/model/LanguageManagerItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "callback", "Lcom/myscript/nebo/languagemanager/presentation/Callback;", "<init>", "(Lcom/myscript/nebo/languagemanager/presentation/Callback;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "getItemViewType", "submitList", "list", "", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LanguageAdapter extends ListAdapter<LanguageManagerItem, RecyclerView.ViewHolder> {
    private final Callback callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LanguageAdapter(Callback callback) {
        super(LanguageAdapterKt.getLANGUAGE_DIFF_CALLBACK());
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            ItemExplanationsBinding itemExplanationsBindingInflate = ItemExplanationsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(itemExplanationsBindingInflate, "inflate(...)");
            return new ExplanationViewHolder(itemExplanationsBindingInflate);
        }
        if (viewType == 1) {
            ItemHeaderBinding itemHeaderBindingInflate = ItemHeaderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(itemHeaderBindingInflate, "inflate(...)");
            return new HeaderViewHolder(itemHeaderBindingInflate);
        }
        if (viewType == 2) {
            ItemLanguageBinding itemLanguageBindingInflate = ItemLanguageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(itemLanguageBindingInflate, "inflate(...)");
            return new LanguageViewHolder(itemLanguageBindingInflate);
        }
        throw new IllegalStateException(("Unknown viewType " + viewType).toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof HeaderViewHolder) {
            LanguageManagerItem item = getItem(position);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem.Section");
            ((HeaderViewHolder) holder).bind((LanguageManagerItem.Section) item);
            return;
        }
        if (holder instanceof LanguageViewHolder) {
            LanguageManagerItem item2 = getItem(position);
            Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type com.myscript.nebo.languagemanager.presentation.model.LanguageManagerItem.Lang");
            ((LanguageViewHolder) holder).bind((LanguageManagerItem.Lang) item2, this.callback);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof LanguageViewHolder) {
            ((LanguageViewHolder) holder).unbind();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<LanguageManagerItem> list) {
        if (list == null) {
            super.submitList(null);
        } else {
            super.submitList(new ArrayList(list));
        }
    }
}
