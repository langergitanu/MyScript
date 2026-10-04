package com.myscript.nebo.dms.sharepage.contacts.p025ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.nebo.dms.sharepage.C6280R;
import com.myscript.nebo.dms.sharepage.contacts.model.ContactItem;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SelectedContactsAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "callback", "Lcom/myscript/nebo/dms/sharepage/contacts/ui/ContactViewHolder$Callback;", "<init>", "(Landroid/view/ViewGroup;Lcom/myscript/nebo/dms/sharepage/contacts/ui/ContactViewHolder$Callback;)V", "Ljava/lang/ref/WeakReference;", "name", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "email", "removeButton", "Landroid/view/View;", "bind", "", "contact", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "Callback", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ContactViewHolder extends RecyclerView.ViewHolder {
    private final WeakReference<Callback> callback;
    private final TextView email;
    private final TextView name;
    private final View removeButton;

    /* JADX INFO: compiled from: SelectedContactsAdapter.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/ContactViewHolder$Callback;", "", "onContactItemDeleted", "", "contact", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void onContactItemDeleted(ContactItem contact);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactViewHolder(ViewGroup parent, Callback callback) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6280R.layout.share_page_contact_layout, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = new WeakReference<>(callback);
        this.name = (TextView) this.itemView.findViewById(C6280R.id.share_page_contact_name);
        this.email = (TextView) this.itemView.findViewById(C6280R.id.share_page_contact_email);
        this.removeButton = this.itemView.findViewById(C6280R.id.share_page_contact_remove_button);
    }

    public final void bind(final ContactItem contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        boolean z = contact.getDisplayName().length() > 0;
        TextView textView = this.name;
        String displayName = contact.getDisplayName();
        if (StringsKt.isBlank(displayName)) {
            displayName = null;
        }
        if (displayName == null) {
            displayName = contact.getEmail();
        }
        textView.setText(displayName);
        TextView email = this.email;
        Intrinsics.checkNotNullExpressionValue(email, "email");
        email.setVisibility(z ? 0 : 8);
        this.removeButton.setVisibility(0);
        this.removeButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.ContactViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactViewHolder.bind$lambda$0(this.f$0, contact, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(ContactViewHolder contactViewHolder, ContactItem contactItem, View view) {
        Callback callback = contactViewHolder.callback.get();
        if (callback != null) {
            callback.onContactItemDeleted(contactItem);
        }
    }
}
