package org.ejml.dense.block.linsol.chol;

import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FSubmatrixD1;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.dense.block.TriangularSolver_FDRB;
import org.ejml.dense.block.decomposition.chol.CholeskyOuterForm_FDRB;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyOuterSolver_FDRB implements LinearSolverDense<FMatrixRBlock> {
    private int blockLength;
    private CholeskyOuterForm_FDRB decomposer = new CholeskyOuterForm_FDRB(true);
    private float[] temp;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRBlock fMatrixRBlock) {
        if (!this.decomposer.decompose(fMatrixRBlock)) {
            return false;
        }
        this.blockLength = fMatrixRBlock.blockLength;
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return SpecializedOps_FDRM.qualityTriangular(this.decomposer.getT((FMatrixRBlock) null));
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRBlock fMatrixRBlock, FMatrixRBlock fMatrixRBlock2) {
        if (fMatrixRBlock.blockLength != this.blockLength) {
            throw new IllegalArgumentException("Unexpected blocklength in B.");
        }
        FSubmatrixD1 fSubmatrixD1 = new FSubmatrixD1(this.decomposer.getT((FMatrixRBlock) null));
        if (fMatrixRBlock2 != null) {
            if (fMatrixRBlock2.blockLength != this.blockLength) {
                throw new IllegalArgumentException("Unexpected blocklength in X.");
            }
            if (fMatrixRBlock2.numRows != fSubmatrixD1.col1) {
                throw new IllegalArgumentException("Not enough rows in X");
            }
        }
        if (fMatrixRBlock.numRows != fSubmatrixD1.col1) {
            throw new IllegalArgumentException("Not enough rows in B");
        }
        TriangularSolver_FDRB.solve(this.blockLength, false, fSubmatrixD1, new FSubmatrixD1(fMatrixRBlock), false);
        TriangularSolver_FDRB.solve(this.blockLength, false, fSubmatrixD1, new FSubmatrixD1(fMatrixRBlock), true);
        if (fMatrixRBlock2 != null) {
            MatrixOps_FDRB.extractAligned(fMatrixRBlock, fMatrixRBlock2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void invert(FMatrixRBlock fMatrixRBlock) {
        FMatrixRBlock t = this.decomposer.getT((FMatrixRBlock) null);
        if (fMatrixRBlock.numRows != t.numRows || fMatrixRBlock.numCols != t.numCols) {
            throw new IllegalArgumentException("Unexpected number or rows and/or columns");
        }
        float[] fArr = this.temp;
        if (fArr != null) {
            int length = fArr.length;
            int i = this.blockLength;
            if (length < i * i) {
                int i2 = this.blockLength;
                this.temp = new float[i2 * i2];
            }
        }
        MatrixOps_FDRB.zeroTriangle(true, fMatrixRBlock);
        FSubmatrixD1 fSubmatrixD1 = new FSubmatrixD1(t);
        FSubmatrixD1 fSubmatrixD12 = new FSubmatrixD1(fMatrixRBlock);
        TriangularSolver_FDRB.invert(this.blockLength, false, fSubmatrixD1, fSubmatrixD12, this.temp);
        TriangularSolver_FDRB.solveL(this.blockLength, fSubmatrixD1, fSubmatrixD12, true);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposer.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public CholeskyDecomposition_F32<FMatrixRBlock> getDecomposition() {
        return this.decomposer;
    }
}
