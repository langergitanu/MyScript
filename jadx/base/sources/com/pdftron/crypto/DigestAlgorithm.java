package com.pdftron.crypto;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public enum DigestAlgorithm {
    e_sha1(0),
    e_sha256(1),
    e_sha384(2),
    e_sha512(3),
    e_ripemd160(4),
    e_unknown_digest_algorithm(5);


    /* JADX INFO: renamed from: a */
    private static HashMap<Integer, DigestAlgorithm> f1387a = new HashMap<>();
    public final int value;

    static native byte[] CalculateDigest(int i, byte[] bArr);

    static native byte[] SignDigest(byte[] bArr, int i, String str, String str2);

    static native byte[] SignDigestWithKeyfileBuffer(byte[] bArr, int i, byte[] bArr2, String str);

    static {
        for (DigestAlgorithm digestAlgorithm : values()) {
            f1387a.put(Integer.valueOf(digestAlgorithm.value), digestAlgorithm);
        }
    }

    DigestAlgorithm(int i) {
        this.value = i;
    }

    public static DigestAlgorithm valueToEnum(int i) {
        return f1387a.get(Integer.valueOf(i));
    }

    public static byte[] calculateDigest(DigestAlgorithm digestAlgorithm, byte[] bArr) throws PDFNetException {
        return CalculateDigest(digestAlgorithm.value, bArr);
    }

    public static byte[] signDigest(byte[] bArr, DigestAlgorithm digestAlgorithm, String str, String str2) throws PDFNetException {
        return SignDigest(bArr, digestAlgorithm.value, str, str2);
    }

    public static byte[] signDigest(byte[] bArr, DigestAlgorithm digestAlgorithm, byte[] bArr2, String str) throws PDFNetException {
        return SignDigestWithKeyfileBuffer(bArr, digestAlgorithm.value, bArr2, str);
    }
}
