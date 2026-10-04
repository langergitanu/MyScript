package org.ejml.dense.row.linsol.chol;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.dense.block.linsol.chol.CholeskyOuterSolver_DDRB;
import org.ejml.dense.row.linsol.LinearSolver_DDRB_to_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverChol_DDRB extends LinearSolver_DDRB_to_DDRM {
    public LinearSolverChol_DDRB() {
        super(new CholeskyOuterSolver_DDRB());
    }

    @Override // org.ejml.dense.row.linsol.LinearSolver_DDRB_to_DDRM, org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        this.blockB.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false);
        MatrixOps_DDRB.convert(dMatrixRMaj, this.blockB);
        this.alg.solve(this.blockB, null);
        MatrixOps_DDRB.convert(this.blockB, dMatrixRMaj2);
    }
}
