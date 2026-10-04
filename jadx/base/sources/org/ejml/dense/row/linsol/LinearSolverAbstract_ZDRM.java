package org.ejml.dense.row.linsol;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LinearSolverAbstract_ZDRM implements LinearSolverDense<ZMatrixRMaj> {

    /* JADX INFO: renamed from: A */
    protected ZMatrixRMaj f2664A;
    protected int numCols;
    protected int numRows;
    protected int stride;

    public ZMatrixRMaj getA() {
        return this.f2664A;
    }

    protected void _setA(ZMatrixRMaj zMatrixRMaj) {
        this.f2664A = zMatrixRMaj;
        this.numRows = zMatrixRMaj.numRows;
        int i = zMatrixRMaj.numCols;
        this.numCols = i;
        this.stride = i * 2;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(ZMatrixRMaj zMatrixRMaj) {
        InvertUsingSolve_ZDRM.invert(this, this.f2664A, zMatrixRMaj);
    }
}
