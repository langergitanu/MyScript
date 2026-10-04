package org.ejml.dense.row;

import java.util.Random;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionInner_FDRM;

/* JADX INFO: loaded from: classes9.dex */
public class CovarianceRandomDraw_FDRM {

    /* JADX INFO: renamed from: A */
    private FMatrixRMaj f2455A;

    /* JADX INFO: renamed from: r */
    private FMatrixRMaj f2456r;
    private Random rand;

    public CovarianceRandomDraw_FDRM(Random random, FMatrixRMaj fMatrixRMaj) {
        this.f2456r = new FMatrixRMaj(fMatrixRMaj.numRows, 1);
        CholeskyDecompositionInner_FDRM choleskyDecompositionInner_FDRM = new CholeskyDecompositionInner_FDRM(true);
        if (!choleskyDecompositionInner_FDRM.decompose(choleskyDecompositionInner_FDRM.inputModified() ? fMatrixRMaj.copy() : fMatrixRMaj)) {
            throw new RuntimeException("Decomposition failed!");
        }
        this.f2455A = choleskyDecompositionInner_FDRM.getT();
        this.rand = random;
    }

    public void next(FMatrixRMaj fMatrixRMaj) {
        for (int i = 0; i < this.f2456r.numRows; i++) {
            this.f2456r.set(i, 0, (float) this.rand.nextGaussian());
        }
        CommonOps_FDRM.multAdd(this.f2455A, this.f2456r, fMatrixRMaj);
    }

    public float computeLikelihoodP() {
        float fExp = 1.0f;
        for (int i = 0; i < this.f2456r.numRows; i++) {
            float f = this.f2456r.get(i, 0);
            fExp *= (float) Math.exp(((-f) * f) / 2.0f);
        }
        return fExp;
    }
}
