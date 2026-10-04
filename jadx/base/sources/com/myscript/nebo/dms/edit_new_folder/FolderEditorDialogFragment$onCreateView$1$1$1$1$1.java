package com.myscript.nebo.dms.edit_new_folder;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class FolderEditorDialogFragment$onCreateView$1$1$1$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    FolderEditorDialogFragment$onCreateView$1$1$1$1$1(Object obj) {
        super(1, obj, FolderEditorViewModel.class, "setFolderColor", "setFolderColor(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((FolderEditorViewModel) this.receiver).setFolderColor(i);
    }
}
