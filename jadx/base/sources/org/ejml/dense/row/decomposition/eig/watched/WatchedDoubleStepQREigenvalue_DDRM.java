package org.ejml.dense.row.decomposition.eig.watched;

import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.EigenvalueExtractor_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class WatchedDoubleStepQREigenvalue_DDRM implements EigenvalueExtractor_DDRM {
    WatchedDoubleStepQREigen_DDRM implicitQR = new WatchedDoubleStepQREigen_DDRM();
    int numSplits;
    int[] splits;

    /* JADX INFO: renamed from: x1 */
    int f2577x1;

    /* JADX INFO: renamed from: x2 */
    int f2578x2;

    public void setup(DMatrixRMaj dMatrixRMaj) {
        this.implicitQR.setup(dMatrixRMaj);
        this.implicitQR.setQ(null);
        this.splits = new int[dMatrixRMaj.numRows];
        this.numSplits = 0;
    }

    @Override // org.ejml.dense.row.decomposition.eig.EigenvalueExtractor_DDRM
    public boolean process(DMatrixRMaj dMatrixRMaj) {
        setup(dMatrixRMaj);
        this.f2577x1 = 0;
        this.f2578x2 = dMatrixRMaj.numRows - 1;
        while (this.implicitQR.numEigen < dMatrixRMaj.numRows) {
            if (this.implicitQR.steps > this.implicitQR.maxIterations) {
                return false;
            }
            this.implicitQR.incrementSteps();
            int i = this.f2578x2;
            int i2 = this.f2577x1;
            if (i < i2) {
                moveToNextSplit();
            } else if (i - i2 == 0) {
                this.implicitQR.addEigenAt(i2);
                this.f2578x2--;
            } else if (i - i2 == 1) {
                this.implicitQR.addComputedEigen2x2(i2, i);
                this.f2578x2 -= 2;
            } else if (this.implicitQR.steps - this.implicitQR.lastExceptional > this.implicitQR.exceptionalThreshold) {
                DMatrixRMaj dMatrixRMaj2 = this.implicitQR.f2569A;
                int i3 = this.f2578x2;
                if (Double.isNaN(dMatrixRMaj2.get(i3, i3))) {
                    return false;
                }
                this.implicitQR.exceptionalShift(this.f2577x1, this.f2578x2);
            } else {
                WatchedDoubleStepQREigen_DDRM watchedDoubleStepQREigen_DDRM = this.implicitQR;
                int i4 = this.f2578x2;
                if (watchedDoubleStepQREigen_DDRM.isZero(i4, i4 - 1)) {
                    this.implicitQR.addEigenAt(this.f2578x2);
                    this.f2578x2--;
                } else {
                    performIteration();
                }
            }
        }
        return true;
    }

    private void moveToNextSplit() {
        int i = this.numSplits;
        if (i <= 0) {
            throw new RuntimeException("bad");
        }
        int[] iArr = this.splits;
        int i2 = i - 1;
        this.numSplits = i2;
        this.f2578x2 = iArr[i2];
        if (i2 > 0) {
            this.f2577x1 = iArr[i - 2] + 1;
        } else {
            this.f2577x1 = 0;
        }
    }

    private void performIteration() {
        int i = this.f2578x2;
        while (true) {
            int i2 = this.f2577x1;
            if (i > i2) {
                int i3 = i - 1;
                if (this.implicitQR.isZero(i, i3)) {
                    this.f2577x1 = i;
                    int[] iArr = this.splits;
                    int i4 = this.numSplits;
                    this.numSplits = i4 + 1;
                    iArr[i4] = i3;
                    return;
                }
                i--;
            } else {
                this.implicitQR.implicitDoubleStep(i2, this.f2578x2);
                return;
            }
        }
    }

    @Override // org.ejml.dense.row.decomposition.eig.EigenvalueExtractor_DDRM
    public int getNumberOfEigenvalues() {
        return this.implicitQR.getNumberOfEigenvalues();
    }

    @Override // org.ejml.dense.row.decomposition.eig.EigenvalueExtractor_DDRM
    public Complex_F64[] getEigenvalues() {
        return this.implicitQR.getEigenvalues();
    }

    public WatchedDoubleStepQREigen_DDRM getImplicitQR() {
        return this.implicitQR;
    }
}
