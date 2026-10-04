package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallWebViewClient.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0017J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebViewClient;", "Landroid/webkit/WebViewClient;", "expectedOrigin", "", "onMainFrameNavigationStarted", "Lkotlin/Function0;", "", "onMainFrameLoadFailed", "onMainFrameLoadFinished", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "failed", "", "finished", "markFailed", "reason", "onPageFinished", "view", "Landroid/webkit/WebView;", ImagesContract.URL, "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "shouldOverrideUrlLoading", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallWebViewClient extends WebViewClient {
    public static final int $stable = 8;
    private final String expectedOrigin;
    private volatile boolean failed;
    private volatile boolean finished;
    private final Function0<Unit> onMainFrameLoadFailed;
    private final Function0<Unit> onMainFrameLoadFinished;
    private final Function0<Unit> onMainFrameNavigationStarted;

    public PaywallWebViewClient(String str, Function0<Unit> onMainFrameNavigationStarted, Function0<Unit> onMainFrameLoadFailed, Function0<Unit> onMainFrameLoadFinished) {
        Intrinsics.checkNotNullParameter(onMainFrameNavigationStarted, "onMainFrameNavigationStarted");
        Intrinsics.checkNotNullParameter(onMainFrameLoadFailed, "onMainFrameLoadFailed");
        Intrinsics.checkNotNullParameter(onMainFrameLoadFinished, "onMainFrameLoadFinished");
        this.expectedOrigin = str;
        this.onMainFrameNavigationStarted = onMainFrameNavigationStarted;
        this.onMainFrameLoadFailed = onMainFrameLoadFailed;
        this.onMainFrameLoadFinished = onMainFrameLoadFinished;
    }

    private final void markFailed(String reason) {
        if (this.failed) {
            return;
        }
        this.failed = true;
        Logger.INSTANCE.m1587w("Paywalls V2 web_view load failed terminally, removing the component: " + reason);
        this.onMainFrameLoadFailed.invoke();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onPageStarted(view, url, favicon);
        if (this.failed) {
            return;
        }
        if ((url != null ? WebViewOriginsKt.toOriginOrNull(url) : null) == null) {
            return;
        }
        if (WebViewOriginsKt.shouldBlockWebViewNavigation(url, true, this.expectedOrigin)) {
            view.stopLoading();
            markFailed("blocked main-frame navigation to '" + url + "' (expectedOrigin=" + this.expectedOrigin + ')');
        } else {
            this.onMainFrameNavigationStarted.invoke();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onPageFinished(view, url);
        if (this.failed || this.finished) {
            return;
        }
        if ((url != null ? WebViewOriginsKt.toOriginOrNull(url) : null) == null) {
            return;
        }
        this.finished = true;
        this.onMainFrameLoadFinished.invoke();
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Uri url = request.getUrl();
        return WebViewOriginsKt.shouldBlockWebViewNavigation(url != null ? url.toString() : null, request.isForMainFrame(), this.expectedOrigin);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        if (request.isForMainFrame()) {
            markFailed("resource error code=" + error.getErrorCode() + " '" + ((Object) error.getDescription()) + '\'');
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(error, "error");
        handler.cancel();
        markFailed("SSL error: " + error);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        if (request.isForMainFrame()) {
            markFailed("HTTP error status=" + errorResponse.getStatusCode());
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        markFailed("render process gone (didCrash=" + detail.didCrash() + ')');
        return true;
    }
}
