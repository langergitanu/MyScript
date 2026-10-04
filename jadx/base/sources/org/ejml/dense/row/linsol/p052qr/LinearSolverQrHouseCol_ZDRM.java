package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_ZDRM;
import org.ejml.dense.row.decompose.TriangularSolver_ZDRM;
import org.ejml.dense.row.decompose.p048qr.QRDecompositionHouseholderColumn_ZDRM;
import org.ejml.dense.row.decompose.p048qr.QrHelperFunctions_ZDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_ZDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouseCol_ZDRM extends LinearSolverAbstract_ZDRM {

    /* JADX INFO: renamed from: QR */
    private double[][] f2706QR;
    private double[] gammas;

    /* JADX INFO: renamed from: a */
    private ZMatrixRMaj f2708a = new ZMatrixRMaj(1, 1);
    private ZMatrixRMaj temp = new ZMatrixRMaj(1, 1);
    protected int maxRows = -1;
    protected int maxCols = -1;

    /* JADX INFO: renamed from: R */
    private ZMatrixRMaj f2707R = new ZMatrixRMaj(1, 1);
    private QRDecompositionHouseholderColumn_ZDRM decomposer = new QRDecompositionHouseholderColumn_ZDRM();

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
    public boolean setA(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows < zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Can't solve for wide systems.  More variables than equations.");
        }
        if (zMatrixRMaj.numRows > this.maxRows || zMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(zMatrixRMaj.numRows, zMatrixRMaj.numCols);
        }
        this.f2707R.reshape(zMatrixRMaj.numCols, zMatrixRMaj.numCols);
        this.f2708a.reshape(zMatrixRMaj.numRows, 1);
        this.temp.reshape(zMatrixRMaj.numRows, 1);
        _setA(zMatrixRMaj);
        if (!this.decomposer.decompose(zMatrixRMaj)) {
            return false;
        }
        this.gammas = this.decomposer.getGammas();
        this.f2706QR = this.decomposer.getQR();
        this.decomposer.getR(this.f2707R, true);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_ZDRM.qualityTriangular(this.f2707R);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(ZMatrixRMaj zMatrixRMaj, ZMatrixRMaj zMatrixRMaj2) {
        if (zMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X: X rows = " + zMatrixRMaj2.numRows + " expected = " + this.numCols);
        }
        if (zMatrixRMaj.numRows != this.numRows || zMatrixRMaj.numCols != zMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = zMatrixRMaj.numCols;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = ((i3 * i) + i2) * 2;
                int i5 = i3 * 2;
                this.f2708a.data[i5] = zMatrixRMaj.data[i4];
                this.f2708a.data[i5 + 1] = zMatrixRMaj.data[i4 + 1];
            }
            for (int i6 = 0; i6 < this.numCols; i6++) {
                double[] dArr = this.f2706QR[i6];
                int i7 = i6 * 2;
                double d = dArr[i7];
                int i8 = i7 + 1;
                double d2 = dArr[i8];
                dArr[i7] = 1.0d;
                dArr[i8] = 0.0d;
                QrHelperFunctions_ZDRM.rank1UpdateMultR(this.f2708a, dArr, 0, this.gammas[i6], 0, i6, this.numRows, this.temp.data);
                dArr[i7] = d;
                dArr[i8] = d2;
            }
            TriangularSolver_ZDRM.solveU(this.f2707R.data, this.f2708a.data, this.numCols);
            for (int i9 = 0; i9 < this.numCols; i9++) {
                int i10 = ((i9 * i) + i2) * 2;
                int i11 = i9 * 2;
                zMatrixRMaj2.data[i10] = this.f2708a.data[i11];
                zMatrixRMaj2.data[i10 + 1] = this.f2708a.data[i11 + 1];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecompositionHouseholderColumn_ZDRM getDecomposition() {
        return this.decomposer;
    }
}
