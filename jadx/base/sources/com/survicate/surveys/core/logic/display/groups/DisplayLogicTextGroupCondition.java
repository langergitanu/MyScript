package com.survicate.surveys.core.logic.display.groups;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DisplayLogicTextGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicTextGroupCondition;", "", "<init>", "(Ljava/lang/String;I)V", "ANSWER_CONTAINS", "ANSWER_DOES_NOT_CONTAIN", "QUESTION_IS_ANSWERED", "QUESTION_IS_NOT_ANSWERED", "HAS_ANY_VALUE", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicTextGroupCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DisplayLogicTextGroupCondition[] $VALUES;
    public static final DisplayLogicTextGroupCondition ANSWER_CONTAINS = new DisplayLogicTextGroupCondition("ANSWER_CONTAINS", 0);
    public static final DisplayLogicTextGroupCondition ANSWER_DOES_NOT_CONTAIN = new DisplayLogicTextGroupCondition("ANSWER_DOES_NOT_CONTAIN", 1);
    public static final DisplayLogicTextGroupCondition QUESTION_IS_ANSWERED = new DisplayLogicTextGroupCondition("QUESTION_IS_ANSWERED", 2);
    public static final DisplayLogicTextGroupCondition QUESTION_IS_NOT_ANSWERED = new DisplayLogicTextGroupCondition("QUESTION_IS_NOT_ANSWERED", 3);
    public static final DisplayLogicTextGroupCondition HAS_ANY_VALUE = new DisplayLogicTextGroupCondition("HAS_ANY_VALUE", 4);

    private static final /* synthetic */ DisplayLogicTextGroupCondition[] $values() {
        return new DisplayLogicTextGroupCondition[]{ANSWER_CONTAINS, ANSWER_DOES_NOT_CONTAIN, QUESTION_IS_ANSWERED, QUESTION_IS_NOT_ANSWERED, HAS_ANY_VALUE};
    }

    public static EnumEntries<DisplayLogicTextGroupCondition> getEntries() {
        return $ENTRIES;
    }

    private DisplayLogicTextGroupCondition(String str, int i) {
    }

    static {
        DisplayLogicTextGroupCondition[] displayLogicTextGroupConditionArr$values = $values();
        $VALUES = displayLogicTextGroupConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(displayLogicTextGroupConditionArr$values);
    }

    public static DisplayLogicTextGroupCondition valueOf(String str) {
        return (DisplayLogicTextGroupCondition) Enum.valueOf(DisplayLogicTextGroupCondition.class, str);
    }

    public static DisplayLogicTextGroupCondition[] values() {
        return (DisplayLogicTextGroupCondition[]) $VALUES.clone();
    }
}
