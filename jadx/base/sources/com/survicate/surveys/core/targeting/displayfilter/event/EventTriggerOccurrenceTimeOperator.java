package com.survicate.surveys.core.targeting.displayfilter.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: EventTriggerSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceTimeOperator;", "", "<init>", "(Ljava/lang/String;I)V", "IS_GREATER_THAN_OR_EQUAL", "IS_LESS_THAN_OR_EQUAL", "IS_BETWEEN", "IS_NOT_BETWEEN", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventTriggerOccurrenceTimeOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventTriggerOccurrenceTimeOperator[] $VALUES;
    public static final EventTriggerOccurrenceTimeOperator IS_GREATER_THAN_OR_EQUAL = new EventTriggerOccurrenceTimeOperator("IS_GREATER_THAN_OR_EQUAL", 0);
    public static final EventTriggerOccurrenceTimeOperator IS_LESS_THAN_OR_EQUAL = new EventTriggerOccurrenceTimeOperator("IS_LESS_THAN_OR_EQUAL", 1);
    public static final EventTriggerOccurrenceTimeOperator IS_BETWEEN = new EventTriggerOccurrenceTimeOperator("IS_BETWEEN", 2);
    public static final EventTriggerOccurrenceTimeOperator IS_NOT_BETWEEN = new EventTriggerOccurrenceTimeOperator("IS_NOT_BETWEEN", 3);

    private static final /* synthetic */ EventTriggerOccurrenceTimeOperator[] $values() {
        return new EventTriggerOccurrenceTimeOperator[]{IS_GREATER_THAN_OR_EQUAL, IS_LESS_THAN_OR_EQUAL, IS_BETWEEN, IS_NOT_BETWEEN};
    }

    public static EnumEntries<EventTriggerOccurrenceTimeOperator> getEntries() {
        return $ENTRIES;
    }

    private EventTriggerOccurrenceTimeOperator(String str, int i) {
    }

    static {
        EventTriggerOccurrenceTimeOperator[] eventTriggerOccurrenceTimeOperatorArr$values = $values();
        $VALUES = eventTriggerOccurrenceTimeOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventTriggerOccurrenceTimeOperatorArr$values);
    }

    public static EventTriggerOccurrenceTimeOperator valueOf(String str) {
        return (EventTriggerOccurrenceTimeOperator) Enum.valueOf(EventTriggerOccurrenceTimeOperator.class, str);
    }

    public static EventTriggerOccurrenceTimeOperator[] values() {
        return (EventTriggerOccurrenceTimeOperator[]) $VALUES.clone();
    }
}
