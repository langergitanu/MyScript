package com.myscript.nebo.languagemanager.presentation.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LanguageManagerItem.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/languagemanager/presentation/model/SectionType;", "", "<init>", "(Ljava/lang/String;I)V", "INSTALLED", "SUGGESTED", "AVAILABLE", "language-manager_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SectionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SectionType[] $VALUES;
    public static final SectionType INSTALLED = new SectionType("INSTALLED", 0);
    public static final SectionType SUGGESTED = new SectionType("SUGGESTED", 1);
    public static final SectionType AVAILABLE = new SectionType("AVAILABLE", 2);

    private static final /* synthetic */ SectionType[] $values() {
        return new SectionType[]{INSTALLED, SUGGESTED, AVAILABLE};
    }

    public static EnumEntries<SectionType> getEntries() {
        return $ENTRIES;
    }

    public static SectionType valueOf(String str) {
        return (SectionType) Enum.valueOf(SectionType.class, str);
    }

    public static SectionType[] values() {
        return (SectionType[]) $VALUES.clone();
    }

    private SectionType(String str, int i) {
    }

    static {
        SectionType[] sectionTypeArr$values = $values();
        $VALUES = sectionTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sectionTypeArr$values);
    }
}
