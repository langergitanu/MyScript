package com.survicate.surveys;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.Regex;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: TextRecallingManager.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m1599d2 = {"Lcom/survicate/surveys/RecallingTag;", "", "value", "", "regex", "Lkotlin/text/Regex;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/text/Regex;)V", "getValue", "()Ljava/lang/String;", "getRegex", "()Lkotlin/text/Regex;", "VISITOR", "ANSWER", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
final class RecallingTag {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RecallingTag[] $VALUES;
    private final Regex regex;
    private final String value;
    public static final RecallingTag VISITOR = new RecallingTag("VISITOR", 0, "visitor", new Regex("\\{\\{visitor\\.(\\S+)(?:\\s?\\|\\s?\"([^\"]*)\")?\\}\\}"));
    public static final RecallingTag ANSWER = new RecallingTag("ANSWER", 1, "answer", new Regex("\\{\\{answer:(\\d+)(?:\\s?\\|\\s?\"([^\"]*)\")?\\}\\}"));

    private static final /* synthetic */ RecallingTag[] $values() {
        return new RecallingTag[]{VISITOR, ANSWER};
    }

    public static EnumEntries<RecallingTag> getEntries() {
        return $ENTRIES;
    }

    private RecallingTag(String str, int i, String str2, Regex regex) {
        this.value = str2;
        this.regex = regex;
    }

    public final Regex getRegex() {
        return this.regex;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        RecallingTag[] recallingTagArr$values = $values();
        $VALUES = recallingTagArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(recallingTagArr$values);
    }

    public static RecallingTag valueOf(String str) {
        return (RecallingTag) Enum.valueOf(RecallingTag.class, str);
    }

    public static RecallingTag[] values() {
        return (RecallingTag[]) $VALUES.clone();
    }
}
