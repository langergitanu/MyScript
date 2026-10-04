package org.ejml.dense.row.decomposition.svd;

import org.ejml.data.FMatrixD1;
import org.ejml.data.FMatrixRMaj;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class SafeSvd_FDRM implements SingularValueDecomposition_F32<FMatrixRMaj> {
    SingularValueDecomposition_F32<FMatrixRMaj> alg;
    FMatrixRMaj work = new FMatrixRMaj(1, 1);

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public SafeSvd_FDRM(SingularValueDecomposition_F32<FMatrixRMaj> singularValueDecomposition_F32) {
        this.alg = singularValueDecomposition_F32;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition_F32
    public float[] getSingularValues() {
        return this.alg.getSingularValues();
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public int numberOfSingularValues() {
        return this.alg.numberOfSingularValues();
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public boolean isCompact() {
        return this.alg.isCompact();
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public FMatrixRMaj getU(FMatrixRMaj fMatrixRMaj, boolean z) {
        return this.alg.getU(fMatrixRMaj, z);
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public FMatrixRMaj getV(FMatrixRMaj fMatrixRMaj, boolean z) {
        return this.alg.getV(fMatrixRMaj, z);
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public FMatrixRMaj getW(FMatrixRMaj fMatrixRMaj) {
        return this.alg.getW(fMatrixRMaj);
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public int numRows() {
        return this.alg.numRows();
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public int numCols() {
        return this.alg.numCols();
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        if (this.alg.inputModified()) {
            this.work.reshape(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
            this.work.set((FMatrixD1) fMatrixRMaj);
            return this.alg.decompose(this.work);
        }
        return this.alg.decompose(fMatrixRMaj);
    }
}
