package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.DMatrix3;
import org.ejml.data.DMatrix3x3;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_DDF3 {
    public static boolean isIdentical(DMatrix3x3 dMatrix3x3, DMatrix3x3 dMatrix3x32, double d) {
        return UtilEjml.isIdentical(dMatrix3x3.a11, dMatrix3x32.a11, d) && UtilEjml.isIdentical(dMatrix3x3.a12, dMatrix3x32.a12, d) && UtilEjml.isIdentical(dMatrix3x3.a13, dMatrix3x32.a13, d) && UtilEjml.isIdentical(dMatrix3x3.a21, dMatrix3x32.a21, d) && UtilEjml.isIdentical(dMatrix3x3.a22, dMatrix3x32.a22, d) && UtilEjml.isIdentical(dMatrix3x3.a23, dMatrix3x32.a23, d) && UtilEjml.isIdentical(dMatrix3x3.a31, dMatrix3x32.a31, d) && UtilEjml.isIdentical(dMatrix3x3.a32, dMatrix3x32.a32, d) && UtilEjml.isIdentical(dMatrix3x3.a33, dMatrix3x32.a33, d);
    }

    public static boolean isIdentical(DMatrix3 dMatrix3, DMatrix3 dMatrix32, double d) {
        return UtilEjml.isIdentical(dMatrix3.f2399a1, dMatrix32.f2399a1, d) && UtilEjml.isIdentical(dMatrix3.f2400a2, dMatrix32.f2400a2, d) && UtilEjml.isIdentical(dMatrix3.f2401a3, dMatrix32.f2401a3, d);
    }

    public static boolean hasUncountable(DMatrix3x3 dMatrix3x3) {
        return UtilEjml.isUncountable((dMatrix3x3.a11 + dMatrix3x3.a12) + dMatrix3x3.a13) || UtilEjml.isUncountable((dMatrix3x3.a21 + dMatrix3x3.a22) + dMatrix3x3.a23) || UtilEjml.isUncountable((dMatrix3x3.a31 + dMatrix3x3.a32) + dMatrix3x3.a33);
    }

    public static boolean hasUncountable(DMatrix3 dMatrix3) {
        return UtilEjml.isUncountable(dMatrix3.f2399a1) || UtilEjml.isUncountable(dMatrix3.f2400a2) || UtilEjml.isUncountable(dMatrix3.f2401a3);
    }
}
