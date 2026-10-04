package com.myscript.nebo.p022ai;

import com.myscript.nebo.analytics.firebase.AIQuizConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: analyticsParameters.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/ai/AIAnalyticsOrigin;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEXT_DOCUMENT", "PDF", "NOTEBOOK", "RAW_CONTENT", "SETTINGS", "nebo-ai_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AIAnalyticsOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AIAnalyticsOrigin[] $VALUES;
    private final String value;
    public static final AIAnalyticsOrigin TEXT_DOCUMENT = new AIAnalyticsOrigin("TEXT_DOCUMENT", 0, "text_document");
    public static final AIAnalyticsOrigin PDF = new AIAnalyticsOrigin("PDF", 1, AIQuizConstants.PDF);
    public static final AIAnalyticsOrigin NOTEBOOK = new AIAnalyticsOrigin("NOTEBOOK", 2, AIQuizConstants.NOTEBOOK);
    public static final AIAnalyticsOrigin RAW_CONTENT = new AIAnalyticsOrigin("RAW_CONTENT", 3, "raw_content");
    public static final AIAnalyticsOrigin SETTINGS = new AIAnalyticsOrigin("SETTINGS", 4, "settings");

    private static final /* synthetic */ AIAnalyticsOrigin[] $values() {
        return new AIAnalyticsOrigin[]{TEXT_DOCUMENT, PDF, NOTEBOOK, RAW_CONTENT, SETTINGS};
    }

    public static EnumEntries<AIAnalyticsOrigin> getEntries() {
        return $ENTRIES;
    }

    public static AIAnalyticsOrigin valueOf(String str) {
        return (AIAnalyticsOrigin) Enum.valueOf(AIAnalyticsOrigin.class, str);
    }

    public static AIAnalyticsOrigin[] values() {
        return (AIAnalyticsOrigin[]) $VALUES.clone();
    }

    private AIAnalyticsOrigin(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        AIAnalyticsOrigin[] aIAnalyticsOriginArr$values = $values();
        $VALUES = aIAnalyticsOriginArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(aIAnalyticsOriginArr$values);
    }
}
