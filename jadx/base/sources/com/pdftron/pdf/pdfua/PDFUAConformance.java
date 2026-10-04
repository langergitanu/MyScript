package com.pdftron.pdf.pdfua;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class PDFUAConformance implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2160a;

    static native void AutoConvert(long j, String str, String str2, long j2);

    static native long Create();

    static native void Destroy(long j);

    public class Level {
        public static final int e_ua_level1 = 0;

        public Level(PDFUAConformance pDFUAConformance) {
        }
    }

    public void destroy() throws PDFNetException {
        long j = this.f2160a;
        if (j != 0) {
            Destroy(j);
            this.f2160a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public PDFUAConformance(long j) {
        this.f2160a = j;
    }

    public PDFUAConformance() {
        this.f2160a = Create();
    }

    public void autoConvert(String str, String str2) throws PDFNetException {
        autoConvert(str, str2, new PDFUAOptions());
    }

    public void autoConvert(String str, String str2, PDFUAOptions pDFUAOptions) throws PDFNetException {
        AutoConvert(this.f2160a, str, str2, pDFUAOptions.m1539a());
        ReachabilityHelper.ensureReachable(pDFUAOptions);
    }

    public long __GetHandle() {
        return this.f2160a;
    }

    public static PDFUAConformance __Create(long j) {
        return new PDFUAConformance(j);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
