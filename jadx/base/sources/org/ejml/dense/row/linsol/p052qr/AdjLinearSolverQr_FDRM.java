package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_FDRM;
import org.ejml.dense.row.decomposition.p050qr.QrUpdate_FDRM;
import org.ejml.dense.row.linsol.AdjustableLinearSolver_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class AdjLinearSolverQr_FDRM extends LinearSolverQr_FDRM implements AdjustableLinearSolver_FDRM {

    /* JADX INFO: renamed from: A */
    private FMatrixRMaj f2688A;
    private QrUpdate_FDRM update;

    public AdjLinearSolverQr_FDRM() {
        super(new QRDecompositionHouseholderColumn_FDRM());
    }

    @Override // org.ejml.dense.row.linsol.p052qr.LinearSolverQr_FDRM
    public void setMaxSize(int i, int i2) {
        int i3 = i + 5;
        super.setMaxSize(i3, i2);
        this.update = new QrUpdate_FDRM(i3, i2, true);
        this.f2688A = new FMatrixRMaj(i3, i2);
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_FDRM
    public FMatrixRMaj getA() {
        if (this.f2688A.data.length < this.numRows * this.numCols) {
            this.f2688A = new FMatrixRMaj(this.numRows, this.numCols);
        }
        this.f2688A.reshape(this.numRows, this.numCols, false);
        CommonOps_FDRM.mult(this.f2742Q, this.f2743R, this.f2688A);
        return this.f2688A;
    }

    @Override // org.ejml.dense.row.linsol.AdjustableLinearSolver_FDRM
    public boolean addRowToA(float[] fArr, int i) {
        if (this.numRows + 1 > this.maxRows) {
            int i2 = this.maxRows / 10;
            if (i2 < 1) {
                i2 = 1;
            }
            this.maxRows = this.numRows + i2;
            this.f2742Q.reshape(this.maxRows, this.maxRows, true);
            this.f2743R.reshape(this.maxRows, this.maxCols, true);
        }
        this.update.addRow(this.f2742Q, this.f2743R, fArr, i, true);
        this.numRows++;
        return true;
    }

    @Override // org.ejml.dense.row.linsol.AdjustableLinearSolver_FDRM
    public boolean removeRowFromA(int i) {
        this.update.deleteRow(this.f2742Q, this.f2743R, i, true);
        this.numRows--;
        return true;
    }
}
