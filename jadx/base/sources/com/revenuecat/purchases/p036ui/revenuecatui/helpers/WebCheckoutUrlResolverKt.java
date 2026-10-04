package com.revenuecat.purchases.p036ui.revenuecatui.helpers;

import com.myscript.nebo.LaunchActivity;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.utils.URIExtensionsKt;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebCheckoutUrlResolver.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a2\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¨\u0006\u0010"}, m1599d2 = {"resolvedWebCheckoutInteractionUrl", "", "paywallAction", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "resolveCustomCheckoutUrl", "customUrl", "behavior", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior;", "packageToUse", "Lcom/revenuecat/purchases/Package;", "packageParam", "resolveWebCheckoutUrlForInteraction", "launchWebCheckout", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WebCheckoutUrlResolverKt {

    /* JADX INFO: compiled from: WebCheckoutUrlResolver.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonComponent.UrlMethod.values().length];
            try {
                iArr[ButtonComponent.UrlMethod.EXTERNAL_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.IN_APP_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonComponent.UrlMethod.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final String resolveWebCheckoutUrlForInteraction(PaywallState.Loaded.Components components, PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        Pair pairM1606to;
        URL webCheckoutURL;
        Intrinsics.checkNotNullParameter(components, "<this>");
        Intrinsics.checkNotNullParameter(launchWebCheckout, "launchWebCheckout");
        String resolvedUrl = launchWebCheckout.getResolvedUrl();
        if (resolvedUrl != null) {
            return resolvedUrl;
        }
        String customUrl = launchWebCheckout.getCustomUrl();
        PaywallAction.External.LaunchWebCheckout.ParamBehavior paramBehavior = launchWebCheckout.getParamBehavior();
        if (paramBehavior instanceof PaywallAction.External.LaunchWebCheckout.ParamBehavior.Append) {
            PaywallAction.External.LaunchWebCheckout.ParamBehavior.Append append = (PaywallAction.External.LaunchWebCheckout.ParamBehavior.Append) paramBehavior;
            Package rcPackage = append.getRcPackage();
            if (rcPackage == null) {
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = components.getSelectedPackageInfo();
                rcPackage = selectedPackageInfo != null ? selectedPackageInfo.getRcPackage() : null;
            }
            pairM1606to = TuplesKt.m1606to(rcPackage, append.getPackageParam());
        } else if (paramBehavior instanceof PaywallAction.External.LaunchWebCheckout.ParamBehavior.DoNotAppend) {
            pairM1606to = TuplesKt.m1606to(null, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Package r3 = (Package) pairM1606to.component1();
        String strResolveCustomCheckoutUrl = customUrl != null ? resolveCustomCheckoutUrl(components, customUrl, paramBehavior, r3, (String) pairM1606to.component2()) : null;
        if (strResolveCustomCheckoutUrl == null) {
            strResolveCustomCheckoutUrl = (r3 == null || (webCheckoutURL = r3.getWebCheckoutURL()) == null) ? null : webCheckoutURL.toString();
            if (strResolveCustomCheckoutUrl == null) {
                URL webCheckoutURL2 = components.getOffering().getWebCheckoutURL();
                if (webCheckoutURL2 != null) {
                    return webCheckoutURL2.toString();
                }
                return null;
            }
        }
        return strResolveCustomCheckoutUrl;
    }

    private static final String resolveCustomCheckoutUrl(PaywallState.Loaded.Components components, String str, PaywallAction.External.LaunchWebCheckout.ParamBehavior paramBehavior, Package r8, String str2) {
        URI uri;
        try {
            uri = new URI(str);
        } catch (URISyntaxException e) {
            Logger.INSTANCE.m1585e("Invalid custom URI: " + str, e);
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        mapCreateMapBuilder.put("rc_source", LaunchActivity.LaunchRoute.App);
        if (paramBehavior instanceof PaywallAction.External.LaunchWebCheckout.ParamBehavior.Append) {
            PaywallAction.External.LaunchWebCheckout.ParamBehavior.Append append = (PaywallAction.External.LaunchWebCheckout.ParamBehavior.Append) paramBehavior;
            String appUserIdParam = append.getAppUserIdParam();
            if (appUserIdParam != null) {
            }
            String envParam = append.getEnvParam();
            if (envParam != null) {
            }
            if (str2 != null && r8 != null) {
                mapCreateMapBuilder.putIfAbsent(str2, r8.getIdentifier());
            }
        }
        URI uriUpsertQueryParameters = URIExtensionsKt.upsertQueryParameters(uri, MapsKt.build(mapCreateMapBuilder));
        if (uriUpsertQueryParameters != null) {
            return uriUpsertQueryParameters.toString();
        }
        return null;
    }

    public static final String resolvedWebCheckoutInteractionUrl(PaywallAction paywallAction, PaywallState.Loaded.Components state) {
        Intrinsics.checkNotNullParameter(paywallAction, "paywallAction");
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(paywallAction instanceof PaywallAction.External.LaunchWebCheckout)) {
            return null;
        }
        PaywallAction.External.LaunchWebCheckout launchWebCheckout = (PaywallAction.External.LaunchWebCheckout) paywallAction;
        int i = WhenMappings.$EnumSwitchMapping$0[launchWebCheckout.getOpenMethod().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return resolveWebCheckoutUrlForInteraction(state, launchWebCheckout);
        }
        if (i == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
