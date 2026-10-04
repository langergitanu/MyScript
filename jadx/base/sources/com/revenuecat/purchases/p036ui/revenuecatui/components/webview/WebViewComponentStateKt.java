package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.WebViewComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallStateStore;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewComponentState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ai\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0003¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"rememberUpdatedWebViewComponentState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewComponentState;", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "stateStoreProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewComponentState;", "paywallState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewComponentState;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class WebViewComponentStateKt {
    public static final /* synthetic */ WebViewComponentState rememberUpdatedWebViewComponentState(WebViewComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.startReplaceGroup(-2108781574);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedWebViewComponentState)P(1)32@1566L36,33@1635L33,34@1709L41,35@1782L38,36@1847L27,30@1475L402:WebViewComponentState.kt#ofb7cm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2108781574, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.webview.rememberUpdatedWebViewComponentState (WebViewComponentState.kt:30)");
        }
        composer.startReplaceGroup(-201002809);
        ComposerKt.sourceInformation(composer, "CC(remember):WebViewComponentState.kt#9igjgp");
        int i2 = (i & 112) ^ 48;
        boolean z = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<PaywallState.Loaded.Components.SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentStateKt$rememberUpdatedWebViewComponentState$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                    return paywallState.getSelectedPackageInfo();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-201000604);
        ComposerKt.sourceInformation(composer, "CC(remember):WebViewComponentState.kt#9igjgp");
        boolean z2 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function0) new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentStateKt$rememberUpdatedWebViewComponentState$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(paywallState.getSelectedTabIndex());
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function02 = (Function0) objRememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-200998228);
        ComposerKt.sourceInformation(composer, "CC(remember):WebViewComponentState.kt#9igjgp");
        boolean z3 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function0) new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentStateKt$rememberUpdatedWebViewComponentState$3$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final OfferEligibility invoke() {
                    return paywallState.getSelectedOfferEligibility();
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function0 function03 = (Function0) objRememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-200995895);
        ComposerKt.sourceInformation(composer, "CC(remember):WebViewComponentState.kt#9igjgp");
        boolean z4 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function0) new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentStateKt$rememberUpdatedWebViewComponentState$4$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends CustomVariableValue> invoke() {
                    return paywallState.getMergedCustomVariables();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Function0 function04 = (Function0) objRememberedValue4;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-200993826);
        ComposerKt.sourceInformation(composer, "CC(remember):WebViewComponentState.kt#9igjgp");
        boolean z5 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue5 = composer.rememberedValue();
        if (z5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = (Function0) new Function0<PaywallStateStore>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.WebViewComponentStateKt$rememberUpdatedWebViewComponentState$5$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PaywallStateStore invoke() {
                    return paywallState.getStateStore();
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        composer.endReplaceGroup();
        WebViewComponentState webViewComponentStateRememberUpdatedWebViewComponentState = rememberUpdatedWebViewComponentState(style, function0, function02, function03, function04, (Function0) objRememberedValue5, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return webViewComponentStateRememberUpdatedWebViewComponentState;
    }

    private static final /* synthetic */ WebViewComponentState rememberUpdatedWebViewComponentState(WebViewComponentStyle webViewComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Composer composer, int i) {
        composer.startReplaceGroup(-562085384);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedWebViewComponentState)P(5,2,3,1)51@2389L27,*53@2466L468:WebViewComponentState.kt#ofb7cm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-562085384, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.webview.rememberUpdatedWebViewComponentState (WebViewComponentState.kt:50)");
        }
        WindowWidthSizeClass windowWidthSizeClass = AndroidWindowAdaptiveInfo_androidKt.currentWindowAdaptiveInfo(composer, 0).getWindowSizeClass().getWindowWidthSizeClass();
        composer.startReplaceGroup(-200973577);
        ComposerKt.sourceInformation(composer, "CC(remember):WebViewComponentState.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(webViewComponentStyle)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            WebViewComponentState webViewComponentState = new WebViewComponentState(windowWidthSizeClass, webViewComponentStyle, function0, function02, function03, function04, function05);
            composer.updateRememberedValue(webViewComponentState);
            objRememberedValue = webViewComponentState;
        }
        WebViewComponentState webViewComponentState2 = (WebViewComponentState) objRememberedValue;
        composer.endReplaceGroup();
        webViewComponentState2.update(windowWidthSizeClass);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return webViewComponentState2;
    }
}
