package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrix5;
import org.ejml.data.FMatrix5x5;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_FDF5 {
    public static boolean isIdentical(FMatrix5x5 fMatrix5x5, FMatrix5x5 fMatrix5x52, float f) {
        return UtilEjml.isIdentical(fMatrix5x5.a11, fMatrix5x52.a11, f) && UtilEjml.isIdentical(fMatrix5x5.a12, fMatrix5x52.a12, f) && UtilEjml.isIdentical(fMatrix5x5.a13, fMatrix5x52.a13, f) && UtilEjml.isIdentical(fMatrix5x5.a14, fMatrix5x52.a14, f) && UtilEjml.isIdentical(fMatrix5x5.a15, fMatrix5x52.a15, f) && UtilEjml.isIdentical(fMatrix5x5.a21, fMatrix5x52.a21, f) && UtilEjml.isIdentical(fMatrix5x5.a22, fMatrix5x52.a22, f) && UtilEjml.isIdentical(fMatrix5x5.a23, fMatrix5x52.a23, f) && UtilEjml.isIdentical(fMatrix5x5.a24, fMatrix5x52.a24, f) && UtilEjml.isIdentical(fMatrix5x5.a25, fMatrix5x52.a25, f) && UtilEjml.isIdentical(fMatrix5x5.a31, fMatrix5x52.a31, f) && UtilEjml.isIdentical(fMatrix5x5.a32, fMatrix5x52.a32, f) && UtilEjml.isIdentical(fMatrix5x5.a33, fMatrix5x52.a33, f) && UtilEjml.isIdentical(fMatrix5x5.a34, fMatrix5x52.a34, f) && UtilEjml.isIdentical(fMatrix5x5.a35, fMatrix5x52.a35, f) && UtilEjml.isIdentical(fMatrix5x5.a41, fMatrix5x52.a41, f) && UtilEjml.isIdentical(fMatrix5x5.a42, fMatrix5x52.a42, f) && UtilEjml.isIdentical(fMatrix5x5.a43, fMatrix5x52.a43, f) && UtilEjml.isIdentical(fMatrix5x5.a44, fMatrix5x52.a44, f) && UtilEjml.isIdentical(fMatrix5x5.a45, fMatrix5x52.a45, f) && UtilEjml.isIdentical(fMatrix5x5.a51, fMatrix5x52.a51, f) && UtilEjml.isIdentical(fMatrix5x5.a52, fMatrix5x52.a52, f) && UtilEjml.isIdentical(fMatrix5x5.a53, fMatrix5x52.a53, f) && UtilEjml.isIdentical(fMatrix5x5.a54, fMatrix5x52.a54, f) && UtilEjml.isIdentical(fMatrix5x5.a55, fMatrix5x52.a55, f);
    }

    public static boolean isIdentical(FMatrix5 fMatrix5, FMatrix5 fMatrix52, float f) {
        return UtilEjml.isIdentical(fMatrix5.f2427a1, fMatrix52.f2427a1, f) && UtilEjml.isIdentical(fMatrix5.f2428a2, fMatrix52.f2428a2, f) && UtilEjml.isIdentical(fMatrix5.f2429a3, fMatrix52.f2429a3, f) && UtilEjml.isIdentical(fMatrix5.f2430a4, fMatrix52.f2430a4, f) && UtilEjml.isIdentical(fMatrix5.f2431a5, fMatrix52.f2431a5, f);
    }

    public static boolean hasUncountable(FMatrix5x5 fMatrix5x5) {
        return UtilEjml.isUncountable((((fMatrix5x5.a11 + fMatrix5x5.a12) + fMatrix5x5.a13) + fMatrix5x5.a14) + fMatrix5x5.a15) || UtilEjml.isUncountable((((fMatrix5x5.a21 + fMatrix5x5.a22) + fMatrix5x5.a23) + fMatrix5x5.a24) + fMatrix5x5.a25) || UtilEjml.isUncountable((((fMatrix5x5.a31 + fMatrix5x5.a32) + fMatrix5x5.a33) + fMatrix5x5.a34) + fMatrix5x5.a35) || UtilEjml.isUncountable((((fMatrix5x5.a41 + fMatrix5x5.a42) + fMatrix5x5.a43) + fMatrix5x5.a44) + fMatrix5x5.a45) || UtilEjml.isUncountable((((fMatrix5x5.a51 + fMatrix5x5.a52) + fMatrix5x5.a53) + fMatrix5x5.a54) + fMatrix5x5.a55);
    }

    public static boolean hasUncountable(FMatrix5 fMatrix5) {
        return UtilEjml.isUncountable(fMatrix5.f2427a1) || UtilEjml.isUncountable(fMatrix5.f2428a2) || UtilEjml.isUncountable(fMatrix5.f2429a3) || UtilEjml.isUncountable(fMatrix5.f2430a4) || UtilEjml.isUncountable(fMatrix5.f2431a5);
    }
}
