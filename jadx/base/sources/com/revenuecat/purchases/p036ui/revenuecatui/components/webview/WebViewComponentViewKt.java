package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.viewinterop.AndroidView_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.webkit.Profile;
import androidx.webkit.ProfileStore;
import androidx.webkit.WebStorageCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.WebViewComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal.p041ws.WebSocketProtocol;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: WebViewComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\u0010\u0010\u001a\b\u0010\u0011\u001a\u00020\tH\u0000\u001a\u0094\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172<\b\u0002\u0010\u0018\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\t0\u00192\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001fH\u0000\u001a4\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0000\u001a\u0010\u0010'\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a2\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020.H\u0000ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001a \u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u000103022\u0006\u0010\f\u001a\u00020\r2\u0006\u00104\u001a\u00020.H\u0000\u001a4\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00012\b\b\u0002\u0010:\u001a\u00020.2\b\b\u0002\u0010;\u001a\u00020.H\u0000\u001a\f\u0010<\u001a\u00020\t*\u00020=H\u0000\u001a\f\u0010>\u001a\u00020\t*\u00020=H\u0000\u001aH\u0010?\u001a\u00020\t*\u00020=2\b\u0010@\u001a\u0004\u0018\u00010\u00072\u0006\u0010A\u001a\u00020.2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0\u001f2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0002\u001a\f\u0010E\u001a\u00020\t*\u00020=H\u0000\u001a1\u0010F\u001a\u0002HG\"\u0004\b\u0000\u0010G*\u00020%2\u0017\u0010H\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002HG0I¢\u0006\u0002\bJH\u0082\b¢\u0006\u0002\u0010K\u001a\u0016\u0010L\u001a\u00020\t*\u00020=2\b\u0010@\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\u0016\u0010M\u001a\u00020\t*\u00020=2\b\u0010@\u001a\u0004\u0018\u00010\u0007H\u0000\u001a\f\u0010N\u001a\u00020O*\u00020=H\u0000\u001a\u0016\u0010P\u001a\u00020\t*\u00020=2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0080T¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006S²\u0006\n\u00104\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010T\u001a\u00020\rX\u008a\u0084\u0002²\u0006\n\u0010U\u001a\u00020\u000bX\u008a\u0084\u0002²\u0006\n\u00108\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010V\u001a\u00020.X\u008a\u008e\u0002"}, m1599d2 = {"AUTOPLAY_REVEAL_FALLBACK_MS", "", "FIT_PLACEHOLDER_HEIGHT", "Lkotlin/UInt;", "I", "FIT_PLACEHOLDER_WIDTH", "PAYWALL_PROFILE_NAME", "", "WebViewComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "clearPaywallProfileStorage", "createPaywallWebView", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/ConfiguredPaywallWebView;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", HTTP.IDENTITY_CODING, "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewIdentity;", "onContentResize", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "widthCssPx", "heightCssPx", "onDocumentReset", "Lkotlin/Function0;", "onLoadFailed", "onLoadFinished", "contextSnapshotProvider", "Lkotlinx/serialization/json/JsonObject;", "createWarmingWebView", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;", "resolvedUrl", "newPaywallWebView", "resolveAxis", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "constraint", "contentCssPx", "placeholder", "unbounded", "", "resolveAxis-BzPDsQc", "(Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;IIZ)Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "webViewContextPushKey", "", "", "darkMode", "webViewEffectiveSize", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "declaredSize", "contentWidthCssPx", "contentHeightCssPx", "widthAxisUnbounded", "heightAxisUnbounded", "applyFullSizeLayoutParams", "Landroid/webkit/WebView;", "applyPaywallProfile", "configure", "expectedOrigin", "allowMediaAutoplay", "onMainFrameNavigationStarted", "onMainFrameLoadFailed", "onMainFrameLoadFinished", "destroyPaywallWebView", "destroyingOnFailure", ExifInterface.GPS_DIRECTION_TRUE, "setUp", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "disableTapHighlight", "hideAutoplayVideoUntilPlaying", "hostedInFrameLayout", "Landroid/widget/FrameLayout;", "releasePaywallWebView", "bridge", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewJavaScriptBridge;", "revenuecatui_defaultsRelease", "currentState", "currentStyle", "loadFailed"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class WebViewComponentViewKt {
    private static final int AUTOPLAY_REVEAL_FALLBACK_MS = 5000;
    public static final int FIT_PLACEHOLDER_HEIGHT = 100;
    public static final int FIT_PLACEHOLDER_WIDTH = 300;
    public static final String PAYWALL_PROFILE_NAME = "com.revenuecat.paywall";

    /* JADX WARN: Removed duplicated region for block: B:148:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void WebViewComponentView(final WebViewComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final WebViewBridgeHolder webViewBridgeHolder;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-860685470);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WebViewComponentView)P(2,1)58@2588L50,61@2700L73,66@2858L307,66@2819L346,83@3669L21,83@3648L43,84@3716L27,85@3768L27,86@3848L76:WebViewComponentView.kt#ofb7cm");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(style) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-860685470, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentView (WebViewComponentView.kt:57)");
                }
                int i5 = i3 & 14;
                if (WebViewComponentStateKt.rememberUpdatedWebViewComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT).getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier3 = companion;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt.WebViewComponentView.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i6) {
                                WebViewComponentViewKt.WebViewComponentView(style, state, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                int i6 = i3;
                final Modifier modifier4 = companion;
                String url = style.getUrl();
                composerStartRestartGroup.startReplaceGroup(-1124698954);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(url);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = WebViewUrlResolver.INSTANCE.resolve(style.getUrl());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final String str = (String) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                String componentId = style.getComponentId();
                String url2 = style.getUrl();
                composerStartRestartGroup.startReplaceGroup(-1124693664);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                boolean zChanged2 = (i5 == 4) | composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(componentId);
                WebViewComponentViewKt$WebViewComponentView$2$1 webViewComponentViewKt$WebViewComponentView$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || webViewComponentViewKt$WebViewComponentView$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    webViewComponentViewKt$WebViewComponentView$2$1RememberedValue = new WebViewComponentViewKt$WebViewComponentView$2$1(str, style, componentId, null);
                    composerStartRestartGroup.updateRememberedValue(webViewComponentViewKt$WebViewComponentView$2$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(url2, componentId, (Function2) webViewComponentViewKt$WebViewComponentView$2$1RememberedValue, composerStartRestartGroup, 0);
                if (str == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup3 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup3 != null) {
                        scopeUpdateScopeEndRestartGroup3.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt.WebViewComponentView.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i7) {
                                WebViewComponentViewKt.WebViewComponentView(style, state, modifier4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (StringsKt.isBlank(componentId)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup4 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup4 != null) {
                        scopeUpdateScopeEndRestartGroup4.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt.WebViewComponentView.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i7) {
                                WebViewComponentViewKt.WebViewComponentView(style, state, modifier4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                boolean z = style.getSize().getWidth() instanceof SizeConstraint.Fit;
                boolean z2 = style.getSize().getHeight() instanceof SizeConstraint.Fit;
                final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0)), composerStartRestartGroup, 0);
                final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(state, composerStartRestartGroup, (i6 >> 3) & 14);
                final State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(style, composerStartRestartGroup, i5);
                composerStartRestartGroup.startReplaceGroup(-1124662215);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState3) | composerStartRestartGroup.changed(stateRememberUpdatedState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<JsonObject>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$contextSnapshotProvider$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final JsonObject invoke() {
                            return WebViewContextSnapshotKt.webViewContextSnapshot(WebViewComponentViewKt.WebViewComponentView$lambda$3(stateRememberUpdatedState2), WebViewComponentViewKt.WebViewComponentView$lambda$4(stateRememberUpdatedState3), WebViewComponentViewKt.WebViewComponentView$lambda$2(stateRememberUpdatedState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final Function0 function0 = (Function0) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                final WebViewIdentity webViewIdentity = new WebViewIdentity(str, componentId, z, z2);
                composerStartRestartGroup.startMovableGroup(-1124642366, webViewIdentity);
                ComposerKt.sourceInformation(composerStartRestartGroup, "100@4343L33,101@4411L33,102@4471L34,104@4637L34,107@4796L178,107@4767L207,118@5514L34,119@5588L34,123@5780L502,194@9422L133,197@9616L135,141@6362L2327,184@8719L396,140@6323L3520");
                composerStartRestartGroup.startReplaceGroup(-1124646418);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableIntState mutableIntState = (MutableIntState) objRememberedValue3;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1124644242);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue4;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1124642321);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState = (MutableState) objRememberedValue5;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1124637009);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new WebViewBridgeHolder();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                WebViewBridgeHolder webViewBridgeHolder2 = (WebViewBridgeHolder) objRememberedValue6;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1124631777);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                boolean zChanged4 = composerStartRestartGroup.changed(stateRememberUpdatedState2) | composerStartRestartGroup.changed(stateRememberUpdatedState) | composerStartRestartGroup.changedInstance(webViewBridgeHolder2);
                WebViewComponentViewKt$WebViewComponentView$5$1 webViewComponentViewKt$WebViewComponentView$5$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged4 || webViewComponentViewKt$WebViewComponentView$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    webViewComponentViewKt$WebViewComponentView$5$1RememberedValue = new WebViewComponentViewKt$WebViewComponentView$5$1(stateRememberUpdatedState2, stateRememberUpdatedState, webViewBridgeHolder2, null);
                    composerStartRestartGroup.updateRememberedValue(webViewComponentViewKt$WebViewComponentView$5$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(webViewBridgeHolder2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) webViewComponentViewKt$WebViewComponentView$5$1RememberedValue, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceGroup(-1124608945);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue7;
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1124606577);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                final MutableState mutableState3 = (MutableState) objRememberedValue8;
                composerStartRestartGroup.endReplaceGroup();
                boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
                boolean zBooleanValue2 = ((Boolean) mutableState3.getValue()).booleanValue();
                Size size = style.getSize();
                int iWebViewComponentView$lambda$7 = WebViewComponentView$lambda$7(mutableIntState);
                int iWebViewComponentView$lambda$10 = WebViewComponentView$lambda$10(mutableIntState2);
                composerStartRestartGroup.startReplaceGroup(-1124599965);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                boolean zChanged5 = composerStartRestartGroup.changed(iWebViewComponentView$lambda$10) | composerStartRestartGroup.changed(size) | composerStartRestartGroup.changed(iWebViewComponentView$lambda$7) | composerStartRestartGroup.changed(zBooleanValue) | composerStartRestartGroup.changed(zBooleanValue2);
                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (zChanged5 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = webViewEffectiveSize(style.getSize(), WebViewComponentView$lambda$7(mutableIntState), WebViewComponentView$lambda$10(mutableIntState2), zBooleanValue, zBooleanValue2);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                Size size2 = (Size) objRememberedValue9;
                composerStartRestartGroup.endReplaceGroup();
                if (WebViewComponentView$lambda$13(mutableState)) {
                    modifier2 = modifier4;
                } else {
                    boolean z3 = style.getSize().getWidth() instanceof SizeConstraint.Fill;
                    composerStartRestartGroup.startReplaceGroup(-1124483790);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                    Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue10 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$6$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Modifier invoke(Modifier conditional) {
                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                return ModifierExtensionsKt.trackMainAxisUnbounded(conditional, true, mutableState2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierConditional = ModifierExtensionsKt.conditional(modifier4, z3, (Function1) objRememberedValue10);
                    boolean z4 = style.getSize().getHeight() instanceof SizeConstraint.Fill;
                    composerStartRestartGroup.startReplaceGroup(-1124477580);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                    Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue11 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$7$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Modifier invoke(Modifier conditional) {
                                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                return ModifierExtensionsKt.trackMainAxisUnbounded(conditional, false, mutableState3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierClipToBounds = ClipKt.clipToBounds(SizeKt.size$default(ModifierExtensionsKt.conditional(modifierConditional, z4, (Function1) objRememberedValue11), size2, null, null, 6, null));
                    composerStartRestartGroup.startReplaceGroup(-1124579516);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                    boolean zChanged6 = composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(webViewIdentity) | composerStartRestartGroup.changed(function0) | composerStartRestartGroup.changedInstance(webViewBridgeHolder2);
                    Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                    if (zChanged6 || objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                        webViewBridgeHolder = webViewBridgeHolder2;
                        objRememberedValue12 = (Function1) new Function1<Context, FrameLayout>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$8$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final FrameLayout invoke(Context context) {
                                Context context2;
                                ConfiguredPaywallWebView configuredPaywallWebViewCreatePaywallWebView;
                                Intrinsics.checkNotNullParameter(context, "context");
                                final MutableIntState mutableIntState3 = mutableIntState;
                                final MutableIntState mutableIntState4 = mutableIntState2;
                                Function2<Integer, Integer, Unit> function2 = new Function2<Integer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$8$1$onContentResize$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                                        invoke2(num, num2);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Integer num, Integer num2) {
                                        if (num != null) {
                                            if (num.intValue() <= 0) {
                                                num = null;
                                            }
                                            if (num != null) {
                                                mutableIntState3.setIntValue(num.intValue());
                                            }
                                        }
                                        if (num2 != null) {
                                            if (num2.intValue() <= 0) {
                                                num2 = null;
                                            }
                                            if (num2 != null) {
                                                mutableIntState4.setIntValue(num2.intValue());
                                            }
                                        }
                                    }
                                };
                                final MutableIntState mutableIntState5 = mutableIntState;
                                final MutableIntState mutableIntState6 = mutableIntState2;
                                Function0<Unit> function02 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$8$1$onDocumentReset$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        mutableIntState5.setIntValue(0);
                                        mutableIntState6.setIntValue(0);
                                    }
                                };
                                final MutableState<Boolean> mutableState4 = mutableState;
                                Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$8$1$onLoadFailed$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        WebViewComponentViewKt.WebViewComponentView$lambda$14(mutableState4, true);
                                    }
                                };
                                PaywallWebViewPrewarmer.INSTANCE.getShared().onDisplayStarted(str);
                                try {
                                    WebViewIdentity webViewIdentity2 = webViewIdentity;
                                    final String str2 = str;
                                    Function0<Unit> function04 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$8$1$configured$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            PaywallWebViewPrewarmer.INSTANCE.getShared().markWarmed(str2);
                                        }
                                    };
                                    context2 = context;
                                    try {
                                        configuredPaywallWebViewCreatePaywallWebView = WebViewComponentViewKt.createPaywallWebView(context2, webViewIdentity2, function2, function02, function03, function04, function0);
                                    } catch (Throwable th) {
                                        th = th;
                                        Logger.INSTANCE.m1587w("Paywalls V2 web_view could not be created: " + th);
                                        WebViewComponentViewKt.WebViewComponentView$lambda$14(mutableState, true);
                                        configuredPaywallWebViewCreatePaywallWebView = null;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    context2 = context;
                                }
                                webViewBridgeHolder.setBridge(configuredPaywallWebViewCreatePaywallWebView != null ? configuredPaywallWebViewCreatePaywallWebView.getBridge() : null);
                                if (configuredPaywallWebViewCreatePaywallWebView == null) {
                                    return new FrameLayout(context2);
                                }
                                try {
                                    configuredPaywallWebViewCreatePaywallWebView.getWebView().loadUrl(str);
                                    return WebViewComponentViewKt.hostedInFrameLayout(configuredPaywallWebViewCreatePaywallWebView.getWebView());
                                } catch (Throwable th3) {
                                    Logger.INSTANCE.m1587w("Paywalls V2 web_view could not start its load: " + th3);
                                    webViewBridgeHolder.setBridge(null);
                                    WebViewComponentViewKt.releasePaywallWebView(configuredPaywallWebViewCreatePaywallWebView.getWebView(), configuredPaywallWebViewCreatePaywallWebView.getBridge());
                                    WebViewComponentViewKt.WebViewComponentView$lambda$14(mutableState, true);
                                    return new FrameLayout(context2);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                    } else {
                        webViewBridgeHolder = webViewBridgeHolder2;
                    }
                    Function1 function1 = (Function1) objRememberedValue12;
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-1124506023);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):WebViewComponentView.kt#9igjgp");
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(webViewBridgeHolder);
                    Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue13 = (Function1) new Function1<FrameLayout, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$WebViewComponentView$9$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FrameLayout frameLayout) {
                                invoke2(frameLayout);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(FrameLayout container) {
                                Intrinsics.checkNotNullParameter(container, "container");
                                PaywallWebViewPrewarmer.INSTANCE.getShared().onDisplayEnded();
                                WebViewJavaScriptBridge bridge = webViewBridgeHolder.getBridge();
                                webViewBridgeHolder.setBridge(null);
                                View childAt = container.getChildAt(0);
                                WebView webView = childAt instanceof WebView ? (WebView) childAt : null;
                                if (webView != null) {
                                    WebViewComponentViewKt.releasePaywallWebView(webView, bridge);
                                }
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    modifier2 = modifier4;
                    AndroidView_androidKt.AndroidView(function1, modifierClipToBounds, null, (Function1) objRememberedValue13, null, composerStartRestartGroup, 0, 20);
                }
                composerStartRestartGroup.endMovableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
            }
            final Modifier modifier5 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt.WebViewComponentView.10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        WebViewComponentViewKt.WebViewComponentView(style, state, modifier5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i52 = i3 & 14;
            if (WebViewComponentStateKt.rememberUpdatedWebViewComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT).getVisible()) {
            }
        }
        final Modifier modifier52 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final int WebViewComponentView$lambda$7(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    private static final int WebViewComponentView$lambda$10(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    private static final boolean WebViewComponentView$lambda$13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WebViewComponentView$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static /* synthetic */ Size webViewEffectiveSize$default(Size size, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z = false;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return webViewEffectiveSize(size, i, i2, z, z2);
    }

    public static final Size webViewEffectiveSize(Size declaredSize, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(declaredSize, "declaredSize");
        return new Size(m14038resolveAxisBzPDsQc(declaredSize.getWidth(), i, 300, z), m14038resolveAxisBzPDsQc(declaredSize.getHeight(), i2, 100, z2));
    }

    /* JADX INFO: renamed from: resolveAxis-BzPDsQc, reason: not valid java name */
    public static final SizeConstraint m14038resolveAxisBzPDsQc(SizeConstraint constraint, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        DefaultConstructorMarker defaultConstructorMarker = null;
        if (constraint instanceof SizeConstraint.Fit) {
            if (i > 0) {
                i2 = UInt.m14594constructorimpl(i);
            } else {
                UInt uInt = ((SizeConstraint.Fit) constraint).getDefault();
                if (uInt != null) {
                    i2 = uInt.getData();
                }
            }
            return new SizeConstraint.Fixed(i2, defaultConstructorMarker);
        }
        if (constraint instanceof SizeConstraint.Fill) {
            if (z) {
                if (i > 0) {
                    i2 = UInt.m14594constructorimpl(i);
                }
                return new SizeConstraint.Fixed(i2, defaultConstructorMarker);
            }
        } else if (!(constraint instanceof SizeConstraint.Fixed)) {
            throw new NoWhenBranchMatchedException();
        }
        return constraint;
    }

    public static final /* synthetic */ List webViewContextPushKey(PaywallState.Loaded.Components state, boolean z) {
        Intrinsics.checkNotNullParameter(state, "state");
        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = state.getSelectedPackageInfo();
        return CollectionsKt.listOf(state, selectedPackageInfo != null ? selectedPackageInfo.getUniqueId() : null, state.getLocale(), Boolean.valueOf(z));
    }

    private static final <T> T destroyingOnFailure(PaywallWebView paywallWebView, Function1<? super PaywallWebView, ? extends T> function1) {
        try {
            return function1.invoke(paywallWebView);
        } catch (Throwable th) {
            destroyPaywallWebView(paywallWebView);
            throw th;
        }
    }

    private static final PaywallWebView newPaywallWebView(Context context) {
        PaywallWebView paywallWebView = new PaywallWebView(context);
        try {
            applyFullSizeLayoutParams(paywallWebView);
            applyPaywallProfile(paywallWebView);
            return paywallWebView;
        } catch (Throwable th) {
            destroyPaywallWebView(paywallWebView);
            throw th;
        }
    }

    public static /* synthetic */ ConfiguredPaywallWebView createPaywallWebView$default(Context context, WebViewIdentity webViewIdentity, Function2 function2, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = new Function2<Integer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt.createPaywallWebView.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num, Integer num2) {
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                    invoke2(num, num2);
                    return Unit.INSTANCE;
                }
            };
        }
        Function2 function22 = function2;
        if ((i & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt.createPaywallWebView.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Function0 function05 = function0;
        if ((i & 32) != 0) {
            function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt.createPaywallWebView.3
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        return createPaywallWebView(context, webViewIdentity, function22, function05, function02, function03, function04);
    }

    public static final ConfiguredPaywallWebView createPaywallWebView(Context context, WebViewIdentity identity, Function2<? super Integer, ? super Integer, Unit> onContentResize, Function0<Unit> onDocumentReset, final Function0<Unit> onLoadFailed, Function0<Unit> onLoadFinished, Function0<JsonObject> contextSnapshotProvider) throws Throwable {
        PaywallWebView paywallWebView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(identity, "identity");
        Intrinsics.checkNotNullParameter(onContentResize, "onContentResize");
        Intrinsics.checkNotNullParameter(onDocumentReset, "onDocumentReset");
        Intrinsics.checkNotNullParameter(onLoadFailed, "onLoadFailed");
        Intrinsics.checkNotNullParameter(onLoadFinished, "onLoadFinished");
        Intrinsics.checkNotNullParameter(contextSnapshotProvider, "contextSnapshotProvider");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        String originOrNull = WebViewOriginsKt.toOriginOrNull(identity.getResolvedUrl());
        PaywallWebView paywallWebViewNewPaywallWebView = newPaywallWebView(context);
        try {
            WebViewJavaScriptBridge webViewJavaScriptBridge = new WebViewJavaScriptBridge(paywallWebViewNewPaywallWebView, identity.getComponentId(), identity.getResolvedUrl(), identity.getSizeToContentWidth(), identity.getSizeToContentHeight(), onContentResize, onDocumentReset, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$createPaywallWebView$4$bridge$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    booleanRef.element = true;
                    onLoadFailed.invoke();
                }
            }, contextSnapshotProvider);
            webViewJavaScriptBridge.attach();
            if (booleanRef.element) {
                releasePaywallWebView(paywallWebViewNewPaywallWebView, webViewJavaScriptBridge);
                return null;
            }
            paywallWebView = paywallWebViewNewPaywallWebView;
            try {
                configure(paywallWebViewNewPaywallWebView, originOrNull, true, new WebViewComponentViewKt$createPaywallWebView$4$1(webViewJavaScriptBridge), onLoadFailed, onLoadFinished);
                WebViewGestureOwnershipProbeKt.installGestureOwnershipProbe(paywallWebView, originOrNull, new WebViewComponentViewKt$createPaywallWebView$4$2(paywallWebView));
                disableTapHighlight(paywallWebView, originOrNull);
                hideAutoplayVideoUntilPlaying(paywallWebView, originOrNull);
                return new ConfiguredPaywallWebView(paywallWebView, webViewJavaScriptBridge);
            } catch (Throwable th) {
                th = th;
                destroyPaywallWebView(paywallWebView);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            paywallWebView = paywallWebViewNewPaywallWebView;
        }
    }

    public static final PaywallWebView createWarmingWebView(Context context, String resolvedUrl, Function0<Unit> onLoadFailed, Function0<Unit> onLoadFinished) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resolvedUrl, "resolvedUrl");
        Intrinsics.checkNotNullParameter(onLoadFailed, "onLoadFailed");
        Intrinsics.checkNotNullParameter(onLoadFinished, "onLoadFinished");
        PaywallWebView paywallWebViewNewPaywallWebView = newPaywallWebView(context);
        try {
            configure(paywallWebViewNewPaywallWebView, WebViewOriginsKt.toOriginOrNull(resolvedUrl), false, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$createWarmingWebView$1$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, onLoadFailed, onLoadFinished);
            return paywallWebViewNewPaywallWebView;
        } catch (Throwable th) {
            destroyPaywallWebView(paywallWebViewNewPaywallWebView);
            throw th;
        }
    }

    public static final void destroyPaywallWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        webView.stopLoading();
        webView.setWebViewClient(new WebViewClient());
        webView.destroy();
    }

    public static final void releasePaywallWebView(WebView webView, WebViewJavaScriptBridge webViewJavaScriptBridge) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        if (webViewJavaScriptBridge != null) {
            webViewJavaScriptBridge.release();
        }
        WebViewGestureOwnershipProbeKt.removeGestureOwnershipProbe(webView);
        destroyPaywallWebView(webView);
    }

    public static final FrameLayout hostedInFrameLayout(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        FrameLayout frameLayout = new FrameLayout(webView.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(webView);
        return frameLayout;
    }

    public static final void applyFullSizeLayoutParams(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    private static final void configure(WebView webView, String str, boolean z, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03) {
        webView.setBackgroundColor(0);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setOverScrollMode(2);
        webView.getSettings().setAllowContentAccess(false);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setCacheMode(-1);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setMixedContentMode(1);
        webView.getSettings().setGeolocationEnabled(false);
        webView.getSettings().setSupportZoom(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(!z);
        webView.setWebViewClient(new PaywallWebViewClient(str, function0, function02, function03));
        if (Purchases.INSTANCE.getLogLevel().compareTo(LogLevel.DEBUG) <= 0) {
            webView.setWebChromeClient(new WebChromeClient() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt.configure.1
                @Override // android.webkit.WebChromeClient
                public boolean onConsoleMessage(ConsoleMessage message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Logger.INSTANCE.m1583d("Paywalls V2 web_view console [" + message.messageLevel() + "] " + message.message() + " (" + message.sourceId() + AbstractJsonLexerKt.COLON + message.lineNumber() + ')');
                    return true;
                }
            });
        }
    }

    public static final void hideAutoplayVideoUntilPlaying(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        if (WebViewFeature.isFeatureSupported(WebViewFeature.DOCUMENT_START_SCRIPT)) {
            if (str == null) {
                str = "*";
            }
            try {
                WebViewCompat.addDocumentStartJavaScript(webView, "(function () {\n  var style = document.createElement('style');\n  style.textContent = 'video[autoplay]:not([data-rc-playing]){opacity:0!important}';\n  document.documentElement.appendChild(style);\n  function reveal(video) { video.setAttribute('data-rc-playing', ''); }\n  document.addEventListener('playing', function (event) { reveal(event.target); }, true);\n  // Armed per element on `loadstart` so videos added after load are covered too.\n  document.addEventListener('loadstart', function (event) {\n    var video = event.target;\n    setTimeout(function () { reveal(video); }, 5000);\n  }, true);\n})();", SetsKt.setOf(str));
            } catch (RuntimeException e) {
                Logger.INSTANCE.m1587w("Failed to install web_view autoplay video reveal: " + e);
            }
        }
    }

    public static final void disableTapHighlight(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        if (WebViewFeature.isFeatureSupported(WebViewFeature.DOCUMENT_START_SCRIPT) && str != null) {
            try {
                WebViewCompat.addDocumentStartJavaScript(webView, "document.documentElement.style.webkitTapHighlightColor = 'transparent';", SetsKt.setOf(str));
            } catch (RuntimeException e) {
                Logger.INSTANCE.m1587w("Failed to disable webkit tap highlight: " + e);
            }
        }
    }

    public static final void applyPaywallProfile(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        if (WebViewFeature.isFeatureSupported("MULTI_PROFILE")) {
            try {
                ProfileStore.getInstance().getOrCreateProfile(PAYWALL_PROFILE_NAME);
                WebViewCompat.setProfile(webView, PAYWALL_PROFILE_NAME);
            } catch (RuntimeException e) {
                Logger.INSTANCE.m1587w("Paywalls V2 web_view could not use an isolated profile; using the default. " + e);
            }
        }
    }

    public static final void clearPaywallProfileStorage() {
        if (!WebViewFeature.isFeatureSupported("MULTI_PROFILE")) {
            Logger.INSTANCE.m1583d("Paywalls V2 web_view storage was not cleared: this System WebView has no isolated profile.");
            return;
        }
        try {
            Profile profile = ProfileStore.getInstance().getProfile(PAYWALL_PROFILE_NAME);
            if (profile == null) {
                return;
            }
            if (WebViewFeature.isFeatureSupported(WebViewFeature.DELETE_BROWSING_DATA)) {
                WebStorageCompat.deleteBrowsingData(profile.getWebStorage(), new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewComponentViewKt.clearPaywallProfileStorage$lambda$28();
                    }
                });
                return;
            }
            final CookieManager cookieManager = profile.getCookieManager();
            cookieManager.removeAllCookies(new ValueCallback() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentViewKt$$ExternalSyntheticLambda1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    cookieManager.flush();
                }
            });
            profile.getWebStorage().deleteAllData();
            Logger.INSTANCE.m1583d("Cleared the paywall web_view profile's cookies and web storage.");
        } catch (RuntimeException e) {
            Logger.INSTANCE.m1587w("Paywalls V2 web_view storage could not be cleared. " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearPaywallProfileStorage$lambda$28() {
        PaywallWebViewPrewarmer.INSTANCE.getShared().onCacheCleared();
        Logger.INSTANCE.m1583d("Cleared the paywall web_view profile's browsing data.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean WebViewComponentView$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallState.Loaded.Components WebViewComponentView$lambda$3(State<PaywallState.Loaded.Components> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebViewComponentStyle WebViewComponentView$lambda$4(State<WebViewComponentStyle> state) {
        return state.getValue();
    }
}
