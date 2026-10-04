package org.ejml.dense.row.decomposition.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecompositionInner_DDRM extends CholeskyDecompositionCommon_DDRM {
    public CholeskyDecompositionInner_DDRM() {
        super(true);
    }

    public CholeskyDecompositionInner_DDRM(boolean z) {
        super(z);
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_DDRM
    protected boolean decomposeLower() {
        int i = 0;
        double d = 0.0d;
        for (int i2 = 0; i2 < this.f2520n; i2++) {
            for (int i3 = i2; i3 < this.f2520n; i3++) {
                double d2 = this.f2521t[(this.f2520n * i2) + i3];
                int i4 = this.f2520n * i2;
                int i5 = this.f2520n * i3;
                int i6 = i4 + i2;
                while (i4 < i6) {
                    d2 -= this.f2521t[i4] * this.f2521t[i5];
                    i4++;
                    i5++;
                }
                if (i2 == i3) {
                    if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return false;
                    }
                    double dSqrt = Math.sqrt(d2);
                    this.f2521t[(this.f2520n * i2) + i2] = dSqrt;
                    d = 1.0d / dSqrt;
                } else {
                    this.f2521t[(this.f2520n * i3) + i2] = d2 * d;
                }
            }
        }
        while (i < this.f2520n) {
            int i7 = i + 1;
            for (int i8 = i7; i8 < this.f2520n; i8++) {
                this.f2521t[(this.f2520n * i) + i8] = 0.0d;
            }
            i = i7;
        }
        return true;
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_DDRM
    protected boolean decomposeUpper() {
        double d = 0.0d;
        for (int i = 0; i < this.f2520n; i++) {
            for (int i2 = i; i2 < this.f2520n; i2++) {
                double d2 = this.f2521t[(this.f2520n * i) + i2];
                for (int i3 = 0; i3 < i; i3++) {
                    d2 -= this.f2521t[(this.f2520n * i3) + i] * this.f2521t[(this.f2520n * i3) + i2];
                }
                if (i == i2) {
                    if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return false;
                    }
                    double dSqrt = Math.sqrt(d2);
                    this.f2521t[(this.f2520n * i) + i] = dSqrt;
                    d = 1.0d / dSqrt;
                } else {
                    this.f2521t[(this.f2520n * i) + i2] = d2 * d;
                }
            }
        }
        for (int i4 = 0; i4 < this.f2520n; i4++) {
            for (int i5 = 0; i5 < i4; i5++) {
                this.f2521t[(this.f2520n * i4) + i5] = 0.0d;
            }
        }
        return true;
    }
}
