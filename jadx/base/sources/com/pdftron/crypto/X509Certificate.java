package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class X509Certificate implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1394a;

    static native long CreateFromBuffer(byte[] bArr);

    static native long CreateFromFile(String str);

    static native void Destroy(long j);

    static native byte[] GetData(long j);

    static native long[] GetExtensions(long j);

    static native String GetFingerprint(long j, int i);

    static native long GetIssuerField(long j);

    static native long GetNotAfterEpochTime(long j);

    static native long GetNotBeforeEpochTime(long j);

    static native int GetRawX509VersionNumber(long j);

    static native byte[] GetSerialNumber(long j);

    static native long GetSubjectField(long j);

    static native String ToString(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1394a;
        if (j != 0) {
            Destroy(j);
            this.f1394a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public X509Certificate(long j) {
        this.f1394a = j;
    }

    public X509Certificate(String str) throws PDFNetException {
        this.f1394a = CreateFromFile(str);
    }

    public X509Certificate(byte[] bArr) throws PDFNetException {
        this.f1394a = CreateFromBuffer(bArr);
    }

    public X501DistinguishedName getIssuerField() throws PDFNetException {
        return new X501DistinguishedName(GetIssuerField(this.f1394a));
    }

    public X501DistinguishedName getSubjectField() throws PDFNetException {
        return new X501DistinguishedName(GetSubjectField(this.f1394a));
    }

    public long getNotBeforeEpochTime() throws PDFNetException {
        return GetNotBeforeEpochTime(this.f1394a);
    }

    public long getNotAfterEpochTime() throws PDFNetException {
        return GetNotAfterEpochTime(this.f1394a);
    }

    public int getRawX509VersionNumber() throws PDFNetException {
        return GetRawX509VersionNumber(this.f1394a);
    }

    public String toString() {
        return ToString(this.f1394a);
    }

    public String getFingerprint(DigestAlgorithm digestAlgorithm) throws PDFNetException {
        return GetFingerprint(this.f1394a, digestAlgorithm.value);
    }

    public String getFingerprint() throws PDFNetException {
        return getFingerprint(DigestAlgorithm.e_sha256);
    }

    public byte[] getSerialNumber() throws PDFNetException {
        return GetSerialNumber(this.f1394a);
    }

    public X509Extension[] getExtensions() throws PDFNetException {
        long[] jArrGetExtensions = GetExtensions(this.f1394a);
        X509Extension[] x509ExtensionArr = new X509Extension[jArrGetExtensions.length];
        for (int i = 0; i < jArrGetExtensions.length; i++) {
            x509ExtensionArr[i] = new X509Extension(jArrGetExtensions[i]);
        }
        return x509ExtensionArr;
    }

    public byte[] getData() throws PDFNetException {
        return GetData(this.f1394a);
    }

    public long __GetHandle() {
        return this.f1394a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
