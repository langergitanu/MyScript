package com.revenuecat.purchases.p036ui.revenuecatui;

import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: InternalPaywall.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class InternalPaywallKt$InternalPaywall$6$2$1$1$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    InternalPaywallKt$InternalPaywall$6$2$1$1$1(Object obj) {
        super(1, obj, PaywallViewModel.class, "onTransitionComplete", "onTransitionComplete(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((PaywallViewModel) this.receiver).onTransitionComplete(i);
    }
}
