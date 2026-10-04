package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.DMatrix5;
import org.ejml.data.DMatrix5x5;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_DDF5 {
    public static boolean isIdentical(DMatrix5x5 dMatrix5x5, DMatrix5x5 dMatrix5x52, double d) {
        return UtilEjml.isIdentical(dMatrix5x5.a11, dMatrix5x52.a11, d) && UtilEjml.isIdentical(dMatrix5x5.a12, dMatrix5x52.a12, d) && UtilEjml.isIdentical(dMatrix5x5.a13, dMatrix5x52.a13, d) && UtilEjml.isIdentical(dMatrix5x5.a14, dMatrix5x52.a14, d) && UtilEjml.isIdentical(dMatrix5x5.a15, dMatrix5x52.a15, d) && UtilEjml.isIdentical(dMatrix5x5.a21, dMatrix5x52.a21, d) && UtilEjml.isIdentical(dMatrix5x5.a22, dMatrix5x52.a22, d) && UtilEjml.isIdentical(dMatrix5x5.a23, dMatrix5x52.a23, d) && UtilEjml.isIdentical(dMatrix5x5.a24, dMatrix5x52.a24, d) && UtilEjml.isIdentical(dMatrix5x5.a25, dMatrix5x52.a25, d) && UtilEjml.isIdentical(dMatrix5x5.a31, dMatrix5x52.a31, d) && UtilEjml.isIdentical(dMatrix5x5.a32, dMatrix5x52.a32, d) && UtilEjml.isIdentical(dMatrix5x5.a33, dMatrix5x52.a33, d) && UtilEjml.isIdentical(dMatrix5x5.a34, dMatrix5x52.a34, d) && UtilEjml.isIdentical(dMatrix5x5.a35, dMatrix5x52.a35, d) && UtilEjml.isIdentical(dMatrix5x5.a41, dMatrix5x52.a41, d) && UtilEjml.isIdentical(dMatrix5x5.a42, dMatrix5x52.a42, d) && UtilEjml.isIdentical(dMatrix5x5.a43, dMatrix5x52.a43, d) && UtilEjml.isIdentical(dMatrix5x5.a44, dMatrix5x52.a44, d) && UtilEjml.isIdentical(dMatrix5x5.a45, dMatrix5x52.a45, d) && UtilEjml.isIdentical(dMatrix5x5.a51, dMatrix5x52.a51, d) && UtilEjml.isIdentical(dMatrix5x5.a52, dMatrix5x52.a52, d) && UtilEjml.isIdentical(dMatrix5x5.a53, dMatrix5x52.a53, d) && UtilEjml.isIdentical(dMatrix5x5.a54, dMatrix5x52.a54, d) && UtilEjml.isIdentical(dMatrix5x5.a55, dMatrix5x52.a55, d);
    }

    public static boolean isIdentical(DMatrix5 dMatrix5, DMatrix5 dMatrix52, double d) {
        return UtilEjml.isIdentical(dMatrix5.f2406a1, dMatrix52.f2406a1, d) && UtilEjml.isIdentical(dMatrix5.f2407a2, dMatrix52.f2407a2, d) && UtilEjml.isIdentical(dMatrix5.f2408a3, dMatrix52.f2408a3, d) && UtilEjml.isIdentical(dMatrix5.f2409a4, dMatrix52.f2409a4, d) && UtilEjml.isIdentical(dMatrix5.f2410a5, dMatrix52.f2410a5, d);
    }

    public static boolean hasUncountable(DMatrix5x5 dMatrix5x5) {
        return UtilEjml.isUncountable((((dMatrix5x5.a11 + dMatrix5x5.a12) + dMatrix5x5.a13) + dMatrix5x5.a14) + dMatrix5x5.a15) || UtilEjml.isUncountable((((dMatrix5x5.a21 + dMatrix5x5.a22) + dMatrix5x5.a23) + dMatrix5x5.a24) + dMatrix5x5.a25) || UtilEjml.isUncountable((((dMatrix5x5.a31 + dMatrix5x5.a32) + dMatrix5x5.a33) + dMatrix5x5.a34) + dMatrix5x5.a35) || UtilEjml.isUncountable((((dMatrix5x5.a41 + dMatrix5x5.a42) + dMatrix5x5.a43) + dMatrix5x5.a44) + dMatrix5x5.a45) || UtilEjml.isUncountable((((dMatrix5x5.a51 + dMatrix5x5.a52) + dMatrix5x5.a53) + dMatrix5x5.a54) + dMatrix5x5.a55);
    }

    public static boolean hasUncountable(DMatrix5 dMatrix5) {
        return UtilEjml.isUncountable(dMatrix5.f2406a1) || UtilEjml.isUncountable(dMatrix5.f2407a2) || UtilEjml.isUncountable(dMatrix5.f2408a3) || UtilEjml.isUncountable(dMatrix5.f2409a4) || UtilEjml.isUncountable(dMatrix5.f2410a5);
    }
}
