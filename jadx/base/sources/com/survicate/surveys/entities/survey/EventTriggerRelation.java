package com.survicate.surveys.entities.survey;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: EventTrigger.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/EventTriggerRelation;", "", "<init>", "(Ljava/lang/String;I)V", "AND", "OR", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventTriggerRelation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventTriggerRelation[] $VALUES;

    @SerialName("and")
    public static final EventTriggerRelation AND = new EventTriggerRelation("AND", 0);

    /* JADX INFO: renamed from: OR */
    @SerialName("or")
    public static final EventTriggerRelation f2271OR = new EventTriggerRelation("OR", 1);

    private static final /* synthetic */ EventTriggerRelation[] $values() {
        return new EventTriggerRelation[]{AND, f2271OR};
    }

    public static EnumEntries<EventTriggerRelation> getEntries() {
        return $ENTRIES;
    }

    private EventTriggerRelation(String str, int i) {
    }

    static {
        EventTriggerRelation[] eventTriggerRelationArr$values = $values();
        $VALUES = eventTriggerRelationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventTriggerRelationArr$values);
    }

    public static EventTriggerRelation valueOf(String str) {
        return (EventTriggerRelation) Enum.valueOf(EventTriggerRelation.class, str);
    }

    public static EventTriggerRelation[] values() {
        return (EventTriggerRelation[]) $VALUES.clone();
    }
}
