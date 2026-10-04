package org.ejml.dense.row.decomposition.eig.symm;

import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class SymmetricQrAlgorithm_DDRM {

    /* JADX INFO: renamed from: Q */
    private DMatrixRMaj f2567Q;
    private double[] eigenvalues;
    private int exceptionalThresh;
    private boolean fastEigenvalues;
    private boolean followingScript;
    private SymmetricQREigenHelper_DDRM helper;
    private int maxIterations;

    public SymmetricQrAlgorithm_DDRM(SymmetricQREigenHelper_DDRM symmetricQREigenHelper_DDRM) {
        this.exceptionalThresh = 15;
        this.maxIterations = 15 * 15;
        this.helper = symmetricQREigenHelper_DDRM;
    }

    public SymmetricQrAlgorithm_DDRM() {
        this.exceptionalThresh = 15;
        this.maxIterations = 15 * 15;
        this.helper = new SymmetricQREigenHelper_DDRM();
    }

    public void setMaxIterations(int i) {
        this.maxIterations = i;
    }

    public DMatrixRMaj getQ() {
        return this.f2567Q;
    }

    public void setQ(DMatrixRMaj dMatrixRMaj) {
        this.f2567Q = dMatrixRMaj;
    }

    public void setFastEigenvalues(boolean z) {
        this.fastEigenvalues = z;
    }

    public double getEigenvalue(int i) {
        return this.helper.diag[i];
    }

    public int getNumberOfEigenvalues() {
        return this.helper.f2549N;
    }

    public boolean process(int i, double[] dArr, double[] dArr2, double[] dArr3) {
        if (dArr != null) {
            this.helper.init(dArr, dArr2, i);
        }
        if (this.f2567Q == null) {
            this.f2567Q = CommonOps_DDRM.identity(this.helper.f2549N);
        }
        this.helper.setQ(this.f2567Q);
        this.followingScript = true;
        this.eigenvalues = dArr3;
        this.fastEigenvalues = false;
        return _process();
    }

    public boolean process(int i, double[] dArr, double[] dArr2) {
        if (dArr != null) {
            this.helper.init(dArr, dArr2, i);
        }
        this.followingScript = false;
        this.eigenvalues = null;
        return _process();
    }

    private boolean _process() {
        while (this.helper.f2557x2 >= 0) {
            if (this.helper.steps > this.maxIterations) {
                return false;
            }
            if (this.helper.f2556x1 == this.helper.f2557x2) {
                this.helper.resetSteps();
                if (!this.helper.nextSplit()) {
                    break;
                }
            } else if (this.fastEigenvalues && this.helper.f2557x2 - this.helper.f2556x1 == 1) {
                this.helper.resetSteps();
                SymmetricQREigenHelper_DDRM symmetricQREigenHelper_DDRM = this.helper;
                symmetricQREigenHelper_DDRM.eigenvalue2by2(symmetricQREigenHelper_DDRM.f2556x1);
                SymmetricQREigenHelper_DDRM symmetricQREigenHelper_DDRM2 = this.helper;
                symmetricQREigenHelper_DDRM2.setSubmatrix(symmetricQREigenHelper_DDRM2.f2557x2, this.helper.f2557x2);
            } else if (this.helper.steps - this.helper.lastExceptional > this.exceptionalThresh) {
                this.helper.exceptionalShift();
            } else {
                performStep();
            }
            this.helper.incrementSteps();
        }
        return true;
    }

    public void performStep() {
        double dComputeShift;
        int i = this.helper.f2557x2;
        do {
            i--;
            if (i < this.helper.f2556x1) {
                if (this.followingScript) {
                    if (this.helper.steps > 10) {
                        this.followingScript = false;
                        return;
                    }
                    dComputeShift = this.eigenvalues[this.helper.f2557x2];
                } else {
                    dComputeShift = this.helper.computeShift();
                }
                this.helper.performImplicitSingleStep(dComputeShift, false);
                return;
            }
        } while (!this.helper.isZero(i));
        int[] iArr = this.helper.splits;
        SymmetricQREigenHelper_DDRM symmetricQREigenHelper_DDRM = this.helper;
        int i2 = symmetricQREigenHelper_DDRM.numSplits;
        symmetricQREigenHelper_DDRM.numSplits = i2 + 1;
        iArr[i2] = i;
        this.helper.f2556x1 = i + 1;
    }
}
