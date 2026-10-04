package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrix3;
import org.ejml.data.FMatrix3x3;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_FDF3 {
    public static boolean isIdentical(FMatrix3x3 fMatrix3x3, FMatrix3x3 fMatrix3x32, float f) {
        return UtilEjml.isIdentical(fMatrix3x3.a11, fMatrix3x32.a11, f) && UtilEjml.isIdentical(fMatrix3x3.a12, fMatrix3x32.a12, f) && UtilEjml.isIdentical(fMatrix3x3.a13, fMatrix3x32.a13, f) && UtilEjml.isIdentical(fMatrix3x3.a21, fMatrix3x32.a21, f) && UtilEjml.isIdentical(fMatrix3x3.a22, fMatrix3x32.a22, f) && UtilEjml.isIdentical(fMatrix3x3.a23, fMatrix3x32.a23, f) && UtilEjml.isIdentical(fMatrix3x3.a31, fMatrix3x32.a31, f) && UtilEjml.isIdentical(fMatrix3x3.a32, fMatrix3x32.a32, f) && UtilEjml.isIdentical(fMatrix3x3.a33, fMatrix3x32.a33, f);
    }

    public static boolean isIdentical(FMatrix3 fMatrix3, FMatrix3 fMatrix32, float f) {
        return UtilEjml.isIdentical(fMatrix3.f2420a1, fMatrix32.f2420a1, f) && UtilEjml.isIdentical(fMatrix3.f2421a2, fMatrix32.f2421a2, f) && UtilEjml.isIdentical(fMatrix3.f2422a3, fMatrix32.f2422a3, f);
    }

    public static boolean hasUncountable(FMatrix3x3 fMatrix3x3) {
        return UtilEjml.isUncountable((fMatrix3x3.a11 + fMatrix3x3.a12) + fMatrix3x3.a13) || UtilEjml.isUncountable((fMatrix3x3.a21 + fMatrix3x3.a22) + fMatrix3x3.a23) || UtilEjml.isUncountable((fMatrix3x3.a31 + fMatrix3x3.a32) + fMatrix3x3.a33);
    }

    public static boolean hasUncountable(FMatrix3 fMatrix3) {
        return UtilEjml.isUncountable(fMatrix3.f2420a1) || UtilEjml.isUncountable(fMatrix3.f2421a2) || UtilEjml.isUncountable(fMatrix3.f2422a3);
    }
}
