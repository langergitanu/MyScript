package org.ejml.dense.row.mult;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix1Row;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixMultProduct_DDRM {
    public static void outer(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2) {
        for (int i = 0; i < dMatrix1Row.numRows; i++) {
            int i2 = (dMatrix1Row2.numCols * i) + i;
            int i3 = i;
            int i4 = i2;
            while (i3 < dMatrix1Row.numRows) {
                int i5 = dMatrix1Row.numCols * i;
                int i6 = dMatrix1Row.numCols * i3;
                int i7 = dMatrix1Row.numCols + i5;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                while (i5 < i7) {
                    d += dMatrix1Row.data[i5] * dMatrix1Row.data[i6];
                    i5++;
                    i6++;
                }
                double[] dArr = dMatrix1Row2.data;
                dMatrix1Row2.data[i2] = d;
                dArr[i4] = d;
                i3++;
                i4 += dMatrix1Row2.numCols;
                i2++;
            }
        }
    }

    public static void inner_small(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2) {
        for (int i = 0; i < dMatrix1Row.numCols; i++) {
            for (int i2 = i; i2 < dMatrix1Row.numCols; i2++) {
                int i3 = (dMatrix1Row2.numCols * i) + i2;
                int i4 = (dMatrix1Row2.numCols * i2) + i;
                int i5 = (dMatrix1Row.numRows * dMatrix1Row.numCols) + i;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i6 = i;
                int i7 = i2;
                while (i6 < i5) {
                    d += dMatrix1Row.data[i6] * dMatrix1Row.data[i7];
                    i6 += dMatrix1Row.numCols;
                    i7 += dMatrix1Row.numCols;
                }
                double[] dArr = dMatrix1Row2.data;
                dMatrix1Row2.data[i4] = d;
                dArr[i3] = d;
            }
        }
    }

    public static void inner_reorder(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2) {
        for (int i = 0; i < dMatrix1Row.numCols; i++) {
            int i2 = (dMatrix1Row2.numCols * i) + i;
            double d = dMatrix1Row.data[i];
            int i3 = i;
            while (i3 < dMatrix1Row.numCols) {
                dMatrix1Row2.data[i2] = dMatrix1Row.data[i3] * d;
                i3++;
                i2++;
            }
            for (int i4 = 1; i4 < dMatrix1Row.numRows; i4++) {
                int i5 = (dMatrix1Row2.numCols * i) + i;
                int i6 = (dMatrix1Row.numCols * i4) + i;
                double d2 = dMatrix1Row.data[i6];
                int i7 = i;
                while (i7 < dMatrix1Row.numCols) {
                    double[] dArr = dMatrix1Row2.data;
                    dArr[i5] = dArr[i5] + (dMatrix1Row.data[i6] * d2);
                    i7++;
                    i5++;
                    i6++;
                }
            }
            int i8 = (dMatrix1Row2.numCols * i) + i;
            int i9 = i;
            int i10 = i8;
            while (i9 < dMatrix1Row.numCols) {
                dMatrix1Row2.data[i8] = dMatrix1Row2.data[i10];
                i9++;
                i8 += dMatrix1Row2.numCols;
                i10++;
            }
        }
    }

    public static void inner_reorder_upper(DMatrix1Row dMatrix1Row, DMatrix1Row dMatrix1Row2) {
        for (int i = 0; i < dMatrix1Row.numCols; i++) {
            int i2 = (dMatrix1Row2.numCols * i) + i;
            double d = dMatrix1Row.data[i];
            int i3 = i;
            while (i3 < dMatrix1Row.numCols) {
                dMatrix1Row2.data[i2] = dMatrix1Row.data[i3] * d;
                i3++;
                i2++;
            }
            for (int i4 = 1; i4 < dMatrix1Row.numRows; i4++) {
                int i5 = (dMatrix1Row2.numCols * i) + i;
                int i6 = (dMatrix1Row.numCols * i4) + i;
                double d2 = dMatrix1Row.data[i6];
                int i7 = i;
                while (i7 < dMatrix1Row.numCols) {
                    double[] dArr = dMatrix1Row2.data;
                    dArr[i5] = dArr[i5] + (dMatrix1Row.data[i6] * d2);
                    i7++;
                    i5++;
                    i6++;
                }
            }
        }
    }
}
