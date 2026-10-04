package org.ejml.dense.row.decomposition.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_DDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public abstract class CholeskyDecompositionCommon_DDRM implements CholeskyDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: T */
    protected DMatrixRMaj f2519T;
    protected boolean lower;

    /* JADX INFO: renamed from: n */
    protected int f2520n;

    /* JADX INFO: renamed from: t */
    protected double[] f2521t;

    /* JADX INFO: renamed from: vv */
    protected double[] f2522vv;
    protected int maxWidth = -1;
    protected Complex_F64 det = new Complex_F64();

    protected abstract boolean decomposeLower();

    protected abstract boolean decomposeUpper();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public CholeskyDecompositionCommon_DDRM(boolean z) {
        this.lower = z;
    }

    public void setExpectedMaxSize(int i, int i2) {
        if (i != i2) {
            throw new IllegalArgumentException("Can only decompose square matrices");
        }
        this.maxWidth = i2;
        this.f2522vv = new double[i2];
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return this.lower;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows > this.maxWidth) {
            setExpectedMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        } else if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        this.f2520n = dMatrixRMaj.numRows;
        this.f2519T = dMatrixRMaj;
        this.f2521t = dMatrixRMaj.data;
        if (this.lower) {
            return decomposeLower();
        }
        return decomposeUpper();
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public DMatrixRMaj getT(DMatrixRMaj dMatrixRMaj) {
        if (this.lower) {
            int i = this.f2520n;
            DMatrixRMaj dMatrixRMajCheckZerosUT = UtilDecompositons_DDRM.checkZerosUT(dMatrixRMaj, i, i);
            for (int i2 = 0; i2 < this.f2520n; i2++) {
                for (int i3 = 0; i3 <= i2; i3++) {
                    dMatrixRMajCheckZerosUT.unsafe_set(i2, i3, this.f2519T.unsafe_get(i2, i3));
                }
            }
            return dMatrixRMajCheckZerosUT;
        }
        int i4 = this.f2520n;
        DMatrixRMaj dMatrixRMajCheckZerosLT = UtilDecompositons_DDRM.checkZerosLT(dMatrixRMaj, i4, i4);
        for (int i5 = 0; i5 < this.f2520n; i5++) {
            for (int i6 = i5; i6 < this.f2520n; i6++) {
                dMatrixRMajCheckZerosLT.unsafe_set(i5, i6, this.f2519T.unsafe_get(i5, i6));
            }
        }
        return dMatrixRMajCheckZerosLT;
    }

    public DMatrixRMaj getT() {
        return this.f2519T;
    }

    public double[] _getVV() {
        return this.f2522vv;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition_F64
    public Complex_F64 computeDeterminant() {
        int i = this.f2520n;
        int i2 = i * i;
        double d = 1.0d;
        int i3 = 0;
        while (i3 < i2) {
            d *= this.f2521t[i3];
            i3 += this.f2520n + 1;
        }
        this.det.real = d * d;
        this.det.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return this.det;
    }
}
