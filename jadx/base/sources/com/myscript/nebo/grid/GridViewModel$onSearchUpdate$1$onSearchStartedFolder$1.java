package com.myscript.nebo.grid;

import com.myscript.nebo.dms.search.DMSSearchController;
import com.myscript.nebo.grid.SearchGridState;
import com.myscript.nebo.grid.SearchState;
import com.myscript.snt.core.NotebookKey;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$onSearchUpdate$1$onSearchStartedFolder$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class GridViewModel$onSearchUpdate$1$onSearchStartedFolder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotebookKey $notebookKey;
    int label;
    final /* synthetic */ GridViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GridViewModel$onSearchUpdate$1$onSearchStartedFolder$1(GridViewModel gridViewModel, NotebookKey notebookKey, Continuation<? super GridViewModel$onSearchUpdate$1$onSearchStartedFolder$1> continuation) {
        super(2, continuation);
        this.this$0 = gridViewModel;
        this.$notebookKey = notebookKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GridViewModel$onSearchUpdate$1$onSearchStartedFolder$1(this.this$0, this.$notebookKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GridViewModel$onSearchUpdate$1$onSearchStartedFolder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0._searchGridState.setValue(new SearchGridState.SearchGridStartedDocument(this.$notebookKey));
            this.this$0.folderState = FolderState.Updating;
            DMSSearchController.SearchType searchType = DMSSearchController.SearchType.GRID;
            DMSSearchController dMSSearchController = this.this$0.searchController;
            if (searchType == (dMSSearchController != null ? dMSSearchController.getSearchType() : null)) {
                NotebookKey notebookKey = this.$notebookKey;
                FolderUIState folderUIState = (FolderUIState) this.this$0._folderUIState.getValue();
                if (Intrinsics.areEqual(notebookKey, folderUIState != null ? folderUIState.getNotebookKey() : null)) {
                    this.this$0._searchState.setValue(new SearchState.Searching(null, 1, null));
                    this.this$0._folderUIState.setValue(this.this$0.computeFolderUIState());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
