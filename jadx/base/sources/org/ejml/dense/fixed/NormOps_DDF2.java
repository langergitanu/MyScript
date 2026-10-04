package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix2;
import org.ejml.data.DMatrix2x2;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_DDF2 {
    public static void normalizeF(DMatrix2x2 dMatrix2x2) {
        CommonOps_DDF2.divide(dMatrix2x2, normF(dMatrix2x2));
    }

    public static void normalizeF(DMatrix2 dMatrix2) {
        CommonOps_DDF2.divide(dMatrix2, normF(dMatrix2));
    }

    public static double fastNormF(DMatrix2x2 dMatrix2x2) {
        return Math.sqrt((dMatrix2x2.a11 * dMatrix2x2.a11) + (dMatrix2x2.a12 * dMatrix2x2.a12) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (dMatrix2x2.a21 * dMatrix2x2.a21) + (dMatrix2x2.a22 * dMatrix2x2.a22));
    }

    public static double fastNormF(DMatrix2 dMatrix2) {
        return Math.sqrt((dMatrix2.f2397a1 * dMatrix2.f2397a1) + (dMatrix2.f2398a2 * dMatrix2.f2398a2));
    }

    public static double normF(DMatrix2x2 dMatrix2x2) {
        double dElementMaxAbs = CommonOps_DDF2.elementMaxAbs(dMatrix2x2);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix2x2.a11 / dElementMaxAbs;
        double d2 = dMatrix2x2.a12 / dElementMaxAbs;
        double d3 = dMatrix2x2.a21 / dElementMaxAbs;
        double d4 = dMatrix2x2.a22 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (d3 * d3) + (d4 * d4));
    }

    public static double normF(DMatrix2 dMatrix2) {
        double dElementMaxAbs = CommonOps_DDF2.elementMaxAbs(dMatrix2);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix2.f2397a1 / dElementMaxAbs;
        double d2 = dMatrix2.f2398a2 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2));
    }
}
