package com.survicate.surveys.core.models;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveEvent.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, m1599d2 = {"Lcom/survicate/surveys/core/models/ActiveEvent;", "", "name", "", DiagnosticsEntry.PROPERTIES_KEY, "", "invokeTimeMs", "", "history", "Lcom/survicate/surveys/core/models/ActiveEventHistory;", "<init>", "(Ljava/lang/String;Ljava/util/Map;JLcom/survicate/surveys/core/models/ActiveEventHistory;)V", "getName", "()Ljava/lang/String;", "getProperties", "()Ljava/util/Map;", "getInvokeTimeMs", "()J", "getHistory", "()Lcom/survicate/surveys/core/models/ActiveEventHistory;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final /* data */ class ActiveEvent {
    private final ActiveEventHistory history;
    private final long invokeTimeMs;
    private final String name;
    private final Map<String, String> properties;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActiveEvent copy$default(ActiveEvent activeEvent, String str, Map map, long j, ActiveEventHistory activeEventHistory, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activeEvent.name;
        }
        if ((i & 2) != 0) {
            map = activeEvent.properties;
        }
        if ((i & 4) != 0) {
            j = activeEvent.invokeTimeMs;
        }
        if ((i & 8) != 0) {
            activeEventHistory = activeEvent.history;
        }
        ActiveEventHistory activeEventHistory2 = activeEventHistory;
        return activeEvent.copy(str, map, j, activeEventHistory2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final Map<String, String> component2() {
        return this.properties;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getInvokeTimeMs() {
        return this.invokeTimeMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ActiveEventHistory getHistory() {
        return this.history;
    }

    public final ActiveEvent copy(String name, Map<String, String> properties, long invokeTimeMs, ActiveEventHistory history) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new ActiveEvent(name, properties, invokeTimeMs, history);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveEvent)) {
            return false;
        }
        ActiveEvent activeEvent = (ActiveEvent) other;
        return Intrinsics.areEqual(this.name, activeEvent.name) && Intrinsics.areEqual(this.properties, activeEvent.properties) && this.invokeTimeMs == activeEvent.invokeTimeMs && Intrinsics.areEqual(this.history, activeEvent.history);
    }

    public int hashCode() {
        int iHashCode = ((((this.name.hashCode() * 31) + this.properties.hashCode()) * 31) + Long.hashCode(this.invokeTimeMs)) * 31;
        ActiveEventHistory activeEventHistory = this.history;
        return iHashCode + (activeEventHistory == null ? 0 : activeEventHistory.hashCode());
    }

    public String toString() {
        return "ActiveEvent(name=" + this.name + ", properties=" + this.properties + ", invokeTimeMs=" + this.invokeTimeMs + ", history=" + this.history + ')';
    }

    public ActiveEvent(String name, Map<String, String> properties, long j, ActiveEventHistory activeEventHistory) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.name = name;
        this.properties = properties;
        this.invokeTimeMs = j;
        this.history = activeEventHistory;
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, String> getProperties() {
        return this.properties;
    }

    public final long getInvokeTimeMs() {
        return this.invokeTimeMs;
    }

    public final ActiveEventHistory getHistory() {
        return this.history;
    }
}
