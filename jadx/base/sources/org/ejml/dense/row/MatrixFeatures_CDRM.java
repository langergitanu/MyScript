package org.ejml.dense.row;

import org.ejml.data.CMatrix;
import org.ejml.data.CMatrixD1;
import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.data.Matrix;
import org.ejml.dense.row.decompose.chol.CholeskyDecompositionInner_CDRM;
import org.ejml.dense.row.mult.VectorVectorMult_CDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_CDRM {
    public static boolean isVector(Matrix matrix) {
        return matrix.getNumCols() == 1 || matrix.getNumRows() == 1;
    }

    public static boolean isNegative(CMatrixD1 cMatrixD1, CMatrixD1 cMatrixD12, float f) {
        if (cMatrixD1.numRows != cMatrixD12.numRows || cMatrixD1.numCols != cMatrixD12.numCols) {
            throw new IllegalArgumentException("Matrix dimensions must match");
        }
        int numElements = cMatrixD1.getNumElements() * 2;
        for (int i = 0; i < numElements; i++) {
            if (Math.abs(cMatrixD1.data[i] + cMatrixD12.data[i]) > f) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasNaN(CMatrixD1 cMatrixD1) {
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            if (Float.isNaN(cMatrixD1.data[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasUncountable(CMatrixD1 cMatrixD1) {
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            float f = cMatrixD1.data[i];
            if (Float.isNaN(f) || Float.isInfinite(f)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEquals(CMatrixD1 cMatrixD1, CMatrixD1 cMatrixD12) {
        if (cMatrixD1.numRows != cMatrixD12.numRows || cMatrixD1.numCols != cMatrixD12.numCols) {
            return false;
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            if (cMatrixD1.data[i] != cMatrixD12.data[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEquals(CMatrixD1 cMatrixD1, CMatrixD1 cMatrixD12, float f) {
        if (cMatrixD1.numRows != cMatrixD12.numRows || cMatrixD1.numCols != cMatrixD12.numCols) {
            return false;
        }
        if (f == 0.0f) {
            return isEquals(cMatrixD1, cMatrixD12);
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            if (f < Math.abs(cMatrixD1.data[i] - cMatrixD12.data[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIdentical(CMatrixD1 cMatrixD1, CMatrixD1 cMatrixD12, float f) {
        if (cMatrixD1.numRows != cMatrixD12.numRows || cMatrixD1.numCols != cMatrixD12.numCols) {
            return false;
        }
        if (f < 0.0f) {
            throw new IllegalArgumentException("Tolerance must be greater than or equal to zero.");
        }
        int dataLength = cMatrixD1.getDataLength();
        for (int i = 0; i < dataLength; i++) {
            float f2 = cMatrixD1.data[i];
            float f3 = cMatrixD12.data[i];
            if (f < Math.abs(f2 - f3)) {
                if (Float.isNaN(f2)) {
                    return Float.isNaN(f3);
                }
                return Float.isInfinite(f2) && f2 == f3;
            }
        }
        return true;
    }

    public static boolean isIdentity(CMatrix cMatrix, float f) {
        Complex_F32 complex_F32 = new Complex_F32();
        for (int i = 0; i < cMatrix.getNumRows(); i++) {
            for (int i2 = 0; i2 < cMatrix.getNumCols(); i2++) {
                cMatrix.get(i, i2, complex_F32);
                if (i == i2) {
                    if (Math.abs(complex_F32.real - 1.0f) > f || Math.abs(complex_F32.imaginary) > f) {
                        return false;
                    }
                } else if (Math.abs(complex_F32.real) > f || Math.abs(complex_F32.imaginary) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isHermitian(CMatrixRMaj cMatrixRMaj, float f) {
        if (cMatrixRMaj.numCols != cMatrixRMaj.numRows) {
            return false;
        }
        Complex_F32 complex_F32 = new Complex_F32();
        Complex_F32 complex_F322 = new Complex_F32();
        for (int i = 0; i < cMatrixRMaj.numCols; i++) {
            for (int i2 = i; i2 < cMatrixRMaj.numCols; i2++) {
                cMatrixRMaj.get(i, i2, complex_F32);
                cMatrixRMaj.get(i2, i, complex_F322);
                if (Math.abs(complex_F32.real - complex_F322.real) > f || Math.abs(complex_F32.imaginary + complex_F322.imaginary) > f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUnitary(CMatrixRMaj cMatrixRMaj, float f) {
        if (cMatrixRMaj.numRows < cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("The number of rows must be more than or equal to the number of columns");
        }
        Complex_F32 complex_F32 = new Complex_F32();
        CMatrixRMaj[] cMatrixRMajArrColumnsToVector = CommonOps_CDRM.columnsToVector(cMatrixRMaj, null);
        int i = 0;
        while (i < cMatrixRMajArrColumnsToVector.length) {
            CMatrixRMaj cMatrixRMaj2 = cMatrixRMajArrColumnsToVector[i];
            VectorVectorMult_CDRM.innerProdH(cMatrixRMaj2, cMatrixRMaj2, complex_F32);
            if (Math.abs(complex_F32.real - 1.0f) > f || Math.abs(complex_F32.imaginary) > f) {
                return false;
            }
            i++;
            for (int i2 = i; i2 < cMatrixRMajArrColumnsToVector.length; i2++) {
                VectorVectorMult_CDRM.innerProdH(cMatrixRMaj2, cMatrixRMajArrColumnsToVector[i2], complex_F32);
                if (complex_F32.getMagnitude2() > f * f) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPositiveDefinite(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numCols != cMatrixRMaj.numRows) {
            return false;
        }
        CholeskyDecompositionInner_CDRM choleskyDecompositionInner_CDRM = new CholeskyDecompositionInner_CDRM(true);
        if (choleskyDecompositionInner_CDRM.inputModified()) {
            cMatrixRMaj = cMatrixRMaj.copy();
        }
        return choleskyDecompositionInner_CDRM.decompose(cMatrixRMaj);
    }

    public static boolean isUpperTriangle(CMatrixRMaj cMatrixRMaj, int i, float f) {
        float f2 = f * f;
        for (int i2 = i + 1; i2 < cMatrixRMaj.numRows; i2++) {
            int iMin = Math.min(i2 - i, cMatrixRMaj.numCols);
            for (int i3 = 0; i3 < iMin; i3++) {
                int i4 = ((cMatrixRMaj.numCols * i2) + i3) * 2;
                float f3 = cMatrixRMaj.data[i4];
                float f4 = cMatrixRMaj.data[i4 + 1];
                if ((f3 * f3) + (f4 * f4) > f2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isLowerTriangle(CMatrixRMaj cMatrixRMaj, int i, float f) {
        float f2 = f * f;
        for (int i2 = 0; i2 < (cMatrixRMaj.numRows - i) - 1; i2++) {
            for (int i3 = i2 + i + 1; i3 < cMatrixRMaj.numCols; i3++) {
                int i4 = ((cMatrixRMaj.numCols * i2) + i3) * 2;
                float f3 = cMatrixRMaj.data[i4];
                float f4 = cMatrixRMaj.data[i4 + 1];
                if ((f3 * f3) + (f4 * f4) > f2) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isZeros(CMatrixD1 cMatrixD1, float f) {
        int numElements = cMatrixD1.getNumElements() * 2;
        for (int i = 0; i < numElements; i++) {
            if (Math.abs(cMatrixD1.data[i]) > f) {
                return false;
            }
        }
        return true;
    }
}
