package org.ejml.dense.fixed;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.ejml.data.DMatrix6;
import org.ejml.data.DMatrix6x6;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_DDF6 {
    public static void normalizeF(DMatrix6x6 dMatrix6x6) {
        CommonOps_DDF6.divide(dMatrix6x6, normF(dMatrix6x6));
    }

    public static void normalizeF(DMatrix6 dMatrix6) {
        CommonOps_DDF6.divide(dMatrix6, normF(dMatrix6));
    }

    public static double fastNormF(DMatrix6x6 dMatrix6x6) {
        return Math.sqrt((dMatrix6x6.a11 * dMatrix6x6.a11) + (dMatrix6x6.a12 * dMatrix6x6.a12) + (dMatrix6x6.a13 * dMatrix6x6.a13) + (dMatrix6x6.a14 * dMatrix6x6.a14) + (dMatrix6x6.a15 * dMatrix6x6.a15) + (dMatrix6x6.a16 * dMatrix6x6.a16) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (dMatrix6x6.a21 * dMatrix6x6.a21) + (dMatrix6x6.a22 * dMatrix6x6.a22) + (dMatrix6x6.a23 * dMatrix6x6.a23) + (dMatrix6x6.a24 * dMatrix6x6.a24) + (dMatrix6x6.a25 * dMatrix6x6.a25) + (dMatrix6x6.a26 * dMatrix6x6.a26) + (dMatrix6x6.a31 * dMatrix6x6.a31) + (dMatrix6x6.a32 * dMatrix6x6.a32) + (dMatrix6x6.a33 * dMatrix6x6.a33) + (dMatrix6x6.a34 * dMatrix6x6.a34) + (dMatrix6x6.a35 * dMatrix6x6.a35) + (dMatrix6x6.a36 * dMatrix6x6.a36) + (dMatrix6x6.a41 * dMatrix6x6.a41) + (dMatrix6x6.a42 * dMatrix6x6.a42) + (dMatrix6x6.a43 * dMatrix6x6.a43) + (dMatrix6x6.a44 * dMatrix6x6.a44) + (dMatrix6x6.a45 * dMatrix6x6.a45) + (dMatrix6x6.a46 * dMatrix6x6.a46) + (dMatrix6x6.a51 * dMatrix6x6.a51) + (dMatrix6x6.a52 * dMatrix6x6.a52) + (dMatrix6x6.a53 * dMatrix6x6.a53) + (dMatrix6x6.a54 * dMatrix6x6.a54) + (dMatrix6x6.a55 * dMatrix6x6.a55) + (dMatrix6x6.a56 * dMatrix6x6.a56) + (dMatrix6x6.a61 * dMatrix6x6.a61) + (dMatrix6x6.a62 * dMatrix6x6.a62) + (dMatrix6x6.a63 * dMatrix6x6.a63) + (dMatrix6x6.a64 * dMatrix6x6.a64) + (dMatrix6x6.a65 * dMatrix6x6.a65) + (dMatrix6x6.a66 * dMatrix6x6.a66));
    }

    public static double fastNormF(DMatrix6 dMatrix6) {
        return Math.sqrt((dMatrix6.f2411a1 * dMatrix6.f2411a1) + (dMatrix6.f2412a2 * dMatrix6.f2412a2) + (dMatrix6.f2413a3 * dMatrix6.f2413a3) + (dMatrix6.f2414a4 * dMatrix6.f2414a4) + (dMatrix6.f2415a5 * dMatrix6.f2415a5) + (dMatrix6.f2416a6 * dMatrix6.f2416a6));
    }

    public static double normF(DMatrix6x6 dMatrix6x6) {
        double dElementMaxAbs = CommonOps_DDF6.elementMaxAbs(dMatrix6x6);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix6x6.a11 / dElementMaxAbs;
        double d2 = dMatrix6x6.a12 / dElementMaxAbs;
        double d3 = dMatrix6x6.a13 / dElementMaxAbs;
        double d4 = dMatrix6x6.a14 / dElementMaxAbs;
        double d5 = dMatrix6x6.a15 / dElementMaxAbs;
        double d6 = dMatrix6x6.a16 / dElementMaxAbs;
        double d7 = dMatrix6x6.a21 / dElementMaxAbs;
        double d8 = dMatrix6x6.a22 / dElementMaxAbs;
        double d9 = dMatrix6x6.a23 / dElementMaxAbs;
        double d10 = dMatrix6x6.a24 / dElementMaxAbs;
        double d11 = dMatrix6x6.a25 / dElementMaxAbs;
        double d12 = dMatrix6x6.a26 / dElementMaxAbs;
        double d13 = dMatrix6x6.a31 / dElementMaxAbs;
        double d14 = dMatrix6x6.a32 / dElementMaxAbs;
        double d15 = dMatrix6x6.a33 / dElementMaxAbs;
        double d16 = dMatrix6x6.a34 / dElementMaxAbs;
        double d17 = dMatrix6x6.a35 / dElementMaxAbs;
        double d18 = dMatrix6x6.a36 / dElementMaxAbs;
        double d19 = dMatrix6x6.a41 / dElementMaxAbs;
        double d20 = dMatrix6x6.a42 / dElementMaxAbs;
        double d21 = dMatrix6x6.a43 / dElementMaxAbs;
        double d22 = dMatrix6x6.a44 / dElementMaxAbs;
        double d23 = dMatrix6x6.a45 / dElementMaxAbs;
        double d24 = dMatrix6x6.a46 / dElementMaxAbs;
        double d25 = dMatrix6x6.a51 / dElementMaxAbs;
        double d26 = dMatrix6x6.a52 / dElementMaxAbs;
        double d27 = dMatrix6x6.a53 / dElementMaxAbs;
        double d28 = dMatrix6x6.a54 / dElementMaxAbs;
        double d29 = dMatrix6x6.a55 / dElementMaxAbs;
        double d30 = dMatrix6x6.a56 / dElementMaxAbs;
        double d31 = dMatrix6x6.a61 / dElementMaxAbs;
        double d32 = dMatrix6x6.a62 / dElementMaxAbs;
        double d33 = dMatrix6x6.a63 / dElementMaxAbs;
        double d34 = dMatrix6x6.a64 / dElementMaxAbs;
        double d35 = dMatrix6x6.a65 / dElementMaxAbs;
        double d36 = dMatrix6x6.a66 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + (d3 * d3) + (d4 * d4) + (d5 * d5) + (d6 * d6) + FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE + (d7 * d7) + (d8 * d8) + (d9 * d9) + (d10 * d10) + (d11 * d11) + (d12 * d12) + (d13 * d13) + (d14 * d14) + (d15 * d15) + (d16 * d16) + (d17 * d17) + (d18 * d18) + (d19 * d19) + (d20 * d20) + (d21 * d21) + (d22 * d22) + (d23 * d23) + (d24 * d24) + (d25 * d25) + (d26 * d26) + (d27 * d27) + (d28 * d28) + (d29 * d29) + (d30 * d30) + (d31 * d31) + (d32 * d32) + (d33 * d33) + (d34 * d34) + (d35 * d35) + (d36 * d36));
    }

    public static double normF(DMatrix6 dMatrix6) {
        double dElementMaxAbs = CommonOps_DDF6.elementMaxAbs(dMatrix6);
        if (dElementMaxAbs == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        double d = dMatrix6.f2411a1 / dElementMaxAbs;
        double d2 = dMatrix6.f2412a2 / dElementMaxAbs;
        double d3 = dMatrix6.f2413a3 / dElementMaxAbs;
        double d4 = dMatrix6.f2414a4 / dElementMaxAbs;
        double d5 = dMatrix6.f2415a5 / dElementMaxAbs;
        double d6 = dMatrix6.f2416a6 / dElementMaxAbs;
        return dElementMaxAbs * Math.sqrt((d * d) + (d2 * d2) + (d3 * d3) + (d4 * d4) + (d5 * d5) + (d6 * d6));
    }
}
