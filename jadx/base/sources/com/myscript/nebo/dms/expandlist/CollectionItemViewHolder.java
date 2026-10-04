package com.myscript.nebo.dms.expandlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.nebo.dms.event.CollectionMoreMenuEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionItemViewHolder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/dms/expandlist/CollectionItemViewHolder;", "Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "parent", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "collectionNameView", "Landroid/widget/TextView;", "moreButton", "Landroid/widget/ImageButton;", "arrowView", "Landroid/view/View;", "value", "collection", "getCollection", "()Lcom/myscript/nebo/dms/core/model/CollectionModel;", "bind", "", "unbind", "onExpansionToggled", "expanded", "", "setDraggedOn", "hovered", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CollectionItemViewHolder extends ParentViewHolder<CollectionModel, FolderModel> {
    public static final int $stable = 8;
    private final View arrowView;
    private CollectionModel collection;
    private final TextView collectionNameView;
    private final ImageButton moreButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionItemViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6208R.layout.dms_collection_item, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        View viewFindViewById = this.itemView.findViewById(C6208R.id.dms_collection_name);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.collectionNameView = (TextView) viewFindViewById;
        View viewFindViewById2 = this.itemView.findViewById(C6208R.id.dms_collection_more_menu);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.moreButton = (ImageButton) viewFindViewById2;
        View viewFindViewById3 = this.itemView.findViewById(C6208R.id.dms_collection_arrow);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.arrowView = viewFindViewById3;
    }

    public final CollectionModel getCollection() {
        return this.collection;
    }

    public final void bind(final CollectionModel collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
        this.itemView.setActivated(collection.getIsExpanded());
        this.arrowView.setVisibility(collection.isEmpty() ? 4 : 0);
        this.collectionNameView.setText(collection.getName());
        this.moreButton.setVisibility(collection.getIsSearch() ? 8 : 0);
        this.itemView.setOnClickListener(this);
        this.moreButton.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.expandlist.CollectionItemViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionItemViewHolder.bind$lambda$0(collection, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(CollectionModel collectionModel, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        iArr[0] = iArr[0] + view.getWidth();
        MainThreadBus.eventBus.post(new CollectionMoreMenuEvent(collectionModel.getCollectionKey(), iArr[0], iArr[1]));
    }

    public final void unbind() {
        this.itemView.setOnClickListener(null);
        this.moreButton.setOnClickListener(null);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);
        this.itemView.setActivated(!this.itemView.isActivated());
    }

    public final void setDraggedOn(boolean hovered) {
        this.itemView.setHovered(hovered);
    }
}
