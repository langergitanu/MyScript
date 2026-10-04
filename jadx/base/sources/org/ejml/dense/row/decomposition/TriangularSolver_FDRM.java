package org.ejml.dense.row.decomposition;

/* JADX INFO: loaded from: classes9.dex */
public class TriangularSolver_FDRM {
    public static void invertLower(float[] fArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * i;
            int i4 = i3 + i2;
            float f = fArr[i4];
            for (int i5 = 0; i5 < i2; i5++) {
                float f2 = 0.0f;
                for (int i6 = i5; i6 < i2; i6++) {
                    f2 += fArr[i3 + i6] * fArr[(i6 * i) + i5];
                }
                fArr[i3 + i5] = (-f2) / f;
            }
            fArr[i4] = 1.0f / f;
        }
    }

    public static void invertLower(float[] fArr, float[] fArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * i;
            int i4 = i3 + i2;
            float f = fArr[i4];
            for (int i5 = 0; i5 < i2; i5++) {
                float f2 = 0.0f;
                for (int i6 = i5; i6 < i2; i6++) {
                    f2 -= fArr[i3 + i6] * fArr2[(i6 * i) + i5];
                }
                fArr2[i3 + i5] = f2 / f;
            }
            fArr2[i4] = 1.0f / f;
        }
    }

    public static void solveL(float[] fArr, float[] fArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            float f = fArr2[i2];
            int i3 = i2 * i;
            int i4 = 0;
            while (i4 < i2) {
                f -= fArr[i3] * fArr2[i4];
                i4++;
                i3++;
            }
            fArr2[i2] = f / fArr[i3];
        }
    }

    public static void solveL(float[] fArr, float[] fArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = (i4 * i2) + i3;
                float f = fArr2[i5];
                for (int i6 = 0; i6 < i4; i6++) {
                    f -= fArr[(i4 * i) + i6] * fArr2[(i6 * i2) + i3];
                }
                fArr2[i5] = f / fArr[(i4 * i) + i4];
            }
        }
    }

    public static void solveTranL(float[] fArr, float[] fArr2, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            float f = fArr2[i2];
            for (int i3 = i2 + 1; i3 < i; i3++) {
                f -= fArr[(i3 * i) + i2] * fArr2[i3];
            }
            fArr2[i2] = f / fArr[(i2 * i) + i2];
        }
    }

    public static void solveU(float[] fArr, float[] fArr2, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            float f = fArr2[i2];
            int i3 = (i2 * i) + i2;
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            while (i5 < i) {
                f -= fArr[i4] * fArr2[i5];
                i5++;
                i4++;
            }
            fArr2[i2] = f / fArr[i3];
        }
    }

    public static void solveU(float[] fArr, float[] fArr2, int i, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            float f = fArr2[i4];
            int i5 = (i4 * i) + i4;
            int i6 = i5 + 1;
            int i7 = i4 + 1;
            while (i7 < i3) {
                f -= fArr[i6] * fArr2[i7];
                i7++;
                i6++;
            }
            fArr2[i4] = f / fArr[i5];
        }
    }

    public static void solveU(float[] fArr, int i, int i2, int i3, float[] fArr2, int i4, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            for (int i8 = i3 - 1; i8 >= 0; i8--) {
                int i9 = (i8 * i5) + i4 + i7;
                float f = fArr2[i9];
                for (int i10 = i8 + 1; i10 < i3; i10++) {
                    f -= fArr[((i8 * i2) + i) + i10] * fArr2[((i10 * i5) + i4) + i7];
                }
                fArr2[i9] = f / fArr[((i8 * i2) + i) + i8];
            }
        }
    }
}
