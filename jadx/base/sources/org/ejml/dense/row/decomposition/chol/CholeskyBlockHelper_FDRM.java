package org.ejml.dense.row.decomposition.chol;

import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
class CholeskyBlockHelper_FDRM {

    /* JADX INFO: renamed from: L */
    private FMatrixRMaj f2515L;

    /* JADX INFO: renamed from: el */
    private float[] f2516el;

    public CholeskyBlockHelper_FDRM(int i) {
        FMatrixRMaj fMatrixRMaj = new FMatrixRMaj(i, i);
        this.f2515L = fMatrixRMaj;
        this.f2516el = fMatrixRMaj.data;
    }

    public boolean decompose(FMatrixRMaj fMatrixRMaj, int i, int i2) {
        float[] fArr = fMatrixRMaj.data;
        float f = 0.0f;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = i3; i4 < i2; i4++) {
                float f2 = fArr[i + (fMatrixRMaj.numCols * i3) + i4];
                int i5 = i3 * i2;
                int i6 = i4 * i2;
                int i7 = i5 + i3;
                int i8 = i6;
                while (i5 < i7) {
                    float[] fArr2 = this.f2516el;
                    f2 -= fArr2[i5] * fArr2[i8];
                    i5++;
                    i8++;
                }
                if (i3 == i4) {
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    float fSqrt = (float) Math.sqrt(f2);
                    this.f2516el[i7] = fSqrt;
                    fArr[i + (fMatrixRMaj.numCols * i3) + i3] = fSqrt;
                    f = 1.0f / fSqrt;
                } else {
                    float f3 = f2 * f;
                    this.f2516el[i6 + i3] = f3;
                    fArr[i + (fMatrixRMaj.numCols * i4) + i3] = f3;
                }
            }
        }
        return true;
    }

    public FMatrixRMaj getL() {
        return this.f2515L;
    }
}
