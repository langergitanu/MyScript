package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQr_DDRM extends LinearSolverAbstract_DDRM {

    /* JADX INFO: renamed from: Q */
    protected DMatrixRMaj f2738Q;

    /* JADX INFO: renamed from: R */
    protected DMatrixRMaj f2739R;

    /* JADX INFO: renamed from: Y */
    private DMatrixRMaj f2740Y;

    /* JADX INFO: renamed from: Z */
    private DMatrixRMaj f2741Z;
    private QRDecomposition<DMatrixRMaj> decomposer;
    protected int maxRows = -1;
    protected int maxCols = -1;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverQr_DDRM(QRDecomposition<DMatrixRMaj> qRDecomposition) {
        this.decomposer = qRDecomposition;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.f2738Q = new DMatrixRMaj(i, i);
        this.f2739R = new DMatrixRMaj(i, i2);
        this.f2740Y = new DMatrixRMaj(i, 1);
        this.f2741Z = new DMatrixRMaj(i, 1);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows > this.maxRows || dMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        _setA(dMatrixRMaj);
        if (!this.decomposer.decompose(dMatrixRMaj)) {
            return false;
        }
        this.f2738Q.reshape(this.numRows, this.numRows, false);
        this.f2739R.reshape(this.numRows, this.numCols, false);
        this.decomposer.getQ(this.f2738Q, false);
        this.decomposer.getR(this.f2739R, false);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_DDRM.qualityTriangular(this.f2739R);
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
        this.f2740Y.reshape(this.numRows, 1, false);
        this.f2741Z.reshape(this.numRows, 1, false);
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2740Y.data[i3] = dMatrixRMaj.get(i3, i2);
            }
            CommonOps_DDRM.multTransA(this.f2738Q, this.f2740Y, this.f2741Z);
            TriangularSolver_DDRM.solveU(this.f2739R.data, this.f2741Z.data, this.numCols);
            for (int i4 = 0; i4 < this.numCols; i4++) {
                dMatrixRMaj2.set(i4, i2, this.f2741Z.data[i4]);
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<DMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }

    public QRDecomposition<DMatrixRMaj> getDecomposer() {
        return this.decomposer;
    }

    public DMatrixRMaj getQ() {
        return this.f2738Q;
    }

    public DMatrixRMaj getR() {
        return this.f2739R;
    }
}
