package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;

/* JADX INFO: loaded from: classes7.dex */
public class Flattener implements AutoCloseable {
    public static final int e_default = 2;
    public static final int e_fast = 1;
    public static final int e_keep_all = 4;
    public static final int e_keep_most = 3;
    public static final int e_simple = 0;
    public static final int e_strict = 1;
    public static final int e_very_strict = 0;

    /* JADX INFO: renamed from: a */
    private long f1555a = FlattenerCreate();

    static native void Destroy(long j);

    static native long FlattenerCreate();

    static native void Process(long j, long j2, int i);

    static native void SetDPI(long j, int i);

    static native void SetJPGQuality(long j, int i);

    static native void SetMaximumImagePixels(long j, int i);

    static native void SetPreferJPG(long j, boolean z);

    static native void SetThreshold(long j, int i);

    public void setDPI(int i) throws PDFNetException {
        SetDPI(this.f1555a, i);
    }

    public void setMaximumImagePixels(int i) throws PDFNetException {
        SetMaximumImagePixels(this.f1555a, i);
    }

    public void setPreferJPG(boolean z) throws PDFNetException {
        SetPreferJPG(this.f1555a, z);
    }

    public void setJPGQuality(int i) throws PDFNetException {
        SetJPGQuality(this.f1555a, i);
    }

    public void SetThreshold(int i) throws PDFNetException {
        SetThreshold(this.f1555a, i);
    }

    public void Process(PDFDoc pDFDoc, int i) throws PDFNetException {
        Process(this.f1555a, pDFDoc.__GetHandle(), i);
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public void destroy() {
        long j = this.f1555a;
        if (j != 0) {
            Destroy(j);
            this.f1555a = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
