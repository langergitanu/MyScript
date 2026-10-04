package ch.randelshofer.fastdoubleparser;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
class JavaBigIntegerFromByteArray extends AbstractNumberParser {
    private static final int MAX_DECIMAL_DIGITS = 646456993;
    private static final int MAX_HEX_DIGITS = 536870912;
    public static final int MAX_INPUT_LENGTH = 1292782622;

    JavaBigIntegerFromByteArray() {
    }

    public BigInteger parseBigIntegerLiteral(byte[] bArr, int i, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5 = i + i2;
        if (i >= 0 && i5 >= i) {
            try {
                if (i5 <= bArr.length && i2 <= 1292782622) {
                    byte b = bArr[i];
                    boolean z = b == 45;
                    if (z || b == 43) {
                        i4 = i + 1;
                        if (charAt(bArr, i4, i5) == 0) {
                            throw new NumberFormatException("illegal syntax");
                        }
                    } else {
                        i4 = i;
                    }
                    if (i3 == 10) {
                        return parseDecDigits(bArr, i4, i5, z);
                    }
                    if (i3 == 16) {
                        return parseHexDigits(bArr, i4, i5, z);
                    }
                    return new BigInteger(new String(bArr, i, i2, StandardCharsets.ISO_8859_1), i3);
                }
            } catch (ArithmeticException e) {
                NumberFormatException numberFormatException = new NumberFormatException("value exceeds limits");
                numberFormatException.initCause(e);
                throw numberFormatException;
            }
        }
        throw new IllegalArgumentException("offset < 0 or length > str.length");
    }

    private BigInteger parseDecDigits(byte[] bArr, int i, int i2, boolean z) {
        int i3 = i2 - i;
        if (i3 > 18) {
            return parseManyDecDigits(bArr, i, i2, z);
        }
        int i4 = (i3 & 7) + i;
        long jTryToParseUpTo7Digits = FastDoubleSwar.tryToParseUpTo7Digits(bArr, i, i4);
        boolean z2 = jTryToParseUpTo7Digits >= 0;
        while (i4 < i2) {
            int iTryToParseEightDigitsUtf8 = FastDoubleSwar.tryToParseEightDigitsUtf8(bArr, i4);
            z2 &= iTryToParseEightDigitsUtf8 >= 0;
            jTryToParseUpTo7Digits = (jTryToParseUpTo7Digits * 100000000) + ((long) iTryToParseEightDigitsUtf8);
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

    private BigInteger parseHexDigits(byte[] bArr, int i, int i2, boolean z) {
        int i3;
        boolean z2;
        int iSkipZeroes = skipZeroes(bArr, i, i2);
        int i4 = i2 - iSkipZeroes;
        if (i4 <= 0) {
            return BigInteger.ZERO;
        }
        if (i4 > 536870912) {
            throw new NumberFormatException("value exceeds limits");
        }
        byte[] bArr2 = new byte[((i4 + 1) >> 1) + 1];
        if ((i4 & 1) != 0) {
            int i5 = iSkipZeroes + 1;
            byte b = bArr[iSkipZeroes];
            byte b2 = b < 0 ? (byte) -1 : AbstractFloatValueParser.CHAR_TO_HEX_MAP[b];
            bArr2[1] = b2;
            i3 = 2;
            z2 = b2 < 0;
            iSkipZeroes = i5;
        } else {
            i3 = 1;
            z2 = false;
        }
        int i6 = ((i2 - iSkipZeroes) & 7) + iSkipZeroes;
        while (iSkipZeroes < i6) {
            byte b3 = bArr[iSkipZeroes];
            byte b4 = bArr[iSkipZeroes + 1];
            byte b5 = b3 < 0 ? (byte) -1 : AbstractFloatValueParser.CHAR_TO_HEX_MAP[b3];
            byte b6 = b4 < 0 ? (byte) -1 : AbstractFloatValueParser.CHAR_TO_HEX_MAP[b4];
            int i7 = i3 + 1;
            bArr2[i3] = (byte) ((b5 << 4) | b6);
            z2 |= b5 < 0 || b6 < 0;
            iSkipZeroes += 2;
            i3 = i7;
        }
        while (iSkipZeroes < i2) {
            long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(bArr, iSkipZeroes);
            FastDoubleSwar.writeIntBE(bArr2, i3, (int) jTryToParseEightHexDigits);
            z2 |= jTryToParseEightHexDigits < 0;
            iSkipZeroes += 8;
            i3 += 4;
        }
        if (z2) {
            throw new NumberFormatException("illegal syntax");
        }
        BigInteger bigInteger = new BigInteger(bArr2);
        return z ? bigInteger.negate() : bigInteger;
    }

    private BigInteger parseManyDecDigits(byte[] bArr, int i, int i2, boolean z) {
        int iSkipZeroes = skipZeroes(bArr, i, i2);
        if (i2 - iSkipZeroes > MAX_DECIMAL_DIGITS) {
            throw new NumberFormatException("value exceeds limits");
        }
        BigInteger digitsRecursive = ParseDigitsTaskByteArray.parseDigitsRecursive(bArr, iSkipZeroes, i2, FastIntegerMath.fillPowersOf10Floor16(iSkipZeroes, i2));
        return z ? digitsRecursive.negate() : digitsRecursive;
    }

    private int skipZeroes(byte[] bArr, int i, int i2) {
        while (i < i2 - 8 && FastDoubleSwar.isEightZeroes(bArr, i)) {
            i += 8;
        }
        while (i < i2 && bArr[i] == 48) {
            i++;
        }
        return i;
    }
}
