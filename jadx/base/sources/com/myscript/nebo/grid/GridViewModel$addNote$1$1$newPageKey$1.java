package com.myscript.nebo.grid;

import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: GridViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "Lcom/myscript/snt/core/PageKey;", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.grid.GridViewModel$addNote$1$1$newPageKey$1", m1609f = "GridViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class GridViewModel$addNote$1$1$newPageKey$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PageKey>, Object> {
    final /* synthetic */ NotebookKey $it;
    final /* synthetic */ Function1<NotebookKey, PageKey> $logic;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    GridViewModel$addNote$1$1$newPageKey$1(Function1<? super NotebookKey, ? extends PageKey> function1, NotebookKey notebookKey, Continuation<? super GridViewModel$addNote$1$1$newPageKey$1> continuation) {
        super(2, continuation);
        this.$logic = function1;
        this.$it = notebookKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GridViewModel$addNote$1$1$newPageKey$1(this.$logic, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PageKey> continuation) {
        return ((GridViewModel$addNote$1$1$newPageKey$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$logic.invoke(this.$it);
    }
}
