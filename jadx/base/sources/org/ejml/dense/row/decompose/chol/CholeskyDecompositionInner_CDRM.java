package org.ejml.dense.row.decompose.chol;

import org.ejml.UtilEjml;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecompositionInner_CDRM extends CholeskyDecompositionCommon_CDRM {
    float tolerance;

    public CholeskyDecompositionInner_CDRM() {
        super(true);
        this.tolerance = UtilEjml.F_EPS;
    }

    public CholeskyDecompositionInner_CDRM(boolean z) {
        super(z);
        this.tolerance = UtilEjml.F_EPS;
    }

    public void setTolerance(float f) {
        this.tolerance = f;
    }

    @Override // org.ejml.dense.row.decompose.chol.CholeskyDecompositionCommon_CDRM
    protected boolean decomposeLower() {
        int i;
        if (this.f2458n == 0) {
            throw new IllegalArgumentException("Cholesky is undefined for 0 by 0 matrix");
        }
        int i2 = this.f2458n * 2;
        float f = 0.0f;
        boolean z = false;
        float f2 = 0.0f;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 < this.f2458n) {
                int i5 = i3;
                while (i5 < this.f2458n) {
                    int i6 = i3 * i2;
                    int i7 = (i5 * 2) + i6;
                    float f3 = this.f2459t[i7];
                    float f4 = this.f2459t[i7 + i4];
                    if (i3 == i5) {
                        if (Math.abs(f4) > this.tolerance * Math.abs(f3)) {
                            return z;
                        }
                        int i8 = (i3 * 2) + i6;
                        while (i6 < i8) {
                            int i9 = i6 + 1;
                            float f5 = this.f2459t[i6];
                            i6 += 2;
                            float f6 = this.f2459t[i9];
                            f3 -= (f5 * f5) + (f6 * f6);
                        }
                        if (f3 <= f) {
                            return z;
                        }
                        float fSqrt = (float) Math.sqrt(f3);
                        this.f2459t[i8] = fSqrt;
                        this.f2459t[i8 + 1] = f;
                        i = i4;
                        f2 = fSqrt;
                    } else {
                        int i10 = i5 * i2;
                        int i11 = i3 * 2;
                        int i12 = i6 + i11;
                        int i13 = i10;
                        while (i6 < i12) {
                            int i14 = i6 + 1;
                            float f7 = this.f2459t[i6];
                            i6 += 2;
                            float f8 = this.f2459t[i14];
                            int i15 = i13 + 1;
                            float f9 = this.f2459t[i13];
                            int i16 = i4;
                            i13 += 2;
                            float f10 = this.f2459t[i15];
                            f3 -= (f7 * f9) + (f8 * f10);
                            f4 -= (f7 * f10) - (f9 * f8);
                            i4 = i16;
                        }
                        i = i4;
                        int i17 = i10 + i11;
                        this.f2459t[i17] = f3 / f2;
                        this.f2459t[i17 + 1] = f4 / f2;
                    }
                    i5++;
                    i4 = i;
                    f = 0.0f;
                    z = false;
                }
                i3++;
                f = 0.0f;
                z = false;
            } else {
                for (int i18 = 1; i18 < this.f2458n; i18++) {
                    for (int i19 = 0; i19 < i18; i19++) {
                        int i20 = (i18 * i2) + (i19 * 2) + 1;
                        this.f2459t[i20] = -this.f2459t[i20];
                    }
                }
                return true;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    @Override // org.ejml.dense.row.decompose.chol.CholeskyDecompositionCommon_CDRM
    protected boolean decomposeUpper() {
        int i;
        if (this.f2458n == 0) {
            throw new IllegalArgumentException("Cholesky is undefined for 0 by 0 matrix");
        }
        int i2 = this.f2458n * 2;
        float f = 0.0f;
        boolean z = false;
        float fSqrt = 0.0f;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 >= this.f2458n) {
                return true;
            }
            int i5 = i3;
            while (i5 < this.f2458n) {
                int i6 = i3 * i2;
                int i7 = i5 * 2;
                int i8 = i6 + i7;
                float f2 = this.f2459t[i8];
                int i9 = i8 + 1;
                float f3 = this.f2459t[i9];
                if (i3 == i5) {
                    if (Math.abs(f3) > this.tolerance * Math.abs(f2)) {
                        return z;
                    }
                    for (?? r5 = z; r5 < i3; r5++) {
                        int i10 = (r5 * i2) + (i3 * 2);
                        float f4 = this.f2459t[i10];
                        float f5 = this.f2459t[i10 + i4];
                        f2 -= (f4 * f4) + (f5 * f5);
                    }
                    if (f2 <= f) {
                        return z;
                    }
                    fSqrt = (float) Math.sqrt(f2);
                    int i11 = i6 + (i3 * 2);
                    this.f2459t[i11] = fSqrt;
                    this.f2459t[i11 + i4] = f;
                    i = i4;
                } else {
                    for (?? r9 = z; r9 < i3; r9++) {
                        int i12 = r9 * i2;
                        int i13 = i12 + (i3 * 2);
                        float f6 = this.f2459t[i13];
                        float f7 = this.f2459t[i13 + 1];
                        int i14 = i12 + i7;
                        float f8 = this.f2459t[i14];
                        int i15 = i4;
                        float f9 = this.f2459t[i14 + 1];
                        f2 -= (f6 * f8) + (f7 * f9);
                        f3 -= (f6 * f9) - (f8 * f7);
                        i4 = i15;
                    }
                    i = i4;
                    this.f2459t[i8] = f2 / fSqrt;
                    this.f2459t[i9] = f3 / fSqrt;
                }
                i5++;
                i4 = i;
                f = 0.0f;
                z = false;
            }
            i3++;
            f = 0.0f;
            z = false;
        }
    }
}
