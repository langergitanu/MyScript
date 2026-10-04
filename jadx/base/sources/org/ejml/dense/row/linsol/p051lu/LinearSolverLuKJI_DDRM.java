package org.ejml.dense.row.linsol.p051lu;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionBase_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverLuKJI_DDRM extends LinearSolverLuBase_DDRM {
    private double[] dataLU;
    private int[] pivot;

    public LinearSolverLuKJI_DDRM(LUDecompositionBase_DDRM lUDecompositionBase_DDRM) {
        super(lUDecompositionBase_DDRM);
    }

    @Override // org.ejml.dense.row.linsol.p051lu.LinearSolverLuBase_DDRM, org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        boolean a2 = super.setA(dMatrixRMaj);
        this.pivot = this.decomp.getPivot();
        this.dataLU = this.decomp.getLU().data;
        return a2;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numCols != dMatrixRMaj2.numCols || dMatrixRMaj.numRows != this.numRows || dMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        if (dMatrixRMaj != dMatrixRMaj2) {
            SpecializedOps_DDRM.copyChangeRow(this.pivot, dMatrixRMaj, dMatrixRMaj2);
            int i = dMatrixRMaj.numCols;
            double[] dArr = dMatrixRMaj2.data;
            int i2 = 0;
            while (i2 < this.numCols) {
                int i3 = i2 + 1;
                for (int i4 = i3; i4 < this.numCols; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = (i4 * i) + i5;
                        dArr[i6] = dArr[i6] - (dArr[(i2 * i) + i5] * this.dataLU[(this.numCols * i4) + i2]);
                    }
                }
                i2 = i3;
            }
            for (int i7 = this.numCols - 1; i7 >= 0; i7--) {
                for (int i8 = 0; i8 < i; i8++) {
                    int i9 = (i7 * i) + i8;
                    dArr[i9] = dArr[i9] / this.dataLU[(this.numCols * i7) + i7];
                }
                for (int i10 = 0; i10 < i7; i10++) {
                    for (int i11 = 0; i11 < i; i11++) {
                        int i12 = (i10 * i) + i11;
                        dArr[i12] = dArr[i12] - (dArr[(i7 * i) + i11] * this.dataLU[(this.numCols * i10) + i7]);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("Current doesn't support using the same matrix instance");
    }
}
