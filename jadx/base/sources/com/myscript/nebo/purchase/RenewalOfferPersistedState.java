package com.myscript.nebo.purchase;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RenewalOfferEvaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/purchase/RenewalOfferPersistedState;", "", "windowStartMs", "", "handledExpirationMs", "<init>", "(JJ)V", "getWindowStartMs", "()J", "getHandledExpirationMs", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class RenewalOfferPersistedState {
    public static final int $stable = 0;
    private final long handledExpirationMs;
    private final long windowStartMs;

    public RenewalOfferPersistedState() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ RenewalOfferPersistedState copy$default(RenewalOfferPersistedState renewalOfferPersistedState, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = renewalOfferPersistedState.windowStartMs;
        }
        if ((i & 2) != 0) {
            j2 = renewalOfferPersistedState.handledExpirationMs;
        }
        return renewalOfferPersistedState.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getWindowStartMs() {
        return this.windowStartMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getHandledExpirationMs() {
        return this.handledExpirationMs;
    }

    public final RenewalOfferPersistedState copy(long windowStartMs, long handledExpirationMs) {
        return new RenewalOfferPersistedState(windowStartMs, handledExpirationMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RenewalOfferPersistedState)) {
            return false;
        }
        RenewalOfferPersistedState renewalOfferPersistedState = (RenewalOfferPersistedState) other;
        return this.windowStartMs == renewalOfferPersistedState.windowStartMs && this.handledExpirationMs == renewalOfferPersistedState.handledExpirationMs;
    }

    public int hashCode() {
        return (Long.hashCode(this.windowStartMs) * 31) + Long.hashCode(this.handledExpirationMs);
    }

    public String toString() {
        return "RenewalOfferPersistedState(windowStartMs=" + this.windowStartMs + ", handledExpirationMs=" + this.handledExpirationMs + ")";
    }

    public RenewalOfferPersistedState(long j, long j2) {
        this.windowStartMs = j;
        this.handledExpirationMs = j2;
    }

    public /* synthetic */ RenewalOfferPersistedState(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public final long getWindowStartMs() {
        return this.windowStartMs;
    }

    public final long getHandledExpirationMs() {
        return this.handledExpirationMs;
    }
}
