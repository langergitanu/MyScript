package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewEnvelope;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: WebViewJavaScriptBridge.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 D2\u00020\u0001:\u0001DB\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012<\b\u0002\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013¢\u0006\u0002\u0010\u0017J#\u0010+\u001a\u0004\u0018\u00010\f2\b\u0010,\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020\u0011H\u0007J\u0018\u00100\u001a\u00020\b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\bH\u0003J\u0010\u00104\u001a\u00020\u00112\u0006\u00101\u001a\u000202H\u0003J\u0010\u00105\u001a\u00020\u00112\u0006\u00101\u001a\u000202H\u0003J\"\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\bH\u0003J\u0010\u0010;\u001a\u00020\u00112\u0006\u00101\u001a\u000202H\u0003J\u0018\u0010<\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00103\u001a\u00020\bH\u0003J\u001a\u0010=\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\bH\u0003J\b\u0010>\u001a\u00020\u001aH\u0002J\b\u0010?\u001a\u00020\u0011H\u0007J\b\u0010@\u001a\u00020\u0011H\u0007J\b\u0010A\u001a\u00020\u0011H\u0007J\b\u0010B\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020\u0011H\u0002R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u0012\u0010\u001e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u00020#8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00030\u00030)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewJavaScriptBridge;", "", "webView", "Landroid/webkit/WebView;", "componentId", "", "expectedUrl", "sizeToContentWidth", "", "sizeToContentHeight", "onContentResize", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "widthCssPx", "heightCssPx", "", "onDocumentReset", "Lkotlin/Function0;", "onSecureMessagingUnsupported", "contextSnapshotProvider", "Lkotlinx/serialization/json/JsonObject;", "(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;ZZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "channelOpen", "documentScope", "Lkotlinx/coroutines/CoroutineScope;", "expectedOrigin", "lastAppliedHeightCssPx", "Ljava/lang/Integer;", "lastAppliedWidthCssPx", "messageListenerInstalled", "protocolVersion", "released", "webMessageListener", "Landroidx/webkit/WebViewCompat$WebMessageListener;", "getWebMessageListener$revenuecatui_defaultsRelease$annotations", "()V", "getWebMessageListener$revenuecatui_defaultsRelease", "()Landroidx/webkit/WebViewCompat$WebMessageListener;", "webViewRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "applyResize", "reported", "lastApplied", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/Integer;", "attach", "deliverEnvelopeNow", "envelope", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewEnvelope;", "allowBeforeNavigation", "handleAppFrame", "handleConnect", "handleInboundMessage", "json", "sourceOrigin", "Landroid/net/Uri;", "isMainFrame", "handleResize", "isCurrentUrlTrusted", "isSourceTrusted", "newDocumentScope", "onMainFrameNavigationStarted", "pushContextNow", "release", "sendContext", "sendFitIfNeeded", "Companion", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WebViewJavaScriptBridge {
    private static final double MAX_RESIZE_CSS_PX = 10000.0d;
    private static final int RESIZE_APPLY_THRESHOLD_CSS_PX = 1;
    private boolean channelOpen;
    private final String componentId;
    private final Function0<JsonObject> contextSnapshotProvider;
    private CoroutineScope documentScope;
    private final String expectedOrigin;
    private Integer lastAppliedHeightCssPx;
    private Integer lastAppliedWidthCssPx;
    private boolean messageListenerInstalled;
    private final Function2<Integer, Integer, Unit> onContentResize;
    private final Function0<Unit> onDocumentReset;
    private final Function0<Unit> onSecureMessagingUnsupported;
    private final int protocolVersion;
    private boolean released;
    private final boolean sizeToContentHeight;
    private final boolean sizeToContentWidth;
    private final WebViewCompat.WebMessageListener webMessageListener;
    private final WeakReference<WebView> webViewRef;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: WebViewJavaScriptBridge.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WebViewEnvelope.Kind.values().length];
            try {
                iArr[WebViewEnvelope.Kind.CONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WebViewEnvelope.Kind.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WebViewEnvelope.Kind.REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getWebMessageListener$revenuecatui_defaultsRelease$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebViewJavaScriptBridge(WebView webView, String componentId, String expectedUrl, boolean z, boolean z2, Function2<? super Integer, ? super Integer, Unit> onContentResize, Function0<Unit> onDocumentReset, Function0<Unit> onSecureMessagingUnsupported, Function0<JsonObject> contextSnapshotProvider) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(expectedUrl, "expectedUrl");
        Intrinsics.checkNotNullParameter(onContentResize, "onContentResize");
        Intrinsics.checkNotNullParameter(onDocumentReset, "onDocumentReset");
        Intrinsics.checkNotNullParameter(onSecureMessagingUnsupported, "onSecureMessagingUnsupported");
        Intrinsics.checkNotNullParameter(contextSnapshotProvider, "contextSnapshotProvider");
        this.componentId = componentId;
        this.sizeToContentWidth = z;
        this.sizeToContentHeight = z2;
        this.onContentResize = onContentResize;
        this.onDocumentReset = onDocumentReset;
        this.onSecureMessagingUnsupported = onSecureMessagingUnsupported;
        this.contextSnapshotProvider = contextSnapshotProvider;
        this.webViewRef = new WeakReference<>(webView);
        this.expectedOrigin = WebViewOriginsKt.toOriginOrNull(expectedUrl);
        this.protocolVersion = 1;
        this.documentScope = newDocumentScope();
        this.webMessageListener = new WebViewCompat.WebMessageListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewJavaScriptBridge$$ExternalSyntheticLambda0
            @Override // androidx.webkit.WebViewCompat.WebMessageListener
            public final void onPostMessage(WebView webView2, WebMessageCompat webMessageCompat, Uri uri, boolean z3, JavaScriptReplyProxy javaScriptReplyProxy) {
                WebViewJavaScriptBridge.webMessageListener$lambda$0(this.f$0, webView2, webMessageCompat, uri, z3, javaScriptReplyProxy);
            }
        };
    }

    public /* synthetic */ WebViewJavaScriptBridge(WebView webView, String str, String str2, boolean z, boolean z2, C78651 c78651, C78662 c78662, C78673 c78673, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(webView, str, str2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? new Function2<Integer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewJavaScriptBridge.1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num, Integer num2) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke2(num, num2);
                return Unit.INSTANCE;
            }
        } : c78651, (i & 64) != 0 ? new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewJavaScriptBridge.2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : c78662, (i & 128) != 0 ? new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewJavaScriptBridge.3
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : c78673, function0);
    }

    private final CoroutineScope newDocumentScope() {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    }

    /* JADX INFO: renamed from: getWebMessageListener$revenuecatui_defaultsRelease, reason: from getter */
    public final WebViewCompat.WebMessageListener getWebMessageListener() {
        return this.webMessageListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void webMessageListener$lambda$0(WebViewJavaScriptBridge webViewJavaScriptBridge, WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z, JavaScriptReplyProxy javaScriptReplyProxy) {
        String data = webMessageCompat.getData();
        if (data == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(webViewJavaScriptBridge.documentScope, null, null, new WebViewJavaScriptBridge$webMessageListener$1$1(webViewJavaScriptBridge, data, uri, z, null), 3, null);
    }

    public final void attach() {
        WebView webView;
        if (this.messageListenerInstalled || (webView = this.webViewRef.get()) == null) {
            return;
        }
        String str = this.expectedOrigin;
        if (str == null) {
            Logger.INSTANCE.m1587w("Paywalls V2 web_view expected origin is not a valid origin; the bridge cannot verify message provenance and will reject all messages.");
            this.onSecureMessagingUnsupported.invoke();
        } else {
            if (!WebViewFeature.isFeatureSupported("WEB_MESSAGE_LISTENER")) {
                Logger.INSTANCE.m1583d("Paywalls V2 web_view secure messaging is unsupported on this System WebView (missing WEB_MESSAGE_LISTENER); falling back.");
                this.onSecureMessagingUnsupported.invoke();
                return;
            }
            try {
                WebViewCompat.addWebMessageListener(webView, WebViewEnvelope.NATIVE_OBJECT_NAME, SetsKt.setOf(str), this.webMessageListener);
                this.messageListenerInstalled = true;
            } catch (RuntimeException e) {
                Logger.INSTANCE.m1587w("Paywalls V2 web_view could not install the secure message listener; falling back. " + e);
                this.onSecureMessagingUnsupported.invoke();
            }
        }
    }

    public final void onMainFrameNavigationStarted() {
        if (this.released) {
            return;
        }
        CoroutineScopeKt.cancel$default(this.documentScope, null, 1, null);
        this.documentScope = newDocumentScope();
        this.channelOpen = false;
        this.lastAppliedWidthCssPx = null;
        this.lastAppliedHeightCssPx = null;
        this.onDocumentReset.invoke();
    }

    public final void release() {
        this.released = true;
        this.channelOpen = false;
        CoroutineScopeKt.cancel$default(this.documentScope, null, 1, null);
        WebView webView = this.webViewRef.get();
        if (!this.messageListenerInstalled || webView == null) {
            return;
        }
        WebViewCompat.removeWebMessageListener(webView, WebViewEnvelope.NATIVE_OBJECT_NAME);
        this.messageListenerInstalled = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleInboundMessage(String json, Uri sourceOrigin, boolean isMainFrame) {
        if (this.released) {
            return;
        }
        if (!isSourceTrusted(sourceOrigin, isMainFrame)) {
            Logger.INSTANCE.m1587w("Dropping inbound web view message: source origin is not the resolved component origin or the frame is not the main frame.");
            return;
        }
        WebViewEnvelope webViewEnvelope = WebViewEnvelope.INSTANCE.parse(json);
        if (webViewEnvelope == null) {
            Logger.INSTANCE.m1587w("Dropping inbound web view message: not a valid transport envelope.");
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[webViewEnvelope.getKind().ordinal()];
        if (i == 1) {
            handleConnect(webViewEnvelope);
        } else if (i == 2 || i == 3) {
            handleAppFrame(webViewEnvelope);
        } else {
            Logger.INSTANCE.m1587w("Dropping inbound web view message: unexpected envelope kind '" + webViewEnvelope.getKind() + "'.");
        }
    }

    private final void handleConnect(WebViewEnvelope envelope) {
        if (this.channelOpen || this.released) {
            return;
        }
        if (envelope.getProtocolVersion() != this.protocolVersion) {
            deliverEnvelopeNow(new WebViewEnvelope(null, this.protocolVersion, WebViewEnvelope.Kind.REJECT, "", (String) null, (String) null, (JsonObject) null, "Unsupported protocol_version " + envelope.getProtocolVersion() + "; native host supports " + this.protocolVersion, 113, (DefaultConstructorMarker) null), true);
            return;
        }
        WebViewEnvelope.Kind kind = WebViewEnvelope.Kind.INIT;
        int i = this.protocolVersion;
        String str = this.componentId;
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.put(WebViewMessageType.CONTEXT, this.contextSnapshotProvider.invoke());
        if (deliverEnvelopeNow(new WebViewEnvelope((String) null, i, kind, str, (String) null, (String) null, jsonObjectBuilder.build(), (String) null, 177, (DefaultConstructorMarker) null), true)) {
            this.channelOpen = true;
            Logger.INSTANCE.m1583d("Paywalls V2 web_view handshake complete, channel open (componentId='" + this.componentId + "').");
            sendFitIfNeeded();
        }
    }

    public final void pushContextNow() {
        if (this.released || !this.channelOpen) {
            return;
        }
        sendContext();
    }

    private final void sendContext() {
        String str = null;
        deliverEnvelopeNow(new WebViewEnvelope(str, this.protocolVersion, WebViewEnvelope.Kind.MESSAGE, this.componentId, WebViewMessageType.CONTEXT, (String) null, this.contextSnapshotProvider.invoke(), (String) null, PDFACompliance.e_PDFA1_6_1, (DefaultConstructorMarker) null), false);
    }

    private final void sendFitIfNeeded() {
        if (this.sizeToContentWidth || this.sizeToContentHeight) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            if (this.sizeToContentWidth) {
                JsonElementBuildersKt.put(jsonObjectBuilder, "width", (Boolean) true);
            }
            if (this.sizeToContentHeight) {
                JsonElementBuildersKt.put(jsonObjectBuilder, "height", (Boolean) true);
            }
            JsonObject jsonObjectBuild = jsonObjectBuilder.build();
            String str = null;
            deliverEnvelopeNow(new WebViewEnvelope(str, this.protocolVersion, WebViewEnvelope.Kind.MESSAGE, this.componentId, WebViewMessageType.FIT, (String) null, jsonObjectBuild, (String) null, PDFACompliance.e_PDFA1_6_1, (DefaultConstructorMarker) null), true);
        }
    }

    private final void handleAppFrame(WebViewEnvelope envelope) {
        if (!this.channelOpen) {
            Logger.INSTANCE.m1587w("Dropping inbound web view message: channel is not open.");
            return;
        }
        if (envelope.getKind() == WebViewEnvelope.Kind.REQUEST && envelope.getId() == null) {
            Logger.INSTANCE.m1587w("Dropping inbound web view message: request frame is missing an id.");
            return;
        }
        if (!Intrinsics.areEqual(envelope.getComponentId(), this.componentId)) {
            Logger.INSTANCE.m1587w("Dropping inbound web view message: component id does not match.");
        } else if (Intrinsics.areEqual(envelope.getType(), WebViewMessageType.RESIZE)) {
            handleResize(envelope);
        } else {
            Logger.INSTANCE.m1587w("Dropping inbound web view message: unsupported message type '" + envelope.getType() + "'.");
        }
    }

    private final void handleResize(WebViewEnvelope envelope) {
        JsonObject payload = envelope.getPayload();
        if (payload == null) {
            return;
        }
        Companion companion = Companion;
        Integer numResizeDimension = companion.resizeDimension(payload, "width");
        Integer num = null;
        if (!this.sizeToContentWidth) {
            numResizeDimension = null;
        }
        Integer numApplyResize = applyResize(numResizeDimension, this.lastAppliedWidthCssPx);
        if (numApplyResize != null) {
            this.lastAppliedWidthCssPx = Integer.valueOf(numApplyResize.intValue());
        } else {
            numApplyResize = null;
        }
        Integer numResizeDimension2 = companion.resizeDimension(payload, "height");
        if (!this.sizeToContentHeight) {
            numResizeDimension2 = null;
        }
        Integer numApplyResize2 = applyResize(numResizeDimension2, this.lastAppliedHeightCssPx);
        if (numApplyResize2 != null) {
            this.lastAppliedHeightCssPx = Integer.valueOf(numApplyResize2.intValue());
            num = numApplyResize2;
        }
        if (numApplyResize == null && num == null) {
            return;
        }
        this.onContentResize.invoke(numApplyResize, num);
    }

    private final Integer applyResize(Integer reported, Integer lastApplied) {
        if (reported == null) {
            return null;
        }
        if (lastApplied == null || Math.abs(reported.intValue() - lastApplied.intValue()) >= 1) {
            return reported;
        }
        return null;
    }

    private final boolean deliverEnvelopeNow(WebViewEnvelope envelope, boolean allowBeforeNavigation) {
        WebView webView = this.webViewRef.get();
        if (webView == null) {
            return false;
        }
        if (!isCurrentUrlTrusted(webView, allowBeforeNavigation)) {
            Logger.INSTANCE.m1587w("Dropping outbound web view message: current origin does not match the resolved component origin.");
            return false;
        }
        webView.evaluateJavascript("if (typeof window.__rcWebComponentsReceive === 'function') { window.__rcWebComponentsReceive(" + Companion.escapeForJavaScript(envelope.toJsonString()) + "); }", null);
        return true;
    }

    private final boolean isSourceTrusted(Uri sourceOrigin, boolean isMainFrame) {
        String originOrNull;
        if (!isMainFrame || this.expectedOrigin == null || sourceOrigin == null || (originOrNull = WebViewOriginsKt.toOriginOrNull(sourceOrigin)) == null) {
            return false;
        }
        return Intrinsics.areEqual(originOrNull, this.expectedOrigin);
    }

    private final boolean isCurrentUrlTrusted(WebView webView, boolean allowBeforeNavigation) {
        if (this.expectedOrigin == null) {
            return false;
        }
        String url = webView.getUrl();
        String originOrNull = url != null ? WebViewOriginsKt.toOriginOrNull(url) : null;
        return originOrNull == null ? allowBeforeNavigation : Intrinsics.areEqual(originOrNull, this.expectedOrigin);
    }

    /* JADX INFO: compiled from: WebViewJavaScriptBridge.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u00020\b*\u00020\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewJavaScriptBridge$Companion;", "", "()V", "MAX_RESIZE_CSS_PX", "", "RESIZE_APPLY_THRESHOLD_CSS_PX", "", "escapeForJavaScript", "", "resizeDimension", "Lkotlinx/serialization/json/JsonObject;", SubscriberAttributeKt.JSON_NAME_KEY, "(Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Integer resizeDimension(JsonObject jsonObject, String key) {
            Double doubleOrNull;
            Intrinsics.checkNotNullParameter(jsonObject, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            Object obj = jsonObject.get((Object) key);
            JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
            if (jsonPrimitive != null && !jsonPrimitive.getIsString() && (doubleOrNull = JsonElementKt.getDoubleOrNull(jsonPrimitive)) != null) {
                double dDoubleValue = doubleOrNull.doubleValue();
                if (Math.abs(dDoubleValue) <= Double.MAX_VALUE && dDoubleValue > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return Integer.valueOf((int) RangesKt.coerceAtMost(dDoubleValue, WebViewJavaScriptBridge.MAX_RESIZE_CSS_PX));
                }
            }
            return null;
        }

        public final String escapeForJavaScript(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return StringsKt.replace$default(StringsKt.replace$default(str, "\u2028", "\\u2028", false, 4, (Object) null), "\u2029", "\\u2029", false, 4, (Object) null);
        }
    }
}
