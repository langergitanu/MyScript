package org.ejml.dense.row.decomposition.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixD1;
import org.ejml.data.DMatrixRMaj;
import org.ejml.dense.row.CommonOps_DDRM;
import org.ejml.interfaces.decomposition.CholeskyLDLDecomposition_F64;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecompositionLDL_DDRM implements CholeskyLDLDecomposition_F64<DMatrixRMaj> {

    /* JADX INFO: renamed from: L */
    private DMatrixRMaj f2527L;

    /* JADX INFO: renamed from: d */
    private double[] f2528d;
    private int maxWidth;

    /* JADX INFO: renamed from: n */
    private int f2529n;

    /* JADX INFO: renamed from: vv */
    double[] f2530vv;

    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean inputModified() {
        return false;
    }

    public void setExpectedMaxSize(int i, int i2) {
        if (i != i2) {
            throw new IllegalArgumentException("Can only decompose square matrices");
        }
        this.maxWidth = i;
        int i3 = this.maxWidth;
        this.f2527L = new DMatrixRMaj(i3, i3);
        int i4 = this.maxWidth;
        this.f2530vv = new double[i4];
        this.f2528d = new double[i4];
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r5 = r5 + 1;
     */
    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj.numRows > this.maxWidth) {
            setExpectedMaxSize(dMatrixRMaj.numRows, dMatrixRMaj.numCols);
        } else if (dMatrixRMaj.numRows != dMatrixRMaj.numCols) {
            throw new RuntimeException("Can only decompose square matrices");
        }
        this.f2529n = dMatrixRMaj.numRows;
        this.f2527L.set((DMatrixD1) dMatrixRMaj);
        double[] dArr = this.f2527L.data;
        int i = 0;
        double d = 0.0d;
        int i2 = 0;
        while (i2 < this.f2529n) {
            int i3 = i2;
            while (true) {
                int i4 = this.f2529n;
                if (i3 < i4) {
                    double d2 = dArr[(i4 * i2) + i3];
                    for (int i5 = 0; i5 < i2; i5++) {
                        int i6 = this.f2529n;
                        d2 -= (dArr[(i2 * i6) + i5] * dArr[(i6 * i3) + i5]) * this.f2528d[i5];
                    }
                    if (i2 == i3) {
                        if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            return false;
                        }
                        this.f2528d[i2] = d2;
                        dArr[(this.f2529n * i2) + i2] = 1.0d;
                        d = 1.0d / d2;
                    } else {
                        dArr[(this.f2529n * i3) + i2] = d2 * d;
                    }
                    i3++;
                }
            }
        }
        while (i < this.f2529n) {
            int i7 = i + 1;
            int i8 = i7;
            while (true) {
                int i9 = this.f2529n;
                if (i8 < i9) {
                    dArr[(i9 * i) + i8] = 0.0d;
                    i8++;
                }
            }
            i = i7;
        }
        return true;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyLDLDecomposition_F64
    public double[] getDiagonal() {
        return this.f2528d;
    }

    public DMatrixRMaj getL() {
        return this.f2527L;
    }

    public double[] _getVV() {
        return this.f2530vv;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyLDLDecomposition
    public DMatrixRMaj getL(DMatrixRMaj dMatrixRMaj) {
        if (dMatrixRMaj == null) {
            return this.f2527L.copy();
        }
        dMatrixRMaj.set((DMatrixD1) this.f2527L);
        return dMatrixRMaj;
    }

    @Override // org.ejml.interfaces.decomposition.CholeskyLDLDecomposition
    public DMatrixRMaj getD(DMatrixRMaj dMatrixRMaj) {
        return CommonOps_DDRM.diag(dMatrixRMaj, this.f2527L.numCols, this.f2528d);
    }
}
