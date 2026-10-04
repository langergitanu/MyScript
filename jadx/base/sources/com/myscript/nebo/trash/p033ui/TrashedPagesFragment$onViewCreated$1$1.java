package com.myscript.nebo.trash.p033ui;

import com.myscript.nebo.trash.TrashedPagesUIState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TrashedPagesFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class TrashedPagesFragment$onViewCreated$1$1 extends FunctionReferenceImpl implements Function1<TrashedPagesUIState, Unit> {
    TrashedPagesFragment$onViewCreated$1$1(Object obj) {
        super(1, obj, TrashedPagesFragment.class, "trashedPagesStateChanged", "trashedPagesStateChanged(Lcom/myscript/nebo/trash/TrashedPagesUIState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TrashedPagesUIState trashedPagesUIState) {
        invoke2(trashedPagesUIState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TrashedPagesUIState p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((TrashedPagesFragment) this.receiver).trashedPagesStateChanged(p0);
    }
}
