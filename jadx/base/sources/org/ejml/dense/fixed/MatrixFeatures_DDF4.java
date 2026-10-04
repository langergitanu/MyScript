package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.DMatrix4;
import org.ejml.data.DMatrix4x4;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_DDF4 {
    public static boolean isIdentical(DMatrix4x4 dMatrix4x4, DMatrix4x4 dMatrix4x42, double d) {
        return UtilEjml.isIdentical(dMatrix4x4.a11, dMatrix4x42.a11, d) && UtilEjml.isIdentical(dMatrix4x4.a12, dMatrix4x42.a12, d) && UtilEjml.isIdentical(dMatrix4x4.a13, dMatrix4x42.a13, d) && UtilEjml.isIdentical(dMatrix4x4.a14, dMatrix4x42.a14, d) && UtilEjml.isIdentical(dMatrix4x4.a21, dMatrix4x42.a21, d) && UtilEjml.isIdentical(dMatrix4x4.a22, dMatrix4x42.a22, d) && UtilEjml.isIdentical(dMatrix4x4.a23, dMatrix4x42.a23, d) && UtilEjml.isIdentical(dMatrix4x4.a24, dMatrix4x42.a24, d) && UtilEjml.isIdentical(dMatrix4x4.a31, dMatrix4x42.a31, d) && UtilEjml.isIdentical(dMatrix4x4.a32, dMatrix4x42.a32, d) && UtilEjml.isIdentical(dMatrix4x4.a33, dMatrix4x42.a33, d) && UtilEjml.isIdentical(dMatrix4x4.a34, dMatrix4x42.a34, d) && UtilEjml.isIdentical(dMatrix4x4.a41, dMatrix4x42.a41, d) && UtilEjml.isIdentical(dMatrix4x4.a42, dMatrix4x42.a42, d) && UtilEjml.isIdentical(dMatrix4x4.a43, dMatrix4x42.a43, d) && UtilEjml.isIdentical(dMatrix4x4.a44, dMatrix4x42.a44, d);
    }

    public static boolean isIdentical(DMatrix4 dMatrix4, DMatrix4 dMatrix42, double d) {
        return UtilEjml.isIdentical(dMatrix4.f2402a1, dMatrix42.f2402a1, d) && UtilEjml.isIdentical(dMatrix4.f2403a2, dMatrix42.f2403a2, d) && UtilEjml.isIdentical(dMatrix4.f2404a3, dMatrix42.f2404a3, d) && UtilEjml.isIdentical(dMatrix4.f2405a4, dMatrix42.f2405a4, d);
    }

    public static boolean hasUncountable(DMatrix4x4 dMatrix4x4) {
        return UtilEjml.isUncountable(((dMatrix4x4.a11 + dMatrix4x4.a12) + dMatrix4x4.a13) + dMatrix4x4.a14) || UtilEjml.isUncountable(((dMatrix4x4.a21 + dMatrix4x4.a22) + dMatrix4x4.a23) + dMatrix4x4.a24) || UtilEjml.isUncountable(((dMatrix4x4.a31 + dMatrix4x4.a32) + dMatrix4x4.a33) + dMatrix4x4.a34) || UtilEjml.isUncountable(((dMatrix4x4.a41 + dMatrix4x4.a42) + dMatrix4x4.a43) + dMatrix4x4.a44);
    }

    public static boolean hasUncountable(DMatrix4 dMatrix4) {
        return UtilEjml.isUncountable(dMatrix4.f2402a1) || UtilEjml.isUncountable(dMatrix4.f2403a2) || UtilEjml.isUncountable(dMatrix4.f2404a3) || UtilEjml.isUncountable(dMatrix4.f2405a4);
    }
}
