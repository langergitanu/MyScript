package org.ejml.dense.row;

import java.util.Random;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.chol.CholeskyDecompositionInner_DDRM;

/* JADX INFO: loaded from: classes9.dex */
public class CovarianceRandomDraw_DDRM {

    /* JADX INFO: renamed from: A */
    private DMatrixRMaj f2453A;

    /* JADX INFO: renamed from: r */
    private DMatrixRMaj f2454r;
    private Random rand;

    public CovarianceRandomDraw_DDRM(Random random, DMatrixRMaj dMatrixRMaj) {
        this.f2454r = new DMatrixRMaj(dMatrixRMaj.numRows, 1);
        CholeskyDecompositionInner_DDRM choleskyDecompositionInner_DDRM = new CholeskyDecompositionInner_DDRM(true);
        if (!choleskyDecompositionInner_DDRM.decompose(choleskyDecompositionInner_DDRM.inputModified() ? dMatrixRMaj.copy() : dMatrixRMaj)) {
            throw new RuntimeException("Decomposition failed!");
        }
        this.f2453A = choleskyDecompositionInner_DDRM.getT();
        this.rand = random;
    }

    public void next(DMatrixRMaj dMatrixRMaj) {
        for (int i = 0; i < this.f2454r.numRows; i++) {
            this.f2454r.set(i, 0, this.rand.nextGaussian());
        }
        CommonOps_DDRM.multAdd(this.f2453A, this.f2454r, dMatrixRMaj);
    }

    public double computeLikelihoodP() {
        double dExp = 1.0d;
        for (int i = 0; i < this.f2454r.numRows; i++) {
            double d = this.f2454r.get(i, 0);
            dExp *= Math.exp(((-d) * d) / 2.0d);
        }
        return dExp;
    }
}
