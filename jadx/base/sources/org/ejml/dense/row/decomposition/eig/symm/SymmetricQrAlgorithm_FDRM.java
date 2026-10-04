package org.ejml.dense.row.decomposition.eig.symm;

import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class SymmetricQrAlgorithm_FDRM {

    /* JADX INFO: renamed from: Q */
    private FMatrixRMaj f2568Q;
    private float[] eigenvalues;
    private int exceptionalThresh;
    private boolean fastEigenvalues;
    private boolean followingScript;
    private SymmetricQREigenHelper_FDRM helper;
    private int maxIterations;

    public SymmetricQrAlgorithm_FDRM(SymmetricQREigenHelper_FDRM symmetricQREigenHelper_FDRM) {
        this.exceptionalThresh = 15;
        this.maxIterations = 15 * 15;
        this.helper = symmetricQREigenHelper_FDRM;
    }

    public SymmetricQrAlgorithm_FDRM() {
        this.exceptionalThresh = 15;
        this.maxIterations = 15 * 15;
        this.helper = new SymmetricQREigenHelper_FDRM();
    }

    public void setMaxIterations(int i) {
        this.maxIterations = i;
    }

    public FMatrixRMaj getQ() {
        return this.f2568Q;
    }

    public void setQ(FMatrixRMaj fMatrixRMaj) {
        this.f2568Q = fMatrixRMaj;
    }

    public void setFastEigenvalues(boolean z) {
        this.fastEigenvalues = z;
    }

    public float getEigenvalue(int i) {
        return this.helper.diag[i];
    }

    public int getNumberOfEigenvalues() {
        return this.helper.f2558N;
    }

    public boolean process(int i, float[] fArr, float[] fArr2, float[] fArr3) {
        if (fArr != null) {
            this.helper.init(fArr, fArr2, i);
        }
        if (this.f2568Q == null) {
            this.f2568Q = CommonOps_FDRM.identity(this.helper.f2558N);
        }
        this.helper.setQ(this.f2568Q);
        this.followingScript = true;
        this.eigenvalues = fArr3;
        this.fastEigenvalues = false;
        return _process();
    }

    public boolean process(int i, float[] fArr, float[] fArr2) {
        if (fArr != null) {
            this.helper.init(fArr, fArr2, i);
        }
        this.followingScript = false;
        this.eigenvalues = null;
        return _process();
    }

    private boolean _process() {
        while (this.helper.f2566x2 >= 0) {
            if (this.helper.steps > this.maxIterations) {
                return false;
            }
            if (this.helper.f2565x1 == this.helper.f2566x2) {
                this.helper.resetSteps();
                if (!this.helper.nextSplit()) {
                    break;
                }
            } else if (this.fastEigenvalues && this.helper.f2566x2 - this.helper.f2565x1 == 1) {
                this.helper.resetSteps();
                SymmetricQREigenHelper_FDRM symmetricQREigenHelper_FDRM = this.helper;
                symmetricQREigenHelper_FDRM.eigenvalue2by2(symmetricQREigenHelper_FDRM.f2565x1);
                SymmetricQREigenHelper_FDRM symmetricQREigenHelper_FDRM2 = this.helper;
                symmetricQREigenHelper_FDRM2.setSubmatrix(symmetricQREigenHelper_FDRM2.f2566x2, this.helper.f2566x2);
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
        float fComputeShift;
        int i = this.helper.f2566x2;
        do {
            i--;
            if (i < this.helper.f2565x1) {
                if (this.followingScript) {
                    if (this.helper.steps > 10) {
                        this.followingScript = false;
                        return;
                    }
                    fComputeShift = this.eigenvalues[this.helper.f2566x2];
                } else {
                    fComputeShift = this.helper.computeShift();
                }
                this.helper.performImplicitSingleStep(fComputeShift, false);
                return;
            }
        } while (!this.helper.isZero(i));
        int[] iArr = this.helper.splits;
        SymmetricQREigenHelper_FDRM symmetricQREigenHelper_FDRM = this.helper;
        int i2 = symmetricQREigenHelper_FDRM.numSplits;
        symmetricQREigenHelper_FDRM.numSplits = i2 + 1;
        iArr[i2] = i;
        this.helper.f2565x1 = i + 1;
    }
}
