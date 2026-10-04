package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderTran_DDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouseTran_DDRM extends LinearSolverAbstract_DDRM {

    /* JADX INFO: renamed from: QR */
    private DMatrixRMaj f2712QR;

    /* JADX INFO: renamed from: U */
    private DMatrixRMaj f2713U;

    /* JADX INFO: renamed from: a */
    private double[] f2714a;
    protected int maxRows = -1;
    protected int maxCols = -1;
    private QRDecompositionHouseholderTran_DDRM decomposer = new QRDecompositionHouseholderTran_DDRM();

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public void setMaxSize(int i, int i2) {
        this.maxRows = i;
        this.maxCols = i2;
        this.f2714a = new double[i];
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
        this.f2712QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_DDRM.qualityTriangular(this.f2712QR);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for X: X rows = " + dMatrixRMaj2.numRows + " expected = " + this.numCols);
        }
        if (dMatrixRMaj.numRows != this.numRows || dMatrixRMaj.numCols != dMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("Unexpected dimensions for B");
        }
        int i = 1;
        this.f2713U = this.decomposer.getR(this.f2713U, true);
        double[] gammas = this.decomposer.getGammas();
        double[] dArr = this.f2712QR.data;
        int i2 = dMatrixRMaj.numCols;
        int i3 = 0;
        while (i3 < i2) {
            for (int i4 = 0; i4 < this.numRows; i4++) {
                this.f2714a[i4] = dMatrixRMaj.data[(i4 * i2) + i3];
            }
            int i5 = 0;
            while (i5 < this.numCols) {
                int i6 = (this.numRows * i5) + i5 + i;
                double d = this.f2714a[i5];
                int i7 = i5 + 1;
                int i8 = i7;
                while (i8 < this.numRows) {
                    d += dArr[i6] * this.f2714a[i8];
                    i8++;
                    i6++;
                    i = i;
                }
                int i9 = i;
                double d2 = d * gammas[i5];
                double[] dArr2 = this.f2714a;
                dArr2[i5] = dArr2[i5] - d2;
                int i10 = (this.numRows * i5) + i5 + 1;
                int i11 = i7;
                while (i11 < this.numRows) {
                    double[] dArr3 = this.f2714a;
                    dArr3[i11] = dArr3[i11] - (dArr[i10] * d2);
                    i11++;
                    i10++;
                }
                i5 = i7;
                i = i9;
            }
            int i12 = i;
            TriangularSolver_DDRM.solveU(this.f2713U.data, this.f2714a, this.numCols);
            for (int i13 = 0; i13 < this.numCols; i13++) {
                dMatrixRMaj2.data[(dMatrixRMaj2.numCols * i13) + i3] = this.f2714a[i13];
            }
            i3++;
            i = i12;
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
}
