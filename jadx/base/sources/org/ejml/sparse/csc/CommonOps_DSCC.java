package org.ejml.sparse.csc;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.data.IGrowArray;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.interfaces.decomposition.LUSparseDecomposition_F64;
import org.ejml.interfaces.linsol.LinearSolverSparse;
import org.ejml.sparse.FillReducing;
import org.ejml.sparse.csc.factory.DecompositionFactory_DSCC;
import org.ejml.sparse.csc.factory.LinearSolverFactory_DSCC;
import org.ejml.sparse.csc.misc.ImplCommonOps_DSCC;
import org.ejml.sparse.csc.misc.TriangularSolver_DSCC;
import org.ejml.sparse.csc.mult.ImplSparseSparseMult_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_DSCC {
    public static boolean checkIndicesSorted(DMatrixSparseCSC dMatrixSparseCSC) {
        int i;
        int i2 = 0;
        while (i2 < dMatrixSparseCSC.numCols) {
            int i3 = dMatrixSparseCSC.col_idx[i2];
            i2++;
            int i4 = dMatrixSparseCSC.col_idx[i2];
            if (i3 != i4 && dMatrixSparseCSC.nz_rows[i3] >= dMatrixSparseCSC.numRows) {
                return false;
            }
            do {
                i3++;
                if (i3 < i4) {
                    i = dMatrixSparseCSC.nz_rows[i3];
                    if (dMatrixSparseCSC.nz_rows[i3 - 1] >= i) {
                        return false;
                    }
                }
            } while (i < dMatrixSparseCSC.numRows);
            return false;
        }
        return true;
    }

    public static boolean checkStructure(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC.col_idx.length < dMatrixSparseCSC.numCols + 1 || dMatrixSparseCSC.col_idx[dMatrixSparseCSC.numCols] != dMatrixSparseCSC.nz_length || dMatrixSparseCSC.nz_rows.length < dMatrixSparseCSC.nz_length || dMatrixSparseCSC.nz_values.length < dMatrixSparseCSC.nz_length || dMatrixSparseCSC.col_idx[0] != 0) {
            return false;
        }
        int i = 0;
        while (i < dMatrixSparseCSC.numCols) {
            int i2 = i + 1;
            if (dMatrixSparseCSC.col_idx[i] > dMatrixSparseCSC.col_idx[i2] || dMatrixSparseCSC.col_idx[i2] - dMatrixSparseCSC.col_idx[i] > dMatrixSparseCSC.numRows) {
                return false;
            }
            i = i2;
        }
        return checkSortedFlag(dMatrixSparseCSC) && !checkDuplicateElements(dMatrixSparseCSC);
    }

    public static boolean checkSortedFlag(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC.indicesSorted) {
            return checkIndicesSorted(dMatrixSparseCSC);
        }
        return true;
    }

    public static boolean checkDuplicateElements(DMatrixSparseCSC dMatrixSparseCSC) {
        dMatrixSparseCSC.copy().sortIndices(null);
        return !checkSortedFlag(r1);
    }

    public static void transpose(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, IGrowArray iGrowArray) {
        if (dMatrixSparseCSC2.numRows != dMatrixSparseCSC.numCols || dMatrixSparseCSC2.numCols != dMatrixSparseCSC.numRows) {
            throw new IllegalArgumentException("Unexpected shape for transpose matrix");
        }
        dMatrixSparseCSC2.growMaxLength(dMatrixSparseCSC.nz_length, false);
        dMatrixSparseCSC2.nz_length = dMatrixSparseCSC.nz_length;
        ImplCommonOps_DSCC.transpose(dMatrixSparseCSC, dMatrixSparseCSC2, iGrowArray);
    }

    public static void mult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        mult(dMatrixSparseCSC, dMatrixSparseCSC2, dMatrixSparseCSC3, null, null);
    }

    public static void mult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC3.numRows || dMatrixSparseCSC2.numCols != dMatrixSparseCSC3.numCols) {
            throw new IllegalArgumentException("Inconsistent matrix shapes");
        }
        ImplSparseSparseMult_DSCC.mult(dMatrixSparseCSC, dMatrixSparseCSC2, dMatrixSparseCSC3, iGrowArray, dGrowArray);
    }

    public static void multTransA(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        if (dMatrixSparseCSC.numCols != dMatrixSparseCSC3.numRows || dMatrixSparseCSC2.numCols != dMatrixSparseCSC3.numCols) {
            throw new IllegalArgumentException("Inconsistent matrix shapes");
        }
        ImplSparseSparseMult_DSCC.multTransA(dMatrixSparseCSC, dMatrixSparseCSC2, dMatrixSparseCSC3, iGrowArray, dGrowArray);
    }

    public static void multTransB(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC3.numRows || dMatrixSparseCSC2.numRows != dMatrixSparseCSC3.numCols) {
            throw new IllegalArgumentException("Inconsistent matrix shapes");
        }
        if (!dMatrixSparseCSC2.isIndicesSorted()) {
            dMatrixSparseCSC2.sortIndices(null);
        }
        ImplSparseSparseMult_DSCC.multTransB(dMatrixSparseCSC, dMatrixSparseCSC2, dMatrixSparseCSC3, iGrowArray, dGrowArray);
    }

    public static void mult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixSparseCSC.numRows != dMatrixRMaj2.numRows || dMatrixRMaj.numCols != dMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Inconsistent matrix shapes");
        }
        ImplSparseSparseMult_DSCC.mult(dMatrixSparseCSC, dMatrixRMaj, dMatrixRMaj2);
    }

    public static void add(double d, DMatrixSparseCSC dMatrixSparseCSC, double d2, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows || dMatrixSparseCSC.numCols != dMatrixSparseCSC2.numCols || dMatrixSparseCSC.numRows != dMatrixSparseCSC3.numRows || dMatrixSparseCSC.numCols != dMatrixSparseCSC3.numCols) {
            throw new IllegalArgumentException("Inconsistent matrix shapes");
        }
        ImplCommonOps_DSCC.add(d, dMatrixSparseCSC, d2, dMatrixSparseCSC2, dMatrixSparseCSC3, iGrowArray, dGrowArray);
    }

    public static DMatrixSparseCSC identity(int i) {
        return identity(i, i);
    }

    public static DMatrixSparseCSC identity(int i, int i2) {
        DMatrixSparseCSC dMatrixSparseCSC = new DMatrixSparseCSC(i, i2, Math.min(i, i2));
        setToIdentity(dMatrixSparseCSC);
        return dMatrixSparseCSC;
    }

    public static void setToIdentity(DMatrixSparseCSC dMatrixSparseCSC) {
        int iMin = Math.min(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols);
        dMatrixSparseCSC.growMaxLength(iMin, false);
        dMatrixSparseCSC.nz_length = iMin;
        Arrays.fill(dMatrixSparseCSC.nz_values, 0, iMin, 1.0d);
        for (int i = 1; i <= iMin; i++) {
            dMatrixSparseCSC.col_idx[i] = i;
            int i2 = i - 1;
            dMatrixSparseCSC.nz_rows[i2] = i2;
        }
        for (int i3 = iMin + 1; i3 <= dMatrixSparseCSC.numCols; i3++) {
            dMatrixSparseCSC.col_idx[i3] = iMin;
        }
    }

    public static void scale(double d, DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        int i = 0;
        if (dMatrixSparseCSC != dMatrixSparseCSC2) {
            if (dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows || dMatrixSparseCSC.numCols != dMatrixSparseCSC2.numCols) {
                throw new IllegalArgumentException("A and B must have the same shape");
            }
            dMatrixSparseCSC2.copyStructure(dMatrixSparseCSC);
            while (i < dMatrixSparseCSC.nz_length) {
                dMatrixSparseCSC2.nz_values[i] = dMatrixSparseCSC.nz_values[i] * d;
                i++;
            }
            return;
        }
        while (i < dMatrixSparseCSC.nz_length) {
            double[] dArr = dMatrixSparseCSC2.nz_values;
            dArr[i] = dArr[i] * d;
            i++;
        }
    }

    public static void divide(DMatrixSparseCSC dMatrixSparseCSC, double d, DMatrixSparseCSC dMatrixSparseCSC2) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows || dMatrixSparseCSC.numCols != dMatrixSparseCSC2.numCols) {
            throw new IllegalArgumentException("Unexpected shape for transpose matrix");
        }
        int i = 0;
        if (dMatrixSparseCSC != dMatrixSparseCSC2) {
            dMatrixSparseCSC2.copyStructure(dMatrixSparseCSC);
            while (i < dMatrixSparseCSC.nz_length) {
                dMatrixSparseCSC2.nz_values[i] = dMatrixSparseCSC.nz_values[i] / d;
                i++;
            }
            return;
        }
        while (i < dMatrixSparseCSC.nz_length) {
            double[] dArr = dMatrixSparseCSC.nz_values;
            dArr[i] = dArr[i] / d;
            i++;
        }
    }

    public static void changeSign(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows || dMatrixSparseCSC.numCols != dMatrixSparseCSC2.numCols) {
            throw new IllegalArgumentException("Unexpected shape for transpose matrix");
        }
        if (dMatrixSparseCSC != dMatrixSparseCSC2) {
            dMatrixSparseCSC2.copyStructure(dMatrixSparseCSC);
        }
        for (int i = 0; i < dMatrixSparseCSC.nz_length; i++) {
            dMatrixSparseCSC2.nz_values[i] = -dMatrixSparseCSC.nz_values[i];
        }
    }

    public static double elementMinAbs(DMatrixSparseCSC dMatrixSparseCSC) {
        int i = dMatrixSparseCSC.nz_length;
        double dAbs = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (i == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (dMatrixSparseCSC.isFull()) {
            dAbs = Math.abs(dMatrixSparseCSC.nz_values[0]);
        }
        for (int i2 = 0; i2 < dMatrixSparseCSC.nz_length; i2++) {
            double dAbs2 = Math.abs(dMatrixSparseCSC.nz_values[i2]);
            if (dAbs2 < dAbs) {
                dAbs = dAbs2;
            }
        }
        return dAbs;
    }

    public static double elementMaxAbs(DMatrixSparseCSC dMatrixSparseCSC) {
        int i = dMatrixSparseCSC.nz_length;
        double dAbs = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (i == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (dMatrixSparseCSC.isFull()) {
            dAbs = Math.abs(dMatrixSparseCSC.nz_values[0]);
        }
        for (int i2 = 0; i2 < dMatrixSparseCSC.nz_length; i2++) {
            double dAbs2 = Math.abs(dMatrixSparseCSC.nz_values[i2]);
            if (dAbs2 > dAbs) {
                dAbs = dAbs2;
            }
        }
        return dAbs;
    }

    public static double elementMin(DMatrixSparseCSC dMatrixSparseCSC) {
        int i = dMatrixSparseCSC.nz_length;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (i == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (dMatrixSparseCSC.isFull()) {
            d = dMatrixSparseCSC.nz_values[0];
        }
        for (int i2 = 0; i2 < dMatrixSparseCSC.nz_length; i2++) {
            double d2 = dMatrixSparseCSC.nz_values[i2];
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static double elementMax(DMatrixSparseCSC dMatrixSparseCSC) {
        int i = dMatrixSparseCSC.nz_length;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (i == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (dMatrixSparseCSC.isFull()) {
            d = dMatrixSparseCSC.nz_values[0];
        }
        for (int i2 = 0; i2 < dMatrixSparseCSC.nz_length; i2++) {
            double d2 = dMatrixSparseCSC.nz_values[i2];
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static double elementSum(DMatrixSparseCSC dMatrixSparseCSC) {
        int i = dMatrixSparseCSC.nz_length;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (i == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        for (int i2 = 0; i2 < dMatrixSparseCSC.nz_length; i2++) {
            d += dMatrixSparseCSC.nz_values[i2];
        }
        return d;
    }

    public static void elementMult(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        if (dMatrixSparseCSC.numCols != dMatrixSparseCSC2.numCols || dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows || dMatrixSparseCSC.numCols != dMatrixSparseCSC3.numCols || dMatrixSparseCSC.numRows != dMatrixSparseCSC3.numRows) {
            throw new IllegalArgumentException("All inputs must have the same number of rows and columns");
        }
        ImplCommonOps_DSCC.elementMult(dMatrixSparseCSC, dMatrixSparseCSC2, dMatrixSparseCSC3, iGrowArray, dGrowArray);
    }

    public static DMatrixSparseCSC diag(double... dArr) {
        int length = dArr.length;
        DMatrixSparseCSC dMatrixSparseCSC = new DMatrixSparseCSC(length, length, length);
        dMatrixSparseCSC.nz_length = length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            dMatrixSparseCSC.col_idx[i2] = i2;
            dMatrixSparseCSC.nz_rows[i] = i;
            dMatrixSparseCSC.nz_values[i] = dArr[i];
            i = i2;
        }
        return dMatrixSparseCSC;
    }

    public static DMatrixSparseCSC permutationMatrix(int[] iArr, boolean z, int i, DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC == null) {
            dMatrixSparseCSC = new DMatrixSparseCSC(i, i, i);
        } else {
            dMatrixSparseCSC.reshape(i, i, i);
        }
        dMatrixSparseCSC.indicesSorted = true;
        dMatrixSparseCSC.nz_length = i;
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                int i3 = i2 + 1;
                dMatrixSparseCSC.col_idx[i3] = i3;
                dMatrixSparseCSC.nz_rows[i2] = iArr[i2];
                dMatrixSparseCSC.nz_values[i2] = 1.0d;
                i2 = i3;
            }
        } else {
            while (i2 < i) {
                int i4 = i2 + 1;
                dMatrixSparseCSC.col_idx[i4] = i4;
                dMatrixSparseCSC.nz_rows[iArr[i2]] = i2;
                dMatrixSparseCSC.nz_values[i2] = 1.0d;
                i2 = i4;
            }
        }
        return dMatrixSparseCSC;
    }

    public static void permutationVector(DMatrixSparseCSC dMatrixSparseCSC, int[] iArr) {
        if (dMatrixSparseCSC.numCols != dMatrixSparseCSC.numRows) {
            throw new IllegalArgumentException("Expected a square matrix");
        }
        if (dMatrixSparseCSC.nz_length != dMatrixSparseCSC.numCols) {
            throw new IllegalArgumentException("Expected N non-zero elements in permutation matrix");
        }
        if (iArr.length < dMatrixSparseCSC.numCols) {
            throw new IllegalArgumentException("vector is too short");
        }
        int i = dMatrixSparseCSC.numCols;
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            if (dMatrixSparseCSC.col_idx[i3] != i3) {
                throw new IllegalArgumentException("Unexpected number of elements in a column");
            }
            iArr[dMatrixSparseCSC.nz_rows[i2]] = i2;
            i2 = i3;
        }
    }

    public static void permutationInverse(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            iArr2[iArr[i2]] = i2;
        }
    }

    public static int[] permutationInverse(int[] iArr, int i) {
        int[] iArr2 = new int[i];
        permutationInverse(iArr, iArr2, i);
        return iArr2;
    }

    public static void permuteRowInv(int[] iArr, DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2) {
        if (dMatrixSparseCSC.numRows > iArr.length) {
            throw new IllegalArgumentException("permutation vector must have at least as many elements as input has rows");
        }
        dMatrixSparseCSC2.reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length);
        dMatrixSparseCSC2.nz_length = dMatrixSparseCSC.nz_length;
        int i = 0;
        dMatrixSparseCSC2.indicesSorted = false;
        System.arraycopy(dMatrixSparseCSC.nz_values, 0, dMatrixSparseCSC2.nz_values, 0, dMatrixSparseCSC.nz_length);
        System.arraycopy(dMatrixSparseCSC.col_idx, 0, dMatrixSparseCSC2.col_idx, 0, dMatrixSparseCSC.numCols + 1);
        int i2 = 0;
        while (i < dMatrixSparseCSC.numCols) {
            i++;
            int i3 = dMatrixSparseCSC2.col_idx[i];
            while (i2 < i3) {
                dMatrixSparseCSC2.nz_rows[i2] = iArr[dMatrixSparseCSC.nz_rows[i2]];
                i2++;
            }
            i2 = i3;
        }
    }

    public static void permute(int[] iArr, DMatrixSparseCSC dMatrixSparseCSC, int[] iArr2, DMatrixSparseCSC dMatrixSparseCSC2) {
        if (iArr != null && dMatrixSparseCSC.numRows > iArr.length) {
            throw new IllegalArgumentException("rowInv permutation vector must have at least as many elements as input has columns");
        }
        if (iArr2 != null && dMatrixSparseCSC.numCols > iArr2.length) {
            throw new IllegalArgumentException("permCol permutation vector must have at least as many elements as input has rows");
        }
        dMatrixSparseCSC2.reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length);
        dMatrixSparseCSC2.indicesSorted = false;
        dMatrixSparseCSC2.nz_length = dMatrixSparseCSC.nz_length;
        int i = dMatrixSparseCSC.numCols;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = iArr2 != null ? iArr2[i2] : i2;
            int i5 = dMatrixSparseCSC.col_idx[i4];
            int i6 = dMatrixSparseCSC.col_idx[i4 + 1] - i5;
            int i7 = i2 + 1;
            dMatrixSparseCSC2.col_idx[i7] = dMatrixSparseCSC2.col_idx[i2] + i6;
            int i8 = 0;
            while (i8 < i6) {
                int i9 = dMatrixSparseCSC.nz_rows[i5];
                int[] iArr3 = dMatrixSparseCSC2.nz_rows;
                if (iArr != null) {
                    i9 = iArr[i9];
                }
                iArr3[i3] = i9;
                dMatrixSparseCSC2.nz_values[i3] = dMatrixSparseCSC.nz_values[i5];
                i8++;
                i3++;
                i5++;
            }
            i2 = i7;
        }
    }

    public static void permute(int[] iArr, double[] dArr, double[] dArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            dArr2[i2] = dArr[iArr[i2]];
        }
    }

    public static void permuteInv(int[] iArr, double[] dArr, double[] dArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            dArr2[iArr[i2]] = dArr[i2];
        }
    }

    public static void permuteSymmetric(DMatrixSparseCSC dMatrixSparseCSC, int[] iArr, DMatrixSparseCSC dMatrixSparseCSC2, IGrowArray iGrowArray) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC.numCols) {
            throw new IllegalArgumentException("Input must be a square matrix");
        }
        if (dMatrixSparseCSC.numRows != iArr.length) {
            throw new IllegalArgumentException("Number of column in input must match length of permInv");
        }
        if (dMatrixSparseCSC.numCols != iArr.length) {
            throw new IllegalArgumentException("Number of rows in input must match length of permInv");
        }
        int i = dMatrixSparseCSC.numCols;
        int[] iArrAdjustClear = TriangularSolver_DSCC.adjustClear(iGrowArray, i);
        int i2 = 0;
        dMatrixSparseCSC2.reshape(i, i, 0);
        dMatrixSparseCSC2.indicesSorted = false;
        dMatrixSparseCSC2.col_idx[0] = 0;
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            int i5 = i3 + 1;
            int i6 = dMatrixSparseCSC.col_idx[i5];
            for (int i7 = dMatrixSparseCSC.col_idx[i3]; i7 < i6; i7++) {
                int i8 = dMatrixSparseCSC.nz_rows[i7];
                if (i8 <= i3) {
                    int i9 = iArr[i8];
                    if (i9 <= i4) {
                        i9 = i4;
                    }
                    iArrAdjustClear[i9] = iArrAdjustClear[i9] + 1;
                }
            }
            i3 = i5;
        }
        dMatrixSparseCSC2.colsum(iArrAdjustClear);
        while (i2 < i) {
            int i10 = iArr[i2];
            int i11 = i2 + 1;
            int i12 = dMatrixSparseCSC.col_idx[i11];
            for (int i13 = dMatrixSparseCSC.col_idx[i2]; i13 < i12; i13++) {
                int i14 = dMatrixSparseCSC.nz_rows[i13];
                if (i14 <= i2) {
                    int i15 = iArr[i14];
                    int i16 = i15 > i10 ? i15 : i10;
                    int i17 = iArrAdjustClear[i16];
                    iArrAdjustClear[i16] = i17 + 1;
                    int[] iArr2 = dMatrixSparseCSC2.nz_rows;
                    if (i15 >= i10) {
                        i15 = i10;
                    }
                    iArr2[i17] = i15;
                    dMatrixSparseCSC2.nz_values[i17] = dMatrixSparseCSC.nz_values[i13];
                }
            }
            i2 = i11;
        }
    }

    public static DMatrixSparseCSC concatRows(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        if (dMatrixSparseCSC.numCols != dMatrixSparseCSC2.numCols) {
            throw new IllegalArgumentException("Number of columns must match");
        }
        if (dMatrixSparseCSC3 == null) {
            dMatrixSparseCSC3 = new DMatrixSparseCSC(0, 0, 0);
        }
        dMatrixSparseCSC3.reshape(dMatrixSparseCSC.numRows + dMatrixSparseCSC2.numRows, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length + dMatrixSparseCSC2.nz_length);
        dMatrixSparseCSC3.nz_length = dMatrixSparseCSC.nz_length + dMatrixSparseCSC2.nz_length;
        int i = 0;
        int i2 = 0;
        while (i < dMatrixSparseCSC.numCols) {
            int i3 = dMatrixSparseCSC.col_idx[i];
            int i4 = i + 1;
            int i5 = dMatrixSparseCSC.col_idx[i4];
            int i6 = dMatrixSparseCSC2.col_idx[i];
            int i7 = dMatrixSparseCSC2.col_idx[i4];
            dMatrixSparseCSC3.col_idx[i4] = (((dMatrixSparseCSC3.col_idx[i] + i5) - i3) + i7) - i6;
            while (i3 < i5) {
                dMatrixSparseCSC3.nz_values[i2] = dMatrixSparseCSC.nz_values[i3];
                dMatrixSparseCSC3.nz_rows[i2] = dMatrixSparseCSC.nz_rows[i3];
                i3++;
                i2++;
            }
            while (i6 < i7) {
                dMatrixSparseCSC3.nz_values[i2] = dMatrixSparseCSC2.nz_values[i6];
                dMatrixSparseCSC3.nz_rows[i2] = dMatrixSparseCSC.numRows + dMatrixSparseCSC2.nz_rows[i6];
                i6++;
                i2++;
            }
            i = i4;
        }
        dMatrixSparseCSC3.indicesSorted = false;
        return dMatrixSparseCSC3;
    }

    public static DMatrixSparseCSC concatColumns(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, DMatrixSparseCSC dMatrixSparseCSC3) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC2.numRows) {
            throw new IllegalArgumentException("Number of rows must match");
        }
        boolean z = false;
        if (dMatrixSparseCSC3 == null) {
            dMatrixSparseCSC3 = new DMatrixSparseCSC(0, 0, 0);
        }
        dMatrixSparseCSC3.reshape(dMatrixSparseCSC.numRows, dMatrixSparseCSC.numCols + dMatrixSparseCSC2.numCols, dMatrixSparseCSC.nz_length + dMatrixSparseCSC2.nz_length);
        dMatrixSparseCSC3.nz_length = dMatrixSparseCSC.nz_length + dMatrixSparseCSC2.nz_length;
        System.arraycopy(dMatrixSparseCSC.col_idx, 0, dMatrixSparseCSC3.col_idx, 0, dMatrixSparseCSC.numCols + 1);
        System.arraycopy(dMatrixSparseCSC.nz_rows, 0, dMatrixSparseCSC3.nz_rows, 0, dMatrixSparseCSC.nz_length);
        System.arraycopy(dMatrixSparseCSC.nz_values, 0, dMatrixSparseCSC3.nz_values, 0, dMatrixSparseCSC.nz_length);
        int i = dMatrixSparseCSC.nz_length;
        int i2 = 0;
        while (i2 < dMatrixSparseCSC2.numCols) {
            int i3 = dMatrixSparseCSC2.col_idx[i2];
            int i4 = i2 + 1;
            int i5 = dMatrixSparseCSC2.col_idx[i4];
            dMatrixSparseCSC3.col_idx[dMatrixSparseCSC.numCols + i2] = i;
            dMatrixSparseCSC3.col_idx[dMatrixSparseCSC.numCols + i2 + 1] = (i5 - i3) + i;
            while (i3 < i5) {
                dMatrixSparseCSC3.nz_rows[i] = dMatrixSparseCSC2.nz_rows[i3];
                dMatrixSparseCSC3.nz_values[i] = dMatrixSparseCSC2.nz_values[i3];
                i3++;
                i++;
            }
            i2 = i4;
        }
        if (dMatrixSparseCSC.indicesSorted && dMatrixSparseCSC2.indicesSorted) {
            z = true;
        }
        dMatrixSparseCSC3.indicesSorted = z;
        return dMatrixSparseCSC3;
    }

    public static DMatrixSparseCSC extractColumn(DMatrixSparseCSC dMatrixSparseCSC, int i, DMatrixSparseCSC dMatrixSparseCSC2) {
        if (dMatrixSparseCSC2 == null) {
            dMatrixSparseCSC2 = new DMatrixSparseCSC(1, 1, 1);
        }
        int i2 = dMatrixSparseCSC.col_idx[i];
        int i3 = dMatrixSparseCSC.col_idx[i + 1] - i2;
        dMatrixSparseCSC2.reshape(dMatrixSparseCSC.numRows, 1, i3);
        dMatrixSparseCSC2.nz_length = i3;
        dMatrixSparseCSC2.col_idx[0] = 0;
        dMatrixSparseCSC2.col_idx[1] = dMatrixSparseCSC2.nz_length;
        System.arraycopy(dMatrixSparseCSC.nz_values, i2, dMatrixSparseCSC2.nz_values, 0, dMatrixSparseCSC2.nz_length);
        System.arraycopy(dMatrixSparseCSC.nz_rows, i2, dMatrixSparseCSC2.nz_rows, 0, dMatrixSparseCSC2.nz_length);
        return dMatrixSparseCSC2;
    }

    public static DMatrixSparseCSC extractRows(DMatrixSparseCSC dMatrixSparseCSC, int i, int i2, DMatrixSparseCSC dMatrixSparseCSC2) {
        if (dMatrixSparseCSC2 == null) {
            dMatrixSparseCSC2 = new DMatrixSparseCSC(1, 1, 1);
        }
        dMatrixSparseCSC2.reshape(i2 - i, dMatrixSparseCSC.numCols, dMatrixSparseCSC.nz_length);
        int i3 = 0;
        while (i3 < dMatrixSparseCSC.numCols) {
            i3++;
            int i4 = dMatrixSparseCSC.col_idx[i3];
            for (int i5 = dMatrixSparseCSC.col_idx[i3]; i5 < i4; i5++) {
                int i6 = dMatrixSparseCSC.nz_rows[i5];
                if (i6 >= i && i6 < i2) {
                    dMatrixSparseCSC2.nz_values[dMatrixSparseCSC2.nz_length] = dMatrixSparseCSC.nz_values[i5];
                    int[] iArr = dMatrixSparseCSC2.nz_rows;
                    int i7 = dMatrixSparseCSC2.nz_length;
                    dMatrixSparseCSC2.nz_length = i7 + 1;
                    iArr[i7] = i6 - i;
                }
            }
            dMatrixSparseCSC2.col_idx[i3] = dMatrixSparseCSC2.nz_length;
        }
        return dMatrixSparseCSC2;
    }

    public static void extract(DMatrixSparseCSC dMatrixSparseCSC, int i, int i2, int i3, int i4, DMatrixSparseCSC dMatrixSparseCSC2, int i5, int i6) {
        int i7 = i;
        if (i2 < i7 || i7 < 0 || i2 > dMatrixSparseCSC.getNumRows()) {
            throw new IllegalArgumentException("srcY1 < srcY0 || srcY0 < 0 || srcY1 > src.numRows");
        }
        if (i4 < i3 || i3 < 0 || i4 > dMatrixSparseCSC.getNumCols()) {
            throw new IllegalArgumentException("srcX1 < srcX0 || srcX0 < 0 || srcX1 > src.numCols");
        }
        int i8 = i4 - i3;
        int i9 = (i2 - i7) + i5;
        if (i9 > dMatrixSparseCSC2.getNumRows()) {
            throw new IllegalArgumentException("dst is too small in rows");
        }
        int i10 = i8 + i6;
        if (i10 > dMatrixSparseCSC2.getNumCols()) {
            throw new IllegalArgumentException("dst is too small in columns");
        }
        zero(dMatrixSparseCSC2, i5, i9, i6, i10);
        int i11 = i3;
        while (i11 < i4) {
            int i12 = dMatrixSparseCSC.col_idx[i11];
            int i13 = i11 + 1;
            int i14 = dMatrixSparseCSC.col_idx[i13];
            while (i12 < i14) {
                int i15 = dMatrixSparseCSC.nz_rows[i12];
                if (i15 >= i7 && i15 < i2) {
                    dMatrixSparseCSC2.set((i15 - i7) + i5, (i11 - i3) + i6, dMatrixSparseCSC.nz_values[i12]);
                }
                i12++;
                i7 = i;
            }
            i7 = i;
            i11 = i13;
        }
    }

    public static void zero(DMatrixSparseCSC dMatrixSparseCSC, int i, int i2, int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            int i6 = i5 + 1;
            int i7 = dMatrixSparseCSC.col_idx[i6];
            int i8 = 0;
            for (int i9 = dMatrixSparseCSC.col_idx[i5]; i9 < i7; i9++) {
                int i10 = dMatrixSparseCSC.nz_rows[i9];
                if (i10 >= i && i10 < i2) {
                    i8++;
                } else if (i8 > 0) {
                    int i11 = i9 - i8;
                    dMatrixSparseCSC.nz_rows[i11] = i10;
                    dMatrixSparseCSC.nz_values[i11] = dMatrixSparseCSC.nz_values[i9];
                }
            }
            if (i8 > 0) {
                while (i7 < dMatrixSparseCSC.nz_length) {
                    int i12 = i7 - i8;
                    dMatrixSparseCSC.nz_rows[i12] = dMatrixSparseCSC.nz_rows[i7];
                    dMatrixSparseCSC.nz_values[i12] = dMatrixSparseCSC.nz_values[i7];
                    i7++;
                }
                dMatrixSparseCSC.nz_length -= i8;
                while (i6 <= dMatrixSparseCSC.numCols) {
                    int[] iArr = dMatrixSparseCSC.col_idx;
                    iArr[i6] = iArr[i6] - i8;
                    i6++;
                }
            }
        }
    }

    public static double dotInnerColumns(DMatrixSparseCSC dMatrixSparseCSC, int i, DMatrixSparseCSC dMatrixSparseCSC2, int i2, IGrowArray iGrowArray, DGrowArray dGrowArray) {
        return ImplSparseSparseMult_DSCC.dotInnerColumns(dMatrixSparseCSC, i, dMatrixSparseCSC2, i2, iGrowArray, dGrowArray);
    }

    public static boolean solve(DMatrixSparseCSC dMatrixSparseCSC, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        LinearSolverSparse<DMatrixSparseCSC, DMatrixRMaj> linearSolverSparseM1683lu;
        if (dMatrixSparseCSC.numRows > dMatrixSparseCSC.numCols) {
            linearSolverSparseM1683lu = LinearSolverFactory_DSCC.m1684qr(FillReducing.NONE);
        } else {
            linearSolverSparseM1683lu = LinearSolverFactory_DSCC.m1683lu(FillReducing.NONE);
        }
        if (linearSolverSparseM1683lu.modifiesA()) {
            dMatrixSparseCSC = dMatrixSparseCSC.copy();
        }
        if (linearSolverSparseM1683lu.modifiesB()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        if (!linearSolverSparseM1683lu.setA(dMatrixSparseCSC)) {
            return false;
        }
        linearSolverSparseM1683lu.solve(dMatrixRMaj, dMatrixRMaj2);
        return true;
    }

    public static boolean invert(DMatrixSparseCSC dMatrixSparseCSC, DMatrixRMaj dMatrixRMaj) {
        if (dMatrixSparseCSC.numRows != dMatrixSparseCSC.numCols) {
            throw new IllegalArgumentException("A must be a square matrix");
        }
        if (dMatrixSparseCSC.numRows != dMatrixRMaj.numRows || dMatrixSparseCSC.numCols != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A and inverse must have the same shape.");
        }
        LinearSolverSparse<DMatrixSparseCSC, DMatrixRMaj> linearSolverSparseM1683lu = LinearSolverFactory_DSCC.m1683lu(FillReducing.NONE);
        if (linearSolverSparseM1683lu.modifiesA()) {
            dMatrixSparseCSC = dMatrixSparseCSC.copy();
        }
        DMatrixRMaj dMatrixRMajIdentity = CommonOps_DDRM.identity(dMatrixSparseCSC.numRows);
        if (!linearSolverSparseM1683lu.setA(dMatrixSparseCSC)) {
            return false;
        }
        linearSolverSparseM1683lu.solve(dMatrixRMajIdentity, dMatrixRMaj);
        return true;
    }

    public static double det(DMatrixSparseCSC dMatrixSparseCSC) {
        LUSparseDecomposition_F64<DMatrixSparseCSC> lUSparseDecomposition_F64M1681lu = DecompositionFactory_DSCC.m1681lu(FillReducing.NONE);
        if (lUSparseDecomposition_F64M1681lu.inputModified()) {
            dMatrixSparseCSC = dMatrixSparseCSC.copy();
        }
        return !lUSparseDecomposition_F64M1681lu.decompose(dMatrixSparseCSC) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : lUSparseDecomposition_F64M1681lu.computeDeterminant().real;
    }

    public static void removeZeros(DMatrixSparseCSC dMatrixSparseCSC, DMatrixSparseCSC dMatrixSparseCSC2, double d) {
        ImplCommonOps_DSCC.removeZeros(dMatrixSparseCSC, dMatrixSparseCSC2, d);
    }

    public static void removeZeros(DMatrixSparseCSC dMatrixSparseCSC, double d) {
        ImplCommonOps_DSCC.removeZeros(dMatrixSparseCSC, d);
    }

    public static double trace(DMatrixSparseCSC dMatrixSparseCSC) {
        int iMin = Math.min(dMatrixSparseCSC.numCols, dMatrixSparseCSC.numRows);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        while (i < iMin) {
            int i2 = dMatrixSparseCSC.col_idx[i];
            int i3 = i + 1;
            int i4 = dMatrixSparseCSC.col_idx[i3];
            while (true) {
                if (i2 >= i4) {
                    break;
                }
                if (dMatrixSparseCSC.nz_rows[i2] == i) {
                    d += dMatrixSparseCSC.nz_values[i2];
                    break;
                }
                i2++;
            }
            i = i3;
        }
        return d;
    }
}
