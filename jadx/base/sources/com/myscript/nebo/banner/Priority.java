package com.myscript.nebo.banner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Banners.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/banner/Priority;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "WARNING", "FORBIDDEN", "CORRUPTED", "MARKETING", "FEEDBACK", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Priority {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Priority[] $VALUES;
    private final int value;
    public static final Priority WARNING = new Priority("WARNING", 0, 4);
    public static final Priority FORBIDDEN = new Priority("FORBIDDEN", 1, 3);
    public static final Priority CORRUPTED = new Priority("CORRUPTED", 2, 2);
    public static final Priority MARKETING = new Priority("MARKETING", 3, 1);
    public static final Priority FEEDBACK = new Priority("FEEDBACK", 4, 0);

    private static final /* synthetic */ Priority[] $values() {
        return new Priority[]{WARNING, FORBIDDEN, CORRUPTED, MARKETING, FEEDBACK};
    }

    public static EnumEntries<Priority> getEntries() {
        return $ENTRIES;
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) $VALUES.clone();
    }

    private Priority(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Priority[] priorityArr$values = $values();
        $VALUES = priorityArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(priorityArr$values);
    }
}
