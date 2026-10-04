package org.ejml.dense.block;

/* JADX INFO: loaded from: classes9.dex */
public class InnerTriangularSolver_FDRB {
    public static void invertLower(float[] fArr, float[] fArr2, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = i4 * i;
            int i6 = i2 + i5;
            float f = fArr[i6 + i4];
            for (int i7 = 0; i7 < i4; i7++) {
                float f2 = 0.0f;
                for (int i8 = i7; i8 < i4; i8++) {
                    f2 += fArr[i6 + i8] * fArr2[(i8 * i) + i3 + i7];
                }
                fArr2[i3 + i5 + i7] = (-f2) / f;
            }
            fArr2[i5 + i3 + i4] = 1.0f / f;
        }
    }

    public static void invertLower(float[] fArr, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = (i3 * i) + i2;
            int i5 = i4 + i3;
            float f = fArr[i5];
            for (int i6 = 0; i6 < i3; i6++) {
                float f2 = 0.0f;
                for (int i7 = i6; i7 < i3; i7++) {
                    f2 += fArr[i4 + i7] * fArr[(i7 * i) + i2 + i6];
                }
                fArr[i4 + i6] = (-f2) / f;
            }
            fArr[i5] = 1.0f / f;
        }
    }

    public static void solveL(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = (i7 * i2) + i5 + i6;
                float f = fArr2[i8];
                for (int i9 = 0; i9 < i7; i9++) {
                    f -= fArr[((i7 * i3) + i4) + i9] * fArr2[((i9 * i2) + i5) + i6];
                }
                fArr2[i8] = f / fArr[((i7 * i3) + i4) + i7];
            }
        }
    }

    public static void solveTransL(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = i - 1; i7 >= 0; i7--) {
                int i8 = (i7 * i2) + i5 + i6;
                float f = fArr2[i8];
                for (int i9 = i7 + 1; i9 < i; i9++) {
                    f -= fArr[((i9 * i3) + i4) + i7] * fArr2[((i9 * i2) + i5) + i6];
                }
                fArr2[i8] = f / fArr[((i7 * i3) + i4) + i7];
            }
        }
    }

    public static void solveLTransB(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = i5 + (i6 * i);
                int i9 = i8 + i7;
                float f = fArr2[i9];
                int i10 = (i7 * i3) + i4;
                int i11 = i10 + i7;
                while (i10 != i11) {
                    f -= fArr[i10] * fArr2[i8];
                    i10++;
                    i8++;
                }
                fArr2[i9] = f / fArr[i11];
            }
        }
    }

    public static void solveU(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = i - 1; i7 >= 0; i7--) {
                int i8 = (i7 * i2) + i5 + i6;
                float f = fArr2[i8];
                for (int i9 = i7 + 1; i9 < i; i9++) {
                    f -= fArr[((i7 * i3) + i4) + i9] * fArr2[((i9 * i2) + i5) + i6];
                }
                fArr2[i8] = f / fArr[((i7 * i3) + i4) + i7];
            }
        }
    }

    public static void solveTransU(float[] fArr, float[] fArr2, int i, int i2, int i3, int i4, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = (i7 * i2) + i5 + i6;
                float f = fArr2[i8];
                for (int i9 = 0; i9 < i7; i9++) {
                    f -= fArr[((i9 * i3) + i4) + i7] * fArr2[((i9 * i2) + i5) + i6];
                }
                fArr2[i8] = f / fArr[((i7 * i3) + i4) + i7];
            }
        }
    }
}
