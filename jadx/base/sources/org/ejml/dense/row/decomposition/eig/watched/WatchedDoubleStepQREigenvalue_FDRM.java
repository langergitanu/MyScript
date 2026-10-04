package org.ejml.dense.row.decomposition.eig.watched;

import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.EigenvalueExtractor_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class WatchedDoubleStepQREigenvalue_FDRM implements EigenvalueExtractor_FDRM {
    WatchedDoubleStepQREigen_FDRM implicitQR = new WatchedDoubleStepQREigen_FDRM();
    int numSplits;
    int[] splits;

    /* JADX INFO: renamed from: x1 */
    int f2579x1;

    /* JADX INFO: renamed from: x2 */
    int f2580x2;

    public void setup(FMatrixRMaj fMatrixRMaj) {
        this.implicitQR.setup(fMatrixRMaj);
        this.implicitQR.setQ(null);
        this.splits = new int[fMatrixRMaj.numRows];
        this.numSplits = 0;
    }

    @Override // org.ejml.dense.row.decomposition.eig.EigenvalueExtractor_FDRM
    public boolean process(FMatrixRMaj fMatrixRMaj) {
        setup(fMatrixRMaj);
        this.f2579x1 = 0;
        this.f2580x2 = fMatrixRMaj.numRows - 1;
        while (this.implicitQR.numEigen < fMatrixRMaj.numRows) {
            if (this.implicitQR.steps > this.implicitQR.maxIterations) {
                return false;
            }
            this.implicitQR.incrementSteps();
            int i = this.f2580x2;
            int i2 = this.f2579x1;
            if (i < i2) {
                moveToNextSplit();
            } else if (i - i2 == 0) {
                this.implicitQR.addEigenAt(i2);
                this.f2580x2--;
            } else if (i - i2 == 1) {
                this.implicitQR.addComputedEigen2x2(i2, i);
                this.f2580x2 -= 2;
            } else if (this.implicitQR.steps - this.implicitQR.lastExceptional > this.implicitQR.exceptionalThreshold) {
                FMatrixRMaj fMatrixRMaj2 = this.implicitQR.f2573A;
                int i3 = this.f2580x2;
                if (Float.isNaN(fMatrixRMaj2.get(i3, i3))) {
                    return false;
                }
                this.implicitQR.exceptionalShift(this.f2579x1, this.f2580x2);
            } else {
                WatchedDoubleStepQREigen_FDRM watchedDoubleStepQREigen_FDRM = this.implicitQR;
                int i4 = this.f2580x2;
                if (watchedDoubleStepQREigen_FDRM.isZero(i4, i4 - 1)) {
                    this.implicitQR.addEigenAt(this.f2580x2);
                    this.f2580x2--;
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
        this.f2580x2 = iArr[i2];
        if (i2 > 0) {
            this.f2579x1 = iArr[i - 2] + 1;
        } else {
            this.f2579x1 = 0;
        }
    }

    private void performIteration() {
        int i = this.f2580x2;
        while (true) {
            int i2 = this.f2579x1;
            if (i > i2) {
                int i3 = i - 1;
                if (this.implicitQR.isZero(i, i3)) {
                    this.f2579x1 = i;
                    int[] iArr = this.splits;
                    int i4 = this.numSplits;
                    this.numSplits = i4 + 1;
                    iArr[i4] = i3;
                    return;
                }
                i--;
            } else {
                this.implicitQR.implicitDoubleStep(i2, this.f2580x2);
                return;
            }
        }
    }

    @Override // org.ejml.dense.row.decomposition.eig.EigenvalueExtractor_FDRM
    public int getNumberOfEigenvalues() {
        return this.implicitQR.getNumberOfEigenvalues();
    }

    @Override // org.ejml.dense.row.decomposition.eig.EigenvalueExtractor_FDRM
    public Complex_F32[] getEigenvalues() {
        return this.implicitQR.getEigenvalues();
    }

    public WatchedDoubleStepQREigen_FDRM getImplicitQR() {
        return this.implicitQR;
    }
}
