package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
final class Ed25519Constants {

    /* JADX INFO: renamed from: B2 */
    static final Ed25519.CachedXYT[] f1229B2;
    static final Ed25519.CachedXYT[][] B_TABLE;

    /* JADX INFO: renamed from: D */
    static final long[] f1230D;

    /* JADX INFO: renamed from: D2 */
    static final long[] f1231D2;
    private static final BigInteger D2_BI;
    private static final BigInteger D_BI;
    private static final BigInteger P_BI;
    static final long[] SQRTM1;
    private static final BigInteger SQRTM1_BI;

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        P_BI = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        D_BI = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        D2_BI = bigIntegerMod2;
        BigInteger bigIntegerModPow = BigInteger.valueOf(2L).modPow(bigIntegerSubtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        SQRTM1_BI = bigIntegerModPow;
        Point point = new Point();
        point.f1233y = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        point.f1232x = recoverX(point.f1233y);
        f1230D = Field25519.expand(toLittleEndian(bigIntegerMod));
        f1231D2 = Field25519.expand(toLittleEndian(bigIntegerMod2));
        SQRTM1 = Field25519.expand(toLittleEndian(bigIntegerModPow));
        B_TABLE = (Ed25519.CachedXYT[][]) Array.newInstance((Class<?>) Ed25519.CachedXYT.class, 32, 8);
        Point pointEdwards = point;
        for (int i = 0; i < 32; i++) {
            Point pointEdwards2 = pointEdwards;
            for (int i2 = 0; i2 < 8; i2++) {
                B_TABLE[i][i2] = getCachedXYT(pointEdwards2);
                pointEdwards2 = edwards(pointEdwards2, pointEdwards);
            }
            for (int i3 = 0; i3 < 8; i3++) {
                pointEdwards = edwards(pointEdwards, pointEdwards);
            }
        }
        Point pointEdwards3 = edwards(point, point);
        f1229B2 = new Ed25519.CachedXYT[8];
        for (int i4 = 0; i4 < 8; i4++) {
            f1229B2[i4] = getCachedXYT(point);
            point = edwards(point, pointEdwards3);
        }
    }

    private static class Point {

        /* JADX INFO: renamed from: x */
        private BigInteger f1232x;

        /* JADX INFO: renamed from: y */
        private BigInteger f1233y;

        private Point() {
        }
    }

    private static BigInteger recoverX(BigInteger y) {
        BigInteger bigIntegerSubtract = y.pow(2).subtract(BigInteger.ONE);
        BigInteger bigIntegerAdd = D_BI.multiply(y.pow(2)).add(BigInteger.ONE);
        BigInteger bigInteger = P_BI;
        BigInteger bigIntegerMultiply = bigIntegerSubtract.multiply(bigIntegerAdd.modInverse(bigInteger));
        BigInteger bigIntegerModPow = bigIntegerMultiply.modPow(bigInteger.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger);
        if (!bigIntegerModPow.pow(2).subtract(bigIntegerMultiply).mod(bigInteger).equals(BigInteger.ZERO)) {
            bigIntegerModPow = bigIntegerModPow.multiply(SQRTM1_BI).mod(bigInteger);
        }
        return bigIntegerModPow.testBit(0) ? bigInteger.subtract(bigIntegerModPow) : bigIntegerModPow;
    }

    private static Point edwards(Point a2, Point b) {
        Point point = new Point();
        BigInteger bigIntegerMultiply = D_BI.multiply(a2.f1232x.multiply(b.f1232x).multiply(a2.f1233y).multiply(b.f1233y));
        BigInteger bigInteger = P_BI;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        point.f1232x = a2.f1232x.multiply(b.f1233y).add(b.f1232x.multiply(a2.f1233y)).multiply(BigInteger.ONE.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        point.f1233y = a2.f1233y.multiply(b.f1233y).add(a2.f1232x.multiply(b.f1232x)).multiply(BigInteger.ONE.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return point;
    }

    private static byte[] toLittleEndian(BigInteger n) {
        byte[] bArr = new byte[32];
        byte[] byteArray = n.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            int i2 = 31 - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point p) {
        BigInteger bigIntegerAdd = p.f1233y.add(p.f1232x);
        BigInteger bigInteger = P_BI;
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(bigIntegerAdd.mod(bigInteger))), Field25519.expand(toLittleEndian(p.f1233y.subtract(p.f1232x).mod(bigInteger))), Field25519.expand(toLittleEndian(D2_BI.multiply(p.f1232x).multiply(p.f1233y).mod(bigInteger))));
    }

    private Ed25519Constants() {
    }
}
