package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.crypto.X509Certificate;
import com.pdftron.pdf.VerificationOptions;

/* JADX INFO: loaded from: classes7.dex */
public class TrustVerificationResult implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2075a;

    static native void Destroy(long j);

    static native long[] GetCertPath(long j);

    static native long GetEmbeddedTimestampVerificationResult(long j);

    static native String GetResultString(long j);

    static native long GetTimeOfTrustVerification(long j);

    static native int GetTimeOfTrustVerificationEnum(long j);

    static native boolean HasEmbeddedTimestampVerificationResult(long j);

    static native boolean WasSuccessful(long j);

    public void destroy() throws PDFNetException {
        long j = this.f2075a;
        if (j != 0) {
            Destroy(j);
            this.f2075a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public TrustVerificationResult(long j) {
        this.f2075a = j;
    }

    public boolean wasSuccessful() throws PDFNetException {
        return WasSuccessful(this.f2075a);
    }

    public String getResultString() throws PDFNetException {
        return GetResultString(this.f2075a);
    }

    public long getTimeOfTrustVerification() throws PDFNetException {
        return GetTimeOfTrustVerification(this.f2075a);
    }

    public VerificationOptions.TimeMode getTimeOfTrustVerificationEnum() throws PDFNetException {
        return VerificationOptions.TimeMode.m1497a(GetTimeOfTrustVerificationEnum(this.f2075a));
    }

    public boolean hasEmbeddedTimestampVerificationResult() throws PDFNetException {
        return HasEmbeddedTimestampVerificationResult(this.f2075a);
    }

    public EmbeddedTimestampVerificationResult getEmbeddedTimestampVerificationResult() throws PDFNetException {
        return new EmbeddedTimestampVerificationResult(GetEmbeddedTimestampVerificationResult(this.f2075a));
    }

    public X509Certificate[] getCertPath() throws PDFNetException {
        long[] jArrGetCertPath = GetCertPath(this.f2075a);
        X509Certificate[] x509CertificateArr = new X509Certificate[jArrGetCertPath.length];
        for (int i = 0; i < jArrGetCertPath.length; i++) {
            x509CertificateArr[i] = new X509Certificate(jArrGetCertPath[i]);
        }
        return x509CertificateArr;
    }

    public long __GetHandle() {
        return this.f2075a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
