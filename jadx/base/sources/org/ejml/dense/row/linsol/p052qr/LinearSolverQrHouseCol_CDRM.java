package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.CMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_CDRM;
import org.ejml.dense.row.decompose.TriangularSolver_CDRM;
import org.ejml.dense.row.decompose.p048qr.QRDecompositionHouseholderColumn_CDRM;
import org.ejml.dense.row.decompose.p048qr.QrHelperFunctions_CDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_CDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouseCol_CDRM extends LinearSolverAbstract_CDRM {

    /* JADX INFO: renamed from: QR */
    private float[][] f2697QR;
    private float[] gammas;

    /* JADX INFO: renamed from: a */
    private CMatrixRMaj f2699a = new CMatrixRMaj(1, 1);
    private CMatrixRMaj temp = new CMatrixRMaj(1, 1);
    protected int maxRows = -1;
    protected int maxCols = -1;

    /* JADX INFO: renamed from: R */
    private CMatrixRMaj f2698R = new CMatrixRMaj(1, 1);
    private QRDecompositionHouseholderColumn_CDRM decomposer = new QRDecompositionHouseholderColumn_CDRM();

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
    public boolean setA(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows < cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Can't solve for wide systems.  More variables than equations.");
        }
        if (cMatrixRMaj.numRows > this.maxRows || cMatrixRMaj.numCols > this.maxCols) {
            setMaxSize(cMatrixRMaj.numRows, cMatrixRMaj.numCols);
        }
        this.f2698R.reshape(cMatrixRMaj.numCols, cMatrixRMaj.numCols);
        this.f2699a.reshape(cMatrixRMaj.numRows, 1);
        this.temp.reshape(cMatrixRMaj.numRows, 1);
        _setA(cMatrixRMaj);
        if (!this.decomposer.decompose(cMatrixRMaj)) {
            return false;
        }
        this.gammas = this.decomposer.getGammas();
        this.f2697QR = this.decomposer.getQR();
        this.decomposer.getR(this.f2698R, true);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_CDRM.qualityTriangular(this.f2698R);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(CMatrixRMaj cMatrixRMaj, CMatrixRMaj cMatrixRMaj2) {
        if (cMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X: X rows = " + cMatrixRMaj2.numRows + " expected = " + this.numCols);
        }
        if (cMatrixRMaj.numRows != this.numRows || cMatrixRMaj.numCols != cMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = cMatrixRMaj.numCols;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                int i4 = ((i3 * i) + i2) * 2;
                int i5 = i3 * 2;
                this.f2699a.data[i5] = cMatrixRMaj.data[i4];
                this.f2699a.data[i5 + 1] = cMatrixRMaj.data[i4 + 1];
            }
            for (int i6 = 0; i6 < this.numCols; i6++) {
                float[] fArr = this.f2697QR[i6];
                int i7 = i6 * 2;
                float f = fArr[i7];
                int i8 = i7 + 1;
                float f2 = fArr[i8];
                fArr[i7] = 1.0f;
                fArr[i8] = 0.0f;
                QrHelperFunctions_CDRM.rank1UpdateMultR(this.f2699a, fArr, 0, this.gammas[i6], 0, i6, this.numRows, this.temp.data);
                fArr[i7] = f;
                fArr[i8] = f2;
            }
            TriangularSolver_CDRM.solveU(this.f2698R.data, this.f2699a.data, this.numCols);
            for (int i9 = 0; i9 < this.numCols; i9++) {
                int i10 = ((i9 * i) + i2) * 2;
                int i11 = i9 * 2;
                cMatrixRMaj2.data[i10] = this.f2699a.data[i11];
                cMatrixRMaj2.data[i10 + 1] = this.f2699a.data[i11 + 1];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecompositionHouseholderColumn_CDRM getDecomposition() {
        return this.decomposer;
    }
}
