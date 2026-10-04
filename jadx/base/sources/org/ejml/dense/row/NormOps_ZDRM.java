package org.ejml.dense.row;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.ZMatrixRMaj;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_ZDRM {
    public static double normF(ZMatrixRMaj zMatrixRMaj) {
        double dElementMaxAbs = CommonOps_ZDRM.elementMaxAbs(zMatrixRMaj);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int dataLength = zMatrixRMaj.getDataLength();
        for (int i = 0; i < dataLength; i += 2) {
            double d2 = zMatrixRMaj.data[i] / dElementMaxAbs;
            double d3 = zMatrixRMaj.data[i + 1] / dElementMaxAbs;
            d += (d2 * d2) + (d3 * d3);
        }
        return dElementMaxAbs * Math.sqrt(d);
    }
}
