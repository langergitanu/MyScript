package org.ejml.dense.row.decomposition.svd;

import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class SafeSvd_DDRM implements SingularValueDecomposition_F64<DMatrixRMaj> {
    SingularValueDecomposition_F64<DMatrixRMaj> alg;
    DMatrixRMaj work = new DMatrixRMaj(1, 1);

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public SafeSvd_DDRM(SingularValueDecomposition_F64<DMatrixRMaj> singularValueDecomposition_F64) {
        this.alg = singularValueDecomposition_F64;
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition_F64
    public double[] getSingularValues() {
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
    public DMatrixRMaj getU(DMatrixRMaj dMatrixRMaj, boolean z) {
        return this.alg.getU(dMatrixRMaj, z);
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public DMatrixRMaj getV(DMatrixRMaj dMatrixRMaj, boolean z) {
        return this.alg.getV(dMatrixRMaj, z);
    }

    @Override // org.ejml.interfaces.decomposition.SingularValueDecomposition
    public DMatrixRMaj getW(DMatrixRMaj dMatrixRMaj) {
        return this.alg.getW(dMatrixRMaj);
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
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        if (this.alg.inputModified()) {
            this.work.reshape(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
            this.work.set((DMatrixD1) dMatrixRMaj);
            return this.alg.decompose(this.work);
        }
        return this.alg.decompose(dMatrixRMaj);
    }
}
