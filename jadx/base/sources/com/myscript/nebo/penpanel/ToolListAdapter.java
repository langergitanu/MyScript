package com.myscript.nebo.penpanel;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.snt.core.ToolConfiguration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToolListAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB%\u0012\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J&\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aH\u0016R$\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/penpanel/ToolListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/myscript/nebo/penpanel/ToolPill;", "Lcom/myscript/nebo/penpanel/ToolPillViewHolder;", "callback", "Lkotlin/Function2;", "Lcom/myscript/snt/core/ToolConfiguration;", "Lcom/myscript/nebo/penpanel/ToolPillView;", "", "Lcom/myscript/nebo/penpanel/ToolPillCallback;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "payloads", "", "", "onViewRecycled", "submitList", "list", "", "Companion", "penpanel_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ToolListAdapter extends ListAdapter<ToolPill, ToolPillViewHolder> {
    private static final ToolListAdapter$Companion$TOOL_PILL_DIFF_UTIL_CALLBACK$1 TOOL_PILL_DIFF_UTIL_CALLBACK = new DiffUtil.ItemCallback<ToolPill>() { // from class: com.myscript.nebo.penpanel.ToolListAdapter$Companion$TOOL_PILL_DIFF_UTIL_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ToolPill oldItem, ToolPill newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getToolConfiguration().getType() == newItem.getToolConfiguration().getType();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ToolPill oldItem, ToolPill newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public Object getChangePayload(ToolPill oldItem, ToolPill newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return (oldItem.getToolConfiguration().getState() != newItem.getToolConfiguration().getState() || oldItem.getToolConfiguration().getColor2() == newItem.getToolConfiguration().getColor2()) ? super.getChangePayload(oldItem, newItem) : ToolPillViewHolder.COLOR_UPDATE_PAYLOAD;
        }
    };
    private final Function2<ToolConfiguration, ToolPillView, Unit> callback;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((ToolPillViewHolder) viewHolder, i, (List<Object>) list);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ToolListAdapter(Function2<? super ToolConfiguration, ? super ToolPillView, Unit> callback) {
        super(TOOL_PILL_DIFF_UTIL_CALLBACK);
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ToolPillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new ToolPillViewHolder(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ToolPillViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        onBindViewHolder(holder, position, (List<Object>) new ArrayList());
    }

    public void onBindViewHolder(ToolPillViewHolder holder, int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ToolPill item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item, this.callback, payloads);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(ToolPillViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.unbind();
        super.onViewRecycled(holder);
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<ToolPill> list) {
        if (list == null) {
            super.submitList(null);
        } else {
            super.submitList(new ArrayList(list));
        }
    }
}
