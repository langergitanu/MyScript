package com.myscript.nebo.penpanel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PenFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class PenFragment$colorDragHelper$2 extends FunctionReferenceImpl implements Function2<Integer, Integer, Unit> {
    PenFragment$colorDragHelper$2(Object obj) {
        super(2, obj, PenFragment.class, "onColorDropped", "onColorDropped(II)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        ((PenFragment) this.receiver).onColorDropped(i, i2);
    }
}
