package com.myscript.nebo.editing;

import com.myscript.atk.core.Point;
import com.myscript.atk.p021ui.ActionMenuCallback;
import com.myscript.atk.p021ui.ActionMenuEntry;
import com.myscript.nebo.editing.PageViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: PageViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "com.myscript.nebo.editing.PageViewModel$onActionMenuUpdate$1$1", m1609f = "PageViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
final class PageViewModel$onActionMenuUpdate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActionMenuEntry[] $actions;
    final /* synthetic */ ActionMenuCallback $callback;
    final /* synthetic */ Point $inputPoint;
    final /* synthetic */ Point $menuPoint;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageViewModel$onActionMenuUpdate$1$1(ActionMenuEntry[] actionMenuEntryArr, PageViewModel pageViewModel, Point point, Point point2, ActionMenuCallback actionMenuCallback, Continuation<? super PageViewModel$onActionMenuUpdate$1$1> continuation) {
        super(2, continuation);
        this.$actions = actionMenuEntryArr;
        this.this$0 = pageViewModel;
        this.$inputPoint = point;
        this.$menuPoint = point2;
        this.$callback = actionMenuCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$onActionMenuUpdate$1$1(this.$actions, this.this$0, this.$inputPoint, this.$menuPoint, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PageViewModel$onActionMenuUpdate$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ActionMenuEntry[] actionMenuEntryArr = this.$actions;
        if (actionMenuEntryArr == null || actionMenuEntryArr.length == 0) {
            this.this$0._actionMenuState.setValue(PageViewModel.ActionMenuState.Closed.INSTANCE);
        } else {
            this.this$0._actionMenuState.setValue(new PageViewModel.ActionMenuState.Opened(ArraysKt.asList(this.$actions), this.$inputPoint, this.$menuPoint, this.$callback));
        }
        return Unit.INSTANCE;
    }
}
