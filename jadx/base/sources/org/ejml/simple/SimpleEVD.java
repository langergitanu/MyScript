package org.ejml.simple;

import java.util.ArrayList;
import java.util.List;
import org.ejml.data.Complex_F32;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.interfaces.decomposition.EigenDecomposition;
import org.ejml.interfaces.decomposition.EigenDecomposition_F32;
import org.ejml.interfaces.decomposition.EigenDecomposition_F64;
import org.ejml.simple.SimpleBase;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleEVD<T extends SimpleBase> {
    private EigenDecomposition eig;
    boolean is64;
    Matrix mat;

    public SimpleEVD(Matrix matrix) {
        this.mat = matrix;
        boolean z = matrix instanceof DMatrixRMaj;
        this.is64 = z;
        if (z) {
            this.eig = DecompositionFactory_DDRM.eig(matrix.getNumCols(), true);
        } else {
            this.eig = DecompositionFactory_FDRM.eig(matrix.getNumCols(), true);
        }
        if (!this.eig.decompose(matrix)) {
            throw new RuntimeException("Eigenvalue Decomposition failed");
        }
    }

    public List<Complex_F64> getEigenvalues() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.is64) {
            EigenDecomposition_F64 eigenDecomposition_F64 = (EigenDecomposition_F64) this.eig;
            while (i < this.eig.getNumberOfEigenvalues()) {
                arrayList.add(eigenDecomposition_F64.getEigenvalue(i));
                i++;
            }
        } else {
            EigenDecomposition_F32 eigenDecomposition_F32 = (EigenDecomposition_F32) this.eig;
            while (i < this.eig.getNumberOfEigenvalues()) {
                Complex_F32 eigenvalue = eigenDecomposition_F32.getEigenvalue(i);
                arrayList.add(new Complex_F64(eigenvalue.real, eigenvalue.imaginary));
                i++;
            }
        }
        return arrayList;
    }

    public int getNumberOfEigenvalues() {
        return this.eig.getNumberOfEigenvalues();
    }

    public Complex_F64 getEigenvalue(int i) {
        if (this.is64) {
            return ((EigenDecomposition_F64) this.eig).getEigenvalue(i);
        }
        Complex_F64 eigenvalue = ((EigenDecomposition_F64) this.eig).getEigenvalue(i);
        return new Complex_F64(eigenvalue.real, eigenvalue.imaginary);
    }

    public T getEigenVector(int i) {
        Matrix eigenVector = this.eig.getEigenVector(i);
        if (eigenVector == null) {
            return null;
        }
        return SimpleMatrix.wrap(eigenVector);
    }

    public double quality() {
        if (this.is64) {
            return DecompositionFactory_DDRM.quality((DMatrixRMaj) this.mat, (EigenDecomposition_F64<DMatrixRMaj>) this.eig);
        }
        return DecompositionFactory_FDRM.quality((FMatrixRMaj) this.mat, (EigenDecomposition_F32<FMatrixRMaj>) this.eig);
    }

    public EigenDecomposition getEVD() {
        return this.eig;
    }

    public int getIndexMax() {
        int i = 0;
        double magnitude2 = getEigenvalue(0).getMagnitude2();
        int numberOfEigenvalues = getNumberOfEigenvalues();
        for (int i2 = 1; i2 < numberOfEigenvalues; i2++) {
            double magnitude22 = getEigenvalue(i2).getMagnitude2();
            if (magnitude22 > magnitude2) {
                i = i2;
                magnitude2 = magnitude22;
            }
        }
        return i;
    }

    public int getIndexMin() {
        int i = 0;
        double magnitude2 = getEigenvalue(0).getMagnitude2();
        int numberOfEigenvalues = getNumberOfEigenvalues();
        for (int i2 = 1; i2 < numberOfEigenvalues; i2++) {
            double magnitude22 = getEigenvalue(i2).getMagnitude2();
            if (magnitude22 < magnitude2) {
                i = i2;
                magnitude2 = magnitude22;
            }
        }
        return i;
    }
}
