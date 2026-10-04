package org.ejml.dense.row.linsol.chol;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.dense.block.linsol.chol.CholeskyOuterSolver_FDRB;
import org.ejml.dense.row.linsol.LinearSolver_FDRB_to_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverChol_FDRB extends LinearSolver_FDRB_to_FDRM {
    public LinearSolverChol_FDRB() {
        super(new CholeskyOuterSolver_FDRB());
    }

    @Override // org.ejml.dense.row.linsol.LinearSolver_FDRB_to_FDRM, org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        this.blockB.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false);
        MatrixOps_FDRB.convert(fMatrixRMaj, this.blockB);
        this.alg.solve(this.blockB, null);
        MatrixOps_FDRB.convert(this.blockB, fMatrixRMaj2);
    }
}
