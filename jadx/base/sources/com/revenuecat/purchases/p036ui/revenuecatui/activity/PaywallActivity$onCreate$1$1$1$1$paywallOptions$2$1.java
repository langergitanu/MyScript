package com.revenuecat.purchases.p036ui.revenuecatui.activity;

import com.revenuecat.purchases.Offering;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PaywallActivity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class PaywallActivity$onCreate$1$1$1$1$paywallOptions$2$1 extends FunctionReferenceImpl implements Function2<Offering, PaywallResult, Unit> {
    PaywallActivity$onCreate$1$1$1$1$paywallOptions$2$1(Object obj) {
        super(2, obj, PaywallActivity.class, "onDismissRequest", "onDismissRequest(Lcom/revenuecat/purchases/Offering;Lcom/revenuecat/purchases/ui/revenuecatui/activity/PaywallResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Offering offering, PaywallResult paywallResult) {
        invoke2(offering, paywallResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Offering offering, PaywallResult paywallResult) {
        ((PaywallActivity) this.receiver).onDismissRequest(offering, paywallResult);
    }
}
