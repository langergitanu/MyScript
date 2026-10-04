package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: PaywallWebView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class PaywallWebView$canScrollHorizontallyReference$1 extends FunctionReferenceImpl implements Function1<Integer, Boolean> {
    PaywallWebView$canScrollHorizontallyReference$1(Object obj) {
        super(1, obj, PaywallWebView.class, "canScrollHorizontally", "canScrollHorizontally(I)Z", 0);
    }

    public final Boolean invoke(int i) {
        return Boolean.valueOf(((PaywallWebView) this.receiver).canScrollHorizontally(i));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return invoke(num.intValue());
    }
}
