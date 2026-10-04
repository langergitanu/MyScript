package com.survicate.surveys.core.logic.display.groups;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: DisplayLogicSingleChoiceGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicSingleChoiceGroupCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS", "IS_NOT", "HAS_ANY_VALUE", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicSingleChoiceGroupCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DisplayLogicSingleChoiceGroupCondition[] $VALUES;

    /* JADX INFO: renamed from: IS */
    public static final DisplayLogicSingleChoiceGroupCondition f2263IS = new DisplayLogicSingleChoiceGroupCondition("IS", 0);
    public static final DisplayLogicSingleChoiceGroupCondition IS_NOT = new DisplayLogicSingleChoiceGroupCondition("IS_NOT", 1);
    public static final DisplayLogicSingleChoiceGroupCondition HAS_ANY_VALUE = new DisplayLogicSingleChoiceGroupCondition("HAS_ANY_VALUE", 2);

    private static final /* synthetic */ DisplayLogicSingleChoiceGroupCondition[] $values() {
        return new DisplayLogicSingleChoiceGroupCondition[]{f2263IS, IS_NOT, HAS_ANY_VALUE};
    }

    public static EnumEntries<DisplayLogicSingleChoiceGroupCondition> getEntries() {
        return $ENTRIES;
    }

    private DisplayLogicSingleChoiceGroupCondition(String str, int i) {
    }

    static {
        DisplayLogicSingleChoiceGroupCondition[] displayLogicSingleChoiceGroupConditionArr$values = $values();
        $VALUES = displayLogicSingleChoiceGroupConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(displayLogicSingleChoiceGroupConditionArr$values);
    }

    public static DisplayLogicSingleChoiceGroupCondition valueOf(String str) {
        return (DisplayLogicSingleChoiceGroupCondition) Enum.valueOf(DisplayLogicSingleChoiceGroupCondition.class, str);
    }

    public static DisplayLogicSingleChoiceGroupCondition[] values() {
        return (DisplayLogicSingleChoiceGroupCondition[]) $VALUES.clone();
    }
}
