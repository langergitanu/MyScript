package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.DMatrix6;
import org.ejml.data.DMatrix6x6;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_DDF6 {
    public static boolean isIdentical(DMatrix6x6 dMatrix6x6, DMatrix6x6 dMatrix6x62, double d) {
        return UtilEjml.isIdentical(dMatrix6x6.a11, dMatrix6x62.a11, d) && UtilEjml.isIdentical(dMatrix6x6.a12, dMatrix6x62.a12, d) && UtilEjml.isIdentical(dMatrix6x6.a13, dMatrix6x62.a13, d) && UtilEjml.isIdentical(dMatrix6x6.a14, dMatrix6x62.a14, d) && UtilEjml.isIdentical(dMatrix6x6.a15, dMatrix6x62.a15, d) && UtilEjml.isIdentical(dMatrix6x6.a16, dMatrix6x62.a16, d) && UtilEjml.isIdentical(dMatrix6x6.a21, dMatrix6x62.a21, d) && UtilEjml.isIdentical(dMatrix6x6.a22, dMatrix6x62.a22, d) && UtilEjml.isIdentical(dMatrix6x6.a23, dMatrix6x62.a23, d) && UtilEjml.isIdentical(dMatrix6x6.a24, dMatrix6x62.a24, d) && UtilEjml.isIdentical(dMatrix6x6.a25, dMatrix6x62.a25, d) && UtilEjml.isIdentical(dMatrix6x6.a26, dMatrix6x62.a26, d) && UtilEjml.isIdentical(dMatrix6x6.a31, dMatrix6x62.a31, d) && UtilEjml.isIdentical(dMatrix6x6.a32, dMatrix6x62.a32, d) && UtilEjml.isIdentical(dMatrix6x6.a33, dMatrix6x62.a33, d) && UtilEjml.isIdentical(dMatrix6x6.a34, dMatrix6x62.a34, d) && UtilEjml.isIdentical(dMatrix6x6.a35, dMatrix6x62.a35, d) && UtilEjml.isIdentical(dMatrix6x6.a36, dMatrix6x62.a36, d) && UtilEjml.isIdentical(dMatrix6x6.a41, dMatrix6x62.a41, d) && UtilEjml.isIdentical(dMatrix6x6.a42, dMatrix6x62.a42, d) && UtilEjml.isIdentical(dMatrix6x6.a43, dMatrix6x62.a43, d) && UtilEjml.isIdentical(dMatrix6x6.a44, dMatrix6x62.a44, d) && UtilEjml.isIdentical(dMatrix6x6.a45, dMatrix6x62.a45, d) && UtilEjml.isIdentical(dMatrix6x6.a46, dMatrix6x62.a46, d) && UtilEjml.isIdentical(dMatrix6x6.a51, dMatrix6x62.a51, d) && UtilEjml.isIdentical(dMatrix6x6.a52, dMatrix6x62.a52, d) && UtilEjml.isIdentical(dMatrix6x6.a53, dMatrix6x62.a53, d) && UtilEjml.isIdentical(dMatrix6x6.a54, dMatrix6x62.a54, d) && UtilEjml.isIdentical(dMatrix6x6.a55, dMatrix6x62.a55, d) && UtilEjml.isIdentical(dMatrix6x6.a56, dMatrix6x62.a56, d) && UtilEjml.isIdentical(dMatrix6x6.a61, dMatrix6x62.a61, d) && UtilEjml.isIdentical(dMatrix6x6.a62, dMatrix6x62.a62, d) && UtilEjml.isIdentical(dMatrix6x6.a63, dMatrix6x62.a63, d) && UtilEjml.isIdentical(dMatrix6x6.a64, dMatrix6x62.a64, d) && UtilEjml.isIdentical(dMatrix6x6.a65, dMatrix6x62.a65, d) && UtilEjml.isIdentical(dMatrix6x6.a66, dMatrix6x62.a66, d);
    }

    public static boolean isIdentical(DMatrix6 dMatrix6, DMatrix6 dMatrix62, double d) {
        return UtilEjml.isIdentical(dMatrix6.f2411a1, dMatrix62.f2411a1, d) && UtilEjml.isIdentical(dMatrix6.f2412a2, dMatrix62.f2412a2, d) && UtilEjml.isIdentical(dMatrix6.f2413a3, dMatrix62.f2413a3, d) && UtilEjml.isIdentical(dMatrix6.f2414a4, dMatrix62.f2414a4, d) && UtilEjml.isIdentical(dMatrix6.f2415a5, dMatrix62.f2415a5, d) && UtilEjml.isIdentical(dMatrix6.f2416a6, dMatrix62.f2416a6, d);
    }

    public static boolean hasUncountable(DMatrix6x6 dMatrix6x6) {
        return UtilEjml.isUncountable(((((dMatrix6x6.a11 + dMatrix6x6.a12) + dMatrix6x6.a13) + dMatrix6x6.a14) + dMatrix6x6.a15) + dMatrix6x6.a16) || UtilEjml.isUncountable(((((dMatrix6x6.a21 + dMatrix6x6.a22) + dMatrix6x6.a23) + dMatrix6x6.a24) + dMatrix6x6.a25) + dMatrix6x6.a26) || UtilEjml.isUncountable(((((dMatrix6x6.a31 + dMatrix6x6.a32) + dMatrix6x6.a33) + dMatrix6x6.a34) + dMatrix6x6.a35) + dMatrix6x6.a36) || UtilEjml.isUncountable(((((dMatrix6x6.a41 + dMatrix6x6.a42) + dMatrix6x6.a43) + dMatrix6x6.a44) + dMatrix6x6.a45) + dMatrix6x6.a46) || UtilEjml.isUncountable(((((dMatrix6x6.a51 + dMatrix6x6.a52) + dMatrix6x6.a53) + dMatrix6x6.a54) + dMatrix6x6.a55) + dMatrix6x6.a56) || UtilEjml.isUncountable(((((dMatrix6x6.a61 + dMatrix6x6.a62) + dMatrix6x6.a63) + dMatrix6x6.a64) + dMatrix6x6.a65) + dMatrix6x6.a66);
    }

    public static boolean hasUncountable(DMatrix6 dMatrix6) {
        return UtilEjml.isUncountable(dMatrix6.f2411a1) || UtilEjml.isUncountable(dMatrix6.f2412a2) || UtilEjml.isUncountable(dMatrix6.f2413a3) || UtilEjml.isUncountable(dMatrix6.f2414a4) || UtilEjml.isUncountable(dMatrix6.f2415a5) || UtilEjml.isUncountable(dMatrix6.f2416a6);
    }
}
