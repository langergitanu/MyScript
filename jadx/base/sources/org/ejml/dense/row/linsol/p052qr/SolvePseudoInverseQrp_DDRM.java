package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.interfaces.decomposition.QRPDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class SolvePseudoInverseQrp_DDRM extends BaseLinearSolverQrp_DDRM {

    /* JADX INFO: renamed from: Q */
    private DMatrixRMaj f2751Q;
    private DMatrixRMaj x_basic;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public SolvePseudoInverseQrp_DDRM(QRPDecomposition_F64<DMatrixRMaj> qRPDecomposition_F64, boolean z) {
        super(qRPDecomposition_F64, z);
        this.f2751Q = new DMatrixRMaj(1, 1);
        this.x_basic = new DMatrixRMaj(1, 1);
    }

    @Override // org.ejml.dense.row.linsol.p052qr.BaseLinearSolverQrp_DDRM, org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        if (!super.setA(dMatrixRMaj)) {
            return false;
        }
        this.f2751Q.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numRows);
        this.decomposition.getQ(this.f2751Q, false);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X");
        }
        if (dMatrixRMaj.numRows != this.numRows || dMatrixRMaj.numCols != dMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = dMatrixRMaj.numCols;
        int[] colPivots = this.decomposition.getColPivots();
        for (int i2 = 0; i2 < i; i2++) {
            this.x_basic.reshape(this.numRows, 1);
            this.f2692Y.reshape(this.numRows, 1);
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2692Y.data[i3] = dMatrixRMaj.get(i3, i2);
            }
            CommonOps_DDRM.multTransA(this.f2751Q, this.f2692Y, this.x_basic);
            TriangularSolver_DDRM.solveU(this.R11.data, this.x_basic.data, this.rank);
            this.x_basic.reshape(this.numCols, 1, true);
            for (int i4 = this.rank; i4 < this.numCols; i4++) {
                this.x_basic.data[i4] = 0.0d;
            }
            if (this.norm2Solution && this.rank < this.numCols) {
                upgradeSolution(this.x_basic);
            }
            for (int i5 = 0; i5 < this.numCols; i5++) {
                dMatrixRMaj2.set(colPivots[i5], i2, this.x_basic.data[i5]);
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposition.inputModified();
    }
}
