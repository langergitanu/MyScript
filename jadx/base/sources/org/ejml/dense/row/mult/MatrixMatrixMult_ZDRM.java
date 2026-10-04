package org.ejml.dense.row.mult;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.MatrixDimensionException;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.CommonOps_ZDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixMatrixMult_ZDRM {
    public static void mult_reorder(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (zMatrixRMaj.numCols == 0 || zMatrixRMaj.numRows == 0) {
            CommonOps_ZDRM.fill(zMatrixRMaj3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int rowStride = zMatrixRMaj.getRowStride();
        int rowStride2 = zMatrixRMaj2.getRowStride();
        int rowStride3 = zMatrixRMaj3.getRowStride();
        int i = zMatrixRMaj2.numRows * rowStride2;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = i3 * rowStride;
            int i5 = i4 + 1;
            double d = zMatrixRMaj.data[i4];
            int i6 = i4 + 2;
            double d2 = zMatrixRMaj.data[i5];
            int i7 = i2;
            int i8 = 0;
            while (i8 < rowStride2) {
                int i9 = i8 + 1;
                double d3 = zMatrixRMaj2.data[i8];
                i8 += 2;
                double d4 = zMatrixRMaj2.data[i9];
                int i10 = i7 + 1;
                zMatrixRMaj3.data[i7] = (d * d3) - (d2 * d4);
                i7 += 2;
                zMatrixRMaj3.data[i10] = (d4 * d) + (d3 * d2);
            }
            while (i8 != i) {
                int i11 = i8 + rowStride2;
                int i12 = i6 + 1;
                double d5 = zMatrixRMaj.data[i6];
                i6 += 2;
                double d6 = zMatrixRMaj.data[i12];
                int i13 = i2;
                while (i8 < i11) {
                    int i14 = i8 + 1;
                    double d7 = zMatrixRMaj2.data[i8];
                    i8 += 2;
                    double d8 = zMatrixRMaj2.data[i14];
                    double[] dArr = zMatrixRMaj3.data;
                    int i15 = i13 + 1;
                    dArr[i13] = dArr[i13] + ((d5 * d7) - (d6 * d8));
                    double[] dArr2 = zMatrixRMaj3.data;
                    i13 += 2;
                    dArr2[i15] = dArr2[i15] + (d8 * d5) + (d7 * d6);
                }
            }
            i2 += rowStride3;
        }
    }

    public static void mult_small(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int rowStride = zMatrixRMaj.getRowStride();
        int rowStride2 = zMatrixRMaj2.getRowStride();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = 0;
            while (i4 < zMatrixRMaj2.numCols) {
                int i5 = i4 * 2;
                int i6 = i + rowStride;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i7 = i;
                double d2 = 0.0d;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    double d3 = zMatrixRMaj.data[i7];
                    i7 += 2;
                    double d4 = zMatrixRMaj.data[i8];
                    double d5 = zMatrixRMaj2.data[i5];
                    double d6 = zMatrixRMaj2.data[i5 + 1];
                    d += (d3 * d5) - (d4 * d6);
                    d2 += (d3 * d6) + (d4 * d5);
                    i5 += rowStride2;
                    rowStride = rowStride;
                }
                int i9 = i2 + 1;
                zMatrixRMaj3.data[i2] = d;
                i2 += 2;
                zMatrixRMaj3.data[i9] = d2;
                i4++;
                rowStride = rowStride;
            }
            i += rowStride;
        }
    }

    public static void multTransA_reorder(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (zMatrixRMaj.numCols == 0 || zMatrixRMaj.numRows == 0) {
            CommonOps_ZDRM.fill(zMatrixRMaj3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        for (int i = 0; i < zMatrixRMaj.numCols; i++) {
            int i2 = zMatrixRMaj3.numCols * i * 2;
            int i3 = i * 2;
            double d = zMatrixRMaj.data[i3];
            double d2 = zMatrixRMaj.data[i3 + 1];
            int i4 = zMatrixRMaj2.numCols * 2;
            int i5 = 0;
            int i6 = i2;
            while (i5 < i4) {
                int i7 = i5 + 1;
                double d3 = zMatrixRMaj2.data[i5];
                i5 += 2;
                double d4 = zMatrixRMaj2.data[i7];
                int i8 = i6 + 1;
                zMatrixRMaj3.data[i6] = (d * d3) + (d2 * d4);
                i6 += 2;
                zMatrixRMaj3.data[i8] = (d4 * d) - (d3 * d2);
            }
            for (int i9 = 1; i9 < zMatrixRMaj.numRows; i9++) {
                double real = zMatrixRMaj.getReal(i9, i);
                double imag = zMatrixRMaj.getImag(i9, i);
                int i10 = (zMatrixRMaj2.numCols * 2) + i5;
                int i11 = i2;
                while (i5 < i10) {
                    int i12 = i5 + 1;
                    double d5 = zMatrixRMaj2.data[i5];
                    i5 += 2;
                    double d6 = zMatrixRMaj2.data[i12];
                    double[] dArr = zMatrixRMaj3.data;
                    int i13 = i11 + 1;
                    dArr[i11] = dArr[i11] + (real * d5) + (imag * d6);
                    double[] dArr2 = zMatrixRMaj3.data;
                    i11 += 2;
                    dArr2[i13] = dArr2[i13] + ((d6 * real) - (d5 * imag));
                }
            }
        }
    }

    public static void multTransA_small(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < zMatrixRMaj.numCols; i2++) {
            for (int i3 = 0; i3 < zMatrixRMaj2.numCols; i3++) {
                int i4 = i2 * 2;
                int i5 = i3 * 2;
                int i6 = (zMatrixRMaj2.numRows * zMatrixRMaj2.numCols * 2) + i5;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d2 = 0.0d;
                while (i5 < i6) {
                    double d3 = zMatrixRMaj.data[i4];
                    double d4 = zMatrixRMaj.data[i4 + 1];
                    double d5 = zMatrixRMaj2.data[i5];
                    double d6 = zMatrixRMaj2.data[i5 + 1];
                    d += (d3 * d5) + (d4 * d6);
                    d2 += (d3 * d6) - (d4 * d5);
                    i4 += zMatrixRMaj.numCols * 2;
                    i5 += zMatrixRMaj2.numCols * 2;
                }
                int i7 = i + 1;
                zMatrixRMaj3.data[i] = d;
                i += 2;
                zMatrixRMaj3.data[i7] = d2;
            }
        }
    }

    public static void multTransB(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = (zMatrixRMaj2.numCols * 2) + i;
            int i5 = 0;
            for (int i6 = 0; i6 < zMatrixRMaj2.numRows; i6++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i7 = i;
                double d2 = 0.0d;
                while (i7 < i4) {
                    int i8 = i7 + 1;
                    double d3 = zMatrixRMaj.data[i7];
                    i7 += 2;
                    double d4 = zMatrixRMaj.data[i8];
                    int i9 = i5 + 1;
                    double d5 = zMatrixRMaj2.data[i5];
                    i5 += 2;
                    double d6 = zMatrixRMaj2.data[i9];
                    d += (d3 * d5) + (d4 * d6);
                    d2 += (d4 * d5) - (d3 * d6);
                }
                int i10 = i2 + 1;
                zMatrixRMaj3.data[i2] = d;
                i2 += 2;
                zMatrixRMaj3.data[i10] = d2;
            }
            i += zMatrixRMaj.numCols * 2;
        }
    }

    public static void multTransAB(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        while (i < zMatrixRMaj.numCols) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < zMatrixRMaj2.numRows) {
                int i5 = i * 2;
                int i6 = (zMatrixRMaj2.numCols * 2) + i4;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d2 = 0.0d;
                while (i4 < i6) {
                    double d3 = zMatrixRMaj.data[i5];
                    double d4 = -zMatrixRMaj.data[i5 + 1];
                    int i7 = i4 + 1;
                    double d5 = zMatrixRMaj2.data[i4];
                    i4 += 2;
                    double d6 = -zMatrixRMaj2.data[i7];
                    d += (d3 * d5) - (d4 * d6);
                    d2 += (d3 * d6) + (d4 * d5);
                    i5 += zMatrixRMaj.numCols * 2;
                    i = i;
                }
                int i8 = i;
                int i9 = i2 + 1;
                zMatrixRMaj3.data[i2] = d;
                i2 += 2;
                zMatrixRMaj3.data[i9] = d2;
                i3++;
                i = i8;
            }
            i++;
        }
    }

    public static void multTransAB_aux(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3, double[] dArr) {
        ZMatrixRMaj zMatrixRMaj4 = zMatrixRMaj;
        ZMatrixRMaj zMatrixRMaj5 = zMatrixRMaj2;
        if (zMatrixRMaj4 == zMatrixRMaj3 || zMatrixRMaj5 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj4.numRows != zMatrixRMaj5.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj4.numCols != zMatrixRMaj3.numRows || zMatrixRMaj5.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[zMatrixRMaj4.numRows * 2] : dArr;
        if (zMatrixRMaj4.numCols == 0 || zMatrixRMaj4.numRows == 0) {
            CommonOps_ZDRM.fill(zMatrixRMaj3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int i = 0;
        int i2 = 0;
        while (i < zMatrixRMaj4.numCols) {
            int i3 = i * 2;
            for (int i4 = 0; i4 < zMatrixRMaj5.numCols; i4++) {
                int i5 = i4 * 2;
                dArr2[i5] = zMatrixRMaj4.data[i3];
                dArr2[i5 + 1] = zMatrixRMaj4.data[i3 + 1];
                i3 += zMatrixRMaj4.numCols * 2;
            }
            int i6 = 0;
            while (i6 < zMatrixRMaj5.numRows) {
                int i7 = zMatrixRMaj5.numCols * i6 * 2;
                int i8 = 0;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i9 = 0;
                while (i8 < zMatrixRMaj5.numCols) {
                    int i10 = i9 + 1;
                    double d3 = dArr2[i9];
                    i9 += 2;
                    double d4 = -dArr2[i10];
                    int i11 = i7 + 1;
                    double d5 = zMatrixRMaj5.data[i7];
                    i7 += 2;
                    double d6 = -zMatrixRMaj5.data[i11];
                    d += (d3 * d5) - (d4 * d6);
                    d2 += (d3 * d6) + (d4 * d5);
                    i8++;
                    zMatrixRMaj5 = zMatrixRMaj2;
                }
                int i12 = i2 + 1;
                zMatrixRMaj3.data[i2] = d;
                i2 += 2;
                zMatrixRMaj3.data[i12] = d2;
                i6++;
                zMatrixRMaj5 = zMatrixRMaj2;
            }
            i++;
            zMatrixRMaj4 = zMatrixRMaj;
            zMatrixRMaj5 = zMatrixRMaj2;
        }
    }

    public static void multAdd_reorder(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (zMatrixRMaj.numCols == 0 || zMatrixRMaj.numRows == 0) {
            return;
        }
        int rowStride = zMatrixRMaj.getRowStride();
        int rowStride2 = zMatrixRMaj2.getRowStride();
        int rowStride3 = zMatrixRMaj3.getRowStride();
        int i = zMatrixRMaj2.numRows * rowStride2;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = i3 * rowStride;
            int i5 = i4 + 1;
            double d = zMatrixRMaj.data[i4];
            int i6 = i4 + 2;
            double d2 = zMatrixRMaj.data[i5];
            int i7 = i2;
            int i8 = 0;
            while (i8 < rowStride2) {
                int i9 = i8 + 1;
                double d3 = zMatrixRMaj2.data[i8];
                i8 += 2;
                double d4 = zMatrixRMaj2.data[i9];
                double[] dArr = zMatrixRMaj3.data;
                int i10 = i7 + 1;
                dArr[i7] = dArr[i7] + ((d * d3) - (d2 * d4));
                double[] dArr2 = zMatrixRMaj3.data;
                i7 += 2;
                dArr2[i10] = dArr2[i10] + (d4 * d) + (d3 * d2);
            }
            while (i8 != i) {
                int i11 = i8 + rowStride2;
                int i12 = i6 + 1;
                double d5 = zMatrixRMaj.data[i6];
                i6 += 2;
                double d6 = zMatrixRMaj.data[i12];
                int i13 = i2;
                while (i8 < i11) {
                    int i14 = i8 + 1;
                    double d7 = zMatrixRMaj2.data[i8];
                    i8 += 2;
                    double d8 = zMatrixRMaj2.data[i14];
                    double[] dArr3 = zMatrixRMaj3.data;
                    int i15 = i13 + 1;
                    dArr3[i13] = dArr3[i13] + ((d5 * d7) - (d6 * d8));
                    double[] dArr4 = zMatrixRMaj3.data;
                    i13 += 2;
                    dArr4[i15] = dArr4[i15] + (d8 * d5) + (d7 * d6);
                }
            }
            i2 += rowStride3;
        }
    }

    public static void multAdd_small(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int rowStride = zMatrixRMaj.getRowStride();
        int rowStride2 = zMatrixRMaj2.getRowStride();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = 0;
            while (i4 < zMatrixRMaj2.numCols) {
                int i5 = i4 * 2;
                int i6 = i + rowStride;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i7 = i;
                double d2 = 0.0d;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    double d3 = zMatrixRMaj.data[i7];
                    i7 += 2;
                    double d4 = zMatrixRMaj.data[i8];
                    double d5 = zMatrixRMaj2.data[i5];
                    double d6 = zMatrixRMaj2.data[i5 + 1];
                    d += (d3 * d5) - (d4 * d6);
                    d2 += (d3 * d6) + (d4 * d5);
                    i5 += rowStride2;
                    rowStride = rowStride;
                }
                int i9 = rowStride;
                double[] dArr = zMatrixRMaj3.data;
                int i10 = i2 + 1;
                dArr[i2] = dArr[i2] + d;
                double[] dArr2 = zMatrixRMaj3.data;
                i2 += 2;
                dArr2[i10] = dArr2[i10] + d2;
                i4++;
                rowStride = i9;
            }
            i += rowStride;
        }
    }

    public static void multAddTransA_reorder(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (zMatrixRMaj.numCols == 0 || zMatrixRMaj.numRows == 0) {
            return;
        }
        for (int i = 0; i < zMatrixRMaj.numCols; i++) {
            int i2 = zMatrixRMaj3.numCols * i * 2;
            int i3 = i * 2;
            double d = zMatrixRMaj.data[i3];
            double d2 = zMatrixRMaj.data[i3 + 1];
            int i4 = zMatrixRMaj2.numCols * 2;
            int i5 = 0;
            int i6 = i2;
            while (i5 < i4) {
                int i7 = i5 + 1;
                double d3 = zMatrixRMaj2.data[i5];
                i5 += 2;
                double d4 = zMatrixRMaj2.data[i7];
                double[] dArr = zMatrixRMaj3.data;
                int i8 = i6 + 1;
                dArr[i6] = dArr[i6] + (d * d3) + (d2 * d4);
                double[] dArr2 = zMatrixRMaj3.data;
                i6 += 2;
                dArr2[i8] = dArr2[i8] + ((d4 * d) - (d3 * d2));
            }
            for (int i9 = 1; i9 < zMatrixRMaj.numRows; i9++) {
                double real = zMatrixRMaj.getReal(i9, i);
                double imag = zMatrixRMaj.getImag(i9, i);
                int i10 = (zMatrixRMaj2.numCols * 2) + i5;
                int i11 = i2;
                while (i5 < i10) {
                    int i12 = i5 + 1;
                    double d5 = zMatrixRMaj2.data[i5];
                    i5 += 2;
                    double d6 = zMatrixRMaj2.data[i12];
                    double[] dArr3 = zMatrixRMaj3.data;
                    int i13 = i11 + 1;
                    dArr3[i11] = dArr3[i11] + (real * d5) + (imag * d6);
                    double[] dArr4 = zMatrixRMaj3.data;
                    i11 += 2;
                    dArr4[i13] = dArr4[i13] + ((d6 * real) - (d5 * imag));
                }
            }
        }
    }

    public static void multAddTransA_small(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < zMatrixRMaj.numCols; i2++) {
            for (int i3 = 0; i3 < zMatrixRMaj2.numCols; i3++) {
                int i4 = i2 * 2;
                int i5 = i3 * 2;
                int i6 = (zMatrixRMaj2.numRows * zMatrixRMaj2.numCols * 2) + i5;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d2 = 0.0d;
                while (i5 < i6) {
                    double d3 = zMatrixRMaj.data[i4];
                    double d4 = zMatrixRMaj.data[i4 + 1];
                    double d5 = zMatrixRMaj2.data[i5];
                    double d6 = zMatrixRMaj2.data[i5 + 1];
                    d += (d3 * d5) + (d4 * d6);
                    d2 += (d3 * d6) - (d4 * d5);
                    i4 += zMatrixRMaj.numCols * 2;
                    i5 += zMatrixRMaj2.numCols * 2;
                }
                double[] dArr = zMatrixRMaj3.data;
                int i7 = i + 1;
                dArr[i] = dArr[i] + d;
                double[] dArr2 = zMatrixRMaj3.data;
                i += 2;
                dArr2[i7] = dArr2[i7] + d2;
            }
        }
    }

    public static void multAddTransB(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = (zMatrixRMaj2.numCols * 2) + i;
            int i5 = 0;
            for (int i6 = 0; i6 < zMatrixRMaj2.numRows; i6++) {
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i7 = i;
                double d2 = 0.0d;
                while (i7 < i4) {
                    int i8 = i7 + 1;
                    double d3 = zMatrixRMaj.data[i7];
                    i7 += 2;
                    double d4 = zMatrixRMaj.data[i8];
                    int i9 = i5 + 1;
                    double d5 = zMatrixRMaj2.data[i5];
                    i5 += 2;
                    double d6 = zMatrixRMaj2.data[i9];
                    d += (d3 * d5) + (d4 * d6);
                    d2 += (d4 * d5) - (d3 * d6);
                }
                double[] dArr = zMatrixRMaj3.data;
                int i10 = i2 + 1;
                dArr[i2] = dArr[i2] + d;
                double[] dArr2 = zMatrixRMaj3.data;
                i2 += 2;
                dArr2[i10] = dArr2[i10] + d2;
            }
            i += zMatrixRMaj.numCols * 2;
        }
    }

    public static void multAddTransAB(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        while (i < zMatrixRMaj.numCols) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < zMatrixRMaj2.numRows) {
                int i5 = i * 2;
                int i6 = (zMatrixRMaj2.numCols * 2) + i4;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d2 = 0.0d;
                while (i4 < i6) {
                    double d3 = zMatrixRMaj.data[i5];
                    double d4 = -zMatrixRMaj.data[i5 + 1];
                    int i7 = i4 + 1;
                    double d5 = zMatrixRMaj2.data[i4];
                    i4 += 2;
                    double d6 = -zMatrixRMaj2.data[i7];
                    d += (d3 * d5) - (d4 * d6);
                    d2 += (d3 * d6) + (d4 * d5);
                    i5 += zMatrixRMaj.numCols * 2;
                    i = i;
                }
                int i8 = i;
                double[] dArr = zMatrixRMaj3.data;
                int i9 = i2 + 1;
                dArr[i2] = dArr[i2] + d;
                double[] dArr2 = zMatrixRMaj3.data;
                i2 += 2;
                dArr2[i9] = dArr2[i9] + d2;
                i3++;
                i = i8;
            }
            i++;
        }
    }

    public static void multAddTransAB_aux(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3, double[] dArr) {
        ZMatrixRMaj zMatrixRMaj4 = zMatrixRMaj;
        ZMatrixRMaj zMatrixRMaj5 = zMatrixRMaj2;
        if (zMatrixRMaj4 == zMatrixRMaj3 || zMatrixRMaj5 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj4.numRows != zMatrixRMaj5.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj4.numCols != zMatrixRMaj3.numRows || zMatrixRMaj5.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[zMatrixRMaj4.numRows * 2] : dArr;
        if (zMatrixRMaj4.numCols == 0 || zMatrixRMaj4.numRows == 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (i < zMatrixRMaj4.numCols) {
            int i3 = i * 2;
            for (int i4 = 0; i4 < zMatrixRMaj5.numCols; i4++) {
                int i5 = i4 * 2;
                dArr2[i5] = zMatrixRMaj4.data[i3];
                dArr2[i5 + 1] = zMatrixRMaj4.data[i3 + 1];
                i3 += zMatrixRMaj4.numCols * 2;
            }
            int i6 = 0;
            while (i6 < zMatrixRMaj5.numRows) {
                int i7 = zMatrixRMaj5.numCols * i6 * 2;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d2 = 0.0d;
                int i8 = 0;
                int i9 = 0;
                while (i8 < zMatrixRMaj5.numCols) {
                    int i10 = i9 + 1;
                    double d3 = dArr2[i9];
                    i9 += 2;
                    double d4 = -dArr2[i10];
                    int i11 = i7 + 1;
                    double d5 = zMatrixRMaj5.data[i7];
                    i7 += 2;
                    double d6 = -zMatrixRMaj5.data[i11];
                    d += (d3 * d5) - (d4 * d6);
                    d2 += (d3 * d6) + (d4 * d5);
                    i8++;
                    zMatrixRMaj5 = zMatrixRMaj2;
                    i = i;
                }
                double[] dArr3 = zMatrixRMaj3.data;
                int i12 = i2 + 1;
                dArr3[i2] = dArr3[i2] + d;
                double[] dArr4 = zMatrixRMaj3.data;
                i2 += 2;
                dArr4[i12] = dArr4[i12] + d2;
                i6++;
                zMatrixRMaj5 = zMatrixRMaj2;
                i = i;
            }
            i++;
            zMatrixRMaj4 = zMatrixRMaj;
            zMatrixRMaj5 = zMatrixRMaj2;
        }
    }

    public static void mult_reorder(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (zMatrixRMaj.numCols == 0 || zMatrixRMaj.numRows == 0) {
            CommonOps_ZDRM.fill(zMatrixRMaj3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int rowStride = zMatrixRMaj.getRowStride();
        int rowStride2 = zMatrixRMaj2.getRowStride();
        int rowStride3 = zMatrixRMaj3.getRowStride();
        int i = zMatrixRMaj2.numRows * rowStride2;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = i3 * rowStride;
            int i5 = i4 + 1;
            double d3 = zMatrixRMaj.data[i4];
            int i6 = i4 + 2;
            double d4 = zMatrixRMaj.data[i5];
            double d5 = (d * d3) - (d2 * d4);
            double d6 = (d4 * d) + (d3 * d2);
            int i7 = i2;
            int i8 = 0;
            while (i8 < rowStride2) {
                int i9 = i8 + 1;
                double d7 = zMatrixRMaj2.data[i8];
                i8 += 2;
                double d8 = zMatrixRMaj2.data[i9];
                int i10 = i7 + 1;
                zMatrixRMaj3.data[i7] = (d5 * d7) - (d6 * d8);
                i7 += 2;
                zMatrixRMaj3.data[i10] = (d8 * d5) + (d7 * d6);
            }
            while (i8 != i) {
                int i11 = i8 + rowStride2;
                int i12 = i6 + 1;
                double d9 = zMatrixRMaj.data[i6];
                i6 += 2;
                double d10 = zMatrixRMaj.data[i12];
                double d11 = (d * d9) - (d2 * d10);
                double d12 = (d10 * d) + (d9 * d2);
                int i13 = i2;
                while (i8 < i11) {
                    int i14 = i8 + 1;
                    double d13 = zMatrixRMaj2.data[i8];
                    i8 += 2;
                    double d14 = zMatrixRMaj2.data[i14];
                    double[] dArr = zMatrixRMaj3.data;
                    int i15 = i13 + 1;
                    dArr[i13] = dArr[i13] + ((d11 * d13) - (d12 * d14));
                    double[] dArr2 = zMatrixRMaj3.data;
                    i13 += 2;
                    dArr2[i15] = dArr2[i15] + (d14 * d11) + (d13 * d12);
                }
            }
            i2 += rowStride3;
        }
    }

    public static void mult_small(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int rowStride = zMatrixRMaj.getRowStride();
        int rowStride2 = zMatrixRMaj2.getRowStride();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = 0;
            while (i4 < zMatrixRMaj2.numCols) {
                int i5 = i4 * 2;
                int i6 = i + rowStride;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i7 = i;
                double d4 = 0.0d;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    double d5 = zMatrixRMaj.data[i7];
                    i7 += 2;
                    double d6 = zMatrixRMaj.data[i8];
                    double d7 = zMatrixRMaj2.data[i5];
                    double d8 = zMatrixRMaj2.data[i5 + 1];
                    d3 += (d5 * d7) - (d6 * d8);
                    d4 += (d5 * d8) + (d6 * d7);
                    i5 += rowStride2;
                    rowStride = rowStride;
                }
                int i9 = i2 + 1;
                zMatrixRMaj3.data[i2] = (d * d3) - (d2 * d4);
                i2 += 2;
                zMatrixRMaj3.data[i9] = (d4 * d) + (d3 * d2);
                i4++;
                rowStride = rowStride;
            }
            i += rowStride;
        }
    }

    public static void multTransA_reorder(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (zMatrixRMaj.numCols == 0 || zMatrixRMaj.numRows == 0) {
            CommonOps_ZDRM.fill(zMatrixRMaj3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        for (int i = 0; i < zMatrixRMaj.numCols; i++) {
            int i2 = zMatrixRMaj3.numCols * i * 2;
            int i3 = i * 2;
            double d3 = zMatrixRMaj.data[i3];
            double d4 = zMatrixRMaj.data[i3 + 1];
            double d5 = (d * d3) + (d2 * d4);
            double d6 = (d4 * d) - (d3 * d2);
            int i4 = zMatrixRMaj2.numCols * 2;
            int i5 = 0;
            int i6 = i2;
            while (i5 < i4) {
                int i7 = i5 + 1;
                double d7 = zMatrixRMaj2.data[i5];
                i5 += 2;
                double d8 = zMatrixRMaj2.data[i7];
                int i8 = i6 + 1;
                zMatrixRMaj3.data[i6] = (d5 * d7) + (d6 * d8);
                i6 += 2;
                zMatrixRMaj3.data[i8] = (d8 * d5) - (d7 * d6);
            }
            for (int i9 = 1; i9 < zMatrixRMaj.numRows; i9++) {
                double real = zMatrixRMaj.getReal(i9, i);
                double imag = zMatrixRMaj.getImag(i9, i);
                double d9 = (d * real) + (d2 * imag);
                double d10 = (imag * d) - (real * d2);
                int i10 = (zMatrixRMaj2.numCols * 2) + i5;
                int i11 = i2;
                while (i5 < i10) {
                    int i12 = i5 + 1;
                    double d11 = zMatrixRMaj2.data[i5];
                    i5 += 2;
                    double d12 = zMatrixRMaj2.data[i12];
                    double[] dArr = zMatrixRMaj3.data;
                    int i13 = i11 + 1;
                    dArr[i11] = dArr[i11] + (d9 * d11) + (d10 * d12);
                    double[] dArr2 = zMatrixRMaj3.data;
                    i11 += 2;
                    dArr2[i13] = dArr2[i13] + ((d12 * d9) - (d11 * d10));
                }
            }
        }
    }

    public static void multTransA_small(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < zMatrixRMaj.numCols; i2++) {
            for (int i3 = 0; i3 < zMatrixRMaj2.numCols; i3++) {
                int i4 = i2 * 2;
                int i5 = i3 * 2;
                int i6 = (zMatrixRMaj2.numRows * zMatrixRMaj2.numCols * 2) + i5;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d4 = 0.0d;
                while (i5 < i6) {
                    double d5 = zMatrixRMaj.data[i4];
                    double d6 = zMatrixRMaj.data[i4 + 1];
                    double d7 = zMatrixRMaj2.data[i5];
                    double d8 = zMatrixRMaj2.data[i5 + 1];
                    d3 += (d5 * d7) + (d6 * d8);
                    d4 += (d5 * d8) - (d6 * d7);
                    i4 += zMatrixRMaj.numCols * 2;
                    i5 += zMatrixRMaj2.numCols * 2;
                }
                int i7 = i + 1;
                zMatrixRMaj3.data[i] = (d * d3) - (d2 * d4);
                i += 2;
                zMatrixRMaj3.data[i7] = (d4 * d) + (d3 * d2);
            }
        }
    }

    public static void multTransB(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = (zMatrixRMaj2.numCols * 2) + i;
            int i5 = 0;
            for (int i6 = 0; i6 < zMatrixRMaj2.numRows; i6++) {
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i7 = i;
                double d4 = 0.0d;
                while (i7 < i4) {
                    int i8 = i7 + 1;
                    double d5 = zMatrixRMaj.data[i7];
                    i7 += 2;
                    double d6 = zMatrixRMaj.data[i8];
                    int i9 = i5 + 1;
                    double d7 = zMatrixRMaj2.data[i5];
                    i5 += 2;
                    double d8 = zMatrixRMaj2.data[i9];
                    d3 += (d5 * d7) + (d6 * d8);
                    d4 += (d6 * d7) - (d5 * d8);
                }
                int i10 = i2 + 1;
                zMatrixRMaj3.data[i2] = (d * d3) - (d2 * d4);
                i2 += 2;
                zMatrixRMaj3.data[i10] = (d4 * d) + (d3 * d2);
            }
            i += zMatrixRMaj.numCols * 2;
        }
    }

    public static void multTransAB(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        while (i < zMatrixRMaj.numCols) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < zMatrixRMaj2.numRows) {
                int i5 = i * 2;
                int i6 = (zMatrixRMaj2.numCols * 2) + i4;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d4 = 0.0d;
                while (i4 < i6) {
                    double d5 = zMatrixRMaj.data[i5];
                    double d6 = -zMatrixRMaj.data[i5 + 1];
                    int i7 = i4 + 1;
                    double d7 = zMatrixRMaj2.data[i4];
                    i4 += 2;
                    double d8 = -zMatrixRMaj2.data[i7];
                    d3 += (d5 * d7) - (d6 * d8);
                    d4 += (d5 * d8) + (d6 * d7);
                    i5 += zMatrixRMaj.numCols * 2;
                    i = i;
                }
                int i8 = i;
                int i9 = i2 + 1;
                zMatrixRMaj3.data[i2] = (d * d3) - (d2 * d4);
                i2 += 2;
                zMatrixRMaj3.data[i9] = (d4 * d) + (d3 * d2);
                i3++;
                i = i8;
            }
            i++;
        }
    }

    public static void multTransAB_aux(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3, double[] dArr) {
        ZMatrixRMaj zMatrixRMaj4 = zMatrixRMaj;
        ZMatrixRMaj zMatrixRMaj5 = zMatrixRMaj2;
        if (zMatrixRMaj4 == zMatrixRMaj3 || zMatrixRMaj5 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj4.numRows != zMatrixRMaj5.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj4.numCols != zMatrixRMaj3.numRows || zMatrixRMaj5.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[zMatrixRMaj4.numRows * 2] : dArr;
        if (zMatrixRMaj4.numCols == 0 || zMatrixRMaj4.numRows == 0) {
            CommonOps_ZDRM.fill(zMatrixRMaj3, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            return;
        }
        int i = 0;
        int i2 = 0;
        while (i < zMatrixRMaj4.numCols) {
            int i3 = i * 2;
            for (int i4 = 0; i4 < zMatrixRMaj5.numCols; i4++) {
                int i5 = i4 * 2;
                dArr2[i5] = zMatrixRMaj4.data[i3];
                dArr2[i5 + 1] = zMatrixRMaj4.data[i3 + 1];
                i3 += zMatrixRMaj4.numCols * 2;
            }
            int i6 = 0;
            while (i6 < zMatrixRMaj5.numRows) {
                int i7 = zMatrixRMaj5.numCols * i6 * 2;
                int i8 = 0;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i9 = 0;
                while (i8 < zMatrixRMaj5.numCols) {
                    int i10 = i9 + 1;
                    double d5 = dArr2[i9];
                    i9 += 2;
                    double d6 = -dArr2[i10];
                    int i11 = i7 + 1;
                    double d7 = zMatrixRMaj5.data[i7];
                    i7 += 2;
                    double d8 = -zMatrixRMaj5.data[i11];
                    d3 += (d5 * d7) - (d6 * d8);
                    d4 += (d5 * d8) + (d6 * d7);
                    i8++;
                    zMatrixRMaj5 = zMatrixRMaj2;
                }
                int i12 = i2 + 1;
                zMatrixRMaj3.data[i2] = (d * d3) - (d2 * d4);
                i2 += 2;
                zMatrixRMaj3.data[i12] = (d4 * d) + (d3 * d2);
                i6++;
                zMatrixRMaj5 = zMatrixRMaj2;
            }
            i++;
            zMatrixRMaj4 = zMatrixRMaj;
            zMatrixRMaj5 = zMatrixRMaj2;
        }
    }

    public static void multAdd_reorder(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (zMatrixRMaj.numCols == 0 || zMatrixRMaj.numRows == 0) {
            return;
        }
        int rowStride = zMatrixRMaj.getRowStride();
        int rowStride2 = zMatrixRMaj2.getRowStride();
        int rowStride3 = zMatrixRMaj3.getRowStride();
        int i = zMatrixRMaj2.numRows * rowStride2;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = i3 * rowStride;
            int i5 = i4 + 1;
            double d3 = zMatrixRMaj.data[i4];
            int i6 = i4 + 2;
            double d4 = zMatrixRMaj.data[i5];
            double d5 = (d * d3) - (d2 * d4);
            double d6 = (d4 * d) + (d3 * d2);
            int i7 = i2;
            int i8 = 0;
            while (i8 < rowStride2) {
                int i9 = i8 + 1;
                double d7 = zMatrixRMaj2.data[i8];
                i8 += 2;
                double d8 = zMatrixRMaj2.data[i9];
                double[] dArr = zMatrixRMaj3.data;
                int i10 = i7 + 1;
                dArr[i7] = dArr[i7] + ((d5 * d7) - (d6 * d8));
                double[] dArr2 = zMatrixRMaj3.data;
                i7 += 2;
                dArr2[i10] = dArr2[i10] + (d8 * d5) + (d7 * d6);
            }
            while (i8 != i) {
                int i11 = i8 + rowStride2;
                int i12 = i6 + 1;
                double d9 = zMatrixRMaj.data[i6];
                i6 += 2;
                double d10 = zMatrixRMaj.data[i12];
                double d11 = (d * d9) - (d2 * d10);
                double d12 = (d10 * d) + (d9 * d2);
                int i13 = i2;
                while (i8 < i11) {
                    int i14 = i8 + 1;
                    double d13 = zMatrixRMaj2.data[i8];
                    i8 += 2;
                    double d14 = zMatrixRMaj2.data[i14];
                    double[] dArr3 = zMatrixRMaj3.data;
                    int i15 = i13 + 1;
                    dArr3[i13] = dArr3[i13] + ((d11 * d13) - (d12 * d14));
                    double[] dArr4 = zMatrixRMaj3.data;
                    i13 += 2;
                    dArr4[i15] = dArr4[i15] + (d14 * d11) + (d13 * d12);
                }
            }
            i2 += rowStride3;
        }
    }

    public static void multAdd_small(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int rowStride = zMatrixRMaj.getRowStride();
        int rowStride2 = zMatrixRMaj2.getRowStride();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = 0;
            while (i4 < zMatrixRMaj2.numCols) {
                int i5 = i4 * 2;
                int i6 = i + rowStride;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i7 = i;
                double d4 = 0.0d;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    double d5 = zMatrixRMaj.data[i7];
                    i7 += 2;
                    double d6 = zMatrixRMaj.data[i8];
                    double d7 = zMatrixRMaj2.data[i5];
                    double d8 = zMatrixRMaj2.data[i5 + 1];
                    d3 += (d5 * d7) - (d6 * d8);
                    d4 += (d5 * d8) + (d6 * d7);
                    i5 += rowStride2;
                    rowStride = rowStride;
                }
                int i9 = rowStride;
                double[] dArr = zMatrixRMaj3.data;
                int i10 = i2 + 1;
                dArr[i2] = dArr[i2] + ((d * d3) - (d2 * d4));
                double[] dArr2 = zMatrixRMaj3.data;
                i2 += 2;
                dArr2[i10] = dArr2[i10] + (d4 * d) + (d3 * d2);
                i4++;
                rowStride = i9;
            }
            i += rowStride;
        }
    }

    public static void multAddTransA_reorder(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (zMatrixRMaj.numCols == 0 || zMatrixRMaj.numRows == 0) {
            return;
        }
        for (int i = 0; i < zMatrixRMaj.numCols; i++) {
            int i2 = zMatrixRMaj3.numCols * i * 2;
            int i3 = i * 2;
            double d3 = zMatrixRMaj.data[i3];
            double d4 = zMatrixRMaj.data[i3 + 1];
            double d5 = (d * d3) + (d2 * d4);
            double d6 = (d4 * d) - (d3 * d2);
            int i4 = zMatrixRMaj2.numCols * 2;
            int i5 = 0;
            int i6 = i2;
            while (i5 < i4) {
                int i7 = i5 + 1;
                double d7 = zMatrixRMaj2.data[i5];
                i5 += 2;
                double d8 = zMatrixRMaj2.data[i7];
                double[] dArr = zMatrixRMaj3.data;
                int i8 = i6 + 1;
                dArr[i6] = dArr[i6] + (d5 * d7) + (d6 * d8);
                double[] dArr2 = zMatrixRMaj3.data;
                i6 += 2;
                dArr2[i8] = dArr2[i8] + ((d8 * d5) - (d7 * d6));
            }
            for (int i9 = 1; i9 < zMatrixRMaj.numRows; i9++) {
                double real = zMatrixRMaj.getReal(i9, i);
                double imag = zMatrixRMaj.getImag(i9, i);
                double d9 = (d * real) + (d2 * imag);
                double d10 = (imag * d) - (real * d2);
                int i10 = (zMatrixRMaj2.numCols * 2) + i5;
                int i11 = i2;
                while (i5 < i10) {
                    int i12 = i5 + 1;
                    double d11 = zMatrixRMaj2.data[i5];
                    i5 += 2;
                    double d12 = zMatrixRMaj2.data[i12];
                    double[] dArr3 = zMatrixRMaj3.data;
                    int i13 = i11 + 1;
                    dArr3[i11] = dArr3[i11] + (d9 * d11) + (d10 * d12);
                    double[] dArr4 = zMatrixRMaj3.data;
                    i11 += 2;
                    dArr4[i13] = dArr4[i13] + ((d12 * d9) - (d11 * d10));
                }
            }
        }
    }

    public static void multAddTransA_small(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numCols != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < zMatrixRMaj.numCols; i2++) {
            for (int i3 = 0; i3 < zMatrixRMaj2.numCols; i3++) {
                int i4 = i2 * 2;
                int i5 = i3 * 2;
                int i6 = (zMatrixRMaj2.numRows * zMatrixRMaj2.numCols * 2) + i5;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d4 = 0.0d;
                while (i5 < i6) {
                    double d5 = zMatrixRMaj.data[i4];
                    double d6 = zMatrixRMaj.data[i4 + 1];
                    double d7 = zMatrixRMaj2.data[i5];
                    double d8 = zMatrixRMaj2.data[i5 + 1];
                    d3 += (d5 * d7) + (d6 * d8);
                    d4 += (d5 * d8) - (d6 * d7);
                    i4 += zMatrixRMaj.numCols * 2;
                    i5 += zMatrixRMaj2.numCols * 2;
                }
                double[] dArr = zMatrixRMaj3.data;
                int i7 = i + 1;
                dArr[i] = dArr[i] + ((d * d3) - (d2 * d4));
                double[] dArr2 = zMatrixRMaj3.data;
                i += 2;
                dArr2[i7] = dArr2[i7] + (d4 * d) + (d3 * d2);
            }
        }
    }

    public static void multAddTransB(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj3.numRows || zMatrixRMaj2.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = (zMatrixRMaj2.numCols * 2) + i;
            int i5 = 0;
            for (int i6 = 0; i6 < zMatrixRMaj2.numRows; i6++) {
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                int i7 = i;
                double d4 = 0.0d;
                while (i7 < i4) {
                    int i8 = i7 + 1;
                    double d5 = zMatrixRMaj.data[i7];
                    i7 += 2;
                    double d6 = zMatrixRMaj.data[i8];
                    int i9 = i5 + 1;
                    double d7 = zMatrixRMaj2.data[i5];
                    i5 += 2;
                    double d8 = zMatrixRMaj2.data[i9];
                    d3 += (d5 * d7) + (d6 * d8);
                    d4 += (d6 * d7) - (d5 * d8);
                }
                double[] dArr = zMatrixRMaj3.data;
                int i10 = i2 + 1;
                dArr[i2] = dArr[i2] + ((d * d3) - (d2 * d4));
                double[] dArr2 = zMatrixRMaj3.data;
                i2 += 2;
                dArr2[i10] = dArr2[i10] + (d4 * d) + (d3 * d2);
            }
            i += zMatrixRMaj.numCols * 2;
        }
    }

    public static void multAddTransAB(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3) {
        if (zMatrixRMaj == zMatrixRMaj3 || zMatrixRMaj2 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj.numRows != zMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj.numCols != zMatrixRMaj3.numRows || zMatrixRMaj2.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        while (i < zMatrixRMaj.numCols) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < zMatrixRMaj2.numRows) {
                int i5 = i * 2;
                int i6 = (zMatrixRMaj2.numCols * 2) + i4;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d4 = 0.0d;
                while (i4 < i6) {
                    double d5 = zMatrixRMaj.data[i5];
                    double d6 = -zMatrixRMaj.data[i5 + 1];
                    int i7 = i4 + 1;
                    double d7 = zMatrixRMaj2.data[i4];
                    i4 += 2;
                    double d8 = -zMatrixRMaj2.data[i7];
                    d3 += (d5 * d7) - (d6 * d8);
                    d4 += (d5 * d8) + (d6 * d7);
                    i5 += zMatrixRMaj.numCols * 2;
                    i = i;
                }
                int i8 = i;
                double[] dArr = zMatrixRMaj3.data;
                int i9 = i2 + 1;
                dArr[i2] = dArr[i2] + ((d * d3) - (d2 * d4));
                double[] dArr2 = zMatrixRMaj3.data;
                i2 += 2;
                dArr2[i9] = dArr2[i9] + (d4 * d) + (d3 * d2);
                i3++;
                i = i8;
            }
            i++;
        }
    }

    public static void multAddTransAB_aux(double d, double d2, ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2, ZMatrixRMaj zMatrixRMaj3, double[] dArr) {
        ZMatrixRMaj zMatrixRMaj4 = zMatrixRMaj;
        ZMatrixRMaj zMatrixRMaj5 = zMatrixRMaj2;
        if (zMatrixRMaj4 == zMatrixRMaj3 || zMatrixRMaj5 == zMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (zMatrixRMaj4.numRows != zMatrixRMaj5.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (zMatrixRMaj4.numCols != zMatrixRMaj3.numRows || zMatrixRMaj5.numRows != zMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        double[] dArr2 = dArr == null ? new double[zMatrixRMaj4.numRows * 2] : dArr;
        if (zMatrixRMaj4.numCols == 0 || zMatrixRMaj4.numRows == 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (i < zMatrixRMaj4.numCols) {
            int i3 = i * 2;
            for (int i4 = 0; i4 < zMatrixRMaj5.numCols; i4++) {
                int i5 = i4 * 2;
                dArr2[i5] = zMatrixRMaj4.data[i3];
                dArr2[i5 + 1] = zMatrixRMaj4.data[i3 + 1];
                i3 += zMatrixRMaj4.numCols * 2;
            }
            int i6 = 0;
            while (i6 < zMatrixRMaj5.numRows) {
                int i7 = zMatrixRMaj5.numCols * i6 * 2;
                double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                double d4 = 0.0d;
                int i8 = 0;
                int i9 = 0;
                while (i8 < zMatrixRMaj5.numCols) {
                    int i10 = i9 + 1;
                    double d5 = dArr2[i9];
                    i9 += 2;
                    double d6 = -dArr2[i10];
                    int i11 = i7 + 1;
                    double d7 = zMatrixRMaj5.data[i7];
                    i7 += 2;
                    double d8 = -zMatrixRMaj5.data[i11];
                    d3 += (d5 * d7) - (d6 * d8);
                    d4 += (d5 * d8) + (d6 * d7);
                    i8++;
                    zMatrixRMaj5 = zMatrixRMaj2;
                    i = i;
                }
                double[] dArr3 = zMatrixRMaj3.data;
                int i12 = i2 + 1;
                dArr3[i2] = dArr3[i2] + ((d * d3) - (d2 * d4));
                double[] dArr4 = zMatrixRMaj3.data;
                i2 += 2;
                dArr4[i12] = dArr4[i12] + (d4 * d) + (d3 * d2);
                i6++;
                zMatrixRMaj5 = zMatrixRMaj2;
                i = i;
            }
            i++;
            zMatrixRMaj4 = zMatrixRMaj;
            zMatrixRMaj5 = zMatrixRMaj2;
        }
    }
}
