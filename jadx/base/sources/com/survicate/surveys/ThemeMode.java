package com.survicate.surveys;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ThemeMode.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/ThemeMode;", "", "<init>", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "AUTO", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ThemeMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ThemeMode[] $VALUES;
    public static final ThemeMode LIGHT = new ThemeMode("LIGHT", 0);
    public static final ThemeMode DARK = new ThemeMode("DARK", 1);
    public static final ThemeMode AUTO = new ThemeMode("AUTO", 2);

    private static final /* synthetic */ ThemeMode[] $values() {
        return new ThemeMode[]{LIGHT, DARK, AUTO};
    }

    public static EnumEntries<ThemeMode> getEntries() {
        return $ENTRIES;
    }

    private ThemeMode(String str, int i) {
    }

    static {
        ThemeMode[] themeModeArr$values = $values();
        $VALUES = themeModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(themeModeArr$values);
    }

    public static ThemeMode valueOf(String str) {
        return (ThemeMode) Enum.valueOf(ThemeMode.class, str);
    }

    public static ThemeMode[] values() {
        return (ThemeMode[]) $VALUES.clone();
    }
}
