package com.revenuecat.purchases.p036ui.revenuecatui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallPreviewPresenter.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/PreviewLinkParams;", "", "offeringId", "", "paywallId", "(Ljava/lang/String;Ljava/lang/String;)V", "getOfferingId", "()Ljava/lang/String;", "getPaywallId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
final /* data */ class PreviewLinkParams {
    private final String offeringId;
    private final String paywallId;

    public static /* synthetic */ PreviewLinkParams copy$default(PreviewLinkParams previewLinkParams, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = previewLinkParams.offeringId;
        }
        if ((i & 2) != 0) {
            str2 = previewLinkParams.paywallId;
        }
        return previewLinkParams.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOfferingId() {
        return this.offeringId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPaywallId() {
        return this.paywallId;
    }

    public final PreviewLinkParams copy(String offeringId, String paywallId) {
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        Intrinsics.checkNotNullParameter(paywallId, "paywallId");
        return new PreviewLinkParams(offeringId, paywallId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreviewLinkParams)) {
            return false;
        }
        PreviewLinkParams previewLinkParams = (PreviewLinkParams) other;
        return Intrinsics.areEqual(this.offeringId, previewLinkParams.offeringId) && Intrinsics.areEqual(this.paywallId, previewLinkParams.paywallId);
    }

    public int hashCode() {
        return (this.offeringId.hashCode() * 31) + this.paywallId.hashCode();
    }

    public String toString() {
        return "PreviewLinkParams(offeringId=" + this.offeringId + ", paywallId=" + this.paywallId + ')';
    }

    public PreviewLinkParams(String offeringId, String paywallId) {
        Intrinsics.checkNotNullParameter(offeringId, "offeringId");
        Intrinsics.checkNotNullParameter(paywallId, "paywallId");
        this.offeringId = offeringId;
        this.paywallId = paywallId;
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final String getPaywallId() {
        return this.paywallId;
    }
}
