package org.ejml.dense.row.decompose.p048qr;

import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;

/* JADX INFO: loaded from: classes9.dex */
public class QrHelperFunctions_CDRM {
    private static float mag(float f, float f2) {
        return (f * f) + (f2 * f2);
    }

    public static float findMax(float[] fArr, int i, int i2) {
        int i3 = i * 2;
        int i4 = (i + i2) * 2;
        float f = -1.0f;
        while (i3 < i4) {
            int i5 = i3 + 1;
            float f2 = fArr[i3];
            i3 += 2;
            float f3 = fArr[i5];
            float f4 = (f2 * f2) + (f3 * f3);
            if (f4 > f) {
                f = f4;
            }
        }
        return (float) Math.sqrt(f);
    }

    public static void divideElements(int i, int i2, float[] fArr, int i3, float f, float f2) {
        float f3 = (f * f) + (f2 * f2);
        int i4 = (i3 + i) * 2;
        while (i < i2) {
            float f4 = fArr[i4];
            int i5 = i4 + 1;
            float f5 = fArr[i5];
            fArr[i4] = ((f4 * f) + (f5 * f2)) / f3;
            i4 += 2;
            fArr[i5] = ((f5 * f) - (f4 * f2)) / f3;
            i++;
        }
    }

    public static float computeTauGammaAndDivide(int i, int i2, float[] fArr, float f, Complex_F32 complex_F32) {
        float f2;
        float f3;
        float f4;
        int i3 = i * 2;
        int i4 = i3;
        float f5 = 0.0f;
        while (i < i2) {
            int i5 = i4 + 1;
            float f6 = fArr[i4] / f;
            fArr[i4] = f6;
            i4 += 2;
            float f7 = fArr[i5] / f;
            fArr[i5] = f7;
            f5 += (f6 * f6) + (f7 * f7);
            i++;
        }
        float fSqrt = (float) Math.sqrt(f5);
        float f8 = fArr[i3];
        float f9 = fArr[i3 + 1];
        float fSqrt2 = (float) Math.sqrt((f8 * f8) + (f9 * f9));
        if (fSqrt2 == 0.0f) {
            complex_F32.real = fSqrt;
            complex_F32.imaginary = 0.0f;
        } else {
            complex_F32.real = (f8 / fSqrt2) * fSqrt;
            complex_F32.imaginary = (f9 / fSqrt2) * fSqrt;
        }
        if (mag(f8 - complex_F32.real, f9 - complex_F32.imaginary) > mag(complex_F32.real + f8, complex_F32.imaginary + f9)) {
            complex_F32.real = -complex_F32.real;
            complex_F32.imaginary = -complex_F32.imaginary;
            f2 = fSqrt * fSqrt;
            f3 = f2 - (fSqrt * fSqrt2);
            f4 = (fSqrt2 * fSqrt2) - ((fSqrt * 2.0f) * fSqrt2);
        } else {
            f2 = fSqrt * fSqrt;
            f3 = (fSqrt * fSqrt2) + f2;
            f4 = (fSqrt2 * fSqrt2) + (fSqrt * 2.0f * fSqrt2);
        }
        return (f4 + f2) / f3;
    }

    public static void rank1UpdateMultR(CMatrixRMaj cMatrixRMaj, float[] fArr, int i, float f, int i2, int i3, int i4, float[] fArr2) {
        int i5 = (i3 + i) * 2;
        float f2 = fArr[i5];
        float f3 = -fArr[i5 + 1];
        int i6 = ((cMatrixRMaj.numCols * i3) + i2) * 2;
        int i7 = i2 * 2;
        int i8 = i7;
        for (int i9 = i2; i9 < cMatrixRMaj.numCols; i9++) {
            int i10 = i6 + 1;
            float f4 = cMatrixRMaj.data[i6];
            i6 += 2;
            float f5 = cMatrixRMaj.data[i10];
            int i11 = i8 + 1;
            fArr2[i8] = (f2 * f4) - (f3 * f5);
            i8 += 2;
            fArr2[i11] = (f5 * f2) + (f4 * f3);
        }
        for (int i12 = i3 + 1; i12 < i4; i12++) {
            int i13 = ((cMatrixRMaj.numCols * i12) + i2) * 2;
            int i14 = (i12 + i) * 2;
            float f6 = fArr[i14];
            float f7 = -fArr[i14 + 1];
            int i15 = i7;
            for (int i16 = i2; i16 < cMatrixRMaj.numCols; i16++) {
                int i17 = i13 + 1;
                float f8 = cMatrixRMaj.data[i13];
                i13 += 2;
                float f9 = cMatrixRMaj.data[i17];
                int i18 = i15 + 1;
                fArr2[i15] = fArr2[i15] + ((f6 * f8) - (f7 * f9));
                i15 += 2;
                fArr2[i18] = fArr2[i18] + (f9 * f6) + (f8 * f7);
            }
        }
        int i19 = i7;
        for (int i20 = i2; i20 < cMatrixRMaj.numCols; i20++) {
            int i21 = i19 + 1;
            fArr2[i19] = fArr2[i19] * f;
            i19 += 2;
            fArr2[i21] = fArr2[i21] * f;
        }
        for (int i22 = i3; i22 < i4; i22++) {
            int i23 = ((cMatrixRMaj.numCols * i22) + i2) * 2;
            int i24 = (i22 + i) * 2;
            float f10 = fArr[i24];
            float f11 = fArr[i24 + 1];
            int i25 = i7;
            for (int i26 = i2; i26 < cMatrixRMaj.numCols; i26++) {
                int i27 = i25 + 1;
                float f12 = fArr2[i25];
                i25 += 2;
                float f13 = fArr2[i27];
                float[] fArr3 = cMatrixRMaj.data;
                int i28 = i23 + 1;
                fArr3[i23] = fArr3[i23] - ((f10 * f12) - (f11 * f13));
                float[] fArr4 = cMatrixRMaj.data;
                i23 += 2;
                fArr4[i28] = fArr4[i28] - ((f13 * f10) + (f12 * f11));
            }
        }
    }

