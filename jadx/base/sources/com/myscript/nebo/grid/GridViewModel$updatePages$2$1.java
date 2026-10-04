package com.myscript.nebo.grid;

import androidx.compose.runtime.composer.linkbuffer.GroupFlagsSpec;
import com.myscript.nebo.dms.core.PageManager;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.dms.DMSFilter;
import java.io.File;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$updatePages$2$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class GridViewModel$updatePages$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NotebookKey $notebookKey;
    int label;
    final /* synthetic */ GridViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GridViewModel$updatePages$2$1(GridViewModel gridViewModel, NotebookKey notebookKey, Continuation<? super GridViewModel$updatePages$2$1> continuation) {
        super(2, continuation);
        this.this$0 = gridViewModel;
        this.$notebookKey = notebookKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GridViewModel$updatePages$2$1(this.this$0, this.$notebookKey, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GridViewModel$updatePages$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        GridViewModel gridViewModel = this.this$0;
        gridViewModel.unbindPageListeners(gridViewModel.getPages());
        List<PageModel> pages = this.this$0.pageRepository.getPages(this.$notebookKey, DMSFilter.ACTIVE);
        this.this$0.bindPageListeners(pages);
        GridViewModel gridViewModel2 = this.this$0;
        List<PageModel> list = pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (PageModel pageModel : list) {
            File file = new File(gridViewModel2.pageRepository.getThumbnailPath(pageModel.getPageKey(), pageModel.getLastModificationDate()));
            if (!file.isFile()) {
                file = null;
            }
            arrayList.add(PageModel.copy$default(pageModel, null, null, false, false, false, false, 0L, 0, 0L, 0L, 0L, null, null, false, null, null, 0, 0, null, 0, false, false, null, file, GroupFlagsSpec.CHILD_NODE_COUNT_MASK, null));
        }
        gridViewModel2.pages = arrayList;
        GridViewModel gridViewModel3 = this.this$0;
        PageManager pageManager = gridViewModel3.pageRepository;
        List<PageModel> pages2 = this.this$0.getPages();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(pages2, 10));
        Iterator<T> it = pages2.iterator();
        while (it.hasNext()) {
            arrayList2.add(((PageModel) it.next()).getPageKey());
        }
        gridViewModel3.canExport = pageManager.canExport(arrayList2);
        return Unit.INSTANCE;
    }
}
