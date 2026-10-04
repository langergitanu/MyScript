package com.fasterxml.jackson.core.p014io.doubleparser;

import androidx.collection.SieveCacheKt;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.NavigableMap;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes5.dex */
final class JavaBigDecimalFromCharSequence extends AbstractNumberParser {
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
    /* JADX WARN: Type inference failed for: r28v0, types: [com.fasterxml.jackson.core.io.doubleparser.JavaBigDecimalFromCharSequence] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BigDecimal parseBigDecimalString(CharSequence charSequence, int i, int i2) {
        ?? r1;
        char cCharAt;
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
                return parseBigDecimalStringWithManyDigits(charSequence, i, i2);
            }
            r1 = i2 + i6;
            char cCharAt2 = charAt(charSequence, i6, (int) r1);
            boolean z3 = cCharAt2 == '-';
            try {
                if ((z3 || cCharAt2 == '+') && (cCharAt2 = charAt(charSequence, i6, (int) r1)) == 0) {
                    throw new NumberFormatException("illegal syntax");
                }
                int i7 = -1;
                int i8 = i6;
                char c = cCharAt2;
                long j3 = 0;
                boolean z4 = false;
                while (true) {
                    if (i8 >= r1) {
                        cCharAt = c;
                        break;
                    }
                    cCharAt = charSequence.charAt(i8);
                    if (!FastDoubleSwar.isDigit(cCharAt)) {
                        if (cCharAt != '.') {
                            break;
                        }
                        z4 |= i7 >= 0;
                        int i9 = i8;
                        while (i9 < r1 - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(charSequence, i9 + 1)) >= 0) {
                            j3 = (j3 * 10000) + ((long) iTryToParseFourDigits);
                            i9 += 4;
                        }
                        i7 = i8;
                        i8 = i9;
                    } else {
                        j3 = ((j3 * 10) + ((long) cCharAt)) - 48;
                    }
                    i8++;
                    c = cCharAt;
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
                if ((cCharAt | TokenParser.f2383SP) == 101) {
                    int i10 = i8 + 1;
                    try {
                        char cCharAt3 = charAt(charSequence, i10, (int) r1);
                        boolean z5 = cCharAt3 == '-' ? z : false;
                        if (z5 || cCharAt3 == '+') {
                            i10 = i8 + 2;
                            cCharAt3 = charAt(charSequence, i10, (int) r1);
                        }
                        z4 |= !FastDoubleSwar.isDigit(cCharAt3);
                        long j4 = 0;
                        while (true) {
                            if (j4 < 2147483647L) {
                                z2 = z5;
                                i4 = i10;
                                j4 = ((j4 * 10) + ((long) cCharAt3)) - 48;
                            } else {
                                z2 = z5;
                                i4 = i10;
                            }
                            j2 = j4;
                            i5 = i4 + 1;
                            cCharAt3 = charAt(charSequence, i5, (int) r1);
                            if (!FastDoubleSwar.isDigit(cCharAt3)) {
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
                return valueOfBigDecimalString(charSequence, i6, i7, i7 + 1, r6, z3, (int) j);
            } catch (ArithmeticException e2) {
                e = e2;
            }
        } catch (ArithmeticException e3) {
            e = e3;
            r1 = "value exceeds limits";
        }
    }

    BigDecimal parseBigDecimalStringWithManyDigits(CharSequence charSequence, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        long j;
        boolean z2;
        int i7;
        boolean z3;
        boolean z4;
        long j2;
        int i8 = i;
        if (i2 > 1292782635) {
            throw new NumberFormatException("illegal syntax");
        }
        int i9 = i2 + i8;
        char cCharAt = charAt(charSequence, i8, i9);
        boolean z5 = cCharAt == '-';
        if ((z5 || cCharAt == '+') && (cCharAt = charAt(charSequence, (i8 = i8 + 1), i9)) == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        int i10 = i8;
        while (true) {
            i3 = i9 - 8;
            if (i10 >= i3 || !FastDoubleSwar.isEightZeroes(charSequence, i10)) {
                break;
            }
            i10 += 8;
        }
        while (i10 < i9 && charSequence.charAt(i10) == '0') {
            i10++;
        }
        int i11 = i10;
        while (i11 < i3 && FastDoubleSwar.isEightDigits(charSequence, i11)) {
            i11 += 8;
        }
        while (i11 < i9) {
            cCharAt = charSequence.charAt(i11);
            if (!FastDoubleSwar.isDigit(cCharAt)) {
                break;
            }
            i11++;
        }
        if (cCharAt == '.') {
            int i12 = i11 + 1;
            while (i12 < i3 && FastDoubleSwar.isEightZeroes(charSequence, i12)) {
                i12 += 8;
            }
            while (i12 < i9 && charSequence.charAt(i12) == '0') {
                i12++;
            }
            int i13 = i12;
            while (i13 < i3 && FastDoubleSwar.isEightDigits(charSequence, i13)) {
                i13 += 8;
            }
            while (i13 < i9) {
                cCharAt = charSequence.charAt(i13);
                if (!FastDoubleSwar.isDigit(cCharAt)) {
                    break;
                }
                i13++;
            }
            i5 = i12;
            i4 = i11;
            i11 = i13;
        } else {
            i4 = -1;
            i5 = -1;
        }
        if (i4 < 0) {
            z = true;
            i6 = i11 - i10;
            i5 = i11;
            i4 = i5;
            j = 0;
        } else {
            i6 = i10 == i4 ? i11 - i5 : (i11 - i10) - 1;
            z = true;
            j = (i4 - i11) + 1;
        }
        if ((cCharAt | TokenParser.f2383SP) == 101) {
            int i14 = i11 + 1;
            char cCharAt2 = charAt(charSequence, i14, i9);
            boolean z6 = cCharAt2 == '-' ? z : false;
            if (z6 || cCharAt2 == '+') {
                i14 = i11 + 2;
                cCharAt2 = charAt(charSequence, i14, i9);
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
                i14++;
                cCharAt2 = charAt(charSequence, i14, i9);
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
            i7 = i11;
            z3 = z7;
            i11 = i14;
        } else {
            z2 = z5;
            i7 = i9;
            z3 = false;
        }
        if (z3 || i11 < i9) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i7 - i8 == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        if (j < SieveCacheKt.NodeMetaAndPreviousMask || j > 2147483647L || i6 > MAX_DIGIT_COUNT) {
            throw new NumberFormatException("value exceeds limits");
        }
        return valueOfBigDecimalString(charSequence, i10, i4, i5, i7, z2, (int) j);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BigDecimal valueOfBigDecimalString(CharSequence charSequence, int i, int i2, int i3, int i4, boolean z, int i5) {
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
                bigIntegerNegate = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, i, i2, navigableMapCreatePowersOfTenFloor16Map);
                if (i6 > 0) {
                    if (i7 > 400) {
                        if (navigableMapCreatePowersOfTenFloor16Map == null) {
                            navigableMapCreatePowersOfTenFloor16Map = FastIntegerMath.createPowersOfTenFloor16Map();
                        }
                        FastIntegerMath.fillPowersOfNFloor16Recursive(navigableMapCreatePowersOfTenFloor16Map, i3, i4);
                        digitsRecursive = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, i3, i4, navigableMapCreatePowersOfTenFloor16Map);
                    } else {
                        digitsRecursive = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, i3, i4, null);
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
            bigIntegerNegate = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, i, i2, null);
        }
        navigableMapCreatePowersOfTenFloor16Map = null;
        if (i6 > 0) {
        }
        if (z) {
        }
        return new BigDecimal(bigIntegerNegate, -i5);
    }
}
