package com.myscript.nebo.p022ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: analyticsParameters.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/AIQuizTrigger;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TRY_AGAIN", "NEW_QUESTIONS", "QUIZ_MODAL", "CONTEXTUAL_MENU", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIQuizTrigger {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AIQuizTrigger[] $VALUES;
    private final String value;
    public static final AIQuizTrigger TRY_AGAIN = new AIQuizTrigger("TRY_AGAIN", 0, "try_again");
    public static final AIQuizTrigger NEW_QUESTIONS = new AIQuizTrigger("NEW_QUESTIONS", 1, "new_questions");
    public static final AIQuizTrigger QUIZ_MODAL = new AIQuizTrigger("QUIZ_MODAL", 2, "quiz_modal");
    public static final AIQuizTrigger CONTEXTUAL_MENU = new AIQuizTrigger("CONTEXTUAL_MENU", 3, "quiz_edit_menu");

    private static final /* synthetic */ AIQuizTrigger[] $values() {
        return new AIQuizTrigger[]{TRY_AGAIN, NEW_QUESTIONS, QUIZ_MODAL, CONTEXTUAL_MENU};
    }

    public static EnumEntries<AIQuizTrigger> getEntries() {
        return $ENTRIES;
    }

    public static AIQuizTrigger valueOf(String str) {
        return (AIQuizTrigger) Enum.valueOf(AIQuizTrigger.class, str);
    }

    public static AIQuizTrigger[] values() {
        return (AIQuizTrigger[]) $VALUES.clone();
    }

    private AIQuizTrigger(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AIQuizTrigger[] aIQuizTriggerArr$values = $values();
        $VALUES = aIQuizTriggerArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(aIQuizTriggerArr$values);
    }
}
