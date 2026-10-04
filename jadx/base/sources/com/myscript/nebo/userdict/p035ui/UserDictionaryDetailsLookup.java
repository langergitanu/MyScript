package com.myscript.nebo.userdict.p035ui;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDictionaryFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/userdict/ui/UserDictionaryDetailsLookup;", "Landroidx/recyclerview/selection/ItemDetailsLookup;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getItemDetails", "Landroidx/recyclerview/selection/ItemDetailsLookup$ItemDetails;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "user-dictionary_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryDetailsLookup extends ItemDetailsLookup<Long> {
    private final RecyclerView recyclerView;

    public UserDictionaryDetailsLookup(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.selection.ItemDetailsLookup
    public ItemDetailsLookup.ItemDetails<Long> getItemDetails(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        View viewFindChildViewUnder = this.recyclerView.findChildViewUnder(event.getX(), event.getY());
        if (viewFindChildViewUnder == null) {
            return null;
        }
        RecyclerView.ViewHolder childViewHolder = this.recyclerView.getChildViewHolder(viewFindChildViewUnder);
        UserDictionaryItemViewHolder userDictionaryItemViewHolder = childViewHolder instanceof UserDictionaryItemViewHolder ? (UserDictionaryItemViewHolder) childViewHolder : null;
        if (userDictionaryItemViewHolder != null) {
            return userDictionaryItemViewHolder.getItemDetails();
        }
        return null;
    }
}
