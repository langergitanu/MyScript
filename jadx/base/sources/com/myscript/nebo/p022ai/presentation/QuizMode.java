package com.myscript.nebo.p022ai.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AIQuizViewModel.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/ai/presentation/QuizMode;", "", "<init>", "(Ljava/lang/String;I)V", "TRUE_FALSE", "MULTIPLE_CHOICE", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class QuizMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ QuizMode[] $VALUES;
    public static final QuizMode TRUE_FALSE = new QuizMode("TRUE_FALSE", 0);
    public static final QuizMode MULTIPLE_CHOICE = new QuizMode("MULTIPLE_CHOICE", 1);

    private static final /* synthetic */ QuizMode[] $values() {
        return new QuizMode[]{TRUE_FALSE, MULTIPLE_CHOICE};
    }

    public static EnumEntries<QuizMode> getEntries() {
        return $ENTRIES;
    }

    public static QuizMode valueOf(String str) {
        return (QuizMode) Enum.valueOf(QuizMode.class, str);
    }

    public static QuizMode[] values() {
        return (QuizMode[]) $VALUES.clone();
    }

    static {
        QuizMode[] quizModeArr$values = $values();
        $VALUES = quizModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(quizModeArr$values);
    }

    private QuizMode(String str, int i) {
    }
}
