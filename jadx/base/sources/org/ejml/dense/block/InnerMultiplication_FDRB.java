package org.ejml.dense.block;

/* JADX INFO: loaded from: classes9.dex */
public class InnerMultiplication_FDRB {
    public static void blockMultPlus(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i4) {
            int i9 = i8 + i6;
            int i10 = i + i5;
            int i11 = i2;
            while (i != i10) {
                int i12 = i + 1;
                float f = fArr[i];
                int i13 = i8;
                while (i13 != i9) {
                    fArr3[i13] = fArr3[i13] + (fArr2[i11] * f);
                    i13++;
                    i11++;
                }
                i = i12;
            }
            i7++;
            i8 = i9;
        }
    }

    public static void blockMultPlusTransA(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                float f = fArr[i9];
                int i12 = i11 + i6;
                int i13 = i8;
                while (i11 != i12) {
                    fArr3[i13] = fArr3[i13] + (fArr2[i11] * f);
                    i13++;
                    i11++;
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultPlusTransB(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                float f = 0.0f;
                for (int i9 = 0; i9 < i5; i9++) {
                    f += fArr[(i7 * i5) + i9 + i] * fArr2[(i8 * i5) + i9 + i2];
                }
                int i10 = (i7 * i6) + i8 + i3;
                fArr3[i10] = fArr3[i10] + f;
            }
        }
    }

    public static void blockMultMinus(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i4) {
            int i9 = i8 + i6;
            int i10 = i + i5;
            int i11 = i2;
            while (i != i10) {
                int i12 = i + 1;
                float f = fArr[i];
                int i13 = i8;
                while (i13 != i9) {
                    fArr3[i13] = fArr3[i13] - (fArr2[i11] * f);
                    i13++;
                    i11++;
                }
                i = i12;
            }
            i7++;
            i8 = i9;
        }
    }

    public static void blockMultMinusTransA(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                float f = fArr[i9];
                int i12 = i11 + i6;
                int i13 = i8;
                while (i11 != i12) {
                    fArr3[i13] = fArr3[i13] - (fArr2[i11] * f);
                    i13++;
                    i11++;
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultMinusTransB(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                float f = 0.0f;
                for (int i9 = 0; i9 < i5; i9++) {
                    f += fArr[(i7 * i5) + i9 + i] * fArr2[(i8 * i5) + i9 + i2];
                }
                int i10 = (i7 * i6) + i8 + i3;
                fArr3[i10] = fArr3[i10] - f;
            }
        }
    }

    public static void blockMultSet(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i4) {
            int i10 = i7 + i6;
            int i11 = i9 + i5;
            int i12 = i2;
            while (i9 != i11) {
                int i13 = i9 + 1;
                float f = fArr[i9];
                int i14 = i7;
                if (i12 == i2) {
                    while (i14 != i10) {
                        fArr3[i14] = fArr2[i12] * f;
                        i14++;
                        i12++;
                    }
                } else {
                    while (i14 != i10) {
                        fArr3[i14] = fArr3[i14] + (fArr2[i12] * f);
                        i14++;
                        i12++;
                    }
                }
                i9 = i13;
            }
            i8++;
            i7 = i10;
        }
    }

    public static void blockMultSetTransA(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                float f = fArr[i9];
                int i12 = i11 + i6;
                int i13 = i8;
                if (i11 == i2) {
                    while (i11 != i12) {
                        fArr3[i13] = fArr2[i11] * f;
                        i13++;
                        i11++;
                    }
                } else {
                    while (i11 != i12) {
                        fArr3[i13] = fArr3[i13] + (fArr2[i11] * f);
                        i13++;
                        i11++;
                    }
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultSetTransB(float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                float f = 0.0f;
                for (int i9 = 0; i9 < i5; i9++) {
                    f += fArr[(i7 * i5) + i9 + i] * fArr2[(i8 * i5) + i9 + i2];
                }
                fArr3[(i7 * i6) + i8 + i3] = f;
            }
        }
    }

    public static void blockMultPlus(float f, float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i4) {
            int i10 = i7 + i6;
            int i11 = i9 + i5;
            int i12 = i2;
            while (i9 != i11) {
                int i13 = i9 + 1;
                float f2 = fArr[i9] * f;
                int i14 = i7;
                while (i14 != i10) {
                    fArr3[i14] = fArr3[i14] + (fArr2[i12] * f2);
                    i14++;
                    i12++;
                }
                i9 = i13;
            }
            i8++;
            i7 = i10;
        }
    }

    public static void blockMultPlusTransA(float f, float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                float f2 = fArr[i9] * f;
                int i12 = i11 + i6;
                int i13 = i8;
                while (i11 != i12) {
                    fArr3[i13] = fArr3[i13] + (fArr2[i11] * f2);
                    i13++;
                    i11++;
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultPlusTransB(float f, float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                float f2 = 0.0f;
                for (int i9 = 0; i9 < i5; i9++) {
                    f2 += fArr[(i7 * i5) + i9 + i] * fArr2[(i8 * i5) + i9 + i2];
                }
                int i10 = (i7 * i6) + i8 + i3;
                fArr3[i10] = fArr3[i10] + (f2 * f);
            }
        }
    }

    public static void blockMultSet(float f, float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i4) {
            int i10 = i7 + i6;
            int i11 = i9 + i5;
            int i12 = i2;
            while (i9 != i11) {
                int i13 = i9 + 1;
                float f2 = fArr[i9] * f;
                int i14 = i7;
                if (i12 == i2) {
                    while (i14 != i10) {
                        fArr3[i14] = fArr2[i12] * f2;
                        i14++;
                        i12++;
                    }
                } else {
                    while (i14 != i10) {
                        fArr3[i14] = fArr3[i14] + (fArr2[i12] * f2);
                        i14++;
                        i12++;
                    }
                }
                i9 = i13;
            }
            i8++;
            i7 = i10;
        }
    }

    public static void blockMultSetTransA(float f, float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i7 + i;
            int i10 = (i5 * i4) + i9;
            int i11 = i2;
            while (i9 != i10) {
                float f2 = fArr[i9] * f;
                int i12 = i11 + i6;
                int i13 = i8;
                if (i11 == i2) {
                    while (i11 != i12) {
                        fArr3[i13] = fArr2[i11] * f2;
                        i13++;
                        i11++;
                    }
                } else {
                    while (i11 != i12) {
                        fArr3[i13] = fArr3[i13] + (fArr2[i11] * f2);
                        i13++;
                        i11++;
                    }
                }
                i9 += i5;
            }
            i7++;
            i8 += i6;
        }
    }

    public static void blockMultSetTransB(float f, float[] fArr, float[] fArr2, float[] fArr3, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i4; i7++) {
            for (int i8 = 0; i8 < i6; i8++) {
                float f2 = 0.0f;
                for (int i9 = 0; i9 < i5; i9++) {
                    f2 += fArr[(i7 * i5) + i9 + i] * fArr2[(i8 * i5) + i9 + i2];
                }
                fArr3[(i7 * i6) + i8 + i3] = f2 * f;
            }
        }
    }
}
