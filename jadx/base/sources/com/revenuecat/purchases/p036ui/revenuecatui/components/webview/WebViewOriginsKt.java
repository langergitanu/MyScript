package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.net.Uri;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.common.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WebViewOrigins.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u0007H\u0000\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0003*\u00020\u0003H\u0000¨\u0006\b"}, m1599d2 = {"shouldBlockWebViewNavigation", "", ImagesContract.URL, "", "isMainFrame", "expectedOrigin", "toOriginOrNull", "Landroid/net/Uri;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class WebViewOriginsKt {
    public static final String toOriginOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Uri uri = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(uri, "uri");
        return toOriginOrNull(uri);
    }

    public static final String toOriginOrNull(Uri uri) {
        String host;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String scheme = uri.getScheme();
        if (scheme != null) {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = scheme.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null && (host = uri.getHost()) != null) {
                if (StringsKt.isBlank(host)) {
                    host = null;
                }
                if (host != null) {
                    Locale US2 = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US2, "US");
                    String lowerCase2 = host.toLowerCase(US2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (lowerCase2 != null) {
                        String str = "";
                        if (uri.getPort() != -1 && ((!Intrinsics.areEqual(lowerCase, ProxyConfig.MATCH_HTTPS) || uri.getPort() != 443) && (!Intrinsics.areEqual(lowerCase, "http") || uri.getPort() != 80))) {
                            str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + uri.getPort();
                        }
                        return lowerCase + "://" + lowerCase2 + str;
                    }
                }
            }
        }
        return null;
    }

    public static final boolean shouldBlockWebViewNavigation(String str, boolean z, String str2) {
        String originOrNull;
        if (str == null || (originOrNull = toOriginOrNull(str)) == null) {
            return true;
        }
        if (StringsKt.startsWith$default(originOrNull, "https://", false, 2, (Object) null)) {
            return z && !Intrinsics.areEqual(originOrNull, str2 != null ? toOriginOrNull(str2) : null);
        }
        return true;
    }
}
