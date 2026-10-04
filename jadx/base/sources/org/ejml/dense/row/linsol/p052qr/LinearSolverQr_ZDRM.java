package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.CommonOps_ZDRM;
import org.ejml.dense.row.SpecializedOps_ZDRM;
import org.ejml.dense.row.decompose.TriangularSolver_ZDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_ZDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQr_ZDRM extends LinearSolverAbstract_ZDRM {

    /* JADX INFO: renamed from: Q */
    protected ZMatrixRMaj f2746Q;

    /* JADX INFO: renamed from: Qt */
    protected ZMatrixRMaj f2747Qt;

    /* JADX INFO: renamed from: R */
    protected ZMatrixRMaj f2748R;

    /* JADX INFO: renamed from: Y */
    private ZMatrixRMaj f2749Y;

    /* JADX INFO: renamed from: Z */
    private ZMatrixRMaj f2750Z;
    private QRDecomposition<ZMatrixRMaj> decomposer;
    protected int maxRows = -1;
    protected int maxCols = -1;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverQr_ZDRM(QRDecomposition<ZMatrixRMaj> qRDecomposition) {
        this.decomposer = qRDecomposition;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.f2746Q = new ZMatrixRMaj(i, i);
        this.f2747Qt = new ZMatrixRMaj(i, i);
        this.f2748R = new ZMatrixRMaj(i, i2);
        this.f2749Y = new ZMatrixRMaj(i, 1);
        this.f2750Z = new ZMatrixRMaj(i, 1);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows > this.maxRows || zMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        }
        _setA(zMatrixRMaj);
        if (!this.decomposer.decompose(zMatrixRMaj)) {
            return false;
        }
        this.f2746Q.reshape(this.numRows, this.numRows);
        this.f2748R.reshape(this.numRows, this.numCols);
        this.decomposer.getQ(this.f2746Q, false);
        this.decomposer.getR(this.f2748R, false);
        CommonOps_ZDRM.transposeConjugate(this.f2746Q, this.f2747Qt);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_ZDRM.qualityTriangular(this.f2748R);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        if (zMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X");
        }
        if (zMatrixRMaj.numRows != this.numRows || zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = zMatrixRMaj.numCols;
        this.f2749Y.reshape(this.numRows, 1);
        this.f2750Z.reshape(this.numRows, 1);
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int index = zMatrixRMaj.getIndex(i3, i2);
                int i4 = i3 * 2;
                this.f2749Y.data[i4] = zMatrixRMaj.data[index];
                this.f2749Y.data[i4 + 1] = zMatrixRMaj.data[index + 1];
            }
            CommonOps_ZDRM.mult(this.f2747Qt, this.f2749Y, this.f2750Z);
            TriangularSolver_ZDRM.solveU(this.f2748R.data, this.f2750Z.data, this.numCols);
            for (int i5 = 0; i5 < this.numCols; i5++) {
                int i6 = i5 * 2;
                zMatrixRMaj2.set(i5, i2, this.f2750Z.data[i6], this.f2750Z.data[i6 + 1]);
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<ZMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }

    public QRDecomposition<ZMatrixRMaj> getDecomposer() {
        return this.decomposer;
    }

    public ZMatrixRMaj getQ() {
        return this.f2746Q;
    }

    public ZMatrixRMaj getR() {
        return this.f2748R;
    }
}
