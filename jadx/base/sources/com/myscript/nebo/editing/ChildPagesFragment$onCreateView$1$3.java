package com.myscript.nebo.editing;

import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: ChildPagesFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class ChildPagesFragment$onCreateView$1$3 extends FunctionReferenceImpl implements Function1<TooltipUIState, Unit> {
    ChildPagesFragment$onCreateView$1$3(Object obj) {
        super(1, obj, ChildPagesFragment.class, "updateTooltip", "updateTooltip(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TooltipUIState tooltipUIState) {
        invoke2(tooltipUIState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TooltipUIState tooltipUIState) {
        ((ChildPagesFragment) this.receiver).updateTooltip(tooltipUIState);
    }
}
