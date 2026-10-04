package org.ejml.dense.block;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class InnerRankUpdate_DDRB {
    public static void rankNUpdate(int i, double d, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12) {
        int i2 = dSubmatrixD12.row1 - dSubmatrixD12.row0;
        if (i2 > i) {
            throw new IllegalArgumentException("Height of B cannot be greater than the block length");
        }
        int i3 = dSubmatrixD12.col1 - dSubmatrixD12.col0;
        if (dSubmatrixD1.col1 - dSubmatrixD1.col0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of columns based on B's width");
        }
        if (dSubmatrixD1.row1 - dSubmatrixD1.row0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of rows based on B's width");
        }
        int i4 = dSubmatrixD12.col0;
        while (i4 < dSubmatrixD12.col1) {
            int i5 = (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (i4 * i2);
            int iMin = Math.min(i, dSubmatrixD12.col1 - i4);
            int i6 = (i4 - dSubmatrixD12.col0) + dSubmatrixD1.row0;
            int iMin2 = Math.min(i, dSubmatrixD1.row1 - i6);
            int i7 = dSubmatrixD12.col0;
            while (i7 < dSubmatrixD12.col1) {
                int iMin3 = Math.min(i, dSubmatrixD12.col1 - i7);
                int i8 = (dSubmatrixD1.original.numCols * i6) + (((i7 - dSubmatrixD12.col0) + dSubmatrixD1.col0) * iMin2);
                InnerMultiplication_DDRB.blockMultPlusTransA(d, dSubmatrixD12.original.data, dSubmatrixD12.original.data, dSubmatrixD1.original.data, i5, (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (i7 * i2), i8, i2, iMin, iMin3);
                i7 += i;
            }
            i4 += i;
        }
    }

    public static void symmRankNMinus_U(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12) {
        int i2 = dSubmatrixD12.row1 - dSubmatrixD12.row0;
        if (i2 > i) {
            throw new IllegalArgumentException("Height of B cannot be greater than the block length");
        }
        int i3 = dSubmatrixD12.col1 - dSubmatrixD12.col0;
        if (dSubmatrixD1.col1 - dSubmatrixD1.col0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of columns based on B's width");
        }
        if (dSubmatrixD1.row1 - dSubmatrixD1.row0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of rows based on B's width");
        }
        int i4 = dSubmatrixD12.col0;
        while (i4 < dSubmatrixD12.col1) {
            int i5 = (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (i4 * i2);
            int iMin = Math.min(i, dSubmatrixD12.col1 - i4);
            int i6 = (i4 - dSubmatrixD12.col0) + dSubmatrixD1.row0;
            int iMin2 = Math.min(i, dSubmatrixD1.row1 - i6);
            int i7 = i4;
            while (i7 < dSubmatrixD12.col1) {
                int iMin3 = Math.min(i, dSubmatrixD12.col1 - i7);
                int i8 = (dSubmatrixD1.original.numCols * i6) + (((i7 - dSubmatrixD12.col0) + dSubmatrixD1.col0) * iMin2);
                int i9 = (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (i7 * i2);
                if (i4 == i7) {
                    multTransABlockMinus_U(dSubmatrixD12.original.data, dSubmatrixD1.original.data, i5, i9, i8, i2, iMin, iMin3);
                } else {
                    multTransABlockMinus(dSubmatrixD12.original.data, dSubmatrixD1.original.data, i5, i9, i8, i2, iMin, iMin3);
                }
                i7 += i;
            }
            i4 += i;
        }
    }

    public static void symmRankNMinus_L(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12) {
        int i2 = dSubmatrixD12.col1 - dSubmatrixD12.col0;
        if (i2 > i) {
            throw new IllegalArgumentException("Width of B cannot be greater than the block length");
        }
        int i3 = dSubmatrixD12.row1 - dSubmatrixD12.row0;
        if (dSubmatrixD1.col1 - dSubmatrixD1.col0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of columns based on B's height");
        }
        if (dSubmatrixD1.row1 - dSubmatrixD1.row0 != i3) {
            throw new IllegalArgumentException("A does not have the expected number of rows based on B's height");
        }
        int i4 = dSubmatrixD12.row0;
        while (i4 < dSubmatrixD12.row1) {
            int iMin = Math.min(i, dSubmatrixD12.row1 - i4);
            int i5 = (dSubmatrixD12.original.numCols * i4) + (dSubmatrixD12.col0 * iMin);
            int i6 = (i4 - dSubmatrixD12.row0) + dSubmatrixD1.row0;
            int iMin2 = Math.min(i, dSubmatrixD1.row1 - i6);
            int i7 = dSubmatrixD12.row0;
            while (i7 <= i4) {
                int iMin3 = Math.min(i, dSubmatrixD12.row1 - i7);
                int i8 = (dSubmatrixD1.original.numCols * i6) + (((i7 - dSubmatrixD12.row0) + dSubmatrixD1.col0) * iMin2);
                int i9 = (dSubmatrixD12.original.numCols * i7) + (dSubmatrixD12.col0 * iMin3);
                if (i4 == i7) {
                    multTransBBlockMinus_L(dSubmatrixD12.original.data, dSubmatrixD1.original.data, i5, i9, i8, i2, iMin, iMin3);
                } else {
                    multTransBBlockMinus(dSubmatrixD12.original.data, dSubmatrixD1.original.data, i5, i9, i8, i2, iMin, iMin3);
                }
                i7 += i;
            }
            i4 += i;
        }
    }

    protected static void multTransABlockMinus(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i2 + (i4 * i6);
        int i8 = i;
        int i9 = i2;
        while (i9 != i7) {
            int i10 = i8 + i5;
            int i11 = i9 + i6;
            int i12 = i3;
            while (i8 != i10) {
                int i13 = i8 + 1;
                double d = dArr[i8];
                for (int i14 = i9; i14 != i11; i14++) {
                    dArr2[i12] = dArr2[i12] - (dArr[i14] * d);
                    i12++;
                }
                i8 = i13;
            }
            i8 = i10;
            i9 = i11;
        }
    }

    protected static void multTransABlockMinus_U(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                double d = dArr[(i8 * i5) + i7 + i];
                int i9 = (i8 * i6) + i2 + i7;
                int i10 = (i7 * i6) + i3 + i7;
                int i11 = (i10 - i7) + i6;
                while (i10 != i11) {
                    dArr2[i10] = dArr2[i10] - (dArr[i9] * d);
                    i10++;
                    i9++;
                }
            }
        }
    }

    protected static void multTransBBlockMinus(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i3;
        int i8 = 0;
        int i9 = i;
        while (i8 < i5) {
            int i10 = i9 + i4;
            int i11 = i7 + i6;
            int i12 = i2;
            while (i7 != i11) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i13 = i12;
                for (int i14 = i9; i14 != i10; i14++) {
                    d += dArr[i14] * dArr[i13];
                    i13++;
                }
                dArr2[i7] = dArr2[i7] - d;
                i12 += i4;
                i7++;
            }
            i8++;
            i9 = i10;
        }
    }

    protected static void multTransBBlockMinus_L(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = (i7 * i4) + i;
            int i9 = i8 + i4;
            int i10 = (i7 * i6) + i3;
            int i11 = i2;
            int i12 = 0;
            while (i12 <= i7) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i13 = i11;
                for (int i14 = i8; i14 != i9; i14++) {
                    d += dArr[i14] * dArr[i13];
                    i13++;
                }
                int i15 = i10 + i12;
                dArr2[i15] = dArr2[i15] - d;
                i12++;
                i11 += i4;
            }
        }
    }
}
