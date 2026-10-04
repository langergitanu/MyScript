package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebViewIdentity.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/WebViewIdentity;", "", "resolvedUrl", "", "componentId", "sizeToContentWidth", "", "sizeToContentHeight", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getComponentId", "()Ljava/lang/String;", "getResolvedUrl", "getSizeToContentHeight", "()Z", "getSizeToContentWidth", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class WebViewIdentity {
    public static final int $stable = 0;
    private final String componentId;
    private final String resolvedUrl;
    private final boolean sizeToContentHeight;
    private final boolean sizeToContentWidth;

    public static /* synthetic */ WebViewIdentity copy$default(WebViewIdentity webViewIdentity, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = webViewIdentity.resolvedUrl;
        }
        if ((i & 2) != 0) {
            str2 = webViewIdentity.componentId;
        }
        if ((i & 4) != 0) {
            z = webViewIdentity.sizeToContentWidth;
        }
        if ((i & 8) != 0) {
            z2 = webViewIdentity.sizeToContentHeight;
        }
        return webViewIdentity.copy(str, str2, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getResolvedUrl() {
        return this.resolvedUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getComponentId() {
        return this.componentId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSizeToContentWidth() {
        return this.sizeToContentWidth;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSizeToContentHeight() {
        return this.sizeToContentHeight;
    }

    public final WebViewIdentity copy(String resolvedUrl, String componentId, boolean sizeToContentWidth, boolean sizeToContentHeight) {
        Intrinsics.checkNotNullParameter(resolvedUrl, "resolvedUrl");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        return new WebViewIdentity(resolvedUrl, componentId, sizeToContentWidth, sizeToContentHeight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WebViewIdentity)) {
            return false;
        }
        WebViewIdentity webViewIdentity = (WebViewIdentity) other;
        return Intrinsics.areEqual(this.resolvedUrl, webViewIdentity.resolvedUrl) && Intrinsics.areEqual(this.componentId, webViewIdentity.componentId) && this.sizeToContentWidth == webViewIdentity.sizeToContentWidth && this.sizeToContentHeight == webViewIdentity.sizeToContentHeight;
    }

    public int hashCode() {
        return (((((this.resolvedUrl.hashCode() * 31) + this.componentId.hashCode()) * 31) + Boolean.hashCode(this.sizeToContentWidth)) * 31) + Boolean.hashCode(this.sizeToContentHeight);
    }

    public String toString() {
        return "WebViewIdentity(resolvedUrl=" + this.resolvedUrl + ", componentId=" + this.componentId + ", sizeToContentWidth=" + this.sizeToContentWidth + ", sizeToContentHeight=" + this.sizeToContentHeight + ')';
    }

    public WebViewIdentity(String resolvedUrl, String componentId, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(resolvedUrl, "resolvedUrl");
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        this.resolvedUrl = resolvedUrl;
        this.componentId = componentId;
        this.sizeToContentWidth = z;
        this.sizeToContentHeight = z2;
    }

    public final String getResolvedUrl() {
        return this.resolvedUrl;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final boolean getSizeToContentWidth() {
        return this.sizeToContentWidth;
    }

    public final boolean getSizeToContentHeight() {
        return this.sizeToContentHeight;
    }
}
