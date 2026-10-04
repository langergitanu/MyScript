package ch.randelshofer.fastdoubleparser;

import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractJsonFloatingPointBitsFromCharSequence extends AbstractFloatValueParser {
    abstract long valueOfFloatLiteral(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    AbstractJsonFloatingPointBitsFromCharSequence() {
    }

    public final long parseNumber(CharSequence charSequence, int i, int i2) {
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int i7;
        long j;
        boolean z3;
        int i8;
        AbstractJsonFloatingPointBitsFromCharSequence abstractJsonFloatingPointBitsFromCharSequence;
        boolean z4;
        int i9 = i + i2;
        if (i < 0 || i9 < i || i9 > charSequence.length() || i2 > 2147483643) {
            throw new IllegalArgumentException("offset < 0 or length > str.length");
        }
        char cCharAt = charAt(charSequence, i, i9);
        boolean z5 = cCharAt == '-';
        if (z5) {
            int i10 = i + 1;
            char cCharAt2 = charAt(charSequence, i10, i9);
            if (cCharAt2 == 0) {
                throw new NumberFormatException("illegal syntax");
            }
            i3 = i10;
            cCharAt = cCharAt2;
        } else {
            i3 = i;
        }
        boolean z6 = cCharAt == '0';
        if (z6 && (cCharAt = charAt(charSequence, (i3 = i3 + 1), i9)) == '0') {
            throw new NumberFormatException("illegal syntax");
        }
        int i11 = -1;
        int i12 = i3;
        long j2 = 0;
        boolean z7 = false;
        while (true) {
            if (i12 >= i9) {
                z = z5;
                z2 = true;
                break;
            }
            cCharAt = charSequence.charAt(i12);
            if (!FastDoubleSwar.isDigit(cCharAt)) {
                z = z5;
                z2 = true;
                if (cCharAt != '.') {
                    break;
                }
                z7 |= i11 >= 0;
                i11 = i12;
            } else {
                z = z5;
                j2 = ((j2 * 10) + ((long) cCharAt)) - 48;
            }
            i12++;
            z5 = z;
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
            char cCharAt3 = charAt(charSequence, i6, i9);
            boolean z8 = cCharAt3 == '-' ? z2 : false;
            if (z8 || cCharAt3 == '+') {
                i6 = i12 + 2;
                cCharAt3 = charAt(charSequence, i6, i9);
            }
            boolean z9 = z7 | (!FastDoubleSwar.isDigit(cCharAt3));
            i7 = 0;
            do {
                if (i7 < 1024) {
                    i7 = ((i7 * 10) + cCharAt3) - 48;
                }
                i6++;
                cCharAt3 = charAt(charSequence, i6, i9);
            } while (FastDoubleSwar.isDigit(cCharAt3));
            if (z8) {
                i7 = -i7;
            }
            i5 += i7;
            z7 = z9;
        } else {
            i6 = i12;
            i7 = 0;
        }
        if (z7 || i6 < i9 || (!z6 && i4 == 0)) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i4 > 19) {
            int i13 = 0;
            long j3 = 0;
            while (i3 < i12) {
                char cCharAt4 = charSequence.charAt(i3);
                if (cCharAt4 != '.') {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = ((j3 * 10) + ((long) cCharAt4)) - 48;
                } else {
                    i13++;
                }
                i3++;
            }
            if (i3 >= i12) {
                z2 = false;
            }
            i8 = (i11 - i3) + i13 + i7;
            j = j3;
            z3 = z2;
            z4 = z;
            abstractJsonFloatingPointBitsFromCharSequence = this;
        } else {
            j = j2;
            z3 = false;
            i8 = 0;
            abstractJsonFloatingPointBitsFromCharSequence = this;
            z4 = z;
        }
        return abstractJsonFloatingPointBitsFromCharSequence.valueOfFloatLiteral(charSequence, i, i9, z4, j, i5, z3, i8);
    }
}
