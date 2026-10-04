package org.ejml.dense.block.linsol.p046qr;

import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.dense.block.TriangularSolver_FDRB;
import org.ejml.dense.block.decomposition.p045qr.QRDecompositionHouseholder_FDRB;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.interfaces.decomposition.QRDecomposition;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class QrHouseHolderSolver_FDRB implements LinearSolverDense<FMatrixRBlock> {

    /* JADX INFO: renamed from: QR */
    protected FMatrixRBlock f2452QR;
    protected QRDecompositionHouseholder_FDRB decomposer;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return true;
    }

    public QrHouseHolderSolver_FDRB() {
        QRDecompositionHouseholder_FDRB qRDecompositionHouseholder_FDRB = new QRDecompositionHouseholder_FDRB();
        this.decomposer = qRDecompositionHouseholder_FDRB;
        qRDecompositionHouseholder_FDRB.setSaveW(false);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRBlock fMatrixRBlock) {
        if (fMatrixRBlock.numRows < fMatrixRBlock.numCols) {
            throw new IllegalArgumentException("Number of rows must be more than or equal to the number of columns.  Can't solve an underdetermined system.");
        }
        if (!this.decomposer.decompose(fMatrixRBlock)) {
            return false;
        }
        this.f2452QR = this.decomposer.getQR();
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.decomposer.getQR());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2) {
        if (fMatrixRBlock.numCols != fMatrixRBlock2.numCols) {
            throw new IllegalArgumentException("Columns of B and X do not match");
        }
        if (this.f2452QR.numCols != fMatrixRBlock2.numRows) {
            throw new IllegalArgumentException("Rows in X do not match the columns in A");
        }
        if (this.f2452QR.numRows != fMatrixRBlock.numRows) {
            throw new IllegalArgumentException("Rows in B do not match the rows in A.");
        }
        if (fMatrixRBlock.blockLength != this.f2452QR.blockLength || fMatrixRBlock2.blockLength != this.f2452QR.blockLength) {
            throw new IllegalArgumentException("All matrices must have the same block length.");
        }
        this.decomposer.applyQTran(fMatrixRBlock);
        MatrixOps_FDRB.extractAligned(fMatrixRBlock, fMatrixRBlock2);
        int iMin = Math.min(this.f2452QR.numRows, this.f2452QR.numCols);
        TriangularSolver_FDRB.solve(this.f2452QR.blockLength, true, new FSubmatrixD1(this.f2452QR, 0, iMin, 0, iMin), new FSubmatrixD1(fMatrixRBlock2), false);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRBlock fMatrixRBlock) {
        int iMin = Math.min(this.f2452QR.numRows, this.f2452QR.numCols);
        if (fMatrixRBlock.numRows != iMin || fMatrixRBlock.numCols != iMin) {
            throw new IllegalArgumentException("A_inv must be square an have dimension " + iMin);
        }
        MatrixOps_FDRB.setIdentity(fMatrixRBlock);
        this.decomposer.applyQTran(fMatrixRBlock);
        TriangularSolver_FDRB.solve(this.f2452QR.blockLength, true, new FSubmatrixD1(this.f2452QR, 0, iMin, 0, iMin), new FSubmatrixD1(fMatrixRBlock), false);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public QRDecomposition<FMatrixRBlock> getDecomposition() {
        return this.decomposer;
    }
}
