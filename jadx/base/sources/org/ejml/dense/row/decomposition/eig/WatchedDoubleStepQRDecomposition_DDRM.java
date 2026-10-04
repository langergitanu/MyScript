package org.ejml.dense.row.decomposition.eig;

import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.eig.watched.WatchedDoubleStepQREigenvalue_DDRM;
import org.ejml.dense.row.decomposition.eig.watched.WatchedDoubleStepQREigenvector_DDRM;
import org.ejml.dense.row.decomposition.hessenberg.HessenbergSimilarDecomposition_DDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class WatchedDoubleStepQRDecomposition_DDRM implements EigenDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: H */
    DMatrixRMaj f2547H;
    boolean computeVectors;
    HessenbergSimilarDecomposition_DDRM hessenberg = new HessenbergSimilarDecomposition_DDRM(10);
    WatchedDoubleStepQREigenvalue_DDRM algValue = new WatchedDoubleStepQREigenvalue_DDRM();
    WatchedDoubleStepQREigenvector_DDRM algVector = new WatchedDoubleStepQREigenvector_DDRM();

    public WatchedDoubleStepQRDecomposition_DDRM(boolean z) {
        this.computeVectors = z;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        if (!this.hessenberg.decompose(dMatrixRMaj)) {
            return false;
        }
        this.f2547H = this.hessenberg.getH(null);
        this.algValue.getImplicitQR().createR = false;
        if (!this.algValue.process(this.f2547H)) {
            return false;
        }
        this.algValue.getImplicitQR().createR = true;
        if (this.computeVectors) {
            return this.algVector.process(this.algValue.getImplicitQR(), this.f2547H, this.hessenberg.getQ(null));
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

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition_F64
    public Complex_F64 getEigenvalue(int i) {
        return this.algValue.getEigenvalues()[i];
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public DMatrixRMaj getEigenVector(int i) {
        return this.algVector.getEigenvectors()[i];
    }
}
