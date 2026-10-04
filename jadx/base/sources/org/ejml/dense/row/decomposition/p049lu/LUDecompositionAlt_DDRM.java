package org.ejml.dense.row.decomposition.p049lu;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class LUDecompositionAlt_DDRM extends LUDecompositionBase_DDRM {
    @Override // org.ejml.interfaces.decomposition.DecompositionInterface
    public boolean decompose(DMatrixRMaj dMatrixRMaj) {
        decomposeCommonInit(dMatrixRMaj);
        double[] dArr = this.f2616vv;
        int i = 0;
        while (i < this.f2615n) {
            for (int i2 = 0; i2 < this.f2614m; i2++) {
                dArr[i2] = this.dataLU[(this.f2615n * i2) + i];
            }
            int i3 = 0;
            while (true) {
                int i4 = this.f2614m;
                double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                if (i3 >= i4) {
                    break;
                }
                int i5 = this.f2615n * i3;
                int i6 = i3 < i ? i3 : i;
                for (int i7 = 0; i7 < i6; i7++) {
                    d += this.dataLU[i5 + i7] * dArr[i7];
                }
                double d2 = dArr[i3] - d;
                dArr[i3] = d2;
                this.dataLU[i5 + i] = d2;
                i3++;
            }
            double dAbs = Math.abs(dArr[i]);
            int i8 = i + 1;
            int i9 = i;
            for (int i10 = i8; i10 < this.f2614m; i10++) {
                double dAbs2 = Math.abs(dArr[i10]);
                if (dAbs2 > dAbs) {
                    i9 = i10;
                    dAbs = dAbs2;
                }
            }
            if (i9 != i) {
                int i11 = this.f2615n * i9;
                int i12 = this.f2615n * i;
                int i13 = this.f2615n + i11;
                while (i11 < i13) {
                    double d3 = this.dataLU[i11];
                    this.dataLU[i11] = this.dataLU[i12];
                    this.dataLU[i12] = d3;
                    i11++;
                    i12++;
                }
                int i14 = this.pivot[i9];
                this.pivot[i9] = this.pivot[i];
                this.pivot[i] = i14;
                this.pivsign = -this.pivsign;
            }
            this.indx[i] = i9;
            if (i < this.f2614m) {
                double d4 = this.dataLU[(this.f2615n * i) + i];
                if (d4 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    for (int i15 = i8; i15 < this.f2614m; i15++) {
                        double[] dArr2 = this.dataLU;
                        int i16 = (this.f2615n * i15) + i;
                        dArr2[i16] = dArr2[i16] / d4;
                    }
                }
            }
            i = i8;
        }
        return true;
    }
}
