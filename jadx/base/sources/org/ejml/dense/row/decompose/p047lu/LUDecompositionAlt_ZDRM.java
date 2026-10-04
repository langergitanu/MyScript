package org.ejml.dense.row.decompose.p047lu;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.ZMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class LUDecompositionAlt_ZDRM extends LUDecompositionBase_ZDRM {
    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(ZMatrixRMaj zMatrixRMaj) {
        decomposeCommonInit(zMatrixRMaj);
        double[] dArr = this.f2486vv;
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= this.f2485n) {
                return true;
            }
            for (int i3 = 0; i3 < this.f2484m; i3++) {
                int i4 = i3 * 2;
                int i5 = i * 2;
                dArr[i4] = this.dataLU[(this.stride * i3) + i5];
                dArr[i4 + 1] = this.dataLU[(this.stride * i3) + i5 + 1];
            }
            int i6 = 0;
            while (true) {
                int i7 = this.f2484m;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                if (i6 >= i7) {
                    break;
                }
                int i8 = this.stride * i6;
                int i9 = i6 < i ? i6 : i;
                double d2 = 0.0d;
                for (int i10 = 0; i10 < i9; i10++) {
                    int i11 = i10 * 2;
                    int i12 = i8 + i11;
                    double d3 = this.dataLU[i12];
                    double d4 = this.dataLU[i12 + 1];
                    double d5 = dArr[i11];
                    double d6 = dArr[i11 + 1];
                    d += (d3 * d5) - (d4 * d6);
                    d2 += (d3 * d6) + (d4 * d5);
                }
                double[] dArr2 = this.dataLU;
                int i13 = i8 + (i * 2);
                int i14 = i6 * 2;
                double d7 = dArr[i14] - d;
                dArr[i14] = d7;
                dArr2[i13] = d7;
                int i15 = i14 + 1;
                double d8 = dArr[i15] - d2;
                dArr[i15] = d8;
                this.dataLU[i13 + 1] = d8;
                i6++;
            }
            int i16 = i * 2;
            double dMag = mag(dArr, i16);
            int i17 = i + 1;
            int i18 = i;
            for (int i19 = i17; i19 < this.f2484m; i19++) {
                double dMag2 = mag(dArr, i19 * 2);
                if (dMag2 > dMag) {
                    i18 = i19;
                    dMag = dMag2;
                }
            }
            if (i18 != i) {
                int i20 = this.stride * i18;
                int i21 = this.stride * i;
                int i22 = this.stride + i20;
                while (i20 < i22) {
                    double d9 = this.dataLU[i20];
                    this.dataLU[i20] = this.dataLU[i21];
                    this.dataLU[i21] = d9;
                    i20++;
                    i21++;
                }
                int i23 = this.pivot[i18];
                this.pivot[i18] = this.pivot[i];
                this.pivot[i] = i23;
                this.pivsign = -this.pivsign;
            }
            this.indx[i] = i18;
            if (i < this.f2484m) {
                double d10 = this.dataLU[(this.stride * i) + i16];
                double d11 = this.dataLU[(i * this.stride) + i16 + 1];
                double d12 = (d10 * d10) + (d11 * d11);
                if (d10 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d11 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    int i24 = i17;
                    while (i24 < this.f2484m) {
                        double d13 = this.dataLU[(this.stride * i24) + i16];
                        double d14 = this.dataLU[(this.stride * i24) + i16 + i2];
                        this.dataLU[(this.stride * i24) + i16] = ((d13 * d10) + (d14 * d11)) / d12;
                        this.dataLU[(this.stride * i24) + i16 + 1] = ((d14 * d10) - (d13 * d11)) / d12;
                        i24++;
                        i2 = i2;
                    }
                }
            }
            i = i17;
        }
    }

    private static double mag(double[] dArr, int i) {
        double d = dArr[i];
        double d2 = dArr[i + 1];
        return (d * d) + (d2 * d2);
    }
}
