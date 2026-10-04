package org.ejml.dense.row.decomposition.eig;

import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.CommonOps_FDRM;
import org.ejml.dense.row.decomposition.eig.symm.SymmetricQREigenHelper_FDRM;
import org.ejml.dense.row.decomposition.eig.symm.SymmetricQrAlgorithm_FDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F32;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public class SymmetricQRAlgorithmDecomposition_FDRM implements EigenDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: V */
    private FMatrixRMaj f2546V;
    boolean computeVectors;
    private boolean computeVectorsWithValues;
    private TridiagonalSimilarDecomposition_F32<FMatrixRMaj> decomp;
    private float[] diag;
    private float[] diagSaved;
    private FMatrixRMaj[] eigenvectors;
    private SymmetricQREigenHelper_FDRM helper;
    private float[] off;
    private float[] offSaved;
    private float[] values;
    private SymmetricQrAlgorithm_FDRM vector;

    public SymmetricQRAlgorithmDecomposition_FDRM(TridiagonalSimilarDecomposition_F32<FMatrixRMaj> tridiagonalSimilarDecomposition_F32, boolean z) {
        this.computeVectorsWithValues = false;
        this.decomp = tridiagonalSimilarDecomposition_F32;
        this.computeVectors = z;
        this.helper = new SymmetricQREigenHelper_FDRM();
        this.vector = new SymmetricQrAlgorithm_FDRM(this.helper);
    }

    public SymmetricQRAlgorithmDecomposition_FDRM(boolean z) {
        this(DecompositionFactory_FDRM.tridiagonal(0), z);
    }

    public void setComputeVectorsWithValues(boolean z) {
        if (!this.computeVectors) {
            throw new IllegalArgumentException("Compute eigenvalues has been set to false");
        }
        this.computeVectorsWithValues = z;
    }

    public void setMaxIterations(int i) {
        this.vector.setMaxIterations(i);
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public int getNumberOfEigenvalues() {
        return this.helper.getMatrixSize();
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition_F32
    public Complex_F32 getEigenvalue(int i) {
        return new Complex_F32(this.values[i], 0.0f);
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public FMatrixRMaj getEigenVector(int i) {
        return this.eigenvectors[i];
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numCols != fMatrixRMaj.numRows) {
            throw new IllegalArgumentException("Matrix must be square.");
        }
        if (fMatrixRMaj.numCols <= 0) {
            return false;
        }
        int i = fMatrixRMaj.numRows;
        if (!this.decomp.decompose(fMatrixRMaj)) {
            return false;
        }
        float[] fArr = this.diag;
        if (fArr == null || fArr.length < i) {
            this.diag = new float[i];
            this.off = new float[i - 1];
        }
        this.decomp.getDiagonal(this.diag, this.off);
        this.helper.init(this.diag, this.off, i);
        if (this.computeVectors) {
            if (this.computeVectorsWithValues) {
                return extractTogether();
            }
            return extractSeparate(i);
        }
        return computeEigenValues();
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return this.decomp.inputModified();
    }

    private boolean extractTogether() {
        FMatrixRMaj q = this.decomp.getQ(this.f2546V, true);
        this.f2546V = q;
        this.helper.setQ(q);
        this.vector.setFastEigenvalues(false);
        if (!this.vector.process(-1, null, null)) {
            return false;
        }
        this.eigenvectors = CommonOps_FDRM.rowsToVector(this.f2546V, this.eigenvectors);
        this.values = this.helper.copyEigenvalues(this.values);
        return true;
    }

    private boolean extractSeparate(int i) {
        if (!computeEigenValues()) {
            return false;
        }
        this.helper.reset(i);
        this.diagSaved = this.helper.swapDiag(this.diagSaved);
        this.offSaved = this.helper.swapOff(this.offSaved);
        FMatrixRMaj q = this.decomp.getQ(this.f2546V, true);
        this.f2546V = q;
        this.vector.setQ(q);
        if (!this.vector.process(-1, null, null, this.values)) {
            return false;
        }
        this.values = this.helper.copyEigenvalues(this.values);
        this.eigenvectors = CommonOps_FDRM.rowsToVector(this.f2546V, this.eigenvectors);
        return true;
    }

    private boolean computeEigenValues() {
        this.diagSaved = this.helper.copyDiag(this.diagSaved);
        this.offSaved = this.helper.copyOff(this.offSaved);
        this.vector.setQ(null);
        this.vector.setFastEigenvalues(true);
        if (!this.vector.process(-1, null, null)) {
            return false;
        }
        this.values = this.helper.copyEigenvalues(this.values);
        return true;
    }
}
