package com.myscript.nebo.editing.background;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundPatternListAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0018\u0010\u0013\u001a\u00020\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/editing/background/BackgroundPatternListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/myscript/nebo/note/ui/PageBackgroundPattern;", "Lcom/myscript/nebo/editing/background/PatternViewHolder;", "onPatternSelected", "Lkotlin/Function1;", "Lcom/myscript/atk/core/BackgroundPattern;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewRecycled", "submitList", "list", "", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackgroundPatternListAdapter extends ListAdapter<PageBackgroundPattern, PatternViewHolder> {
    private final Function1<BackgroundPattern, Unit> onPatternSelected;
    public static final int $stable = 8;
    private static final C6422x781e6d11 PATTERN_DIFF_UTIL_CALLBACK = new DiffUtil.ItemCallback<PageBackgroundPattern>() { // from class: com.myscript.nebo.editing.background.BackgroundPatternListAdapter$Companion$PATTERN_DIFF_UTIL_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(PageBackgroundPattern oldItem, PageBackgroundPattern newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getPattern() == newItem.getPattern();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(PageBackgroundPattern oldItem, PageBackgroundPattern newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundPatternListAdapter(Function1<? super BackgroundPattern, Unit> onPatternSelected) {
        super(PATTERN_DIFF_UTIL_CALLBACK);
        Intrinsics.checkNotNullParameter(onPatternSelected, "onPatternSelected");
        this.onPatternSelected = onPatternSelected;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PatternViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new PatternViewHolder(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PatternViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PageBackgroundPattern item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item, this.onPatternSelected);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(PatternViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.unbind();
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<PageBackgroundPattern> list) {
        if (list == null) {
            super.submitList(null);
        } else {
            super.submitList(CollectionsKt.toList(list));
        }
    }
}
