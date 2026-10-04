package org.ejml.dense.row.mult;

import org.ejml.MatrixDimensionException;
import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.CommonOps_CDRM;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixMatrixMult_CDRM {
    public static void mult_reorder(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CMatrixRMaj cMatrixRMaj4 = cMatrixRMaj;
        if (cMatrixRMaj4 == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj4.numCols != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj4.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (cMatrixRMaj4.numCols == 0 || cMatrixRMaj4.numRows == 0) {
            CommonOps_CDRM.fill(cMatrixRMaj3, 0.0f, 0.0f);
            return;
        }
        int rowStride = cMatrixRMaj4.getRowStride();
        int rowStride2 = cMatrixRMaj2.getRowStride();
        int rowStride3 = cMatrixRMaj3.getRowStride();
        int i = cMatrixRMaj2.numRows * rowStride2;
        int i2 = 0;
        int i3 = 0;
        while (i2 < cMatrixRMaj4.numRows) {
            int i4 = i2 * rowStride;
            int i5 = i4 + 1;
            float f = cMatrixRMaj4.data[i4];
            int i6 = i4 + 2;
            float f2 = cMatrixRMaj4.data[i5];
            int i7 = i3;
            int i8 = 0;
            while (i8 < rowStride2) {
                int i9 = i8 + 1;
                float f3 = cMatrixRMaj2.data[i8];
                i8 += 2;
                float f4 = cMatrixRMaj2.data[i9];
                int i10 = i7 + 1;
                cMatrixRMaj3.data[i7] = (f * f3) - (f2 * f4);
                i7 += 2;
                cMatrixRMaj3.data[i10] = (f4 * f) + (f3 * f2);
                rowStride = rowStride;
            }
            int i11 = rowStride;
            while (i8 != i) {
                int i12 = i8 + rowStride2;
                int i13 = i6 + 1;
                float f5 = cMatrixRMaj4.data[i6];
                i6 += 2;
                float f6 = cMatrixRMaj4.data[i13];
                int i14 = i3;
                while (i8 < i12) {
                    int i15 = i8 + 1;
                    float f7 = cMatrixRMaj2.data[i8];
                    i8 += 2;
                    float f8 = cMatrixRMaj2.data[i15];
                    float[] fArr = cMatrixRMaj3.data;
                    int i16 = i14 + 1;
                    fArr[i14] = fArr[i14] + ((f5 * f7) - (f6 * f8));
                    float[] fArr2 = cMatrixRMaj3.data;
                    i14 += 2;
                    fArr2[i16] = fArr2[i16] + (f8 * f5) + (f7 * f6);
                }
                cMatrixRMaj4 = cMatrixRMaj;
            }
            i3 += rowStride3;
            i2++;
            cMatrixRMaj4 = cMatrixRMaj;
            rowStride = i11;
        }
    }

    public static void mult_small(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CMatrixRMaj cMatrixRMaj4 = cMatrixRMaj;
        if (cMatrixRMaj4 == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj4.numCols != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj4.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int rowStride = cMatrixRMaj4.getRowStride();
        int rowStride2 = cMatrixRMaj2.getRowStride();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < cMatrixRMaj4.numRows) {
            int i4 = 0;
            while (i4 < cMatrixRMaj2.numCols) {
                int i5 = i4 * 2;
                int i6 = i2 + rowStride;
                float f = 0.0f;
                int i7 = i2;
                float f2 = 0.0f;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    float f3 = cMatrixRMaj4.data[i7];
                    i7 += 2;
                    float f4 = cMatrixRMaj4.data[i8];
                    float f5 = cMatrixRMaj2.data[i5];
                    float f6 = cMatrixRMaj2.data[i5 + 1];
                    f += (f3 * f5) - (f4 * f6);
                    f2 += (f3 * f6) + (f4 * f5);
                    i5 += rowStride2;
                    cMatrixRMaj4 = cMatrixRMaj;
                }
                int i9 = i3 + 1;
                cMatrixRMaj3.data[i3] = f;
                i3 += 2;
                cMatrixRMaj3.data[i9] = f2;
                i4++;
                cMatrixRMaj4 = cMatrixRMaj;
            }
            i2 += rowStride;
            i++;
            cMatrixRMaj4 = cMatrixRMaj;
        }
    }

    public static void multTransA_reorder(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (cMatrixRMaj.numCols == 0 || cMatrixRMaj.numRows == 0) {
            CommonOps_CDRM.fill(cMatrixRMaj3, 0.0f, 0.0f);
            return;
        }
        for (int i = 0; i < cMatrixRMaj.numCols; i++) {
            int i2 = cMatrixRMaj3.numCols * i * 2;
            int i3 = i * 2;
            float f = cMatrixRMaj.data[i3];
            float f2 = cMatrixRMaj.data[i3 + 1];
            int i4 = cMatrixRMaj2.numCols * 2;
            int i5 = 0;
            int i6 = i2;
            while (i5 < i4) {
                int i7 = i5 + 1;
                float f3 = cMatrixRMaj2.data[i5];
                i5 += 2;
                float f4 = cMatrixRMaj2.data[i7];
                int i8 = i6 + 1;
                cMatrixRMaj3.data[i6] = (f * f3) + (f2 * f4);
                i6 += 2;
                cMatrixRMaj3.data[i8] = (f4 * f) - (f3 * f2);
            }
            for (int i9 = 1; i9 < cMatrixRMaj.numRows; i9++) {
                float real = cMatrixRMaj.getReal(i9, i);
                float imag = cMatrixRMaj.getImag(i9, i);
                int i10 = (cMatrixRMaj2.numCols * 2) + i5;
                int i11 = i2;
                while (i5 < i10) {
                    int i12 = i5 + 1;
                    float f5 = cMatrixRMaj2.data[i5];
                    i5 += 2;
                    float f6 = cMatrixRMaj2.data[i12];
                    float[] fArr = cMatrixRMaj3.data;
                    int i13 = i11 + 1;
                    fArr[i11] = fArr[i11] + (real * f5) + (imag * f6);
                    float[] fArr2 = cMatrixRMaj3.data;
                    i11 += 2;
                    fArr2[i13] = fArr2[i13] + ((f6 * real) - (f5 * imag));
                }
            }
        }
    }

    public static void multTransA_small(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            for (int i3 = 0; i3 < cMatrixRMaj2.numCols; i3++) {
                int i4 = i2 * 2;
                int i5 = i3 * 2;
                int i6 = (cMatrixRMaj2.numRows * cMatrixRMaj2.numCols * 2) + i5;
                float f = 0.0f;
                float f2 = 0.0f;
                while (i5 < i6) {
                    float f3 = cMatrixRMaj.data[i4];
                    float f4 = cMatrixRMaj.data[i4 + 1];
                    float f5 = cMatrixRMaj2.data[i5];
                    float f6 = cMatrixRMaj2.data[i5 + 1];
                    f += (f3 * f5) + (f4 * f6);
                    f2 += (f3 * f6) - (f4 * f5);
                    i4 += cMatrixRMaj.numCols * 2;
                    i5 += cMatrixRMaj2.numCols * 2;
                }
                int i7 = i + 1;
                cMatrixRMaj3.data[i] = f;
                i += 2;
                cMatrixRMaj3.data[i7] = f2;
            }
        }
    }

    public static void multTransB(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < cMatrixRMaj.numRows; i3++) {
            int i4 = (cMatrixRMaj2.numCols * 2) + i;
            int i5 = 0;
            for (int i6 = 0; i6 < cMatrixRMaj2.numRows; i6++) {
                float f = 0.0f;
                int i7 = i;
                float f2 = 0.0f;
                while (i7 < i4) {
                    int i8 = i7 + 1;
                    float f3 = cMatrixRMaj.data[i7];
                    i7 += 2;
                    float f4 = cMatrixRMaj.data[i8];
                    int i9 = i5 + 1;
                    float f5 = cMatrixRMaj2.data[i5];
                    i5 += 2;
                    float f6 = cMatrixRMaj2.data[i9];
                    f += (f3 * f5) + (f4 * f6);
                    f2 += (f4 * f5) - (f3 * f6);
                }
                int i10 = i2 + 1;
                cMatrixRMaj3.data[i2] = f;
                i2 += 2;
                cMatrixRMaj3.data[i10] = f2;
            }
            i += cMatrixRMaj.numCols * 2;
        }
    }

    public static void multTransAB(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < cMatrixRMaj2.numRows; i4++) {
                int i5 = i2 * 2;
                int i6 = (cMatrixRMaj2.numCols * 2) + i3;
                float f = 0.0f;
                float f2 = 0.0f;
                while (i3 < i6) {
                    float f3 = cMatrixRMaj.data[i5];
                    float f4 = -cMatrixRMaj.data[i5 + 1];
                    int i7 = i3 + 1;
                    float f5 = cMatrixRMaj2.data[i3];
                    i3 += 2;
                    float f6 = -cMatrixRMaj2.data[i7];
                    f += (f3 * f5) - (f4 * f6);
                    f2 += (f3 * f6) + (f4 * f5);
                    i5 += cMatrixRMaj.numCols * 2;
                }
                int i8 = i + 1;
                cMatrixRMaj3.data[i] = f;
                i += 2;
                cMatrixRMaj3.data[i8] = f2;
            }
        }
    }

    public static void multTransAB_aux(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3, float[] fArr) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        float[] fArr2 = fArr == null ? new float[cMatrixRMaj.numRows * 2] : fArr;
        if (cMatrixRMaj.numCols == 0 || cMatrixRMaj.numRows == 0) {
            CommonOps_CDRM.fill(cMatrixRMaj3, 0.0f, 0.0f);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            int i3 = i2 * 2;
            for (int i4 = 0; i4 < cMatrixRMaj2.numCols; i4++) {
                int i5 = i4 * 2;
                fArr2[i5] = cMatrixRMaj.data[i3];
                fArr2[i5 + 1] = cMatrixRMaj.data[i3 + 1];
                i3 += cMatrixRMaj.numCols * 2;
            }
            for (int i6 = 0; i6 < cMatrixRMaj2.numRows; i6++) {
                int i7 = cMatrixRMaj2.numCols * i6 * 2;
                float f = 0.0f;
                float f2 = 0.0f;
                int i8 = 0;
                for (int i9 = 0; i9 < cMatrixRMaj2.numCols; i9++) {
                    int i10 = i8 + 1;
                    float f3 = fArr2[i8];
                    i8 += 2;
                    float f4 = -fArr2[i10];
                    int i11 = i7 + 1;
                    float f5 = cMatrixRMaj2.data[i7];
                    i7 += 2;
                    float f6 = -cMatrixRMaj2.data[i11];
                    f += (f3 * f5) - (f4 * f6);
                    f2 += (f3 * f6) + (f4 * f5);
                }
                int i12 = i + 1;
                cMatrixRMaj3.data[i] = f;
                i += 2;
                cMatrixRMaj3.data[i12] = f2;
            }
        }
    }

    public static void multAdd_reorder(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CMatrixRMaj cMatrixRMaj4 = cMatrixRMaj;
        if (cMatrixRMaj4 == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj4.numCols != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj4.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (cMatrixRMaj4.numCols == 0 || cMatrixRMaj4.numRows == 0) {
            return;
        }
        int rowStride = cMatrixRMaj4.getRowStride();
        int rowStride2 = cMatrixRMaj2.getRowStride();
        int rowStride3 = cMatrixRMaj3.getRowStride();
        int i = cMatrixRMaj2.numRows * rowStride2;
        int i2 = 0;
        int i3 = 0;
        while (i2 < cMatrixRMaj4.numRows) {
            int i4 = i2 * rowStride;
            int i5 = i4 + 1;
            float f = cMatrixRMaj4.data[i4];
            int i6 = i4 + 2;
            float f2 = cMatrixRMaj4.data[i5];
            int i7 = i3;
            int i8 = 0;
            while (i8 < rowStride2) {
                int i9 = i8 + 1;
                float f3 = cMatrixRMaj2.data[i8];
                i8 += 2;
                float f4 = cMatrixRMaj2.data[i9];
                int i10 = rowStride;
                float[] fArr = cMatrixRMaj3.data;
                int i11 = i7 + 1;
                fArr[i7] = fArr[i7] + ((f * f3) - (f2 * f4));
                float[] fArr2 = cMatrixRMaj3.data;
                i7 += 2;
                fArr2[i11] = fArr2[i11] + (f4 * f) + (f3 * f2);
                rowStride = i10;
            }
            int i12 = rowStride;
            while (i8 != i) {
                int i13 = i8 + rowStride2;
                int i14 = i6 + 1;
                float f5 = cMatrixRMaj4.data[i6];
                i6 += 2;
                float f6 = cMatrixRMaj4.data[i14];
                int i15 = i3;
                while (i8 < i13) {
                    int i16 = i8 + 1;
                    float f7 = cMatrixRMaj2.data[i8];
                    i8 += 2;
                    float f8 = cMatrixRMaj2.data[i16];
                    float[] fArr3 = cMatrixRMaj3.data;
                    int i17 = i15 + 1;
                    fArr3[i15] = fArr3[i15] + ((f5 * f7) - (f6 * f8));
                    float[] fArr4 = cMatrixRMaj3.data;
                    i15 += 2;
                    fArr4[i17] = fArr4[i17] + (f8 * f5) + (f7 * f6);
                }
                cMatrixRMaj4 = cMatrixRMaj;
            }
            i3 += rowStride3;
            i2++;
            cMatrixRMaj4 = cMatrixRMaj;
            rowStride = i12;
        }
    }

    public static void multAdd_small(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CMatrixRMaj cMatrixRMaj4 = cMatrixRMaj;
        if (cMatrixRMaj4 == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj4.numCols != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj4.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int rowStride = cMatrixRMaj4.getRowStride();
        int rowStride2 = cMatrixRMaj2.getRowStride();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < cMatrixRMaj4.numRows) {
            int i4 = 0;
            while (i4 < cMatrixRMaj2.numCols) {
                int i5 = i4 * 2;
                int i6 = i2 + rowStride;
                float f = 0.0f;
                int i7 = i2;
                float f2 = 0.0f;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    float f3 = cMatrixRMaj4.data[i7];
                    i7 += 2;
                    float f4 = cMatrixRMaj4.data[i8];
                    float f5 = cMatrixRMaj2.data[i5];
                    float f6 = cMatrixRMaj2.data[i5 + 1];
                    f += (f3 * f5) - (f4 * f6);
                    f2 += (f3 * f6) + (f4 * f5);
                    i5 += rowStride2;
                    cMatrixRMaj4 = cMatrixRMaj;
                }
                float[] fArr = cMatrixRMaj3.data;
                int i9 = i3 + 1;
                fArr[i3] = fArr[i3] + f;
                float[] fArr2 = cMatrixRMaj3.data;
                i3 += 2;
                fArr2[i9] = fArr2[i9] + f2;
                i4++;
                cMatrixRMaj4 = cMatrixRMaj;
            }
            i2 += rowStride;
            i++;
            cMatrixRMaj4 = cMatrixRMaj;
        }
    }

    public static void multAddTransA_reorder(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (cMatrixRMaj.numCols == 0 || cMatrixRMaj.numRows == 0) {
            return;
        }
        for (int i = 0; i < cMatrixRMaj.numCols; i++) {
            int i2 = cMatrixRMaj3.numCols * i * 2;
            int i3 = i * 2;
            float f = cMatrixRMaj.data[i3];
            float f2 = cMatrixRMaj.data[i3 + 1];
            int i4 = cMatrixRMaj2.numCols * 2;
            int i5 = 0;
            int i6 = i2;
            while (i5 < i4) {
                int i7 = i5 + 1;
                float f3 = cMatrixRMaj2.data[i5];
                i5 += 2;
                float f4 = cMatrixRMaj2.data[i7];
                float[] fArr = cMatrixRMaj3.data;
                int i8 = i6 + 1;
                fArr[i6] = fArr[i6] + (f * f3) + (f2 * f4);
                float[] fArr2 = cMatrixRMaj3.data;
                i6 += 2;
                fArr2[i8] = fArr2[i8] + ((f4 * f) - (f3 * f2));
            }
            for (int i9 = 1; i9 < cMatrixRMaj.numRows; i9++) {
                float real = cMatrixRMaj.getReal(i9, i);
                float imag = cMatrixRMaj.getImag(i9, i);
                int i10 = (cMatrixRMaj2.numCols * 2) + i5;
                int i11 = i2;
                while (i5 < i10) {
                    int i12 = i5 + 1;
                    float f5 = cMatrixRMaj2.data[i5];
                    i5 += 2;
                    float f6 = cMatrixRMaj2.data[i12];
                    float[] fArr3 = cMatrixRMaj3.data;
                    int i13 = i11 + 1;
                    fArr3[i11] = fArr3[i11] + (real * f5) + (imag * f6);
                    float[] fArr4 = cMatrixRMaj3.data;
                    i11 += 2;
                    fArr4[i13] = fArr4[i13] + ((f6 * real) - (f5 * imag));
                }
            }
        }
    }

    public static void multAddTransA_small(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            for (int i3 = 0; i3 < cMatrixRMaj2.numCols; i3++) {
                int i4 = i2 * 2;
                int i5 = i3 * 2;
                int i6 = (cMatrixRMaj2.numRows * cMatrixRMaj2.numCols * 2) + i5;
                float f = 0.0f;
                float f2 = 0.0f;
                while (i5 < i6) {
                    float f3 = cMatrixRMaj.data[i4];
                    float f4 = cMatrixRMaj.data[i4 + 1];
                    float f5 = cMatrixRMaj2.data[i5];
                    float f6 = cMatrixRMaj2.data[i5 + 1];
                    f += (f3 * f5) + (f4 * f6);
                    f2 += (f3 * f6) - (f4 * f5);
                    i4 += cMatrixRMaj.numCols * 2;
                    i5 += cMatrixRMaj2.numCols * 2;
                }
                float[] fArr = cMatrixRMaj3.data;
                int i7 = i + 1;
                fArr[i] = fArr[i] + f;
                float[] fArr2 = cMatrixRMaj3.data;
                i += 2;
                fArr2[i7] = fArr2[i7] + f2;
            }
        }
    }

    public static void multAddTransB(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < cMatrixRMaj.numRows; i3++) {
            int i4 = (cMatrixRMaj2.numCols * 2) + i;
            int i5 = 0;
            for (int i6 = 0; i6 < cMatrixRMaj2.numRows; i6++) {
                float f = 0.0f;
                int i7 = i;
                float f2 = 0.0f;
                while (i7 < i4) {
                    int i8 = i7 + 1;
                    float f3 = cMatrixRMaj.data[i7];
                    i7 += 2;
                    float f4 = cMatrixRMaj.data[i8];
                    int i9 = i5 + 1;
                    float f5 = cMatrixRMaj2.data[i5];
                    i5 += 2;
                    float f6 = cMatrixRMaj2.data[i9];
                    f += (f3 * f5) + (f4 * f6);
                    f2 += (f4 * f5) - (f3 * f6);
                }
                float[] fArr = cMatrixRMaj3.data;
                int i10 = i2 + 1;
                fArr[i2] = fArr[i2] + f;
                float[] fArr2 = cMatrixRMaj3.data;
                i2 += 2;
                fArr2[i10] = fArr2[i10] + f2;
            }
            i += cMatrixRMaj.numCols * 2;
        }
    }

    public static void multAddTransAB(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < cMatrixRMaj2.numRows; i4++) {
                int i5 = i2 * 2;
                int i6 = (cMatrixRMaj2.numCols * 2) + i3;
                float f = 0.0f;
                float f2 = 0.0f;
                while (i3 < i6) {
                    float f3 = cMatrixRMaj.data[i5];
                    float f4 = -cMatrixRMaj.data[i5 + 1];
                    int i7 = i3 + 1;
                    float f5 = cMatrixRMaj2.data[i3];
                    i3 += 2;
                    float f6 = -cMatrixRMaj2.data[i7];
                    f += (f3 * f5) - (f4 * f6);
                    f2 += (f3 * f6) + (f4 * f5);
                    i5 += cMatrixRMaj.numCols * 2;
                }
                float[] fArr = cMatrixRMaj3.data;
                int i8 = i + 1;
                fArr[i] = fArr[i] + f;
                float[] fArr2 = cMatrixRMaj3.data;
                i += 2;
                fArr2[i8] = fArr2[i8] + f2;
            }
        }
    }

    public static void multAddTransAB_aux(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3, float[] fArr) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        float[] fArr2 = fArr == null ? new float[cMatrixRMaj.numRows * 2] : fArr;
        if (cMatrixRMaj.numCols == 0 || cMatrixRMaj.numRows == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            int i3 = i2 * 2;
            for (int i4 = 0; i4 < cMatrixRMaj2.numCols; i4++) {
                int i5 = i4 * 2;
                fArr2[i5] = cMatrixRMaj.data[i3];
                fArr2[i5 + 1] = cMatrixRMaj.data[i3 + 1];
                i3 += cMatrixRMaj.numCols * 2;
            }
            for (int i6 = 0; i6 < cMatrixRMaj2.numRows; i6++) {
                int i7 = cMatrixRMaj2.numCols * i6 * 2;
                float f = 0.0f;
                float f2 = 0.0f;
                int i8 = 0;
                for (int i9 = 0; i9 < cMatrixRMaj2.numCols; i9++) {
                    int i10 = i8 + 1;
                    float f3 = fArr2[i8];
                    i8 += 2;
                    float f4 = -fArr2[i10];
                    int i11 = i7 + 1;
                    float f5 = cMatrixRMaj2.data[i7];
                    i7 += 2;
                    float f6 = -cMatrixRMaj2.data[i11];
                    f += (f3 * f5) - (f4 * f6);
                    f2 += (f3 * f6) + (f4 * f5);
                }
                float[] fArr3 = cMatrixRMaj3.data;
                int i12 = i + 1;
                fArr3[i] = fArr3[i] + f;
                float[] fArr4 = cMatrixRMaj3.data;
                i += 2;
                fArr4[i12] = fArr4[i12] + f2;
            }
        }
    }

    public static void mult_reorder(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CMatrixRMaj cMatrixRMaj4 = cMatrixRMaj;
        if (cMatrixRMaj4 == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj4.numCols != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj4.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (cMatrixRMaj4.numCols == 0 || cMatrixRMaj4.numRows == 0) {
            CommonOps_CDRM.fill(cMatrixRMaj3, 0.0f, 0.0f);
            return;
        }
        int rowStride = cMatrixRMaj4.getRowStride();
        int rowStride2 = cMatrixRMaj2.getRowStride();
        int rowStride3 = cMatrixRMaj3.getRowStride();
        int i = cMatrixRMaj2.numRows * rowStride2;
        int i2 = 0;
        int i3 = 0;
        while (i2 < cMatrixRMaj4.numRows) {
            int i4 = i2 * rowStride;
            int i5 = i4 + 1;
            float f3 = cMatrixRMaj4.data[i4];
            int i6 = i4 + 2;
            float f4 = cMatrixRMaj4.data[i5];
            float f5 = (f * f3) - (f2 * f4);
            float f6 = (f4 * f) + (f3 * f2);
            int i7 = i3;
            int i8 = 0;
            while (i8 < rowStride2) {
                int i9 = i8 + 1;
                float f7 = cMatrixRMaj2.data[i8];
                i8 += 2;
                float f8 = cMatrixRMaj2.data[i9];
                int i10 = i7 + 1;
                cMatrixRMaj3.data[i7] = (f5 * f7) - (f6 * f8);
                i7 += 2;
                cMatrixRMaj3.data[i10] = (f8 * f5) + (f7 * f6);
                rowStride = rowStride;
            }
            int i11 = rowStride;
            while (i8 != i) {
                int i12 = i8 + rowStride2;
                int i13 = i6 + 1;
                float f9 = cMatrixRMaj4.data[i6];
                i6 += 2;
                float f10 = cMatrixRMaj4.data[i13];
                float f11 = (f * f9) - (f2 * f10);
                float f12 = (f10 * f) + (f9 * f2);
                int i14 = i3;
                while (i8 < i12) {
                    int i15 = i8 + 1;
                    float f13 = cMatrixRMaj2.data[i8];
                    i8 += 2;
                    float f14 = cMatrixRMaj2.data[i15];
                    float[] fArr = cMatrixRMaj3.data;
                    int i16 = i14 + 1;
                    fArr[i14] = fArr[i14] + ((f11 * f13) - (f12 * f14));
                    float[] fArr2 = cMatrixRMaj3.data;
                    i14 += 2;
                    fArr2[i16] = fArr2[i16] + (f14 * f11) + (f13 * f12);
                }
                cMatrixRMaj4 = cMatrixRMaj;
            }
            i3 += rowStride3;
            i2++;
            cMatrixRMaj4 = cMatrixRMaj;
            rowStride = i11;
        }
    }

    public static void mult_small(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CMatrixRMaj cMatrixRMaj4 = cMatrixRMaj;
        if (cMatrixRMaj4 == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj4.numCols != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj4.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int rowStride = cMatrixRMaj4.getRowStride();
        int rowStride2 = cMatrixRMaj2.getRowStride();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < cMatrixRMaj4.numRows) {
            int i4 = 0;
            while (i4 < cMatrixRMaj2.numCols) {
                int i5 = i4 * 2;
                int i6 = i2 + rowStride;
                float f3 = 0.0f;
                int i7 = i2;
                float f4 = 0.0f;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    float f5 = cMatrixRMaj4.data[i7];
                    i7 += 2;
                    float f6 = cMatrixRMaj4.data[i8];
                    float f7 = cMatrixRMaj2.data[i5];
                    float f8 = cMatrixRMaj2.data[i5 + 1];
                    f3 += (f5 * f7) - (f6 * f8);
                    f4 += (f5 * f8) + (f6 * f7);
                    i5 += rowStride2;
                    cMatrixRMaj4 = cMatrixRMaj;
                }
                int i9 = i3 + 1;
                cMatrixRMaj3.data[i3] = (f * f3) - (f2 * f4);
                i3 += 2;
                cMatrixRMaj3.data[i9] = (f4 * f) + (f3 * f2);
                i4++;
                cMatrixRMaj4 = cMatrixRMaj;
            }
            i2 += rowStride;
            i++;
            cMatrixRMaj4 = cMatrixRMaj;
        }
    }

    public static void multTransA_reorder(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (cMatrixRMaj.numCols == 0 || cMatrixRMaj.numRows == 0) {
            CommonOps_CDRM.fill(cMatrixRMaj3, 0.0f, 0.0f);
            return;
        }
        for (int i = 0; i < cMatrixRMaj.numCols; i++) {
            int i2 = cMatrixRMaj3.numCols * i * 2;
            int i3 = i * 2;
            float f3 = cMatrixRMaj.data[i3];
            float f4 = cMatrixRMaj.data[i3 + 1];
            float f5 = (f * f3) + (f2 * f4);
            float f6 = (f4 * f) - (f3 * f2);
            int i4 = cMatrixRMaj2.numCols * 2;
            int i5 = 0;
            int i6 = i2;
            while (i5 < i4) {
                int i7 = i5 + 1;
                float f7 = cMatrixRMaj2.data[i5];
                i5 += 2;
                float f8 = cMatrixRMaj2.data[i7];
                int i8 = i6 + 1;
                cMatrixRMaj3.data[i6] = (f5 * f7) + (f6 * f8);
                i6 += 2;
                cMatrixRMaj3.data[i8] = (f8 * f5) - (f7 * f6);
            }
            for (int i9 = 1; i9 < cMatrixRMaj.numRows; i9++) {
                float real = cMatrixRMaj.getReal(i9, i);
                float imag = cMatrixRMaj.getImag(i9, i);
                float f9 = (f * real) + (f2 * imag);
                float f10 = (imag * f) - (real * f2);
                int i10 = (cMatrixRMaj2.numCols * 2) + i5;
                int i11 = i2;
                while (i5 < i10) {
                    int i12 = i5 + 1;
                    float f11 = cMatrixRMaj2.data[i5];
                    i5 += 2;
                    float f12 = cMatrixRMaj2.data[i12];
                    float[] fArr = cMatrixRMaj3.data;
                    int i13 = i11 + 1;
                    fArr[i11] = fArr[i11] + (f9 * f11) + (f10 * f12);
                    float[] fArr2 = cMatrixRMaj3.data;
                    i11 += 2;
                    fArr2[i13] = fArr2[i13] + ((f12 * f9) - (f11 * f10));
                }
            }
        }
    }

    public static void multTransA_small(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            for (int i3 = 0; i3 < cMatrixRMaj2.numCols; i3++) {
                int i4 = i2 * 2;
                int i5 = i3 * 2;
                int i6 = (cMatrixRMaj2.numRows * cMatrixRMaj2.numCols * 2) + i5;
                float f3 = 0.0f;
                float f4 = 0.0f;
                while (i5 < i6) {
                    float f5 = cMatrixRMaj.data[i4];
                    float f6 = cMatrixRMaj.data[i4 + 1];
                    float f7 = cMatrixRMaj2.data[i5];
                    float f8 = cMatrixRMaj2.data[i5 + 1];
                    f3 += (f5 * f7) + (f6 * f8);
                    f4 += (f5 * f8) - (f6 * f7);
                    i4 += cMatrixRMaj.numCols * 2;
                    i5 += cMatrixRMaj2.numCols * 2;
                }
                int i7 = i + 1;
                cMatrixRMaj3.data[i] = (f * f3) - (f2 * f4);
                i += 2;
                cMatrixRMaj3.data[i7] = (f4 * f) + (f3 * f2);
            }
        }
    }

    public static void multTransB(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < cMatrixRMaj.numRows; i3++) {
            int i4 = (cMatrixRMaj2.numCols * 2) + i;
            int i5 = 0;
            for (int i6 = 0; i6 < cMatrixRMaj2.numRows; i6++) {
                float f3 = 0.0f;
                int i7 = i;
                float f4 = 0.0f;
                while (i7 < i4) {
                    int i8 = i7 + 1;
                    float f5 = cMatrixRMaj.data[i7];
                    i7 += 2;
                    float f6 = cMatrixRMaj.data[i8];
                    int i9 = i5 + 1;
                    float f7 = cMatrixRMaj2.data[i5];
                    i5 += 2;
                    float f8 = cMatrixRMaj2.data[i9];
                    f3 += (f5 * f7) + (f6 * f8);
                    f4 += (f6 * f7) - (f5 * f8);
                }
                int i10 = i2 + 1;
                cMatrixRMaj3.data[i2] = (f * f3) - (f2 * f4);
                i2 += 2;
                cMatrixRMaj3.data[i10] = (f4 * f) + (f3 * f2);
            }
            i += cMatrixRMaj.numCols * 2;
        }
    }

    public static void multTransAB(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < cMatrixRMaj2.numRows; i4++) {
                int i5 = i2 * 2;
                int i6 = (cMatrixRMaj2.numCols * 2) + i3;
                float f3 = 0.0f;
                float f4 = 0.0f;
                while (i3 < i6) {
                    float f5 = cMatrixRMaj.data[i5];
                    float f6 = -cMatrixRMaj.data[i5 + 1];
                    int i7 = i3 + 1;
                    float f7 = cMatrixRMaj2.data[i3];
                    i3 += 2;
                    float f8 = -cMatrixRMaj2.data[i7];
                    f3 += (f5 * f7) - (f6 * f8);
                    f4 += (f5 * f8) + (f6 * f7);
                    i5 += cMatrixRMaj.numCols * 2;
                }
                int i8 = i + 1;
                cMatrixRMaj3.data[i] = (f * f3) - (f2 * f4);
                i += 2;
                cMatrixRMaj3.data[i8] = (f4 * f) + (f3 * f2);
            }
        }
    }

    public static void multTransAB_aux(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3, float[] fArr) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        float[] fArr2 = fArr == null ? new float[cMatrixRMaj.numRows * 2] : fArr;
        if (cMatrixRMaj.numCols == 0 || cMatrixRMaj.numRows == 0) {
            CommonOps_CDRM.fill(cMatrixRMaj3, 0.0f, 0.0f);
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            int i3 = i2 * 2;
            for (int i4 = 0; i4 < cMatrixRMaj2.numCols; i4++) {
                int i5 = i4 * 2;
                fArr2[i5] = cMatrixRMaj.data[i3];
                fArr2[i5 + 1] = cMatrixRMaj.data[i3 + 1];
                i3 += cMatrixRMaj.numCols * 2;
            }
            for (int i6 = 0; i6 < cMatrixRMaj2.numRows; i6++) {
                int i7 = cMatrixRMaj2.numCols * i6 * 2;
                float f3 = 0.0f;
                float f4 = 0.0f;
                int i8 = 0;
                for (int i9 = 0; i9 < cMatrixRMaj2.numCols; i9++) {
                    int i10 = i8 + 1;
                    float f5 = fArr2[i8];
                    i8 += 2;
                    float f6 = -fArr2[i10];
                    int i11 = i7 + 1;
                    float f7 = cMatrixRMaj2.data[i7];
                    i7 += 2;
                    float f8 = -cMatrixRMaj2.data[i11];
                    f3 += (f5 * f7) - (f6 * f8);
                    f4 += (f5 * f8) + (f6 * f7);
                }
                int i12 = i + 1;
                cMatrixRMaj3.data[i] = (f * f3) - (f2 * f4);
                i += 2;
                cMatrixRMaj3.data[i12] = (f4 * f) + (f3 * f2);
            }
        }
    }

    public static void multAdd_reorder(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CMatrixRMaj cMatrixRMaj4 = cMatrixRMaj;
        if (cMatrixRMaj4 == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj4.numCols != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj4.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (cMatrixRMaj4.numCols == 0 || cMatrixRMaj4.numRows == 0) {
            return;
        }
        int rowStride = cMatrixRMaj4.getRowStride();
        int rowStride2 = cMatrixRMaj2.getRowStride();
        int rowStride3 = cMatrixRMaj3.getRowStride();
        int i = cMatrixRMaj2.numRows * rowStride2;
        int i2 = 0;
        int i3 = 0;
        while (i2 < cMatrixRMaj4.numRows) {
            int i4 = i2 * rowStride;
            int i5 = i4 + 1;
            float f3 = cMatrixRMaj4.data[i4];
            int i6 = i4 + 2;
            float f4 = cMatrixRMaj4.data[i5];
            float f5 = (f * f3) - (f2 * f4);
            float f6 = (f4 * f) + (f3 * f2);
            int i7 = i3;
            int i8 = 0;
            while (i8 < rowStride2) {
                int i9 = i8 + 1;
                float f7 = cMatrixRMaj2.data[i8];
                i8 += 2;
                float f8 = cMatrixRMaj2.data[i9];
                int i10 = rowStride;
                float[] fArr = cMatrixRMaj3.data;
                int i11 = i7 + 1;
                fArr[i7] = fArr[i7] + ((f5 * f7) - (f6 * f8));
                float[] fArr2 = cMatrixRMaj3.data;
                i7 += 2;
                fArr2[i11] = fArr2[i11] + (f8 * f5) + (f7 * f6);
                rowStride = i10;
            }
            int i12 = rowStride;
            while (i8 != i) {
                int i13 = i8 + rowStride2;
                int i14 = i6 + 1;
                float f9 = cMatrixRMaj4.data[i6];
                i6 += 2;
                float f10 = cMatrixRMaj4.data[i14];
                float f11 = (f * f9) - (f2 * f10);
                float f12 = (f10 * f) + (f9 * f2);
                int i15 = i3;
                while (i8 < i13) {
                    int i16 = i8 + 1;
                    float f13 = cMatrixRMaj2.data[i8];
                    i8 += 2;
                    float f14 = cMatrixRMaj2.data[i16];
                    float[] fArr3 = cMatrixRMaj3.data;
                    int i17 = i15 + 1;
                    fArr3[i15] = fArr3[i15] + ((f11 * f13) - (f12 * f14));
                    float[] fArr4 = cMatrixRMaj3.data;
                    i15 += 2;
                    fArr4[i17] = fArr4[i17] + (f14 * f11) + (f13 * f12);
                }
                cMatrixRMaj4 = cMatrixRMaj;
            }
            i3 += rowStride3;
            i2++;
            cMatrixRMaj4 = cMatrixRMaj;
            rowStride = i12;
        }
    }

    public static void multAdd_small(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        CMatrixRMaj cMatrixRMaj4 = cMatrixRMaj;
        if (cMatrixRMaj4 == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj4.numCols != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj4.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int rowStride = cMatrixRMaj4.getRowStride();
        int rowStride2 = cMatrixRMaj2.getRowStride();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < cMatrixRMaj4.numRows) {
            int i4 = 0;
            while (i4 < cMatrixRMaj2.numCols) {
                int i5 = i4 * 2;
                int i6 = i2 + rowStride;
                float f3 = 0.0f;
                int i7 = i2;
                float f4 = 0.0f;
                while (i7 < i6) {
                    int i8 = i7 + 1;
                    float f5 = cMatrixRMaj4.data[i7];
                    i7 += 2;
                    float f6 = cMatrixRMaj4.data[i8];
                    float f7 = cMatrixRMaj2.data[i5];
                    float f8 = cMatrixRMaj2.data[i5 + 1];
                    f3 += (f5 * f7) - (f6 * f8);
                    f4 += (f5 * f8) + (f6 * f7);
                    i5 += rowStride2;
                    cMatrixRMaj4 = cMatrixRMaj;
                }
                float[] fArr = cMatrixRMaj3.data;
                int i9 = i3 + 1;
                fArr[i3] = fArr[i3] + ((f * f3) - (f2 * f4));
                float[] fArr2 = cMatrixRMaj3.data;
                i3 += 2;
                fArr2[i9] = fArr2[i9] + (f4 * f) + (f3 * f2);
                i4++;
                cMatrixRMaj4 = cMatrixRMaj;
            }
            i2 += rowStride;
            i++;
            cMatrixRMaj4 = cMatrixRMaj;
        }
    }

    public static void multAddTransA_reorder(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        if (cMatrixRMaj.numCols == 0 || cMatrixRMaj.numRows == 0) {
            return;
        }
        for (int i = 0; i < cMatrixRMaj.numCols; i++) {
            int i2 = cMatrixRMaj3.numCols * i * 2;
            int i3 = i * 2;
            float f3 = cMatrixRMaj.data[i3];
            float f4 = cMatrixRMaj.data[i3 + 1];
            float f5 = (f * f3) + (f2 * f4);
            float f6 = (f4 * f) - (f3 * f2);
            int i4 = cMatrixRMaj2.numCols * 2;
            int i5 = 0;
            int i6 = i2;
            while (i5 < i4) {
                int i7 = i5 + 1;
                float f7 = cMatrixRMaj2.data[i5];
                i5 += 2;
                float f8 = cMatrixRMaj2.data[i7];
                float[] fArr = cMatrixRMaj3.data;
                int i8 = i6 + 1;
                fArr[i6] = fArr[i6] + (f5 * f7) + (f6 * f8);
                float[] fArr2 = cMatrixRMaj3.data;
                i6 += 2;
                fArr2[i8] = fArr2[i8] + ((f8 * f5) - (f7 * f6));
            }
            for (int i9 = 1; i9 < cMatrixRMaj.numRows; i9++) {
                float real = cMatrixRMaj.getReal(i9, i);
                float imag = cMatrixRMaj.getImag(i9, i);
                float f9 = (f * real) + (f2 * imag);
                float f10 = (imag * f) - (real * f2);
                int i10 = (cMatrixRMaj2.numCols * 2) + i5;
                int i11 = i2;
                while (i5 < i10) {
                    int i12 = i5 + 1;
                    float f11 = cMatrixRMaj2.data[i5];
                    i5 += 2;
                    float f12 = cMatrixRMaj2.data[i12];
                    float[] fArr3 = cMatrixRMaj3.data;
                    int i13 = i11 + 1;
                    fArr3[i11] = fArr3[i11] + (f9 * f11) + (f10 * f12);
                    float[] fArr4 = cMatrixRMaj3.data;
                    i11 += 2;
                    fArr4[i13] = fArr4[i13] + ((f12 * f9) - (f11 * f10));
                }
            }
        }
    }

    public static void multAddTransA_small(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numRows) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numCols != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            for (int i3 = 0; i3 < cMatrixRMaj2.numCols; i3++) {
                int i4 = i2 * 2;
                int i5 = i3 * 2;
                int i6 = (cMatrixRMaj2.numRows * cMatrixRMaj2.numCols * 2) + i5;
                float f3 = 0.0f;
                float f4 = 0.0f;
                while (i5 < i6) {
                    float f5 = cMatrixRMaj.data[i4];
                    float f6 = cMatrixRMaj.data[i4 + 1];
                    float f7 = cMatrixRMaj2.data[i5];
                    float f8 = cMatrixRMaj2.data[i5 + 1];
                    f3 += (f5 * f7) + (f6 * f8);
                    f4 += (f5 * f8) - (f6 * f7);
                    i4 += cMatrixRMaj.numCols * 2;
                    i5 += cMatrixRMaj2.numCols * 2;
                }
                float[] fArr = cMatrixRMaj3.data;
                int i7 = i + 1;
                fArr[i] = fArr[i] + ((f * f3) - (f2 * f4));
                float[] fArr2 = cMatrixRMaj3.data;
                i += 2;
                fArr2[i7] = fArr2[i7] + (f4 * f) + (f3 * f2);
            }
        }
    }

    public static void multAddTransB(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < cMatrixRMaj.numRows; i3++) {
            int i4 = (cMatrixRMaj2.numCols * 2) + i;
            int i5 = 0;
            for (int i6 = 0; i6 < cMatrixRMaj2.numRows; i6++) {
                float f3 = 0.0f;
                int i7 = i;
                float f4 = 0.0f;
                while (i7 < i4) {
                    int i8 = i7 + 1;
                    float f5 = cMatrixRMaj.data[i7];
                    i7 += 2;
                    float f6 = cMatrixRMaj.data[i8];
                    int i9 = i5 + 1;
                    float f7 = cMatrixRMaj2.data[i5];
                    i5 += 2;
                    float f8 = cMatrixRMaj2.data[i9];
                    f3 += (f5 * f7) + (f6 * f8);
                    f4 += (f6 * f7) - (f5 * f8);
                }
                float[] fArr = cMatrixRMaj3.data;
                int i10 = i2 + 1;
                fArr[i2] = fArr[i2] + ((f * f3) - (f2 * f4));
                float[] fArr2 = cMatrixRMaj3.data;
                i2 += 2;
                fArr2[i10] = fArr2[i10] + (f4 * f) + (f3 * f2);
            }
            i += cMatrixRMaj.numCols * 2;
        }
    }

    public static void multAddTransAB(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < cMatrixRMaj2.numRows; i4++) {
                int i5 = i2 * 2;
                int i6 = (cMatrixRMaj2.numCols * 2) + i3;
                float f3 = 0.0f;
                float f4 = 0.0f;
                while (i3 < i6) {
                    float f5 = cMatrixRMaj.data[i5];
                    float f6 = -cMatrixRMaj.data[i5 + 1];
                    int i7 = i3 + 1;
                    float f7 = cMatrixRMaj2.data[i3];
                    i3 += 2;
                    float f8 = -cMatrixRMaj2.data[i7];
                    f3 += (f5 * f7) - (f6 * f8);
                    f4 += (f5 * f8) + (f6 * f7);
                    i5 += cMatrixRMaj.numCols * 2;
                }
                float[] fArr = cMatrixRMaj3.data;
                int i8 = i + 1;
                fArr[i] = fArr[i] + ((f * f3) - (f2 * f4));
                float[] fArr2 = cMatrixRMaj3.data;
                i += 2;
                fArr2[i8] = fArr2[i8] + (f4 * f) + (f3 * f2);
            }
        }
    }

    public static void multAddTransAB_aux(float f, float f2, CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2, CMatrixRMaj cMatrixRMaj3, float[] fArr) {
        if (cMatrixRMaj == cMatrixRMaj3 || cMatrixRMaj2 == cMatrixRMaj3) {
            throw new IllegalArgumentException("Neither 'a' or 'b' can be the same matrix as 'c'");
        }
        if (cMatrixRMaj.numRows != cMatrixRMaj2.numCols) {
            throw new MatrixDimensionException("The 'a' and 'b' matrices do not have compatible dimensions");
        }
        if (cMatrixRMaj.numCols != cMatrixRMaj3.numRows || cMatrixRMaj2.numRows != cMatrixRMaj3.numCols) {
            throw new MatrixDimensionException("The results matrix does not have the desired dimensions");
        }
        float[] fArr2 = fArr == null ? new float[cMatrixRMaj.numRows * 2] : fArr;
        if (cMatrixRMaj.numCols == 0 || cMatrixRMaj.numRows == 0) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj.numCols; i2++) {
            int i3 = i2 * 2;
            for (int i4 = 0; i4 < cMatrixRMaj2.numCols; i4++) {
                int i5 = i4 * 2;
                fArr2[i5] = cMatrixRMaj.data[i3];
                fArr2[i5 + 1] = cMatrixRMaj.data[i3 + 1];
                i3 += cMatrixRMaj.numCols * 2;
            }
            for (int i6 = 0; i6 < cMatrixRMaj2.numRows; i6++) {
                int i7 = cMatrixRMaj2.numCols * i6 * 2;
                float f3 = 0.0f;
                float f4 = 0.0f;
                int i8 = 0;
                for (int i9 = 0; i9 < cMatrixRMaj2.numCols; i9++) {
                    int i10 = i8 + 1;
                    float f5 = fArr2[i8];
                    i8 += 2;
                    float f6 = -fArr2[i10];
                    int i11 = i7 + 1;
                    float f7 = cMatrixRMaj2.data[i7];
                    i7 += 2;
                    float f8 = -cMatrixRMaj2.data[i11];
                    f3 += (f5 * f7) - (f6 * f8);
                    f4 += (f5 * f8) + (f6 * f7);
                }
                float[] fArr3 = cMatrixRMaj3.data;
                int i12 = i + 1;
                fArr3[i] = fArr3[i] + ((f * f3) - (f2 * f4));
                float[] fArr4 = cMatrixRMaj3.data;
                i += 2;
                fArr4[i12] = fArr4[i12] + (f4 * f) + (f3 * f2);
            }
        }
    }
}
