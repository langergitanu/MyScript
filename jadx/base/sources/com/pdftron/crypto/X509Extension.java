package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class X509Extension implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1395a;

    static native void Destroy(long j);

    static native int[] GetData(long j);

    static native long GetObjectIdentifier(long j);

    static native boolean IsCritical(long j);

    static native String ToString(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1395a;
        if (j != 0) {
            Destroy(j);
            this.f1395a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public X509Extension(long j) {
        this.f1395a = j;
    }

    public boolean isCritical() throws PDFNetException {
        return IsCritical(this.f1395a);
    }

    public long getObjectIdentifier() throws PDFNetException {
        return GetObjectIdentifier(this.f1395a);
    }

    public int[] getData() throws PDFNetException {
        return GetData(this.f1395a);
    }

    public String toString() {
        return ToString(this.f1395a);
    }

    public long __GetHandle() {
        return this.f1395a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
