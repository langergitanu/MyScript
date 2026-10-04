package org.ejml.dense.row;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrix1Row;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_FDRM {
    public static void normalizeF(FMatrixRMaj fMatrixRMaj) {
        float fNormF = normF(fMatrixRMaj);
        if (fNormF == 0.0f) {
            return;
        }
        int numElements = fMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fMatrixRMaj.div(i, fNormF);
        }
    }

    public static float conditionP(FMatrixRMaj fMatrixRMaj, float f) {
        float fNormP;
        float fNormP2;
        if (f == 2.0f) {
            return conditionP2(fMatrixRMaj);
        }
        if (fMatrixRMaj.numRows == fMatrixRMaj.numCols) {
            FMatrixRMaj fMatrixRMaj2 = new FMatrixRMaj(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
            if (!CommonOps_FDRM.invert(fMatrixRMaj, fMatrixRMaj2)) {
                throw new IllegalArgumentException("A can't be inverted.");
            }
            fNormP = normP(fMatrixRMaj, f);
            fNormP2 = normP(fMatrixRMaj2, f);
        } else {
            FMatrixRMaj fMatrixRMaj3 = new FMatrixRMaj(fMatrixRMaj.numCols, fMatrixRMaj.numRows);
            CommonOps_FDRM.pinv(fMatrixRMaj, fMatrixRMaj3);
            fNormP = normP(fMatrixRMaj, f);
            fNormP2 = normP(fMatrixRMaj3, f);
        }
        return fNormP * fNormP2;
    }

    public static float conditionP2(FMatrixRMaj fMatrixRMaj) {
        SingularValueDecomposition_F32<FMatrixRMaj> singularValueDecomposition_F32Svd = DecompositionFactory_FDRM.svd(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false, false, true);
        singularValueDecomposition_F32Svd.decompose(fMatrixRMaj);
        float[] singularValues = singularValueDecomposition_F32Svd.getSingularValues();
        if (SingularOps_FDRM.rank(singularValueDecomposition_F32Svd, UtilEjml.TEST_F32) == 0) {
            return 0.0f;
        }
        float f = Float.MAX_VALUE;
        float f2 = Float.MIN_VALUE;
        for (float f3 : singularValues) {
            if (f3 < f) {
                f = f3;
            }
            if (f3 > f2) {
                f2 = f3;
            }
        }
        return f2 / f;
    }

    public static float fastNormF(FMatrixD1 fMatrixD1) {
        int numElements = fMatrixD1.getNumElements();
        float f = 0.0f;
        for (int i = 0; i < numElements; i++) {
            float f2 = fMatrixD1.get(i);
            f += f2 * f2;
        }
        return (float) Math.sqrt(f);
    }

    public static float normF(FMatrixD1 fMatrixD1) {
        float fElementMaxAbs = CommonOps_FDRM.elementMaxAbs(fMatrixD1);
        float f = 0.0f;
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        int numElements = fMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            float f2 = fMatrixD1.get(i) / fElementMaxAbs;
            f += f2 * f2;
        }
        return fElementMaxAbs * ((float) Math.sqrt(f));
    }

    public static float elementP(FMatrix1Row fMatrix1Row, float f) {
        if (f == 1.0f) {
            return CommonOps_FDRM.elementSumAbs(fMatrix1Row);
        }
        if (f == 2.0f) {
            return normF(fMatrix1Row);
        }
        float fElementMaxAbs = CommonOps_FDRM.elementMaxAbs(fMatrix1Row);
        float fPow = 0.0f;
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        int numElements = fMatrix1Row.getNumElements();
        for (int i = 0; i < numElements; i++) {
            fPow += (float) Math.pow(Math.abs(fMatrix1Row.get(i) / fElementMaxAbs), f);
        }
        return fElementMaxAbs * ((float) Math.pow(fPow, 1.0f / f));
    }

    public static float fastElementP(FMatrixD1 fMatrixD1, float f) {
        if (f == 2.0f) {
            return fastNormF(fMatrixD1);
        }
        int numElements = fMatrixD1.getNumElements();
        float fPow = 0.0f;
        for (int i = 0; i < numElements; i++) {
            fPow += (float) Math.pow(Math.abs(fMatrixD1.get(i)), f);
        }
        return (float) Math.pow(fPow, 1.0f / f);
    }

    public static float normP(FMatrixRMaj fMatrixRMaj, float f) {
        if (f == 1.0f) {
            return normP1(fMatrixRMaj);
        }
        if (f == 2.0f) {
            return normP2(fMatrixRMaj);
        }
        if (Float.isInfinite(f)) {
            return normPInf(fMatrixRMaj);
        }
        if (MatrixFeatures_FDRM.isVector(fMatrixRMaj)) {
            return elementP(fMatrixRMaj, f);
        }
        throw new IllegalArgumentException("Doesn't support induced norms yet.");
    }

    public static float fastNormP(FMatrixRMaj fMatrixRMaj, float f) {
        if (f == 1.0f) {
            return normP1(fMatrixRMaj);
        }
        if (f == 2.0f) {
            return fastNormP2(fMatrixRMaj);
        }
        if (Float.isInfinite(f)) {
            return normPInf(fMatrixRMaj);
        }
        if (MatrixFeatures_FDRM.isVector(fMatrixRMaj)) {
            return fastElementP(fMatrixRMaj, f);
        }
        throw new IllegalArgumentException("Doesn't support induced norms yet.");
    }

    public static float normP1(FMatrixRMaj fMatrixRMaj) {
        if (MatrixFeatures_FDRM.isVector(fMatrixRMaj)) {
            return CommonOps_FDRM.elementSumAbs(fMatrixRMaj);
        }
        return inducedP1(fMatrixRMaj);
    }

    public static float normP2(FMatrixRMaj fMatrixRMaj) {
        if (MatrixFeatures_FDRM.isVector(fMatrixRMaj)) {
            return normF(fMatrixRMaj);
        }
        return inducedP2(fMatrixRMaj);
    }

    public static float fastNormP2(FMatrixRMaj fMatrixRMaj) {
        if (MatrixFeatures_FDRM.isVector(fMatrixRMaj)) {
            return fastNormF(fMatrixRMaj);
        }
        return inducedP2(fMatrixRMaj);
    }

    public static float normPInf(FMatrixRMaj fMatrixRMaj) {
        if (MatrixFeatures_FDRM.isVector(fMatrixRMaj)) {
            return CommonOps_FDRM.elementMaxAbs(fMatrixRMaj);
        }
        return inducedPInf(fMatrixRMaj);
    }

    public static float inducedP1(FMatrixRMaj fMatrixRMaj) {
        int i = fMatrixRMaj.numRows;
        int i2 = fMatrixRMaj.numCols;
        float f = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            float fAbs = 0.0f;
            for (int i4 = 0; i4 < i; i4++) {
                fAbs += Math.abs(fMatrixRMaj.get(i4, i3));
            }
            if (fAbs > f) {
                f = fAbs;
            }
        }
        return f;
    }

    public static float inducedP2(FMatrixRMaj fMatrixRMaj) {
        SingularValueDecomposition_F32<FMatrixRMaj> singularValueDecomposition_F32Svd = DecompositionFactory_FDRM.svd(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false, false, true);
        if (!singularValueDecomposition_F32Svd.decompose(fMatrixRMaj)) {
            throw new RuntimeException("Decomposition failed");
        }
        float[] singularValues = singularValueDecomposition_F32Svd.getSingularValues();
        return UtilEjml.max(singularValues, 0, singularValues.length);
    }

    public static float inducedPInf(FMatrixRMaj fMatrixRMaj) {
        int i = fMatrixRMaj.numRows;
        int i2 = fMatrixRMaj.numCols;
        float f = 0.0f;
        for (int i3 = 0; i3 < i; i3++) {
            float fAbs = 0.0f;
            for (int i4 = 0; i4 < i2; i4++) {
                fAbs += Math.abs(fMatrixRMaj.get(i3, i4));
            }
            if (fAbs > f) {
                f = fAbs;
            }
        }
        return f;
    }
}
