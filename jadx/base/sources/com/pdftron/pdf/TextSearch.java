package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.ocg.Context;

/* JADX INFO: loaded from: classes7.dex */
public class TextSearch implements AutoCloseable {
    public static final int e_ambient_string = 64;
    public static final int e_case_sensitive = 2;
    public static final int e_highlight = 32;
    public static final int e_page_stop = 16;
    public static final int e_raw_text_search = 128;
    public static final int e_reg_expression = 1;
    public static final int e_search_up = 8;
    public static final int e_search_using_zorder = 256;
    public static final int e_whole_word = 4;

    /* JADX INFO: renamed from: a */
    private long f2072a = TextSearchCreate();

    static native boolean Begin(long j, long j2, String str, int i, int i2, int i3);

    static native void Delete(long j);

    static native int GetCurrentPage(long j);

    static native int GetMode(long j);

    static native TextSearchResult Run(long j);

    static native void SetAmbientLettersAfter(long j, int i);

    static native void SetAmbientLettersBefore(long j, int i);

    static native void SetAmbientWordsAfter(long j, int i);

    static native void SetAmbientWordsBefore(long j, int i);

    static native void SetMode(long j, int i);

    static native void SetOCGContext(long j, long j2);

    static native boolean SetPattern(long j, String str);

    static native void SetRightToLeftLanguage(long j, boolean z);

    static native long TextSearchCreate();

    public void destroy() {
        long j = this.f2072a;
        if (j != 0) {
            Delete(j);
            this.f2072a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public boolean begin(PDFDoc pDFDoc, String str, int i, int i2, int i3) {
        boolean zBegin = Begin(this.f2072a, pDFDoc.__GetHandle(), str, i, i2, i3);
        ReachabilityHelper.ensureReachable(pDFDoc);
        return zBegin;
    }

    public TextSearchResult run() {
        TextSearchResult textSearchResultRun = Run(this.f2072a);
        textSearchResultRun.highlights.f1567b = this;
        return textSearchResultRun;
    }

    public boolean setPattern(String str) {
        return SetPattern(this.f2072a, str);
    }

    public int getMode() {
        return GetMode(this.f2072a);
    }

    public void setMode(int i) {
        SetMode(this.f2072a, i);
    }

    public int getCurrentPage() {
        return GetCurrentPage(this.f2072a);
    }

    public void setRightToLeftLanguage(boolean z) {
        SetRightToLeftLanguage(this.f2072a, z);
    }

    public void setAmbientLettersBefore(int i) throws PDFNetException {
        SetAmbientLettersBefore(this.f2072a, i);
    }

    public void setAmbientLettersAfter(int i) throws PDFNetException {
        SetAmbientLettersAfter(this.f2072a, i);
    }

    public void setAmbientWordsBefore(int i) throws PDFNetException {
        SetAmbientWordsBefore(this.f2072a, i);
    }

    public void setAmbientWordsAfter(int i) throws PDFNetException {
        SetAmbientWordsAfter(this.f2072a, i);
    }

    public void setOCGContext(Context context) {
        if (context == null) {
            SetOCGContext(this.f2072a, 0L);
        } else {
            SetOCGContext(this.f2072a, context.__GetHandle());
            ReachabilityHelper.ensureReachable(context);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
