package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.Matrix;
import org.ejml.data.ZMatrix;
import org.ejml.data.ZMatrixD1;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.chol.CholeskyDecompositionInner_ZDRM;
import org.ejml.dense.row.mult.VectorVectorMult_ZDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_ZDRM {
    public static boolean isVector(Matrix matrix) {
        return matrix.getNumCols() == 1 || matrix.getNumRows() == 1;
    }

    public static boolean isNegative(ZMatrixD1 zMatrixD1, ZMatrixD1 zMatrixD12, double d) {
        if (zMatrixD1.numRows != zMatrixD12.numRows || zMatrixD1.numCols != zMatrixD12.numCols) {
            throw new IllegalArgumentException("Matrix dimensions must match");
        }
        int numElements = zMatrixD1.getNumElements() * 2;
        for (int i = 0; i < numElements; i++) {
            if (Math.abs(zMatrixD1.data[i] + zMatrixD12.data[i]) > d) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasNaN(ZMatrixD1 zMatrixD1) {
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            if (Double.isNaN(zMatrixD1.data[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasUncountable(ZMatrixD1 zMatrixD1) {
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            double d = zMatrixD1.data[i];
            if (Double.isNaN(d) || Double.isInfinite(d)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEquals(ZMatrixD1 zMatrixD1, ZMatrixD1 zMatrixD12) {
        if (zMatrixD1.numRows != zMatrixD12.numRows || zMatrixD1.numCols != zMatrixD12.numCols) {
            return false;
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            if (zMatrixD1.data[i] != zMatrixD12.data[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEquals(ZMatrixD1 zMatrixD1, ZMatrixD1 zMatrixD12, double d) {
        if (zMatrixD1.numRows != zMatrixD12.numRows || zMatrixD1.numCols != zMatrixD12.numCols) {
            return false;
        }
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return isEquals(zMatrixD1, zMatrixD12);
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            if (d < Math.abs(zMatrixD1.data[i] - zMatrixD12.data[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIdentical(ZMatrixD1 zMatrixD1, ZMatrixD1 zMatrixD12, double d) {
        if (zMatrixD1.numRows != zMatrixD12.numRows || zMatrixD1.numCols != zMatrixD12.numCols) {
            return false;
        }
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            throw new IllegalArgumentException("Tolerance must be greater than or equal to zero.");
        }
        int dataLength = zMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            double d2 = zMatrixD1.data[i];
            double d3 = zMatrixD12.data[i];
            if (d < Math.abs(d2 - d3)) {
                if (Double.isNaN(d2)) {
                    return Double.isNaN(d3);
                }
                return Double.isInfinite(d2) && d2 == d3;
            }
        }
        return true;
    }

    public static boolean isIdentity(ZMatrix zMatrix, double d) {
        Complex_F64 complex_F64 = new Complex_F64();
        for (int i = 0; i < zMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < zMatrix.getNumCols(); i2++) {
                zMatrix.get(i, i2, complex_F64);
                if (i == i2) {
                    if (Math.abs(complex_F64.real - 1.0d) > d || Math.abs(complex_F64.imaginary) > d) {
                        return false;
                    }
                } else if (Math.abs(complex_F64.real) > d || Math.abs(complex_F64.imaginary) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isHermitian(ZMatrixRMaj zMatrixRMaj, double d) {
        if (zMatrixRMaj.numCols != zMatrixRMaj.numRows) {
            return false;
        }
        Complex_F64 complex_F64 = new Complex_F64();
        Complex_F64 complex_F642 = new Complex_F64();
        for (int i = 0; i < zMatrixRMaj.numCols; i++) {
            for (int i2 = i; i2 < zMatrixRMaj.numCols; i2++) {
                zMatrixRMaj.get(i, i2, complex_F64);
                zMatrixRMaj.get(i2, i, complex_F642);
                if (Math.abs(complex_F64.real - complex_F642.real) > d || Math.abs(complex_F64.imaginary + complex_F642.imaginary) > d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUnitary(ZMatrixRMaj zMatrixRMaj, double d) {
        if (zMatrixRMaj.numRows < zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("The number of rows must be more than or equal to the number of columns");
        }
        Complex_F64 complex_F64 = new Complex_F64();
        ZMatrixRMaj[] zMatrixRMajArrColumnsToVector = CommonOps_ZDRM.columnsToVector(zMatrixRMaj, null);
        int i = 0;
        while (i < zMatrixRMajArrColumnsToVector.length) {
            ZMatrixRMaj zMatrixRMaj2 = zMatrixRMajArrColumnsToVector[i];
            VectorVectorMult_ZDRM.innerProdH(zMatrixRMaj2, zMatrixRMaj2, complex_F64);
            if (Math.abs(complex_F64.real - 1.0d) > d || Math.abs(complex_F64.imaginary) > d) {
                return false;
            }
            i++;
            for (int i2 = i; i2 < zMatrixRMajArrColumnsToVector.length; i2++) {
                VectorVectorMult_ZDRM.innerProdH(zMatrixRMaj2, zMatrixRMajArrColumnsToVector[i2], complex_F64);
                if (complex_F64.getMagnitude2() > d * d) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPositiveDefinite(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numCols != zMatrixRMaj.numRows) {
            return false;
        }
        CholeskyDecompositionInner_ZDRM choleskyDecompositionInner_ZDRM = new CholeskyDecompositionInner_ZDRM(true);
        if (choleskyDecompositionInner_ZDRM.inputModified()) {
            zMatrixRMaj = zMatrixRMaj.copy();
        }
        return choleskyDecompositionInner_ZDRM.decompose(zMatrixRMaj);
    }

    public static boolean isUpperTriangle(ZMatrixRMaj zMatrixRMaj, int i, double d) {
        double d2 = d * d;
        for (int i2 = i + 1; i2 < zMatrixRMaj.numRows; i2++) {
            int iMin = Math.min(i2 - i, zMatrixRMaj.numCols);
            for (int i3 = 0; i3 < iMin; i3++) {
                int i4 = ((zMatrixRMaj.numCols * i2) + i3) * 2;
                double d3 = zMatrixRMaj.data[i4];
                double d4 = zMatrixRMaj.data[i4 + 1];
                if ((d3 * d3) + (d4 * d4) > d2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLowerTriangle(ZMatrixRMaj zMatrixRMaj, int i, double d) {
        double d2 = d * d;
        for (int i2 = 0; i2 < (zMatrixRMaj.numRows - i) - 1; i2++) {
            for (int i3 = i2 + i + 1; i3 < zMatrixRMaj.numCols; i3++) {
                int i4 = ((zMatrixRMaj.numCols * i2) + i3) * 2;
                double d3 = zMatrixRMaj.data[i4];
                double d4 = zMatrixRMaj.data[i4 + 1];
                if ((d3 * d3) + (d4 * d4) > d2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isZeros(ZMatrixD1 zMatrixD1, double d) {
        int numElements = zMatrixD1.getNumElements() * 2;
        for (int i = 0; i < numElements; i++) {
            if (Math.abs(zMatrixD1.data[i]) > d) {
                return false;
            }
        }
        return true;
    }
}
