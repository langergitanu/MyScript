package org.ejml.dense.block.decomposition.chol;

import org.ejml.data.FSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class InnerCholesky_FDRB {
    public static boolean upper(FSubmatrixD1 fSubmatrixD1) {
        int i = fSubmatrixD1.row1 - fSubmatrixD1.row0;
        return upper(fSubmatrixD1.original.data, (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (fSubmatrixD1.col0 * i), i);
    }

    public static boolean lower(FSubmatrixD1 fSubmatrixD1) {
        int i = fSubmatrixD1.row1 - fSubmatrixD1.row0;
        return lower(fSubmatrixD1.original.data, (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + (fSubmatrixD1.col0 * i), i);
    }

    public static boolean upper(float[] fArr, int i, int i2) {
        float f = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                int i5 = (i3 * i2) + i;
                int i6 = i5 + i4;
                float f2 = fArr[i6];
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = (i7 * i2) + i;
                    f2 -= fArr[i8 + i3] * fArr[i8 + i4];
                }
                if (i3 == i4) {
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    float fSqrt = (float) Math.sqrt(f2);
                    fArr[i5 + i3] = fSqrt;
                    f = 1.0f / fSqrt;
                } else {
                    fArr[i6] = f2 * f;
                }
            }
        }
        return true;
    }

    public static boolean lower(float[] fArr, int i, int i2) {
        float f = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                int i5 = (i4 * i2) + i;
                int i6 = i5 + i3;
                float f2 = fArr[i6];
                for (int i7 = 0; i7 < i3; i7++) {
                    f2 -= fArr[((i3 * i2) + i) + i7] * fArr[i5 + i7];
                }
                if (i3 == i4) {
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    float fSqrt = (float) Math.sqrt(f2);
                    fArr[(i3 * i2) + i + i3] = fSqrt;
                    f = 1.0f / fSqrt;
                } else {
                    fArr[i6] = f2 * f;
                }
            }
        }
        return true;
    }
}
