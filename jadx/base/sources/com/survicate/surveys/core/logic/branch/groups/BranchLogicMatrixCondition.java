package com.survicate.surveys.core.logic.branch.groups;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: BranchLogicMatrixGroup.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/groups/BranchLogicMatrixCondition;", "", "<init>", "(Ljava/lang/String;I)V", "IS", "IS_NOT", "IS_BETWEEN", "HAS_ANY_VALUE", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicMatrixCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BranchLogicMatrixCondition[] $VALUES;

    /* JADX INFO: renamed from: IS */
    public static final BranchLogicMatrixCondition f2257IS = new BranchLogicMatrixCondition("IS", 0);
    public static final BranchLogicMatrixCondition IS_NOT = new BranchLogicMatrixCondition("IS_NOT", 1);
    public static final BranchLogicMatrixCondition IS_BETWEEN = new BranchLogicMatrixCondition("IS_BETWEEN", 2);
    public static final BranchLogicMatrixCondition HAS_ANY_VALUE = new BranchLogicMatrixCondition("HAS_ANY_VALUE", 3);

    private static final /* synthetic */ BranchLogicMatrixCondition[] $values() {
        return new BranchLogicMatrixCondition[]{f2257IS, IS_NOT, IS_BETWEEN, HAS_ANY_VALUE};
    }

    public static EnumEntries<BranchLogicMatrixCondition> getEntries() {
        return $ENTRIES;
    }

    private BranchLogicMatrixCondition(String str, int i) {
    }

    static {
        BranchLogicMatrixCondition[] branchLogicMatrixConditionArr$values = $values();
        $VALUES = branchLogicMatrixConditionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(branchLogicMatrixConditionArr$values);
    }

    public static BranchLogicMatrixCondition valueOf(String str) {
        return (BranchLogicMatrixCondition) Enum.valueOf(BranchLogicMatrixCondition.class, str);
    }

    public static BranchLogicMatrixCondition[] values() {
        return (BranchLogicMatrixCondition[]) $VALUES.clone();
    }
}
