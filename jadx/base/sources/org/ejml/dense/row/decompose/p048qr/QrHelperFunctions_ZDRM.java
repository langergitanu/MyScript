package org.ejml.dense.row.decompose.p048qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class QrHelperFunctions_ZDRM {
    private static double mag(double d, double d2) {
        return (d * d) + (d2 * d2);
    }

    public static double findMax(double[] dArr, int i, int i2) {
        int i3 = i * 2;
        int i4 = (i + i2) * 2;
        double d = -1.0d;
        while (i3 < i4) {
            int i5 = i3 + 1;
            double d2 = dArr[i3];
            i3 += 2;
            double d3 = dArr[i5];
            double d4 = (d2 * d2) + (d3 * d3);
            if (d4 > d) {
                d = d4;
            }
        }
        return Math.sqrt(d);
    }

    public static void divideElements(int i, int i2, double[] dArr, int i3, double d, double d2) {
        double d3 = (d * d) + (d2 * d2);
        int i4 = (i3 + i) * 2;
        while (i < i2) {
            double d4 = dArr[i4];
            int i5 = i4 + 1;
            double d5 = dArr[i5];
            dArr[i4] = ((d4 * d) + (d5 * d2)) / d3;
            i4 += 2;
            dArr[i5] = ((d5 * d) - (d4 * d2)) / d3;
            i++;
        }
    }

    public static double computeTauGammaAndDivide(int i, int i2, double[] dArr, double d, Complex_F64 complex_F64) {
        double d2;
        double d3;
        double d4;
        int i3 = i * 2;
        int i4 = i3;
        double d5 = 0.0d;
        while (i < i2) {
            int i5 = i4 + 1;
            double d6 = dArr[i4] / d;
            dArr[i4] = d6;
            i4 += 2;
            double d7 = dArr[i5] / d;
            dArr[i5] = d7;
            d5 += (d6 * d6) + (d7 * d7);
            i++;
        }
        double dSqrt = Math.sqrt(d5);
        double d8 = dArr[i3];
        double d9 = dArr[i3 + 1];
        double dSqrt2 = Math.sqrt((d8 * d8) + (d9 * d9));
        if (dSqrt2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            complex_F64.real = dSqrt;
            complex_F64.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            complex_F64.real = (d8 / dSqrt2) * dSqrt;
            complex_F64.imaginary = (d9 / dSqrt2) * dSqrt;
        }
        if (mag(d8 - complex_F64.real, d9 - complex_F64.imaginary) > mag(complex_F64.real + d8, complex_F64.imaginary + d9)) {
            complex_F64.real = -complex_F64.real;
            complex_F64.imaginary = -complex_F64.imaginary;
            d2 = dSqrt * dSqrt;
            d3 = d2 - (dSqrt * dSqrt2);
            d4 = (dSqrt2 * dSqrt2) - ((dSqrt * 2.0d) * dSqrt2);
        } else {
            d2 = dSqrt * dSqrt;
            d3 = (dSqrt * dSqrt2) + d2;
            d4 = (dSqrt2 * dSqrt2) + (dSqrt * 2.0d * dSqrt2);
        }
        return (d4 + d2) / d3;
    }

    public static void rank1UpdateMultR(ZMatrixRMaj zMatrixRMaj, double[] dArr, int i, double d, int i2, int i3, int i4, double[] dArr2) {
        int i5 = (i3 + i) * 2;
        double d2 = dArr[i5];
        double d3 = -dArr[i5 + 1];
        int i6 = ((zMatrixRMaj.numCols * i3) + i2) * 2;
        int i7 = i2 * 2;
        int i8 = i7;
        for (int i9 = i2; i9 < zMatrixRMaj.numCols; i9++) {
            int i10 = i6 + 1;
            double d4 = zMatrixRMaj.data[i6];
            i6 += 2;
            double d5 = zMatrixRMaj.data[i10];
            int i11 = i8 + 1;
            dArr2[i8] = (d2 * d4) - (d3 * d5);
            i8 += 2;
            dArr2[i11] = (d5 * d2) + (d4 * d3);
        }
        for (int i12 = i3 + 1; i12 < i4; i12++) {
            int i13 = ((zMatrixRMaj.numCols * i12) + i2) * 2;
            int i14 = (i12 + i) * 2;
            double d6 = dArr[i14];
            double d7 = -dArr[i14 + 1];
            int i15 = i7;
            for (int i16 = i2; i16 < zMatrixRMaj.numCols; i16++) {
                int i17 = i13 + 1;
                double d8 = zMatrixRMaj.data[i13];
                i13 += 2;
                double d9 = zMatrixRMaj.data[i17];
                int i18 = i15 + 1;
                dArr2[i15] = dArr2[i15] + ((d6 * d8) - (d7 * d9));
                i15 += 2;
                dArr2[i18] = dArr2[i18] + (d9 * d6) + (d8 * d7);
            }
        }
        int i19 = i7;
        for (int i20 = i2; i20 < zMatrixRMaj.numCols; i20++) {
            int i21 = i19 + 1;
            dArr2[i19] = dArr2[i19] * d;
            i19 += 2;
            dArr2[i21] = dArr2[i21] * d;
        }
        for (int i22 = i3; i22 < i4; i22++) {
            int i23 = ((zMatrixRMaj.numCols * i22) + i2) * 2;
            int i24 = (i22 + i) * 2;
            double d10 = dArr[i24];
            double d11 = dArr[i24 + 1];
            int i25 = i7;
            for (int i26 = i2; i26 < zMatrixRMaj.numCols; i26++) {
                int i27 = i25 + 1;
                double d12 = dArr2[i25];
                i25 += 2;
                double d13 = dArr2[i27];
                double[] dArr3 = zMatrixRMaj.data;
                int i28 = i23 + 1;
                dArr3[i23] = dArr3[i23] - ((d10 * d12) - (d11 * d13));
                double[] dArr4 = zMatrixRMaj.data;
                i23 += 2;
                dArr4[i28] = dArr4[i28] - ((d13 * d10) + (d12 * d11));
            }
        }
    }

    public static void rank1UpdateMultL(ZMatrixRMaj zMatrixRMaj, double[] dArr, int i, double d, int i2, int i3, int i4) {
        int i5 = i2;
        while (true) {
            int i6 = i4;
            if (i5 >= zMatrixRMaj.numRows) {
                return;
            }
            int i7 = ((zMatrixRMaj.numCols * i5) + i3) * 2;
            int i8 = (i + i3) * 2;
            double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            int i9 = i7;
            int i10 = i8;
            double d3 = 0.0d;
            for (int i11 = i3; i11 < i6; i11++) {
                int i12 = i9 + 1;
                double d4 = zMatrixRMaj.data[i9];
                i9 += 2;
                double d5 = zMatrixRMaj.data[i12];
                int i13 = i10 + 1;
                double d6 = dArr[i10];
                i10 += 2;
                double d7 = dArr[i13];
                d2 += (d4 * d6) - (d5 * d7);
                d3 += (d4 * d7) + (d5 * d6);
            }
            double d8 = -d;
            double d9 = d2 * d8;
            double d10 = d8 * d3;
            int i14 = i3;
            while (i14 < i6) {
                int i15 = i8 + 1;
                double d11 = dArr[i8];
                i8 += 2;
                double d12 = -dArr[i15];
                double[] dArr2 = zMatrixRMaj.data;
                int i16 = i7 + 1;
                dArr2[i7] = dArr2[i7] + ((d9 * d11) - (d10 * d12));
                double[] dArr3 = zMatrixRMaj.data;
                i7 += 2;
                dArr3[i16] = dArr3[i16] + (d12 * d9) + (d11 * d10);
                i14++;
                i6 = i4;
                i5 = i5;
            }
            i5++;
        }
    }

    public static void extractHouseholderColumn(ZMatrixRMaj zMatrixRMaj, int i, int i2, int i3, double[] dArr, int i4) {
        int i5 = (i4 + i) * 2;
        int i6 = i5 + 1;
        dArr[i5] = 1.0d;
        int i7 = i5 + 2;
        dArr[i6] = 0.0d;
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            int index = zMatrixRMaj.getIndex(i, i3);
            int i8 = i7 + 1;
            dArr[i7] = zMatrixRMaj.data[index];
            i7 += 2;
            dArr[i8] = zMatrixRMaj.data[index + 1];
        }
    }

    public static void extractHouseholderRow(ZMatrixRMaj zMatrixRMaj, int i, int i2, int i3, double[] dArr, int i4) {
        int i5 = (i4 + i2) * 2;
        dArr[i5] = 1.0d;
        dArr[i5 + 1] = 0.0d;
        System.arraycopy(zMatrixRMaj.data, ((i * zMatrixRMaj.numCols) + i2 + 1) * 2, dArr, i5 + 2, ((i3 - i2) - 1) * 2);
    }

    public static double extractColumnAndMax(ZMatrixRMaj zMatrixRMaj, int i, int i2, int i3, double[] dArr, int i4) {
        int i5 = (i4 + i) * 2;
        int index = zMatrixRMaj.getIndex(i, i3);
        double[] dArr2 = zMatrixRMaj.data;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (i < i2) {
            int i6 = i5 + 1;
            double d2 = dArr2[index];
            dArr[i5] = d2;
            i5 += 2;
            double d3 = dArr2[index + 1];
            dArr[i6] = d3;
            double d4 = (d2 * d2) + (d3 * d3);
            if (d < d4) {
                d = d4;
            }
            i++;
            index += zMatrixRMaj.numCols * 2;
        }
        return Math.sqrt(d);
    }

    public static double computeRowMax(ZMatrixRMaj zMatrixRMaj, int i, int i2, int i3) {
        int index = zMatrixRMaj.getIndex(i, i2);
        double[] dArr = zMatrixRMaj.data;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (i2 < i3) {
            int i4 = index + 1;
            double d2 = dArr[index];
            index += 2;
            double d3 = dArr[i4];
            double d4 = (d2 * d2) + (d3 * d3);
            if (d < d4) {
                d = d4;
            }
            i2++;
        }
        return Math.sqrt(d);
    }
}
