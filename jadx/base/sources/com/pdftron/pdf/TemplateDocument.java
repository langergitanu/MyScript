package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class TemplateDocument implements AutoCloseable {
    public static final int e_failure = 2;
    public static final int e_incomplete = 1;
    public static final int e_success = 0;

    /* JADX INFO: renamed from: a */
    private long f2058a;

    static native void CancelConversion(long j);

    static native void Destroy(long j);

    static native long FillTemplateJson(long j, String str);

    static native void FillTemplateJsonToOffice(long j, String str, String str2);

    static native void FillTemplateJsonToOfficeWithFilter(long j, String str, long j2);

    static native int GetConversionStatus(long j);

    static native String GetErrorString(long j);

    static native int GetNumWarnings(long j);

    static native String GetTemplateKeysJson(long j);

    static native String GetWarningString(long j, int i);

    static native boolean IsCancelled(long j);

    public void destroy() throws PDFNetException {
        long j = this.f2058a;
        if (j != 0) {
            Destroy(j);
            this.f2058a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public TemplateDocument(long j) {
        this.f2058a = j;
    }

    public PDFDoc fillTemplateJson(String str) throws PDFNetException {
        return PDFDoc.__Create(FillTemplateJson(this.f2058a, str));
    }

    public void fillTemplateJsonToOffice(String str, String str2) throws PDFNetException {
        FillTemplateJsonToOffice(this.f2058a, str, str2);
    }

    public void fillTemplateJsonToOfficeWithFilter(String str, Filter filter) throws PDFNetException {
        FillTemplateJsonToOfficeWithFilter(this.f2058a, str, filter.__GetHandle());
        ReachabilityHelper.ensureReachable(filter);
    }

    public String getTemplateKeysJson() throws PDFNetException {
        return GetTemplateKeysJson(this.f2058a);
    }

    public String getErrorString() throws PDFNetException {
        return GetErrorString(this.f2058a);
    }

    public int getConversionStatus() throws PDFNetException {
        return GetConversionStatus(this.f2058a);
    }

    public void cancelConversion() throws PDFNetException {
        CancelConversion(this.f2058a);
    }

    public boolean isCancelled() throws PDFNetException {
        return IsCancelled(this.f2058a);
    }

    public int getNumWarnings() throws PDFNetException {
        return GetNumWarnings(this.f2058a);
    }

    public String getWarningString(int i) throws PDFNetException {
        return GetWarningString(this.f2058a, i);
    }

    public long __GetHandle() {
        return this.f2058a;
    }

    public static TemplateDocument __Create(long j) {
        return new TemplateDocument(j);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
