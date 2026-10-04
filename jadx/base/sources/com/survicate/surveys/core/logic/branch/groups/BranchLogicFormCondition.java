package com.survicate.surveys.core.logic.branch.groups;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BranchLogicFormGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicFormCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS_FILLED_IN", "IS_NOT_FILLED_IN", "HAS_ANY_VALUE", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicFormCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BranchLogicFormCondition[] $VALUES;
    public static final BranchLogicFormCondition IS_FILLED_IN = new BranchLogicFormCondition("IS_FILLED_IN", 0);
    public static final BranchLogicFormCondition IS_NOT_FILLED_IN = new BranchLogicFormCondition("IS_NOT_FILLED_IN", 1);
    public static final BranchLogicFormCondition HAS_ANY_VALUE = new BranchLogicFormCondition("HAS_ANY_VALUE", 2);

    private static final /* synthetic */ BranchLogicFormCondition[] $values() {
        return new BranchLogicFormCondition[]{IS_FILLED_IN, IS_NOT_FILLED_IN, HAS_ANY_VALUE};
    }

    public static EnumEntries<BranchLogicFormCondition> getEntries() {
        return $ENTRIES;
    }

    private BranchLogicFormCondition(String str, int i) {
    }

    static {
        BranchLogicFormCondition[] branchLogicFormConditionArr$values = $values();
        $VALUES = branchLogicFormConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(branchLogicFormConditionArr$values);
    }

    public static BranchLogicFormCondition valueOf(String str) {
        return (BranchLogicFormCondition) Enum.valueOf(BranchLogicFormCondition.class, str);
    }

    public static BranchLogicFormCondition[] values() {
        return (BranchLogicFormCondition[]) $VALUES.clone();
    }
}
