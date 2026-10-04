package com.survicate.surveys.core.logic.display.groups;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DisplayLogicRangeGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicRangeGroupCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS", "IS_NOT", "IS_BETWEEN", "HAS_ANY_VALUE", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicRangeGroupCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DisplayLogicRangeGroupCondition[] $VALUES;

    /* JADX INFO: renamed from: IS */
    public static final DisplayLogicRangeGroupCondition f2262IS = new DisplayLogicRangeGroupCondition("IS", 0);
    public static final DisplayLogicRangeGroupCondition IS_NOT = new DisplayLogicRangeGroupCondition("IS_NOT", 1);
    public static final DisplayLogicRangeGroupCondition IS_BETWEEN = new DisplayLogicRangeGroupCondition("IS_BETWEEN", 2);
    public static final DisplayLogicRangeGroupCondition HAS_ANY_VALUE = new DisplayLogicRangeGroupCondition("HAS_ANY_VALUE", 3);

    private static final /* synthetic */ DisplayLogicRangeGroupCondition[] $values() {
        return new DisplayLogicRangeGroupCondition[]{f2262IS, IS_NOT, IS_BETWEEN, HAS_ANY_VALUE};
    }

    public static EnumEntries<DisplayLogicRangeGroupCondition> getEntries() {
        return $ENTRIES;
    }

    private DisplayLogicRangeGroupCondition(String str, int i) {
    }

    static {
        DisplayLogicRangeGroupCondition[] displayLogicRangeGroupConditionArr$values = $values();
        $VALUES = displayLogicRangeGroupConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(displayLogicRangeGroupConditionArr$values);
    }

    public static DisplayLogicRangeGroupCondition valueOf(String str) {
        return (DisplayLogicRangeGroupCondition) Enum.valueOf(DisplayLogicRangeGroupCondition.class, str);
    }

    public static DisplayLogicRangeGroupCondition[] values() {
        return (DisplayLogicRangeGroupCondition[]) $VALUES.clone();
    }
}
