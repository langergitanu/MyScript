package org.ejml.sparse.csc;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrixSparseCSC;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_DSCC {
    public static double fastNormF(DMatrixSparseCSC dMatrixSparseCSC) {
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dMatrixSparseCSC.nz_length; i++) {
            double d2 = dMatrixSparseCSC.nz_values[i];
            d += d2 * d2;
        }
        return Math.sqrt(d);
    }

    public static double normF(DMatrixSparseCSC dMatrixSparseCSC) {
        double dElementMaxAbs = CommonOps_DSCC.elementMaxAbs(dMatrixSparseCSC);
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        for (int i = 0; i < dMatrixSparseCSC.nz_length; i++) {
            double d2 = dMatrixSparseCSC.nz_values[i] / dElementMaxAbs;
            d += d2 * d2;
        }
        return dElementMaxAbs * Math.sqrt(d);
    }
}
