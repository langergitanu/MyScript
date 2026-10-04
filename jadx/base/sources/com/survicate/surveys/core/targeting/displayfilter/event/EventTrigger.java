package com.survicate.surveys.core.targeting.displayfilter.event;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventTrigger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003J7\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTrigger;", "", "name", "", "relation", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerRelation;", DiagnosticsEntry.PROPERTIES_KEY, "", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerProperty;", "settings", "Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerSettings;", "<init>", "(Ljava/lang/String;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerRelation;Ljava/util/List;Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerSettings;)V", "getName", "()Ljava/lang/String;", "getRelation", "()Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerRelation;", "getProperties", "()Ljava/util/List;", "getSettings", "()Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerSettings;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class EventTrigger {
    private final String name;
    private final List<EventTriggerProperty> properties;
    private final EventTriggerRelation relation;
    private final EventTriggerSettings settings;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventTrigger copy$default(EventTrigger eventTrigger, String str, EventTriggerRelation eventTriggerRelation, List list, EventTriggerSettings eventTriggerSettings, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventTrigger.name;
        }
        if ((i & 2) != 0) {
            eventTriggerRelation = eventTrigger.relation;
        }
        if ((i & 4) != 0) {
            list = eventTrigger.properties;
        }
        if ((i & 8) != 0) {
            eventTriggerSettings = eventTrigger.settings;
        }
        return eventTrigger.copy(str, eventTriggerRelation, list, eventTriggerSettings);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EventTriggerRelation getRelation() {
        return this.relation;
    }

    public final List<EventTriggerProperty> component3() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final EventTriggerSettings getSettings() {
        return this.settings;
    }

    public final EventTrigger copy(String name, EventTriggerRelation relation, List<EventTriggerProperty> properties, EventTriggerSettings settings) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new EventTrigger(name, relation, properties, settings);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTrigger)) {
            return false;
        }
        EventTrigger eventTrigger = (EventTrigger) other;
        return Intrinsics.areEqual(this.name, eventTrigger.name) && this.relation == eventTrigger.relation && Intrinsics.areEqual(this.properties, eventTrigger.properties) && Intrinsics.areEqual(this.settings, eventTrigger.settings);
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.relation.hashCode()) * 31) + this.properties.hashCode()) * 31) + this.settings.hashCode();
    }

    public String toString() {
        return "EventTrigger(name=" + this.name + ", relation=" + this.relation + ", properties=" + this.properties + ", settings=" + this.settings + ')';
    }

    public EventTrigger(String name, EventTriggerRelation relation, List<EventTriggerProperty> properties, EventTriggerSettings settings) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.name = name;
        this.relation = relation;
        this.properties = properties;
        this.settings = settings;
    }

    public final String getName() {
        return this.name;
    }

    public final EventTriggerRelation getRelation() {
        return this.relation;
    }

    public final List<EventTriggerProperty> getProperties() {
        return this.properties;
    }

    public final EventTriggerSettings getSettings() {
        return this.settings;
    }
}
