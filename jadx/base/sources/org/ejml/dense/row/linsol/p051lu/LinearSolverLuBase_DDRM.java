package org.ejml.dense.row.linsol.p051lu;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.p049lu.LUDecompositionBase_DDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LinearSolverLuBase_DDRM extends LinearSolverAbstract_DDRM {
    protected LUDecompositionBase_DDRM decomp;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverLuBase_DDRM(LUDecompositionBase_DDRM lUDecompositionBase_DDRM) {
        this.decomp = lUDecompositionBase_DDRM;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        _setA(dMatrixRMaj);
        return this.decomp.decompose(dMatrixRMaj);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return this.decomp.quality();
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_DDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRMaj dMatrixRMaj) {
        double[] dArr_getVV = this.decomp._getVV();
        DMatrixRMaj lu = this.decomp.getLU();
        if (dMatrixRMaj.numCols != lu.numCols || dMatrixRMaj.numRows != lu.numRows) {
            throw new IllegalArgumentException("Unexpected matrix dimension");
        }
        int i = this.f2662A.numCols;
        double[] dArr = dMatrixRMaj.data;
        int i2 = 0;
        while (i2 < i) {
            int i3 = 0;
            while (i3 < i) {
                dArr_getVV[i3] = i3 == i2 ? 1.0d : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                i3++;
            }
            this.decomp._solveVectorInternal(dArr_getVV);
            int i4 = 0;
            int i5 = i2;
            while (i4 < i) {
                dArr[i5] = dArr_getVV[i4];
                i4++;
                i5 += i;
            }
            i2++;
        }
    }

    public void improveSol(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        if (dMatrixRMaj.numCols != dMatrixRMaj2.numCols) {
            throw new IllegalArgumentException("bad shapes");
        }
        double[] dArr = this.f2662A.data;
        double[] dArr2 = dMatrixRMaj.data;
        double[] dArr3 = dMatrixRMaj2.data;
        int i = dMatrixRMaj.numCols;
        int i2 = dMatrixRMaj.numCols;
        double[] dArr_getVV = this.decomp._getVV();
        for (int i3 = 0; i3 < i; i3++) {
            for (int i4 = 0; i4 < i2; i4++) {
                double d = -dArr2[(i4 * i) + i3];
                for (int i5 = 0; i5 < i2; i5++) {
                    d += dArr[(i4 * i2) + i5] * dArr3[(i5 * i) + i3];
                }
                dArr_getVV[i4] = d;
            }
            this.decomp._solveVectorInternal(dArr_getVV);
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = (i6 * i) + i3;
                dArr3[i7] = dArr3[i7] - dArr_getVV[i6];
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public LUDecompositionBase_DDRM getDecomposition() {
        return this.decomp;
    }
}
