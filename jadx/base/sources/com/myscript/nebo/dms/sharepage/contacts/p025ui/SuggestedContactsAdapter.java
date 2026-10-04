package com.myscript.nebo.dms.sharepage.contacts.p025ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.myscript.nebo.dms.sharepage.C6280R;
import com.myscript.nebo.dms.sharepage.contacts.model.ContactItem;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SuggestedContactsAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/dms/sharepage/contacts/ui/SuggestedContactsAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/myscript/nebo/dms/sharepage/contacts/model/ContactItem;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "getFilter", "Landroid/widget/Filter;", "dms-share-page_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SuggestedContactsAdapter extends ArrayAdapter<ContactItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuggestedContactsAdapter(Context context) {
        super(context, C6280R.layout.share_page_contact_layout, C6280R.id.share_page_contact_name);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = super.getView(position, convertView, parent);
        Intrinsics.checkNotNullExpressionValue(view, "getView(...)");
        ContactItem item = getItem(position);
        if (item != null) {
            ((TextView) view.findViewById(C6280R.id.share_page_contact_name)).setText(item.getDisplayName());
            ((TextView) view.findViewById(C6280R.id.share_page_contact_email)).setText(item.getEmail());
        }
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: com.myscript.nebo.dms.sharepage.contacts.ui.SuggestedContactsAdapter.getFilter.1
            @Override // android.widget.Filter
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
            }

            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence constraint) {
                return new Filter.FilterResults();
            }
        };
    }
}
