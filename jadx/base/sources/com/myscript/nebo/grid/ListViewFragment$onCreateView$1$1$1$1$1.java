package com.myscript.nebo.grid;

import com.myscript.nebo.dms.core.model.PageModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListViewFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ListViewFragment$onCreateView$1$1$1$1$1 extends FunctionReferenceImpl implements Function1<PageModel, Unit> {
    ListViewFragment$onCreateView$1$1$1$1$1(Object obj) {
        super(1, obj, GridViewModel.class, "requestThumbnail", "requestThumbnail(Lcom/myscript/nebo/dms/core/model/PageModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PageModel pageModel) {
        invoke2(pageModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PageModel p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((GridViewModel) this.receiver).requestThumbnail(p0);
    }
}
