package com.myscript.nebo.purchase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RenewalOfferEvaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/purchase/RenewalOfferEvaluation;", "", "persisted", "Lcom/myscript/nebo/purchase/RenewalOfferPersistedState;", "offerActive", "", "windowEndsAtMs", "", "<init>", "(Lcom/myscript/nebo/purchase/RenewalOfferPersistedState;ZJ)V", "getPersisted", "()Lcom/myscript/nebo/purchase/RenewalOfferPersistedState;", "getOfferActive", "()Z", "getWindowEndsAtMs", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class RenewalOfferEvaluation {
    public static final int $stable = 0;
    private final boolean offerActive;
    private final RenewalOfferPersistedState persisted;
    private final long windowEndsAtMs;

    public static /* synthetic */ RenewalOfferEvaluation copy$default(RenewalOfferEvaluation renewalOfferEvaluation, RenewalOfferPersistedState renewalOfferPersistedState, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            renewalOfferPersistedState = renewalOfferEvaluation.persisted;
        }
        if ((i & 2) != 0) {
            z = renewalOfferEvaluation.offerActive;
        }
        if ((i & 4) != 0) {
            j = renewalOfferEvaluation.windowEndsAtMs;
        }
        return renewalOfferEvaluation.copy(renewalOfferPersistedState, z, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RenewalOfferPersistedState getPersisted() {
        return this.persisted;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getOfferActive() {
        return this.offerActive;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getWindowEndsAtMs() {
        return this.windowEndsAtMs;
    }

    public final RenewalOfferEvaluation copy(RenewalOfferPersistedState persisted, boolean offerActive, long windowEndsAtMs) {
        Intrinsics.checkNotNullParameter(persisted, "persisted");
        return new RenewalOfferEvaluation(persisted, offerActive, windowEndsAtMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenewalOfferEvaluation)) {
            return false;
        }
        RenewalOfferEvaluation renewalOfferEvaluation = (RenewalOfferEvaluation) other;
        return Intrinsics.areEqual(this.persisted, renewalOfferEvaluation.persisted) && this.offerActive == renewalOfferEvaluation.offerActive && this.windowEndsAtMs == renewalOfferEvaluation.windowEndsAtMs;
    }

    public int hashCode() {
        return (((this.persisted.hashCode() * 31) + Boolean.hashCode(this.offerActive)) * 31) + Long.hashCode(this.windowEndsAtMs);
    }

    public String toString() {
        return "RenewalOfferEvaluation(persisted=" + this.persisted + ", offerActive=" + this.offerActive + ", windowEndsAtMs=" + this.windowEndsAtMs + ")";
    }

    public RenewalOfferEvaluation(RenewalOfferPersistedState persisted, boolean z, long j) {
        Intrinsics.checkNotNullParameter(persisted, "persisted");
        this.persisted = persisted;
        this.offerActive = z;
        this.windowEndsAtMs = j;
    }

    public final RenewalOfferPersistedState getPersisted() {
        return this.persisted;
    }

    public final boolean getOfferActive() {
        return this.offerActive;
    }

    public final long getWindowEndsAtMs() {
        return this.windowEndsAtMs;
    }
}
