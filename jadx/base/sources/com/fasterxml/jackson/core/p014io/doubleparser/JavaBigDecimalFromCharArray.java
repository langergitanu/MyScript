package com.fasterxml.jackson.core.p014io.doubleparser;

import androidx.collection.SieveCacheKt;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NavigableMap;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes5.dex */
final class JavaBigDecimalFromCharArray extends AbstractNumberParser {
    private static final int MANY_DIGITS_THRESHOLD = 32;
    private static final int MAX_DIGIT_COUNT = 1292782621;
    private static final long MAX_EXPONENT_NUMBER = 2147483647L;
    public static final int MAX_INPUT_LENGTH = 1292782635;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r28v0, types: [com.fasterxml.jackson.core.io.doubleparser.JavaBigDecimalFromCharArray] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDecimal parseBigDecimalString(char[] cArr, int i, int i2) {
        ?? r1;
        char c;
        int i3;
        boolean z;
        String str;
        long j;
        ?? r6;
        boolean z2;
        int i4;
        long j2;
        int i5;
        int iTryToParseFourDigits;
        int i6 = i;
        try {
            if (i2 >= 32) {
                return parseBigDecimalStringWithManyDigits(cArr, i, i2);
            }
            r1 = i2 + i6;
            char cCharAt = charAt(cArr, i6, (int) r1);
            boolean z3 = cCharAt == '-';
            try {
                if ((z3 || cCharAt == '+') && (cCharAt = charAt(cArr, i6, (int) r1)) == 0) {
                    throw new NumberFormatException("illegal syntax");
                }
                int i7 = -1;
                int i8 = i6;
                char c2 = cCharAt;
                long j3 = 0;
                boolean z4 = false;
                while (true) {
                    if (i8 >= r1) {
                        c = c2;
                        break;
                    }
                    c = cArr[i8];
                    if (!FastDoubleSwar.isDigit(c)) {
                        if (c != '.') {
                            break;
                        }
                        z4 |= i7 >= 0;
                        int i9 = i8;
                        while (i9 < r1 - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(cArr, i9 + 1)) >= 0) {
                            j3 = (j3 * 10000) + ((long) iTryToParseFourDigits);
                            i9 += 4;
                        }
                        i7 = i8;
                        i8 = i9;
                    } else {
                        j3 = ((j3 * 10) + ((long) c)) - 48;
                    }
                    i8++;
                    c2 = c;
                }
                if (i7 < 0) {
                    i3 = i8 - i6;
                    z = true;
                    str = "value exceeds limits";
                    i7 = i8;
                    j = 0;
                } else {
                    i3 = (i8 - i6) - 1;
                    z = true;
                    str = "value exceeds limits";
                    j = (i7 - i8) + 1;
                }
                if ((c | TokenParser.f2383SP) == 101) {
                    int i10 = i8 + 1;
                    try {
                        char cCharAt2 = charAt(cArr, i10, (int) r1);
                        boolean z5 = cCharAt2 == '-' ? z : false;
                        if (z5 || cCharAt2 == '+') {
                            i10 = i8 + 2;
                            cCharAt2 = charAt(cArr, i10, (int) r1);
                        }
                        z4 |= !FastDoubleSwar.isDigit(cCharAt2);
                        long j4 = 0;
                        while (true) {
                            if (j4 < 2147483647L) {
                                z2 = z5;
                                i4 = i10;
                                j4 = ((j4 * 10) + ((long) cCharAt2)) - 48;
                            } else {
                                z2 = z5;
                                i4 = i10;
                            }
                            j2 = j4;
                            i5 = i4 + 1;
                            cCharAt2 = charAt(cArr, i5, (int) r1);
                            if (!FastDoubleSwar.isDigit(cCharAt2)) {
                                break;
                            }
                            j4 = j2;
                            i10 = i5;
                            z5 = z2;
                        }
                        if (z2) {
                            j2 = -j2;
                        }
                        j += j2;
                        r6 = i8;
                        i8 = i5;
                    } catch (ArithmeticException e) {
                        e = e;
                        r1 = str;
                        NumberFormatException numberFormatException = new NumberFormatException(r1);
                        numberFormatException.initCause(e);
                        throw numberFormatException;
                    }
                } else {
                    r6 = r1;
                }
                if (z4 || i8 < r1 || i3 == 0 || i3 > MAX_DIGIT_COUNT) {
                    throw new NumberFormatException("illegal syntax");
                }
                if (j <= SieveCacheKt.NodeMetaAndPreviousMask || j > 2147483647L) {
                    throw new NumberFormatException(str);
                }
                if (i3 <= 18) {
                    if (z3) {
                        j3 = -j3;
                    }
                    return new BigDecimal(j3).scaleByPowerOfTen((int) j);
                }
                return valueOfBigDecimalString(cArr, i6, i7, i7 + 1, r6, z3, (int) j);
            } catch (ArithmeticException e2) {
                e = e2;
            }
        } catch (ArithmeticException e3) {
            e = e3;
            r1 = "value exceeds limits";
        }
    }

    BigDecimal parseBigDecimalStringWithManyDigits(char[] cArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        long j;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        long j2;
        int i7 = i;
        if (i2 > 1292782635) {
            throw new NumberFormatException("illegal syntax");
        }
        int i8 = i2 + i7;
        char cCharAt = charAt(cArr, i7, i8);
        boolean z5 = cCharAt == '-';
        if ((z5 || cCharAt == '+') && (cCharAt = charAt(cArr, (i7 = i7 + 1), i8)) == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        int iMin = Math.min(i8 - 8, 1073741824);
        int i9 = i7;
        while (i9 < iMin && FastDoubleSwar.isEightZeroes(cArr, i9)) {
            i9 += 8;
        }
        while (i9 < i8 && cArr[i9] == '0') {
            i9++;
        }
        int i10 = i9;
        while (i10 < iMin && FastDoubleSwar.isEightDigits(cArr, i10)) {
            i10 += 8;
        }
        while (i10 < i8) {
            cCharAt = cArr[i10];
            if (!FastDoubleSwar.isDigit(cCharAt)) {
                break;
            }
            i10++;
        }
        if (cCharAt == '.') {
            int i11 = i10 + 1;
            while (i11 < iMin && FastDoubleSwar.isEightZeroes(cArr, i11)) {
                i11 += 8;
            }
            while (i11 < i8 && cArr[i11] == '0') {
                i11++;
            }
            int i12 = i11;
            while (i12 < iMin && FastDoubleSwar.isEightDigits(cArr, i12)) {
                i12 += 8;
            }
            while (i12 < i8) {
                cCharAt = cArr[i12];
                if (!FastDoubleSwar.isDigit(cCharAt)) {
                    break;
                }
                i12++;
            }
            i4 = i11;
            i3 = i10;
            i10 = i12;
        } else {
            i3 = -1;
            i4 = -1;
        }
        if (i3 < 0) {
            z = true;
            i5 = i10 - i9;
            i4 = i10;
            i3 = i4;
            j = 0;
        } else {
            i5 = i9 == i3 ? i10 - i4 : (i10 - i9) - 1;
            z = true;
            j = (i3 - i10) + 1;
        }
        if ((cCharAt | TokenParser.f2383SP) == 101) {
            int i13 = i10 + 1;
            char cCharAt2 = charAt(cArr, i13, i8);
            boolean z6 = cCharAt2 == '-' ? z : false;
            if (z6 || cCharAt2 == '+') {
                i13 = i10 + 2;
                cCharAt2 = charAt(cArr, i13, i8);
            }
            boolean z7 = !FastDoubleSwar.isDigit(cCharAt2);
            long j3 = 0;
            while (true) {
                if (j3 < 2147483647L) {
                    z4 = z6;
                    z2 = z5;
                    j3 = ((j3 * 10) + ((long) cCharAt2)) - 48;
                } else {
                    z4 = z6;
                    z2 = z5;
                }
                j2 = j3;
                i13++;
                cCharAt2 = charAt(cArr, i13, i8);
                if (!FastDoubleSwar.isDigit(cCharAt2)) {
                    break;
                }
                j3 = j2;
                z5 = z2;
                z6 = z4;
            }
            if (z4) {
                j2 = -j2;
            }
            j += j2;
            i6 = i10;
            z3 = z7;
            i10 = i13;
        } else {
            z2 = z5;
            i6 = i8;
            z3 = false;
        }
        if (z3 || i10 < i8) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i6 - i7 == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        if (j < SieveCacheKt.NodeMetaAndPreviousMask || j > 2147483647L || i5 > MAX_DIGIT_COUNT) {
            throw new NumberFormatException("value exceeds limits");
        }
        return valueOfBigDecimalString(cArr, i9, i3, i4, i6, z2, (int) j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BigDecimal valueOfBigDecimalString(char[] cArr, int i, int i2, int i3, int i4, boolean z, int i5) {
        BigInteger bigIntegerNegate;
        NavigableMap<Integer, BigInteger> navigableMapCreatePowersOfTenFloor16Map;
        BigInteger digitsRecursive;
        int i6 = (i4 - i2) - 1;
        int i7 = i4 - i3;
        int i8 = i2 - i;
        if (i8 <= 0) {
            bigIntegerNegate = BigInteger.ZERO;
        } else {
            if (i8 > 400) {
                navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i, i2);
                bigIntegerNegate = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, i, i2, navigableMapCreatePowersOfTenFloor16Map);
                if (i7 > 0) {
                    if (i7 > 400) {
                        if (navigableMapCreatePowersOfTenFloor16Map == null) {
                            navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                        }
                        int i9 = i2 + 1;
                        FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i9, i4);
                        digitsRecursive = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, i9, i4, navigableMapCreatePowersOfTenFloor16Map);
                    } else {
                        digitsRecursive = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, i2 + 1, i4, null);
                    }
                    if (bigIntegerNegate.signum() != 0) {
                        digitsRecursive = FftMultiplier.multiply(bigIntegerNegate, FastIntegerMath.computePowerOfTen(navigableMapCreatePowersOfTenFloor16Map, i6)).add(digitsRecursive);
                    }
                    bigIntegerNegate = digitsRecursive;
                }
                if (z) {
                    bigIntegerNegate = bigIntegerNegate.negate();
                }
                return new BigDecimal(bigIntegerNegate, -i5);
            }
            bigIntegerNegate = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, i, i2, null);
        }
        navigableMapCreatePowersOfTenFloor16Map = null;
        if (i7 > 0) {
        }
        if (z) {
        }
        return new BigDecimal(bigIntegerNegate, -i5);
    }
}
