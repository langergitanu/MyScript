package com.myscript.nebo.userdict.p035ui;

import android.view.ViewGroup;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDictionaryAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010#\u001a\u00020\u001e2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010!H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/UserDictionaryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/myscript/nebo/userdict/ui/UserDictionaryItem;", "Lcom/myscript/nebo/userdict/ui/UserDictionaryItemViewHolder;", "<init>", "()V", "isInSelectionMode", "", "()Z", "setInSelectionMode", "(Z)V", "tracker", "Landroidx/recyclerview/selection/SelectionTracker;", "", "getTracker$user_dictionary_release", "()Landroidx/recyclerview/selection/SelectionTracker;", "setTracker$user_dictionary_release", "(Landroidx/recyclerview/selection/SelectionTracker;)V", "stableIds", "", "nextId", "Ljava/util/concurrent/atomic/AtomicLong;", "getItemId", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "payloads", "", "", "submitList", "list", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryAdapter extends ListAdapter<UserDictionaryItem, UserDictionaryItemViewHolder> {
    private boolean isInSelectionMode;
    private final AtomicLong nextId;
    private final Map<UserDictionaryItem, Long> stableIds;
    private SelectionTracker<Long> tracker;

    public UserDictionaryAdapter() {
        super(UserDictionaryAdapterKt.getUSER_DICTIONARY_DIFF_CALLBACK());
        this.stableIds = new LinkedHashMap();
        this.nextId = new AtomicLong(0L);
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((UserDictionaryItemViewHolder) viewHolder, i, (List<? extends Object>) list);
    }

    /* JADX INFO: renamed from: isInSelectionMode, reason: from getter */
    public final boolean getIsInSelectionMode() {
        return this.isInSelectionMode;
    }

    public final void setInSelectionMode(boolean z) {
        this.isInSelectionMode = z;
    }

    public final SelectionTracker<Long> getTracker$user_dictionary_release() {
        return this.tracker;
    }

    public final void setTracker$user_dictionary_release(SelectionTracker<Long> selectionTracker) {
        this.tracker = selectionTracker;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        Map<UserDictionaryItem, Long> map = this.stableIds;
        UserDictionaryItem item = getItem(position);
        Long lValueOf = map.get(item);
        if (lValueOf == null) {
            lValueOf = Long.valueOf(this.nextId.getAndIncrement());
            map.put(item, lValueOf);
        }
        return lValueOf.longValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UserDictionaryItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new UserDictionaryItemViewHolder(parent);
    }

    public void onBindViewHolder(UserDictionaryItemViewHolder holder, int position, List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        SelectionTracker<Long> selectionTracker = this.tracker;
        boolean zIsSelected = selectionTracker != null ? selectionTracker.isSelected(Long.valueOf(position)) : false;
        UserDictionaryItem item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item, this.isInSelectionMode, zIsSelected);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(UserDictionaryItemViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<? extends Object> listEmptyList = Collections.emptyList();
        Intrinsics.checkNotNullExpressionValue(listEmptyList, "emptyList(...)");
        onBindViewHolder(holder, position, listEmptyList);
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<UserDictionaryItem> list) {
        if (list == null) {
            super.submitList(null);
        } else {
            super.submitList(new ArrayList(list));
        }
    }
}
