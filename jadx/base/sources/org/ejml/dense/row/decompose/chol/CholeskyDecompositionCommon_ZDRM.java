package org.ejml.dense.row.decompose.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.Complex_F64;
import org.ejml.data.ZMatrixRMaj;
import org.ejml.dense.row.decompose.UtilDecompositons_ZDRM;
import org.ejml.interfaces.decomposition.CholeskyDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public abstract class CholeskyDecompositionCommon_ZDRM implements CholeskyDecomposition_F64<ZMatrixRMaj> {

    /* JADX INFO: renamed from: T */
    protected ZMatrixRMaj f2460T;
    protected Complex_F64 det = new Complex_F64();
    protected boolean lower;

    /* JADX INFO: renamed from: n */
    protected int f2461n;

    /* JADX INFO: renamed from: t */
    protected double[] f2462t;

    protected abstract boolean decomposeLower();

    protected abstract boolean decomposeUpper();

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return true;
    }

    public CholeskyDecompositionCommon_ZDRM(boolean z) {
        this.lower = z;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public boolean isLower() {
        return this.lower;
    }

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(ZMatrixRMaj zMatrixRMaj) {
        if (zMatrixRMaj.numRows != zMatrixRMaj.numCols) {
            throw new IllegalArgumentException("Must be a square matrix.");
        }
        this.f2461n = zMatrixRMaj.numRows;
        this.f2460T = zMatrixRMaj;
        this.f2462t = zMatrixRMaj.data;
        if (this.lower) {
            return decomposeLower();
        }
        return decomposeUpper();
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition
    public ZMatrixRMaj getT(ZMatrixRMaj zMatrixRMaj) {
        int i = 0;
        if (this.lower) {
            int i2 = this.f2461n;
            ZMatrixRMaj zMatrixRMajCheckZerosUT = UtilDecompositons_ZDRM.checkZerosUT(zMatrixRMaj, i2, i2);
            int i3 = 0;
            while (true) {
                int i4 = this.f2461n;
                if (i3 >= i4) {
                    return zMatrixRMajCheckZerosUT;
                }
                int i5 = i4 * i3 * 2;
                for (int i6 = 0; i6 <= i3; i6++) {
                    zMatrixRMajCheckZerosUT.data[i5] = this.f2460T.data[i5];
                    int i7 = i5 + 1;
                    zMatrixRMajCheckZerosUT.data[i7] = this.f2460T.data[i7];
                    i5 += 2;
                }
                i3++;
            }
        } else {
            int i8 = this.f2461n;
            ZMatrixRMaj zMatrixRMajCheckZerosLT = UtilDecompositons_ZDRM.checkZerosLT(zMatrixRMaj, i8, i8);
            while (true) {
                int i9 = this.f2461n;
                if (i >= i9) {
                    return zMatrixRMajCheckZerosLT;
                }
                int i10 = ((i9 * i) + i) * 2;
                for (int i11 = i; i11 < this.f2461n; i11++) {
                    zMatrixRMajCheckZerosLT.data[i10] = this.f2460T.data[i10];
                    int i12 = i10 + 1;
                    zMatrixRMajCheckZerosLT.data[i12] = this.f2460T.data[i12];
                    i10 += 2;
                }
                i++;
            }
        }
    }

    public ZMatrixRMaj _getT() {
        return this.f2460T;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyDecomposition_F64
    public Complex_F64 computeDeterminant() {
        int i = this.f2461n;
        int i2 = i * i * 2;
        double d = 1.0d;
        int i3 = 0;
        while (i3 < i2) {
            d *= this.f2462t[i3];
            i3 += (this.f2461n + 1) * 2;
        }
        this.det.real = d * d;
        this.det.imaginary = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        return this.det;
    }
}
