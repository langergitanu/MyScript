package com.android.billingclient.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.android.billingclient:billing-ktx@@8.3.0 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Lcom/android/billingclient/api/CreateExternalOfferReportingDetailsResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "externalOfferReportingDetails", "Lcom/android/billingclient/api/ExternalOfferReportingDetails;", "<init>", "(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/ExternalOfferReportingDetails;)V", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "getExternalOfferReportingDetails", "()Lcom/android/billingclient/api/ExternalOfferReportingDetails;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, m1600k = 1, m1601mv = {2, 2, 0}, m1603xi = 48)
public final /* data */ class CreateExternalOfferReportingDetailsResult {
    private final BillingResult zza;
    private final ExternalOfferReportingDetails zzb;

    public CreateExternalOfferReportingDetailsResult(BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.zza = billingResult;
        this.zzb = externalOfferReportingDetails;
    }

    public static /* synthetic */ CreateExternalOfferReportingDetailsResult copy$default(CreateExternalOfferReportingDetailsResult createExternalOfferReportingDetailsResult, BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            billingResult = createExternalOfferReportingDetailsResult.zza;
        }
        if ((i & 2) != 0) {
            externalOfferReportingDetails = createExternalOfferReportingDetailsResult.zzb;
        }
        return createExternalOfferReportingDetailsResult.copy(billingResult, externalOfferReportingDetails);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BillingResult getZza() {
        return this.zza;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ExternalOfferReportingDetails getZzb() {
        return this.zzb;
    }

    public final CreateExternalOfferReportingDetailsResult copy(BillingResult billingResult, ExternalOfferReportingDetails externalOfferReportingDetails) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        return new CreateExternalOfferReportingDetailsResult(billingResult, externalOfferReportingDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreateExternalOfferReportingDetailsResult)) {
            return false;
        }
        CreateExternalOfferReportingDetailsResult createExternalOfferReportingDetailsResult = (CreateExternalOfferReportingDetailsResult) other;
        return Intrinsics.areEqual(this.zza, createExternalOfferReportingDetailsResult.zza) && Intrinsics.areEqual(this.zzb, createExternalOfferReportingDetailsResult.zzb);
    }

    public final BillingResult getBillingResult() {
        return this.zza;
    }

    public final ExternalOfferReportingDetails getExternalOfferReportingDetails() {
        return this.zzb;
    }

    public int hashCode() {
        int iHashCode = this.zza.hashCode() * 31;
        ExternalOfferReportingDetails externalOfferReportingDetails = this.zzb;
        return iHashCode + (externalOfferReportingDetails == null ? 0 : externalOfferReportingDetails.hashCode());
    }

    public String toString() {
        return "CreateExternalOfferReportingDetailsResult(billingResult=" + this.zza + ", externalOfferReportingDetails=" + this.zzb + ")";
    }
}
