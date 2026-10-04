package com.myscript.nebo.editing;

import com.myscript.snt.dms.IPaginatedContainer;
import com.myscript.snt.dms.NotebookManager;
import com.myscript.snt.dms.PDFManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesViewModel$childPageListener$1$pagesUpdated$1$childPageList$1 */
/* JADX INFO: compiled from: ChildPagesViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, m1599d2 = {"<anonymous>", "", "Lcom/myscript/nebo/editing/ChildPage;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.ChildPagesViewModel$childPageListener$1$pagesUpdated$1$childPageList$1", m1609f = "ChildPagesViewModel.kt", m1610i = {0}, m1611l = {368}, m1612m = "invokeSuspend", m1613n = {"selectedPageId"}, m1614nl = {-1}, m1615s = {"L$0"}, m1616v = 2)
final class C6319x2562d676 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ChildPage>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ChildPagesViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C6319x2562d676(ChildPagesViewModel childPagesViewModel, Continuation<? super C6319x2562d676> continuation) {
        super(2, continuation);
        this.this$0 = childPagesViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C6319x2562d676(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ChildPage>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<ChildPage>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ChildPage>> continuation) {
        return ((C6319x2562d676) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AutoCloseable autoCloseableNewRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        IPaginatedContainer paginatedContainer = this.this$0.getPaginatedContainer();
        String str = null;
        if (paginatedContainer != null) {
            if (paginatedContainer instanceof NotebookManager) {
                autoCloseableNewRef = NotebookManager.newRef((NotebookManager) paginatedContainer);
            } else {
                if (!(paginatedContainer instanceof PDFManager)) {
                    throw new IllegalStateException("Unsupported IPaginatedContainer type".toString());
                }
                autoCloseableNewRef = PDFManager.newRef((PDFManager) paginatedContainer);
            }
            if (autoCloseableNewRef != null) {
                AutoCloseable autoCloseable = autoCloseableNewRef;
                try {
                    String strSelectedPage = ((IPaginatedContainer) autoCloseable).selectedPage();
                    AutoCloseableKt.closeFinally(autoCloseable, null);
                    str = strSelectedPage;
                } finally {
                }
            }
        }
        this.L$0 = SpillingKt.nullOutSpilledVariable(str);
        this.label = 1;
        Object objComputeChildPages$default = ChildPagesViewModel.computeChildPages$default(this.this$0, str, null, this, 2, null);
        return objComputeChildPages$default == coroutine_suspended ? coroutine_suspended : objComputeChildPages$default;
    }
}
