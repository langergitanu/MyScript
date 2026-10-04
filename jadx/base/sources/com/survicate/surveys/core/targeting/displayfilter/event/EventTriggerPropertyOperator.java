package com.survicate.surveys.core.targeting.displayfilter.event;

import com.google.api.client.googleapis.notifications.ResourceStates;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: EventTriggerProperty.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerPropertyOperator;", "", "<init>", "(Ljava/lang/String;I)V", "IS_EQUAL", "IS_NOT_EQUAL", "CONTAINS", "DOES_NOT_CONTAIN", ResourceStates.EXISTS, "DOES_NOT_EXIST", "ANY", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventTriggerPropertyOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventTriggerPropertyOperator[] $VALUES;
    public static final EventTriggerPropertyOperator IS_EQUAL = new EventTriggerPropertyOperator("IS_EQUAL", 0);
    public static final EventTriggerPropertyOperator IS_NOT_EQUAL = new EventTriggerPropertyOperator("IS_NOT_EQUAL", 1);
    public static final EventTriggerPropertyOperator CONTAINS = new EventTriggerPropertyOperator("CONTAINS", 2);
    public static final EventTriggerPropertyOperator DOES_NOT_CONTAIN = new EventTriggerPropertyOperator("DOES_NOT_CONTAIN", 3);
    public static final EventTriggerPropertyOperator EXISTS = new EventTriggerPropertyOperator(ResourceStates.EXISTS, 4);
    public static final EventTriggerPropertyOperator DOES_NOT_EXIST = new EventTriggerPropertyOperator("DOES_NOT_EXIST", 5);
    public static final EventTriggerPropertyOperator ANY = new EventTriggerPropertyOperator("ANY", 6);

    private static final /* synthetic */ EventTriggerPropertyOperator[] $values() {
        return new EventTriggerPropertyOperator[]{IS_EQUAL, IS_NOT_EQUAL, CONTAINS, DOES_NOT_CONTAIN, EXISTS, DOES_NOT_EXIST, ANY};
    }

    public static EnumEntries<EventTriggerPropertyOperator> getEntries() {
        return $ENTRIES;
    }

    private EventTriggerPropertyOperator(String str, int i) {
    }

    static {
        EventTriggerPropertyOperator[] eventTriggerPropertyOperatorArr$values = $values();
        $VALUES = eventTriggerPropertyOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventTriggerPropertyOperatorArr$values);
    }

    public static EventTriggerPropertyOperator valueOf(String str) {
        return (EventTriggerPropertyOperator) Enum.valueOf(EventTriggerPropertyOperator.class, str);
    }

    public static EventTriggerPropertyOperator[] values() {
        return (EventTriggerPropertyOperator[]) $VALUES.clone();
    }
}
