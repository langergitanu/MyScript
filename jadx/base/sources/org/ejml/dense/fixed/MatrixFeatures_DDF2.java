package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.DMatrix2;
import org.ejml.data.DMatrix2x2;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_DDF2 {
    public static boolean isIdentical(DMatrix2x2 dMatrix2x2, DMatrix2x2 dMatrix2x22, double d) {
        return UtilEjml.isIdentical(dMatrix2x2.a11, dMatrix2x22.a11, d) && UtilEjml.isIdentical(dMatrix2x2.a12, dMatrix2x22.a12, d) && UtilEjml.isIdentical(dMatrix2x2.a21, dMatrix2x22.a21, d) && UtilEjml.isIdentical(dMatrix2x2.a22, dMatrix2x22.a22, d);
    }

    public static boolean isIdentical(DMatrix2 dMatrix2, DMatrix2 dMatrix22, double d) {
        return UtilEjml.isIdentical(dMatrix2.f2397a1, dMatrix22.f2397a1, d) && UtilEjml.isIdentical(dMatrix2.f2398a2, dMatrix22.f2398a2, d);
    }

    public static boolean hasUncountable(DMatrix2x2 dMatrix2x2) {
        return UtilEjml.isUncountable(dMatrix2x2.a11 + dMatrix2x2.a12) || UtilEjml.isUncountable(dMatrix2x2.a21 + dMatrix2x2.a22);
    }

    public static boolean hasUncountable(DMatrix2 dMatrix2) {
        return UtilEjml.isUncountable(dMatrix2.f2397a1) || UtilEjml.isUncountable(dMatrix2.f2398a2);
    }
}
