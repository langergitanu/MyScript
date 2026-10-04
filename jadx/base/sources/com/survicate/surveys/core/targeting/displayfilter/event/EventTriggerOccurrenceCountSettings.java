package com.survicate.surveys.core.targeting.displayfilter.event;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventTriggerSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountSettings;", "", "value", "", "", "operator", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountOperator;", "<init>", "(Ljava/util/List;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountOperator;)V", "getValue", "()Ljava/util/List;", "getOperator", "()Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountOperator;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class EventTriggerOccurrenceCountSettings {
    private final EventTriggerOccurrenceCountOperator operator;
    private final List<Long> value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTriggerOccurrenceCountSettings copy$default(EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, List list, EventTriggerOccurrenceCountOperator eventTriggerOccurrenceCountOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            list = eventTriggerOccurrenceCountSettings.value;
        }
        if ((i & 2) != 0) {
            eventTriggerOccurrenceCountOperator = eventTriggerOccurrenceCountSettings.operator;
        }
        return eventTriggerOccurrenceCountSettings.copy(list, eventTriggerOccurrenceCountOperator);
    }

    public final List<Long> component1() {
        return this.value;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EventTriggerOccurrenceCountOperator getOperator() {
        return this.operator;
    }

    public final EventTriggerOccurrenceCountSettings copy(List<Long> value, EventTriggerOccurrenceCountOperator operator) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(operator, "operator");
        return new EventTriggerOccurrenceCountSettings(value, operator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTriggerOccurrenceCountSettings)) {
            return false;
        }
        EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings = (EventTriggerOccurrenceCountSettings) other;
        return Intrinsics.areEqual(this.value, eventTriggerOccurrenceCountSettings.value) && this.operator == eventTriggerOccurrenceCountSettings.operator;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.operator.hashCode();
    }

    public String toString() {
        return "EventTriggerOccurrenceCountSettings(value=" + this.value + ", operator=" + this.operator + ')';
    }

    public EventTriggerOccurrenceCountSettings(List<Long> value, EventTriggerOccurrenceCountOperator operator) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(operator, "operator");
        this.value = value;
        this.operator = operator;
    }

    public final List<Long> getValue() {
        return this.value;
    }

    public final EventTriggerOccurrenceCountOperator getOperator() {
        return this.operator;
    }
}
