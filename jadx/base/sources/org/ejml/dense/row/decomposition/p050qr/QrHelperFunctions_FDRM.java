package org.ejml.dense.row.decomposition.p050qr;

import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class QrHelperFunctions_FDRM {
    public static float findMax(float[] fArr, int i, int i2) {
        int i3 = i2 + i;
        float f = -1.0f;
        while (i < i3) {
            float f2 = fArr[i];
            if (f2 < 0.0f) {
                f2 = -f2;
            }
            if (f2 > f) {
                f = f2;
            }
            i++;
        }
        return f;
    }

    public static void divideElements(int i, int i2, float[] fArr, float f) {
        while (i < i2) {
            fArr[i] = fArr[i] / f;
            i++;
        }
    }

    public static void divideElements(int i, int i2, float[] fArr, int i3, float f) {
        while (i < i2) {
            int i4 = i + i3;
            fArr[i4] = fArr[i4] / f;
            i++;
        }
    }

    public static void divideElements_Brow(int i, int i2, float[] fArr, float[] fArr2, int i3, float f) {
        while (i < i2) {
            int i4 = i + i3;
            float f2 = fArr2[i4] / f;
            fArr2[i4] = f2;
            fArr[i] = f2;
            i++;
        }
    }

    public static void divideElements_Bcol(int i, int i2, int i3, float[] fArr, float[] fArr2, int i4, float f) {
        int i5 = (i * i3) + i4;
        while (i < i2) {
            float f2 = fArr[i] / f;
            fArr[i] = f2;
            fArr2[i5] = f2;
            i++;
            i5 += i3;
        }
    }

    public static float computeTauAndDivide(int i, int i2, float[] fArr, int i3, float f) {
        float f2 = 0.0f;
        for (int i4 = i; i4 < i2; i4++) {
            int i5 = i3 + i4;
            float f3 = fArr[i5] / f;
            fArr[i5] = f3;
            f2 += f3 * f3;
        }
        float fSqrt = (float) Math.sqrt(f2);
        return fArr[i3 + i] < 0.0f ? -fSqrt : fSqrt;
    }

    public static float computeTauAndDivide(int i, int i2, float[] fArr, float f) {
        float f2 = 0.0f;
        for (int i3 = i; i3 < i2; i3++) {
            float f3 = fArr[i3] / f;
            fArr[i3] = f3;
            f2 += f3 * f3;
        }
        float fSqrt = (float) Math.sqrt(f2);
        return fArr[i] < 0.0f ? -fSqrt : fSqrt;
    }

    public static void rank1UpdateMultR(FMatrixRMaj fMatrixRMaj, float[] fArr, float f, int i, int i2, int i3, float[] fArr2) {
        for (int i4 = i; i4 < fMatrixRMaj.numCols; i4++) {
            fArr2[i4] = fArr[i2] * fMatrixRMaj.data[(fMatrixRMaj.numCols * i2) + i4];
        }
        for (int i5 = i2 + 1; i5 < i3; i5++) {
            int i6 = (fMatrixRMaj.numCols * i5) + i;
            float f2 = fArr[i5];
            int i7 = i;
            while (i7 < fMatrixRMaj.numCols) {
                fArr2[i7] = fArr2[i7] + (fMatrixRMaj.data[i6] * f2);
                i7++;
                i6++;
            }
        }
        for (int i8 = i; i8 < fMatrixRMaj.numCols; i8++) {
            fArr2[i8] = fArr2[i8] * f;
        }
        while (i2 < i3) {
            float f3 = fArr[i2];
            int i9 = (fMatrixRMaj.numCols * i2) + i;
            int i10 = i;
            while (i10 < fMatrixRMaj.numCols) {
                float[] fArr3 = fMatrixRMaj.data;
                fArr3[i9] = fArr3[i9] - (fArr2[i10] * f3);
                i10++;
                i9++;
            }
            i2++;
        }
    }

    public static void rank1UpdateMultR(FMatrixRMaj fMatrixRMaj, float[] fArr, int i, float f, int i2, int i3, int i4, float[] fArr2) {
        for (int i5 = i2; i5 < fMatrixRMaj.numCols; i5++) {
            fArr2[i5] = fArr[i3 + i] * fMatrixRMaj.data[(fMatrixRMaj.numCols * i3) + i5];
        }
        for (int i6 = i3 + 1; i6 < i4; i6++) {
            int i7 = (fMatrixRMaj.numCols * i6) + i2;
            float f2 = fArr[i6 + i];
            int i8 = i2;
            while (i8 < fMatrixRMaj.numCols) {
                fArr2[i8] = fArr2[i8] + (fMatrixRMaj.data[i7] * f2);
                i8++;
                i7++;
            }
        }
        for (int i9 = i2; i9 < fMatrixRMaj.numCols; i9++) {
            fArr2[i9] = fArr2[i9] * f;
        }
        while (i3 < i4) {
            float f3 = fArr[i3 + i];
            int i10 = (fMatrixRMaj.numCols * i3) + i2;
            int i11 = i2;
            while (i11 < fMatrixRMaj.numCols) {
                float[] fArr3 = fMatrixRMaj.data;
                fArr3[i10] = fArr3[i10] - (fArr2[i11] * f3);
                i11++;
                i10++;
            }
            i3++;
        }
    }

    public static void rank1UpdateMultL(FMatrixRMaj fMatrixRMaj, float[] fArr, float f, int i, int i2, int i3) {
        while (i < fMatrixRMaj.numRows) {
            int i4 = (fMatrixRMaj.numCols * i) + i2;
            float f2 = 0.0f;
            int i5 = i2;
            int i6 = i4;
            while (i5 < i3) {
                f2 += fMatrixRMaj.data[i6] * fArr[i5];
                i5++;
                i6++;
            }
            float f3 = (-f) * f2;
            int i7 = i2;
            while (i7 < i3) {
                float[] fArr2 = fMatrixRMaj.data;
                fArr2[i4] = fArr2[i4] + (fArr[i7] * f3);
                i7++;
                i4++;
            }
            i++;
        }
    }
}
