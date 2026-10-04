package com.myscript.nebo.editing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManagePagesDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ManagePagesDialog$onCreateView$1$1$1$1$3$1 extends FunctionReferenceImpl implements Function1<ChildPage, Unit> {
    ManagePagesDialog$onCreateView$1$1$1$1$3$1(Object obj) {
        super(1, obj, ChildPagesViewModel.class, "requestThumbnail", "requestThumbnail(Lcom/myscript/nebo/editing/ChildPage;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChildPage childPage) {
        invoke2(childPage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChildPage p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((ChildPagesViewModel) this.receiver).requestThumbnail(p0);
    }
}
