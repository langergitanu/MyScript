package org.ejml.dense.row.decomposition.eig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.NormOps_DDRM;
import org.ejml.dense.row.SpecializedOps_DDRM;
import org.ejml.dense.row.factory.LinearSolverFactory_DDRM;
import org.ejml.interfaces.linsol.LinearSolverDense;

/* JADX INFO: loaded from: classes9.dex */
public class EigenPowerMethod_DDRM {

    /* JADX INFO: renamed from: B */
    private DMatrixRMaj f2535B;

    /* JADX INFO: renamed from: q0 */
    private DMatrixRMaj f2536q0;

    /* JADX INFO: renamed from: q1 */
    private DMatrixRMaj f2537q1;

    /* JADX INFO: renamed from: q2 */
    private DMatrixRMaj f2538q2;
    private DMatrixRMaj seed;
    private double tol = UtilEjml.TESTP_F64;
    private int maxIterations = 20;

    public EigenPowerMethod_DDRM(int i) {
        this.f2536q0 = new DMatrixRMaj(i, 1);
        this.f2537q1 = new DMatrixRMaj(i, 1);
        this.f2538q2 = new DMatrixRMaj(i, 1);
        this.f2535B = new DMatrixRMaj(i, i);
    }

    public void setSeed(DMatrixRMaj dMatrixRMaj) {
        this.seed = dMatrixRMaj;
    }

    public void setOptions(int i, double d) {
        this.maxIterations = i;
        this.tol = d;
    }

    public boolean computeDirect(DMatrixRMaj dMatrixRMaj) {
        initPower(dMatrixRMaj);
        boolean zCheckConverged = false;
        for (int i = 0; i < this.maxIterations && !zCheckConverged; i++) {
            CommonOps_DDRM.mult(dMatrixRMaj, this.f2536q0, this.f2537q1);
            CommonOps_DDRM.divide(this.f2537q1, NormOps_DDRM.normPInf(this.f2537q1), this.f2538q2);
            zCheckConverged = checkConverged(dMatrixRMaj);
        }
        return zCheckConverged;
    }

    private void initPower(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("A must be a square matrix.");
        }
        DMatrixRMaj dMatrixRMaj2 = this.seed;
        if (dMatrixRMaj2 != null) {
            this.f2536q0.set((DMatrixD1) dMatrixRMaj2);
            return;
        }
        for (int i = 0; i < dMatrixRMaj.numRows; i++) {
            this.f2536q0.data[i] = 1.0d;
        }
    }

    private boolean checkConverged(DMatrixRMaj dMatrixRMaj) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        for (int i = 0; i < dMatrixRMaj.numRows; i++) {
            double dAbs = Math.abs(this.f2538q2.data[i] - this.f2536q0.data[i]);
            if (dAbs > d) {
                d = dAbs;
            }
            double dAbs2 = Math.abs(this.f2538q2.data[i] + this.f2536q0.data[i]);
            if (dAbs2 > d2) {
                d2 = dAbs2;
            }
        }
        DMatrixRMaj dMatrixRMaj2 = this.f2536q0;
        this.f2536q0 = this.f2538q2;
        this.f2538q2 = dMatrixRMaj2;
        double d3 = this.tol;
        return d < d3 || d2 < d3;
    }

    public boolean computeShiftDirect(DMatrixRMaj dMatrixRMaj, double d) {
        SpecializedOps_DDRM.addIdentity(dMatrixRMaj, this.f2535B, -d);
        return computeDirect(this.f2535B);
    }

    public boolean computeShiftInvert(DMatrixRMaj dMatrixRMaj, double d) {
        initPower(dMatrixRMaj);
        LinearSolverDense<DMatrixRMaj> linearSolverDenseLinear = LinearSolverFactory_DDRM.linear(dMatrixRMaj.numCols);
        SpecializedOps_DDRM.addIdentity(dMatrixRMaj, this.f2535B, -d);
        linearSolverDenseLinear.setA(this.f2535B);
        boolean zCheckConverged = false;
        for (int i = 0; i < this.maxIterations && !zCheckConverged; i++) {
            linearSolverDenseLinear.solve(this.f2536q0, this.f2537q1);
            CommonOps_DDRM.divide(this.f2537q1, NormOps_DDRM.normPInf(this.f2537q1), this.f2538q2);
            zCheckConverged = checkConverged(dMatrixRMaj);
        }
        return zCheckConverged;
    }

    public DMatrixRMaj getEigenVector() {
        return this.f2536q0;
    }
}
