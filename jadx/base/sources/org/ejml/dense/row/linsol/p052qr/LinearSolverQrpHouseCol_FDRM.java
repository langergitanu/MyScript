package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.TriangularSolver_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QRColPivDecompositionHouseholderColumn_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QrHelperFunctions_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrpHouseCol_FDRM extends BaseLinearSolverQrp_FDRM {
    private QRColPivDecompositionHouseholderColumn_FDRM decomposition;
    private FMatrixRMaj x_basic;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverQrpHouseCol_FDRM(QRColPivDecompositionHouseholderColumn_FDRM qRColPivDecompositionHouseholderColumn_FDRM, boolean z) {
        super(qRColPivDecompositionHouseholderColumn_FDRM, z);
        this.x_basic = new FMatrixRMaj(1, 1);
        this.decomposition = qRColPivDecompositionHouseholderColumn_FDRM;
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
        int[] colPivots = this.decomposition.getColPivots();
        float[][] qr = this.decomposition.getQR();
        float[] gammas = this.decomposition.getGammas();
        for (int i2 = 0; i2 < i; i2++) {
            this.x_basic.reshape(this.numRows, 1);
            this.f2696Y.reshape(this.numRows, 1);
            for (int i3 = 0; i3 < this.numRows; i3++) {
                this.x_basic.data[i3] = fMatrixRMaj.get(i3, i2);
            }
            int i4 = 0;
            while (i4 < this.rank) {
                float[] fArr = qr[i4];
                float f = fArr[i4];
                fArr[i4] = 1.0f;
                int i5 = i4;
                QrHelperFunctions_FDRM.rank1UpdateMultR(this.x_basic, fArr, gammas[i4], 0, i5, this.numRows, this.f2696Y.data);
                fArr[i5] = f;
                i4 = i5 + 1;
            }
            TriangularSolver_FDRM.solveU(this.R11.data, this.x_basic.data, this.rank);
            this.x_basic.reshape(this.numCols, 1, true);
            for (int i6 = this.rank; i6 < this.numCols; i6++) {
                this.x_basic.data[i6] = 0.0f;
            }
            if (this.norm2Solution && this.rank < this.numCols) {
                upgradeSolution(this.x_basic);
            }
            for (int i7 = 0; i7 < this.numCols; i7++) {
                fMatrixRMaj2.set(colPivots[i7], i2, this.x_basic.data[i7]);
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposition.inputModified();
    }
}
