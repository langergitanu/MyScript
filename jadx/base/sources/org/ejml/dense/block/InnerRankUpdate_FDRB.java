package org.ejml.dense.block;

import org.ejml.data.FSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class InnerRankUpdate_FDRB {
    public static void rankNUpdate(int i, float f, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12) {
        int i2 = fSubmatrixD12.row1 - fSubmatrixD12.row0;
        if (i2 > i) {
            throw new IllegalArgumentException("Height of B cannot be greater than the block length");
        }
        int i3 = fSubmatrixD12.col1 - fSubmatrixD12.col0;
        if (fSubmatrixD1.col1 - fSubmatrixD1.col0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of columns based on B's width");
        }
        if (fSubmatrixD1.row1 - fSubmatrixD1.row0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of rows based on B's width");
        }
        int i4 = fSubmatrixD12.col0;
        while (i4 < fSubmatrixD12.col1) {
            int i5 = (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (i4 * i2);
            int iMin = Math.min(i, fSubmatrixD12.col1 - i4);
            int i6 = (i4 - fSubmatrixD12.col0) + fSubmatrixD1.row0;
            int iMin2 = Math.min(i, fSubmatrixD1.row1 - i6);
            int i7 = fSubmatrixD12.col0;
            while (i7 < fSubmatrixD12.col1) {
                int iMin3 = Math.min(i, fSubmatrixD12.col1 - i7);
                int i8 = (fSubmatrixD1.original.numCols * i6) + (((i7 - fSubmatrixD12.col0) + fSubmatrixD1.col0) * iMin2);
                InnerMultiplication_FDRB.blockMultPlusTransA(f, fSubmatrixD12.original.data, fSubmatrixD12.original.data, fSubmatrixD1.original.data, i5, (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (i7 * i2), i8, i2, iMin, iMin3);
                i7 += i;
            }
            i4 += i;
        }
    }

    public static void symmRankNMinus_U(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12) {
        int i2 = fSubmatrixD12.row1 - fSubmatrixD12.row0;
        if (i2 > i) {
            throw new IllegalArgumentException("Height of B cannot be greater than the block length");
        }
        int i3 = fSubmatrixD12.col1 - fSubmatrixD12.col0;
        if (fSubmatrixD1.col1 - fSubmatrixD1.col0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of columns based on B's width");
        }
        if (fSubmatrixD1.row1 - fSubmatrixD1.row0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of rows based on B's width");
        }
        int i4 = fSubmatrixD12.col0;
        while (i4 < fSubmatrixD12.col1) {
            int i5 = (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (i4 * i2);
            int iMin = Math.min(i, fSubmatrixD12.col1 - i4);
            int i6 = (i4 - fSubmatrixD12.col0) + fSubmatrixD1.row0;
            int iMin2 = Math.min(i, fSubmatrixD1.row1 - i6);
            int i7 = i4;
            while (i7 < fSubmatrixD12.col1) {
                int iMin3 = Math.min(i, fSubmatrixD12.col1 - i7);
                int i8 = (fSubmatrixD1.original.numCols * i6) + (((i7 - fSubmatrixD12.col0) + fSubmatrixD1.col0) * iMin2);
                int i9 = (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (i7 * i2);
                if (i4 == i7) {
                    multTransABlockMinus_U(fSubmatrixD12.original.data, fSubmatrixD1.original.data, i5, i9, i8, i2, iMin, iMin3);
                } else {
                    multTransABlockMinus(fSubmatrixD12.original.data, fSubmatrixD1.original.data, i5, i9, i8, i2, iMin, iMin3);
                }
                i7 += i;
            }
            i4 += i;
        }
    }

    public static void symmRankNMinus_L(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12) {
        int i2 = fSubmatrixD12.col1 - fSubmatrixD12.col0;
        if (i2 > i) {
            throw new IllegalArgumentException("Width of B cannot be greater than the block length");
        }
        int i3 = fSubmatrixD12.row1 - fSubmatrixD12.row0;
        if (fSubmatrixD1.col1 - fSubmatrixD1.col0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of columns based on B's height");
        }
        if (fSubmatrixD1.row1 - fSubmatrixD1.row0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of rows based on B's height");
        }
        int i4 = fSubmatrixD12.row0;
        while (i4 < fSubmatrixD12.row1) {
            int iMin = Math.min(i, fSubmatrixD12.row1 - i4);
            int i5 = (fSubmatrixD12.original.numCols * i4) + (fSubmatrixD12.col0 * iMin);
            int i6 = (i4 - fSubmatrixD12.row0) + fSubmatrixD1.row0;
            int iMin2 = Math.min(i, fSubmatrixD1.row1 - i6);
            int i7 = fSubmatrixD12.row0;
            while (i7 <= i4) {
                int iMin3 = Math.min(i, fSubmatrixD12.row1 - i7);
                int i8 = (fSubmatrixD1.original.numCols * i6) + (((i7 - fSubmatrixD12.row0) + fSubmatrixD1.col0) * iMin2);
                int i9 = (fSubmatrixD12.original.numCols * i7) + (fSubmatrixD12.col0 * iMin3);
                if (i4 == i7) {
                    multTransBBlockMinus_L(fSubmatrixD12.original.data, fSubmatrixD1.original.data, i5, i9, i8, i2, iMin, iMin3);
                } else {
                    multTransBBlockMinus(fSubmatrixD12.original.data, fSubmatrixD1.original.data, i5, i9, i8, i2, iMin, iMin3);
                }
                i7 += i;
            }
            i4 += i;
        }
    }

    protected static void multTransABlockMinus(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = (i4 * i6) + i2;
        while (i2 != i7) {
            int i8 = i + i5;
            int i9 = i2 + i6;
            int i10 = i3;
            while (i != i8) {
                int i11 = i + 1;
                float f = fArr[i];
                for (int i12 = i2; i12 != i9; i12++) {
                    fArr2[i10] = fArr2[i10] - (fArr[i12] * f);
                    i10++;
                }
                i = i11;
            }
            i = i8;
            i2 = i9;
        }
    }

    protected static void multTransABlockMinus_U(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                float f = fArr[(i8 * i5) + i7 + i];
                int i9 = (i8 * i6) + i2 + i7;
                int i10 = (i7 * i6) + i3 + i7;
                int i11 = (i10 - i7) + i6;
                while (i10 != i11) {
                    fArr2[i10] = fArr2[i10] - (fArr[i9] * f);
                    i10++;
                    i9++;
                }
            }
        }
    }

    protected static void multTransBBlockMinus(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        int i8 = i3;
        while (i7 < i5) {
            int i9 = i + i4;
            int i10 = i8 + i6;
            int i11 = i2;
            while (i8 != i10) {
                float f = 0.0f;
                int i12 = i;
                int i13 = i11;
                while (i12 != i9) {
                    f += fArr[i12] * fArr[i13];
                    i12++;
                    i13++;
                }
                fArr2[i8] = fArr2[i8] - f;
                i11 += i4;
                i8++;
            }
            i7++;
            i = i9;
        }
    }

    protected static void multTransBBlockMinus_L(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = (i7 * i4) + i;
            int i9 = i8 + i4;
            int i10 = (i7 * i6) + i3;
            int i11 = i2;
            int i12 = 0;
            while (i12 <= i7) {
                float f = 0.0f;
                int i13 = i8;
                int i14 = i11;
                while (i13 != i9) {
                    f += fArr[i13] * fArr[i14];
                    i13++;
                    i14++;
                }
                int i15 = i10 + i12;
                fArr2[i15] = fArr2[i15] - f;
                i12++;
                i11 += i4;
            }
        }
    }
}
