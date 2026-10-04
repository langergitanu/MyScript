package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewGestureOwnershipProbe.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a9\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\tH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0005*\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"GESTURE_PROBE_OBJECT_NAME", "", "GESTURE_PROBE_SCRIPT", "VERDICT_OWN", "installGestureOwnershipProbe", "", "Landroid/webkit/WebView;", "expectedOrigin", "onVerdict", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "wantsGesture", "removeGestureOwnershipProbe", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class WebViewGestureOwnershipProbeKt {
    private static final String GESTURE_PROBE_OBJECT_NAME = "rcPaywallGestureProbe";
    private static final String GESTURE_PROBE_SCRIPT = "(function () {\n  var name = 'rcPaywallGestureProbe';\n  var ELEMENT_NODE = Node.ELEMENT_NODE;\n  function isRootScroller(n) {\n    return n === document.scrollingElement || n === document.documentElement || n === document.body;\n  }\n  function consumesGesture(el) {\n    var node = el && el.nodeType === ELEMENT_NODE ? el : (el ? el.parentElement : null);\n    for (var n = node; n && n.nodeType === ELEMENT_NODE; n = n.parentElement) {\n      var s = getComputedStyle(n);\n      // Only `none` means the browser won't pan this element at all (JS owns every axis). `pan-x`/\n      // `pan-y` still let native scroll handle an axis, already covered by canScroll*.\n      if (s.touchAction === 'none') return true;\n      // The root scroller is the WebView's own scroll, already tracked by canScroll* with correct\n      // edge handoff; only inner scrollers are invisible to it.\n      if (isRootScroller(n)) continue;\n      if ((s.overflowY === 'auto' || s.overflowY === 'scroll') && n.scrollHeight > n.clientHeight) return true;\n      if ((s.overflowX === 'auto' || s.overflowX === 'scroll') && n.scrollWidth > n.clientWidth) return true;\n    }\n    return false;\n  }\n  document.addEventListener('touchstart', function (event) {\n    // Only the first finger of a sequence: the recognizer tracks one gesture, so a second finger's\n    // verdict must not overwrite it.\n    if (event.touches.length > 1) return;\n    try {\n      window[name].postMessage(consumesGesture(event.target) ? 'own' : 'release');\n    } catch (e) {}\n  }, { passive: true, capture: true });\n})();";
    private static final String VERDICT_OWN = "own";

    public static final void installGestureOwnershipProbe(WebView webView, String str, final Function1<? super Boolean, Unit> onVerdict) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(onVerdict, "onVerdict");
        if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER") && WebViewFeature.isFeatureSupported(WebViewFeature.DOCUMENT_START_SCRIPT) && str != null) {
            Set of = SetsKt.setOf(str);
            try {
                WebViewCompat.addWebMessageListener(webView, GESTURE_PROBE_OBJECT_NAME, of, new WebViewCompat.WebMessageListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewGestureOwnershipProbeKt$$ExternalSyntheticLambda0
                    @Override // androidx.webkit.WebViewCompat.WebMessageListener
                    public final void onPostMessage(WebView webView2, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
                        WebViewGestureOwnershipProbeKt.installGestureOwnershipProbe$lambda$0(onVerdict, webView2, webMessageCompat, uri, z, javaScriptReplyProxy);
                    }
                });
                WebViewCompat.addDocumentStartJavaScript(webView, GESTURE_PROBE_SCRIPT, of);
            } catch (RuntimeException e) {
                Logger.INSTANCE.m1587w("Paywalls V2 web_view could not install the gesture-ownership probe; drag arbitration will use native scrollability only. " + e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installGestureOwnershipProbe$lambda$0(Function1 function1, WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        if (z) {
            function1.invoke(Boolean.valueOf(Intrinsics.areEqual(webMessageCompat.getData(), VERDICT_OWN)));
        }
    }

    public static final void removeGestureOwnershipProbe(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
            try {
                WebViewCompat.removeWebMessageListener(webView, GESTURE_PROBE_OBJECT_NAME);
            } catch (RuntimeException e) {
                Logger.INSTANCE.m1583d("Paywalls V2 web_view gesture probe listener already removed. " + e);
            }
        }
    }
}
