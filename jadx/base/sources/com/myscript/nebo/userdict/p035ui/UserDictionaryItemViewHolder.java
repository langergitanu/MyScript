package com.myscript.nebo.userdict.p035ui;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.userdict.C6889R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDictionaryAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/UserDictionaryItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "wordLabel", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "checkbox", "Landroid/widget/ImageView;", "bind", "", "item", "Lcom/myscript/nebo/userdict/ui/UserDictionaryItem;", "selectionModeEnabled", "", "selected", "getItemDetails", "Landroidx/recyclerview/selection/ItemDetailsLookup$ItemDetails;", "", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryItemViewHolder extends RecyclerView.ViewHolder {
    private final ImageView checkbox;
    private final TextView wordLabel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserDictionaryItemViewHolder(ViewGroup parent) {
        super(ViewExt.inflate$default(parent, C6889R.layout.user_dictionary_item, false, 2, null));
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.wordLabel = (TextView) this.itemView.findViewById(C6889R.id.user_dict_item_label);
        this.checkbox = (ImageView) this.itemView.findViewById(C6889R.id.user_dict_item_checkbox);
    }

    public final void bind(UserDictionaryItem item, boolean selectionModeEnabled, boolean selected) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.wordLabel.setText(item.getLabel());
        this.itemView.setSelected(selected);
        this.checkbox.setVisibility(selectionModeEnabled ? 0 : 4);
        this.itemView.setTag(item);
    }

    public final ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
        return new ItemDetailsLookup.ItemDetails<Long>() { // from class: com.myscript.nebo.userdict.ui.UserDictionaryItemViewHolder.getItemDetails.1
            @Override // androidx.recyclerview.selection.ItemDetailsLookup.ItemDetails
            public int getPosition() {
                return UserDictionaryItemViewHolder.this.getAdapterPosition();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.recyclerview.selection.ItemDetailsLookup.ItemDetails
            public Long getSelectionKey() {
                return Long.valueOf(UserDictionaryItemViewHolder.this.getAdapterPosition());
            }
        };
    }
}
