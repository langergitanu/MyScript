package com.survicate.surveys.entities.models;

import com.survicate.surveys.targeting.ActiveEvent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: ActiveEventHistory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tB=\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J1\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0015¨\u0006."}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "", "eventName", "", "occurrenceCount", "", "firstOccurrenceMs", "lastOccurrenceMs", "<init>", "(Ljava/lang/String;JJJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEventName$annotations", "()V", "getEventName", "()Ljava/lang/String;", "getOccurrenceCount$annotations", "getOccurrenceCount", "()J", "getFirstOccurrenceMs$annotations", "getFirstOccurrenceMs", "getLastOccurrenceMs$annotations", "getLastOccurrenceMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "Companion", "$serializer", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class ActiveEventHistory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String eventName;
    private final long firstOccurrenceMs;
    private final long lastOccurrenceMs;
    private final long occurrenceCount;

    public static /* synthetic */ ActiveEventHistory copy$default(ActiveEventHistory activeEventHistory, String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activeEventHistory.eventName;
        }
        if ((i & 2) != 0) {
            j = activeEventHistory.occurrenceCount;
        }
        if ((i & 4) != 0) {
            j2 = activeEventHistory.firstOccurrenceMs;
        }
        if ((i & 8) != 0) {
            j3 = activeEventHistory.lastOccurrenceMs;
        }
        long j4 = j3;
        return activeEventHistory.copy(str, j, j2, j4);
    }

    @SerialName("event_name")
    public static /* synthetic */ void getEventName$annotations() {
    }

    @SerialName("first_occurrence_ms")
    public static /* synthetic */ void getFirstOccurrenceMs$annotations() {
    }

    @SerialName("last_occurrence_ms")
    public static /* synthetic */ void getLastOccurrenceMs$annotations() {
    }

    @SerialName("occurrence_count")
    public static /* synthetic */ void getOccurrenceCount$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getOccurrenceCount() {
        return this.occurrenceCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getFirstOccurrenceMs() {
        return this.firstOccurrenceMs;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getLastOccurrenceMs() {
        return this.lastOccurrenceMs;
    }

    public final ActiveEventHistory copy(String eventName, long occurrenceCount, long firstOccurrenceMs, long lastOccurrenceMs) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new ActiveEventHistory(eventName, occurrenceCount, firstOccurrenceMs, lastOccurrenceMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveEventHistory)) {
            return false;
        }
        ActiveEventHistory activeEventHistory = (ActiveEventHistory) other;
        return Intrinsics.areEqual(this.eventName, activeEventHistory.eventName) && this.occurrenceCount == activeEventHistory.occurrenceCount && this.firstOccurrenceMs == activeEventHistory.firstOccurrenceMs && this.lastOccurrenceMs == activeEventHistory.lastOccurrenceMs;
    }

    public int hashCode() {
        return (((((this.eventName.hashCode() * 31) + Long.hashCode(this.occurrenceCount)) * 31) + Long.hashCode(this.firstOccurrenceMs)) * 31) + Long.hashCode(this.lastOccurrenceMs);
    }

    public String toString() {
        return "ActiveEventHistory(eventName=" + this.eventName + ", occurrenceCount=" + this.occurrenceCount + ", firstOccurrenceMs=" + this.firstOccurrenceMs + ", lastOccurrenceMs=" + this.lastOccurrenceMs + ')';
    }

    public /* synthetic */ ActiveEventHistory(int i, String str, long j, long j2, long j3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, ActiveEventHistory$$serializer.INSTANCE.getDescriptor());
        }
        this.eventName = str;
        this.occurrenceCount = j;
        this.firstOccurrenceMs = j2;
        this.lastOccurrenceMs = j3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(ActiveEventHistory self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.eventName);
        output.encodeLongElement(serialDesc, 1, self.occurrenceCount);
        output.encodeLongElement(serialDesc, 2, self.firstOccurrenceMs);
        output.encodeLongElement(serialDesc, 3, self.lastOccurrenceMs);
    }

    public ActiveEventHistory(String eventName, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.eventName = eventName;
        this.occurrenceCount = j;
        this.firstOccurrenceMs = j2;
        this.lastOccurrenceMs = j3;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final long getOccurrenceCount() {
        return this.occurrenceCount;
    }

    public final long getFirstOccurrenceMs() {
        return this.firstOccurrenceMs;
    }

    public final long getLastOccurrenceMs() {
        return this.lastOccurrenceMs;
    }

    /* JADX INFO: compiled from: ActiveEventHistory.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/entities/models/ActiveEventHistory$Companion;", "", "<init>", "()V", "fromActiveEvent", "Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "serializer", "Lkotlinx/serialization/KSerializer;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ActiveEventHistory> serializer() {
            return ActiveEventHistory$$serializer.INSTANCE;
        }

        public final ActiveEventHistory fromActiveEvent(ActiveEvent activeEvent) {
            Intrinsics.checkNotNullParameter(activeEvent, "activeEvent");
            return new ActiveEventHistory(activeEvent.getName(), 1L, activeEvent.getInvokeTimeMs(), activeEvent.getInvokeTimeMs());
        }
    }
}
