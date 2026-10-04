package com.myscript.nebo.p022ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: analyticsParameters.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/ai/AIExplainTrigger;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BUTTON", "CONTEXTUAL_MENU", "RETRY", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIExplainTrigger {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AIExplainTrigger[] $VALUES;
    public static final AIExplainTrigger BUTTON = new AIExplainTrigger("BUTTON", 0, "explain_button");
    public static final AIExplainTrigger CONTEXTUAL_MENU = new AIExplainTrigger("CONTEXTUAL_MENU", 1, "explain_edit_menu");
    public static final AIExplainTrigger RETRY = new AIExplainTrigger("RETRY", 2, "regenerate_button");
    private final String value;

    private static final /* synthetic */ AIExplainTrigger[] $values() {
        return new AIExplainTrigger[]{BUTTON, CONTEXTUAL_MENU, RETRY};
    }

    public static EnumEntries<AIExplainTrigger> getEntries() {
        return $ENTRIES;
    }

    public static AIExplainTrigger valueOf(String str) {
        return (AIExplainTrigger) Enum.valueOf(AIExplainTrigger.class, str);
    }

    public static AIExplainTrigger[] values() {
        return (AIExplainTrigger[]) $VALUES.clone();
    }

    private AIExplainTrigger(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AIExplainTrigger[] aIExplainTriggerArr$values = $values();
        $VALUES = aIExplainTriggerArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(aIExplainTriggerArr$values);
    }
}
