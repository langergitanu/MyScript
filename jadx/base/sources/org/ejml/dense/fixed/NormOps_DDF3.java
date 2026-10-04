package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix3;
import org.ejml.data.DMatrix3x3;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_DDF3 {
    public static void normalizeF(DMatrix3x3 dMatrix3x3) {
        CommonOps_DDF3.divide(dMatrix3x3, normF(dMatrix3x3));
    }

    public static void normalizeF(DMatrix3 dMatrix3) {
        CommonOps_DDF3.divide(dMatrix3, normF(dMatrix3));
    }

    public static double fastNormF(DMatrix3x3 dMatrix3x3) {
        return Math.sqrt((dMatrix3x3.a11 * dMatrix3x3.a11) + (dMatrix3x3.a12 * dMatrix3x3.a12) + (dMatrix3x3.a13 * dMatrix3x3.a13) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (dMatrix3x3.a21 * dMatrix3x3.a21) + (dMatrix3x3.a22 * dMatrix3x3.a22) + (dMatrix3x3.a23 * dMatrix3x3.a23) + (dMatrix3x3.a31 * dMatrix3x3.a31) + (dMatrix3x3.a32 * dMatrix3x3.a32) + (dMatrix3x3.a33 * dMatrix3x3.a33));
    }

    public static double fastNormF(DMatrix3 dMatrix3) {
        return Math.sqrt((dMatrix3.f2399a1 * dMatrix3.f2399a1) + (dMatrix3.f2400a2 * dMatrix3.f2400a2) + (dMatrix3.f2401a3 * dMatrix3.f2401a3));
    }

    public static double normF(DMatrix3x3 dMatrix3x3) {
        double dElementMaxAbs = CommonOps_DDF3.elementMaxAbs(dMatrix3x3);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix3x3.a11 / dElementMaxAbs;
        double d2 = dMatrix3x3.a12 / dElementMaxAbs;
        double d3 = dMatrix3x3.a13 / dElementMaxAbs;
        double d4 = dMatrix3x3.a21 / dElementMaxAbs;
        double d5 = dMatrix3x3.a22 / dElementMaxAbs;
        double d6 = dMatrix3x3.a23 / dElementMaxAbs;
        double d7 = dMatrix3x3.a31 / dElementMaxAbs;
        double d8 = dMatrix3x3.a32 / dElementMaxAbs;
        double d9 = dMatrix3x3.a33 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + (d3 * d3) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (d4 * d4) + (d5 * d5) + (d6 * d6) + (d7 * d7) + (d8 * d8) + (d9 * d9));
    }

    public static double normF(DMatrix3 dMatrix3) {
        double dElementMaxAbs = CommonOps_DDF3.elementMaxAbs(dMatrix3);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix3.f2399a1 / dElementMaxAbs;
        double d2 = dMatrix3.f2400a2 / dElementMaxAbs;
        double d3 = dMatrix3.f2401a3 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + (d3 * d3));
    }
}
