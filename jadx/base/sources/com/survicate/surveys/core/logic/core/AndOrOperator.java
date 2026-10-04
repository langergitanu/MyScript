package com.survicate.surveys.core.logic.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AndOrOperator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "", "<init>", "(Ljava/lang/String;I)V", "AND", "OR", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class AndOrOperator {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AndOrOperator[] $VALUES;
    public static final AndOrOperator AND = new AndOrOperator("AND", 0);

    /* JADX INFO: renamed from: OR */
    public static final AndOrOperator f2260OR = new AndOrOperator("OR", 1);

    private static final /* synthetic */ AndOrOperator[] $values() {
        return new AndOrOperator[]{AND, f2260OR};
    }

    public static EnumEntries<AndOrOperator> getEntries() {
        return $ENTRIES;
    }

    private AndOrOperator(String str, int i) {
    }

    static {
        AndOrOperator[] andOrOperatorArr$values = $values();
        $VALUES = andOrOperatorArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(andOrOperatorArr$values);
    }

    public static AndOrOperator valueOf(String str) {
        return (AndOrOperator) Enum.valueOf(AndOrOperator.class, str);
    }

    public static AndOrOperator[] values() {
        return (AndOrOperator[]) $VALUES.clone();
    }
}
