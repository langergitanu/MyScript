package com.myscript.nebo.dms.sharepage.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.dms.sharepage.C6280R;
import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharePageInvitedContactAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rJ\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0012H\u0016J\u0014\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter$InvitedContactViewHolder;", "contactList", "", "", "callback", "Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter$Callback;", "<init>", "(Ljava/util/List;Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter$Callback;)V", "getCallback", "()Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter$Callback;", "isDeleteDisabled", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "", "getItemCount", "setDeleteDisabled", "", "isDisabled", "onBindViewHolder", "holder", "position", "setList", "newContactList", "", "Callback", "InvitedContactViewHolder", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SharePageInvitedContactAdapter extends RecyclerView.Adapter<InvitedContactViewHolder> {
    private final Callback callback;
    private final List<String> contactList;
    private boolean isDeleteDisabled;

    /* JADX INFO: compiled from: SharePageInvitedContactAdapter.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter$Callback;", "", "removeAccess", "", "email", "", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void removeAccess(String email);
    }

    public SharePageInvitedContactAdapter(List<String> contactList, Callback callback) {
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.contactList = contactList;
        this.callback = callback;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public InvitedContactViewHolder onCreateViewHolder(ViewGroup parent, int p1) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C6280R.layout.share_page_contact_row, parent, false);
        Intrinsics.checkNotNull(viewInflate);
        return new InvitedContactViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.contactList.size();
    }

    public final void setDeleteDisabled(boolean isDisabled) {
        this.isDeleteDisabled = isDisabled;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(InvitedContactViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.getTextView().setText(this.contactList.get(position));
        holder.getDeleteButton().setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageInvitedContactAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SharePageInvitedContactAdapter.onBindViewHolder$lambda$0(this.f$0, position, view);
            }
        });
        holder.getDeleteButton().setEnabled(!this.isDeleteDisabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(SharePageInvitedContactAdapter sharePageInvitedContactAdapter, int i, View view) {
        sharePageInvitedContactAdapter.callback.removeAccess(sharePageInvitedContactAdapter.contactList.get(i));
        sharePageInvitedContactAdapter.contactList.remove(i);
        sharePageInvitedContactAdapter.notifyItemRemoved(i);
    }

    public final void setList(List<String> newContactList) {
        Intrinsics.checkNotNullParameter(newContactList, "newContactList");
        this.contactList.clear();
        this.contactList.addAll(newContactList);
        CollectionsKt.sortWith(this.contactList, new Comparator() { // from class: com.myscript.nebo.dms.sharepage.dialog.SharePageInvitedContactAdapter$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return SharePageInvitedContactAdapter.setList$lambda$0((String) obj, (String) obj2);
            }
        });
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int setList$lambda$0(String str, String str2) {
        return Collator.getInstance().compare(str, str2);
    }

    /* JADX INFO: compiled from: SharePageInvitedContactAdapter.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/dialog/SharePageInvitedContactAdapter$InvitedContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "setTextView", "(Landroid/widget/TextView;)V", "deleteButton", "getDeleteButton", "()Landroid/view/View;", "setDeleteButton", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class InvitedContactViewHolder extends RecyclerView.ViewHolder {
        private View deleteButton;
        private TextView textView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvitedContactViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(C6280R.id.share_page_contact_row_mail);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            this.textView = (TextView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(C6280R.id.share_page_contact_row_delete);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            this.deleteButton = viewFindViewById2;
        }

        public final TextView getTextView() {
            return this.textView;
        }

        public final void setTextView(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.textView = textView;
        }

        public final View getDeleteButton() {
            return this.deleteButton;
        }

        public final void setDeleteButton(View view) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.deleteButton = view;
        }
    }
}
