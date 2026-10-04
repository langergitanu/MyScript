package com.myscript.nebo.grid;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: ImportableDocument.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/grid/ImportableKind;", "", "<init>", "(Ljava/lang/String;I)V", "NEBO", "PDF", "UNSUPPORTED", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ImportableKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ImportableKind[] $VALUES;
    public static final ImportableKind NEBO = new ImportableKind("NEBO", 0);
    public static final ImportableKind PDF = new ImportableKind("PDF", 1);
    public static final ImportableKind UNSUPPORTED = new ImportableKind("UNSUPPORTED", 2);

    private static final /* synthetic */ ImportableKind[] $values() {
        return new ImportableKind[]{NEBO, PDF, UNSUPPORTED};
    }

    public static EnumEntries<ImportableKind> getEntries() {
        return $ENTRIES;
    }

    public static ImportableKind valueOf(String str) {
        return (ImportableKind) Enum.valueOf(ImportableKind.class, str);
    }

    public static ImportableKind[] values() {
        return (ImportableKind[]) $VALUES.clone();
    }

    static {
        ImportableKind[] importableKindArr$values = $values();
        $VALUES = importableKindArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(importableKindArr$values);
    }

    private ImportableKind(String str, int i) {
    }
}
