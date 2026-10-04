package ch.randelshofer.fastdoubleparser;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractJsonFloatingPointBitsFromByteArray extends AbstractFloatValueParser {
    abstract long valueOfFloatLiteral(byte[] bArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    AbstractJsonFloatingPointBitsFromByteArray() {
    }

    public final long parseNumber(byte[] bArr, int i, int i2) {
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
        AbstractJsonFloatingPointBitsFromByteArray abstractJsonFloatingPointBitsFromByteArray;
        boolean z4;
        int iTryToParseFourDigits;
        int i9 = i + i2;
        if (i < 0 || i9 < i || i9 > bArr.length || i2 > 2147483643) {
            throw new IllegalArgumentException("offset < 0 or length > str.length");
        }
        byte bCharAt = charAt(bArr, i, i9);
        boolean z5 = bCharAt == 45;
        if (z5) {
            int i10 = i + 1;
            byte bCharAt2 = charAt(bArr, i10, i9);
            if (bCharAt2 == 0) {
                throw new NumberFormatException("illegal syntax");
            }
            i3 = i10;
            bCharAt = bCharAt2;
        } else {
            i3 = i;
        }
        boolean z6 = bCharAt == 48;
        if (z6 && (bCharAt = charAt(bArr, (i3 = i3 + 1), i9)) == 48) {
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
            bCharAt = bArr[i12];
            if (!FastDoubleSwar.isDigit(bCharAt)) {
                z = z5;
                z2 = true;
                if (bCharAt != 46) {
                    break;
                }
                z7 |= i11 >= 0;
                int i13 = i12;
                while (i13 < i9 - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(bArr, i13 + 1)) >= 0) {
                    j2 = (j2 * 10000) + ((long) iTryToParseFourDigits);
                    i13 += 4;
                }
                i11 = i12;
                i12 = i13;
            } else {
                z = z5;
                j2 = ((j2 * 10) + ((long) bCharAt)) - 48;
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
        if ((bCharAt | 32) == 101) {
            i6 = i12 + 1;
            byte bCharAt3 = charAt(bArr, i6, i9);
            boolean z8 = bCharAt3 == 45 ? z2 : false;
            if (z8 || bCharAt3 == 43) {
                i6 = i12 + 2;
                bCharAt3 = charAt(bArr, i6, i9);
            }
            boolean z9 = z7 | (!FastDoubleSwar.isDigit(bCharAt3));
            i7 = 0;
            do {
                if (i7 < 1024) {
                    i7 = ((i7 * 10) + bCharAt3) - 48;
                }
                i6++;
                bCharAt3 = charAt(bArr, i6, i9);
            } while (FastDoubleSwar.isDigit(bCharAt3));
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
            int i14 = 0;
            long j3 = 0;
            while (i3 < i12) {
                byte b = bArr[i3];
                if (b != 46) {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = ((j3 * 10) + ((long) b)) - 48;
                } else {
                    i14++;
                }
                i3++;
            }
            if (i3 >= i12) {
                z2 = false;
            }
            i8 = (i11 - i3) + i14 + i7;
            j = j3;
            z3 = z2;
            z4 = z;
            abstractJsonFloatingPointBitsFromByteArray = this;
        } else {
            j = j2;
            z3 = false;
            i8 = 0;
            abstractJsonFloatingPointBitsFromByteArray = this;
            z4 = z;
        }
        return abstractJsonFloatingPointBitsFromByteArray.valueOfFloatLiteral(bArr, i, i9, z4, j, i5, z3, i8);
    }
}
