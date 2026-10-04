package org.ejml.simple;

import org.ejml.UtilEjml;
import org.ejml.data.DMatrixRMaj;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.SingularOps_DDRM;
import org.ejml.dense.row.SingularOps_FDRM;
import org.ejml.dense.row.factory.DecompositionFactory_DDRM;
import org.ejml.dense.row.factory.DecompositionFactory_FDRM;
import org.ejml.interfaces.decomposition.SingularValueDecomposition;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F32;
import org.ejml.interfaces.decomposition.SingularValueDecomposition_F64;
import org.ejml.simple.SimpleBase;

/* JADX INFO: loaded from: classes9.dex */
public class SimpleSVD<T extends SimpleBase> {

    /* JADX INFO: renamed from: U */
    private T f2758U;

    /* JADX INFO: renamed from: V */
    private T f2759V;

    /* JADX INFO: renamed from: W */
    private T f2760W;
    final boolean is64;
    private Matrix mat;
    private SingularValueDecomposition svd;
    double tol;

    public SimpleSVD(Matrix matrix, boolean z) {
        this.mat = matrix;
        boolean z2 = matrix instanceof DMatrixRMaj;
        this.is64 = z2;
        if (z2) {
            DMatrixRMaj dMatrixRMaj = (DMatrixRMaj) matrix;
            this.svd = DecompositionFactory_DDRM.svd(dMatrixRMaj.numRows, dMatrixRMaj.numCols, true, true, z);
        } else {
            FMatrixRMaj fMatrixRMaj = (FMatrixRMaj) matrix;
            this.svd = DecompositionFactory_FDRM.svd(fMatrixRMaj.numRows, fMatrixRMaj.numCols, true, true, z);
        }
        if (!this.svd.decompose(matrix)) {
            throw new RuntimeException("Decomposition failed");
        }
        this.f2758U = SimpleMatrix.wrap(this.svd.getU(null, false));
        this.f2760W = SimpleMatrix.wrap(this.svd.getW(null));
        this.f2759V = SimpleMatrix.wrap(this.svd.getV(null, false));
        if (z2) {
            SingularOps_DDRM.descendingOrder((DMatrixRMaj) this.f2758U.getMatrix(), false, (DMatrixRMaj) this.f2760W.getMatrix(), (DMatrixRMaj) this.f2759V.getMatrix(), false);
            this.tol = SingularOps_DDRM.singularThreshold((SingularValueDecomposition_F64) this.svd);
        } else {
            SingularOps_FDRM.descendingOrder((FMatrixRMaj) this.f2758U.getMatrix(), false, (FMatrixRMaj) this.f2760W.getMatrix(), (FMatrixRMaj) this.f2759V.getMatrix(), false);
            this.tol = SingularOps_FDRM.singularThreshold((SingularValueDecomposition_F32) this.svd);
        }
    }

    public T getU() {
        return this.f2758U;
    }

    public T getW() {
        return this.f2760W;
    }

    public T getV() {
        return this.f2759V;
    }

    public double quality() {
        if (this.is64) {
            return DecompositionFactory_DDRM.quality((DMatrixRMaj) this.mat, (DMatrixRMaj) this.f2758U.getMatrix(), (DMatrixRMaj) this.f2760W.getMatrix(), (DMatrixRMaj) this.f2759V.transpose().getMatrix());
        }
        return DecompositionFactory_FDRM.quality((FMatrixRMaj) this.mat, (FMatrixRMaj) this.f2758U.getMatrix(), (FMatrixRMaj) this.f2760W.getMatrix(), (FMatrixRMaj) this.f2759V.transpose().getMatrix());
    }

    public SimpleMatrix nullSpace() {
        if (this.is64) {
            return SimpleMatrix.wrap(SingularOps_DDRM.nullSpace((SingularValueDecomposition_F64) this.svd, null, this.tol));
        }
        return SimpleMatrix.wrap(SingularOps_FDRM.nullSpace((SingularValueDecomposition_F32) this.svd, null, (float) this.tol));
    }

    public double getSingleValue(int i) {
        return this.f2760W.get(i, i);
    }

    public double[] getSingularValues() {
        int iNumCols = this.f2760W.numCols();
        double[] dArr = new double[iNumCols];
        for (int i = 0; i < iNumCols; i++) {
            dArr[i] = getSingleValue(i);
        }
        return dArr;
    }

    public int rank() {
        if (this.is64) {
            return SingularOps_DDRM.rank((SingularValueDecomposition_F64) this.svd, this.tol);
        }
        return SingularOps_FDRM.rank((SingularValueDecomposition_F32) this.svd, (float) this.tol);
    }

    public int nullity() {
        if (this.is64) {
            return SingularOps_DDRM.nullity((SingularValueDecomposition_F64) this.svd, UtilEjml.EPS * 10.0d);
        }
        return SingularOps_FDRM.nullity((SingularValueDecomposition_F32) this.svd, UtilEjml.F_EPS * 5.0f);
    }

    public SingularValueDecomposition getSVD() {
        return this.svd;
    }
}
