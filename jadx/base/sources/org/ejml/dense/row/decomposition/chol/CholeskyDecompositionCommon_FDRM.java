package org.ejml.dense.row.decomposition.chol;

import org.ejml.data.Complex_F32;
import org.ejml.data.FMatrixRMaj;
import org.ejml.dense.row.decomposition.UtilDecompositons_FDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public abstract class CholeskyDecompositionCommon_FDRM implements CholeskyDecomposition_F32<FMatrixRMaj> {

    /* JADX INFO: renamed from: T */
    protected FMatrixRMaj f2523T;
    protected boolean lower;

    /* JADX INFO: renamed from: n */
    protected int f2524n;

    /* JADX INFO: renamed from: t */
    protected float[] f2525t;

    /* JADX INFO: renamed from: vv */
    protected float[] f2526vv;
    protected int maxWidth = -1;
    protected Complex_F32 det = new Complex_F32();

    protected abstract boolean decomposeLower();

    protected abstract boolean decomposeUpper();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public CholeskyDecompositionCommon_FDRM(boolean z) {
        this.lower = z;
    }

    public void setExpectedMaxSize(int i, int i2) {
        if (i != i2) {
            throw new IllegalArgumentException("Can only decompose square matrices");
        }
        this.maxWidth = i2;
        this.f2526vv = new float[i2];
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return this.lower;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        if (fMatrixRMaj.numRows > this.maxWidth) {
            setExpectedMaxSize(fMatrixRMaj.numRows, fMatrixRMaj.numCols);
        } else if (fMatrixRMaj.numRows != fMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        this.f2524n = fMatrixRMaj.numRows;
        this.f2523T = fMatrixRMaj;
        this.f2525t = fMatrixRMaj.data;
        if (this.lower) {
            return decomposeLower();
        }
        return decomposeUpper();
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public FMatrixRMaj getT(FMatrixRMaj fMatrixRMaj) {
        if (this.lower) {
            int i = this.f2524n;
            FMatrixRMaj fMatrixRMajCheckZerosUT = UtilDecompositons_FDRM.checkZerosUT(fMatrixRMaj, i, i);
            for (int i2 = 0; i2 < this.f2524n; i2++) {
                for (int i3 = 0; i3 <= i2; i3++) {
                    fMatrixRMajCheckZerosUT.unsafe_set(i2, i3, this.f2523T.unsafe_get(i2, i3));
                }
            }
            return fMatrixRMajCheckZerosUT;
        }
        int i4 = this.f2524n;
        FMatrixRMaj fMatrixRMajCheckZerosLT = UtilDecompositons_FDRM.checkZerosLT(fMatrixRMaj, i4, i4);
        for (int i5 = 0; i5 < this.f2524n; i5++) {
            for (int i6 = i5; i6 < this.f2524n; i6++) {
                fMatrixRMajCheckZerosLT.unsafe_set(i5, i6, this.f2523T.unsafe_get(i5, i6));
            }
        }
        return fMatrixRMajCheckZerosLT;
    }

    public FMatrixRMaj getT() {
        return this.f2523T;
    }

    public float[] _getVV() {
        return this.f2526vv;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition_F32
    public Complex_F32 computeDeterminant() {
        int i = this.f2524n;
        int i2 = i * i;
        float f = 1.0f;
        int i3 = 0;
        while (i3 < i2) {
            f *= this.f2525t[i3];
            i3 += this.f2524n + 1;
        }
        this.det.real = f * f;
        this.det.imaginary = 0.0f;
        return this.det;
    }
}
