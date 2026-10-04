package com.myscript.nebo.grid.p029ui.compose;

import com.myscript.nebo.grid.GridViewModel;
import com.myscript.nebo.grid.Order;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: notesDisplayControls.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1 extends FunctionReferenceImpl implements Function1<Order, Unit> {
    NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1(Object obj) {
        super(1, obj, GridViewModel.class, "setSortingOrder", "setSortingOrder(Lcom/myscript/nebo/grid/Order;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Order order) {
        invoke2(order);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Order p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((GridViewModel) this.receiver).setSortingOrder(p0);
    }
}
