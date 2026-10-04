package com.myscript.nebo.editing.search;

import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchPageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$onSearchUpdate$1$onSearchStartedPage$1", m1609f = "SearchPageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class SearchPageViewModel$onSearchUpdate$1$onSearchStartedPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PageKey $pageKey;
    final /* synthetic */ String $searchQuery;
    int label;
    final /* synthetic */ SearchPageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchPageViewModel$onSearchUpdate$1$onSearchStartedPage$1(SearchPageViewModel searchPageViewModel, PageKey pageKey, String str, Continuation<? super SearchPageViewModel$onSearchUpdate$1$onSearchStartedPage$1> continuation) {
        super(2, continuation);
        this.this$0 = searchPageViewModel;
        this.$pageKey = pageKey;
        this.$searchQuery = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchPageViewModel$onSearchUpdate$1$onSearchStartedPage$1(this.this$0, this.$pageKey, this.$searchQuery, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchPageViewModel$onSearchUpdate$1$onSearchStartedPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0._searchState.setValue(new SearchPageState(SearchState.Active, this.$pageKey, this.$searchQuery, true, true, true, false, 64, null));
        return Unit.INSTANCE;
    }
}
