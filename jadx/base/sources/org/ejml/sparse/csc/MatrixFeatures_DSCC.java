package org.ejml.sparse.csc;

import org.ejml.UtilEjml;
import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.sparse.csc.decomposition.chol.CholeskyUpLooking_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_DSCC {
    public static boolean isEquals(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        if (!dMatrixSparseCSC.indicesSorted || !dMatrixSparseCSC2.indicesSorted) {
            throw new IllegalArgumentException("Inputs must have sorted indices");
        }
        if (!isSameStructure(dMatrixSparseCSC, dMatrixSparseCSC2)) {
            return false;
        }
        for (int i = 0; i < dMatrixSparseCSC.nz_length; i++) {
            if (dMatrixSparseCSC.nz_values[i] != dMatrixSparseCSC2.nz_values[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEquals(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, double d) {
        if (!dMatrixSparseCSC.indicesSorted || !dMatrixSparseCSC2.indicesSorted) {
            throw new IllegalArgumentException("Inputs must have sorted indices");
        }
        if (!isSameStructure(dMatrixSparseCSC, dMatrixSparseCSC2)) {
            return false;
        }
        for (int i = 0; i < dMatrixSparseCSC.nz_length; i++) {
            if (Math.abs(dMatrixSparseCSC.nz_values[i] - dMatrixSparseCSC2.nz_values[i]) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqualsSort(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, double d) {
        if (!dMatrixSparseCSC.indicesSorted) {
            dMatrixSparseCSC.sortIndices(null);
        }
        if (!dMatrixSparseCSC2.indicesSorted) {
            dMatrixSparseCSC2.sortIndices(null);
        }
        if (!isSameStructure(dMatrixSparseCSC, dMatrixSparseCSC2)) {
            return false;
        }
        for (int i = 0; i < dMatrixSparseCSC.nz_length; i++) {
            if (Math.abs(dMatrixSparseCSC.nz_values[i] - dMatrixSparseCSC2.nz_values[i]) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSameStructure(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows || dMatrixSparseCSC.numCols != dMatrixSparseCSC2.numCols || dMatrixSparseCSC.nz_length != dMatrixSparseCSC2.nz_length) {
            return false;
        }
        for (int i = 0; i <= dMatrixSparseCSC.numCols; i++) {
            if (dMatrixSparseCSC.col_idx[i] != dMatrixSparseCSC2.col_idx[i]) {
                return false;
            }
        }
        for (int i2 = 0; i2 < dMatrixSparseCSC.nz_length; i2++) {
            if (dMatrixSparseCSC.nz_rows[i2] != dMatrixSparseCSC2.nz_rows[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasUncountable(DMatrixSparseCSC dMatrixSparseCSC) {
        for (int i = 0; i < dMatrixSparseCSC.nz_length; i++) {
            if (UtilEjml.isUncountable(dMatrixSparseCSC.nz_values[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isZeros(DMatrixSparseCSC dMatrixSparseCSC, double d) {
        for (int i = 0; i < dMatrixSparseCSC.nz_length; i++) {
            if (Math.abs(dMatrixSparseCSC.nz_values[i]) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIdentity(DMatrixSparseCSC dMatrixSparseCSC, double d) {
        if (dMatrixSparseCSC.numCols != dMatrixSparseCSC.numRows || dMatrixSparseCSC.nz_length != dMatrixSparseCSC.numCols) {
            return false;
        }
        for (int i = 1; i <= dMatrixSparseCSC.numCols; i++) {
            if (dMatrixSparseCSC.col_idx[i] != i || Math.abs(dMatrixSparseCSC.nz_values[i - 1] - 1.0d) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLowerTriangle(DMatrixSparseCSC dMatrixSparseCSC, int i, double d) {
        if (dMatrixSparseCSC.numCols != dMatrixSparseCSC.numRows || dMatrixSparseCSC.nz_length < dMatrixSparseCSC.numCols - i) {
            return false;
        }
        int i2 = 0;
        while (i2 < dMatrixSparseCSC.numCols) {
            int i3 = dMatrixSparseCSC.col_idx[i2];
            int i4 = i2 + 1;
            int i5 = dMatrixSparseCSC.col_idx[i4];
            if (i2 >= i && (i3 == i5 || dMatrixSparseCSC.nz_rows[i3] != Math.max(0, i2 - i))) {
                return false;
            }
            if (i2 - i >= 0 && Math.abs(dMatrixSparseCSC.nz_values[i3]) <= d) {
                return false;
            }
            i2 = i4;
        }
        return true;
    }

    public static boolean isTranspose(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, double d) {
        if (dMatrixSparseCSC.numCols != dMatrixSparseCSC2.numRows || dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numCols || dMatrixSparseCSC.nz_length != dMatrixSparseCSC2.nz_length) {
            return false;
        }
        if (!dMatrixSparseCSC.indicesSorted) {
            throw new IllegalArgumentException("A must have sorted indicies");
        }
        DMatrixSparseCSC dMatrixSparseCSC3 = new DMatrixSparseCSC(dMatrixSparseCSC2.numCols, dMatrixSparseCSC2.numRows, dMatrixSparseCSC2.nz_length);
        CommonOps_DSCC.transpose(dMatrixSparseCSC2, dMatrixSparseCSC3, null);
        dMatrixSparseCSC3.sortIndices(null);
        for (int i = 0; i < dMatrixSparseCSC2.nz_length; i++) {
            if (dMatrixSparseCSC.nz_rows[i] != dMatrixSparseCSC3.nz_rows[i] || Math.abs(dMatrixSparseCSC.nz_values[i] - dMatrixSparseCSC3.nz_values[i]) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean isVector(DMatrixSparseCSC dMatrixSparseCSC) {
        return (dMatrixSparseCSC.numCols == 1 && dMatrixSparseCSC.numRows > 1) || (dMatrixSparseCSC.numRows == 1 && dMatrixSparseCSC.numCols > 1);
    }

    public static boolean isSymmetric(DMatrixSparseCSC dMatrixSparseCSC, double d) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC.numCols) {
            return false;
        }
        int i = dMatrixSparseCSC.numCols;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            int i4 = dMatrixSparseCSC.col_idx[i3];
            for (int i5 = dMatrixSparseCSC.col_idx[i2]; i5 < i4; i5++) {
                if (Math.abs(dMatrixSparseCSC.get(i2, dMatrixSparseCSC.nz_rows[i5]) - dMatrixSparseCSC.nz_values[i5]) > d) {
                    return false;
                }
            }
            i2 = i3;
        }
        return true;
    }

    public static boolean isPositiveDefinite(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC.numCols) {
            return false;
        }
        return new CholeskyUpLooking_DSCC().decompose(dMatrixSparseCSC);
    }

    public static boolean isOrthogonal(DMatrixSparseCSC dMatrixSparseCSC, double d) {
        if (dMatrixSparseCSC.numRows < dMatrixSparseCSC.numCols) {
            throw new IllegalArgumentException("The number of rows must be more than or equal to the number of columns");
        }
        IGrowArray iGrowArray = new IGrowArray();
        DGrowArray dGrowArray = new DGrowArray();
        int i = 0;
        while (i < dMatrixSparseCSC.numRows) {
            int i2 = i + 1;
            int i3 = i2;
            while (i3 < dMatrixSparseCSC.numCols) {
                DMatrixSparseCSC dMatrixSparseCSC2 = dMatrixSparseCSC;
                if (Math.abs(CommonOps_DSCC.dotInnerColumns(dMatrixSparseCSC2, i, dMatrixSparseCSC, i3, iGrowArray, dGrowArray)) > d) {
                    return false;
                }
                i3++;
                dMatrixSparseCSC = dMatrixSparseCSC2;
            }
            i = i2;
        }
        return true;
    }
}
