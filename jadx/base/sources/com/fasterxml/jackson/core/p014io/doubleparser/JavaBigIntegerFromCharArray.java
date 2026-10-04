package com.fasterxml.jackson.core.p014io.doubleparser;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
class JavaBigIntegerFromCharArray extends AbstractNumberParser {
    private static final int MAX_DECIMAL_DIGITS = 646456993;
    private static final int MAX_HEX_DIGITS = 536870912;
    public static final int MAX_INPUT_LENGTH = 1292782622;

    JavaBigIntegerFromCharArray() {
    }

    public BigInteger parseBigIntegerLiteral(char[] cArr, int i, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5 = i + i2;
        if (i >= 0 && i5 >= i) {
            try {
                if (i5 <= cArr.length && i2 <= 1292782622) {
                    char c = cArr[i];
                    boolean z = c == '-';
                    if (z || c == '+') {
                        i4 = i + 1;
                        if (charAt(cArr, i4, i5) == 0) {
                            throw new NumberFormatException("illegal syntax");
                        }
                    } else {
                        i4 = i;
                    }
                    if (i3 == 10) {
                        return parseDecDigits(cArr, i4, i5, z);
                    }
                    if (i3 == 16) {
                        return parseHexDigits(cArr, i4, i5, z);
                    }
                    return new BigInteger(new String(cArr, i, i2), i3);
                }
            } catch (ArithmeticException e) {
                NumberFormatException numberFormatException = new NumberFormatException("value exceeds limits");
                numberFormatException.initCause(e);
                throw numberFormatException;
            }
        }
        throw new IllegalArgumentException("offset < 0 or length > str.length");
    }

    private BigInteger parseDecDigits(char[] cArr, int i, int i2, boolean z) {
        int i3 = i2 - i;
        if (i3 > 18) {
            return parseManyDecDigits(cArr, i, i2, z);
        }
        int i4 = (i3 & 7) + i;
        long jTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(cArr, i, i4);
        boolean z2 = jTryToParseUpTo7Digits >= 0;
        while (i4 < i2) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(cArr, i4);
            z2 &= iTryToParseEightDigits >= 0;
            jTryToParseUpTo7Digits = (jTryToParseUpTo7Digits * 100000000) + ((long) iTryToParseEightDigits);
            i4 += 8;
        }
        if (!z2) {
            throw new NumberFormatException("illegal syntax");
        }
        if (z) {
            jTryToParseUpTo7Digits = -jTryToParseUpTo7Digits;
        }
        return BigInteger.valueOf(jTryToParseUpTo7Digits);
    }

    private BigInteger parseHexDigits(char[] cArr, int i, int i2, boolean z) {
        int i3;
        boolean z2;
        int iSkipZeroes = skipZeroes(cArr, i, i2);
        int i4 = i2 - iSkipZeroes;
        if (i4 <= 0) {
            return BigInteger.ZERO;
        }
        if (i4 > 536870912) {
            throw new NumberFormatException("value exceeds limits");
        }
        byte[] bArr = new byte[((i4 + 1) >> 1) + 1];
        if ((i4 & 1) != 0) {
            int i5 = iSkipZeroes + 1;
            byte b = AbstractFloatValueParser.CHAR_TO_HEX_MAP[cArr[iSkipZeroes]];
            bArr[1] = b;
            i3 = 2;
            z2 = b < 0;
            iSkipZeroes = i5;
        } else {
            i3 = 1;
            z2 = false;
        }
        int i6 = ((i2 - iSkipZeroes) & 7) + iSkipZeroes;
        while (iSkipZeroes < i6) {
            char c = cArr[iSkipZeroes];
            char c2 = cArr[iSkipZeroes + 1];
            byte b2 = c >= 128 ? (byte) -1 : AbstractFloatValueParser.CHAR_TO_HEX_MAP[c];
            byte b3 = c2 < 128 ? AbstractFloatValueParser.CHAR_TO_HEX_MAP[c2] : (byte) -1;
            int i7 = i3 + 1;
            bArr[i3] = (byte) ((b2 << 4) | b3);
            z2 |= b2 < 0 || b3 < 0;
            iSkipZeroes += 2;
            i3 = i7;
        }
        while (iSkipZeroes < i2) {
            long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(cArr, iSkipZeroes);
            FastDoubleSwar.writeIntBE(bArr, i3, (int) jTryToParseEightHexDigits);
            z2 |= jTryToParseEightHexDigits < 0;
            iSkipZeroes += 8;
            i3 += 4;
        }
        if (z2) {
            throw new NumberFormatException("illegal syntax");
        }
        BigInteger bigInteger = new BigInteger(bArr);
        return z ? bigInteger.negate() : bigInteger;
    }

    private BigInteger parseManyDecDigits(char[] cArr, int i, int i2, boolean z) {
        int iSkipZeroes = skipZeroes(cArr, i, i2);
        if (i2 - iSkipZeroes > MAX_DECIMAL_DIGITS) {
            throw new NumberFormatException("value exceeds limits");
        }
        BigInteger digitsRecursive = ParseDigitsTaskCharArray.parseDigitsRecursive(cArr, iSkipZeroes, i2, FastIntegerMath.fillPowersOf10Floor16(iSkipZeroes, i2));
        return z ? digitsRecursive.negate() : digitsRecursive;
    }

    private int skipZeroes(char[] cArr, int i, int i2) {
        while (i < i2 - 8 && FastDoubleSwar.isEightZeroes(cArr, i)) {
            i += 8;
        }
        while (i < i2 && cArr[i] == '0') {
            i++;
        }
        return i;
    }
}
