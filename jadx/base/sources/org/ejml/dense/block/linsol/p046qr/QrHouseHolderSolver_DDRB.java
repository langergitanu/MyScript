package org.ejml.dense.block.linsol.p046qr;

import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.dense.block.TriangularSolver_DDRB;
import org.ejml.dense.block.decomposition.p045qr.QRDecompositionHouseholder_DDRB;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class QrHouseHolderSolver_DDRB implements LinearSolverDense<DMatrixRBlock> {

    /* JADX INFO: renamed from: QR */
    protected DMatrixRBlock f2451QR;
    protected QRDecompositionHouseholder_DDRB decomposer;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return true;
    }

    public QrHouseHolderSolver_DDRB() {
        QRDecompositionHouseholder_DDRB qRDecompositionHouseholder_DDRB = new QRDecompositionHouseholder_DDRB();
        this.decomposer = qRDecompositionHouseholder_DDRB;
        qRDecompositionHouseholder_DDRB.setSaveW(false);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRBlock dMatrixRBlock) {
        if (dMatrixRBlock.numRows < dMatrixRBlock.numCols) {
            throw new IllegalArgumentException("Number of rows must be more than or equal to the number of columns.  Can't solve an underdetermined system.");
        }
        if (!this.decomposer.decompose(dMatrixRBlock)) {
            return false;
        }
        this.f2451QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_DDRM.qualityTriangular(this.decomposer.getQR());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2) {
        if (dMatrixRBlock.numCols != dMatrixRBlock2.numCols) {
            throw new IllegalArgumentException("Columns of B and X do not match");
        }
        if (this.f2451QR.numCols != dMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("Rows in X do not match the columns in A");
        }
        if (this.f2451QR.numRows != dMatrixRBlock.numRows) {
            throw new IllegalArgumentException("Rows in B do not match the rows in A.");
        }
        if (dMatrixRBlock.blockLength != this.f2451QR.blockLength || dMatrixRBlock2.blockLength != this.f2451QR.blockLength) {
            throw new IllegalArgumentException("All matrices must have the same block length.");
        }
        this.decomposer.applyQTran(dMatrixRBlock);
        MatrixOps_DDRB.extractAligned(dMatrixRBlock, dMatrixRBlock2);
        int iMin = Math.min(this.f2451QR.numRows, this.f2451QR.numCols);
        TriangularSolver_DDRB.solve(this.f2451QR.blockLength, true, new DSubmatrixD1(this.f2451QR, 0, iMin, 0, iMin), new DSubmatrixD1(dMatrixRBlock2), false);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRBlock dMatrixRBlock) {
        int iMin = Math.min(this.f2451QR.numRows, this.f2451QR.numCols);
        if (dMatrixRBlock.numRows != iMin || dMatrixRBlock.numCols != iMin) {
            throw new IllegalArgumentException("A_inv must be square an have dimension " + iMin);
        }
        MatrixOps_DDRB.setIdentity(dMatrixRBlock);
        this.decomposer.applyQTran(dMatrixRBlock);
        TriangularSolver_DDRB.solve(this.f2451QR.blockLength, true, new DSubmatrixD1(this.f2451QR, 0, iMin, 0, iMin), new DSubmatrixD1(dMatrixRBlock), false);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<DMatrixRBlock> getDecomposition() {
        return this.decomposer;
    }
}
