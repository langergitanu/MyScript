package org.ejml.dense.row.decompose;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.CommonOps_ZDRM;

/* JADX INFO: loaded from: classes9.dex */
public class UtilDecompositons_ZDRM {
    public static ZMatrixRMaj checkIdentity(ZMatrixRMaj zMatrixRMaj, int i, int i2) {
        if (zMatrixRMaj == null) {
            return CommonOps_ZDRM.identity(i, i2);
        }
        if (i != zMatrixRMaj.numRows || i2 != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        CommonOps_ZDRM.setIdentity(zMatrixRMaj);
        return zMatrixRMaj;
    }

    public static ZMatrixRMaj checkZeros(ZMatrixRMaj zMatrixRMaj, int i, int i2) {
        if (zMatrixRMaj == null) {
            return new ZMatrixRMaj(i, i2);
        }
        if (i != zMatrixRMaj.numRows || i2 != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        zMatrixRMaj.zero();
        return zMatrixRMaj;
    }

    public static ZMatrixRMaj checkZerosLT(ZMatrixRMaj zMatrixRMaj, int i, int i2) {
        if (zMatrixRMaj == null) {
            return new ZMatrixRMaj(i, i2);
        }
        if (i != zMatrixRMaj.numRows || i2 != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        for (int i3 = 0; i3 < zMatrixRMaj.numRows; i3++) {
            int i4 = zMatrixRMaj.numCols * i3 * 2;
            int iMin = (Math.min(i3, zMatrixRMaj.numCols) * 2) + i4;
            while (i4 < iMin) {
                zMatrixRMaj.data[i4] = 0.0d;
                i4++;
            }
        }
        return zMatrixRMaj;
    }

    public static ZMatrixRMaj checkZerosUT(ZMatrixRMaj zMatrixRMaj, int i, int i2) {
        if (zMatrixRMaj == null) {
            return new ZMatrixRMaj(i, i2);
        }
        if (i != zMatrixRMaj.numRows || i2 != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        int iMin = Math.min(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = ((zMatrixRMaj.numCols * i3) + zMatrixRMaj.numCols) * 2;
            for (int i5 = ((zMatrixRMaj.numCols * i3) + i3 + 1) * 2; i5 < i4; i5++) {
                zMatrixRMaj.data[i5] = 0.0d;
            }
        }
        return zMatrixRMaj;
    }
}
