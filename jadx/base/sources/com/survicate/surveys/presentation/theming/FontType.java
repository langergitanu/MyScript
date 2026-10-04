package com.survicate.surveys.presentation.theming;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FontType.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/presentation/theming/FontType;", "", "<init>", "(Ljava/lang/String;I)V", "REGULAR", "REGULAR_ITALIC", "BOLD", "BOLD_ITALIC", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class FontType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FontType[] $VALUES;
    public static final FontType REGULAR = new FontType("REGULAR", 0);
    public static final FontType REGULAR_ITALIC = new FontType("REGULAR_ITALIC", 1);
    public static final FontType BOLD = new FontType("BOLD", 2);
    public static final FontType BOLD_ITALIC = new FontType("BOLD_ITALIC", 3);

    private static final /* synthetic */ FontType[] $values() {
        return new FontType[]{REGULAR, REGULAR_ITALIC, BOLD, BOLD_ITALIC};
    }

    public static EnumEntries<FontType> getEntries() {
        return $ENTRIES;
    }

    private FontType(String str, int i) {
    }

    static {
        FontType[] fontTypeArr$values = $values();
        $VALUES = fontTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(fontTypeArr$values);
    }

    public static FontType valueOf(String str) {
        return (FontType) Enum.valueOf(FontType.class, str);
    }

    public static FontType[] values() {
        return (FontType[]) $VALUES.clone();
    }
}
