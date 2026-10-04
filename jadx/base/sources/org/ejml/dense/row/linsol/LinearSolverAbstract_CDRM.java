package org.ejml.dense.row.linsol;

import org.ejml.data.CMatrixRMaj;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LinearSolverAbstract_CDRM implements LinearSolverDense<CMatrixRMaj> {

    /* JADX INFO: renamed from: A */
    protected CMatrixRMaj f2661A;
    protected int numCols;
    protected int numRows;
    protected int stride;

    public CMatrixRMaj getA() {
        return this.f2661A;
    }

    protected void _setA(CMatrixRMaj cMatrixRMaj) {
        this.f2661A = cMatrixRMaj;
        this.numRows = cMatrixRMaj.numRows;
        int i = cMatrixRMaj.numCols;
        this.numCols = i;
        this.stride = i * 2;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(CMatrixRMaj cMatrixRMaj) {
        InvertUsingSolve_CDRM.invert(this, this.f2661A, cMatrixRMaj);
    }
}
