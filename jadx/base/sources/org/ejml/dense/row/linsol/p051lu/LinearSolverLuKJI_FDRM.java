package org.ejml.dense.row.linsol.p051lu;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionBase_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class LinearSolverLuKJI_FDRM extends LinearSolverLuBase_FDRM {
    private float[] dataLU;
    private int[] pivot;

    public LinearSolverLuKJI_FDRM(LUDecompositionBase_FDRM lUDecompositionBase_FDRM) {
        super(lUDecompositionBase_FDRM);
    }

    @Override // org.ejml.dense.row.linsol.p051lu.LinearSolverLuBase_FDRM, org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        boolean a2 = super.setA(fMatrixRMaj);
        this.pivot = this.decomp.getPivot();
        this.dataLU = this.decomp.getLU().data;
        return a2;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        if (fMatrixRMaj.numCols != fMatrixRMaj2.numCols || fMatrixRMaj.numRows != this.numRows || fMatrixRMaj2.numRows != this.numCols) {
            throw new IllegalArgumentException("Unexpected matrix size");
        }
        if (fMatrixRMaj != fMatrixRMaj2) {
            SpecializedOps_FDRM.copyChangeRow(this.pivot, fMatrixRMaj, fMatrixRMaj2);
            int i = fMatrixRMaj.numCols;
            float[] fArr = fMatrixRMaj2.data;
            int i2 = 0;
            while (i2 < this.numCols) {
                int i3 = i2 + 1;
                for (int i4 = i3; i4 < this.numCols; i4++) {
                    for (int i5 = 0; i5 < i; i5++) {
                        int i6 = (i4 * i) + i5;
                        fArr[i6] = fArr[i6] - (fArr[(i2 * i) + i5] * this.dataLU[(this.numCols * i4) + i2]);
                    }
                }
                i2 = i3;
            }
            for (int i7 = this.numCols - 1; i7 >= 0; i7--) {
                for (int i8 = 0; i8 < i; i8++) {
                    int i9 = (i7 * i) + i8;
                    fArr[i9] = fArr[i9] / this.dataLU[(this.numCols * i7) + i7];
                }
                for (int i10 = 0; i10 < i7; i10++) {
                    for (int i11 = 0; i11 < i; i11++) {
                        int i12 = (i10 * i) + i11;
                        fArr[i12] = fArr[i12] - (fArr[(i7 * i) + i11] * this.dataLU[(this.numCols * i10) + i7]);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("Current doesn't support using the same matrix instance");
    }
}
