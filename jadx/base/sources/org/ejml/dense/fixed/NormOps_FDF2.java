package org.ejml.dense.fixed;

import org.ejml.data.FMatrix2;
import org.ejml.data.FMatrix2x2;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_FDF2 {
    public static void normalizeF(FMatrix2x2 fMatrix2x2) {
        CommonOps_FDF2.divide(fMatrix2x2, normF(fMatrix2x2));
    }

    public static void normalizeF(FMatrix2 fMatrix2) {
        CommonOps_FDF2.divide(fMatrix2, normF(fMatrix2));
    }

    public static float fastNormF(FMatrix2x2 fMatrix2x2) {
        return (float) Math.sqrt((fMatrix2x2.a11 * fMatrix2x2.a11) + (fMatrix2x2.a12 * fMatrix2x2.a12) + 0.0f + (fMatrix2x2.a21 * fMatrix2x2.a21) + (fMatrix2x2.a22 * fMatrix2x2.a22));
    }

    public static float fastNormF(FMatrix2 fMatrix2) {
        return (float) Math.sqrt((fMatrix2.f2418a1 * fMatrix2.f2418a1) + (fMatrix2.f2419a2 * fMatrix2.f2419a2));
    }

    public static float normF(FMatrix2x2 fMatrix2x2) {
        float fElementMaxAbs = CommonOps_FDF2.elementMaxAbs(fMatrix2x2);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix2x2.a11 / fElementMaxAbs;
        float f2 = fMatrix2x2.a12 / fElementMaxAbs;
        float f3 = fMatrix2x2.a21 / fElementMaxAbs;
        float f4 = fMatrix2x2.a22 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + 0.0f + (f3 * f3) + (f4 * f4)));
    }

    public static float normF(FMatrix2 fMatrix2) {
        float fElementMaxAbs = CommonOps_FDF2.elementMaxAbs(fMatrix2);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix2.f2418a1 / fElementMaxAbs;
        float f2 = fMatrix2.f2419a2 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2)));
    }
}
