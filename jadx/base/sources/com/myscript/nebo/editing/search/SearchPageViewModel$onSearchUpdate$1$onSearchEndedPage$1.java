package com.myscript.nebo.editing.search;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.SWIGVectorExtent;
import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SearchMatch;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchPageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$onSearchUpdate$1$onSearchEndedPage$1", m1609f = "SearchPageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class SearchPageViewModel$onSearchUpdate$1$onSearchEndedPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SearchPageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchPageViewModel$onSearchUpdate$1$onSearchEndedPage$1(SearchPageViewModel searchPageViewModel, Continuation<? super SearchPageViewModel$onSearchUpdate$1$onSearchEndedPage$1> continuation) {
        super(2, continuation);
        this.this$0 = searchPageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchPageViewModel$onSearchUpdate$1$onSearchEndedPage$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchPageViewModel$onSearchUpdate$1$onSearchEndedPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SearchPageState searchPageState = (SearchPageState) this.this$0._searchState.getValue();
            if (searchPageState != null) {
                SearchPageViewModel searchPageViewModel = this.this$0;
                if (searchPageState.getState() != SearchState.Active) {
                    return Unit.INSTANCE;
                }
                PageKey pageKey = searchPageState.getPageKey();
                if (pageKey != null && (Intrinsics.areEqual(searchPageViewModel.searchController.getPageKey(), pageKey) || Intrinsics.areEqual(searchPageViewModel.getLibraryRepository().getPaginatedContainerKeyFromPageKey(pageKey), searchPageViewModel.searchController.getPageKey()))) {
                    Extent extent = null;
                    String pageUUID = !searchPageViewModel.hits.isEmpty() ? ((SearchMatch) CollectionsKt.first(searchPageViewModel.hits)).getPageUUID() : null;
                    if (pageUUID != null) {
                        SWIGVectorExtent extents = ((SearchMatch) CollectionsKt.first(searchPageViewModel.hits)).getExtents();
                        Intrinsics.checkNotNullExpressionValue(extents, "getExtents(...)");
                        extent = (Extent) CollectionsKt.first((List) extents);
                    }
                    searchPageViewModel.getPageIdToShow().setValue(pageUUID);
                    searchPageViewModel._hitNavState.setValue(new SearchHitNavState(searchPageViewModel.getSelectedHitNumber(), searchPageViewModel.getHitCount(), extent));
                    searchPageViewModel._searchState.setValue(SearchPageState.copy$default(searchPageState, null, null, null, false, false, searchPageViewModel.searchController.getSearchType() == DMSSearchController.SearchType.GRID, false, 95, null));
                    searchPageViewModel._searchHits.setValue(CollectionsKt.toList(searchPageViewModel.hits));
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
