package org.ejml.dense.row.linsol;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.misc.UnrolledInverseFromMinor_DDRM;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverUnrolled_DDRM implements LinearSolverDense<DMatrixRMaj> {

    /* JADX INFO: renamed from: A */
    DMatrixRMaj f2665A;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public <D extends DecompositionInterface> D getDecomposition() {
        return null;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            return false;
        }
        this.f2665A = dMatrixRMaj;
        return dMatrixRMaj.numRows <= 5;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        throw new IllegalArgumentException("Not supported by this solver.");
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        throw new RuntimeException("Not supported");
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRMaj dMatrixRMaj) {
        if (this.f2665A.numRows == 1) {
            dMatrixRMaj.set(0, 1.0d / this.f2665A.get(0));
        }
        UnrolledInverseFromMinor_DDRM.inv(this.f2665A, dMatrixRMaj);
    }
}
