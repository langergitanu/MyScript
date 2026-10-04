package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class KeyStrokeEventData implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    long f1581a;

    static native void Destroy(long j);

    static native long KeyStrokeEventDataCreate(String str, String str2, String str3, int i, int i2);

    public KeyStrokeEventData(String str, String str2, String str3, int i, int i2) throws PDFNetException {
        this.f1581a = KeyStrokeEventDataCreate(str, str2, str3, i, i2);
    }

    public void destroy() throws PDFNetException {
        long j = this.f1581a;
        if (j != 0) {
            Destroy(j);
            this.f1581a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
