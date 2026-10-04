package org.ejml.dense.row.linsol;

import org.ejml.data.DMatrixRMaj;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LinearSolverAbstract_DDRM implements LinearSolverDense<DMatrixRMaj> {

    /* JADX INFO: renamed from: A */
    protected DMatrixRMaj f2662A;
    protected int numCols;
    protected int numRows;

    public DMatrixRMaj getA() {
        return this.f2662A;
    }

    protected void _setA(DMatrixRMaj dMatrixRMaj) {
        this.f2662A = dMatrixRMaj;
        this.numRows = dMatrixRMaj.numRows;
        this.numCols = dMatrixRMaj.numCols;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRMaj dMatrixRMaj) {
        InvertUsingSolve_DDRM.invert(this, this.f2662A, dMatrixRMaj);
    }
}
