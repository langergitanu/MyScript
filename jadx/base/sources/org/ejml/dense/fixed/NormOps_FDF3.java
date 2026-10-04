package org.ejml.dense.fixed;

import org.ejml.data.FMatrix3;
import org.ejml.data.FMatrix3x3;

/* JADX INFO: loaded from: classes9.dex */
public class NormOps_FDF3 {
    public static void normalizeF(FMatrix3x3 fMatrix3x3) {
        CommonOps_FDF3.divide(fMatrix3x3, normF(fMatrix3x3));
    }

    public static void normalizeF(FMatrix3 fMatrix3) {
        CommonOps_FDF3.divide(fMatrix3, normF(fMatrix3));
    }

    public static float fastNormF(FMatrix3x3 fMatrix3x3) {
        return (float) Math.sqrt((fMatrix3x3.a11 * fMatrix3x3.a11) + (fMatrix3x3.a12 * fMatrix3x3.a12) + (fMatrix3x3.a13 * fMatrix3x3.a13) + 0.0f + (fMatrix3x3.a21 * fMatrix3x3.a21) + (fMatrix3x3.a22 * fMatrix3x3.a22) + (fMatrix3x3.a23 * fMatrix3x3.a23) + (fMatrix3x3.a31 * fMatrix3x3.a31) + (fMatrix3x3.a32 * fMatrix3x3.a32) + (fMatrix3x3.a33 * fMatrix3x3.a33));
    }

    public static float fastNormF(FMatrix3 fMatrix3) {
        return (float) Math.sqrt((fMatrix3.f2420a1 * fMatrix3.f2420a1) + (fMatrix3.f2421a2 * fMatrix3.f2421a2) + (fMatrix3.f2422a3 * fMatrix3.f2422a3));
    }

    public static float normF(FMatrix3x3 fMatrix3x3) {
        float fElementMaxAbs = CommonOps_FDF3.elementMaxAbs(fMatrix3x3);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix3x3.a11 / fElementMaxAbs;
        float f2 = fMatrix3x3.a12 / fElementMaxAbs;
        float f3 = fMatrix3x3.a13 / fElementMaxAbs;
        float f4 = fMatrix3x3.a21 / fElementMaxAbs;
        float f5 = fMatrix3x3.a22 / fElementMaxAbs;
        float f6 = fMatrix3x3.a23 / fElementMaxAbs;
        float f7 = fMatrix3x3.a31 / fElementMaxAbs;
        float f8 = fMatrix3x3.a32 / fElementMaxAbs;
        float f9 = fMatrix3x3.a33 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + 0.0f + (f4 * f4) + (f5 * f5) + (f6 * f6) + (f7 * f7) + (f8 * f8) + (f9 * f9)));
    }

    public static float normF(FMatrix3 fMatrix3) {
        float fElementMaxAbs = CommonOps_FDF3.elementMaxAbs(fMatrix3);
        if (fElementMaxAbs == 0.0f) {
            return 0.0f;
        }
        float f = fMatrix3.f2420a1 / fElementMaxAbs;
        float f2 = fMatrix3.f2421a2 / fElementMaxAbs;
        float f3 = fMatrix3.f2422a3 / fElementMaxAbs;
        return fElementMaxAbs * ((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
    }
}
