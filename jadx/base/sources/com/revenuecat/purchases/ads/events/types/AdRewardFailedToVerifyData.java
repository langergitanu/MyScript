package com.revenuecat.purchases.ads.events.types;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdRewardFailedToVerifyData.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0019\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRewardFailedToVerifyData;", "", "networkName", "", "mediatorName", "Lcom/revenuecat/purchases/ads/events/types/AdMediatorName;", "adFormat", "Lcom/revenuecat/purchases/ads/events/types/AdFormat;", "placement", "adUnitId", "impressionId", "failureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdFormat-y0COY5Q", "()Ljava/lang/String;", "Ljava/lang/String;", "getAdUnitId", "getFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getImpressionId", "getMediatorName-GyoM_N4", "getNetworkName", "getPlacement", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class AdRewardFailedToVerifyData {
    private final String adFormat;
    private final String adUnitId;
    private final AdRewardFailureReason failureReason;
    private final String impressionId;
    private final String mediatorName;
    private final String networkName;
    private final String placement;

    public /* synthetic */ AdRewardFailedToVerifyData(String str, String str2, String str3, String str4, String str5, String str6, AdRewardFailureReason adRewardFailureReason, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, adRewardFailureReason);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdRewardFailedToVerifyData)) {
            return false;
        }
        AdRewardFailedToVerifyData adRewardFailedToVerifyData = (AdRewardFailedToVerifyData) obj;
        return Intrinsics.areEqual(this.networkName, adRewardFailedToVerifyData.networkName) && AdMediatorName.m13674equalsimpl0(this.mediatorName, adRewardFailedToVerifyData.mediatorName) && AdFormat.m13657equalsimpl0(this.adFormat, adRewardFailedToVerifyData.adFormat) && Intrinsics.areEqual(this.placement, adRewardFailedToVerifyData.placement) && Intrinsics.areEqual(this.adUnitId, adRewardFailedToVerifyData.adUnitId) && Intrinsics.areEqual(this.impressionId, adRewardFailedToVerifyData.impressionId) && Intrinsics.areEqual(this.failureReason, adRewardFailedToVerifyData.failureReason);
    }

    public int hashCode() {
        String str = this.networkName;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + AdMediatorName.m13675hashCodeimpl(this.mediatorName)) * 31) + AdFormat.m13658hashCodeimpl(this.adFormat)) * 31;
        String str2 = this.placement;
        return ((((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.adUnitId.hashCode()) * 31) + this.impressionId.hashCode()) * 31) + this.failureReason.hashCode();
    }

    public String toString() {
        return "AdRewardFailedToVerifyData(networkName=" + this.networkName + ", mediatorName=" + ((Object) AdMediatorName.m13676toStringimpl(this.mediatorName)) + ", adFormat=" + ((Object) AdFormat.m13659toStringimpl(this.adFormat)) + ", placement=" + this.placement + ", adUnitId=" + this.adUnitId + ", impressionId=" + this.impressionId + ", failureReason=" + this.failureReason + ')';
    }

    private AdRewardFailedToVerifyData(String str, String mediatorName, String adFormat, String str2, String adUnitId, String impressionId, AdRewardFailureReason failureReason) {
        Intrinsics.checkNotNullParameter(mediatorName, "mediatorName");
        Intrinsics.checkNotNullParameter(adFormat, "adFormat");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(failureReason, "failureReason");
        this.networkName = str;
        this.mediatorName = mediatorName;
        this.adFormat = adFormat;
        this.placement = str2;
        this.adUnitId = adUnitId;
        this.impressionId = impressionId;
        this.failureReason = failureReason;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    /* JADX INFO: renamed from: getMediatorName-GyoM_N4, reason: not valid java name and from getter */
    public final String getMediatorName() {
        return this.mediatorName;
    }

    /* JADX INFO: renamed from: getAdFormat-y0COY5Q, reason: not valid java name and from getter */
    public final String getAdFormat() {
        return this.adFormat;
    }

    public final String getPlacement() {
        return this.placement;
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final String getImpressionId() {
        return this.impressionId;
    }

    public final AdRewardFailureReason getFailureReason() {
        return this.failureReason;
    }
}
