package com.myscript.nebo.editing.search;

import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SearchMatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchPageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.search.SearchPageViewModel$onDMSSearchUpdate$1$onSearchEnded$1", m1609f = "SearchPageViewModel.kt", m1610i = {0, 0}, m1611l = {113}, m1612m = "invokeSuspend", m1613n = {"it", "$i$a$-let-SearchPageViewModel$onDMSSearchUpdate$1$onSearchEnded$1$1"}, m1614nl = {114}, m1615s = {"L$1", "I$0"}, m1616v = 2)
final class SearchPageViewModel$onDMSSearchUpdate$1$onSearchEnded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SearchPageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchPageViewModel$onDMSSearchUpdate$1$onSearchEnded$1(SearchPageViewModel searchPageViewModel, Continuation<? super SearchPageViewModel$onDMSSearchUpdate$1$onSearchEnded$1> continuation) {
        super(2, continuation);
        this.this$0 = searchPageViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchPageViewModel$onDMSSearchUpdate$1$onSearchEnded$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchPageViewModel$onDMSSearchUpdate$1$onSearchEnded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PageKey pageKey;
        SearchPageViewModel searchPageViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SearchPageState value = this.this$0.getSearchState().getValue();
            if (value != null && (pageKey = value.getPageKey()) != null) {
                SearchPageViewModel searchPageViewModel2 = this.this$0;
                this.L$0 = searchPageViewModel2;
                this.L$1 = SpillingKt.nullOutSpilledVariable(pageKey);
                this.I$0 = 0;
                this.label = 1;
                if (searchPageViewModel2.refreshHitBoundsInternal(pageKey, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                searchPageViewModel = searchPageViewModel2;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        searchPageViewModel = (SearchPageViewModel) this.L$0;
        ResultKt.throwOnFailure(obj);
        searchPageViewModel.showCurrentHitNextPageBinding(false);
        searchPageViewModel.getPageIdToShow().setValue(!searchPageViewModel.hits.isEmpty() ? ((SearchMatch) searchPageViewModel.hits.get(searchPageViewModel.selectedHitIndex)).getPageUUID() : null);
        return Unit.INSTANCE;
    }
}
