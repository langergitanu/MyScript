package com.myscript.nebo.penpanel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PenFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class PenFragment$colorsAdapter$1 extends FunctionReferenceImpl implements Function1<ColorPillViewHolder, Unit> {
    PenFragment$colorsAdapter$1(Object obj) {
        super(1, obj, PenFragment.class, "onColorClicked", "onColorClicked(Lcom/myscript/nebo/penpanel/ColorPillViewHolder;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ColorPillViewHolder colorPillViewHolder) {
        invoke2(colorPillViewHolder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ColorPillViewHolder p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((PenFragment) this.receiver).onColorClicked(p0);
    }
}
