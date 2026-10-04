package org.ejml.dense.row.misc;

import org.ejml.data.ZMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class TransposeAlgs_ZDRM {
    public static void square(ZMatrixRMaj zMatrixRMaj) {
        int rowStride = zMatrixRMaj.getRowStride();
        int i = 0;
        int i2 = rowStride;
        int i3 = 2;
        while (i < zMatrixRMaj.numRows) {
            int i4 = i + 1;
            int i5 = (i4 * rowStride) + (i * 2);
            while (i3 < i2) {
                double d = zMatrixRMaj.data[i3];
                int i6 = i3 + 1;
                double d2 = zMatrixRMaj.data[i6];
                zMatrixRMaj.data[i3] = zMatrixRMaj.data[i5];
                int i7 = i5 + 1;
                zMatrixRMaj.data[i6] = zMatrixRMaj.data[i7];
                zMatrixRMaj.data[i5] = d;
                zMatrixRMaj.data[i7] = d2;
                i3 += 2;
                i5 += rowStride;
            }
            i3 += (i + 2) * 2;
            i2 += rowStride;
            i = i4;
        }
    }

    public static void squareConjugate(ZMatrixRMaj zMatrixRMaj) {
        int rowStride = zMatrixRMaj.getRowStride();
        int i = 0;
        int i2 = rowStride;
        int i3 = 2;
        while (i < zMatrixRMaj.numRows) {
            int i4 = i3 - 1;
            zMatrixRMaj.data[i4] = -zMatrixRMaj.data[i4];
            int i5 = i + 1;
            int i6 = (i5 * rowStride) + (i * 2);
            while (i3 < i2) {
                double d = zMatrixRMaj.data[i3];
                int i7 = i3 + 1;
                double d2 = zMatrixRMaj.data[i7];
                zMatrixRMaj.data[i3] = zMatrixRMaj.data[i6];
                int i8 = i6 + 1;
                zMatrixRMaj.data[i7] = -zMatrixRMaj.data[i8];
                zMatrixRMaj.data[i6] = d;
                zMatrixRMaj.data[i8] = -d2;
                i3 += 2;
                i6 += rowStride;
                i = i;
            }
            i3 += (i + 2) * 2;
            i2 += rowStride;
            i = i5;
        }
    }

    public static void standard(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        int rowStride = zMatrixRMaj2.getRowStride();
        int rowStride2 = zMatrixRMaj.getRowStride();
        int i = 0;
        for (int i2 = 0; i2 < zMatrixRMaj2.numRows; i2++) {
            int i3 = i2 * 2;
            int i4 = i + rowStride;
            while (i < i4) {
                int i5 = i + 1;
                zMatrixRMaj2.data[i] = zMatrixRMaj.data[i3];
                i += 2;
                zMatrixRMaj2.data[i5] = zMatrixRMaj.data[i3 + 1];
                i3 += rowStride2;
            }
        }
    }

    public static void standardConjugate(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        int rowStride = zMatrixRMaj2.getRowStride();
        int rowStride2 = zMatrixRMaj.getRowStride();
        int i = 0;
        for (int i2 = 0; i2 < zMatrixRMaj2.numRows; i2++) {
            int i3 = i2 * 2;
            int i4 = i + rowStride;
            while (i < i4) {
                int i5 = i + 1;
                zMatrixRMaj2.data[i] = zMatrixRMaj.data[i3];
                i += 2;
                zMatrixRMaj2.data[i5] = -zMatrixRMaj.data[i3 + 1];
                i3 += rowStride2;
            }
        }
    }
}
