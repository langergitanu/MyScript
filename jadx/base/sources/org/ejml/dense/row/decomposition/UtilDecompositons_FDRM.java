package org.ejml.dense.row.decomposition;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class UtilDecompositons_FDRM {
    public static FMatrixRMaj checkIdentity(FMatrixRMaj fMatrixRMaj, int i, int i2) {
        if (fMatrixRMaj == null) {
            return CommonOps_FDRM.identity(i, i2);
        }
        if (i != fMatrixRMaj.numRows || i2 != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        CommonOps_FDRM.setIdentity(fMatrixRMaj);
        return fMatrixRMaj;
    }

    public static FMatrixRMaj checkZeros(FMatrixRMaj fMatrixRMaj, int i, int i2) {
        if (fMatrixRMaj == null) {
            return new FMatrixRMaj(i, i2);
        }
        if (i != fMatrixRMaj.numRows || i2 != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        fMatrixRMaj.zero();
        return fMatrixRMaj;
    }

    public static FMatrixRMaj checkZerosLT(FMatrixRMaj fMatrixRMaj, int i, int i2) {
        if (fMatrixRMaj == null) {
            return new FMatrixRMaj(i, i2);
        }
        if (i != fMatrixRMaj.numRows || i2 != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        for (int i3 = 0; i3 < fMatrixRMaj.numRows; i3++) {
            int i4 = fMatrixRMaj.numCols * i3;
            int iMin = Math.min(i3, fMatrixRMaj.numCols) + i4;
            while (i4 < iMin) {
                fMatrixRMaj.data[i4] = 0.0f;
                i4++;
            }
        }
        return fMatrixRMaj;
    }

    public static FMatrixRMaj checkZerosUT(FMatrixRMaj fMatrixRMaj, int i, int i2) {
        if (fMatrixRMaj == null) {
            return new FMatrixRMaj(i, i2);
        }
        if (i != fMatrixRMaj.numRows || i2 != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Input is not " + i + " x " + i2 + " matrix");
        }
        int iMin = Math.min(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        for (int i3 = 0; i3 < iMin; i3++) {
            int i4 = (fMatrixRMaj.numCols * i3) + fMatrixRMaj.numCols;
            for (int i5 = (fMatrixRMaj.numCols * i3) + i3 + 1; i5 < i4; i5++) {
                fMatrixRMaj.data[i5] = 0.0f;
            }
        }
        return fMatrixRMaj;
    }
}
