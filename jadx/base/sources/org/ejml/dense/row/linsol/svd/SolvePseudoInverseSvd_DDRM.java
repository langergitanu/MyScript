package org.ejml.dense.row.linsol.svd;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.interfaces.decomposition.SingularValueDecomposition;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F64;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class SolvePseudoInverseSvd_DDRM implements LinearSolverDense<DMatrixRMaj> {
    private DMatrixRMaj U_t;

    /* JADX INFO: renamed from: V */
    private DMatrixRMaj f2753V;
    private DMatrixRMaj pinv;
    private SingularValueDecomposition_F64<DMatrixRMaj> svd;
    private double threshold;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public SolvePseudoInverseSvd_DDRM(int i, int i2) {
        this.pinv = new DMatrixRMaj(1, 1);
        this.threshold = UtilEjml.EPS;
        this.U_t = new DMatrixRMaj(1, 1);
        this.f2753V = new DMatrixRMaj(1, 1);
        this.svd = DecompositionFactory_DDRM.svd(i, i2, true, true, true);
    }

    public SolvePseudoInverseSvd_DDRM() {
        this(100, 100);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(DMatrixRMaj dMatrixRMaj) {
        this.pinv.reshape(dMatrixRMaj.numCols, dMatrixRMaj.numRows, false);
        if (!this.svd.decompose(dMatrixRMaj)) {
            return false;
        }
        this.svd.getU(this.U_t, true);
        this.svd.getV(this.f2753V, false);
        double[] singularValues = this.svd.getSingularValues();
        int iMin = Math.min(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        double d = 0.0d;
        for (int i = 0; i < iMin; i++) {
            double d2 = singularValues[i];
            if (d2 > d) {
                d = d2;
            }
        }
        double dMax = this.threshold * ((double) Math.max(dMatrixRMaj.numCols, dMatrixRMaj.numRows)) * d;
        if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            for (int i2 = 0; i2 < iMin; i2++) {
                double d3 = singularValues[i2];
                if (d3 < dMax) {
                    singularValues[i2] = 0.0d;
                } else {
                    singularValues[i2] = 1.0d / d3;
                }
            }
        }
        for (int i3 = 0; i3 < this.f2753V.numRows; i3++) {
            int i4 = this.f2753V.numCols * i3;
            int i5 = 0;
            while (i5 < this.f2753V.numCols) {
                double[] dArr = this.f2753V.data;
                dArr[i4] = dArr[i4] * singularValues[i5];
                i5++;
                i4++;
            }
        }
        CommonOps_DDRM.mult(this.f2753V, this.U_t, this.pinv);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        throw new IllegalArgumentException("Not supported by this solver.");
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(DMatrixRMaj dMatrixRMaj, DMatrixRMaj dMatrixRMaj2) {
        CommonOps_DDRM.mult(this.pinv, dMatrixRMaj, dMatrixRMaj2);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(DMatrixRMaj dMatrixRMaj) {
        dMatrixRMaj.set((DMatrixD1) this.pinv);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.svd.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public SingularValueDecomposition<DMatrixRMaj> getDecomposition() {
        return this.svd;
    }

    public void setThreshold(double d) {
        this.threshold = d;
    }

    public SingularValueDecomposition<DMatrixRMaj> getDecomposer() {
        return this.svd;
    }
}
