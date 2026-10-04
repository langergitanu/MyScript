package org.ejml.dense.row.linsol.p051lu;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionBase_ZDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverLu_ZDRM extends LinearSolverLuBase_ZDRM {
    public LinearSolverLu_ZDRM(LUDecompositionBase_ZDRM lUDecompositionBase_ZDRM) {
        super(lUDecompositionBase_ZDRM);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        if (zMatrixRMaj.numCols != zMatrixRMaj2.numCols || zMatrixRMaj.numRows != this.numRows || zMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = zMatrixRMaj.numCols;
        int rowStride = zMatrixRMaj.getRowStride();
        double[] dArr = zMatrixRMaj.data;
        double[] dArr2 = zMatrixRMaj2.data;
        double[] dArr_getVV = this.decomp._getVV();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            int i4 = 0;
            int i5 = i3;
            while (i4 < this.numRows) {
                int i6 = i4 * 2;
                dArr_getVV[i6] = dArr[i5];
                dArr_getVV[i6 + 1] = dArr[i5 + 1];
                i4++;
                i5 += rowStride;
            }
            this.decomp._solveVectorInternal(dArr_getVV);
            int i7 = 0;
            while (i7 < this.numRows) {
                int i8 = i7 * 2;
                dArr2[i3] = dArr_getVV[i8];
                dArr2[i3 + 1] = dArr_getVV[i8 + 1];
                i7++;
                i3 += rowStride;
            }
        }
    }
}
