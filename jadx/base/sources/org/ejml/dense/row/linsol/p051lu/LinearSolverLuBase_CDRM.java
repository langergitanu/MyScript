package org.ejml.dense.row.linsol.p051lu;

import java.util.Arrays;
import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionBase_CDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_CDRM;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LinearSolverLuBase_CDRM extends LinearSolverAbstract_CDRM {
    protected LUDecompositionBase_CDRM decomp;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverLuBase_CDRM(LUDecompositionBase_CDRM lUDecompositionBase_CDRM) {
        this.decomp = lUDecompositionBase_CDRM;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(CMatrixRMaj cMatrixRMaj) {
        _setA(cMatrixRMaj);
        return this.decomp.decompose(cMatrixRMaj);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return this.decomp.quality();
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_CDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(CMatrixRMaj cMatrixRMaj) {
        float[] fArr_getVV = this.decomp._getVV();
        CMatrixRMaj lu = this.decomp.getLU();
        if (cMatrixRMaj.numCols != lu.numCols || cMatrixRMaj.numRows != lu.numRows) {
            throw new IllegalArgumentException("Unexpected matrix dimension");
        }
        int i = this.f2661A.numCols;
        float[] fArr = cMatrixRMaj.data;
        int rowStride = cMatrixRMaj.getRowStride();
        for (int i2 = 0; i2 < i; i2++) {
            Arrays.fill(fArr_getVV, 0, i * 2, 0.0f);
            int i3 = i2 * 2;
            fArr_getVV[i3] = 1.0f;
            fArr_getVV[i3 + 1] = 0.0f;
            this.decomp._solveVectorInternal(fArr_getVV);
            int i4 = 0;
            while (i4 < i) {
                int i5 = i4 * 2;
                fArr[i3] = fArr_getVV[i5];
                fArr[i3 + 1] = fArr_getVV[i5 + 1];
                i4++;
                i3 += rowStride;
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public LUDecompositionBase_CDRM getDecomposition() {
        return this.decomp;
    }
}
