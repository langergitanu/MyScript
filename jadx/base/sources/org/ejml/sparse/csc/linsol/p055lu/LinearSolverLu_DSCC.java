package org.ejml.sparse.csc.linsol.p055lu;

import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.linsol.LinearSolverSparse;
import org.ejml.sparse.csc.CommonOps_DSCC;
import org.ejml.sparse.csc.decomposition.p053lu.LuUpLooking_DSCC;
import org.ejml.sparse.csc.misc.TriangularSolver_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverLu_DSCC implements LinearSolverSparse<DMatrixSparseCSC, DMatrixRMaj> {
    LuUpLooking_DSCC decomposition;

    /* JADX INFO: renamed from: gx */
    private DGrowArray f2784gx = new DGrowArray();

    /* JADX INFO: renamed from: gb */
    private DGrowArray f2783gb = new DGrowArray();

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverLu_DSCC(LuUpLooking_DSCC luUpLooking_DSCC) {
        this.decomposition = luUpLooking_DSCC;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixSparseCSC dMatrixSparseCSC) {
        return this.decomposition.decompose(dMatrixSparseCSC);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return TriangularSolver_DSCC.qualityTriangular(this.decomposition.getU());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverSparse
    public void lockStructure() {
        this.decomposition.lockStructure();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverSparse
    public boolean isStructureLocked() {
        return this.decomposition.isStructureLocked();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        double[] dArr;
        int[] pinv = this.decomposition.getPinv();
        int[] reducePermutation = this.decomposition.getReducePermutation();
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(this.f2784gx, dMatrixRMaj2.numRows);
        double[] dArrAdjust2 = TriangularSolver_DSCC.adjust(this.f2783gb, dMatrixRMaj.numRows);
        DMatrixSparseCSC l = this.decomposition.getL();
        DMatrixSparseCSC u = this.decomposition.getU();
        boolean z = this.decomposition.getReduceFill() != null;
        for (int i = 0; i < dMatrixRMaj2.numCols; i++) {
            int i2 = 0;
            int i3 = i;
            while (i2 < dMatrixRMaj.numRows) {
                dArrAdjust2[i2] = dMatrixRMaj.data[i3];
                i2++;
                i3 += dMatrixRMaj2.numCols;
            }
            CommonOps_DSCC.permuteInv(pinv, dArrAdjust2, dArrAdjust, dMatrixRMaj2.numRows);
            TriangularSolver_DSCC.solveL(l, dArrAdjust);
            TriangularSolver_DSCC.solveU(u, dArrAdjust);
            if (z) {
                CommonOps_DSCC.permute(reducePermutation, dArrAdjust, dArrAdjust2, dMatrixRMaj2.numRows);
                dArr = dArrAdjust2;
            } else {
                dArr = dArrAdjust;
            }
            int i4 = 0;
            int i5 = i;
            while (i4 < dMatrixRMaj2.numRows) {
                dMatrixRMaj2.data[i5] = dArr[i4];
                i4++;
                i5 += dMatrixRMaj2.numCols;
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.decomposition.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public <D extends DecompositionInterface> D getDecomposition() {
        return this.decomposition;
    }
}
