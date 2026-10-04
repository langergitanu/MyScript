package com.myscript.nebo.dms.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: LibraryRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/PdfOptimizationResult;", "", "<init>", "(Ljava/lang/String;I)V", "OPTIMIZED", "ALREADY_OPTIMIZED", "FAILED", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PdfOptimizationResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PdfOptimizationResult[] $VALUES;
    public static final PdfOptimizationResult OPTIMIZED = new PdfOptimizationResult("OPTIMIZED", 0);
    public static final PdfOptimizationResult ALREADY_OPTIMIZED = new PdfOptimizationResult("ALREADY_OPTIMIZED", 1);
    public static final PdfOptimizationResult FAILED = new PdfOptimizationResult("FAILED", 2);

    private static final /* synthetic */ PdfOptimizationResult[] $values() {
        return new PdfOptimizationResult[]{OPTIMIZED, ALREADY_OPTIMIZED, FAILED};
    }

    public static EnumEntries<PdfOptimizationResult> getEntries() {
        return $ENTRIES;
    }

    public static PdfOptimizationResult valueOf(String str) {
        return (PdfOptimizationResult) Enum.valueOf(PdfOptimizationResult.class, str);
    }

    public static PdfOptimizationResult[] values() {
        return (PdfOptimizationResult[]) $VALUES.clone();
    }

    private PdfOptimizationResult(String str, int i) {
    }

    static {
        PdfOptimizationResult[] pdfOptimizationResultArr$values = $values();
        $VALUES = pdfOptimizationResultArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pdfOptimizationResultArr$values);
    }
}
