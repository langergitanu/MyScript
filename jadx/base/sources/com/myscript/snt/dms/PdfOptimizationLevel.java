package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum PdfOptimizationLevel {
    BEST_QUALITY,
    BALANCED,
    BEST_PERFORMANCE;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PdfOptimizationLevel swigToEnum(int i) {
        PdfOptimizationLevel[] pdfOptimizationLevelArr = (PdfOptimizationLevel[]) PdfOptimizationLevel.class.getEnumConstants();
        if (i < pdfOptimizationLevelArr.length && i >= 0) {
            PdfOptimizationLevel pdfOptimizationLevel = pdfOptimizationLevelArr[i];
            if (pdfOptimizationLevel.swigValue == i) {
                return pdfOptimizationLevel;
            }
        }
        for (PdfOptimizationLevel pdfOptimizationLevel2 : pdfOptimizationLevelArr) {
            if (pdfOptimizationLevel2.swigValue == i) {
                return pdfOptimizationLevel2;
            }
        }
        throw new IllegalArgumentException("No enum " + PdfOptimizationLevel.class + " with value " + i);
    }

    PdfOptimizationLevel() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PdfOptimizationLevel(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PdfOptimizationLevel(PdfOptimizationLevel pdfOptimizationLevel) {
        int i = pdfOptimizationLevel.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
