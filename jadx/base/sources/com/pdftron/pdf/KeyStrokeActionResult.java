package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class KeyStrokeActionResult implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1580a;

    static native void Destroy(long j);

    static native String GetText(long j);

    static native boolean IsValid(long j);

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1580a);
    }

    public String getText() throws PDFNetException {
        return GetText(this.f1580a);
    }

    public void destroy() throws PDFNetException {
        long j = this.f1580a;
        if (j != 0) {
            Destroy(j);
            this.f1580a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    KeyStrokeActionResult(long j) {
        this.f1580a = j;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
