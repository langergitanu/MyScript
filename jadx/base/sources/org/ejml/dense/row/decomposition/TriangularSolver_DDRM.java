package org.ejml.dense.row.decomposition;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes9.dex */
public class TriangularSolver_DDRM {
    public static void invertLower(double[] dArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * i;
            int i4 = i3 + i2;
            double d = dArr[i4];
            for (int i5 = 0; i5 < i2; i5++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i6 = i5; i6 < i2; i6++) {
                    d2 += dArr[i3 + i6] * dArr[(i6 * i) + i5];
                }
                dArr[i3 + i5] = (-d2) / d;
            }
            dArr[i4] = 1.0d / d;
        }
    }

    public static void invertLower(double[] dArr, double[] dArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * i;
            int i4 = i3 + i2;
            double d = dArr[i4];
            for (int i5 = 0; i5 < i2; i5++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i6 = i5; i6 < i2; i6++) {
                    d2 -= dArr[i3 + i6] * dArr2[(i6 * i) + i5];
                }
                dArr2[i3 + i5] = d2 / d;
            }
            dArr2[i4] = 1.0d / d;
        }
    }

    public static void solveL(double[] dArr, double[] dArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            double d = dArr2[i2];
            int i3 = i2 * i;
            int i4 = 0;
            while (i4 < i2) {
                d -= dArr[i3] * dArr2[i4];
                i4++;
                i3++;
            }
            dArr2[i2] = d / dArr[i3];
        }
    }

    public static void solveL(double[] dArr, double[] dArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = (i4 * i2) + i3;
                double d = dArr2[i5];
                for (int i6 = 0; i6 < i4; i6++) {
                    d -= dArr[(i4 * i) + i6] * dArr2[(i6 * i2) + i3];
                }
                dArr2[i5] = d / dArr[(i4 * i) + i4];
            }
        }
    }

    public static void solveTranL(double[] dArr, double[] dArr2, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            double d = dArr2[i2];
            for (int i3 = i2 + 1; i3 < i; i3++) {
                d -= dArr[(i3 * i) + i2] * dArr2[i3];
            }
            dArr2[i2] = d / dArr[(i2 * i) + i2];
        }
    }

    public static void solveU(double[] dArr, double[] dArr2, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            double d = dArr2[i2];
            int i3 = (i2 * i) + i2;
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            while (i5 < i) {
                d -= dArr[i4] * dArr2[i5];
                i5++;
                i4++;
            }
            dArr2[i2] = d / dArr[i3];
        }
    }

    public static void solveU(double[] dArr, double[] dArr2, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            double d = dArr2[i4];
            int i5 = (i4 * i) + i4;
            int i6 = i5 + 1;
            int i7 = i4 + 1;
            while (i7 < i3) {
                d -= dArr[i6] * dArr2[i7];
                i7++;
                i6++;
            }
            dArr2[i4] = d / dArr[i5];
        }
    }

    public static void solveU(double[] dArr, int i, int i2, int i3, double[] dArr2, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            for (int i8 = i3 - 1; i8 >= 0; i8--) {
                int i9 = i4 + (i8 * i5) + i7;
                double d = dArr2[i9];
                for (int i10 = i8 + 1; i10 < i3; i10++) {
                    d -= dArr[((i8 * i2) + i) + i10] * dArr2[(i4 + (i10 * i5)) + i7];
                }
                dArr2[i9] = d / dArr[((i8 * i2) + i) + i8];
            }
        }
    }
}
