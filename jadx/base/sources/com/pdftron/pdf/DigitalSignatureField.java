package com.pdftron.pdf;

import com.pdftron.common.ByteRange;
import com.pdftron.common.PDFNetException;
import com.pdftron.crypto.AlgorithmIdentifier;
import com.pdftron.crypto.DigestAlgorithm;
import com.pdftron.crypto.ObjectIdentifier;
import com.pdftron.crypto.X509Certificate;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class DigitalSignatureField extends AbstractC6968g implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1518a;

    /* JADX INFO: renamed from: d */
    private Object f1519d;

    public enum FieldPermissions {
        e_lock_all,
        e_include,
        e_exclude
    }

    static native byte[] CalculateDigest(long j, int i);

    static native void CertifyOnNextSave(long j, String str, String str2);

    static native void CertifyOnNextSave(long j, byte[] bArr, String str);

    static native void CertifyOnNextSaveWithCustomHandler(long j, long j2);

    static native void ClearSignature(long j);

    static native long Create(long j);

    static native void CreateSigDictForCustomCertification(long j, String str, int i, int i2);

    static native void CreateSigDictForCustomSigning(long j, String str, int i, int i2);

    static native void Destroy(long j);

    static native boolean EnableLTVOfflineVerification(long j, long j2);

    static native byte[] GenerateCMSSignature(long j, long[] jArr, long j2, long j3, byte[] bArr, byte[] bArr2);

    static native byte[] GenerateCMSSignatureWithAlgoId(long j, long[] jArr, long j2, long j3, byte[] bArr, byte[] bArr2, long j4);

    static native byte[] GenerateCMSSignedAttributes(byte[] bArr, byte[] bArr2);

    static native long GenerateContentsWithEmbeddedTimestamp(long j, long j2, long j3);

    static native byte[] GenerateESSSigningCertPAdESAttribute(long j, int i);

    static native ByteRange[] GetByteRanges(long j);

    static native byte[] GetCert(long j, int i);

    static native int GetCertCount(long j);

    static native long[] GetCertPathsFromCMS(long j, int i);

    static native int GetCertPathsFromCMSGetSize(long j);

    static native String GetContactInfo(long j);

    static native int GetDocumentPermissions(long j);

    static native String GetLocation(long j);

    static native String[] GetLockedFields(long j);

    static native String GetReason(long j);

    static native long GetSDFObj(long j);

    static native String GetSignatureName(long j);

    static native long GetSignerCertFromCMS(long j);

    static native long GetSigningTime(long j);

    static native int GetSubFilter(long j);

    static native boolean HasCryptographicSignature(long j);

    static native boolean HasVisibleAppearance(long j);

    static native boolean IsCertification(long j);

    static native boolean IsLockedByDigitalSignature(long j);

    static native void SetContactInfo(long j, String str);

    static native boolean SetDigSigLogFilename(String str);

    static native void SetDocumentPermissions(long j, int i);

    static native void SetFieldPermissions(long j, int i);

    static native void SetFieldPermissions(long j, int i, String[] strArr);

    static native void SetLocation(long j, String str);

    static native void SetPreferredDigestAlgorithm(long j, int i, boolean z);

    static native void SetReason(long j, String str);

    static native void SetSigDictTimeOfSigning(long j, long j2);

    static native byte[] SignDigestBuffer(byte[] bArr, byte[] bArr2, String str, boolean z, int i);

    static native byte[] SignDigestPath(byte[] bArr, String str, String str2, boolean z, int i);

    static native void SignOnNextSave(long j, String str, String str2);

    static native void SignOnNextSave(long j, byte[] bArr, String str);

    static native void SignOnNextSaveWithCustomHandler(long j, long j2);

    static native void TimestampOnNextSave(long j, long j2, long j3);

    static native void UseSubFilter(long j, int i, boolean z);

    static native long Verify(long j, long j2);

    public enum SubFilterType {
        e_adbe_x509_rsa_sha1(0),
        e_adbe_pkcs7_detached(1),
        e_adbe_pkcs7_sha1(2),
        e_ETSI_CAdES_detached(3),
        e_ETSI_RFC3161(4),
        e_unknown(5),
        e_absent(6);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, SubFilterType> f1524b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1526a;

        static {
            for (SubFilterType subFilterType : values()) {
                f1524b.put(Integer.valueOf(subFilterType.f1526a), subFilterType);
            }
        }

        SubFilterType(int i) {
            this.f1526a = i;
        }

        /* JADX INFO: renamed from: a */
        static SubFilterType m1154a(int i) {
            return f1524b.get(Integer.valueOf(i));
        }
    }

    public enum DocumentPermissions {
        e_no_changes_allowed(1),
        e_formfilling_signing_allowed(2),
        e_annotating_formfilling_signing_allowed(3),
        e_unrestricted(4);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, DocumentPermissions> f1520b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1522a;

        static {
            for (DocumentPermissions documentPermissions : values()) {
                f1520b.put(Integer.valueOf(documentPermissions.f1522a), documentPermissions);
            }
        }

        DocumentPermissions(int i) {
            this.f1522a = i;
        }

        /* JADX INFO: renamed from: a */
        static DocumentPermissions m1153a(int i) {
            return f1520b.get(Integer.valueOf(i));
        }
    }

    public DigitalSignatureField(Field field) throws PDFNetException {
        this.f1518a = Create(field.__GetHandle());
        this.f1519d = field.__GetRefHandle();
        clearList();
    }

    public boolean hasCryptographicSignature() throws PDFNetException {
        return HasCryptographicSignature(this.f1518a);
    }

    public SubFilterType getSubFilter() throws PDFNetException {
        return SubFilterType.m1154a(GetSubFilter(this.f1518a));
    }

    public String getSignatureName() throws PDFNetException {
        return GetSignatureName(this.f1518a);
    }

    public Date getSigningTime() throws PDFNetException {
        return new Date(GetSigningTime(this.f1518a));
    }

    public String getLocation() throws PDFNetException {
        return GetLocation(this.f1518a);
    }

    public String getReason() throws PDFNetException {
        return GetReason(this.f1518a);
    }

    public String getContactInfo() throws PDFNetException {
        return GetContactInfo(this.f1518a);
    }

    public byte[] getCert(int i) throws PDFNetException {
        return GetCert(this.f1518a, i);
    }

    public int getCertCount() throws PDFNetException {
        return GetCertCount(this.f1518a);
    }

    public boolean hasVisibleAppearance() throws PDFNetException {
        return HasVisibleAppearance(this.f1518a);
    }

    public void setContactInfo(String str) throws PDFNetException {
        SetContactInfo(this.f1518a, str);
    }

    public void setLocation(String str) throws PDFNetException {
        SetLocation(this.f1518a, str);
    }

    public void setReason(String str) throws PDFNetException {
        SetReason(this.f1518a, str);
    }

    public void setDocumentPermissions(DocumentPermissions documentPermissions) throws PDFNetException {
        SetDocumentPermissions(this.f1518a, documentPermissions.f1522a);
    }

    public void setFieldPermissions(FieldPermissions fieldPermissions, String[] strArr) throws PDFNetException {
        SetFieldPermissions(this.f1518a, fieldPermissions.ordinal(), strArr);
    }

    public void setFieldPermissions(FieldPermissions fieldPermissions) throws PDFNetException {
        SetFieldPermissions(this.f1518a, fieldPermissions.ordinal());
    }

    public void signOnNextSave(String str, String str2) throws PDFNetException {
        SignOnNextSave(this.f1518a, str, str2);
    }

    public void signOnNextSave(byte[] bArr, String str) throws PDFNetException {
        SignOnNextSave(this.f1518a, bArr, str);
    }

    public void signOnNextSaveWithCustomHandler(long j) throws PDFNetException {
        SignOnNextSaveWithCustomHandler(this.f1518a, j);
    }

    public void certifyOnNextSave(String str, String str2) throws PDFNetException {
        CertifyOnNextSave(this.f1518a, str, str2);
    }

    public void certifyOnNextSave(byte[] bArr, String str) throws PDFNetException {
        CertifyOnNextSave(this.f1518a, bArr, str);
    }

    public void certifyOnNextSaveWithCustomHandler(long j) throws PDFNetException {
        CertifyOnNextSaveWithCustomHandler(this.f1518a, j);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.f1518a), this.f1519d);
    }

    public boolean isLockedByDigitalSignature() throws PDFNetException {
        return IsLockedByDigitalSignature(this.f1518a);
    }

    public String[] getLockedFields() throws PDFNetException {
        return GetLockedFields(this.f1518a);
    }

    public DocumentPermissions getDocumentPermissions() throws PDFNetException {
        return DocumentPermissions.m1153a(GetDocumentPermissions(this.f1518a));
    }

    public void clearSignature() throws PDFNetException {
        ClearSignature(this.f1518a);
    }

    public VerificationResult verify(VerificationOptions verificationOptions) throws PDFNetException {
        VerificationResult verificationResult = new VerificationResult(Verify(this.f1518a, verificationOptions.__GetHandle()), __GetRefHandle());
        ReachabilityHelper.ensureReachable(verificationOptions);
        return verificationResult;
    }

    public boolean isCertification() throws PDFNetException {
        return IsCertification(this.f1518a);
    }

    public X509Certificate getSignerCertFromCMS() throws PDFNetException {
        return new X509Certificate(GetSignerCertFromCMS(this.f1518a));
    }

    public ByteRange[] getByteRanges() throws PDFNetException {
        return GetByteRanges(this.f1518a);
    }

    public X509Certificate[][] getCertPathsFromCMS() throws PDFNetException {
        X509Certificate[][] x509CertificateArr = new X509Certificate[GetCertPathsFromCMSGetSize(this.f1518a)][];
        for (int i = 0; i < GetCertPathsFromCMSGetSize(this.f1518a); i++) {
            long[] jArrGetCertPathsFromCMS = GetCertPathsFromCMS(this.f1518a, i);
            x509CertificateArr[i] = new X509Certificate[jArrGetCertPathsFromCMS.length];
            for (int i2 = 0; i2 < jArrGetCertPathsFromCMS.length; i2++) {
                x509CertificateArr[i][i2] = new X509Certificate(jArrGetCertPathsFromCMS[i2]);
            }
        }
        return x509CertificateArr;
    }

    public boolean enableLTVOfflineVerification(VerificationResult verificationResult) throws PDFNetException {
        boolean zEnableLTVOfflineVerification = EnableLTVOfflineVerification(this.f1518a, verificationResult.__GetHandle());
        ReachabilityHelper.ensureReachable(verificationResult);
        return zEnableLTVOfflineVerification;
    }

    public void timestampOnNextSave(TimestampingConfiguration timestampingConfiguration, VerificationOptions verificationOptions) throws PDFNetException {
        TimestampOnNextSave(this.f1518a, timestampingConfiguration.__GetHandle(), verificationOptions.__GetHandle());
        ReachabilityHelper.ensureReachable(timestampingConfiguration);
        ReachabilityHelper.ensureReachable(verificationOptions);
    }

    public TimestampingResult generateContentsWithEmbeddedTimestamp(TimestampingConfiguration timestampingConfiguration, VerificationOptions verificationOptions) throws PDFNetException {
        TimestampingResult timestampingResult = new TimestampingResult(GenerateContentsWithEmbeddedTimestamp(this.f1518a, timestampingConfiguration.__GetHandle(), verificationOptions.__GetHandle()));
        ReachabilityHelper.ensureReachable(timestampingConfiguration);
        ReachabilityHelper.ensureReachable(verificationOptions);
        return timestampingResult;
    }

    public void useSubFilter(SubFilterType subFilterType, boolean z) throws PDFNetException {
        UseSubFilter(this.f1518a, subFilterType.f1526a, z);
    }

    public void useSubFilter(SubFilterType subFilterType) throws PDFNetException {
        UseSubFilter(this.f1518a, subFilterType.f1526a, true);
    }

    public byte[] calculateDigest() throws PDFNetException {
        return CalculateDigest(this.f1518a, DigestAlgorithm.e_sha256.value);
    }

    public byte[] calculateDigest(DigestAlgorithm digestAlgorithm) throws PDFNetException {
        return CalculateDigest(this.f1518a, digestAlgorithm.value);
    }

    public void setPreferredDigestAlgorithm(DigestAlgorithm digestAlgorithm, boolean z) throws PDFNetException {
        SetPreferredDigestAlgorithm(this.f1518a, digestAlgorithm.value, z);
    }

    public void setPreferredDigestAlgorithm(DigestAlgorithm digestAlgorithm) throws PDFNetException {
        SetPreferredDigestAlgorithm(this.f1518a, digestAlgorithm.value, true);
    }

    public void createSigDictForCustomCertification(String str, SubFilterType subFilterType, int i) throws PDFNetException {
        CreateSigDictForCustomCertification(this.f1518a, str, subFilterType.f1526a, i);
    }

    public void createSigDictForCustomSigning(String str, SubFilterType subFilterType, int i) throws PDFNetException {
        CreateSigDictForCustomSigning(this.f1518a, str, subFilterType.f1526a, i);
    }

    public void setSigDictTimeOfSigning(Date date) throws PDFNetException {
        SetSigDictTimeOfSigning(this.f1518a, date.f1515a);
        ReachabilityHelper.ensureReachable(date);
    }

    public static byte[] signDigest(byte[] bArr, String str, String str2, boolean z, DigestAlgorithm digestAlgorithm) throws PDFNetException {
        return SignDigestPath(bArr, str, str2, z, digestAlgorithm.value);
    }

    public static byte[] signDigest(byte[] bArr, byte[] bArr2, String str, boolean z, DigestAlgorithm digestAlgorithm) throws PDFNetException {
        return SignDigestBuffer(bArr, bArr2, str, z, digestAlgorithm.value);
    }

    public static byte[] generateESSSigningCertPAdESAttribute(X509Certificate x509Certificate, DigestAlgorithm digestAlgorithm) throws PDFNetException {
        byte[] bArrGenerateESSSigningCertPAdESAttribute = GenerateESSSigningCertPAdESAttribute(x509Certificate.__GetHandle(), digestAlgorithm.value);
        ReachabilityHelper.ensureReachable(x509Certificate);
        return bArrGenerateESSSigningCertPAdESAttribute;
    }

    public static byte[] generateCMSSignedAttributes(byte[] bArr, byte[] bArr2) throws PDFNetException {
        return GenerateCMSSignedAttributes(bArr, bArr2);
    }

    public static byte[] generateCMSSignedAttributes(byte[] bArr) throws PDFNetException {
        return GenerateCMSSignedAttributes(bArr, new byte[0]);
    }

    public static byte[] generateCMSSignature(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, ObjectIdentifier objectIdentifier, ObjectIdentifier objectIdentifier2, byte[] bArr, byte[] bArr2) throws PDFNetException {
        long[] jArr = new long[x509CertificateArr.length];
        for (int i = 0; i < x509CertificateArr.length; i++) {
            jArr[i] = x509CertificateArr[i].__GetHandle();
        }
        byte[] bArrGenerateCMSSignature = GenerateCMSSignature(x509Certificate.__GetHandle(), jArr, objectIdentifier.__GetHandle(), objectIdentifier2.__GetHandle(), bArr, bArr2);
        ReachabilityHelper.ensureReachable(x509Certificate);
        ReachabilityHelper.ensureReachable(objectIdentifier);
        ReachabilityHelper.ensureReachable(objectIdentifier2);
        ReachabilityHelper.ensureReachable(x509CertificateArr);
        return bArrGenerateCMSSignature;
    }

    public static byte[] generateCMSSignature(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, byte[] bArr2) throws PDFNetException {
        long[] jArr = new long[x509CertificateArr.length];
        for (int i = 0; i < x509CertificateArr.length; i++) {
            jArr[i] = x509CertificateArr[i].__GetHandle();
        }
        byte[] bArrGenerateCMSSignatureWithAlgoId = GenerateCMSSignatureWithAlgoId(x509Certificate.__GetHandle(), jArr, algorithmIdentifier.__GetHandle(), algorithmIdentifier2.__GetHandle(), bArr, bArr2, 0L);
        ReachabilityHelper.ensureReachable(x509Certificate);
        ReachabilityHelper.ensureReachable(algorithmIdentifier);
        ReachabilityHelper.ensureReachable(algorithmIdentifier2);
        ReachabilityHelper.ensureReachable(x509CertificateArr);
        return bArrGenerateCMSSignatureWithAlgoId;
    }

    public static byte[] generateCMSSignature(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr, AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, byte[] bArr2, CMSSignatureOptions cMSSignatureOptions) throws PDFNetException {
        long[] jArr = new long[x509CertificateArr.length];
        for (int i = 0; i < x509CertificateArr.length; i++) {
            jArr[i] = x509CertificateArr[i].__GetHandle();
        }
        byte[] bArrGenerateCMSSignatureWithAlgoId = GenerateCMSSignatureWithAlgoId(x509Certificate.__GetHandle(), jArr, algorithmIdentifier.__GetHandle(), algorithmIdentifier2.__GetHandle(), bArr, bArr2, cMSSignatureOptions.__GetHandle());
        ReachabilityHelper.ensureReachable(x509Certificate);
        ReachabilityHelper.ensureReachable(algorithmIdentifier);
        ReachabilityHelper.ensureReachable(algorithmIdentifier2);
        ReachabilityHelper.ensureReachable(x509CertificateArr);
        ReachabilityHelper.ensureReachable(cMSSignatureOptions);
        return bArrGenerateCMSSignatureWithAlgoId;
    }

    public static boolean setDigSigLogFilename(String str) throws PDFNetException {
        return SetDigSigLogFilename(str);
    }

    public long __GetHandle() {
        return this.f1518a;
    }

    DigitalSignatureField(long j, Object obj) throws PDFNetException {
        this.f1518a = j;
        this.f1519d = obj;
        clearList();
    }

    public static DigitalSignatureField __Create(long j, Object obj) throws PDFNetException {
        if (j == 0) {
            return null;
        }
        return new DigitalSignatureField(j, obj);
    }

    @Override // com.pdftron.pdf.AbstractC6968g, com.pdftron.pdf.__Delete
    public void destroy() throws PDFNetException {
        long j = this.f1518a;
        if (j == 0 || (this.f1519d instanceof DigitalSignatureFieldIterator)) {
            return;
        }
        Destroy(j);
        this.f1518a = 0L;
    }

    @Override // com.pdftron.pdf.AbstractC6968g
    protected void finalize() throws Throwable {
        destroy();
    }

    public Object __GetRefHandle() {
        return this.f1519d;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
