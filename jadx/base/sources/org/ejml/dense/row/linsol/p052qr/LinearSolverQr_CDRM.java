package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.CommonOps_CDRM;
import org.ejml.dense.row.SpecializedOps_CDRM;
import org.ejml.dense.row.decompose.TriangularSolver_CDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_CDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQr_CDRM extends LinearSolverAbstract_CDRM {

    /* JADX INFO: renamed from: Q */
    protected CMatrixRMaj f2733Q;

    /* JADX INFO: renamed from: Qt */
    protected CMatrixRMaj f2734Qt;

    /* JADX INFO: renamed from: R */
    protected CMatrixRMaj f2735R;

    /* JADX INFO: renamed from: Y */
    private CMatrixRMaj f2736Y;

    /* JADX INFO: renamed from: Z */
    private CMatrixRMaj f2737Z;
    private QRDecomposition<CMatrixRMaj> decomposer;
    protected int maxRows = -1;
    protected int maxCols = -1;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverQr_CDRM(QRDecomposition<CMatrixRMaj> qRDecomposition) {
        this.decomposer = qRDecomposition;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.f2733Q = new CMatrixRMaj(i, i);
        this.f2734Qt = new CMatrixRMaj(i, i);
        this.f2735R = new CMatrixRMaj(i, i2);
        this.f2736Y = new CMatrixRMaj(i, 1);
        this.f2737Z = new CMatrixRMaj(i, 1);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows > this.maxRows || cMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        }
        _setA(cMatrixRMaj);
        if (!this.decomposer.decompose(cMatrixRMaj)) {
            return false;
        }
        this.f2733Q.reshape(this.numRows, this.numRows);
        this.f2735R.reshape(this.numRows, this.numCols);
        this.decomposer.getQ(this.f2733Q, false);
        this.decomposer.getR(this.f2735R, false);
        CommonOps_CDRM.transposeConjugate(this.f2733Q, this.f2734Qt);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_CDRM.qualityTriangular(this.f2735R);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        if (cMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X");
        }
        if (cMatrixRMaj.numRows != this.numRows || cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = cMatrixRMaj.numCols;
        this.f2736Y.reshape(this.numRows, 1);
        this.f2737Z.reshape(this.numRows, 1);
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int index = cMatrixRMaj.getIndex(i3, i2);
                int i4 = i3 * 2;
                this.f2736Y.data[i4] = cMatrixRMaj.data[index];
                this.f2736Y.data[i4 + 1] = cMatrixRMaj.data[index + 1];
            }
            CommonOps_CDRM.mult(this.f2734Qt, this.f2736Y, this.f2737Z);
            TriangularSolver_CDRM.solveU(this.f2735R.data, this.f2737Z.data, this.numCols);
            for (int i5 = 0; i5 < this.numCols; i5++) {
                int i6 = i5 * 2;
                cMatrixRMaj2.set(i5, i2, this.f2737Z.data[i6], this.f2737Z.data[i6 + 1]);
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<CMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }

    public QRDecomposition<CMatrixRMaj> getDecomposer() {
        return this.decomposer;
    }

    public CMatrixRMaj getQ() {
        return this.f2733Q;
    }

    public CMatrixRMaj getR() {
        return this.f2735R;
    }
}
