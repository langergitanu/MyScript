package com.revenuecat.purchases.paywalls;

import android.content.Context;
import android.net.Uri;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: PaywallAssetWarmer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tH&¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/PaywallAssetWarmer;", "", "clearWebViewStorage", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "prebootWebView", "warmImages", "imageUris", "", "Landroid/net/Uri;", "warmWebViewUrls", "urls", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PaywallAssetWarmer {
    void clearWebViewStorage(Context context);

    void prebootWebView(Context context);

    void warmImages(Context context, List<? extends Uri> imageUris);

    void warmWebViewUrls(Context context, List<String> urls);
}
