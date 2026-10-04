package org.ejml.dense.row.decompose.chol;

import org.ejml.data.CMatrixRMaj;
import org.ejml.data.Complex_F32;
import org.ejml.dense.row.decompose.UtilDecompositons_CDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F32;

/* JADX INFO: loaded from: classes9.dex */
public abstract class CholeskyDecompositionCommon_CDRM implements CholeskyDecomposition_F32<CMatrixRMaj> {

    /* JADX INFO: renamed from: T */
    protected CMatrixRMaj f2457T;
    protected Complex_F32 det = new Complex_F32();
    protected boolean lower;

    /* JADX INFO: renamed from: n */
    protected int f2458n;

    /* JADX INFO: renamed from: t */
    protected float[] f2459t;

    protected abstract boolean decomposeLower();

    protected abstract boolean decomposeUpper();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public CholeskyDecompositionCommon_CDRM(boolean z) {
        this.lower = z;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return this.lower;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(CMatrixRMaj cMatrixRMaj) {
        if (cMatrixRMaj.numRows != cMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        this.f2458n = cMatrixRMaj.numRows;
        this.f2457T = cMatrixRMaj;
        this.f2459t = cMatrixRMaj.data;
        if (this.lower) {
            return decomposeLower();
        }
        return decomposeUpper();
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public CMatrixRMaj getT(CMatrixRMaj cMatrixRMaj) {
        int i = 0;
        if (this.lower) {
            int i2 = this.f2458n;
            CMatrixRMaj cMatrixRMajCheckZerosUT = UtilDecompositons_CDRM.checkZerosUT(cMatrixRMaj, i2, i2);
            int i3 = 0;
            while (true) {
                int i4 = this.f2458n;
                if (i3 >= i4) {
                    return cMatrixRMajCheckZerosUT;
                }
                int i5 = i4 * i3 * 2;
                for (int i6 = 0; i6 <= i3; i6++) {
                    cMatrixRMajCheckZerosUT.data[i5] = this.f2457T.data[i5];
                    int i7 = i5 + 1;
                    cMatrixRMajCheckZerosUT.data[i7] = this.f2457T.data[i7];
                    i5 += 2;
                }
                i3++;
            }
        } else {
            int i8 = this.f2458n;
            CMatrixRMaj cMatrixRMajCheckZerosLT = UtilDecompositons_CDRM.checkZerosLT(cMatrixRMaj, i8, i8);
            while (true) {
                int i9 = this.f2458n;
                if (i >= i9) {
                    return cMatrixRMajCheckZerosLT;
                }
                int i10 = ((i9 * i) + i) * 2;
                for (int i11 = i; i11 < this.f2458n; i11++) {
                    cMatrixRMajCheckZerosLT.data[i10] = this.f2457T.data[i10];
                    int i12 = i10 + 1;
                    cMatrixRMajCheckZerosLT.data[i12] = this.f2457T.data[i12];
                    i10 += 2;
                }
                i++;
            }
        }
    }

    public CMatrixRMaj _getT() {
        return this.f2457T;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition_F32
    public Complex_F32 computeDeterminant() {
        int i = this.f2458n;
        int i2 = i * i * 2;
        float f = 1.0f;
        int i3 = 0;
        while (i3 < i2) {
            f *= this.f2459t[i3];
            i3 += (this.f2458n + 1) * 2;
        }
        this.det.real = f * f;
        this.det.imaginary = 0.0f;
        return this.det;
    }
}
