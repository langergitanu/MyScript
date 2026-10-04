package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.mult.VectorVectorMult_ZDRM;

/* JADX INFO: loaded from: classes9.dex */
public class SpecializedOps_ZDRM {
    public static ZMatrixRMaj createReflector(ZMatrixRMaj zMatrixRMaj) {
        if (!MatrixFeatures_ZDRM.isVector(zMatrixRMaj)) {
            throw new IllegalArgumentException("u must be a vector");
        }
        double dNormF = NormOps_ZDRM.normF(zMatrixRMaj);
        ZMatrixRMaj zMatrixRMajIdentity = CommonOps_ZDRM.identity(zMatrixRMaj.getNumElements());
        CommonOps_ZDRM.multAddTransB((-2.0d) / (dNormF * dNormF), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, zMatrixRMaj, zMatrixRMaj, zMatrixRMajIdentity);
        return zMatrixRMajIdentity;
    }

    public static ZMatrixRMaj createReflector(ZMatrixRMaj zMatrixRMaj, double d) {
        if (!MatrixFeatures_ZDRM.isVector(zMatrixRMaj)) {
            throw new IllegalArgumentException("u must be a vector");
        }
        ZMatrixRMaj zMatrixRMajIdentity = CommonOps_ZDRM.identity(zMatrixRMaj.getNumElements());
        CommonOps_ZDRM.multAddTransB(-d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, zMatrixRMaj, zMatrixRMaj, zMatrixRMajIdentity);
        return zMatrixRMajIdentity;
    }

    public static ZMatrixRMaj pivotMatrix(ZMatrixRMaj zMatrixRMaj, int[] iArr, int i, boolean z) {
        if (zMatrixRMaj == null) {
            zMatrixRMaj = new ZMatrixRMaj(i, i);
        } else {
            if (zMatrixRMaj.numCols != i || zMatrixRMaj.numRows != i) {
                throw new IllegalArgumentException("Unexpected matrix dimension");
            }
            CommonOps_ZDRM.fill(zMatrixRMaj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        ZMatrixRMaj zMatrixRMaj2 = zMatrixRMaj;
        if (z) {
            for (int i2 = 0; i2 < i; i2++) {
                zMatrixRMaj2.set(iArr[i2], i2, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                zMatrixRMaj2.set(i3, iArr[i3], 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
        }
        return zMatrixRMaj2;
    }

    public static double elementDiagMaxMagnitude2(ZMatrixRMaj zMatrixRMaj) {
        int iMin = Math.min(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        int rowStride = zMatrixRMaj.getRowStride();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < iMin; i++) {
            int i2 = (i * rowStride) + (i * 2);
            double d2 = zMatrixRMaj.data[i2];
            double d3 = zMatrixRMaj.data[i2 + 1];
            double d4 = (d2 * d2) + (d3 * d3);
            if (d4 > d) {
                d = d4;
            }
        }
        return d;
    }

    public static double qualityTriangular(ZMatrixRMaj zMatrixRMaj) {
        int iMin = Math.min(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        double dElementDiagMaxMagnitude2 = elementDiagMaxMagnitude2(zMatrixRMaj);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (dElementDiagMaxMagnitude2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double dSqrt = Math.sqrt(dElementDiagMaxMagnitude2);
        int rowStride = zMatrixRMaj.getRowStride();
        double d2 = 1.0d;
        int i = 0;
        while (i < iMin) {
            int i2 = (i * rowStride) + (i * 2);
            double d3 = zMatrixRMaj.data[i2] / dSqrt;
            double d4 = zMatrixRMaj.data[i2] / dSqrt;
            double d5 = (d2 * d3) - (d * d4);
            d = (d2 * d4) + (d3 * d);
            i++;
            d2 = d5;
        }
        return Math.sqrt((d2 * d2) + (d * d));
    }

    public static ZMatrixRMaj householder(ZMatrixRMaj zMatrixRMaj, double d) {
        int dataLength = zMatrixRMaj.getDataLength() / 2;
        ZMatrixRMaj zMatrixRMaj2 = new ZMatrixRMaj(dataLength, dataLength);
        VectorVectorMult_ZDRM.outerProdH(zMatrixRMaj, zMatrixRMaj, zMatrixRMaj2);
        CommonOps_ZDRM.elementMultiply(zMatrixRMaj2, -d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, zMatrixRMaj2);
        for (int i = 0; i < dataLength; i++) {
            int i2 = ((zMatrixRMaj2.numCols * i) + i) * 2;
            zMatrixRMaj2.data[i2] = zMatrixRMaj2.data[i2] + 1.0d;
        }
        return zMatrixRMaj2;
    }

    public static ZMatrixRMaj householderVector(ZMatrixRMaj zMatrixRMaj) {
        ZMatrixRMaj zMatrixRMajCopy = zMatrixRMaj.copy();
        CommonOps_ZDRM.elementDivide(zMatrixRMajCopy, CommonOps_ZDRM.elementMaxAbs(zMatrixRMajCopy), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, zMatrixRMajCopy);
        double dNormF = NormOps_ZDRM.normF(zMatrixRMajCopy);
        Complex_F64 complex_F64 = new Complex_F64();
        zMatrixRMajCopy.get(0, 0, complex_F64);
        double magnitude = complex_F64.getMagnitude();
        double magnitude2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (magnitude != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double magnitude3 = (complex_F64.real / complex_F64.getMagnitude()) * dNormF;
            magnitude2 = (complex_F64.imaginary / complex_F64.getMagnitude()) * dNormF;
            dNormF = magnitude3;
        }
        zMatrixRMajCopy.set(0, 0, complex_F64.real + dNormF, magnitude2 + complex_F64.imaginary);
        CommonOps_ZDRM.elementDivide(zMatrixRMajCopy, zMatrixRMajCopy.getReal(0, 0), zMatrixRMajCopy.getImag(0, 0), zMatrixRMajCopy);
        return zMatrixRMajCopy;
    }
}
