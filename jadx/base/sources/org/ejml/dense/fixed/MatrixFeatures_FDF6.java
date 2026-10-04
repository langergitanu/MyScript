package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrix6;
import org.ejml.data.FMatrix6x6;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_FDF6 {
    public static boolean isIdentical(FMatrix6x6 fMatrix6x6, FMatrix6x6 fMatrix6x62, float f) {
        return UtilEjml.isIdentical(fMatrix6x6.a11, fMatrix6x62.a11, f) && UtilEjml.isIdentical(fMatrix6x6.a12, fMatrix6x62.a12, f) && UtilEjml.isIdentical(fMatrix6x6.a13, fMatrix6x62.a13, f) && UtilEjml.isIdentical(fMatrix6x6.a14, fMatrix6x62.a14, f) && UtilEjml.isIdentical(fMatrix6x6.a15, fMatrix6x62.a15, f) && UtilEjml.isIdentical(fMatrix6x6.a16, fMatrix6x62.a16, f) && UtilEjml.isIdentical(fMatrix6x6.a21, fMatrix6x62.a21, f) && UtilEjml.isIdentical(fMatrix6x6.a22, fMatrix6x62.a22, f) && UtilEjml.isIdentical(fMatrix6x6.a23, fMatrix6x62.a23, f) && UtilEjml.isIdentical(fMatrix6x6.a24, fMatrix6x62.a24, f) && UtilEjml.isIdentical(fMatrix6x6.a25, fMatrix6x62.a25, f) && UtilEjml.isIdentical(fMatrix6x6.a26, fMatrix6x62.a26, f) && UtilEjml.isIdentical(fMatrix6x6.a31, fMatrix6x62.a31, f) && UtilEjml.isIdentical(fMatrix6x6.a32, fMatrix6x62.a32, f) && UtilEjml.isIdentical(fMatrix6x6.a33, fMatrix6x62.a33, f) && UtilEjml.isIdentical(fMatrix6x6.a34, fMatrix6x62.a34, f) && UtilEjml.isIdentical(fMatrix6x6.a35, fMatrix6x62.a35, f) && UtilEjml.isIdentical(fMatrix6x6.a36, fMatrix6x62.a36, f) && UtilEjml.isIdentical(fMatrix6x6.a41, fMatrix6x62.a41, f) && UtilEjml.isIdentical(fMatrix6x6.a42, fMatrix6x62.a42, f) && UtilEjml.isIdentical(fMatrix6x6.a43, fMatrix6x62.a43, f) && UtilEjml.isIdentical(fMatrix6x6.a44, fMatrix6x62.a44, f) && UtilEjml.isIdentical(fMatrix6x6.a45, fMatrix6x62.a45, f) && UtilEjml.isIdentical(fMatrix6x6.a46, fMatrix6x62.a46, f) && UtilEjml.isIdentical(fMatrix6x6.a51, fMatrix6x62.a51, f) && UtilEjml.isIdentical(fMatrix6x6.a52, fMatrix6x62.a52, f) && UtilEjml.isIdentical(fMatrix6x6.a53, fMatrix6x62.a53, f) && UtilEjml.isIdentical(fMatrix6x6.a54, fMatrix6x62.a54, f) && UtilEjml.isIdentical(fMatrix6x6.a55, fMatrix6x62.a55, f) && UtilEjml.isIdentical(fMatrix6x6.a56, fMatrix6x62.a56, f) && UtilEjml.isIdentical(fMatrix6x6.a61, fMatrix6x62.a61, f) && UtilEjml.isIdentical(fMatrix6x6.a62, fMatrix6x62.a62, f) && UtilEjml.isIdentical(fMatrix6x6.a63, fMatrix6x62.a63, f) && UtilEjml.isIdentical(fMatrix6x6.a64, fMatrix6x62.a64, f) && UtilEjml.isIdentical(fMatrix6x6.a65, fMatrix6x62.a65, f) && UtilEjml.isIdentical(fMatrix6x6.a66, fMatrix6x62.a66, f);
    }

    public static boolean isIdentical(FMatrix6 fMatrix6, FMatrix6 fMatrix62, float f) {
        return UtilEjml.isIdentical(fMatrix6.f2432a1, fMatrix62.f2432a1, f) && UtilEjml.isIdentical(fMatrix6.f2433a2, fMatrix62.f2433a2, f) && UtilEjml.isIdentical(fMatrix6.f2434a3, fMatrix62.f2434a3, f) && UtilEjml.isIdentical(fMatrix6.f2435a4, fMatrix62.f2435a4, f) && UtilEjml.isIdentical(fMatrix6.f2436a5, fMatrix62.f2436a5, f) && UtilEjml.isIdentical(fMatrix6.f2437a6, fMatrix62.f2437a6, f);
    }

    public static boolean hasUncountable(FMatrix6x6 fMatrix6x6) {
        return UtilEjml.isUncountable(((((fMatrix6x6.a11 + fMatrix6x6.a12) + fMatrix6x6.a13) + fMatrix6x6.a14) + fMatrix6x6.a15) + fMatrix6x6.a16) || UtilEjml.isUncountable(((((fMatrix6x6.a21 + fMatrix6x6.a22) + fMatrix6x6.a23) + fMatrix6x6.a24) + fMatrix6x6.a25) + fMatrix6x6.a26) || UtilEjml.isUncountable(((((fMatrix6x6.a31 + fMatrix6x6.a32) + fMatrix6x6.a33) + fMatrix6x6.a34) + fMatrix6x6.a35) + fMatrix6x6.a36) || UtilEjml.isUncountable(((((fMatrix6x6.a41 + fMatrix6x6.a42) + fMatrix6x6.a43) + fMatrix6x6.a44) + fMatrix6x6.a45) + fMatrix6x6.a46) || UtilEjml.isUncountable(((((fMatrix6x6.a51 + fMatrix6x6.a52) + fMatrix6x6.a53) + fMatrix6x6.a54) + fMatrix6x6.a55) + fMatrix6x6.a56) || UtilEjml.isUncountable(((((fMatrix6x6.a61 + fMatrix6x6.a62) + fMatrix6x6.a63) + fMatrix6x6.a64) + fMatrix6x6.a65) + fMatrix6x6.a66);
    }

    public static boolean hasUncountable(FMatrix6 fMatrix6) {
        return UtilEjml.isUncountable(fMatrix6.f2432a1) || UtilEjml.isUncountable(fMatrix6.f2433a2) || UtilEjml.isUncountable(fMatrix6.f2434a3) || UtilEjml.isUncountable(fMatrix6.f2435a4) || UtilEjml.isUncountable(fMatrix6.f2436a5) || UtilEjml.isUncountable(fMatrix6.f2437a6);
    }
}
