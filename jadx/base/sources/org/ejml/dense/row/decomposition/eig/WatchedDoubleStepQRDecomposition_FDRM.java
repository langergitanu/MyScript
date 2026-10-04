package org.ejml.dense.row.decomposition.eig;

import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.watched.WatchedDoubleStepQREigenvalue_FDRM;
import org.ejml.dense.row.decomposition.eig.watched.WatchedDoubleStepQREigenvector_FDRM;
import org.ejml.dense.row.decomposition.hessenberg.HessenbergSimilarDecomposition_FDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class WatchedDoubleStepQRDecomposition_FDRM implements EigenDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: H */
    FMatrixRMaj f2548H;
    boolean computeVectors;
    HessenbergSimilarDecomposition_FDRM hessenberg = new HessenbergSimilarDecomposition_FDRM(10);
    WatchedDoubleStepQREigenvalue_FDRM algValue = new WatchedDoubleStepQREigenvalue_FDRM();
    WatchedDoubleStepQREigenvector_FDRM algVector = new WatchedDoubleStepQREigenvector_FDRM();

    public WatchedDoubleStepQRDecomposition_FDRM(boolean z) {
        this.computeVectors = z;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        if (!this.hessenberg.decompose(fMatrixRMaj)) {
            return false;
        }
        this.f2548H = this.hessenberg.getH(null);
        this.algValue.getImplicitQR().createR = false;
        if (!this.algValue.process(this.f2548H)) {
            return false;
        }
        this.algValue.getImplicitQR().createR = true;
        if (this.computeVectors) {
            return this.algVector.process(this.algValue.getImplicitQR(), this.f2548H, this.hessenberg.getQ(null));
        }
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return this.hessenberg.inputModified();
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public int getNumberOfEigenvalues() {
        return this.algValue.getEigenvalues().length;
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition_F32
    public Complex_F32 getEigenvalue(int i) {
        return this.algValue.getEigenvalues()[i];
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public FMatrixRMaj getEigenVector(int i) {
        return this.algVector.getEigenvectors()[i];
    }
}
