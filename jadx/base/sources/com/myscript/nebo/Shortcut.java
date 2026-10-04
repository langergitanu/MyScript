package com.myscript.nebo;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: MainActivityDetailFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/Shortcut;", "", "<init>", "(Ljava/lang/String;I)V", "ESCAPE", "SEARCH", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Shortcut {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Shortcut[] $VALUES;
    public static final Shortcut ESCAPE = new Shortcut("ESCAPE", 0);
    public static final Shortcut SEARCH = new Shortcut("SEARCH", 1);

    private static final /* synthetic */ Shortcut[] $values() {
        return new Shortcut[]{ESCAPE, SEARCH};
    }

    public static EnumEntries<Shortcut> getEntries() {
        return $ENTRIES;
    }

    public static Shortcut valueOf(String str) {
        return (Shortcut) Enum.valueOf(Shortcut.class, str);
    }

    public static Shortcut[] values() {
        return (Shortcut[]) $VALUES.clone();
    }

    private Shortcut(String str, int i) {
    }

    static {
        Shortcut[] shortcutArr$values = $values();
        $VALUES = shortcutArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(shortcutArr$values);
    }
}
