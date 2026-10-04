package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix5;
import org.ejml.data.DMatrix5x5;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_DDF5 {
    public static void normalizeF(DMatrix5x5 dMatrix5x5) {
        CommonOps_DDF5.divide(dMatrix5x5, normF(dMatrix5x5));
    }

    public static void normalizeF(DMatrix5 dMatrix5) {
        CommonOps_DDF5.divide(dMatrix5, normF(dMatrix5));
    }

    public static double fastNormF(DMatrix5x5 dMatrix5x5) {
        return Math.sqrt((dMatrix5x5.a11 * dMatrix5x5.a11) + (dMatrix5x5.a12 * dMatrix5x5.a12) + (dMatrix5x5.a13 * dMatrix5x5.a13) + (dMatrix5x5.a14 * dMatrix5x5.a14) + (dMatrix5x5.a15 * dMatrix5x5.a15) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (dMatrix5x5.a21 * dMatrix5x5.a21) + (dMatrix5x5.a22 * dMatrix5x5.a22) + (dMatrix5x5.a23 * dMatrix5x5.a23) + (dMatrix5x5.a24 * dMatrix5x5.a24) + (dMatrix5x5.a25 * dMatrix5x5.a25) + (dMatrix5x5.a31 * dMatrix5x5.a31) + (dMatrix5x5.a32 * dMatrix5x5.a32) + (dMatrix5x5.a33 * dMatrix5x5.a33) + (dMatrix5x5.a34 * dMatrix5x5.a34) + (dMatrix5x5.a35 * dMatrix5x5.a35) + (dMatrix5x5.a41 * dMatrix5x5.a41) + (dMatrix5x5.a42 * dMatrix5x5.a42) + (dMatrix5x5.a43 * dMatrix5x5.a43) + (dMatrix5x5.a44 * dMatrix5x5.a44) + (dMatrix5x5.a45 * dMatrix5x5.a45) + (dMatrix5x5.a51 * dMatrix5x5.a51) + (dMatrix5x5.a52 * dMatrix5x5.a52) + (dMatrix5x5.a53 * dMatrix5x5.a53) + (dMatrix5x5.a54 * dMatrix5x5.a54) + (dMatrix5x5.a55 * dMatrix5x5.a55));
    }

    public static double fastNormF(DMatrix5 dMatrix5) {
        return Math.sqrt((dMatrix5.f2406a1 * dMatrix5.f2406a1) + (dMatrix5.f2407a2 * dMatrix5.f2407a2) + (dMatrix5.f2408a3 * dMatrix5.f2408a3) + (dMatrix5.f2409a4 * dMatrix5.f2409a4) + (dMatrix5.f2410a5 * dMatrix5.f2410a5));
    }

    public static double normF(DMatrix5x5 dMatrix5x5) {
        double dElementMaxAbs = CommonOps_DDF5.elementMaxAbs(dMatrix5x5);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix5x5.a11 / dElementMaxAbs;
        double d2 = dMatrix5x5.a12 / dElementMaxAbs;
        double d3 = dMatrix5x5.a13 / dElementMaxAbs;
        double d4 = dMatrix5x5.a14 / dElementMaxAbs;
        double d5 = dMatrix5x5.a15 / dElementMaxAbs;
        double d6 = dMatrix5x5.a21 / dElementMaxAbs;
        double d7 = dMatrix5x5.a22 / dElementMaxAbs;
        double d8 = dMatrix5x5.a23 / dElementMaxAbs;
        double d9 = dMatrix5x5.a24 / dElementMaxAbs;
        double d10 = dMatrix5x5.a25 / dElementMaxAbs;
        double d11 = dMatrix5x5.a31 / dElementMaxAbs;
        double d12 = dMatrix5x5.a32 / dElementMaxAbs;
        double d13 = dMatrix5x5.a33 / dElementMaxAbs;
        double d14 = dMatrix5x5.a34 / dElementMaxAbs;
        double d15 = dMatrix5x5.a35 / dElementMaxAbs;
        double d16 = dMatrix5x5.a41 / dElementMaxAbs;
        double d17 = dMatrix5x5.a42 / dElementMaxAbs;
        double d18 = dMatrix5x5.a43 / dElementMaxAbs;
        double d19 = dMatrix5x5.a44 / dElementMaxAbs;
        double d20 = dMatrix5x5.a45 / dElementMaxAbs;
        double d21 = dMatrix5x5.a51 / dElementMaxAbs;
        double d22 = dMatrix5x5.a52 / dElementMaxAbs;
        double d23 = dMatrix5x5.a53 / dElementMaxAbs;
        double d24 = dMatrix5x5.a54 / dElementMaxAbs;
        double d25 = dMatrix5x5.a55 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + (d3 * d3) + (d4 * d4) + (d5 * d5) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (d6 * d6) + (d7 * d7) + (d8 * d8) + (d9 * d9) + (d10 * d10) + (d11 * d11) + (d12 * d12) + (d13 * d13) + (d14 * d14) + (d15 * d15) + (d16 * d16) + (d17 * d17) + (d18 * d18) + (d19 * d19) + (d20 * d20) + (d21 * d21) + (d22 * d22) + (d23 * d23) + (d24 * d24) + (d25 * d25));
    }

    public static double normF(DMatrix5 dMatrix5) {
        double dElementMaxAbs = CommonOps_DDF5.elementMaxAbs(dMatrix5);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix5.f2406a1 / dElementMaxAbs;
        double d2 = dMatrix5.f2407a2 / dElementMaxAbs;
        double d3 = dMatrix5.f2408a3 / dElementMaxAbs;
        double d4 = dMatrix5.f2409a4 / dElementMaxAbs;
        double d5 = dMatrix5.f2410a5 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + (d3 * d3) + (d4 * d4) + (d5 * d5));
    }
}
