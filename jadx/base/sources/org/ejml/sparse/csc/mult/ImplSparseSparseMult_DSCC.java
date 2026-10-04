package org.ejml.sparse.csc.mult;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.sparse.csc.CommonOps_DSCC;
import org.ejml.sparse.csc.misc.TriangularSolver_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class ImplSparseSparseMult_DSCC {
    public static void mult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        DMatrixSparseCSC dMatrixSparseCSC4;
        DMatrixSparseCSC dMatrixSparseCSC5;
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(dGrowArray, dMatrixSparseCSC.numRows);
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(iGrowArray, dMatrixSparseCSC.numRows, dMatrixSparseCSC.numRows);
        dMatrixSparseCSC3.growMaxLength(dMatrixSparseCSC.nz_length + dMatrixSparseCSC2.nz_length, false);
        dMatrixSparseCSC3.indicesSorted = false;
        dMatrixSparseCSC3.nz_length = 0;
        int i = dMatrixSparseCSC2.col_idx[0];
        int i2 = 1;
        while (i2 <= dMatrixSparseCSC2.numCols) {
            int i3 = i2 - 1;
            int i4 = dMatrixSparseCSC2.col_idx[i2];
            dMatrixSparseCSC3.col_idx[i2] = dMatrixSparseCSC3.nz_length;
            if (i == i4) {
                dMatrixSparseCSC4 = dMatrixSparseCSC;
                dMatrixSparseCSC5 = dMatrixSparseCSC3;
            } else {
                while (i < i4) {
                    multAddColA(dMatrixSparseCSC, dMatrixSparseCSC2.nz_rows[i], dMatrixSparseCSC2.nz_values[i], dMatrixSparseCSC3, i2, dArrAdjust, iArrAdjust);
                    i++;
                }
                dMatrixSparseCSC4 = dMatrixSparseCSC;
                dMatrixSparseCSC5 = dMatrixSparseCSC3;
                int i5 = dMatrixSparseCSC5.col_idx[i2];
                for (int i6 = dMatrixSparseCSC5.col_idx[i3]; i6 < i5; i6++) {
                    dMatrixSparseCSC5.nz_values[i6] = dArrAdjust[dMatrixSparseCSC5.nz_rows[i6]];
                }
                i = i4;
            }
            i2++;
            dMatrixSparseCSC = dMatrixSparseCSC4;
            dMatrixSparseCSC3 = dMatrixSparseCSC5;
        }
    }

    public static void multTransA(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(dGrowArray, dMatrixSparseCSC.numRows);
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(iGrowArray, dMatrixSparseCSC.numRows, dMatrixSparseCSC.numRows);
        int i = 0;
        dMatrixSparseCSC3.growMaxLength(dMatrixSparseCSC.nz_length + dMatrixSparseCSC2.nz_length, false);
        dMatrixSparseCSC3.indicesSorted = true;
        dMatrixSparseCSC3.nz_length = 0;
        dMatrixSparseCSC3.col_idx[0] = 0;
        int i2 = dMatrixSparseCSC2.col_idx[0];
        int i3 = 1;
        while (i3 <= dMatrixSparseCSC2.numCols) {
            int i4 = dMatrixSparseCSC2.col_idx[i3];
            dMatrixSparseCSC3.col_idx[i3] = dMatrixSparseCSC3.nz_length;
            if (i2 != i4) {
                while (i2 < i4) {
                    int i5 = dMatrixSparseCSC2.nz_rows[i2];
                    dArrAdjust[i5] = dMatrixSparseCSC2.nz_values[i2];
                    iArrAdjust[i5] = i3;
                    i2++;
                }
                int i6 = i;
                while (i6 < dMatrixSparseCSC.numCols) {
                    int i7 = i6 + 1;
                    int i8 = dMatrixSparseCSC.col_idx[i7];
                    double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    for (int i9 = dMatrixSparseCSC.col_idx[i6]; i9 < i8; i9++) {
                        int i10 = dMatrixSparseCSC.nz_rows[i9];
                        if (iArrAdjust[i10] == i3) {
                            d += dArrAdjust[i10] * dMatrixSparseCSC.nz_values[i9];
                        }
                    }
                    if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        if (dMatrixSparseCSC3.nz_length == dMatrixSparseCSC3.nz_values.length) {
                            dMatrixSparseCSC3.growMaxLength((dMatrixSparseCSC3.nz_length * 2) + 1, true);
                        }
                        dMatrixSparseCSC3.nz_values[dMatrixSparseCSC3.nz_length] = d;
                        int[] iArr = dMatrixSparseCSC3.nz_rows;
                        int i11 = dMatrixSparseCSC3.nz_length;
                        dMatrixSparseCSC3.nz_length = i11 + 1;
                        iArr[i11] = i6;
                    }
                    i6 = i7;
                }
                dMatrixSparseCSC3.col_idx[i3] = dMatrixSparseCSC3.nz_length;
                i2 = i4;
            }
            i3++;
            i = 0;
        }
    }

    public static void multTransB(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        DMatrixSparseCSC dMatrixSparseCSC4;
        DMatrixSparseCSC dMatrixSparseCSC5;
        if (!dMatrixSparseCSC2.isIndicesSorted()) {
            throw new IllegalArgumentException("B must have its indices sorted.");
        }
        if (!CommonOps_DSCC.checkIndicesSorted(dMatrixSparseCSC2)) {
            throw new IllegalArgumentException("Crap. Not really sorted");
        }
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(dGrowArray, dMatrixSparseCSC.numRows);
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(iGrowArray, dMatrixSparseCSC.numRows + dMatrixSparseCSC2.numCols, dMatrixSparseCSC.numRows);
        dMatrixSparseCSC3.growMaxLength(dMatrixSparseCSC.nz_length + dMatrixSparseCSC2.nz_length, false);
        dMatrixSparseCSC3.indicesSorted = false;
        dMatrixSparseCSC3.nz_length = 0;
        dMatrixSparseCSC3.col_idx[0] = 0;
        int i = dMatrixSparseCSC.numRows;
        System.arraycopy(dMatrixSparseCSC2.col_idx, 0, iArrAdjust, i, dMatrixSparseCSC2.numCols);
        int i2 = 0;
        while (i2 < dMatrixSparseCSC2.numRows) {
            int i3 = i2 + 1;
            dMatrixSparseCSC3.col_idx[i3] = dMatrixSparseCSC3.nz_length;
            int i4 = 0;
            while (i4 < dMatrixSparseCSC2.numCols) {
                int i5 = i + i4;
                int i6 = iArrAdjust[i5];
                int i7 = i4 + 1;
                if (i6 >= dMatrixSparseCSC2.col_idx[i7] || dMatrixSparseCSC2.nz_rows[i6] != i2) {
                    dMatrixSparseCSC4 = dMatrixSparseCSC;
                    dMatrixSparseCSC5 = dMatrixSparseCSC3;
                } else {
                    double d = dMatrixSparseCSC2.nz_values[i6];
                    dMatrixSparseCSC4 = dMatrixSparseCSC;
                    dMatrixSparseCSC5 = dMatrixSparseCSC3;
                    multAddColA(dMatrixSparseCSC4, i4, d, dMatrixSparseCSC5, i3, dArrAdjust, iArrAdjust);
                    iArrAdjust[i5] = iArrAdjust[i5] + 1;
                }
                dMatrixSparseCSC = dMatrixSparseCSC4;
                dMatrixSparseCSC3 = dMatrixSparseCSC5;
                i4 = i7;
            }
            DMatrixSparseCSC dMatrixSparseCSC6 = dMatrixSparseCSC;
            DMatrixSparseCSC dMatrixSparseCSC7 = dMatrixSparseCSC3;
            int i8 = dMatrixSparseCSC7.col_idx[i3];
            for (int i9 = dMatrixSparseCSC7.col_idx[i2]; i9 < i8; i9++) {
                dMatrixSparseCSC7.nz_values[i9] = dArrAdjust[dMatrixSparseCSC7.nz_rows[i9]];
            }
            dMatrixSparseCSC = dMatrixSparseCSC6;
            dMatrixSparseCSC3 = dMatrixSparseCSC7;
            i2 = i3;
        }
    }

    public static void multAddColA(DMatrixSparseCSC dMatrixSparseCSC, int i, double d, DMatrixSparseCSC dMatrixSparseCSC2, int i2, double[] dArr, int[] iArr) {
        int i3 = dMatrixSparseCSC.col_idx[i + 1];
        for (int i4 = dMatrixSparseCSC.col_idx[i]; i4 < i3; i4++) {
            int i5 = dMatrixSparseCSC.nz_rows[i4];
            if (iArr[i5] < i2) {
                if (dMatrixSparseCSC2.nz_length >= dMatrixSparseCSC2.nz_rows.length) {
                    dMatrixSparseCSC2.growMaxLength((dMatrixSparseCSC2.nz_length * 2) + 1, true);
                }
                iArr[i5] = i2;
                dMatrixSparseCSC2.nz_rows[dMatrixSparseCSC2.nz_length] = i5;
                int[] iArr2 = dMatrixSparseCSC2.col_idx;
                int i6 = dMatrixSparseCSC2.nz_length + 1;
                dMatrixSparseCSC2.nz_length = i6;
                iArr2[i2] = i6;
                dArr[i5] = dMatrixSparseCSC.nz_values[i4] * d;
            } else {
                dArr[i5] = dArr[i5] + (dMatrixSparseCSC.nz_values[i4] * d);
            }
        }
    }

    public static void addRowsInAInToC(DMatrixSparseCSC dMatrixSparseCSC, int i, DMatrixSparseCSC dMatrixSparseCSC2, int i2, int[] iArr) {
        int i3 = dMatrixSparseCSC.col_idx[i + 1];
        for (int i4 = dMatrixSparseCSC.col_idx[i]; i4 < i3; i4++) {
            int i5 = dMatrixSparseCSC.nz_rows[i4];
            if (iArr[i5] < i2) {
                if (dMatrixSparseCSC2.nz_length >= dMatrixSparseCSC2.nz_rows.length) {
                    dMatrixSparseCSC2.growMaxLength((dMatrixSparseCSC2.nz_length * 2) + 1, true);
                }
                iArr[i5] = i2;
                int[] iArr2 = dMatrixSparseCSC2.nz_rows;
                int i6 = dMatrixSparseCSC2.nz_length;
                dMatrixSparseCSC2.nz_length = i6 + 1;
                iArr2[i6] = i5;
            }
        }
        dMatrixSparseCSC2.col_idx[i2 + 1] = dMatrixSparseCSC2.nz_length;
    }

    public static void mult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        DMatrixSparseCSC dMatrixSparseCSC2 = dMatrixSparseCSC;
        dMatrixRMaj2.zero();
        int i = 0;
        while (i < dMatrixSparseCSC2.numCols) {
            int i2 = dMatrixSparseCSC2.col_idx[i];
            int i3 = i + 1;
            int i4 = dMatrixSparseCSC2.col_idx[i3];
            while (i2 < i4) {
                int i5 = dMatrixSparseCSC2.nz_rows[i2];
                double d = dMatrixSparseCSC2.nz_values[i2];
                int i6 = dMatrixRMaj.numCols * i;
                int i7 = i5 * dMatrixRMaj2.numCols;
                int i8 = dMatrixRMaj.numCols + i6;
                while (i6 < i8) {
                    double[] dArr = dMatrixRMaj2.data;
                    dArr[i7] = dArr[i7] + (dMatrixRMaj.data[i6] * d);
                    i7++;
                    i6++;
                }
                i2++;
                dMatrixSparseCSC2 = dMatrixSparseCSC;
            }
            dMatrixSparseCSC2 = dMatrixSparseCSC;
            i = i3;
        }
    }

    public static double dotInnerColumns(DMatrixSparseCSC dMatrixSparseCSC, int i, DMatrixSparseCSC dMatrixSparseCSC2, int i2, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows) {
            throw new IllegalArgumentException("Number of rows must match.");
        }
        int[] iArrAdjust = TriangularSolver_DSCC.adjust(iGrowArray, dMatrixSparseCSC.numRows);
        int i3 = 0;
        Arrays.fill(iArrAdjust, 0, dMatrixSparseCSC.numRows, -1);
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(dGrowArray, dMatrixSparseCSC.numRows);
        int i4 = dMatrixSparseCSC.col_idx[i];
        int i5 = dMatrixSparseCSC.col_idx[i + 1];
        while (i4 < i5) {
            int i6 = dMatrixSparseCSC.nz_rows[i4];
            dArrAdjust[i3] = dMatrixSparseCSC.nz_values[i4];
            iArrAdjust[i6] = i3;
            i4++;
            i3++;
        }
        int i7 = dMatrixSparseCSC2.col_idx[i2 + 1];
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i8 = dMatrixSparseCSC2.col_idx[i2]; i8 < i7; i8++) {
            int i9 = iArrAdjust[dMatrixSparseCSC2.nz_rows[i8]];
            if (i9 != -1) {
                d += dArrAdjust[i9] * dMatrixSparseCSC2.nz_values[i8];
            }
        }
        return d;
    }
}
