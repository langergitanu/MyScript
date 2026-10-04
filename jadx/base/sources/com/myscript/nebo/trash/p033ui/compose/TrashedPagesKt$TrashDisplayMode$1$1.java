package com.myscript.nebo.trash.p033ui.compose;

import com.myscript.nebo.trash.TrashViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: trashedPages.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class TrashedPagesKt$TrashDisplayMode$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    TrashedPagesKt$TrashDisplayMode$1$1(Object obj) {
        super(0, obj, TrashViewModel.class, "toggleTrashDisplayMode", "toggleTrashDisplayMode()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((TrashViewModel) this.receiver).toggleTrashDisplayMode();
    }
}
