package com.revenuecat.purchases.checkpoints;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.common.events.FeatureEvent;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.Date;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointEvent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointEvent;", "Lcom/revenuecat/purchases/common/events/FeatureEvent;", Keys.IDENTIFIER, "", "id", "Ljava/util/UUID;", DiagnosticsEntry.TIMESTAMP_KEY, "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/UUID;Ljava/util/Date;)V", "getId", "()Ljava/util/UUID;", "getIdentifier", "()Ljava/lang/String;", "getTimestamp", "()Ljava/util/Date;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class CheckpointEvent implements FeatureEvent {
    private final UUID id;
    private final String identifier;
    private final Date timestamp;

    public static /* synthetic */ CheckpointEvent copy$default(CheckpointEvent checkpointEvent, String str, UUID uuid, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = checkpointEvent.identifier;
        }
        if ((i & 2) != 0) {
            uuid = checkpointEvent.id;
        }
        if ((i & 4) != 0) {
            date = checkpointEvent.timestamp;
        }
        return checkpointEvent.copy(str, uuid, date);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final UUID getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getTimestamp() {
        return this.timestamp;
    }

    public final CheckpointEvent copy(String identifier, UUID id, Date timestamp) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return new CheckpointEvent(identifier, id, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckpointEvent)) {
            return false;
        }
        CheckpointEvent checkpointEvent = (CheckpointEvent) other;
        return Intrinsics.areEqual(this.identifier, checkpointEvent.identifier) && Intrinsics.areEqual(this.id, checkpointEvent.id) && Intrinsics.areEqual(this.timestamp, checkpointEvent.timestamp);
    }

    public int hashCode() {
        return (((this.identifier.hashCode() * 31) + this.id.hashCode()) * 31) + this.timestamp.hashCode();
    }

    public String toString() {
        return "CheckpointEvent(identifier=" + this.identifier + ", id=" + this.id + ", timestamp=" + this.timestamp + ')';
    }

    public CheckpointEvent(String identifier, UUID id, Date timestamp) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        this.identifier = identifier;
        this.id = id;
        this.timestamp = timestamp;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CheckpointEvent(String str, UUID uuid, Date date, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 2) != 0) {
            uuid = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID()");
        }
        this(str, uuid, (i & 4) != 0 ? new Date() : date);
    }

    public final UUID getId() {
        return this.id;
    }

    public final Date getTimestamp() {
        return this.timestamp;
    }
}
