package com.myscript.nebo.p022ai.presentation.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AIContainerViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/compose/AIMode;", "", "<init>", "(Ljava/lang/String;I)V", "EXPLAIN", "SUMMARIZE", "QUIZ", "MINIMIZED", "NONE", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AIMode[] $VALUES;
    public static final AIMode EXPLAIN = new AIMode("EXPLAIN", 0);
    public static final AIMode SUMMARIZE = new AIMode("SUMMARIZE", 1);
    public static final AIMode QUIZ = new AIMode("QUIZ", 2);
    public static final AIMode MINIMIZED = new AIMode("MINIMIZED", 3);
    public static final AIMode NONE = new AIMode("NONE", 4);

    private static final /* synthetic */ AIMode[] $values() {
        return new AIMode[]{EXPLAIN, SUMMARIZE, QUIZ, MINIMIZED, NONE};
    }

    public static EnumEntries<AIMode> getEntries() {
        return $ENTRIES;
    }

    public static AIMode valueOf(String str) {
        return (AIMode) Enum.valueOf(AIMode.class, str);
    }

    public static AIMode[] values() {
        return (AIMode[]) $VALUES.clone();
    }

    static {
        AIMode[] aIModeArr$values = $values();
        $VALUES = aIModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(aIModeArr$values);
    }

    private AIMode(String str, int i) {
    }
}
