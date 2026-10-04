package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.net.Uri;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WebViewUrlResolver.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewUrlResolver;", "", "()V", "HTTPS_SCHEME", "", "resolve", ImagesContract.URL, "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WebViewUrlResolver {
    public static final int $stable = 0;
    private static final String HTTPS_SCHEME = "https";
    public static final WebViewUrlResolver INSTANCE = new WebViewUrlResolver();

    private WebViewUrlResolver() {
    }

    public final String resolve(String url) {
        String host;
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "{{", false, 2, (Object) null)) {
            return null;
        }
        Uri uri = Uri.parse(url);
        if (!StringsKt.equals(uri.getScheme(), "https", true) || (host = uri.getHost()) == null || StringsKt.isBlank(host)) {
            return null;
        }
        return url;
    }
}
