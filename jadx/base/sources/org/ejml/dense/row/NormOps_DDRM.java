package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrix1Row;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_DDRM {
    public static void normalizeF(DMatrixRMaj dMatrixRMaj) {
        double dNormF = normF(dMatrixRMaj);
        if (dNormF == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return;
        }
        int numElements = dMatrixRMaj.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dMatrixRMaj.div(i, dNormF);
        }
    }

    public static double conditionP(DMatrixRMaj dMatrixRMaj, double d) {
        double dNormP;
        double dNormP2;
        if (d == 2.0d) {
            return conditionP2(dMatrixRMaj);
        }
        if (dMatrixRMaj.numRows == dMatrixRMaj.numCols) {
            DMatrixRMaj dMatrixRMaj2 = new DMatrixRMaj(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
            if (!CommonOps_DDRM.invert(dMatrixRMaj, dMatrixRMaj2)) {
                throw new IllegalArgumentException("A can't be inverted.");
            }
            dNormP = normP(dMatrixRMaj, d);
            dNormP2 = normP(dMatrixRMaj2, d);
        } else {
            DMatrixRMaj dMatrixRMaj3 = new DMatrixRMaj(dMatrixRMaj.numCols, dMatrixRMaj.numRows);
            CommonOps_DDRM.pinv(dMatrixRMaj, dMatrixRMaj3);
            dNormP = normP(dMatrixRMaj, d);
            dNormP2 = normP(dMatrixRMaj3, d);
        }
        return dNormP * dNormP2;
    }

    public static double conditionP2(DMatrixRMaj dMatrixRMaj) {
        SingularValueDecomposition_F64<DMatrixRMaj> singularValueDecomposition_F64Svd = DecompositionFactory_DDRM.svd(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false, false, true);
        singularValueDecomposition_F64Svd.decompose(dMatrixRMaj);
        double[] singularValues = singularValueDecomposition_F64Svd.getSingularValues();
        if (SingularOps_DDRM.rank(singularValueDecomposition_F64Svd, UtilEjml.TEST_F64) == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = Double.MAX_VALUE;
        double d2 = Double.MIN_VALUE;
        for (double d3 : singularValues) {
            if (d3 < d) {
                d = d3;
            }
            if (d3 > d2) {
                d2 = d3;
            }
        }
        return d2 / d;
    }

    public static double fastNormF(DMatrixD1 dMatrixD1) {
        int numElements = dMatrixD1.getNumElements();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            double d2 = dMatrixD1.get(i);
            d += d2 * d2;
        }
        return Math.sqrt(d);
    }

    public static double normF(DMatrixD1 dMatrixD1) {
        double dElementMaxAbs = CommonOps_DDRM.elementMaxAbs(dMatrixD1);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int numElements = dMatrixD1.getNumElements();
        for (int i = 0; i < numElements; i++) {
            double d2 = dMatrixD1.get(i) / dElementMaxAbs;
            d += d2 * d2;
        }
        return dElementMaxAbs * Math.sqrt(d);
    }

    public static double elementP(DMatrix1Row dMatrix1Row, double d) {
        if (d == 1.0d) {
            return CommonOps_DDRM.elementSumAbs(dMatrix1Row);
        }
        if (d == 2.0d) {
            return normF(dMatrix1Row);
        }
        double dElementMaxAbs = CommonOps_DDRM.elementMaxAbs(dMatrix1Row);
        double dPow = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int numElements = dMatrix1Row.getNumElements();
        for (int i = 0; i < numElements; i++) {
            dPow += Math.pow(Math.abs(dMatrix1Row.get(i) / dElementMaxAbs), d);
        }
        return dElementMaxAbs * Math.pow(dPow, 1.0d / d);
    }

    public static double fastElementP(DMatrixD1 dMatrixD1, double d) {
        if (d == 2.0d) {
            return fastNormF(dMatrixD1);
        }
        int numElements = dMatrixD1.getNumElements();
        double dPow = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < numElements; i++) {
            dPow += Math.pow(Math.abs(dMatrixD1.get(i)), d);
        }
        return Math.pow(dPow, 1.0d / d);
    }

    public static double normP(DMatrixRMaj dMatrixRMaj, double d) {
        if (d == 1.0d) {
            return normP1(dMatrixRMaj);
        }
        if (d == 2.0d) {
            return normP2(dMatrixRMaj);
        }
        if (Double.isInfinite(d)) {
            return normPInf(dMatrixRMaj);
        }
        if (MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
            return elementP(dMatrixRMaj, d);
        }
        throw new IllegalArgumentException("Doesn't support induced norms yet.");
    }

    public static double fastNormP(DMatrixRMaj dMatrixRMaj, double d) {
        if (d == 1.0d) {
            return normP1(dMatrixRMaj);
        }
        if (d == 2.0d) {
            return fastNormP2(dMatrixRMaj);
        }
        if (Double.isInfinite(d)) {
            return normPInf(dMatrixRMaj);
        }
        if (MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
            return fastElementP(dMatrixRMaj, d);
        }
        throw new IllegalArgumentException("Doesn't support induced norms yet.");
    }

    public static double normP1(DMatrixRMaj dMatrixRMaj) {
        if (MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
            return CommonOps_DDRM.elementSumAbs(dMatrixRMaj);
        }
        return inducedP1(dMatrixRMaj);
    }

    public static double normP2(DMatrixRMaj dMatrixRMaj) {
        if (MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
            return normF(dMatrixRMaj);
        }
        return inducedP2(dMatrixRMaj);
    }

    public static double fastNormP2(DMatrixRMaj dMatrixRMaj) {
        if (MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
            return fastNormF(dMatrixRMaj);
        }
        return inducedP2(dMatrixRMaj);
    }

    public static double normPInf(DMatrixRMaj dMatrixRMaj) {
        if (MatrixFeatures_DDRM.isVector(dMatrixRMaj)) {
            return CommonOps_DDRM.elementMaxAbs(dMatrixRMaj);
        }
        return inducedPInf(dMatrixRMaj);
    }

    public static double inducedP1(DMatrixRMaj dMatrixRMaj) {
        int i = dMatrixRMaj.numRows;
        int i2 = dMatrixRMaj.numCols;
        double d = 0.0d;
        for (int i3 = 0; i3 < i2; i3++) {
            double dAbs = 0.0d;
            for (int i4 = 0; i4 < i; i4++) {
                dAbs += Math.abs(dMatrixRMaj.get(i4, i3));
            }
            if (dAbs > d) {
                d = dAbs;
            }
        }
        return d;
    }

    public static double inducedP2(DMatrixRMaj dMatrixRMaj) {
        SingularValueDecomposition_F64<DMatrixRMaj> singularValueDecomposition_F64Svd = DecompositionFactory_DDRM.svd(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false, false, true);
        if (!singularValueDecomposition_F64Svd.decompose(dMatrixRMaj)) {
            throw new RuntimeException("Decomposition failed");
        }
        double[] singularValues = singularValueDecomposition_F64Svd.getSingularValues();
        return UtilEjml.max(singularValues, 0, singularValues.length);
    }

    public static double inducedPInf(DMatrixRMaj dMatrixRMaj) {
        int i = dMatrixRMaj.numRows;
        int i2 = dMatrixRMaj.numCols;
        double d = 0.0d;
        for (int i3 = 0; i3 < i; i3++) {
            double dAbs = 0.0d;
            for (int i4 = 0; i4 < i2; i4++) {
                dAbs += Math.abs(dMatrixRMaj.get(i3, i4));
            }
            if (dAbs > d) {
                d = dAbs;
            }
        }
        return d;
    }
}
