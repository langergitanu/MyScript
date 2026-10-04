package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholder_DDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrHouse_DDRM extends LinearSolverAbstract_DDRM {

    /* JADX INFO: renamed from: QR */
    private DMatrixRMaj f2724QR;

    /* JADX INFO: renamed from: a */
    private double[] f2725a;
    private double[] gammas;

    /* JADX INFO: renamed from: u */
    private double[] f2726u;
    private int maxRows = -1;
    private QRDecompositionHouseholder_DDRM decomposer = new QRDecompositionHouseholder_DDRM();

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
        this.f2725a = new double[i];
        this.f2726u = new double[i];
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows > this.maxRows) {
            setMaxSize(dMatrixRMaj.numRows);
        }
        _setA(dMatrixRMaj);
        if (!this.decomposer.decompose(dMatrixRMaj)) {
            return false;
        }
        this.gammas = this.decomposer.getGammas();
        this.f2724QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_DDRM.qualityTriangular(this.f2724QR);
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
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.f2725a[i3] = dMatrixRMaj.data[(i3 * i) + i2];
            }
            int i4 = 0;
            while (i4 < this.numCols) {
                this.f2726u[i4] = 1.0d;
                double d = this.f2725a[i4];
                int i5 = i4 + 1;
                for (int i6 = i5; i6 < this.numRows; i6++) {
                    double[] dArr = this.f2726u;
                    double dUnsafe_get = this.f2724QR.unsafe_get(i6, i4);
                    dArr[i6] = dUnsafe_get;
                    d += dUnsafe_get * this.f2725a[i6];
                }
                double d2 = d * this.gammas[i4];
                while (i4 < this.numRows) {
                    double[] dArr2 = this.f2725a;
                    dArr2[i4] = dArr2[i4] - (this.f2726u[i4] * d2);
                    i4++;
                }
                i4 = i5;
            }
            TriangularSolver_DDRM.solveU(this.f2724QR.data, this.f2725a, this.numCols);
            for (int i7 = 0; i7 < this.numCols; i7++) {
                dMatrixRMaj2.data[(dMatrixRMaj2.numCols * i7) + i2] = this.f2725a[i7];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<DMatrixRMaj> getDecomposition() {
        return this.decomposer;
    }
}
