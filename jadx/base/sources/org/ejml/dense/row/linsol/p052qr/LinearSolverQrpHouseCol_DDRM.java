package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.TriangularSolver_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QRColPivDecompositionHouseholderColumn_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrpHouseCol_DDRM extends BaseLinearSolverQrp_DDRM {
    private QRColPivDecompositionHouseholderColumn_DDRM decomposition;
    private DMatrixRMaj x_basic;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverQrpHouseCol_DDRM(QRColPivDecompositionHouseholderColumn_DDRM qRColPivDecompositionHouseholderColumn_DDRM, boolean z) {
        super(qRColPivDecompositionHouseholderColumn_DDRM, z);
        this.x_basic = new DMatrixRMaj(1, 1);
        this.decomposition = qRColPivDecompositionHouseholderColumn_DDRM;
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
        int[] colPivots = this.decomposition.getColPivots();
        double[][] qr = this.decomposition.getQR();
        double[] gammas = this.decomposition.getGammas();
        for (int i2 = 0; i2 < i; i2++) {
            this.x_basic.reshape(this.numRows, 1);
            this.f2692Y.reshape(this.numRows, 1);
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.x_basic.data[i3] = dMatrixRMaj.get(i3, i2);
            }
            int i4 = 0;
            while (i4 < this.rank) {
                double[] dArr = qr[i4];
                double d = dArr[i4];
                dArr[i4] = 1.0d;
                int i5 = i4;
                QrHelperFunctions_DDRM.rank1UpdateMultR(this.x_basic, dArr, gammas[i4], 0, i5, this.numRows, this.f2692Y.data);
                dArr[i5] = d;
                i4 = i5 + 1;
            }
            TriangularSolver_DDRM.solveU(this.R11.data, this.x_basic.data, this.rank);
            this.x_basic.reshape(this.numCols, 1, true);
            for (int i6 = this.rank; i6 < this.numCols; i6++) {
                this.x_basic.data[i6] = 0.0d;
            }
            if (this.norm2Solution && this.rank < this.numCols) {
                upgradeSolution(this.x_basic);
            }
            for (int i7 = 0; i7 < this.numCols; i7++) {
                dMatrixRMaj2.set(colPivots[i7], i2, this.x_basic.data[i7]);
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposition.inputModified();
    }
}
