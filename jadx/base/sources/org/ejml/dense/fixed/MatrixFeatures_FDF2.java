package org.ejml.dense.fixed;

import org.ejml.UtilEjml;
import org.ejml.data.FMatrix2;
import org.ejml.data.FMatrix2x2;

/* JADX INFO: loaded from: classes9.dex */
public class MatrixFeatures_FDF2 {
    public static boolean isIdentical(FMatrix2x2 fMatrix2x2, FMatrix2x2 fMatrix2x22, float f) {
        return UtilEjml.isIdentical(fMatrix2x2.a11, fMatrix2x22.a11, f) && UtilEjml.isIdentical(fMatrix2x2.a12, fMatrix2x22.a12, f) && UtilEjml.isIdentical(fMatrix2x2.a21, fMatrix2x22.a21, f) && UtilEjml.isIdentical(fMatrix2x2.a22, fMatrix2x22.a22, f);
    }

    public static boolean isIdentical(FMatrix2 fMatrix2, FMatrix2 fMatrix22, float f) {
        return UtilEjml.isIdentical(fMatrix2.f2418a1, fMatrix22.f2418a1, f) && UtilEjml.isIdentical(fMatrix2.f2419a2, fMatrix22.f2419a2, f);
    }

    public static boolean hasUncountable(FMatrix2x2 fMatrix2x2) {
        return UtilEjml.isUncountable(fMatrix2x2.a11 + fMatrix2x2.a12) || UtilEjml.isUncountable(fMatrix2x2.a21 + fMatrix2x2.a22);
    }

    public static boolean hasUncountable(FMatrix2 fMatrix2) {
        return UtilEjml.isUncountable(fMatrix2.f2418a1) || UtilEjml.isUncountable(fMatrix2.f2419a2);
    }
}
