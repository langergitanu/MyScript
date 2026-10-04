package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: WebViewComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
/* synthetic */ class WebViewComponentViewKt$createPaywallWebView$4$1 extends FunctionReferenceImpl implements Function0<Unit> {
    WebViewComponentViewKt$createPaywallWebView$4$1(Object obj) {
        super(0, obj, WebViewJavaScriptBridge.class, "onMainFrameNavigationStarted", "onMainFrameNavigationStarted()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((WebViewJavaScriptBridge) this.receiver).onMainFrameNavigationStarted();
    }
}
