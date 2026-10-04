package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectIdentifier implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1389a;

    static native long CreateFromDigestAlgorithm(int i);

    static native long CreateFromIntArr(int[] iArr);

    static native long CreateFromPredefined(int i);

    static native void Destroy(long j);

    static native int[] GetRawValue(long j);

    public enum Predefined {
        common_name(0),
        surname(1),
        country_name(2),
        locality_name(3),
        state_or_province_name(4),
        street_address(5),
        organization_name(6),
        organizational_unit_name(7),
        SHA1(8),
        SHA256(9),
        SHA384(10),
        SHA512(11),
        RIPEMD160(12),
        RSA_encryption_PKCS1(13),
        RSASSA_PSS(14),
        MGF1(15);


        /* JADX INFO: renamed from: a */
        private final int f1391a;

        Predefined(int i) {
            this.f1391a = i;
        }

        public final int getValue() {
            return this.f1391a;
        }
    }

    public void destroy() throws PDFNetException {
        long j = this.f1389a;
        if (j != 0) {
            Destroy(j);
            this.f1389a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    ObjectIdentifier(long j) {
        this.f1389a = j;
    }

    public ObjectIdentifier(Predefined predefined) throws PDFNetException {
        this.f1389a = CreateFromPredefined(predefined.getValue());
    }

    public ObjectIdentifier(DigestAlgorithm digestAlgorithm) throws PDFNetException {
        this.f1389a = CreateFromDigestAlgorithm(digestAlgorithm.value);
    }

    public int[] getRawValue() throws PDFNetException {
        return GetRawValue(this.f1389a);
    }

    public ObjectIdentifier(int[] iArr) throws PDFNetException {
        this.f1389a = CreateFromIntArr(iArr);
    }

    public long __GetHandle() {
        return this.f1389a;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
