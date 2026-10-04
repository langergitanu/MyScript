package org.ejml.dense.row.decomposition.eig;

import org.ejml.UtilEjml;
import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.MatrixFeatures_FDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class SwitchingEigenDecomposition_FDRM implements EigenDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: A */
    FMatrixRMaj f2544A;
    boolean computeVectors;
    EigenDecomposition_F32<FMatrixRMaj> generalAlg;
    boolean symmetric;
    EigenDecomposition_F32<FMatrixRMaj> symmetricAlg;
    private float tol;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public SwitchingEigenDecomposition_FDRM(int i, boolean z, float f) {
        this.f2544A = new FMatrixRMaj(1, 1);
        this.symmetricAlg = DecompositionFactory_FDRM.eig(i, z, true);
        this.generalAlg = DecompositionFactory_FDRM.eig(i, z, false);
        this.computeVectors = z;
        this.tol = f;
    }

    public SwitchingEigenDecomposition_FDRM(int i) {
        this(i, true, UtilEjml.TEST_F32);
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public int getNumberOfEigenvalues() {
        return this.symmetric ? this.symmetricAlg.getNumberOfEigenvalues() : this.generalAlg.getNumberOfEigenvalues();
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition_F32
    public Complex_F32 getEigenvalue(int i) {
        return this.symmetric ? this.symmetricAlg.getEigenvalue(i) : this.generalAlg.getEigenvalue(i);
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public FMatrixRMaj getEigenVector(int i) {
        if (this.computeVectors) {
            return this.symmetric ? this.symmetricAlg.getEigenVector(i) : this.generalAlg.getEigenVector(i);
        }
        throw new IllegalArgumentException("Configured to not compute eignevectors");
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        this.f2544A.set((FMatrixD1) fMatrixRMaj);
        boolean zIsSymmetric = MatrixFeatures_FDRM.isSymmetric(this.f2544A, this.tol);
        this.symmetric = zIsSymmetric;
        if (zIsSymmetric) {
            return this.symmetricAlg.decompose(this.f2544A);
        }
        return this.generalAlg.decompose(this.f2544A);
    }
}
