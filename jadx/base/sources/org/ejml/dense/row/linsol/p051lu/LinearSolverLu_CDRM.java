package org.ejml.dense.row.linsol.p051lu;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionBase_CDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverLu_CDRM extends LinearSolverLuBase_CDRM {
    public LinearSolverLu_CDRM(LUDecompositionBase_CDRM lUDecompositionBase_CDRM) {
        super(lUDecompositionBase_CDRM);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        if (cMatrixRMaj.numCols != cMatrixRMaj2.numCols || cMatrixRMaj.numRows != this.numRows || cMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = cMatrixRMaj.numCols;
        int rowStride = cMatrixRMaj.getRowStride();
        float[] fArr = cMatrixRMaj.data;
        float[] fArr2 = cMatrixRMaj2.data;
        float[] fArr_getVV = this.decomp._getVV();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.numRows) {
                int i6 = i4 * 2;
                fArr_getVV[i6] = fArr[i5];
                fArr_getVV[i6 + 1] = fArr[i5 + 1];
                i4++;
                i5 += rowStride;
            }
            this.decomp._solveVectorInternal(fArr_getVV);
            int i7 = 0;
            while (i7 < this.numRows) {
                int i8 = i7 * 2;
                fArr2[i3] = fArr_getVV[i8];
                fArr2[i3 + 1] = fArr_getVV[i8 + 1];
                i7++;
                i3 += rowStride;
            }
        }
    }
}
