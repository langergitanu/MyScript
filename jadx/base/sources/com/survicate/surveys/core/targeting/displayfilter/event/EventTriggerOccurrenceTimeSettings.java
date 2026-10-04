package com.survicate.surveys.core.targeting.displayfilter.event;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventTriggerSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J4\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;", "", "periodMs", "", "dates", "", "", "operator", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeOperator;", "<init>", "(Ljava/lang/Long;Ljava/util/List;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeOperator;)V", "getPeriodMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDates", "()Ljava/util/List;", "getOperator", "()Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeOperator;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/util/List;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeOperator;)Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeSettings;", "equals", "", "other", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class EventTriggerOccurrenceTimeSettings {
    private final List<String> dates;
    private final EventTriggerOccurrenceTimeOperator operator;
    private final Long periodMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTriggerOccurrenceTimeSettings copy$default(EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, Long l, List list, EventTriggerOccurrenceTimeOperator eventTriggerOccurrenceTimeOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            l = eventTriggerOccurrenceTimeSettings.periodMs;
        }
        if ((i & 2) != 0) {
            list = eventTriggerOccurrenceTimeSettings.dates;
        }
        if ((i & 4) != 0) {
            eventTriggerOccurrenceTimeOperator = eventTriggerOccurrenceTimeSettings.operator;
        }
        return eventTriggerOccurrenceTimeSettings.copy(l, list, eventTriggerOccurrenceTimeOperator);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getPeriodMs() {
        return this.periodMs;
    }

    public final List<String> component2() {
        return this.dates;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EventTriggerOccurrenceTimeOperator getOperator() {
        return this.operator;
    }

    public final EventTriggerOccurrenceTimeSettings copy(Long periodMs, List<String> dates, EventTriggerOccurrenceTimeOperator operator) {
        Intrinsics.checkNotNullParameter(dates, "dates");
        Intrinsics.checkNotNullParameter(operator, "operator");
        return new EventTriggerOccurrenceTimeSettings(periodMs, dates, operator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTriggerOccurrenceTimeSettings)) {
            return false;
        }
        EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings = (EventTriggerOccurrenceTimeSettings) other;
        return Intrinsics.areEqual(this.periodMs, eventTriggerOccurrenceTimeSettings.periodMs) && Intrinsics.areEqual(this.dates, eventTriggerOccurrenceTimeSettings.dates) && this.operator == eventTriggerOccurrenceTimeSettings.operator;
    }

    public int hashCode() {
        Long l = this.periodMs;
        return ((((l == null ? 0 : l.hashCode()) * 31) + this.dates.hashCode()) * 31) + this.operator.hashCode();
    }

    public String toString() {
        return "EventTriggerOccurrenceTimeSettings(periodMs=" + this.periodMs + ", dates=" + this.dates + ", operator=" + this.operator + ')';
    }

    public EventTriggerOccurrenceTimeSettings(Long l, List<String> dates, EventTriggerOccurrenceTimeOperator operator) {
        Intrinsics.checkNotNullParameter(dates, "dates");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.periodMs = l;
        this.dates = dates;
        this.operator = operator;
    }

    public final Long getPeriodMs() {
        return this.periodMs;
    }

    public final List<String> getDates() {
        return this.dates;
    }

    public final EventTriggerOccurrenceTimeOperator getOperator() {
        return this.operator;
    }
}
