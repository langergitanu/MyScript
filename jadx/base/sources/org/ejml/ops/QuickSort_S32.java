package org.ejml.ops;

/* JADX INFO: loaded from: classes9.dex */
public class QuickSort_S32 {

    /* JADX INFO: renamed from: M */
    private int f2756M;
    private int NSTACK;
    private int[] istack;

    public QuickSort_S32() {
        this.f2756M = 7;
        this.NSTACK = 65;
        this.istack = new int[65];
    }

    public QuickSort_S32(int i, int i2) {
        this.f2756M = i2;
        this.NSTACK = i;
        this.istack = new int[i];
    }

    public void sort(int[] iArr, int i, int[] iArr2) {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            iArr2[i5] = i5;
        }
        int i6 = i - 1;
        int i7 = -1;
        while (true) {
            if (i6 - i4 < this.f2756M) {
                for (int i8 = i4 + 1; i8 <= i6; i8++) {
                    int i9 = iArr2[i8];
                    int i10 = iArr[i9];
                    int i11 = i8 - 1;
                    while (i11 >= i4) {
                        int i12 = iArr2[i11];
                        if (iArr[i12] <= i10) {
                            break;
                        }
                        iArr2[i11 + 1] = i12;
                        i11--;
                    }
                    iArr2[i11 + 1] = i9;
                }
                if (i7 < 0) {
                    return;
                }
                int[] iArr3 = this.istack;
                int i13 = i7 - 1;
                int i14 = iArr3[i7];
                i7 -= 2;
                i4 = iArr3[i13];
                i6 = i14;
            } else {
                int i15 = (i4 + i6) >>> 1;
                int i16 = iArr2[i15];
                int i17 = i4 + 1;
                iArr2[i15] = iArr2[i17];
                iArr2[i17] = i16;
                int i18 = iArr2[i4];
                int i19 = iArr[i18];
                int i20 = iArr2[i6];
                if (i19 > iArr[i20]) {
                    iArr2[i4] = i20;
                    iArr2[i6] = i18;
                }
                int i21 = iArr2[i17];
                int i22 = iArr[i21];
                int i23 = iArr2[i6];
                if (i22 > iArr[i23]) {
                    iArr2[i17] = i23;
                    iArr2[i6] = i21;
                }
                int i24 = iArr2[i4];
                int i25 = iArr[i24];
                int i26 = iArr2[i17];
                if (i25 > iArr[i26]) {
                    iArr2[i4] = i26;
                    iArr2[i17] = i24;
                }
                int i27 = iArr[iArr2[i17]];
                int i28 = i6;
                int i29 = i17;
                while (true) {
                    i29++;
                    if (iArr[iArr2[i29]] >= i27) {
                        while (true) {
                            i2 = i28 - 1;
                            i3 = iArr2[i2];
                            if (iArr[i3] <= i27) {
                                break;
                            } else {
                                i28 = i2;
                            }
                        }
                        if (i2 < i29) {
                            break;
                        }
                        int i30 = iArr2[i29];
                        iArr2[i29] = i3;
                        iArr2[i2] = i30;
                        i28 = i2;
                    }
                }
                int i31 = iArr2[i17];
                iArr2[i17] = i3;
                iArr2[i2] = i31;
                int i32 = i7 + 2;
                if (i32 >= this.NSTACK) {
                    throw new RuntimeException("NSTACK too small");
                }
                if ((i6 - i29) + 1 >= i2 - i4) {
                    int[] iArr4 = this.istack;
                    iArr4[i32] = i6;
                    iArr4[i7 + 1] = i29;
                    i6 = i28 - 2;
                    i7 = i32;
                } else {
                    int[] iArr5 = this.istack;
                    iArr5[i32] = i28 - 2;
                    iArr5[i7 + 1] = i4;
                    i7 = i32;
                    i4 = i29;
                }
            }
        }
    }
}
