package com.myscript.nebo.userdict.p035ui;

import androidx.recyclerview.selection.SelectionPredicates;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.selection.StorageStrategy;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDictionaryFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m1599d2 = {"createSelectionTracker", "Landroidx/recyclerview/selection/SelectionTracker;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "user-dictionary_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class UserDictionaryFragmentKt {
    public static final SelectionTracker<Long> createSelectionTracker(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        SelectionTracker<Long> selectionTrackerBuild = new SelectionTracker.Builder("selection_UserDictionaryFragment", recyclerView, new RecyclerViewKeyProvider(), new UserDictionaryDetailsLookup(recyclerView), StorageStrategy.createLongStorage()).withSelectionPredicate(SelectionPredicates.createSelectAnything()).build();
        Intrinsics.checkNotNullExpressionValue(selectionTrackerBuild, "build(...)");
        return selectionTrackerBuild;
    }
}
