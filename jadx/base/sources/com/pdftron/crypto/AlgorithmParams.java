package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AlgorithmParams implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1386a;

    static native void Destroy(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1386a;
        if (j != 0) {
            Destroy(j);
            this.f1386a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public AlgorithmParams(long j) {
        this.f1386a = j;
    }

    public long __GetHandle() {
        return this.f1386a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
