package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.EjmlParameters;
import org.ejml.LinearSolverSafe;
import org.ejml.MatrixDimensionException;
import org.ejml.UtilEjml;
import org.ejml.data.BMatrixRMaj;
import org.ejml.data.DMatrix;
import org.ejml.data.DMatrix1Row;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionAlt_DDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_DDRM;
import org.ejml.dense.row.linsol.p051lu.LinearSolverLu_DDRM;
import org.ejml.dense.row.misc.ImplCommonOps_DDMA;
import org.ejml.dense.row.misc.ImplCommonOps_DDRM;
import org.ejml.dense.row.misc.RrefGaussJordanRowPivot_DDRM;
import org.ejml.dense.row.misc.TransposeAlgs_DDRM;
import org.ejml.dense.row.misc.UnrolledDeterminantFromMinor_DDRM;
import org.ejml.dense.row.misc.UnrolledInverseFromMinor_DDRM;
import org.ejml.dense.row.mult.MatrixMatrixMult_DDRM;
import org.ejml.dense.row.mult.MatrixMultProduct_DDRM;
import org.ejml.dense.row.mult.MatrixVectorMult_DDRM;
import org.ejml.dense.row.mult.VectorVectorMult_DDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_DDRM {
    public static void mult(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numCols == 1) {
            MatrixVectorMult_DDRM.mult(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else if (dMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.mult_reorder(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.mult_small(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void mult(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.mult_reorder(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.mult_small(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multTransA(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numCols == 1) {
            if (dMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
                MatrixVectorMult_DDRM.multTransA_reorder(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
                return;
            } else {
                MatrixVectorMult_DDRM.multTransA_small(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
                return;
            }
        }
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH || dMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multTransA_reorder(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.multTransA_small(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multTransA(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH || dMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multTransA_reorder(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.multTransA_small(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multTransB(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numRows == 1) {
            MatrixVectorMult_DDRM.mult(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.multTransB(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multTransB(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        MatrixMatrixMult_DDRM.multTransB(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
    }

    public static void multTransAB(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numRows == 1) {
            if (dMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
                MatrixVectorMult_DDRM.multTransA_reorder(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
                return;
            } else {
                MatrixVectorMult_DDRM.multTransA_small(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
                return;
            }
        }
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multTransAB_aux(dMatrix1Row, dMatrix1Row2, dMatrix1Row3, null);
        } else {
            MatrixMatrixMult_DDRM.multTransAB(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multTransAB(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multTransAB_aux(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3, null);
        } else {
            MatrixMatrixMult_DDRM.multTransAB(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static double dot(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (!MatrixFeatures_DDRM.isVector(dMatrixD1) || !MatrixFeatures_DDRM.isVector(dMatrixD12)) {
            throw new RuntimeException("Both inputs must be vectors");
        }
        return VectorVectorMult_DDRM.innerProd(dMatrixD1, dMatrixD12);
    }

    public static void multInner(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2) {
        if (dMatrix1Row.numCols != dMatrix1Row2.numCols || dMatrix1Row.numCols != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("Rows and columns of 'c' must be the same as the columns in 'a'");
        }
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_INNER_SWITCH) {
            MatrixMultProduct_DDRM.inner_small(dMatrix1Row, dMatrix1Row2);
        } else {
            MatrixMultProduct_DDRM.inner_reorder(dMatrix1Row, dMatrix1Row2);
        }
    }

    public static void multOuter(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2) {
        if (dMatrix1Row.numRows != dMatrix1Row2.numCols || dMatrix1Row.numRows != dMatrix1Row2.numRows) {
            throw new MatrixDimensionException("Rows and columns of 'c' must be the same as the rows in 'a'");
        }
        MatrixMultProduct_DDRM.outer(dMatrix1Row, dMatrix1Row2);
    }

    public static void multAdd(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numCols == 1) {
            MatrixVectorMult_DDRM.multAdd(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else if (dMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multAdd_reorder(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.multAdd_small(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multAdd(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multAdd_reorder(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.multAdd_small(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multAddTransA(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numCols == 1) {
            if (dMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
                MatrixVectorMult_DDRM.multAddTransA_reorder(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
                return;
            } else {
                MatrixVectorMult_DDRM.multAddTransA_small(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
                return;
            }
        }
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH || dMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multAddTransA_reorder(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.multAddTransA_small(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multAddTransA(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH || dMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multAddTransA_reorder(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        } else {
            MatrixMatrixMult_DDRM.multAddTransA_small(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multAddTransB(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        MatrixMatrixMult_DDRM.multAddTransB(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
    }

    public static void multAddTransB(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        MatrixMatrixMult_DDRM.multAddTransB(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
    }

    public static void multAddTransAB(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row2.numRows == 1) {
            if (dMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
                MatrixVectorMult_DDRM.multAddTransA_reorder(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
                return;
            } else {
                MatrixVectorMult_DDRM.multAddTransA_small(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
                return;
            }
        }
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multAddTransAB_aux(dMatrix1Row, dMatrix1Row2, dMatrix1Row3, null);
        } else {
            MatrixMatrixMult_DDRM.multAddTransAB(dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static void multAddTransAB(double d, DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2, DMatrix1Row dMatrix1Row3) {
        if (dMatrix1Row.numCols >= EjmlParameters.MULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_DDRM.multAddTransAB_aux(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3, null);
        } else {
            MatrixMatrixMult_DDRM.multAddTransAB(d, dMatrix1Row, dMatrix1Row2, dMatrix1Row3);
        }
    }

    public static boolean solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        LinearSolverSafe linearSolverSafe = new LinearSolverSafe(LinearSolverFactory_DDRM.general(dMatrixRMaj.numRows, dMatrixRMaj.numCols));
        if (!linearSolverSafe.setA(dMatrixRMaj)) {
            return false;
        }
        linearSolverSafe.solve(dMatrixRMaj2, dMatrixRMaj3);
        return true;
    }

    public static void transpose(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numCols == dMatrixRMaj.numRows) {
            TransposeAlgs_DDRM.square(dMatrixRMaj);
            return;
        }
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numCols, dMatrixRMaj.numRows);
        transpose(dMatrixRMaj, dMatrixRMaj2);
        dMatrixRMaj.set((DMatrixD1) dMatrixRMaj2);
    }

    public static DMatrixRMaj transpose(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numCols, dMatrixRMaj.numRows);
        } else if (dMatrixRMaj.numRows != dMatrixRMaj2.numCols || dMatrixRMaj.numCols != dMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("Incompatible matrix dimensions");
        }
        if (dMatrixRMaj.numRows > EjmlParameters.TRANSPOSE_SWITCH && dMatrixRMaj.numCols > EjmlParameters.TRANSPOSE_SWITCH) {
            TransposeAlgs_DDRM.block(dMatrixRMaj, dMatrixRMaj2, EjmlParameters.BLOCK_WIDTH);
            return dMatrixRMaj2;
        }
        TransposeAlgs_DDRM.standard(dMatrixRMaj, dMatrixRMaj2);
        return dMatrixRMaj2;
    }

    public static double trace(DMatrix1Row dMatrix1Row) {
        int iMin = Math.min(dMatrix1Row.numRows, dMatrix1Row.numCols);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            d += dMatrix1Row.get(i);
            i += dMatrix1Row.numCols + 1;
        }
        return d;
    }

    public static double det(DMatrixRMaj dMatrixRMaj) {
        int numCols = dMatrixRMaj.getNumCols();
        if (numCols != dMatrixRMaj.getNumRows()) {
            throw new MatrixDimensionException("Must be a square matrix.");
        }
        if (numCols <= 6) {
            if (numCols >= 2) {
                return UnrolledDeterminantFromMinor_DDRM.det(dMatrixRMaj);
            }
            return dMatrixRMaj.get(0);
        }
        LUDecompositionAlt_DDRM lUDecompositionAlt_DDRM = new LUDecompositionAlt_DDRM();
        if (lUDecompositionAlt_DDRM.inputModified()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        return !lUDecompositionAlt_DDRM.decompose(dMatrixRMaj) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : lUDecompositionAlt_DDRM.computeDeterminant().real;
    }

    public static boolean invert(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numCols <= 5) {
            if (dMatrixRMaj.numCols != dMatrixRMaj.numRows) {
                throw new MatrixDimensionException("Must be a square matrix.");
            }
            if (dMatrixRMaj.numCols >= 2) {
                UnrolledInverseFromMinor_DDRM.inv(dMatrixRMaj, dMatrixRMaj);
                return true;
            }
            dMatrixRMaj.set(0, 1.0d / dMatrixRMaj.get(0));
            return true;
        }
        LinearSolverLu_DDRM linearSolverLu_DDRM = new LinearSolverLu_DDRM(new LUDecompositionAlt_DDRM());
        if (!linearSolverLu_DDRM.setA(dMatrixRMaj)) {
            return false;
        }
        linearSolverLu_DDRM.invert(dMatrixRMaj);
        return true;
    }

    public static boolean invert(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numCols <= 5) {
            if (dMatrixRMaj.numCols != dMatrixRMaj.numRows) {
                throw new MatrixDimensionException("Must be a square matrix.");
            }
            if (dMatrixRMaj2.numCols >= 2) {
                UnrolledInverseFromMinor_DDRM.inv(dMatrixRMaj, dMatrixRMaj2);
                return true;
            }
            dMatrixRMaj2.set(0, 1.0d / dMatrixRMaj.get(0));
            return true;
        }
        LinearSolverLu_DDRM linearSolverLu_DDRM = new LinearSolverLu_DDRM(new LUDecompositionAlt_DDRM());
        if (linearSolverLu_DDRM.modifiesA()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        if (!linearSolverLu_DDRM.setA(dMatrixRMaj)) {
            return false;
        }
        linearSolverLu_DDRM.invert(dMatrixRMaj2);
        return true;
    }

    public static void pinv(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        LinearSolverDense<DMatrixRMaj> linearSolverDensePseudoInverse = LinearSolverFactory_DDRM.pseudoInverse(true);
        if (linearSolverDensePseudoInverse.modifiesA()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        if (!linearSolverDensePseudoInverse.setA(dMatrixRMaj)) {
            throw new IllegalArgumentException("Invert failed, maybe a bug?");
        }
        linearSolverDensePseudoInverse.invert(dMatrixRMaj2);
    }

    public static DMatrixRMaj[] columnsToVector(DMatrixRMaj dMatrixRMaj, DMatrixRMaj[] dMatrixRMajArr) {
        if (dMatrixRMajArr == null || dMatrixRMajArr.length < dMatrixRMaj.numCols) {
            dMatrixRMajArr = new DMatrixRMaj[dMatrixRMaj.numCols];
        }
        for (int i = 0; i < dMatrixRMajArr.length; i++) {
            DMatrixRMaj dMatrixRMaj2 = dMatrixRMajArr[i];
            if (dMatrixRMaj2 == null) {
                dMatrixRMajArr[i] = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
            } else {
                dMatrixRMaj2.reshape(dMatrixRMaj.numRows, 1, false);
            }
            DMatrixRMaj dMatrixRMaj3 = dMatrixRMajArr[i];
            for (int i2 = 0; i2 < dMatrixRMaj.numRows; i2++) {
                dMatrixRMaj3.set(i2, 0, dMatrixRMaj.get(i2, i));
            }
        }
        return dMatrixRMajArr;
    }

    public static DMatrixRMaj[] rowsToVector(DMatrixRMaj dMatrixRMaj, DMatrixRMaj[] dMatrixRMajArr) {
        if (dMatrixRMajArr == null || dMatrixRMajArr.length < dMatrixRMaj.numRows) {
            dMatrixRMajArr = new DMatrixRMaj[dMatrixRMaj.numRows];
        }
        for (int i = 0; i < dMatrixRMajArr.length; i++) {
            DMatrixRMaj dMatrixRMaj2 = dMatrixRMajArr[i];
            if (dMatrixRMaj2 == null) {
                dMatrixRMajArr[i] = new DMatrixRMaj(dMatrixRMaj.numCols, 1);
            } else {
                dMatrixRMaj2.reshape(dMatrixRMaj.numCols, 1, false);
            }
            DMatrixRMaj dMatrixRMaj3 = dMatrixRMajArr[i];
            for (int i2 = 0; i2 < dMatrixRMaj.numCols; i2++) {
                dMatrixRMaj3.set(i2, 0, dMatrixRMaj.get(i, i2));
            }
        }
        return dMatrixRMajArr;
    }

    public static void setIdentity(DMatrix1Row dMatrix1Row) {
        int i = dMatrix1Row.numRows < dMatrix1Row.numCols ? dMatrix1Row.numRows : dMatrix1Row.numCols;
        int i2 = 0;
        Arrays.fill(dMatrix1Row.data, 0, dMatrix1Row.getNumElements(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        int i3 = 0;
        while (i2 < i) {
            dMatrix1Row.data[i3] = 1.0d;
            i2++;
            i3 += dMatrix1Row.numCols + 1;
        }
    }

    public static DMatrixRMaj identity(int i) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i);
        for (int i2 = 0; i2 < i; i2++) {
            dMatrixRMaj.set(i2, i2, 1.0d);
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj identity(int i, int i2) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        if (i >= i2) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            dMatrixRMaj.set(i3, i3, 1.0d);
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj diag(double... dArr) {
        return diag(null, dArr.length, dArr);
    }

    public static DMatrixRMaj diag(DMatrixRMaj dMatrixRMaj, int i, double... dArr) {
        if (dMatrixRMaj == null) {
            dMatrixRMaj = new DMatrixRMaj(i, i);
        } else {
            if (dMatrixRMaj.numRows != i || dMatrixRMaj.numCols != i) {
                throw new IllegalArgumentException("Unexpected matrix size");
            }
            fill(dMatrixRMaj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        for (int i2 = 0; i2 < i; i2++) {
            dMatrixRMaj.unsafe_set(i2, i2, dArr[i2]);
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj diagR(int i, int i2, double... dArr) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i2);
        int iMin = Math.min(i, i2);
        for (int i3 = 0; i3 < iMin; i3++) {
            dMatrixRMaj.set(i3, i3, dArr[i3]);
        }
        return dMatrixRMaj;
    }

    public static void kron(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, DMatrixRMaj dMatrixRMaj3) {
        int i = dMatrixRMaj.numCols * dMatrixRMaj2.numCols;
        int i2 = dMatrixRMaj.numRows * dMatrixRMaj2.numRows;
        if (dMatrixRMaj3.numCols != i || dMatrixRMaj3.numRows != i2) {
            throw new MatrixDimensionException("C does not have the expected dimensions");
        }
        for (int i3 = 0; i3 < dMatrixRMaj.numRows; i3++) {
            for (int i4 = 0; i4 < dMatrixRMaj.numCols; i4++) {
                double d = dMatrixRMaj.get(i3, i4);
                for (int i5 = 0; i5 < dMatrixRMaj2.numRows; i5++) {
                    for (int i6 = 0; i6 < dMatrixRMaj2.numCols; i6++) {
                        dMatrixRMaj3.set((dMatrixRMaj2.numRows * i3) + i5, (dMatrixRMaj2.numCols * i4) + i6, dMatrixRMaj2.get(i5, i6) * d);
                    }
                }
            }
        }
    }

    public static void extract(DMatrix dMatrix, int i, int i2, int i3, int i4, DMatrix dMatrix2, int i5, int i6) {
        if (i2 < i || i < 0 || i2 > dMatrix.getNumRows()) {
            throw new MatrixDimensionException("srcY1 < srcY0 || srcY0 < 0 || srcY1 > src.numRows");
        }
        if (i4 < i3 || i3 < 0 || i4 > dMatrix.getNumCols()) {
            throw new MatrixDimensionException("srcX1 < srcX0 || srcX0 < 0 || srcX1 > src.numCols");
        }
        int i7 = i4 - i3;
        int i8 = i2 - i;
        if (i5 + i8 > dMatrix2.getNumRows()) {
            throw new MatrixDimensionException("dst is too small in rows");
        }
        if (i6 + i7 > dMatrix2.getNumCols()) {
            throw new MatrixDimensionException("dst is too small in columns");
        }
        if ((dMatrix instanceof DMatrixRMaj) && (dMatrix2 instanceof DMatrixRMaj)) {
            ImplCommonOps_DDRM.extract((DMatrixRMaj) dMatrix, i, i3, (DMatrixRMaj) dMatrix2, i5, i6, i8, i7);
        } else {
            ImplCommonOps_DDMA.extract(dMatrix, i, i3, dMatrix2, i5, i6, i8, i7);
        }
    }

    public static DMatrixRMaj extract(DMatrixRMaj dMatrixRMaj, int i, int i2, int i3, int i4) {
        if (i2 <= i || i < 0 || i2 > dMatrixRMaj.numRows) {
            throw new MatrixDimensionException("srcY1 <= srcY0 || srcY0 < 0 || srcY1 > src.numRows");
        }
        if (i4 <= i3 || i3 < 0 || i4 > dMatrixRMaj.numCols) {
            throw new MatrixDimensionException("srcX1 <= srcX0 || srcX0 < 0 || srcX1 > src.numCols");
        }
        int i5 = i4 - i3;
        int i6 = i2 - i;
        DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(i6, i5);
        ImplCommonOps_DDRM.extract(dMatrixRMaj, i, i3, dMatrixRMaj2, 0, 0, i6, i5);
        return dMatrixRMaj2;
    }

    public static void extract(DMatrixRMaj dMatrixRMaj, int[] iArr, int i, int[] iArr2, int i2, DMatrixRMaj dMatrixRMaj2) {
        if (i != dMatrixRMaj2.numRows || i2 != dMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("Unexpected number of rows and/or columns in dst matrix");
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = dMatrixRMaj.numCols * iArr[i4];
            int i6 = 0;
            while (i6 < i2) {
                dMatrixRMaj2.data[i3] = dMatrixRMaj.data[iArr2[i6] + i5];
                i6++;
                i3++;
            }
        }
    }

    public static void extract(DMatrixRMaj dMatrixRMaj, int[] iArr, int i, DMatrixRMaj dMatrixRMaj2) {
        if (!MatrixFeatures_DDRM.isVector(dMatrixRMaj2)) {
            throw new MatrixDimensionException("Dst must be a vector");
        }
        if (i != dMatrixRMaj2.getNumElements()) {
            throw new MatrixDimensionException("Unexpected number of elements in dst vector");
        }
        for (int i2 = 0; i2 < i; i2++) {
            dMatrixRMaj2.data[i2] = dMatrixRMaj.data[iArr[i2]];
        }
    }

    public static void insert(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, int[] iArr, int i, int[] iArr2, int i2) {
        if (i != dMatrixRMaj.numRows || i2 != dMatrixRMaj.numCols) {
            throw new MatrixDimensionException("Unexpected number of rows and/or columns in dst matrix");
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = dMatrixRMaj2.numCols * iArr[i4];
            int i6 = 0;
            while (i6 < i2) {
                dMatrixRMaj2.data[iArr2[i6] + i5] = dMatrixRMaj.data[i3];
                i6++;
                i3++;
            }
        }
    }

    public static void extractDiag(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        int iMin = Math.min(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        if (!MatrixFeatures_DDRM.isVector(dMatrixRMaj2)) {
            throw new MatrixDimensionException("Expected a vector for dst.");
        }
        if (dMatrixRMaj2.getNumElements() != iMin) {
            throw new MatrixDimensionException("Expected " + iMin + " elements in dst.");
        }
        for (int i = 0; i < iMin; i++) {
            dMatrixRMaj2.set(i, dMatrixRMaj.unsafe_get(i, i));
        }
    }

    public static DMatrixRMaj extractRow(DMatrixRMaj dMatrixRMaj, int i, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(1, dMatrixRMaj.numCols);
        } else if (!MatrixFeatures_DDRM.isVector(dMatrixRMaj2) || dMatrixRMaj2.getNumElements() != dMatrixRMaj.numCols) {
            throw new MatrixDimensionException("Output must be a vector of length " + dMatrixRMaj.numCols);
        }
        System.arraycopy(dMatrixRMaj.data, dMatrixRMaj.getIndex(i, 0), dMatrixRMaj2.data, 0, dMatrixRMaj.numCols);
        return dMatrixRMaj2;
    }

    public static DMatrixRMaj extractColumn(DMatrixRMaj dMatrixRMaj, int i, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
        } else if (!MatrixFeatures_DDRM.isVector(dMatrixRMaj2) || dMatrixRMaj2.getNumElements() != dMatrixRMaj.numRows) {
            throw new MatrixDimensionException("Output must be a vector of length " + dMatrixRMaj.numRows);
        }
        int i2 = 0;
        while (i2 < dMatrixRMaj.numRows) {
            dMatrixRMaj2.data[i2] = dMatrixRMaj.data[i];
            i2++;
            i += dMatrixRMaj.numCols;
        }
        return dMatrixRMaj2;
    }

    public static void insert(DMatrix dMatrix, DMatrix dMatrix2, int i, int i2) {
        extract(dMatrix, 0, dMatrix.getNumRows(), 0, dMatrix.getNumCols(), dMatrix2, i, i2);
    }

    public static double elementMax(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        double d = dMatrixD1.get(0);
        for (int i = 1; i < numElements; i++) {
            double d2 = dMatrixD1.get(i);
            if (d2 >= d) {
                d = d2;
            }
        }
        return d;
    }

    public static double elementMaxAbs(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            double dAbs = Math.abs(dMatrixD1.get(i));
            if (dAbs > d) {
                d = dAbs;
            }
        }
        return d;
    }

    public static double elementMin(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        double d = dMatrixD1.get(0);
        for (int i = 1; i < numElements; i++) {
            double d2 = dMatrixD1.get(i);
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static double elementMinAbs(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        double d = Double.MAX_VALUE;
        for (int i = 0; i < numElements; i++) {
            double dAbs = Math.abs(dMatrixD1.get(i));
            if (dAbs < d) {
                d = dAbs;
            }
        }
        return d;
    }

    public static void elementMult(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD1.times(i, dMatrixD12.get(i));
        }
    }

    public static void elementMult(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numRows != dMatrixD13.numRows || dMatrixD1.numCols != dMatrixD13.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD13.set(i, dMatrixD1.get(i) * dMatrixD12.get(i));
        }
    }

    public static void elementDiv(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD1.div(i, dMatrixD12.get(i));
        }
    }

    public static void elementDiv(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numRows != dMatrixD13.numRows || dMatrixD1.numCols != dMatrixD13.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD13.set(i, dMatrixD1.get(i) / dMatrixD12.get(i));
        }
    }

    public static double elementSum(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            d += dMatrixD1.get(i);
        }
        return d;
    }

    public static double elementSumAbs(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        double dAbs = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            dAbs += Math.abs(dMatrixD1.get(i));
        }
        return dAbs;
    }

    public static void elementPower(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numRows != dMatrixD13.numRows || dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numCols != dMatrixD13.numCols) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD13.data[i] = Math.pow(dMatrixD1.data[i], dMatrixD12.data[i]);
        }
    }

    public static void elementPower(double d, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = Math.pow(d, dMatrixD1.data[i]);
        }
    }

    public static void elementPower(DMatrixD1 dMatrixD1, double d, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = Math.pow(dMatrixD1.data[i], d);
        }
    }

    public static void elementLog(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = Math.log(dMatrixD1.data[i]);
        }
    }

    public static void elementExp(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = Math.exp(dMatrixD1.data[i]);
        }
    }

    public static DMatrixRMaj sumRows(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
        } else {
            dMatrixRMaj2.reshape(dMatrixRMaj.numRows, 1);
        }
        int i = 0;
        while (i < dMatrixRMaj.numRows) {
            int i2 = i + 1;
            int i3 = dMatrixRMaj.numCols * i2;
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            for (int i4 = dMatrixRMaj.numCols * i; i4 < i3; i4++) {
                d += dMatrixRMaj.data[i4];
            }
            dMatrixRMaj2.set(i, d);
            i = i2;
        }
        return dMatrixRMaj2;
    }

    public static DMatrixRMaj minRows(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
        } else {
            dMatrixRMaj2.reshape(dMatrixRMaj.numRows, 1);
        }
        int i = 0;
        while (i < dMatrixRMaj.numRows) {
            int i2 = i + 1;
            int i3 = dMatrixRMaj.numCols * i2;
            double d = Double.MAX_VALUE;
            for (int i4 = dMatrixRMaj.numCols * i; i4 < i3; i4++) {
                double d2 = dMatrixRMaj.data[i4];
                if (d2 < d) {
                    d = d2;
                }
            }
            dMatrixRMaj2.set(i, d);
            i = i2;
        }
        return dMatrixRMaj2;
    }

    public static DMatrixRMaj maxRows(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
        } else {
            dMatrixRMaj2.reshape(dMatrixRMaj.numRows, 1);
        }
        int i = 0;
        while (i < dMatrixRMaj.numRows) {
            int i2 = i + 1;
            int i3 = dMatrixRMaj.numCols * i2;
            double d = -1.7976931348623157E308d;
            for (int i4 = dMatrixRMaj.numCols * i; i4 < i3; i4++) {
                double d2 = dMatrixRMaj.data[i4];
                if (d2 > d) {
                    d = d2;
                }
            }
            dMatrixRMaj2.set(i, d);
            i = i2;
        }
        return dMatrixRMaj2;
    }

    public static DMatrixRMaj sumCols(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(1, dMatrixRMaj.numCols);
        } else {
            dMatrixRMaj2.reshape(1, dMatrixRMaj.numCols);
        }
        for (int i = 0; i < dMatrixRMaj.numCols; i++) {
            int i2 = (dMatrixRMaj.numCols * dMatrixRMaj.numRows) + i;
            double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            int i3 = i;
            while (i3 < i2) {
                d += dMatrixRMaj.data[i3];
                i3 += dMatrixRMaj.numCols;
            }
            dMatrixRMaj2.set(i, d);
        }
        return dMatrixRMaj2;
    }

    public static DMatrixRMaj minCols(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(1, dMatrixRMaj.numCols);
        } else {
            dMatrixRMaj2.reshape(1, dMatrixRMaj.numCols);
        }
        for (int i = 0; i < dMatrixRMaj.numCols; i++) {
            int i2 = (dMatrixRMaj.numCols * dMatrixRMaj.numRows) + i;
            double d = Double.MAX_VALUE;
            int i3 = i;
            while (i3 < i2) {
                double d2 = dMatrixRMaj.data[i3];
                if (d2 < d) {
                    d = d2;
                }
                i3 += dMatrixRMaj.numCols;
            }
            dMatrixRMaj2.set(i, d);
        }
        return dMatrixRMaj2;
    }

    public static DMatrixRMaj maxCols(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(1, dMatrixRMaj.numCols);
        } else {
            dMatrixRMaj2.reshape(1, dMatrixRMaj.numCols);
        }
        for (int i = 0; i < dMatrixRMaj.numCols; i++) {
            int i2 = (dMatrixRMaj.numCols * dMatrixRMaj.numRows) + i;
            double d = -1.7976931348623157E308d;
            int i3 = i;
            while (i3 < i2) {
                double d2 = dMatrixRMaj.data[i3];
                if (d2 > d) {
                    d = d2;
                }
                i3 += dMatrixRMaj.numCols;
            }
            dMatrixRMaj2.set(i, d);
        }
        return dMatrixRMaj2;
    }

    public static void addEquals(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD1.plus(i, dMatrixD12.get(i));
        }
    }

    public static void addEquals(DMatrixD1 dMatrixD1, double d, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD1.plus(i, dMatrixD12.get(i) * d);
        }
    }

    public static void add(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD13.numCols || dMatrixD1.numRows != dMatrixD13.numRows) {
            throw new MatrixDimensionException("The matrices are not all the same dimension.");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD13.set(i, dMatrixD1.get(i) + dMatrixD12.get(i));
        }
    }

    public static void add(DMatrixD1 dMatrixD1, double d, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD13.numCols || dMatrixD1.numRows != dMatrixD13.numRows) {
            throw new MatrixDimensionException("The matrices are not all the same dimension.");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD13.set(i, dMatrixD1.get(i) + (dMatrixD12.get(i) * d));
        }
    }

    public static void add(double d, DMatrixD1 dMatrixD1, double d2, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD13.numCols || dMatrixD1.numRows != dMatrixD13.numRows) {
            throw new MatrixDimensionException("The matrices are not all the same dimension.");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD13.set(i, (dMatrixD1.get(i) * d) + (dMatrixD12.get(i) * d2));
        }
    }

    public static void add(double d, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD13.numCols || dMatrixD1.numRows != dMatrixD13.numRows) {
            throw new MatrixDimensionException("The matrices are not all the same dimension.");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD13.set(i, (dMatrixD1.get(i) * d) + dMatrixD12.get(i));
        }
    }

    public static void add(DMatrixD1 dMatrixD1, double d) {
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD1.plus(i, d);
        }
    }

    public static void add(DMatrixD1 dMatrixD1, double d, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("Dimensions of a and c do not match.");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = dMatrixD1.data[i] + d;
        }
    }

    public static void subtract(DMatrixD1 dMatrixD1, double d, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("Dimensions of a and c do not match.");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = dMatrixD1.data[i] - d;
        }
    }

    public static void subtract(double d, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("Dimensions of a and c do not match.");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = d - dMatrixD1.data[i];
        }
    }

    public static void subtractEquals(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            double[] dArr = dMatrixD1.data;
            dArr[i] = dArr[i] - dMatrixD12.data[i];
        }
    }

    public static void subtract(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, DMatrixD1 dMatrixD13) {
        if (dMatrixD1.numCols != dMatrixD12.numCols || dMatrixD1.numRows != dMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD13.data[i] = dMatrixD1.data[i] - dMatrixD12.data[i];
        }
    }

    public static void scale(double d, DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            double[] dArr = dMatrixD1.data;
            dArr[i] = dArr[i] * d;
        }
    }

    public static void scale(double d, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("Matrices must have the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = dMatrixD1.data[i] * d;
        }
    }

    public static void divide(double d, DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD1.data[i] = d / dMatrixD1.data[i];
        }
    }

    public static void divide(DMatrixD1 dMatrixD1, double d) {
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            double[] dArr = dMatrixD1.data;
            dArr[i] = dArr[i] / d;
        }
    }

    public static void divide(double d, DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("Matrices must have the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = d / dMatrixD1.data[i];
        }
    }

    public static void divide(DMatrixD1 dMatrixD1, double d, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("Matrices must have the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = dMatrixD1.data[i] / d;
        }
    }

    public static void changeSign(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD1.data[i] = -dMatrixD1.data[i];
        }
    }

    public static void changeSign(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new MatrixDimensionException("Matrices must have the same shape");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixD12.data[i] = -dMatrixD1.data[i];
        }
    }

    public static void fill(DMatrixD1 dMatrixD1, double d) {
        Arrays.fill(dMatrixD1.data, 0, dMatrixD1.getNumElements(), d);
    }

    public static DMatrixRMaj rref(DMatrixRMaj dMatrixRMaj, int i, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        } else if (dMatrixRMaj2.numCols != dMatrixRMaj.numCols || dMatrixRMaj2.numRows != dMatrixRMaj.numRows) {
            throw new MatrixDimensionException("'re' must have the same shape as the original input matrix");
        }
        if (i <= 0) {
            i = Math.min(dMatrixRMaj.numCols, dMatrixRMaj.numRows);
        }
        RrefGaussJordanRowPivot_DDRM rrefGaussJordanRowPivot_DDRM = new RrefGaussJordanRowPivot_DDRM();
        rrefGaussJordanRowPivot_DDRM.setTolerance(elementMaxAbs(dMatrixRMaj) * UtilEjml.EPS * ((double) Math.max(dMatrixRMaj.numRows, dMatrixRMaj.numCols)));
        dMatrixRMaj2.set((DMatrixD1) dMatrixRMaj);
        rrefGaussJordanRowPivot_DDRM.reduce(dMatrixRMaj2, i);
        return dMatrixRMaj2;
    }

    public static BMatrixRMaj elementLessThan(DMatrixRMaj dMatrixRMaj, double d, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = dMatrixRMaj.data[i] < d;
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementLessThanOrEqual(DMatrixRMaj dMatrixRMaj, double d, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = dMatrixRMaj.data[i] <= d;
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementMoreThan(DMatrixRMaj dMatrixRMaj, double d, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = dMatrixRMaj.data[i] > d;
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementMoreThanOrEqual(DMatrixRMaj dMatrixRMaj, double d, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = dMatrixRMaj.data[i] >= d;
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementLessThan(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = dMatrixRMaj.data[i] < dMatrixRMaj2.data[i];
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementLessThanOrEqual(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = dMatrixRMaj.data[i] <= dMatrixRMaj2.data[i];
        }
        return bMatrixRMaj;
    }

    public static DMatrixRMaj elements(DMatrixRMaj dMatrixRMaj, BMatrixRMaj bMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numRows != bMatrixRMaj.numRows || dMatrixRMaj.numCols != bMatrixRMaj.numCols) {
            throw new MatrixDimensionException("Input matrices must have the same shape");
        }
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(1, 1);
        }
        dMatrixRMaj2.reshape(countTrue(bMatrixRMaj), 1);
        int numElements = dMatrixRMaj.getNumElements();
        int i = 0;
        for (int i2 = 0; i2 < numElements; i2++) {
            if (bMatrixRMaj.data[i2]) {
                dMatrixRMaj2.data[i] = dMatrixRMaj.data[i2];
                i++;
            }
        }
        return dMatrixRMaj2;
    }

    public static int countTrue(BMatrixRMaj bMatrixRMaj) {
        int numElements = bMatrixRMaj.getNumElements();
        int i = 0;
        for (int i2 = 0; i2 < numElements; i2++) {
            if (bMatrixRMaj.data[i2]) {
                i++;
            }
        }
        return i;
    }

    public static DMatrixRMaj concatColumns(DMatrixRMaj... dMatrixRMajArr) {
        int iMax = 0;
        int i = 0;
        for (int i2 = 0; i2 < dMatrixRMajArr.length; i2++) {
            iMax = Math.max(iMax, dMatrixRMajArr[i2].numRows);
            i += dMatrixRMajArr[i2].numCols;
        }
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(iMax, i);
        int i3 = 0;
        for (int i4 = 0; i4 < dMatrixRMajArr.length; i4++) {
            insert(dMatrixRMajArr[i4], dMatrixRMaj, 0, i3);
            i3 += dMatrixRMajArr[i4].numCols;
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj concatRows(DMatrixRMaj... dMatrixRMajArr) {
        int i = 0;
        int iMax = 0;
        for (int i2 = 0; i2 < dMatrixRMajArr.length; i2++) {
            i += dMatrixRMajArr[i2].numRows;
            iMax = Math.max(iMax, dMatrixRMajArr[i2].numCols);
        }
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, iMax);
        int i3 = 0;
        for (int i4 = 0; i4 < dMatrixRMajArr.length; i4++) {
            insert(dMatrixRMajArr[i4], dMatrixRMaj, i3, 0);
            i3 += dMatrixRMajArr[i4].numRows;
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj permuteRowInv(int[] iArr, DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numRows > iArr.length) {
            throw new MatrixDimensionException("permutation vector must have at least as many elements as input has rows");
        }
        if (dMatrixRMaj2 == null) {
            dMatrixRMaj2 = new DMatrixRMaj(1, 1);
        }
        dMatrixRMaj2.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        int i = dMatrixRMaj.numCols;
        for (int i2 = 0; i2 < dMatrixRMaj.numRows; i2++) {
            System.arraycopy(dMatrixRMaj.data, i2 * i, dMatrixRMaj2.data, iArr[i2] * i, i);
        }
        return dMatrixRMaj2;
    }
}
