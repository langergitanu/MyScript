package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentConversion implements AutoCloseable {
    public static final int e_failure = 2;
    public static final int e_incomplete = 1;
    public static final int e_success = 0;

    /* JADX INFO: renamed from: a */
    private long f1532a;

    static native void CancelConversion(long j);

    static native void Convert(long j);

    static native void ConvertNextPage(long j);

    static native void Destroy(long j);

    static native int GetConversionStatus(long j);

    static native String GetCurrentExcelSheetName(long j);

    static native long GetDoc(long j);

    static native String GetErrorString(long j);

    static native int GetNextExcelSheetCellCount(long j);

    static native int GetNumConvertedPages(long j);

    static native int GetNumWarnings(long j);

    static native double GetProgress(long j);

    static native String GetProgressLabel(long j);

    static native String GetWarningString(long j, int i);

    static native boolean HasProgressTracking(long j);

    static native boolean IsCancelled(long j);

    static native void SkipNextExcelSheet(long j);

    static native int TryConvert(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1532a;
        if (j != 0) {
            Destroy(j);
            this.f1532a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public DocumentConversion(long j) {
        this.f1532a = j;
    }

    public int tryConvert() throws PDFNetException {
        return TryConvert(this.f1532a);
    }

    public void convert() throws PDFNetException {
        Convert(this.f1532a);
    }

    public void convertNextPage() throws PDFNetException {
        ConvertNextPage(this.f1532a);
    }

    public PDFDoc getDoc() throws PDFNetException {
        return PDFDoc.__Create(GetDoc(this.f1532a));
    }

    public int getConversionStatus() throws PDFNetException {
        return GetConversionStatus(this.f1532a);
    }

    public void cancelConversion() throws PDFNetException {
        CancelConversion(this.f1532a);
    }

    public boolean isCancelled() throws PDFNetException {
        return IsCancelled(this.f1532a);
    }

    public boolean hasProgressTracking() throws PDFNetException {
        return HasProgressTracking(this.f1532a);
    }

    public double getProgress() throws PDFNetException {
        return GetProgress(this.f1532a);
    }

    public String getProgressLabel() throws PDFNetException {
        return GetProgressLabel(this.f1532a);
    }

    public int getNumConvertedPages() throws PDFNetException {
        return GetNumConvertedPages(this.f1532a);
    }

    public String getErrorString() throws PDFNetException {
        return GetErrorString(this.f1532a);
    }

    public int getNumWarnings() throws PDFNetException {
        return GetNumWarnings(this.f1532a);
    }

    public String getWarningString(int i) throws PDFNetException {
        return GetWarningString(this.f1532a, i);
    }

    public String getCurrentExcelSheetName() throws PDFNetException {
        return GetCurrentExcelSheetName(this.f1532a);
    }

    public int getNextExcelSheetCellCount() throws PDFNetException {
        return GetNextExcelSheetCellCount(this.f1532a);
    }

    public void skipNextExcelSheet() throws PDFNetException {
        SkipNextExcelSheet(this.f1532a);
    }

    public long __GetHandle() {
        return this.f1532a;
    }

    public static DocumentConversion __Create(long j) {
        return new DocumentConversion(j);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
