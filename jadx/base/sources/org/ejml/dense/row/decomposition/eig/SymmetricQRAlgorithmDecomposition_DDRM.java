package org.ejml.dense.row.decomposition.eig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.dense.row.decomposition.eig.symm.SymmetricQREigenHelper_DDRM;
import org.ejml.dense.row.decomposition.eig.symm.SymmetricQrAlgorithm_DDRM;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;
import org.ejml.interfaces.decomposition.TridiagonalSimilarDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class SymmetricQRAlgorithmDecomposition_DDRM implements EigenDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: V */
    private DMatrixRMaj f2545V;
    boolean computeVectors;
    private boolean computeVectorsWithValues;
    private TridiagonalSimilarDecomposition_F64<DMatrixRMaj> decomp;
    private double[] diag;
    private double[] diagSaved;
    private DMatrixRMaj[] eigenvectors;
    private SymmetricQREigenHelper_DDRM helper;
    private double[] off;
    private double[] offSaved;
    private double[] values;
    private SymmetricQrAlgorithm_DDRM vector;

    public SymmetricQRAlgorithmDecomposition_DDRM(TridiagonalSimilarDecomposition_F64<DMatrixRMaj> tridiagonalSimilarDecomposition_F64, boolean z) {
        this.computeVectorsWithValues = false;
        this.decomp = tridiagonalSimilarDecomposition_F64;
        this.computeVectors = z;
        this.helper = new SymmetricQREigenHelper_DDRM();
        this.vector = new SymmetricQrAlgorithm_DDRM(this.helper);
    }

    public SymmetricQRAlgorithmDecomposition_DDRM(boolean z) {
        this(DecompositionFactory_DDRM.tridiagonal(0), z);
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

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition_F64
    public Complex_F64 getEigenvalue(int i) {
        return new Complex_F64(this.values[i], FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    @Override // org.ejml.interfaces.decomposition.EigenDecomposition
    public DMatrixRMaj getEigenVector(int i) {
        return this.eigenvectors[i];
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numCols != dMatrixRMaj.numRows) {
            throw new IllegalArgumentException("Matrix must be square.");
        }
        if (dMatrixRMaj.numCols <= 0) {
            return false;
        }
        int i = dMatrixRMaj.numRows;
        if (!this.decomp.decompose(dMatrixRMaj)) {
            return false;
        }
        double[] dArr = this.diag;
        if (dArr == null || dArr.length < i) {
            this.diag = new double[i];
            this.off = new double[i - 1];
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
        DMatrixRMaj q = this.decomp.getQ(this.f2545V, true);
        this.f2545V = q;
        this.helper.setQ(q);
        this.vector.setFastEigenvalues(false);
        if (!this.vector.process(-1, null, null)) {
            return false;
        }
        this.eigenvectors = CommonOps_DDRM.rowsToVector(this.f2545V, this.eigenvectors);
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
        DMatrixRMaj q = this.decomp.getQ(this.f2545V, true);
        this.f2545V = q;
        this.vector.setQ(q);
        if (!this.vector.process(-1, null, null, this.values)) {
            return false;
        }
        this.values = this.helper.copyEigenvalues(this.values);
        this.eigenvectors = CommonOps_DDRM.rowsToVector(this.f2545V, this.eigenvectors);
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
