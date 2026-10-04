package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_DDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouseCol_DDRM extends LinearSolverAbstract_DDRM {

    /* JADX INFO: renamed from: QR */
    private double[][] f2700QR;
    private double[] gammas;

    /* JADX INFO: renamed from: a */
    private DMatrixRMaj f2702a = new DMatrixRMaj(1, 1);
    private DMatrixRMaj temp = new DMatrixRMaj(1, 1);
    protected int maxRows = -1;
    protected int maxCols = -1;

    /* JADX INFO: renamed from: R */
    private DMatrixRMaj f2701R = new DMatrixRMaj(1, 1);
    private QRDecompositionHouseholderColumn_DDRM decomposer = new QRDecompositionHouseholderColumn_DDRM();

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows < dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Can't solve for wide systems.  More variables than equations.");
        }
        if (dMatrixRMaj.numRows > this.maxRows || dMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        }
        this.f2701R.reshape(dMatrixRMaj.numCols, dMatrixRMaj.numCols);
        this.f2702a.reshape(dMatrixRMaj.numRows, 1);
        this.temp.reshape(dMatrixRMaj.numRows, 1);
        _setA(dMatrixRMaj);
        if (!this.decomposer.decompose(dMatrixRMaj)) {
            return false;
        }
        this.gammas = this.decomposer.getGammas();
        this.f2700QR = this.decomposer.getQR();
        this.decomposer.getR(this.f2701R, true);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_DDRM.qualityTriangular(this.f2701R);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X: X rows = " + dMatrixRMaj2.numRows + " expected = " + this.numCols);
        }
        if (dMatrixRMaj.numRows != this.numRows || dMatrixRMaj.numCols != dMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = dMatrixRMaj.numCols;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2702a.data[i3] = dMatrixRMaj.data[(i3 * i) + i2];
            }
            for (int i4 = 0; i4 < this.numCols; i4++) {
                double[] dArr = this.f2700QR[i4];
                double d = dArr[i4];
                dArr[i4] = 1.0d;
                QrHelperFunctions_DDRM.rank1UpdateMultR(this.f2702a, dArr, this.gammas[i4], 0, i4, this.numRows, this.temp.data);
                dArr[i4] = d;
            }
            TriangularSolver_DDRM.solveU(this.f2701R.data, this.f2702a.data, this.numCols);
            for (int i5 = 0; i5 < this.numCols; i5++) {
                dMatrixRMaj2.data[(dMatrixRMaj2.numCols * i5) + i2] = this.f2702a.data[i5];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<DMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
