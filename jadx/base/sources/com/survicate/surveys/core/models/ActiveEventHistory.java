package com.survicate.surveys.core.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveEventHistory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, m1599d2 = {"Lcom/survicate/surveys/core/models/ActiveEventHistory;", "", "eventName", "", "occurrenceCount", "", "firstOccurrenceMs", "lastOccurrenceMs", "<init>", "(Ljava/lang/String;JJJ)V", "getEventName", "()Ljava/lang/String;", "getOccurrenceCount", "()J", "getFirstOccurrenceMs", "getLastOccurrenceMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class ActiveEventHistory {
    private final String eventName;
    private final long firstOccurrenceMs;
    private final long lastOccurrenceMs;
    private final long occurrenceCount;

    public static /* synthetic */ ActiveEventHistory copy$default(ActiveEventHistory activeEventHistory, String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activeEventHistory.eventName;
        }
        if ((i & 2) != 0) {
            j = activeEventHistory.occurrenceCount;
        }
        if ((i & 4) != 0) {
            j2 = activeEventHistory.firstOccurrenceMs;
        }
        if ((i & 8) != 0) {
            j3 = activeEventHistory.lastOccurrenceMs;
        }
        long j4 = j3;
        return activeEventHistory.copy(str, j, j2, j4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getOccurrenceCount() {
        return this.occurrenceCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getFirstOccurrenceMs() {
        return this.firstOccurrenceMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getLastOccurrenceMs() {
        return this.lastOccurrenceMs;
    }

    public final ActiveEventHistory copy(String eventName, long occurrenceCount, long firstOccurrenceMs, long lastOccurrenceMs) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new ActiveEventHistory(eventName, occurrenceCount, firstOccurrenceMs, lastOccurrenceMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveEventHistory)) {
            return false;
        }
        ActiveEventHistory activeEventHistory = (ActiveEventHistory) other;
        return Intrinsics.areEqual(this.eventName, activeEventHistory.eventName) && this.occurrenceCount == activeEventHistory.occurrenceCount && this.firstOccurrenceMs == activeEventHistory.firstOccurrenceMs && this.lastOccurrenceMs == activeEventHistory.lastOccurrenceMs;
    }

    public int hashCode() {
        return (((((this.eventName.hashCode() * 31) + Long.hashCode(this.occurrenceCount)) * 31) + Long.hashCode(this.firstOccurrenceMs)) * 31) + Long.hashCode(this.lastOccurrenceMs);
    }

    public String toString() {
        return "ActiveEventHistory(eventName=" + this.eventName + ", occurrenceCount=" + this.occurrenceCount + ", firstOccurrenceMs=" + this.firstOccurrenceMs + ", lastOccurrenceMs=" + this.lastOccurrenceMs + ')';
    }

    public ActiveEventHistory(String eventName, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.occurrenceCount = j;
        this.firstOccurrenceMs = j2;
        this.lastOccurrenceMs = j3;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final long getOccurrenceCount() {
        return this.occurrenceCount;
    }

    public final long getFirstOccurrenceMs() {
        return this.firstOccurrenceMs;
    }

    public final long getLastOccurrenceMs() {
        return this.lastOccurrenceMs;
    }
}
