package com.myscript.nebo.p022ai.presentation.compose.components;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AIDropdownMenu.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/components/AIDropdownOption;", "", "<init>", "(Ljava/lang/String;I)V", "Summarize", "Explain", "Quiz", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIDropdownOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AIDropdownOption[] $VALUES;
    public static final AIDropdownOption Summarize = new AIDropdownOption("Summarize", 0);
    public static final AIDropdownOption Explain = new AIDropdownOption("Explain", 1);
    public static final AIDropdownOption Quiz = new AIDropdownOption("Quiz", 2);

    private static final /* synthetic */ AIDropdownOption[] $values() {
        return new AIDropdownOption[]{Summarize, Explain, Quiz};
    }

    public static EnumEntries<AIDropdownOption> getEntries() {
        return $ENTRIES;
    }

    public static AIDropdownOption valueOf(String str) {
        return (AIDropdownOption) Enum.valueOf(AIDropdownOption.class, str);
    }

    public static AIDropdownOption[] values() {
        return (AIDropdownOption[]) $VALUES.clone();
    }

    private AIDropdownOption(String str, int i) {
    }

    static {
        AIDropdownOption[] aIDropdownOptionArr$values = $values();
        $VALUES = aIDropdownOptionArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(aIDropdownOptionArr$values);
    }
}
