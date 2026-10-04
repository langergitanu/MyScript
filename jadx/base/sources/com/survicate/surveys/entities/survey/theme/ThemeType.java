package com.survicate.surveys.entities.survey.theme;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ThemeType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, m1599d2 = {"Lcom/survicate/surveys/entities/survey/theme/ThemeType;", "", "<init>", "(Ljava/lang/String;I)V", "MICRO", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ThemeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ThemeType[] $VALUES;
    public static final ThemeType MICRO = new ThemeType("MICRO", 0);

    private static final /* synthetic */ ThemeType[] $values() {
        return new ThemeType[]{MICRO};
    }

    public static EnumEntries<ThemeType> getEntries() {
        return $ENTRIES;
    }

    private ThemeType(String str, int i) {
    }

    static {
        ThemeType[] themeTypeArr$values = $values();
        $VALUES = themeTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(themeTypeArr$values);
    }

    public static ThemeType valueOf(String str) {
        return (ThemeType) Enum.valueOf(ThemeType.class, str);
    }

    public static ThemeType[] values() {
        return (ThemeType[]) $VALUES.clone();
    }
}
