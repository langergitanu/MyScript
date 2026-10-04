package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.crypto.X509Certificate;
import com.pdftron.fdf.FDFDoc;
import com.pdftron.helpers.ReachabilityHelper;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class VerificationOptions implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f2076a;

    static native void AddTrustedCertificate(long j, byte[] bArr);

    static native void AddTrustedCertificateFlags(long j, byte[] bArr, long j2);

    static native void AddTrustedCertificateString(long j, String str);

    static native void AddTrustedCertificateStringFlags(long j, String str, long j2);

    static native void AddTrustedCertificates(long j, byte[] bArr);

    static native long Create(int i);

    static native void Destroy(long j);

    static native void EnableDigestVerification(long j, boolean z);

    static native void EnableModificationVerification(long j, boolean z);

    static native void EnableOnlineCRLRevocationChecking(long j, boolean z);

    static native void EnableOnlineOCSPRevocationChecking(long j, boolean z);

    static native void EnableOnlineRevocationChecking(long j, boolean z);

    static native void EnableTrustVerification(long j, boolean z);

    static native long GetTrustedCertificate(long j, int i);

    static native int GetTrustedCertificateCount(long j);

    static native void LoadTrustList(long j, long j2);

    static native void SetRevocationTimeout(long j, long j2);

    public enum SecurityLevel {
        e_compatibility_and_archiving(0),
        e_maximum(1);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, SecurityLevel> f2079b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f2081a;

        static {
            for (SecurityLevel securityLevel : values()) {
                f2079b.put(Integer.valueOf(securityLevel.f2081a), securityLevel);
            }
        }

        SecurityLevel(int i) {
            this.f2081a = i;
        }
    }

    public enum TimeMode {
        e_signing(0),
        e_timestamp(1),
        e_current(2);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, TimeMode> f2082b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        private int f2084a;

        static {
            for (TimeMode timeMode : values()) {
                f2082b.put(Integer.valueOf(timeMode.f2084a), timeMode);
            }
        }

        TimeMode(int i) {
            this.f2084a = i;
        }

        /* JADX INFO: renamed from: a */
        static TimeMode m1497a(int i) {
            return f2082b.get(Integer.valueOf(i));
        }
    }

    public enum CertificateTrustFlag {
        e_signing_trust(1),
        e_certification_trust(2),
        e_dynamic_content(4),
        e_javascript(16),
        e_identity(32),
        e_trust_anchor(64),
        e_default_trust(97),
        e_complete_trust(119);


        /* JADX INFO: renamed from: a */
        private static HashMap<Integer, CertificateTrustFlag> f2077a = new HashMap<>();
        public final int value;

        static {
            for (CertificateTrustFlag certificateTrustFlag : values()) {
                f2077a.put(Integer.valueOf(certificateTrustFlag.value), certificateTrustFlag);
            }
        }

        CertificateTrustFlag(int i) {
            this.value = i;
        }
    }

    public void destroy() throws PDFNetException {
        long j = this.f2076a;
        if (j != 0) {
            Destroy(j);
            this.f2076a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public VerificationOptions(long j) {
        this.f2076a = j;
    }

    public VerificationOptions(SecurityLevel securityLevel) throws PDFNetException {
        this.f2076a = Create(securityLevel.f2081a);
    }

    public void addTrustedCertificate(byte[] bArr, long j) throws PDFNetException {
        AddTrustedCertificateFlags(this.f2076a, bArr, j);
    }

    public void addTrustedCertificate(byte[] bArr) throws PDFNetException {
        AddTrustedCertificate(this.f2076a, bArr);
    }

    public void addTrustedCertificate(String str, long j) throws PDFNetException {
        AddTrustedCertificateStringFlags(this.f2076a, str, j);
    }

    public void addTrustedCertificate(String str) throws PDFNetException {
        AddTrustedCertificateString(this.f2076a, str);
    }

    public void addTrustedCertificates(byte[] bArr) throws PDFNetException {
        AddTrustedCertificates(this.f2076a, bArr);
    }

    public void loadTrustList(FDFDoc fDFDoc) throws PDFNetException {
        LoadTrustList(this.f2076a, fDFDoc.__GetHandle());
        ReachabilityHelper.ensureReachable(fDFDoc);
    }

    public void enableModificationVerification(boolean z) throws PDFNetException {
        EnableModificationVerification(this.f2076a, z);
    }

    public void enableDigestVerification(boolean z) throws PDFNetException {
        EnableDigestVerification(this.f2076a, z);
    }

    public void enableTrustVerification(boolean z) throws PDFNetException {
        EnableTrustVerification(this.f2076a, z);
    }

    public void setRevocationTimeout(long j) throws PDFNetException {
        SetRevocationTimeout(this.f2076a, j);
    }

    public void enableOnlineCRLRevocationChecking(boolean z) throws PDFNetException {
        EnableOnlineCRLRevocationChecking(this.f2076a, z);
    }

    public void enableOnlineOCSPRevocationChecking(boolean z) throws PDFNetException {
        EnableOnlineOCSPRevocationChecking(this.f2076a, z);
    }

    public void enableOnlineRevocationChecking(boolean z) throws PDFNetException {
        EnableOnlineRevocationChecking(this.f2076a, z);
    }

    public long __GetHandle() {
        return this.f2076a;
    }

    public int getTrustedCertificateCount() throws PDFNetException {
        return GetTrustedCertificateCount(this.f2076a);
    }

    public X509Certificate getTrustedCertificate(int i) throws PDFNetException {
        return new X509Certificate(GetTrustedCertificate(this.f2076a, i));
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
