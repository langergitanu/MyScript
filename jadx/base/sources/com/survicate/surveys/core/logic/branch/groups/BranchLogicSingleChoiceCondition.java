package com.survicate.surveys.core.logic.branch.groups;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BranchLogicSingleChoiceGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicSingleChoiceCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS", "IS_NOT", "HAS_ANY_VALUE", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicSingleChoiceCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BranchLogicSingleChoiceCondition[] $VALUES;

    /* JADX INFO: renamed from: IS */
    public static final BranchLogicSingleChoiceCondition f2259IS = new BranchLogicSingleChoiceCondition("IS", 0);
    public static final BranchLogicSingleChoiceCondition IS_NOT = new BranchLogicSingleChoiceCondition("IS_NOT", 1);
    public static final BranchLogicSingleChoiceCondition HAS_ANY_VALUE = new BranchLogicSingleChoiceCondition("HAS_ANY_VALUE", 2);

    private static final /* synthetic */ BranchLogicSingleChoiceCondition[] $values() {
        return new BranchLogicSingleChoiceCondition[]{f2259IS, IS_NOT, HAS_ANY_VALUE};
    }

    public static EnumEntries<BranchLogicSingleChoiceCondition> getEntries() {
        return $ENTRIES;
    }

    private BranchLogicSingleChoiceCondition(String str, int i) {
    }

    static {
        BranchLogicSingleChoiceCondition[] branchLogicSingleChoiceConditionArr$values = $values();
        $VALUES = branchLogicSingleChoiceConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(branchLogicSingleChoiceConditionArr$values);
    }

    public static BranchLogicSingleChoiceCondition valueOf(String str) {
        return (BranchLogicSingleChoiceCondition) Enum.valueOf(BranchLogicSingleChoiceCondition.class, str);
    }

    public static BranchLogicSingleChoiceCondition[] values() {
        return (BranchLogicSingleChoiceCondition[]) $VALUES.clone();
    }
}
