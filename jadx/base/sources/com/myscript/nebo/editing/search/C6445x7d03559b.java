package com.myscript.nebo.editing.search;

import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SearchMatch;
import java.util.Collection;
import java.util.Iterator;
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

/* JADX INFO: renamed from: com.myscript.nebo.editing.search.SearchPageViewModel$refreshHitBoundsInternal$currentPageMatches$1 */
/* JADX INFO: compiled from: SearchPageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0004*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00030\u0001*\u00020\u0005H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/snt/core/SearchMatch;", "", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$refreshHitBoundsInternal$currentPageMatches$1", m1609f = "SearchPageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class C6445x7d03559b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<SearchMatch>>, Object> {
    final /* synthetic */ PageKey $pageKey;
    int label;
    final /* synthetic */ SearchPageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6445x7d03559b(SearchPageViewModel searchPageViewModel, PageKey pageKey, Continuation<? super C6445x7d03559b> continuation) {
        super(2, continuation);
        this.this$0 = searchPageViewModel;
        this.$pageKey = pageKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6445x7d03559b(this.this$0, this.$pageKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<SearchMatch>> continuation) {
        return ((C6445x7d03559b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        PageModel paginatedContainerFromPageKey = this.this$0.getLibraryRepository().getPaginatedContainerFromPageKey(this.$pageKey);
        if (paginatedContainerFromPageKey != null) {
            SearchPageViewModel searchPageViewModel = this.this$0;
            List mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.emptyList());
            Iterator<T> it = searchPageViewModel.getLibraryRepository().getPages(paginatedContainerFromPageKey.getPageKey()).iterator();
            while (it.hasNext()) {
                List<SearchMatch> listRetrieveDeserializedSearchResults = searchPageViewModel.searchController.getSearchController().retrieveDeserializedSearchResults(((PageModel) it.next()).getPageKey());
                Intrinsics.checkNotNull(listRetrieveDeserializedSearchResults);
                Iterator<T> it2 = listRetrieveDeserializedSearchResults.iterator();
                while (it2.hasNext()) {
                    mutableList.add((SearchMatch) it2.next());
                }
            }
            if (mutableList != null) {
                return mutableList;
            }
        }
        return this.this$0.searchController.getSearchController().retrieveDeserializedSearchResults(this.$pageKey);
    }
}
