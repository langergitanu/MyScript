package com.revenuecat.purchases.p036ui.revenuecatui.paywalls;

import android.content.Context;
import android.net.Uri;
import coil.ImageLoader;
import coil.request.ImageRequest;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.PaywallWebViewPrewarmer;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.PaywallWebViewStartUp;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.paywalls.PaywallAssetWarmer;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallAssetWarmerImpl.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nH\u0016¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/paywalls/PaywallAssetWarmerImpl;", "Lcom/revenuecat/purchases/paywalls/PaywallAssetWarmer;", "()V", "clearWebViewStorage", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "prebootWebView", "warmImages", "imageUris", "", "Landroid/net/Uri;", "warmWebViewUrls", "urls", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallAssetWarmerImpl implements PaywallAssetWarmer {
    public static final int $stable = 0;

    @Override // com.revenuecat.purchases.paywalls.PaywallAssetWarmer
    public void warmImages(Context context, List<? extends Uri> imageUris) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUris, "imageUris");
        ImageLoader imageLoader = PaywallImageLoader.INSTANCE.get(context);
        Iterator<T> it = imageUris.iterator();
        while (it.hasNext()) {
            imageLoader.enqueue(new ImageRequest.Builder(context).data((Uri) it.next()).build());
        }
    }

    @Override // com.revenuecat.purchases.paywalls.PaywallAssetWarmer
    public void prebootWebView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PaywallWebViewStartUp.startUp$default(PaywallWebViewStartUp.INSTANCE, context, null, 2, null);
    }

    @Override // com.revenuecat.purchases.paywalls.PaywallAssetWarmer
    public void warmWebViewUrls(Context context, List<String> urls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(urls, "urls");
        Iterator<T> it = urls.iterator();
        while (it.hasNext()) {
            PaywallWebViewPrewarmer.INSTANCE.getShared().prewarm(context, (String) it.next());
        }
    }

    @Override // com.revenuecat.purchases.paywalls.PaywallAssetWarmer
    public void clearWebViewStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WebViewComponentViewKt.clearPaywallProfileStorage();
    }
}
