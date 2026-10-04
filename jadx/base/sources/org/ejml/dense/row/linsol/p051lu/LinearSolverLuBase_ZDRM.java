package org.ejml.dense.row.linsol.p051lu;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.p047lu.LUDecompositionBase_ZDRM;
import org.ejml.dense.row.linsol.LinearSolverAbstract_ZDRM;

/* JADX INFO: loaded from: classes9.dex */
public abstract class LinearSolverLuBase_ZDRM extends LinearSolverAbstract_ZDRM {
    protected LUDecompositionBase_ZDRM decomp;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return false;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public LinearSolverLuBase_ZDRM(LUDecompositionBase_ZDRM lUDecompositionBase_ZDRM) {
        this.decomp = lUDecompositionBase_ZDRM;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(ZMatrixRMaj zMatrixRMaj) {
        _setA(zMatrixRMaj);
        return this.decomp.decompose(zMatrixRMaj);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        return this.decomp.quality();
    }

    @Override // org.ejml.dense.row.linsol.LinearSolverAbstract_ZDRM, org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(ZMatrixRMaj zMatrixRMaj) {
        double[] dArr_getVV = this.decomp._getVV();
        ZMatrixRMaj lu = this.decomp.getLU();
        if (zMatrixRMaj.numCols != lu.numCols || zMatrixRMaj.numRows != lu.numRows) {
            throw new IllegalArgumentException("Unexpected matrix dimension");
        }
        int i = this.f2664A.numCols;
        double[] dArr = zMatrixRMaj.data;
        int rowStride = zMatrixRMaj.getRowStride();
        for (int i2 = 0; i2 < i; i2++) {
            Arrays.fill(dArr_getVV, 0, i * 2, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            int i3 = i2 * 2;
            dArr_getVV[i3] = 1.0d;
            dArr_getVV[i3 + 1] = 0.0d;
            this.decomp._solveVectorInternal(dArr_getVV);
            int i4 = 0;
            while (i4 < i) {
                int i5 = i4 * 2;
                dArr[i3] = dArr_getVV[i5];
                dArr[i3 + 1] = dArr_getVV[i5 + 1];
                i4++;
                i3 += rowStride;
            }
        }
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public LUDecompositionBase_ZDRM getDecomposition() {
        return this.decomp;
    }
}
