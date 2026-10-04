package org.ejml.dense.row.linsol;

import org.ejml.data.FMatrixRMaj;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LinearSolverAbstract_FDRM implements LinearSolverDense<FMatrixRMaj> {

    /* JADX INFO: renamed from: A */
    protected FMatrixRMaj f2663A;
    protected int numCols;
    protected int numRows;

    public FMatrixRMaj getA() {
        return this.f2663A;
    }

    protected void _setA(FMatrixRMaj fMatrixRMaj) {
        this.f2663A = fMatrixRMaj;
        this.numRows = fMatrixRMaj.numRows;
        this.numCols = fMatrixRMaj.numCols;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRMaj fMatrixRMaj) {
        InvertUsingSolve_FDRM.invert(this, this.f2663A, fMatrixRMaj);
    }
}
