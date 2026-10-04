package ch.randelshofer.fastdoubleparser;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractJavaFloatingPointBitsFromByteArray extends AbstractFloatValueParser {
    abstract long nan();

    abstract long negativeInfinity();

    abstract long positiveInfinity();

    abstract long valueOfFloatLiteral(byte[] bArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    abstract long valueOfHexLiteral(byte[] bArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4);

    AbstractJavaFloatingPointBitsFromByteArray() {
    }

    private static int skipWhitespace(byte[] bArr, int i, int i2) {
        while (i < i2 && (bArr[i] & 255) <= 32) {
            i++;
        }
        return i;
    }

    private long parseDecFloatLiteral(byte[] bArr, int i, int i2, int i3, boolean z, boolean z2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        long j;
        boolean z3;
        int i9;
        AbstractJavaFloatingPointBitsFromByteArray abstractJavaFloatingPointBitsFromByteArray;
        int i10;
        boolean z4;
        int i11;
        int iTryToParseFourDigits;
        int i12 = -1;
        int i13 = i;
        long j2 = 0;
        byte b = 0;
        boolean z5 = false;
        while (true) {
            if (i13 >= i3) {
                break;
            }
            b = bArr[i13];
            if (!FastDoubleSwar.isDigit(b)) {
                if (b != 46) {
                    break;
                }
                z5 |= i12 >= 0;
                int i14 = i13;
                while (i14 < i3 - 4 && (iTryToParseFourDigits = FastDoubleSwar.tryToParseFourDigits(bArr, i14 + 1)) >= 0) {
                    j2 = (j2 * 10000) + ((long) iTryToParseFourDigits);
                    i14 += 4;
                }
                int i15 = i13;
                i13 = i14;
                i12 = i15;
            } else {
                j2 = ((j2 * 10) + ((long) b)) - 48;
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
        if ((b | 32) == 101) {
            i7 = i13 + 1;
            byte bCharAt = charAt(bArr, i7, i3);
            boolean z6 = bCharAt == 45;
            if (z6 || bCharAt == 43) {
                i7 = i13 + 2;
                bCharAt = charAt(bArr, i7, i3);
            }
            boolean z7 = z5 | (!FastDoubleSwar.isDigit(bCharAt));
            int i16 = 0;
            do {
                if (i16 < 1024) {
                    i16 = ((i16 * 10) + bCharAt) - 48;
                }
                i7++;
                bCharAt = charAt(bArr, i7, i3);
            } while (FastDoubleSwar.isDigit(bCharAt));
            if (z6) {
                i16 = -i16;
            }
            i4 += i16;
            int i17 = i16;
            b = bCharAt;
            i8 = i17;
            z5 = z7;
        } else {
            i7 = i13;
            i8 = 0;
        }
        if ((b == 100) | (b == 68) | (b == 102) | (b == 70)) {
            i7++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i7, i3);
        if (z5 || iSkipWhitespace < i3 || (!z2 && i6 == 0)) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i6 > 19) {
            int i18 = i;
            int i19 = 0;
            long j3 = 0;
            while (i18 < i13) {
                byte b2 = bArr[i18];
                if (b2 != 46) {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = ((j3 * 10) + ((long) b2)) - 48;
                } else {
                    i19++;
                }
                i18++;
            }
            i9 = (i5 - i18) + i19 + i8;
            j = j3;
            z3 = i18 < i13;
            abstractJavaFloatingPointBitsFromByteArray = this;
            z4 = z;
            i11 = i4;
            i10 = i2;
        } else {
            j = j2;
            z3 = false;
            i9 = 0;
            abstractJavaFloatingPointBitsFromByteArray = this;
            i10 = i2;
            z4 = z;
            i11 = i4;
        }
        return abstractJavaFloatingPointBitsFromByteArray.valueOfFloatLiteral(bArr, i10, i3, z4, j, i11, z3, i9);
    }

    public long parseFloatingPointLiteral(byte[] bArr, int i, int i2) {
        boolean z;
        int i3;
        AbstractJavaFloatingPointBitsFromByteArray abstractJavaFloatingPointBitsFromByteArray;
        byte[] bArr2;
        int i4;
        int i5 = i + i2;
        if (i < 0 || i5 < i || i5 > bArr.length || i2 > 2147483643) {
            throw new IllegalArgumentException("offset < 0 or length > str.length");
        }
        int iSkipWhitespace = skipWhitespace(bArr, i, i5);
        if (iSkipWhitespace == i5) {
            throw new NumberFormatException("illegal syntax");
        }
        byte bCharAt = bArr[iSkipWhitespace];
        boolean z2 = true;
        if (bCharAt == 45) {
            z = true;
        } else {
            z = true;
            z2 = false;
        }
        if ((z2 || bCharAt == 43) && (bCharAt = charAt(bArr, (iSkipWhitespace = iSkipWhitespace + 1), i5)) == 0) {
            throw new NumberFormatException("illegal syntax");
        }
        if (bCharAt >= 73) {
            return parseNaNOrInfinity(bArr, iSkipWhitespace, i5, z2);
        }
        boolean z3 = bCharAt == 48 ? z : false;
        if (z3) {
            int i6 = iSkipWhitespace + 1;
            byte bCharAt2 = charAt(bArr, i6, i5);
            if (bCharAt2 == 120 || bCharAt2 == 88) {
                return parseHexFloatingPointLiteral(bArr, iSkipWhitespace + 2, i, i5, z2);
            }
            i3 = i6;
            bArr2 = bArr;
            i4 = i;
            abstractJavaFloatingPointBitsFromByteArray = this;
        } else {
            i3 = iSkipWhitespace;
            abstractJavaFloatingPointBitsFromByteArray = this;
            bArr2 = bArr;
            i4 = i;
        }
        return abstractJavaFloatingPointBitsFromByteArray.parseDecFloatLiteral(bArr2, i3, i4, i5, z2, z3);
    }

    private long parseHexFloatingPointLiteral(byte[] bArr, int i, int i2, int i3, boolean z) {
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
        byte b = 0;
        boolean z3 = false;
        while (true) {
            if (i11 >= i3) {
                break;
            }
            b = bArr[i11];
            int iLookupHex = lookupHex(b);
            if (iLookupHex < 0) {
                if (iLookupHex != -4) {
                    break;
                }
                z3 |= i10 >= 0;
                i10 = i11;
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
        boolean z4 = (b | 32) == 112;
        if (z4) {
            i6 = i11 + 1;
            byte bCharAt = charAt(bArr, i6, i3);
            boolean z5 = bCharAt == 45;
            if (z5 || bCharAt == 43) {
                i6 = i11 + 2;
                bCharAt = charAt(bArr, i6, i3);
            }
            boolean z6 = z3 | (!FastDoubleSwar.isDigit(bCharAt));
            int i12 = 0;
            do {
                if (i12 < 1024) {
                    i12 = ((i12 * 10) + bCharAt) - 48;
                }
                i6++;
                bCharAt = charAt(bArr, i6, i3);
            } while (FastDoubleSwar.isDigit(bCharAt));
            if (z5) {
                i12 = -i12;
            }
            iMin += i12;
            int i13 = i12;
            b = bCharAt;
            i7 = i13;
            z3 = z6;
        } else {
            i6 = i11;
            i7 = 0;
        }
        if ((b == 70) | (b == 68) | (b == 100) | (b == 102)) {
            i6++;
        }
        int iSkipWhitespace = skipWhitespace(bArr, i6, i3);
        if (z3 || iSkipWhitespace < i3 || i5 == 0 || !z4) {
            throw new NumberFormatException("illegal syntax");
        }
        if (i5 > 16) {
            int i14 = i;
            int i15 = 0;
            long j3 = 0;
            while (i14 < i11) {
                int iLookupHex2 = lookupHex(bArr[i14]);
                if (iLookupHex2 < 0) {
                    i15++;
                } else {
                    if (Long.compareUnsigned(j3, 1000000000000000000L) >= 0) {
                        break;
                    }
                    j3 = (j3 << 4) | ((long) iLookupHex2);
                }
                i14++;
            }
            boolean z7 = i14 < i11;
            iSkipWhitespace = i14;
            i9 = i15;
            i8 = i7;
            j = j3;
            z2 = z7;
        } else {
            i8 = i7;
            j = j2;
            i9 = 0;
            z2 = false;
        }
        return valueOfHexLiteral(bArr, i2, i3, z, j, iMin, z2, (((i4 - iSkipWhitespace) + i9) * 4) + i8);
    }

    private long parseNaNOrInfinity(byte[] bArr, int i, int i2, boolean z) {
        if (bArr[i] == 78) {
            int i3 = i + 2;
            if (i3 < i2 && bArr[i + 1] == 97 && bArr[i3] == 78 && skipWhitespace(bArr, i + 3, i2) == i2) {
                return nan();
            }
        } else if (i + 7 < i2 && FastDoubleSwar.readLongLE(bArr, i) == 8751735898823355977L && skipWhitespace(bArr, i + 8, i2) == i2) {
            return z ? negativeInfinity() : positiveInfinity();
        }
        throw new NumberFormatException("illegal syntax");
    }
}
