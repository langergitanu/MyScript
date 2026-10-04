package org.ejml.dense.block;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DSubmatrixD1;

/* JADX INFO: loaded from: classes9.dex */
public class VectorOps_DDRB {
    public static void scale_row(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d, DSubmatrixD1 dSubmatrixD12, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i5;
        double[] dArr = dSubmatrixD1.original.data;
        double[] dArr2 = dSubmatrixD12.original.data;
        int i8 = i4 % i6;
        int i9 = i4 - i8;
        int i10 = i2 % i6;
        int i11 = (dSubmatrixD1.row0 + i2) - i10;
        int i12 = i3 % i6;
        int i13 = (dSubmatrixD12.row0 + i3) - i12;
        int iMin = Math.min(i6, dSubmatrixD1.row1 - i11);
        int iMin2 = Math.min(i6, dSubmatrixD12.row1 - i13);
        int i14 = i9;
        while (i14 < i7) {
            int iMin3 = Math.min(i6, i7 - i14);
            int iMin4 = Math.min(i6, (dSubmatrixD1.col1 - dSubmatrixD1.col0) - i14);
            int iMin5 = Math.min(i6, (dSubmatrixD12.col1 - dSubmatrixD12.col0) - i14);
            int i15 = (dSubmatrixD1.original.numCols * i11) + ((dSubmatrixD1.col0 + i14) * iMin) + (i10 * iMin4);
            int i16 = (dSubmatrixD12.original.numCols * i13) + ((dSubmatrixD12.col0 + i14) * iMin2) + (iMin5 * i12);
            if (i14 == i9) {
                int i17 = i15 + i8;
                int i18 = i16 + i8;
                int i19 = i8;
                while (i19 < iMin3) {
                    dArr2[i18] = dArr[i17] * d;
                    i19++;
                    i18++;
                    i17++;
                }
            } else {
                int i20 = i15;
                int i21 = i16;
                int i22 = 0;
                while (i22 < iMin3) {
                    dArr2[i21] = dArr[i20] * d;
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

    public static void div_row(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d, DSubmatrixD1 dSubmatrixD12, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i5;
        double[] dArr = dSubmatrixD1.original.data;
        double[] dArr2 = dSubmatrixD12.original.data;
        int i8 = i4 % i6;
        int i9 = i4 - i8;
        int i10 = i2 % i6;
        int i11 = (dSubmatrixD1.row0 + i2) - i10;
        int i12 = i3 % i6;
        int i13 = (dSubmatrixD12.row0 + i3) - i12;
        int iMin = Math.min(i6, dSubmatrixD1.row1 - i11);
        int iMin2 = Math.min(i6, dSubmatrixD12.row1 - i13);
        int i14 = i9;
        while (i14 < i7) {
            int iMin3 = Math.min(i6, i7 - i14);
            int iMin4 = Math.min(i6, (dSubmatrixD1.col1 - dSubmatrixD1.col0) - i14);
            int iMin5 = Math.min(i6, (dSubmatrixD12.col1 - dSubmatrixD12.col0) - i14);
            int i15 = (dSubmatrixD1.original.numCols * i11) + ((dSubmatrixD1.col0 + i14) * iMin) + (i10 * iMin4);
            int i16 = (dSubmatrixD12.original.numCols * i13) + ((dSubmatrixD12.col0 + i14) * iMin2) + (iMin5 * i12);
            if (i14 == i9) {
                int i17 = i15 + i8;
                int i18 = i16 + i8;
                int i19 = i8;
                while (i19 < iMin3) {
                    dArr2[i18] = dArr[i17] / d;
                    i19++;
                    i18++;
                    i17++;
                }
            } else {
                int i20 = i15;
                int i21 = i16;
                int i22 = 0;
                while (i22 < iMin3) {
                    dArr2[i21] = dArr[i20] / d;
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

    public static void add_row(int i, DSubmatrixD1 dSubmatrixD1, int i2, double d, DSubmatrixD1 dSubmatrixD12, int i3, double d2, DSubmatrixD1 dSubmatrixD13, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i6;
        int iMin = Math.min(i7, dSubmatrixD1.row1 - dSubmatrixD1.row0);
        int iMin2 = Math.min(i7, dSubmatrixD12.row1 - dSubmatrixD12.row0);
        int iMin3 = Math.min(i7, dSubmatrixD13.row1 - dSubmatrixD13.row0);
        int i9 = i5 % i7;
        int i10 = i5 - i9;
        double[] dArr = dSubmatrixD1.original.data;
        double[] dArr2 = dSubmatrixD12.original.data;
        double[] dArr3 = dSubmatrixD13.original.data;
        int i11 = i10;
        while (i11 < i8) {
            int iMin4 = Math.min(i7, i8 - i11);
            int iMin5 = Math.min(i7, (dSubmatrixD1.col1 - dSubmatrixD1.col0) - i11);
            int iMin6 = Math.min(i7, (dSubmatrixD12.col1 - dSubmatrixD12.col0) - i11);
            int iMin7 = Math.min(i7, (dSubmatrixD13.col1 - dSubmatrixD13.col0) - i11);
            int i12 = (dSubmatrixD1.row0 * dSubmatrixD1.original.numCols) + ((dSubmatrixD1.col0 + i11) * iMin) + (i2 * iMin5);
            int i13 = (dSubmatrixD12.original.numCols * dSubmatrixD12.row0) + ((dSubmatrixD12.col0 + i11) * iMin2) + (iMin6 * i3);
            int i14 = (dSubmatrixD13.original.numCols * dSubmatrixD13.row0) + ((dSubmatrixD13.col0 + i11) * iMin3) + (iMin7 * i4);
            if (i11 == i10) {
                int i15 = i12 + i9;
                int i16 = i13 + i9;
                int i17 = i14 + i9;
                int i18 = i9;
                while (i18 < iMin4) {
                    dArr3[i17] = (dArr[i15] * d) + (dArr2[i16] * d2);
                    i18++;
                    i16++;
                    i17++;
                    i15++;
                }
            } else {
                int i19 = i12;
                int i20 = 0;
                int i21 = i13;
                while (i20 < iMin4) {
                    dArr3[i14] = (dArr[i19] * d) + (dArr2[i21] * d2);
                    i20++;
                    i21++;
                    i14++;
                    i19++;
                }
            }
            i11 += i;
            i7 = i;
            i8 = i6;
        }
    }

    public static double dot_row(int i, DSubmatrixD1 dSubmatrixD1, int i2, DSubmatrixD1 dSubmatrixD12, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i5;
        int i8 = i4 % i6;
        int i9 = i4 - i8;
        double[] dArr = dSubmatrixD1.original.data;
        double[] dArr2 = dSubmatrixD12.original.data;
        int i10 = i2 % i6;
        int i11 = (dSubmatrixD1.row0 + i2) - i10;
        int i12 = i3 % i6;
        int i13 = (dSubmatrixD12.row0 + i3) - i12;
        int iMin = Math.min(i6, dSubmatrixD1.row1 - i11);
        int iMin2 = Math.min(i6, dSubmatrixD12.row1 - i13);
        if (dSubmatrixD1.col1 - dSubmatrixD1.col0 != dSubmatrixD12.col1 - dSubmatrixD12.col0) {
            throw new RuntimeException();
        }
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i14 = i9;
        while (i14 < i7) {
            int iMin3 = Math.min(i6, i5 - i14);
            double[] dArr3 = dArr;
            int iMin4 = Math.min(i6, (dSubmatrixD1.col1 - dSubmatrixD1.col0) - i14);
            int iMin5 = Math.min(i6, (dSubmatrixD12.col1 - dSubmatrixD12.col0) - i14);
            int i15 = (dSubmatrixD1.original.numCols * i11) + ((dSubmatrixD1.col0 + i14) * iMin) + (i10 * iMin4);
            int i16 = (dSubmatrixD12.original.numCols * i13) + ((dSubmatrixD12.col0 + i14) * iMin2) + (iMin5 * i12);
            if (i14 == i9) {
                int i17 = i15 + i8;
                int i18 = i16 + i8;
                int i19 = i8;
                while (i19 < iMin3) {
                    d += dArr2[i18] * dArr3[i17];
                    i19++;
                    i18++;
                    i17++;
                }
            } else {
                double d2 = d;
                int i20 = 0;
                int i21 = i15;
                while (i20 < iMin3) {
                    d2 += dArr2[i16] * dArr3[i21];
                    i20++;
                    i21++;
                    i16++;
                }
                d = d2;
            }
            i14 += i;
            i6 = i;
            dArr = dArr3;
            i7 = i5;
        }
        return d;
    }

    public static double dot_row_col(int i, DSubmatrixD1 dSubmatrixD1, int i2, DSubmatrixD1 dSubmatrixD12, int i3, int i4, int i5) {
        int i6 = i;
        int i7 = i5;
        int i8 = i4 % i6;
        int i9 = i4 - i8;
        double[] dArr = dSubmatrixD1.original.data;
        double[] dArr2 = dSubmatrixD12.original.data;
        int i10 = i2 % i6;
        int i11 = (dSubmatrixD1.row0 + i2) - i10;
        int i12 = i3 % i6;
        int i13 = (dSubmatrixD12.col0 + i3) - i12;
        int iMin = Math.min(i6, dSubmatrixD1.row1 - i11);
        int iMin2 = Math.min(i6, dSubmatrixD12.col1 - i13);
        if (dSubmatrixD1.col1 - dSubmatrixD1.col0 != dSubmatrixD12.col1 - dSubmatrixD12.col0) {
            throw new RuntimeException();
        }
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        int i14 = i9;
        while (i14 < i7) {
            int iMin3 = Math.min(i6, i5 - i14);
            double[] dArr3 = dArr;
            int iMin4 = Math.min(i6, (dSubmatrixD1.col1 - dSubmatrixD1.col0) - i14);
            int iMin5 = Math.min(i6, (dSubmatrixD12.row1 - dSubmatrixD12.row0) - i14);
            int i15 = (dSubmatrixD1.original.numCols * i11) + ((dSubmatrixD1.col0 + i14) * iMin) + (i10 * iMin4);
            int i16 = (dSubmatrixD12.original.numCols * (dSubmatrixD12.row0 + i14)) + (iMin5 * i13) + i12;
            if (i14 == i9) {
                int i17 = i15 + i8;
                int i18 = i16 + (i8 * iMin2);
                int i19 = i8;
                while (i19 < iMin3) {
                    d += dArr2[i18] * dArr3[i17];
                    i19++;
                    i18 += iMin2;
                    i17++;
                }
            } else {
                double d2 = d;
                int i20 = 0;
                int i21 = i15;
                while (i20 < iMin3) {
                    d2 += dArr2[i16] * dArr3[i21];
                    i20++;
                    i16 += iMin2;
                    i21++;
                }
                d = d2;
            }
            i14 += i;
            i6 = i;
            dArr = dArr3;
            i7 = i5;
        }
        return d;
    }
}
