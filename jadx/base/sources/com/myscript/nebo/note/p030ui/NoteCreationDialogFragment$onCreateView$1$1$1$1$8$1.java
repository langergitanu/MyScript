package com.myscript.nebo.note.p030ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: NoteCreationDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class NoteCreationDialogFragment$onCreateView$1$1$1$1$8$1 extends FunctionReferenceImpl implements Function0<Unit> {
    NoteCreationDialogFragment$onCreateView$1$1$1$1$8$1(Object obj) {
        super(0, obj, NoteCreationDialogFragment.class, "openLanguageManager", "openLanguageManager()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((NoteCreationDialogFragment) this.receiver).openLanguageManager();
    }
}
