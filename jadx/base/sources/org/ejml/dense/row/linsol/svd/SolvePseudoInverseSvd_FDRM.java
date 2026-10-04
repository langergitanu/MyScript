package org.ejml.dense.row.linsol.svd;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.interfaces.decomposition.SingularValueDecomposition;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class SolvePseudoInverseSvd_FDRM implements LinearSolverDense<FMatrixRMaj> {
    private FMatrixRMaj U_t;

    /* JADX INFO: renamed from: V */
    private FMatrixRMaj f2754V;
    private FMatrixRMaj pinv;
    private SingularValueDecomposition_F32<FMatrixRMaj> svd;
    private float threshold;

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesB() {
        return false;
    }

    public SolvePseudoInverseSvd_FDRM(int i, int i2) {
        this.pinv = new FMatrixRMaj(1, 1);
        this.threshold = UtilEjml.F_EPS;
        this.U_t = new FMatrixRMaj(1, 1);
        this.f2754V = new FMatrixRMaj(1, 1);
        this.svd = DecompositionFactory_FDRM.svd(i, i2, true, true, true);
    }

    public SolvePseudoInverseSvd_FDRM() {
        this(100, 100);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean setA(FMatrixRMaj fMatrixRMaj) {
        this.pinv.reshape(fMatrixRMaj.numCols, fMatrixRMaj.numRows, false);
        if (!this.svd.decompose(fMatrixRMaj)) {
            return false;
        }
        this.svd.getU(this.U_t, true);
        this.svd.getV(this.f2754V, false);
        float[] singularValues = this.svd.getSingularValues();
        int iMin = Math.min(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        float f = 0.0f;
        for (int i = 0; i < iMin; i++) {
            float f2 = singularValues[i];
            if (f2 > f) {
                f = f2;
            }
        }
        float fMax = this.threshold * Math.max(fMatrixRMaj.numCols, fMatrixRMaj.numRows) * f;
        if (f != 0.0f) {
            for (int i2 = 0; i2 < iMin; i2++) {
                float f3 = singularValues[i2];
                if (f3 < fMax) {
                    singularValues[i2] = 0.0f;
                } else {
                    singularValues[i2] = 1.0f / f3;
                }
            }
        }
        for (int i3 = 0; i3 < this.f2754V.numRows; i3++) {
            int i4 = this.f2754V.numCols * i3;
            int i5 = 0;
            while (i5 < this.f2754V.numCols) {
                float[] fArr = this.f2754V.data;
                fArr[i4] = fArr[i4] * singularValues[i5];
                i5++;
                i4++;
            }
        }
        CommonOps_FDRM.mult(this.f2754V, this.U_t, this.pinv);
        return true;
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public double quality() {
        throw new IllegalArgumentException("Not supported by this solver.");
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public void solve(FMatrixRMaj fMatrixRMaj, FMatrixRMaj fMatrixRMaj2) {
        CommonOps_FDRM.mult(this.pinv, fMatrixRMaj, fMatrixRMaj2);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolverDense
    public void invert(FMatrixRMaj fMatrixRMaj) {
        fMatrixRMaj.set((FMatrixD1) this.pinv);
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public boolean modifiesA() {
        return this.svd.inputModified();
    }

    @Override // org.ejml.interfaces.linsol.LinearSolver
    public SingularValueDecomposition<FMatrixRMaj> getDecomposition() {
        return this.svd;
    }

    public void setThreshold(float f) {
        this.threshold = f;
    }

    public SingularValueDecomposition<FMatrixRMaj> getDecomposer() {
        return this.svd;
    }
}
