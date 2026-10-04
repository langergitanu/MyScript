package org.ejml.dense.row.mult;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class VectorVectorMult_ZDRM {
    public static Complex_F64 innerProd(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, Complex_F64 complex_F64) {
        ZMatrixRMaj zMatrixRMaj3 = zMatrixRMaj;
        ZMatrixRMaj zMatrixRMaj4 = zMatrixRMaj2;
        Complex_F64 complex_F642 = complex_F64;
        if (complex_F642 == null) {
            complex_F642 = new Complex_F64();
        } else {
            complex_F642.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            complex_F642.real = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int dataLength = zMatrixRMaj3.getDataLength();
        int i = 0;
        while (i < dataLength) {
            double d = zMatrixRMaj3.data[i];
            int i2 = i + 1;
            double d2 = zMatrixRMaj3.data[i2];
            double d3 = zMatrixRMaj4.data[i];
            double d4 = zMatrixRMaj4.data[i2];
            complex_F642.real += (d * d3) - (d2 * d4);
            complex_F642.imaginary += (d * d4) + (d2 * d3);
            i += 2;
            zMatrixRMaj3 = zMatrixRMaj;
            zMatrixRMaj4 = zMatrixRMaj2;
        }
        return complex_F642;
    }

    public static Complex_F64 innerProdH(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, Complex_F64 complex_F64) {
        ZMatrixRMaj zMatrixRMaj3 = zMatrixRMaj;
        ZMatrixRMaj zMatrixRMaj4 = zMatrixRMaj2;
        Complex_F64 complex_F642 = complex_F64;
        if (complex_F642 == null) {
            complex_F642 = new Complex_F64();
        } else {
            complex_F642.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            complex_F642.real = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int dataLength = zMatrixRMaj3.getDataLength();
        int i = 0;
        while (i < dataLength) {
            double d = zMatrixRMaj3.data[i];
            int i2 = i + 1;
            double d2 = zMatrixRMaj3.data[i2];
            double d3 = zMatrixRMaj4.data[i];
            double d4 = -zMatrixRMaj4.data[i2];
            complex_F642.real += (d * d3) - (d2 * d4);
            complex_F642.imaginary += (d * d4) + (d2 * d3);
            i += 2;
            zMatrixRMaj3 = zMatrixRMaj;
            zMatrixRMaj4 = zMatrixRMaj2;
        }
        return complex_F642;
    }

    public static void outerProd(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        int i = zMatrixRMaj3.numRows;
        int i2 = zMatrixRMaj3.numCols;
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i4 * 2;
            double d = zMatrixRMaj.data[i5];
            double d2 = zMatrixRMaj.data[i5 + 1];
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                int i8 = i6 + 1;
                double d3 = zMatrixRMaj2.data[i6];
                i6 += 2;
                double d4 = zMatrixRMaj2.data[i8];
                int i9 = i3 + 1;
                zMatrixRMaj3.data[i3] = (d * d3) - (d2 * d4);
                i3 += 2;
                zMatrixRMaj3.data[i9] = (d4 * d) + (d3 * d2);
            }
        }
    }

    public static void outerProdH(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        int i = zMatrixRMaj3.numRows;
        int i2 = zMatrixRMaj3.numCols;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = i3 * 2;
            double d = zMatrixRMaj.data[i5];
            double d2 = zMatrixRMaj.data[i5 + 1];
            int i6 = 0;
            int i7 = 0;
            while (i6 < i2) {
                int i8 = i7 + 1;
                double d3 = zMatrixRMaj2.data[i7];
                i7 += 2;
                double d4 = -zMatrixRMaj2.data[i8];
                int i9 = i4 + 1;
                zMatrixRMaj3.data[i4] = (d * d3) - (d2 * d4);
                i4 += 2;
                zMatrixRMaj3.data[i9] = (d4 * d) + (d3 * d2);
                i6++;
                i3 = i3;
            }
            i3++;
        }
    }
}
