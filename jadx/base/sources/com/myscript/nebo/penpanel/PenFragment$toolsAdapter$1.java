package com.myscript.nebo.penpanel;

import com.myscript.snt.core.ToolConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PenFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class PenFragment$toolsAdapter$1 extends FunctionReferenceImpl implements Function2<ToolConfiguration, ToolPillView, Unit> {
    PenFragment$toolsAdapter$1(Object obj) {
        super(2, obj, PenFragment.class, "onToolClicked", "onToolClicked(Lcom/myscript/snt/core/ToolConfiguration;Lcom/myscript/nebo/penpanel/ToolPillView;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ToolConfiguration toolConfiguration, ToolPillView toolPillView) {
        invoke2(toolConfiguration, toolPillView);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ToolConfiguration p0, ToolPillView p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((PenFragment) this.receiver).onToolClicked(p0, p1);
    }
}
