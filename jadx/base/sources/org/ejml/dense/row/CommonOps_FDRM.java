package org.ejml.dense.row;

import java.util.Arrays;
import org.ejml.EjmlParameters;
import org.ejml.LinearSolverSafe;
import org.ejml.MatrixDimensionException;
import org.ejml.UtilEjml;
import org.ejml.data.BMatrixRMaj;
import org.ejml.data.FMatrix;
import org.ejml.data.FMatrix1Row;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionAlt_FDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_FDRM;
import org.ejml.dense.row.linsol.p051lu.LinearSolverLu_FDRM;
import org.ejml.dense.row.misc.ImplCommonOps_FDMA;
import org.ejml.dense.row.misc.ImplCommonOps_FDRM;
import org.ejml.dense.row.misc.RrefGaussJordanRowPivot_FDRM;
import org.ejml.dense.row.misc.TransposeAlgs_FDRM;
import org.ejml.dense.row.misc.UnrolledDeterminantFromMinor_FDRM;
import org.ejml.dense.row.misc.UnrolledInverseFromMinor_FDRM;
import org.ejml.dense.row.mult.MatrixMatrixMult_FDRM;
import org.ejml.dense.row.mult.MatrixMultProduct_FDRM;
import org.ejml.dense.row.mult.MatrixVectorMult_FDRM;
import org.ejml.dense.row.mult.VectorVectorMult_FDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_FDRM {
    public static void mult(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numCols == 1) {
            MatrixVectorMult_FDRM.mult(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else if (fMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.mult_reorder(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.mult_small(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void mult(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.mult_reorder(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.mult_small(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multTransA(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numCols == 1) {
            if (fMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
                MatrixVectorMult_FDRM.multTransA_reorder(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
                return;
            } else {
                MatrixVectorMult_FDRM.multTransA_small(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
                return;
            }
        }
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH || fMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multTransA_reorder(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.multTransA_small(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multTransA(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH || fMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multTransA_reorder(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.multTransA_small(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multTransB(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numRows == 1) {
            MatrixVectorMult_FDRM.mult(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.multTransB(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multTransB(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        MatrixMatrixMult_FDRM.multTransB(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
    }

    public static void multTransAB(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numRows == 1) {
            if (fMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
                MatrixVectorMult_FDRM.multTransA_reorder(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
                return;
            } else {
                MatrixVectorMult_FDRM.multTransA_small(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
                return;
            }
        }
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multTransAB_aux(fMatrix1Row, fMatrix1Row2, fMatrix1Row3, null);
        } else {
            MatrixMatrixMult_FDRM.multTransAB(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multTransAB(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multTransAB_aux(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3, null);
        } else {
            MatrixMatrixMult_FDRM.multTransAB(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static float dot(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (!MatrixFeatures_FDRM.isVector(fMatrixD1) || !MatrixFeatures_FDRM.isVector(fMatrixD12)) {
            throw new RuntimeException("Both inputs must be vectors");
        }
        return VectorVectorMult_FDRM.innerProd(fMatrixD1, fMatrixD12);
    }

    public static void multInner(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2) {
        if (fMatrix1Row.numCols != fMatrix1Row2.numCols || fMatrix1Row.numCols != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("Rows and columns of 'c' must be the same as the columns in 'a'");
        }
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_INNER_SWITCH) {
            MatrixMultProduct_FDRM.inner_small(fMatrix1Row, fMatrix1Row2);
        } else {
            MatrixMultProduct_FDRM.inner_reorder(fMatrix1Row, fMatrix1Row2);
        }
    }

    public static void multOuter(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2) {
        if (fMatrix1Row.numRows != fMatrix1Row2.numCols || fMatrix1Row.numRows != fMatrix1Row2.numRows) {
            throw new MatrixDimensionException("Rows and columns of 'c' must be the same as the rows in 'a'");
        }
        MatrixMultProduct_FDRM.outer(fMatrix1Row, fMatrix1Row2);
    }

    public static void multAdd(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numCols == 1) {
            MatrixVectorMult_FDRM.multAdd(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else if (fMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multAdd_reorder(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.multAdd_small(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multAdd(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multAdd_reorder(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.multAdd_small(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multAddTransA(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numCols == 1) {
            if (fMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
                MatrixVectorMult_FDRM.multAddTransA_reorder(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
                return;
            } else {
                MatrixVectorMult_FDRM.multAddTransA_small(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
                return;
            }
        }
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH || fMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multAddTransA_reorder(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.multAddTransA_small(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multAddTransA(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH || fMatrix1Row2.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multAddTransA_reorder(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        } else {
            MatrixMatrixMult_FDRM.multAddTransA_small(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multAddTransB(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        MatrixMatrixMult_FDRM.multAddTransB(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
    }

    public static void multAddTransB(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        MatrixMatrixMult_FDRM.multAddTransB(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
    }

    public static void multAddTransAB(FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row2.numRows == 1) {
            if (fMatrix1Row.numCols >= EjmlParameters.MULT_COLUMN_SWITCH) {
                MatrixVectorMult_FDRM.multAddTransA_reorder(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
                return;
            } else {
                MatrixVectorMult_FDRM.multAddTransA_small(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
                return;
            }
        }
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multAddTransAB_aux(fMatrix1Row, fMatrix1Row2, fMatrix1Row3, null);
        } else {
            MatrixMatrixMult_FDRM.multAddTransAB(fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static void multAddTransAB(float f, FMatrix1Row fMatrix1Row, FMatrix1Row fMatrix1Row2, FMatrix1Row fMatrix1Row3) {
        if (fMatrix1Row.numCols >= EjmlParameters.MULT_TRANAB_COLUMN_SWITCH) {
            MatrixMatrixMult_FDRM.multAddTransAB_aux(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3, null);
        } else {
            MatrixMatrixMult_FDRM.multAddTransAB(f, fMatrix1Row, fMatrix1Row2, fMatrix1Row3);
        }
    }

    public static boolean solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        LinearSolverSafe linearSolverSafe = new LinearSolverSafe(LinearSolverFactory_FDRM.general(fMatrixRMaj.numRows, fMatrixRMaj.numCols));
        if (!linearSolverSafe.setA(fMatrixRMaj)) {
            return false;
        }
        linearSolverSafe.solve(fMatrixRMaj2, fMatrixRMaj3);
        return true;
    }

    public static void transpose(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numCols == fMatrixRMaj.numRows) {
            TransposeAlgs_FDRM.square(fMatrixRMaj);
            return;
        }
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numCols, fMatrixRMaj.numRows);
        transpose(fMatrixRMaj, fMatrixRMaj2);
        fMatrixRMaj.set((FMatrixD1) fMatrixRMaj2);
    }

    public static FMatrixRMaj transpose(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numCols, fMatrixRMaj.numRows);
        } else if (fMatrixRMaj.numRows != fMatrixRMaj2.numCols || fMatrixRMaj.numCols != fMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("Incompatible matrix dimensions");
        }
        if (fMatrixRMaj.numRows > EjmlParameters.TRANSPOSE_SWITCH && fMatrixRMaj.numCols > EjmlParameters.TRANSPOSE_SWITCH) {
            TransposeAlgs_FDRM.block(fMatrixRMaj, fMatrixRMaj2, EjmlParameters.BLOCK_WIDTH);
            return fMatrixRMaj2;
        }
        TransposeAlgs_FDRM.standard(fMatrixRMaj, fMatrixRMaj2);
        return fMatrixRMaj2;
    }

    public static float trace(FMatrix1Row fMatrix1Row) {
        int iMin = Math.min(fMatrix1Row.numRows, fMatrix1Row.numCols);
        float f = 0.0f;
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            f += fMatrix1Row.get(i);
            i += fMatrix1Row.numCols + 1;
        }
        return f;
    }

    public static float det(FMatrixRMaj fMatrixRMaj) {
        int numCols = fMatrixRMaj.getNumCols();
        if (numCols != fMatrixRMaj.getNumRows()) {
            throw new MatrixDimensionException("Must be a square matrix.");
        }
        if (numCols <= 6) {
            if (numCols >= 2) {
                return UnrolledDeterminantFromMinor_FDRM.det(fMatrixRMaj);
            }
            return fMatrixRMaj.get(0);
        }
        LUDecompositionAlt_FDRM lUDecompositionAlt_FDRM = new LUDecompositionAlt_FDRM();
        if (lUDecompositionAlt_FDRM.inputModified()) {
            fMatrixRMaj = fMatrixRMaj.copy();
        }
        if (lUDecompositionAlt_FDRM.decompose(fMatrixRMaj)) {
            return lUDecompositionAlt_FDRM.computeDeterminant().real;
        }
        return 0.0f;
    }

    public static boolean invert(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numCols <= 5) {
            if (fMatrixRMaj.numCols != fMatrixRMaj.numRows) {
                throw new MatrixDimensionException("Must be a square matrix.");
            }
            if (fMatrixRMaj.numCols >= 2) {
                UnrolledInverseFromMinor_FDRM.inv(fMatrixRMaj, fMatrixRMaj);
                return true;
            }
            fMatrixRMaj.set(0, 1.0f / fMatrixRMaj.get(0));
            return true;
        }
        LinearSolverLu_FDRM linearSolverLu_FDRM = new LinearSolverLu_FDRM(new LUDecompositionAlt_FDRM());
        if (!linearSolverLu_FDRM.setA(fMatrixRMaj)) {
            return false;
        }
        linearSolverLu_FDRM.invert(fMatrixRMaj);
        return true;
    }

    public static boolean invert(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numCols <= 5) {
            if (fMatrixRMaj.numCols != fMatrixRMaj.numRows) {
                throw new MatrixDimensionException("Must be a square matrix.");
            }
            if (fMatrixRMaj2.numCols >= 2) {
                UnrolledInverseFromMinor_FDRM.inv(fMatrixRMaj, fMatrixRMaj2);
                return true;
            }
            fMatrixRMaj2.set(0, 1.0f / fMatrixRMaj.get(0));
            return true;
        }
        LinearSolverLu_FDRM linearSolverLu_FDRM = new LinearSolverLu_FDRM(new LUDecompositionAlt_FDRM());
        if (linearSolverLu_FDRM.modifiesA()) {
            fMatrixRMaj = fMatrixRMaj.copy();
        }
        if (!linearSolverLu_FDRM.setA(fMatrixRMaj)) {
            return false;
        }
        linearSolverLu_FDRM.invert(fMatrixRMaj2);
        return true;
    }

    public static void pinv(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        LinearSolverDense<FMatrixRMaj> linearSolverDensePseudoInverse = LinearSolverFactory_FDRM.pseudoInverse(true);
        if (linearSolverDensePseudoInverse.modifiesA()) {
            fMatrixRMaj = fMatrixRMaj.copy();
        }
        if (!linearSolverDensePseudoInverse.setA(fMatrixRMaj)) {
            throw new IllegalArgumentException("Invert failed, maybe a bug?");
        }
        linearSolverDensePseudoInverse.invert(fMatrixRMaj2);
    }

    public static FMatrixRMaj[] columnsToVector(FMatrixRMaj fMatrixRMaj, FMatrixRMaj[] fMatrixRMajArr) {
        if (fMatrixRMajArr == null || fMatrixRMajArr.length < fMatrixRMaj.numCols) {
            fMatrixRMajArr = new FMatrixRMaj[fMatrixRMaj.numCols];
        }
        for (int i = 0; i < fMatrixRMajArr.length; i++) {
            FMatrixRMaj fMatrixRMaj2 = fMatrixRMajArr[i];
            if (fMatrixRMaj2 == null) {
                fMatrixRMajArr[i] = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
            } else {
                fMatrixRMaj2.reshape(fMatrixRMaj.numRows, 1, false);
            }
            FMatrixRMaj fMatrixRMaj3 = fMatrixRMajArr[i];
            for (int i2 = 0; i2 < fMatrixRMaj.numRows; i2++) {
                fMatrixRMaj3.set(i2, 0, fMatrixRMaj.get(i2, i));
            }
        }
        return fMatrixRMajArr;
    }

    public static FMatrixRMaj[] rowsToVector(FMatrixRMaj fMatrixRMaj, FMatrixRMaj[] fMatrixRMajArr) {
        if (fMatrixRMajArr == null || fMatrixRMajArr.length < fMatrixRMaj.numRows) {
            fMatrixRMajArr = new FMatrixRMaj[fMatrixRMaj.numRows];
        }
        for (int i = 0; i < fMatrixRMajArr.length; i++) {
            FMatrixRMaj fMatrixRMaj2 = fMatrixRMajArr[i];
            if (fMatrixRMaj2 == null) {
                fMatrixRMajArr[i] = new FMatrixRMaj(fMatrixRMaj.numCols, 1);
            } else {
                fMatrixRMaj2.reshape(fMatrixRMaj.numCols, 1, false);
            }
            FMatrixRMaj fMatrixRMaj3 = fMatrixRMajArr[i];
            for (int i2 = 0; i2 < fMatrixRMaj.numCols; i2++) {
                fMatrixRMaj3.set(i2, 0, fMatrixRMaj.get(i, i2));
            }
        }
        return fMatrixRMajArr;
    }

    public static void setIdentity(FMatrix1Row fMatrix1Row) {
        int i = fMatrix1Row.numRows < fMatrix1Row.numCols ? fMatrix1Row.numRows : fMatrix1Row.numCols;
        int i2 = 0;
        Arrays.fill(fMatrix1Row.data, 0, fMatrix1Row.getNumElements(), 0.0f);
        int i3 = 0;
        while (i2 < i) {
            fMatrix1Row.data[i3] = 1.0f;
            i2++;
            i3 += fMatrix1Row.numCols + 1;
        }
    }

    public static FMatrixRMaj identity(int i) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i);
        for (int i2 = 0; i2 < i; i2++) {
            fMatrixRMaj.set(i2, i2, 1.0f);
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj identity(int i, int i2) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        if (i >= i2) {
            i = i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            fMatrixRMaj.set(i3, i3, 1.0f);
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj diag(float... fArr) {
        return diag(null, fArr.length, fArr);
    }

    public static FMatrixRMaj diag(FMatrixRMaj fMatrixRMaj, int i, float... fArr) {
        if (fMatrixRMaj == null) {
            fMatrixRMaj = new FMatrixRMaj(i, i);
        } else {
            if (fMatrixRMaj.numRows != i || fMatrixRMaj.numCols != i) {
                throw new IllegalArgumentException("Unexpected matrix size");
            }
            fill(fMatrixRMaj, 0.0f);
        }
        for (int i2 = 0; i2 < i; i2++) {
            fMatrixRMaj.unsafe_set(i2, i2, fArr[i2]);
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj diagR(int i, int i2, float... fArr) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i2);
        int iMin = Math.min(i, i2);
        for (int i3 = 0; i3 < iMin; i3++) {
            fMatrixRMaj.set(i3, i3, fArr[i3]);
        }
        return fMatrixRMaj;
    }

    public static void kron(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, FMatrixRMaj fMatrixRMaj3) {
        int i = fMatrixRMaj.numCols * fMatrixRMaj2.numCols;
        int i2 = fMatrixRMaj.numRows * fMatrixRMaj2.numRows;
        if (fMatrixRMaj3.numCols != i || fMatrixRMaj3.numRows != i2) {
            throw new MatrixDimensionException("C does not have the expected dimensions");
        }
        for (int i3 = 0; i3 < fMatrixRMaj.numRows; i3++) {
            for (int i4 = 0; i4 < fMatrixRMaj.numCols; i4++) {
                float f = fMatrixRMaj.get(i3, i4);
                for (int i5 = 0; i5 < fMatrixRMaj2.numRows; i5++) {
                    for (int i6 = 0; i6 < fMatrixRMaj2.numCols; i6++) {
                        fMatrixRMaj3.set((fMatrixRMaj2.numRows * i3) + i5, (fMatrixRMaj2.numCols * i4) + i6, fMatrixRMaj2.get(i5, i6) * f);
                    }
                }
            }
        }
    }

    public static void extract(FMatrix fMatrix, int i, int i2, int i3, int i4, FMatrix fMatrix2, int i5, int i6) {
        if (i2 < i || i < 0 || i2 > fMatrix.getNumRows()) {
            throw new MatrixDimensionException("srcY1 < srcY0 || srcY0 < 0 || srcY1 > src.numRows");
        }
        if (i4 < i3 || i3 < 0 || i4 > fMatrix.getNumCols()) {
            throw new MatrixDimensionException("srcX1 < srcX0 || srcX0 < 0 || srcX1 > src.numCols");
        }
        int i7 = i4 - i3;
        int i8 = i2 - i;
        if (i5 + i8 > fMatrix2.getNumRows()) {
            throw new MatrixDimensionException("dst is too small in rows");
        }
        if (i6 + i7 > fMatrix2.getNumCols()) {
            throw new MatrixDimensionException("dst is too small in columns");
        }
        if ((fMatrix instanceof FMatrixRMaj) && (fMatrix2 instanceof FMatrixRMaj)) {
            ImplCommonOps_FDRM.extract((FMatrixRMaj) fMatrix, i, i3, (FMatrixRMaj) fMatrix2, i5, i6, i8, i7);
        } else {
            ImplCommonOps_FDMA.extract(fMatrix, i, i3, fMatrix2, i5, i6, i8, i7);
        }
    }

    public static FMatrixRMaj extract(FMatrixRMaj fMatrixRMaj, int i, int i2, int i3, int i4) {
        if (i2 <= i || i < 0 || i2 > fMatrixRMaj.numRows) {
            throw new MatrixDimensionException("srcY1 <= srcY0 || srcY0 < 0 || srcY1 > src.numRows");
        }
        if (i4 <= i3 || i3 < 0 || i4 > fMatrixRMaj.numCols) {
            throw new MatrixDimensionException("srcX1 <= srcX0 || srcX0 < 0 || srcX1 > src.numCols");
        }
        int i5 = i4 - i3;
        int i6 = i2 - i;
        FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(i6, i5);
        ImplCommonOps_FDRM.extract(fMatrixRMaj, i, i3, fMatrixRMaj2, 0, 0, i6, i5);
        return fMatrixRMaj2;
    }

    public static void extract(FMatrixRMaj fMatrixRMaj, int[] iArr, int i, int[] iArr2, int i2, FMatrixRMaj fMatrixRMaj2) {
        if (i != fMatrixRMaj2.numRows || i2 != fMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("Unexpected number of rows and/or columns in dst matrix");
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = fMatrixRMaj.numCols * iArr[i4];
            int i6 = 0;
            while (i6 < i2) {
                fMatrixRMaj2.data[i3] = fMatrixRMaj.data[iArr2[i6] + i5];
                i6++;
                i3++;
            }
        }
    }

    public static void extract(FMatrixRMaj fMatrixRMaj, int[] iArr, int i, FMatrixRMaj fMatrixRMaj2) {
        if (!MatrixFeatures_FDRM.isVector(fMatrixRMaj2)) {
            throw new MatrixDimensionException("Dst must be a vector");
        }
        if (i != fMatrixRMaj2.getNumElements()) {
            throw new MatrixDimensionException("Unexpected number of elements in dst vector");
        }
        for (int i2 = 0; i2 < i; i2++) {
            fMatrixRMaj2.data[i2] = fMatrixRMaj.data[iArr[i2]];
        }
    }

    public static void insert(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, int[] iArr, int i, int[] iArr2, int i2) {
        if (i != fMatrixRMaj.numRows || i2 != fMatrixRMaj.numCols) {
            throw new MatrixDimensionException("Unexpected number of rows and/or columns in dst matrix");
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = fMatrixRMaj2.numCols * iArr[i4];
            int i6 = 0;
            while (i6 < i2) {
                fMatrixRMaj2.data[iArr2[i6] + i5] = fMatrixRMaj.data[i3];
                i6++;
                i3++;
            }
        }
    }

    public static void extractDiag(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        int iMin = Math.min(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        if (!MatrixFeatures_FDRM.isVector(fMatrixRMaj2)) {
            throw new MatrixDimensionException("Expected a vector for dst.");
        }
        if (fMatrixRMaj2.getNumElements() != iMin) {
            throw new MatrixDimensionException("Expected " + iMin + " elements in dst.");
        }
        for (int i = 0; i < iMin; i++) {
            fMatrixRMaj2.set(i, fMatrixRMaj.unsafe_get(i, i));
        }
    }

    public static FMatrixRMaj extractRow(FMatrixRMaj fMatrixRMaj, int i, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(1, fMatrixRMaj.numCols);
        } else if (!MatrixFeatures_FDRM.isVector(fMatrixRMaj2) || fMatrixRMaj2.getNumElements() != fMatrixRMaj.numCols) {
            throw new MatrixDimensionException("Output must be a vector of length " + fMatrixRMaj.numCols);
        }
        System.arraycopy(fMatrixRMaj.data, fMatrixRMaj.getIndex(i, 0), fMatrixRMaj2.data, 0, fMatrixRMaj.numCols);
        return fMatrixRMaj2;
    }

    public static FMatrixRMaj extractColumn(FMatrixRMaj fMatrixRMaj, int i, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
        } else if (!MatrixFeatures_FDRM.isVector(fMatrixRMaj2) || fMatrixRMaj2.getNumElements() != fMatrixRMaj.numRows) {
            throw new MatrixDimensionException("Output must be a vector of length " + fMatrixRMaj.numRows);
        }
        int i2 = 0;
        while (i2 < fMatrixRMaj.numRows) {
            fMatrixRMaj2.data[i2] = fMatrixRMaj.data[i];
            i2++;
            i += fMatrixRMaj.numCols;
        }
        return fMatrixRMaj2;
    }

    public static void insert(FMatrix fMatrix, FMatrix fMatrix2, int i, int i2) {
        extract(fMatrix, 0, fMatrix.getNumRows(), 0, fMatrix.getNumCols(), fMatrix2, i, i2);
    }

    public static float elementMax(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        float f = fMatrixD1.get(0);
        for (int i = 1; i < numElements; i++) {
            float f2 = fMatrixD1.get(i);
            if (f2 >= f) {
                f = f2;
            }
        }
        return f;
    }

    public static float elementMaxAbs(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        float f = 0.0f;
        for (int i = 0; i < numElements; i++) {
            float fAbs = Math.abs(fMatrixD1.get(i));
            if (fAbs > f) {
                f = fAbs;
            }
        }
        return f;
    }

    public static float elementMin(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        float f = fMatrixD1.get(0);
        for (int i = 1; i < numElements; i++) {
            float f2 = fMatrixD1.get(i);
            if (f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static float elementMinAbs(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        float f = Float.MAX_VALUE;
        for (int i = 0; i < numElements; i++) {
            float fAbs = Math.abs(fMatrixD1.get(i));
            if (fAbs < f) {
                f = fAbs;
            }
        }
        return f;
    }

    public static void elementMult(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD1.times(i, fMatrixD12.get(i));
        }
    }

    public static void elementMult(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numRows != fMatrixD13.numRows || fMatrixD1.numCols != fMatrixD13.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD13.set(i, fMatrixD1.get(i) * fMatrixD12.get(i));
        }
    }

    public static void elementDiv(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD1.div(i, fMatrixD12.get(i));
        }
    }

    public static void elementDiv(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numRows != fMatrixD13.numRows || fMatrixD1.numCols != fMatrixD13.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD13.set(i, fMatrixD1.get(i) / fMatrixD12.get(i));
        }
    }

    public static float elementSum(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        float f = 0.0f;
        for (int i = 0; i < numElements; i++) {
            f += fMatrixD1.get(i);
        }
        return f;
    }

    public static float elementSumAbs(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        float fAbs = 0.0f;
        for (int i = 0; i < numElements; i++) {
            fAbs += Math.abs(fMatrixD1.get(i));
        }
        return fAbs;
    }

    public static void elementPower(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numRows != fMatrixD13.numRows || fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numCols != fMatrixD13.numCols) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD13.data[i] = (float) Math.pow(fMatrixD1.data[i], fMatrixD12.data[i]);
        }
    }

    public static void elementPower(float f, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = (float) Math.pow(f, fMatrixD1.data[i]);
        }
    }

    public static void elementPower(FMatrixD1 fMatrixD1, float f, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = (float) Math.pow(fMatrixD1.data[i], f);
        }
    }

    public static void elementLog(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = (float) Math.log(fMatrixD1.data[i]);
        }
    }

    public static void elementExp(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows) {
            throw new MatrixDimensionException("All matrices must be the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = (float) Math.exp(fMatrixD1.data[i]);
        }
    }

    public static FMatrixRMaj sumRows(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
        } else {
            fMatrixRMaj2.reshape(fMatrixRMaj.numRows, 1);
        }
        int i = 0;
        while (i < fMatrixRMaj.numRows) {
            int i2 = i + 1;
            int i3 = fMatrixRMaj.numCols * i2;
            float f = 0.0f;
            for (int i4 = fMatrixRMaj.numCols * i; i4 < i3; i4++) {
                f += fMatrixRMaj.data[i4];
            }
            fMatrixRMaj2.set(i, f);
            i = i2;
        }
        return fMatrixRMaj2;
    }

    public static FMatrixRMaj minRows(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
        } else {
            fMatrixRMaj2.reshape(fMatrixRMaj.numRows, 1);
        }
        int i = 0;
        while (i < fMatrixRMaj.numRows) {
            int i2 = i + 1;
            int i3 = fMatrixRMaj.numCols * i2;
            float f = Float.MAX_VALUE;
            for (int i4 = fMatrixRMaj.numCols * i; i4 < i3; i4++) {
                float f2 = fMatrixRMaj.data[i4];
                if (f2 < f) {
                    f = f2;
                }
            }
            fMatrixRMaj2.set(i, f);
            i = i2;
        }
        return fMatrixRMaj2;
    }

    public static FMatrixRMaj maxRows(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
        } else {
            fMatrixRMaj2.reshape(fMatrixRMaj.numRows, 1);
        }
        int i = 0;
        while (i < fMatrixRMaj.numRows) {
            int i2 = i + 1;
            int i3 = fMatrixRMaj.numCols * i2;
            float f = -3.4028235E38f;
            for (int i4 = fMatrixRMaj.numCols * i; i4 < i3; i4++) {
                float f2 = fMatrixRMaj.data[i4];
                if (f2 > f) {
                    f = f2;
                }
            }
            fMatrixRMaj2.set(i, f);
            i = i2;
        }
        return fMatrixRMaj2;
    }

    public static FMatrixRMaj sumCols(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(1, fMatrixRMaj.numCols);
        } else {
            fMatrixRMaj2.reshape(1, fMatrixRMaj.numCols);
        }
        for (int i = 0; i < fMatrixRMaj.numCols; i++) {
            int i2 = (fMatrixRMaj.numCols * fMatrixRMaj.numRows) + i;
            float f = 0.0f;
            int i3 = i;
            while (i3 < i2) {
                f += fMatrixRMaj.data[i3];
                i3 += fMatrixRMaj.numCols;
            }
            fMatrixRMaj2.set(i, f);
        }
        return fMatrixRMaj2;
    }

    public static FMatrixRMaj minCols(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(1, fMatrixRMaj.numCols);
        } else {
            fMatrixRMaj2.reshape(1, fMatrixRMaj.numCols);
        }
        for (int i = 0; i < fMatrixRMaj.numCols; i++) {
            int i2 = (fMatrixRMaj.numCols * fMatrixRMaj.numRows) + i;
            float f = Float.MAX_VALUE;
            int i3 = i;
            while (i3 < i2) {
                float f2 = fMatrixRMaj.data[i3];
                if (f2 < f) {
                    f = f2;
                }
                i3 += fMatrixRMaj.numCols;
            }
            fMatrixRMaj2.set(i, f);
        }
        return fMatrixRMaj2;
    }

    public static FMatrixRMaj maxCols(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(1, fMatrixRMaj.numCols);
        } else {
            fMatrixRMaj2.reshape(1, fMatrixRMaj.numCols);
        }
        for (int i = 0; i < fMatrixRMaj.numCols; i++) {
            int i2 = (fMatrixRMaj.numCols * fMatrixRMaj.numRows) + i;
            float f = -3.4028235E38f;
            int i3 = i;
            while (i3 < i2) {
                float f2 = fMatrixRMaj.data[i3];
                if (f2 > f) {
                    f = f2;
                }
                i3 += fMatrixRMaj.numCols;
            }
            fMatrixRMaj2.set(i, f);
        }
        return fMatrixRMaj2;
    }

    public static void addEquals(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD1.plus(i, fMatrixD12.get(i));
        }
    }

    public static void addEquals(FMatrixD1 fMatrixD1, float f, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD1.plus(i, fMatrixD12.get(i) * f);
        }
    }

    public static void add(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD13.numCols || fMatrixD1.numRows != fMatrixD13.numRows) {
            throw new MatrixDimensionException("The matrices are not all the same dimension.");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD13.set(i, fMatrixD1.get(i) + fMatrixD12.get(i));
        }
    }

    public static void add(FMatrixD1 fMatrixD1, float f, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD13.numCols || fMatrixD1.numRows != fMatrixD13.numRows) {
            throw new MatrixDimensionException("The matrices are not all the same dimension.");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD13.set(i, fMatrixD1.get(i) + (fMatrixD12.get(i) * f));
        }
    }

    public static void add(float f, FMatrixD1 fMatrixD1, float f2, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD13.numCols || fMatrixD1.numRows != fMatrixD13.numRows) {
            throw new MatrixDimensionException("The matrices are not all the same dimension.");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD13.set(i, (fMatrixD1.get(i) * f) + (fMatrixD12.get(i) * f2));
        }
    }

    public static void add(float f, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD13.numCols || fMatrixD1.numRows != fMatrixD13.numRows) {
            throw new MatrixDimensionException("The matrices are not all the same dimension.");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD13.set(i, (fMatrixD1.get(i) * f) + fMatrixD12.get(i));
        }
    }

    public static void add(FMatrixD1 fMatrixD1, float f) {
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD1.plus(i, f);
        }
    }

    public static void add(FMatrixD1 fMatrixD1, float f, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("Dimensions of a and c do not match.");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = fMatrixD1.data[i] + f;
        }
    }

    public static void subtract(FMatrixD1 fMatrixD1, float f, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("Dimensions of a and c do not match.");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = fMatrixD1.data[i] - f;
        }
    }

    public static void subtract(float f, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("Dimensions of a and c do not match.");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = f - fMatrixD1.data[i];
        }
    }

    public static void subtractEquals(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            float[] fArr = fMatrixD1.data;
            fArr[i] = fArr[i] - fMatrixD12.data[i];
        }
    }

    public static void subtract(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, FMatrixD1 fMatrixD13) {
        if (fMatrixD1.numCols != fMatrixD12.numCols || fMatrixD1.numRows != fMatrixD12.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD13.data[i] = fMatrixD1.data[i] - fMatrixD12.data[i];
        }
    }

    public static void scale(float f, FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            float[] fArr = fMatrixD1.data;
            fArr[i] = fArr[i] * f;
        }
    }

    public static void scale(float f, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("Matrices must have the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = fMatrixD1.data[i] * f;
        }
    }

    public static void divide(float f, FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD1.data[i] = f / fMatrixD1.data[i];
        }
    }

    public static void divide(FMatrixD1 fMatrixD1, float f) {
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            float[] fArr = fMatrixD1.data;
            fArr[i] = fArr[i] / f;
        }
    }

    public static void divide(float f, FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("Matrices must have the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = f / fMatrixD1.data[i];
        }
    }

    public static void divide(FMatrixD1 fMatrixD1, float f, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("Matrices must have the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = fMatrixD1.data[i] / f;
        }
    }

    public static void changeSign(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD1.data[i] = -fMatrixD1.data[i];
        }
    }

    public static void changeSign(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new MatrixDimensionException("Matrices must have the same shape");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixD12.data[i] = -fMatrixD1.data[i];
        }
    }

    public static void fill(FMatrixD1 fMatrixD1, float f) {
        Arrays.fill(fMatrixD1.data, 0, fMatrixD1.getNumElements(), f);
    }

    public static FMatrixRMaj rref(FMatrixRMaj fMatrixRMaj, int i, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        } else if (fMatrixRMaj2.numCols != fMatrixRMaj.numCols || fMatrixRMaj2.numRows != fMatrixRMaj.numRows) {
            throw new MatrixDimensionException("'re' must have the same shape as the original input matrix");
        }
        if (i <= 0) {
            i = Math.min(fMatrixRMaj.numCols, fMatrixRMaj.numRows);
        }
        RrefGaussJordanRowPivot_FDRM rrefGaussJordanRowPivot_FDRM = new RrefGaussJordanRowPivot_FDRM();
        rrefGaussJordanRowPivot_FDRM.setTolerance(elementMaxAbs(fMatrixRMaj) * UtilEjml.F_EPS * Math.max(fMatrixRMaj.numRows, fMatrixRMaj.numCols));
        fMatrixRMaj2.set((FMatrixD1) fMatrixRMaj);
        rrefGaussJordanRowPivot_FDRM.reduce(fMatrixRMaj2, i);
        return fMatrixRMaj2;
    }

    public static BMatrixRMaj elementLessThan(FMatrixRMaj fMatrixRMaj, float f, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = fMatrixRMaj.data[i] < f;
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementLessThanOrEqual(FMatrixRMaj fMatrixRMaj, float f, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = fMatrixRMaj.data[i] <= f;
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementMoreThan(FMatrixRMaj fMatrixRMaj, float f, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = fMatrixRMaj.data[i] > f;
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementMoreThanOrEqual(FMatrixRMaj fMatrixRMaj, float f, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = fMatrixRMaj.data[i] >= f;
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementLessThan(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = fMatrixRMaj.data[i] < fMatrixRMaj2.data[i];
        }
        return bMatrixRMaj;
    }

    public static BMatrixRMaj elementLessThanOrEqual(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj == null) {
            bMatrixRMaj = new BMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        bMatrixRMaj.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            bMatrixRMaj.data[i] = fMatrixRMaj.data[i] <= fMatrixRMaj2.data[i];
        }
        return bMatrixRMaj;
    }

    public static FMatrixRMaj elements(FMatrixRMaj fMatrixRMaj, BMatrixRMaj bMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numRows != bMatrixRMaj.numRows || fMatrixRMaj.numCols != bMatrixRMaj.numCols) {
            throw new MatrixDimensionException("Input matrices must have the same shape");
        }
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(1, 1);
        }
        fMatrixRMaj2.reshape(countTrue(bMatrixRMaj), 1);
        int numElements = fMatrixRMaj.getNumElements();
        int i = 0;
        for (int i2 = 0; i2 < numElements; i2++) {
            if (bMatrixRMaj.data[i2]) {
                fMatrixRMaj2.data[i] = fMatrixRMaj.data[i2];
                i++;
            }
        }
        return fMatrixRMaj2;
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

    public static FMatrixRMaj concatColumns(FMatrixRMaj... fMatrixRMajArr) {
        int iMax = 0;
        int i = 0;
        for (int i2 = 0; i2 < fMatrixRMajArr.length; i2++) {
            iMax = Math.max(iMax, fMatrixRMajArr[i2].numRows);
            i += fMatrixRMajArr[i2].numCols;
        }
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(iMax, i);
        int i3 = 0;
        for (int i4 = 0; i4 < fMatrixRMajArr.length; i4++) {
            insert(fMatrixRMajArr[i4], fMatrixRMaj, 0, i3);
            i3 += fMatrixRMajArr[i4].numCols;
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj concatRows(FMatrixRMaj... fMatrixRMajArr) {
        int i = 0;
        int iMax = 0;
        for (int i2 = 0; i2 < fMatrixRMajArr.length; i2++) {
            i += fMatrixRMajArr[i2].numRows;
            iMax = Math.max(iMax, fMatrixRMajArr[i2].numCols);
        }
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, iMax);
        int i3 = 0;
        for (int i4 = 0; i4 < fMatrixRMajArr.length; i4++) {
            insert(fMatrixRMajArr[i4], fMatrixRMaj, i3, 0);
            i3 += fMatrixRMajArr[i4].numRows;
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj permuteRowInv(int[] iArr, FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numRows > iArr.length) {
            throw new MatrixDimensionException("permutation vector must have at least as many elements as input has rows");
        }
        if (fMatrixRMaj2 == null) {
            fMatrixRMaj2 = new FMatrixRMaj(1, 1);
        }
        fMatrixRMaj2.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        int i = fMatrixRMaj.numCols;
        for (int i2 = 0; i2 < fMatrixRMaj.numRows; i2++) {
            System.arraycopy(fMatrixRMaj.data, i2 * i, fMatrixRMaj2.data, iArr[i2] * i, i);
        }
        return fMatrixRMaj2;
    }
}
