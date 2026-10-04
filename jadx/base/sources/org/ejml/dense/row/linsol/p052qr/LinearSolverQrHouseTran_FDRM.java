package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderTran_FDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouseTran_FDRM extends LinearSolverAbstract_FDRM {

    /* JADX INFO: renamed from: QR */
    private FMatrixRMaj f2715QR;

    /* JADX INFO: renamed from: U */
    private FMatrixRMaj f2716U;

    /* JADX INFO: renamed from: a */
    private float[] f2717a;
    protected int maxRows = -1;
    protected int maxCols = -1;
    private QRDecompositionHouseholderTran_FDRM decomposer = new QRDecompositionHouseholderTran_FDRM();

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.f2717a = new float[i];
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
        this.f2715QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.f2715QR);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X: X rows = " + fMatrixRMaj2.numRows + " expected = " + this.numCols);
        }
        if (fMatrixRMaj.numRows != this.numRows || fMatrixRMaj.numCols != fMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        this.f2716U = this.decomposer.getR(this.f2716U, true);
        float[] gammas = this.decomposer.getGammas();
        float[] fArr = this.f2715QR.data;
        int i = fMatrixRMaj.numCols;
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2717a[i3] = fMatrixRMaj.data[(i3 * i) + i2];
            }
            int i4 = 0;
            while (i4 < this.numCols) {
                int i5 = (this.numRows * i4) + i4 + 1;
                float f = this.f2717a[i4];
                int i6 = i4 + 1;
                int i7 = i6;
                while (i7 < this.numRows) {
                    f += fArr[i5] * this.f2717a[i7];
                    i7++;
                    i5++;
                }
                float f2 = f * gammas[i4];
                float[] fArr2 = this.f2717a;
                fArr2[i4] = fArr2[i4] - f2;
                int i8 = (this.numRows * i4) + i4 + 1;
                int i9 = i6;
                while (i9 < this.numRows) {
                    float[] fArr3 = this.f2717a;
                    fArr3[i9] = fArr3[i9] - (fArr[i8] * f2);
                    i9++;
                    i8++;
                }
                i4 = i6;
            }
            TriangularSolver_FDRM.solveU(this.f2716U.data, this.f2717a, this.numCols);
            for (int i10 = 0; i10 < this.numCols; i10++) {
                fMatrixRMaj2.data[(fMatrixRMaj2.numCols * i10) + i2] = this.f2717a[i10];
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
}
