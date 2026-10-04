package org.ejml.dense.row.linsol.p051lu;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionBase_FDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LinearSolverLuBase_FDRM extends LinearSolverAbstract_FDRM {
    protected LUDecompositionBase_FDRM decomp;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverLuBase_FDRM(LUDecompositionBase_FDRM lUDecompositionBase_FDRM) {
        this.decomp = lUDecompositionBase_FDRM;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        _setA(fMatrixRMaj);
        return this.decomp.decompose(fMatrixRMaj);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return this.decomp.quality();
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRMaj fMatrixRMaj) {
        float[] fArr_getVV = this.decomp._getVV();
        FMatrixRMaj lu = this.decomp.getLU();
        if (fMatrixRMaj.numCols != lu.numCols || fMatrixRMaj.numRows != lu.numRows) {
            throw new IllegalArgumentException("Unexpected matrix dimension");
        }
        int i = this.f2663A.numCols;
        float[] fArr = fMatrixRMaj.data;
        int i2 = 0;
        while (i2 < i) {
            int i3 = 0;
            while (i3 < i) {
                fArr_getVV[i3] = i3 == i2 ? 1.0f : 0.0f;
                i3++;
            }
            this.decomp._solveVectorInternal(fArr_getVV);
            int i4 = 0;
            int i5 = i2;
            while (i4 < i) {
                fArr[i5] = fArr_getVV[i4];
                i4++;
                i5 += i;
            }
            i2++;
        }
    }

    public void improveSol(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numCols != fMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("bad shapes");
        }
        float[] fArr = this.f2663A.data;
        float[] fArr2 = fMatrixRMaj.data;
        float[] fArr3 = fMatrixRMaj2.data;
        int i = fMatrixRMaj.numCols;
        int i2 = fMatrixRMaj.numCols;
        float[] fArr_getVV = this.decomp._getVV();
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                float f = -fArr2[(i4 * i) + i3];
                for (int i5 = 0; i5 < i2; i5++) {
                    f += fArr[(i4 * i2) + i5] * fArr3[(i5 * i) + i3];
                }
                fArr_getVV[i4] = f;
            }
            this.decomp._solveVectorInternal(fArr_getVV);
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = (i6 * i) + i3;
                fArr3[i7] = fArr3[i7] - fArr_getVV[i6];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public LUDecompositionBase_FDRM getDecomposition() {
        return this.decomp;
    }
}
