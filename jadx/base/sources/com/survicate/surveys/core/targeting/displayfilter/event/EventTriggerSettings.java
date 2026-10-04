package com.survicate.surveys.core.targeting.displayfilter.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventTriggerSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerSettings;", "", "delayMs", "", "occurrences", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountSettings;", "firstOccurrence", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;", "lastOccurrence", "<init>", "(Ljava/lang/Long;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountSettings;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;)V", "getDelayMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOccurrences", "()Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountSettings;", "getFirstOccurrence", "()Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;", "getLastOccurrence", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountSettings;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;)Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerSettings;", "equals", "", "other", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class EventTriggerSettings {
    private final Long delayMs;
    private final EventTriggerOccurrenceTimeSettings firstOccurrence;
    private final EventTriggerOccurrenceTimeSettings lastOccurrence;
    private final EventTriggerOccurrenceCountSettings occurrences;

    public EventTriggerSettings() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ EventTriggerSettings copy$default(EventTriggerSettings eventTriggerSettings, Long l, EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = eventTriggerSettings.delayMs;
        }
        if ((i & 2) != 0) {
            eventTriggerOccurrenceCountSettings = eventTriggerSettings.occurrences;
        }
        if ((i & 4) != 0) {
            eventTriggerOccurrenceTimeSettings = eventTriggerSettings.firstOccurrence;
        }
        if ((i & 8) != 0) {
            eventTriggerOccurrenceTimeSettings2 = eventTriggerSettings.lastOccurrence;
        }
        return eventTriggerSettings.copy(l, eventTriggerOccurrenceCountSettings, eventTriggerOccurrenceTimeSettings, eventTriggerOccurrenceTimeSettings2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getDelayMs() {
        return this.delayMs;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EventTriggerOccurrenceCountSettings getOccurrences() {
        return this.occurrences;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EventTriggerOccurrenceTimeSettings getFirstOccurrence() {
        return this.firstOccurrence;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final EventTriggerOccurrenceTimeSettings getLastOccurrence() {
        return this.lastOccurrence;
    }

    public final EventTriggerSettings copy(Long delayMs, EventTriggerOccurrenceCountSettings occurrences, EventTriggerOccurrenceTimeSettings firstOccurrence, EventTriggerOccurrenceTimeSettings lastOccurrence) {
        return new EventTriggerSettings(delayMs, occurrences, firstOccurrence, lastOccurrence);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTriggerSettings)) {
            return false;
        }
        EventTriggerSettings eventTriggerSettings = (EventTriggerSettings) other;
        return Intrinsics.areEqual(this.delayMs, eventTriggerSettings.delayMs) && Intrinsics.areEqual(this.occurrences, eventTriggerSettings.occurrences) && Intrinsics.areEqual(this.firstOccurrence, eventTriggerSettings.firstOccurrence) && Intrinsics.areEqual(this.lastOccurrence, eventTriggerSettings.lastOccurrence);
    }

    public int hashCode() {
        Long l = this.delayMs;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings = this.occurrences;
        int iHashCode2 = (iHashCode + (eventTriggerOccurrenceCountSettings == null ? 0 : eventTriggerOccurrenceCountSettings.hashCode())) * 31;
        EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings = this.firstOccurrence;
        int iHashCode3 = (iHashCode2 + (eventTriggerOccurrenceTimeSettings == null ? 0 : eventTriggerOccurrenceTimeSettings.hashCode())) * 31;
        EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2 = this.lastOccurrence;
        return iHashCode3 + (eventTriggerOccurrenceTimeSettings2 != null ? eventTriggerOccurrenceTimeSettings2.hashCode() : 0);
    }

    public String toString() {
        return "EventTriggerSettings(delayMs=" + this.delayMs + ", occurrences=" + this.occurrences + ", firstOccurrence=" + this.firstOccurrence + ", lastOccurrence=" + this.lastOccurrence + ')';
    }

    public EventTriggerSettings(Long l, EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2) {
        this.delayMs = l;
        this.occurrences = eventTriggerOccurrenceCountSettings;
        this.firstOccurrence = eventTriggerOccurrenceTimeSettings;
        this.lastOccurrence = eventTriggerOccurrenceTimeSettings2;
    }

    public /* synthetic */ EventTriggerSettings(Long l, EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : eventTriggerOccurrenceCountSettings, (i & 4) != 0 ? null : eventTriggerOccurrenceTimeSettings, (i & 8) != 0 ? null : eventTriggerOccurrenceTimeSettings2);
    }

    public final Long getDelayMs() {
        return this.delayMs;
    }

    public final EventTriggerOccurrenceCountSettings getOccurrences() {
        return this.occurrences;
    }

    public final EventTriggerOccurrenceTimeSettings getFirstOccurrence() {
        return this.firstOccurrence;
    }

    public final EventTriggerOccurrenceTimeSettings getLastOccurrence() {
        return this.lastOccurrence;
    }
}
