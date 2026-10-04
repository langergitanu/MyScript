package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Random;
import org.ejml.data.ZMatrixD1;
import org.ejml.data.ZMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class RandomMatrices_ZDRM {
    public static ZMatrixRMaj rectangle(int i, int i2, Random random) {
        return rectangle(i, i2, -1.0d, 1.0d, random);
    }

    public static ZMatrixRMaj rectangle(int i, int i2, double d, double d2, Random random) {
        ZMatrixRMaj zMatrixRMaj = new ZMatrixRMaj(i, i2);
        fillUniform(zMatrixRMaj, d, d2, random);
        return zMatrixRMaj;
    }

    public static void fillUniform(ZMatrixRMaj zMatrixRMaj, Random random) {
        fillUniform(zMatrixRMaj, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, random);
    }

    public static void fillUniform(ZMatrixD1 zMatrixD1, double d, double d2, Random random) {
        double[] data = zMatrixD1.getData();
        int dataLength = zMatrixD1.getDataLength();
        double d3 = d2 - d;
        for (int i = 0; i < dataLength; i++) {
            data[i] = (random.nextDouble() * d3) + d;
        }
    }

    public static ZMatrixRMaj hermitianPosDef(int i, Random random) {
        ZMatrixRMaj zMatrixRMajRectangle = rectangle(i, 1, random);
        ZMatrixRMaj zMatrixRMaj = new ZMatrixRMaj(1, i);
        ZMatrixRMaj zMatrixRMaj2 = new ZMatrixRMaj(i, i);
        CommonOps_ZDRM.transposeConjugate(zMatrixRMajRectangle, zMatrixRMaj);
        CommonOps_ZDRM.mult(zMatrixRMajRectangle, zMatrixRMaj, zMatrixRMaj2);
        for (int i2 = 0; i2 < i; i2++) {
            double[] dArr = zMatrixRMaj2.data;
            int i3 = ((i2 * i) + i2) * 2;
            dArr[i3] = dArr[i3] + 1.0d;
        }
        return zMatrixRMaj2;
    }

    public static ZMatrixRMaj hermitian(int i, double d, double d2, Random random) {
        ZMatrixRMaj zMatrixRMaj = new ZMatrixRMaj(i, i);
        fillHermitian(zMatrixRMaj, d, d2, random);
        return zMatrixRMaj;
    }

    public static void fillHermitian(ZMatrixRMaj zMatrixRMaj, double d, double d2, Random random) {
        if (zMatrixRMaj.numRows != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be a square matrix");
        }
        double d3 = d2 - d;
        int i = zMatrixRMaj.numRows;
        int i2 = 0;
        while (i2 < i) {
            ZMatrixRMaj zMatrixRMaj2 = zMatrixRMaj;
            zMatrixRMaj2.set(i2, i2, (random.nextDouble() * d3) + d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            int i3 = i2 + 1;
            int i4 = i3;
            while (i4 < i) {
                double dNextDouble = (random.nextDouble() * d3) + d;
                double dNextDouble2 = (random.nextDouble() * d3) + d;
                zMatrixRMaj2.set(i2, i4, dNextDouble, dNextDouble2);
                int i5 = i4;
                int i6 = i2;
                zMatrixRMaj2.set(i5, i6, dNextDouble, -dNextDouble2);
                i2 = i6;
                i4 = i5 + 1;
            }
            i2 = i3;
            zMatrixRMaj = zMatrixRMaj2;
        }
    }
}
