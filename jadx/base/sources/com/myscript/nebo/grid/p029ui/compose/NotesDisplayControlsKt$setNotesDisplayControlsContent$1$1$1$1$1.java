package com.myscript.nebo.grid.p029ui.compose;

import com.myscript.nebo.grid.GridViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: notesDisplayControls.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1(Object obj) {
        super(0, obj, GridViewModel.class, "toggleSortMenu", "toggleSortMenu()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((GridViewModel) this.receiver).toggleSortMenu();
    }
}
