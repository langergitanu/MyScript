package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public enum PdfOptimizationResult {
    OPTIMIZED,
    ALREADY_OPTIMIZED,
    FAILED;

    private final int swigValue;

    public final int swigValue() {
        return this.swigValue;
    }

    public static PdfOptimizationResult swigToEnum(int i) {
        PdfOptimizationResult[] pdfOptimizationResultArr = (PdfOptimizationResult[]) PdfOptimizationResult.class.getEnumConstants();
        if (i < pdfOptimizationResultArr.length && i >= 0) {
            PdfOptimizationResult pdfOptimizationResult = pdfOptimizationResultArr[i];
            if (pdfOptimizationResult.swigValue == i) {
                return pdfOptimizationResult;
            }
        }
        for (PdfOptimizationResult pdfOptimizationResult2 : pdfOptimizationResultArr) {
            if (pdfOptimizationResult2.swigValue == i) {
                return pdfOptimizationResult2;
            }
        }
        throw new IllegalArgumentException("No enum " + PdfOptimizationResult.class + " with value " + i);
    }

    PdfOptimizationResult() {
        int i = SwigNext.next;
        SwigNext.next = i + 1;
        this.swigValue = i;
    }

    PdfOptimizationResult(int i) {
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    PdfOptimizationResult(PdfOptimizationResult pdfOptimizationResult) {
        int i = pdfOptimizationResult.swigValue;
        this.swigValue = i;
        SwigNext.next = i + 1;
    }

    private static class SwigNext {
        private static int next;

        private SwigNext() {
        }
    }
}
