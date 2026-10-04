package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/ConfiguredPaywallWebView;", "", "webView", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;", "bridge", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewJavaScriptBridge;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewJavaScriptBridge;)V", "getBridge", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewJavaScriptBridge;", "getWebView", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ConfiguredPaywallWebView {
    public static final int $stable = 8;
    private final WebViewJavaScriptBridge bridge;
    private final PaywallWebView webView;

    public ConfiguredPaywallWebView(PaywallWebView webView, WebViewJavaScriptBridge bridge) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        this.webView = webView;
        this.bridge = bridge;
    }

    public final PaywallWebView getWebView() {
        return this.webView;
    }

    public final WebViewJavaScriptBridge getBridge() {
        return this.bridge;
    }
}
