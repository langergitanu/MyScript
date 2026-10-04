package com.myscript.android.utils.p019ui.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LayoutConfiguration.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/android/utils/ui/compose/ScreenLayoutConfiguration;", "", "<init>", "(Ljava/lang/String;I)V", "COMPACT_LANDSCAPE", "COMPACT_PORTRAIT", "LARGE_LANDSCAPE", "LARGE_PORTRAIT", "android-utils_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ScreenLayoutConfiguration {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ScreenLayoutConfiguration[] $VALUES;
    public static final ScreenLayoutConfiguration COMPACT_LANDSCAPE = new ScreenLayoutConfiguration("COMPACT_LANDSCAPE", 0);
    public static final ScreenLayoutConfiguration COMPACT_PORTRAIT = new ScreenLayoutConfiguration("COMPACT_PORTRAIT", 1);
    public static final ScreenLayoutConfiguration LARGE_LANDSCAPE = new ScreenLayoutConfiguration("LARGE_LANDSCAPE", 2);
    public static final ScreenLayoutConfiguration LARGE_PORTRAIT = new ScreenLayoutConfiguration("LARGE_PORTRAIT", 3);

    private static final /* synthetic */ ScreenLayoutConfiguration[] $values() {
        return new ScreenLayoutConfiguration[]{COMPACT_LANDSCAPE, COMPACT_PORTRAIT, LARGE_LANDSCAPE, LARGE_PORTRAIT};
    }

    public static EnumEntries<ScreenLayoutConfiguration> getEntries() {
        return $ENTRIES;
    }

    public static ScreenLayoutConfiguration valueOf(String str) {
        return (ScreenLayoutConfiguration) Enum.valueOf(ScreenLayoutConfiguration.class, str);
    }

    public static ScreenLayoutConfiguration[] values() {
        return (ScreenLayoutConfiguration[]) $VALUES.clone();
    }

    private ScreenLayoutConfiguration(String str, int i) {
    }

    static {
        ScreenLayoutConfiguration[] screenLayoutConfigurationArr$values = $values();
        $VALUES = screenLayoutConfigurationArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(screenLayoutConfigurationArr$values);
    }
}
