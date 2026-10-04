package org.ejml.dense.block;

import org.ejml.data.DSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class TriangularSolver_DDRB {
    public static void invert(int i, boolean z, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, double[] dArr) {
        int i2 = i;
        double[] dArr2 = dArr;
        if (z) {
            throw new IllegalArgumentException("Upper triangular matrices not supported yet");
        }
        if (dArr2.length < i2 * i2) {
            throw new IllegalArgumentException("Temp must be at least blockLength*blockLength long.");
        }
        if (dSubmatrixD1.row0 != dSubmatrixD12.row0 || dSubmatrixD1.row1 != dSubmatrixD12.row1 || dSubmatrixD1.col0 != dSubmatrixD12.col0 || dSubmatrixD1.col1 != dSubmatrixD12.col1) {
            throw new IllegalArgumentException("T and T_inv must be at the same elements in the matrix");
        }
        int i3 = dSubmatrixD1.row1 - dSubmatrixD1.row0;
        double[] dArr3 = dSubmatrixD1.original.data;
        double[] dArr4 = dSubmatrixD12.original.data;
        int i4 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (dSubmatrixD1.col0 * i3);
        int i5 = 0;
        while (i5 < i3) {
            int iMin = Math.min(dSubmatrixD1.row1 - (dSubmatrixD1.row0 + i5), i2);
            int i6 = (dSubmatrixD1.original.numCols * (dSubmatrixD1.row0 + i5)) + i4 + ((dSubmatrixD1.col0 + i5) * iMin);
            int i7 = 0;
            while (i7 < i5) {
                int iMin2 = Math.min(dSubmatrixD1.col1 - (dSubmatrixD1.col0 + i7), i2);
                for (int i8 = 0; i8 < dArr2.length; i8++) {
                    dArr2[i8] = 0.0d;
                }
                int i9 = i7;
                while (i9 < i5) {
                    int iMin3 = Math.min(dSubmatrixD1.col1 - (dSubmatrixD1.col0 + i9), i2);
                    double[] dArr5 = dArr2;
                    double[] dArr6 = dArr4;
                    double[] dArr7 = dArr3;
                    InnerMultiplication_DDRB.blockMultMinus(dArr7, dArr6, dArr5, (dSubmatrixD1.original.numCols * (dSubmatrixD1.row0 + i5)) + i4 + ((dSubmatrixD1.col0 + i9) * iMin), (dSubmatrixD1.original.numCols * (dSubmatrixD1.row0 + i9)) + i4 + ((dSubmatrixD1.col0 + i7) * iMin3), 0, iMin, iMin3, iMin2);
                    i9 += i;
                    dArr2 = dArr;
                    i7 = i7;
                    dArr3 = dArr7;
                    dArr4 = dArr6;
                    i2 = i;
                }
                double[] dArr8 = dArr4;
                double[] dArr9 = dArr3;
                int i10 = i7;
                int i11 = iMin;
                int i12 = (dSubmatrixD1.original.numCols * (dSubmatrixD1.row0 + i5)) + i4 + (i11 * (dSubmatrixD1.col0 + i10));
                dArr2 = dArr;
                InnerTriangularSolver_DDRB.solveL(dArr9, dArr2, i11, iMin2, i11, i6, 0);
                System.arraycopy(dArr2, 0, dArr8, i12, iMin2 * i11);
                i7 = i10 + i;
                i2 = i;
                iMin = i11;
                dArr3 = dArr9;
                dArr4 = dArr8;
            }
            double[] dArr10 = dArr4;
            double[] dArr11 = dArr3;
            InnerTriangularSolver_DDRB.invertLower(dArr11, dArr10, iMin, i6, i6);
            i5 += i;
            i2 = i;
            dArr3 = dArr11;
            dArr4 = dArr10;
        }
    }

    public static void invert(int i, boolean z, DSubmatrixD1 dSubmatrixD1, double[] dArr) {
        double[] dArr2 = dArr;
        if (z) {
            throw new IllegalArgumentException("Upper triangular matrices not supported yet");
        }
        if (dArr2.length < i * i) {
            throw new IllegalArgumentException("Temp must be at least blockLength*blockLength long.");
        }
        int i2 = dSubmatrixD1.row1 - dSubmatrixD1.row0;
        double[] dArr3 = dSubmatrixD1.original.data;
        int i3 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (dSubmatrixD1.col0 * i2);
        int i4 = 0;
        while (i4 < i2) {
            int iMin = Math.min(dSubmatrixD1.row1 - (dSubmatrixD1.row0 + i4), i);
            int i5 = (dSubmatrixD1.original.numCols * (dSubmatrixD1.row0 + i4)) + i3 + ((dSubmatrixD1.col0 + i4) * iMin);
            int i6 = 0;
            while (i6 < i4) {
                int iMin2 = Math.min(dSubmatrixD1.col1 - (dSubmatrixD1.col0 + i6), i);
                for (int i7 = 0; i7 < dArr2.length; i7++) {
                    dArr2[i7] = 0.0d;
                }
                int i8 = i6;
                while (i8 < i4) {
                    int iMin3 = Math.min(dSubmatrixD1.col1 - (dSubmatrixD1.col0 + i8), i);
                    int i9 = iMin;
                    InnerMultiplication_DDRB.blockMultMinus(dArr3, dArr3, dArr, (dSubmatrixD1.original.numCols * (dSubmatrixD1.row0 + i4)) + i3 + ((dSubmatrixD1.col0 + i8) * iMin), (dSubmatrixD1.original.numCols * (dSubmatrixD1.row0 + i8)) + i3 + ((dSubmatrixD1.col0 + i6) * iMin3), 0, i9, iMin3, iMin2);
                    iMin = i9;
                    i8 += i;
                    i6 = i6;
                }
                int i10 = i6;
                int i11 = (dSubmatrixD1.original.numCols * (dSubmatrixD1.row0 + i4)) + i3 + ((dSubmatrixD1.col0 + i10) * iMin);
                dArr2 = dArr;
                InnerTriangularSolver_DDRB.solveL(dArr3, dArr2, iMin, iMin2, iMin, i5, 0);
                System.arraycopy(dArr2, 0, dArr3, i11, iMin2 * iMin);
                i6 = i10 + i;
            }
            InnerTriangularSolver_DDRB.invertLower(dArr3, iMin, i5);
            i4 += i;
        }
    }

    public static void solve(int i, boolean z, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, boolean z2) {
        if (z) {
            solveR(i, dSubmatrixD1, dSubmatrixD12, z2);
        } else {
            solveL(i, dSubmatrixD1, dSubmatrixD12, z2);
        }
    }

    public static void solveBlock(int i, boolean z, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, boolean z2, boolean z3) {
        int i2 = dSubmatrixD1.row1 - dSubmatrixD1.row0;
        if (i2 > i) {
            throw new IllegalArgumentException("T can be at most the size of a block");
        }
        int iMin = Math.min(i, dSubmatrixD1.original.numRows - dSubmatrixD1.row0);
        int iMin2 = Math.min(i, dSubmatrixD1.original.numCols - dSubmatrixD1.col0);
        int i3 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (dSubmatrixD1.col0 * iMin);
        double[] dArr = dSubmatrixD1.original.data;
        double[] dArr2 = dSubmatrixD12.original.data;
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
            int i4 = dSubmatrixD12.row0;
            while (i4 < dSubmatrixD12.row1) {
                int i5 = i4 + i;
                int iMin3 = Math.min(dSubmatrixD12.row1, i5) - i4;
                InnerTriangularSolver_DDRB.solveLTransB(dArr, dArr2, iMin, iMin3, iMin, i3, (i4 * dSubmatrixD12.original.numCols) + (dSubmatrixD12.col0 * iMin3));
                i4 = i5;
            }
            return;
        }
        if (i2 != dSubmatrixD12.row1 - dSubmatrixD12.row0) {
            throw new IllegalArgumentException("T and B must have the same number of rows.");
        }
        if (z) {
            if (z2) {
                int i6 = dSubmatrixD12.col0;
                while (i6 < dSubmatrixD12.col1) {
                    int i7 = i6 + i;
                    InnerTriangularSolver_DDRB.solveTransU(dArr, dArr2, i2, Math.min(dSubmatrixD12.col1, i7) - i6, i2, i3, (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (i2 * i6));
                    i6 = i7;
                }
                return;
            }
            int i8 = dSubmatrixD12.col0;
            while (i8 < dSubmatrixD12.col1) {
                int i9 = i8 + i;
                InnerTriangularSolver_DDRB.solveU(dArr, dArr2, i2, Math.min(dSubmatrixD12.col1, i9) - i8, i2, i3, (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (i2 * i8));
                i8 = i9;
            }
            return;
        }
        if (z2) {
            int i10 = dSubmatrixD12.col0;
            while (i10 < dSubmatrixD12.col1) {
                int i11 = i10 + i;
                InnerTriangularSolver_DDRB.solveTransL(dArr, dArr2, i2, Math.min(dSubmatrixD12.col1, i11) - i10, iMin2, i3, (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (i2 * i10));
                i10 = i11;
            }
            return;
        }
        int i12 = dSubmatrixD12.col0;
        while (i12 < dSubmatrixD12.col1) {
            int i13 = i12 + i;
            InnerTriangularSolver_DDRB.solveL(dArr, dArr2, i2, Math.min(dSubmatrixD12.col1, i13) - i12, iMin2, i3, (dSubmatrixD12.row0 * dSubmatrixD12.original.numCols) + (i2 * i12));
            i12 = i13;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void solveL(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, boolean z) {
        int i2;
        int i3;
        DSubmatrixD1 dSubmatrixD13 = new DSubmatrixD1(dSubmatrixD12.original);
        DSubmatrixD1 dSubmatrixD14 = new DSubmatrixD1(dSubmatrixD1.original);
        DSubmatrixD1 dSubmatrixD15 = new DSubmatrixD1(dSubmatrixD12.original);
        int i4 = dSubmatrixD12.row1 - dSubmatrixD12.row0;
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
            dSubmatrixD14.col0 = dSubmatrixD1.col0 + i5;
            dSubmatrixD14.col1 = dSubmatrixD14.col0 + iMin;
            dSubmatrixD14.row0 = dSubmatrixD1.row0 + i5;
            dSubmatrixD14.row1 = dSubmatrixD14.row0 + iMin;
            dSubmatrixD15.col0 = dSubmatrixD12.col0;
            dSubmatrixD15.col1 = dSubmatrixD12.col1;
            dSubmatrixD15.row0 = dSubmatrixD12.row0 + i5;
            dSubmatrixD15.row1 = dSubmatrixD15.row0 + iMin;
            int i6 = i;
            boolean z2 = z;
            solveBlock(i6, false, dSubmatrixD14, dSubmatrixD15, z2, false);
            if (z2) {
                if (dSubmatrixD14.row0 > 0) {
                    if (z2) {
                        dSubmatrixD14.col1 = dSubmatrixD14.col0;
                        dSubmatrixD14.col0 = dSubmatrixD14.col1 - i6;
                        dSubmatrixD14.row1 = dSubmatrixD1.row1;
                        dSubmatrixD15.row1 = dSubmatrixD12.row1;
                        dSubmatrixD13.row0 = dSubmatrixD15.row0 - i6;
                        dSubmatrixD13.row1 = dSubmatrixD15.row0;
                    } else {
                        dSubmatrixD14.row0 = dSubmatrixD14.row1;
                        dSubmatrixD14.row1 = Math.min(dSubmatrixD14.row0 + i6, dSubmatrixD1.row1);
                        dSubmatrixD14.col0 = dSubmatrixD1.col0;
                        dSubmatrixD15.row0 = dSubmatrixD12.row0;
                        dSubmatrixD13.row0 = dSubmatrixD15.row1;
                        dSubmatrixD13.row1 = Math.min(dSubmatrixD13.row0 + i6, dSubmatrixD12.row1);
                    }
                    int i7 = dSubmatrixD12.col0;
                    while (i7 < dSubmatrixD12.col1) {
                        dSubmatrixD15.col0 = i7;
                        i7 += i6;
                        dSubmatrixD15.col1 = Math.min(i7, dSubmatrixD12.col1);
                        dSubmatrixD13.col0 = dSubmatrixD15.col0;
                        dSubmatrixD13.col1 = dSubmatrixD15.col1;
                        if (z2) {
                            MatrixMult_DDRB.multMinusTransA(i6, dSubmatrixD14, dSubmatrixD15, dSubmatrixD13);
                        } else {
                            MatrixMult_DDRB.multMinus(i6, dSubmatrixD14, dSubmatrixD15, dSubmatrixD13);
                        }
                    }
                }
            } else if (dSubmatrixD14.row1 < dSubmatrixD1.row1) {
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
    public static void solveR(int i, DSubmatrixD1 dSubmatrixD1, DSubmatrixD1 dSubmatrixD12, boolean z) {
        int i2;
        int i3;
        int i4 = dSubmatrixD12.row1 - dSubmatrixD12.row0;
        if (dSubmatrixD1.getCols() != i4) {
            throw new IllegalArgumentException("Number of columns in R must be equal to the number of rows in B");
        }
        if (dSubmatrixD1.getRows() != i4) {
            throw new IllegalArgumentException("Number of rows in R must be equal to the number of rows in B");
        }
        DSubmatrixD1 dSubmatrixD13 = new DSubmatrixD1(dSubmatrixD12.original);
        DSubmatrixD1 dSubmatrixD14 = new DSubmatrixD1(dSubmatrixD1.original);
        DSubmatrixD1 dSubmatrixD15 = new DSubmatrixD1(dSubmatrixD12.original);
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
            dSubmatrixD14.col0 = dSubmatrixD1.col0 + i2;
            dSubmatrixD14.col1 = dSubmatrixD14.col0 + iMin;
            dSubmatrixD14.row0 = dSubmatrixD1.row0 + i2;
            dSubmatrixD14.row1 = dSubmatrixD14.row0 + iMin;
            dSubmatrixD15.col0 = dSubmatrixD12.col0;
            dSubmatrixD15.col1 = dSubmatrixD12.col1;
            dSubmatrixD15.row0 = dSubmatrixD12.row0 + i2;
            dSubmatrixD15.row1 = dSubmatrixD15.row0 + iMin;
            int i5 = i;
            boolean z2 = z;
            solveBlock(i5, true, dSubmatrixD14, dSubmatrixD15, z2, false);
            if (z2) {
                if (dSubmatrixD14.row1 < dSubmatrixD1.row1) {
                    if (z2) {
                        dSubmatrixD14.col0 = dSubmatrixD14.col1;
                        dSubmatrixD14.col1 = Math.min(dSubmatrixD14.col0 + i5, dSubmatrixD1.col1);
                        dSubmatrixD14.row0 = dSubmatrixD1.row0;
                        dSubmatrixD15.row0 = dSubmatrixD12.row0;
                        dSubmatrixD13.row0 = dSubmatrixD15.row1;
                        dSubmatrixD13.row1 = Math.min(dSubmatrixD13.row0 + i5, dSubmatrixD12.row1);
                    } else {
                        dSubmatrixD14.row1 = dSubmatrixD14.row0;
                        dSubmatrixD14.row0 = dSubmatrixD14.row1 - i5;
                        dSubmatrixD14.col1 = dSubmatrixD1.col1;
                        dSubmatrixD15.row1 = dSubmatrixD12.row1;
                        dSubmatrixD13.row0 = dSubmatrixD15.row0 - i5;
                        dSubmatrixD13.row1 = dSubmatrixD15.row0;
                    }
                    int i6 = dSubmatrixD12.col0;
                    while (i6 < dSubmatrixD12.col1) {
                        dSubmatrixD15.col0 = i6;
                        i6 += i5;
                        dSubmatrixD15.col1 = Math.min(i6, dSubmatrixD12.col1);
                        dSubmatrixD13.col0 = dSubmatrixD15.col0;
                        dSubmatrixD13.col1 = dSubmatrixD15.col1;
                        if (z2) {
                            MatrixMult_DDRB.multMinusTransA(i5, dSubmatrixD14, dSubmatrixD15, dSubmatrixD13);
                        } else {
                            MatrixMult_DDRB.multMinus(i5, dSubmatrixD14, dSubmatrixD15, dSubmatrixD13);
                        }
                    }
                }
            } else if (dSubmatrixD14.row0 > 0) {
            }
            i2 += i3;
            i = i5;
            z = z2;
        }
    }
}
