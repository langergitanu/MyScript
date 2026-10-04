package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholder_FDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouse_FDRM extends LinearSolverAbstract_FDRM {

    /* JADX INFO: renamed from: QR */
    private FMatrixRMaj f2727QR;

    /* JADX INFO: renamed from: a */
    private float[] f2728a;
    private float[] gammas;

    /* JADX INFO: renamed from: u */
    private float[] f2729u;
    private int maxRows = -1;
    private QRDecompositionHouseholder_FDRM decomposer = new QRDecompositionHouseholder_FDRM();

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public void setMaxSize(int i) {
        this.maxRows = i;
        this.f2728a = new float[i];
        this.f2729u = new float[i];
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows > this.maxRows) {
            setMaxSize(fMatrixRMaj.numRows);
        }
        _setA(fMatrixRMaj);
        if (!this.decomposer.decompose(fMatrixRMaj)) {
            return false;
        }
        this.gammas = this.decomposer.getGammas();
        this.f2727QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.f2727QR);
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
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2728a[i3] = fMatrixRMaj.data[(i3 * i) + i2];
            }
            int i4 = 0;
            while (i4 < this.numCols) {
                this.f2729u[i4] = 1.0f;
                float f = this.f2728a[i4];
                int i5 = i4 + 1;
                for (int i6 = i5; i6 < this.numRows; i6++) {
                    float[] fArr = this.f2729u;
                    float fUnsafe_get = this.f2727QR.unsafe_get(i6, i4);
                    fArr[i6] = fUnsafe_get;
                    f += fUnsafe_get * this.f2728a[i6];
                }
                float f2 = f * this.gammas[i4];
                while (i4 < this.numRows) {
                    float[] fArr2 = this.f2728a;
                    fArr2[i4] = fArr2[i4] - (this.f2729u[i4] * f2);
                    i4++;
                }
                i4 = i5;
            }
            TriangularSolver_FDRM.solveU(this.f2727QR.data, this.f2728a, this.numCols);
            for (int i7 = 0; i7 < this.numCols; i7++) {
                fMatrixRMaj2.data[(fMatrixRMaj2.numCols * i7) + i2] = this.f2728a[i7];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<FMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
