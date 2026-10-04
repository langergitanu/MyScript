package org.ejml.dense.block.decomposition.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class InnerCholesky_DDRB {
    public static boolean upper(DSubmatrixD1 dSubmatrixD1) {
        int i = dSubmatrixD1.row1 - dSubmatrixD1.row0;
        return upper(dSubmatrixD1.original.data, (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (dSubmatrixD1.col0 * i), i);
    }

    public static boolean lower(DSubmatrixD1 dSubmatrixD1) {
        int i = dSubmatrixD1.row1 - dSubmatrixD1.row0;
        return lower(dSubmatrixD1.original.data, (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + (dSubmatrixD1.col0 * i), i);
    }

    public static boolean upper(double[] dArr, int i, int i2) {
        double d = 0.0d;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                int i5 = i + (i3 * i2);
                int i6 = i5 + i4;
                double d2 = dArr[i6];
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = i + (i7 * i2);
                    d2 -= dArr[i8 + i3] * dArr[i8 + i4];
                }
                if (i3 == i4) {
                    if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return false;
                    }
                    double dSqrt = Math.sqrt(d2);
                    dArr[i5 + i3] = dSqrt;
                    d = 1.0d / dSqrt;
                } else {
                    dArr[i6] = d2 * d;
                }
            }
        }
        return true;
    }

    public static boolean lower(double[] dArr, int i, int i2) {
        double d = 0.0d;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                int i5 = i + (i4 * i2);
                int i6 = i5 + i3;
                double d2 = dArr[i6];
                for (int i7 = 0; i7 < i3; i7++) {
                    d2 -= dArr[(i + (i3 * i2)) + i7] * dArr[i5 + i7];
                }
                if (i3 == i4) {
                    if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return false;
                    }
                    double dSqrt = Math.sqrt(d2);
                    dArr[i + (i3 * i2) + i3] = dSqrt;
                    d = 1.0d / dSqrt;
                } else {
                    dArr[i6] = d2 * d;
                }
            }
        }
        return true;
    }
}
