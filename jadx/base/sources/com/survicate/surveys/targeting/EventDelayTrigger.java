package com.survicate.surveys.targeting;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventDelayTargeting.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/targeting/EventDelayTrigger;", "", "eventName", "", "surveyId", "delayMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getEventName", "()Ljava/lang/String;", "getSurveyId", "getDelayMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class EventDelayTrigger {
    private final long delayMs;
    private final String eventName;
    private final String surveyId;

    public static /* synthetic */ EventDelayTrigger copy$default(EventDelayTrigger eventDelayTrigger, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventDelayTrigger.eventName;
        }
        if ((i & 2) != 0) {
            str2 = eventDelayTrigger.surveyId;
        }
        if ((i & 4) != 0) {
            j = eventDelayTrigger.delayMs;
        }
        return eventDelayTrigger.copy(str, str2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSurveyId() {
        return this.surveyId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getDelayMs() {
        return this.delayMs;
    }

    public final EventDelayTrigger copy(String eventName, String surveyId, long delayMs) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        return new EventDelayTrigger(eventName, surveyId, delayMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventDelayTrigger)) {
            return false;
        }
        EventDelayTrigger eventDelayTrigger = (EventDelayTrigger) other;
        return Intrinsics.areEqual(this.eventName, eventDelayTrigger.eventName) && Intrinsics.areEqual(this.surveyId, eventDelayTrigger.surveyId) && this.delayMs == eventDelayTrigger.delayMs;
    }

    public int hashCode() {
        return (((this.eventName.hashCode() * 31) + this.surveyId.hashCode()) * 31) + Long.hashCode(this.delayMs);
    }

    public String toString() {
        return "EventDelayTrigger(eventName=" + this.eventName + ", surveyId=" + this.surveyId + ", delayMs=" + this.delayMs + ')';
    }

    public EventDelayTrigger(String eventName, String surveyId, long j) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        this.eventName = eventName;
        this.surveyId = surveyId;
        this.delayMs = j;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final String getSurveyId() {
        return this.surveyId;
    }

    public final long getDelayMs() {
        return this.delayMs;
    }
}
