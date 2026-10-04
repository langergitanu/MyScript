package org.ejml.dense.row.linsol.p052qr;

import org.ejml.LinearSolverSafe;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_FDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM;
import org.ejml.interfaces.decomposition.QRPDecomposition_F32;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseLinearSolverQrp_FDRM extends LinearSolverAbstract_FDRM {
    QRPDecomposition_F32<FMatrixRMaj> decomposition;
    protected LinearSolverDense<FMatrixRMaj> internalSolver;
    protected boolean norm2Solution;
    protected int rank;

    /* JADX INFO: renamed from: Y */
    protected FMatrixRMaj f2696Y = new FMatrixRMaj(1, 1);

    /* JADX INFO: renamed from: R */
    protected FMatrixRMaj f2694R = new FMatrixRMaj(1, 1);
    protected FMatrixRMaj R11 = new FMatrixRMaj(1, 1);

    /* JADX INFO: renamed from: I */
    protected FMatrixRMaj f2693I = new FMatrixRMaj(1, 1);

    /* JADX INFO: renamed from: W */
    private FMatrixRMaj f2695W = new FMatrixRMaj(1, 1);

    protected BaseLinearSolverQrp_FDRM(QRPDecomposition_F32<FMatrixRMaj> qRPDecomposition_F32, boolean z) {
        this.internalSolver = LinearSolverFactory_FDRM.leastSquares(1, 1);
        this.decomposition = qRPDecomposition_F32;
        this.norm2Solution = z;
        if (this.internalSolver.modifiesA()) {
            this.internalSolver = new LinearSolverSafe(this.internalSolver);
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        _setA(fMatrixRMaj);
        if (!this.decomposition.decompose(fMatrixRMaj)) {
            return false;
        }
        this.rank = this.decomposition.getRank();
        this.f2694R.reshape(this.numRows, this.numCols);
        this.decomposition.getR(this.f2694R, false);
        FMatrixRMaj fMatrixRMaj2 = this.R11;
        int i = this.rank;
        fMatrixRMaj2.reshape(i, i);
        FMatrixRMaj fMatrixRMaj3 = this.f2694R;
        int i2 = this.rank;
        CommonOps_FDRM.extract(fMatrixRMaj3, 0, i2, 0, i2, this.R11, 0, 0);
        if (this.norm2Solution && this.rank < this.numCols) {
            this.f2695W.reshape(this.rank, this.numCols - this.rank);
            FMatrixRMaj fMatrixRMaj4 = this.f2694R;
            int i3 = this.rank;
            CommonOps_FDRM.extract(fMatrixRMaj4, 0, i3, i3, this.numCols, this.f2695W, 0, 0);
            TriangularSolver_FDRM.solveU(this.R11.data, 0, this.R11.numCols, this.R11.numCols, this.f2695W.data, 0, this.f2695W.numCols, this.f2695W.numCols);
            this.f2695W.reshape(this.numCols, this.f2695W.numCols, true);
            for (int i4 = 0; i4 < this.numCols - this.rank; i4++) {
                int i5 = 0;
                while (true) {
                    int i6 = this.numCols;
                    int i7 = this.rank;
                    if (i5 < i6 - i7) {
                        if (i4 == i5) {
                            this.f2695W.set(i7 + i4, i5, -1.0f);
                        } else {
                            this.f2695W.set(i7 + i4, i5, 0.0f);
                        }
                        i5++;
                    }
                }
            }
        }
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.f2694R);
    }

    protected void upgradeSolution(FMatrixRMaj fMatrixRMaj) {
        FMatrixRMaj fMatrixRMaj2 = this.f2696Y;
        if (!this.internalSolver.setA(this.f2695W)) {
            throw new RuntimeException("This should never happen.  Is input NaN?");
        }
        fMatrixRMaj2.reshape(this.numCols - this.rank, 1);
        this.internalSolver.solve(fMatrixRMaj, fMatrixRMaj2);
        CommonOps_FDRM.multAdd(-1.0f, this.f2695W, fMatrixRMaj2, fMatrixRMaj);
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numCols != this.numRows || fMatrixRMaj.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for A_inv");
        }
        this.f2693I.reshape(this.numRows, this.numRows);
        CommonOps_FDRM.setIdentity(this.f2693I);
        solve(this.f2693I, fMatrixRMaj);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRPDecomposition_F32<FMatrixRMaj> getDecomposition() {
        return this.decomposition;
    }
}
