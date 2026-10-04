package org.ejml.dense.row.linsol.p052qr;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.LinearSolverSafe;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_DDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM;
import org.ejml.interfaces.decomposition.QRPDecomposition_F64;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseLinearSolverQrp_DDRM extends LinearSolverAbstract_DDRM {
    QRPDecomposition_F64<DMatrixRMaj> decomposition;
    protected LinearSolverDense<DMatrixRMaj> internalSolver;
    protected boolean norm2Solution;
    protected int rank;

    /* JADX INFO: renamed from: Y */
    protected DMatrixRMaj f2692Y = new DMatrixRMaj(1, 1);

    /* JADX INFO: renamed from: R */
    protected DMatrixRMaj f2690R = new DMatrixRMaj(1, 1);
    protected DMatrixRMaj R11 = new DMatrixRMaj(1, 1);

    /* JADX INFO: renamed from: I */
    protected DMatrixRMaj f2689I = new DMatrixRMaj(1, 1);

    /* JADX INFO: renamed from: W */
    private DMatrixRMaj f2691W = new DMatrixRMaj(1, 1);

    protected BaseLinearSolverQrp_DDRM(QRPDecomposition_F64<DMatrixRMaj> qRPDecomposition_F64, boolean z) {
        this.internalSolver = LinearSolverFactory_DDRM.leastSquares(1, 1);
        this.decomposition = qRPDecomposition_F64;
        this.norm2Solution = z;
        if (this.internalSolver.modifiesA()) {
            this.internalSolver = new LinearSolverSafe(this.internalSolver);
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        _setA(dMatrixRMaj);
        if (!this.decomposition.decompose(dMatrixRMaj)) {
            return false;
        }
        this.rank = this.decomposition.getRank();
        this.f2690R.reshape(this.numRows, this.numCols);
        this.decomposition.getR(this.f2690R, false);
        DMatrixRMaj dMatrixRMaj2 = this.R11;
        int i = this.rank;
        dMatrixRMaj2.reshape(i, i);
        DMatrixRMaj dMatrixRMaj3 = this.f2690R;
        int i2 = this.rank;
        CommonOps_DDRM.extract(dMatrixRMaj3, 0, i2, 0, i2, this.R11, 0, 0);
        if (this.norm2Solution && this.rank < this.numCols) {
            this.f2691W.reshape(this.rank, this.numCols - this.rank);
            DMatrixRMaj dMatrixRMaj4 = this.f2690R;
            int i3 = this.rank;
            CommonOps_DDRM.extract(dMatrixRMaj4, 0, i3, i3, this.numCols, this.f2691W, 0, 0);
            TriangularSolver_DDRM.solveU(this.R11.data, 0, this.R11.numCols, this.R11.numCols, this.f2691W.data, 0, this.f2691W.numCols, this.f2691W.numCols);
            this.f2691W.reshape(this.numCols, this.f2691W.numCols, true);
            for (int i4 = 0; i4 < this.numCols - this.rank; i4++) {
                int i5 = 0;
                while (true) {
                    int i6 = this.numCols;
                    int i7 = this.rank;
                    if (i5 < i6 - i7) {
                        if (i4 == i5) {
                            this.f2691W.set(i7 + i4, i5, -1.0d);
                        } else {
                            this.f2691W.set(i7 + i4, i5, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
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
        return SpecializedOps_DDRM.qualityTriangular(this.f2690R);
    }

    protected void upgradeSolution(DMatrixRMaj dMatrixRMaj) {
        DMatrixRMaj dMatrixRMaj2 = this.f2692Y;
        if (!this.internalSolver.setA(this.f2691W)) {
            throw new RuntimeException("This should never happen.  Is input NaN?");
        }
        dMatrixRMaj2.reshape(this.numCols - this.rank, 1);
        this.internalSolver.solve(dMatrixRMaj, dMatrixRMaj2);
        CommonOps_DDRM.multAdd(-1.0d, this.f2691W, dMatrixRMaj2, dMatrixRMaj);
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numCols != this.numRows || dMatrixRMaj.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for A_inv");
        }
        this.f2689I.reshape(this.numRows, this.numRows);
        CommonOps_DDRM.setIdentity(this.f2689I);
        solve(this.f2689I, dMatrixRMaj);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRPDecomposition_F64<DMatrixRMaj> getDecomposition() {
        return this.decomposition;
    }
}
