package com.myscript.nebo.languagemanager.presentation;

import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.languagemanager.databinding.ItemExplanationsBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LanguageAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/ExplanationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/myscript/nebo/languagemanager/databinding/ItemExplanationsBinding;", "<init>", "(Lcom/myscript/nebo/languagemanager/databinding/ItemExplanationsBinding;)V", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ExplanationViewHolder extends RecyclerView.ViewHolder {
    private final ItemExplanationsBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExplanationViewHolder(ItemExplanationsBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }
}
