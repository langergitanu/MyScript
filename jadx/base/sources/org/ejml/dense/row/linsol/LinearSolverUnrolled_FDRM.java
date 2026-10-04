package org.ejml.dense.row.linsol;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.misc.UnrolledInverseFromMinor_FDRM;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverUnrolled_FDRM implements LinearSolverDense<FMatrixRMaj> {

    /* JADX INFO: renamed from: A */
    FMatrixRMaj f2666A;

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
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            return false;
        }
        this.f2666A = fMatrixRMaj;
        return fMatrixRMaj.numRows <= 5;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        throw new IllegalArgumentException("Not supported by this solver.");
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        throw new RuntimeException("Not supported");
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRMaj fMatrixRMaj) {
        if (this.f2666A.numRows == 1) {
            fMatrixRMaj.set(0, 1.0f / this.f2666A.get(0));
        }
        UnrolledInverseFromMinor_FDRM.inv(this.f2666A, fMatrixRMaj);
    }
}
