package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.crypto.DigestAlgorithm;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class VerificationResult implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private Object f2085a;

    /* JADX INFO: renamed from: b */
    private long f2086b;

    static native void Destroy(long j);

    static native int GetDigestAlgorithm(long j);

    static native int GetDigestStatus(long j);

    static native String GetDigestStatusAsString(long j);

    static native long GetDigitalSignatureField(long j);

    static native long[] GetDisallowedChanges(long j);

    static native int GetDocumentStatus(long j);

    static native String GetDocumentStatusAsString(long j);

    static native int GetPermissionsStatus(long j);

    static native String GetPermissionsStatusAsString(long j);

    static native int GetTrustStatus(long j);

    static native String GetTrustStatusAsString(long j);

    static native long GetTrustVerificationResult(long j);

    static native String[] GetUnsupportedFeatures(long j);

    static native boolean GetVerificationStatus(long j);

    static native boolean HasTrustVerificationResult(long j);

    public enum DocumentStatus {
        e_no_error(0),
        e_corrupt_file(1),
        e_unsigned(2),
        e_bad_byteranges(3),
        e_corrupt_cryptographic_contents(4);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, DocumentStatus> f2090b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        private int f2092a;

        static {
            for (DocumentStatus documentStatus : values()) {
                f2090b.put(Integer.valueOf(documentStatus.f2092a), documentStatus);
            }
        }

        DocumentStatus(int i) {
            this.f2092a = i;
        }

        /* JADX INFO: renamed from: a */
        static DocumentStatus m1499a(int i) {
            return f2090b.get(Integer.valueOf(i));
        }
    }

    public enum DigestStatus {
        e_digest_invalid(0),
        e_digest_verified(1),
        e_digest_verification_disabled(2),
        e_weak_digest_algorithm_but_digest_verifiable(3),
        e_no_digest_status(4),
        e_unsupported_encoding(5),
        e_unsupported_digest_algorithm(6);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, DigestStatus> f2087b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        private int f2089a;

        static {
            for (DigestStatus digestStatus : values()) {
                f2087b.put(Integer.valueOf(digestStatus.f2089a), digestStatus);
            }
        }

        DigestStatus(int i) {
            this.f2089a = i;
        }

        /* JADX INFO: renamed from: a */
        static DigestStatus m1498a(int i) {
            return f2087b.get(Integer.valueOf(i));
        }
    }

    public enum TrustStatus {
        e_trust_verified(0),
        e_untrusted(1),
        e_trust_verification_disabled(2),
        e_no_trust_status(3),
        e_unsupported_trust_features(4);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, TrustStatus> f2096b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        private int f2098a;

        static {
            for (TrustStatus trustStatus : values()) {
                f2096b.put(Integer.valueOf(trustStatus.f2098a), trustStatus);
            }
        }

        TrustStatus(int i) {
            this.f2098a = i;
        }

        /* JADX INFO: renamed from: a */
        static TrustStatus m1501a(int i) {
            return f2096b.get(Integer.valueOf(i));
        }
    }

    public enum ModificationPermissionsStatus {
        e_invalidated_by_disallowed_changes(0),
        e_has_allowed_changes(1),
        e_unmodified(2),
        e_permissions_verification_disabled(3),
        e_no_permissions_status(4),
        e_unsupported_permissions_features(5);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, ModificationPermissionsStatus> f2093b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        private int f2095a;

        static {
            for (ModificationPermissionsStatus modificationPermissionsStatus : values()) {
                f2093b.put(Integer.valueOf(modificationPermissionsStatus.f2095a), modificationPermissionsStatus);
            }
        }

        ModificationPermissionsStatus(int i) {
            this.f2095a = i;
        }

        /* JADX INFO: renamed from: a */
        static ModificationPermissionsStatus m1500a(int i) {
            return f2093b.get(Integer.valueOf(i));
        }
    }

    public void destroy() throws PDFNetException {
        long j = this.f2086b;
        if (j != 0) {
            Destroy(j);
            this.f2086b = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public VerificationResult(long j, Object obj) {
        this.f2086b = j;
        this.f2085a = obj;
    }

    public DigitalSignatureField getDigitalSignatureField() throws PDFNetException {
        return DigitalSignatureField.__Create(GetDigitalSignatureField(__GetHandle()), __GetRefHandle());
    }

    public boolean getVerificationStatus() throws PDFNetException {
        return GetVerificationStatus(this.f2086b);
    }

    public DocumentStatus getDocumentStatus() throws PDFNetException {
        return DocumentStatus.m1499a(GetDocumentStatus(this.f2086b));
    }

    public DigestStatus getDigestStatus() throws PDFNetException {
        return DigestStatus.m1498a(GetDigestStatus(this.f2086b));
    }

    public TrustStatus getTrustStatus() throws PDFNetException {
        return TrustStatus.m1501a(GetTrustStatus(this.f2086b));
    }

    public ModificationPermissionsStatus getPermissionsStatus() throws PDFNetException {
        return ModificationPermissionsStatus.m1500a(GetPermissionsStatus(this.f2086b));
    }

    public boolean hasTrustVerificationResult() throws PDFNetException {
        return HasTrustVerificationResult(this.f2086b);
    }

    public TrustVerificationResult getTrustVerificationResult() throws PDFNetException {
        return new TrustVerificationResult(GetTrustVerificationResult(this.f2086b));
    }

    public DisallowedChange[] getDisallowedChanges() throws PDFNetException {
        long[] jArrGetDisallowedChanges = GetDisallowedChanges(this.f2086b);
        DisallowedChange[] disallowedChangeArr = new DisallowedChange[jArrGetDisallowedChanges.length];
        for (int i = 0; i < jArrGetDisallowedChanges.length; i++) {
            disallowedChangeArr[i] = new DisallowedChange(jArrGetDisallowedChanges[i]);
        }
        return disallowedChangeArr;
    }

    public DigestAlgorithm getDigestAlgorithm() throws PDFNetException {
        return DigestAlgorithm.valueToEnum(GetDigestAlgorithm(this.f2086b));
    }

    public String getDocumentStatusAsString() throws PDFNetException {
        return GetDocumentStatusAsString(this.f2086b);
    }

    public String getDigestStatusAsString() throws PDFNetException {
        return GetDigestStatusAsString(this.f2086b);
    }

    public String getTrustStatusAsString() throws PDFNetException {
        return GetTrustStatusAsString(this.f2086b);
    }

    public String getPermissionsStatusAsString() throws PDFNetException {
        return GetPermissionsStatusAsString(this.f2086b);
    }

    public String[] getUnsupportedFeatures() throws PDFNetException {
        return GetUnsupportedFeatures(this.f2086b);
    }

    public long __GetHandle() {
        return this.f2086b;
    }

    public Object __GetRefHandle() {
        return this.f2085a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
