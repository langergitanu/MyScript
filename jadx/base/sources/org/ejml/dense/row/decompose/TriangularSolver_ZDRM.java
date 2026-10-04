package org.ejml.dense.row.decompose;

/* JADX INFO: loaded from: classes9.dex */
public class TriangularSolver_ZDRM {
    public static void solveU(double[] dArr, double[] dArr2, int i) {
        int i2 = i * 2;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            int i4 = i3 * 2;
            double d = dArr2[i4];
            int i5 = i4 + 1;
            double d2 = dArr2[i5];
            int i6 = (i3 * i2) + i4;
            int i7 = i6 + 2;
            for (int i8 = i3 + 1; i8 < i; i8++) {
                int i9 = i8 * 2;
                double d3 = dArr2[i9];
                double d4 = dArr2[i9 + 1];
                int i10 = i7 + 1;
                double d5 = dArr[i7];
                i7 += 2;
                double d6 = dArr[i10];
                d -= (d3 * d5) - (d4 * d6);
                d2 -= (d3 * d6) + (d4 * d5);
            }
            double d7 = dArr[i6];
            double d8 = dArr[i6 + 1];
            double d9 = (d7 * d7) + (d8 * d8);
            dArr2[i4] = ((d * d7) + (d2 * d8)) / d9;
            dArr2[i5] = ((d2 * d7) - (d * d8)) / d9;
        }
    }

    public static void solveL_diagReal(double[] dArr, double[] dArr2, int i) {
        int i2 = i * 2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * 2;
            double d = dArr2[i4];
            int i5 = i4 + 1;
            double d2 = dArr2[i5];
            int i6 = i3 * i2;
            int i7 = 0;
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = i6 + 1;
                double d3 = dArr[i6];
                i6 += 2;
                double d4 = dArr[i9];
                int i10 = i7 + 1;
                double d5 = dArr2[i7];
                i7 += 2;
                double d6 = dArr2[i10];
                d -= (d3 * d5) - (d4 * d6);
                d2 -= (d3 * d6) + (d4 * d5);
            }
            double d7 = dArr[i6];
            dArr2[i4] = d / d7;
            dArr2[i5] = d2 / d7;
        }
    }

    public static void solveConjTranL_diagReal(double[] dArr, double[] dArr2, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            int i3 = i2 * 2;
            double d = dArr2[i3];
            int i4 = i3 + 1;
            double d2 = dArr2[i4];
            int i5 = i2 + 1;
            int i6 = i5 * 2;
            while (i5 < i) {
                int i7 = ((i5 * i) + i2) * 2;
                double d3 = dArr[i7];
                double d4 = dArr[i7 + 1];
                int i8 = i6 + 1;
                double d5 = dArr2[i6];
                i6 += 2;
                double d6 = dArr2[i8];
                d -= (d3 * d5) + (d4 * d6);
                d2 -= (d3 * d6) - (d4 * d5);
                i5++;
            }
            double d7 = dArr[((i2 * i) + i2) * 2];
            dArr2[i3] = d / d7;
            dArr2[i4] = d2 / d7;
        }
    }
}
