package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_FDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouseCol_FDRM extends LinearSolverAbstract_FDRM {

    /* JADX INFO: renamed from: QR */
    private float[][] f2703QR;
    private float[] gammas;

    /* JADX INFO: renamed from: a */
    private FMatrixRMaj f2705a = new FMatrixRMaj(1, 1);
    private FMatrixRMaj temp = new FMatrixRMaj(1, 1);
    protected int maxRows = -1;
    protected int maxCols = -1;

    /* JADX INFO: renamed from: R */
    private FMatrixRMaj f2704R = new FMatrixRMaj(1, 1);
    private QRDecompositionHouseholderColumn_FDRM decomposer = new QRDecompositionHouseholderColumn_FDRM();

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
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows < fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Can't solve for wide systems.  More variables than equations.");
        }
        if (fMatrixRMaj.numRows > this.maxRows || fMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        }
        this.f2704R.reshape(fMatrixRMaj.numCols, fMatrixRMaj.numCols);
        this.f2705a.reshape(fMatrixRMaj.numRows, 1);
        this.temp.reshape(fMatrixRMaj.numRows, 1);
        _setA(fMatrixRMaj);
        if (!this.decomposer.decompose(fMatrixRMaj)) {
            return false;
        }
        this.gammas = this.decomposer.getGammas();
        this.f2703QR = this.decomposer.getQR();
        this.decomposer.getR(this.f2704R, true);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.f2704R);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X: X rows = " + fMatrixRMaj2.numRows + " expected = " + this.numCols);
        }
        if (fMatrixRMaj.numRows != this.numRows || fMatrixRMaj.numCols != fMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = fMatrixRMaj.numCols;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2705a.data[i3] = fMatrixRMaj.data[(i3 * i) + i2];
            }
            for (int i4 = 0; i4 < this.numCols; i4++) {
                float[] fArr = this.f2703QR[i4];
                float f = fArr[i4];
                fArr[i4] = 1.0f;
                QrHelperFunctions_FDRM.rank1UpdateMultR(this.f2705a, fArr, this.gammas[i4], 0, i4, this.numRows, this.temp.data);
                fArr[i4] = f;
            }
            TriangularSolver_FDRM.solveU(this.f2704R.data, this.f2705a.data, this.numCols);
            for (int i5 = 0; i5 < this.numCols; i5++) {
                fMatrixRMaj2.data[(fMatrixRMaj2.numCols * i5) + i2] = this.f2705a.data[i5];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<FMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
