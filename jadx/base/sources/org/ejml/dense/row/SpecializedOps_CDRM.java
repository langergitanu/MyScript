package org.ejml.dense.row;

import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.dense.row.mult.VectorVectorMult_CDRM;

/* JADX INFO: loaded from: classes9.dex */
public class SpecializedOps_CDRM {
    public static CMatrixRMaj createReflector(CMatrixRMaj cMatrixRMaj) {
        if (!MatrixFeatures_CDRM.isVector(cMatrixRMaj)) {
            throw new IllegalArgumentException("u must be a vector");
        }
        float fNormF = NormOps_CDRM.normF(cMatrixRMaj);
        float f = (-2.0f) / (fNormF * fNormF);
        CMatrixRMaj cMatrixRMajIdentity = CommonOps_CDRM.identity(cMatrixRMaj.getNumElements());
        CommonOps_CDRM.multAddTransB(f, 0.0f, cMatrixRMaj, cMatrixRMaj, cMatrixRMajIdentity);
        return cMatrixRMajIdentity;
    }

    public static CMatrixRMaj createReflector(CMatrixRMaj cMatrixRMaj, float f) {
        if (!MatrixFeatures_CDRM.isVector(cMatrixRMaj)) {
            throw new IllegalArgumentException("u must be a vector");
        }
        CMatrixRMaj cMatrixRMajIdentity = CommonOps_CDRM.identity(cMatrixRMaj.getNumElements());
        CommonOps_CDRM.multAddTransB(-f, 0.0f, cMatrixRMaj, cMatrixRMaj, cMatrixRMajIdentity);
        return cMatrixRMajIdentity;
    }

    public static CMatrixRMaj pivotMatrix(CMatrixRMaj cMatrixRMaj, int[] iArr, int i, boolean z) {
        if (cMatrixRMaj == null) {
            cMatrixRMaj = new CMatrixRMaj(i, i);
        } else {
            if (cMatrixRMaj.numCols != i || cMatrixRMaj.numRows != i) {
                throw new IllegalArgumentException("Unexpected matrix dimension");
            }
            CommonOps_CDRM.fill(cMatrixRMaj, 0.0f, 0.0f);
        }
        int i2 = 0;
        if (z) {
            while (i2 < i) {
                cMatrixRMaj.set(iArr[i2], i2, 1.0f, 0.0f);
                i2++;
            }
        } else {
            while (i2 < i) {
                cMatrixRMaj.set(i2, iArr[i2], 1.0f, 0.0f);
                i2++;
            }
        }
        return cMatrixRMaj;
    }

    public static float elementDiagMaxMagnitude2(CMatrixRMaj cMatrixRMaj) {
        int iMin = Math.min(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        int rowStride = cMatrixRMaj.getRowStride();
        float f = 0.0f;
        for (int i = 0; i < iMin; i++) {
            int i2 = (i * rowStride) + (i * 2);
            float f2 = cMatrixRMaj.data[i2];
            float f3 = cMatrixRMaj.data[i2 + 1];
            float f4 = (f2 * f2) + (f3 * f3);
            if (f4 > f) {
                f = f4;
            }
        }
        return f;
    }

    public static float qualityTriangular(CMatrixRMaj cMatrixRMaj) {
        int iMin = Math.min(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        float fElementDiagMaxMagnitude2 = elementDiagMaxMagnitude2(cMatrixRMaj);
        float f = 0.0f;
        if (fElementDiagMaxMagnitude2 == 0.0f) {
            return 0.0f;
        }
        float fSqrt = (float) Math.sqrt(fElementDiagMaxMagnitude2);
        int rowStride = cMatrixRMaj.getRowStride();
        float f2 = 1.0f;
        int i = 0;
        while (i < iMin) {
            int i2 = (i * rowStride) + (i * 2);
            float f3 = cMatrixRMaj.data[i2] / fSqrt;
            float f4 = cMatrixRMaj.data[i2] / fSqrt;
            float f5 = (f2 * f3) - (f * f4);
            f = (f2 * f4) + (f3 * f);
            i++;
            f2 = f5;
        }
        return (float) Math.sqrt((f2 * f2) + (f * f));
    }

    public static CMatrixRMaj householder(CMatrixRMaj cMatrixRMaj, float f) {
        int dataLength = cMatrixRMaj.getDataLength() / 2;
        CMatrixRMaj cMatrixRMaj2 = new CMatrixRMaj(dataLength, dataLength);
        VectorVectorMult_CDRM.outerProdH(cMatrixRMaj, cMatrixRMaj, cMatrixRMaj2);
        CommonOps_CDRM.elementMultiply(cMatrixRMaj2, -f, 0.0f, cMatrixRMaj2);
        for (int i = 0; i < dataLength; i++) {
            int i2 = ((cMatrixRMaj2.numCols * i) + i) * 2;
            cMatrixRMaj2.data[i2] = cMatrixRMaj2.data[i2] + 1.0f;
        }
        return cMatrixRMaj2;
    }

    public static CMatrixRMaj householderVector(CMatrixRMaj cMatrixRMaj) {
        CMatrixRMaj cMatrixRMajCopy = cMatrixRMaj.copy();
        float magnitude = 0.0f;
        CommonOps_CDRM.elementDivide(cMatrixRMajCopy, CommonOps_CDRM.elementMaxAbs(cMatrixRMajCopy), 0.0f, cMatrixRMajCopy);
        float fNormF = NormOps_CDRM.normF(cMatrixRMajCopy);
        Complex_F32 complex_F32 = new Complex_F32();
        cMatrixRMajCopy.get(0, 0, complex_F32);
        if (complex_F32.getMagnitude() != 0.0f) {
            float magnitude2 = (complex_F32.real / complex_F32.getMagnitude()) * fNormF;
            magnitude = fNormF * (complex_F32.imaginary / complex_F32.getMagnitude());
            fNormF = magnitude2;
        }
        cMatrixRMajCopy.set(0, 0, complex_F32.real + fNormF, complex_F32.imaginary + magnitude);
        CommonOps_CDRM.elementDivide(cMatrixRMajCopy, cMatrixRMajCopy.getReal(0, 0), cMatrixRMajCopy.getImag(0, 0), cMatrixRMajCopy);
        return cMatrixRMajCopy;
    }
}
