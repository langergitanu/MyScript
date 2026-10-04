package org.ejml.dense.block;

import org.ejml.data.FSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class TriangularSolver_FDRB {
    public static void invert(int i, boolean z, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, float[] fArr) {
        int i2 = i;
        float[] fArr2 = fArr;
        if (z) {
            throw new IllegalArgumentException("Upper triangular matrices not supported yet");
        }
        if (fArr2.length < i2 * i2) {
            throw new IllegalArgumentException("Temp must be at least blockLength*blockLength long.");
        }
        if (fSubmatrixD1.row0 != fSubmatrixD12.row0 || fSubmatrixD1.row1 != fSubmatrixD12.row1 || fSubmatrixD1.col0 != fSubmatrixD12.col0 || fSubmatrixD1.col1 != fSubmatrixD12.col1) {
            throw new IllegalArgumentException("T and T_inv must be at the same elements in the matrix");
        }
        int i3 = fSubmatrixD1.row1 - fSubmatrixD1.row0;
        float[] fArr3 = fSubmatrixD1.original.data;
        float[] fArr4 = fSubmatrixD12.original.data;
        int i4 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (fSubmatrixD1.col0 * i3);
        int i5 = 0;
        while (i5 < i3) {
            int iMin = Math.min(fSubmatrixD1.row1 - (fSubmatrixD1.row0 + i5), i2);
            int i6 = (fSubmatrixD1.original.numCols * (fSubmatrixD1.row0 + i5)) + i4 + ((fSubmatrixD1.col0 + i5) * iMin);
            int i7 = 0;
            while (i7 < i5) {
                int iMin2 = Math.min(fSubmatrixD1.col1 - (fSubmatrixD1.col0 + i7), i2);
                for (int i8 = 0; i8 < fArr2.length; i8++) {
                    fArr2[i8] = 0.0f;
                }
                int i9 = i7;
                while (i9 < i5) {
                    int iMin3 = Math.min(fSubmatrixD1.col1 - (fSubmatrixD1.col0 + i9), i2);
                    float[] fArr5 = fArr2;
                    float[] fArr6 = fArr4;
                    float[] fArr7 = fArr3;
                    InnerMultiplication_FDRB.blockMultMinus(fArr7, fArr6, fArr5, (fSubmatrixD1.original.numCols * (fSubmatrixD1.row0 + i5)) + i4 + ((fSubmatrixD1.col0 + i9) * iMin), (fSubmatrixD1.original.numCols * (fSubmatrixD1.row0 + i9)) + i4 + ((fSubmatrixD1.col0 + i7) * iMin3), 0, iMin, iMin3, iMin2);
                    i9 += i;
                    fArr2 = fArr;
                    i7 = i7;
                    fArr3 = fArr7;
                    fArr4 = fArr6;
                    i2 = i;
                }
                float[] fArr8 = fArr4;
                float[] fArr9 = fArr3;
                int i10 = i7;
                int i11 = iMin;
                int i12 = (fSubmatrixD1.original.numCols * (fSubmatrixD1.row0 + i5)) + i4 + (i11 * (fSubmatrixD1.col0 + i10));
                fArr2 = fArr;
                InnerTriangularSolver_FDRB.solveL(fArr9, fArr2, i11, iMin2, i11, i6, 0);
                System.arraycopy(fArr2, 0, fArr8, i12, iMin2 * i11);
                i7 = i10 + i;
                i2 = i;
                iMin = i11;
                fArr3 = fArr9;
                fArr4 = fArr8;
            }
            float[] fArr10 = fArr4;
            float[] fArr11 = fArr3;
            InnerTriangularSolver_FDRB.invertLower(fArr11, fArr10, iMin, i6, i6);
            i5 += i;
            i2 = i;
            fArr3 = fArr11;
            fArr4 = fArr10;
        }
    }

    public static void invert(int i, boolean z, FSubmatrixD1 fSubmatrixD1, float[] fArr) {
        float[] fArr2 = fArr;
        if (z) {
            throw new IllegalArgumentException("Upper triangular matrices not supported yet");
        }
        if (fArr2.length < i * i) {
            throw new IllegalArgumentException("Temp must be at least blockLength*blockLength long.");
        }
        int i2 = fSubmatrixD1.row1 - fSubmatrixD1.row0;
        float[] fArr3 = fSubmatrixD1.original.data;
        int i3 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (fSubmatrixD1.col0 * i2);
        int i4 = 0;
        while (i4 < i2) {
            int iMin = Math.min(fSubmatrixD1.row1 - (fSubmatrixD1.row0 + i4), i);
            int i5 = (fSubmatrixD1.original.numCols * (fSubmatrixD1.row0 + i4)) + i3 + ((fSubmatrixD1.col0 + i4) * iMin);
            int i6 = 0;
            while (i6 < i4) {
                int iMin2 = Math.min(fSubmatrixD1.col1 - (fSubmatrixD1.col0 + i6), i);
                for (int i7 = 0; i7 < fArr2.length; i7++) {
                    fArr2[i7] = 0.0f;
                }
                int i8 = i6;
                while (i8 < i4) {
                    int iMin3 = Math.min(fSubmatrixD1.col1 - (fSubmatrixD1.col0 + i8), i);
                    int i9 = iMin;
                    InnerMultiplication_FDRB.blockMultMinus(fArr3, fArr3, fArr, (fSubmatrixD1.original.numCols * (fSubmatrixD1.row0 + i4)) + i3 + ((fSubmatrixD1.col0 + i8) * iMin), (fSubmatrixD1.original.numCols * (fSubmatrixD1.row0 + i8)) + i3 + ((fSubmatrixD1.col0 + i6) * iMin3), 0, i9, iMin3, iMin2);
                    iMin = i9;
                    i8 += i;
                    i6 = i6;
                }
                int i10 = i6;
                int i11 = (fSubmatrixD1.original.numCols * (fSubmatrixD1.row0 + i4)) + i3 + ((fSubmatrixD1.col0 + i10) * iMin);
                fArr2 = fArr;
                InnerTriangularSolver_FDRB.solveL(fArr3, fArr2, iMin, iMin2, iMin, i5, 0);
                System.arraycopy(fArr2, 0, fArr3, i11, iMin2 * iMin);
                i6 = i10 + i;
            }
            InnerTriangularSolver_FDRB.invertLower(fArr3, iMin, i5);
            i4 += i;
        }
    }

    public static void solve(int i, boolean z, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, boolean z2) {
        if (z) {
            solveR(i, fSubmatrixD1, fSubmatrixD12, z2);
        } else {
            solveL(i, fSubmatrixD1, fSubmatrixD12, z2);
        }
    }

    public static void solveBlock(int i, boolean z, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, boolean z2, boolean z3) {
        int i2 = fSubmatrixD1.row1 - fSubmatrixD1.row0;
        if (i2 > i) {
            throw new IllegalArgumentException("T can be at most the size of a block");
        }
        int iMin = Math.min(i, fSubmatrixD1.original.numRows - fSubmatrixD1.row0);
        int iMin2 = Math.min(i, fSubmatrixD1.original.numCols - fSubmatrixD1.col0);
        int i3 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (fSubmatrixD1.col0 * iMin);
        float[] fArr = fSubmatrixD1.original.data;
        float[] fArr2 = fSubmatrixD12.original.data;
        if (z3) {
            if (z) {
                if (z2) {
                    throw new IllegalArgumentException("Operation not yet supported");
                }
                throw new IllegalArgumentException("Operation not yet supported");
            }
            if (z2) {
                throw new IllegalArgumentException("Operation not yet supported");
            }
            int i4 = fSubmatrixD12.row0;
            while (i4 < fSubmatrixD12.row1) {
                int i5 = i4 + i;
                int iMin3 = Math.min(fSubmatrixD12.row1, i5) - i4;
                InnerTriangularSolver_FDRB.solveLTransB(fArr, fArr2, iMin, iMin3, iMin, i3, (i4 * fSubmatrixD12.original.numCols) + (fSubmatrixD12.col0 * iMin3));
                i4 = i5;
            }
            return;
        }
        if (i2 != fSubmatrixD12.row1 - fSubmatrixD12.row0) {
            throw new IllegalArgumentException("T and B must have the same number of rows.");
        }
        if (z) {
            if (z2) {
                int i6 = fSubmatrixD12.col0;
                while (i6 < fSubmatrixD12.col1) {
                    int i7 = i6 + i;
                    InnerTriangularSolver_FDRB.solveTransU(fArr, fArr2, i2, Math.min(fSubmatrixD12.col1, i7) - i6, i2, i3, (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (i2 * i6));
                    i6 = i7;
                }
                return;
            }
            int i8 = fSubmatrixD12.col0;
            while (i8 < fSubmatrixD12.col1) {
                int i9 = i8 + i;
                InnerTriangularSolver_FDRB.solveU(fArr, fArr2, i2, Math.min(fSubmatrixD12.col1, i9) - i8, i2, i3, (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (i2 * i8));
                i8 = i9;
            }
            return;
        }
        if (z2) {
            int i10 = fSubmatrixD12.col0;
            while (i10 < fSubmatrixD12.col1) {
                int i11 = i10 + i;
                InnerTriangularSolver_FDRB.solveTransL(fArr, fArr2, i2, Math.min(fSubmatrixD12.col1, i11) - i10, iMin2, i3, (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (i2 * i10));
                i10 = i11;
            }
            return;
        }
        int i12 = fSubmatrixD12.col0;
        while (i12 < fSubmatrixD12.col1) {
            int i13 = i12 + i;
            InnerTriangularSolver_FDRB.solveL(fArr, fArr2, i2, Math.min(fSubmatrixD12.col1, i13) - i12, iMin2, i3, (fSubmatrixD12.row0 * fSubmatrixD12.original.numCols) + (i2 * i12));
            i12 = i13;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void solveL(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, boolean z) {
        int i2;
        int i3;
        FSubmatrixD1 fSubmatrixD13 = new FSubmatrixD1(fSubmatrixD12.original);
        FSubmatrixD1 fSubmatrixD14 = new FSubmatrixD1(fSubmatrixD1.original);
        FSubmatrixD1 fSubmatrixD15 = new FSubmatrixD1(fSubmatrixD12.original);
        int i4 = fSubmatrixD12.row1 - fSubmatrixD12.row0;
        if (z) {
            i2 = i4 - (i4 % i);
            if (i2 == i4 && i4 >= i) {
                i2 -= i;
            }
            i3 = -i;
        } else {
            i2 = 0;
            i3 = i;
        }
        int i5 = i2;
        while (true) {
            if (z) {
                if (i5 < 0) {
                    return;
                }
            } else if (i5 >= i4) {
                return;
            }
            int iMin = Math.min(i, i4 - i5);
            fSubmatrixD14.col0 = fSubmatrixD1.col0 + i5;
            fSubmatrixD14.col1 = fSubmatrixD14.col0 + iMin;
            fSubmatrixD14.row0 = fSubmatrixD1.row0 + i5;
            fSubmatrixD14.row1 = fSubmatrixD14.row0 + iMin;
            fSubmatrixD15.col0 = fSubmatrixD12.col0;
            fSubmatrixD15.col1 = fSubmatrixD12.col1;
            fSubmatrixD15.row0 = fSubmatrixD12.row0 + i5;
            fSubmatrixD15.row1 = fSubmatrixD15.row0 + iMin;
            int i6 = i;
            boolean z2 = z;
            solveBlock(i6, false, fSubmatrixD14, fSubmatrixD15, z2, false);
            if (z2) {
                if (fSubmatrixD14.row0 > 0) {
                    if (z2) {
                        fSubmatrixD14.col1 = fSubmatrixD14.col0;
                        fSubmatrixD14.col0 = fSubmatrixD14.col1 - i6;
                        fSubmatrixD14.row1 = fSubmatrixD1.row1;
                        fSubmatrixD15.row1 = fSubmatrixD12.row1;
                        fSubmatrixD13.row0 = fSubmatrixD15.row0 - i6;
                        fSubmatrixD13.row1 = fSubmatrixD15.row0;
                    } else {
                        fSubmatrixD14.row0 = fSubmatrixD14.row1;
                        fSubmatrixD14.row1 = Math.min(fSubmatrixD14.row0 + i6, fSubmatrixD1.row1);
                        fSubmatrixD14.col0 = fSubmatrixD1.col0;
                        fSubmatrixD15.row0 = fSubmatrixD12.row0;
                        fSubmatrixD13.row0 = fSubmatrixD15.row1;
                        fSubmatrixD13.row1 = Math.min(fSubmatrixD13.row0 + i6, fSubmatrixD12.row1);
                    }
                    int i7 = fSubmatrixD12.col0;
                    while (i7 < fSubmatrixD12.col1) {
                        fSubmatrixD15.col0 = i7;
                        i7 += i6;
                        fSubmatrixD15.col1 = Math.min(i7, fSubmatrixD12.col1);
                        fSubmatrixD13.col0 = fSubmatrixD15.col0;
                        fSubmatrixD13.col1 = fSubmatrixD15.col1;
                        if (z2) {
                            MatrixMult_FDRB.multMinusTransA(i6, fSubmatrixD14, fSubmatrixD15, fSubmatrixD13);
                        } else {
                            MatrixMult_FDRB.multMinus(i6, fSubmatrixD14, fSubmatrixD15, fSubmatrixD13);
                        }
                    }
                }
            } else if (fSubmatrixD14.row1 < fSubmatrixD1.row1) {
            }
            i5 += i3;
            i = i6;
            z = z2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void solveR(int i, FSubmatrixD1 fSubmatrixD1, FSubmatrixD1 fSubmatrixD12, boolean z) {
        int i2;
        int i3;
        int i4 = fSubmatrixD12.row1 - fSubmatrixD12.row0;
        if (fSubmatrixD1.getCols() != i4) {
            throw new IllegalArgumentException("Number of columns in R must be equal to the number of rows in B");
        }
        if (fSubmatrixD1.getRows() != i4) {
            throw new IllegalArgumentException("Number of rows in R must be equal to the number of rows in B");
        }
        FSubmatrixD1 fSubmatrixD13 = new FSubmatrixD1(fSubmatrixD12.original);
        FSubmatrixD1 fSubmatrixD14 = new FSubmatrixD1(fSubmatrixD1.original);
        FSubmatrixD1 fSubmatrixD15 = new FSubmatrixD1(fSubmatrixD12.original);
        if (z) {
            i2 = 0;
            i3 = i;
        } else {
            i2 = i4 - (i4 % i);
            if (i2 == i4 && i4 >= i) {
                i2 -= i;
            }
            i3 = -i;
        }
        while (true) {
            if (z) {
                if (i2 >= i4) {
                    return;
                }
            } else if (i2 < 0) {
                return;
            }
            int iMin = Math.min(i, i4 - i2);
            fSubmatrixD14.col0 = fSubmatrixD1.col0 + i2;
            fSubmatrixD14.col1 = fSubmatrixD14.col0 + iMin;
            fSubmatrixD14.row0 = fSubmatrixD1.row0 + i2;
            fSubmatrixD14.row1 = fSubmatrixD14.row0 + iMin;
            fSubmatrixD15.col0 = fSubmatrixD12.col0;
            fSubmatrixD15.col1 = fSubmatrixD12.col1;
            fSubmatrixD15.row0 = fSubmatrixD12.row0 + i2;
            fSubmatrixD15.row1 = fSubmatrixD15.row0 + iMin;
            int i5 = i;
            boolean z2 = z;
            solveBlock(i5, true, fSubmatrixD14, fSubmatrixD15, z2, false);
            if (z2) {
                if (fSubmatrixD14.row1 < fSubmatrixD1.row1) {
                    if (z2) {
                        fSubmatrixD14.col0 = fSubmatrixD14.col1;
                        fSubmatrixD14.col1 = Math.min(fSubmatrixD14.col0 + i5, fSubmatrixD1.col1);
                        fSubmatrixD14.row0 = fSubmatrixD1.row0;
                        fSubmatrixD15.row0 = fSubmatrixD12.row0;
                        fSubmatrixD13.row0 = fSubmatrixD15.row1;
                        fSubmatrixD13.row1 = Math.min(fSubmatrixD13.row0 + i5, fSubmatrixD12.row1);
                    } else {
                        fSubmatrixD14.row1 = fSubmatrixD14.row0;
                        fSubmatrixD14.row0 = fSubmatrixD14.row1 - i5;
                        fSubmatrixD14.col1 = fSubmatrixD1.col1;
                        fSubmatrixD15.row1 = fSubmatrixD12.row1;
                        fSubmatrixD13.row0 = fSubmatrixD15.row0 - i5;
                        fSubmatrixD13.row1 = fSubmatrixD15.row0;
                    }
                    int i6 = fSubmatrixD12.col0;
                    while (i6 < fSubmatrixD12.col1) {
                        fSubmatrixD15.col0 = i6;
                        i6 += i5;
                        fSubmatrixD15.col1 = Math.min(i6, fSubmatrixD12.col1);
                        fSubmatrixD13.col0 = fSubmatrixD15.col0;
                        fSubmatrixD13.col1 = fSubmatrixD15.col1;
                        if (z2) {
                            MatrixMult_FDRB.multMinusTransA(i5, fSubmatrixD14, fSubmatrixD15, fSubmatrixD13);
                        } else {
                            MatrixMult_FDRB.multMinus(i5, fSubmatrixD14, fSubmatrixD15, fSubmatrixD13);
                        }
                    }
                }
            } else if (fSubmatrixD14.row0 > 0) {
            }
            i2 += i3;
            i = i5;
            z = z2;
        }
    }
}
