package org.ejml.dense.row.decomposition.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
class CholeskyBlockHelper_DDRM {

    /* JADX INFO: renamed from: L */
    private DMatrixRMaj f2513L;

    /* JADX INFO: renamed from: el */
    private double[] f2514el;

    public CholeskyBlockHelper_DDRM(int i) {
        DMatrixRMaj dMatrixRMaj = new DMatrixRMaj(i, i);
        this.f2513L = dMatrixRMaj;
        this.f2514el = dMatrixRMaj.data;
    }

    public boolean decompose(DMatrixRMaj dMatrixRMaj, int i, int i2) {
        double[] dArr = dMatrixRMaj.data;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                double d2 = dArr[i + (dMatrixRMaj.numCols * i3) + i4];
                int i5 = i3 * i2;
                int i6 = i4 * i2;
                int i7 = i5 + i3;
                int i8 = i6;
                while (i5 < i7) {
                    double[] dArr2 = this.f2514el;
                    d2 -= dArr2[i5] * dArr2[i8];
                    i5++;
                    i8++;
                }
                if (i3 == i4) {
                    if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return false;
                    }
                    double dSqrt = Math.sqrt(d2);
                    this.f2514el[i7] = dSqrt;
                    dArr[i + (dMatrixRMaj.numCols * i3) + i3] = dSqrt;
                    d = 1.0d / dSqrt;
                } else {
                    double d3 = d2 * d;
                    this.f2514el[i6 + i3] = d3;
                    dArr[i + (dMatrixRMaj.numCols * i4) + i3] = d3;
                }
            }
        }
        return true;
    }

    public DMatrixRMaj getL() {
        return this.f2513L;
    }
}
