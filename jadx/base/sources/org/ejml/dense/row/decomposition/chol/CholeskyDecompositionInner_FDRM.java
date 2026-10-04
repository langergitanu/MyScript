package org.ejml.dense.row.decomposition.chol;

/* JADX INFO: loaded from: classes9.dex */
public class CholeskyDecompositionInner_FDRM extends CholeskyDecompositionCommon_FDRM {
    public CholeskyDecompositionInner_FDRM() {
        super(true);
    }

    public CholeskyDecompositionInner_FDRM(boolean z) {
        super(z);
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_FDRM
    protected boolean decomposeLower() {
        int i = 0;
        float f = 0.0f;
        for (int i2 = 0; i2 < this.f2524n; i2++) {
            for (int i3 = i2; i3 < this.f2524n; i3++) {
                float f2 = this.f2525t[(this.f2524n * i2) + i3];
                int i4 = this.f2524n * i2;
                int i5 = this.f2524n * i3;
                int i6 = i4 + i2;
                while (i4 < i6) {
                    f2 -= this.f2525t[i4] * this.f2525t[i5];
                    i4++;
                    i5++;
                }
                if (i2 == i3) {
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    float fSqrt = (float) Math.sqrt(f2);
                    this.f2525t[(this.f2524n * i2) + i2] = fSqrt;
                    f = 1.0f / fSqrt;
                } else {
                    this.f2525t[(this.f2524n * i3) + i2] = f2 * f;
                }
            }
        }
        while (i < this.f2524n) {
            int i7 = i + 1;
            for (int i8 = i7; i8 < this.f2524n; i8++) {
                this.f2525t[(this.f2524n * i) + i8] = 0.0f;
            }
            i = i7;
        }
        return true;
    }

    @Override // org.ejml.dense.row.decomposition.chol.CholeskyDecompositionCommon_FDRM
    protected boolean decomposeUpper() {
        float f = 0.0f;
        for (int i = 0; i < this.f2524n; i++) {
            for (int i2 = i; i2 < this.f2524n; i2++) {
                float f2 = this.f2525t[(this.f2524n * i) + i2];
                for (int i3 = 0; i3 < i; i3++) {
                    f2 -= this.f2525t[(this.f2524n * i3) + i] * this.f2525t[(this.f2524n * i3) + i2];
                }
                if (i == i2) {
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    float fSqrt = (float) Math.sqrt(f2);
                    this.f2525t[(this.f2524n * i) + i] = fSqrt;
                    f = 1.0f / fSqrt;
                } else {
                    this.f2525t[(this.f2524n * i) + i2] = f2 * f;
                }
            }
        }
        for (int i4 = 0; i4 < this.f2524n; i4++) {
            for (int i5 = 0; i5 < i4; i5++) {
                this.f2525t[(this.f2524n * i4) + i5] = 0.0f;
            }
        }
        return true;
    }
}
