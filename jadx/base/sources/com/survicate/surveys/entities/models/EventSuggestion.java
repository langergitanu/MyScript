package com.survicate.surveys.entities.models;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.survicate.surveys.targeting.ActiveEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventSuggestion.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/EventSuggestion;", "", "name", "", DiagnosticsEntry.PROPERTIES_KEY, "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getProperties", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class EventSuggestion {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String name;
    private final List<String> properties;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventSuggestion copy$default(EventSuggestion eventSuggestion, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eventSuggestion.name;
        }
        if ((i & 2) != 0) {
            list = eventSuggestion.properties;
        }
        return eventSuggestion.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<String> component2() {
        return this.properties;
    }

    public final EventSuggestion copy(String name, List<String> properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new EventSuggestion(name, properties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventSuggestion)) {
            return false;
        }
        EventSuggestion eventSuggestion = (EventSuggestion) other;
        return Intrinsics.areEqual(this.name, eventSuggestion.name) && Intrinsics.areEqual(this.properties, eventSuggestion.properties);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.properties.hashCode();
    }

    public String toString() {
        return "EventSuggestion(name=" + this.name + ", properties=" + this.properties + ')';
    }

    public EventSuggestion(String name, List<String> properties) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.name = name;
        this.properties = properties;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getProperties() {
        return this.properties;
    }

    /* JADX INFO: compiled from: EventSuggestion.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/EventSuggestion$Companion;", "", "<init>", "()V", "fromActiveEvent", "Lcom/survicate/surveys/entities/models/EventSuggestion;", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EventSuggestion fromActiveEvent(ActiveEvent activeEvent) {
            Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
            return new EventSuggestion(activeEvent.getName(), CollectionsKt.toList(activeEvent.getProperties().keySet()));
        }
    }
}
