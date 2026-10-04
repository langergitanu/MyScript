package org.ejml.dense.row.decomposition.eig;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.NormOps_FDRM;
import org.ejml.dense.row.SpecializedOps_FDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_FDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class EigenPowerMethod_FDRM {

    /* JADX INFO: renamed from: B */
    private FMatrixRMaj f2539B;

    /* JADX INFO: renamed from: q0 */
    private FMatrixRMaj f2540q0;

    /* JADX INFO: renamed from: q1 */
    private FMatrixRMaj f2541q1;

    /* JADX INFO: renamed from: q2 */
    private FMatrixRMaj f2542q2;
    private FMatrixRMaj seed;
    private float tol = UtilEjml.TESTP_F32;
    private int maxIterations = 20;

    public EigenPowerMethod_FDRM(int i) {
        this.f2540q0 = new FMatrixRMaj(i, 1);
        this.f2541q1 = new FMatrixRMaj(i, 1);
        this.f2542q2 = new FMatrixRMaj(i, 1);
        this.f2539B = new FMatrixRMaj(i, i);
    }

    public void setSeed(FMatrixRMaj fMatrixRMaj) {
        this.seed = fMatrixRMaj;
    }

    public void setOptions(int i, float f) {
        this.maxIterations = i;
        this.tol = f;
    }

    public boolean computeDirect(FMatrixRMaj fMatrixRMaj) {
        initPower(fMatrixRMaj);
        boolean zCheckConverged = false;
        for (int i = 0; i < this.maxIterations && !zCheckConverged; i++) {
            CommonOps_FDRM.mult(fMatrixRMaj, this.f2540q0, this.f2541q1);
            CommonOps_FDRM.divide(this.f2541q1, NormOps_FDRM.normPInf(this.f2541q1), this.f2542q2);
            zCheckConverged = checkConverged(fMatrixRMaj);
        }
        return zCheckConverged;
    }

    private void initPower(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be a square matrix.");
        }
        FMatrixRMaj fMatrixRMaj2 = this.seed;
        if (fMatrixRMaj2 != null) {
            this.f2540q0.set((FMatrixD1) fMatrixRMaj2);
            return;
        }
        for (int i = 0; i < fMatrixRMaj.numRows; i++) {
            this.f2540q0.data[i] = 1.0f;
        }
    }

    private boolean checkConverged(FMatrixRMaj fMatrixRMaj) {
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < fMatrixRMaj.numRows; i++) {
            float fAbs = Math.abs(this.f2542q2.data[i] - this.f2540q0.data[i]);
            if (fAbs > f) {
                f = fAbs;
            }
            float fAbs2 = Math.abs(this.f2542q2.data[i] + this.f2540q0.data[i]);
            if (fAbs2 > f2) {
                f2 = fAbs2;
            }
        }
        FMatrixRMaj fMatrixRMaj2 = this.f2540q0;
        this.f2540q0 = this.f2542q2;
        this.f2542q2 = fMatrixRMaj2;
        float f3 = this.tol;
        return f < f3 || f2 < f3;
    }

    public boolean computeShiftDirect(FMatrixRMaj fMatrixRMaj, float f) {
        SpecializedOps_FDRM.addIdentity(fMatrixRMaj, this.f2539B, -f);
        return computeDirect(this.f2539B);
    }

    public boolean computeShiftInvert(FMatrixRMaj fMatrixRMaj, float f) {
        initPower(fMatrixRMaj);
        LinearSolverDense<FMatrixRMaj> linearSolverDenseLinear = LinearSolverFactory_FDRM.linear(fMatrixRMaj.numCols);
        SpecializedOps_FDRM.addIdentity(fMatrixRMaj, this.f2539B, -f);
        linearSolverDenseLinear.setA(this.f2539B);
        boolean zCheckConverged = false;
        for (int i = 0; i < this.maxIterations && !zCheckConverged; i++) {
            linearSolverDenseLinear.solve(this.f2540q0, this.f2541q1);
            CommonOps_FDRM.divide(this.f2541q1, NormOps_FDRM.normPInf(this.f2541q1), this.f2542q2);
            zCheckConverged = checkConverged(fMatrixRMaj);
        }
        return zCheckConverged;
    }

    public FMatrixRMaj getEigenVector() {
        return this.f2540q0;
    }
}
