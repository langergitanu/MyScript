package com.revenuecat.purchases.p036ui.revenuecatui.components.style;

import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedWebViewPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.state.PackageContext;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewComponentStyle.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u00012\u00020\u0002Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006¢\u0006\u0002\u0010\u0017J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\u0004HÆ\u0003J\u0015\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0086\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00062\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0013HÖ\u0001J\t\u0010;\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001b¨\u0006<"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageContext;", ImagesContract.URL, "", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "componentId", "overrides", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedOverride;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedWebViewPartial;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "tabIndex", "", "offerEligibility", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "ignoreTopWindowInsets", "(Ljava/lang/String;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Z)V", "getComponentId", "()Ljava/lang/String;", "getIgnoreTopWindowInsets", "()Z", "getOfferEligibility", "()Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "getOverrides", "()Ljava/util/List;", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getTabIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "getVisible", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;Ljava/lang/Integer;Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;Z)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/WebViewComponentStyle;", "equals", "other", "", "hashCode", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class WebViewComponentStyle implements ComponentStyle, PackageContext {
    public static final int $stable = 0;
    private final String componentId;
    private final boolean ignoreTopWindowInsets;
    private final OfferEligibility offerEligibility;
    private final List<PresentedOverride<PresentedWebViewPartial>> overrides;
    private final Package rcPackage;
    private final ResolvedOffer resolvedOffer;
    private final Size size;
    private final Integer tabIndex;
    private final String url;
    private final boolean visible;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WebViewComponentStyle copy$default(WebViewComponentStyle webViewComponentStyle, String str, boolean z, Size size, String str2, List list, Package r6, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webViewComponentStyle.url;
        }
        if ((i & 2) != 0) {
            z = webViewComponentStyle.visible;
        }
        if ((i & 4) != 0) {
            size = webViewComponentStyle.size;
        }
        if ((i & 8) != 0) {
            str2 = webViewComponentStyle.componentId;
        }
        if ((i & 16) != 0) {
            list = webViewComponentStyle.overrides;
        }
        if ((i & 32) != 0) {
            r6 = webViewComponentStyle.rcPackage;
        }
        if ((i & 64) != 0) {
            resolvedOffer = webViewComponentStyle.resolvedOffer;
        }
        if ((i & 128) != 0) {
            num = webViewComponentStyle.tabIndex;
        }
        if ((i & 256) != 0) {
            offerEligibility = webViewComponentStyle.offerEligibility;
        }
        if ((i & 512) != 0) {
            z2 = webViewComponentStyle.ignoreTopWindowInsets;
        }
        OfferEligibility offerEligibility2 = offerEligibility;
        boolean z3 = z2;
        ResolvedOffer resolvedOffer2 = resolvedOffer;
        Integer num2 = num;
        List list2 = list;
        Package r8 = r6;
        return webViewComponentStyle.copy(str, z, size, str2, list2, r8, resolvedOffer2, num2, offerEligibility2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIgnoreTopWindowInsets() {
        return this.ignoreTopWindowInsets;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getComponentId() {
        return this.componentId;
    }

    public final List<PresentedOverride<PresentedWebViewPartial>> component5() {
        return this.overrides;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Package getRcPackage() {
        return this.rcPackage;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getTabIndex() {
        return this.tabIndex;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final WebViewComponentStyle copy(String url, boolean visible, Size size, String componentId, List<PresentedOverride<PresentedWebViewPartial>> overrides, Package rcPackage, ResolvedOffer resolvedOffer, Integer tabIndex, OfferEligibility offerEligibility, boolean ignoreTopWindowInsets) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        return new WebViewComponentStyle(url, visible, size, componentId, overrides, rcPackage, resolvedOffer, tabIndex, offerEligibility, ignoreTopWindowInsets);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebViewComponentStyle)) {
            return false;
        }
        WebViewComponentStyle webViewComponentStyle = (WebViewComponentStyle) other;
        return Intrinsics.areEqual(this.url, webViewComponentStyle.url) && this.visible == webViewComponentStyle.visible && Intrinsics.areEqual(this.size, webViewComponentStyle.size) && Intrinsics.areEqual(this.componentId, webViewComponentStyle.componentId) && Intrinsics.areEqual(this.overrides, webViewComponentStyle.overrides) && Intrinsics.areEqual(this.rcPackage, webViewComponentStyle.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, webViewComponentStyle.resolvedOffer) && Intrinsics.areEqual(this.tabIndex, webViewComponentStyle.tabIndex) && Intrinsics.areEqual(this.offerEligibility, webViewComponentStyle.offerEligibility) && this.ignoreTopWindowInsets == webViewComponentStyle.ignoreTopWindowInsets;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.url.hashCode() * 31) + Boolean.hashCode(this.visible)) * 31) + this.size.hashCode()) * 31) + this.componentId.hashCode()) * 31) + this.overrides.hashCode()) * 31;
        Package r1 = this.rcPackage;
        int iHashCode2 = (iHashCode + (r1 == null ? 0 : r1.hashCode())) * 31;
        ResolvedOffer resolvedOffer = this.resolvedOffer;
        int iHashCode3 = (iHashCode2 + (resolvedOffer == null ? 0 : resolvedOffer.hashCode())) * 31;
        Integer num = this.tabIndex;
        int iHashCode4 = (iHashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        OfferEligibility offerEligibility = this.offerEligibility;
        return ((iHashCode4 + (offerEligibility != null ? offerEligibility.hashCode() : 0)) * 31) + Boolean.hashCode(this.ignoreTopWindowInsets);
    }

    public String toString() {
        return "WebViewComponentStyle(url=" + this.url + ", visible=" + this.visible + ", size=" + this.size + ", componentId=" + this.componentId + ", overrides=" + this.overrides + ", rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ", tabIndex=" + this.tabIndex + ", offerEligibility=" + this.offerEligibility + ", ignoreTopWindowInsets=" + this.ignoreTopWindowInsets + ')';
    }

    public WebViewComponentStyle(String url, boolean z, Size size, String componentId, List<PresentedOverride<PresentedWebViewPartial>> overrides, Package r7, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(overrides, "overrides");
        this.url = url;
        this.visible = z;
        this.size = size;
        this.componentId = componentId;
        this.overrides = overrides;
        this.rcPackage = r7;
        this.resolvedOffer = resolvedOffer;
        this.tabIndex = num;
        this.offerEligibility = offerEligibility;
        this.ignoreTopWindowInsets = z2;
    }

    public /* synthetic */ WebViewComponentStyle(String str, boolean z, Size size, String str2, List list, Package r7, ResolvedOffer resolvedOffer, Integer num, OfferEligibility offerEligibility, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, size, str2, list, r7, (i & 64) != 0 ? null : resolvedOffer, num, (i & 256) != 0 ? null : offerEligibility, (i & 512) != 0 ? false : z2);
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle
    public boolean getVisible() {
        return this.visible;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle
    public Size getSize() {
        return this.size;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final List<PresentedOverride<PresentedWebViewPartial>> getOverrides() {
        return this.overrides;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Package getRcPackage() {
        return this.rcPackage;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ ResolvedOffer getResolvedOffer() {
        return this.resolvedOffer;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ Integer getTabIndex() {
        return this.tabIndex;
    }

    @Override // com.revenuecat.purchases.p036ui.revenuecatui.components.state.PackageContext
    public /* synthetic */ OfferEligibility getOfferEligibility() {
        return this.offerEligibility;
    }

    public final boolean getIgnoreTopWindowInsets() {
        return this.ignoreTopWindowInsets;
    }
}
