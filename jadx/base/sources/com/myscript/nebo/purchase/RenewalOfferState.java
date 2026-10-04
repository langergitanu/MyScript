package com.myscript.nebo.purchase;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/purchase/RenewalOfferState;", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "endsAtMs", "", "<init>", "(ZJ)V", "getActive", "()Z", "getEndsAtMs", "()J", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class RenewalOfferState {
    public static final int $stable = 0;
    private final boolean active;
    private final long endsAtMs;

    public RenewalOfferState() {
        this(false, 0L, 3, null);
    }

    public static /* synthetic */ RenewalOfferState copy$default(RenewalOfferState renewalOfferState, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = renewalOfferState.active;
        }
        if ((i & 2) != 0) {
            j = renewalOfferState.endsAtMs;
        }
        return renewalOfferState.copy(z, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getActive() {
        return this.active;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getEndsAtMs() {
        return this.endsAtMs;
    }

    public final RenewalOfferState copy(boolean active, long endsAtMs) {
        return new RenewalOfferState(active, endsAtMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenewalOfferState)) {
            return false;
        }
        RenewalOfferState renewalOfferState = (RenewalOfferState) other;
        return this.active == renewalOfferState.active && this.endsAtMs == renewalOfferState.endsAtMs;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.active) * 31) + Long.hashCode(this.endsAtMs);
    }

    public String toString() {
        return "RenewalOfferState(active=" + this.active + ", endsAtMs=" + this.endsAtMs + ")";
    }

    public RenewalOfferState(boolean z, long j) {
        this.active = z;
        this.endsAtMs = j;
    }

    public /* synthetic */ RenewalOfferState(boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j);
    }

    public final boolean getActive() {
        return this.active;
    }

    public final long getEndsAtMs() {
        return this.endsAtMs;
    }
}
