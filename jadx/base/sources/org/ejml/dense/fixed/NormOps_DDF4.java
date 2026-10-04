package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix4;
import org.ejml.data.DMatrix4x4;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_DDF4 {
    public static void normalizeF(DMatrix4x4 dMatrix4x4) {
        CommonOps_DDF4.divide(dMatrix4x4, normF(dMatrix4x4));
    }

    public static void normalizeF(DMatrix4 dMatrix4) {
        CommonOps_DDF4.divide(dMatrix4, normF(dMatrix4));
    }

    public static double fastNormF(DMatrix4x4 dMatrix4x4) {
        return Math.sqrt((dMatrix4x4.a11 * dMatrix4x4.a11) + (dMatrix4x4.a12 * dMatrix4x4.a12) + (dMatrix4x4.a13 * dMatrix4x4.a13) + (dMatrix4x4.a14 * dMatrix4x4.a14) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (dMatrix4x4.a21 * dMatrix4x4.a21) + (dMatrix4x4.a22 * dMatrix4x4.a22) + (dMatrix4x4.a23 * dMatrix4x4.a23) + (dMatrix4x4.a24 * dMatrix4x4.a24) + (dMatrix4x4.a31 * dMatrix4x4.a31) + (dMatrix4x4.a32 * dMatrix4x4.a32) + (dMatrix4x4.a33 * dMatrix4x4.a33) + (dMatrix4x4.a34 * dMatrix4x4.a34) + (dMatrix4x4.a41 * dMatrix4x4.a41) + (dMatrix4x4.a42 * dMatrix4x4.a42) + (dMatrix4x4.a43 * dMatrix4x4.a43) + (dMatrix4x4.a44 * dMatrix4x4.a44));
    }

    public static double fastNormF(DMatrix4 dMatrix4) {
        return Math.sqrt((dMatrix4.f2402a1 * dMatrix4.f2402a1) + (dMatrix4.f2403a2 * dMatrix4.f2403a2) + (dMatrix4.f2404a3 * dMatrix4.f2404a3) + (dMatrix4.f2405a4 * dMatrix4.f2405a4));
    }

    public static double normF(DMatrix4x4 dMatrix4x4) {
        double dElementMaxAbs = CommonOps_DDF4.elementMaxAbs(dMatrix4x4);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix4x4.a11 / dElementMaxAbs;
        double d2 = dMatrix4x4.a12 / dElementMaxAbs;
        double d3 = dMatrix4x4.a13 / dElementMaxAbs;
        double d4 = dMatrix4x4.a14 / dElementMaxAbs;
        double d5 = dMatrix4x4.a21 / dElementMaxAbs;
        double d6 = dMatrix4x4.a22 / dElementMaxAbs;
        double d7 = dMatrix4x4.a23 / dElementMaxAbs;
        double d8 = dMatrix4x4.a24 / dElementMaxAbs;
        double d9 = dMatrix4x4.a31 / dElementMaxAbs;
        double d10 = dMatrix4x4.a32 / dElementMaxAbs;
        double d11 = dMatrix4x4.a33 / dElementMaxAbs;
        double d12 = dMatrix4x4.a34 / dElementMaxAbs;
        double d13 = dMatrix4x4.a41 / dElementMaxAbs;
        double d14 = dMatrix4x4.a42 / dElementMaxAbs;
        double d15 = dMatrix4x4.a43 / dElementMaxAbs;
        double d16 = dMatrix4x4.a44 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + (d3 * d3) + (d4 * d4) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (d5 * d5) + (d6 * d6) + (d7 * d7) + (d8 * d8) + (d9 * d9) + (d10 * d10) + (d11 * d11) + (d12 * d12) + (d13 * d13) + (d14 * d14) + (d15 * d15) + (d16 * d16));
    }

    public static double normF(DMatrix4 dMatrix4) {
        double dElementMaxAbs = CommonOps_DDF4.elementMaxAbs(dMatrix4);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix4.f2402a1 / dElementMaxAbs;
        double d2 = dMatrix4.f2403a2 / dElementMaxAbs;
        double d3 = dMatrix4.f2404a3 / dElementMaxAbs;
        double d4 = dMatrix4.f2405a4 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + (d3 * d3) + (d4 * d4));
    }
}
