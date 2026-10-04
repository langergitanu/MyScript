package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.interfaces.decomposition.QRPDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class SolvePseudoInverseQrp_FDRM extends BaseLinearSolverQrp_FDRM {

    /* JADX INFO: renamed from: Q */
    private FMatrixRMaj f2752Q;
    private FMatrixRMaj x_basic;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public SolvePseudoInverseQrp_FDRM(QRPDecomposition_F32<FMatrixRMaj> qRPDecomposition_F32, boolean z) {
        super(qRPDecomposition_F32, z);
        this.f2752Q = new FMatrixRMaj(1, 1);
        this.x_basic = new FMatrixRMaj(1, 1);
    }

    @Override // org.ejml.dense.row.linsol.p052qr.BaseLinearSolverQrp_FDRM, org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        if (!super.setA(fMatrixRMaj)) {
            return false;
        }
        this.f2752Q.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numRows);
        this.decomposition.getQ(this.f2752Q, false);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X");
        }
        if (fMatrixRMaj.numRows != this.numRows || fMatrixRMaj.numCols != fMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = fMatrixRMaj.numCols;
        int[] colPivots = this.decomposition.getColPivots();
        for (int i2 = 0; i2 < i; i2++) {
            this.x_basic.reshape(this.numRows, 1);
            this.f2696Y.reshape(this.numRows, 1);
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2696Y.data[i3] = fMatrixRMaj.get(i3, i2);
            }
            CommonOps_FDRM.multTransA(this.f2752Q, this.f2696Y, this.x_basic);
            TriangularSolver_FDRM.solveU(this.R11.data, this.x_basic.data, this.rank);
            this.x_basic.reshape(this.numCols, 1, true);
            for (int i4 = this.rank; i4 < this.numCols; i4++) {
                this.x_basic.data[i4] = 0.0f;
            }
            if (this.norm2Solution && this.rank < this.numCols) {
                upgradeSolution(this.x_basic);
            }
            for (int i5 = 0; i5 < this.numCols; i5++) {
                fMatrixRMaj2.set(colPivots[i5], i2, this.x_basic.data[i5]);
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposition.inputModified();
    }
}