    public static void rank1UpdateMultL(CMatrixRMaj cMatrixRMaj, float[] fArr, int i, float f, int i2, int i3, int i4) {
        for (int i5 = i2; i5 < cMatrixRMaj.numRows; i5++) {
            int i6 = ((cMatrixRMaj.numCols * i5) + i3) * 2;
            int i7 = (i + i3) * 2;
            float f2 = 0.0f;
            int i8 = i6;
            int i9 = i7;
            float f3 = 0.0f;
            for (int i10 = i3; i10 < i4; i10++) {
                int i11 = i8 + 1;
                float f4 = cMatrixRMaj.data[i8];
                i8 += 2;
                float f5 = cMatrixRMaj.data[i11];
                int i12 = i9 + 1;
                float f6 = fArr[i9];
                i9 += 2;
                float f7 = fArr[i12];
                f2 += (f4 * f6) - (f5 * f7);
                f3 += (f4 * f7) + (f5 * f6);
            }
            float f8 = -f;
            float f9 = f2 * f8;
            float f10 = f8 * f3;
            for (int i13 = i3; i13 < i4; i13++) {
                int i14 = i7 + 1;
                float f11 = fArr[i7];
                i7 += 2;
                float f12 = -fArr[i14];
                float[] fArr2 = cMatrixRMaj.data;
                int i15 = i6 + 1;
                fArr2[i6] = fArr2[i6] + ((f9 * f11) - (f10 * f12));
                float[] fArr3 = cMatrixRMaj.data;
                i6 += 2;
                fArr3[i15] = fArr3[i15] + (f12 * f9) + (f11 * f10);
            }
        }
    }

    public static void extractHouseholderColumn(CMatrixRMaj cMatrixRMaj, int i, int i2, int i3, float[] fArr, int i4) {
        int i5 = (i4 + i) * 2;
        int i6 = i5 + 1;
        fArr[i5] = 1.0f;
        int i7 = i5 + 2;
        fArr[i6] = 0.0f;
        while (true) {
            i++;
            if (i >= i2) {
                return;
            }
            int index = cMatrixRMaj.getIndex(i, i3);
            int i8 = i7 + 1;
            fArr[i7] = cMatrixRMaj.data[index];
            i7 += 2;
            fArr[i8] = cMatrixRMaj.data[index + 1];
        }
    }

    public static void extractHouseholderRow(CMatrixRMaj cMatrixRMaj, int i, int i2, int i3, float[] fArr, int i4) {
        int i5 = (i4 + i2) * 2;
        fArr[i5] = 1.0f;
        fArr[i5 + 1] = 0.0f;
        System.arraycopy(cMatrixRMaj.data, ((i * cMatrixRMaj.numCols) + i2 + 1) * 2, fArr, i5 + 2, ((i3 - i2) - 1) * 2);
    }

    public static float extractColumnAndMax(CMatrixRMaj cMatrixRMaj, int i, int i2, int i3, float[] fArr, int i4) {
        int i5 = (i4 + i) * 2;
        int index = cMatrixRMaj.getIndex(i, i3);
        float[] fArr2 = cMatrixRMaj.data;
        float f = 0.0f;
        while (i < i2) {
            int i6 = i5 + 1;
            float f2 = fArr2[index];
            fArr[i5] = f2;
            i5 += 2;
            float f3 = fArr2[index + 1];
            fArr[i6] = f3;
            float f4 = (f2 * f2) + (f3 * f3);
            if (f < f4) {
                f = f4;
            }
            i++;
            index += cMatrixRMaj.numCols * 2;
        }
        return (float) Math.sqrt(f);
    }

    public static float computeRowMax(CMatrixRMaj cMatrixRMaj, int i, int i2, int i3) {
        int index = cMatrixRMaj.getIndex(i, i2);
        float[] fArr = cMatrixRMaj.data;
        float f = 0.0f;
        while (i2 < i3) {
            int i4 = index + 1;
            float f2 = fArr[index];
            index += 2;
            float f3 = fArr[i4];
            float f4 = (f2 * f2) + (f3 * f3);
            if (f < f4) {
                f = f4;
            }
            i2++;
        }
        return (float) Math.sqrt(f);
    }
}
