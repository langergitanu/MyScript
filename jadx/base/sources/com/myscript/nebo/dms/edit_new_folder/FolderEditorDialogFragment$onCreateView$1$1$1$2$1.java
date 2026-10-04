package com.myscript.nebo.dms.edit_new_folder;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderEditorDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class FolderEditorDialogFragment$onCreateView$1$1$1$2$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    FolderEditorDialogFragment$onCreateView$1$1$1$2$1(Object obj) {
        super(1, obj, FolderEditorViewModel.class, "setFolderName", "setFolderName(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((FolderEditorViewModel) this.receiver).setFolderName(p0);
    }
}
