package org.ejml.ops;

import org.ejml.data.BMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class CommonOps_BDRM {
    public static void transposeSquare(BMatrixRMaj bMatrixRMaj) {
        if (bMatrixRMaj.numCols != bMatrixRMaj.numRows) {
            throw new IllegalArgumentException("Must be sqare");
        }
        int i = bMatrixRMaj.numCols;
        int i2 = 1;
        int i3 = 0;
        while (i3 < bMatrixRMaj.numRows) {
            int i4 = i3 + 1;
            int i5 = (bMatrixRMaj.numCols * i4) + i3;
            while (i2 < i) {
                boolean z = bMatrixRMaj.data[i2];
                bMatrixRMaj.data[i2] = bMatrixRMaj.data[i5];
                bMatrixRMaj.data[i5] = z;
                i2++;
                i5 += bMatrixRMaj.numCols;
            }
            i2 += i3 + 2;
            i += bMatrixRMaj.numCols;
            i3 = i4;
        }
    }
}
