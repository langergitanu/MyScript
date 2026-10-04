package com.myscript.nebo.inspector;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NeboFilesAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/inspector/NeboFilesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/myscript/nebo/inspector/NeboFile;", "Lcom/myscript/nebo/inspector/NeboFileViewHolder;", "<init>", "()V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "onViewRecycled", "submitList", "list", "", "Companion", "nebo-inspector_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboFilesAdapter extends ListAdapter<NeboFile, NeboFileViewHolder> {
    private static final NeboFilesAdapter$Companion$NEBO_FILE_DIFF_UTIL_CALLBACK$1 NEBO_FILE_DIFF_UTIL_CALLBACK = new DiffUtil.ItemCallback<NeboFile>() { // from class: com.myscript.nebo.inspector.NeboFilesAdapter$Companion$NEBO_FILE_DIFF_UTIL_CALLBACK$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(NeboFile oldItem, NeboFile newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getFile().getCanonicalPath(), newItem.getFile().getCanonicalPath());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(NeboFile oldItem, NeboFile newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getLabel(), newItem.getLabel());
        }
    };

    public NeboFilesAdapter() {
        super(NEBO_FILE_DIFF_UTIL_CALLBACK);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public NeboFileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new NeboFileViewHolder(parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(NeboFileViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        NeboFile item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(NeboFileViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.unbind();
        super.onViewRecycled(holder);
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<NeboFile> list) {
        if (list == null) {
            super.submitList(null);
        } else {
            super.submitList(new ArrayList(list));
        }
    }
}
