package com.myscript.nebo.dms.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LibraryRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/PdfOptimizationLevel;", "", "<init>", "(Ljava/lang/String;I)V", "BEST_QUALITY", "BALANCED", "BEST_PERFORMANCE", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PdfOptimizationLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PdfOptimizationLevel[] $VALUES;
    public static final PdfOptimizationLevel BEST_QUALITY = new PdfOptimizationLevel("BEST_QUALITY", 0);
    public static final PdfOptimizationLevel BALANCED = new PdfOptimizationLevel("BALANCED", 1);
    public static final PdfOptimizationLevel BEST_PERFORMANCE = new PdfOptimizationLevel("BEST_PERFORMANCE", 2);

    private static final /* synthetic */ PdfOptimizationLevel[] $values() {
        return new PdfOptimizationLevel[]{BEST_QUALITY, BALANCED, BEST_PERFORMANCE};
    }

    public static EnumEntries<PdfOptimizationLevel> getEntries() {
        return $ENTRIES;
    }

    public static PdfOptimizationLevel valueOf(String str) {
        return (PdfOptimizationLevel) Enum.valueOf(PdfOptimizationLevel.class, str);
    }

    public static PdfOptimizationLevel[] values() {
        return (PdfOptimizationLevel[]) $VALUES.clone();
    }

    static {
        PdfOptimizationLevel[] pdfOptimizationLevelArr$values = $values();
        $VALUES = pdfOptimizationLevelArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pdfOptimizationLevelArr$values);
    }

    private PdfOptimizationLevel(String str, int i) {
    }
}
