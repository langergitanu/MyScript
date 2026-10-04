package com.survicate.surveys.core.logic.branch.groups;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BranchLogicMultipleChoiceGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicMultipleChoiceCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS_EXACTLY", "INCLUDES_ALL", "INCLUDES_ANY", "DOES_NOT_INCLUDE_ANY", "HAS_ANY_VALUE", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicMultipleChoiceCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BranchLogicMultipleChoiceCondition[] $VALUES;
    public static final BranchLogicMultipleChoiceCondition IS_EXACTLY = new BranchLogicMultipleChoiceCondition("IS_EXACTLY", 0);
    public static final BranchLogicMultipleChoiceCondition INCLUDES_ALL = new BranchLogicMultipleChoiceCondition("INCLUDES_ALL", 1);
    public static final BranchLogicMultipleChoiceCondition INCLUDES_ANY = new BranchLogicMultipleChoiceCondition("INCLUDES_ANY", 2);
    public static final BranchLogicMultipleChoiceCondition DOES_NOT_INCLUDE_ANY = new BranchLogicMultipleChoiceCondition("DOES_NOT_INCLUDE_ANY", 3);
    public static final BranchLogicMultipleChoiceCondition HAS_ANY_VALUE = new BranchLogicMultipleChoiceCondition("HAS_ANY_VALUE", 4);

    private static final /* synthetic */ BranchLogicMultipleChoiceCondition[] $values() {
        return new BranchLogicMultipleChoiceCondition[]{IS_EXACTLY, INCLUDES_ALL, INCLUDES_ANY, DOES_NOT_INCLUDE_ANY, HAS_ANY_VALUE};
    }

    public static EnumEntries<BranchLogicMultipleChoiceCondition> getEntries() {
        return $ENTRIES;
    }

    private BranchLogicMultipleChoiceCondition(String str, int i) {
    }

    static {
        BranchLogicMultipleChoiceCondition[] branchLogicMultipleChoiceConditionArr$values = $values();
        $VALUES = branchLogicMultipleChoiceConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(branchLogicMultipleChoiceConditionArr$values);
    }

    public static BranchLogicMultipleChoiceCondition valueOf(String str) {
        return (BranchLogicMultipleChoiceCondition) Enum.valueOf(BranchLogicMultipleChoiceCondition.class, str);
    }

    public static BranchLogicMultipleChoiceCondition[] values() {
        return (BranchLogicMultipleChoiceCondition[]) $VALUES.clone();
    }
}
