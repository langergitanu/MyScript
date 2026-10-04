package com.myscript.nebo.grid;

import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/core/PageKey;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$importAsPdf$1$pageKey$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class GridViewModel$importAsPdf$1$pageKey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PageKey>, Object> {
    final /* synthetic */ String $lang;
    final /* synthetic */ File $pdfFile;
    final /* synthetic */ NotebookKey $targetNotebookKey;
    int label;
    final /* synthetic */ GridViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GridViewModel$importAsPdf$1$pageKey$1(GridViewModel gridViewModel, NotebookKey notebookKey, File file, String str, Continuation<? super GridViewModel$importAsPdf$1$pageKey$1> continuation) {
        super(2, continuation);
        this.this$0 = gridViewModel;
        this.$targetNotebookKey = notebookKey;
        this.$pdfFile = file;
        this.$lang = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GridViewModel$importAsPdf$1$pageKey$1(this.this$0, this.$targetNotebookKey, this.$pdfFile, this.$lang, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PageKey> continuation) {
        return ((GridViewModel$importAsPdf$1$pageKey$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PageKey pageKeyImportAsPdf = this.this$0.pageRepository.importAsPdf(this.$targetNotebookKey, this.$pdfFile, this.$lang);
            if (pageKeyImportAsPdf != null) {
                return pageKeyImportAsPdf;
            }
            throw new IllegalStateException("Error while importing PDF".toString());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
