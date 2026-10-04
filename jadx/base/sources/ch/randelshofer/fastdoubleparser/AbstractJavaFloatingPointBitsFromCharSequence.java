package ch.randelshofer.fastdoubleparser;

import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractJavaFloatingPointBitsFromCharSequence extends AbstractFloatValueParser {
    abstract long nan();

    abstract long negativeInfinity();

    abstract long positiveInfinity();

    abstract long valueOfFloatLiteral(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    abstract long valueOfHexLiteral(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    AbstractJavaFloatingPointBitsFromCharSequence() {
    }

    private static int skipWhitespace(CharSequence charSequence, int i, int i2) {
        while (i < i2 && charSequence.charAt(i) <= ' ') {
            i++;
        }
        return i;
    }

    private long parseDecFloatLiteral(CharSequence charSequence, int i, int i2, int i3, boolean z, boolean z2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j;
        boolean z3;
        int i9;
        AbstractJavaFloatingPointBitsFromCharSequence abstractJavaFloatingPointBitsFromCharSequence;
        int i10;
        boolean z4;
        int i11;
        int i12 = -1;
        int i13 = i;
        long j2 = 0;
        char cCharAt = 0;
        boolean z5 = false;
        while (true) {
            if (i13 >= i3) {
                break;
            }
            cCharAt = charSequence.charAt(i13);
            if (!FastDoubleSwar.isDigit(cCharAt)) {
                if (cCharAt != '.') {
                    break;
                }
                z5 |= i12 >= 0;
                i12 = i13;
            } else {
                j2 = ((j2 * 10) + ((long) cCharAt)) - 48;
            }
            i13++;
        }
        if (i12 < 0) {
            i6 = i13 - i;
            i5 = i13;
            i4 = 0;
        } else {
            i4 = (i12 - i13) + 1;
            i5 = i12;
            i6 = (i13 - i) - 1;
        }
        if ((cCharAt | TokenParser.f2383SP) == 101) {
            i7 = i13 + 1;
            char cCharAt2 = charAt(charSequence, i7, i3);
            boolean z6 = cCharAt2 == '-';
            if (z6 || cCharAt2 == '+') {
                i7 = i13 + 2;
                cCharAt2 = charAt(charSequence, i7, i3);
            }
            boolean z7 = z5 | (!FastDoubleSwar.isDigit(cCharAt2));
            int i14 = 0;
            do {
                if (i14 < 1024) {
                    i14 = ((i14 * 10) + cCharAt2) - 48;
                }
                i7++;
                cCharAt2 = charAt(charSequence, i7, i3);
            } while (FastDoubleSwar.isDigit(cCharAt2));
            if (z6) {
                i14 = -i14;
            }
            i4 += i14;
            int i15 = i14;
            cCharAt = cCharAt2;
            i8 = i15;
            z5 = z7;
        } else {
            i7 = i13;
            i8 = 0;
        }
        if ((cCharAt == 'd') | (cCharAt == 'D') | (cCharAt == 'f') | (cCharAt == 'F')) {
            i7++;
        }
        int iSkipWhitespace = skipWhitespace(charSequence, i7, i3);
        if (z5 || iSkipWhitespace < i3 || (!z2 && i6 == 0)) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i6 > 19) {
            int i16 = i;
            int i17 = 0;
            long j3 = 0;
            while (i16 < i13) {
                char cCharAt3 = charSequence.charAt(i16);
                if (cCharAt3 != '.') {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = ((j3 * 10) + ((long) cCharAt3)) - 48;
                } else {
                    i17++;
                }
                i16++;
            }
            i9 = (i5 - i16) + i17 + i8;
            j = j3;
            z3 = i16 < i13;
            abstractJavaFloatingPointBitsFromCharSequence = this;
            z4 = z;
            i11 = i4;
            i10 = i2;
        } else {
            j = j2;
            z3 = false;
            i9 = 0;
            abstractJavaFloatingPointBitsFromCharSequence = this;
            i10 = i2;
            z4 = z;
            i11 = i4;
        }
        return abstractJavaFloatingPointBitsFromCharSequence.valueOfFloatLiteral(charSequence, i10, i3, z4, j, i11, z3, i9);
    }

    public final long parseFloatingPointLiteral(CharSequence charSequence, int i, int i2) {
        boolean z;
        int i3;
        AbstractJavaFloatingPointBitsFromCharSequence abstractJavaFloatingPointBitsFromCharSequence;
        CharSequence charSequence2;
        int i4;
        int i5 = i + i2;
        if (i < 0 || i5 < i || i5 > charSequence.length() || i2 > 2147483643) {
            throw new IllegalArgumentException("offset < 0 or length > str.length");
        }
        int iSkipWhitespace = skipWhitespace(charSequence, i, i5);
        if (iSkipWhitespace == i5) {
            throw new NumberFormatException("illegal syntax");
        }
        char cCharAt = charSequence.charAt(iSkipWhitespace);
        boolean z2 = true;
        if (cCharAt == '-') {
            z = true;
        } else {
            z = true;
            z2 = false;
        }
        if ((z2 || cCharAt == '+') && (cCharAt = charAt(charSequence, (iSkipWhitespace = iSkipWhitespace + 1), i5)) == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        if (cCharAt >= 'I') {
            return parseNaNOrInfinity(charSequence, iSkipWhitespace, i5, z2);
        }
        boolean z3 = cCharAt == '0' ? z : false;
        if (z3) {
            int i6 = iSkipWhitespace + 1;
            char cCharAt2 = charAt(charSequence, i6, i5);
            if (cCharAt2 == 'x' || cCharAt2 == 'X') {
                return parseHexFloatLiteral(charSequence, iSkipWhitespace + 2, i, i5, z2);
            }
            i3 = i6;
            charSequence2 = charSequence;
            i4 = i;
            abstractJavaFloatingPointBitsFromCharSequence = this;
        } else {
            i3 = iSkipWhitespace;
            abstractJavaFloatingPointBitsFromCharSequence = this;
            charSequence2 = charSequence;
            i4 = i;
        }
        return abstractJavaFloatingPointBitsFromCharSequence.parseDecFloatLiteral(charSequence2, i3, i4, i5, z2, z3);
    }

    private long parseHexFloatLiteral(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        int iMin;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j;
        int i9;
        boolean z2;
        int i10 = -1;
        int i11 = i;
        long j2 = 0;
        char cCharAt = 0;
        boolean z3 = false;
        while (true) {
            if (i11 >= i3) {
                break;
            }
            cCharAt = charSequence.charAt(i11);
            int iLookupHex = lookupHex(cCharAt);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z3 |= i10 >= 0;
                int i12 = i11;
                while (i12 < i3 - 8) {
                    long jTryToParseEightHexDigits = FastDoubleSwar.tryToParseEightHexDigits(charSequence, i12 + 1);
                    if (jTryToParseEightHexDigits < 0) {
                        break;
                    }
                    j2 = (j2 << 32) + jTryToParseEightHexDigits;
                    i12 += 8;
                }
                int i13 = i11;
                i11 = i12;
                i10 = i13;
            } else {
                j2 = (j2 << 4) | ((long) iLookupHex);
            }
            i11++;
        }
        if (i10 < 0) {
            i5 = i11 - i;
            i4 = i11;
            iMin = 0;
        } else {
            iMin = Math.min((i10 - i11) + 1, 1024) * 4;
            i4 = i10;
            i5 = (i11 - i) - 1;
        }
        boolean z4 = (cCharAt | TokenParser.f2383SP) == 112;
        if (z4) {
            i6 = i11 + 1;
            char cCharAt2 = charAt(charSequence, i6, i3);
            boolean z5 = cCharAt2 == '-';
            if (z5 || cCharAt2 == '+') {
                i6 = i11 + 2;
                cCharAt2 = charAt(charSequence, i6, i3);
            }
            boolean z6 = z3 | (!FastDoubleSwar.isDigit(cCharAt2));
            int i14 = 0;
            do {
                if (i14 < 1024) {
                    i14 = ((i14 * 10) + cCharAt2) - 48;
                }
                i6++;
                cCharAt2 = charAt(charSequence, i6, i3);
            } while (FastDoubleSwar.isDigit(cCharAt2));
            if (z5) {
                i14 = -i14;
            }
            iMin += i14;
            int i15 = i14;
            cCharAt = cCharAt2;
            i7 = i15;
            z3 = z6;
        } else {
            i6 = i11;
            i7 = 0;
        }
        if ((cCharAt == 'F') | (cCharAt == 'D') | (cCharAt == 'd') | (cCharAt == 'f')) {
            i6++;
        }
        int iSkipWhitespace = skipWhitespace(charSequence, i6, i3);
        if (z3 || iSkipWhitespace < i3 || i5 == 0 || !z4) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i5 > 16) {
            int i16 = i;
            int i17 = 0;
            long j3 = 0;
            while (i16 < i11) {
                int iLookupHex2 = lookupHex(charSequence.charAt(i16));
                if (iLookupHex2 < 0) {
                    i17++;
                } else {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = (j3 << 4) | ((long) iLookupHex2);
                }
                i16++;
            }
            boolean z7 = i16 < i11;
            iSkipWhitespace = i16;
            i9 = i17;
            i8 = i7;
            j = j3;
            z2 = z7;
        } else {
            i8 = i7;
            j = j2;
            i9 = 0;
            z2 = false;
        }
        return valueOfHexLiteral(charSequence, i2, i3, z, j, iMin, z2, (((i4 - iSkipWhitespace) + i9) * 4) + i8);
    }

    private long parseNaNOrInfinity(CharSequence charSequence, int i, int i2, boolean z) {
        if (charSequence.charAt(i) == 'N') {
            int i3 = i + 2;
            if (i3 < i2 && charSequence.charAt(i + 1) == 'a' && charSequence.charAt(i3) == 'N' && skipWhitespace(charSequence, i + 3, i2) == i2) {
                return nan();
            }
        } else {
            int i4 = i + 7;
            if (i4 < i2 && charSequence.charAt(i) == 'I' && charSequence.charAt(i + 1) == 'n' && charSequence.charAt(i + 2) == 'f' && charSequence.charAt(i + 3) == 'i' && charSequence.charAt(i + 4) == 'n' && charSequence.charAt(i + 5) == 'i' && charSequence.charAt(i + 6) == 't' && charSequence.charAt(i4) == 'y' && skipWhitespace(charSequence, i + 8, i2) == i2) {
                return z ? negativeInfinity() : positiveInfinity();
            }
        }
        throw new NumberFormatException("illegal syntax");
    }
}
