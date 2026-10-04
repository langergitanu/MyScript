package com.myscript.nebo.editing.background;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackgroundColorListAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/myscript/nebo/editing/background/BackgroundColorListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/myscript/nebo/note/ui/PageBackgroundColor;", "Lcom/myscript/nebo/editing/background/ColorViewHolder;", "onColorSelected", "Lkotlin/Function1;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "onViewRecycled", "submitList", "list", "", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackgroundColorListAdapter extends ListAdapter<PageBackgroundColor, ColorViewHolder> {
    private final Function1<PageBackgroundColor, Unit> onColorSelected;
    public static final int $stable = 8;
    private static final BackgroundColorListAdapter$Companion$COLOR_DIFF_UTIL_CALLBACK$1 COLOR_DIFF_UTIL_CALLBACK = new DiffUtil.ItemCallback<PageBackgroundColor>() { // from class: com.myscript.nebo.editing.background.BackgroundColorListAdapter$Companion$COLOR_DIFF_UTIL_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(PageBackgroundColor oldItem, PageBackgroundColor newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getColor() == newItem.getColor();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(PageBackgroundColor oldItem, PageBackgroundColor newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BackgroundColorListAdapter(Function1<? super PageBackgroundColor, Unit> onColorSelected) {
        super(COLOR_DIFF_UTIL_CALLBACK);
        Intrinsics.checkNotNullParameter(onColorSelected, "onColorSelected");
        this.onColorSelected = onColorSelected;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new ColorViewHolder(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ColorViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        PageBackgroundColor item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item, this.onColorSelected);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(ColorViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.unbind();
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<PageBackgroundColor> list) {
        if (list == null) {
            super.submitList(null);
        } else {
            super.submitList(CollectionsKt.toList(list));
        }
    }
}
