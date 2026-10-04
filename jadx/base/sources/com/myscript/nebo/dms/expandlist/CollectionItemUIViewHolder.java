package com.myscript.nebo.dms.expandlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.myscript.nebo.dms.C6208R;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.snt.core.CollectionKey;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DmsSimpleAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\nJ\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/dms/expandlist/CollectionItemUIViewHolder;", "Lcom/bignerdranch/expandablerecyclerview/ParentViewHolder;", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "parent", "Landroid/view/ViewGroup;", "onCollectionMoreMenuClicked", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/myscript/snt/core/CollectionKey;", "", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "arrowIcon", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "nameLabel", "Landroid/widget/TextView;", "moreIcon", "canExpand", "", "bind", "collection", "unbind", "onClick", "view", "onExpansionToggled", "expanded", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CollectionItemUIViewHolder extends ParentViewHolder<CollectionModel, FolderModel> {
    public static final int $stable = 8;
    private final ImageView arrowIcon;
    private boolean canExpand;
    private final View moreIcon;
    private final TextView nameLabel;
    private final Function2<View, CollectionKey, Unit> onCollectionMoreMenuClicked;

    public final void unbind() {
    }

    public /* synthetic */ CollectionItemUIViewHolder(ViewGroup viewGroup, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? null : function2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CollectionItemUIViewHolder(ViewGroup parent, Function2<? super View, ? super CollectionKey, Unit> function2) {
        super(LayoutInflater.from(parent.getContext()).inflate(C6208R.layout.dms_collection_item, parent, false));
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.onCollectionMoreMenuClicked = function2;
        this.arrowIcon = (ImageView) this.itemView.findViewById(C6208R.id.dms_collection_arrow);
        this.nameLabel = (TextView) this.itemView.findViewById(C6208R.id.dms_collection_name);
        this.moreIcon = this.itemView.findViewById(C6208R.id.dms_collection_more_menu);
        this.canExpand = true;
    }

    public final void bind(final CollectionModel collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.itemView.setActivated(collection.getIsExpanded());
        this.arrowIcon.setVisibility((collection.getFolders().isEmpty() || collection.getIsTrashed()) ? 4 : 0);
        this.nameLabel.setText(collection.getName());
        View moreIcon = this.moreIcon;
        Intrinsics.checkNotNullExpressionValue(moreIcon, "moreIcon");
        moreIcon.setVisibility(this.onCollectionMoreMenuClicked != null ? 0 : 8);
        final Function2<View, CollectionKey, Unit> function2 = this.onCollectionMoreMenuClicked;
        if (function2 != null) {
            this.moreIcon.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.dms.expandlist.CollectionItemUIViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CollectionItemUIViewHolder.bind$lambda$0$0(function2, collection, view);
                }
            });
        }
        this.canExpand = !collection.getIsTrashed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0$0(Function2 function2, CollectionModel collectionModel, View view) {
        Intrinsics.checkNotNull(view);
        function2.invoke(view, collectionModel.getCollectionKey());
    }

    @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            Result.Companion companion = Result.INSTANCE;
            CollectionItemUIViewHolder collectionItemUIViewHolder = this;
            if (this.canExpand) {
                super.onClick(view);
            }
            Result.m14499constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m14499constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Override // com.bignerdranch.expandablerecyclerview.ParentViewHolder
    public void onExpansionToggled(boolean expanded) {
        super.onExpansionToggled(expanded);
        this.itemView.setActivated(!this.itemView.isActivated());
    }
}
