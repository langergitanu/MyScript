package org.ejml.dense.row.decompose.chol;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.UtilEjml;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecompositionInner_ZDRM extends CholeskyDecompositionCommon_ZDRM {
    double tolerance;

    public CholeskyDecompositionInner_ZDRM() {
        super(true);
        this.tolerance = UtilEjml.EPS;
    }

    public CholeskyDecompositionInner_ZDRM(boolean z) {
        super(z);
        this.tolerance = UtilEjml.EPS;
    }

    public void setTolerance(double d) {
        this.tolerance = d;
    }

    @Override // org.ejml.dense.row.decompose.chol.CholeskyDecompositionCommon_ZDRM
    protected boolean decomposeLower() {
        if (this.f2461n == 0) {
            throw new IllegalArgumentException("Cholesky is undefined for 0 by 0 matrix");
        }
        int i = this.f2461n * 2;
        boolean z = false;
        int i2 = 0;
        double dSqrt = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (i2 < this.f2461n) {
            int i3 = i2;
            while (i3 < this.f2461n) {
                int i4 = i2 * i;
                int i5 = (i3 * 2) + i4;
                double d = this.f2462t[i5];
                double d2 = this.f2462t[i5 + 1];
                if (i2 == i3) {
                    if (Math.abs(d2) > this.tolerance * Math.abs(d)) {
                        return z;
                    }
                    int i6 = (i2 * 2) + i4;
                    while (i4 < i6) {
                        int i7 = i4 + 1;
                        double d3 = this.f2462t[i4];
                        i4 += 2;
                        double d4 = this.f2462t[i7];
                        d -= (d3 * d3) + (d4 * d4);
                    }
                    if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return z;
                    }
                    dSqrt = Math.sqrt(d);
                    this.f2462t[i6] = dSqrt;
                    this.f2462t[i6 + 1] = 0.0d;
                } else {
                    int i8 = i3 * i;
                    int i9 = i2 * 2;
                    int i10 = i4 + i9;
                    int i11 = i8;
                    while (i4 < i10) {
                        int i12 = i4 + 1;
                        double d5 = this.f2462t[i4];
                        i4 += 2;
                        double d6 = this.f2462t[i12];
                        int i13 = i11 + 1;
                        double d7 = this.f2462t[i11];
                        i11 += 2;
                        double d8 = this.f2462t[i13];
                        d -= (d5 * d7) + (d6 * d8);
                        d2 -= (d5 * d8) - (d7 * d6);
                    }
                    int i14 = i8 + i9;
                    this.f2462t[i14] = d / dSqrt;
                    this.f2462t[i14 + 1] = d2 / dSqrt;
                }
                i3++;
                z = false;
            }
            i2++;
            z = false;
        }
        for (int i15 = 1; i15 < this.f2461n; i15++) {
            for (int i16 = 0; i16 < i15; i16++) {
                int i17 = (i15 * i) + (i16 * 2) + 1;
                this.f2462t[i17] = -this.f2462t[i17];
            }
        }
        return true;
    }

    @Override // org.ejml.dense.row.decompose.chol.CholeskyDecompositionCommon_ZDRM
    protected boolean decomposeUpper() {
        if (this.f2461n == 0) {
            throw new IllegalArgumentException("Cholesky is undefined for 0 by 0 matrix");
        }
        int i = this.f2461n * 2;
        double dSqrt = 0.0d;
        for (int i2 = 0; i2 < this.f2461n; i2++) {
            for (int i3 = i2; i3 < this.f2461n; i3++) {
                int i4 = i2 * i;
                int i5 = i3 * 2;
                int i6 = i4 + i5;
                double d = this.f2462t[i6];
                int i7 = i6 + 1;
                double d2 = this.f2462t[i7];
                if (i2 == i3) {
                    if (Math.abs(d2) > this.tolerance * Math.abs(d)) {
                        return false;
                    }
                    for (int i8 = 0; i8 < i2; i8++) {
                        int i9 = (i8 * i) + (i2 * 2);
                        double d3 = this.f2462t[i9];
                        double d4 = this.f2462t[i9 + 1];
                        d -= (d3 * d3) + (d4 * d4);
                    }
                    if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        return false;
                    }
                    dSqrt = Math.sqrt(d);
                    int i10 = i4 + (i2 * 2);
                    this.f2462t[i10] = dSqrt;
                    this.f2462t[i10 + 1] = 0.0d;
                } else {
                    for (int i11 = 0; i11 < i2; i11++) {
                        int i12 = i11 * i;
                        int i13 = i12 + (i2 * 2);
                        double d5 = this.f2462t[i13];
                        double d6 = this.f2462t[i13 + 1];
                        int i14 = i12 + i5;
                        double d7 = this.f2462t[i14];
                        double d8 = this.f2462t[i14 + 1];
                        d -= (d5 * d7) + (d6 * d8);
                        d2 -= (d5 * d8) - (d7 * d6);
                    }
                    this.f2462t[i6] = d / dSqrt;
                    this.f2462t[i7] = d2 / dSqrt;
                }
            }
        }
        return true;
    }
}
