package com.myscript.nebo.editing;

import com.myscript.nebo.dms.core.PdfOptimizationLevel;
import com.myscript.nebo.dms.core.PdfOptimizationResult;
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

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/nebo/dms/core/PdfOptimizationResult;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$optimizePdf$1$result$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class PageViewModel$optimizePdf$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfOptimizationResult>, Object> {
    final /* synthetic */ PdfOptimizationLevel $level;
    final /* synthetic */ PageKey $pageKey;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageViewModel$optimizePdf$1$result$1(PageViewModel pageViewModel, PageKey pageKey, PdfOptimizationLevel pdfOptimizationLevel, Continuation<? super PageViewModel$optimizePdf$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$pageKey = pageKey;
        this.$level = pdfOptimizationLevel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$optimizePdf$1$result$1(this.this$0, this.$pageKey, this.$level, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfOptimizationResult> continuation) {
        return ((PageViewModel$optimizePdf$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.repository.optimizePdf(this.$pageKey, this.$level);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
