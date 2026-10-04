package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class CMSSignatureOptions implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1454a;

    static native void AddTimestampToken(long j, byte[] bArr);

    static native long Create();

    static native void Destroy(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1454a;
        if (j != 0) {
            Destroy(j);
            this.f1454a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public CMSSignatureOptions(long j) {
        this.f1454a = j;
    }

    public CMSSignatureOptions() throws PDFNetException {
        this.f1454a = Create();
    }

    public void addTimestampToken(byte[] bArr) throws PDFNetException {
        AddTimestampToken(this.f1454a, bArr);
    }

    public long __GetHandle() {
        return this.f1454a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
