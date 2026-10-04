package ch.randelshofer.fastdoubleparser;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes4.dex */
class JavaBigIntegerFromCharSequence extends AbstractNumberParser {
    private static final int MAX_DECIMAL_DIGITS = 646456993;
    private static final int MAX_HEX_DIGITS = 536870912;
    public static final int MAX_INPUT_LENGTH = 1292782622;

    JavaBigIntegerFromCharSequence() {
    }

    public BigInteger parseBigIntegerLiteral(CharSequence charSequence, int i, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5 = i + i2;
        if (i >= 0 && i5 >= i) {
            try {
                if (i5 <= charSequence.length() && i2 <= 1292782622) {
                    char cCharAt = charSequence.charAt(i);
                    boolean z = cCharAt == '-';
                    if (z || cCharAt == '+') {
                        i4 = i + 1;
                        if (charAt(charSequence, i4, i5) == 0) {
                            throw new NumberFormatException("illegal syntax");
                        }
                    } else {
                        i4 = i;
                    }
                    if (i3 == 10) {
                        return parseDecDigits(charSequence, i4, i5, z);
                    }
                    if (i3 == 16) {
                        return parseHexDigits(charSequence, i4, i5, z);
                    }
                    return new BigInteger(charSequence.subSequence(i, i2).toString(), i3);
                }
            } catch (ArithmeticException e) {
                NumberFormatException numberFormatException = new NumberFormatException("value exceeds limits");
                numberFormatException.initCause(e);
                throw numberFormatException;
            }
        }
        throw new IllegalArgumentException("offset < 0 or length > str.length");
    }

    private BigInteger parseDecDigits(CharSequence charSequence, int i, int i2, boolean z) {
        int i3 = i2 - i;
        if (i3 > 18) {
            return parseManyDecDigits(charSequence, i, i2, z);
        }
        int i4 = (i3 & 7) + i;
        long jTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(charSequence, i, i4);
        boolean z2 = jTryToParseUpTo7Digits >= 0;
        while (i4 < i2) {
            int iTryToParseEightDigits = FastDoubleSwar.tryToParseEightDigits(charSequence, i4);
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

    private BigInteger parseHexDigits(CharSequence charSequence, int i, int i2, boolean z) {
        int i3;
        boolean z2;
        int iSkipZeroes = skipZeroes(charSequence, i, i2);
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
            int iLookupHex = lookupHex(charSequence.charAt(iSkipZeroes));
            bArr[1] = (byte) iLookupHex;
            i3 = 2;
            z2 = iLookupHex < 0;
            iSkipZeroes = i5;
        } else {
            i3 = 1;
            z2 = false;
        }
        int i6 = ((i2 - iSkipZeroes) & 7) + iSkipZeroes;
        while (iSkipZeroes < i6) {
            char cCharAt = charSequence.charAt(iSkipZeroes);
            char cCharAt2 = charSequence.charAt(iSkipZeroes + 1);
            int iLookupHex2 = lookupHex(cCharAt);
            int iLookupHex3 = lookupHex(cCharAt2);
            int i7 = i3 + 1;
            bArr[i3] = (byte) ((iLookupHex2 << 4) | iLookupHex3);
            z2 |= iLookupHex3 < 0 || iLookupHex2 < 0;
            iSkipZeroes += 2;
            i3 = i7;
        }
        while (iSkipZeroes < i2) {
            long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(charSequence, iSkipZeroes);
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

    private BigInteger parseManyDecDigits(CharSequence charSequence, int i, int i2, boolean z) {
        int iSkipZeroes = skipZeroes(charSequence, i, i2);
        if (i2 - iSkipZeroes > MAX_DECIMAL_DIGITS) {
            throw new NumberFormatException("value exceeds limits");
        }
        BigInteger digitsRecursive = ParseDigitsTaskCharSequence.parseDigitsRecursive(charSequence, iSkipZeroes, i2, FastIntegerMath.fillPowersOf10Floor16(iSkipZeroes, i2));
        return z ? digitsRecursive.negate() : digitsRecursive;
    }

    private int skipZeroes(CharSequence charSequence, int i, int i2) {
        while (i < i2 && charSequence.charAt(i) == '0') {
            i++;
        }
        return i;
    }
}
