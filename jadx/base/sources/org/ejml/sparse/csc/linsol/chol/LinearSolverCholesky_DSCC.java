package org.ejml.sparse.csc.linsol.chol;

import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.linsol.LinearSolverSparse;
import org.ejml.sparse.ComputePermutation;
import org.ejml.sparse.csc.CommonOps_DSCC;
import org.ejml.sparse.csc.decomposition.chol.CholeskyUpLooking_DSCC;
import org.ejml.sparse.csc.misc.ApplyFillReductionPermutation;
import org.ejml.sparse.csc.misc.TriangularSolver_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverCholesky_DSCC implements LinearSolverSparse<DMatrixSparseCSC, DMatrixRMaj> {
    CholeskyUpLooking_DSCC cholesky;

    /* JADX INFO: renamed from: gb */
    DGrowArray f2781gb = new DGrowArray();

    /* JADX INFO: renamed from: gx */
    DGrowArray f2782gx = new DGrowArray();
    ApplyFillReductionPermutation reduce;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverCholesky_DSCC(CholeskyUpLooking_DSCC choleskyUpLooking_DSCC, ComputePermutation<DMatrixSparseCSC> computePermutation) {
        this.cholesky = choleskyUpLooking_DSCC;
        this.reduce = new ApplyFillReductionPermutation(computePermutation, true);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixSparseCSC dMatrixSparseCSC) {
        return this.cholesky.decompose(this.reduce.apply(dMatrixSparseCSC));
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return TriangularSolver_DSCC.qualityTriangular(this.cholesky.getL());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverSparse
    public void lockStructure() {
        this.cholesky.lockStructure();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverSparse
    public boolean isStructureLocked() {
        return this.cholesky.isStructureLocked();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        DMatrixSparseCSC l = this.cholesky.getL();
        int i = l.numRows;
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(this.f2781gb, i);
        double[] dArrAdjust2 = TriangularSolver_DSCC.adjust(this.f2782gx, i);
        int[] arrayPinv = this.reduce.getArrayPinv();
        for (int i2 = 0; i2 < dMatrixRMaj.numCols; i2++) {
            int i3 = 0;
            int i4 = i2;
            while (i3 < i) {
                dArrAdjust[i3] = dMatrixRMaj.data[i4];
                i3++;
                i4 += dMatrixRMaj.numCols;
            }
            if (arrayPinv != null) {
                CommonOps_DSCC.permuteInv(arrayPinv, dArrAdjust, dArrAdjust2, i);
                TriangularSolver_DSCC.solveL(l, dArrAdjust2);
                TriangularSolver_DSCC.solveTranL(l, dArrAdjust2);
                CommonOps_DSCC.permute(arrayPinv, dArrAdjust2, dArrAdjust, i);
            } else {
                TriangularSolver_DSCC.solveL(l, dArrAdjust);
                TriangularSolver_DSCC.solveTranL(l, dArrAdjust);
            }
            int i5 = 0;
            int i6 = i2;
            while (i5 < i) {
                dMatrixRMaj2.data[i6] = dArrAdjust[i5];
                i5++;
                i6 += dMatrixRMaj2.numCols;
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.cholesky.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public <D extends DecompositionInterface> D getDecomposition() {
        return this.cholesky;
    }
}
