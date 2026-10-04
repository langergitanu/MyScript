package org.ejml.dense.row.linsol;

import org.ejml.data.DMatrixRBlock;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.block.MatrixOps_DDRB;
import org.ejml.dense.block.linsol.chol.CholeskyOuterSolver_DDRB;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolver_DDRB_to_DDRM implements LinearSolverDense<DMatrixRMaj> {
    protected LinearSolverDense<DMatrixRBlock> alg;
    protected DMatrixRBlock blockA = new DMatrixRBlock(1, 1);
    protected DMatrixRBlock blockB = new DMatrixRBlock(1, 1);
    protected DMatrixRBlock blockX = new DMatrixRBlock(1, 1);

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolver_DDRB_to_DDRM(LinearSolverDense<DMatrixRBlock> linearSolverDense) {
        this.alg = new CholeskyOuterSolver_DDRB();
        this.alg = linearSolverDense;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        this.blockA.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false);
        MatrixOps_DDRB.convert(dMatrixRMaj, this.blockA);
        return this.alg.setA(this.blockA);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return this.alg.quality();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        this.blockB.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false);
        this.blockX.reshape(dMatrixRMaj2.numRows, dMatrixRMaj2.numCols, false);
        MatrixOps_DDRB.convert(dMatrixRMaj, this.blockB);
        this.alg.solve(this.blockB, this.blockX);
        MatrixOps_DDRB.convert(this.blockX, dMatrixRMaj2);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRMaj dMatrixRMaj) {
        this.blockB.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols, false);
        this.alg.invert(this.blockB);
        MatrixOps_DDRB.convert(this.blockB, dMatrixRMaj);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public <D extends DecompositionInterface> D getDecomposition() {
        return (D) this.alg.getDecomposition();
    }
}
