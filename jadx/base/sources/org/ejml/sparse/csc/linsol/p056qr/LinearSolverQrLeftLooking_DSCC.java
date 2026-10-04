package org.ejml.sparse.csc.linsol.p056qr;

import org.ejml.data.DGrowArray;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.DMatrixSparseCSC;
import org.ejml.interfaces.decomposition.DecompositionInterface;
import org.ejml.interfaces.linsol.LinearSolverSparse;
import org.ejml.sparse.csc.CommonOps_DSCC;
import org.ejml.sparse.csc.decomposition.p054qr.QrHelperFunctions_DSCC;
import org.ejml.sparse.csc.decomposition.p054qr.QrLeftLookingDecomposition_DSCC;
import org.ejml.sparse.csc.misc.TriangularSolver_DSCC;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverQrLeftLooking_DSCC implements LinearSolverSparse<DMatrixSparseCSC, DMatrixRMaj> {

    /* JADX INFO: renamed from: gb */
    private DGrowArray f2785gb = new DGrowArray();
    private DGrowArray gbp = new DGrowArray();

    /* JADX INFO: renamed from: gx */
    private DGrowArray f2786gx = new DGrowArray();

    /* JADX INFO: renamed from: m */
    private int f2787m;

    /* JADX INFO: renamed from: n */
    private int f2788n;

    /* JADX INFO: renamed from: qr */
    private QrLeftLookingDecomposition_DSCC f2789qr;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverQrLeftLooking_DSCC(QrLeftLookingDecomposition_DSCC qrLeftLookingDecomposition_DSCC) {
        this.f2789qr = qrLeftLookingDecomposition_DSCC;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixSparseCSC dMatrixSparseCSC) {
        if (dMatrixSparseCSC.numCols > dMatrixSparseCSC.numRows) {
            throw new IllegalArgumentException("Can't handle wide matrices");
        }
        this.f2787m = dMatrixSparseCSC.numRows;
        this.f2788n = dMatrixSparseCSC.numCols;
        return this.f2789qr.decompose(dMatrixSparseCSC) && !this.f2789qr.isSingular();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return TriangularSolver_DSCC.qualityTriangular(this.f2789qr.getR());
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverSparse
    public void lockStructure() {
        this.f2789qr.lockStructure();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverSparse
    public boolean isStructureLocked() {
        return this.f2789qr.isStructureLocked();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        double[] dArr;
        double[] dArrAdjust = TriangularSolver_DSCC.adjust(this.f2785gb, dMatrixRMaj.numRows);
        double[] dArrAdjust2 = TriangularSolver_DSCC.adjust(this.gbp, dMatrixRMaj.numRows);
        double[] dArrAdjust3 = TriangularSolver_DSCC.adjust(this.f2786gx, dMatrixRMaj2.numRows);
        int[] pinv = this.f2789qr.getStructure().getPinv();
        for (int i = 0; i < dMatrixRMaj2.numCols; i++) {
            int i2 = 0;
            int i3 = i;
            while (i2 < dMatrixRMaj.numRows) {
                dArrAdjust[i2] = dMatrixRMaj.data[i3];
                i2++;
                i3 += dMatrixRMaj2.numCols;
            }
            CommonOps_DSCC.permuteInv(pinv, dArrAdjust, dArrAdjust2, this.f2787m);
            for (int i4 = 0; i4 < this.f2788n; i4++) {
                QrHelperFunctions_DSCC.applyHouseholder(this.f2789qr.getV(), i4, this.f2789qr.getBeta(i4), dArrAdjust2);
            }
            TriangularSolver_DSCC.solveU(this.f2789qr.getR(), dArrAdjust2);
            if (this.f2789qr.isFillPermutated()) {
                CommonOps_DSCC.permute(this.f2789qr.getFillPermutation(), dArrAdjust2, dArrAdjust3, dMatrixRMaj2.numRows);
                dArr = dArrAdjust3;
            } else {
                dArr = dArrAdjust2;
            }
            int i5 = 0;
            int i6 = i;
            while (i5 < dMatrixRMaj2.numRows) {
                dMatrixRMaj2.data[i6] = dArr[i5];
                i5++;
                i6 += dMatrixRMaj2.numCols;
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.f2789qr.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public <D extends DecompositionInterface> D getDecomposition() {
        return this.f2789qr;
    }
}
