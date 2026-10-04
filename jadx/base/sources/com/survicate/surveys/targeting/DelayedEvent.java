package com.survicate.surveys.targeting;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventDelayTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/survicate/surveys/targeting/DelayedEvent;", "", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "surveyId", "", "expectedDelayMs", "", "<init>", "(Lcom/survicate/surveys/targeting/ActiveEvent;Ljava/lang/String;J)V", "getActiveEvent", "()Lcom/survicate/surveys/targeting/ActiveEvent;", "getSurveyId", "()Ljava/lang/String;", "getExpectedDelayMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final /* data */ class DelayedEvent {
    private final ActiveEvent activeEvent;
    private final long expectedDelayMs;
    private final String surveyId;

    public static /* synthetic */ DelayedEvent copy$default(DelayedEvent delayedEvent, ActiveEvent activeEvent, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            activeEvent = delayedEvent.activeEvent;
        }
        if ((i & 2) != 0) {
            str = delayedEvent.surveyId;
        }
        if ((i & 4) != 0) {
            j = delayedEvent.expectedDelayMs;
        }
        return delayedEvent.copy(activeEvent, str, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ActiveEvent getActiveEvent() {
        return this.activeEvent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSurveyId() {
        return this.surveyId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getExpectedDelayMs() {
        return this.expectedDelayMs;
    }

    public final DelayedEvent copy(ActiveEvent activeEvent, String surveyId, long expectedDelayMs) {
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        return new DelayedEvent(activeEvent, surveyId, expectedDelayMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DelayedEvent)) {
            return false;
        }
        DelayedEvent delayedEvent = (DelayedEvent) other;
        return Intrinsics.areEqual(this.activeEvent, delayedEvent.activeEvent) && Intrinsics.areEqual(this.surveyId, delayedEvent.surveyId) && this.expectedDelayMs == delayedEvent.expectedDelayMs;
    }

    public int hashCode() {
        return (((this.activeEvent.hashCode() * 31) + this.surveyId.hashCode()) * 31) + Long.hashCode(this.expectedDelayMs);
    }

    public String toString() {
        return "DelayedEvent(activeEvent=" + this.activeEvent + ", surveyId=" + this.surveyId + ", expectedDelayMs=" + this.expectedDelayMs + ')';
    }

    public DelayedEvent(ActiveEvent activeEvent, String surveyId, long j) {
        Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        this.activeEvent = activeEvent;
        this.surveyId = surveyId;
        this.expectedDelayMs = j;
    }

    public final ActiveEvent getActiveEvent() {
        return this.activeEvent;
    }

    public final String getSurveyId() {
        return this.surveyId;
    }

    public final long getExpectedDelayMs() {
        return this.expectedDelayMs;
    }
}
