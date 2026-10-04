package org.ejml.dense.row.linsol;

import org.ejml.data.FMatrixRBlock;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.block.MatrixOps_FDRB;
import org.ejml.dense.block.linsol.chol.CholeskyOuterSolver_FDRB;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolver_FDRB_to_FDRM implements LinearSolverDense<FMatrixRMaj> {
    protected LinearSolverDense<FMatrixRBlock> alg;
    protected FMatrixRBlock blockA = new FMatrixRBlock(1, 1);
    protected FMatrixRBlock blockB = new FMatrixRBlock(1, 1);
    protected FMatrixRBlock blockX = new FMatrixRBlock(1, 1);

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolver_FDRB_to_FDRM(LinearSolverDense<FMatrixRBlock> linearSolverDense) {
        this.alg = new CholeskyOuterSolver_FDRB();
        this.alg = linearSolverDense;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        this.blockA.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false);
        MatrixOps_FDRB.convert(fMatrixRMaj, this.blockA);
        return this.alg.setA(this.blockA);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return this.alg.quality();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        this.blockB.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false);
        this.blockX.reshape(fMatrixRMaj2.numRows, fMatrixRMaj2.numCols, false);
        MatrixOps_FDRB.convert(fMatrixRMaj, this.blockB);
        this.alg.solve(this.blockB, this.blockX);
        MatrixOps_FDRB.convert(this.blockX, fMatrixRMaj2);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRMaj fMatrixRMaj) {
        this.blockB.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols, false);
        this.alg.invert(this.blockB);
        MatrixOps_FDRB.convert(this.blockB, fMatrixRMaj);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public <D extends DecompositionInterface> D getDecomposition() {
        return (D) this.alg.getDecomposition();
    }
}
