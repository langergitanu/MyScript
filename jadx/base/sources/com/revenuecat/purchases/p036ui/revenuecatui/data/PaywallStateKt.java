package com.revenuecat.purchases.p036ui.revenuecatui.data;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPackagePartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.paywalls.components.PartialPackageComponent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PaywallState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0000¢\u0006\u0002\u0010\u0013\u001a(\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u00020\u00150\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00180\rH\u0002\u001a(\u0010\u0019\u001a\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u00020\u00150\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00180\rH\u0002\u001a(\u0010\u001a\u001a\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u00020\u00150\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00180\rH\u0002\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u0002*\u00020\u001cH\u0000\u001a \u0010\u001d\u001a\u00020\u0006*\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00180\rH\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, m1599d2 = {"currentColors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "getCurrentColors", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "isInFullScreenMode", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;)Z", "selectedLocalization", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "getSelectedLocalization", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;)Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/ProcessedLocalizedConfiguration;", "getAvailableStorefrontCountryLocalesByLanguage", "", "", "Ljava/util/Locale;", "storefrontCountryCode", "availableLocales", "", "(Ljava/lang/String;[Ljava/util/Locale;)Ljava/util/Map;", "authoredDefaultIfVisible", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$AvailablePackages$Info;", "", "customVariables", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "defaultSelection", "firstVisible", "loadedLegacy", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState;", "resolvesVisible", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallStateKt {
    public static /* synthetic */ Map getAvailableStorefrontCountryLocalesByLanguage$default(String str, Locale[] localeArr, int i, Object obj) {
        if ((i & 2) != 0) {
            localeArr = Locale.getAvailableLocales();
            Intrinsics.checkNotNullExpressionValue(localeArr, "getAvailableLocales()");
        }
        return getAvailableStorefrontCountryLocalesByLanguage(str, localeArr);
    }

    public static final Map<String, Locale> getAvailableStorefrontCountryLocalesByLanguage(String str, Locale[] availableLocales) {
        Intrinsics.checkNotNullParameter(availableLocales, "availableLocales");
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return MapsKt.emptyMap();
        }
        ArrayList arrayList = new ArrayList();
        for (Locale locale : availableLocales) {
            if (StringsKt.equals(locale.getCountry(), str, true) && !StringsKt.equals(locale.getVariant(), "POSIX", true)) {
                arrayList.add(locale);
            }
        }
        ArrayList arrayList2 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
        for (Object obj : arrayList2) {
            String language = ((Locale) obj).getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "it.language");
            String lowerCase = language.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            linkedHashMap.put(lowerCase, obj);
        }
        return linkedHashMap;
    }

    public static final PaywallState.Loaded.Legacy loadedLegacy(PaywallState paywallState) {
        Intrinsics.checkNotNullParameter(paywallState, "<this>");
        if (paywallState instanceof PaywallState.Error) {
            return null;
        }
        if (paywallState instanceof PaywallState.Loaded) {
            PaywallState.Loaded loaded = (PaywallState.Loaded) paywallState;
            if (loaded instanceof PaywallState.Loaded.Legacy) {
                return (PaywallState.Loaded.Legacy) paywallState;
            }
            if (loaded instanceof PaywallState.Loaded.Components) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
        if (paywallState instanceof PaywallState.Loading) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final ProcessedLocalizedConfiguration getSelectedLocalization(PaywallState.Loaded.Legacy legacy) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        return legacy.getSelectedPackage().getValue().getLocalization();
    }

    public static final TemplateConfiguration.Colors getCurrentColors(PaywallState.Loaded.Legacy legacy, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        ComposerKt.sourceInformationMarkerStart(composer, 779612430, "C(<get-currentColors>)510@24810L18:PaywallState.kt#beua8j");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(779612430, i, -1, "com.revenuecat.purchases.ui.revenuecatui.data.<get-currentColors> (PaywallState.kt:510)");
        }
        TemplateConfiguration.Colors currentColors = legacy.getTemplateConfiguration().getCurrentColors(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return currentColors;
    }

    public static final boolean isInFullScreenMode(PaywallState.Loaded.Legacy legacy) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        return PaywallModeKt.isFullScreen(legacy.getTemplateConfiguration().getMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean resolvesVisible(PaywallState.Loaded.Components.AvailablePackages.Info info, Map<String, ? extends CustomVariableValue> map) {
        PartialPackageComponent partial;
        Boolean visible;
        List<PresentedOverride<PresentedPackagePartial>> visibilityOverrides = info.getVisibilityOverrides();
        ScreenCondition screenCondition = ScreenCondition.COMPACT;
        OfferEligibility.Ineligible offerEligibility = info.getOfferEligibility();
        if (offerEligibility == null) {
            offerEligibility = OfferEligibility.Ineligible.INSTANCE;
        }
        PresentedPackagePartial presentedPackagePartial = (PresentedPackagePartial) PresentedPartialKt.buildPresentedPartial(visibilityOverrides, screenCondition, offerEligibility, ComponentViewState.DEFAULT, new ConditionContext(null, map, null, 4, null));
        if (presentedPackagePartial != null && (partial = presentedPackagePartial.getPartial()) != null && (visible = partial.getVisible()) != null) {
            return visible.booleanValue();
        }
        return info.getVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallState.Loaded.Components.AvailablePackages.Info defaultSelection(List<PaywallState.Loaded.Components.AvailablePackages.Info> list, Map<String, ? extends CustomVariableValue> map) {
        PaywallState.Loaded.Components.AvailablePackages.Info infoAuthoredDefaultIfVisible = authoredDefaultIfVisible(list, map);
        return infoAuthoredDefaultIfVisible == null ? firstVisible(list, map) : infoAuthoredDefaultIfVisible;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallState.Loaded.Components.AvailablePackages.Info authoredDefaultIfVisible(List<PaywallState.Loaded.Components.AvailablePackages.Info> list, Map<String, ? extends CustomVariableValue> map) {
        Object next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            PaywallState.Loaded.Components.AvailablePackages.Info info = (PaywallState.Loaded.Components.AvailablePackages.Info) next;
            if (info.isSelectedByDefault() && resolvesVisible(info, map)) {
                break;
            }
        }
        return (PaywallState.Loaded.Components.AvailablePackages.Info) next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallState.Loaded.Components.AvailablePackages.Info firstVisible(List<PaywallState.Loaded.Components.AvailablePackages.Info> list, Map<String, ? extends CustomVariableValue> map) {
        Object next;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (resolvesVisible((PaywallState.Loaded.Components.AvailablePackages.Info) next, map)) {
                break;
            }
        }
        return (PaywallState.Loaded.Components.AvailablePackages.Info) next;
    }
}
