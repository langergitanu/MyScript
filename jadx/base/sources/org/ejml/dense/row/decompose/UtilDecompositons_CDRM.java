package org.ejml.dense.row.decompose;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.CommonOps_CDRM;

/* JADX INFO: loaded from: classes9.dex */
public class UtilDecompositons_CDRM {
    public static CMatrixRMaj checkIdentity(CMatrixRMaj cMatrixRMaj, int i, int i2) {
        if (cMatrixRMaj == null) {
            return CommonOps_CDRM.identity(i, i2);
        }
        if (i != cMatrixRMaj.numRows || i2 != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        CommonOps_CDRM.setIdentity(cMatrixRMaj);
        return cMatrixRMaj;
    }

    public static CMatrixRMaj checkZeros(CMatrixRMaj cMatrixRMaj, int i, int i2) {
        if (cMatrixRMaj == null) {
            return new CMatrixRMaj(i, i2);
        }
        if (i != cMatrixRMaj.numRows || i2 != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        cMatrixRMaj.zero();
        return cMatrixRMaj;
    }

    public static CMatrixRMaj checkZerosLT(CMatrixRMaj cMatrixRMaj, int i, int i2) {
        if (cMatrixRMaj == null) {
            return new CMatrixRMaj(i, i2);
        }
        if (i != cMatrixRMaj.numRows || i2 != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        for (int i3 = 0; i3 < cMatrixRMaj.numRows; i3++) {
            int i4 = cMatrixRMaj.numCols * i3 * 2;
            int iMin = (Math.min(i3, cMatrixRMaj.numCols) * 2) + i4;
            while (i4 < iMin) {
                cMatrixRMaj.data[i4] = 0.0f;
                i4++;
            }
        }
        return cMatrixRMaj;
    }

    public static CMatrixRMaj checkZerosUT(CMatrixRMaj cMatrixRMaj, int i, int i2) {
        if (cMatrixRMaj == null) {
            return new CMatrixRMaj(i, i2);
        }
        if (i != cMatrixRMaj.numRows || i2 != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        int iMin = Math.min(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = ((cMatrixRMaj.numCols * i3) + cMatrixRMaj.numCols) * 2;
            for (int i5 = ((cMatrixRMaj.numCols * i3) + i3 + 1) * 2; i5 < i4; i5++) {
                cMatrixRMaj.data[i5] = 0.0f;
            }
        }
        return cMatrixRMaj;
    }
}
