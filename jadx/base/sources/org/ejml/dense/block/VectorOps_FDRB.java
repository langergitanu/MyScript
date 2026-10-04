package org.ejml.dense.block;

import org.ejml.data.FSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class VectorOps_FDRB {
    public static void scale_row(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f, FSubmatrixD1 fSubmatrixD12, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i5;
        float[] fArr = fSubmatrixD1.original.data;
        float[] fArr2 = fSubmatrixD12.original.data;
        int i8 = i4 % i6;
        int i9 = i4 - i8;
        int i10 = i2 % i6;
        int i11 = (fSubmatrixD1.row0 + i2) - i10;
        int i12 = i3 % i6;
        int i13 = (fSubmatrixD12.row0 + i3) - i12;
        int iMin = Math.min(i6, fSubmatrixD1.row1 - i11);
        int iMin2 = Math.min(i6, fSubmatrixD12.row1 - i13);
        int i14 = i9;
        while (i14 < i7) {
            int iMin3 = Math.min(i6, i7 - i14);
            int iMin4 = Math.min(i6, (fSubmatrixD1.col1 - fSubmatrixD1.col0) - i14);
            int iMin5 = Math.min(i6, (fSubmatrixD12.col1 - fSubmatrixD12.col0) - i14);
            int i15 = (fSubmatrixD1.original.numCols * i11) + ((fSubmatrixD1.col0 + i14) * iMin) + (i10 * iMin4);
            int i16 = (fSubmatrixD12.original.numCols * i13) + ((fSubmatrixD12.col0 + i14) * iMin2) + (iMin5 * i12);
            if (i14 == i9) {
                int i17 = i15 + i8;
                int i18 = i16 + i8;
                int i19 = i8;
                while (i19 < iMin3) {
                    fArr2[i18] = fArr[i17] * f;
                    i19++;
                    i18++;
                    i17++;
                }
            } else {
                int i20 = i15;
                int i21 = i16;
                int i22 = 0;
                while (i22 < iMin3) {
                    fArr2[i21] = fArr[i20] * f;
                    i22++;
                    i21++;
                    i20++;
                }
            }
            i14 += i;
            i6 = i;
            i7 = i5;
        }
    }

    public static void div_row(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f, FSubmatrixD1 fSubmatrixD12, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i5;
        float[] fArr = fSubmatrixD1.original.data;
        float[] fArr2 = fSubmatrixD12.original.data;
        int i8 = i4 % i6;
        int i9 = i4 - i8;
        int i10 = i2 % i6;
        int i11 = (fSubmatrixD1.row0 + i2) - i10;
        int i12 = i3 % i6;
        int i13 = (fSubmatrixD12.row0 + i3) - i12;
        int iMin = Math.min(i6, fSubmatrixD1.row1 - i11);
        int iMin2 = Math.min(i6, fSubmatrixD12.row1 - i13);
        int i14 = i9;
        while (i14 < i7) {
            int iMin3 = Math.min(i6, i7 - i14);
            int iMin4 = Math.min(i6, (fSubmatrixD1.col1 - fSubmatrixD1.col0) - i14);
            int iMin5 = Math.min(i6, (fSubmatrixD12.col1 - fSubmatrixD12.col0) - i14);
            int i15 = (fSubmatrixD1.original.numCols * i11) + ((fSubmatrixD1.col0 + i14) * iMin) + (i10 * iMin4);
            int i16 = (fSubmatrixD12.original.numCols * i13) + ((fSubmatrixD12.col0 + i14) * iMin2) + (iMin5 * i12);
            if (i14 == i9) {
                int i17 = i15 + i8;
                int i18 = i16 + i8;
                int i19 = i8;
                while (i19 < iMin3) {
                    fArr2[i18] = fArr[i17] / f;
                    i19++;
                    i18++;
                    i17++;
                }
            } else {
                int i20 = i15;
                int i21 = i16;
                int i22 = 0;
                while (i22 < iMin3) {
                    fArr2[i21] = fArr[i20] / f;
                    i22++;
                    i21++;
                    i20++;
                }
            }
            i14 += i;
            i6 = i;
            i7 = i5;
        }
    }

    public static void add_row(int i, FSubmatrixD1 fSubmatrixD1, int i2, float f, FSubmatrixD1 fSubmatrixD12, int i3, float f2, FSubmatrixD1 fSubmatrixD13, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i6;
        int iMin = Math.min(i7, fSubmatrixD1.row1 - fSubmatrixD1.row0);
        int iMin2 = Math.min(i7, fSubmatrixD12.row1 - fSubmatrixD12.row0);
        int iMin3 = Math.min(i7, fSubmatrixD13.row1 - fSubmatrixD13.row0);
        int i9 = i5 % i7;
        int i10 = i5 - i9;
        float[] fArr = fSubmatrixD1.original.data;
        float[] fArr2 = fSubmatrixD12.original.data;
        float[] fArr3 = fSubmatrixD13.original.data;
        int i11 = i10;
        while (i11 < i8) {
            int iMin4 = Math.min(i7, i8 - i11);
            int iMin5 = Math.min(i7, (fSubmatrixD1.col1 - fSubmatrixD1.col0) - i11);
            int iMin6 = Math.min(i7, (fSubmatrixD12.col1 - fSubmatrixD12.col0) - i11);
            int iMin7 = Math.min(i7, (fSubmatrixD13.col1 - fSubmatrixD13.col0) - i11);
            int i12 = (fSubmatrixD1.row0 * fSubmatrixD1.original.numCols) + ((fSubmatrixD1.col0 + i11) * iMin) + (i2 * iMin5);
            int i13 = (fSubmatrixD12.original.numCols * fSubmatrixD12.row0) + ((fSubmatrixD12.col0 + i11) * iMin2) + (iMin6 * i3);
            int i14 = (fSubmatrixD13.original.numCols * fSubmatrixD13.row0) + ((fSubmatrixD13.col0 + i11) * iMin3) + (iMin7 * i4);
            if (i11 == i10) {
                int i15 = i12 + i9;
                int i16 = i13 + i9;
                int i17 = i14 + i9;
                int i18 = i9;
                while (i18 < iMin4) {
                    fArr3[i17] = (fArr[i15] * f) + (fArr2[i16] * f2);
                    i18++;
                    i17++;
                    i15++;
                    i16++;
                }
            } else {
                int i19 = i12;
                int i20 = 0;
                int i21 = i13;
                while (i20 < iMin4) {
                    fArr3[i14] = (fArr[i19] * f) + (fArr2[i21] * f2);
                    i20++;
                    i14++;
                    i19++;
                    i21++;
                }
            }
            i11 += i;
            i7 = i;
            i8 = i6;
        }
    }

    public static float dot_row(int i, FSubmatrixD1 fSubmatrixD1, int i2, FSubmatrixD1 fSubmatrixD12, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i5;
        int i8 = i4 % i6;
        int i9 = i4 - i8;
        float[] fArr = fSubmatrixD1.original.data;
        float[] fArr2 = fSubmatrixD12.original.data;
        int i10 = i2 % i6;
        int i11 = (fSubmatrixD1.row0 + i2) - i10;
        int i12 = i3 % i6;
        int i13 = (fSubmatrixD12.row0 + i3) - i12;
        int iMin = Math.min(i6, fSubmatrixD1.row1 - i11);
        int iMin2 = Math.min(i6, fSubmatrixD12.row1 - i13);
        if (fSubmatrixD1.col1 - fSubmatrixD1.col0 != fSubmatrixD12.col1 - fSubmatrixD12.col0) {
            throw new RuntimeException();
        }
        float f = 0.0f;
        int i14 = i9;
        while (i14 < i7) {
            int iMin3 = Math.min(i6, i7 - i14);
            int iMin4 = Math.min(i6, (fSubmatrixD1.col1 - fSubmatrixD1.col0) - i14);
            int iMin5 = Math.min(i6, (fSubmatrixD12.col1 - fSubmatrixD12.col0) - i14);
            int i15 = (fSubmatrixD1.original.numCols * i11) + ((fSubmatrixD1.col0 + i14) * iMin) + (i10 * iMin4);
            int i16 = (fSubmatrixD12.original.numCols * i13) + ((fSubmatrixD12.col0 + i14) * iMin2) + (iMin5 * i12);
            if (i14 == i9) {
                int i17 = i15 + i8;
                int i18 = i16 + i8;
                int i19 = i8;
                while (i19 < iMin3) {
                    f += fArr2[i18] * fArr[i17];
                    i19++;
                    i18++;
                    i17++;
                }
            } else {
                float f2 = f;
                int i20 = 0;
                int i21 = i15;
                while (i20 < iMin3) {
                    f2 += fArr2[i16] * fArr[i21];
                    i20++;
                    i16++;
                    i21++;
                }
                f = f2;
            }
            i14 += i;
            i6 = i;
            i7 = i5;
        }
        return f;
    }

    public static float dot_row_col(int i, FSubmatrixD1 fSubmatrixD1, int i2, FSubmatrixD1 fSubmatrixD12, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i5;
        int i8 = i4 % i6;
        int i9 = i4 - i8;
        float[] fArr = fSubmatrixD1.original.data;
        float[] fArr2 = fSubmatrixD12.original.data;
        int i10 = i2 % i6;
        int i11 = (fSubmatrixD1.row0 + i2) - i10;
        int i12 = i3 % i6;
        int i13 = (fSubmatrixD12.col0 + i3) - i12;
        int iMin = Math.min(i6, fSubmatrixD1.row1 - i11);
        int iMin2 = Math.min(i6, fSubmatrixD12.col1 - i13);
        if (fSubmatrixD1.col1 - fSubmatrixD1.col0 != fSubmatrixD12.col1 - fSubmatrixD12.col0) {
            throw new RuntimeException();
        }
        float f = 0.0f;
        int i14 = i9;
        while (i14 < i7) {
            int iMin3 = Math.min(i6, i7 - i14);
            int iMin4 = Math.min(i6, (fSubmatrixD1.col1 - fSubmatrixD1.col0) - i14);
            int iMin5 = Math.min(i6, (fSubmatrixD12.row1 - fSubmatrixD12.row0) - i14);
            int i15 = (fSubmatrixD1.original.numCols * i11) + ((fSubmatrixD1.col0 + i14) * iMin) + (i10 * iMin4);
            int i16 = (fSubmatrixD12.original.numCols * (fSubmatrixD12.row0 + i14)) + (iMin5 * i13) + i12;
            if (i14 == i9) {
                int i17 = i15 + i8;
                int i18 = i16 + (i8 * iMin2);
                int i19 = i8;
                while (i19 < iMin3) {
                    f += fArr2[i18] * fArr[i17];
                    i19++;
                    i18 += iMin2;
                    i17++;
                }
            } else {
                float f2 = f;
                int i20 = 0;
                int i21 = i15;
                while (i20 < iMin3) {
                    f2 += fArr2[i16] * fArr[i21];
                    i20++;
                    i16 += iMin2;
                    i21++;
                }
                f = f2;
            }
            i14 += i;
            i6 = i;
            i7 = i5;
        }
        return f;
    }
}
