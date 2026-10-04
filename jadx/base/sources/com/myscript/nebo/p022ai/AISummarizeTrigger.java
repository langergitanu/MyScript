package com.myscript.nebo.p022ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: analyticsParameters.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/ai/AISummarizeTrigger;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BUTTON", "CONTEXTUAL_MENU", "SHORTER", "RETRY", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AISummarizeTrigger {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AISummarizeTrigger[] $VALUES;
    private final String value;
    public static final AISummarizeTrigger BUTTON = new AISummarizeTrigger("BUTTON", 0, "summarize_button");
    public static final AISummarizeTrigger CONTEXTUAL_MENU = new AISummarizeTrigger("CONTEXTUAL_MENU", 1, "summarize_edit_menu");
    public static final AISummarizeTrigger SHORTER = new AISummarizeTrigger("SHORTER", 2, "shorter_button");
    public static final AISummarizeTrigger RETRY = new AISummarizeTrigger("RETRY", 3, "regenerate_button");

    private static final /* synthetic */ AISummarizeTrigger[] $values() {
        return new AISummarizeTrigger[]{BUTTON, CONTEXTUAL_MENU, SHORTER, RETRY};
    }

    public static EnumEntries<AISummarizeTrigger> getEntries() {
        return $ENTRIES;
    }

    public static AISummarizeTrigger valueOf(String str) {
        return (AISummarizeTrigger) Enum.valueOf(AISummarizeTrigger.class, str);
    }

    public static AISummarizeTrigger[] values() {
        return (AISummarizeTrigger[]) $VALUES.clone();
    }

    private AISummarizeTrigger(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AISummarizeTrigger[] aISummarizeTriggerArr$values = $values();
        $VALUES = aISummarizeTriggerArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(aISummarizeTriggerArr$values);
    }
}
