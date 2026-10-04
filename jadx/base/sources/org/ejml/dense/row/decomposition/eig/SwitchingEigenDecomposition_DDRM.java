package org.ejml.dense.row.decomposition.eig;

import org.ejml.UtilEjml;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.MatrixFeatures_DDRM;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class SwitchingEigenDecomposition_DDRM implements EigenDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: A */
    DMatrixRMaj f2543A;
    boolean computeVectors;
    EigenDecomposition_F64<DMatrixRMaj> generalAlg;
    boolean symmetric;
    EigenDecomposition_F64<DMatrixRMaj> symmetricAlg;
    private double tol;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public SwitchingEigenDecomposition_DDRM(int i, boolean z, double d) {
        this.f2543A = new DMatrixRMaj(1, 1);
        this.symmetricAlg = DecompositionFactory_DDRM.eig(i, z, true);
        this.generalAlg = DecompositionFactory_DDRM.eig(i, z, false);
        this.computeVectors = z;
        this.tol = d;
    }

    public SwitchingEigenDecomposition_DDRM(int i) {
        this(i, true, UtilEjml.TEST_F64);
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public int getNumberOfEigenvalues() {
        return this.symmetric ? this.symmetricAlg.getNumberOfEigenvalues() : this.generalAlg.getNumberOfEigenvalues();
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition_F64
    public Complex_F64 getEigenvalue(int i) {
        return this.symmetric ? this.symmetricAlg.getEigenvalue(i) : this.generalAlg.getEigenvalue(i);
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public DMatrixRMaj getEigenVector(int i) {
        if (this.computeVectors) {
            return this.symmetric ? this.symmetricAlg.getEigenVector(i) : this.generalAlg.getEigenVector(i);
        }
        throw new IllegalArgumentException("Configured to not compute eignevectors");
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        this.f2543A.set((DMatrixD1) dMatrixRMaj);
        boolean zIsSymmetric = MatrixFeatures_DDRM.isSymmetric(this.f2543A, this.tol);
        this.symmetric = zIsSymmetric;
        if (zIsSymmetric) {
            return this.symmetricAlg.decompose(this.f2543A);
        }
        return this.generalAlg.decompose(this.f2543A);
    }
}
