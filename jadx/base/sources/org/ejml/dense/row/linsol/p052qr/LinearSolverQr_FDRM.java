package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQr_FDRM extends LinearSolverAbstract_FDRM {

    /* JADX INFO: renamed from: Q */
    protected FMatrixRMaj f2742Q;

    /* JADX INFO: renamed from: R */
    protected FMatrixRMaj f2743R;

    /* JADX INFO: renamed from: Y */
    private FMatrixRMaj f2744Y;

    /* JADX INFO: renamed from: Z */
    private FMatrixRMaj f2745Z;
    private QRDecomposition<FMatrixRMaj> decomposer;
    protected int maxRows = -1;
    protected int maxCols = -1;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverQr_FDRM(QRDecomposition<FMatrixRMaj> qRDecomposition) {
        this.decomposer = qRDecomposition;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.f2742Q = new FMatrixRMaj(i, i);
        this.f2743R = new FMatrixRMaj(i, i2);
        this.f2744Y = new FMatrixRMaj(i, 1);
        this.f2745Z = new FMatrixRMaj(i, 1);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows > this.maxRows || fMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        _setA(fMatrixRMaj);
        if (!this.decomposer.decompose(fMatrixRMaj)) {
            return false;
        }
        this.f2742Q.reshape(this.numRows, this.numRows, false);
        this.f2743R.reshape(this.numRows, this.numCols, false);
        this.decomposer.getQ(this.f2742Q, false);
        this.decomposer.getR(this.f2743R, false);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.f2743R);
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
        this.f2744Y.reshape(this.numRows, 1, false);
        this.f2745Z.reshape(this.numRows, 1, false);
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2744Y.data[i3] = fMatrixRMaj.get(i3, i2);
            }
            CommonOps_FDRM.multTransA(this.f2742Q, this.f2744Y, this.f2745Z);
            TriangularSolver_FDRM.solveU(this.f2743R.data, this.f2745Z.data, this.numCols);
            for (int i4 = 0; i4 < this.numCols; i4++) {
                fMatrixRMaj2.set(i4, i2, this.f2745Z.data[i4]);
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<FMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }

    public QRDecomposition<FMatrixRMaj> getDecomposer() {
        return this.decomposer;
    }

    public FMatrixRMaj getQ() {
        return this.f2742Q;
    }

    public FMatrixRMaj getR() {
        return this.f2743R;
    }
}
