package com.survicate.surveys.entities.survey;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* JADX INFO: compiled from: EventTrigger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\fHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001a¨\u00063"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerSettings;", "", "delay", "", "occurrences", "Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountSettings;", "firstOccurrence", "Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;", "lastOccurrence", "<init>", "(Ljava/lang/Long;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountSettings;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountSettings;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDelay$annotations", "()V", "getDelay", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOccurrences$annotations", "getOccurrences", "()Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountSettings;", "getFirstOccurrence$annotations", "getFirstOccurrence", "()Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;", "getLastOccurrence$annotations", "getLastOccurrence", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceCountSettings;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;Lcom/survicate/surveys/entities/survey/EventTriggerOccurrenceTimeSettings;)Lcom/survicate/surveys/entities/survey/EventTriggerSettings;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$survicate_sdk_release", "$serializer", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
@Serializable
public final /* data */ class EventTriggerSettings {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long delay;
    private final EventTriggerOccurrenceTimeSettings firstOccurrence;
    private final EventTriggerOccurrenceTimeSettings lastOccurrence;
    private final EventTriggerOccurrenceCountSettings occurrences;

    public EventTriggerSettings() {
        this((Long) null, (EventTriggerOccurrenceCountSettings) null, (EventTriggerOccurrenceTimeSettings) null, (EventTriggerOccurrenceTimeSettings) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ EventTriggerSettings copy$default(EventTriggerSettings eventTriggerSettings, Long l, EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = eventTriggerSettings.delay;
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

    @SerialName("delay")
    public static /* synthetic */ void getDelay$annotations() {
    }

    @SerialName("first_occurrence")
    public static /* synthetic */ void getFirstOccurrence$annotations() {
    }

    @SerialName("last_occurrence")
    public static /* synthetic */ void getLastOccurrence$annotations() {
    }

    @SerialName("occurrences")
    public static /* synthetic */ void getOccurrences$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getDelay() {
        return this.delay;
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

    public final EventTriggerSettings copy(Long delay, EventTriggerOccurrenceCountSettings occurrences, EventTriggerOccurrenceTimeSettings firstOccurrence, EventTriggerOccurrenceTimeSettings lastOccurrence) {
        return new EventTriggerSettings(delay, occurrences, firstOccurrence, lastOccurrence);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventTriggerSettings)) {
            return false;
        }
        EventTriggerSettings eventTriggerSettings = (EventTriggerSettings) other;
        return Intrinsics.areEqual(this.delay, eventTriggerSettings.delay) && Intrinsics.areEqual(this.occurrences, eventTriggerSettings.occurrences) && Intrinsics.areEqual(this.firstOccurrence, eventTriggerSettings.firstOccurrence) && Intrinsics.areEqual(this.lastOccurrence, eventTriggerSettings.lastOccurrence);
    }

    public int hashCode() {
        Long l = this.delay;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings = this.occurrences;
        int iHashCode2 = (iHashCode + (eventTriggerOccurrenceCountSettings == null ? 0 : eventTriggerOccurrenceCountSettings.hashCode())) * 31;
        EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings = this.firstOccurrence;
        int iHashCode3 = (iHashCode2 + (eventTriggerOccurrenceTimeSettings == null ? 0 : eventTriggerOccurrenceTimeSettings.hashCode())) * 31;
        EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2 = this.lastOccurrence;
        return iHashCode3 + (eventTriggerOccurrenceTimeSettings2 != null ? eventTriggerOccurrenceTimeSettings2.hashCode() : 0);
    }

    public String toString() {
        return "EventTriggerSettings(delay=" + this.delay + ", occurrences=" + this.occurrences + ", firstOccurrence=" + this.firstOccurrence + ", lastOccurrence=" + this.lastOccurrence + ')';
    }

    /* JADX INFO: compiled from: EventTrigger.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerSettings$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/survicate/surveys/entities/survey/EventTriggerSettings;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<EventTriggerSettings> serializer() {
            return EventTriggerSettings$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EventTriggerSettings(int i, Long l, EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.delay = null;
        } else {
            this.delay = l;
        }
        if ((i & 2) == 0) {
            this.occurrences = null;
        } else {
            this.occurrences = eventTriggerOccurrenceCountSettings;
        }
        if ((i & 4) == 0) {
            this.firstOccurrence = null;
        } else {
            this.firstOccurrence = eventTriggerOccurrenceTimeSettings;
        }
        if ((i & 8) == 0) {
            this.lastOccurrence = null;
        } else {
            this.lastOccurrence = eventTriggerOccurrenceTimeSettings2;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$survicate_sdk_release(EventTriggerSettings self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.delay != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.delay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.occurrences != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, EventTriggerOccurrenceCountSettings$$serializer.INSTANCE, self.occurrences);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.firstOccurrence != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE, self.firstOccurrence);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.lastOccurrence == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, EventTriggerOccurrenceTimeSettings$$serializer.INSTANCE, self.lastOccurrence);
    }

    public EventTriggerSettings(Long l, EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2) {
        this.delay = l;
        this.occurrences = eventTriggerOccurrenceCountSettings;
        this.firstOccurrence = eventTriggerOccurrenceTimeSettings;
        this.lastOccurrence = eventTriggerOccurrenceTimeSettings2;
    }

    public /* synthetic */ EventTriggerSettings(Long l, EventTriggerOccurrenceCountSettings eventTriggerOccurrenceCountSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings, EventTriggerOccurrenceTimeSettings eventTriggerOccurrenceTimeSettings2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : eventTriggerOccurrenceCountSettings, (i & 4) != 0 ? null : eventTriggerOccurrenceTimeSettings, (i & 8) != 0 ? null : eventTriggerOccurrenceTimeSettings2);
    }

    public final Long getDelay() {
        return this.delay;
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
