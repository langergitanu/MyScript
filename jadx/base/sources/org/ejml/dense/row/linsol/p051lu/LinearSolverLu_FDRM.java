package org.ejml.dense.row.linsol.p051lu;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionBase_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverLu_FDRM extends LinearSolverLuBase_FDRM {
    boolean doImprove;

    public LinearSolverLu_FDRM(LUDecompositionBase_FDRM lUDecompositionBase_FDRM) {
        super(lUDecompositionBase_FDRM);
        this.doImprove = false;
    }

    public LinearSolverLu_FDRM(LUDecompositionBase_FDRM lUDecompositionBase_FDRM, boolean z) {
        super(lUDecompositionBase_FDRM);
        this.doImprove = z;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numCols != fMatrixRMaj2.numCols || fMatrixRMaj.numRows != this.numRows || fMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        int i = fMatrixRMaj.numCols;
        float[] fArr = fMatrixRMaj.data;
        float[] fArr2 = fMatrixRMaj2.data;
        float[] fArr_getVV = this.decomp._getVV();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = 0;
            int i4 = i2;
            while (i3 < this.numCols) {
                fArr_getVV[i3] = fArr[i4];
                i3++;
                i4 += i;
            }
            this.decomp._solveVectorInternal(fArr_getVV);
            int i5 = 0;
            int i6 = i2;
            while (i5 < this.numCols) {
                fArr2[i6] = fArr_getVV[i5];
                i5++;
                i6 += i;
            }
        }
        if (this.doImprove) {
            improveSol(fMatrixRMaj, fMatrixRMaj2);
        }
    }
}
