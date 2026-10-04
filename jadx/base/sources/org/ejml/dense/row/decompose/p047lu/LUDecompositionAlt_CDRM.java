package org.ejml.dense.row.decompose.p047lu;

import org.ejml.data.CMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class LUDecompositionAlt_CDRM extends LUDecompositionBase_CDRM {
    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(CMatrixRMaj cMatrixRMaj) {
        decomposeCommonInit(cMatrixRMaj);
        float[] fArr = this.f2482vv;
        int i = 0;
        while (i < this.f2481n) {
            for (int i2 = 0; i2 < this.f2480m; i2++) {
                int i3 = i2 * 2;
                int i4 = i * 2;
                fArr[i3] = this.dataLU[(this.stride * i2) + i4];
                fArr[i3 + 1] = this.dataLU[(this.stride * i2) + i4 + 1];
            }
            int i5 = 0;
            while (true) {
                float f = 0.0f;
                if (i5 >= this.f2480m) {
                    break;
                }
                int i6 = this.stride * i5;
                int i7 = i5 < i ? i5 : i;
                float f2 = 0.0f;
                for (int i8 = 0; i8 < i7; i8++) {
                    int i9 = i8 * 2;
                    int i10 = i6 + i9;
                    float f3 = this.dataLU[i10];
                    float f4 = this.dataLU[i10 + 1];
                    float f5 = fArr[i9];
                    float f6 = fArr[i9 + 1];
                    f += (f3 * f5) - (f4 * f6);
                    f2 += (f3 * f6) + (f4 * f5);
                }
                float[] fArr2 = this.dataLU;
                int i11 = i6 + (i * 2);
                int i12 = i5 * 2;
                float f7 = fArr[i12] - f;
                fArr[i12] = f7;
                fArr2[i11] = f7;
                int i13 = i12 + 1;
                float f8 = fArr[i13] - f2;
                fArr[i13] = f8;
                this.dataLU[i11 + 1] = f8;
                i5++;
            }
            int i14 = i * 2;
            float fMag = mag(fArr, i14);
            int i15 = i + 1;
            int i16 = i;
            for (int i17 = i15; i17 < this.f2480m; i17++) {
                float fMag2 = mag(fArr, i17 * 2);
                if (fMag2 > fMag) {
                    i16 = i17;
                    fMag = fMag2;
                }
            }
            if (i16 != i) {
                int i18 = this.stride * i16;
                int i19 = this.stride * i;
                int i20 = this.stride + i18;
                while (i18 < i20) {
                    float f9 = this.dataLU[i18];
                    this.dataLU[i18] = this.dataLU[i19];
                    this.dataLU[i19] = f9;
                    i18++;
                    i19++;
                }
                int i21 = this.pivot[i16];
                this.pivot[i16] = this.pivot[i];
                this.pivot[i] = i21;
                this.pivsign = -this.pivsign;
            }
            this.indx[i] = i16;
            if (i < this.f2480m) {
                float f10 = this.dataLU[(this.stride * i) + i14];
                float f11 = this.dataLU[(i * this.stride) + i14 + 1];
                float f12 = (f10 * f10) + (f11 * f11);
                if (f10 != 0.0f || f11 != 0.0f) {
                    for (int i22 = i15; i22 < this.f2480m; i22++) {
                        float f13 = this.dataLU[(this.stride * i22) + i14];
                        float f14 = this.dataLU[(this.stride * i22) + i14 + 1];
                        this.dataLU[(this.stride * i22) + i14] = ((f13 * f10) + (f14 * f11)) / f12;
                        this.dataLU[(this.stride * i22) + i14 + 1] = ((f14 * f10) - (f13 * f11)) / f12;
                    }
                }
            }
            i = i15;
        }
        return true;
    }

    private static float mag(float[] fArr, int i) {
        float f = fArr[i];
        float f2 = fArr[i + 1];
        return (f * f) + (f2 * f2);
    }
}
