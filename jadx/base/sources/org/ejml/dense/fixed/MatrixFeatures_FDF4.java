package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrix4;
import org.ejml.data.FMatrix4x4;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_FDF4 {
    public static boolean isIdentical(FMatrix4x4 fMatrix4x4, FMatrix4x4 fMatrix4x42, float f) {
        return UtilEjml.isIdentical(fMatrix4x4.a11, fMatrix4x42.a11, f) && UtilEjml.isIdentical(fMatrix4x4.a12, fMatrix4x42.a12, f) && UtilEjml.isIdentical(fMatrix4x4.a13, fMatrix4x42.a13, f) && UtilEjml.isIdentical(fMatrix4x4.a14, fMatrix4x42.a14, f) && UtilEjml.isIdentical(fMatrix4x4.a21, fMatrix4x42.a21, f) && UtilEjml.isIdentical(fMatrix4x4.a22, fMatrix4x42.a22, f) && UtilEjml.isIdentical(fMatrix4x4.a23, fMatrix4x42.a23, f) && UtilEjml.isIdentical(fMatrix4x4.a24, fMatrix4x42.a24, f) && UtilEjml.isIdentical(fMatrix4x4.a31, fMatrix4x42.a31, f) && UtilEjml.isIdentical(fMatrix4x4.a32, fMatrix4x42.a32, f) && UtilEjml.isIdentical(fMatrix4x4.a33, fMatrix4x42.a33, f) && UtilEjml.isIdentical(fMatrix4x4.a34, fMatrix4x42.a34, f) && UtilEjml.isIdentical(fMatrix4x4.a41, fMatrix4x42.a41, f) && UtilEjml.isIdentical(fMatrix4x4.a42, fMatrix4x42.a42, f) && UtilEjml.isIdentical(fMatrix4x4.a43, fMatrix4x42.a43, f) && UtilEjml.isIdentical(fMatrix4x4.a44, fMatrix4x42.a44, f);
    }

    public static boolean isIdentical(FMatrix4 fMatrix4, FMatrix4 fMatrix42, float f) {
        return UtilEjml.isIdentical(fMatrix4.f2423a1, fMatrix42.f2423a1, f) && UtilEjml.isIdentical(fMatrix4.f2424a2, fMatrix42.f2424a2, f) && UtilEjml.isIdentical(fMatrix4.f2425a3, fMatrix42.f2425a3, f) && UtilEjml.isIdentical(fMatrix4.f2426a4, fMatrix42.f2426a4, f);
    }

    public static boolean hasUncountable(FMatrix4x4 fMatrix4x4) {
        return UtilEjml.isUncountable(((fMatrix4x4.a11 + fMatrix4x4.a12) + fMatrix4x4.a13) + fMatrix4x4.a14) || UtilEjml.isUncountable(((fMatrix4x4.a21 + fMatrix4x4.a22) + fMatrix4x4.a23) + fMatrix4x4.a24) || UtilEjml.isUncountable(((fMatrix4x4.a31 + fMatrix4x4.a32) + fMatrix4x4.a33) + fMatrix4x4.a34) || UtilEjml.isUncountable(((fMatrix4x4.a41 + fMatrix4x4.a42) + fMatrix4x4.a43) + fMatrix4x4.a44);
    }

    public static boolean hasUncountable(FMatrix4 fMatrix4) {
        return UtilEjml.isUncountable(fMatrix4.f2423a1) || UtilEjml.isUncountable(fMatrix4.f2424a2) || UtilEjml.isUncountable(fMatrix4.f2425a3) || UtilEjml.isUncountable(fMatrix4.f2426a4);
    }
}
