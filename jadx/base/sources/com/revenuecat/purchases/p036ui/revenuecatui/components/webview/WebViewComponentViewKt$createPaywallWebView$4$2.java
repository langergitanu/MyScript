package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: WebViewComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class WebViewComponentViewKt$createPaywallWebView$4$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    WebViewComponentViewKt$createPaywallWebView$4$2(Object obj) {
        super(1, obj, PaywallWebView.class, "onContentGestureVerdict", "onContentGestureVerdict(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ((PaywallWebView) this.receiver).onContentGestureVerdict(z);
    }
}
