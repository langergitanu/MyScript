package com.survicate.surveys.core.targeting.displayfilter.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventTriggerProperty.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerProperty;", "", "name", "", "value", "propertyOperator", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerPropertyOperator;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerPropertyOperator;)V", "getName", "()Ljava/lang/String;", "getValue", "getPropertyOperator", "()Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerPropertyOperator;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class EventTriggerProperty {
    private final String name;
    private final EventTriggerPropertyOperator propertyOperator;
    private final String value;

    public static /* synthetic */ EventTriggerProperty copy$default(EventTriggerProperty eventTriggerProperty, String str, String str2, EventTriggerPropertyOperator eventTriggerPropertyOperator, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventTriggerProperty.name;
        }
        if ((i & 2) != 0) {
            str2 = eventTriggerProperty.value;
        }
        if ((i & 4) != 0) {
            eventTriggerPropertyOperator = eventTriggerProperty.propertyOperator;
        }
        return eventTriggerProperty.copy(str, str2, eventTriggerPropertyOperator);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final EventTriggerPropertyOperator getPropertyOperator() {
        return this.propertyOperator;
    }

    public final EventTriggerProperty copy(String name, String value, EventTriggerPropertyOperator propertyOperator) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(propertyOperator, "propertyOperator");
        return new EventTriggerProperty(name, value, propertyOperator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTriggerProperty)) {
            return false;
        }
        EventTriggerProperty eventTriggerProperty = (EventTriggerProperty) other;
        return Intrinsics.areEqual(this.name, eventTriggerProperty.name) && Intrinsics.areEqual(this.value, eventTriggerProperty.value) && this.propertyOperator == eventTriggerProperty.propertyOperator;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + this.propertyOperator.hashCode();
    }

    public String toString() {
        return "EventTriggerProperty(name=" + this.name + ", value=" + this.value + ", propertyOperator=" + this.propertyOperator + ')';
    }

    public EventTriggerProperty(String name, String value, EventTriggerPropertyOperator propertyOperator) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(propertyOperator, "propertyOperator");
        this.name = name;
        this.value = value;
        this.propertyOperator = propertyOperator;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final EventTriggerPropertyOperator getPropertyOperator() {
        return this.propertyOperator;
    }
}
