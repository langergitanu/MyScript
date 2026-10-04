package com.myscript.nebo.editing;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChildPagesFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ChildPagesFragment$onCreateView$onChildPageActionsRequest$1 extends FunctionReferenceImpl implements Function1<ChildPage, List<? extends ChildPageAction>> {
    ChildPagesFragment$onCreateView$onChildPageActionsRequest$1(Object obj) {
        super(1, obj, ChildPagesViewModel.class, "getPageActions", "getPageActions(Lcom/myscript/nebo/editing/ChildPage;)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<ChildPageAction> invoke(ChildPage p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((ChildPagesViewModel) this.receiver).getPageActions(p0);
    }
}
