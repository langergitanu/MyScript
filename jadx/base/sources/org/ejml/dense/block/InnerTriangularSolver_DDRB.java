package org.ejml.dense.block;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes9.dex */
public class InnerTriangularSolver_DDRB {
    public static void invertLower(double[] dArr, double[] dArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i4 * i;
            int i6 = i2 + i5;
            double d = dArr[i6 + i4];
            for (int i7 = 0; i7 < i4; i7++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i8 = i7; i8 < i4; i8++) {
                    d2 += dArr[i6 + i8] * dArr2[i3 + (i8 * i) + i7];
                }
                dArr2[i3 + i5 + i7] = (-d2) / d;
            }
            dArr2[i3 + i5 + i4] = 1.0d / d;
        }
    }

    public static void invertLower(double[] dArr, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i2 + (i3 * i);
            int i5 = i4 + i3;
            double d = dArr[i5];
            for (int i6 = 0; i6 < i3; i6++) {
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                for (int i7 = i6; i7 < i3; i7++) {
                    d2 += dArr[i4 + i7] * dArr[i2 + (i7 * i) + i6];
                }
                dArr[i4 + i6] = (-d2) / d;
            }
            dArr[i5] = 1.0d / d;
        }
    }

    public static void solveL(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = i5 + (i7 * i2) + i6;
                double d = dArr2[i8];
                for (int i9 = 0; i9 < i7; i9++) {
                    d -= dArr[(i4 + (i7 * i3)) + i9] * dArr2[(i5 + (i9 * i2)) + i6];
                }
                dArr2[i8] = d / dArr[(i4 + (i7 * i3)) + i7];
            }
        }
    }

    public static void solveTransL(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = i - 1; i7 >= 0; i7--) {
                int i8 = i5 + (i7 * i2) + i6;
                double d = dArr2[i8];
                for (int i9 = i7 + 1; i9 < i; i9++) {
                    d -= dArr[((i9 * i3) + i4) + i7] * dArr2[(i5 + (i9 * i2)) + i6];
                }
                dArr2[i8] = d / dArr[((i7 * i3) + i4) + i7];
            }
        }
    }

    public static void solveLTransB(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = i5 + (i6 * i);
                int i9 = i8 + i7;
                double d = dArr2[i9];
                int i10 = i4 + (i7 * i3);
                int i11 = i10 + i7;
                while (i10 != i11) {
                    d -= dArr[i10] * dArr2[i8];
                    i8++;
                    i10++;
                }
                dArr2[i9] = d / dArr[i11];
            }
        }
    }

    public static void solveU(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = i - 1; i7 >= 0; i7--) {
                int i8 = i5 + (i7 * i2) + i6;
                double d = dArr2[i8];
                for (int i9 = i7 + 1; i9 < i; i9++) {
                    d -= dArr[((i7 * i3) + i4) + i9] * dArr2[(i5 + (i9 * i2)) + i6];
                }
                dArr2[i8] = d / dArr[((i7 * i3) + i4) + i7];
            }
        }
    }

    public static void solveTransU(double[] dArr, double[] dArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = i5 + (i7 * i2) + i6;
                double d = dArr2[i8];
                for (int i9 = 0; i9 < i7; i9++) {
                    d -= dArr[(i4 + (i9 * i3)) + i7] * dArr2[(i5 + (i9 * i2)) + i6];
                }
                dArr2[i8] = d / dArr[(i4 + (i7 * i3)) + i7];
            }
        }
    }
}
