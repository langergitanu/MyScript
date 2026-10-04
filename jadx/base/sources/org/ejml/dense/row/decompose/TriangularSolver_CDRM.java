package org.ejml.dense.row.decompose;

/* JADX INFO: loaded from: classes9.dex */
public class TriangularSolver_CDRM {
    public static void solveU(float[] fArr, float[] fArr2, int i) {
        int i2 = i * 2;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            int i4 = i3 * 2;
            float f = fArr2[i4];
            int i5 = i4 + 1;
            float f2 = fArr2[i5];
            int i6 = (i3 * i2) + i4;
            int i7 = i6 + 2;
            for (int i8 = i3 + 1; i8 < i; i8++) {
                int i9 = i8 * 2;
                float f3 = fArr2[i9];
                float f4 = fArr2[i9 + 1];
                int i10 = i7 + 1;
                float f5 = fArr[i7];
                i7 += 2;
                float f6 = fArr[i10];
                f -= (f3 * f5) - (f4 * f6);
                f2 -= (f3 * f6) + (f4 * f5);
            }
            float f7 = fArr[i6];
            float f8 = fArr[i6 + 1];
            float f9 = (f7 * f7) + (f8 * f8);
            fArr2[i4] = ((f * f7) + (f2 * f8)) / f9;
            fArr2[i5] = ((f2 * f7) - (f * f8)) / f9;
        }
    }

    public static void solveL_diagReal(float[] fArr, float[] fArr2, int i) {
        int i2 = i * 2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * 2;
            float f = fArr2[i4];
            int i5 = i4 + 1;
            float f2 = fArr2[i5];
            int i6 = i3 * i2;
            int i7 = 0;
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = i6 + 1;
                float f3 = fArr[i6];
                i6 += 2;
                float f4 = fArr[i9];
                int i10 = i7 + 1;
                float f5 = fArr2[i7];
                i7 += 2;
                float f6 = fArr2[i10];
                f -= (f3 * f5) - (f4 * f6);
                f2 -= (f3 * f6) + (f4 * f5);
            }
            float f7 = fArr[i6];
            fArr2[i4] = f / f7;
            fArr2[i5] = f2 / f7;
        }
    }

    public static void solveConjTranL_diagReal(float[] fArr, float[] fArr2, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            int i3 = i2 * 2;
            float f = fArr2[i3];
            int i4 = i3 + 1;
            float f2 = fArr2[i4];
            int i5 = i2 + 1;
            int i6 = i5 * 2;
            while (i5 < i) {
                int i7 = ((i5 * i) + i2) * 2;
                float f3 = fArr[i7];
                float f4 = fArr[i7 + 1];
                int i8 = i6 + 1;
                float f5 = fArr2[i6];
                i6 += 2;
                float f6 = fArr2[i8];
                f -= (f3 * f5) + (f4 * f6);
                f2 -= (f3 * f6) - (f4 * f5);
                i5++;
            }
            float f7 = fArr[((i2 * i) + i2) * 2];
            fArr2[i3] = f / f7;
            fArr2[i4] = f2 / f7;
        }
    }
}
