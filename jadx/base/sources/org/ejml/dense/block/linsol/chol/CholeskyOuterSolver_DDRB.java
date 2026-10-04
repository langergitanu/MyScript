package org.ejml.dense.block.linsol.chol;

import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DSubmatrixD1;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.dense.block.TriangularSolver_DDRB;
import org.ejml.dense.block.decomposition.chol.CholeskyOuterForm_DDRB;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyOuterSolver_DDRB implements LinearSolverDense<DMatrixRBlock> {
    private int blockLength;
    private CholeskyOuterForm_DDRB decomposer = new CholeskyOuterForm_DDRB(true);
    private double[] temp;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRBlock dMatrixRBlock) {
        if (!this.decomposer.decompose(dMatrixRBlock)) {
            return false;
        }
        this.blockLength = dMatrixRBlock.blockLength;
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_DDRM.qualityTriangular(this.decomposer.getT((DMatrixRBlock) null));
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRBlock dMatrixRBlock, DMatrixRBlock dMatrixRBlock2) {
        if (dMatrixRBlock.blockLength != this.blockLength) {
            throw new IllegalArgumentException("Unexpected blocklength in B.");
        }
        DSubmatrixD1 dSubmatrixD1 = new DSubmatrixD1(this.decomposer.getT((DMatrixRBlock) null));
        if (dMatrixRBlock2 != null) {
            if (dMatrixRBlock2.blockLength != this.blockLength) {
                throw new IllegalArgumentException("Unexpected blocklength in X.");
            }
            if (dMatrixRBlock2.numRows != dSubmatrixD1.col1) {
                throw new IllegalArgumentException("Not enough rows in X");
            }
        }
        if (dMatrixRBlock.numRows != dSubmatrixD1.col1) {
            throw new IllegalArgumentException("Not enough rows in B");
        }
        TriangularSolver_DDRB.solve(this.blockLength, false, dSubmatrixD1, new DSubmatrixD1(dMatrixRBlock), false);
        TriangularSolver_DDRB.solve(this.blockLength, false, dSubmatrixD1, new DSubmatrixD1(dMatrixRBlock), true);
        if (dMatrixRBlock2 != null) {
            MatrixOps_DDRB.extractAligned(dMatrixRBlock, dMatrixRBlock2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invert(DMatrixRBlock dMatrixRBlock) {
        DMatrixRBlock t = this.decomposer.getT((DMatrixRBlock) null);
        if (dMatrixRBlock.numRows != t.numRows || dMatrixRBlock.numCols != t.numCols) {
            throw new IllegalArgumentException("Unexpected number or rows and/or columns");
        }
        double[] dArr = this.temp;
        if (dArr != null) {
            int length = dArr.length;
            int i = this.blockLength;
            if (length < i * i) {
                int i2 = this.blockLength;
                this.temp = new double[i2 * i2];
            }
        }
        MatrixOps_DDRB.zeroTriangle(true, dMatrixRBlock);
        DSubmatrixD1 dSubmatrixD1 = new DSubmatrixD1(t);
        DSubmatrixD1 dSubmatrixD12 = new DSubmatrixD1(dMatrixRBlock);
        TriangularSolver_DDRB.invert(this.blockLength, false, dSubmatrixD1, dSubmatrixD12, this.temp);
        TriangularSolver_DDRB.solveL(this.blockLength, dSubmatrixD1, dSubmatrixD12, true);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public CholeskyDecomposition_F64<DMatrixRBlock> getDecomposition() {
        return this.decomposer;
    }
}
