package com.myscript.nebo.dms.expandlist;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.model.ExpandableWrapper;
import com.myscript.android.utils.StableIdKeyProvider;
import com.myscript.nebo.dms.core.model.CollectionModel;
import com.myscript.nebo.dms.core.model.FolderModel;
import com.myscript.snt.core.CollectionKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DmsSimpleAdapter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u00020\u0006Bg\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\b\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J \u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u0002H\u0016J(\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u0003H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0019H\u0016J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0019H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m1599d2 = {"Lcom/myscript/nebo/dms/expandlist/DmsSimpleAdapter;", "Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter;", "Lcom/myscript/nebo/dms/core/model/CollectionModel;", "Lcom/myscript/nebo/dms/core/model/FolderModel;", "Lcom/myscript/nebo/dms/expandlist/CollectionItemUIViewHolder;", "Lcom/myscript/nebo/dms/expandlist/NotebookItemUIViewHolder;", "Lcom/bignerdranch/expandablerecyclerview/ExpandableRecyclerAdapter$ExpandCollapseListener;", "onNotebookClicked", "Lkotlin/Function1;", "", "onNotebookCoverClicked", "onNotebookLongClicked", "", "onCollectionMoreMenuClicked", "Lkotlin/Function2;", "Landroid/view/View;", "Lcom/myscript/snt/core/CollectionKey;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "stableIds", "Lcom/myscript/android/utils/StableIdKeyProvider;", "", "getItemId", "", "position", "", "onCreateParentViewHolder", "parentViewGroup", "Landroid/view/ViewGroup;", "viewType", "onCreateChildViewHolder", "childViewGroup", "onBindParentViewHolder", "parentViewHolder", "parentPosition", "parent", "onBindChildViewHolder", "childViewHolder", "childPosition", "child", "onViewDetachedFromWindow", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onParentExpanded", "onParentCollapsed", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DmsSimpleAdapter extends ExpandableRecyclerAdapter<CollectionModel, FolderModel, CollectionItemUIViewHolder, NotebookItemUIViewHolder> implements ExpandableRecyclerAdapter.ExpandCollapseListener {
    public static final int $stable = 8;
    private final Function2<View, CollectionKey, Unit> onCollectionMoreMenuClicked;
    private final Function1<FolderModel, Unit> onNotebookClicked;
    private final Function1<FolderModel, Unit> onNotebookCoverClicked;
    private final Function1<FolderModel, Boolean> onNotebookLongClicked;
    private final StableIdKeyProvider<String> stableIds;

    public DmsSimpleAdapter() {
        this(null, null, null, null, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(FolderModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    public /* synthetic */ DmsSimpleAdapter(Function1 function1, Function1 function12, Function1 function13, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1() { // from class: com.myscript.nebo.dms.expandlist.DmsSimpleAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DmsSimpleAdapter._init_$lambda$0((FolderModel) obj);
            }
        } : function1, (i & 2) != 0 ? new Function1() { // from class: com.myscript.nebo.dms.expandlist.DmsSimpleAdapter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DmsSimpleAdapter._init_$lambda$1((FolderModel) obj);
            }
        } : function12, (i & 4) != 0 ? new Function1() { // from class: com.myscript.nebo.dms.expandlist.DmsSimpleAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(DmsSimpleAdapter._init_$lambda$2((FolderModel) obj));
            }
        } : function13, (i & 8) != 0 ? null : function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(FolderModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(FolderModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DmsSimpleAdapter(Function1<? super FolderModel, Unit> onNotebookClicked, Function1<? super FolderModel, Unit> onNotebookCoverClicked, Function1<? super FolderModel, Boolean> onNotebookLongClicked, Function2<? super View, ? super CollectionKey, Unit> function2) {
        super(CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(onNotebookClicked, "onNotebookClicked");
        Intrinsics.checkNotNullParameter(onNotebookCoverClicked, "onNotebookCoverClicked");
        Intrinsics.checkNotNullParameter(onNotebookLongClicked, "onNotebookLongClicked");
        this.onNotebookClicked = onNotebookClicked;
        this.onNotebookCoverClicked = onNotebookCoverClicked;
        this.onNotebookLongClicked = onNotebookLongClicked;
        this.onCollectionMoreMenuClicked = function2;
        this.stableIds = new StableIdKeyProvider<>();
        setHasStableIds(true);
        setExpandCollapseListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        ExpandableWrapper expandableWrapper = (ExpandableWrapper) this.mFlatItemList.get(position);
        if (expandableWrapper.isParent()) {
            StableIdKeyProvider<String> stableIdKeyProvider = this.stableIds;
            String strSerialize = ((CollectionModel) expandableWrapper.getParent()).getCollectionKey().serialize();
            Intrinsics.checkNotNullExpressionValue(strSerialize, "serialize(...)");
            return stableIdKeyProvider.getItemId(strSerialize);
        }
        StableIdKeyProvider<String> stableIdKeyProvider2 = this.stableIds;
        String strSerialize2 = ((FolderModel) expandableWrapper.getChild()).getNotebookKey().serialize();
        Intrinsics.checkNotNullExpressionValue(strSerialize2, "serialize(...)");
        return stableIdKeyProvider2.getItemId(strSerialize2);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public CollectionItemUIViewHolder onCreateParentViewHolder(ViewGroup parentViewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(parentViewGroup, "parentViewGroup");
        return new CollectionItemUIViewHolder(parentViewGroup, this.onCollectionMoreMenuClicked);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public NotebookItemUIViewHolder onCreateChildViewHolder(ViewGroup childViewGroup, int viewType) {
        Intrinsics.checkNotNullParameter(childViewGroup, "childViewGroup");
        return new NotebookItemUIViewHolder(childViewGroup);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public void onBindParentViewHolder(CollectionItemUIViewHolder parentViewHolder, int parentPosition, CollectionModel parent) {
        Intrinsics.checkNotNullParameter(parentViewHolder, "parentViewHolder");
        Intrinsics.checkNotNullParameter(parent, "parent");
        parentViewHolder.bind(parent);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter
    public void onBindChildViewHolder(NotebookItemUIViewHolder childViewHolder, int parentPosition, int childPosition, FolderModel child) {
        Intrinsics.checkNotNullParameter(childViewHolder, "childViewHolder");
        Intrinsics.checkNotNullParameter(child, "child");
        childViewHolder.bind(child, this.onNotebookClicked, this.onNotebookCoverClicked, this.onNotebookLongClicked);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof CollectionItemUIViewHolder) {
            ((CollectionItemUIViewHolder) holder).unbind();
        } else if (holder instanceof NotebookItemUIViewHolder) {
            ((NotebookItemUIViewHolder) holder).unbind();
        }
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter.ExpandCollapseListener
    public void onParentExpanded(int parentPosition) {
        getParentList().get(parentPosition).setExpanded(true);
        notifyParentChanged(parentPosition);
    }

    @Override // com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter.ExpandCollapseListener
    public void onParentCollapsed(int parentPosition) {
        getParentList().get(parentPosition).setExpanded(false);
        notifyParentChanged(parentPosition);
    }
}
