package com.myscript.nebo.editing;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChildPagesFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ChildPagesFragment$onCreateView$onDuplicatePage$1 extends FunctionReferenceImpl implements Function1<ChildPage, Unit> {
    ChildPagesFragment$onCreateView$onDuplicatePage$1(Object obj) {
        super(1, obj, ChildPagesViewModel.class, "duplicatePage", "duplicatePage(Lcom/myscript/nebo/editing/ChildPage;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChildPage childPage) {
        invoke2(childPage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChildPage p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((ChildPagesViewModel) this.receiver).duplicatePage(p0);
    }
}
