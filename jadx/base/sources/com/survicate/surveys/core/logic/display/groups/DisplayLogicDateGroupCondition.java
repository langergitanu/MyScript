package com.survicate.surveys.core.logic.display.groups;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DisplayLogicDateGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicDateGroupCondition;", "", "<init>", "(Ljava/lang/String;I)V", "QUESTION_IS_ANSWERED", "QUESTION_IS_NOT_ANSWERED", "HAS_ANY_VALUE", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicDateGroupCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DisplayLogicDateGroupCondition[] $VALUES;
    public static final DisplayLogicDateGroupCondition QUESTION_IS_ANSWERED = new DisplayLogicDateGroupCondition("QUESTION_IS_ANSWERED", 0);
    public static final DisplayLogicDateGroupCondition QUESTION_IS_NOT_ANSWERED = new DisplayLogicDateGroupCondition("QUESTION_IS_NOT_ANSWERED", 1);
    public static final DisplayLogicDateGroupCondition HAS_ANY_VALUE = new DisplayLogicDateGroupCondition("HAS_ANY_VALUE", 2);

    private static final /* synthetic */ DisplayLogicDateGroupCondition[] $values() {
        return new DisplayLogicDateGroupCondition[]{QUESTION_IS_ANSWERED, QUESTION_IS_NOT_ANSWERED, HAS_ANY_VALUE};
    }

    public static EnumEntries<DisplayLogicDateGroupCondition> getEntries() {
        return $ENTRIES;
    }

    private DisplayLogicDateGroupCondition(String str, int i) {
    }

    static {
        DisplayLogicDateGroupCondition[] displayLogicDateGroupConditionArr$values = $values();
        $VALUES = displayLogicDateGroupConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(displayLogicDateGroupConditionArr$values);
    }

    public static DisplayLogicDateGroupCondition valueOf(String str) {
        return (DisplayLogicDateGroupCondition) Enum.valueOf(DisplayLogicDateGroupCondition.class, str);
    }

    public static DisplayLogicDateGroupCondition[] values() {
        return (DisplayLogicDateGroupCondition[]) $VALUES.clone();
    }
}
