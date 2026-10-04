package org.ejml.dense.row.misc;

import org.ejml.data.CMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class TransposeAlgs_CDRM {
    public static void square(CMatrixRMaj cMatrixRMaj) {
        int rowStride = cMatrixRMaj.getRowStride();
        int i = 0;
        int i2 = rowStride;
        int i3 = 2;
        while (i < cMatrixRMaj.numRows) {
            int i4 = i + 1;
            int i5 = (i4 * rowStride) + (i * 2);
            while (i3 < i2) {
                float f = cMatrixRMaj.data[i3];
                int i6 = i3 + 1;
                float f2 = cMatrixRMaj.data[i6];
                cMatrixRMaj.data[i3] = cMatrixRMaj.data[i5];
                int i7 = i5 + 1;
                cMatrixRMaj.data[i6] = cMatrixRMaj.data[i7];
                cMatrixRMaj.data[i5] = f;
                cMatrixRMaj.data[i7] = f2;
                i3 += 2;
                i5 += rowStride;
            }
            i3 += (i + 2) * 2;
            i2 += rowStride;
            i = i4;
        }
    }

    public static void squareConjugate(CMatrixRMaj cMatrixRMaj) {
        int rowStride = cMatrixRMaj.getRowStride();
        int i = 0;
        int i2 = rowStride;
        int i3 = 2;
        while (i < cMatrixRMaj.numRows) {
            int i4 = i3 - 1;
            cMatrixRMaj.data[i4] = -cMatrixRMaj.data[i4];
            int i5 = i + 1;
            int i6 = (i5 * rowStride) + (i * 2);
            while (i3 < i2) {
                float f = cMatrixRMaj.data[i3];
                int i7 = i3 + 1;
                float f2 = cMatrixRMaj.data[i7];
                cMatrixRMaj.data[i3] = cMatrixRMaj.data[i6];
                int i8 = i6 + 1;
                cMatrixRMaj.data[i7] = -cMatrixRMaj.data[i8];
                cMatrixRMaj.data[i6] = f;
                cMatrixRMaj.data[i8] = -f2;
                i3 += 2;
                i6 += rowStride;
            }
            i3 += (i + 2) * 2;
            i2 += rowStride;
            i = i5;
        }
    }

    public static void standard(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        int rowStride = cMatrixRMaj2.getRowStride();
        int rowStride2 = cMatrixRMaj.getRowStride();
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj2.numRows; i2++) {
            int i3 = i2 * 2;
            int i4 = i + rowStride;
            while (i < i4) {
                int i5 = i + 1;
                cMatrixRMaj2.data[i] = cMatrixRMaj.data[i3];
                i += 2;
                cMatrixRMaj2.data[i5] = cMatrixRMaj.data[i3 + 1];
                i3 += rowStride2;
            }
        }
    }

    public static void standardConjugate(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        int rowStride = cMatrixRMaj2.getRowStride();
        int rowStride2 = cMatrixRMaj.getRowStride();
        int i = 0;
        for (int i2 = 0; i2 < cMatrixRMaj2.numRows; i2++) {
            int i3 = i2 * 2;
            int i4 = i + rowStride;
            while (i < i4) {
                int i5 = i + 1;
                cMatrixRMaj2.data[i] = cMatrixRMaj.data[i3];
                i += 2;
                cMatrixRMaj2.data[i5] = -cMatrixRMaj.data[i3 + 1];
                i3 += rowStride2;
            }
        }
    }
}
