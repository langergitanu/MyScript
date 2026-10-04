package ch.randelshofer.fastdoubleparser;

import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractJsonFloatingPointBitsFromCharArray extends AbstractFloatValueParser {
    abstract long valueOfFloatLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    AbstractJsonFloatingPointBitsFromCharArray() {
    }

    public final long parseNumber(char[] cArr, int i, int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        AbstractJsonFloatingPointBitsFromCharArray abstractJsonFloatingPointBitsFromCharArray;
        int i4;
        int i5;
        int i6;
        int i7;
        long j;
        boolean z4;
        int i8;
        char c;
        boolean z5;
        int iTryToParseEightDigits;
        int i9 = i + i2;
        if (i < 0 || i9 < i || i9 > cArr.length || i2 > 2147483643) {
            throw new IllegalArgumentException("offset < 0 or length > str.length");
        }
        char cCharAt = charAt(cArr, i, i9);
        boolean z6 = cCharAt == '-';
        if (z6) {
            int i10 = i + 1;
            char cCharAt2 = charAt(cArr, i10, i9);
            if (cCharAt2 == 0) {
                throw new NumberFormatException("illegal syntax");
            }
            i3 = i10;
            cCharAt = cCharAt2;
        } else {
            i3 = i;
        }
        char c2 = '0';
        boolean z7 = cCharAt == '0';
        if (z7 && (cCharAt = charAt(cArr, (i3 = i3 + 1), i9)) == '0') {
            throw new NumberFormatException("illegal syntax");
        }
        int i11 = -1;
        int i12 = i3;
        long j2 = 0;
        boolean z8 = false;
        while (true) {
            if (i12 >= i9) {
                z = true;
                z2 = z6;
                z3 = z7;
                abstractJsonFloatingPointBitsFromCharArray = this;
                break;
            }
            cCharAt = cArr[i12];
            if (!FastDoubleSwar.isDigit(cCharAt)) {
                z2 = z6;
                z = true;
                if (cCharAt != '.') {
                    abstractJsonFloatingPointBitsFromCharArray = this;
                    z3 = z7;
                    break;
                }
                z8 |= i11 >= 0;
                int i13 = i12;
                while (i13 < i9 - 8 && (iTryToParseEightDigits = tryToParseEightDigits(cArr, i13 + 1)) >= 0) {
                    j2 = (j2 * 100000000) + ((long) iTryToParseEightDigits);
                    i13 += 8;
                    c2 = c2;
                    z7 = z7;
                }
                c = c2;
                z5 = z7;
                i11 = i12;
                i12 = i13;
            } else {
                z2 = z6;
                j2 = ((j2 * 10) + ((long) cCharAt)) - 48;
                c = c2;
                z5 = z7;
            }
            i12++;
            z6 = z2;
            c2 = c;
            z7 = z5;
        }
        if (i11 < 0) {
            i4 = i12 - i3;
            i11 = i12;
            i5 = 0;
        } else {
            i4 = (i12 - i3) - 1;
            i5 = (i11 - i12) + 1;
        }
        if ((cCharAt | TokenParser.f2383SP) == 101) {
            i6 = i12 + 1;
            char cCharAt3 = charAt(cArr, i6, i9);
            boolean z9 = cCharAt3 == '-' ? z : false;
            if (z9 || cCharAt3 == '+') {
                i6 = i12 + 2;
                cCharAt3 = charAt(cArr, i6, i9);
            }
            boolean z10 = z8 | (!FastDoubleSwar.isDigit(cCharAt3));
            i7 = 0;
            do {
                if (i7 < 1024) {
                    i7 = ((i7 * 10) + cCharAt3) - 48;
                }
                i6++;
                cCharAt3 = charAt(cArr, i6, i9);
            } while (FastDoubleSwar.isDigit(cCharAt3));
            if (z9) {
                i7 = -i7;
            }
            i5 += i7;
            z8 = z10;
        } else {
            i6 = i12;
            i7 = 0;
        }
        if (z8 || i6 < i9 || (!z3 && i4 == 0)) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i4 > 19) {
            int i14 = 0;
            long j3 = 0;
            while (i3 < i12) {
                char c3 = cArr[i3];
                if (c3 != '.') {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = ((j3 * 10) + ((long) c3)) - 48;
                } else {
                    i14++;
                }
                i3++;
            }
            if (i3 >= i12) {
                z = false;
            }
            i8 = (i11 - i3) + i14 + i7;
            j = j3;
            z4 = z;
        } else {
            j = j2;
            z4 = false;
            i8 = 0;
        }
        return abstractJsonFloatingPointBitsFromCharArray.valueOfFloatLiteral(cArr, i, i9, z2, j, i5, z4, i8);
    }

    private int tryToParseEightDigits(char[] cArr, int i) {
        return FastDoubleSwar.tryToParseEightDigits(cArr, i);
    }
}
