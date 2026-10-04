package org.ejml.dense.row;

import org.ejml.UtilEjml;
import org.ejml.data.BMatrixRMaj;
import org.ejml.data.FMatrix;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionInner_FDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.dense.row.mult.VectorVectorMult_FDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F32;
import org.ejml.interfaces.decomposition.LUDecomposition_F32;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_FDRM {
    public static boolean hasNaN(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (Float.isNaN(fMatrixD1.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasUncountable(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            float f = fMatrixD1.get(i);
            if (Float.isNaN(f) || Float.isInfinite(f)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isZeros(FMatrixD1 fMatrixD1, float f) {
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (Math.abs(fMatrixD1.get(i)) > f) {
                return false;
            }
        }
        return true;
    }

    public static boolean isVector(Matrix matrix) {
        return matrix.getNumCols() == 1 || matrix.getNumRows() == 1;
    }

    public static boolean isPositiveDefinite(FMatrixRMaj fMatrixRMaj) {
        if (!isSquare(fMatrixRMaj)) {
            return false;
        }
        CholeskyDecompositionInner_FDRM choleskyDecompositionInner_FDRM = new CholeskyDecompositionInner_FDRM(true);
        if (choleskyDecompositionInner_FDRM.inputModified()) {
            fMatrixRMaj = fMatrixRMaj.copy();
        }
        return choleskyDecompositionInner_FDRM.decompose(fMatrixRMaj);
    }

    public static boolean isPositiveSemidefinite(FMatrixRMaj fMatrixRMaj) {
        if (!isSquare(fMatrixRMaj)) {
            return false;
        }
        EigenDecomposition_F32<FMatrixRMaj> eigenDecomposition_F32Eig = DecompositionFactory_FDRM.eig(fMatrixRMaj.numCols, false);
        if (eigenDecomposition_F32Eig.inputModified()) {
            fMatrixRMaj = fMatrixRMaj.copy();
        }
        eigenDecomposition_F32Eig.decompose(fMatrixRMaj);
        for (int i = 0; i < fMatrixRMaj.numRows; i++) {
            if (eigenDecomposition_F32Eig.getEigenvalue(i).getReal() < 0.0f) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSquare(FMatrixD1 fMatrixD1) {
        return fMatrixD1.numCols == fMatrixD1.numRows;
    }

    public static boolean isSymmetric(FMatrixRMaj fMatrixRMaj, float f) {
        if (fMatrixRMaj.numCols != fMatrixRMaj.numRows) {
            return false;
        }
        float fElementMaxAbs = CommonOps_FDRM.elementMaxAbs(fMatrixRMaj);
        for (int i = 0; i < fMatrixRMaj.numRows; i++) {
            for (int i2 = 0; i2 < i; i2++) {
                if (Math.abs((fMatrixRMaj.get(i, i2) / fElementMaxAbs) - (fMatrixRMaj.get(i2, i) / fElementMaxAbs)) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSymmetric(FMatrixRMaj fMatrixRMaj) {
        return isSymmetric(fMatrixRMaj, 0.0f);
    }

    public static boolean isSkewSymmetric(FMatrixRMaj fMatrixRMaj, float f) {
        if (fMatrixRMaj.numCols != fMatrixRMaj.numRows) {
            return false;
        }
        for (int i = 0; i < fMatrixRMaj.numRows; i++) {
            for (int i2 = 0; i2 < i; i2++) {
                if (Math.abs(fMatrixRMaj.get(i, i2) + fMatrixRMaj.get(i2, i)) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isInverse(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2, float f) {
        if (fMatrixRMaj.numRows != fMatrixRMaj2.numRows || fMatrixRMaj.numCols != fMatrixRMaj2.numCols) {
            return false;
        }
        int i = fMatrixRMaj.numRows;
        int i2 = fMatrixRMaj.numCols;
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                float f2 = 0.0f;
                for (int i5 = 0; i5 < i2; i5++) {
                    f2 += fMatrixRMaj.get(i3, i5) * fMatrixRMaj2.get(i5, i4);
                }
                if (i3 == i4) {
                    if (Math.abs(f2 - 1.0f) > f) {
                        return false;
                    }
                } else if (Math.abs(f2) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEquals(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, float f) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            return false;
        }
        if (f == 0.0f) {
            return isEquals(fMatrixD1, fMatrixD12);
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (f < Math.abs(fMatrixD1.get(i) - fMatrixD12.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqualsTriangle(FMatrix fMatrix, FMatrix fMatrix2, boolean z, float f) {
        if (fMatrix.getNumRows() != fMatrix2.getNumRows() || fMatrix.getNumCols() != fMatrix2.getNumCols()) {
            return false;
        }
        if (z) {
            for (int i = 0; i < fMatrix.getNumRows(); i++) {
                for (int i2 = i; i2 < fMatrix.getNumCols(); i2++) {
                    if (Math.abs(fMatrix.get(i, i2) - fMatrix2.get(i, i2)) > f) {
                        return false;
                    }
                }
            }
        } else {
            for (int i3 = 0; i3 < fMatrix.getNumRows(); i3++) {
                int iMin = Math.min(i3, fMatrix.getNumCols() - 1);
                for (int i4 = 0; i4 <= iMin; i4++) {
                    if (Math.abs(fMatrix.get(i3, i4) - fMatrix2.get(i3, i4)) > f) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isEquals(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            return false;
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (fMatrixD1.get(i) != fMatrixD12.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEquals(BMatrixRMaj bMatrixRMaj, BMatrixRMaj bMatrixRMaj2) {
        if (bMatrixRMaj.numRows != bMatrixRMaj2.numRows || bMatrixRMaj.numCols != bMatrixRMaj2.numCols) {
            return false;
        }
        int numElements = bMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (bMatrixRMaj.get(i) != bMatrixRMaj2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIdentical(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, float f) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            return false;
        }
        if (f < 0.0f) {
            throw new IllegalArgumentException("Tolerance must be greater than or equal to zero.");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (!UtilEjml.isIdentical(fMatrixD1.get(i), fMatrixD12.get(i), f)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOrthogonal(FMatrixRMaj fMatrixRMaj, float f) {
        if (fMatrixRMaj.numRows < fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("The number of rows must be more than or equal to the number of columns");
        }
        FMatrixRMaj[] fMatrixRMajArrColumnsToVector = CommonOps_FDRM.columnsToVector(fMatrixRMaj, null);
        int i = 0;
        while (i < fMatrixRMajArrColumnsToVector.length) {
            FMatrixRMaj fMatrixRMaj2 = fMatrixRMajArrColumnsToVector[i];
            i++;
            for (int i2 = i; i2 < fMatrixRMajArrColumnsToVector.length; i2++) {
                if (Math.abs(VectorVectorMult_FDRM.innerProd(fMatrixRMaj2, fMatrixRMajArrColumnsToVector[i2])) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isRowsLinearIndependent(FMatrixRMaj fMatrixRMaj) {
        LUDecomposition_F32<FMatrixRMaj> lUDecomposition_F32M1669lu = DecompositionFactory_FDRM.m1669lu(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        if (lUDecomposition_F32M1669lu.inputModified()) {
            fMatrixRMaj = fMatrixRMaj.copy();
        }
        if (!lUDecomposition_F32M1669lu.decompose(fMatrixRMaj)) {
            throw new RuntimeException("Decompositon failed?");
        }
        return !lUDecomposition_F32M1669lu.isSingular();
    }

    public static boolean isIdentity(FMatrixRMaj fMatrixRMaj, float f) {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrixRMaj.numRows; i3++) {
            for (int i4 = 0; i4 < fMatrixRMaj.numCols; i4++) {
                if (i3 == i4) {
                    i = i2 + 1;
                    if (Math.abs(fMatrixRMaj.get(i2) - 1.0f) > f) {
                        return false;
                    }
                } else {
                    i = i2 + 1;
                    if (Math.abs(fMatrixRMaj.get(i2)) > f) {
                        return false;
                    }
                }
                i2 = i;
            }
        }
        return true;
    }

    public static boolean isConstantVal(FMatrixRMaj fMatrixRMaj, float f, float f2) {
        int i = 0;
        for (int i2 = 0; i2 < fMatrixRMaj.numRows; i2++) {
            int i3 = 0;
            while (i3 < fMatrixRMaj.numCols) {
                int i4 = i + 1;
                if (Math.abs(fMatrixRMaj.get(i) - f) > f2) {
                    return false;
                }
                i3++;
                i = i4;
            }
        }
        return true;
    }

    public static boolean isDiagonalPositive(FMatrixRMaj fMatrixRMaj) {
        for (int i = 0; i < fMatrixRMaj.numRows; i++) {
            if (fMatrixRMaj.get(i, i) < 0.0f) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFullRank(FMatrixRMaj fMatrixRMaj) {
        throw new RuntimeException("Implement");
    }

    public static boolean isNegative(FMatrixD1 fMatrixD1, FMatrixD1 fMatrixD12, float f) {
        if (fMatrixD1.numRows != fMatrixD12.numRows || fMatrixD1.numCols != fMatrixD12.numCols) {
            throw new IllegalArgumentException("Matrix dimensions must match");
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (Math.abs(fMatrixD1.get(i) + fMatrixD12.get(i)) > f) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUpperTriangle(FMatrixRMaj fMatrixRMaj, int i, float f) {
        for (int i2 = i + 1; i2 < fMatrixRMaj.numRows; i2++) {
            int iMin = Math.min(i2 - i, fMatrixRMaj.numCols);
            for (int i3 = 0; i3 < iMin; i3++) {
                if (Math.abs(fMatrixRMaj.unsafe_get(i2, i3)) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLowerTriangle(FMatrixRMaj fMatrixRMaj, int i, float f) {
        for (int i2 = 0; i2 < (fMatrixRMaj.numRows - i) - 1; i2++) {
            for (int i3 = i2 + i + 1; i3 < fMatrixRMaj.numCols; i3++) {
                if (Math.abs(fMatrixRMaj.unsafe_get(i2, i3)) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int rank(FMatrixRMaj fMatrixRMaj) {
        return rank(fMatrixRMaj, UtilEjml.F_EPS * 100.0f);
    }

    public static int rank(FMatrixRMaj fMatrixRMaj, float f) {
        SingularValueDecomposition_F32<FMatrixRMaj> singularValueDecomposition_F32Svd = DecompositionFactory_FDRM.svd(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false, false, true);
        if (singularValueDecomposition_F32Svd.inputModified()) {
            fMatrixRMaj = fMatrixRMaj.copy();
        }
        if (!singularValueDecomposition_F32Svd.decompose(fMatrixRMaj)) {
            throw new RuntimeException("Decomposition failed");
        }
        return SingularOps_FDRM.rank(singularValueDecomposition_F32Svd, f);
    }

    public static int nullity(FMatrixRMaj fMatrixRMaj) {
        return nullity(fMatrixRMaj, UtilEjml.F_EPS * 100.0f);
    }

    public static int nullity(FMatrixRMaj fMatrixRMaj, float f) {
        SingularValueDecomposition_F32<FMatrixRMaj> singularValueDecomposition_F32Svd = DecompositionFactory_FDRM.svd(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false, false, true);
        if (singularValueDecomposition_F32Svd.inputModified()) {
            fMatrixRMaj = fMatrixRMaj.copy();
        }
        if (!singularValueDecomposition_F32Svd.decompose(fMatrixRMaj)) {
            throw new RuntimeException("Decomposition failed");
        }
        return SingularOps_FDRM.nullity(singularValueDecomposition_F32Svd, f);
    }

    public static int countNonZero(FMatrixRMaj fMatrixRMaj) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < fMatrixRMaj.numRows; i3++) {
            int i4 = 0;
            while (i4 < fMatrixRMaj.numCols) {
                if (fMatrixRMaj.data[i2] != 0.0f) {
                    i++;
                }
                i4++;
                i2++;
            }
        }
        return i;
    }
}
