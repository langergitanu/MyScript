package com.survicate.surveys.core.targeting.displayfilter.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: EventTriggerSettings.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/core/targeting/displayfilter/event/EventTriggerOccurrenceCountOperator;", "", "<init>", "(Ljava/lang/String;I)V", "IS_EQUAL", "IS_NOT_EQUAL", "IS_GREATER_THAN", "IS_GREATER_THAN_OR_EQUAL", "IS_LESS_THAN", "IS_LESS_THAN_OR_EQUAL", "IS_BETWEEN", "IS_NOT_BETWEEN", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class EventTriggerOccurrenceCountOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ EventTriggerOccurrenceCountOperator[] $VALUES;
    public static final EventTriggerOccurrenceCountOperator IS_EQUAL = new EventTriggerOccurrenceCountOperator("IS_EQUAL", 0);
    public static final EventTriggerOccurrenceCountOperator IS_NOT_EQUAL = new EventTriggerOccurrenceCountOperator("IS_NOT_EQUAL", 1);
    public static final EventTriggerOccurrenceCountOperator IS_GREATER_THAN = new EventTriggerOccurrenceCountOperator("IS_GREATER_THAN", 2);
    public static final EventTriggerOccurrenceCountOperator IS_GREATER_THAN_OR_EQUAL = new EventTriggerOccurrenceCountOperator("IS_GREATER_THAN_OR_EQUAL", 3);
    public static final EventTriggerOccurrenceCountOperator IS_LESS_THAN = new EventTriggerOccurrenceCountOperator("IS_LESS_THAN", 4);
    public static final EventTriggerOccurrenceCountOperator IS_LESS_THAN_OR_EQUAL = new EventTriggerOccurrenceCountOperator("IS_LESS_THAN_OR_EQUAL", 5);
    public static final EventTriggerOccurrenceCountOperator IS_BETWEEN = new EventTriggerOccurrenceCountOperator("IS_BETWEEN", 6);
    public static final EventTriggerOccurrenceCountOperator IS_NOT_BETWEEN = new EventTriggerOccurrenceCountOperator("IS_NOT_BETWEEN", 7);

    private static final /* synthetic */ EventTriggerOccurrenceCountOperator[] $values() {
        return new EventTriggerOccurrenceCountOperator[]{IS_EQUAL, IS_NOT_EQUAL, IS_GREATER_THAN, IS_GREATER_THAN_OR_EQUAL, IS_LESS_THAN, IS_LESS_THAN_OR_EQUAL, IS_BETWEEN, IS_NOT_BETWEEN};
    }

    public static EnumEntries<EventTriggerOccurrenceCountOperator> getEntries() {
        return $ENTRIES;
    }

    private EventTriggerOccurrenceCountOperator(String str, int i) {
    }

    static {
        EventTriggerOccurrenceCountOperator[] eventTriggerOccurrenceCountOperatorArr$values = $values();
        $VALUES = eventTriggerOccurrenceCountOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(eventTriggerOccurrenceCountOperatorArr$values);
    }

    public static EventTriggerOccurrenceCountOperator valueOf(String str) {
        return (EventTriggerOccurrenceCountOperator) Enum.valueOf(EventTriggerOccurrenceCountOperator.class, str);
    }

    public static EventTriggerOccurrenceCountOperator[] values() {
        return (EventTriggerOccurrenceCountOperator[]) $VALUES.clone();
    }
}
