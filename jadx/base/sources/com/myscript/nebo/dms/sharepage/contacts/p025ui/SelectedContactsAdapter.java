package com.myscript.nebo.dms.sharepage.contacts.p025ui;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.myscript.nebo.dms.sharepage.contacts.model.ContactItem;
import com.myscript.nebo.dms.sharepage.contacts.p025ui.ContactViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectedContactsAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/SelectedContactsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/ContactViewHolder;", "callback", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/ContactViewHolder$Callback;", "<init>", "(Lcom/myscript/nebo/dms/sharepage/contacts/ui/ContactViewHolder$Callback;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "submitList", "list", "", "Companion", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SelectedContactsAdapter extends ListAdapter<ContactItem, ContactViewHolder> {
    private final ContactViewHolder.Callback callback;
    private static final SelectedContactsAdapter$Companion$CONTACTS_DIFF_UTIL$1 CONTACTS_DIFF_UTIL = new DiffUtil.ItemCallback<ContactItem>() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SelectedContactsAdapter$Companion$CONTACTS_DIFF_UTIL$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ContactItem oldItem, ContactItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem.getEmail(), newItem.getEmail());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ContactItem oldItem, ContactItem newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectedContactsAdapter(ContactViewHolder.Callback callback) {
        super(CONTACTS_DIFF_UTIL);
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new ContactViewHolder(parent, this.callback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ContactItem item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        holder.bind(item);
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(List<ContactItem> list) {
        if (list == null) {
            super.submitList(null);
        } else {
            super.submitList(new ArrayList(list));
        }
    }
}
