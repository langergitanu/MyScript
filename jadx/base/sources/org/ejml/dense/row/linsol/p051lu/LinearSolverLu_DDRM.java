package org.ejml.dense.row.linsol.p051lu;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionBase_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverLu_DDRM extends LinearSolverLuBase_DDRM {
    boolean doImprove;

    public LinearSolverLu_DDRM(LUDecompositionBase_DDRM lUDecompositionBase_DDRM) {
        super(lUDecompositionBase_DDRM);
        this.doImprove = false;
    }

    public LinearSolverLu_DDRM(LUDecompositionBase_DDRM lUDecompositionBase_DDRM, boolean z) {
        super(lUDecompositionBase_DDRM);
        this.doImprove = z;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numCols != dMatrixRMaj2.numCols || dMatrixRMaj.numRows != this.numRows || dMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = dMatrixRMaj.numCols;
        double[] dArr = dMatrixRMaj.data;
        double[] dArr2 = dMatrixRMaj2.data;
        double[] dArr_getVV = this.decomp._getVV();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.numCols) {
                dArr_getVV[i3] = dArr[i4];
                i3++;
                i4 += i;
            }
            this.decomp._solveVectorInternal(dArr_getVV);
            int i5 = 0;
            int i6 = i2;
            while (i5 < this.numCols) {
                dArr2[i6] = dArr_getVV[i5];
                i5++;
                i6 += i;
            }
        }
        if (this.doImprove) {
            improveSol(dMatrixRMaj, dMatrixRMaj2);
        }
    }
}
