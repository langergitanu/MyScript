package org.ejml.dense.row.decomposition;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class UtilDecompositons_DDRM {
    public static DMatrixRMaj checkIdentity(DMatrixRMaj dMatrixRMaj, int i, int i2) {
        if (dMatrixRMaj == null) {
            return CommonOps_DDRM.identity(i, i2);
        }
        if (i != dMatrixRMaj.numRows || i2 != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        CommonOps_DDRM.setIdentity(dMatrixRMaj);
        return dMatrixRMaj;
    }

    public static DMatrixRMaj checkZeros(DMatrixRMaj dMatrixRMaj, int i, int i2) {
        if (dMatrixRMaj == null) {
            return new DMatrixRMaj(i, i2);
        }
        if (i != dMatrixRMaj.numRows || i2 != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        dMatrixRMaj.zero();
        return dMatrixRMaj;
    }

    public static DMatrixRMaj checkZerosLT(DMatrixRMaj dMatrixRMaj, int i, int i2) {
        if (dMatrixRMaj == null) {
            return new DMatrixRMaj(i, i2);
        }
        if (i != dMatrixRMaj.numRows || i2 != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        for (int i3 = 0; i3 < dMatrixRMaj.numRows; i3++) {
            int i4 = dMatrixRMaj.numCols * i3;
            int iMin = Math.min(i3, dMatrixRMaj.numCols) + i4;
            while (i4 < iMin) {
                dMatrixRMaj.data[i4] = 0.0d;
                i4++;
            }
        }
        return dMatrixRMaj;
    }

    public static DMatrixRMaj checkZerosUT(DMatrixRMaj dMatrixRMaj, int i, int i2) {
        if (dMatrixRMaj == null) {
            return new DMatrixRMaj(i, i2);
        }
        if (i != dMatrixRMaj.numRows || i2 != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        int iMin = Math.min(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = (dMatrixRMaj.numCols * i3) + dMatrixRMaj.numCols;
            for (int i5 = (dMatrixRMaj.numCols * i3) + i3 + 1; i5 < i4; i5++) {
                dMatrixRMaj.data[i5] = 0.0d;
            }
        }
        return dMatrixRMaj;
    }
}
