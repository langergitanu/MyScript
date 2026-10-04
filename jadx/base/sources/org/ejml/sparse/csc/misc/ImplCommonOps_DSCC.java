package org.ejml.sparse.csc.misc;

import java.util.Arrays;
import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.sparse.csc.mult.ImplSparseSparseMult_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class ImplCommonOps_DSCC {
    public static void transpose(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, IGrowArray iGrowArray) {
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(iGrowArray, dMatrixSparseCSC.numRows, dMatrixSparseCSC.numRows);
        dMatrixSparseCSC2.reshape(dMatrixSparseCSC.numCols, dMatrixSparseCSC.numRows, dMatrixSparseCSC.nz_length);
        int i = dMatrixSparseCSC.col_idx[0];
        int i2 = 1;
        int i3 = 1;
        while (i3 <= dMatrixSparseCSC.numCols) {
            int i4 = dMatrixSparseCSC.col_idx[i3];
            while (i < i4) {
                if (dMatrixSparseCSC.nz_rows.length <= i) {
                    throw new RuntimeException("Egads");
                }
                int i5 = dMatrixSparseCSC.nz_rows[i];
                iArrAdjust[i5] = iArrAdjust[i5] + 1;
                i++;
            }
            i3++;
            i = i4;
        }
        dMatrixSparseCSC2.colsum(iArrAdjust);
        int i6 = dMatrixSparseCSC.col_idx[0];
        while (i2 <= dMatrixSparseCSC.numCols) {
            int i7 = i2 - 1;
            int i8 = dMatrixSparseCSC.col_idx[i2];
            while (i6 < i8) {
                int i9 = dMatrixSparseCSC.nz_rows[i6];
                int i10 = iArrAdjust[i9];
                iArrAdjust[i9] = i10 + 1;
                dMatrixSparseCSC2.nz_rows[i10] = i7;
                dMatrixSparseCSC2.nz_values[i10] = dMatrixSparseCSC.nz_values[i6];
                i6++;
            }
            i2++;
            i6 = i8;
        }
    }

    public static void add(double d, DMatrixSparseCSC dMatrixSparseCSC, double d2, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(dGrowArray, dMatrixSparseCSC.numRows);
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(iGrowArray, dMatrixSparseCSC.numRows, dMatrixSparseCSC.numRows);
        dMatrixSparseCSC3.indicesSorted = false;
        dMatrixSparseCSC3.nz_length = 0;
        int i = 0;
        while (i < dMatrixSparseCSC.numCols) {
            dMatrixSparseCSC3.col_idx[i] = dMatrixSparseCSC3.nz_length;
            int i2 = i + 1;
            ImplSparseSparseMult_DSCC.multAddColA(dMatrixSparseCSC, i, d, dMatrixSparseCSC3, i2, dArrAdjust, iArrAdjust);
            ImplSparseSparseMult_DSCC.multAddColA(dMatrixSparseCSC2, i, d2, dMatrixSparseCSC3, i2, dArrAdjust, iArrAdjust);
            int i3 = dMatrixSparseCSC3.col_idx[i2];
            for (int i4 = dMatrixSparseCSC3.col_idx[i]; i4 < i3; i4++) {
                dMatrixSparseCSC3.nz_values[i4] = dArrAdjust[dMatrixSparseCSC3.nz_rows[i4]];
            }
            i = i2;
        }
    }

    public static void addColAppend(double d, DMatrixSparseCSC dMatrixSparseCSC, int i, double d2, DMatrixSparseCSC dMatrixSparseCSC2, int i2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows || dMatrixSparseCSC.numRows != dMatrixSparseCSC3.numRows) {
            throw new IllegalArgumentException("Number of rows in A, B, and C do not match");
        }
        int i3 = dMatrixSparseCSC.col_idx[i];
        int i4 = dMatrixSparseCSC.col_idx[i + 1];
        int i5 = dMatrixSparseCSC2.col_idx[i2];
        int i6 = dMatrixSparseCSC2.col_idx[i2 + 1];
        int i7 = dMatrixSparseCSC3.numCols + 1;
        dMatrixSparseCSC3.numCols = i7;
        dMatrixSparseCSC3.growMaxColumns(i7, true);
        dMatrixSparseCSC3.growMaxLength((((dMatrixSparseCSC3.nz_length + i4) - i3) + i6) - i5, true);
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(iGrowArray, dMatrixSparseCSC.numRows);
        Arrays.fill(iArrAdjust, 0, dMatrixSparseCSC.numRows, -1);
        while (i3 < i4) {
            int i8 = dMatrixSparseCSC.nz_rows[i3];
            dMatrixSparseCSC3.nz_rows[dMatrixSparseCSC3.nz_length] = i8;
            dMatrixSparseCSC3.nz_values[dMatrixSparseCSC3.nz_length] = dMatrixSparseCSC.nz_values[i3] * d;
            int i9 = dMatrixSparseCSC3.nz_length;
            dMatrixSparseCSC3.nz_length = i9 + 1;
            iArrAdjust[i8] = i9;
            i3++;
        }
        while (i5 < i6) {
            int i10 = dMatrixSparseCSC2.nz_rows[i5];
            if (iArrAdjust[i10] != -1) {
                double[] dArr = dMatrixSparseCSC3.nz_values;
                int i11 = iArrAdjust[i10];
                dArr[i11] = dArr[i11] + (dMatrixSparseCSC2.nz_values[i5] * d2);
            } else {
                dMatrixSparseCSC3.nz_values[dMatrixSparseCSC3.nz_length] = dMatrixSparseCSC2.nz_values[i5] * d2;
                int[] iArr = dMatrixSparseCSC3.nz_rows;
                int i12 = dMatrixSparseCSC3.nz_length;
                dMatrixSparseCSC3.nz_length = i12 + 1;
                iArr[i12] = i10;
            }
            i5++;
        }
        dMatrixSparseCSC3.col_idx[dMatrixSparseCSC3.numCols] = dMatrixSparseCSC3.nz_length;
    }

    public static void elementMult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(dGrowArray, dMatrixSparseCSC.numRows);
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(iGrowArray, dMatrixSparseCSC.numRows);
        int i = 0;
        Arrays.fill(iArrAdjust, 0, dMatrixSparseCSC.numRows, -1);
        dMatrixSparseCSC3.indicesSorted = false;
        dMatrixSparseCSC3.nz_length = 0;
        while (i < dMatrixSparseCSC.numCols) {
            int i2 = dMatrixSparseCSC.col_idx[i];
            int i3 = i + 1;
            int i4 = dMatrixSparseCSC.col_idx[i3];
            int i5 = dMatrixSparseCSC2.col_idx[i];
            int i6 = dMatrixSparseCSC2.col_idx[i3];
            int iMin = Math.min(i4 - i2, i6 - i5);
            if (dMatrixSparseCSC3.nz_length + iMin > dMatrixSparseCSC3.nz_values.length) {
                dMatrixSparseCSC3.growMaxLength(dMatrixSparseCSC3.nz_values.length + iMin, true);
            }
            dMatrixSparseCSC3.col_idx[i] = dMatrixSparseCSC3.nz_length;
            while (i2 < i4) {
                int i7 = dMatrixSparseCSC.nz_rows[i2];
                iArrAdjust[i7] = i;
                dArrAdjust[i7] = dMatrixSparseCSC.nz_values[i2];
                i2++;
            }
            while (i5 < i6) {
                int i8 = dMatrixSparseCSC2.nz_rows[i5];
                if (iArrAdjust[i8] == i) {
                    dMatrixSparseCSC3.nz_values[dMatrixSparseCSC3.nz_length] = dArrAdjust[i8] * dMatrixSparseCSC2.nz_values[i5];
                    int[] iArr = dMatrixSparseCSC3.nz_rows;
                    int i9 = dMatrixSparseCSC3.nz_length;
                    dMatrixSparseCSC3.nz_length = i9 + 1;
                    iArr[i9] = i8;
                }
                i5++;
            }
            i = i3;
        }
        dMatrixSparseCSC3.col_idx[dMatrixSparseCSC3.numCols] = dMatrixSparseCSC3.nz_length;
    }

    public static void removeZeros(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, double d) {
        dMatrixSparseCSC2.reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length);
        int i = 0;
        dMatrixSparseCSC2.nz_length = 0;
        while (i < dMatrixSparseCSC.numCols) {
            dMatrixSparseCSC2.col_idx[i] = dMatrixSparseCSC2.nz_length;
            i++;
            int i2 = dMatrixSparseCSC.col_idx[i];
            for (int i3 = dMatrixSparseCSC.col_idx[i]; i3 < i2; i3++) {
                double d2 = dMatrixSparseCSC.nz_values[i3];
                if (Math.abs(d2) > d) {
                    dMatrixSparseCSC2.nz_rows[dMatrixSparseCSC2.nz_length] = dMatrixSparseCSC.nz_rows[i3];
                    double[] dArr = dMatrixSparseCSC2.nz_values;
                    int i4 = dMatrixSparseCSC2.nz_length;
                    dMatrixSparseCSC2.nz_length = i4 + 1;
                    dArr[i4] = d2;
                }
            }
        }
        dMatrixSparseCSC2.col_idx[dMatrixSparseCSC2.numCols] = dMatrixSparseCSC2.nz_length;
    }

    public static void removeZeros(DMatrixSparseCSC dMatrixSparseCSC, double d) {
        int i = 0;
        int i2 = 0;
        while (i < dMatrixSparseCSC.numCols) {
            i++;
            int i3 = dMatrixSparseCSC.col_idx[i];
            for (int i4 = dMatrixSparseCSC.col_idx[i] + i2; i4 < i3; i4++) {
                double d2 = dMatrixSparseCSC.nz_values[i4];
                if (Math.abs(d2) > d) {
                    int i5 = i4 - i2;
                    dMatrixSparseCSC.nz_rows[i5] = dMatrixSparseCSC.nz_rows[i4];
                    dMatrixSparseCSC.nz_values[i5] = d2;
                } else {
                    i2++;
                }
            }
            int[] iArr = dMatrixSparseCSC.col_idx;
            iArr[i] = iArr[i] - i2;
        }
        dMatrixSparseCSC.nz_length -= i2;
    }
}
