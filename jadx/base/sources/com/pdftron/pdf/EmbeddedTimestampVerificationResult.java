package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.crypto.DigestAlgorithm;
import com.pdftron.pdf.VerificationResult;

/* JADX INFO: loaded from: classes7.dex */
public class EmbeddedTimestampVerificationResult implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1539a;

    static native void Destroy(long j);

    static native int GetCMSDigestStatus(long j);

    static native String GetCMSDigestStatusAsString(long j);

    static native int GetCMSSignatureDigestAlgorithm(long j);

    static native int GetMessageImprintDigestAlgorithm(long j);

    static native int GetMessageImprintDigestStatus(long j);

    static native String GetMessageImprintDigestStatusAsString(long j);

    static native int GetTrustStatus(long j);

    static native String GetTrustStatusAsString(long j);

    static native long GetTrustVerificationResult(long j);

    static native String[] GetUnsupportedFeatures(long j);

    static native boolean GetVerificationStatus(long j);

    static native boolean HasTrustVerificationResult(long j);

    public void destroy() throws PDFNetException {
        long j = this.f1539a;
        if (j != 0) {
            Destroy(j);
            this.f1539a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public EmbeddedTimestampVerificationResult(long j) {
        this.f1539a = j;
    }

    public boolean getVerificationStatus() throws PDFNetException {
        return GetVerificationStatus(this.f1539a);
    }

    public VerificationResult.DigestStatus getCMSDigestStatus() throws PDFNetException {
        return VerificationResult.DigestStatus.m1498a(GetCMSDigestStatus(this.f1539a));
    }

    public VerificationResult.DigestStatus getMessageImprintDigestStatus() throws PDFNetException {
        return VerificationResult.DigestStatus.m1498a(GetMessageImprintDigestStatus(this.f1539a));
    }

    public VerificationResult.TrustStatus getTrustStatus() throws PDFNetException {
        return VerificationResult.TrustStatus.m1501a(GetTrustStatus(this.f1539a));
    }

    public String getCMSDigestStatusAsString() throws PDFNetException {
        return GetCMSDigestStatusAsString(this.f1539a);
    }

    public String getMessageImprintDigestStatusAsString() throws PDFNetException {
        return GetMessageImprintDigestStatusAsString(this.f1539a);
    }

    public String getTrustStatusAsString() throws PDFNetException {
        return GetTrustStatusAsString(this.f1539a);
    }

    public boolean hasTrustVerificationResult() throws PDFNetException {
        return HasTrustVerificationResult(this.f1539a);
    }

    public TrustVerificationResult getTrustVerificationResult() throws PDFNetException {
        return new TrustVerificationResult(GetTrustVerificationResult(this.f1539a));
    }

    public DigestAlgorithm getCMSSignatureDigestAlgorithm() throws PDFNetException {
        return DigestAlgorithm.valueToEnum(GetCMSSignatureDigestAlgorithm(this.f1539a));
    }

    public DigestAlgorithm getMessageImprintDigestAlgorithm() throws PDFNetException {
        return DigestAlgorithm.valueToEnum(GetMessageImprintDigestAlgorithm(this.f1539a));
    }

    public String[] getUnsupportedFeatures() throws PDFNetException {
        return GetUnsupportedFeatures(this.f1539a);
    }

    public long __GetHandle() {
        return this.f1539a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
