package org.ejml.dense.row.linsol.p052qr;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QRDecompositionHouseholderColumn_DDRM;
import org.ejml.dense.row.decomposition.p050qr.QrUpdate_DDRM;
import org.ejml.dense.row.linsol.AdjustableLinearSolver_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class AdjLinearSolverQr_DDRM extends LinearSolverQr_DDRM implements AdjustableLinearSolver_DDRM {

    /* JADX INFO: renamed from: A */
    private DMatrixRMaj f2687A;
    private QrUpdate_DDRM update;

    public AdjLinearSolverQr_DDRM() {
        super(new QRDecompositionHouseholderColumn_DDRM());
    }

    @Override // org.ejml.dense.row.linsol.p052qr.LinearSolverQr_DDRM
    public void setMaxSize(int i, int i2) {
        int i3 = i + 5;
        super.setMaxSize(i3, i2);
        this.update = new QrUpdate_DDRM(i3, i2, true);
        this.f2687A = new DMatrixRMaj(i3, i2);
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM
    public DMatrixRMaj getA() {
        if (this.f2687A.data.length < this.numRows * this.numCols) {
            this.f2687A = new DMatrixRMaj(this.numRows, this.numCols);
        }
        this.f2687A.reshape(this.numRows, this.numCols, false);
        CommonOps_DDRM.mult(this.f2738Q, this.f2739R, this.f2687A);
        return this.f2687A;
    }

    @Override // org.ejml.dense.row.linsol.AdjustableLinearSolver_DDRM
    public boolean addRowToA(double[] dArr, int i) {
        if (this.numRows + 1 > this.maxRows) {
            int i2 = this.maxRows / 10;
            if (i2 < 1) {
                i2 = 1;
            }
            this.maxRows = this.numRows + i2;
            this.f2738Q.reshape(this.maxRows, this.maxRows, true);
            this.f2739R.reshape(this.maxRows, this.maxCols, true);
        }
        this.update.addRow(this.f2738Q, this.f2739R, dArr, i, true);
        this.numRows++;
        return true;
    }

    @Override // org.ejml.dense.row.linsol.AdjustableLinearSolver_DDRM
    public boolean removeRowFromA(int i) {
        this.update.deleteRow(this.f2738Q, this.f2739R, i, true);
        this.numRows--;
        return true;
    }
}
