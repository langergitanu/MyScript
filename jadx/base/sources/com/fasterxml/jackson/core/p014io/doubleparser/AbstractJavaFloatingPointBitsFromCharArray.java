package com.fasterxml.jackson.core.p014io.doubleparser;

import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractJavaFloatingPointBitsFromCharArray extends AbstractFloatValueParser {
    private static final boolean CONDITIONAL_COMPILATION_PARSE_EIGHT_HEX_DIGITS = true;

    abstract long nan();

    abstract long negativeInfinity();

    abstract long positiveInfinity();

    abstract long valueOfFloatLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    abstract long valueOfHexLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    AbstractJavaFloatingPointBitsFromCharArray() {
    }

    private static int skipWhitespace(char[] cArr, int i, int i2) {
        while (i < i2 && cArr[i] <= ' ') {
            i++;
        }
        return i;
    }

    private long parseDecFloatLiteral(char[] cArr, int i, int i2, int i3, boolean z, boolean z2) {
        int i4;
        int i5;
        int i6;
        int i7;
        long j;
        boolean z3;
        int i8;
        int iMin = Math.min(i3 - 4, 1073741824);
        int i9 = -1;
        int i10 = i;
        long j2 = 0;
        char c = 0;
        boolean z4 = false;
        while (i10 < i3) {
            c = cArr[i10];
            if (!FastDoubleSwar.isDigit(c)) {
                if (c != '.') {
                    break;
                }
                z4 |= i9 >= 0;
                int i11 = i10;
                while (i11 < iMin) {
                    int iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(cArr, i11 + 1);
                    if (iTryToParseFourDigits < 0) {
                        break;
                    }
                    j2 = (j2 * 10000) + ((long) iTryToParseFourDigits);
                    i11 += 4;
                }
                int i12 = i10;
                i10 = i11;
                i9 = i12;
            } else {
                j2 = ((j2 * 10) + ((long) c)) - 48;
            }
            i10++;
        }
        if (i9 < 0) {
            i4 = i10 - i;
            i9 = i10;
            i5 = 0;
        } else {
            i4 = (i10 - i) - 1;
            i5 = (i9 - i10) + 1;
        }
        boolean z5 = true;
        if ((c | TokenParser.f2383SP) == 101) {
            i6 = i10 + 1;
            char cCharAt = charAt(cArr, i6, i3);
            boolean z6 = cCharAt == '-';
            if (z6 || cCharAt == '+') {
                i6 = i10 + 2;
                cCharAt = charAt(cArr, i6, i3);
            }
            boolean z7 = z4 | (!FastDoubleSwar.isDigit(cCharAt));
            int i13 = 0;
            do {
                if (i13 < 1024) {
                    i13 = ((i13 * 10) + cCharAt) - 48;
                }
                i6++;
                cCharAt = charAt(cArr, i6, i3);
            } while (FastDoubleSwar.isDigit(cCharAt));
            if (z6) {
                i13 = -i13;
            }
            i5 += i13;
            int i14 = i13;
            c = cCharAt;
            i7 = i14;
            z4 = z7;
        } else {
            i6 = i10;
            i7 = 0;
        }
        if ((c == 'F') | (c == 'd') | (c == 'D') | (c == 'f')) {
            i6++;
        }
        int iSkipWhitespace = skipWhitespace(cArr, i6, i3);
        if (z4 || iSkipWhitespace < i3 || (!z2 && i4 == 0)) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i4 > 19) {
            int i15 = i;
            int i16 = 0;
            long j3 = 0;
            while (i15 < i10) {
                char c2 = cArr[i15];
                if (c2 != '.') {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = ((j3 * 10) + ((long) c2)) - 48;
                } else {
                    i16++;
                }
                i15++;
            }
            if (i15 >= i10) {
                z5 = false;
            }
            i8 = i7 + (i9 - i15) + i16;
            j = j3;
            z3 = z5;
        } else {
            j = j2;
            z3 = false;
            i8 = 0;
        }
        return valueOfFloatLiteral(cArr, i2, i3, z, j, i5, z3, i8);
    }

    public long parseFloatingPointLiteral(char[] cArr, int i, int i2) {
        boolean z;
        int i3;
        AbstractJavaFloatingPointBitsFromCharArray abstractJavaFloatingPointBitsFromCharArray;
        char[] cArr2;
        int i4;
        int i5 = i + i2;
        if (i < 0 || i5 < i || i5 > cArr.length || i2 > 2147483643) {
            throw new IllegalArgumentException("offset < 0 or length > str.length");
        }
        int iSkipWhitespace = skipWhitespace(cArr, i, i5);
        if (iSkipWhitespace == i5) {
            throw new NumberFormatException("illegal syntax");
        }
        char cCharAt = cArr[iSkipWhitespace];
        boolean z2 = true;
        if (cCharAt == '-') {
            z = true;
        } else {
            z = true;
            z2 = false;
        }
        if ((z2 || cCharAt == '+') && (cCharAt = charAt(cArr, (iSkipWhitespace = iSkipWhitespace + 1), i5)) == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        if (cCharAt >= 'I') {
            return parseNaNOrInfinity(cArr, iSkipWhitespace, i5, z2);
        }
        boolean z3 = cCharAt == '0' ? z : false;
        if (z3) {
            int i6 = iSkipWhitespace + 1;
            char cCharAt2 = charAt(cArr, i6, i5);
            if (cCharAt2 == 'x' || cCharAt2 == 'X') {
                return parseHexFloatLiteral(cArr, iSkipWhitespace + 2, i, i5, z2);
            }
            i3 = i6;
            cArr2 = cArr;
            i4 = i;
            abstractJavaFloatingPointBitsFromCharArray = this;
        } else {
            i3 = iSkipWhitespace;
            abstractJavaFloatingPointBitsFromCharArray = this;
            cArr2 = cArr;
            i4 = i;
        }
        return abstractJavaFloatingPointBitsFromCharArray.parseDecFloatLiteral(cArr2, i3, i4, i5, z2, z3);
    }

    private long parseHexFloatLiteral(char[] cArr, int i, int i2, int i3, boolean z) {
        int iMin;
        int i4;
        int i5;
        char c;
        boolean z2;
        int i6;
        int i7;
        long j;
        boolean z3;
        int i8;
        int i9 = -1;
        int i10 = i;
        long j2 = 0;
        char cCharAt = 0;
        boolean z4 = false;
        while (i10 < i3) {
            cCharAt = cArr[i10];
            int iLookupHex = lookupHex(cCharAt);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z4 |= i9 >= 0;
                int i11 = i10;
                while (i11 < i3 - 8) {
                    long jTryToParseEightHexDigits = tryToParseEightHexDigits(cArr, i11 + 1);
                    if (jTryToParseEightHexDigits < 0) {
                        break;
                    }
                    j2 = (j2 << 32) + jTryToParseEightHexDigits;
                    i11 += 8;
                }
                int i12 = i10;
                i10 = i11;
                i9 = i12;
            } else {
                j2 = (j2 << 4) | ((long) iLookupHex);
            }
            i10++;
        }
        if (i9 < 0) {
            i5 = i10 - i;
            i4 = i10;
            iMin = 0;
        } else {
            iMin = Math.min((i9 - i10) + 1, 1024) * 4;
            i4 = i9;
            i5 = (i10 - i) - 1;
        }
        boolean z5 = (cCharAt | TokenParser.f2383SP) == 112;
        if (z5) {
            i6 = i10 + 1;
            cCharAt = charAt(cArr, i6, i3);
            c = 4;
            boolean z6 = cCharAt == '-';
            z2 = true;
            if (z6 || cCharAt == '+') {
                i6 = i10 + 2;
                cCharAt = charAt(cArr, i6, i3);
            }
            boolean z7 = (!FastDoubleSwar.isDigit(cCharAt)) | z4;
            int i13 = 0;
            do {
                if (i13 < 1024) {
                    i13 = ((i13 * 10) + cCharAt) - 48;
                }
                i6++;
                cCharAt = charAt(cArr, i6, i3);
            } while (FastDoubleSwar.isDigit(cCharAt));
            if (z6) {
                i13 = -i13;
            }
            iMin += i13;
            i7 = i13;
            z4 = z7;
        } else {
            c = 4;
            z2 = true;
            i6 = i10;
            i7 = 0;
        }
        if ((cCharAt == 'F' ? z2 : false) | (cCharAt == 'd' ? z2 : false) | (cCharAt == 'D' ? z2 : false) | (cCharAt == 'f' ? z2 : false)) {
            i6++;
        }
        int iSkipWhitespace = skipWhitespace(cArr, i6, i3);
        if (z4 || iSkipWhitespace < i3 || i5 == 0 || !z5) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i5 > 16) {
            int i14 = i;
            long j3 = 0;
            int i15 = 0;
            while (i14 < i10) {
                int iLookupHex2 = lookupHex(cArr[i14]);
                if (iLookupHex2 < 0) {
                    i15++;
                } else {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = (j3 << c) | ((long) iLookupHex2);
                }
                i14++;
            }
            z3 = i14 < i10 ? z2 : false;
            i8 = i15;
            j = j3;
            iSkipWhitespace = i14;
        } else {
            j = j2;
            z3 = false;
            i8 = 0;
        }
        return valueOfHexLiteral(cArr, i2, i3, z, j, iMin, z3, (((i4 - iSkipWhitespace) + i8) * 4) + i7);
    }

    private long parseNaNOrInfinity(char[] cArr, int i, int i2, boolean z) {
        char c = cArr[i];
        if (c == 'N') {
            int i3 = i + 2;
            if (i3 < i2 && cArr[i + 1] == 'a' && cArr[i3] == 'N' && skipWhitespace(cArr, i + 3, i2) == i2) {
                return nan();
            }
        } else {
            int i4 = i + 7;
            if (i4 < i2 && c == 'I' && cArr[i + 1] == 'n' && cArr[i + 2] == 'f' && cArr[i + 3] == 'i' && cArr[i + 4] == 'n' && cArr[i + 5] == 'i' && cArr[i + 6] == 't' && cArr[i4] == 'y' && skipWhitespace(cArr, i + 8, i2) == i2) {
                return z ? negativeInfinity() : positiveInfinity();
            }
        }
        throw new NumberFormatException("illegal syntax");
    }

    private long tryToParseEightHexDigits(char[] cArr, int i) {
        return FastDoubleSwar.tryToParseEightHexDigits(cArr, i);
    }
}
