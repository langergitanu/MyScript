package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class X501AttributeTypeAndValue implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1392a;

    static native void Destroy(long j);

    static native long GetAttributeTypeOID(long j);

    static native String GetStringValue(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1392a;
        if (j != 0) {
            Destroy(j);
            this.f1392a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public X501AttributeTypeAndValue(long j) {
        this.f1392a = j;
    }

    public ObjectIdentifier getAttributeTypeOID() throws PDFNetException {
        return new ObjectIdentifier(GetAttributeTypeOID(this.f1392a));
    }

    public String getStringValue() throws PDFNetException {
        return GetStringValue(this.f1392a);
    }

    public long __GetHandle() {
        return this.f1392a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
