package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.BMatrixRMaj;
import org.ejml.data.DMatrix;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionInner_DDRM;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.dense.row.mult.VectorVectorMult_DDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;
import org.ejml.interfaces.decomposition.LUDecomposition_F64;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_DDRM {
    public static boolean hasNaN(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (Double.isNaN(dMatrixD1.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasUncountable(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            double d = dMatrixD1.get(i);
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isZeros(DMatrixD1 dMatrixD1, double d) {
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (Math.abs(dMatrixD1.get(i)) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean isVector(Matrix matrix) {
        return matrix.getNumCols() == 1 || matrix.getNumRows() == 1;
    }

    public static boolean isPositiveDefinite(DMatrixRMaj dMatrixRMaj) {
        if (!isSquare(dMatrixRMaj)) {
            return false;
        }
        CholeskyDecompositionInner_DDRM choleskyDecompositionInner_DDRM = new CholeskyDecompositionInner_DDRM(true);
        if (choleskyDecompositionInner_DDRM.inputModified()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        return choleskyDecompositionInner_DDRM.decompose(dMatrixRMaj);
    }

    public static boolean isPositiveSemidefinite(DMatrixRMaj dMatrixRMaj) {
        if (!isSquare(dMatrixRMaj)) {
            return false;
        }
        EigenDecomposition_F64<DMatrixRMaj> eigenDecomposition_F64Eig = DecompositionFactory_DDRM.eig(dMatrixRMaj.numCols, false);
        if (eigenDecomposition_F64Eig.inputModified()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        eigenDecomposition_F64Eig.decompose(dMatrixRMaj);
        for (int i = 0; i < dMatrixRMaj.numRows; i++) {
            if (eigenDecomposition_F64Eig.getEigenvalue(i).getReal() < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSquare(DMatrixD1 dMatrixD1) {
        return dMatrixD1.numCols == dMatrixD1.numRows;
    }

    public static boolean isSymmetric(DMatrixRMaj dMatrixRMaj, double d) {
        if (dMatrixRMaj.numCols != dMatrixRMaj.numRows) {
            return false;
        }
        double dElementMaxAbs = CommonOps_DDRM.elementMaxAbs(dMatrixRMaj);
        for (int i = 0; i < dMatrixRMaj.numRows; i++) {
            for (int i2 = 0; i2 < i; i2++) {
                if (Math.abs((dMatrixRMaj.get(i, i2) / dElementMaxAbs) - (dMatrixRMaj.get(i2, i) / dElementMaxAbs)) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSymmetric(DMatrixRMaj dMatrixRMaj) {
        return isSymmetric(dMatrixRMaj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static boolean isSkewSymmetric(DMatrixRMaj dMatrixRMaj, double d) {
        if (dMatrixRMaj.numCols != dMatrixRMaj.numRows) {
            return false;
        }
        for (int i = 0; i < dMatrixRMaj.numRows; i++) {
            for (int i2 = 0; i2 < i; i2++) {
                if (Math.abs(dMatrixRMaj.get(i, i2) + dMatrixRMaj.get(i2, i)) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isInverse(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2, double d) {
        if (dMatrixRMaj.numRows != dMatrixRMaj2.numRows || dMatrixRMaj.numCols != dMatrixRMaj2.numCols) {
            return false;
        }
        int i = dMatrixRMaj.numRows;
        int i2 = dMatrixRMaj.numCols;
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i5 = 0; i5 < i2; i5++) {
                    d2 += dMatrixRMaj.get(i3, i5) * dMatrixRMaj2.get(i5, i4);
                }
                if (i3 == i4) {
                    if (Math.abs(d2 - 1.0d) > d) {
                        return false;
                    }
                } else if (Math.abs(d2) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEquals(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, double d) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            return false;
        }
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return isEquals(dMatrixD1, dMatrixD12);
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (d < Math.abs(dMatrixD1.get(i) - dMatrixD12.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqualsTriangle(DMatrix dMatrix, DMatrix dMatrix2, boolean z, double d) {
        if (dMatrix.getNumRows() != dMatrix2.getNumRows() || dMatrix.getNumCols() != dMatrix2.getNumCols()) {
            return false;
        }
        if (z) {
            for (int i = 0; i < dMatrix.getNumRows(); i++) {
                for (int i2 = i; i2 < dMatrix.getNumCols(); i2++) {
                    if (Math.abs(dMatrix.get(i, i2) - dMatrix2.get(i, i2)) > d) {
                        return false;
                    }
                }
            }
        } else {
            for (int i3 = 0; i3 < dMatrix.getNumRows(); i3++) {
                int iMin = Math.min(i3, dMatrix.getNumCols() - 1);
                for (int i4 = 0; i4 <= iMin; i4++) {
                    if (Math.abs(dMatrix.get(i3, i4) - dMatrix2.get(i3, i4)) > d) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isEquals(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            return false;
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (dMatrixD1.get(i) != dMatrixD12.get(i)) {
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

    public static boolean isIdentical(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, double d) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            return false;
        }
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("Tolerance must be greater than or equal to zero.");
        }
        int numElements = dMatrixD1.getNumElements();
        int i = 0;
        while (i < numElements) {
            double d2 = d;
            if (!UtilEjml.isIdentical(dMatrixD1.get(i), dMatrixD12.get(i), d2)) {
                return false;
            }
            i++;
            d = d2;
        }
        return true;
    }

    public static boolean isOrthogonal(DMatrixRMaj dMatrixRMaj, double d) {
        if (dMatrixRMaj.numRows < dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("The number of rows must be more than or equal to the number of columns");
        }
        DMatrixRMaj[] dMatrixRMajArrColumnsToVector = CommonOps_DDRM.columnsToVector(dMatrixRMaj, null);
        int i = 0;
        while (i < dMatrixRMajArrColumnsToVector.length) {
            DMatrixRMaj dMatrixRMaj2 = dMatrixRMajArrColumnsToVector[i];
            i++;
            for (int i2 = i; i2 < dMatrixRMajArrColumnsToVector.length; i2++) {
                if (Math.abs(VectorVectorMult_DDRM.innerProd(dMatrixRMaj2, dMatrixRMajArrColumnsToVector[i2])) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isRowsLinearIndependent(DMatrixRMaj dMatrixRMaj) {
        LUDecomposition_F64<DMatrixRMaj> lUDecomposition_F64M1667lu = DecompositionFactory_DDRM.m1667lu(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        if (lUDecomposition_F64M1667lu.inputModified()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        if (!lUDecomposition_F64M1667lu.decompose(dMatrixRMaj)) {
            throw new RuntimeException("Decompositon failed?");
        }
        return !lUDecomposition_F64M1667lu.isSingular();
    }

    public static boolean isIdentity(DMatrixRMaj dMatrixRMaj, double d) {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrixRMaj.numRows; i3++) {
            for (int i4 = 0; i4 < dMatrixRMaj.numCols; i4++) {
                if (i3 == i4) {
                    i = i2 + 1;
                    if (Math.abs(dMatrixRMaj.get(i2) - 1.0d) > d) {
                        return false;
                    }
                } else {
                    i = i2 + 1;
                    if (Math.abs(dMatrixRMaj.get(i2)) > d) {
                        return false;
                    }
                }
                i2 = i;
            }
        }
        return true;
    }

    public static boolean isConstantVal(DMatrixRMaj dMatrixRMaj, double d, double d2) {
        int i = 0;
        for (int i2 = 0; i2 < dMatrixRMaj.numRows; i2++) {
            int i3 = 0;
            while (i3 < dMatrixRMaj.numCols) {
                int i4 = i + 1;
                if (Math.abs(dMatrixRMaj.get(i) - d) > d2) {
                    return false;
                }
                i3++;
                i = i4;
            }
        }
        return true;
    }

    public static boolean isDiagonalPositive(DMatrixRMaj dMatrixRMaj) {
        for (int i = 0; i < dMatrixRMaj.numRows; i++) {
            if (dMatrixRMaj.get(i, i) < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFullRank(DMatrixRMaj dMatrixRMaj) {
        throw new RuntimeException("Implement");
    }

    public static boolean isNegative(DMatrixD1 dMatrixD1, DMatrixD1 dMatrixD12, double d) {
        if (dMatrixD1.numRows != dMatrixD12.numRows || dMatrixD1.numCols != dMatrixD12.numCols) {
            throw new IllegalArgumentException("Matrix dimensions must match");
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            if (Math.abs(dMatrixD1.get(i) + dMatrixD12.get(i)) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUpperTriangle(DMatrixRMaj dMatrixRMaj, int i, double d) {
        for (int i2 = i + 1; i2 < dMatrixRMaj.numRows; i2++) {
            int iMin = Math.min(i2 - i, dMatrixRMaj.numCols);
            for (int i3 = 0; i3 < iMin; i3++) {
                if (Math.abs(dMatrixRMaj.unsafe_get(i2, i3)) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLowerTriangle(DMatrixRMaj dMatrixRMaj, int i, double d) {
        for (int i2 = 0; i2 < (dMatrixRMaj.numRows - i) - 1; i2++) {
            for (int i3 = i2 + i + 1; i3 < dMatrixRMaj.numCols; i3++) {
                if (Math.abs(dMatrixRMaj.unsafe_get(i2, i3)) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int rank(DMatrixRMaj dMatrixRMaj) {
        return rank(dMatrixRMaj, UtilEjml.EPS * 100.0d);
    }

    public static int rank(DMatrixRMaj dMatrixRMaj, double d) {
        SingularValueDecomposition_F64<DMatrixRMaj> singularValueDecomposition_F64Svd = DecompositionFactory_DDRM.svd(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false, false, true);
        if (singularValueDecomposition_F64Svd.inputModified()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        if (!singularValueDecomposition_F64Svd.decompose(dMatrixRMaj)) {
            throw new RuntimeException("Decomposition failed");
        }
        return SingularOps_DDRM.rank(singularValueDecomposition_F64Svd, d);
    }

    public static int nullity(DMatrixRMaj dMatrixRMaj) {
        return nullity(dMatrixRMaj, UtilEjml.EPS * 100.0d);
    }

    public static int nullity(DMatrixRMaj dMatrixRMaj, double d) {
        SingularValueDecomposition_F64<DMatrixRMaj> singularValueDecomposition_F64Svd = DecompositionFactory_DDRM.svd(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false, false, true);
        if (singularValueDecomposition_F64Svd.inputModified()) {
            dMatrixRMaj = dMatrixRMaj.copy();
        }
        if (!singularValueDecomposition_F64Svd.decompose(dMatrixRMaj)) {
            throw new RuntimeException("Decomposition failed");
        }
        return SingularOps_DDRM.nullity(singularValueDecomposition_F64Svd, d);
    }

    public static int countNonZero(DMatrixRMaj dMatrixRMaj) {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < dMatrixRMaj.numRows; i3++) {
            int i4 = 0;
            while (i4 < dMatrixRMaj.numCols) {
                if (dMatrixRMaj.data[i2] != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    i++;
                }
                i4++;
                i2++;
            }
        }
        return i;
    }
}
