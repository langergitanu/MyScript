package org.ejml.dense.row.decomposition.p049lu;

import org.ejml.data.FMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class LUDecompositionAlt_FDRM extends LUDecompositionBase_FDRM {
    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(FMatrixRMaj fMatrixRMaj) {
        decomposeCommonInit(fMatrixRMaj);
        float[] fArr = this.f2620vv;
        int i = 0;
        while (i < this.f2619n) {
            for (int i2 = 0; i2 < this.f2618m; i2++) {
                fArr[i2] = this.dataLU[(this.f2619n * i2) + i];
            }
            int i3 = 0;
            while (true) {
                float f = 0.0f;
                if (i3 >= this.f2618m) {
                    break;
                }
                int i4 = this.f2619n * i3;
                int i5 = i3 < i ? i3 : i;
                for (int i6 = 0; i6 < i5; i6++) {
                    f += this.dataLU[i4 + i6] * fArr[i6];
                }
                float f2 = fArr[i3] - f;
                fArr[i3] = f2;
                this.dataLU[i4 + i] = f2;
                i3++;
            }
            float fAbs = Math.abs(fArr[i]);
            int i7 = i + 1;
            int i8 = i;
            for (int i9 = i7; i9 < this.f2618m; i9++) {
                float fAbs2 = Math.abs(fArr[i9]);
                if (fAbs2 > fAbs) {
                    i8 = i9;
                    fAbs = fAbs2;
                }
            }
            if (i8 != i) {
                int i10 = this.f2619n * i8;
                int i11 = this.f2619n * i;
                int i12 = this.f2619n + i10;
                while (i10 < i12) {
                    float f3 = this.dataLU[i10];
                    this.dataLU[i10] = this.dataLU[i11];
                    this.dataLU[i11] = f3;
                    i10++;
                    i11++;
                }
                int i13 = this.pivot[i8];
                this.pivot[i8] = this.pivot[i];
                this.pivot[i] = i13;
                this.pivsign = -this.pivsign;
            }
            this.indx[i] = i8;
            if (i < this.f2618m) {
                float f4 = this.dataLU[(this.f2619n * i) + i];
                if (f4 != 0.0f) {
                    for (int i14 = i7; i14 < this.f2618m; i14++) {
                        float[] fArr2 = this.dataLU;
                        int i15 = (this.f2619n * i14) + i;
                        fArr2[i15] = fArr2[i15] / f4;
                    }
                }
            }
            i = i7;
        }
        return true;
    }
}
