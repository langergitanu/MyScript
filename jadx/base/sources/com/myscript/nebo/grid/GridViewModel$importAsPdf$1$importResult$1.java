package com.myscript.nebo.grid;

import android.net.Uri;
import com.myscript.nebo.dms.util.ImportController;
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
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/dms/util/ImportController$ImportResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$importAsPdf$1$importResult$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class GridViewModel$importAsPdf$1$importResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImportController.ImportResult>, Object> {
    final /* synthetic */ Uri $requestedUri;
    int label;
    final /* synthetic */ GridViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GridViewModel$importAsPdf$1$importResult$1(GridViewModel gridViewModel, Uri uri, Continuation<? super GridViewModel$importAsPdf$1$importResult$1> continuation) {
        super(2, continuation);
        this.this$0 = gridViewModel;
        this.$requestedUri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GridViewModel$importAsPdf$1$importResult$1(this.this$0, this.$requestedUri, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ImportController.ImportResult> continuation) {
        return ((GridViewModel$importAsPdf$1$importResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IPdfImporter iPdfImporter = this.this$0.pdfImporter;
            if (iPdfImporter != null) {
                return iPdfImporter.importPdf(this.$requestedUri);
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
